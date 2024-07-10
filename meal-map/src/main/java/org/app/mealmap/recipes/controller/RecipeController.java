package org.app.mealmap.recipes.controller;

import jakarta.validation.Valid;
import org.app.mealmap.recipes.dto.RecipeDto;
import org.app.mealmap.recipes.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public Flux<RecipeDto> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<RecipeDto> getRecipeById(@PathVariable String id) {
        return recipeService.getRecipeById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<RecipeDto> createRecipe(@Valid @RequestBody Mono<RecipeDto> recipeDtoMono) {
        return recipeService.createRecipe(recipeDtoMono);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<RecipeDto> updateRecipe(@PathVariable String id, @Valid @RequestBody Mono<RecipeDto> recipeDtoMono) {
        return recipeService.updateRecipe(id, recipeDtoMono);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteRecipe(@PathVariable String id) {
        return recipeService.deleteRecipe(id);
    }

}
