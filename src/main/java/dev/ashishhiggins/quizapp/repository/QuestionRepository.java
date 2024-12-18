package dev.ashishhiggins.quizapp.repository;

import dev.ashishhiggins.quizapp.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    default Question findRandomQuestion() {
        List<Question> questions = findAll();
        Random random = new Random();
        return questions.get(random.nextInt(questions.size()));  // Select random question from the list
    }
}
