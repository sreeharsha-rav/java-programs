package org.app.mealmap.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

/*
 * This class represents a meal plan.
 * A meal plan is a collection of recipes that a user plans to eat over a period of time.
 * id: The unique identifier of the meal plan.
 * userId: The unique identifier of the user who created the meal plan.
 * name: The name of the meal plan.
 * description: A short description of the meal plan.
 * recipeIds: An array of recipe IDs that are part of the meal plan.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("meal_plans")
public class MealPlan {
    @Id
    private Integer id;

    @Column("user_id")
    private Integer userId;

    @Column("name")
    private String name;

    @Column("description")
    private String description;

    @Column("recipe_ids")
    private List<String> recipeIds;

}
