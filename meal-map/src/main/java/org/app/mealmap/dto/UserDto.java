package org.app.mealmap.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*
 * Data Transfer Object for User
 * id: The id of the user
 * username: The username of the user
 * favoriteRecipes: The list of favorite recipes of the user
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Integer id;

    @Schema(description = "The username of the user")
    private String username;

    @Schema(description = "The list of favorite recipes of the user")
    private List<String> favoriteRecipes;
}
