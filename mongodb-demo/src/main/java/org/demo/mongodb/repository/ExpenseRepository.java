package org.demo.mongodb.repository;

import org.demo.mongodb.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
 * The ExpenseRepository interface is a repository that extends the MongoRepository interface.
 * It provides methods to perform CRUD operations on the Expense collection in the MongoDB database.
 */
@Repository
public interface ExpenseRepository extends MongoRepository<Expense, String> {

    @Query("{ 'name' : ?0 }")
    Optional<Expense> findByName(String name);

}
