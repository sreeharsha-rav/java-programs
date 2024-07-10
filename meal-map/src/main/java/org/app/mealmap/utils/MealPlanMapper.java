package org.app.mealmap.utils;

import org.app.mealmap.dto.MealPlanDto;
import org.app.mealmap.model.MealPlan;

/*
 * This class provides methods to map between meal plan entities and meal plan DTOs.
 * entityToDto: Converts a meal plan entity to a meal plan DTO.
 * dtoToEntity: Converts a meal plan DTO to a meal plan entity.
 */
public class MealPlanMapper {

    public static MealPlanDto entityToDto(MealPlan mealPlan) {
        return MealPlanDto.builder()
                .id(mealPlan.getId())
                .userId(mealPlan.getUserId())
                .name(mealPlan.getName())
                .description(mealPlan.getDescription())
                .build();
    }

    public static MealPlan dtoToEntity(MealPlanDto mealPlanDto) {
        return MealPlan.builder()
                .id(mealPlanDto.getId())
                .userId(mealPlanDto.getUserId())
                .name(mealPlanDto.getName())
                .description(mealPlanDto.getDescription())
                .build();
    }

}
