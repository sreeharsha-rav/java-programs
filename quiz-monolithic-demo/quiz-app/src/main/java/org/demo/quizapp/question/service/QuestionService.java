package org.demo.quizapp.question.service;

import org.demo.quizapp.question.dto.QuestionRequest;
import org.demo.quizapp.question.entity.Question;

import java.util.List;

/*
 * This interface is for Question Service.
 * getAllQuestions: method to get all questions
 * getQuestionsByCategory: method to get questions by category
 * addQuestion: method to add a question
 */
public interface QuestionService {
    List<Question> getAllQuestions();
    List<Question> getQuestionsByCategory(String category);
    String addQuestion(QuestionRequest questionRequest);
}
