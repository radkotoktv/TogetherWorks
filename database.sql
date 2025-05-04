CREATE DATABASE IF NOT EXISTS together_works;
USE together_works;

CREATE TABLE sponsors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    amount INT
);

CREATE TABLE projects (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    owner VARCHAR(255),
    money_needed INT,
    start_date DATE NOT NULL,
    end_date DATE,
    sponsor INT,
    FOREIGN KEY (sponsor) REFERENCES sponsors(id)
);

CREATE TABLE volunteers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    gender ENUM('male', 'female', 'other') NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    project_id INT,
    FOREIGN KEY (project_id) REFERENCES projects(id)
);

CREATE TABLE preferences (
    volunteer_id INT,
    preference VARCHAR(255),
    PRIMARY KEY (volunteer_id, preference),
    FOREIGN KEY (volunteer_id) REFERENCES volunteers(id)
);

CREATE TABLE resources (
    id INT AUTO_INCREMENT PRIMARY KEY,
    type ENUM('equipment', 'material', 'tool', 'other') NOT NULL, -- To be changed
    quantity INT NOT NULL,
    project_id INT,
    FOREIGN KEY (project_id) REFERENCES projects(id)
);

CREATE TABLE posts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    author VARCHAR(255),
    date CHAR(10),
    description CHAR(255)
);

CREATE TABLE comments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    post_id INT,
    text VARCHAR(500),
    author VARCHAR(255),
    date DATE,
    parent_id INT,
    FOREIGN KEY (post_id) REFERENCES posts(id),
    FOREIGN KEY (parent_id) REFERENCES comments(id)
);
