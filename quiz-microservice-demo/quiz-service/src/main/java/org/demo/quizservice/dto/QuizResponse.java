package org.demo.quizservice.dto;

import lombok.Data;

import java.util.List;

/*
 * This class is used to store the response of a quiz.
 * id: The id of the quiz.
 * quizTitle: The title of the quiz.
 * questions: The list of questions in the quiz.
 */
@Data
public class QuizResponse {
    private Integer id;
    private String quizTitle;
    private List<QuestionResponse> questions;
}
