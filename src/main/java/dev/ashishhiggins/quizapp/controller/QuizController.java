package dev.ashishhiggins.quizapp.controller;

import dev.ashishhiggins.quizapp.entity.Question;
import dev.ashishhiggins.quizapp.entity.QuizSession;
import dev.ashishhiggins.quizapp.service.QuizService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @Operation(summary = "Start a new quiz session for the user", description = "Starts a quiz session for the given user ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Quiz started successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid user ID")
    })
    @PostMapping("/start/{userId}")
    public ResponseEntity<String> startQuiz(@Parameter(description = "User ID for starting the quiz", required = true) @PathVariable Long userId) {
        quizService.startQuiz(userId);
        return ResponseEntity.ok("Quiz started for user ID " + userId);
    }

    @Operation(summary = "Get a random question", description = "Fetches a random question for the quiz.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Random question retrieved successfully")
    })
    @GetMapping("/question")
    public Question getQuestion() {
        return quizService.getRandomQuestion();
    }

    @Operation(summary = "Submit an answer for a specific question", description = "Validates the answer and stores the result.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Answer submitted successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid answer or question ID")
    })
    @PostMapping("/submit/{userId}")
    public ResponseEntity<String> submitAnswer(
            @Parameter(description = "User ID who is submitting the answer", required = true) @PathVariable Long userId,
            @Parameter(description = "Question ID", required = true) @RequestParam Long questionId,
            @Parameter(description = "Answer choice", required = true) @RequestParam String answer) {
        quizService.submitAnswer(userId, questionId, answer);
        return ResponseEntity.ok("Answer submitted for user ID " + userId);
    }

    @Operation(summary = "Get the summary of the quiz session for the user", description = "Retrieves the summary of the quiz session for the given user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Quiz session summary retrieved successfully")
    })
    @GetMapping("/summary/{userId}")
    public ResponseEntity<List<QuizSession>> getSummary(
            @Parameter(description = "User ID for retrieving quiz summary", required = true) @PathVariable Long userId) {
        List<QuizSession> sessions = quizService.getQuizSummary(userId);
        return ResponseEntity.ok(sessions);
    }

}