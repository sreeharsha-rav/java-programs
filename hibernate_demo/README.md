# Hibernate Demo

This project demonstrates the functionality of Hibernate in Java. It includes implementations for CRUD operations on two entities: Book and Employee.

## Prerequisites

Before running the code, make sure you have the following:

- Java Development Kit (JDK) installed
- MySQL database server installed and running

## Getting Started

1. Clone this repository to your local machine. Go to the project directory.
2. Open the project in your favorite Java IDE.
3. Update the database connection details  and provide mapping configuration in the `hibernate.cfg.xml` file.
4. Run the `App.java` file to execute the demo in relevant package.

## Functionality

### Book CRUD - bookPkg

- Uses xml based mapping. Please refer to `Book.hbm.xml` file under `bookPkg.entity` for mapping details.
- Files:
  - `Book.java` - Entity class in `bookPkg.entity`
  - `Book.hbm.xml` - Mapping file in `bookPkg.entity`
  - `BookDao.java` - Data access object in `bookPkg.dao`
  - `BookDaoImpl.java` - Data access object implementation in `bookPkg.dao`
  - `App.java` - Main class in `bookPkg.client`
- Functions:
  - Create a new book
  - Retrieve a book by ID
  - Update a book's details
  - Delete a book

### Employee CRUD - empPkg

- Uses annotation based mapping. Please refer to `Employee.java` file under `empPkg.entity` for mapping details.
- Files:
  - `Employee.java` - Entity class in `empPkg.entity`
  - `EmployeeDao.java` - Data access object in `empPkg.dao`
  - `EmployeeDaoImpl.java` - Data access object implementation in `empPkg.dao`
  - `App.java` - Main class in `empPkg.client`
- Functions:
  - Create a new employee
  - Retrieve an employee by ID
  - Update an employee's details
  - Delete an employee

## Usage

To use the JDBC functionality in your own project, follow these steps:

1. Add in dependencies to your maven project in the `pom.xml` file.
    ```xml
    <dependencies>
        <!-- Hibernate -->
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-core</artifactId>
            <version>6.2.0.Final</version>
        </dependency>
        <!-- MySQL -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.21</version>
        </dependency>
        <!-- JUnit -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.11</version>
            <scope>test</scope>
        </dependency>
        <!-- Log4j -->
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.17</version>
        </dependency>
        <!-- slf4j-log4j12 -->
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-log4j12</artifactId>
            <version>1.7.16</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
    ```
2. Copy the `hibernate.cfg.xml` file to your project.
3. Update the database connection details in the `hibernate.cfg.xml` file.
4. Implement the necessary CRUD operations for your entity.

## License

This project is licensed under the [MIT License](LICENSE).