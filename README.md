# QuizApp - Spring Boot Quiz Application

This project implements a simple quiz application using Spring Boot. Users can take quizzes by starting a new session, answering randomly generated questions, and reviewing their results.

## Features

*   Start a new quiz session for a user
*   Answer randomly generated questions
*   Submit answers and receive feedback (correct/incorrect)
*   Review quiz session summary (answered questions and results)

## Technologies Used

*   Spring Boot
*   Spring Data JPA
*   Spring Web MVC
*   Swagger Open API (documentation)
*   H2 Database (in-memory database for development)


## Running the application

You can run the application using Maven

### Running with Maven

1.  Ensure you have Java 21.
2.  Clone or download the project.
3.  Open a terminal in the project directory.
4.  Run `mvn clean install` to build the application.
5.  Run `mvn spring-boot:run` to start the application.

The application will be available on port `8080` by default. You can access the Swagger documentation at `http://localhost:8080/swagger-ui/`.


## API Documentation and Sample Responses

The application uses Swagger Open API to provide interactive documentation for the available API endpoints. You can access the documentation at `http://localhost:8080/swagger-ui/`.

Here are some sample responses for the REST APIs:

*   **POST /api/quiz/start/{userId}** - Start a quiz

    *   Request:
        ```
        /api/quiz/start/123
        ```
    *   Response (200 OK):
        ```
        Quiz started for user ID 123
        ```

*   **GET /api/quiz/question** - Get a random question

    *   Response (200 OK):
        ```json
        {
          "id": 1,
          "text": "What is the capital of France?",
          "optionA": "Paris",
          "optionB": "London",
          "optionC": "Berlin",
          "optionD": "Madrid",
          "correctOption": "A"
        }
        ```

*   **POST /api/quiz/submit/{userId}?questionId={questionId}&answer={answer}** - Submit an answer

    *   Request:
        ```
        /api/quiz/submit/123?questionId=1&answer=A
        ```
    *   Response (200 OK):
        ```
        Answer submitted for user ID 123
        ```

*   **GET /api/quiz/summary/{userId}** - Get quiz summary

    *   Request:
        ```
        /api/quiz/summary/123
        ```
    *   Response (200 OK) - Example with one correct and one incorrect answer:
        ```json
        [
          {
            "id": 1,
            "userId": 123,
            "questionId": 1,
            "correct": true
          },
          {
            "id": 2,
            "userId": 123,
            "questionId": 2,
            "correct": false
          }
        ]
        ```

## Sample Data

The application comes with some sample questions pre-loaded into the database. You can add or modify these questions using your preferred database management tool.

## Building the project

You can build the project using Maven. The following commands are useful:

*   `mvn clean`: Cleans the project.
*   `mvn install`: Builds the project and creates a JAR file in the `target` directory.
*   `mvn spring-boot:run`: Runs the application in development mode.


sample testcases:

<img width="1048" alt="image" src="https://github.com/user-attachments/assets/6e5411ff-7a0f-4d6d-8b11-af8c787e6a11" />

<img width="1022" alt="image" src="https://github.com/user-attachments/assets/c570b328-d39b-467e-a0d3-69bfdd811169" />

<img width="1034" alt="image" src="https://github.com/user-attachments/assets/e71005c1-0733-4de4-99e9-6d65efa0916e" />

<img width="1022" alt="image" src="https://github.com/user-attachments/assets/df64ae92-f3ff-479c-bc06-b0e97242d9e1" />



