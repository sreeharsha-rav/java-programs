# MealMap

[![Version](https://img.shields.io/badge/version-0.1.0-blue.svg)](https://github.com/sreeharsha-rav/typescript-projects/tree/mealmap)
[![Latest Update](https://img.shields.io/badge/latest%20update-July%202024-blue.svg)]()

MealMap is a recipe discovery app designed to help you find delicious recipes based on your preferences and ingredients.

Current development roadmap:
- [x] Setup the project structure
- [] Implement user authentication
- [] Add recipe search and filtering
- [] Create meal plans

## Description

MealMap allows users to search, filter, and discover a wide variety of recipes. Users can also save their favorite recipes and create a personalized meal plan. The app leverages Fastify for the backend, Prisma as the ORM, and MongoDB for data storage, with TypeScript ensuring robust and maintainable code.

## Features

- Search for recipes by ingredients, cuisine, and dietary preferences
- Save and manage favorite recipes
- Create and customize meal plans
- User authentication and profile management
- Responsive design for a seamless experience across devices

## Technologies

- **Frontend:** Next.js, TypeScript, Tailwind CSS
- **Backend:** Spring Boot, Spring Webflux, Java, Fastify
- **Database:** PostgreSQL, MongoDB
- **ORM:** Prisma, Mongoose
- **Others:** Docker, Git, Jenkins, AWS

## Data Model

### User

| Field           | Type                | Description                  |
|-----------------|---------------------|------------------------------|
| id              | String              | Unique identifier            |
| username        | String              | User's name                  |
| email           | String              | User's email address         |
| password        | String              | User's password (hashed)     |
| favorites       | Array of Recipe IDs | List of user's favorite recipes |
| mealPlans       | Array of Meal Plan IDs | List of user's meal plans |

### Recipe

| Field           | Type                | Description                  |
|-----------------|---------------------|------------------------------|
| id              | String              | Unique identifier            |
| name            | String              | Name of the recipe           |
| imageUrl        | String              | URL of the recipe image      |
| ingredients     | Array of Objects    | List of ingredients          |
| instructions    | String              | Step-by-step instructions    |

### Meal Plan

| Field           | Type                | Description                  |
|-----------------|---------------------|------------------------------|
| id              | String              | Unique identifier            |
| userId          | String              | ID of the user who created the meal plan |
| name            | String              | Name of the meal plan        |
| recipes         | Array of Recipe IDs | List of recipes in the meal plan |

## API Endpoints

### User Endpoints

| Method | Endpoint              | Description           |
|--------|-----------------------|-----------------------|
| POST   | /api/users            | Register a new user    |
| POST   | /api/users/login      | User login             |
| GET    | /api/users/:id        | Get user details       |
| PUT    | /api/users/:id        | Update user details    |
| DELETE | /api/users/:id        | Delete user account    |

### Recipe Endpoints

| Method | Endpoint              | Description           |
|--------|-----------------------|-----------------------|
| GET    | /api/recipes          | Get all recipes        |
| GET    | /api/recipes/:id      | Get recipe by ID       |
| POST   | /api/recipes          | Add a new recipe       |
| PUT    | /api/recipes/:id      | Update a recipe        |
| DELETE | /api/recipes/:id      | Delete a recipe        |

### Meal Plan Endpoints

| Method | Endpoint              | Description           |
|--------|-----------------------|-----------------------|
| GET    | /api/mealplans        | Get all meal plans     |
| GET    | /api/mealplans/:id    | Get meal plan by ID    |
| POST   | /api/mealplans        | Create a new meal plan |
| PUT    | /api/mealplans/:id    | Update a meal plan     |
| DELETE | /api/mealplans/:id    | Delete a meal plan     |

## Installation

### Setup


### Testing


### Docker

Access the API at http://localhost:3000.

## API Usage Examples

View all the api usage examples and test cases here: [Postman](https://www.postman.com/sreeharsha-rav/workspace/typescript-apps/collection/28103794-5532ef74-0ec3-4a93-ac67-86f9a03cfc4e?action=share&creator=28103794).

## Future Enhancements

[] Add further details to the Recipe model, such as cooking time and difficulty level
[] Add search and filtering functionality for recipes
[] Implement AI-based recipe recommendations based on user preferences
[] Integrate with third-party APIs for additional recipe data
[] Add ratings and reviews for recipes
[] Implement meal plan sharing and collaboration features