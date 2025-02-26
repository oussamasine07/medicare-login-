CREATE DATABASE medicare_login;
USE medicare_login;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fullName VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role ENUM("doctor", "patient") NOT NULL
);

INSERT INTO uers
    (fullName, email, password, role)
VALUES
    (?, ?, ?);

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