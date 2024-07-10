package org.app.mealmap.user.controller;

import org.app.mealmap.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getUser() {
        return "Hello, user!";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createUser() {
        return "User created!";
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public String updateUser() {
        return "User updated!";
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public String deleteUser() {
        return "User deleted!";
    }
}
