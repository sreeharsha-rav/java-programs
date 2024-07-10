package org.app.mealmap.recipes.repository;

import org.app.mealmap.recipes.model.Recipe;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/*
 * This interface provides methods for interacting with the recipe collection in the MongoDB database.
 */
@Repository
public interface RecipeRepository extends ReactiveMongoRepository<Recipe, String> {

}
