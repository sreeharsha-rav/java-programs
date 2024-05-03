package org.demo.quizservice.controller;

import org.demo.quizservice.dto.QuizResponse;
import org.demo.quizservice.dto.QuizScore;
import org.demo.quizservice.dto.QuizRequest;
import org.demo.quizservice.dto.Answer;
import org.demo.quizservice.entity.Quiz;
import org.demo.quizservice.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * QuizController to handle quiz related requests
 * createQuiz: Create a new quiz
 * getQuiz: Get a quiz by id
 * submitQuiz: Submit a quiz and get the score
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
