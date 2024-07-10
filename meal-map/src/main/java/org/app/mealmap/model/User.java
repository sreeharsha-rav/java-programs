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
@Table("users")
public class User {

    @Id
    private Integer id;

    @Column("username")
    private String username;

    @Column("password")
    private String password;

    @Column("favorite_recipes")
    private List<String> favoriteRecipes;

    @Column("meal_plan_ids")
    private List<Integer> mealPlanIds;
}
