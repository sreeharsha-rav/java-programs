package org.app.mealmap.recipes.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*
 * This class represents a recipe entity.
 * id: the unique identifier of the recipe.
 * name: the name of the recipe.
 * description: a short description of the recipe.
 * imageUrl: the URL of the image of the recipe.
 * ingredients: an array of ingredients required for the recipe.
 * instructions: the cooking instructions for the recipe.
 */
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("recipes")
public class Recipe {

    @Id
    private String id;
    private String name;
    private String description;
    private String imageUrl;
    private String ingredients;   // FUTURE: Change to array of Ingredient objects
    private String instructions;    // FUTURE: Change to array of strings

    /* FUTURE: Add more fields for recipe details:
            cooking time,
            serving size,
            diet type,
            cuisine etc.
     */
}
