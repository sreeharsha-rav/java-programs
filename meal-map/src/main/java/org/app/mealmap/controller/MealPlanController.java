package org.app.mealmap.controller;

import jakarta.validation.Valid;
import org.app.mealmap.dto.MealPlanDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.app.mealmap.service.MealPlanService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/*
 * This class is the controller for the meal plan entity. It is responsible for handling HTTP requests related to meal plans.
 * getAllMealPlansForUser: This method returns all meal plans for a specific user.
 * getMealPlanById: This method returns a meal plan by its ID.
 * createMealPlan: This method creates a new meal plan.
 * updateMealPlan: This method updates an existing meal plan.
 * deleteMealPlan: This method deletes a meal plan.
 */
@RestController
@RequestMapping("/api/meal-plans")
public class MealPlanController {

    @Autowired
    private MealPlanService mealPlanService;

    @GetMapping("/user/{userId}")
    public Flux<MealPlanDto> getAllMealPlansForUser(@PathVariable Integer userId){
        return mealPlanService.getAllMealPlansForUser(userId);
    }

    @GetMapping("/{mealPlanId}")
    public Mono<MealPlanDto> getMealPlanById(@PathVariable Integer mealPlanId) {
        return mealPlanService.getMealPlanById(mealPlanId);
    }

    @PostMapping
    public Mono<MealPlanDto> createMealPlan(@Valid @RequestBody Mono<MealPlanDto> mealPlanDtoMono) {
        return mealPlanService.createMealPlan(mealPlanDtoMono);
    }

    @PutMapping("/{mealPlanId}")
    public Mono<MealPlanDto> updateMealPlan(@PathVariable Integer mealPlanId, @Valid @RequestBody Mono<MealPlanDto> mealPlanDtoMono) {
        return mealPlanService.updateMealPlan(mealPlanId, mealPlanDtoMono);
    }

    @DeleteMapping("/{mealPlanId}")
    public Mono<Void> deleteMealPlan(@PathVariable Integer mealPlanId) {
        return mealPlanService.deleteMealPlan(mealPlanId);
    }

}
