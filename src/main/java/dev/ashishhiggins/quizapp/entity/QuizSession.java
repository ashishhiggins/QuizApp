package dev.ashishhiggins.quizapp.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Schema(description = "Represents a quiz session record, storing a user's responses and whether they were correct")
public class QuizSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the quiz session", example = "1")
    private Long id;

    @Column(name = "user_id", nullable = false)
    @Schema(description = "The ID of the user participating in the quiz", example = "12345")
    private Long userId;

    @Column(name = "question_id", nullable = false)
    @Schema(description = "The ID of the question that was answered", example = "1")
    private Long questionId;

    @Column(nullable = false)
    @Schema(description = "Indicates whether the user's answer was correct", example = "true")
    private boolean correct;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    @Override
    public String toString() {
        return "QuizSession{" +
                "id=" + id +
                ", userId=" + userId +
                ", questionId=" + questionId +
                ", correct=" + correct +
                '}';
    }
}