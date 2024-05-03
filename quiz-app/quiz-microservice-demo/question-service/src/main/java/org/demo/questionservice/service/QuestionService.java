package org.demo.questionservice.service;

import org.demo.questionservice.dto.Answer;
import org.demo.questionservice.dto.QuestionRequest;
import org.demo.questionservice.dto.QuestionResponse;
import org.demo.questionservice.dto.Score;
import org.demo.questionservice.entity.Question;

import java.util.List;

/*
 * This interface is for Question Service.
 * getAllQuestions: method to get all questions
 * getQuestionsByCategory: method to get questions by category
 * addQuestion: method to add a question
 * generateQuestions: method to generate questions
 * getQuestionsByIDs: method to get questions by IDs
 * calculateScore: method to calculate score
 */
public interface QuestionService {
    List<Question> getAllQuestions();
    List<Question> getQuestionsByCategory(String category);
    String addQuestion(QuestionRequest questionRequest);
    List<Integer> generateQuestions(Integer numQuestions, String category);
    List<QuestionResponse> getQuestionsByIDs(List<Integer> questionIDs);
    Score calculateScore(List<Answer> answers);
}
