DROP TABLE IF EXISTS recipes;
CREATE TABLE recipes (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    description TEXT,
    imageUrl VARCHAR(255)
);