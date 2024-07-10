package org.app.mealmap.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String id;

    @NotBlank(message = "Username is required")
    @NotNull(message = "Username cannot be null")
    private String username;

    @NotBlank(message = "Password is required")
    @NotNull(message = "Password cannot be null")
    private String password;

    private String[] favoriteRecipes;
}
