package org.app.mealmap.service;

import org.app.mealmap.dto.UserDto;
import org.app.mealmap.repository.UserRepository;
import org.app.mealmap.utils.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*
 * This is the service class for the User model.
 * createUser: This method creates a new user from a user DTO.
 * getUserByUsername: This method retrieves a user by username from the database.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Mono<UserDto> createUser(Mono<UserDto> userDtoMono) {
        return userDtoMono.map(UserMapper::dtoToEntity)
                .flatMap(userRepository::save)
                .map(UserMapper::entityToDto)
                .switchIfEmpty(Mono.error(new RuntimeException("User not created")));
    }

    public Mono<UserDto> findByUsername(String username) {
        return userRepository.findProjectedByUsername(username)
                .map(UserMapper::projectionToDto)
                .switchIfEmpty(Mono.error(new RuntimeException("User not found")));
    }

    public Mono<UserDto> getUserById(Integer userId) {
        return userRepository.findById(userId)
                .map(UserMapper::entityToDto)
                .switchIfEmpty(Mono.error(new RuntimeException("User not found")));
    }

    public Mono<UserDto> addFavoriteRecipe(Integer userId, String recipeId) {
        return userRepository.findById(userId)
                .map(user -> {
                    List<String> favoriteRecipes = Optional.ofNullable(user.getFavoriteRecipes())
                            .orElse(Arrays.asList());
                    favoriteRecipes.add(recipeId);
                    user.setFavoriteRecipes(favoriteRecipes);
                    return user;
                })
                .flatMap(userRepository::save)
                .map(UserMapper::entityToDto)
                .switchIfEmpty(Mono.error(new RuntimeException("User not found")));

    }

    public Mono<UserDto> removeFavoriteRecipe(Integer userId, String recipeId) {
        return userRepository.findById(userId)
                .map(user -> {
                    Arrays.stream(user.getFavoriteRecipes().toArray())
                            .filter(favoriteRecipe -> !favoriteRecipe.equals(recipeId));
                    return user;
                })
                .flatMap(userRepository::save)
                .map(UserMapper::entityToDto)
                .switchIfEmpty(Mono.error(new RuntimeException("User not found")));
    }

}
