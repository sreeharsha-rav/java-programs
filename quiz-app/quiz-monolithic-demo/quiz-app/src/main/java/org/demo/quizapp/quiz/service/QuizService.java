package org.demo.quizapp.quiz.service;

import org.demo.quizapp.quiz.dto.Answer;
import org.demo.quizapp.quiz.dto.QuizRequest;
import org.demo.quizapp.quiz.dto.QuizResponse;
import org.demo.quizapp.quiz.dto.QuizScore;
import org.demo.quizapp.quiz.entity.Quiz;

import java.util.List;

/*
 * This interface is for Quiz Service.
 * createQuiz: method to create a quiz
 * getQuiz: method to get a quiz
 * submitQuiz: method to submit a quiz
 */
public interface QuizService {
    Quiz createQuiz(QuizRequest quizRequest);
    QuizResponse getQuiz(Integer quizId);
    QuizScore submitQuiz(Integer quizId, List<Answer> answers);
}
