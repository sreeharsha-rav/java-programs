package org.demo.quizservice.service;

import org.demo.quizservice.dto.*;
import org.demo.quizservice.entity.Quiz;

import java.util.List;

/*
 * This represents the interface for QuizService
 * createQuiz: creates a quiz
 * getQuiz: gets a quiz given an id
 * submitQuiz: submit a quiz with answers to get score
 */
public interface QuizService {
    Quiz createQuiz(QuizRequest quizRequest);
    QuizResponse getQuiz(Integer quizId);
    QuizScore submitQuiz(Integer quizId, List<Answer> answers);
}
