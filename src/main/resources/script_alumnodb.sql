-- Eliminar la base de datos si existe y volver a crearla
DROP DATABASE IF EXISTS alumnosdb;
CREATE DATABASE alumnosdb;
USE alumnosdb;

-- Eliminar la tabla usuarios si existe y volver a crearla
DROP TABLE IF EXISTS usuarios;
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- Eliminar la tabla alumnos si existe y volver a crearla
DROP TABLE IF EXISTS alumnos;
CREATE TABLE alumnos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);

-- Insertar 10 registros en la tabla usuarios
INSERT INTO usuarios (username, password) VALUES 
('jdoe', 'pass123'),
('asmith', 'secure456'),
('mgarcia', 'clave789'),
('lmartinez', '123abc'),
('rrodriguez', 'xyz987'),
('bperez', 'qwerty123'),
('nlopez', 'letmein'),
('gfernandez', 'admin123'),
('esanchez', 'password'),
('dcampos', '654321');

-- Insertar 10 registros en la tabla alumnos
INSERT INTO alumnos (name, email) VALUES 
('Juan Pérez', 'juan.perez@email.com'),
('María García', 'maria.garcia@email.com'),
('Carlos López', 'carlos.lopez@email.com'),
('Ana Martínez', 'ana.martinez@email.com'),
('Luis Fernández', 'luis.fernandez@email.com'),
('Sofía Ramírez', 'sofia.ramirez@email.com'),
('Ricardo Gómez', 'ricardo.gomez@email.com'),
('Elena Sánchez', 'elena.sanchez@email.com'),
('David Torres', 'david.torres@email.com'),
('Laura Jiménez', 'laura.jimenez@email.com');

-- Query para actualizar la contraseña de un usuario
UPDATE usuarios SET password = 'newpassword123' WHERE id = 1;

-- Query para actualizar el email de un alumno
UPDATE alumnos SET email = 'nuevo.email@email.com' WHERE id = 2;

-- Query para eliminar un usuario por su ID
DELETE FROM usuarios WHERE id = 10;

-- Query para eliminar un alumno por su ID
DELETE FROM alumnos WHERE id = 5;
