# Quiz Microservice

This is a micrservice version of the Quiz app. It is a simple quiz app that allows users to answer questions and get a score at the end.

## Prerequisites

Before running the code, make sure you have the following:

- Java Development Kit (JDK) installed
- Spring Boot installed
    - Spring Web
    - Spring Data JPA
    - MySQL Driver
    - Reactive Gateway
    - Eureka Discovery Client
    - Eureka Server
    - Lombok
- Maven installed
- MySQL installed
- An IDE like IntelliJ IDEA or Eclipse
- Postman or any other API testing tool

## Getting Started

1. Clone this repository to your local machine. Go to the project directory.
2. Open the project in your favorite Java IDE.
3. Run the applications in the following order:
    - `EurekaServerApplication.java` (Eureka Server) [Port: 8761]
    - `QuestionServiceApplication.java` (Question Service) [Port: 8010]
    - `QuizServiceApplication.java` (Quiz Service) [Port: 8020]
    - `ApiGatewayApplication.java` (API Gateway) [Port: 8100]
4. Access the API Gateway at `http://localhost:8100`.
5. Use Postman or any other API testing tool to test the endpoints.
    - Refer to the API documentation [here].(quiz-microservice-demo/Quiz microservices.postman_collection.json).

## Functionality

The Quiz app has the following functionality:

- Display a list of questions to the user.
- Add questions to the database.
- Allow the user to select an answer for each question.
- Calculate the score based on the user's answers.
- Display the final score to the user.

### API Endpoints

The Quiz app exposes the following API endpoints:

- `GET /questions`: Get all questions.
- `POST /questions`: Add a new question.
- `GET /questions/category/{category}`: Get questions by category.
- `POST /quiz/create`: Create a new quiz.
- `POST /quiz/{id}/submit`: Submit a quiz.
- `GET /quiz/{id}`: Get a quiz by ID.
