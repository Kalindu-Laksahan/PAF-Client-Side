-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 22, 2021 at 08:05 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gadgetbadget`
--

-- --------------------------------------------------------

--
-- Table structure for table `researcher`
--

CREATE TABLE `researcher` (
  `ResearcherID` int(11) NOT NULL,
  `ResearcherName` varchar(20) NOT NULL,
  `ResearcherEmail` varchar(20) NOT NULL,
  `AboutResearcher` varchar(200) NOT NULL,
  `ProjectName` varchar(20) NOT NULL,
  `ProjectDescription` varchar(500) NOT NULL,
  `ProjectPrice` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `researcher`
--

INSERT INTO `researcher` (`ResearcherID`, `ResearcherName`, `ResearcherEmail`, `AboutResearcher`, `ProjectName`, `ProjectDescription`, `ProjectPrice`) VALUES
(1, 'Kalindu Laksahan', 'kali@gmail.com', 'gangster', 'POS ', 'This is a good project', 3000),
(2, 'Uvin Jithmal', 'Uvinj@gmail.com', 'I am a NSBM Student', 'Web Application', 'This my Web Application', 2400),
(9, 'Nipun l', 'NipunL@gmail.com', 'I Am a Sliit Student', 'Quiz Application', 'This App is IOS Application', 5000),
(10, 'Anjelo', 'Anjelo@gmaol.com', 'I am working on my app', 'Mobile App', 'This is an ios app', 7500);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `researcher`
--
ALTER TABLE `researcher`
  ADD PRIMARY KEY (`ResearcherID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `researcher`
--
ALTER TABLE `researcher`
  MODIFY `ResearcherID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
