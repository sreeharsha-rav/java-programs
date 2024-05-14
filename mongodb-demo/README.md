# MongoDB Spring Boot Example

This is a simple example of how to use MongoDB with Spring Boot.

## Software Requirements

- Java 17
- Spring Boot 3.2.5
- Spring Web
- Spring Data MongoDB
- Test Containers
- Maven 4.0.0
- MongoDB 7.0.9

## How to Run

1. Clone this repository
2. Setup MongoDB locally using MongoDB Compass and create a database called `expense_tracker` and a collection called `expenses`.
3. Run the following command:

```shell
mvn clean install
```

4. Run the following command:

```shell
mvn spring-boot:run
```

5. Test the endpoints using Postman or any other tool. Please refer to the [`MongoDB Demo.postman_collection.json`](./MongoDB%20Demo.postman_collection.json) file to see the available endpoints.