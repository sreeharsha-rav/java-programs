package org.app.mealmap.utils;

import org.app.mealmap.model.User;
import org.app.mealmap.model.UserProjection;
import org.app.mealmap.dto.UserDto;

/*
 * This class is responsible for mapping User entities to User DTOs and vice versa.
 * entityToDto: This method maps a User entity to a User DTO.
 * dtoToEntity: This method maps a User DTO to a User entity.
 * projectionToDto: This method maps a User projection to a User DTO.
 */
public class UserMapper {

    public static UserDto entityToDto(User entity) {
        UserDto dto = UserDto.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .favoriteRecipes(entity.getFavoriteRecipes())
                .build();
        return dto;
    }

    public static User dtoToEntity(UserDto dto) {
        User entity = User.builder()
                .id(dto.getId())
                .username(dto.getUsername())
                .favoriteRecipes(dto.getFavoriteRecipes())
                .build();
        return entity;
    }

    public static UserDto projectionToDto(UserProjection projection) {
        UserDto dto = UserDto.builder()
                .id(projection.getId())
                .username(projection.getUsername())
                .favoriteRecipes(projection.getFavoriteRecipes())
                .build();
        return dto;
    }
}
