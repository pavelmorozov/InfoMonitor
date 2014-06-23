CREATE DATABASE  IF NOT EXISTS `reg_tab_info` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `reg_tab_info`;
-- MySQL dump 10.13  Distrib 5.6.11, for Win32 (x86)
--
-- Host: localhost    Database: reg_tab_info
-- ------------------------------------------------------
-- Server version	5.6.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `regularflight_codeshare`
--

DROP TABLE IF EXISTS `regularflight_codeshare`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `regularflight_codeshare` (
  `RegularFlight_id` bigint(20) NOT NULL,
  `codeShare_id` bigint(20) NOT NULL,
  PRIMARY KEY (`RegularFlight_id`,`codeShare_id`),
  UNIQUE KEY `UK_kaopk8ti7rsabyi1c6td4j9my` (`codeShare_id`),
  CONSTRAINT `FK_4xsoe4pqc5us4lh6skpp3ofpy` FOREIGN KEY (`RegularFlight_id`) REFERENCES `regularflight` (`id`),
  CONSTRAINT `FK_kaopk8ti7rsabyi1c6td4j9my` FOREIGN KEY (`codeShare_id`) REFERENCES `codeshare` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `regularflight_codeshare`
--

LOCK TABLES `regularflight_codeshare` WRITE;
/*!40000 ALTER TABLE `regularflight_codeshare` DISABLE KEYS */;
INSERT INTO `regularflight_codeshare` VALUES (1,2),(1,3),(1,4);
/*!40000 ALTER TABLE `regularflight_codeshare` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-06-23  6:48:40
