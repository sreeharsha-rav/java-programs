# Quiz Monolithic

This is a monolithic version of the Quiz app. It is a simple quiz app that allows users to answer questions and get a score at the end.

## Prerequisites

Before running the code, make sure you have the following:

- Java Development Kit (JDK) installed
- Spring Boot installed
    - Spring Web
    - Spring Data JPA
    - H2 Database
- Maven installed
- An IDE like IntelliJ IDEA or Eclipse

## Getting Started

1. Clone this repository to your local machine. Go to the project directory.
2. Open the project in your favorite Java IDE.
3. Run the `QuizApplication.java` file to start the application.

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