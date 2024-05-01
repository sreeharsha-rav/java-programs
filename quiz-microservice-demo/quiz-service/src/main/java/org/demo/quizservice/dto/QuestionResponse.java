package org.demo.quizservice.dto;

import lombok.Data;

/*
 * This class is used to store the response of a question.
 * id: The id of the question.
 * questionTitle: The title of the question.
 * option1: The first option of the question.
 * option2: The second option of the question.
 * option3: The third option of the question.
 * option4: The fourth option of the question.
 */
@Data
public class QuestionResponse {
    private Integer id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
}
