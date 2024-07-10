package org.app.mealmap.repository;

import org.app.mealmap.model.User;
import org.app.mealmap.model.UserProjection;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/*
 * This is the repository interface for the User model in PostgreSQL.
 * findByUsername: This method retrieves a user by username from the database.
 * findProjectedByUsername: This method retrieves a user projection by username from the database.
 */
@Repository
public interface UserRepository extends ReactiveCrudRepository<User, Integer> {
    Mono<User> findByUsername(String username);
    Mono<UserProjection> findProjectedByUsername(String username);
}
