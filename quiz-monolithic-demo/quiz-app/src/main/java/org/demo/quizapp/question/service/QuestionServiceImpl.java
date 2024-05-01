package org.demo.quizapp.question.service;

import org.demo.quizapp.question.dto.QuestionRequest;
import org.demo.quizapp.question.entity.Question;
import org.demo.quizapp.question.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/*
 * This class is a service class for Question Service.
 * getAllQuestions: method to get all questions
 * getQuestionsByCategory: method to get questions by category
 * addQuestion: method to add a question
 */
@Service
public class QuestionServiceImpl {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionRepository.findByCategory(category);
    }

    public String addQuestion(QuestionRequest questionRequest) {
        Question question = new Question();
        question.setCategory(questionRequest.getCategory());
        question.setDifficulty(questionRequest.getDifficulty());
        question.setOption1(questionRequest.getOption1());
        question.setOption2(questionRequest.getOption2());
        question.setOption3(questionRequest.getOption3());
        question.setOption4(questionRequest.getOption4());
        question.setQuestionTitle(questionRequest.getQuestionTitle());
        question.setCorrectOption(questionRequest.getCorrectOption());
        Question savedQuestion = questionRepository.save(question);
        return savedQuestion != null ? "success" : "failure";
    }

}
