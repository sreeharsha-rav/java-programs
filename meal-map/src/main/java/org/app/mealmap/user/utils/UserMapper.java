package org.app.mealmap.user.utils;

import org.app.mealmap.user.Model.User;
import org.app.mealmap.user.dto.UserDto;
import org.springframework.beans.BeanUtils;

public class UserMapper {

    public static UserDto entityToDto(User entity) {
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public static User dtoToEntity(UserDto dto) {
        User entity = new User();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
