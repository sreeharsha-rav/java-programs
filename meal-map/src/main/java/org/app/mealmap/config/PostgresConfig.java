package org.app.mealmap.config;

import lombok.extern.slf4j.Slf4j;
import org.app.mealmap.repository.MealPlanRepository;
import org.app.mealmap.model.User;
import org.app.mealmap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class PostgresConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MealPlanRepository mealPlanRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        loadUserData();
    }


    public List<User> userData() {
        return Arrays.asList(
            User.builder()
                .username("user1")
                .password(passwordEncoder.encode("password1"))
                .build(),
            User.builder()
                .username("user2")
                .password(passwordEncoder.encode("password2"))
                .build()
        );
    }

    public void loadUserData() {
        userRepository.deleteAll()
            .thenMany(Flux.fromIterable(userData()))
            .flatMap(userRepository::save)
            .thenMany(userRepository.findAll())
            .subscribe(user -> log.info("User inserted from command line runner: " + user));
    }
}
