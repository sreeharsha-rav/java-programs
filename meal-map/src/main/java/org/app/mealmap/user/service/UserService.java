package org.app.mealmap.user.service;

import org.app.mealmap.user.dto.UserDto;
import org.app.mealmap.user.repository.UserRepository;
import org.app.mealmap.user.utils.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private Mono<UserDto> createUser(Mono<UserDto> userDtoMono) {
        return userDtoMono.map(UserMapper::dtoToEntity)
                .flatMap(userRepository::insert)
                .map(UserMapper::entityToDto)
                .switchIfEmpty(Mono.error(new RuntimeException("User not created")));
    }

    private Mono<UserDto> getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(UserMapper::entityToDto)
                .switchIfEmpty(Mono.error(new RuntimeException("User not found")));
    }

    private Mono<UserDto> updateUser(String id, Mono<UserDto> userDtoMono) {
        return userRepository.findById(id)
                .flatMap(user -> userDtoMono.map(UserMapper::dtoToEntity)
                        .doOnNext(e -> e.setId(id))
                        .flatMap(userRepository::save))
                .map(UserMapper::entityToDto)
                .switchIfEmpty(Mono.error(new RuntimeException("User not updated")));
    }

    private Mono<Void> deleteUser(String id) {
        return userRepository.deleteById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("User not deleted")));
    }
}
