package org.demo.quizapp.quiz.dto;

import lombok.Data;

/*
 * This class is a DTO class for QuizScore.
 * quizId: quiz ID
 * score: score of the quiz
 * totalQuestions: total number of questions
 * correctAnswers: number of correct answers
 * incorrectAnswers: number of incorrect answers
 */
@Data
public class QuizScore {
    private Integer quizId;
    private Double score;
    private Integer totalQuestions;
    private Integer correctAnswers;
    private Integer incorrectAnswers;
}
