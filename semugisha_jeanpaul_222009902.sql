-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2024 at 12:00 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.1.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `semugisha_jeanpaul_222009902`
--

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `course_id` int(15) NOT NULL,
  `course_name` varchar(220) NOT NULL,
  `instructor` varchar(220) NOT NULL,
  `description_text` varchar(220) NOT NULL,
  `credit` varchar(220) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`course_id`, `course_name`, `instructor`, `description_text`, `credit`) VALUES
(1, 'MATH', 'ALL DOMAAIN', 'WELCOME', '20'),
(2, 'kiswa', 'all student', 'level one', '20'),
(3, 'java', 'all', 'for mine', '23'),
(4, 'geograph', 'online', 'all of you', '20'),
(8, 'INTERMEDIATE', 'ALL BUSINESS SCHOOL', 'COMMON', '15'),
(9, 'research', 'all student', 'become', '20');

-- --------------------------------------------------------

--
-- Table structure for table `examination`
--

CREATE TABLE `examination` (
  `examination_id` int(20) NOT NULL,
  `examination_name` varchar(220) NOT NULL,
  `examination_date` varchar(220) NOT NULL,
  `subject` varchar(202) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `examination`
--

INSERT INTO `examination` (`examination_id`, `examination_name`, `examination_date`, `subject`) VALUES
(1, 'math', '15/6/2024', 'java'),
(2, 'java', '19/2/2024', 'programming');

-- --------------------------------------------------------

--
-- Table structure for table `lecture`
--

CREATE TABLE `lecture` (
  `lecture_id` int(15) NOT NULL,
  `first_name` varchar(220) NOT NULL,
  `last_name` varchar(220) NOT NULL,
  `specialization` varchar(220) NOT NULL,
  `email` varchar(220) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `lecture`
--

INSERT INTO `lecture` (`lecture_id`, `first_name`, `last_name`, `specialization`, `email`) VALUES
(1, 'muneza', 'aloys', 'engeneer', '@gmail.com'),
(2, 'semugish', 'jeyp', 'account', 'semu@gmail.com'),
(4, 'k', 'dot', 'account', 'dot@gmail.com'),
(6, 'mana jeyp', 'mere', 'medecine', 'mere@gmail.com'),
(7, 'semugish', 'jeyp', 'tech', 'semugish@gmail.com'),
(10, 'nana', 'nunu', 'phd', 'nunu@gmail.com'),
(23, 'fidelite', 'fifi', 'programming', 'ate@gmail.com'),
(24, 'semugisha', 'jean', 'programmer', 'jean@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `siginup`
--

CREATE TABLE `siginup` (
  `id` int(20) NOT NULL,
  `first_name` varchar(220) NOT NULL,
  `last_name` varchar(220) NOT NULL,
  `email` varchar(202) NOT NULL,
  `pass_word` varchar(202) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `siginup`
--

INSERT INTO `siginup` (`id`, `first_name`, `last_name`, `email`, `pass_word`) VALUES
(1, '', '', '', ''),
(2, '1', 'jeyp', 'jeyp@gmail.com', '1234567'),
(3, '', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `student_id` int(11) NOT NULL,
  `first_name` varchar(220) NOT NULL,
  `last_name` varchar(220) NOT NULL,
  `email` varchar(202) NOT NULL,
  `age` int(202) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`student_id`, `first_name`, `last_name`, `email`, `age`) VALUES
(1, 'murazeyesu', 'jackson', 'jackson@gmail.com', 22),
(2, 'diogene', 'imanirafasha', 'diogen@gmail.com', 23),
(7, 'bugingo', 'bolingo', 'bolingogmail.com', 30),
(8, 'Umuhoza', 'lili', 'lili@gmail.com', 21);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`course_id`);

--
-- Indexes for table `examination`
--
ALTER TABLE `examination`
  ADD PRIMARY KEY (`examination_id`);

--
-- Indexes for table `lecture`
--
ALTER TABLE `lecture`
  ADD PRIMARY KEY (`lecture_id`);

--
-- Indexes for table `siginup`
--
ALTER TABLE `siginup`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`student_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `course_id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `examination`
--
ALTER TABLE `examination`
  MODIFY `examination_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `lecture`
--
ALTER TABLE `lecture`
  MODIFY `lecture_id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `siginup`
--
ALTER TABLE `siginup`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `student_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
