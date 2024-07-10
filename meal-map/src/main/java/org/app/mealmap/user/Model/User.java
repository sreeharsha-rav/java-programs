package org.app.mealmap.user.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*
 * This class represents a user entity.
 * id: the unique identifier of the user.
 * username: the username of the user.
 * password: the password of the user.
 * favoriteRecipes: an array of recipe ids that the user has favorited.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("users")
public class User {

    @Id
    private String id;

    private String username;

    private String password;

    private String[] favoriteRecipes;
}
