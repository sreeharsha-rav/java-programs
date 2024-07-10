package org.app.mealmap.recipes.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * This class represents a recipe data transfer object.
 * id: the unique identifier of the recipe.
 * name: the name of the recipe.
 * description: a short description of the recipe.
 * imageUrl: the URL of the image of the recipe.
 * ingredients: an array of ingredients required for the recipe.
 * instructions: the cooking instructions for the recipe.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDto {
    private String id;

    @Schema(description = "The name of the recipe")
    @NotBlank
    private String name;

    @Schema(description = "A short description of the recipe")
    @NotBlank
    private String description;

    @Schema(description = "The URL of the image of the recipe")
    @NotBlank
    private String imageUrl;

    @Schema(description = "An array of ingredients required for the recipe")
    @NotBlank
    private String ingredients;

    @Schema(description = "The cooking instructions for the recipe")
    @NotBlank
    private String instructions;
}
