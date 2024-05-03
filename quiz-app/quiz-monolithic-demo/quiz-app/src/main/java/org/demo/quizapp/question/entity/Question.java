package org.demo.quizapp.question.entity;

import jakarta.persistence.*;
import lombok.Data;

/*
 * This class is an entity class for Question.
 * id: question ID
 * category: category of the question
 * difficulty: difficulty level of the question
 * option1: option 1
 * option2: option 2
 * option3: option 3
 * option4: option 4
 * questionTitle: title of the question
 * correctOption: correct option
 */
@Entity
@Data
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private Integer id;

    @Column(nullable = false, length = 255, name = "category")
    private String category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "difficulty")
    private Difficulty difficulty;

    @Column(nullable = false, name = "option1")
    private String option1;

    @Column(nullable = false, name = "option2")
    private String option2;

    @Column(nullable = false, name = "option3")
    private String option3;

    @Column(nullable = false, name = "option4")
    private String option4;

    @Column(nullable = false, name = "question_title")
    private String questionTitle;

    @Column(nullable = false, name = "correct_option")
    private Integer correctOption;

}
