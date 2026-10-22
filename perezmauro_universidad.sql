-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 22, 2026 at 02:35 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `perezmauro_universidad`
--
CREATE DATABASE IF NOT EXISTS `perezmauro_universidad` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `perezmauro_universidad`;

-- --------------------------------------------------------

--
-- Table structure for table `alumno`
--

CREATE TABLE `alumno` (
  `idAlumno` int(11) NOT NULL,
  `dni` int(11) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `fechaNac` date NOT NULL,
  `activo` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `alumno`
--

INSERT INTO `alumno` (`idAlumno`, `dni`, `apellido`, `nombre`, `fechaNac`, `activo`) VALUES
(1, 38749011, 'Perez', 'Mauro Gabriel', '2026-10-04', 1),
(4, 123456, 'Messi', 'Lionel Andrés', '2026-10-07', 1),
(7, 35353535, 'Scaloni', 'Leonel', '2026-10-07', 1),
(10, 1245621, 'Mickey', 'Mouse', '2026-10-05', 1),
(11, 34987652, 'Alvarez', 'Julian', '2026-10-08', 1),
(12, 10101010, 'Altman', 'Sam', '2026-10-08', 1),
(13, 999999, 'Perez', 'Enzo', '2026-10-08', 1),
(18, 132545, 'Fernandez', 'Enzo', '2026-10-08', 1),
(21, 35884192, 'Lucero', 'Melisa', '2026-10-04', 1),
(22, 14595092, 'Quiroga', 'Blanca', '1962-06-08', 1),
(34, 11111, 'mengano', 'fulano', '2005-10-21', 1),
(36, 35884191, 'de melon', 'corazon', '2001-10-05', 0),
(45, 987654321, 'Otamendi', 'Nicolás', '1990-06-09', 1),
(46, 30102, 'Tinelli', 'Marcelo', '1980-10-15', 1),
(47, 1235641321, 'Esposito', 'Lali', '1991-10-10', 0),
(48, 566112165, 'Occhiato', 'Nicolas', '1992-10-14', 0),
(49, 40598466, 'Guzman', 'Francesca', '2008-02-26', 1);

-- --------------------------------------------------------

--
-- Table structure for table `cursada`
--

CREATE TABLE `cursada` (
  `idCursada` int(11) NOT NULL,
  `idAlumno` int(11) NOT NULL,
  `idMateria` int(11) NOT NULL,
  `nota` double DEFAULT NULL,
  `asist` float DEFAULT NULL,
  `anio` year(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cursada`
--

INSERT INTO `cursada` (`idCursada`, `idAlumno`, `idMateria`, `nota`, `asist`, `anio`) VALUES
(1, 4, 8, 8, 0, '2026'),
(2, 1, 4, 8, 0, '2026'),
(10, 7, 9, 0, 0, '2026'),
(17, 7, 3, 0, 0, '2026'),
(19, 7, 11, 0, 0, '2026'),
(39, 7, 2, 0, 0, '2026'),
(45, 4, 1, 0, 3.33, '2026'),
(46, 4, 13, 9.85, 0, '2026'),
(47, 1, 6, 0, 0, '2026'),
(48, 10, 14, 0, 0, '2026'),
(49, 13, 2, 4.5, 0, '2026'),
(50, 1, 5, 0, 0, '2026'),
(65, 1, 14, 10, 0, '2026'),
(67, 1, 2, 0, 0, '2026'),
(68, 18, 14, 0, 0, '2026'),
(69, 12, 2, 0, 0, '2026'),
(70, 22, 1, 0, 0, '2026'),
(71, 21, 2, 0, 0, '2026'),
(72, 46, 4, 0, 0, '2026'),
(73, 49, 11, 7.85, 0, '2026'),
(74, 4, 2, 5, 6.66, '2026');

-- --------------------------------------------------------

--
-- Table structure for table `materia`
--

CREATE TABLE `materia` (
  `idMateria` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `activo` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `materia`
--

INSERT INTO `materia` (`idMateria`, `nombre`, `activo`) VALUES
(1, 'Inglés', 1),
(2, 'Programación 3', 1),
(3, 'Administración de BD', 1),
(4, 'Web 1', 1),
(5, 'Algebra Lineal', 1),
(6, 'Fundamentos de IA', 1),
(7, 'Programacion web 2', 1),
(8, 'Ingles 2', 1),
(9, 'Laboratorio 1', 1),
(11, 'laboratorio 2', 1),
(13, 'ingles 3', 1),
(14, 'Ing. de Software 1', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`idAlumno`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indexes for table `cursada`
--
ALTER TABLE `cursada`
  ADD PRIMARY KEY (`idCursada`),
  ADD UNIQUE KEY `anio` (`idAlumno`,`idMateria`,`anio`),
  ADD KEY `idAlumno` (`idAlumno`,`idMateria`),
  ADD KEY `idMateria` (`idMateria`);

--
-- Indexes for table `materia`
--
ALTER TABLE `materia`
  ADD PRIMARY KEY (`idMateria`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `alumno`
--
ALTER TABLE `alumno`
  MODIFY `idAlumno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- AUTO_INCREMENT for table `cursada`
--
ALTER TABLE `cursada`
  MODIFY `idCursada` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=75;

--
-- AUTO_INCREMENT for table `materia`
--
ALTER TABLE `materia`
  MODIFY `idMateria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cursada`
--
ALTER TABLE `cursada`
  ADD CONSTRAINT `cursada_ibfk_1` FOREIGN KEY (`idAlumno`) REFERENCES `alumno` (`idAlumno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `cursada_ibfk_2` FOREIGN KEY (`idMateria`) REFERENCES `materia` (`idMateria`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
