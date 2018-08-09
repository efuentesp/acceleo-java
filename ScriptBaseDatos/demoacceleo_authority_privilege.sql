-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: 127.0.0.1    Database: demoacceleo
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `authority_privilege`
--

DROP TABLE IF EXISTS `authority_privilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authority_privilege` (
  `id_authority` int(11) NOT NULL,
  `id_privilege` int(11) NOT NULL,
  `id_aut_priv` int(11) NOT NULL AUTO_INCREMENT,
  `enabled` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_aut_priv`),
  UNIQUE KEY `UQ_AUTH_PRIV` (`id_authority`,`id_privilege`),
  KEY `id_privilege_idx` (`id_privilege`),
  KEY `id_authority_idx` (`id_authority`),
  CONSTRAINT `fk_id_authority` FOREIGN KEY (`id_authority`) REFERENCES `authority` (`id_authority`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_id_privilege` FOREIGN KEY (`id_privilege`) REFERENCES `privilege` (`id_privilege`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authority_privilege`
--

LOCK TABLES `authority_privilege` WRITE;
/*!40000 ALTER TABLE `authority_privilege` DISABLE KEYS */;
INSERT INTO `authority_privilege` VALUES (1,9,17,1),(1,10,18,1),(1,23,37,1),(1,24,38,1),(1,25,39,1),(1,26,40,1),(1,27,41,1),(1,28,42,1),(1,29,43,1),(1,30,44,1),(2,30,48,0),(3,30,49,0),(6,30,50,1),(7,30,51,0),(2,31,62,1),(2,32,63,1),(2,33,64,1),(2,34,65,1),(2,39,292,1),(2,40,293,1),(2,41,294,1),(2,42,295,1),(2,43,296,1),(2,44,297,1),(2,45,298,1),(2,46,299,1),(2,35,300,1),(2,36,301,1),(2,37,302,1),(2,38,303,1),(1,31,304,1),(1,32,305,1),(1,33,306,1),(1,34,307,1),(1,35,308,1),(1,36,309,1),(1,37,310,1),(1,38,311,1),(1,39,312,1),(1,40,313,1),(1,41,314,1),(1,42,315,1),(1,43,316,1),(1,44,317,1),(1,45,318,1),(1,46,319,1);
/*!40000 ALTER TABLE `authority_privilege` ENABLE KEYS */;
UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-06 12:00:14