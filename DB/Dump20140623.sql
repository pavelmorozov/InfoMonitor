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
-- Table structure for table `codeshare`
--

DROP TABLE IF EXISTS `codeshare`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `codeshare` (
  `id` bigint(20) NOT NULL,
  `regularFlight` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_m8t81x7wuxbw35bb3d1w1ak6s` (`regularFlight`),
  CONSTRAINT `FK_7uqgu32460lu9xyovutw31nt3` FOREIGN KEY (`id`) REFERENCES `flight` (`id`),
  CONSTRAINT `FK_m8t81x7wuxbw35bb3d1w1ak6s` FOREIGN KEY (`regularFlight`) REFERENCES `regularflight` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `codeshare`
--

LOCK TABLES `codeshare` WRITE;
/*!40000 ALTER TABLE `codeshare` DISABLE KEYS */;
INSERT INTO `codeshare` VALUES (2,1),(3,1),(4,1);
/*!40000 ALTER TABLE `codeshare` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `imagePath` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'/path/path1.jpg','New company 1'),(2,'/path/path2.jpg','New company 2'),(3,'/path/path3.jpg','New company 3'),(4,'/path/path4.jpg','New company 4'),(5,'/path/path.jpg','New company'),(6,'/path/path.jpg','New company'),(7,'/path/path.jpg','New company'),(8,'/path/path.jpg','New company'),(9,'/path/path.jpg','New company'),(10,'/path/path.jpg','New company'),(11,'/path/path.jpg','New company'),(12,'/path/path.jpg','New company'),(13,'/path/path.jpg','New company'),(14,'/path/path.jpg','New company'),(15,'/path/path.jpg','New company'),(16,'/path/path.jpg','New company'),(17,'/path/path.jpg','New company'),(18,'/path/path.jpg','New company'),(19,'/path/path.jpg','New company'),(20,'/path/path.jpg','New company'),(21,'/path/path.jpg','New company'),(22,'/path/path.jpg','New company');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `destination`
--

DROP TABLE IF EXISTS `destination`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `destination` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `airPort` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `destination`
--

LOCK TABLES `destination` WRITE;
/*!40000 ALTER TABLE `destination` DISABLE KEYS */;
INSERT INTO `destination` VALUES (1,'DNK');
/*!40000 ALTER TABLE `destination` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `destinationmultilanguage`
--

DROP TABLE IF EXISTS `destinationmultilanguage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `destinationmultilanguage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `airPortMultiLanguage` varchar(255) DEFAULT NULL,
  `destination` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_gbt964umvn90awp44ayy0013y` (`destination`),
  CONSTRAINT `FK_gbt964umvn90awp44ayy0013y` FOREIGN KEY (`destination`) REFERENCES `destination` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `destinationmultilanguage`
--

LOCK TABLES `destinationmultilanguage` WRITE;
/*!40000 ALTER TABLE `destinationmultilanguage` DISABLE KEYS */;
INSERT INTO `destinationmultilanguage` VALUES (1,'Днепропетровск',1),(2,'Дніпропетровськ',1),(3,'Dnipropetrovsk',1);
/*!40000 ALTER TABLE `destinationmultilanguage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flight` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `flightNumber` varchar(255) NOT NULL,
  `flightCompany` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_q1yb657f3oo92q8nffkywyd52` (`flightNumber`),
  KEY `FK_4eabxm5ajh456yti872qt0mt1` (`flightCompany`),
  CONSTRAINT `FK_4eabxm5ajh456yti872qt0mt1` FOREIGN KEY (`flightCompany`) REFERENCES `company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES (1,'AAA 100',1),(2,'B 100',2),(3,'C 100',3),(4,'D 100',4),(5,'E 100',5);
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flightclass`
--

DROP TABLE IF EXISTS `flightclass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flightclass` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `className` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flightclass`
--

LOCK TABLES `flightclass` WRITE;
/*!40000 ALTER TABLE `flightclass` DISABLE KEYS */;
INSERT INTO `flightclass` VALUES (1,'Business Class');
/*!40000 ALTER TABLE `flightclass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flightregistrationinfo`
--

DROP TABLE IF EXISTS `flightregistrationinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flightregistrationinfo` (
  `id` varchar(255) NOT NULL,
  `flight` bigint(20) DEFAULT NULL,
  `flightClass_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_7exkwtwo4pqd2deck5wwrjw07` (`flight`),
  KEY `FK_opq7dba4bkwfj6syq82cx1tlp` (`flightClass_id`),
  CONSTRAINT `FK_2t2l5dh7sl8sbrnuu2pvydm3d` FOREIGN KEY (`id`) REFERENCES `monitorinfo` (`id`),
  CONSTRAINT `FK_7exkwtwo4pqd2deck5wwrjw07` FOREIGN KEY (`flight`) REFERENCES `regularflight` (`id`),
  CONSTRAINT `FK_opq7dba4bkwfj6syq82cx1tlp` FOREIGN KEY (`flightClass_id`) REFERENCES `flightclass` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flightregistrationinfo`
--

LOCK TABLES `flightregistrationinfo` WRITE;
/*!40000 ALTER TABLE `flightregistrationinfo` DISABLE KEYS */;
INSERT INTO `flightregistrationinfo` VALUES ('Monitor1',1,1),('Monitor2',5,1);
/*!40000 ALTER TABLE `flightregistrationinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imageinfo`
--

DROP TABLE IF EXISTS `imageinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `imageinfo` (
  `imageName` varchar(255) DEFAULT NULL,
  `imagePath` varchar(255) DEFAULT NULL,
  `id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_ocef0lya1o157tv0mpoet0pr7` FOREIGN KEY (`id`) REFERENCES `monitorinfo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imageinfo`
--

LOCK TABLES `imageinfo` WRITE;
/*!40000 ALTER TABLE `imageinfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `imageinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monitor`
--

DROP TABLE IF EXISTS `monitor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `monitor` (
  `MonitorName` varchar(255) NOT NULL,
  `monitorInfo_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`MonitorName`),
  KEY `FK_k8dp4fh9tkb654k6n2x09gg4j` (`monitorInfo_id`),
  CONSTRAINT `FK_k8dp4fh9tkb654k6n2x09gg4j` FOREIGN KEY (`monitorInfo_id`) REFERENCES `monitorinfo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monitor`
--

LOCK TABLES `monitor` WRITE;
/*!40000 ALTER TABLE `monitor` DISABLE KEYS */;
INSERT INTO `monitor` VALUES ('Монитор 3',NULL),('Monitor1','Monitor1'),('Monitor2','Monitor2');
/*!40000 ALTER TABLE `monitor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monitorinfo`
--

DROP TABLE IF EXISTS `monitorinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `monitorinfo` (
  `id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monitorinfo`
--

LOCK TABLES `monitorinfo` WRITE;
/*!40000 ALTER TABLE `monitorinfo` DISABLE KEYS */;
INSERT INTO `monitorinfo` VALUES ('Monitor1'),('Monitor2'),('Монитор 3');
/*!40000 ALTER TABLE `monitorinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `regularflight`
--

DROP TABLE IF EXISTS `regularflight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `regularflight` (
  `id` bigint(20) NOT NULL,
  `flightDestination` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_45749n0xjs1yqdm9cjcmi23fa` (`flightDestination`),
  CONSTRAINT `FK_32c96vhevxkg3y0ppqav50a1e` FOREIGN KEY (`id`) REFERENCES `flight` (`id`),
  CONSTRAINT `FK_45749n0xjs1yqdm9cjcmi23fa` FOREIGN KEY (`flightDestination`) REFERENCES `destination` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `regularflight`
--

LOCK TABLES `regularflight` WRITE;
/*!40000 ALTER TABLE `regularflight` DISABLE KEYS */;
INSERT INTO `regularflight` VALUES (1,1),(5,1);
/*!40000 ALTER TABLE `regularflight` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `twoflightsregistrationinfo`
--

DROP TABLE IF EXISTS `twoflightsregistrationinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `twoflightsregistrationinfo` (
  `id` varchar(255) NOT NULL,
  `flight1` bigint(20) DEFAULT NULL,
  `flight2` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_84ll5f9oornlox6jslykm9x7p` (`flight1`),
  KEY `FK_i82w7j8ngq3tu7idg8bv0o2am` (`flight2`),
  CONSTRAINT `FK_84ll5f9oornlox6jslykm9x7p` FOREIGN KEY (`flight1`) REFERENCES `regularflight` (`id`),
  CONSTRAINT `FK_i82w7j8ngq3tu7idg8bv0o2am` FOREIGN KEY (`flight2`) REFERENCES `regularflight` (`id`),
  CONSTRAINT `FK_t2c3b3dkbye407q28qkjp9mw2` FOREIGN KEY (`id`) REFERENCES `monitorinfo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `twoflightsregistrationinfo`
--

LOCK TABLES `twoflightsregistrationinfo` WRITE;
/*!40000 ALTER TABLE `twoflightsregistrationinfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `twoflightsregistrationinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-06-23  6:49:21
