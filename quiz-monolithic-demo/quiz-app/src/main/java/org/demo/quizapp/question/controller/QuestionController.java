package org.demo.quizapp.question.controller;

import org.demo.quizapp.question.dto.QuestionRequest;
import org.demo.quizapp.question.entity.Question;
import org.demo.quizapp.question.service.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * This class is a controller class for Question.
 * getAllQuestions: method to get all questions
 * getQuestionsByCategory: method to get questions by category
 * addQuestion: method to add a question
 */
@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionServiceImpl questionService;

    @GetMapping
    public ResponseEntity<?> getAllQuestions() {
        List<Question> questions = questionService.getAllQuestions();
        if (questions.isEmpty()) {
            return new ResponseEntity<>("No questions found", null, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(questions, null, HttpStatus.OK);
        }
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<?> getQuestionsByCategory(@PathVariable String category) {
        List<Question> questions = questionService.getQuestionsByCategory(category);
        if (questions.isEmpty()) {
            return new ResponseEntity<>("No questions found", null, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(questions, null, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<?> addQuestion(@RequestBody QuestionRequest questionRequest) {
        String response = questionService.addQuestion(questionRequest);
        if (response.equals("success")) {
            return new ResponseEntity<>("Successfully added question", null, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to add question", null, HttpStatus.BAD_REQUEST);
        }
    }

}
