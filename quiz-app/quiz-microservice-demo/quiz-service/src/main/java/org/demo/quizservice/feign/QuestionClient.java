package org.demo.quizservice.feign;

import org.demo.quizservice.dto.Answer;
import org.demo.quizservice.dto.Score;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * This interaface represents the feign client for question-service
 * generateQuestions: generates questions given count of questions and category
 * getQuestionsByIds: gives a list of questions based on a list of question ids
 * getScore: calculates score based on the submitted answers
 */
@FeignClient(name = "QUESTION-SERVICE")
public interface QuestionClient {

    @GetMapping("/questions/generate")
    public ResponseEntity<?> generateQuestions(@RequestParam Integer numQuestions, @RequestParam String category);

    @PostMapping("/questions/getByIds")
    public ResponseEntity<?> getQuestionsByIds(@RequestBody List<Integer> questionIds);

    @PostMapping("/questions/score")
    public ResponseEntity<Score> getScore(@RequestBody List<Answer> answers);

}
