package org.mealmap.app.recipes.repository;

import org.mealmap.app.recipes.model.Recipe;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends ReactiveCrudRepository<Recipe, Long> {
}
