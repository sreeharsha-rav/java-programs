package org.app.mealmap.config;

import lombok.extern.slf4j.Slf4j;
import org.app.mealmap.model.Recipe;
import org.app.mealmap.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

/*
 * This class initializes the MongoDB database with recipe data.
 */
@Component
@Slf4j
public class MongoConfig implements CommandLineRunner {

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public void run(String... args) {
        initRecipeData();
    }

    public List<Recipe> recipeData() {
        return Arrays.asList(
                Recipe.builder()
                        .name("Pasta")
                        .description("A delicious pasta dish.")
                        .imageUrl("https://www.example.com/pasta.jpg")
                        .ingredients("Pasta, tomato sauce, cheese")
                        .instructions("Cook pasta, add tomato sauce, sprinkle cheese.")
                        .build(),
                Recipe.builder()
                        .name("Pizza")
                        .description("A tasty pizza.")
                        .imageUrl("https://www.example.com/pizza.jpg")
                        .ingredients("Pizza base, tomato sauce, cheese, toppings")
                        .instructions("Spread tomato sauce on base, add cheese and toppings, bake.")
                        .build(),
                Recipe.builder()
                        .name("Salad")
                        .description("A healthy salad.")
                        .imageUrl("https://www.example.com/salad.jpg")
                        .ingredients("Lettuce, tomatoes, cucumber, dressing")
                        .instructions("Chop vegetables, mix with dressing.")
                        .build()
        );
    }

    private void initRecipeData() {
        recipeRepository.deleteAll()
                .thenMany(Flux.fromIterable(recipeData()))
                .flatMap(recipeRepository::save)
                .thenMany(recipeRepository.findAll())
                .subscribe(recipe -> log.info("Recipe inserted: " + recipe.getName()));
    }

}
