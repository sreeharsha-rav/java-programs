package org.demo.quizapp.quiz.dto;

import lombok.Data;

/*
 * This class is a DTO class for QuizRequest.
 * quizTitle: title of the quiz
 * questionCount: number of questions
 * category: category of the quiz
 */
@Data
public class QuizRequest {
    private String quizTitle;
    private Integer questionCount;
    private String category;
}
