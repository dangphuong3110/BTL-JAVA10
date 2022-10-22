-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: hotel_management
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `idRoom` varchar(45) NOT NULL,
  `nameRoom` varchar(45) DEFAULT NULL,
  `typeRoom` varchar(45) DEFAULT NULL,
  `priceRoom` int DEFAULT NULL,
  `stateRoom` varchar(45) DEFAULT NULL,
  `noteRoom` varchar(45) DEFAULT NULL,
  `idStaff` varchar(45) DEFAULT NULL,
  `idService` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idRoom`),
  KEY `idStaff` (`idStaff`),
  KEY `idService` (`idService`),
  CONSTRAINT `room_ibfk_1` FOREIGN KEY (`idStaff`) REFERENCES `staff` (`idStaff`),
  CONSTRAINT `room_ibfk_2` FOREIGN KEY (`idService`) REFERENCES `service` (`idService`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES ('P01','101','Normal',400,'Unavailable','Null','NV01','DV01'),('P02','102','Normal',400,'Available','Null','NV02','DV01'),('P03','103','Normal',400,'Available','Null','NV01','DV01'),('P04','104','Normal',400,'Unavailable','Null','NV01','DV01'),('P05','201','VIP',1000,'Available','Null','NV04','DV05'),('P06','202','VIP',1000,'Available','Null','NV04','DV05'),('P07','203','VIP',1000,'Available','Null','NV04','DV05'),('P08','204','VIP',1000,'Available','Null','NV04','DV05'),('P09','301','VIP',1000,'Available','Null','NV06','DV01');
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-22 13:14:28
