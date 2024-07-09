package org.app.mealmap.recipes.service;

import lombok.extern.slf4j.Slf4j;
import org.app.mealmap.recipes.model.Recipe;
import org.app.mealmap.recipes.repository.RecipeRepository;
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
@Slf4j
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public Flux<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Mono<Recipe> getRecipeById(Long id) {
        return recipeRepository.findById(id)
                .switchIfEmpty(Mono.error(new Exception("Recipe not found with id: " + id)))
                .onErrorResume(error -> {
                    log.error("Error occurred: ", id, error);
                    return Mono.empty();
                });
    }

    public Mono<Recipe> createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public Mono<Recipe> updateRecipe(Long id, Recipe recipe) {
        return recipeRepository.findById(id)
                .flatMap(existingRecipe -> {
                    existingRecipe.setName(recipe.getName());
                    existingRecipe.setDescription(recipe.getDescription());
                    existingRecipe.setImageUrl(recipe.getImageUrl());
                    return recipeRepository.save(existingRecipe);
                })
                .onErrorResume(error -> {
                    log.error("Error occurred while updating recipe", error);
                    return Mono.empty();
                });
    }

    public Mono<Void> deleteRecipe(Long id) {
        return recipeRepository.deleteById(id);
    }

}