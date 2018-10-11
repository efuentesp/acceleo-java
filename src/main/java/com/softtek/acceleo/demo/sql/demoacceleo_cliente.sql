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
-- Table structure for table `cliente`
--
DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` ( 
`nombre` VARCHAR(100) DEFAULT NULL,
`clave` INT DEFAULT NULL,
`clienteId` int(11) DEFAULT NULL,
`etiquetaasignadaId` int(11) DEFAULT NULL,
`ordensimplificadaId` int(11) DEFAULT NULL,
`clienteId` INT NOT NULL AUTO_INCREMENT, 
PRIMARY KEY(`clienteId`),
KEY `clienteId_idx` (`clienteId`),
CONSTRAINT `clienteId` FOREIGN KEY (`clienteId`) 
REFERENCES `cliente` (`clienteId`) ON DELETE NO ACTION ON UPDATE NO ACTION
KEY `etiquetaasignadaId_idx` (`etiquetaasignadaId`),
CONSTRAINT `etiquetaasignadaId` FOREIGN KEY (`etiquetaasignadaId`) 
REFERENCES `etiquetaasignada` (`etiquetaasignadaId`) ON DELETE NO ACTION ON UPDATE NO ACTION
KEY `ordensimplificadaId_idx` (`ordensimplificadaId`),
CONSTRAINT `ordensimplificadaId` FOREIGN KEY (`ordensimplificadaId`) 
REFERENCES `ordensimplificada` (`ordensimplificadaId`) ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;


/* Table Insert */
INSERT INTO `grupo` (NAME) VALUES ('CLIENTE');
COMMIT;
INSERT INTO `privilege` (NAME, ID_GRUPO, ENABLED, CREATIONDATE) VALUES ('CLIENTESEARCH',(SELECT ID_GRUPO FROM `grupo` WHERE NAME = 'CLIENTE'),1,now());
INSERT INTO `privilege` (NAME, ID_GRUPO, ENABLED, CREATIONDATE) VALUES ('CLIENTEUPDATE',(SELECT ID_GRUPO FROM `grupo` WHERE NAME = 'CLIENTE'),1,now());
INSERT INTO `privilege` (NAME, ID_GRUPO, ENABLED, CREATIONDATE) VALUES ('CLIENTEDELETE',(SELECT ID_GRUPO FROM `grupo` WHERE NAME = 'CLIENTE'),1,now());
INSERT INTO `privilege` (NAME, ID_GRUPO, ENABLED, CREATIONDATE) VALUES ('CLIENTECREATE',(SELECT ID_GRUPO FROM `grupo` WHERE NAME = 'CLIENTE'),1,now());
COMMIT;

