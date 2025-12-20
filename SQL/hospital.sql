-- Database creation
CREATE DATABASE IF NOT EXISTS hospital;
USE hospital;

-- =========================
-- PATIENT TABLE
-- =========================
CREATE TABLE IF NOT EXISTS patient (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    gender VARCHAR(10)
);

-- =========================
-- LAB REQUESTS TABLE
-- =========================
CREATE TABLE IF NOT EXISTS lab_requests (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT,
    doctor VARCHAR(100),
    test_type VARCHAR(100),
    result VARCHAR(255),
    status VARCHAR(20),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- =========================
-- RADIOLOGY REQUESTS TABLE
-- =========================
CREATE TABLE IF NOT EXISTS radiology_requests (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT,
    doctor VARCHAR(100),
    scan_type VARCHAR(100),
    findings VARCHAR(255),
    status VARCHAR(20),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- =========================
-- TELEMEDICINE SESSIONS
-- =========================
CREATE TABLE IF NOT EXISTS telemedicine_sessions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    doctor VARCHAR(100),
    patient VARCHAR(100),
    session_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
