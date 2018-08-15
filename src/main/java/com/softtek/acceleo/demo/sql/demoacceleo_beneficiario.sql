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
-- Table structure for table `beneficiario`
--
DROP TABLE IF EXISTS `beneficiario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `beneficiario` ( 
`nombre` VARCHAR(100) DEFAULT NULL,
`apellidopaterno` VARCHAR(100) DEFAULT NULL,
`apellidomaterno` VARCHAR(100) DEFAULT NULL,
`fechanacimiento` DATE DEFAULT NULL,
`cuentadeahorroId` int(11) DEFAULT NULL,
`generoId` varchar(100) DEFAULT NULL,
`parentescoId` varchar(100) DEFAULT NULL,
`beneficiarioId` INT NOT NULL AUTO_INCREMENT, 
PRIMARY KEY(`beneficiarioId`),
KEY `cuentadeahorroId_idx` (`cuentadeahorroId`),
CONSTRAINT `cuentadeahorroId` FOREIGN KEY (`cuentadeahorroId`) 
REFERENCES `cuentadeahorro` (`cuentadeahorroId`) ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;


/* Table Insert */
INSERT INTO `grupo` (NAME) VALUES ('BENEFICIARIO');
COMMIT;
INSERT INTO `privilege` (NAME, ID_GRUPO, ENABLED, CREATIONDATE) VALUES ('BENEFICIARIOSEARCH',(SELECT ID_GRUPO FROM `grupo` WHERE NAME = 'BENEFICIARIO'),1,now());
INSERT INTO `privilege` (NAME, ID_GRUPO, ENABLED, CREATIONDATE) VALUES ('BENEFICIARIOUPDATE',(SELECT ID_GRUPO FROM `grupo` WHERE NAME = 'BENEFICIARIO'),1,now());
INSERT INTO `privilege` (NAME, ID_GRUPO, ENABLED, CREATIONDATE) VALUES ('BENEFICIARIODELETE',(SELECT ID_GRUPO FROM `grupo` WHERE NAME = 'BENEFICIARIO'),1,now());
INSERT INTO `privilege` (NAME, ID_GRUPO, ENABLED, CREATIONDATE) VALUES ('BENEFICIARIOCREATE',(SELECT ID_GRUPO FROM `grupo` WHERE NAME = 'BENEFICIARIO'),1,now());
COMMIT;

