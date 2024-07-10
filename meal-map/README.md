# MealMap

MealMap is a recipe platform to create, discover, and share recipes. The app allows users to search for recipes, save their favorite recipes, and create a personalized meal plan. 
The app leverages Spring Webflux on the backend to provide a reactive and scalable API.

## Description

MealMap allows users to search, filter, and discover a wide variety of recipes. Users can also save their favorite recipes and create a personalized meal plan. 
The app leverages Spring Webflux on the backend to provide a reactive and scalable API.

- **Backend:** Spring Boot, Spring Webflux, Java
- **Database:** PostgreSQL, MongoDB

## Data Model

### User

| Field           | Type                | Description                  |
|-----------------|---------------------|------------------------------|
| id              | String              | Unique identifier            |
| username        | String              | User's name                  |
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
