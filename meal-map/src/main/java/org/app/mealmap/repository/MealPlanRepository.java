package org.app.mealmap.repository;

import org.app.mealmap.model.MealPlan;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

/*
 * This interface is the repository for the meal plan entity. It is responsible for handling database operations related to meal plans.
 * findAllByUserId: This method returns all meal plans for a specific user.
 */
public interface MealPlanRepository extends ReactiveCrudRepository<MealPlan, Integer> {
    Flux<MealPlan> findAllByUserId(Integer userId);
}
