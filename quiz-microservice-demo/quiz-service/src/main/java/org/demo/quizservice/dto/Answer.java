package org.demo.quizservice.dto;

import lombok.Data;

/*
 * This class is used to store the answer of a question.
 * questionId: The id of the question.
 * selectedOption: The option selected by the user.
 */
@Data
public class Answer {
    private Integer questionId;
    private Integer selectedOption;
}
