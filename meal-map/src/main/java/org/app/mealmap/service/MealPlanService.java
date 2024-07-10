package org.app.mealmap.service;

import org.app.mealmap.dto.MealPlanDto;
import org.app.mealmap.dto.UserDto;
import org.app.mealmap.repository.MealPlanRepository;
import org.app.mealmap.utils.MealPlanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/*
 * This is the service class for the MealPlan model.
 * getAllMealPlansForUser: This method returns all meal plans for a specific user.
 * getMealPlanById: This method returns a meal plan by its ID.
 * createMealPlan: This method creates a new meal plan.
 * updateMealPlan: This method updates an existing meal plan.
 * deleteMealPlan: This method deletes a meal plan.
 */
@Service
public class MealPlanService {

    @Autowired
    private MealPlanRepository mealPlanRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private RecipeService recipeService;

    public Flux<MealPlanDto> getAllMealPlansForUser(Integer userId) {
        // Check if the user exists
        Mono<UserDto> userDtoMono = userService.getUserById(userId);
        return userDtoMono.flatMapMany(userDto -> mealPlanRepository.findAllByUserId(userId)
                .map(MealPlanMapper::entityToDto));
        // FUTURE: Add RecipeDto and UserDto to MealPlanDto

    }

    public Mono<MealPlanDto> getMealPlanById(Integer mealPlanId) {
        return mealPlanRepository.findById(mealPlanId)
                .map(MealPlanMapper::entityToDto)
                .switchIfEmpty(Mono.error(new RuntimeException("Meal plan not found")));
    }

    public Mono<MealPlanDto> createMealPlan(Mono<MealPlanDto> mealPlanDtoMono) {
        return mealPlanDtoMono.map(MealPlanMapper::dtoToEntity)
                .flatMap(mealPlanRepository::save)
                .map(MealPlanMapper::entityToDto)
                .switchIfEmpty(Mono.error(new RuntimeException("Meal plan not created")));
    }

    public Mono<MealPlanDto> updateMealPlan(Integer mealPlanId, Mono<MealPlanDto> mealPlanDtoMono) {
        return mealPlanRepository.findById(mealPlanId)
                .flatMap(mealPlan -> mealPlanDtoMono.map(MealPlanMapper::dtoToEntity)
                        .doOnNext(e -> e.setId(mealPlanId))
                        .flatMap(mealPlanRepository::save))
                .map(MealPlanMapper::entityToDto)
                .switchIfEmpty(Mono.error(new RuntimeException("Meal plan not updated")));
    }

    public Mono<Void> deleteMealPlan(Integer mealPlanId) {
        return mealPlanRepository.deleteById(mealPlanId)
                .switchIfEmpty(Mono.error(new RuntimeException("Meal plan not deleted")));
    }
}
