package org.demo.questionservice.controller;


import org.demo.questionservice.dto.Answer;
import org.demo.questionservice.dto.QuestionResponse;
import org.demo.questionservice.dto.Score;
import org.demo.questionservice.service.QuestionServiceImpl;
import org.demo.questionservice.dto.QuestionRequest;
import org.demo.questionservice.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * This class is a controller class for the Question Service.
 * getAllQuestions: method to get all questions
 * getQuestionsByCategory: method to get questions by category
 * addQuestion: method to add a question
 * generateQuestions: method to generate questions
 * getQuestionsByIds: method to get questions by IDs
 * getScore: method calculate score
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

    @GetMapping("/generate")
    public ResponseEntity<?> generateQuestions(@RequestParam Integer numQuestions, @RequestParam String category) {
        List<Integer> questionIds = questionService.generateQuestions(numQuestions, category);
        if (questionIds.isEmpty()) {
            return new ResponseEntity<>("No questions found for given count and category", null, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(questionIds, null, HttpStatus.OK);
        }
    }

    @PostMapping("/getByIds")
    public ResponseEntity<?> getQuestionsByIds(@RequestBody List<Integer> questionIds) {
        List<QuestionResponse> questions = questionService.getQuestionsByIDs(questionIds);
        if (questions == null) {
            return new ResponseEntity<>("No questions found for given ids", null, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(questions, null, HttpStatus.OK);
        }
    }

    @PostMapping("/score")
    public ResponseEntity<?> getScore(@RequestBody List<Answer> answers) {
        Score score = questionService.calculateScore(answers);
        if (score != null) {
            return new ResponseEntity<>(score, null, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to calculate score", null, HttpStatus.BAD_REQUEST);
        }
    }

}
