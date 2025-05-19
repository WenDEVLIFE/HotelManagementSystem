-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 19, 2025 at 03:00 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hoteldatabase`
--

-- --------------------------------------------------------

--
-- Table structure for table `check_in_table`
--

CREATE TABLE `check_in_table` (
  `check_in_id` int(255) NOT NULL,
  `user_id` int(255) NOT NULL,
  `customer_name` varchar(255) NOT NULL,
  `room_id` varchar(255) NOT NULL,
  `no_of_person` int(255) NOT NULL,
  `date_in` varchar(255) NOT NULL,
  `date_out` varchar(255) NOT NULL,
  `no_of_nights` int(255) NOT NULL,
  `advance_payment` int(255) NOT NULL,
  `balance` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `check_in_table`
--

INSERT INTO `check_in_table` (`check_in_id`, `user_id`, `customer_name`, `room_id`, `no_of_person`, `date_in`, `date_out`, `no_of_nights`, `advance_payment`, `balance`) VALUES
(2, 1, '2025-05-19', 'L345', 1, '2025-05-19', '2025-05-20', 1, 566, 4545),
(3, 1, 'wewe', 'L345', 4, '2025-05-19', '2025-05-20', 1, 900, 1000);

-- --------------------------------------------------------

--
-- Table structure for table `check_out_table`
--

CREATE TABLE `check_out_table` (
  `check_out_id` int(255) NOT NULL,
  `room_id` varchar(255) NOT NULL,
  `user_id` int(255) NOT NULL,
  `guest_name` varchar(255) NOT NULL,
  `date_in` varchar(255) NOT NULL,
  `no_of_days` int(255) NOT NULL,
  `no_of_person` int(255) NOT NULL,
  `date_out` varchar(255) NOT NULL,
  `rate` int(255) NOT NULL,
  `total_change` int(255) NOT NULL,
  `other_charges` int(255) NOT NULL,
  `total` int(255) NOT NULL,
  `amount` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `check_out_table`
--

INSERT INTO `check_out_table` (`check_out_id`, `room_id`, `user_id`, `guest_name`, `date_in`, `no_of_days`, `no_of_person`, `date_out`, `rate`, `total_change`, `other_charges`, `total`, `amount`) VALUES
(1, 'L345', 1, 'WWEW', '2025-05-19', 1, 1, '2025-05-20', 455, 234, 566, 1000, 1000);

-- --------------------------------------------------------

--
-- Table structure for table `report`
--

CREATE TABLE `report` (
  `report_id` int(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  `time` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `report`
--

INSERT INTO `report` (`report_id`, `description`, `date`, `time`) VALUES
(1, 'Check-in details added for customer name 2025-05-19', '2025-05-19', '15:07:57.242218'),
(2, 'Check-out details added for customer name WWEW', '2025-05-19', '16:04:23.519833200'),
(3, 'Check-in details added for customer name wewe', '2025-05-19', '17:27:21.667745');

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `room_id` varchar(255) NOT NULL,
  `room_status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`room_id`, `room_status`) VALUES
('L345', 'Occupied');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `username`, `password`, `role`) VALUES
(1, 'DoeUser', 'DOE', 'user'),
(2, 'Admin', 'admin', 'Admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `check_in_table`
--
ALTER TABLE `check_in_table`
  ADD PRIMARY KEY (`check_in_id`);

--
-- Indexes for table `check_out_table`
--
ALTER TABLE `check_out_table`
  ADD PRIMARY KEY (`check_out_id`);

--
-- Indexes for table `report`
--
ALTER TABLE `report`
  ADD PRIMARY KEY (`report_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `check_in_table`
--
ALTER TABLE `check_in_table`
  MODIFY `check_in_id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `check_out_table`
--
ALTER TABLE `check_out_table`
  MODIFY `check_out_id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `report`
--
ALTER TABLE `report`
  MODIFY `report_id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
