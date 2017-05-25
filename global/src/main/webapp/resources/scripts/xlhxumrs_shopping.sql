-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 24, 2017 at 11:09 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 7.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `xlhxumrs_shopping`
--

-- --------------------------------------------------------

--
-- Table structure for table `td_cash_transaction`
--

CREATE TABLE `td_cash_transaction` (
  `cash_record_id` bigint(20) NOT NULL,
  `customer_id` bigint(20) NOT NULL,
  `amount` double NOT NULL,
  `paymentType` varchar(20) NOT NULL,
  `goddown_no` varchar(20) NOT NULL,
  `cash_record_date` datetime NOT NULL,
  `name` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `td_cash_transaction`
--

INSERT INTO `td_cash_transaction` (`cash_record_id`, `customer_id`, `amount`, `paymentType`, `goddown_no`, `cash_record_date`, `name`) VALUES
(1, 1, 1000, 'Cash', '1', '2016-10-15 13:28:25', 'Vicky');

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
(1, '1', 1000, 'Vicky');

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
  `name` varchar(50) NOT NULL,
  `bill_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `td_customer_balance_details`
--

INSERT INTO `td_customer_balance_details` (`balance_details_code`, `customer_id`, `goddown_no`, `bill_no`, `bill_amount`, `paid_amount`, `due_amount`, `name`, `bill_date`) VALUES
(3, 1, '1', 3, 480, 0, 480, 'Vicky', '2016-10-13 23:01:54'),
(4, 1, '1', 15, 440, 0, 440, 'Vicky', '2016-10-16 03:25:16'),
(5, 1, '1', 16, 40, 0, 40, 'Vicky', '2017-05-13 21:06:37');

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
(1, '1', 'Vicky', 'namadipta.patro@gmail.com', 'Tf314,passion Elite-2,electronic City', 'KA', 'Banglore', '9886275563', '', '', NULL);

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
('1', 1, 'Vicky', '9886275563');

-- --------------------------------------------------------

--
-- Table structure for table `td_item_details_for_bill`
--

CREATE TABLE `td_item_details_for_bill` (
  `bill_item_details` bigint(20) NOT NULL,
  `bill_no` bigint(20) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  `sell_price` double NOT NULL,
  `quantity` int(11) NOT NULL,
  `sell_vat` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `td_item_details_for_bill`
--

INSERT INTO `td_item_details_for_bill` (`bill_item_details`, `bill_no`, `product_id`, `sell_price`, `quantity`, `sell_vat`) VALUES
(1, 1, 1, 40, 2, 0),
(2, 2, 1, 40, 23, 0),
(3, 3, 1, 40, 12, 0),
(4, 15, 1, 40, 11, 2),
(5, 16, 1, 40, 1, 2),
(6, 17, 1, 40, 6, 2);

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
(1, '', NULL, NULL, '', 36, 2, 40, 2, '2nd Room', 2944, 'Thums Up', 'Cold Drink');

--
-- Triggers `td_product_quanity_details`
--
DELIMITER $$
CREATE TRIGGER `add stock` AFTER INSERT ON `td_product_quanity_details` FOR EACH ROW insert into td_stock_details (product_id,product_desc,product_name) values (new.product_id, new.product_desc,new.product_name)
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `td_profit_loss`
--

CREATE TABLE `td_profit_loss` (
  `day` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Amount` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `td_profit_loss`
--

INSERT INTO `td_profit_loss` (`day`, `Amount`) VALUES
('2016-10-15 18:30:00', 9.439999999999998),
('2016-10-15 21:39:22', 9.439999999999998),
('2016-10-15 21:40:09', 9.439999999999998),
('2016-10-15 21:40:32', 117.99999999999994),
('2016-10-15 21:40:53', 174.63999999999993),
('2016-10-15 21:40:54', 9.439999999999998),
('2016-10-15 21:40:55', 9.439999999999998),
('2016-10-15 21:40:56', 9.439999999999998),
('2016-10-15 21:40:57', 9.439999999999998),
('2016-10-15 21:40:58', 9.439999999999998),
('2016-10-15 21:40:59', 9.439999999999998),
('2016-10-15 21:41:00', 9.439999999999998),
('2016-10-15 21:41:47', 9.439999999999998),
('2016-10-15 21:42:56', 108.55999999999995),
('2016-10-15 21:43:15', 165.19999999999993);

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
  `due_amount` double NOT NULL,
  `processed` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `td_purchase_history`
--

INSERT INTO `td_purchase_history` (`bill_no`, `godown_no`, `customer_id`, `bill_amount`, `payment_type`, `bill_date`, `paid_amount`, `vat_amount`, `basic_amount`, `due_amount`, `processed`) VALUES
(1, '1', 1, 80, 'CASH', '2016-10-10 20:04:57', 0, 1.6, 78.4, 80, 'D'),
(2, '1', 1, 920, 'CASH', '2016-10-10 20:05:19', 300, 18.4, 901.6, 620, 'D'),
(3, '1', 1, 480, 'CASH', '2016-10-13 23:01:54', 0, 9.6, 470.4, 480, 'D'),
(4, '1', 1, 80, 'CASH', '2016-10-10 20:04:57', 0, 1.6, 78.4, 80, 'D'),
(5, '1', 1, 80, 'CASH', '2016-10-10 20:04:57', 0, 1.6, 78.4, 80, 'D'),
(6, '1', 1, 920, 'CASH', '2016-10-10 20:05:19', 300, 18.4, 901.6, 620, 'D'),
(7, '1', 1, 480, 'CASH', '2016-10-13 23:01:54', 0, 9.6, 470.4, 480, 'D'),
(8, '1', 1, 80, 'CASH', '2016-10-10 20:04:57', 0, 1.6, 78.4, 80, 'D'),
(9, '1', 1, 80, 'CASH', '2016-10-10 20:04:57', 0, 1.6, 78.4, 80, 'D'),
(10, '1', 1, 80, 'CASH', '2016-10-10 20:04:57', 0, 1.6, 78.4, 80, 'D'),
(11, '1', 1, 80, 'CASH', '2016-10-10 20:04:57', 0, 1.6, 78.4, 80, 'D'),
(12, '1', 1, 80, 'CASH', '2016-10-10 20:04:57', 0, 1.6, 78.4, 80, 'D'),
(13, '1', 1, 80, 'CASH', '2016-10-10 20:04:57', 0, 1.6, 78.4, 80, 'D'),
(14, '1', 1, 80, 'CASH', '2016-10-10 20:04:57', 0, 1.6, 78.4, 80, 'D'),
(15, '1', 1, 440, 'CASH', '2016-10-16 03:25:16', 0, 8.8, 431.2, 440, NULL),
(16, '1', 1, 40, 'CASH', '2017-05-13 21:06:37', 0, 0.8, 39.2, 40, NULL),
(17, NULL, NULL, 240, 'CASH', '2017-05-13 21:07:22', 0, 4.8, 235.2, 240, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `td_shop_config`
--

CREATE TABLE `td_shop_config` (
  `shop_id` bigint(250) NOT NULL,
  `shop_name` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
(1, 'Thums Up', 'Cold Drink');

-- --------------------------------------------------------

--
-- Table structure for table `td_user_log`
--

CREATE TABLE `td_user_log` (
  `user_id` varchar(50) NOT NULL,
  `shop_id` varchar(20) NOT NULL,
  `ip_address` varchar(25) NOT NULL,
  `session_id` varchar(200) NOT NULL,
  `User_track_id` bigint(20) NOT NULL,
  `loggin_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `logedout_date` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `td_user_log`
--

INSERT INTO `td_user_log` (`user_id`, `shop_id`, `ip_address`, `session_id`, `User_track_id`, `loggin_date`, `logedout_date`) VALUES
('1', '1', '0:0:0:0:0:0:0:1', '1548164E88B79C81C4A5CC5A8F467ECF', 1, '2016-10-09 11:56:02', '2016-10-09 11:56:24'),
('1', '1', '0:0:0:0:0:0:0:1', '619FA37B6BDDD2819C1A61665191AC73', 2, '2016-10-09 11:56:37', NULL),
('1', '1', '0:0:0:0:0:0:0:1', 'A53A9D983E482A65390C23508F528790', 3, '2016-10-09 12:38:01', NULL),
('1', '1', '0:0:0:0:0:0:0:1', 'C9BDBD0A2EB9736E6D518DA833116241', 4, '2016-10-10 14:31:42', NULL),
('1', '1', '0:0:0:0:0:0:0:1', 'A6CF9ADB76B30148A756955593541D72', 5, '2016-10-10 16:52:15', '2016-10-10 17:43:23'),
('1', '1', '0:0:0:0:0:0:0:1', '77DF13852FE995AFD971EAFB356B239B', 6, '2016-10-10 17:43:26', NULL),
('1', '1', '0:0:0:0:0:0:0:1', 'CFA3B59FA2859C6466036FB6797F8EC0', 7, '2016-10-13 17:31:45', NULL),
('1', '1', '0:0:0:0:0:0:0:1', '4B3B052E460211738E7F75C5DE113E3D', 8, '2016-10-13 18:08:43', NULL),
('1', '1', '0:0:0:0:0:0:0:1', '3887DB59236B4FDB341EDC24BBFCD5E2', 9, '2016-10-13 18:15:41', NULL),
('1', '1', '0:0:0:0:0:0:0:1', '3887DB59236B4FDB341EDC24BBFCD5E2', 10, '2016-10-13 18:48:28', NULL),
('1', '1', '0:0:0:0:0:0:0:1', '2E58B08BF247C9A4934ED1A7A9946430', 11, '2016-10-15 06:53:52', NULL),
('1', '1', '0:0:0:0:0:0:0:1', '3061F702AFB5681B5628D8D32AC04480', 12, '2016-10-15 13:02:56', NULL),
('1', '1', '0:0:0:0:0:0:0:1', 'E98246F60F122BDB2A1CCEE40061F5EC', 13, '2016-10-15 18:31:20', NULL),
('1', '1', '0:0:0:0:0:0:0:1', '80EF4387AFD3DF1D3FAD6748C77E8A69', 14, '2016-10-15 21:09:42', NULL),
('1', '1', '0:0:0:0:0:0:0:1', '18CEB0C536D798DD9AD54973883C2110', 15, '2016-10-15 21:47:29', '2016-10-15 21:49:05'),
('1', '1', '0:0:0:0:0:0:0:1', '6E3F921D8C16617218C6C382BA95BCA6', 16, '2016-10-15 21:49:08', '2016-10-15 22:00:11'),
('1', '1', '0:0:0:0:0:0:0:1', 'E67C75F7D5036E5B494FF0A94DD2E224', 17, '2016-10-16 06:31:30', NULL),
('1', '1', '0:0:0:0:0:0:0:1', 'E67C75F7D5036E5B494FF0A94DD2E224', 18, '2016-10-16 06:53:49', NULL),
('1', '1', '0:0:0:0:0:0:0:1', 'A771F3323B9F287A0C9002CC2048F8E9', 19, '2016-10-16 08:05:42', '2016-10-16 08:36:02'),
('1', '1', '0:0:0:0:0:0:0:1', '8C2EE00C877660844961EFC16D969424', 20, '2016-10-16 08:37:47', '2016-10-16 08:42:38'),
('1', '1', '0:0:0:0:0:0:0:1', '01BFE82C985F164ABDFD5B3B45B9ECDA', 21, '2016-10-16 19:31:40', '2016-10-16 19:32:49'),
('1', '1', '0:0:0:0:0:0:0:1', 'E6593B022951208761402BE1085F15E3', 22, '2016-10-17 19:29:35', '2016-10-17 19:29:43'),
('1', '1', '0:0:0:0:0:0:0:1', '0B754F17B5BBF9098A6F971A908EA98B', 23, '2016-10-17 19:29:56', '2016-10-17 19:30:06'),
('1', '1', '0:0:0:0:0:0:0:1', '5406C25DE5C923964BD5DC6EDDDC7147', 24, '2016-10-17 19:32:41', '2016-10-17 19:33:10'),
('1', '1', '0:0:0:0:0:0:0:1', '1F67E0CC3A1036A085C46F093D880180', 25, '2016-10-20 18:52:09', '2016-10-20 18:52:20'),
('1', '1', '0:0:0:0:0:0:0:1', '24896DF5497064D20548D22DF9343B8F', 26, '2016-10-21 18:25:37', '2016-10-21 18:25:47'),
('1', '1', '0:0:0:0:0:0:0:1', '1A80DC24AFDF15B8EBCC208DADBB8ECC', 27, '2016-10-21 18:33:09', NULL),
('1', '1', '0:0:0:0:0:0:0:1', 'F6D0D258214E10553B98CB02F19C45CC', 28, '2017-05-13 15:32:45', '2017-05-13 15:33:28'),
('1', '1', '0:0:0:0:0:0:0:1', 'A7420DA8CCAAB6881BB0E2648E90023A', 29, '2017-05-13 15:33:36', NULL),
('1', '1', '0:0:0:0:0:0:0:1', '52B57A23B4F6825CF173E44E1C5516FE', 30, '2017-05-17 17:48:52', NULL),
('1', '1', '0:0:0:0:0:0:0:1', 'A3D392793762104AB8A9EE03AE0C582D', 31, '2017-05-18 06:15:39', NULL),
('1', '1', '0:0:0:0:0:0:0:1', 'A3D392793762104AB8A9EE03AE0C582D', 32, '2017-05-18 06:15:39', NULL),
('1', '1', '0:0:0:0:0:0:0:1', 'A3D392793762104AB8A9EE03AE0C582D', 33, '2017-05-18 06:30:56', NULL),
('1', '1', '0:0:0:0:0:0:0:1', '9C06599A33F564ED8D83050DE6C28BFD', 34, '2017-05-18 06:44:35', NULL),
('1', '1', '0:0:0:0:0:0:0:1', '85A704A27A5B0C72417E712F107537C2', 35, '2017-05-18 06:49:38', NULL),
('1', '1', '0:0:0:0:0:0:0:1', 'A8E14B1DAE5FA07B9F549B970F99BBEB', 36, '2017-05-18 07:18:10', NULL),
('1', '1', '0:0:0:0:0:0:0:1', '6D54E4F4D4631B7AED847B0527C98993', 37, '2017-05-18 07:35:35', NULL),
('1', '1', '0:0:0:0:0:0:0:1', '85766A88DB68BAB4C70013191D98FF1A', 38, '2017-05-18 07:48:27', NULL);

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
(1, 'Namadipta', 'namadipta.patro@gmail.com', '123', 1, 'Admin', 'A');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `td_cash_transaction`
--
ALTER TABLE `td_cash_transaction`
  ADD PRIMARY KEY (`cash_record_id`);

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
-- Indexes for table `td_profit_loss`
--
ALTER TABLE `td_profit_loss`
  ADD PRIMARY KEY (`day`);

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
-- Indexes for table `td_user_log`
--
ALTER TABLE `td_user_log`
  ADD PRIMARY KEY (`User_track_id`);

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
-- AUTO_INCREMENT for table `td_cash_transaction`
--
ALTER TABLE `td_cash_transaction`
  MODIFY `cash_record_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `td_customer_balance_details`
--
ALTER TABLE `td_customer_balance_details`
  MODIFY `balance_details_code` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `td_customer_details`
--
ALTER TABLE `td_customer_details`
  MODIFY `customer_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `td_item_details_for_bill`
--
ALTER TABLE `td_item_details_for_bill`
  MODIFY `bill_item_details` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `td_product_quanity_details`
--
ALTER TABLE `td_product_quanity_details`
  MODIFY `product_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `td_purchase_history`
--
ALTER TABLE `td_purchase_history`
  MODIFY `bill_no` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT for table `td_shop_config`
--
ALTER TABLE `td_shop_config`
  MODIFY `shop_id` bigint(250) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `td_user_log`
--
ALTER TABLE `td_user_log`
  MODIFY `User_track_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;
--
-- AUTO_INCREMENT for table `td_user_login`
--
ALTER TABLE `td_user_login`
  MODIFY `user_id` bigint(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
