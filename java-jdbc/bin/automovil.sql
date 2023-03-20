-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
-- Server version: 8.0.27
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Database: `automovil`
--

DELIMITER $$
--
-- Procedures
--
DROP PROCEDURE IF EXISTS `Insertar`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `Insertar` (IN `idauto` CHAR(8), IN `mar` VARCHAR(20), IN `plac` VARCHAR(50), IN `pre` DECIMAL, IN `sto` INT, IN `fec` DATE, IN `est` TINYINT)  insert into automovil(IdAutomovil, marca, numeroplaca, precio, stock, fechafabricacion, estado) values(idauto,mar,plac,pre,sto,fec,est)$$

DROP PROCEDURE IF EXISTS `Listar`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `Listar` ()  select * from automovil
ORDER BY `IdAutomovil` ASC$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `automovil`
--

DROP TABLE IF EXISTS `automovil`;
CREATE TABLE IF NOT EXISTS `automovil` (
  `IdAutomovil` char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `marca` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `numeroplaca` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `precio` double NOT NULL,
  `stock` int NOT NULL,
  `fechafabricacion` date NOT NULL,
  `estado` tinyint(1) NOT NULL,
  PRIMARY KEY (`IdAutomovil`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `automovil`
--

INSERT INTO `automovil` (`IdAutomovil`, `marca`, `numeroplaca`, `precio`, `stock`, `fechafabricacion`, `estado`) VALUES
('PROD0001', 'VOLKSWAGEN', 'ABC-1234', 30000, 3, '2018-06-13', 1),
('PROD0002', 'VOLVO', 'DEF-5678', 10000.98, 1, '2019-06-06', 1),
('PROD0003', 'PEUGEOT', 'PRU-7886', 45086, 0, '2019-12-06', 0),
('PROD0004', 'NISSAN', 'FRN-9876', 56765, 1, '2017-11-23', 1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
