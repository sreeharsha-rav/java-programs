package com.example.springbootdemo.repository;

import com.example.springbootdemo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * This interface is used to interact with the database.
 * It extends the JpaRepository interface which provides CRUD operations on the database.
 * The JpaRepository interface takes two parameters: the entity class and the primary key type.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
