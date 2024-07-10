DROP TABLE IF EXISTS users;
CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  username VARCHAR(100) NOT NULL,
  password VARCHAR(100) NOT NULL,
  favorite_recipes JSONB DEFAULT '[]'::jsonb,
  meal_plan_ids INTEGER[] DEFAULT '{}',
  CONSTRAINT unique_username
      UNIQUE (username)
);
-- Add a relationship between the meal_plans and users tables,
-- So that each meal plan is associated with a user.
-- A user can have multiple meal plans, but a meal plan can only belong to one user.

DROP TABLE IF EXISTS meal_plans;
CREATE TABLE meal_plans (
  id SERIAL PRIMARY KEY,
  user_id INTEGER NOT NULL,
  name VARCHAR(255) NOT NULL,
  description TEXT,
  recipe_ids TEXT[] DEFAULT '{}',
  CONSTRAINT fk_user
      FOREIGN KEY (user_id)
      REFERENCES users(id)
);