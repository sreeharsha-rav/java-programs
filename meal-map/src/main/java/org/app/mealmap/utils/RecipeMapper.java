package org.app.mealmap.utils;

import org.app.mealmap.dto.RecipeDto;
import org.app.mealmap.model.Recipe;
import org.springframework.beans.BeanUtils;

/*
 * This class provides utility methods for converting Recipe entities to RecipeDto objects and vice versa.
 * entityToDto: converts a Recipe entity to a RecipeDto object.
 * dtoToEntity: converts a RecipeDto object to a Recipe entity.
 */
public class RecipeMapper {
    public static RecipeDto entityToDto(Recipe entity) {
        RecipeDto dto = new RecipeDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public static Recipe dtoToEntity(RecipeDto dto) {
        Recipe entity = new Recipe();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
