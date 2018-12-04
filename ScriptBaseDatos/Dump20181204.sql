-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: demoacceleo
-- ------------------------------------------------------
-- Server version	5.7.22-log

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

DROP TABLE IF EXISTS `authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authority` (
  `id_authority` varbinary(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `enabled` tinyint(4) NOT NULL,
  `creationdate` timestamp(6) NOT NULL DEFAULT '0000-00-00 00:00:00.000000',
  `modifieddate` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id_authority`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authority`
--

LOCK TABLES `authority` WRITE;
/*!40000 ALTER TABLE `authority` DISABLE KEYS */;
INSERT INTO `authority` VALUES ('788406be-edea-11e8-b1fb-d4bed9943d61','ADMIN',1,'2018-06-25 10:00:00.000000',NULL),('788646cb-edea-11e8-b1fb-d4bed9943d61','USER',1,'2018-06-25 10:00:00.000000',NULL),('78864827-edea-11e8-b1fb-d4bed9943d61','ANONYMOUS',1,'2018-06-25 10:00:00.000000',NULL),('7886488e-edea-11e8-b1fb-d4bed9943d61','BASICO',1,'2018-06-25 10:00:00.000000',NULL),('788648e4-edea-11e8-b1fb-d4bed9943d61','TEST2',0,'2018-07-03 10:00:00.000000',NULL),('7886493a-edea-11e8-b1fb-d4bed9943d61','TEST',0,'2018-07-04 10:00:00.000000',NULL),('78864993-edea-11e8-b1fb-d4bed9943d61','USER TEST',1,'2018-07-05 10:00:00.000000',NULL),('78864a00-edea-11e8-b1fb-d4bed9943d61','BASICO2',0,'2018-07-13 10:00:00.000000','2018-07-13 10:00:00.000000');
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
INSERT INTO `authority_privilege` VALUES ('788406be-edea-11e8-b1fb-d4bed9943d61','7fa860cf-eded-11e8-b1fb-d4bed9943d61','18a5e261-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7faa7ff2-eded-11e8-b1fb-d4bed9943d61','18a5f8b6-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7faa8165-eded-11e8-b1fb-d4bed9943d61','18a5f9d9-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7faa81fd-eded-11e8-b1fb-d4bed9943d61','18a5fab4-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7faa82d5-eded-11e8-b1fb-d4bed9943d61','18a5fb88-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7faa8363-eded-11e8-b1fb-d4bed9943d61','18a5fc52-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7faa8480-eded-11e8-b1fb-d4bed9943d61','18a5fd36-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7faa8507-eded-11e8-b1fb-d4bed9943d61','18a5fdfd-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4ca15-eded-11e8-b1fb-d4bed9943d61','18a5fed1-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4cc58-eded-11e8-b1fb-d4bed9943d61','18b0f43a-ee77-11e8-b1fb-d4bed9943d61',1),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb4cc58-eded-11e8-b1fb-d4bed9943d61','18b0f5c1-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb4cc58-eded-11e8-b1fb-d4bed9943d61','18b0f68e-ee77-11e8-b1fb-d4bed9943d61',1),('7886493a-edea-11e8-b1fb-d4bed9943d61','7fb4cc58-eded-11e8-b1fb-d4bed9943d61','18b0f762-ee77-11e8-b1fb-d4bed9943d61',1),('78864993-edea-11e8-b1fb-d4bed9943d61','7fb4cc58-eded-11e8-b1fb-d4bed9943d61','18b0f81f-ee77-11e8-b1fb-d4bed9943d61',0),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb4ce2e-eded-11e8-b1fb-d4bed9943d61','18b0f8dc-ee77-11e8-b1fb-d4bed9943d61',0),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb4cf0f-eded-11e8-b1fb-d4bed9943d61','18b0f9a9-ee77-11e8-b1fb-d4bed9943d61',0),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb4cfbb-eded-11e8-b1fb-d4bed9943d61','18b0fa73-ee77-11e8-b1fb-d4bed9943d61',0),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb4d054-eded-11e8-b1fb-d4bed9943d61','18b0fb39-ee77-11e8-b1fb-d4bed9943d61',0),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb4d318-eded-11e8-b1fb-d4bed9943d61','18b0fc07-ee77-11e8-b1fb-d4bed9943d61',0),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb4d3a3-eded-11e8-b1fb-d4bed9943d61','18b0fccd-ee77-11e8-b1fb-d4bed9943d61',0),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb4d435-eded-11e8-b1fb-d4bed9943d61','18b0fd91-ee77-11e8-b1fb-d4bed9943d61',0),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb4d4c0-eded-11e8-b1fb-d4bed9943d61','18b0fe51-ee77-11e8-b1fb-d4bed9943d61',0),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb4d544-eded-11e8-b1fb-d4bed9943d61','18b0ff0d-ee77-11e8-b1fb-d4bed9943d61',0),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb4d5cf-eded-11e8-b1fb-d4bed9943d61','18b0ffcd-ee77-11e8-b1fb-d4bed9943d61',0),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb4d65b-eded-11e8-b1fb-d4bed9943d61','18b1008d-ee77-11e8-b1fb-d4bed9943d61',0),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb4d746-eded-11e8-b1fb-d4bed9943d61','18b1014a-ee77-11e8-b1fb-d4bed9943d61',0),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb4d0e2-eded-11e8-b1fb-d4bed9943d61','18b10207-ee77-11e8-b1fb-d4bed9943d61',0),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb4d16d-eded-11e8-b1fb-d4bed9943d61','18b102ca-ee77-11e8-b1fb-d4bed9943d61',0),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb4d1ff-eded-11e8-b1fb-d4bed9943d61','18b1038d-ee77-11e8-b1fb-d4bed9943d61',0),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb4d28d-eded-11e8-b1fb-d4bed9943d61','18b10451-ee77-11e8-b1fb-d4bed9943d61',0),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4ce2e-eded-11e8-b1fb-d4bed9943d61','18b10511-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4cf0f-eded-11e8-b1fb-d4bed9943d61','18b105db-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4cfbb-eded-11e8-b1fb-d4bed9943d61','18b106a8-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4d054-eded-11e8-b1fb-d4bed9943d61','18b10772-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4d0e2-eded-11e8-b1fb-d4bed9943d61','18b10849-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4d16d-eded-11e8-b1fb-d4bed9943d61','18b1091d-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4d1ff-eded-11e8-b1fb-d4bed9943d61','18b109e0-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4d28d-eded-11e8-b1fb-d4bed9943d61','18b10aa4-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4d318-eded-11e8-b1fb-d4bed9943d61','18b10b67-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4d3a3-eded-11e8-b1fb-d4bed9943d61','18b10c2a-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4d435-eded-11e8-b1fb-d4bed9943d61','18b10ce7-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4d4c0-eded-11e8-b1fb-d4bed9943d61','18b10da7-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4d544-eded-11e8-b1fb-d4bed9943d61','18b10e64-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4d5cf-eded-11e8-b1fb-d4bed9943d61','18b10f27-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4d65b-eded-11e8-b1fb-d4bed9943d61','18b10fe7-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4d746-eded-11e8-b1fb-d4bed9943d61','18b110ae-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4d7ca-eded-11e8-b1fb-d4bed9943d61','18b1116e-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4d855-eded-11e8-b1fb-d4bed9943d61','18b1122e-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4d943-eded-11e8-b1fb-d4bed9943d61','18b112f1-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4d9c8-eded-11e8-b1fb-d4bed9943d61','18b113b5-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4da50-eded-11e8-b1fb-d4bed9943d61','18b11475-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4dadb-eded-11e8-b1fb-d4bed9943d61','18b11535-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4db5f-eded-11e8-b1fb-d4bed9943d61','18b115f1-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4dbe7-eded-11e8-b1fb-d4bed9943d61','18b116b5-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4dc6f-eded-11e8-b1fb-d4bed9943d61','18b1176e-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4dcfa-eded-11e8-b1fb-d4bed9943d61','18b1182e-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4dd85-eded-11e8-b1fb-d4bed9943d61','18b118eb-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4de0c-eded-11e8-b1fb-d4bed9943d61','18b119b5-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4de94-eded-11e8-b1fb-d4bed9943d61','18b11a75-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4df1c-eded-11e8-b1fb-d4bed9943d61','18b11b38-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4dfaa-eded-11e8-b1fb-d4bed9943d61','18b11bf8-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4e039-eded-11e8-b1fb-d4bed9943d61','18b11cb5-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4e0c0-eded-11e8-b1fb-d4bed9943d61','18b11d75-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4e148-eded-11e8-b1fb-d4bed9943d61','18b11e35-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4e1d3-eded-11e8-b1fb-d4bed9943d61','18b11ef2-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4e25e-eded-11e8-b1fb-d4bed9943d61','18b11fb5-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4e2e3-eded-11e8-b1fb-d4bed9943d61','18b12072-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4e36a-eded-11e8-b1fb-d4bed9943d61','18b12132-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4e3f5-eded-11e8-b1fb-d4bed9943d61','18b121f2-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4e47d-eded-11e8-b1fb-d4bed9943d61','18b122b2-ee77-11e8-b1fb-d4bed9943d61',1),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb4d7ca-eded-11e8-b1fb-d4bed9943d61','18b12372-ee77-11e8-b1fb-d4bed9943d61',0),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb4d855-eded-11e8-b1fb-d4bed9943d61','18b1244c-ee77-11e8-b1fb-d4bed9943d61',0),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb4d943-eded-11e8-b1fb-d4bed9943d61','18b12527-ee77-11e8-b1fb-d4bed9943d61',0),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb4da50-eded-11e8-b1fb-d4bed9943d61','18b125f1-ee77-11e8-b1fb-d4bed9943d61',0),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb4dbe7-eded-11e8-b1fb-d4bed9943d61','18b126c1-ee77-11e8-b1fb-d4bed9943d61',0),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4f09f-eded-11e8-b1fb-d4bed9943d61','18b12792-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4efba-eded-11e8-b1fb-d4bed9943d61','18b129e2-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4ef32-eded-11e8-b1fb-d4bed9943d61','18b12acd-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4eeae-eded-11e8-b1fb-d4bed9943d61','18b12ba1-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4ee26-eded-11e8-b1fb-d4bed9943d61','18b12c9a-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4eda2-eded-11e8-b1fb-d4bed9943d61','18b12d74-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4ed1a-eded-11e8-b1fb-d4bed9943d61','18b12e37-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4ec99-eded-11e8-b1fb-d4bed9943d61','18b12f01-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4ec15-eded-11e8-b1fb-d4bed9943d61','18b12fc5-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4ea7d-eded-11e8-b1fb-d4bed9943d61','18b1308f-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4eb05-eded-11e8-b1fb-d4bed9943d61','18b13159-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4eb90-eded-11e8-b1fb-d4bed9943d61','18b1321f-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4e505-eded-11e8-b1fb-d4bed9943d61','18b132e9-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4e5e6-eded-11e8-b1fb-d4bed9943d61','18b133c7-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4e66e-eded-11e8-b1fb-d4bed9943d61','18b13494-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4e9c7-eded-11e8-b1fb-d4bed9943d61','18b1355b-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4f126-eded-11e8-b1fb-d4bed9943d61','18b13622-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4f1ab-eded-11e8-b1fb-d4bed9943d61','18b136ef-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4f236-eded-11e8-b1fb-d4bed9943d61','18b137bf-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4f37e-eded-11e8-b1fb-d4bed9943d61','18b13889-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4f437-eded-11e8-b1fb-d4bed9943d61','18b13953-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4f522-eded-11e8-b1fb-d4bed9943d61','18b13a21-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4f5ad-eded-11e8-b1fb-d4bed9943d61','18b13add-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4f632-eded-11e8-b1fb-d4bed9943d61','18b13bb5-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4f6b3-eded-11e8-b1fb-d4bed9943d61','18b13c78-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4f797-eded-11e8-b1fb-d4bed9943d61','18b13d3b-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4f822-eded-11e8-b1fb-d4bed9943d61','18b13df5-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4f8aa-eded-11e8-b1fb-d4bed9943d61','18b13eb1-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4f932-eded-11e8-b1fb-d4bed9943d61','18b13f71-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4f9b9-eded-11e8-b1fb-d4bed9943d61','18b1402e-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4fa44-eded-11e8-b1fb-d4bed9943d61','18b140e7-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4facf-eded-11e8-b1fb-d4bed9943d61','18b141a4-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4fb57-eded-11e8-b1fb-d4bed9943d61','18b14261-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4fd2a-eded-11e8-b1fb-d4bed9943d61','18b1433f-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4fc9c-eded-11e8-b1fb-d4bed9943d61','18b143ff-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4fdb2-eded-11e8-b1fb-d4bed9943d61','18b144cf-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4feb4-eded-11e8-b1fb-d4bed9943d61','18b145a6-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4ff38-eded-11e8-b1fb-d4bed9943d61','18b14674-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb4ffb9-eded-11e8-b1fb-d4bed9943d61','18b1473e-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb5003b-eded-11e8-b1fb-d4bed9943d61','18b1480b-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb500bf-eded-11e8-b1fb-d4bed9943d61','18b148dc-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb501a7-eded-11e8-b1fb-d4bed9943d61','18b149e8-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb50235-eded-11e8-b1fb-d4bed9943d61','18b15789-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb502bd-eded-11e8-b1fb-d4bed9943d61','18b15892-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb50345-eded-11e8-b1fb-d4bed9943d61','18b1595c-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb503c9-eded-11e8-b1fb-d4bed9943d61','18b15a1f-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb50457-eded-11e8-b1fb-d4bed9943d61','18b15ae6-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb504df-eded-11e8-b1fb-d4bed9943d61','18b15bbd-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb50567-eded-11e8-b1fb-d4bed9943d61','18b15ca8-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb5064b-eded-11e8-b1fb-d4bed9943d61','18b15d72-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb5073a-eded-11e8-b1fb-d4bed9943d61','18b15e53-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb5081e-eded-11e8-b1fb-d4bed9943d61','18b15f1a-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb508a3-eded-11e8-b1fb-d4bed9943d61','18b15fe1-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb50941-eded-11e8-b1fb-d4bed9943d61','18b160a4-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb50a58-eded-11e8-b1fb-d4bed9943d61','18b16167-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb50bbd-eded-11e8-b1fb-d4bed9943d61','18b1622b-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb50ad9-eded-11e8-b1fb-d4bed9943d61','18b1645a-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb50c48-eded-11e8-b1fb-d4bed9943d61','18b166f7-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb509d0-eded-11e8-b1fb-d4bed9943d61','18b167f9-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb50cd3-eded-11e8-b1fb-d4bed9943d61','18b168cd-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb50d5b-eded-11e8-b1fb-d4bed9943d61','18b169bb-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb51041-eded-11e8-b1fb-d4bed9943d61','18b16b4c-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb50e71-eded-11e8-b1fb-d4bed9943d61','18b16c30-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb50de6-eded-11e8-b1fb-d4bed9943d61','18b16d15-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb50f5f-eded-11e8-b1fb-d4bed9943d61','18b16df6-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb510c2-eded-11e8-b1fb-d4bed9943d61','18b78964-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb51655-eded-11e8-b1fb-d4bed9943d61','18b78b5f-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb5175a-eded-11e8-b1fb-d4bed9943d61','18b78c4d-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb51955-eded-11e8-b1fb-d4bed9943d61','18b78d2b-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb519e3-eded-11e8-b1fb-d4bed9943d61','18b78e09-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb5189b-eded-11e8-b1fb-d4bed9943d61','18b78ed6-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb51a6e-eded-11e8-b1fb-d4bed9943d61','18b78fcb-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb51c86-eded-11e8-b1fb-d4bed9943d61','18b790a2-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb51b77-eded-11e8-b1fb-d4bed9943d61','18b79173-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb51d0e-eded-11e8-b1fb-d4bed9943d61','18b7923d-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb51c02-eded-11e8-b1fb-d4bed9943d61','18b7930d-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb51af6-eded-11e8-b1fb-d4bed9943d61','18b793d7-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb51d93-eded-11e8-b1fb-d4bed9943d61','18b794a1-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb51e1a-eded-11e8-b1fb-d4bed9943d61','18b79568-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb5239d-eded-11e8-b1fb-d4bed9943d61','18b79632-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb5244f-eded-11e8-b1fb-d4bed9943d61','18b79706-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb5260b-eded-11e8-b1fb-d4bed9943d61','18b7981c-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb52579-eded-11e8-b1fb-d4bed9943d61','18b79914-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb524e4-eded-11e8-b1fb-d4bed9943d61','18b799e5-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb526ce-eded-11e8-b1fb-d4bed9943d61','18b79aaf-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb52760-eded-11e8-b1fb-d4bed9943d61','18b79b7c-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb5287a-eded-11e8-b1fb-d4bed9943d61','18b79c46-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb527f2-eded-11e8-b1fb-d4bed9943d61','18b79d10-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb52982-eded-11e8-b1fb-d4bed9943d61','18b79ddd-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb52901-eded-11e8-b1fb-d4bed9943d61','18b79ea7-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb52a8b-eded-11e8-b1fb-d4bed9943d61','18b79f71-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb52a07-eded-11e8-b1fb-d4bed9943d61','18b7a073-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb52b2a-eded-11e8-b1fb-d4bed9943d61','18b7a144-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb52bb2-eded-11e8-b1fb-d4bed9943d61','18b7a20e-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb52c3a-eded-11e8-b1fb-d4bed9943d61','18b7a2d4-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb52dc0-eded-11e8-b1fb-d4bed9943d61','18b7a39e-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb52d3c-eded-11e8-b1fb-d4bed9943d61','18b7a46c-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb52cbb-eded-11e8-b1fb-d4bed9943d61','18b7a536-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb52e48-eded-11e8-b1fb-d4bed9943d61','18b7a5fc-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb52ec9-eded-11e8-b1fb-d4bed9943d61','18b7a6c6-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb53180-eded-11e8-b1fb-d4bed9943d61','18bcd49f-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb53074-eded-11e8-b1fb-d4bed9943d61','18bcd637-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb52fdf-eded-11e8-b1fb-d4bed9943d61','18bcd72c-ee77-11e8-b1fb-d4bed9943d61',1),('788406be-edea-11e8-b1fb-d4bed9943d61','7fb53103-eded-11e8-b1fb-d4bed9943d61','18bcd813-ee77-11e8-b1fb-d4bed9943d61',1),('7886488e-edea-11e8-b1fb-d4bed9943d61','7fb4ce2e-eded-11e8-b1fb-d4bed9943d61','18bcd902-ee77-11e8-b1fb-d4bed9943d61',0),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb53180-eded-11e8-b1fb-d4bed9943d61','18bcda01-ee77-11e8-b1fb-d4bed9943d61',1),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb53103-eded-11e8-b1fb-d4bed9943d61','18bcdae8-ee77-11e8-b1fb-d4bed9943d61',1),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb53074-eded-11e8-b1fb-d4bed9943d61','18bcdbc6-ee77-11e8-b1fb-d4bed9943d61',1),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb52fdf-eded-11e8-b1fb-d4bed9943d61','18bcdca4-ee77-11e8-b1fb-d4bed9943d61',1),('7886488e-edea-11e8-b1fb-d4bed9943d61','7fb52fdf-eded-11e8-b1fb-d4bed9943d61','18bcdd82-ee77-11e8-b1fb-d4bed9943d61',1),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb52ec9-eded-11e8-b1fb-d4bed9943d61','18bcde70-ee77-11e8-b1fb-d4bed9943d61',1),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb52e48-eded-11e8-b1fb-d4bed9943d61','18bcdf51-ee77-11e8-b1fb-d4bed9943d61',1),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb52dc0-eded-11e8-b1fb-d4bed9943d61','18bce02f-ee77-11e8-b1fb-d4bed9943d61',1),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb52d3c-eded-11e8-b1fb-d4bed9943d61','18bce10a-ee77-11e8-b1fb-d4bed9943d61',1),('7886488e-edea-11e8-b1fb-d4bed9943d61','7fb52d3c-eded-11e8-b1fb-d4bed9943d61','18bce1e1-ee77-11e8-b1fb-d4bed9943d61',1),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb52cbb-eded-11e8-b1fb-d4bed9943d61','18bce2b1-ee77-11e8-b1fb-d4bed9943d61',1),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb52c3a-eded-11e8-b1fb-d4bed9943d61','18bce38c-ee77-11e8-b1fb-d4bed9943d61',1),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb52bb2-eded-11e8-b1fb-d4bed9943d61','18bce470-ee77-11e8-b1fb-d4bed9943d61',1),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb52b2a-eded-11e8-b1fb-d4bed9943d61','18bce54b-ee77-11e8-b1fb-d4bed9943d61',1),('7886488e-edea-11e8-b1fb-d4bed9943d61','7fb52b2a-eded-11e8-b1fb-d4bed9943d61','18bce625-ee77-11e8-b1fb-d4bed9943d61',1),('7886488e-edea-11e8-b1fb-d4bed9943d61','7fb52a8b-eded-11e8-b1fb-d4bed9943d61','18bce6fd-ee77-11e8-b1fb-d4bed9943d61',1),('7886488e-edea-11e8-b1fb-d4bed9943d61','7fb52a07-eded-11e8-b1fb-d4bed9943d61','18bce80c-ee77-11e8-b1fb-d4bed9943d61',1),('7886488e-edea-11e8-b1fb-d4bed9943d61','7fb52982-eded-11e8-b1fb-d4bed9943d61','18bce8f7-ee77-11e8-b1fb-d4bed9943d61',1),('7886488e-edea-11e8-b1fb-d4bed9943d61','7fb52901-eded-11e8-b1fb-d4bed9943d61','18bcea71-ee77-11e8-b1fb-d4bed9943d61',1),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb52901-eded-11e8-b1fb-d4bed9943d61','18bceb6c-ee77-11e8-b1fb-d4bed9943d61',1),('7886488e-edea-11e8-b1fb-d4bed9943d61','7fb5287a-eded-11e8-b1fb-d4bed9943d61','18bcec75-ee77-11e8-b1fb-d4bed9943d61',0),('7886488e-edea-11e8-b1fb-d4bed9943d61','7fb527f2-eded-11e8-b1fb-d4bed9943d61','18bced77-ee77-11e8-b1fb-d4bed9943d61',0),('7886488e-edea-11e8-b1fb-d4bed9943d61','7fb52760-eded-11e8-b1fb-d4bed9943d61','18bcee79-ee77-11e8-b1fb-d4bed9943d61',0),('7886488e-edea-11e8-b1fb-d4bed9943d61','7fb526ce-eded-11e8-b1fb-d4bed9943d61','18bcef78-ee77-11e8-b1fb-d4bed9943d61',1),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb526ce-eded-11e8-b1fb-d4bed9943d61','18bcf074-ee77-11e8-b1fb-d4bed9943d61',1),('7886488e-edea-11e8-b1fb-d4bed9943d61','7fb5239d-eded-11e8-b1fb-d4bed9943d61','18c5c505-ee77-11e8-b1fb-d4bed9943d61',1),('7886488e-edea-11e8-b1fb-d4bed9943d61','7fb51e1a-eded-11e8-b1fb-d4bed9943d61','18c5c79f-ee77-11e8-b1fb-d4bed9943d61',1),('7886488e-edea-11e8-b1fb-d4bed9943d61','7fb51d93-eded-11e8-b1fb-d4bed9943d61','18c5c8a8-ee77-11e8-b1fb-d4bed9943d61',1),('7886488e-edea-11e8-b1fb-d4bed9943d61','7fb51d0e-eded-11e8-b1fb-d4bed9943d61','18c5c9a0-ee77-11e8-b1fb-d4bed9943d61',1),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb51d0e-eded-11e8-b1fb-d4bed9943d61','18cbcd39-ee77-11e8-b1fb-d4bed9943d61',1),('7886488e-edea-11e8-b1fb-d4bed9943d61','7fb51c86-eded-11e8-b1fb-d4bed9943d61','18cbcec9-ee77-11e8-b1fb-d4bed9943d61',0),('7886488e-edea-11e8-b1fb-d4bed9943d61','7fb51c02-eded-11e8-b1fb-d4bed9943d61','18cbcfc1-ee77-11e8-b1fb-d4bed9943d61',0),('7886488e-edea-11e8-b1fb-d4bed9943d61','7fb51b77-eded-11e8-b1fb-d4bed9943d61','18cbd0b3-ee77-11e8-b1fb-d4bed9943d61',0),('7886488e-edea-11e8-b1fb-d4bed9943d61','7fb51af6-eded-11e8-b1fb-d4bed9943d61','18cbd19b-ee77-11e8-b1fb-d4bed9943d61',1),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb51af6-eded-11e8-b1fb-d4bed9943d61','18cbd286-ee77-11e8-b1fb-d4bed9943d61',1),('7886488e-edea-11e8-b1fb-d4bed9943d61','7fb5189b-eded-11e8-b1fb-d4bed9943d61','18cbd36e-ee77-11e8-b1fb-d4bed9943d61',1),('7886488e-edea-11e8-b1fb-d4bed9943d61','7fb51041-eded-11e8-b1fb-d4bed9943d61','18cbd470-ee77-11e8-b1fb-d4bed9943d61',1),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb50f5f-eded-11e8-b1fb-d4bed9943d61','18cbd554-ee77-11e8-b1fb-d4bed9943d61',1),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb50e71-eded-11e8-b1fb-d4bed9943d61','18cbd63f-ee77-11e8-b1fb-d4bed9943d61',1),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb50de6-eded-11e8-b1fb-d4bed9943d61','18cbd724-ee77-11e8-b1fb-d4bed9943d61',1),('7886488e-edea-11e8-b1fb-d4bed9943d61','7fb50d5b-eded-11e8-b1fb-d4bed9943d61','18cbd805-ee77-11e8-b1fb-d4bed9943d61',1),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb50d5b-eded-11e8-b1fb-d4bed9943d61','18cbd8df-ee77-11e8-b1fb-d4bed9943d61',1),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb50cd3-eded-11e8-b1fb-d4bed9943d61','18cbd9c4-ee77-11e8-b1fb-d4bed9943d61',1),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb50c48-eded-11e8-b1fb-d4bed9943d61','18cbdaa2-ee77-11e8-b1fb-d4bed9943d61',1),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb50bbd-eded-11e8-b1fb-d4bed9943d61','18cbdb86-ee77-11e8-b1fb-d4bed9943d61',1),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb50ad9-eded-11e8-b1fb-d4bed9943d61','18cbdc6e-ee77-11e8-b1fb-d4bed9943d61',1),('7886488e-edea-11e8-b1fb-d4bed9943d61','7fb50ad9-eded-11e8-b1fb-d4bed9943d61','18cbdd66-ee77-11e8-b1fb-d4bed9943d61',1),('7886488e-edea-11e8-b1fb-d4bed9943d61','7fb508a3-eded-11e8-b1fb-d4bed9943d61','18cbde4b-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fa860cf-eded-11e8-b1fb-d4bed9943d61','18cbdf28-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7faa7ff2-eded-11e8-b1fb-d4bed9943d61','18cbe014-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7faa8165-eded-11e8-b1fb-d4bed9943d61','18cbe0ee-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7faa81fd-eded-11e8-b1fb-d4bed9943d61','18cbe1c9-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7faa82d5-eded-11e8-b1fb-d4bed9943d61','18cbe353-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7faa8363-eded-11e8-b1fb-d4bed9943d61','18cbe44b-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7faa8480-eded-11e8-b1fb-d4bed9943d61','18cbe536-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7faa8507-eded-11e8-b1fb-d4bed9943d61','18cbe621-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb4ca15-eded-11e8-b1fb-d4bed9943d61','18cfe7a9-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb4ce2e-eded-11e8-b1fb-d4bed9943d61','18cfe91f-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb4cf0f-eded-11e8-b1fb-d4bed9943d61','18cfea14-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb4cfbb-eded-11e8-b1fb-d4bed9943d61','18cfeaf8-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb4d054-eded-11e8-b1fb-d4bed9943d61','18cfebd6-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb4d0e2-eded-11e8-b1fb-d4bed9943d61','18cfecb1-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb4d16d-eded-11e8-b1fb-d4bed9943d61','18cfed88-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb4d1ff-eded-11e8-b1fb-d4bed9943d61','18cfee5f-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb4d28d-eded-11e8-b1fb-d4bed9943d61','18cfef36-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb4d3a3-eded-11e8-b1fb-d4bed9943d61','18cff00a-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb4d435-eded-11e8-b1fb-d4bed9943d61','18cff0e1-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb4d318-eded-11e8-b1fb-d4bed9943d61','18cff1c9-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb4d4c0-eded-11e8-b1fb-d4bed9943d61','18cff29d-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb4d544-eded-11e8-b1fb-d4bed9943d61','18cff39f-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb4d5cf-eded-11e8-b1fb-d4bed9943d61','18cff473-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb4d65b-eded-11e8-b1fb-d4bed9943d61','18cff53a-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb4d746-eded-11e8-b1fb-d4bed9943d61','18cff607-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb4eeae-eded-11e8-b1fb-d4bed9943d61','18cff6d4-ee77-11e8-b1fb-d4bed9943d61',1),('7886488e-edea-11e8-b1fb-d4bed9943d61','7fb50941-eded-11e8-b1fb-d4bed9943d61','18cff79e-ee77-11e8-b1fb-d4bed9943d61',0),('7886488e-edea-11e8-b1fb-d4bed9943d61','7fb509d0-eded-11e8-b1fb-d4bed9943d61','18cff879-ee77-11e8-b1fb-d4bed9943d61',0),('7886488e-edea-11e8-b1fb-d4bed9943d61','7fb50a58-eded-11e8-b1fb-d4bed9943d61','18cff93c-ee77-11e8-b1fb-d4bed9943d61',0),('7886488e-edea-11e8-b1fb-d4bed9943d61','7fb510c2-eded-11e8-b1fb-d4bed9943d61','18cffa1d-ee77-11e8-b1fb-d4bed9943d61',0),('7886488e-edea-11e8-b1fb-d4bed9943d61','7fb51655-eded-11e8-b1fb-d4bed9943d61','18cffaeb-ee77-11e8-b1fb-d4bed9943d61',0),('7886488e-edea-11e8-b1fb-d4bed9943d61','7fb5175a-eded-11e8-b1fb-d4bed9943d61','18cffbb1-ee77-11e8-b1fb-d4bed9943d61',0),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb508a3-eded-11e8-b1fb-d4bed9943d61','18cffc78-ee77-11e8-b1fb-d4bed9943d61',1),('7886488e-edea-11e8-b1fb-d4bed9943d61','7faa81fd-eded-11e8-b1fb-d4bed9943d61','18cffd42-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb50ad9-eded-11e8-b1fb-d4bed9943d61','18cffe08-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb50d5b-eded-11e8-b1fb-d4bed9943d61','18cffedc-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb51041-eded-11e8-b1fb-d4bed9943d61','18cfffad-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb510c2-eded-11e8-b1fb-d4bed9943d61','18d0007d-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb5175a-eded-11e8-b1fb-d4bed9943d61','18d0014b-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb51655-eded-11e8-b1fb-d4bed9943d61','18d00215-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb5189b-eded-11e8-b1fb-d4bed9943d61','18d00303-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb51955-eded-11e8-b1fb-d4bed9943d61','18d003d0-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb519e3-eded-11e8-b1fb-d4bed9943d61','18d0049a-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb51a6e-eded-11e8-b1fb-d4bed9943d61','18d00564-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb51af6-eded-11e8-b1fb-d4bed9943d61','18d00631-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb51b77-eded-11e8-b1fb-d4bed9943d61','18d006fb-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb51c02-eded-11e8-b1fb-d4bed9943d61','18d007bf-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb51c86-eded-11e8-b1fb-d4bed9943d61','18d00882-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb51d0e-eded-11e8-b1fb-d4bed9943d61','18d00945-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb5244f-eded-11e8-b1fb-d4bed9943d61','18d00a09-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb524e4-eded-11e8-b1fb-d4bed9943d61','18d00acf-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb52579-eded-11e8-b1fb-d4bed9943d61','18d00bb1-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb5260b-eded-11e8-b1fb-d4bed9943d61','18d00c7a-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb526ce-eded-11e8-b1fb-d4bed9943d61','18d00d4b-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb52760-eded-11e8-b1fb-d4bed9943d61','18d00e0e-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb527f2-eded-11e8-b1fb-d4bed9943d61','18d00ed5-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb5287a-eded-11e8-b1fb-d4bed9943d61','18d00f98-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb52901-eded-11e8-b1fb-d4bed9943d61','18d01058-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb52b2a-eded-11e8-b1fb-d4bed9943d61','18d0111f-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb52d3c-eded-11e8-b1fb-d4bed9943d61','18d011e2-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb52fdf-eded-11e8-b1fb-d4bed9943d61','18d012a9-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb53103-eded-11e8-b1fb-d4bed9943d61','18d01380-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb50941-eded-11e8-b1fb-d4bed9943d61','18d01451-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb509d0-eded-11e8-b1fb-d4bed9943d61','18d4b05a-ee77-11e8-b1fb-d4bed9943d61',1),('78864827-edea-11e8-b1fb-d4bed9943d61','7fb50a58-eded-11e8-b1fb-d4bed9943d61','18d4b1f1-ee77-11e8-b1fb-d4bed9943d61',1),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb50567-eded-11e8-b1fb-d4bed9943d61','18d4b2e3-ee77-11e8-b1fb-d4bed9943d61',1),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb5064b-eded-11e8-b1fb-d4bed9943d61','18da165a-ee77-11e8-b1fb-d4bed9943d61',1),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb5073a-eded-11e8-b1fb-d4bed9943d61','18da17da-ee77-11e8-b1fb-d4bed9943d61',1),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb5081e-eded-11e8-b1fb-d4bed9943d61','18da18bb-ee77-11e8-b1fb-d4bed9943d61',1),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb50345-eded-11e8-b1fb-d4bed9943d61','18da1cd1-ee77-11e8-b1fb-d4bed9943d61',1),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb503c9-eded-11e8-b1fb-d4bed9943d61','18da1dd7-ee77-11e8-b1fb-d4bed9943d61',1),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb50457-eded-11e8-b1fb-d4bed9943d61','18da1eb1-ee77-11e8-b1fb-d4bed9943d61',1),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb504df-eded-11e8-b1fb-d4bed9943d61','18da202b-ee77-11e8-b1fb-d4bed9943d61',1),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb500bf-eded-11e8-b1fb-d4bed9943d61','18da2102-ee77-11e8-b1fb-d4bed9943d61',1),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb501a7-eded-11e8-b1fb-d4bed9943d61','18da21dd-ee77-11e8-b1fb-d4bed9943d61',1),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb50235-eded-11e8-b1fb-d4bed9943d61','18da22b7-ee77-11e8-b1fb-d4bed9943d61',1),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb502bd-eded-11e8-b1fb-d4bed9943d61','18da2388-ee77-11e8-b1fb-d4bed9943d61',1),('788646cb-edea-11e8-b1fb-d4bed9943d61','7fb4ca15-eded-11e8-b1fb-d4bed9943d61','18da245f-ee77-11e8-b1fb-d4bed9943d61',0);
/*!40000 ALTER TABLE `authority_privilege` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `candidato`
--

DROP TABLE IF EXISTS `candidato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `candidato` (
  `nombre` varchar(100) DEFAULT NULL,
  `apellidopaterno` varchar(100) DEFAULT NULL,
  `apellidomaterno` varchar(100) DEFAULT NULL,
  `fecha` timestamp(6) NULL DEFAULT NULL,
  `genero` varchar(50) DEFAULT NULL,
  `estatuscandidato` varchar(50) DEFAULT NULL,
  `candidatoId` varbinary(50) NOT NULL,
  PRIMARY KEY (`candidatoId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidato`
--

LOCK TABLES `candidato` WRITE;
/*!40000 ALTER TABLE `candidato` DISABLE KEYS */;
INSERT INTO `candidato` VALUES ('Juan','Perez','Perez','2000-11-15 00:00:00.000000','male','1','19069234-e941-11e8-9f32-f2801f1b9fd1'),('Rosalba','Barrera','Blanco','2018-11-26 21:10:28.000000','MAS','E2','ac1046dc-6751-1733-8167-51ecac4e0001'),('Candidato 2 - 1','Apellido paterno 2','Apellido materno 2','2018-11-20 06:00:00.000000','MAS','E1','ac1046dc-6752-1098-8167-527e2c39000e');
/*!40000 ALTER TABLE `candidato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `direccion`
--

DROP TABLE IF EXISTS `direccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `direccion` (
  `calle` varchar(100) DEFAULT NULL,
  `cp` varchar(100) DEFAULT NULL,
  `ciudad` varchar(100) DEFAULT NULL,
  `estado` varchar(100) DEFAULT NULL,
  `direccionId` varbinary(50) NOT NULL,
  PRIMARY KEY (`direccionId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `direccion`
--

LOCK TABLES `direccion` WRITE;
/*!40000 ALTER TABLE `direccion` DISABLE KEYS */;
INSERT INTO `direccion` VALUES ('Calle 1 - 1','12345','Ciudad 1','Estado 1','ac1046dc-6751-1fc8-8167-51cf0c2f0006'),('Calle 3','12345','Ciudad 3','Estado 3','ac1046dc-6752-1098-8167-527c4c3e000c');
/*!40000 ALTER TABLE `direccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `documento`
--

DROP TABLE IF EXISTS `documento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `documento` (
  `nombre` varchar(100) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `size` int(11) NOT NULL,
  `documentoId` varbinary(50) NOT NULL,
  PRIMARY KEY (`documentoId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documento`
--

LOCK TABLES `documento` WRITE;
/*!40000 ALTER TABLE `documento` DISABLE KEYS */;
INSERT INTO `documento` VALUES ('Documento 1','Documento 1',2,'ac1046dc-6751-122c-8167-5164f8500002'),('Documento 2','Documento 2',2,'ac1046dc-6752-1098-8167-527935420009');
/*!40000 ALTER TABLE `documento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evento`
--

DROP TABLE IF EXISTS `evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evento` (
  `tipoevento` varchar(50) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `posicionId` varbinary(50) DEFAULT NULL,
  `candidatoId` varbinary(50) DEFAULT NULL,
  `fecha` timestamp(6) NULL DEFAULT NULL,
  `responsable` varchar(100) DEFAULT NULL,
  `notas` varchar(100) DEFAULT NULL,
  `fechareal` timestamp(6) NULL DEFAULT NULL,
  `responsablereal` varchar(100) DEFAULT NULL,
  `feedback` varchar(100) DEFAULT NULL,
  `comentarios` varchar(100) DEFAULT NULL,
  `estatusevento` varchar(50) DEFAULT NULL,
  `eventoId` varbinary(50) NOT NULL,
  PRIMARY KEY (`eventoId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento`
--

LOCK TABLES `evento` WRITE;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
INSERT INTO `evento` VALUES ('D','Evento 1','¨F\‹gRòÅgR¸Q\0','í4\ÈA\Ëü2ÚÄü\—','2018-11-27 15:49:50.000000','Dr. Susana Reyna Reyna','5tKQmC1tMh','2018-11-27 15:49:50.000000','Bertha Mendoza Mendoza','2jM4XPMQa0ftd9lL6B2MTa6037b9fsxUDPjMqDzk9w9X8Wsb0oS3SuHg2l2','jVQ6ibxsTaUIOY6KT6XeqkV4tduhhUrGS','E5','ac1046dc-6755-1782-8167-5607d1870005'),('D','Evento 2-1','¨F\‹gRòÅgR¸Q\0','í4\ÈA\Ëü2ÚÄü\—','2018-11-27 15:49:50.000000','Dr. Susana Reyna Reyna','5tKQmC1tMh','2018-11-27 15:49:50.000000','Bertha Mendoza Mendoza','2jM4XPMQa0ftd9lL6B2MTa6037b9fsxUDPjMqDzk9w9X8Wsb0oS3SuHg2l2','jVQ6ibxsTaUIOY6KT6XeqkV4tduhhUrGS','E5','ac1046dc-6755-1782-8167-560d12be0006');
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `filial`
--

DROP TABLE IF EXISTS `filial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `filial` (
  `nombre` varchar(100) DEFAULT NULL,
  `ubicacion` varchar(100) DEFAULT NULL,
  `ciudad` varchar(100) DEFAULT NULL,
  `estado` varchar(100) DEFAULT NULL,
  `telefono` varchar(100) DEFAULT NULL,
  `sitio` varchar(100) DEFAULT NULL,
  `contacto` varchar(100) DEFAULT NULL,
  `notas` varchar(100) DEFAULT NULL,
  `filialId` varbinary(50) NOT NULL,
  PRIMARY KEY (`filialId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `filial`
--

LOCK TABLES `filial` WRITE;
/*!40000 ALTER TABLE `filial` DISABLE KEYS */;
INSERT INTO `filial` VALUES ('Filial 1','Ubicacion filial 1','Ciudad 1','Estado 1','698 894 6122','Matsoft','Contacto 1','Nota 1','ac1046dc-6751-1fc8-8167-51d417ae0007');
/*!40000 ALTER TABLE `filial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genero`
--

DROP TABLE IF EXISTS `genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genero` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `valor` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genero`
--

LOCK TABLES `genero` WRITE;
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
INSERT INTO `genero` VALUES (1,'Masculino','M'),(2,'Femenino','F');
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;
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
INSERT INTO `grupo` VALUES ('bac8a37a-ede7-11e8-b1fb-d4bed9943d61','MANAGE'),('bac8b0c9-ede7-11e8-b1fb-d4bed9943d61','USER'),('bac8b175-ede7-11e8-b1fb-d4bed9943d61','AUTHORITY'),('bac8b1d2-ede7-11e8-b1fb-d4bed9943d61','APPLICATION'),('bac8b214-ede7-11e8-b1fb-d4bed9943d61','FUNCTIONALSERVICE'),('bac8b253-ede7-11e8-b1fb-d4bed9943d61','MENU'),('bac8b295-ede7-11e8-b1fb-d4bed9943d61','MODULE'),('bac8b306-ede7-11e8-b1fb-d4bed9943d61','CUENTADEAHORRO'),('bac8b358-ede7-11e8-b1fb-d4bed9943d61','APORTACION'),('bac8b391-ede7-11e8-b1fb-d4bed9943d61','DEPARTAMENTO'),('bac8b3cc-ede7-11e8-b1fb-d4bed9943d61','EMPRESA'),('bac8b408-ede7-11e8-b1fb-d4bed9943d61','PLANTA'),('bac8b443-ede7-11e8-b1fb-d4bed9943d61','TASADEINTERES'),('bac8b47f-ede7-11e8-b1fb-d4bed9943d61','SOCIO'),('bac8b4bb-ede7-11e8-b1fb-d4bed9943d61','PERFIL'),('bac8b4f6-ede7-11e8-b1fb-d4bed9943d61','INTERES'),('bac8b532-ede7-11e8-b1fb-d4bed9943d61','DOMICILIO'),('bac8b571-ede7-11e8-b1fb-d4bed9943d61','BENEFICIARIO'),('bac8b5a9-ede7-11e8-b1fb-d4bed9943d61','CUENTABANCARIA'),('bac8b620-ede7-11e8-b1fb-d4bed9943d61','ORDENSIMPLIFICADA'),('bac8b662-ede7-11e8-b1fb-d4bed9943d61','OPERADORPRODUCCION'),('bac8b69b-ede7-11e8-b1fb-d4bed9943d61','ETIQUETAASIGNADA'),('bac8b6d6-ede7-11e8-b1fb-d4bed9943d61','CLIENTE'),('bac8b70e-ede7-11e8-b1fb-d4bed9943d61','AFILIADO'),('bac8b74a-ede7-11e8-b1fb-d4bed9943d61','BENEFICIARIO'),('bac8b789-ede7-11e8-b1fb-d4bed9943d61','BENEFICIARIO'),('bac8b7c5-ede7-11e8-b1fb-d4bed9943d61','TIPOPENSION'),('bac8b7fd-ede7-11e8-b1fb-d4bed9943d61','SOLICITUDPENSION'),('bac8b835-ede7-11e8-b1fb-d4bed9943d61','USUARIO'),('bac8b86d-ede7-11e8-b1fb-d4bed9943d61','TRAYECTORIA'),('bac8b8a6-ede7-11e8-b1fb-d4bed9943d61','SOLICITUD'),('bac8b8de-ede7-11e8-b1fb-d4bed9943d61','ROL'),('bac8b916-ede7-11e8-b1fb-d4bed9943d61','RECLUTADOR'),('bac8b952-ede7-11e8-b1fb-d4bed9943d61','RECLUTADOR'),('bac8b98a-ede7-11e8-b1fb-d4bed9943d61','PUESTO'),('bac8b9c6-ede7-11e8-b1fb-d4bed9943d61','POSICION'),('bac8ba01-ede7-11e8-b1fb-d4bed9943d61','PERMISO'),('bac8ba36-ede7-11e8-b1fb-d4bed9943d61','FILIAL'),('bac8ba6f-ede7-11e8-b1fb-d4bed9943d61','EVENTO'),('bac8baa7-ede7-11e8-b1fb-d4bed9943d61','DOCUMENTO'),('bac8bae2-ede7-11e8-b1fb-d4bed9943d61','DIRECCION'),('bac8bb1b-ede7-11e8-b1fb-d4bed9943d61','CANDIDATO');
/*!40000 ALTER TABLE `grupo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permiso`
--

DROP TABLE IF EXISTS `permiso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permiso` (
  `rolId` varbinary(50) DEFAULT NULL,
  `funcion` varchar(100) DEFAULT NULL,
  `ruta` varchar(100) DEFAULT NULL,
  `nivelpermiso` varchar(100) DEFAULT NULL,
  `permisoId` varbinary(50) NOT NULL,
  PRIMARY KEY (`permisoId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permiso`
--

LOCK TABLES `permiso` WRITE;
/*!40000 ALTER TABLE `permiso` DISABLE KEYS */;
INSERT INTO `permiso` VALUES ('¨F\‹gUÇÅgV˜\0','Sub-Ex-','q4V86so0td4ayP','w1v7MQ9fWyB2ZjX03OxXhwcvPY7ayVV5','ac1046dc-6755-1782-8167-562346e2000b');
/*!40000 ALTER TABLE `permiso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posicion`
--

DROP TABLE IF EXISTS `posicion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `posicion` (
  `filialId` varbinary(50) DEFAULT NULL,
  `puestos` varchar(50) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `fecha` timestamp(6) NULL DEFAULT NULL,
  `contacto` varchar(100) DEFAULT NULL,
  `salario` decimal(10,2) DEFAULT NULL,
  `vacantes` int(11) NOT NULL,
  `tiponomina` varchar(50) DEFAULT NULL,
  `reclutadorId` varbinary(50) DEFAULT NULL,
  `estatusposicion` varchar(50) DEFAULT NULL,
  `posicionId` varbinary(50) NOT NULL,
  PRIMARY KEY (`posicionId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posicion`
--

LOCK TABLES `posicion` WRITE;
/*!40000 ALTER TABLE `posicion` DISABLE KEYS */;
INSERT INTO `posicion` VALUES ('¨F\‹gQ»ÅgQ\‘Æ\0','A','Nombre posicion 1','Descripcion 1','2018-11-26 21:10:28.000000','Contacto 1',4897.00,2,'B','¨F\‹gQ3ÅgQ˘5¸\0','E3','ac1046dc-6752-1098-8167-521cfc510004'),('¨F\‹gQ»ÅgQ\‘Æ\0','G','Nombre 1','Descripcion 1','2018-11-26 21:10:28.000000','Srita. Graciela Rodr√≠guez Rodr√≠guez',4897.00,529740,'B','¨F\‹gQ3ÅgQ˘5¸\0','E3','ac1046dc-6752-1098-8167-521feff50005'),('¨F\‹gQ»ÅgQ\‘Æ\0','A','Posicion 3 - 1','Vacante 1','2018-11-26 06:00:00.000000','Responsable de la posicion 3',1.00,1,'A','¨F\‹gQ3ÅgQ˘5¸\0','E1','ac1046dc-6752-1098-8167-528d89e70010');
/*!40000 ALTER TABLE `posicion` ENABLE KEYS */;
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
  `creationdate` timestamp(6) NOT NULL DEFAULT '0000-00-00 00:00:00.000000',
  `modifieddate` timestamp(6) NULL DEFAULT NULL,
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
INSERT INTO `privilege` VALUES ('7fa860cf-eded-11e8-b1fb-d4bed9943d61','ROLE:READ','bac8a37a-ede7-11e8-b1fb-d4bed9943d61',1,'2018-07-02 10:00:00.000000',NULL),('7faa7ff2-eded-11e8-b1fb-d4bed9943d61','ROLE:UPDATE','bac8a37a-ede7-11e8-b1fb-d4bed9943d61',1,'2018-07-02 10:00:00.000000',NULL),('7faa8165-eded-11e8-b1fb-d4bed9943d61','USER:CREATE','bac8b0c9-ede7-11e8-b1fb-d4bed9943d61',1,'2018-07-02 10:00:00.000000',NULL),('7faa81fd-eded-11e8-b1fb-d4bed9943d61','USER:READ','bac8b0c9-ede7-11e8-b1fb-d4bed9943d61',1,'2018-07-02 10:00:00.000000',NULL),('7faa82d5-eded-11e8-b1fb-d4bed9943d61','USER:UPDATE','bac8b0c9-ede7-11e8-b1fb-d4bed9943d61',1,'2018-07-02 10:00:00.000000',NULL),('7faa8363-eded-11e8-b1fb-d4bed9943d61','USER:DELETE','bac8b0c9-ede7-11e8-b1fb-d4bed9943d61',1,'2018-07-02 10:00:00.000000',NULL),('7faa8480-eded-11e8-b1fb-d4bed9943d61','PERMISSION:CREATE','bac8b175-ede7-11e8-b1fb-d4bed9943d61',1,'2018-07-02 10:00:00.000000',NULL),('7faa8507-eded-11e8-b1fb-d4bed9943d61','PERMISSION:UPDATE','bac8b175-ede7-11e8-b1fb-d4bed9943d61',1,'2018-07-02 10:00:00.000000',NULL),('7fb4ca15-eded-11e8-b1fb-d4bed9943d61','PERMISSION:READ','bac8b175-ede7-11e8-b1fb-d4bed9943d61',1,'2018-07-02 10:00:00.000000',NULL),('7fb4cc58-eded-11e8-b1fb-d4bed9943d61','PERMISSION:DELETE','bac8b175-ede7-11e8-b1fb-d4bed9943d61',1,'2018-07-02 10:00:00.000000',NULL),('7fb4ce2e-eded-11e8-b1fb-d4bed9943d61','APPLICATION:READ','bac8b1d2-ede7-11e8-b1fb-d4bed9943d61',1,'2018-07-18 10:00:00.000000',NULL),('7fb4cf0f-eded-11e8-b1fb-d4bed9943d61','APPLICATION:UPDATE','bac8b1d2-ede7-11e8-b1fb-d4bed9943d61',1,'2018-07-18 10:00:00.000000',NULL),('7fb4cfbb-eded-11e8-b1fb-d4bed9943d61','APPLICATION:DELETE','bac8b1d2-ede7-11e8-b1fb-d4bed9943d61',1,'2018-07-18 10:00:00.000000',NULL),('7fb4d054-eded-11e8-b1fb-d4bed9943d61','APPLICATION:CREATE','bac8b1d2-ede7-11e8-b1fb-d4bed9943d61',1,'2018-07-18 10:00:00.000000',NULL),('7fb4d0e2-eded-11e8-b1fb-d4bed9943d61','FUNCTIONALSERVICE:READ','bac8b214-ede7-11e8-b1fb-d4bed9943d61',1,'2018-07-18 10:00:00.000000',NULL),('7fb4d16d-eded-11e8-b1fb-d4bed9943d61','FUNCTIONALSERVICE:UPDATE','bac8b214-ede7-11e8-b1fb-d4bed9943d61',1,'2018-07-18 10:00:00.000000',NULL),('7fb4d1ff-eded-11e8-b1fb-d4bed9943d61','FUNCTIONALSERVICE:DELETE','bac8b214-ede7-11e8-b1fb-d4bed9943d61',1,'2018-07-18 10:00:00.000000',NULL),('7fb4d28d-eded-11e8-b1fb-d4bed9943d61','FUNCTIONALSERVICE:CREATE','bac8b214-ede7-11e8-b1fb-d4bed9943d61',1,'2018-07-18 10:00:00.000000',NULL),('7fb4d318-eded-11e8-b1fb-d4bed9943d61','MENU:READ','bac8b253-ede7-11e8-b1fb-d4bed9943d61',1,'2018-07-18 10:00:00.000000',NULL),('7fb4d3a3-eded-11e8-b1fb-d4bed9943d61','MENU:UPDATE','bac8b253-ede7-11e8-b1fb-d4bed9943d61',1,'2018-07-18 10:00:00.000000',NULL),('7fb4d435-eded-11e8-b1fb-d4bed9943d61','MENU:DELETE','bac8b253-ede7-11e8-b1fb-d4bed9943d61',1,'2018-07-18 10:00:00.000000',NULL),('7fb4d4c0-eded-11e8-b1fb-d4bed9943d61','MENU:CREATE','bac8b253-ede7-11e8-b1fb-d4bed9943d61',1,'2018-07-18 10:00:00.000000',NULL),('7fb4d544-eded-11e8-b1fb-d4bed9943d61','MODULE:READ','bac8b295-ede7-11e8-b1fb-d4bed9943d61',1,'2018-07-18 10:00:00.000000',NULL),('7fb4d5cf-eded-11e8-b1fb-d4bed9943d61','MODULE:UPDATE','bac8b295-ede7-11e8-b1fb-d4bed9943d61',1,'2018-07-18 10:00:00.000000',NULL),('7fb4d65b-eded-11e8-b1fb-d4bed9943d61','MODULE:DELETE','bac8b295-ede7-11e8-b1fb-d4bed9943d61',1,'2018-07-18 10:00:00.000000',NULL),('7fb4d746-eded-11e8-b1fb-d4bed9943d61','MODULE:CREATE','bac8b295-ede7-11e8-b1fb-d4bed9943d61',1,'2018-07-18 10:00:00.000000',NULL),('7fb4d7ca-eded-11e8-b1fb-d4bed9943d61','CUENTADEAHORRO:READ','bac8b306-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-13 10:00:00.000000',NULL),('7fb4d855-eded-11e8-b1fb-d4bed9943d61','CUENTADEAHORRO:UPDATE','bac8b306-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-13 10:00:00.000000',NULL),('7fb4d943-eded-11e8-b1fb-d4bed9943d61','CUENTADEAHORRO:DELETE','bac8b306-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-13 10:00:00.000000',NULL),('7fb4d9c8-eded-11e8-b1fb-d4bed9943d61','CUENTADEAHORRO:CREATE','bac8b306-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-13 10:00:00.000000',NULL),('7fb4da50-eded-11e8-b1fb-d4bed9943d61','APORTACION:READ','bac8b358-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-13 10:00:00.000000',NULL),('7fb4dadb-eded-11e8-b1fb-d4bed9943d61','APORTACION:UPDATE','bac8b358-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-13 10:00:00.000000',NULL),('7fb4db5f-eded-11e8-b1fb-d4bed9943d61','APORTACION:DELETE','bac8b358-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-13 10:00:00.000000',NULL),('7fb4dbe7-eded-11e8-b1fb-d4bed9943d61','APORTACION:CREATE','bac8b358-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-13 10:00:00.000000',NULL),('7fb4dc6f-eded-11e8-b1fb-d4bed9943d61','DEPARTAMENTO:READ','bac8b391-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-14 10:00:00.000000',NULL),('7fb4dcfa-eded-11e8-b1fb-d4bed9943d61','DEPARTAMENTO:UPDATE','bac8b391-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-14 10:00:00.000000',NULL),('7fb4dd85-eded-11e8-b1fb-d4bed9943d61','DEPARTAMENTO:DELETE','bac8b391-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-14 10:00:00.000000',NULL),('7fb4de0c-eded-11e8-b1fb-d4bed9943d61','DEPARTAMENTO:CREATE','bac8b391-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-14 10:00:00.000000',NULL),('7fb4de94-eded-11e8-b1fb-d4bed9943d61','EMPRESA:READ','bac8b3cc-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-14 10:00:00.000000',NULL),('7fb4df1c-eded-11e8-b1fb-d4bed9943d61','EMPRESA:UPDATE','bac8b3cc-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-14 10:00:00.000000',NULL),('7fb4dfaa-eded-11e8-b1fb-d4bed9943d61','EMPRESA:DELETE','bac8b3cc-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-14 10:00:00.000000',NULL),('7fb4e039-eded-11e8-b1fb-d4bed9943d61','EMPRESA:CREATE','bac8b3cc-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-14 10:00:00.000000',NULL),('7fb4e0c0-eded-11e8-b1fb-d4bed9943d61','PLANTA:READ','bac8b408-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-14 10:00:00.000000',NULL),('7fb4e148-eded-11e8-b1fb-d4bed9943d61','PLANTA:UPDATE','bac8b408-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-14 10:00:00.000000',NULL),('7fb4e1d3-eded-11e8-b1fb-d4bed9943d61','PLANTA:DELETE','bac8b408-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-14 10:00:00.000000',NULL),('7fb4e25e-eded-11e8-b1fb-d4bed9943d61','PLANTA:CREATE','bac8b408-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-14 10:00:00.000000',NULL),('7fb4e2e3-eded-11e8-b1fb-d4bed9943d61','TASADEINTERES:READ','bac8b443-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-14 10:00:00.000000',NULL),('7fb4e36a-eded-11e8-b1fb-d4bed9943d61','TASADEINTERES:UPDATE','bac8b443-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-14 10:00:00.000000',NULL),('7fb4e3f5-eded-11e8-b1fb-d4bed9943d61','TASADEINTERES:DELETE','bac8b443-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-14 10:00:00.000000',NULL),('7fb4e47d-eded-11e8-b1fb-d4bed9943d61','TASADEINTERES:CREATE','bac8b443-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-14 10:00:00.000000',NULL),('7fb4e505-eded-11e8-b1fb-d4bed9943d61','SOCIO:READ','bac8b47f-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-15 10:00:00.000000',NULL),('7fb4e5e6-eded-11e8-b1fb-d4bed9943d61','SOCIO:UPDATE','bac8b47f-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-15 10:00:00.000000',NULL),('7fb4e66e-eded-11e8-b1fb-d4bed9943d61','SOCIO:DELETE','bac8b47f-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-15 10:00:00.000000',NULL),('7fb4e9c7-eded-11e8-b1fb-d4bed9943d61','SOCIO:CREATE','bac8b47f-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-15 10:00:00.000000',NULL),('7fb4ea7d-eded-11e8-b1fb-d4bed9943d61','PERFIL:READ','bac8b4bb-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-15 10:00:00.000000',NULL),('7fb4eb05-eded-11e8-b1fb-d4bed9943d61','PERFIL:UPDATE','bac8b4bb-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-15 10:00:00.000000',NULL),('7fb4eb90-eded-11e8-b1fb-d4bed9943d61','PERFIL:DELETE','bac8b4bb-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-15 10:00:00.000000',NULL),('7fb4ec15-eded-11e8-b1fb-d4bed9943d61','PERFIL:CREATE','bac8b4bb-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-15 10:00:00.000000',NULL),('7fb4ec99-eded-11e8-b1fb-d4bed9943d61','INTERES:READ','bac8b4f6-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-15 10:00:00.000000',NULL),('7fb4ed1a-eded-11e8-b1fb-d4bed9943d61','INTERES:UPDATE','bac8b4f6-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-15 10:00:00.000000',NULL),('7fb4eda2-eded-11e8-b1fb-d4bed9943d61','INTERES:DELETE','bac8b4f6-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-15 10:00:00.000000',NULL),('7fb4ee26-eded-11e8-b1fb-d4bed9943d61','INTERES:CREATE','bac8b4f6-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-15 10:00:00.000000',NULL),('7fb4eeae-eded-11e8-b1fb-d4bed9943d61','DOMICILIO:READ','bac8b532-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-15 10:00:00.000000',NULL),('7fb4ef32-eded-11e8-b1fb-d4bed9943d61','DOMICILIO:UPDATE','bac8b532-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-15 10:00:00.000000',NULL),('7fb4efba-eded-11e8-b1fb-d4bed9943d61','DOMICILIO:DELETE','bac8b532-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-15 10:00:00.000000',NULL),('7fb4f09f-eded-11e8-b1fb-d4bed9943d61','DOMICILIO:CREATE','bac8b532-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-15 10:00:00.000000',NULL),('7fb4f126-eded-11e8-b1fb-d4bed9943d61','BENEFICIARIO:READ','bac8b571-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-15 10:00:00.000000',NULL),('7fb4f1ab-eded-11e8-b1fb-d4bed9943d61','BENEFICIARIO:UPDATE','bac8b571-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-15 10:00:00.000000',NULL),('7fb4f236-eded-11e8-b1fb-d4bed9943d61','BENEFICIARIO:DELETE','bac8b571-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-15 10:00:00.000000',NULL),('7fb4f37e-eded-11e8-b1fb-d4bed9943d61','BENEFICIARIO:CREATE','bac8b571-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-15 10:00:00.000000',NULL),('7fb4f437-eded-11e8-b1fb-d4bed9943d61','CUENTABANCARIA:READ','bac8b5a9-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-16 10:00:00.000000',NULL),('7fb4f522-eded-11e8-b1fb-d4bed9943d61','CUENTABANCARIA:UPDATE','bac8b5a9-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-16 10:00:00.000000',NULL),('7fb4f5ad-eded-11e8-b1fb-d4bed9943d61','CUENTABANCARIA:DELETE','bac8b5a9-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-16 10:00:00.000000',NULL),('7fb4f632-eded-11e8-b1fb-d4bed9943d61','CUENTABANCARIA:CREATE','bac8b5a9-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-16 10:00:00.000000',NULL),('7fb4f6b3-eded-11e8-b1fb-d4bed9943d61','ORDENSIMPLIFICADA:READ','bac8b620-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-31 10:00:00.000000',NULL),('7fb4f797-eded-11e8-b1fb-d4bed9943d61','ORDENSIMPLIFICADA:UPDATE','bac8b620-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-31 10:00:00.000000',NULL),('7fb4f822-eded-11e8-b1fb-d4bed9943d61','ORDENSIMPLIFICADA:DELETE','bac8b620-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-31 10:00:00.000000',NULL),('7fb4f8aa-eded-11e8-b1fb-d4bed9943d61','ORDENSIMPLIFICADA:CREATE','bac8b620-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-31 10:00:00.000000',NULL),('7fb4f932-eded-11e8-b1fb-d4bed9943d61','OPERADORPRODUCCION:READ','bac8b662-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-31 10:00:00.000000',NULL),('7fb4f9b9-eded-11e8-b1fb-d4bed9943d61','OPERADORPRODUCCION:UPDATE','bac8b662-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-31 10:00:00.000000',NULL),('7fb4fa44-eded-11e8-b1fb-d4bed9943d61','OPERADORPRODUCCION:DELETE','bac8b662-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-31 10:00:00.000000',NULL),('7fb4facf-eded-11e8-b1fb-d4bed9943d61','OPERADORPRODUCCION:CREATE','bac8b662-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-31 10:00:00.000000',NULL),('7fb4fb57-eded-11e8-b1fb-d4bed9943d61','ETIQUETAASIGNADA:READ','bac8b69b-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-31 10:00:00.000000',NULL),('7fb4fc9c-eded-11e8-b1fb-d4bed9943d61','ETIQUETAASIGNADA:UPDATE','bac8b69b-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-31 10:00:00.000000',NULL),('7fb4fd2a-eded-11e8-b1fb-d4bed9943d61','ETIQUETAASIGNADA:DELETE','bac8b69b-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-31 10:00:00.000000',NULL),('7fb4fdb2-eded-11e8-b1fb-d4bed9943d61','ETIQUETAASIGNADA:CREATE','bac8b69b-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-31 10:00:00.000000',NULL),('7fb4feb4-eded-11e8-b1fb-d4bed9943d61','CLIENTE:READ','bac8b6d6-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-31 10:00:00.000000',NULL),('7fb4ff38-eded-11e8-b1fb-d4bed9943d61','CLIENTE:UPDATE','bac8b6d6-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-31 10:00:00.000000',NULL),('7fb4ffb9-eded-11e8-b1fb-d4bed9943d61','CLIENTE:DELETE','bac8b6d6-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-31 10:00:00.000000',NULL),('7fb5003b-eded-11e8-b1fb-d4bed9943d61','CLIENTE:CREATE','bac8b6d6-ede7-11e8-b1fb-d4bed9943d61',1,'2018-08-31 10:00:00.000000',NULL),('7fb500bf-eded-11e8-b1fb-d4bed9943d61','AFILIADO:READ','bac8b70e-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-01 10:00:00.000000',NULL),('7fb501a7-eded-11e8-b1fb-d4bed9943d61','AFILIADO:UPDATE','bac8b70e-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-01 10:00:00.000000',NULL),('7fb50235-eded-11e8-b1fb-d4bed9943d61','AFILIADO:DELETE','bac8b70e-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-01 10:00:00.000000',NULL),('7fb502bd-eded-11e8-b1fb-d4bed9943d61','AFILIADO:CREATE','bac8b70e-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-01 10:00:00.000000',NULL),('7fb50345-eded-11e8-b1fb-d4bed9943d61','TIPOPENSION:READ','bac8b7c5-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-01 10:00:00.000000',NULL),('7fb503c9-eded-11e8-b1fb-d4bed9943d61','TIPOPENSION:UPDATE','bac8b7c5-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-01 10:00:00.000000',NULL),('7fb50457-eded-11e8-b1fb-d4bed9943d61','TIPOPENSION:DELETE','bac8b7c5-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-01 10:00:00.000000',NULL),('7fb504df-eded-11e8-b1fb-d4bed9943d61','TIPOPENSION:CREATE','bac8b7c5-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-01 10:00:00.000000',NULL),('7fb50567-eded-11e8-b1fb-d4bed9943d61','SOLICITUDPENSION:READ','bac8b7fd-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-01 10:00:00.000000',NULL),('7fb5064b-eded-11e8-b1fb-d4bed9943d61','SOLICITUDPENSION:DELETE','bac8b7fd-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-01 10:00:00.000000',NULL),('7fb5073a-eded-11e8-b1fb-d4bed9943d61','SOLICITUDPENSION:CREATE','bac8b7fd-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-01 10:00:00.000000',NULL),('7fb5081e-eded-11e8-b1fb-d4bed9943d61','SOLICITUDPENSION:UPDATE','bac8b7fd-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-01 10:00:00.000000',NULL),('7fb508a3-eded-11e8-b1fb-d4bed9943d61','USUARIO:READ','bac8b835-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb50941-eded-11e8-b1fb-d4bed9943d61','USUARIO:UPDATE','bac8b835-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb509d0-eded-11e8-b1fb-d4bed9943d61','USUARIO:DELETE','bac8b835-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb50a58-eded-11e8-b1fb-d4bed9943d61','USUARIO:CREATE','bac8b835-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb50ad9-eded-11e8-b1fb-d4bed9943d61','TRAYECTORIA:READ','bac8b86d-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb50bbd-eded-11e8-b1fb-d4bed9943d61','TRAYECTORIA:UPDATE','bac8b86d-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb50c48-eded-11e8-b1fb-d4bed9943d61','TRAYECTORIA:DELETE','bac8b86d-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb50cd3-eded-11e8-b1fb-d4bed9943d61','TRAYECTORIA:CREATE','bac8b86d-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb50d5b-eded-11e8-b1fb-d4bed9943d61','SOLICITUD:READ','bac8b8a6-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb50de6-eded-11e8-b1fb-d4bed9943d61','SOLICITUD:UPDATE','bac8b8a6-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb50e71-eded-11e8-b1fb-d4bed9943d61','SOLICITUD:DELETE','bac8b8a6-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb50f5f-eded-11e8-b1fb-d4bed9943d61','SOLICITUD:CREATE','bac8b8a6-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb51041-eded-11e8-b1fb-d4bed9943d61','ROL:READ','bac8b8de-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb510c2-eded-11e8-b1fb-d4bed9943d61','ROL:UPDATE','bac8b8de-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb51655-eded-11e8-b1fb-d4bed9943d61','ROL:DELETE','bac8b8de-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb5175a-eded-11e8-b1fb-d4bed9943d61','ROL:CREATE','bac8b8de-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb5189b-eded-11e8-b1fb-d4bed9943d61','RECLUTADOR:READ','bac8b916-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb51955-eded-11e8-b1fb-d4bed9943d61','RECLUTADOR:UPDATE','bac8b916-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb519e3-eded-11e8-b1fb-d4bed9943d61','RECLUTADOR:DELETE','bac8b916-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb51a6e-eded-11e8-b1fb-d4bed9943d61','RECLUTADOR:CREATE','bac8b916-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb51af6-eded-11e8-b1fb-d4bed9943d61','PUESTO:READ','bac8b98a-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb51b77-eded-11e8-b1fb-d4bed9943d61','PUESTO:UPDATE','bac8b98a-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb51c02-eded-11e8-b1fb-d4bed9943d61','PUESTO:DELETE','bac8b98a-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb51c86-eded-11e8-b1fb-d4bed9943d61','PUESTO:CREATE','bac8b98a-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb51d0e-eded-11e8-b1fb-d4bed9943d61','POSICION:READ','bac8b9c6-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb51d93-eded-11e8-b1fb-d4bed9943d61','POSICION:UPDATE','bac8b9c6-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb51e1a-eded-11e8-b1fb-d4bed9943d61','POSICION:DELETE','bac8b9c6-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb5239d-eded-11e8-b1fb-d4bed9943d61','POSICION:CREATE','bac8b9c6-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb5244f-eded-11e8-b1fb-d4bed9943d61','PERMISO:READ','bac8ba01-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb524e4-eded-11e8-b1fb-d4bed9943d61','PERMISO:UPDATE','bac8ba01-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb52579-eded-11e8-b1fb-d4bed9943d61','PERMISO:DELETE','bac8ba01-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb5260b-eded-11e8-b1fb-d4bed9943d61','PERMISO:CREATE','bac8ba01-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb526ce-eded-11e8-b1fb-d4bed9943d61','FILIAL:READ','bac8ba36-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb52760-eded-11e8-b1fb-d4bed9943d61','FILIAL:UPDATE','bac8ba36-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb527f2-eded-11e8-b1fb-d4bed9943d61','FILIAL:DELETE','bac8ba36-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb5287a-eded-11e8-b1fb-d4bed9943d61','FILIAL:CREATE','bac8ba36-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb52901-eded-11e8-b1fb-d4bed9943d61','EVENTO:READ','bac8ba6f-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb52982-eded-11e8-b1fb-d4bed9943d61','EVENTO:UPDATE','bac8ba6f-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb52a07-eded-11e8-b1fb-d4bed9943d61','EVENTO:DELETE','bac8ba6f-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb52a8b-eded-11e8-b1fb-d4bed9943d61','EVENTO:CREATE','bac8ba6f-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb52b2a-eded-11e8-b1fb-d4bed9943d61','DOCUMENTO:READ','bac8baa7-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb52bb2-eded-11e8-b1fb-d4bed9943d61','DOCUMENTO:UPDATE','bac8baa7-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb52c3a-eded-11e8-b1fb-d4bed9943d61','DOCUMENTO:DELETE','bac8baa7-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb52cbb-eded-11e8-b1fb-d4bed9943d61','DOCUMENTO:CREATE','bac8baa7-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb52d3c-eded-11e8-b1fb-d4bed9943d61','DIRECCION:READ','bac8bae2-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb52dc0-eded-11e8-b1fb-d4bed9943d61','DIRECCION:UPDATE','bac8bae2-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb52e48-eded-11e8-b1fb-d4bed9943d61','DIRECCION:DELETE','bac8bae2-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb52ec9-eded-11e8-b1fb-d4bed9943d61','DIRECCION:CREATE','bac8bae2-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb52fdf-eded-11e8-b1fb-d4bed9943d61','CANDIDATO:READ','bac8bb1b-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb53074-eded-11e8-b1fb-d4bed9943d61','CANDIDATO:UPDATE','bac8bb1b-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb53103-eded-11e8-b1fb-d4bed9943d61','CANDIDATO:DELETE','bac8bb1b-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL),('7fb53180-eded-11e8-b1fb-d4bed9943d61','CANDIDATO:CREATE','bac8bb1b-ede7-11e8-b1fb-d4bed9943d61',1,'2018-10-10 10:00:00.000000',NULL);
/*!40000 ALTER TABLE `privilege` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reclutador`
--

DROP TABLE IF EXISTS `reclutador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reclutador` (
  `nombre` varchar(100) DEFAULT NULL,
  `apellidopaterno` varchar(100) DEFAULT NULL,
  `apellidomaterno` varchar(100) DEFAULT NULL,
  `genero` varchar(50) DEFAULT NULL,
  `reclutadorId` varbinary(50) NOT NULL,
  PRIMARY KEY (`reclutadorId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reclutador`
--

LOCK TABLES `reclutador` WRITE;
/*!40000 ALTER TABLE `reclutador` DISABLE KEYS */;
INSERT INTO `reclutador` VALUES ('Nombre 3','Apellido 3','Apellido 3','FEM','ac1046dc-6751-1733-8167-51f76aba0003'),('Ernesto','Arenas','Ju√°rez','FEM','ac1046dc-6751-1733-8167-51f935fc0005'),('Reclutador 3 - 1','Apellido paterno reclutador 3','Apellido materno reclutador 3','MAS','ac1046dc-6752-1098-8167-528bc59e000f');
/*!40000 ALTER TABLE `reclutador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rol` (
  `clave` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `activo` int(11) NOT NULL,
  `rolId` varbinary(50) NOT NULL,
  PRIMARY KEY (`rolId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (661696,'Subin',180199,'ac1046dc-6755-1782-8167-5618f7160007');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitud`
--

DROP TABLE IF EXISTS `solicitud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `solicitud` (
  `posicionId` varbinary(50) DEFAULT NULL,
  `candidatoId` varbinary(50) DEFAULT NULL,
  `fecha` timestamp(6) NULL DEFAULT NULL,
  `salario` decimal(10,2) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `telefono` varchar(100) DEFAULT NULL,
  `direccionId` varbinary(50) DEFAULT NULL,
  `trayectoria` varchar(50) DEFAULT NULL,
  `estatussolicitud` varchar(50) DEFAULT NULL,
  `solicitudId` varbinary(50) NOT NULL,
  PRIMARY KEY (`solicitudId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitud`
--

LOCK TABLES `solicitud` WRITE;
/*!40000 ALTER TABLE `solicitud` DISABLE KEYS */;
INSERT INTO `solicitud` VALUES ('¨F\‹gRòÅgR\Ôı\0','í4\ÈA\Ëü2ÚÄü\—','2018-11-20 06:00:00.000000',10.00,'correo.test@gmail.com','5512345678','¨F\‹gQ»ÅgQ\œ/\0','A','E1','ac1046dc-6752-1098-8167-5291b5eb0011'),('¨F\‹gRòÅgR¸Q\0','¨F\‹gQ3ÅgQ\Ï¨N\0','2018-11-26 06:00:00.000000',4.00,'correo.test@correo.com','5512345678','¨F\‹gQ»ÅgQ\œ/\0','A','E1','ac1046dc-6752-1098-8167-5293d6920012'),('¨F\‹gRòÅgR¸Q\0','í4\ÈA\Ëü2ÚÄü\—','2018-11-27 15:49:50.000000',3.00,'edgar.torres@yahoo.com','6334423770','¨F\‹gQ»ÅgQ\œ/\0','B','E1','ac1046dc-6755-1782-8167-55ddf2a90000'),('¨F\‹gRòÅgR¸Q\0','í4\ÈA\Ëü2ÚÄü\—','2018-11-27 15:49:50.000000',3.00,'edgar.torres@yahoo.com','6334423770','¨F\‹gQ»ÅgQ\œ/\0','B','E1','ac1046dc-6755-1782-8167-55e1865e0001');
/*!40000 ALTER TABLE `solicitud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trayectoria`
--

DROP TABLE IF EXISTS `trayectoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trayectoria` (
  `trayectoria` varchar(50) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `clave` varchar(100) DEFAULT NULL,
  `documentoId` varbinary(50) DEFAULT NULL,
  `trayectoriaId` varbinary(50) NOT NULL,
  PRIMARY KEY (`trayectoriaId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trayectoria`
--

LOCK TABLES `trayectoria` WRITE;
/*!40000 ALTER TABLE `trayectoria` DISABLE KEYS */;
INSERT INTO `trayectoria` VALUES ('A','Trayectoria 1','Trayectoria','¨F\‹gQ,ÅgQd¯P\0','ac1046dc-6751-1fc8-8167-5172eeb70003');
/*!40000 ALTER TABLE `trayectoria` ENABLE KEYS */;
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
  `lastpasswordresetdate` timestamp(6) NULL DEFAULT NULL,
  `creationdate` timestamp(6) NOT NULL DEFAULT '0000-00-00 00:00:00.000000',
  `modifieddate` timestamp(6) NULL DEFAULT NULL,
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
INSERT INTO `user` VALUES ('a47d104e-ede6-11e8-b1fb-d4bed9943d61','admin','$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi','Normaysel','Carbajal','normaysel.carbajal@softtek.com',1,NULL,'2018-10-27 16:09:53.000000','2018-06-25 10:00:00.000000',NULL),('a47f53f3-ede6-11e8-b1fb-d4bed9943d61','user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','Javier','Aguilar','javieraguilar@softtek.com',1,NULL,'2018-09-29 10:00:00.000000','2018-07-18 10:00:00.000000','2018-07-18 10:00:00.000000'),('a47f5555-ede6-11e8-b1fb-d4bed9943d61','test','$2a$10$SdTyWGY5rKgWQWEI.FgX/ujMVVwt1T45fI3t1a4/VT/vd89A8zi4a','Juan','Perez','juanperez@softtek.com',1,NULL,'2018-07-07 10:00:00.000000','2018-07-03 10:00:00.000000',NULL),('a47f55f1-ede6-11e8-b1fb-d4bed9943d61','jaas79','$2a$10$4NYOvd/pyX86Z03r3nCn/ezNbVtOwStCfkzgGQ84KHSPSQ3ku4MQ.','Javier','Aguilar','javier.aguilar@softtek.com',1,NULL,'2018-10-23 17:01:45.000000','2018-07-09 10:00:00.000000','2018-07-09 10:00:00.000000'),('a47f5683-ede6-11e8-b1fb-d4bed9943d61','user-rol-disabled','$2a$10$daY8gikhmfnkGwXqBUJfxugHjd49xv4w3xqwBNXXDNQPOuf92aZ/i','User','Rol Disabled','user.disabled@email.com',1,NULL,'2018-06-13 10:00:00.000000','2018-07-13 10:00:00.000000',NULL),('a47f5711-ede6-11e8-b1fb-d4bed9943d61','Normaysel','$2a$10$mWWqKl/gcVRuxnHnKfkky.vfkmvrxBWopW0HLyUD8HjF1fbHjRQtS','Normaysel','Carbajal','alexydiego@gmail.com',1,NULL,'2018-06-24 10:00:00.000000','2018-07-24 10:00:00.000000',NULL),('a47f5799-ede6-11e8-b1fb-d4bed9943d61','Reclutador','$2a$10$Rcn0okKKuID/Y03Jbr/9Wuuxx4g1YZPYso6TIranbg/O9cpvDYATa','Usuario para pruebas','reclutador','reclutador@softtek.com',1,NULL,'2018-09-24 10:00:00.000000','2018-10-22 10:00:00.000000','2018-10-22 10:00:00.000000'),('a47f583e-ede6-11e8-b1fb-d4bed9943d61','Candidato','$2a$10$WFSEoQOM47QC2Z8PvzlQNeH9qi8Ov1gWnUvYeq51/FX33mKjUIeCG','Usuario para pruebas 2','candidato','candidato@softtek.com',1,NULL,'2018-09-24 10:00:00.000000','2018-10-22 10:00:00.000000',NULL),('a47f58d3-ede6-11e8-b1fb-d4bed9943d61','Administrador','$2a$10$HH2OkZcc64D43h5Q139E1enDQnVoWeLDW/hg1jJ0RegTZWfojt0Uq','Administrador','del sistema','administrador@softtek.com',1,NULL,'2018-09-24 10:00:00.000000','2018-10-23 10:00:00.000000','2018-10-23 10:00:00.000000'),('a47f59a7-ede6-11e8-b1fb-d4bed9943d61','test_01','$2a$10$SdTyWGY5rKgWQWEI.FgX/ujMVVwt1T45fI3t1a4/VT/vd89A8zi4a','test','pruebas','test@correo.com',1,NULL,'2018-11-12 12:00:00.000000','2018-11-12 12:00:00.000000','2018-11-12 12:00:00.000000'),('a47f5a32-ede6-11e8-b1fb-d4bed9943d61','test_02','$2a$10$lkLnWqrSTy7i.MMkGi8Q4.f1H/EWER5uKN6H2ktBjOw7TjIbdPcQu','test02','test02','test02@correo.com',1,NULL,'2018-11-12 12:00:00.000000','2018-11-12 12:00:00.000000','2018-11-12 12:00:00.000000'),('ac1046dc-6750-1398-8167-50d4d2540001','test 03','$2a$10$qKscOUEn8N1DnOHqDMEUoOHEoK.Hac3tRe8pnB8rnylBSB5pGH2OC','test03','test03','test03.test03@mail.com',1,NULL,NULL,'2018-11-26 16:23:01.000000',NULL),('ac1046dc-6750-1398-8167-50dbfe4b0004','test 04','$2a$10$cnViwOLlj8NgKdLMbjyA8eOFusJ8mBKYBezWqtT6wOKgCPS8w7ipW','test04','test04','test04.test04@mail.com',1,NULL,NULL,'2018-11-26 16:30:53.000000',NULL);
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
INSERT INTO `user_authority` VALUES ('ac1046dc-6750-1398-8167-50d4d2540001','788646cb-edea-11e8-b1fb-d4bed9943d61','ac1046dc-6750-1398-8167-50d501980002',1),('ac1046dc-6750-1398-8167-50dbfe4b0004','788646cb-edea-11e8-b1fb-d4bed9943d61','ac1046dc-6750-1398-8167-50dc025d0005',1),('a47d104e-ede6-11e8-b1fb-d4bed9943d61','788406be-edea-11e8-b1fb-d4bed9943d61','f9786436-edef-11e8-b1fb-d4bed9943d61',1),('a47f5683-ede6-11e8-b1fb-d4bed9943d61','78864a00-edea-11e8-b1fb-d4bed9943d61','f97afced-edef-11e8-b1fb-d4bed9943d61',1),('a47f53f3-ede6-11e8-b1fb-d4bed9943d61','788646cb-edea-11e8-b1fb-d4bed9943d61','f97afde8-edef-11e8-b1fb-d4bed9943d61',1),('a47f5711-ede6-11e8-b1fb-d4bed9943d61','788646cb-edea-11e8-b1fb-d4bed9943d61','f97afe95-edef-11e8-b1fb-d4bed9943d61',1),('a47f583e-ede6-11e8-b1fb-d4bed9943d61','788646cb-edea-11e8-b1fb-d4bed9943d61','f97aff58-edef-11e8-b1fb-d4bed9943d61',1),('a47f5799-ede6-11e8-b1fb-d4bed9943d61','7886488e-edea-11e8-b1fb-d4bed9943d61','f97b0001-edef-11e8-b1fb-d4bed9943d61',1),('a47f58d3-ede6-11e8-b1fb-d4bed9943d61','78864827-edea-11e8-b1fb-d4bed9943d61','f98801cd-edef-11e8-b1fb-d4bed9943d61',1),('a47f55f1-ede6-11e8-b1fb-d4bed9943d61','788646cb-edea-11e8-b1fb-d4bed9943d61','f9880350-edef-11e8-b1fb-d4bed9943d61',1);
/*!40000 ALTER TABLE `user_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `nombreclave` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `activo` int(11) NOT NULL,
  `rolId` varbinary(50) DEFAULT NULL,
  `usuarioId` varbinary(50) NOT NULL,
  PRIMARY KEY (`usuarioId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('Solarbreeze-2','87xly2vz3o',482794,'¨F\‹gUÇÅgV˜\0','ac1046dc-6755-1782-8167-561d6999000a');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'demoacceleo'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-04 11:51:49
