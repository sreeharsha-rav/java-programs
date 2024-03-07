# JDBC Demo

This project demonstrates the functionality of JDBC in Java. It includes implementations for CRUD operations on two entities: Book and Employee.

## Prerequisites

Before running the code, make sure you have the following:

- Java Development Kit (JDK) installed
- MySQL database server installed and running
- MySQL Connector-Java library added to your project

## Getting Started

1. Clone this repository to your local machine. Go to the project directory.
2. Open the project in your favorite Java IDE.
3. Update the database connection details in the `MyConnection.Java` file.
4. Run the `Main.java` file to execute the demo.

## Functionality

### Book CRUD

- Create a new book
- Retrieve a book by ID
- Update a book's details
- Delete a book

### Employee CRUD

- Create a new employee
- Retrieve an employee by ID
- Update an employee's details
- Delete an employee

## Usage

To use the JDBC functionality in your own project, follow these steps:

1. Add in dependencies to your maven project in the `pom.xml` file.
    ```xml
    <dependencies>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.23</version>
        </dependency>
    </dependencies>
    ```
2. Copy the `MyConnection.java` file to your project.
3. Update the database connection details in the `MyConnection.java` file.
4. Implement the necessary CRUD operations for your entity.

## License

This project is licensed under the [MIT License](LICENSE).