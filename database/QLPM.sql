-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: mysql
-- Generation Time: Jun 07, 2024 at 05:04 PM
-- Server version: 8.4.0
-- PHP Version: 8.2.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `QLPM`
--

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE `accounts` (
                            `id` int NOT NULL,
                            `magiaovien` char(5) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
                            `passwords` varchar(20) DEFAULT NULL,
                            `roles` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`id`, `magiaovien`, `passwords`, `roles`) VALUES
                                                                      (1, 'GV1', '123456', 'ADMIN'),
                                                                      (2, 'GV2', '123456', 'GIAOVIEN');

-- --------------------------------------------------------

--
-- Table structure for table `dangkysudung`
--

CREATE TABLE `dangkysudung` (
                                `madangky` char(5) NOT NULL,
                                `maphongmay` char(5) NOT NULL,
                                `magiaovien` char(5) NOT NULL,
                                `mamonhoc` char(5) NOT NULL,
                                `batdau` date NOT NULL,
                                `ketthuc` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `giaovien`
--

CREATE TABLE `giaovien` (
                            `magiaovien` char(5) NOT NULL,
                            `tengiaovien` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                            `hocvi` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
                            `ngaycong` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `giaovien`
--

INSERT INTO `giaovien` (`magiaovien`, `tengiaovien`, `hocvi`, `ngaycong`) VALUES
                                                                              ('GV1', 'Nguyen Thi A', 'Thac Si', 0),
                                                                              ('GV2', 'Nguyen Van C', 'Thac Si', 0),
                                                                              ('GV3', 'Nguyen Van B', 'Thac Si', 0),
                                                                              ('GV4', 'Nguyen Thi C', 'Thac Si', 0),
                                                                              ('GV5', 'Nguyen Thi T', 'Thac Si', 0),
                                                                              ('GV6', 'Nguyen Van D', 'Thac Si', 0),
                                                                              ('GV7', 'Nguyen Thi F', 'Thac Si', 0);

--
-- Triggers `giaovien`
--
DELIMITER $$
CREATE TRIGGER `trigger_delete_giaovien_delete_lichsudung` BEFORE DELETE ON `giaovien` FOR EACH ROW DELETE from dangkysudung WHERE magiaovien=OLD.magiaovien
    $$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `trigger_delete_giaovien_delete_lichtruc1` BEFORE DELETE ON `giaovien` FOR EACH ROW DELETE from lichtruc WHERE magiaovien=OLD.magiaovien
    $$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `lichtruc`
--

CREATE TABLE `lichtruc` (
                            `magiaovien` char(5) NOT NULL,
                            `ngaytruc` date NOT NULL,
                            `ghichu` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `lichtruc`
--

INSERT INTO `lichtruc` (`magiaovien`, `ngaytruc`, `ghichu`) VALUES
    ('GV3', '2020-06-04', 'Buổi trực đầu tiên');

-- --------------------------------------------------------

--
-- Table structure for table `may`
--

CREATE TABLE `may` (
                       `mamay` char(5) NOT NULL,
                       `cauhinhmay` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                       `tinhtrangmay` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                       `maphanmem` char(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `may`
--

INSERT INTO `may` (`mamay`, `cauhinhmay`, `tinhtrangmay`, `maphanmem`) VALUES
                                                                           ('MM1', 'corei5', 'Tot', 'PM12'),
                                                                           ('MM2', 'corei7', 'Tot', 'PM14'),
                                                                           ('MM3', 'corei5', 'Tot', 'PM16'),
                                                                           ('MM4', 'corei7', 'Tot', 'PM13'),
                                                                           ('MM5', 'corei5', 'Tot', 'PM15'),
                                                                           ('MM6', 'corei5', 'Tot', 'PM17'),
                                                                           ('MM7', 'corei7', 'Tot', 'PM18');

-- --------------------------------------------------------

--
-- Table structure for table `monhoc`
--

CREATE TABLE `monhoc` (
                          `mamonhoc` char(5) NOT NULL,
                          `tenmonhoc` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                          `cauhinhmay` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
                          `maphanmem` char(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `monhoc`
--

INSERT INTO `monhoc` (`mamonhoc`, `tenmonhoc`, `cauhinhmay`, `maphanmem`) VALUES
                                                                              ('Mon1', 'JAVA', 'corei5', 'PM12'),
                                                                              ('Mon2', 'SQL', 'corei7', 'PM18'),
                                                                              ('Mon3', 'XML', 'corei5', 'PM16'),
                                                                              ('Mon4', 'Nhap mon tin hoc', 'corei7', 'PM14'),
                                                                              ('Mon5', 'Quan Li Du An', 'corei5', 'PM15'),
                                                                              ('Mon6', 'Mang May Tinh', 'corei7', 'PM13'),
                                                                              ('Mon7', 'Tieng ANH CNTT', 'corei5', 'PM17');

-- --------------------------------------------------------

--
-- Table structure for table `phanmem`
--

CREATE TABLE `phanmem` (
                           `maphanmem` char(5) NOT NULL,
                           `tenphanmem` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `phanmem`
--

INSERT INTO `phanmem` (`maphanmem`, `tenphanmem`) VALUES
                                                      ('PM12', 'netbean'),
                                                      ('PM13', 'coccoc'),
                                                      ('PM14', 'word'),
                                                      ('PM15', 'execl'),
                                                      ('PM16', 'powerpoint'),
                                                      ('PM17', 'chrome'),
                                                      ('PM18', 'sql sever');

-- --------------------------------------------------------

--
-- Table structure for table `phongmay`
--

CREATE TABLE `phongmay` (
                            `maphongmay` char(5) NOT NULL,
                            `vitri` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                            `mamay` char(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `phongmay`
--

INSERT INTO `phongmay` (`maphongmay`, `vitri`, `mamay`) VALUES
                                                            ('P1a', 'Tang1', 'MM1'),
                                                            ('P1b', 'Tang1', 'MM2'),
                                                            ('P1c', 'Tang1', 'MM3'),
                                                            ('P2a', 'Tang2', 'MM6'),
                                                            ('P2b', 'Tang2', 'MM7'),
                                                            ('P3a', 'Tang3', 'MM4'),
                                                            ('P3b', 'Tang3', 'MM5'),
                                                            ('P4a', 'Tang1', 'MM1'),
                                                            ('P4b', 'Tang1', 'MM2');

--
-- Triggers `phongmay`
--
DELIMITER $$
CREATE TRIGGER `trigger_delete_phongmay_delete_lichdk` BEFORE DELETE ON `phongmay` FOR EACH ROW DELETE from dangkysudung WHERE maphongmay=OLD.maphongmay
    $$
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accounts`
--
ALTER TABLE `accounts`
    ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `magiaovien` (`magiaovien`);

--
-- Indexes for table `dangkysudung`
--
ALTER TABLE `dangkysudung`
    ADD PRIMARY KEY (`madangky`),
  ADD KEY `FK_lichtruc_phongmay` (`maphongmay`),
  ADD KEY `FK_lichtruc_giaovien` (`magiaovien`),
  ADD KEY `FK_lichtrgiaovienuc_monhoc` (`mamonhoc`);

--
-- Indexes for table `giaovien`
--
ALTER TABLE `giaovien`
    ADD PRIMARY KEY (`magiaovien`);

--
-- Indexes for table `lichtruc`
--
ALTER TABLE `lichtruc`
    ADD PRIMARY KEY (`ngaytruc`),
  ADD KEY `fk_ligiaovien` (`magiaovien`);

--
-- Indexes for table `may`
--
ALTER TABLE `may`
    ADD PRIMARY KEY (`mamay`),
  ADD KEY `FK_may_phanmem` (`maphanmem`);

--
-- Indexes for table `monhoc`
--
ALTER TABLE `monhoc`
    ADD PRIMARY KEY (`mamonhoc`),
  ADD KEY `FK_monhoc_phanmem` (`maphanmem`);

--
-- Indexes for table `phanmem`
--
ALTER TABLE `phanmem`
    ADD PRIMARY KEY (`maphanmem`);

--
-- Indexes for table `phongmay`
--
ALTER TABLE `phongmay`
    ADD PRIMARY KEY (`maphongmay`),
  ADD KEY `FK_phongmay_may` (`mamay`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `accounts`
--
ALTER TABLE `accounts`
    MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `dangkysudung`
--
ALTER TABLE `dangkysudung`
    ADD CONSTRAINT `FK_lichtrgiaovienuc_monhoc` FOREIGN KEY (`mamonhoc`) REFERENCES `monhoc` (`mamonhoc`),
  ADD CONSTRAINT `FK_lichtruc_giaovien` FOREIGN KEY (`magiaovien`) REFERENCES `giaovien` (`magiaovien`),
  ADD CONSTRAINT `FK_lichtruc_phongmay` FOREIGN KEY (`maphongmay`) REFERENCES `phongmay` (`maphongmay`);

--
-- Constraints for table `lichtruc`
--
ALTER TABLE `lichtruc`
    ADD CONSTRAINT `fk_ligiaovien` FOREIGN KEY (`magiaovien`) REFERENCES `giaovien` (`magiaovien`);

--
-- Constraints for table `may`
--
ALTER TABLE `may`
    ADD CONSTRAINT `FK_may_phanmem` FOREIGN KEY (`maphanmem`) REFERENCES `phanmem` (`maphanmem`);

--
-- Constraints for table `monhoc`
--
ALTER TABLE `monhoc`
    ADD CONSTRAINT `FK_monhoc_phanmem` FOREIGN KEY (`maphanmem`) REFERENCES `phanmem` (`maphanmem`);

--
-- Constraints for table `phongmay`
--
ALTER TABLE `phongmay`
    ADD CONSTRAINT `FK_phongmay_may` FOREIGN KEY (`mamay`) REFERENCES `may` (`mamay`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
