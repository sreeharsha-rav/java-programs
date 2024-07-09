package org.mealmap.app.recipes.controller;

import org.mealmap.app.recipes.model.Recipe;
import org.mealmap.app.recipes.service.RecipeService;
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
        return recipeService.getRecipeById(id)
                .map(recipe -> ResponseEntity.ok(recipe))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Recipe> createRecipe(@RequestBody Recipe recipe) {
        return recipeService.createRecipe(recipe);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ResponseEntity<Recipe>> updateRecipe(@PathVariable Long id, @RequestBody Recipe recipe) {
        return recipeService.updateRecipe(id, recipe)
                .map(updatedRecipe -> ResponseEntity.ok(updatedRecipe))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<ResponseEntity<Void>> deleteRecipe(@PathVariable Long id) {
        return recipeService.deleteRecipe(id)
                .then(Mono.just(ResponseEntity.noContent().<Void>build()))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}
