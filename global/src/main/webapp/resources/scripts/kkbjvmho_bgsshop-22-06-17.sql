-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 21, 2017 at 02:28 PM
-- Server version: 5.6.35-log
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kkbjvmho_bgsshop`
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
  `goddown_no` varchar(100) DEFAULT NULL,
  `cash_record_date` datetime NOT NULL,
  `name` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `td_customer_balance`
--

CREATE TABLE `td_customer_balance` (
  `customer_id` bigint(20) NOT NULL,
  `godownno` varchar(100) DEFAULT NULL,
  `total_balance` double NOT NULL DEFAULT '0',
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `td_customer_balance_details`
--

CREATE TABLE `td_customer_balance_details` (
  `balance_details_code` bigint(20) NOT NULL,
  `customer_id` bigint(20) NOT NULL,
  `goddown_no` varchar(100) DEFAULT NULL,
  `bill_no` bigint(20) NOT NULL,
  `bill_amount` double NOT NULL,
  `paid_amount` double NOT NULL,
  `due_amount` double NOT NULL,
  `name` varchar(50) NOT NULL,
  `bill_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `godown_no` varchar(100) DEFAULT NULL,
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
(2, '95x(senapati lori)', 'krushna ready(jagannath stor)', '', 'aska main road.', 'Odisha', 'Aska', '9437412974', '', '', NULL),
(3, '80(GANJAM LORI)', 'RAM MRUTI PARTO', '', 'NIRAJAN NAGAR ', 'ODISHA', 'ASKA', '9861733783', '', '', NULL),
(4, '21(GANJAM LORI)', 'A.NILACHALA PATRO(MAHA LAXMI ENGESY)', '', 'ASKA MAIN ROAD (TIN NO-21385101650)', 'ODISHA', 'BERHAMPUE', '9861282612', '', '', NULL),
(5, '99(BRUDABANA LLORI)', 'A.GANGA DHARA PATRO(GANGA DHARA ENTER PRICES)', '', 'BALIPADAR MAINROAD (TIN NO-21451902212)', 'ODISHA', 'BALIPADAR', '9937590492', '', '', NULL),
(6, '46(BRUDABAN LORI)', 'LAXMAN POLAI', '', 'BALIPADAR MAINROAD ', 'odisha', 'BALIPADAR', '9938184639', '', '', NULL),
(7, 'NP(PRADHANA LORI)', 'RANJENDRA PRUSTI ', '', 'BHANJANAGAR MAINROAD', 'ODISHA', 'BHANJANAGAR', '9937907664', '', '', NULL),
(8, 'SB(RADHAKANTA LORI)', 'MONAJ SUBUDHI', '', 'BADAMADHAPUR', 'ODISHA', 'CHATRAPUR', '9938274796', '', '', NULL),
(9, 'SKM(NIRMAL LORI)', 'K.SUSANT KU. MAHAPATRO', '', 'BALIGUDA MAINROAD', 'ODISHA', 'BALIGUDA', '9437770488', '', '', NULL),
(10, 'MKS(RADHAKANTA LORI)', 'MAHENDRA SAHU(MAHENDRA SAHU ENTERPRICES)', '', 'TARINI STREET CHATRAPUR', 'ODISHA', 'CHATRAPUR', '9132373737', '', '', NULL),
(11, '(X)(RADHAKANTALORI)', 'K.SURYA NARAYANA PATRO', '', 'CORT STATION STREET CHATRAPUR', 'ODISHA', 'CHATRAPUR', '9861234621', '', '', NULL),
(12, '351(BANADAVI)', 'RABINDRA NATH PADHY', '', 'GOUDADHAPA KABISURYA NAGAR', '', 'KABISURYA NAGAR', '9776463127', '', '', NULL),
(13, '416(BANADAVI LORI)', 'K.GOURI SANKAR PATRO(SRABA MANGALA MARGO)', '', 'KABISURYA NAGAR', 'ODISHA', 'KABISURYA NAGAR', '7377563686', '', '', NULL),
(14, '78(RADHAKANTA LORI)', 'MODAN MOHAN CHARTY', '', 'KOROPADA MAINROAD', 'ODISHA', 'KOROPADA', '9583167799', '', '', NULL),
(15, '58(SANAPATIN LORI)', 'K.BADRI NARAYANA PATRO(NARAYANI TRADERS)', '', 'MUNDA MARAI(TIN NO-21525101767)', 'ODISHA', 'MUNDA MARIA', '9437325486', '', '', NULL),
(16, '091(NATABARLAL LORI)', 'BHABANI MAHAPATRO(MAHAPATRO GENERAL STOR)', '', 'HANUMAN BAZAR MAINROAD PURUSOTAM PUR', 'ODISHA', 'PURUSOTAM PUR', '9090458772', '', '', NULL),
(17, '95X(NATABARLAL LORI)', 'GANGA BEHERA', '', 'PURUSOTAM PUR MAINROAD', '', '', '9861561933', '', '', NULL),
(18, '501(BAJARANGI LORI)', 'A.RAJARAO PATRO', '', 'BAZAR STREET, PITALA', 'ODISHA', 'PITALA', '8018505071', '', '', NULL),
(19, '158(PRADHAN LORI)', 'SRIKANTA DAS ', '', 'PAILIPADA MAINROAD', 'ODISHA', 'PAILIPADA', '9438521997', '', '', NULL),
(20, 'PS(NATABARA LORI)', 'SANTOSH KU. SAHU', '', 'PANDIA MAINROAD', 'ODISHA', 'PANDIA', '9938599118', '', '', NULL),
(21, 'ND(KURAISUNI)', 'PRAMOD KU.PATRO', '', 'R.UDAYAGIRI MAINROAD', 'ODISHA', 'R.UDAYAGIRI', '9438138242', '', '', NULL),
(22, 'K4XX(KURAISUNI LORI)', 'K.RAJARAO PATRO', '', 'LUBRISING', 'ODISHA', 'R.UDAYAGIRI', '9439406582', '', '', NULL),
(23, '555(SRI GANESH LORI)', 'PRABHAT KU. PADHY', '', 'SARODA MAINROAD', 'ODISHA', 'SARODA', '7735313099', '', '', NULL),
(24, '521(MAHA MAYI LORI)', 'MITU SUBUDHI', '', 'SHERAGADA MAINROAD', 'ODISHA', 'SHERAGADA', '9937429195', '', '', NULL),
(25, '331(MAHAMAI LORI)', 'P.SUBARAO PATRO', '', 'KORODA KANA', 'ODISHA', 'SAROGADA', '9938275780', '', '', NULL),
(26, 'LGS(MAHAMAI LORI)', 'B.BHAGABAN PATRO', '', 'CHARI CHAKA SAROGADA', '', 'SAROGADA', '9938183926', '', '', NULL),
(27, '202(BAPANGI LORI)', 'A.PURNA CHANDRA SARAB', '', 'TIKABALI MAINROAD', 'ODISHA', 'TIKABALI', '9437412603', '', '', NULL),
(28, '', 's.simanchla patro(tansen free general stor)', '', 'BHAIRABI MARCKET ', 'odisha', 'berhampur', '9861168835', '', '', NULL),
(29, '', 'G.GOBINDA', '', 'SHIKHAKULAM MAINROAD', 'ODISHA', 'SHIKHAKULAM', '8121605145', '', '', NULL),
(30, '', 'PRAFULA KU. PADHY(SRI KRISHNA STOR)', '', 'MATA SAHI, OLD BERHAMPUR', 'ODISHA', 'BERHAMPUR', '9237234358', '', '', NULL),
(31, '', 'PARAMANANDA SAHU', '', 'CENTER POINT (SANKAR BINAYAK COMPLEX)', 'ODISHA', 'BERHAMPUR', '9938407508', '', '', NULL),
(32, '', 'PAPUN PATRO(PATAKHANDA TRANSPORT)', '', 'RAJA SAHI ', 'ODISHA', 'BERHAMPUR', '9437454970', '', '', NULL),
(33, '', 'PRATAP KUMAR SADAGI', '', 'GAJAPATI NAGAR', 'ODISHA', 'BERHAMPUR', '8093881411', '', '', NULL),
(34, '', 'A.MOHAN RAO', '', 'CHANDAN MARCKET', 'ODISHA', 'BERHAMPUR', '9040301160', '', '', NULL),
(35, '', 'SRIVASU RAO(AYAPA PASTORE', '', 'MATHAPATA SAHI(TIN NO-21611907168)', 'ODISHA', 'BERHAMPUR', '9437370724', '', '', NULL),
(36, '', 'S.MADHUSUDANA PRUSTI(PRUSTI TRANSPORT)', '', 'RAZA SAHI', 'ODISHA', 'BERHAMPUR', '9438589400', '', '', NULL),
(37, '', 'KRUSHNA CHANDRA PANDA(KORA PANDA)[PANDA STORE]', '', 'KOMAPULI MAINROAD (SIN NO-4900938)', 'ODISHA', 'BERHAMPUR', '9861353896', '', '', NULL),
(38, '', 'K.SIMACHALA PATRO(MAA BHAIRABI GENERAL STORE )', '', 'ANKULI MAINROAD', 'ODISHA', 'BERHAMPUR ', '9861165151', '', '', NULL),
(39, '', 'B.MAHASWER', '', 'PLOT NO-109, SRI TWAR 3rd STAGE', 'ODISHA', 'BERHAMPUR', '9237027481', '', '', NULL),
(40, '', 'NARAYAN MAHAPATRO(MAHAPATRO GENERAL STORE)', '', 'UNIVERCITY, GOPALPUR', 'ODISHA', 'BERHAMPUR', '9692682814', '', '', NULL),
(41, '', 'N.CHINA READY', '', 'PUTI GOPALPUR', 'ODISHA', 'CHATRAPUR', '9238871305', '', '', NULL),
(42, '', 'B.BADRI NARAYAN', '', 'KHARIAGUDA, CHIKITI', 'ODISHA', 'CHIKITI', '7749996477', '', '', NULL),
(43, 'SHYAM SUNDAR LORI', 'T.ANADESWAR PATRO(SAHIL STORE)', '', 'DANGAOSTA MAINROAD', 'ODISHA', 'DANGAOSTA', '9437661192', '', '', NULL),
(44, '', 'DEBANDRA BEHERA', '', 'GANJU', 'ODISHA', 'BERHAMPUR', '9938604973', '', '', NULL),
(45, '', 'B.RAKESH PATRO', '', 'PATRO PUR', 'ODISHA', 'PATRO PUR', '9437859173', '', '', NULL),
(46, '', 'S.K.JALLY(SRI RAM STORE', '', 'PARI KUDA', 'puri', 'PARI KUDA', '9938556063', '', '', NULL),
(48, '25(RAMA KRUSHNA TRIPATHY LORI)', 'GAYA PRADHAN', '', 'DARINGBADI MAINROAD', 'ODISHA', 'DARINGBADI', '9439910250', '', '', NULL),
(49, '26X(RAMA KRUSHNA TRIPATHY LORI)', 'UPANDRA SAHU', '', 'DARINGBADI MAINROAD', 'ODISHA', 'DARINGBADI', '9437589215', '', '', NULL),
(50, '107(JAGATAJANANI LORI)', 'TIKINA SAHU(SHAYMALAI ENTERPRICES)', '', 'POLASARA MAINROAD', 'ODISHA', 'POLASARA', '9861048190', '', '', NULL),
(51, '50(SANKHA CHAKRA LORI)', 'M.SACHITANANDA CHOUDHARY', '', 'BANKA BAZAR, RAZA STREET', 'ODISHA', 'SORADA', '9853415962', '', '', NULL),
(52, '105(LAXMI NARSIMHA LORI)', 'RAGHUNATH PANIGRAHY(SRI RADHA KRUSHNA STOR)', '', 'N.BURUPADA(SIN NO-5001548)', 'ODISHA', 'SAULAI', '9861362167', '', '', NULL),
(53, '', ' BISWARANJAN SAHU(SAHU GENERAL STORE) ', '', 'GOLANTHRA', 'ODISHA', 'GOLANTHRA', '9778868558', '', '', NULL);

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
DELIMITER $$
CREATE TRIGGER `update_customer` AFTER UPDATE ON `td_customer_details` FOR EACH ROW UPDATE td_customer_search SET name = NEW.name , mobile=NEW.mobile ,godown_no=NEW.godown_no WHERE customer_id = NEW.customer_id
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `td_customer_search`
--

CREATE TABLE `td_customer_search` (
  `godown_no` varchar(100) DEFAULT NULL,
  `customer_id` bigint(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `mobile` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `td_customer_search`
--

INSERT INTO `td_customer_search` (`godown_no`, `customer_id`, `name`, `mobile`) VALUES
('95x(senapati lori)', 2, 'krushna ready(jagannath stor)', '9437412974'),
('80(GANJAM LORI)', 3, 'RAM MRUTI PARTO', '9861733783'),
('21(GANJAM LORI)', 4, 'A.NILACHALA PATRO(MAHA LAXMI ENGESY)', '9861282612'),
('99(BRUDABANA LLORI)', 5, 'A.GANGA DHARA PATRO(GANGA DHARA ENTER PRICES)', '9937590492'),
('46(BRUDABAN LORI)', 6, 'LAXMAN POLAI', '9938184639'),
('NP(PRADHANA LORI)', 7, 'RANJENDRA PRUSTI ', '9937907664'),
('SB(RADHAKANTA LORI)', 8, 'MONAJ SUBUDHI', '9938274796'),
('SKM(NIRMAL LORI)', 9, 'K.SUSANT KU. MAHAPATRO', '9437770488'),
('MKS(RADHAKANTA LORI)', 10, 'MAHENDRA SAHU(MAHENDRA SAHU ENTERPRICES)', '9132373737'),
('(X)(RADHAKANTALORI)', 11, 'K.SURYA NARAYANA PATRO', '9861234621'),
('351(BANADAVI)', 12, 'RABINDRA NATH PADHY', '9776463127'),
('416(BANADAVI LORI)', 13, 'K.GOURI SANKAR PATRO(SRABA MANGALA MARGO)', '7377563686'),
('78(RADHAKANTA LORI)', 14, 'MODAN MOHAN CHARTY', '9583167799'),
('58(SANAPATIN LORI)', 15, 'K.BADRI NARAYANA PATRO(NARAYANI TRADERS)', '9437325486'),
('091(NATABARLAL LORI)', 16, 'BHABANI MAHAPATRO(MAHAPATRO GENERAL STOR)', '9090458772'),
('95X(NATABARLAL LORI)', 17, 'GANGA BEHERA', '9861561933'),
('501(BAJARANGI LORI)', 18, 'A.RAJARAO PATRO', '8018505071'),
('158(PRADHAN LORI)', 19, 'SRIKANTA DAS ', '9438521997'),
('PS(NATABARA LORI)', 20, 'SANTOSH KU. SAHU', '9938599118'),
('ND(KURAISUNI)', 21, 'PRAMOD KU.PATRO', '9438138242'),
('K4XX(KURAISUNI LORI)', 22, 'K.RAJARAO PATRO', '9439406582'),
('555(SRI GANESH LORI)', 23, 'PRABHAT KU. PADHY', '7735313099'),
('521(MAHA MAYI LORI)', 24, 'MITU SUBUDHI', '9937429195'),
('331(MAHAMAI LORI)', 25, 'P.SUBARAO PATRO', '9938275780'),
('LGS(MAHAMAI LORI)', 26, 'B.BHAGABAN PATRO', '9938183926'),
('202(BAPANGI LORI)', 27, 'A.PURNA CHANDRA SARAB', '9437412603'),
('', 28, 's.simanchla patro(tansen free general stor)', '9861168835'),
('', 29, 'G.GOBINDA', '8121605145'),
('', 30, 'PRAFULA KU. PADHY(SRI KRISHNA STOR)', '9237234358'),
('', 31, 'PARAMANANDA SAHU', '9938407508'),
('', 32, 'PAPUN PATRO(PATAKHANDA TRANSPORT)', '9437454970'),
('', 33, 'PRATAP KUMAR SADAGI', '8093881411'),
('', 34, 'A.MOHAN RAO', '9040301160'),
('', 35, 'SRIVASU RAO(AYAPA PASTORE', '9437370724'),
('', 36, 'S.MADHUSUDANA PRUSTI(PRUSTI TRANSPORT)', '9438589400'),
('', 37, 'KRUSHNA CHANDRA PANDA(KORA PANDA)[PANDA STORE]', '9861353896'),
('', 38, 'K.SIMACHALA PATRO(MAA BHAIRABI GENERAL STORE )', '9861165151'),
('', 39, 'B.MAHASWER', '9237027481'),
('', 40, 'NARAYAN MAHAPATRO(MAHAPATRO GENERAL STORE)', '9692682814'),
('', 41, 'N.CHINA READY', '9238871305'),
('', 42, 'B.BADRI NARAYAN', '7749996477'),
('SHYAM SUNDAR LORI', 43, 'T.ANADESWAR PATRO(SAHIL STORE)', '9437661192'),
('', 44, 'DEBANDRA BEHERA', '9938604973'),
('', 45, 'B.RAKESH PATRO', '9437859173'),
('', 46, 'S.K.JALLY(SRI RAM STORE', '9938556063'),
('25(RAMA KRUSHNA TRIPATHY LORI)', 48, 'GAYA PRADHAN', '9439910250'),
('26X(RAMA KRUSHNA TRIPATHY LORI)', 49, 'UPANDRA SAHU', '9437589215'),
('107(JAGATAJANANI LORI)', 50, 'TIKINA SAHU(SHAYMALAI ENTERPRICES)', '9861048190'),
('50(SANKHA CHAKRA LORI)', 51, 'M.SACHITANANDA CHOUDHARY', '9853415962'),
('105(LAXMI NARSIMHA LORI)', 52, 'RAGHUNATH PANIGRAHY(SRI RADHA KRUSHNA STOR)', '9861362167'),
('', 53, ' BISWARANJAN SAHU(SAHU GENERAL STORE) ', '9778868558');

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

-- --------------------------------------------------------

--
-- Table structure for table `td_purchase_history`
--

CREATE TABLE `td_purchase_history` (
  `bill_no` bigint(20) NOT NULL,
  `godown_no` varchar(100) DEFAULT NULL,
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
('1', '0', '202.12.83.41', '26E7DE50BBE66EF97DE0AC1F436684A1', 1, '2017-06-07 08:55:52', '2017-06-07 08:57:32'),
('1', '0', '202.12.83.41', 'BA5F8B35E8AC89C2857DFAA1C1629DD2', 2, '2017-06-07 08:57:35', '2017-06-07 08:58:18'),
('1', '0', '202.12.83.41', 'D7AA457DBC0099E4F98A3D77058DB77A', 3, '2017-06-07 08:58:40', '2017-06-07 08:59:52'),
('1', '0', '202.12.83.41', '1CAED8AA67011808F166D0F14CB8F587', 4, '2017-06-07 08:59:54', NULL),
('1', '0', '27.59.100.10', '7614EC57934EC5ECB6BA8BD968F20D13', 5, '2017-06-07 11:45:16', '2017-06-07 11:45:23'),
('1', '0', '27.59.100.10', 'F64D1426ECCF53B3D5FA6D5F3B2D3E7D', 6, '2017-06-07 11:45:34', NULL),
('3', '1', '117.197.246.6', 'C3A1F31C304F6D51D57D42A098CD4F65', 7, '2017-06-07 12:12:44', NULL),
('3', '1', '117.197.237.222', '6699DED14CB7C6D6E18BC6ED5F5E6303', 8, '2017-06-07 18:30:35', '2017-06-07 18:43:32'),
('3', '1', '117.197.237.222', '367B6052DF398259C380A3A739452D60', 9, '2017-06-07 18:45:09', '2017-06-07 19:00:50'),
('3', '1', '117.248.166.194', '31F2A9716165B0FDA07D82F7C13B150C', 10, '2017-06-08 12:10:53', NULL),
('3', '1', '117.248.166.194', '505B7BD0F29C5596C72627F0E65A40CA', 11, '2017-06-08 12:32:56', NULL),
('3', '1', '117.248.166.194', '21FB9AE5BBB9C891A7EE137FC5ADD746', 12, '2017-06-08 12:46:34', '2017-06-08 12:53:30'),
('3', '1', '117.248.166.194', 'A304364C3F76111129830A2A17F5B529', 13, '2017-06-08 12:55:16', NULL),
('3', '1', '117.248.166.194', '367448A58308578B412E1E0D304A9057', 14, '2017-06-08 14:13:21', '2017-06-08 14:15:57'),
('3', '1', '117.197.243.23', '341A985ABF35E8DFC109331A8A6A99B6', 15, '2017-06-08 20:08:17', '2017-06-08 20:26:08'),
('3', '1', '117.197.243.23', 'AC2FDE97A600534741E971EE3DFCDEC2', 16, '2017-06-08 20:55:39', '2017-06-08 21:05:30'),
('4', '1', '202.12.83.41', '92B1DA1859B2F6A0F7FEFFCFDFA8633E', 17, '2017-06-09 02:28:06', NULL),
('4', '1', '202.12.83.41', '92B1DA1859B2F6A0F7FEFFCFDFA8633E', 18, '2017-06-09 02:28:39', NULL),
('4', '1', '202.12.83.41', '92B1DA1859B2F6A0F7FEFFCFDFA8633E', 19, '2017-06-09 02:28:52', NULL),
('4', '1', '202.12.83.41', 'D52C57A83BF6375E8A8EEDECFD53450D', 20, '2017-06-09 02:33:47', NULL),
('4', '1', '202.12.83.41', '582AACD0632A1A1EA318AFA553CDC96C', 21, '2017-06-09 02:36:28', NULL),
('3', '1', '117.197.243.23', 'C2C12B635522BF19AB3D61E28842CD0B', 22, '2017-06-09 11:41:57', NULL),
('3', '1', '117.197.243.23', '3FE4366603714DF268B2E510A4E777BE', 23, '2017-06-09 12:08:16', NULL),
('3', '1', '117.197.243.23', '0B9D3597CD958368548C037257DB9379', 24, '2017-06-09 13:27:41', NULL),
('3', '1', '103.218.121.238', '0726E37E5EBEAE805D7627E8BC27A6B2', 25, '2017-06-09 18:04:48', NULL),
('3', '1', '103.218.121.238', 'E6FBE4359B6ACF8013EBC2072271DF6C', 26, '2017-06-10 12:08:16', '2017-06-10 12:10:49'),
('3', '1', '103.218.121.238', 'ABAB370C68559AC5E05CFD80B70AED7E', 27, '2017-06-10 12:11:31', '2017-06-10 12:17:49'),
('3', '1', '103.218.121.238', '57211A1E9A5EC0B4C46E8B860C27D525', 28, '2017-06-10 14:12:53', NULL),
('4', '1', '202.12.83.41', 'CBAD975A229A18912EF485F8D6BFD0C8', 29, '2017-06-12 00:37:19', NULL),
('4', '1', '202.12.83.41', '43CABE3B591872F183F7493F024AB12F', 30, '2017-06-12 01:12:18', NULL),
('3', '1', '117.197.254.189', '349EE0422469D8B56BF51965A49B85FE', 31, '2017-06-12 12:36:28', '2017-06-12 12:43:32'),
('3', '1', '117.197.254.189', 'D8687594D01DF4BCD213739A557609DB', 32, '2017-06-12 12:36:55', NULL),
('3', '1', '117.197.254.189', 'D8687594D01DF4BCD213739A557609DB', 33, '2017-06-12 12:37:30', '2017-06-12 12:44:21'),
('3', '1', '117.197.254.189', '0E5658F527E4ABEC6E2A8DEEFDF350C6', 34, '2017-06-12 12:46:51', '2017-06-12 13:01:29'),
('3', '1', '117.197.254.189', '150C5BCD5726F90EF23B85ABACF122E4', 35, '2017-06-12 13:02:17', '2017-06-12 13:18:16'),
('3', '1', '117.197.254.189', 'D3FB81B71AB859145B15602792593F97', 36, '2017-06-12 13:19:22', NULL),
('3', '1', '117.197.254.189', 'D3FB81B71AB859145B15602792593F97', 37, '2017-06-12 13:28:07', '2017-06-12 13:33:50'),
('3', '1', '117.197.254.189', '3C0F1905C80B2D23C4BD4A4B996406E1', 38, '2017-06-12 13:37:06', NULL),
('3', '1', '117.197.254.189', '15ADD360B930899544F767711DBC555D', 39, '2017-06-12 13:47:37', '2017-06-12 14:24:21'),
('4', '1', '27.59.8.207', 'C280CB6F0D4ECAFEC77A9B09C4CB03F6', 40, '2017-06-12 14:07:47', NULL),
('3', '1', '117.197.254.189', 'C9E645EC4A3A5C8A58FB4ECD3D3D8C30', 41, '2017-06-12 17:44:40', NULL),
('3', '1', '117.197.254.189', '2851B242C85CB5C8A077E8036606E3D0', 42, '2017-06-12 20:12:55', '2017-06-12 20:15:45'),
('3', '1', '117.197.254.189', 'A0D07654D75ECCB1C0D837398421DEA0', 43, '2017-06-12 20:48:50', '2017-06-12 20:53:52'),
('4', '1', '202.12.83.41', 'EC16817AA7D4ABFC57A0A560BD8D0332', 44, '2017-06-13 01:59:40', NULL),
('4', '1', '202.12.83.41', '449315E157BBB47CC195C410FC919BA5', 45, '2017-06-13 02:45:12', '2017-06-13 02:47:10'),
('4', '1', '202.12.83.41', '730A8E413A4DA72F23AD3C3EE2A4D96A', 46, '2017-06-13 03:46:10', NULL),
('3', '1', '117.248.129.69', 'A414A40F79587AA398ED1CA10DC3E7F7', 47, '2017-06-13 12:09:36', NULL),
('3', '1', '117.248.129.69', '10C7A5C4722BA4B18F4D19F3023754B6', 48, '2017-06-13 12:30:56', '2017-06-13 14:29:26'),
('4', '1', '103.204.96.6', 'C8F656D32A94ED83D72360401FBB7B06', 49, '2017-06-13 12:59:54', NULL),
('3', '1', '117.248.129.69', 'DE8616198D77A1EA97AAA677471B3FA6', 50, '2017-06-13 17:42:36', NULL),
('3', '1', '117.248.129.69', 'FE22473EBB34F28D1AF2CAA505669EE1', 51, '2017-06-13 18:14:48', '2017-06-13 18:54:49'),
('3', '1', '117.248.129.69', '14F9F3D3AB3D62E98A08D8A7422294F9', 52, '2017-06-13 18:59:38', NULL),
('4', '1', '202.12.83.41', '6930F75617D7CA09E6ED0D9E30F76206', 53, '2017-06-14 01:15:37', NULL),
('4', '1', '202.12.83.41', 'F1AA173DF2B5A4B47AD5EC941DF1B764', 54, '2017-06-14 02:04:52', NULL),
('4', '1', '202.12.83.41', '138712E88370490F2B779D19F87ED6F9', 55, '2017-06-14 02:54:57', NULL),
('4', '1', '202.12.83.41', '853E4E787258A9A1CDCEF7412873389A', 56, '2017-06-15 00:55:56', '2017-06-15 00:56:32'),
('4', '1', '202.12.83.41', 'E8A1937809C26B4A5BE9F412B8D9545C', 57, '2017-06-15 00:56:35', '2017-06-15 00:57:20'),
('3', '1', '117.248.167.59', '0609E7847E7EDA9C20DF624236CEFD7D', 58, '2017-06-15 18:10:52', NULL),
('3', '1', '117.197.243.64', '0FE0578CC11EB43D45441522073F7E0E', 59, '2017-06-15 18:48:09', '2017-06-15 18:49:35'),
('4', '1', '202.12.83.41', '1D86CBD39449423A06281D914C01E2E6', 60, '2017-06-16 00:04:18', NULL),
('4', '1', '103.204.96.6', 'FA1C7396F14CF7BAE95BB27E50799018', 61, '2017-06-16 15:25:19', NULL),
('3', '1', '117.197.234.134', '4DBB4A324B5C14581A2BC915D7271830', 62, '2017-06-17 12:55:54', '2017-06-17 12:58:46'),
('3', '1', '117.197.234.134', 'D1787C9D7CE74B739B2F9BDE269B9EBE', 63, '2017-06-17 13:43:05', '2017-06-17 13:44:04'),
('3', '1', '117.197.234.134', 'BE35518ABF4705D92A312DF96D86D40C', 64, '2017-06-17 18:21:38', NULL),
('3', '1', '117.197.234.134', '23F7FDD46298DF80D339E9C2D4970FF7', 65, '2017-06-17 18:35:40', NULL),
('4', '1', '202.12.83.41', '305108B8B24D04725A4F760F95F6247B', 66, '2017-06-19 01:01:15', NULL),
('4', '1', '202.12.83.41', '305108B8B24D04725A4F760F95F6247B', 67, '2017-06-19 01:38:12', '2017-06-19 01:38:25');

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
(4, 'kanha', 'kanha@gmail.com', 'kanha', 1, 'Biller', 'A'),
(3, 'srinu', 'bgsbhaskar7@gmail.com', 'sreesanth', 1, 'Biller', 'A');

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
  ADD UNIQUE KEY `mobile` (`mobile`);

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
  MODIFY `cash_record_id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `td_customer_balance_details`
--
ALTER TABLE `td_customer_balance_details`
  MODIFY `balance_details_code` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `td_customer_details`
--
ALTER TABLE `td_customer_details`
  MODIFY `customer_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;
--
-- AUTO_INCREMENT for table `td_item_details_for_bill`
--
ALTER TABLE `td_item_details_for_bill`
  MODIFY `bill_item_details` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `td_product_quanity_details`
--
ALTER TABLE `td_product_quanity_details`
  MODIFY `product_id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `td_purchase_history`
--
ALTER TABLE `td_purchase_history`
  MODIFY `bill_no` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `td_shop_config`
--
ALTER TABLE `td_shop_config`
  MODIFY `shop_id` bigint(250) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `td_user_log`
--
ALTER TABLE `td_user_log`
  MODIFY `User_track_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=68;
--
-- AUTO_INCREMENT for table `td_user_login`
--
ALTER TABLE `td_user_login`
  MODIFY `user_id` bigint(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
