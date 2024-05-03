package org.demo.quizservice.service;

import org.demo.quizservice.dto.*;
import org.demo.quizservice.entity.Quiz;
import org.demo.quizservice.feign.QuestionClient;
import org.demo.quizservice.repository.QuizRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
 * This class represents the implementation of the QuizService interface
 * createQuiz: creates a quiz
 * getQuiz: get a quiz based on id
 * submitQuiz: submit quiz with answers to get a score
 */
@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionClient questionClient;

    @Override
    public Quiz createQuiz(QuizRequest quizRequest) {
        String category = quizRequest.getCategory();
        Integer questionCount = quizRequest.getQuestionCount();
        List<Integer> questionIds = (List<Integer>) questionClient.generateQuestions(questionCount, category).getBody();

        Quiz quiz = new Quiz();
        quiz.setQuizTitle(quizRequest.getQuizTitle());
        quiz.setQuestionIds(questionIds);

        Quiz savedQuiz = quizRepository.save(quiz);

        return savedQuiz;
    }

    @Override
    public QuizResponse getQuiz(Integer quizId) {
        Optional<Quiz> quiz = quizRepository.findById(quizId);
        if (quiz.isPresent()) {
            // Create a QuizResponse object
            QuizResponse quizResponse = new QuizResponse();
            quizResponse.setId(quiz.get().getId());
            quizResponse.setQuizTitle(quiz.get().getQuizTitle());
            // Get the questions for the quiz
            List<Integer> questionIds = quiz.get().getQuestionIds();
            List<QuestionResponse> questions = (List<QuestionResponse>) questionClient.getQuestionsByIds(questionIds).getBody();
            quizResponse.setQuestions(questions);

            return quizResponse;
        } else {
            return null;
        }
    }

    @Override
    public QuizScore submitQuiz(Integer quizId, List<Answer> answers) {
        Optional<Quiz> quiz = quizRepository.findById(quizId);
        if (quiz.isPresent()) {
            List<Integer> questionIds = quiz.get().getQuestionIds();
            int totalQuestions = questionIds.size();

            // Get score from question client
            Score score = (Score) questionClient.getScore(answers).getBody();

            // Create a QuizScore object
            QuizScore quizScore = new QuizScore();
            quizScore.setQuizId(quizId);
            quizScore.setTotalQuestions(totalQuestions);
            quizScore.setCorrectAnswers(score.getCorrectAnswers());
            quizScore.setScore(score.getScore());
            quizScore.setIncorrectAnswers(score.getIncorrectAnswers());

            return quizScore;

        } else {
            return null;
        }
    }

}
