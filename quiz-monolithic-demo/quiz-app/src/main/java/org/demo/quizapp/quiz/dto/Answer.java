package org.demo.quizapp.quiz.dto;

import lombok.Data;

/*
 * This class is a DTO class for Answer.
 * questionId: question ID
 * selectedOption: selected option
 */
@Data
public class Answer {
    private Integer questionId;
    private Integer selectedOption;
}
