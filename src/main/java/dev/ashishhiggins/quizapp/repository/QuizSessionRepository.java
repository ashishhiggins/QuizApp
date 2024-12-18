package dev.ashishhiggins.quizapp.repository;

import dev.ashishhiggins.quizapp.entity.QuizSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface QuizSessionRepository extends JpaRepository<QuizSession, Long> {
    List<QuizSession> findByUserId(Long userId);

    void deleteAllByUserId(Long userId);  }
