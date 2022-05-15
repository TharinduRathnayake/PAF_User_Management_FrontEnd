-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 15, 2022 at 05:03 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `electrogrid`
--

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `CustomerID` int(10) NOT NULL,
  `CustomerfName` varchar(30) NOT NULL,
  `CustomerlName` varchar(38) NOT NULL,
  `AccountNumber` int(20) NOT NULL,
  `CustomerNIC` varchar(20) NOT NULL,
  `CustomerEmail` varchar(30) NOT NULL,
  `CustomerPhone` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`CustomerID`, `CustomerfName`, `CustomerlName`, `AccountNumber`, `CustomerNIC`, `CustomerEmail`, `CustomerPhone`) VALUES
(16, 'Tharindu', 'Rathnayake', 80275563, '981783654v', 'tharindu1dr@gmail.com', '7749472867'),
(17, 'Danushi', 'Kollure', 674253648, '2000643748v', 'danu12@gmail.com', '775264753'),
(18, 'Gagamini', 'Suriyawatte', 776543783, '2000473568v', 'gaga33@gmail.com', '713562765');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`CustomerID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `CustomerID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
