package org.demo.quizservice.dto;

import lombok.Data;

/*
 * This class is used to store the score of questions.
 * score: The score obtained in the for all questions.
 * correctAnswers: The number of correct answers in the quiz.
 * incorrectAnswers: The number of incorrect answers in the quiz.
 * totalQuestions: The total number of questions in the quiz.
 */
@Data
public class Score {
    private Double score;
    private Integer correctAnswers;
    private Integer incorrectAnswers;
    private Integer totalQuestions;
}
