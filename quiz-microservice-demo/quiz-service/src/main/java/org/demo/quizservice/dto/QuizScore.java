package org.demo.quizservice.dto;

import lombok.Data;

/*
 * This class is used to store the score of a quiz.
 * quizId: The id of the quiz.
 * score: The score obtained in the quiz.
 * totalQuestions: The total number of questions in the quiz.
 * correctAnswers: The number of correct answers in the quiz.
 * incorrectAnswers: The number of incorrect answers in the quiz.
 */
@Data
public class QuizScore {
    private Integer quizId;
    private Double score;
    private Integer totalQuestions;
    private Integer correctAnswers;
    private Integer incorrectAnswers;
}
