package org.app.mealmap.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * This class represents a meal plan data transfer object.
 * id: The unique identifier of the meal plan.
 * userId: The unique identifier of the user who owns the meal plan.
 * name: The name of the meal plan.
 * description: A short description of the meal plan.
 * recipeIds: An array of recipe IDs that are part of the meal plan.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MealPlanDto {

    private Integer id;

    @Schema(description = "The unique identifier of the user who owns the meal plan")
    @NotNull
    private Integer userId;

    @Schema(description = "The name of the meal plan")
    @NotBlank
    private String name;

    @Schema(description = "A short description of the meal plan")
    @NotBlank
    private String description;

    @Schema(description = "An array of recipe IDs that are part of the meal plan")
    @NotNull
    private String[] recipeIds;
}
