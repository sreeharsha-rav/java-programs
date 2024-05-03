package org.demo.questionservice.service;

import org.demo.questionservice.dto.Answer;
import org.demo.questionservice.dto.QuestionRequest;
import org.demo.questionservice.dto.QuestionResponse;
import org.demo.questionservice.dto.Score;
import org.demo.questionservice.entity.Question;
import org.demo.questionservice.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * This class is a service class for Question Service.
 * getAllQuestions: method to get all questions
 * getQuestionsByCategory: method to get questions by category
 * addQuestion: method to add a question
 * generateQuestions: method to generate questions
 * getQuestionsByIDs: method to get questions by IDs
 * calculateScore: method to calculate score
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public List<Question> getQuestionsByCategory(String category) {
        return questionRepository.findByCategory(category);
    }

    @Override
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

    @Override
    public List<Integer> generateQuestions(Integer numQuestions, String category) {
        List<Integer> questionIds = questionRepository.findRandomQuestionIdsByCategory(category, numQuestions);
        return questionIds;
    }

    @Override
    public List<QuestionResponse> getQuestionsByIDs(List<Integer> questionIDs) {
        List<Question> questions = questionRepository.findAllById(questionIDs);
        if (questions.isEmpty()) {
            return null;
        } else {
            List<QuestionResponse> questionResponses = new ArrayList<>();
            for (Question question : questions) {
                QuestionResponse questionResponse = new QuestionResponse();
                questionResponse.setId(question.getId());
                questionResponse.setOption1(question.getOption1());
                questionResponse.setOption2(question.getOption2());
                questionResponse.setOption3(question.getOption3());
                questionResponse.setOption4(question.getOption4());
                questionResponse.setQuestionTitle(question.getQuestionTitle());
                questionResponses.add(questionResponse);
            }
            return questionResponses;
        }
    }

    @Override
    public Score calculateScore(List<Answer> answers) {
        List<Integer> questionIds = answers.stream().map(Answer::getQuestionId).collect(Collectors.toList());
        List<Question> questions = questionRepository.findAllById(questionIds);

        // Check if the number of answers submitted is equal to the number of questions
        if (answers.size() != questions.size()) {
            return null;
        }

        // Check if questions list is empty
        if (questions.isEmpty()) {
            return null;
        }

        // Calculate the score
        int totalQuestions = questions.size();
        int correctAnswers = 0;

        // Check each answer and calculate the score
        for (Answer answer : answers) {
            // Extract questionId and selectedOption from answer object
            int questionId = answer.getQuestionId();
            int selectedOption = answer.getSelectedOption();

            // Find the question object from the list of questions
            Question question = questions.stream().filter(q -> q.getId().equals(questionId)).findFirst().orElse(null);
            // Check if the selected option is correct
            if (question != null && question.getCorrectOption().equals(selectedOption)) {
                correctAnswers++;
            }
        }
        Double finalScore = (double) Math.round((correctAnswers * 100.00) / totalQuestions);
        Score score = new Score();
        score.setTotalQuestions(totalQuestions);
        score.setCorrectAnswers(correctAnswers);
        score.setScore(finalScore);
        score.setIncorrectAnswers(totalQuestions - correctAnswers);
        return score;
    }

}
