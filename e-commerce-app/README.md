# E-Commerce Microservices

## Description

This project is a simple e-commerce application that is built using microservices architecture. The application is built using Spring Boot, Spring Cloud, Spring Data, and Spring Security. The application is divided into multiple microservices, each of which is responsible for a specific functionality. The microservices communicate with each other using REST APIs. The application provides the following functionalities:

1. Authentication and Authorization using JWT.
2. Product catalog.
3. Order management.
4. Inventory management.
5. Notification service.

There is also a gateway service that acts as an entry point to the application.

### Architecture


### Microservices

- **Product Service**: Create and manage products, acts as a product catalog.
- **Order Service**: Can order products.
- **Inventory Service**: Check the availability of products in the inventory.
- **Notification Service**: Send notifications after an order is placed.

## Technologies Used

- Java 21
- Spring Boot 3.2.5
- MongoDB
- MySQL

## How to Run

1. Clone the repository