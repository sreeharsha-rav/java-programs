package org.demo.quizapp.question.repository;

import org.demo.quizapp.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/*
 * This interface is a repository for Question.
 * findByCategory: method to find questions by category
 * findRandomQuestionsByCategory: method to find random questions by category
 */
@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM questions q WHERE q.category=:category ORDER BY RANDOM() LIMIT :questionCount", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, Integer questionCount);

}
