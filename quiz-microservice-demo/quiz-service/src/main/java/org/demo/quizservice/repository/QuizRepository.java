package org.demo.quizservice.repository;

import org.demo.quizservice.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * Repository to interact with quiz table
 */
@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {
}
