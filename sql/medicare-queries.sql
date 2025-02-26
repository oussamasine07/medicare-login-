CREATE DATABASE medicare_login;
USE medicare_login;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fullName VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    role ENUM("doctor", "patient") NOT NULL
);

CREATE TABLE doctors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    specialty VARCHAR(255) NULL,
    phone VARCHAR(255) NULL,
    address VARCHAR(255) NULL,
    FOREIGN KEY(user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE patients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    phone VARCHAR(255) NULL,
    address VARCHAR(255) NULL,
    FOREIGN KEY(user_id) REFERENCES users(id) ON DELETE CASCADE
);