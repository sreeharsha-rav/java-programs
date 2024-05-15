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

- Java 17
- Spring Boot 3.2.5
- MongoDB
- MySQL
- Docker
- Keycloak
- Swagger UI, Springdoc OpenAPI

## How to Run

1. Clone the repository
   - Go to the `e-commerce-app` directory

2. Setup databases:
    - MongoDB:
      - Create a database named `ecommerce_db`, and a collection named `product`
      - Setup MongoDB connection in `application.yml` file in the `product-service` module
    - MySQL:
      - Create a database named `ecommerce_db`
      - Setup MySQL connection in `application.yml` file in the `order-service` module
      - Run the SQL script `order-service/src/main/resources/schema.sql` to create the required tables
      - Run the SQL script `order-service/src/main/resources/data.sql` to insert some sample data
      - Setup MySQL connection in `application.yml` file in the `inventory-service` module
      - Run the SQL script `inventory-service/src/main/resources/schema.sql` to create the required tables
      
3. Setup Keycloak:
    - Download and run Keycloak
    - Run docker yml file `docker-compose up -d` in `api-gateway` module
    - Access Keycloak admin console at `http://localhost:8181`
      - Use credentials mentioned in `docker-compose.yml` file
    - Create a realm named `e-commerce-app`
    - Create a client named `e-commerce-client`
    - Create a user and assign the user to the client
    - Update the `application.yml` file in the `api-gateway` module with the Keycloak configuration

4. Run the microservices:
    - Run the `EurekaServerApplication` class in the `eureka-server` module
    - Run the `ProductServiceApplication` class in the `product-service` module
    - Run the `OrderServiceApplication` class in the `order-service` module
    - Run the `InventoryServiceApplication` class in the `inventory-service` module
    - Run the `ApiGatewayApplication` class in the `api-gateway` module

5. Access the services API documentation:
    - `http://localhost:9000/swagger-ui.html`
   