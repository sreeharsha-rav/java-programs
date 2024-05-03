package org.demo.quizservice.dto;

import lombok.Data;

/*
 * This class is used to store the request of a quiz.
 * quizTitle: The title of the quiz.
 * questionCount: The number of questions in the quiz.
 * category: The category of the quiz.
 */
@Data
public class QuizRequest {
    private String quizTitle;
    private Integer questionCount;
    private String category;
}
