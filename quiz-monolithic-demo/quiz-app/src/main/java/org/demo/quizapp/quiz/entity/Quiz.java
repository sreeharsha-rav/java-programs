package org.demo.quizapp.quiz.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.demo.quizapp.question.entity.Question;

import java.util.List;

/*
 * This class is an entity class for Quiz.
 * id: quiz ID
 * quizTitle: title of the quiz
 * questions: list of questions
 */
@Entity
@Data
@Table(name = "quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "quiz_title")
    private String quizTitle;

    @ManyToMany
    private List<Question> questions;

}
