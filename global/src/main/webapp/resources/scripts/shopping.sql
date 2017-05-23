-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 13, 2017 at 09:26 AM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 7.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shopping`
--

-- --------------------------------------------------------

--
-- Table structure for table `td_customer_balance`
--

CREATE TABLE `td_customer_balance` (
  `customer_id` bigint(20) NOT NULL,
  `godownno` varchar(20) NOT NULL,
  `total_balance` double NOT NULL DEFAULT '0',
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `td_customer_balance`
--

INSERT INTO `td_customer_balance` (`customer_id`, `godownno`, `total_balance`, `name`) VALUES
(1, '56', 340186, 'Namadipta Patro'),
(9, '22', 765, 'ram mohan');

-- --------------------------------------------------------

--
-- Table structure for table `td_customer_balance_details`
--

CREATE TABLE `td_customer_balance_details` (
  `balance_details_code` bigint(20) NOT NULL,
  `customer_id` bigint(20) NOT NULL,
  `goddown_no` varchar(20) NOT NULL,
  `bill_no` bigint(20) NOT NULL,
  `bill_amount` double NOT NULL,
  `paid_amount` double NOT NULL,
  `due_amount` double NOT NULL,
  `bill_date` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `td_customer_balance_details`
--

INSERT INTO `td_customer_balance_details` (`balance_details_code`, `customer_id`, `goddown_no`, `bill_no`, `bill_amount`, `paid_amount`, `due_amount`, `bill_date`, `name`) VALUES
(1, 1, '56', 1, 1170, 1100, 70, 'Wed Jul 20 20:58:08 IST 2016', 'Namadipta Patro'),
(2, 1, '56', 2, 390, 0, 390, 'Thu Jul 21 20:14:11 IST 2016', 'Namadipta Patro'),
(3, 9, '22', 3, 10, 8, 2, 'Thu Jul 21 20:17:14 IST 2016', 'ram mohan'),
(4, 1, '56', 4, 80, 80, 0, 'Thu Jul 21 20:19:24 IST 2016', 'Namadipta Patro'),
(5, 1, '56', 5, 1014, 0, 1014, 'Fri Jul 22 20:33:53 IST 2016', 'Namadipta Patro'),
(6, 1, '56', 6, 100, 0, 100, 'Fri Jul 22 20:47:17 IST 2016', 'Namadipta Patro'),
(7, 1, '56', 7, 10, 0, 10, 'Fri Jul 22 20:56:57 IST 2016', 'Namadipta Patro'),
(8, 1, '56', 8, 780, 0, 780, 'Fri Jul 22 20:59:06 IST 2016', 'Namadipta Patro'),
(9, 1, '56', 9, 780, 0, 780, 'Fri Jul 22 20:59:06 IST 2016', 'Namadipta Patro'),
(10, 1, '56', 10, 780, 0, 780, 'Fri Jul 22 21:03:18 IST 2016', 'Namadipta Patro'),
(11, 1, '56', 11, 780, 0, 780, 'Fri Jul 22 21:06:27 IST 2016', 'Namadipta Patro'),
(12, 1, '56', 12, 780, 0, 780, 'Fri Jul 22 21:08:34 IST 2016', 'Namadipta Patro'),
(13, 1, '56', 13, 936, 0, 936, 'Fri Jul 22 21:19:12 IST 2016', 'Namadipta Patro'),
(14, 1, '56', 14, 780, 0, 780, 'Fri Jul 22 21:20:55 IST 2016', 'Namadipta Patro'),
(15, 1, '56', 15, 858, 0, 858, 'Fri Jul 22 21:32:19 IST 2016', 'Namadipta Patro'),
(16, 1, '56', 16, 780, 0, 780, 'Fri Jul 22 21:39:23 IST 2016', 'Namadipta Patro'),
(17, 1, '56', 17, 858, 0, 858, 'Fri Jul 22 21:41:38 IST 2016', 'Namadipta Patro'),
(18, 1, '56', 18, 858, 0, 858, 'Fri Jul 22 21:45:46 IST 2016', 'Namadipta Patro'),
(19, 1, '56', 19, 858, 0, 858, 'Fri Jul 22 21:50:14 IST 2016', 'Namadipta Patro'),
(20, 1, '56', 20, 858, 0, 858, 'Fri Jul 22 21:50:14 IST 2016', 'Namadipta Patro'),
(21, 1, '56', 21, 858, 0, 858, 'Fri Jul 22 21:50:14 IST 2016', 'Namadipta Patro'),
(22, 1, '56', 22, 25662, 0, 25662, 'Fri Jul 22 23:30:55 IST 2016', 'Namadipta Patro'),
(23, 1, '56', 23, 234, 0, 234, 'Fri Jul 22 23:33:15 IST 2016', 'Namadipta Patro'),
(24, 1, '56', 24, 390, 0, 390, 'Fri Jul 22 23:43:03 IST 2016', 'Namadipta Patro'),
(25, 1, '56', 25, 858, 0, 858, 'Sat Jul 23 12:53:23 IST 2016', 'Namadipta Patro'),
(26, 1, '56', 26, 78, 0, 78, 'Sat Jul 23 13:08:08 IST 2016', 'Namadipta Patro'),
(27, 1, '56', 27, 78, 0, 78, 'Sat Jul 23 13:17:27 IST 2016', 'Namadipta Patro'),
(28, 1, '56', 28, 78, 0, 78, 'Sat Jul 23 13:17:27 IST 2016', 'Namadipta Patro'),
(29, 1, '56', 29, -77, 0, -77, 'Sat Jul 23 13:24:33 IST 2016', 'Namadipta Patro'),
(30, 9, '22', 30, 77, 0, 77, 'Sat Jul 23 13:26:59 IST 2016', 'ram mohan'),
(31, 1, '56', 31, 23712, 0, 23712, 'Sat Jul 23 13:29:41 IST 2016', 'Namadipta Patro'),
(32, 1, '56', 32, 23556, 0, 23556, 'Sat Jul 23 13:38:47 IST 2016', 'Namadipta Patro'),
(33, 1, '56', 33, 23556, 0, 23556, 'Sat Jul 23 13:38:47 IST 2016', 'Namadipta Patro'),
(34, 1, '56', 34, 23400, 0, 23400, 'Sat Jul 23 13:49:32 IST 2016', 'Namadipta Patro'),
(35, 1, '56', 35, 23322, 0, 23322, 'Sat Jul 23 13:59:44 IST 2016', 'Namadipta Patro'),
(36, 1, '56', 36, 78, 0, 78, 'Sat Jul 23 14:05:20 IST 2016', 'Namadipta Patro'),
(37, 1, '56', 37, 23166, 0, 23166, 'Sat Jul 23 14:08:13 IST 2016', 'Namadipta Patro'),
(38, 1, '56', 38, 78, 0, 78, 'Sat Jul 23 22:11:05 IST 2016', 'Namadipta Patro'),
(39, 1, '56', 39, 78, 0, 78, 'Sat Jul 23 22:11:05 IST 2016', 'Namadipta Patro'),
(40, 1, '56', 40, 78, 0, 78, 'Sat Jul 23 22:33:25 IST 2016', 'Namadipta Patro'),
(41, 1, '56', 41, 78, 0, 78, 'Sat Jul 23 22:38:21 IST 2016', 'Namadipta Patro'),
(42, 1, '56', 42, 156, 0, 156, 'Sun Jul 24 02:40:58 IST 2016', 'Namadipta Patro'),
(43, 1, '56', 43, 156, 0, 156, 'Sun Jul 24 02:41:19 IST 2016', 'Namadipta Patro'),
(44, 1, '56', 44, 156, 0, 156, 'Sun Jul 24 02:42:21 IST 2016', 'Namadipta Patro'),
(45, 1, '56', 45, 1, 0, 1, 'Sun Jul 24 02:43:55 IST 2016', 'Namadipta Patro'),
(46, 1, '56', 46, 10, 0, 10, 'Sun Jul 24 02:45:19 IST 2016', 'Namadipta Patro'),
(47, 1, '56', 47, 1, 0, 1, 'Sun Jul 24 02:45:40 IST 2016', 'Namadipta Patro'),
(48, 1, '56', 48, 1, 0, 1, 'Sun Jul 24 02:47:00 IST 2016', 'Namadipta Patro'),
(49, 1, '56', 49, 6, 0, 6, 'Sun Jul 24 02:47:13 IST 2016', 'Namadipta Patro'),
(50, 1, '56', 50, 6, 0, 6, 'Sun Jul 24 02:47:13 IST 2016', 'Namadipta Patro'),
(51, 1, '56', 51, 2, 0, 2, 'Sun Jul 24 02:48:49 IST 2016', 'Namadipta Patro'),
(52, 1, '56', 52, 2, 0, 2, 'Sun Jul 24 02:53:58 IST 2016', 'Namadipta Patro'),
(53, 9, '22', 54, 10, 0, 10, 'Sun Jul 24 02:58:34 IST 2016', 'ram mohan'),
(54, 9, '22', 55, 10, 0, 10, 'Sun Jul 24 03:00:27 IST 2016', 'ram mohan'),
(55, 9, '22', 56, 10, 0, 10, 'Sun Jul 24 03:00:27 IST 2016', 'ram mohan'),
(56, 9, '22', 57, 2, 0, 2, 'Sun Jul 24 03:03:51 IST 2016', 'ram mohan'),
(57, 9, '22', 58, 1, 0, 1, 'Sun Jul 24 03:05:14 IST 2016', 'ram mohan'),
(58, 1, '56', 59, 2, 0, 2, 'Sun Jul 24 03:05:33 IST 2016', 'Namadipta Patro'),
(59, 1, '56', 60, 1, 0, 1, 'Sun Jul 24 03:07:36 IST 2016', 'Namadipta Patro'),
(60, 1, '56', 61, 78, 0, 78, 'Sun Jul 24 03:07:56 IST 2016', 'Namadipta Patro'),
(61, 1, '56', 62, 156, 0, 156, 'Sun Jul 24 03:11:15 IST 2016', 'Namadipta Patro'),
(62, 1, '56', 63, 4, 0, 4, 'Sun Jul 24 03:12:27 IST 2016', 'Namadipta Patro'),
(63, 9, '22', 64, 156, 34, 122, 'Sun Jul 24 03:24:57 IST 2016', 'ram mohan'),
(64, 9, '22', 65, 33, 0, 33, 'Sun Jul 24 03:29:33 IST 2016', 'ram mohan'),
(65, 9, '22', 66, 78, 0, 78, 'Sun Jul 24 03:33:40 IST 2016', 'ram mohan'),
(66, 9, '22', 67, 2, 0, 2, 'Sun Jul 24 03:34:35 IST 2016', 'ram mohan'),
(67, 9, '22', 68, 2, 0, 2, 'Sun Jul 24 03:35:34 IST 2016', 'ram mohan'),
(68, 9, '22', 69, 2, 0, 2, 'Sun Jul 24 03:37:19 IST 2016', 'ram mohan'),
(69, 9, '22', 70, 156, 0, 156, 'Sun Jul 24 03:37:51 IST 2016', 'ram mohan'),
(70, 1, '56', 71, 1, 0, 1, 'Sun Jul 24 03:57:05 IST 2016', 'Namadipta Patro'),
(71, 9, '22', 72, 1, 0, 1, 'Sun Jul 24 03:57:20 IST 2016', 'ram mohan'),
(72, 1, '56', 73, 1, 0, 1, 'Sun Jul 24 03:57:05 IST 2016', 'Namadipta Patro'),
(73, 9, '22', 74, 1, 0, 1, 'Sun Jul 24 04:04:34 IST 2016', 'ram mohan'),
(74, 9, '22', 75, 2, 0, 2, 'Sun Jul 24 04:06:20 IST 2016', 'ram mohan'),
(75, 9, '22', 76, 1, 0, 1, 'Sun Jul 24 04:07:32 IST 2016', 'ram mohan'),
(76, 9, '22', 77, 1, 0, 1, 'Sun Jul 24 04:09:16 IST 2016', 'ram mohan'),
(77, 9, '22', 78, 1, 0, 1, 'Sun Jul 24 04:09:31 IST 2016', 'ram mohan'),
(78, 9, '22', 79, 1, 0, 1, 'Sun Jul 24 04:10:31 IST 2016', 'ram mohan'),
(79, 9, '22', 80, 1, 0, 1, 'Sun Jul 24 04:10:44 IST 2016', 'ram mohan'),
(80, 9, '22', 81, 1, 0, 1, 'Sun Jul 24 04:12:03 IST 2016', 'ram mohan'),
(81, 9, '22', 82, 1, 0, 1, 'Sun Jul 24 04:13:32 IST 2016', 'ram mohan'),
(82, 9, '22', 83, 1, 0, 1, 'Sun Jul 24 04:13:51 IST 2016', 'ram mohan'),
(83, 9, '22', 84, 1, 0, 1, 'Sun Jul 24 04:20:43 IST 2016', 'ram mohan'),
(84, 1, '56', 85, 858, 0, 858, 'Sun Jul 24 17:15:15 IST 2016', 'Namadipta Patro'),
(85, 9, '22', 86, 11, 0, 11, 'Sun Jul 24 17:15:40 IST 2016', 'ram mohan'),
(86, 1, '56', 87, 156, 0, 156, 'Sun Jul 24 20:01:09 IST 2016', 'Namadipta Patro'),
(87, 1, '56', 88, 156, 0, 156, 'Sun Jul 24 20:01:29 IST 2016', 'Namadipta Patro'),
(88, 1, '56', 89, 156, 0, 156, 'Sun Jul 24 20:02:54 IST 2016', 'Namadipta Patro'),
(89, 1, '56', 90, 78, 0, 78, 'Sun Jul 24 20:03:31 IST 2016', 'Namadipta Patro'),
(90, 1, '56', 91, 78, 0, 78, 'Sun Jul 24 20:04:17 IST 2016', 'Namadipta Patro'),
(91, 1, '56', 92, 390, 0, 390, 'Sun Jul 24 20:05:20 IST 2016', 'Namadipta Patro'),
(92, 1, '56', 93, 78, 0, 78, 'Sun Jul 24 20:09:55 IST 2016', 'Namadipta Patro'),
(93, 1, '56', 94, 78, 0, 78, 'Sun Jul 24 20:19:11 IST 2016', 'Namadipta Patro'),
(94, 1, '56', 95, 156, 0, 156, 'Sun Jul 24 20:19:58 IST 2016', 'Namadipta Patro'),
(95, 1, '56', 96, 29640, 0, 29640, 'Sun Jul 24 20:22:07 IST 2016', 'Namadipta Patro'),
(96, 1, '56', 97, 1, 0, 1, 'Sun Jul 24 20:23:46 IST 2016', 'Namadipta Patro'),
(97, 1, '56', 98, 1, 0, 1, 'Sun Jul 24 20:25:26 IST 2016', 'Namadipta Patro'),
(98, 1, '56', 99, 1, 0, 1, 'Sun Jul 24 20:32:27 IST 2016', 'Namadipta Patro'),
(99, 1, '56', 100, 1, 0, 1, 'Sun Jul 24 20:35:46 IST 2016', 'Namadipta Patro'),
(100, 1, '56', 101, 156, 0, 156, 'Sun Jul 24 20:36:02 IST 2016', 'Namadipta Patro'),
(101, 1, '56', 102, 1, 0, 1, 'Sun Jul 24 20:51:02 IST 2016', 'Namadipta Patro'),
(102, 1, '56', 103, 78, 0, 78, 'Sun Jul 24 20:51:38 IST 2016', 'Namadipta Patro'),
(103, 1, '56', 104, 1, 0, 1, 'Sun Jul 24 20:53:05 IST 2016', 'Namadipta Patro'),
(104, 1, '56', 105, 78, 0, 78, 'Sun Jul 24 20:51:38 IST 2016', 'Namadipta Patro'),
(105, 1, '56', 106, 98473, 0, 98473, 'Sun Jul 24 20:53:56 IST 2016', 'Namadipta Patro'),
(106, 1, '56', 107, 78, 0, 78, 'Sun Jul 24 20:51:38 IST 2016', 'Namadipta Patro'),
(107, 1, '56', 108, 858, 0, 858, 'Sun Jul 24 20:55:23 IST 2016', 'Namadipta Patro'),
(108, 1, '56', 109, 78, 0, 78, 'Sun Jul 24 20:51:38 IST 2016', 'Namadipta Patro'),
(109, 1, '56', 110, 23634, 0, 23634, 'Sun Jul 24 20:56:11 IST 2016', 'Namadipta Patro'),
(110, 1, '56', 111, 0, 0, 0, 'Sun Jul 24 21:10:31 IST 2016', 'Namadipta Patro'),
(111, 1, '56', 112, 156, 0, 156, 'Sun Jul 24 21:31:39 IST 2016', 'Namadipta Patro'),
(112, 1, '56', 113, 156, 0, 156, 'Sun Jul 24 21:32:23 IST 2016', 'Namadipta Patro'),
(113, 1, '56', 114, 156, 0, 156, 'Sun Jul 24 21:32:37 IST 2016', 'Namadipta Patro'),
(114, 1, '56', 115, 78, 0, 78, 'Sun Jul 24 21:33:19 IST 2016', 'Namadipta Patro'),
(115, 1, '56', 116, 156, 0, 156, 'Mon Jul 25 00:00:40 IST 2016', 'Namadipta Patro'),
(116, 1, '56', 117, 78, 0, 78, 'Tue Jul 26 00:43:24 IST 2016', 'Namadipta Patro'),
(117, 1, '56', 118, 78, 0, 78, 'Tue Jul 26 20:38:58 IST 2016', 'Namadipta Patro'),
(118, 1, '56', 119, 78, 0, 78, 'Tue Jul 26 20:42:50 IST 2016', 'Namadipta Patro'),
(119, 1, '56', 120, 78, 0, 78, 'Tue Jul 26 20:46:36 IST 2016', 'Namadipta Patro'),
(120, 1, '56', 121, 78, 0, 78, 'Tue Jul 26 20:48:02 IST 2016', 'Namadipta Patro'),
(121, 1, '56', 122, 78, 0, 78, 'Tue Jul 26 20:48:02 IST 2016', 'Namadipta Patro'),
(122, 1, '56', 123, 78, 0, 78, 'Tue Jul 26 20:49:01 IST 2016', 'Namadipta Patro'),
(123, 1, '56', 124, 78, 0, 78, 'Tue Jul 26 20:49:01 IST 2016', 'Namadipta Patro'),
(124, 1, '56', 125, 78, 0, 78, 'Tue Jul 26 20:51:53 IST 2016', 'Namadipta Patro'),
(125, 1, '56', 126, 78, 0, 78, 'Tue Jul 26 20:52:56 IST 2016', 'Namadipta Patro'),
(126, 1, '56', 127, 78, 0, 78, 'Tue Jul 26 20:53:06 IST 2016', 'Namadipta Patro'),
(127, 1, '56', 128, 78, 0, 78, 'Tue Jul 26 20:56:23 IST 2016', 'Namadipta Patro'),
(128, 1, '56', 129, 78, 0, 78, 'Tue Jul 26 20:56:36 IST 2016', 'Namadipta Patro'),
(129, 1, '56', 130, 78, 0, 78, 'Tue Jul 26 20:59:11 IST 2016', 'Namadipta Patro'),
(130, 1, '56', 131, 78, 0, 78, 'Tue Jul 26 20:59:43 IST 2016', 'Namadipta Patro'),
(131, 1, '56', 132, 78, 0, 78, 'Tue Jul 26 21:02:10 IST 2016', 'Namadipta Patro'),
(132, 1, '56', 133, 78, 0, 78, 'Tue Jul 26 21:03:16 IST 2016', 'Namadipta Patro'),
(133, 1, '56', 134, 78, 0, 78, 'Tue Jul 26 21:16:28 IST 2016', 'Namadipta Patro'),
(134, 1, '56', 135, 78, 0, 78, 'Tue Jul 26 21:18:15 IST 2016', 'Namadipta Patro'),
(135, 1, '56', 136, 78, 0, 78, 'Tue Jul 26 21:18:27 IST 2016', 'Namadipta Patro'),
(136, 1, '56', 137, 78, 0, 78, 'Tue Jul 26 21:23:12 IST 2016', 'Namadipta Patro'),
(137, 9, '22', 138, 78, 0, 78, 'Tue Jul 26 21:23:39 IST 2016', 'ram mohan'),
(138, 9, '22', 139, 78, 0, 78, 'Tue Jul 26 21:24:00 IST 2016', 'ram mohan'),
(139, 1, '56', 140, 78, 0, 78, 'Tue Jul 26 21:25:31 IST 2016', 'Namadipta Patro'),
(140, 1, '56', 141, 78, 0, 78, 'Tue Jul 26 21:25:46 IST 2016', 'Namadipta Patro'),
(141, 1, '56', 142, 78, 0, 78, 'Tue Jul 26 23:04:15 IST 2016', 'Namadipta Patro');

--
-- Triggers `td_customer_balance_details`
--
DELIMITER $$
CREATE TRIGGER `update_customer_dues` AFTER INSERT ON `td_customer_balance_details` FOR EACH ROW update td_customer_balance set total_balance =(SELECT sum(due_amount) from td_customer_balance_details where customer_id=new.customer_id) where customer_id=new.customer_id
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `td_customer_details`
--

CREATE TABLE `td_customer_details` (
  `customer_id` bigint(20) NOT NULL,
  `godown_no` varchar(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(200) DEFAULT NULL,
  `address` varchar(400) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `mobile` varchar(20) NOT NULL,
  `landline` varchar(20) DEFAULT NULL,
  `secondary_phone` varchar(20) DEFAULT NULL,
  `dob` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `td_customer_details`
--

INSERT INTO `td_customer_details` (`customer_id`, `godown_no`, `name`, `email`, `address`, `state`, `city`, `mobile`, `landline`, `secondary_phone`, `dob`) VALUES
(1, '56', 'Namadipta Patro', 'namadipta.patro@gmail.com', 'Tf314,passion Elite-2,electronic City', 'KA', 'Banglore', '9886275563', '9886275563', '9886275563', NULL),
(9, '22', 'ram mohan', 'ramohanca@gmail.com', 'Bam', '', '', '8904846795', '', '', '1990-03-11');

--
-- Triggers `td_customer_details`
--
DELIMITER $$
CREATE TRIGGER `add customer` AFTER INSERT ON `td_customer_details` FOR EACH ROW INSERT
INTO
  td_customer_search(
    NAME,
    mobile,
    godown_no,
    customer_id
  )
VALUES(
  NEW.name,
  NEW.mobile,
  NEW.godown_no,
  NEW.customer_id
)
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `td_customer_search`
--

CREATE TABLE `td_customer_search` (
  `godown_no` varchar(20) NOT NULL,
  `customer_id` bigint(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `mobile` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `td_customer_search`
--

INSERT INTO `td_customer_search` (`godown_no`, `customer_id`, `name`, `mobile`) VALUES
('56', 1, 'Namadipta Patro', '9886275563'),
('22', 9, 'ram mohan', '8904846795');

-- --------------------------------------------------------

--
-- Table structure for table `td_item_details_for_bill`
--

CREATE TABLE `td_item_details_for_bill` (
  `bill_item_details` bigint(20) NOT NULL,
  `bill_no` bigint(20) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  `sell_price` double NOT NULL,
  `quantity` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `td_item_details_for_bill`
--

INSERT INTO `td_item_details_for_bill` (`bill_item_details`, `bill_no`, `product_id`, `sell_price`, `quantity`) VALUES
(1, 1, 1, 78, 15),
(2, 2, 1, 78, 5),
(3, 3, 2, 1, 10),
(4, 4, 2, 1, 80),
(5, 5, 1, 78, 13),
(6, 6, 2, 1, 100),
(7, 7, 2, 1, 10),
(8, 8, 1, 78, 10),
(9, 9, 1, 78, 10),
(10, 10, 1, 78, 10),
(11, 11, 1, 78, 10),
(12, 12, 1, 78, 10),
(13, 13, 1, 78, 12),
(14, 14, 1, 78, 10),
(15, 15, 1, 78, 11),
(16, 16, 1, 78, 10),
(17, 17, 1, 78, 11),
(18, 18, 1, 78, 11),
(19, 19, 1, 78, 11),
(20, 20, 1, 78, 11),
(21, 21, 1, 78, 11),
(22, 22, 1, 78, 2),
(23, 23, 1, 78, 3),
(24, 24, 1, 78, 5),
(25, 25, 1, 78, 11),
(26, 26, 1, 78, 1),
(27, 27, 1, 78, 1),
(28, 28, 1, 78, 1),
(29, 29, 2, 1, 1),
(30, 30, 1, 78, 1),
(31, 31, 1, 78, 2),
(32, 32, 1, 78, 1),
(33, 33, 1, 78, 1),
(34, 34, 1, 78, 1),
(35, 35, 1, 78, 1),
(36, 36, 1, 78, 1),
(37, 37, 1, 78, 1),
(38, 38, 1, 78, 1),
(39, 39, 1, 78, 1),
(40, 40, 1, 78, 1),
(41, 41, 1, 78, 1),
(42, 42, 1, 78, 2),
(43, 43, 1, 78, 2),
(44, 44, 1, 78, 2),
(45, 45, 2, 1, 1),
(46, 46, 2, 1, 10),
(47, 47, 2, 1, 1),
(48, 48, 2, 1, 1),
(49, 49, 2, 1, 6),
(50, 50, 2, 1, 6),
(51, 51, 2, 1, 2),
(52, 52, 2, 1, 2),
(53, 53, 2, 1, 2),
(54, 54, 2, 1, 10),
(55, 55, 2, 1, 10),
(56, 56, 2, 1, 10),
(57, 57, 2, 1, 2),
(58, 58, 2, 1, 1),
(59, 59, 2, 1, 2),
(60, 60, 2, 1, 1),
(61, 61, 1, 78, 1),
(62, 62, 1, 78, 2),
(63, 63, 2, 1, 4),
(64, 64, 1, 78, 2),
(65, 65, 2, 1, 33),
(66, 66, 1, 78, 1),
(67, 67, 2, 1, 2),
(68, 68, 2, 1, 2),
(69, 69, 2, 1, 2),
(70, 70, 1, 78, 2),
(71, 71, 2, 1, 1),
(72, 72, 2, 1, 1),
(73, 73, 2, 1, 1),
(74, 74, 2, 1, 1),
(75, 75, 2, 1, 2),
(76, 76, 2, 1, 1),
(77, 77, 2, 1, 1),
(78, 78, 2, 1, 1),
(79, 79, 2, 1, 1),
(80, 80, 2, 1, 1),
(81, 81, 2, 1, 1),
(82, 82, 2, 1, 1),
(83, 83, 2, 1, 1),
(84, 84, 2, 1, 1),
(85, 85, 3, 78, 11),
(86, 86, 2, 1, 11),
(87, 87, 1, 78, 2),
(88, 88, 1, 78, 2),
(89, 89, 1, 78, 2),
(90, 90, 1, 78, 1),
(91, 91, 1, 78, 1),
(92, 92, 1, 78, 5),
(93, 93, 1, 78, 1),
(94, 94, 1, 78, 1),
(95, 95, 1, 78, 2),
(96, 96, 1, 78, 380),
(97, 97, 2, 1, 1),
(98, 98, 2, 1, 1),
(99, 99, 2, 1, 1),
(100, 100, 2, 1, 1),
(101, 101, 3, 78, 2),
(102, 102, 2, 1, 1),
(103, 103, 3, 78, 1),
(104, 104, 2, 1, 1),
(105, 105, 3, 78, 1),
(106, 106, 2, 1, 98473),
(107, 107, 3, 78, 1),
(108, 108, 4, 78, 11),
(109, 109, 3, 78, 1),
(110, 110, 3, 78, 303),
(111, 111, 3, 78, 0),
(112, 112, 1, 78, 2),
(113, 113, 1, 78, 2),
(114, 114, 1, 78, 2),
(115, 115, 1, 78, 1),
(116, 116, 1, 78, 2),
(117, 117, 1, 78, 1),
(118, 118, 1, 78, 1),
(119, 119, 1, 78, 1),
(120, 120, 1, 78, 1),
(121, 121, 1, 78, 1),
(122, 122, 1, 78, 1),
(123, 123, 1, 78, 1),
(124, 124, 1, 78, 1),
(125, 125, 1, 78, 1),
(126, 126, 1, 78, 1),
(127, 127, 1, 78, 1),
(128, 128, 1, 78, 1),
(129, 129, 1, 78, 1),
(130, 130, 1, 78, 1),
(131, 131, 1, 78, 1),
(132, 132, 1, 78, 1),
(133, 133, 1, 78, 1),
(134, 134, 1, 78, 1),
(135, 135, 1, 78, 1),
(136, 136, 1, 78, 1),
(137, 137, 1, 78, 1),
(138, 138, 1, 78, 1),
(139, 139, 1, 78, 1),
(140, 140, 1, 78, 1),
(141, 141, 1, 78, 1),
(142, 142, 1, 78, 1),
(143, 143, 1, 78, 1),
(144, 144, 1, 78, 1),
(145, 145, 1, 78, 1),
(146, 146, 1, 78, 1),
(147, 147, 1, 78, 1),
(148, 148, 1, 78, 1),
(149, 149, 1, 78, 1),
(150, 150, 1, 78, 1),
(151, 151, 1, 78, 1),
(152, 152, 1, 78, 1),
(153, 153, 1, 78, 1),
(154, 154, 1, 78, 1),
(155, 155, 1, 78, 1),
(156, 156, 1, 78, 1),
(157, 157, 1, 78, 1),
(158, 158, 1, 78, 1),
(159, 159, 1, 78, 1),
(160, 160, 1, 78, 1),
(161, 161, 1, 78, 1);

-- --------------------------------------------------------

--
-- Table structure for table `td_product_quanity_details`
--

CREATE TABLE `td_product_quanity_details` (
  `product_id` bigint(20) NOT NULL,
  `product_batch_no` varchar(40) DEFAULT NULL,
  `product_mfg_dt` date DEFAULT NULL,
  `product_expiry_dt` date DEFAULT NULL,
  `product_extra_info` varchar(400) DEFAULT NULL,
  `product_purchase_price` double NOT NULL,
  `product_purchase_vat` double DEFAULT NULL,
  `product_selling_price` double NOT NULL,
  `product_sell_vat` double DEFAULT NULL,
  `product_location` varchar(50) DEFAULT NULL,
  `product_quantity` bigint(20) DEFAULT NULL,
  `product_name` varchar(500) NOT NULL,
  `product_desc` varchar(1200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `td_product_quanity_details`
--

INSERT INTO `td_product_quanity_details` (`product_id`, `product_batch_no`, `product_mfg_dt`, `product_expiry_dt`, `product_extra_info`, `product_purchase_price`, `product_purchase_vat`, `product_selling_price`, `product_sell_vat`, `product_location`, `product_quantity`, `product_name`, `product_desc`) VALUES
(1, 'czf01389evlu36', '2016-06-01', NULL, 'no bargain', 72, 2, 78, 2, 'room2', 9966, 'Gold Flake', 'small'),
(2, '', '2016-02-02', NULL, '', 0.3, 2, 1, 2, 'room1', 0, 'family match box', 'matches'),
(3, 'czf01389evlu36', '2016-06-02', '2018-06-02', 'no bargain', 72, 2, 78, 2, 'room2', 0, 'Gold Flake', 'small'),
(4, 'czf01389evlu5', '2016-06-01', NULL, 'no bargain', 72, 2, 78, 2, 'room2', 0, 'Gold Flake', 'small');

--
-- Triggers `td_product_quanity_details`
--
DELIMITER $$
CREATE TRIGGER `add stock` AFTER INSERT ON `td_product_quanity_details` FOR EACH ROW insert into td_stock_details (product_id,product_desc,product_name) values (new.product_id, new.product_desc,new.product_name)
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `td_purchase_history`
--

CREATE TABLE `td_purchase_history` (
  `bill_no` bigint(20) NOT NULL,
  `godown_no` varchar(20) DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  `bill_amount` double NOT NULL,
  `payment_type` varchar(10) NOT NULL,
  `bill_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `paid_amount` double NOT NULL,
  `vat_amount` double NOT NULL,
  `basic_amount` double NOT NULL,
  `due_amount` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `td_purchase_history`
--

INSERT INTO `td_purchase_history` (`bill_no`, `godown_no`, `customer_id`, `bill_amount`, `payment_type`, `bill_date`, `paid_amount`, `vat_amount`, `basic_amount`, `due_amount`) VALUES
(1, NULL, NULL, 1170, 'CASH', '2016-07-20 20:58:08', 1100, 23.4, 1146.6, 70),
(2, NULL, NULL, 390, 'CASH', '2016-07-21 20:14:11', 0, 7.8, 382.2, 390),
(3, NULL, NULL, 10, 'CASH', '2016-07-21 20:17:14', 8, 0.2, 9.8, 2),
(4, NULL, NULL, 80, 'CASH', '2016-07-21 20:19:24', 80, 1.6, 78.4, 0),
(5, NULL, NULL, 1014, 'CASH', '2016-07-22 20:33:53', 0, 20.28, 993.72, 1014),
(6, NULL, NULL, 100, 'CASH', '2016-07-22 20:47:17', 0, 2, 98, 100),
(7, NULL, NULL, 10, 'CASH', '2016-07-22 20:56:57', 0, 0.2, 9.8, 10),
(8, NULL, NULL, 780, 'CASH', '2016-07-22 20:59:06', 0, 15.6, 764.4, 780),
(9, NULL, NULL, 780, 'CASH', '2016-07-22 20:59:06', 0, 15.6, 764.4, 780),
(10, NULL, NULL, 780, 'CASH', '2016-07-22 21:03:18', 0, 15.6, 764.4, 780),
(11, NULL, NULL, 780, 'CASH', '2016-07-22 21:06:27', 0, 15.6, 764.4, 780),
(12, NULL, NULL, 780, 'CASH', '2016-07-22 21:08:34', 0, 15.6, 764.4, 780),
(13, NULL, NULL, 936, 'CASH', '2016-07-22 21:19:12', 0, 18.72, 917.28, 936),
(14, NULL, NULL, 780, 'CASH', '2016-07-22 21:20:55', 0, 15.6, 764.4, 780),
(15, NULL, NULL, 858, 'CASH', '2016-07-22 21:32:19', 0, 17.16, 840.84, 858),
(16, NULL, NULL, 780, 'CASH', '2016-07-22 21:39:23', 0, 15.6, 764.4, 780),
(17, NULL, NULL, 858, 'CASH', '2016-07-22 21:41:38', 0, 17.16, 840.84, 858),
(18, NULL, NULL, 858, 'CASH', '2016-07-22 21:45:46', 0, 17.16, 840.84, 858),
(19, NULL, NULL, 858, 'CASH', '2016-07-22 21:50:14', 0, 17.16, 840.84, 858),
(20, NULL, NULL, 858, 'CASH', '2016-07-22 21:50:14', 0, 17.16, 840.84, 858),
(21, NULL, NULL, 858, 'CASH', '2016-07-22 21:50:14', 0, 17.16, 840.84, 858),
(22, NULL, NULL, 25662, 'CASH', '2016-07-22 23:30:55', 0, 513.24, 25148.76, 25662),
(23, NULL, NULL, 234, 'CASH', '2016-07-22 23:33:15', 0, 4.68, 229.32, 234),
(24, NULL, NULL, 390, 'CASH', '2016-07-22 23:43:03', 0, 7.8, 382.2, 390),
(25, NULL, NULL, 858, 'CASH', '2016-07-23 12:53:23', 0, 17.16, 840.84, 858),
(26, NULL, NULL, 78, 'CASH', '2016-07-23 13:08:08', 0, 1.56, 76.44, 78),
(27, NULL, NULL, 78, 'CASH', '2016-07-23 13:17:27', 0, 1.56, 76.44, 78),
(28, NULL, NULL, 78, 'CASH', '2016-07-23 13:17:27', 0, 1.56, 76.44, 78),
(29, NULL, NULL, -77, 'CASH', '2016-07-23 13:24:33', 0, -1.54, -75.46, -77),
(30, NULL, NULL, 77, 'CASH', '2016-07-23 13:26:59', 0, 1.54, 75.46, 77),
(31, NULL, NULL, 23712, 'CASH', '2016-07-23 13:29:41', 0, 474.24, 23237.76, 23712),
(32, NULL, NULL, 23556, 'CASH', '2016-07-23 13:38:47', 0, 471.12, 23084.88, 23556),
(33, NULL, NULL, 23556, 'CASH', '2016-07-23 13:38:47', 0, 471.12, 23084.88, 23556),
(34, NULL, NULL, 23400, 'CASH', '2016-07-23 13:49:32', 0, 468, 22932, 23400),
(35, NULL, NULL, 23322, 'CASH', '2016-07-23 13:59:44', 0, 466.44, 22855.56, 23322),
(36, NULL, NULL, 78, 'CASH', '2016-07-23 14:05:20', 0, 1.56, 76.44, 78),
(37, NULL, NULL, 23166, 'CASH', '2016-07-23 14:08:13', 0, 463.32, 22702.68, 23166),
(38, NULL, NULL, 78, 'CASH', '2016-07-23 22:11:05', 0, 1.56, 76.44, 78),
(39, NULL, NULL, 78, 'CASH', '2016-07-23 22:11:05', 0, 1.56, 76.44, 78),
(40, NULL, NULL, 78, 'CASH', '2016-07-23 22:33:25', 0, 1.56, 76.44, 78),
(41, NULL, NULL, 78, 'CASH', '2016-07-23 22:38:21', 0, 1.56, 76.44, 78),
(42, NULL, NULL, 156, 'CASH', '2016-07-24 02:40:58', 0, 3.12, 152.88, 156),
(43, NULL, NULL, 156, 'CASH', '2016-07-24 02:41:19', 0, 3.12, 152.88, 156),
(44, NULL, NULL, 156, 'CASH', '2016-07-24 02:42:21', 0, 3.12, 152.88, 156),
(45, NULL, NULL, 1, 'CASH', '2016-07-24 02:43:55', 0, 0.02, 0.98, 1),
(46, NULL, NULL, 10, 'CASH', '2016-07-24 02:45:19', 0, 0.2, 9.8, 10),
(47, NULL, NULL, 1, 'CASH', '2016-07-24 02:45:40', 0, 0.02, 0.98, 1),
(48, NULL, NULL, 1, 'CASH', '2016-07-24 02:47:00', 0, 0.02, 0.98, 1),
(49, NULL, NULL, 6, 'CASH', '2016-07-24 02:47:13', 0, 0.12, 5.88, 6),
(50, NULL, NULL, 6, 'CASH', '2016-07-24 02:47:13', 0, 0.12, 5.88, 6),
(51, NULL, NULL, 2, 'CASH', '2016-07-24 02:48:49', 0, 0.04, 1.96, 2),
(52, NULL, NULL, 2, 'CASH', '2016-07-24 02:53:58', 0, 0.04, 1.96, 2),
(53, NULL, NULL, 2, 'CASH', '2016-07-24 02:53:58', 0, 0.04, 1.96, 2),
(54, NULL, NULL, 10, 'CASH', '2016-07-24 02:58:34', 0, 0.2, 9.8, 10),
(55, NULL, NULL, 10, 'CASH', '2016-07-24 03:00:27', 0, 0.2, 9.8, 10),
(56, NULL, NULL, 10, 'CASH', '2016-07-24 03:00:27', 0, 0.2, 9.8, 10),
(57, NULL, NULL, 2, 'CASH', '2016-07-24 03:03:51', 0, 0.04, 1.96, 2),
(58, NULL, NULL, 1, 'CASH', '2016-07-24 03:05:14', 0, 0.02, 0.98, 1),
(59, NULL, NULL, 2, 'CASH', '2016-07-24 03:05:33', 0, 0.04, 1.96, 2),
(60, NULL, NULL, 1, 'CASH', '2016-07-24 03:07:36', 0, 0.02, 0.98, 1),
(61, NULL, NULL, 78, 'CASH', '2016-07-24 03:07:56', 0, 1.56, 76.44, 78),
(62, NULL, NULL, 156, 'CASH', '2016-07-24 03:11:15', 0, 3.12, 152.88, 156),
(63, NULL, NULL, 4, 'CASH', '2016-07-24 03:12:27', 0, 0.08, 3.92, 4),
(64, NULL, NULL, 156, 'CASH', '2016-07-24 03:24:57', 34, 3.12, 152.88, 122),
(65, NULL, NULL, 33, 'CASH', '2016-07-24 03:29:33', 0, 0.66, 32.34, 33),
(66, NULL, NULL, 78, 'CASH', '2016-07-24 03:33:40', 0, 1.56, 76.44, 78),
(67, NULL, NULL, 2, 'CASH', '2016-07-24 03:34:35', 0, 0.04, 1.96, 2),
(68, NULL, NULL, 2, 'CASH', '2016-07-24 03:35:34', 0, 0.04, 1.96, 2),
(69, NULL, NULL, 2, 'CASH', '2016-07-24 03:37:19', 0, 0.04, 1.96, 2),
(70, NULL, NULL, 156, 'CASH', '2016-07-24 03:37:51', 0, 3.12, 152.88, 156),
(71, NULL, NULL, 1, 'CASH', '2016-07-24 03:57:05', 0, 0.02, 0.98, 1),
(72, NULL, NULL, 1, 'CASH', '2016-07-24 03:57:20', 0, 0.02, 0.98, 1),
(73, NULL, NULL, 1, 'CASH', '2016-07-24 03:57:05', 0, 0.02, 0.98, 1),
(74, NULL, NULL, 1, 'CASH', '2016-07-24 04:04:34', 0, 0.02, 0.98, 1),
(75, NULL, NULL, 2, 'CASH', '2016-07-24 04:06:20', 0, 0.04, 1.96, 2),
(76, NULL, NULL, 1, 'CASH', '2016-07-24 04:07:32', 0, 0.02, 0.98, 1),
(77, NULL, NULL, 1, 'CASH', '2016-07-24 04:09:16', 0, 0.02, 0.98, 1),
(78, NULL, NULL, 1, 'CASH', '2016-07-24 04:09:31', 0, 0.02, 0.98, 1),
(79, NULL, NULL, 1, 'CASH', '2016-07-24 04:10:31', 0, 0.02, 0.98, 1),
(80, NULL, NULL, 1, 'CASH', '2016-07-24 04:10:44', 0, 0.02, 0.98, 1),
(81, NULL, NULL, 1, 'CASH', '2016-07-24 04:12:03', 0, 0.02, 0.98, 1),
(82, NULL, NULL, 1, 'CASH', '2016-07-24 04:13:32', 0, 0.02, 0.98, 1),
(83, NULL, NULL, 1, 'CASH', '2016-07-24 04:13:51', 0, 0.02, 0.98, 1),
(84, NULL, NULL, 1, 'CASH', '2016-07-24 04:20:43', 0, 0.02, 0.98, 1),
(85, NULL, NULL, 858, 'CASH', '2016-07-24 17:15:15', 0, 17.16, 840.84, 858),
(86, NULL, NULL, 11, 'CASH', '2016-07-24 17:15:40', 0, 0.22, 10.78, 11),
(87, NULL, NULL, 156, 'CASH', '2016-07-24 20:01:09', 0, 3.12, 152.88, 156),
(88, NULL, NULL, 156, 'CASH', '2016-07-24 20:01:29', 0, 3.12, 152.88, 156),
(89, NULL, NULL, 156, 'CASH', '2016-07-24 20:02:54', 0, 3.12, 152.88, 156),
(90, NULL, NULL, 78, 'CASH', '2016-07-24 20:03:31', 0, 1.56, 76.44, 78),
(91, NULL, NULL, 78, 'CASH', '2016-07-24 20:04:17', 0, 1.56, 76.44, 78),
(92, NULL, NULL, 390, 'CASH', '2016-07-24 20:05:20', 0, 7.8, 382.2, 390),
(93, NULL, NULL, 78, 'CASH', '2016-07-24 20:09:55', 0, 1.56, 76.44, 78),
(94, NULL, NULL, 78, 'CASH', '2016-07-24 20:19:11', 0, 1.56, 76.44, 78),
(95, NULL, NULL, 156, 'CASH', '2016-07-24 20:19:58', 0, 3.12, 152.88, 156),
(96, NULL, NULL, 29640, 'CASH', '2016-07-24 20:22:07', 0, 592.8, 29047.2, 29640),
(97, NULL, NULL, 1, 'CASH', '2016-07-24 20:23:46', 0, 0.02, 0.98, 1),
(98, NULL, NULL, 1, 'CASH', '2016-07-24 20:25:26', 0, 0.02, 0.98, 1),
(99, NULL, NULL, 1, 'CASH', '2016-07-24 20:32:27', 0, 0.02, 0.98, 1),
(100, NULL, NULL, 1, 'CASH', '2016-07-24 20:35:46', 0, 0.02, 0.98, 1),
(101, NULL, NULL, 156, 'CASH', '2016-07-24 20:36:02', 0, 3.12, 152.88, 156),
(102, NULL, NULL, 1, 'CASH', '2016-07-24 20:51:02', 0, 0.02, 0.98, 1),
(103, NULL, NULL, 78, 'CASH', '2016-07-24 20:51:38', 0, 1.56, 76.44, 78),
(104, NULL, NULL, 1, 'CASH', '2016-07-24 20:53:05', 0, 0.02, 0.98, 1),
(105, NULL, NULL, 78, 'CASH', '2016-07-24 20:51:38', 0, 1.56, 76.44, 78),
(106, NULL, NULL, 98473, 'CASH', '2016-07-24 20:53:56', 0, 1969.46, 96503.54, 98473),
(107, NULL, NULL, 78, 'CASH', '2016-07-24 20:51:38', 0, 1.56, 76.44, 78),
(108, NULL, NULL, 858, 'CASH', '2016-07-24 20:55:23', 0, 17.16, 840.84, 858),
(109, NULL, NULL, 78, 'CASH', '2016-07-24 20:51:38', 0, 1.56, 76.44, 78),
(110, NULL, NULL, 23634, 'CASH', '2016-07-24 20:56:11', 0, 472.68, 23161.32, 23634),
(111, NULL, NULL, 0, 'CASH', '2016-07-24 21:10:31', 0, 0, 0, 0),
(112, NULL, NULL, 156, 'CASH', '2016-07-24 21:31:39', 0, 3.12, 152.88, 156),
(113, NULL, NULL, 156, 'CASH', '2016-07-24 21:32:23', 0, 3.12, 152.88, 156),
(114, NULL, NULL, 156, 'CASH', '2016-07-24 21:32:37', 0, 3.12, 152.88, 156),
(115, NULL, NULL, 78, 'CASH', '2016-07-24 21:33:19', 0, 1.56, 76.44, 78),
(116, NULL, NULL, 156, 'CASH', '2016-07-25 00:00:40', 0, 3.12, 152.88, 156),
(117, NULL, NULL, 78, 'CASH', '2016-07-26 00:43:24', 0, 1.56, 76.44, 78),
(118, NULL, NULL, 78, 'CASH', '2016-07-26 20:38:58', 0, 1.56, 76.44, 78),
(119, NULL, NULL, 78, 'CASH', '2016-07-26 20:42:50', 0, 1.56, 76.44, 78),
(120, NULL, NULL, 78, 'CASH', '2016-07-26 20:46:36', 0, 1.56, 76.44, 78),
(121, NULL, NULL, 78, 'CASH', '2016-07-26 20:48:02', 0, 1.56, 76.44, 78),
(122, NULL, NULL, 78, 'CASH', '2016-07-26 20:48:02', 0, 1.56, 76.44, 78),
(123, NULL, NULL, 78, 'CASH', '2016-07-26 20:49:01', 0, 1.56, 76.44, 78),
(124, NULL, NULL, 78, 'CASH', '2016-07-26 20:49:01', 0, 1.56, 76.44, 78),
(125, NULL, NULL, 78, 'CASH', '2016-07-26 20:51:53', 0, 1.56, 76.44, 78),
(126, NULL, NULL, 78, 'CASH', '2016-07-26 20:52:56', 0, 1.56, 76.44, 78),
(127, NULL, NULL, 78, 'CASH', '2016-07-26 20:53:06', 0, 1.56, 76.44, 78),
(128, NULL, NULL, 78, 'CASH', '2016-07-26 20:56:23', 0, 1.56, 76.44, 78),
(129, NULL, NULL, 78, 'CASH', '2016-07-26 20:56:36', 0, 1.56, 76.44, 78),
(130, NULL, NULL, 78, 'CASH', '2016-07-26 20:59:11', 0, 1.56, 76.44, 78),
(131, NULL, NULL, 78, 'CASH', '2016-07-26 20:59:43', 0, 1.56, 76.44, 78),
(132, NULL, NULL, 78, 'CASH', '2016-07-26 21:02:10', 0, 1.56, 76.44, 78),
(133, NULL, NULL, 78, 'CASH', '2016-07-26 21:03:16', 0, 1.56, 76.44, 78),
(134, NULL, NULL, 78, 'CASH', '2016-07-26 21:16:28', 0, 1.56, 76.44, 78),
(135, NULL, NULL, 78, 'CASH', '2016-07-26 21:18:15', 0, 1.56, 76.44, 78),
(136, NULL, NULL, 78, 'CASH', '2016-07-26 21:18:27', 0, 1.56, 76.44, 78),
(137, NULL, NULL, 78, 'CASH', '2016-07-26 21:23:12', 0, 1.56, 76.44, 78),
(138, NULL, NULL, 78, 'CASH', '2016-07-26 21:23:39', 0, 1.56, 76.44, 78),
(139, NULL, NULL, 78, 'CASH', '2016-07-26 21:24:00', 0, 1.56, 76.44, 78),
(140, NULL, NULL, 78, 'CASH', '2016-07-26 21:25:31', 0, 1.56, 76.44, 78),
(141, NULL, NULL, 78, 'CASH', '2016-07-26 21:25:46', 0, 1.56, 76.44, 78),
(142, NULL, NULL, 78, 'CASH', '2016-07-26 23:04:15', 0, 1.56, 76.44, 78),
(143, NULL, NULL, 78, 'CASH', '2016-07-26 23:27:46', 0, 1.56, 76.44, 78),
(144, NULL, NULL, 78, 'CASH', '2016-07-26 23:31:38', 0, 1.56, 76.44, 78),
(145, NULL, NULL, 78, 'CASH', '2016-07-26 23:36:31', 0, 1.56, 76.44, 78),
(146, NULL, NULL, 78, 'CASH', '2016-07-26 23:37:36', 0, 1.56, 76.44, 78),
(147, NULL, NULL, 78, 'CASH', '2016-07-26 23:37:36', 0, 1.56, 76.44, 78),
(148, NULL, NULL, 78, 'CASH', '2016-07-27 00:16:48', 0, 1.56, 76.44, 78),
(149, NULL, NULL, 78, 'CASH', '2016-07-27 00:18:19', 0, 1.56, 76.44, 78),
(150, NULL, NULL, 78, 'CASH', '2016-07-27 00:23:08', 0, 1.56, 76.44, 78),
(151, NULL, NULL, 78, 'CASH', '2016-07-27 00:23:45', 0, 1.56, 76.44, 78),
(152, NULL, NULL, 78, 'CASH', '2016-07-27 00:27:00', 0, 1.56, 76.44, 78),
(153, NULL, NULL, 78, 'CASH', '2016-07-27 00:28:10', 0, 1.56, 76.44, 78),
(154, NULL, NULL, 78, 'CASH', '2016-07-27 00:37:30', 0, 1.56, 76.44, 78),
(155, NULL, NULL, 78, 'CASH', '2016-07-27 00:38:30', 0, 1.56, 76.44, 78),
(156, NULL, NULL, 78, 'CASH', '2016-07-27 00:42:14', 0, 1.56, 76.44, 78),
(157, NULL, NULL, 78, 'CASH', '2016-07-27 00:51:40', 0, 1.56, 76.44, 78),
(158, NULL, NULL, 78, 'CASH', '2016-07-27 00:52:11', 0, 1.56, 76.44, 78),
(159, NULL, NULL, 78, 'CASH', '2016-07-27 00:53:44', 0, 1.56, 76.44, 78),
(160, NULL, NULL, 78, 'CASH', '2016-07-28 23:19:07', 0, 1.56, 76.44, 78),
(161, NULL, NULL, 78, 'CASH', '2016-07-28 23:21:09', 0, 1.56, 76.44, 78);

-- --------------------------------------------------------

--
-- Table structure for table `td_shop_config`
--

CREATE TABLE `td_shop_config` (
  `shop_id` bigint(250) NOT NULL,
  `shop_name` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `td_shop_config`
--

INSERT INTO `td_shop_config` (`shop_id`, `shop_name`) VALUES
(1, 'BGS');

-- --------------------------------------------------------

--
-- Table structure for table `td_stock_details`
--

CREATE TABLE `td_stock_details` (
  `product_id` bigint(20) NOT NULL,
  `product_name` varchar(500) NOT NULL,
  `Product_desc` varchar(1200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `td_stock_details`
--

INSERT INTO `td_stock_details` (`product_id`, `product_name`, `Product_desc`) VALUES
(1, 'gold flake', 'small'),
(2, 'family match box', 'matches'),
(3, 'Gold Flake', 'small'),
(4, 'Gold Flake', 'small');

-- --------------------------------------------------------

--
-- Table structure for table `td_user_login`
--

CREATE TABLE `td_user_login` (
  `user_id` bigint(10) NOT NULL,
  `user_name` varchar(15) NOT NULL,
  `email` varchar(250) NOT NULL,
  `password` varchar(30) NOT NULL,
  `shop_id` bigint(20) NOT NULL,
  `user_role` varchar(20) NOT NULL,
  `status` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `td_user_login`
--

INSERT INTO `td_user_login` (`user_id`, `user_name`, `email`, `password`, `shop_id`, `user_role`, `status`) VALUES
(1, 'namadipta', 'namadipta.patro@gmail.com', 'test', 1, 'Admin', 'A');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `td_customer_balance`
--
ALTER TABLE `td_customer_balance`
  ADD PRIMARY KEY (`customer_id`);

--
-- Indexes for table `td_customer_balance_details`
--
ALTER TABLE `td_customer_balance_details`
  ADD PRIMARY KEY (`balance_details_code`);

--
-- Indexes for table `td_customer_details`
--
ALTER TABLE `td_customer_details`
  ADD PRIMARY KEY (`customer_id`),
  ADD UNIQUE KEY `mobile` (`mobile`),
  ADD UNIQUE KEY `godown_no` (`godown_no`);

--
-- Indexes for table `td_customer_search`
--
ALTER TABLE `td_customer_search`
  ADD PRIMARY KEY (`customer_id`),
  ADD KEY `idx_name_mobile` (`name`,`mobile`);

--
-- Indexes for table `td_item_details_for_bill`
--
ALTER TABLE `td_item_details_for_bill`
  ADD PRIMARY KEY (`bill_item_details`);

--
-- Indexes for table `td_product_quanity_details`
--
ALTER TABLE `td_product_quanity_details`
  ADD PRIMARY KEY (`product_id`),
  ADD UNIQUE KEY `product_id` (`product_id`);

--
-- Indexes for table `td_purchase_history`
--
ALTER TABLE `td_purchase_history`
  ADD PRIMARY KEY (`bill_no`);

--
-- Indexes for table `td_shop_config`
--
ALTER TABLE `td_shop_config`
  ADD PRIMARY KEY (`shop_id`);

--
-- Indexes for table `td_stock_details`
--
ALTER TABLE `td_stock_details`
  ADD PRIMARY KEY (`product_id`),
  ADD UNIQUE KEY `product_id` (`product_id`);

--
-- Indexes for table `td_user_login`
--
ALTER TABLE `td_user_login`
  ADD PRIMARY KEY (`user_name`),
  ADD UNIQUE KEY `idx_user_id` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `td_customer_balance_details`
--
ALTER TABLE `td_customer_balance_details`
  MODIFY `balance_details_code` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=142;
--
-- AUTO_INCREMENT for table `td_customer_details`
--
ALTER TABLE `td_customer_details`
  MODIFY `customer_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `td_item_details_for_bill`
--
ALTER TABLE `td_item_details_for_bill`
  MODIFY `bill_item_details` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=162;
--
-- AUTO_INCREMENT for table `td_product_quanity_details`
--
ALTER TABLE `td_product_quanity_details`
  MODIFY `product_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `td_purchase_history`
--
ALTER TABLE `td_purchase_history`
  MODIFY `bill_no` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=162;
--
-- AUTO_INCREMENT for table `td_shop_config`
--
ALTER TABLE `td_shop_config`
  MODIFY `shop_id` bigint(250) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `td_user_login`
--
ALTER TABLE `td_user_login`
  MODIFY `user_id` bigint(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
