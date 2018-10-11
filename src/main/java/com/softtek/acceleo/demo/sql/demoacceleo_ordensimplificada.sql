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
-- Table structure for table `ordensimplificada`
--
DROP TABLE IF EXISTS `ordensimplificada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordensimplificada` ( 
`sap` INT DEFAULT NULL,
`cantidadprogramada` INT DEFAULT NULL,
`ordentrabajo` INT DEFAULT NULL,
`fechafinal` DATE DEFAULT NULL,
`cantidadproducida` INT DEFAULT NULL,
`fechainicial` DATE DEFAULT NULL,
`comentario` String DEFAULT NULL,
`lineaId` varchar(100) DEFAULT NULL,
`destinoId` varchar(100) DEFAULT NULL,
`estadoordenId` varchar(100) DEFAULT NULL,
`estadoordenId` varchar(100) DEFAULT NULL,
`operadorproduccionId` int(11) DEFAULT NULL,
`operadorproduccionId` int(11) DEFAULT NULL,
`clienteId` int(11) DEFAULT NULL,
`ordensimplificadaId` INT NOT NULL AUTO_INCREMENT, 
PRIMARY KEY(`ordensimplificadaId`),
KEY `operadorproduccionId_idx` (`operadorproduccionId`),
CONSTRAINT `operadorproduccionId` FOREIGN KEY (`operadorproduccionId`) 
REFERENCES `operadorproduccion` (`operadorproduccionId`) ON DELETE NO ACTION ON UPDATE NO ACTION
KEY `operadorproduccionId_idx` (`operadorproduccionId`),
CONSTRAINT `operadorproduccionId` FOREIGN KEY (`operadorproduccionId`) 
REFERENCES `operadorproduccion` (`operadorproduccionId`) ON DELETE NO ACTION ON UPDATE NO ACTION
KEY `clienteId_idx` (`clienteId`),
CONSTRAINT `clienteId` FOREIGN KEY (`clienteId`) 
REFERENCES `cliente` (`clienteId`) ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;


/* Table Insert */
INSERT INTO `grupo` (NAME) VALUES ('ORDENSIMPLIFICADA');
COMMIT;
INSERT INTO `privilege` (NAME, ID_GRUPO, ENABLED, CREATIONDATE) VALUES ('ORDENSIMPLIFICADASEARCH',(SELECT ID_GRUPO FROM `grupo` WHERE NAME = 'ORDENSIMPLIFICADA'),1,now());
INSERT INTO `privilege` (NAME, ID_GRUPO, ENABLED, CREATIONDATE) VALUES ('ORDENSIMPLIFICADAUPDATE',(SELECT ID_GRUPO FROM `grupo` WHERE NAME = 'ORDENSIMPLIFICADA'),1,now());
INSERT INTO `privilege` (NAME, ID_GRUPO, ENABLED, CREATIONDATE) VALUES ('ORDENSIMPLIFICADADELETE',(SELECT ID_GRUPO FROM `grupo` WHERE NAME = 'ORDENSIMPLIFICADA'),1,now());
INSERT INTO `privilege` (NAME, ID_GRUPO, ENABLED, CREATIONDATE) VALUES ('ORDENSIMPLIFICADACREATE',(SELECT ID_GRUPO FROM `grupo` WHERE NAME = 'ORDENSIMPLIFICADA'),1,now());
COMMIT;

