package org.demo.questionservice.dto;

import lombok.Data;

/*
 * This class is a DTO class for Score.
 * score: score of the user
 * correctAnswers: number of correct answers
 * incorrectAnswers: number of incorrect answers
 * totalQuestions: total number of questions
 */
@Data
public class Score {
    private Double score;
    private Integer correctAnswers;
    private Integer incorrectAnswers;
    private Integer totalQuestions;
}
