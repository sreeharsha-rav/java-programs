package org.app.mealmap.recipes.service;

import org.app.mealmap.recipes.dto.RecipeDto;
import org.app.mealmap.recipes.repository.RecipeRepository;
import org.app.mealmap.recipes.utils.RecipeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/*
 * This class provides the business logic for managing recipes.
 * getAllRecipes: retrieves all recipes.
 * getRecipeById: retrieves a recipe by its unique identifier.
 * createRecipe: creates a new recipe.
 * updateRecipe: updates an existing recipe.
 * deleteRecipe: deletes a recipe by its unique identifier.
 */
@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public Flux<RecipeDto> getAllRecipes() {
        return recipeRepository.findAll()
                .map(RecipeMapper::entityToDto);
    }

    public Mono<RecipeDto> getRecipeById(String id) {
        return recipeRepository.findById(id)
                .map(RecipeMapper::entityToDto)
                .switchIfEmpty(Mono.error(new RuntimeException("Recipe not found")));

    }

    public Mono<RecipeDto> createRecipe(Mono<RecipeDto> recipeDtoMono) {
        return recipeDtoMono.map(RecipeMapper::dtoToEntity)
                .flatMap(recipeRepository::insert)
                .map(RecipeMapper::entityToDto)
                .switchIfEmpty(Mono.error(new RuntimeException("Recipe not created")));
    }

    public Mono<RecipeDto> updateRecipe(String id, Mono<RecipeDto> recipeDtoMono) {
        return recipeRepository.findById(id)
                .flatMap(recipe -> recipeDtoMono.map(RecipeMapper::dtoToEntity)
                        .doOnNext(e -> e.setId(id))
                        .flatMap(recipeRepository::save))
                .map(RecipeMapper::entityToDto)
                .switchIfEmpty(Mono.error(new RuntimeException("Recipe not updated")));
    }

    public Mono<Void> deleteRecipe(String id) {
        return recipeRepository.deleteById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("Recipe not deleted")));
    }

}
