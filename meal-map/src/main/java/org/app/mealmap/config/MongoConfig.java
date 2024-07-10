package org.app.mealmap.config;

import lombok.extern.slf4j.Slf4j;
import org.app.mealmap.recipes.model.Recipe;
import org.app.mealmap.recipes.repository.RecipeRepository;
import org.app.mealmap.user.Model.User;
import org.app.mealmap.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class MongoConfig implements CommandLineRunner {

    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

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

    public List<User> userData() {
        return Arrays.asList(
                User.builder()
                        .username("user")
                        .password(passwordEncoder.encode("password"))
                        .favoriteRecipes(new String[]{"1", "2"})
                        .build(),
                User.builder()
                        .username("admin")
                        .password(passwordEncoder.encode("password"))
                        .favoriteRecipes(new String[]{"2", "3"})
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

    private void initUserData() {
        // insert user data into the database
        userRepository.deleteAll()
                .thenMany(Flux.fromIterable(userData()))
                .flatMap(userRepository::save)
                .thenMany(userRepository.findAll())
                .subscribe(user -> log.info("User inserted: " + user.getUsername()));
    }

}
