-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 12, 2018 at 08:05 AM
-- Server version: 10.1.32-MariaDB
-- PHP Version: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sabaa`
--

-- --------------------------------------------------------

--
-- Table structure for table `barangKeluar`
--

CREATE TABLE `barangKeluar` (
  `idBK` int(3) UNSIGNED ZEROFILL NOT NULL,
  `castBK` varchar(2) NOT NULL DEFAULT 'BK',
  `idBarang` char(5) DEFAULT NULL,
  `namaBarang` varchar(100) DEFAULT NULL,
  `jumlahBarang` int(11) DEFAULT NULL,
  `tglKeluar` date DEFAULT NULL,
  `tujuanBarang` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `barangKeluar`
--

INSERT INTO `barangKeluar` (`idBK`, `castBK`, `idBarang`, `namaBarang`, `jumlahBarang`, `tglKeluar`, `tujuanBarang`) VALUES
(001, 'BK', 'b0001', 'Patchcord SC/UPC - SC/UPC 20m', 10, '2018-01-05', 'Surabaya'),
(002, 'BK', 'b0010', 'OTB 12 Core', 10, '2018-01-05', 'Surabaya'),
(003, 'BK', 'b0012', 'OTB 96 Core', 10, '2018-01-05', 'Surabaya'),
(004, 'BK', 'b0015', 'ODP 16 Core', 10, '2018-01-05', 'Jakarta'),
(005, 'BK', 'b0003', 'Patchcord FC/UPC - FC/UPC 20m', 10, '2018-01-05', 'Jakarta'),
(006, 'BK', 'b0007', 'Patchcord SC/UPC - SC/UPC 5m', 10, '2018-01-05', 'Jakarta'),
(007, 'BK', 'b0004', 'Patchcord SC/UPC - SC/UPC 10m', 10, '2018-01-05', 'Jogja'),
(008, 'BK', 'b0005', 'Patchcord SC/UPC - FC/UPC 10m', 10, '2018-01-04', 'Bandung'),
(009, 'BK', 'b0004', 'Patchcord SC/UPC - SC/UPC 10m', 10, '2018-01-02', 'Bandung'),
(010, 'BK', 'b0002', 'Patchcord SC/UPC - FC/UPC 20m', 10, '2018-01-13', 'Bandung'),
(011, 'BK', 'b0010', 'OTB 12 Core', 5, '2018-07-05', 'surabaya'),
(012, 'BK', 'b0005', 'Patchcord SC/UPC - FC/UPC 10m', 60, '0000-00-00', 'Surabaya'),
(013, 'BK', 'b0003', 'Patchcord FC/UPC - FC/UPC 20m', 40, '0000-00-00', 'Jakarta'),
(014, 'BK', 'b0004', 'Patchcord SC/UPC - SC/UPC 10m', 50, '2018-07-05', 'Bandung'),
(015, 'BK', 'b0003', 'Patchcord FC/UPC - FC/UPC 20m 	', 50, '2018-07-12', 'Surabaya'),
(020, 'BK', 'b0002', 'Patchcord SC/UPC - FC/UPC 20m', 10, '2018-07-09', 'Surabaya'),
(021, 'BK', 'b0002', 'Patchcord SC/UPC - FC/UPC 20m', 40, '2018-07-10', 'JAKARTA'),
(022, 'BK', 'b0011', 'OTB 24 Core', 10, '2018-07-10', 'SURABAYA'),
(023, 'BK', 'b0002', 'Patchcord SC/UPC - FC/UPC 20m', 10, '2018-07-11', 'JAKARTA');

--
-- Triggers `barangKeluar`
--
DELIMITER $$
CREATE TRIGGER `INSERT_BK` AFTER INSERT ON `barangKeluar` FOR EACH ROW BEGIN
UPDATE masterBarang
SET stokBarang = stokBarang-NEW.jumlahBarang
WHERE
idBarang = NEW.idBarang;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `barangMasuk`
--

CREATE TABLE `barangMasuk` (
  `idBM` int(3) UNSIGNED ZEROFILL NOT NULL,
  `castBM` varchar(2) NOT NULL DEFAULT 'BM',
  `idBarang` char(5) DEFAULT NULL,
  `namaBarang` varchar(100) DEFAULT NULL,
  `jumlahBarang` int(11) DEFAULT NULL,
  `tglMasuk` date DEFAULT NULL,
  `supplier` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `barangMasuk`
--

INSERT INTO `barangMasuk` (`idBM`, `castBM`, `idBarang`, `namaBarang`, `jumlahBarang`, `tglMasuk`, `supplier`) VALUES
(011, 'BM', 'b0001', 'Patchcord SC/UPC - SC/UPC 20m', 10, '2018-01-01', 'Surabaya'),
(012, 'BM', 'b0005', 'Patchcord SC/UPC - FC/UPC 10m', 5, '2018-01-01', 'Surabaya'),
(013, 'BM', 'b0004', 'Patchcord SC/UPC - SC/UPC 10m', 8, '2018-01-01', 'Surabaya'),
(014, 'BM', 'b0007', 'Patchcord SC/UPC - SC/UPC 5m', 1, '2018-01-01', 'Jakarta'),
(015, 'BM', 'b0015', 'ODP 16 Core', 1, '2018-01-01', 'Jakarta'),
(016, 'BM', 'b0012', 'OTB 96 Core', 1, '2018-01-01', 'Jogja'),
(017, 'BM', 'b0010', 'OTB 12 Core', 1, '2018-01-01', 'Jogja'),
(018, 'BM', 'b0001', 'Patchcord SC/UPC - SC/UPC 20m', 20, '2018-01-01', 'Semarang'),
(019, 'BM', 'b0002', 'Patchcord SC/UPC - FC/UPC 20m', 15, '2018-01-01', 'Bandung'),
(020, 'BM', 'b0003', 'Patchcord FC/UPC - FC/UPC 20m', 25, '2018-01-01', 'Banyuwangi'),
(021, 'BM', 'b0003', 'Patchcord FC/UPC - FC/UPC 20m', 45, '2018-07-05', 'PT.Jaya'),
(024, 'BM', 'b0003', 'Patchcord FC/UPC - FC/UPC 20m', 50, '2018-07-10', 'Sukamaju'),
(029, 'BM', 'b0013', 'OTB 144 Core', 4, '2018-07-09', 'Surabaya'),
(030, 'BM', 'b0016', 'ODP 8 Core', 10, '2018-07-10', 'PT. Baya'),
(031, 'BM', 'b0001', 'Patchcord SC/UPC - SC/UPC 20m', 10, '2018-07-11', 'PT. Baya');

--
-- Triggers `barangMasuk`
--
DELIMITER $$
CREATE TRIGGER `BM_INSERTBM` AFTER INSERT ON `barangMasuk` FOR EACH ROW BEGIN
UPDATE masterBarang
SET stokBarang = stokBarang+NEW.jumlahBarang
WHERE
idBarang = NEW.idBarang;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `masterBarang`
--

CREATE TABLE `masterBarang` (
  `idBarang` char(5) NOT NULL,
  `namaBarang` varchar(100) DEFAULT NULL,
  `stokBarang` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `masterBarang`
--

INSERT INTO `masterBarang` (`idBarang`, `namaBarang`, `stokBarang`) VALUES
('b0001', 'Patchcord SC/UPC - SC/UPC 20m', 210),
('b0002', 'Patchcord SC/UPC - FC/UPC 20m', 140),
('b0003', 'Patchcord FC/UPC - FC/UPC 20m', 150),
('b0004', 'Patchcord SC/UPC - SC/UPC 10m', 125),
('b0005', 'Patchcord SC/UPC - FC/UPC 10m', 100),
('b0006', 'Patchcord FC/UPC - FC/UPC 10m', 100),
('b0007', 'Patchcord SC/UPC - SC/UPC 5m', 200),
('b0008', 'Patchcord SC/UPC - FC/UPC 5m', 200),
('b0009', 'Patchcord FC/UPC - SC/UPC 5m', 200),
('b0010', 'OTB 12 Core', 25),
('b0011', 'OTB 24 Core', -5),
('b0012', 'OTB 96 Core', 1),
('b0013', 'OTB 144 Core', 5),
('b0014', 'ODP 12 Core', 80),
('b0015', 'ODP 16 Core', 450),
('b0016', 'ODP 8 Core', 310),
('b0017', 'ODP', 10);

-- --------------------------------------------------------

--
-- Table structure for table `mintaBarang`
--

CREATE TABLE `mintaBarang` (
  `idMB` int(3) UNSIGNED ZEROFILL NOT NULL,
  `castMB` char(2) DEFAULT 'MB',
  `idMitra` char(5) DEFAULT NULL,
  `idBarang` char(5) DEFAULT NULL,
  `pemintaMB` varchar(50) DEFAULT NULL,
  `barangMB` varchar(100) DEFAULT NULL,
  `jumlahMB` int(11) DEFAULT NULL,
  `tglMB` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mintaBarang`
--

INSERT INTO `mintaBarang` (`idMB`, `castMB`, `idMitra`, `idBarang`, `pemintaMB`, `barangMB`, `jumlahMB`, `tglMB`) VALUES
(001, 'MB', 'MI001', 'b0016', 'Aji', 'ODP 8 Core', 40, '2018-07-10'),
(002, 'MB', 'MI001', 'b0001', 'Budi', 'Patchcord SC/UPC - SC/UPC 20m', 40, '2018-07-10'),
(003, 'MB', 'MI002', 'b0007', 'Dwiki', 'Patchcord SC/UPC - SC/UPC 5m', 15, '2018-07-10'),
(004, 'MB', 'MI002', 'b0001', 'Jarma', 'Patchcord SC/UPC - SC/UPC 20m', 10, '2018-07-11');

-- --------------------------------------------------------

--
-- Table structure for table `mitra`
--

CREATE TABLE `mitra` (
  `idMitra` varchar(5) NOT NULL,
  `namaMitra` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mitra`
--

INSERT INTO `mitra` (`idMitra`, `namaMitra`) VALUES
('MI001', 'SURABAYA'),
('MI002', 'JAKARTA');

-- --------------------------------------------------------

--
-- Table structure for table `purchaseOrder`
--

CREATE TABLE `purchaseOrder` (
  `idPO` int(3) UNSIGNED ZEROFILL NOT NULL,
  `castPO` char(2) DEFAULT 'PO',
  `idSupplier` char(5) DEFAULT NULL,
  `namaBarang` varchar(100) NOT NULL,
  `tglPO` date NOT NULL,
  `jumlahBarang` int(11) NOT NULL,
  `hargaBarang` float NOT NULL,
  `discountBarang` float NOT NULL,
  `grandtotal` float AS ((jumlahBarang*hargaBarang)-(hargaBarang*discountBarang)) VIRTUAL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchaseOrder`
--

INSERT INTO `purchaseOrder` (`idPO`, `castPO`, `idSupplier`, `namaBarang`, `tglPO`, `jumlahBarang`, `hargaBarang`, `discountBarang`) VALUES
(001, 'PO', 'SU001', 'ODB 8 Core', '0000-00-00', 15, 77000, 0.4),
(002, 'PO', 'SU002', 'OTP 16 Core', '0000-00-00', 24, 55000, 0.2),
(003, 'PO', 'SU002', 'ODP', '0000-00-00', 40, 40000, 0.5);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `idSupplier` char(5) NOT NULL,
  `namaSupplier` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`idSupplier`, `namaSupplier`) VALUES
('SU001', 'PT.Jaya'),
('SU002', 'PT. Baya'),
('SU003', 'PT.Warna'),
('SU004', 'PT. Karya');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` varchar(4) NOT NULL,
  `username` varchar(32) NOT NULL,
  `password` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`) VALUES
('0001', 'admin', 'admin'),
('0002', 'gudang', 'gudang');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barangKeluar`
--
ALTER TABLE `barangKeluar`
  ADD PRIMARY KEY (`idBK`),
  ADD KEY `idBarang` (`idBarang`);

--
-- Indexes for table `barangMasuk`
--
ALTER TABLE `barangMasuk`
  ADD PRIMARY KEY (`idBM`),
  ADD KEY `idBarang` (`idBarang`);

--
-- Indexes for table `masterBarang`
--
ALTER TABLE `masterBarang`
  ADD PRIMARY KEY (`idBarang`);

--
-- Indexes for table `mintaBarang`
--
ALTER TABLE `mintaBarang`
  ADD PRIMARY KEY (`idMB`),
  ADD KEY `fk_mb` (`idBarang`),
  ADD KEY `fk_mbMitra` (`idMitra`);

--
-- Indexes for table `mitra`
--
ALTER TABLE `mitra`
  ADD PRIMARY KEY (`idMitra`);

--
-- Indexes for table `purchaseOrder`
--
ALTER TABLE `purchaseOrder`
  ADD PRIMARY KEY (`idPO`),
  ADD KEY `fk_po` (`idSupplier`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`idSupplier`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `barangKeluar`
--
ALTER TABLE `barangKeluar`
  MODIFY `idBK` int(3) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `barangMasuk`
--
ALTER TABLE `barangMasuk`
  MODIFY `idBM` int(3) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `mintaBarang`
--
ALTER TABLE `mintaBarang`
  MODIFY `idMB` int(3) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `purchaseOrder`
--
ALTER TABLE `purchaseOrder`
  MODIFY `idPO` int(3) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `barangKeluar`
--
ALTER TABLE `barangKeluar`
  ADD CONSTRAINT `barangKeluar_ibfk_1` FOREIGN KEY (`idBarang`) REFERENCES `masterBarang` (`idBarang`);

--
-- Constraints for table `barangMasuk`
--
ALTER TABLE `barangMasuk`
  ADD CONSTRAINT `barangMasuk_ibfk_1` FOREIGN KEY (`idBarang`) REFERENCES `masterBarang` (`idBarang`);

--
-- Constraints for table `mintaBarang`
--
ALTER TABLE `mintaBarang`
  ADD CONSTRAINT `fk_mb` FOREIGN KEY (`idBarang`) REFERENCES `masterBarang` (`idBarang`),
  ADD CONSTRAINT `fk_mbMitra` FOREIGN KEY (`idMitra`) REFERENCES `mitra` (`idMitra`);

--
-- Constraints for table `purchaseOrder`
--
ALTER TABLE `purchaseOrder`
  ADD CONSTRAINT `fk_po` FOREIGN KEY (`idSupplier`) REFERENCES `supplier` (`idSupplier`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
