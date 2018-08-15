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
-- Table structure for table `socio`
--
DROP TABLE IF EXISTS `socio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `socio` ( 
`apellidopaterno` VARCHAR(100) DEFAULT NULL,
`numero` INT DEFAULT NULL,
`nombre` VARCHAR(100) DEFAULT NULL,
`apellidomaterno` VARCHAR(100) DEFAULT NULL,
`correo` String DEFAULT NULL,
`telefono` String DEFAULT NULL,
`generoId` varchar(100) DEFAULT NULL,
`tipoempleadoId` varchar(100) DEFAULT NULL,
`departamentoId` int(11) DEFAULT NULL,
`plantaId` int(11) DEFAULT NULL,
`socioId` INT NOT NULL AUTO_INCREMENT, 
PRIMARY KEY(`socioId`),
KEY `departamentoId_idx` (`departamentoId`),
CONSTRAINT `departamentoId` FOREIGN KEY (`departamentoId`) 
REFERENCES `departamento` (`departamentoId`) ON DELETE NO ACTION ON UPDATE NO ACTION
KEY `plantaId_idx` (`plantaId`),
CONSTRAINT `plantaId` FOREIGN KEY (`plantaId`) 
REFERENCES `planta` (`plantaId`) ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;


/* Table Insert */
INSERT INTO `grupo` (NAME) VALUES ('SOCIO');
COMMIT;
INSERT INTO `privilege` (NAME, ID_GRUPO, ENABLED, CREATIONDATE) VALUES ('SOCIOSEARCH',(SELECT ID_GRUPO FROM `grupo` WHERE NAME = 'SOCIO'),1,now());
INSERT INTO `privilege` (NAME, ID_GRUPO, ENABLED, CREATIONDATE) VALUES ('SOCIOUPDATE',(SELECT ID_GRUPO FROM `grupo` WHERE NAME = 'SOCIO'),1,now());
INSERT INTO `privilege` (NAME, ID_GRUPO, ENABLED, CREATIONDATE) VALUES ('SOCIODELETE',(SELECT ID_GRUPO FROM `grupo` WHERE NAME = 'SOCIO'),1,now());
INSERT INTO `privilege` (NAME, ID_GRUPO, ENABLED, CREATIONDATE) VALUES ('SOCIOCREATE',(SELECT ID_GRUPO FROM `grupo` WHERE NAME = 'SOCIO'),1,now());
COMMIT;

