package org.demo.quizapp.question.dto;

import lombok.Data;
import org.demo.quizapp.question.entity.Difficulty;

/*
 * This class is a DTO class for QuestionRequest.
 * category: category of the question
 * difficulty: difficulty level of the question
 * option1: option 1
 * option2: option 2
 * option3: option 3
 * option4: option 4
 * questionTitle: title of the question
 * correctOption: correct option
 */
@Data
public class QuestionRequest {
    private String category;
    private Difficulty difficulty;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String questionTitle;
    private Integer correctOption;
}
