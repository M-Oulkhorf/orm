-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 03, 2024 at 10:12 PM
-- Server version: 8.3.0
-- PHP Version: 8.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `app`
--

-- --------------------------------------------------------

--
-- Table structure for table `band`
--

DROP TABLE IF EXISTS `band`;
CREATE TABLE IF NOT EXISTS `band` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `band_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `band`
--

INSERT INTO `band` (`id`, `band_name`) VALUES
(1, 'Les Mélodistes'),
(2, 'Les Rythmes de la Nuit');

-- --------------------------------------------------------

--
-- Table structure for table `band_festival`
--

DROP TABLE IF EXISTS `band_festival`;
CREATE TABLE IF NOT EXISTS `band_festival` (
  `band_id` bigint NOT NULL,
  `festival_id` bigint NOT NULL,
  PRIMARY KEY (`band_id`,`festival_id`),
  KEY `FK18uitmfb7yaqkr10362qe5ql0` (`festival_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `band_festival`
--

INSERT INTO `band_festival` (`band_id`, `festival_id`) VALUES
(1, 1),
(2, 2),
(3, 3);

-- --------------------------------------------------------

--
-- Table structure for table `band_musician`
--

DROP TABLE IF EXISTS `band_musician`;
CREATE TABLE IF NOT EXISTS `band_musician` (
  `band_id` bigint NOT NULL,
  `musician_id` bigint NOT NULL,
  PRIMARY KEY (`band_id`,`musician_id`),
  KEY `FKg02ofu4jqh39kvp72rmov776j` (`musician_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `band_musician`
--

INSERT INTO `band_musician` (`band_id`, `musician_id`) VALUES
(1, 1),
(1, 2),
(2, 1),
(2, 4);

-- --------------------------------------------------------

--
-- Table structure for table `festival`
--

DROP TABLE IF EXISTS `festival`;
CREATE TABLE IF NOT EXISTS `festival` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ville` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `date` date NOT NULL,
  `tarif` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `festival`
--

INSERT INTO `festival` (`id`, `libelle`, `ville`, `date`, `tarif`) VALUES
(1, 'Festival de Jazz', 'Paris', '2023-07-15', 50),
(2, 'Festival Rock', 'Lyon', '2023-08-20', 75),
(3, 'Festival Classique', 'Marseille', '2023-09-10', 60),
(4, 'Festival de Jazz', 'Paris', '2023-07-15', 50);

-- --------------------------------------------------------

--
-- Table structure for table `musician`
--

DROP TABLE IF EXISTS `musician`;
CREATE TABLE IF NOT EXISTS `musician` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `person_id` bigint NOT NULL,
  `instruments` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `join_date` date DEFAULT NULL,
  `leave_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9y9d9br4we09yq9c2iwe4bljw` (`person_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `musician`
--

INSERT INTO `musician` (`id`, `person_id`, `instruments`, `join_date`, `leave_date`) VALUES
(1, 1, 'Guitare', '2023-01-01', NULL),
(2, 1, 'Piano', '2023-01-01', NULL),
(3, 2, 'Batterie', '2023-02-01', NULL),
(4, 3, 'Saxophone', '2023-03-01', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
CREATE TABLE IF NOT EXISTS `person` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `age` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`id`, `first_name`, `last_name`, `email`, `age`) VALUES
(1, 'Alice', 'Dupont', 'alice.updated@example.com', 31),
(2, 'Bob', 'Martin', 'bob.martin@example.com', 25),
(3, 'Charlie', 'Leroy', 'charlie.leroy@example.com', 28),
(4, 'Diane', 'Moreau', 'diane.moreau@example.com', 35),
(5, 'Eve', 'Bouvier', 'eve.bouvier@example.com', 22);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
