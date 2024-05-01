package org.demo.quizapp.quiz.dto;

import lombok.Data;
import org.demo.quizapp.question.dto.QuestionResponse;

import java.util.List;

/*
 * This class is a DTO class for QuizResponse.
 * id: quiz ID
 * quizTitle: title of the quiz
 * questions: list of questions
 */
@Data
public class QuizResponse {
    private Integer id;
    private String quizTitle;
    private List<QuestionResponse> questions;
}
