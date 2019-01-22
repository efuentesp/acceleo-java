-- MySQL dump 10.13  Distrib 5.5.52, for debian-linux-gnu (i686)
--
-- Host: localhost    Database: demoacceleo
-- ------------------------------------------------------
-- Server version	5.5.52-0ubuntu0.12.04.1

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
-- Table structure for table `authority`
--

DROP DATABASE IF EXISTS demoacceleo;

CREATE DATABASE demoacceleo;

USE demoacceleo;

DROP TABLE IF EXISTS `authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authority` (
  `id_authority` varbinary(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `enabled` tinyint(4) NOT NULL,
  `creationdate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `modifieddate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id_authority`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authority`
--

LOCK TABLES `authority` WRITE;
/*!40000 ALTER TABLE `authority` DISABLE KEYS */;
INSERT INTO `authority` VALUES ('788406be-edea-11e8-b1fb-d4bed9943d61','ADMIN',1,'2018-06-25 10:00:00',NULL);
/*!40000 ALTER TABLE `authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authority_privilege`
--

DROP TABLE IF EXISTS `authority_privilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authority_privilege` (
  `id_authority` varbinary(50) NOT NULL,
  `id_privilege` varbinary(50) NOT NULL,
  `id_aut_priv` varbinary(50) NOT NULL,
  `enabled` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_aut_priv`),
  UNIQUE KEY `UQ_AUTH_PRIV` (`id_authority`,`id_privilege`),
  KEY `id_privilege_idx` (`id_privilege`),
  KEY `id_authority_idx` (`id_authority`),
  CONSTRAINT `fk_id_authority` FOREIGN KEY (`id_authority`) REFERENCES `authority` (`id_authority`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_id_privilege` FOREIGN KEY (`id_privilege`) REFERENCES `privilege` (`id_privilege`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authority_privilege`
--

LOCK TABLES `authority_privilege` WRITE;
/*!40000 ALTER TABLE `authority_privilege` DISABLE KEYS */;
INSERT INTO `authority_privilege` VALUES ('788406be-edea-11e8-b1fb-d4bed9943d61','7fa860cf-eded-11e8-b1fb-d4bed9943d61','18a5e261-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7faa7ff2-eded-11e8-b1fb-d4bed9943d61','18a5f8b6-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7faa8165-eded-11e8-b1fb-d4bed9943d61','18a5f9d9-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7faa81fd-eded-11e8-b1fb-d4bed9943d61','18a5fab4-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7faa82d5-eded-11e8-b1fb-d4bed9943d61','18a5fb88-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7faa8363-eded-11e8-b1fb-d4bed9943d61','18a5fc52-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7faa8480-eded-11e8-b1fb-d4bed9943d61','18a5fd36-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7faa8507-eded-11e8-b1fb-d4bed9943d61','18a5fdfd-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4ca15-eded-11e8-b1fb-d4bed9943d61','18a5fed1-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4cc58-eded-11e8-b1fb-d4bed9943d61','18b0f43a-ee77-11e8-b1fb-d4bed9943d61',1);
/*!40000 ALTER TABLE `authority_privilege` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupo`
--

DROP TABLE IF EXISTS `grupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupo` (
  `id_grupo` varbinary(50) NOT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id_grupo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupo`
--

LOCK TABLES `grupo` WRITE;
/*!40000 ALTER TABLE `grupo` DISABLE KEYS */;
INSERT INTO `grupo` VALUES ('bac8a37a-ede7-11e8-b1fb-d4bed9943d61','MANAGE'),('bac8b0c9-ede7-11e8-b1fb-d4bed9943d61','USER'),('bac8b175-ede7-11e8-b1fb-d4bed9943d61','AUTHORITY');
/*!40000 ALTER TABLE `grupo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `privilege`
--

DROP TABLE IF EXISTS `privilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `privilege` (
  `id_privilege` varbinary(50) NOT NULL,
  `name` varchar(45) NOT NULL,
  `id_grupo` varbinary(50) NOT NULL,
  `enabled` tinyint(4) NOT NULL,
  `creationdate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `modifieddate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id_privilege`),
  KEY `id_group_idx` (`id_grupo`),
  CONSTRAINT `id_grupo` FOREIGN KEY (`id_grupo`) REFERENCES `grupo` (`id_grupo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `privilege`
--

LOCK TABLES `privilege` WRITE;
/*!40000 ALTER TABLE `privilege` DISABLE KEYS */;
INSERT INTO `privilege` VALUES ('7fa860cf-eded-11e8-b1fb-d4bed9943d61','ROLE:READ','bac8a37a-ede7-11e8-b1fb-d4bed9943d61',1,'2018-07-02 10:00:00',NULL),('7faa7ff2-eded-11e8-b1fb-d4bed9943d61','ROLE:UPDATE','bac8a37a-ede7-11e8-b1fb-d4bed9943d61',1,'2018-07-02 10:00:00',NULL),('7faa8165-eded-11e8-b1fb-d4bed9943d61','USER:CREATE','bac8b0c9-ede7-11e8-b1fb-d4bed9943d61',1,'2018-07-02 10:00:00',NULL),('7faa81fd-eded-11e8-b1fb-d4bed9943d61','USER:READ','bac8b0c9-ede7-11e8-b1fb-d4bed9943d61',1,'2018-07-02 10:00:00',NULL),('7faa82d5-eded-11e8-b1fb-d4bed9943d61','USER:UPDATE','bac8b0c9-ede7-11e8-b1fb-d4bed9943d61',1,'2018-07-02 10:00:00',NULL),('7faa8363-eded-11e8-b1fb-d4bed9943d61','USER:DELETE','bac8b0c9-ede7-11e8-b1fb-d4bed9943d61',1,'2018-07-02 10:00:00',NULL),('7faa8480-eded-11e8-b1fb-d4bed9943d61','PERMISSION:CREATE','bac8b175-ede7-11e8-b1fb-d4bed9943d61',1,'2018-07-02 10:00:00',NULL),('7faa8507-eded-11e8-b1fb-d4bed9943d61','PERMISSION:UPDATE','bac8b175-ede7-11e8-b1fb-d4bed9943d61',1,'2018-07-02 10:00:00',NULL),('7fb4ca15-eded-11e8-b1fb-d4bed9943d61','PERMISSION:READ','bac8b175-ede7-11e8-b1fb-d4bed9943d61',1,'2018-07-02 10:00:00',NULL),('7fb4cc58-eded-11e8-b1fb-d4bed9943d61','PERMISSION:DELETE','bac8b175-ede7-11e8-b1fb-d4bed9943d61',1,'2018-07-02 10:00:00',NULL);
/*!40000 ALTER TABLE `privilege` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id_user` varbinary(50) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `firstname` varchar(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT '1',
  `attemps` int(11) DEFAULT NULL,
  `lastpasswordresetdate` timestamp NULL DEFAULT NULL,
  `creationdate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `modifieddate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `USERNAME_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('a47d104e-ede6-11e8-b1fb-d4bed9943d61','admin','$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi','Normaysel','Carbajal','normaysel.carbajal@softtek.com',1,NULL,'2018-10-27 16:09:53','2018-06-25 10:00:00',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_authority`
--

DROP TABLE IF EXISTS `user_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_authority` (
  `id_user` varbinary(50) NOT NULL,
  `id_authority` varbinary(50) NOT NULL,
  `id_user_auth` varbinary(50) NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_user_auth`),
  KEY `id_authority_idx` (`id_authority`),
  KEY `id_user_idx` (`id_user`),
  CONSTRAINT `id_authority` FOREIGN KEY (`id_authority`) REFERENCES `authority` (`id_authority`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_authority`
--

LOCK TABLES `user_authority` WRITE;
/*!40000 ALTER TABLE `user_authority` DISABLE KEYS */;
INSERT INTO `user_authority` VALUES ('a47d104e-ede6-11e8-b1fb-d4bed9943d61','788406be-edea-11e8-b1fb-d4bed9943d61','f9786436-edef-11e8-b1fb-d4bed9943d61',1);
/*!40000 ALTER TABLE `user_authority` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-22 23:56:01
