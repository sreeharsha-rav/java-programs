# SpringBoot Demo

This project demonstrates the functionality of Spring Boot in Java. It includes implementations for CRUD operations on models like `Book`.

## Prerequisites

Before running the code, make sure you have the following:

- Java Development Kit (JDK) installed
- Spring Boot installed
    - Spring Web
    - Spring Data JPA
    - H2 Database
    - Lombok
- Maven installed
- An IDE like IntelliJ IDEA or Eclipse
- Postman or any other API testing tool

## Getting Started

1. Clone this repository to your local machine. Go to the project directory.
2. Open the project in your favorite Java IDE.
3. Run the `SpringBootDemoApplication.java` file to start the application.
4. Access the application at `http://localhost:8080`.
5. Use Postman or any other API testing tool to test the endpoints.

## Functionality

The Spring Boot Demo app has the following functionality:

- Display a list of books to the user.
- Get a book by ID.
- Add a book to the database.
- Update book details.
- Delete books from the database.

### Database Schema

Books Table

| Column | Type | Constraints |
| --- | --- | --- |
| id | INT | AUTO_INCREMENT, PRIMARY KEY |
| title | VARCHAR(255) | NOT NULL |
| author | VARCHAR(255) | NOT NULL |
| price | DOUBLE | NOT NULL |

### API Endpoints

The Spring Boot Demo app exposes the following API endpoints:

- `GET /api/books/`: Get all books.
- `GET /api/books/{id}`: Get a book by ID.
- `POST /api/books/`: Add a new book.
- `PUT /api/books/{id}`: Update a book by ID.
- `DELETE /api/books/{id}`: Delete a book by ID.