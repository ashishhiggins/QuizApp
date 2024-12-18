package dev.ashishhiggins.quizapp.service;

import dev.ashishhiggins.quizapp.entity.Question;
import dev.ashishhiggins.quizapp.entity.QuizSession;
import dev.ashishhiggins.quizapp.repository.QuestionRepository;
import dev.ashishhiggins.quizapp.repository.QuizSessionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class QuizService {

    private final QuestionRepository questionRepository;
    private final QuizSessionRepository quizSessionRepository;

    public QuizService(QuestionRepository questionRepository, QuizSessionRepository quizSessionRepository) {
        this.questionRepository = questionRepository;
        this.quizSessionRepository = quizSessionRepository;
    }

    // Start a new quiz session for a user
    @Transactional
    public void startQuiz(Long userId) {
        // Initialize the quiz session for the user (clear previous attempts if needed)
        quizSessionRepository.deleteAllByUserId(userId);  // Clears previous quiz history
    }

    // Get a random question
    public Question getRandomQuestion() {
        List<Question> questions = questionRepository.findAll();
        Random rand = new Random();
        return questions.get(rand.nextInt(questions.size()));
    }

    // Submit an answer and track the result
    public void submitAnswer(Long userId, Long questionId, String answer) {
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);
        if (optionalQuestion.isEmpty()) {
            throw new RuntimeException("Question not found");
        }

        Question question = optionalQuestion.get();
        boolean correct = question.getCorrectOption().equalsIgnoreCase(answer);

        QuizSession session = new QuizSession();
        session.setUserId(userId);
        session.setQuestionId(questionId);
        session.setCorrect(correct);
        quizSessionRepository.save(session);
    }

    // Get a user's quiz session summary
    public List<QuizSession> getQuizSummary(Long userId) {
        return quizSessionRepository.findByUserId(userId);
    }
}