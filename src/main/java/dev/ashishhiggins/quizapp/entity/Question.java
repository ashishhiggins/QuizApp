package dev.ashishhiggins.quizapp.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Schema(description = "Represents a quiz question in the system")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the question", example = "1")
    private Long id;

    @Column(nullable = false)
    @Schema(description = "The text of the question", example = "What is the capital of France?")
    private String text;

    @Column(name = "option_a", nullable = false)
    @Schema(description = "Option A for the question", example = "Paris")
    private String optionA;

    @Column(name = "option_b", nullable = false)
    @Schema(description = "Option B for the question", example = "London")
    private String optionB;

    @Column(name = "option_c", nullable = false)
    @Schema(description = "Option C for the question", example = "Berlin")
    private String optionC;

    @Column(name = "option_d", nullable = false)
    @Schema(description = "Option D for the question", example = "Madrid")
    private String optionD;

    @Column(name = "correct_option", nullable = false)
    @Schema(description = "The correct answer option (A, B, C, D)", example = "A")
    private String correctOption;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(String correctOption) {
        this.correctOption = correctOption;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", optionA='" + optionA + '\'' +
                ", optionB='" + optionB + '\'' +
                ", optionC='" + optionC + '\'' +
                ", optionD='" + optionD + '\'' +
                ", correctOption='" + correctOption + '\'' +
                '}';
    }
}