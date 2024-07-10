package org.app.mealmap.repository;

import org.app.mealmap.model.Recipe;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

/*
 * This interface provides methods for interacting with the recipe collection in the MongoDB database.
 */
@Repository
public interface RecipeRepository extends ReactiveMongoRepository<Recipe, String> {
}
