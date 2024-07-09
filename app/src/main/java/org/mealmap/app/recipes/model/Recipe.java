package org.mealmap.app.recipes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/*
 * This class represents a recipe entity.
 * id: the unique identifier of the recipe.
 * name: the name of the recipe.
 * description: a short description of the recipe.
 * imageUrl: the URL of the image of the recipe.
 */
@Table("recipes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {

    @Id
    @Column("id")
    private Long id;

    @Column("name")
    private String name;

    @Column("description")
    private String description;

    @Column("imageUrl")
    private String imageUrl;
}
