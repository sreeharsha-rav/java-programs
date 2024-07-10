package org.app.mealmap.model;

import java.util.List;

/*
 * Projection for User entity
 * id: The unique identifier of the user
 * username: The username of the user
 * favoriteRecipes: The list of favorite recipes of the user
 */
public interface UserProjection {
    Integer getId();
    String getUsername();
    List<String> getFavoriteRecipes();
}
