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

SELECT * FROM users
WHERE email = ?;

CREATE TABLE appointments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT NOT NULL,
    doctor_id INT NOT NULL,
    appDate DATE NOT NULL,
    appTime TIME NOT NULL,
    motif VARCHAR(255) NOT NULL,
    is_canceled BOOLEAN NOT NULL DEFAULT FALSE,
    is_done BOOLEAN NOT NULL DEFAULT FALSE,
    FOREIGN KEY(patient_id) REFERENCES patients(id) ON DELETE CASCADE,
    FOREIGN KEY(doctor_id) REFERENCES doctors(id) ON DELETE CASCADE
);

SELECT * FROM doctors
WHERE id = ?;

-- select appointments by patient id
SELECT * FROM appointments
WHERE patient_id = ?;

-- select appointments by doctor id
SELECT * FROM appointments
WHERE doctor_id = ?;

INSERT INTO appointments
    ( patient_id, doctor_id, appDate, appTime, motif )
VALUES
    (2, 7, "2025-11-21", "12:00:00", "this is test motif");






















