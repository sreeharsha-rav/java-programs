package org.demo.quizapp.quiz.controller;

import org.demo.quizapp.quiz.dto.Answer;
import org.demo.quizapp.quiz.dto.QuizRequest;
import org.demo.quizapp.quiz.dto.QuizResponse;
import org.demo.quizapp.quiz.dto.QuizScore;
import org.demo.quizapp.quiz.entity.Quiz;
import org.demo.quizapp.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * This class is a controller class for Quiz.
 * createQuiz: method to create a quiz
 * getQuiz: method to get a quiz
 * submitQuiz: method to submit a quiz
 */
@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<?> createQuiz(@RequestBody QuizRequest quizRequest) {
        Quiz createdQuiz = quizService.createQuiz(quizRequest);
        if (createdQuiz.getId() != null) {
            return new ResponseEntity<>("Successfully created quiz with id: " + createdQuiz.getId(), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Quiz creation failed", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{quizId}")
    public ResponseEntity<?> getQuiz(@PathVariable Integer quizId) {
        QuizResponse quizResponse = quizService.getQuiz(quizId);
        if (quizResponse != null) {
            return new ResponseEntity<>(quizResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Quiz not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{quizId}/submit")
    public ResponseEntity<?> submitQuiz(@PathVariable Integer quizId, @RequestBody List<Answer> answers) {
        QuizScore quizScore = quizService.submitQuiz(quizId, answers);
        if (quizScore != null) {
            return new ResponseEntity<>(quizScore, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to submit quiz and calculate score", HttpStatus.BAD_REQUEST);
        }
    }

}
