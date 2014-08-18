CREATE DATABASE  IF NOT EXISTS `reg_tab_info` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `reg_tab_info`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: 10.0.229.249    Database: reg_tab_info
-- ------------------------------------------------------
-- Server version	5.5.37-0+wheezy1

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
-- Table structure for table `CodeShare`
--

DROP TABLE IF EXISTS `CodeShare`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CodeShare` (
  `id` bigint(20) NOT NULL,
  `regularFlight` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_m8t81x7wuxbw35bb3d1w1ak6s` (`regularFlight`),
  CONSTRAINT `FK_7uqgu32460lu9xyovutw31nt3` FOREIGN KEY (`id`) REFERENCES `Flight` (`id`),
  CONSTRAINT `FK_m8t81x7wuxbw35bb3d1w1ak6s` FOREIGN KEY (`regularFlight`) REFERENCES `RegularFlight` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CodeShare`
--

LOCK TABLES `CodeShare` WRITE;
/*!40000 ALTER TABLE `CodeShare` DISABLE KEYS */;
INSERT INTO `CodeShare` VALUES (6,1),(7,1),(8,1),(9,2),(10,3),(11,4),(49,27);
/*!40000 ALTER TABLE `CodeShare` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Company`
--

DROP TABLE IF EXISTS `Company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Company` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `imagePath` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Company`
--

LOCK TABLES `Company` WRITE;
/*!40000 ALTER TABLE `Company` DISABLE KEYS */;
INSERT INTO `Company` VALUES (1,'mau.jpg','МАУ'),(2,'da.jpg','Днеправиа'),(3,'afr.jpg','Air France'),(4,'klm.jpg','KLM'),(5,'wr.jpg','Роза Ветров'),(6,'astra.png','Astra Airlines'),(7,'af.jpg','Аэрофлот'),(8,'tra.jpg','Трансаэро'),(9,'aa.jpg','Австрийские авиалинии'),(10,'ta.jpg','Турецкие авиалинии'),(12,'ellin.jpg','Ellin Air');
/*!40000 ALTER TABLE `Company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Destination`
--

DROP TABLE IF EXISTS `Destination`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Destination` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `airPort` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Destination`
--

LOCK TABLES `Destination` WRITE;
/*!40000 ALTER TABLE `Destination` DISABLE KEYS */;
INSERT INTO `Destination` VALUES (1,'AYT'),(2,'GYD'),(3,'BUS'),(4,'BOJ'),(5,'VIE'),(6,'VNO'),(7,'DLM'),(8,'DOK'),(9,'DXB'),(10,'DUS'),(11,'EVN'),(12,'SZG'),(13,'IFO'),(14,'HER'),(15,'KBP'),(16,'KKT'),(17,'CFU'),(18,'LCA'),(19,'LWO'),(20,'DME'),(21,'SVO'),(22,'GPA'),(23,'SKG'),(24,'IST'),(25,'TBS'),(26,'TLV'),(27,'TIV'),(28,'HRG'),(29,'SSH'),(30,'CPH');
/*!40000 ALTER TABLE `Destination` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DestinationMultiLanguage`
--

DROP TABLE IF EXISTS `DestinationMultiLanguage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DestinationMultiLanguage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `airPortMultiLanguage` varchar(255) DEFAULT NULL,
  `destination` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_gbt964umvn90awp44ayy0013y` (`destination`),
  CONSTRAINT `FK_gbt964umvn90awp44ayy0013y` FOREIGN KEY (`destination`) REFERENCES `Destination` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DestinationMultiLanguage`
--

LOCK TABLES `DestinationMultiLanguage` WRITE;
/*!40000 ALTER TABLE `DestinationMultiLanguage` DISABLE KEYS */;
INSERT INTO `DestinationMultiLanguage` VALUES (1,'Київ',15),(2,'Киев',15),(3,'Kiyv',15),(4,'Анталия',1),(5,'Баку',2),(6,'Батуми',3),(7,'Бургас',4),(8,'Вена',5),(9,'Вильнюс',6),(10,'Даламан',7),(11,'Донецк',8),(12,'Дубаи',9),(13,'Дюссельдорф',10),(14,'Ереван',11),(15,'Зальцбург',12),(16,'Ивано-Франковск',13),(17,'Ираклион',14),(18,'Киттиля',16),(19,'Корфу',17),(20,'Ларнака',18),(21,'Львов',19),(22,'Москва',20),(23,'Москва',21),(24,'Патрас',22),(25,'Салоники',23),(26,'Стамбул',24),(27,'Тбилиси',25),(28,'Тель Авив',26),(29,'Тиват',27),(30,'Хургада',28),(31,'Шарм-Эль-Шейх',29),(32,'Копенгаген',30);
/*!40000 ALTER TABLE `DestinationMultiLanguage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Flight`
--

DROP TABLE IF EXISTS `Flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Flight` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `flightNumber` varchar(255) NOT NULL,
  `flightCompany` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_q1yb657f3oo92q8nffkywyd52` (`flightNumber`),
  KEY `FK_4eabxm5ajh456yti872qt0mt1` (`flightCompany`),
  CONSTRAINT `FK_4eabxm5ajh456yti872qt0mt1` FOREIGN KEY (`flightCompany`) REFERENCES `Company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Flight`
--

LOCK TABLES `Flight` WRITE;
/*!40000 ALTER TABLE `Flight` DISABLE KEYS */;
INSERT INTO `Flight` VALUES (1,'PS 072',1),(2,'Z6 004',2),(3,'Z6 006',2),(4,'Z6 008',2),(5,'Z6 002',2),(6,'Z6 1172 ',2),(7,'AF 3367 ',3),(8,'KL 3130',4),(9,'PS 1004',1),(10,'PS 1006',1),(11,'PS 1008',1),(12,'7W 3011',5),(13,'7W 3021',5),(14,'7W 3041',5),(15,'7W 3051',5),(16,'7W 3081',5),(17,'7W 3201',5),(18,'7W 3211',5),(19,'7W 3231',5),(20,'7W 3351',5),(21,'7W 3053',5),(22,'7W 3423',5),(23,'7W 7019',5),(24,'7W 8085',5),(25,'A2 142',6),(26,'OS 676',9),(27,'PS 791',1),(28,'SU 1817',7),(29,'TK 436',10),(30,'UN 242',8),(31,'Z6 201',2),(32,'Z6 501',2),(33,'Z6 503',2),(34,'Z6 511',2),(35,'Z6 517',2),(36,'Z6 523',2),(37,'7W 1103',5),(38,'7W 3131',5),(39,'7W 3391',5),(40,'7W 3771',5),(41,'7W 5011',5),(42,'7W 7737',5),(43,'ELB 142',12),(44,'ELB 242',12),(45,'Z6 203',2),(46,'Z6 507',2),(47,'Z6 513',2),(48,'Z6 521',2),(49,'PS 4791',1);
/*!40000 ALTER TABLE `Flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `FlightClass`
--

DROP TABLE IF EXISTS `FlightClass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `FlightClass` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `classColor` varchar(255) DEFAULT NULL,
  `className` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FlightClass`
--

LOCK TABLES `FlightClass` WRITE;
/*!40000 ALTER TABLE `FlightClass` DISABLE KEYS */;
INSERT INTO `FlightClass` VALUES (1,'227777','BUSINESS CLASS'),(2,'559955','ECONOMY CLASS'),(3,'559955','PREMIUM ECONOMY CLASS 	');
/*!40000 ALTER TABLE `FlightClass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `FlightRegistrationInfo`
--

DROP TABLE IF EXISTS `FlightRegistrationInfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `FlightRegistrationInfo` (
  `id` varchar(255) NOT NULL,
  `flight` bigint(20) DEFAULT NULL,
  `flightClass_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_7exkwtwo4pqd2deck5wwrjw07` (`flight`),
  KEY `FK_opq7dba4bkwfj6syq82cx1tlp` (`flightClass_id`),
  CONSTRAINT `FK_2t2l5dh7sl8sbrnuu2pvydm3d` FOREIGN KEY (`id`) REFERENCES `MonitorInfo` (`id`),
  CONSTRAINT `FK_7exkwtwo4pqd2deck5wwrjw07` FOREIGN KEY (`flight`) REFERENCES `RegularFlight` (`id`),
  CONSTRAINT `FK_opq7dba4bkwfj6syq82cx1tlp` FOREIGN KEY (`flightClass_id`) REFERENCES `FlightClass` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FlightRegistrationInfo`
--

LOCK TABLES `FlightRegistrationInfo` WRITE;
/*!40000 ALTER TABLE `FlightRegistrationInfo` DISABLE KEYS */;
INSERT INTO `FlightRegistrationInfo` VALUES ('Interior_2',1,1),('International_2',1,1),('International_4',1,1),('International_5',1,1),('International_6',1,1),('SAB_1',15,1),('SAB_2',1,1),('Test',18,1);
/*!40000 ALTER TABLE `FlightRegistrationInfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Image`
--

DROP TABLE IF EXISTS `Image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Image` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `imageFile` varchar(255) DEFAULT NULL,
  `imageName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Image`
--

LOCK TABLES `Image` WRITE;
/*!40000 ALTER TABLE `Image` DISABLE KEYS */;
INSERT INTO `Image` VALUES (1,'MAD_logo.jpg','Аэропорт Днепропетровск'),(2,'OS676b.gif','OS 676 B'),(3,'OS676e.gif','OS 676 E'),(4,'TK436E.jpg','TK436 economy'),(5,'TK436B.jpg','TK436 business'),(6,'TK436.gif','TK436 САБ'),(7,'SU1817b.gif','SU 1817b'),(8,'SU1817e.gif','SU 1817e'),(9,'THY_economy.jpg','THY_economy'),(10,'TK0436.gif','TK0436');
/*!40000 ALTER TABLE `Image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ImageInfo`
--

DROP TABLE IF EXISTS `ImageInfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ImageInfo` (
  `id` varchar(255) NOT NULL,
  `image_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_spxqp5x3j5xqi9negsk37rybx` (`image_id`),
  CONSTRAINT `FK_ocef0lya1o157tv0mpoet0pr7` FOREIGN KEY (`id`) REFERENCES `MonitorInfo` (`id`),
  CONSTRAINT `FK_spxqp5x3j5xqi9negsk37rybx` FOREIGN KEY (`image_id`) REFERENCES `Image` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ImageInfo`
--

LOCK TABLES `ImageInfo` WRITE;
/*!40000 ALTER TABLE `ImageInfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `ImageInfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Monitor`
--

DROP TABLE IF EXISTS `Monitor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Monitor` (
  `monitorName` varchar(255) NOT NULL,
  `monitorInfo_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`monitorName`),
  KEY `FK_k8dp4fh9tkb654k6n2x09gg4j` (`monitorInfo_id`),
  CONSTRAINT `FK_k8dp4fh9tkb654k6n2x09gg4j` FOREIGN KEY (`monitorInfo_id`) REFERENCES `MonitorInfo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Monitor`
--

LOCK TABLES `Monitor` WRITE;
/*!40000 ALTER TABLE `Monitor` DISABLE KEYS */;
INSERT INTO `Monitor` VALUES ('Interior_1','Interior_1'),('Interior_2','Interior_2'),('International_1','International_1'),('International_2','International_2'),('International_3','International_3'),('International_4','International_4'),('International_5','International_5'),('International_6','International_6'),('SAB_1','SAB_1'),('SAB_2','SAB_2'),('Test','Test');
/*!40000 ALTER TABLE `Monitor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MonitorInfo`
--

DROP TABLE IF EXISTS `MonitorInfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MonitorInfo` (
  `id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MonitorInfo`
--

LOCK TABLES `MonitorInfo` WRITE;
/*!40000 ALTER TABLE `MonitorInfo` DISABLE KEYS */;
INSERT INTO `MonitorInfo` VALUES ('Interior_1'),('Interior_2'),('International_1'),('International_2'),('International_3'),('International_4'),('International_5'),('International_6'),('International_7'),('International_8'),('SAB_1'),('SAB_2'),('Test');
/*!40000 ALTER TABLE `MonitorInfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RegularFlight`
--

DROP TABLE IF EXISTS `RegularFlight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `RegularFlight` (
  `id` bigint(20) NOT NULL,
  `flightDestination` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_45749n0xjs1yqdm9cjcmi23fa` (`flightDestination`),
  CONSTRAINT `FK_32c96vhevxkg3y0ppqav50a1e` FOREIGN KEY (`id`) REFERENCES `Flight` (`id`),
  CONSTRAINT `FK_45749n0xjs1yqdm9cjcmi23fa` FOREIGN KEY (`flightDestination`) REFERENCES `Destination` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RegularFlight`
--

LOCK TABLES `RegularFlight` WRITE;
/*!40000 ALTER TABLE `RegularFlight` DISABLE KEYS */;
INSERT INTO `RegularFlight` VALUES (12,1),(41,1),(36,2),(48,3),(19,4),(26,5),(42,6),(13,7),(14,9),(34,11),(20,12),(23,12),(31,13),(37,13),(16,14),(24,14),(1,15),(2,15),(3,15),(4,15),(5,15),(39,16),(44,17),(17,18),(45,19),(30,20),(32,20),(33,20),(28,21),(38,22),(25,23),(43,23),(29,24),(46,24),(47,25),(27,26),(35,26),(18,27),(22,28),(15,29),(21,29),(40,30);
/*!40000 ALTER TABLE `RegularFlight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RegularFlight_CodeShare`
--

DROP TABLE IF EXISTS `RegularFlight_CodeShare`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `RegularFlight_CodeShare` (
  `RegularFlight_id` bigint(20) NOT NULL,
  `codeShare_id` bigint(20) NOT NULL,
  PRIMARY KEY (`RegularFlight_id`,`codeShare_id`),
  UNIQUE KEY `UK_kaopk8ti7rsabyi1c6td4j9my` (`codeShare_id`),
  CONSTRAINT `FK_4xsoe4pqc5us4lh6skpp3ofpy` FOREIGN KEY (`RegularFlight_id`) REFERENCES `RegularFlight` (`id`),
  CONSTRAINT `FK_kaopk8ti7rsabyi1c6td4j9my` FOREIGN KEY (`codeShare_id`) REFERENCES `CodeShare` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RegularFlight_CodeShare`
--

LOCK TABLES `RegularFlight_CodeShare` WRITE;
/*!40000 ALTER TABLE `RegularFlight_CodeShare` DISABLE KEYS */;
INSERT INTO `RegularFlight_CodeShare` VALUES (1,6),(1,7),(1,8),(2,9),(3,10),(4,11),(27,49);
/*!40000 ALTER TABLE `RegularFlight_CodeShare` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TwoFlightsRegistrationInfo`
--

DROP TABLE IF EXISTS `TwoFlightsRegistrationInfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TwoFlightsRegistrationInfo` (
  `id` varchar(255) NOT NULL,
  `flight1` bigint(20) DEFAULT NULL,
  `flight2` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_84ll5f9oornlox6jslykm9x7p` (`flight1`),
  KEY `FK_i82w7j8ngq3tu7idg8bv0o2am` (`flight2`),
  CONSTRAINT `FK_t2c3b3dkbye407q28qkjp9mw2` FOREIGN KEY (`id`) REFERENCES `MonitorInfo` (`id`),
  CONSTRAINT `FK_84ll5f9oornlox6jslykm9x7p` FOREIGN KEY (`flight1`) REFERENCES `RegularFlight` (`id`),
  CONSTRAINT `FK_i82w7j8ngq3tu7idg8bv0o2am` FOREIGN KEY (`flight2`) REFERENCES `RegularFlight` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TwoFlightsRegistrationInfo`
--

LOCK TABLES `TwoFlightsRegistrationInfo` WRITE;
/*!40000 ALTER TABLE `TwoFlightsRegistrationInfo` DISABLE KEYS */;
INSERT INTO `TwoFlightsRegistrationInfo` VALUES ('Interior_1',2,2),('International_1',4,4),('International_3',37,12);
/*!40000 ALTER TABLE `TwoFlightsRegistrationInfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-08-18  8:29:37
