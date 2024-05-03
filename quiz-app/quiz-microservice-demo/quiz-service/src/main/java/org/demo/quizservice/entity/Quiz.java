package org.demo.quizservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/*
 * This class represents a quiz entity.
 * id: The id of the quiz.
 * quizTitle: The title of the quiz.
 * questionIds: The list of question ids in the quiz.
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

    @ElementCollection
    private List<Integer> questionIds;

}
