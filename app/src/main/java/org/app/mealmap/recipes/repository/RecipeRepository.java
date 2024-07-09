package org.app.mealmap.recipes.repository;

import org.app.mealmap.recipes.model.Recipe;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends ReactiveCrudRepository<Recipe, Long> {
}
