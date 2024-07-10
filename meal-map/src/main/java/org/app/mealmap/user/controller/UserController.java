package org.app.mealmap.user.controller;

import org.app.mealmap.user.dto.UserDto;
import org.app.mealmap.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<UserDto> createUser(@RequestBody Mono<UserDto> userDtoMono) {
        return userService.createUser(userDtoMono);
    }

}
