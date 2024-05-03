package org.demo.quizapp.quiz.repository;

import org.demo.quizapp.quiz.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * This interface is a repository for Quiz.
 */
@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {
}
