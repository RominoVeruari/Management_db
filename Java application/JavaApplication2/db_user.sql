-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 16, 2019 at 02:13 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_user`
--

-- --------------------------------------------------------

--
-- Table structure for table `db_client`
--

CREATE TABLE `db_client` (
  `ID` int(16) NOT NULL,
  `FirstName` varchar(16) NOT NULL,
  `FatherName` varchar(16) NOT NULL,
  `LastName` varchar(16) NOT NULL,
  `BirthDate` date NOT NULL,
  `BirthPlace` varchar(16) NOT NULL,
  `Gender` varchar(16) NOT NULL,
  `MaritalStatus` varchar(16) NOT NULL,
  `PhoneNumber` int(16) NOT NULL,
  `Address` varchar(16) NOT NULL,
  `Email` varchar(16) NOT NULL,
  `Photo` varchar(250) NOT NULL,
  `CF` varchar(11) NOT NULL,
  `Username` varchar(16) NOT NULL,
  `Password` varchar(16) NOT NULL,
  `admin` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_client`
--

INSERT INTO `db_client` (`ID`, `FirstName`, `FatherName`, `LastName`, `BirthDate`, `BirthPlace`, `Gender`, `MaritalStatus`, `PhoneNumber`, `Address`, `Email`, `Photo`, `CF`, `Username`, `Password`, `admin`) VALUES
(3, '21', '3', '4', '2019-02-22', '6', 'Male', 'Married', 9, '10', '11', 'av1.jpg', '13', '14', '15', 1),
(5, '11', '22', '33', '2019-02-22', '55', 'Male', 'Single', 88, '99', '101', 'av2.jpg', '112', '114', '115', 0);

-- --------------------------------------------------------

--
-- Table structure for table `db_test`
--

CREATE TABLE `db_test` (
  `a1` int(11) NOT NULL,
  `a2` varchar(11) NOT NULL,
  `a3` varchar(11) NOT NULL,
  `a4` varchar(11) NOT NULL,
  `b1` varchar(11) NOT NULL,
  `b2` varchar(11) NOT NULL,
  `b3` varchar(11) NOT NULL,
  `b4` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_test`
--

INSERT INTO `db_test` (`a1`, `a2`, `a3`, `a4`, `b1`, `b2`, `b3`, `b4`) VALUES
(1, '1', '2', '3', '4', '5', '6', '7');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `ID` int(4) NOT NULL,
  `Username` varchar(16) NOT NULL,
  `Password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`ID`, `Username`, `Password`) VALUES
(1, 'admin', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `db_client`
--
ALTER TABLE `db_client`
  ADD UNIQUE KEY `ID` (`ID`);

--
-- Indexes for table `db_test`
--
ALTER TABLE `db_test`
  ADD UNIQUE KEY `a1` (`a1`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `db_client`
--
ALTER TABLE `db_client`
  MODIFY `ID` int(16) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `db_test`
--
ALTER TABLE `db_test`
  MODIFY `a1` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `ID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
