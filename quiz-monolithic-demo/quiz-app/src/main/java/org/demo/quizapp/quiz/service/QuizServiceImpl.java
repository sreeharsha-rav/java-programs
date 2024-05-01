package org.demo.quizapp.quiz.service;

import org.demo.quizapp.question.dto.QuestionResponse;
import org.demo.quizapp.question.entity.Question;
import org.demo.quizapp.question.repository.QuestionRepository;
import org.demo.quizapp.quiz.dto.Answer;
import org.demo.quizapp.quiz.dto.QuizRequest;
import org.demo.quizapp.quiz.dto.QuizResponse;
import org.demo.quizapp.quiz.dto.QuizScore;
import org.demo.quizapp.quiz.entity.Quiz;
import org.demo.quizapp.quiz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
 * This class is a service class for Quiz Service.
 * createQuiz: method to create a quiz
 * getQuiz: method to get a quiz
 * submitQuiz: method to submit a quiz
 */
@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Quiz createQuiz(QuizRequest quizRequest) {
        String category = quizRequest.getCategory();
        Integer questionCount = quizRequest.getQuestionCount();
        List<Question> questions = questionRepository.findRandomQuestionsByCategory(category, questionCount);

        Quiz quiz = new Quiz();
        quiz.setQuizTitle(quizRequest.getQuizTitle());
        quiz.setQuestions(questions);
        Quiz savedQuiz = quizRepository.save(quiz);
        return savedQuiz;
    }

    @Override
    public QuizResponse getQuiz(Integer quizId) {
        Optional<Quiz> quiz = quizRepository.findById(quizId);
        if (quiz.isPresent()) {
            List<Question> questions = quiz.get().getQuestions();
            List<QuestionResponse> questionResponses = new ArrayList<>();
            for (Question question : questions) {
                QuestionResponse questionResponse = new QuestionResponse();
                questionResponse.setId(question.getId());
                questionResponse.setQuestionTitle(question.getQuestionTitle());
                questionResponse.setOption1(question.getOption1());
                questionResponse.setOption2(question.getOption2());
                questionResponse.setOption3(question.getOption3());
                questionResponse.setOption4(question.getOption4());

                questionResponses.add(questionResponse);
            }
            QuizResponse quizResponse = new QuizResponse();
            quizResponse.setId(quiz.get().getId());
            quizResponse.setQuizTitle(quiz.get().getQuizTitle());
            quizResponse.setQuestions(questionResponses);

            return quizResponse;
        } else {
            return null;
        }
    }

    @Override
    public QuizScore submitQuiz(Integer quizId, List<Answer> answers) {
        Optional<Quiz> quiz = quizRepository.findById(quizId);
        if (quiz.isPresent()) {
            List<Question> questions = quiz.get().getQuestions();
            int totalQuestions = questions.size();
            int correctAnswers = 0;

            // Check if the number of answers submitted is equal to the number of questions in the quiz
            if (answers.size() != totalQuestions) {
                return null;
            }

            // Check each answer and calculate the score
            for (Answer answer : answers) {
                // Extract questionId and selectedOption from answer object
                Integer questionId = answer.getQuestionId();
                Integer selectedOption = answer.getSelectedOption();

                // Find the question object from the list of questions
                Question question = questions.stream().filter(q -> q.getId().equals(questionId)).findFirst().orElse(null);
                // Check if the selected option is correct
                if (question != null && question.getCorrectOption().equals(selectedOption)) {
                    correctAnswers++;
                }
            }

            // Calculate the score and limit it to 2 decimal places
            double score = (double) correctAnswers / totalQuestions * 100;
            score = Math.round(score * 100.00) / 100.00;

            QuizScore quizScore = new QuizScore();
            quizScore.setQuizId(quizId);
            quizScore.setScore(score);
            quizScore.setTotalQuestions(questions.size());
            quizScore.setCorrectAnswers(correctAnswers);
            quizScore.setIncorrectAnswers(totalQuestions - correctAnswers);

            return quizScore;

        } else {
            return null;
        }
    }

}
