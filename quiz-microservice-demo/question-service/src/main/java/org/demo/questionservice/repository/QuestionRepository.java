package org.demo.questionservice.repository;

import org.demo.questionservice.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * This interface is a repository for Question.
 * findByCategory: method to get questions by category
 * findRandomQuestionIdsByCategory: method to get random question IDs by category
 */
@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);

    @Query(value = "SELECT q.id FROM questions q WHERE q.category=:category ORDER BY RAND() LIMIT :questionCount", nativeQuery = true)
    List<Integer> findRandomQuestionIdsByCategory(String category, Integer questionCount);

}
