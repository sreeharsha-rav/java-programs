package org.demo.quizapp.question.dto;

import lombok.Data;

/*
 * This class is a DTO class for QuestionResponse.
 * id: question ID
 * questionTitle: title of the question
 * option1: option 1
 * option2: option 2
 * option3: option 3
 * option4: option 4
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
