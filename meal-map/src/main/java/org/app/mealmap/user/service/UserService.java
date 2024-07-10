package org.app.mealmap.user.service;

import org.app.mealmap.user.Model.User;
import org.app.mealmap.user.dto.UserDto;
import org.app.mealmap.user.repository.UserRepository;
import org.app.mealmap.user.utils.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

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
                .flatMap(userRepository::insert)
                .map(UserMapper::entityToDto)
                .switchIfEmpty(Mono.error(new RuntimeException("User not created")));
    }

    public Mono<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
