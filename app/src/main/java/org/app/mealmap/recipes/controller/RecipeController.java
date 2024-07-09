package org.app.mealmap.recipes.controller;

import jakarta.validation.Valid;
import org.app.mealmap.recipes.model.Recipe;
import org.app.mealmap.recipes.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/*
 * This class represents a controller for the recipe entity.
 * It handles HTTP requests related to recipes.
 * getAllRecipes: returns all recipes.
 * getRecipeById: returns a recipe by its id.
 * createRecipe: creates a new recipe.
 * updateRecipe: updates a recipe by its id.
 * deleteRecipe: deletes a recipe by its id.
 */
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ResponseEntity<Recipe>> getRecipeById(@PathVariable Long id) {
        Mono<Recipe> recipe = recipeService.getRecipeById(id);
        return recipe.map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Recipe> createRecipe(@Valid @RequestBody Recipe recipe) {
        return recipeService.createRecipe(recipe)
                .onErrorResume(error -> {
                    return Mono.error(new Exception("Error occurred while creating recipe"));
                });
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ResponseEntity<Recipe>> updateRecipe(@PathVariable Long id, @Valid @RequestBody Recipe recipe) {
        Mono<Recipe> updatedRecipe = recipeService.updateRecipe(id, recipe);
        return updatedRecipe.map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<ResponseEntity<Void>> deleteRecipe(@PathVariable Long id) {
        return recipeService.deleteRecipe(id)
                .then(Mono.just(ResponseEntity.noContent().<Void>build()))
                .defaultIfEmpty(ResponseEntity.notFound().build())
                .onErrorResume(error -> {
                    return Mono.error(new Exception("Error occurred while deleting recipe"));
                });
    }

}
