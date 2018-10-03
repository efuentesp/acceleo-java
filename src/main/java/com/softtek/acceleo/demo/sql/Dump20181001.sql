-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: demoacceleo
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
-- Table structure for table `afiliado`
--

DROP TABLE IF EXISTS `afiliado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `afiliado` (
  `nss` varchar(100) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `acta_nacimiento` decimal(10,0) DEFAULT NULL,
  `numero` decimal(10,0) DEFAULT NULL,
  `semanas_cotizadas` int(11) DEFAULT NULL,
  `correo` varchar(128) DEFAULT NULL,
  `foto` decimal(10,0) DEFAULT NULL,
  `apellido_materno` varchar(100) DEFAULT NULL,
  `apellido_paterno` varchar(100) DEFAULT NULL,
  `fecha_afiliacion` date DEFAULT NULL,
  `observaciones` varchar(256) DEFAULT NULL,
  `genero1Id` varchar(100) DEFAULT NULL,
  `beneficiario1Id` int(11) DEFAULT NULL,
  `afiliadoId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`afiliadoId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `afiliado`
--

LOCK TABLES `afiliado` WRITE;
/*!40000 ALTER TABLE `afiliado` DISABLE KEYS */;
/*!40000 ALTER TABLE `afiliado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aportacion`
--

DROP TABLE IF EXISTS `aportacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aportacion` (
  `monto` decimal(10,0) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `cuentadeahorroId` int(11) DEFAULT NULL,
  `tipoaportacionId` varchar(100) DEFAULT NULL,
  `aportacionId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`aportacionId`),
  KEY `cuentadeahorroId_idx` (`cuentadeahorroId`),
  CONSTRAINT `cuentadeahorroId` FOREIGN KEY (`cuentadeahorroId`) REFERENCES `cuentadeahorro` (`cuentadeahorroId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aportacion`
--

LOCK TABLES `aportacion` WRITE;
/*!40000 ALTER TABLE `aportacion` DISABLE KEYS */;
INSERT INTO `aportacion` VALUES (12,'2018-10-03',9,'cf',9),(12000,'2018-10-09',9,'cf',10),(20000,'2018-08-04',9,'cf',11),(20000,'2019-12-30',9,'fa',12),(3000,'2018-08-26',9,'cf',13);
/*!40000 ALTER TABLE `aportacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authority`
--

DROP TABLE IF EXISTS `authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authority` (
  `id_authority` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `enabled` tinyint(4) NOT NULL,
  `creationdate` date NOT NULL,
  `modifieddate` date DEFAULT NULL,
  PRIMARY KEY (`id_authority`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authority`
--

LOCK TABLES `authority` WRITE;
/*!40000 ALTER TABLE `authority` DISABLE KEYS */;
INSERT INTO `authority` VALUES (1,'ADMIN',1,'2018-06-25',NULL),(2,'USER',1,'2018-06-25',NULL),(3,'ANONYMOUS',1,'2018-06-25',NULL),(4,'BASICO',1,'2018-06-25',NULL),(5,'TEST2',0,'2018-07-03',NULL),(6,'TEST',0,'2018-07-04',NULL),(7,'USER TEST',1,'2018-07-05',NULL),(8,'BASICO2',0,'2018-07-13','2018-07-13');
/*!40000 ALTER TABLE `authority` ENABLE KEYS */;
UNLOCK TABLES;

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
  CONSTRAINT `fk_id_privilege` FOREIGN KEY (`id_privilege`) REFERENCES `privilege` (`ID_PRIVILEGE`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=390 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authority_privilege`
--

LOCK TABLES `authority_privilege` WRITE;
/*!40000 ALTER TABLE `authority_privilege` DISABLE KEYS */;
INSERT INTO `authority_privilege` VALUES (1,9,17,1),(1,10,18,1),(1,23,37,1),(1,24,38,1),(1,25,39,1),(1,26,40,1),(1,27,41,1),(1,28,42,1),(1,29,43,1),(1,30,44,1),(2,30,48,0),(3,30,49,0),(6,30,50,1),(7,30,51,0),(2,31,62,1),(2,32,63,1),(2,33,64,1),(2,34,65,1),(2,39,292,1),(2,40,293,1),(2,41,294,1),(2,42,295,1),(2,43,296,1),(2,44,297,1),(2,45,298,1),(2,46,299,1),(2,35,300,1),(2,36,301,1),(2,37,302,1),(2,38,303,1),(1,31,304,1),(1,32,305,1),(1,33,306,1),(1,34,307,1),(1,35,308,1),(1,36,309,1),(1,37,310,1),(1,38,311,1),(1,39,312,1),(1,40,313,1),(1,41,314,1),(1,42,315,1),(1,43,316,1),(1,44,317,1),(1,45,318,1),(1,46,319,1),(1,47,320,1),(1,48,321,1),(1,49,322,1),(1,50,323,1),(1,51,324,1),(1,52,325,1),(1,53,326,1),(1,54,327,1),(1,55,328,1),(1,56,329,1),(1,57,330,1),(1,58,331,1),(1,59,332,1),(1,60,333,1),(1,61,334,1),(1,62,335,1),(1,63,336,1),(1,64,337,1),(1,65,338,1),(1,66,339,1),(1,67,340,1),(1,68,341,1),(1,69,342,1),(1,70,343,1),(2,47,344,1),(2,48,345,1),(2,49,346,1),(2,51,347,1),(2,54,348,1),(1,87,349,1),(1,86,350,1),(1,85,351,1),(1,84,352,1),(1,83,353,1),(1,82,354,1),(1,81,355,1),(1,80,356,1),(1,79,357,1),(1,78,358,1),(1,75,359,1),(1,76,360,1),(1,77,361,1),(1,71,362,1),(1,72,363,1),(1,73,364,1),(1,74,365,1),(1,88,366,1),(1,89,367,1),(1,90,368,1),(1,91,369,1),(1,92,370,1),(1,93,371,1),(1,94,372,1),(1,95,373,1),(1,96,374,1),(1,97,375,1),(1,98,376,1),(1,99,377,1),(1,100,378,1),(1,101,379,1),(1,102,380,1),(1,103,381,1),(1,104,382,1),(1,106,383,1),(1,105,384,1),(1,107,385,1),(1,108,386,1),(1,109,387,1),(1,110,388,1),(1,111,389,1);
/*!40000 ALTER TABLE `authority_privilege` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `beneficiario`
--

DROP TABLE IF EXISTS `beneficiario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `beneficiario` (
  `apellido_paterno` varchar(100) DEFAULT NULL,
  `apellido_materno` varchar(100) DEFAULT NULL,
  `curp` varchar(100) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `parentescoId` varchar(100) DEFAULT NULL,
  `afiliado1Id` int(11) DEFAULT NULL,
  `beneficiarioId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`beneficiarioId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `beneficiario`
--

LOCK TABLES `beneficiario` WRITE;
/*!40000 ALTER TABLE `beneficiario` DISABLE KEYS */;
/*!40000 ALTER TABLE `beneficiario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `nombre` varchar(100) NOT NULL,
  `clave` int(11) NOT NULL,
  `clienteId` int(11) NOT NULL AUTO_INCREMENT,
  `cliente1Id` int(11) DEFAULT NULL,
  PRIMARY KEY (`clienteId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES ('test_cliente',96,2,NULL),('Prueba',2,3,2),('234234',234234,4,2);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuentabancaria`
--

DROP TABLE IF EXISTS `cuentabancaria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cuentabancaria` (
  `clabe` int(11) DEFAULT NULL,
  `cuenta` int(11) DEFAULT NULL,
  `socioId` int(11) DEFAULT NULL,
  `bancoId` varchar(100) DEFAULT NULL,
  `cuentabancariaId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`cuentabancariaId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuentabancaria`
--

LOCK TABLES `cuentabancaria` WRITE;
/*!40000 ALTER TABLE `cuentabancaria` DISABLE KEYS */;
INSERT INTO `cuentabancaria` VALUES (34567890,890,9,'b1',1),(123456,123456,10,'b1',2);
/*!40000 ALTER TABLE `cuentabancaria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuentadeahorro`
--

DROP TABLE IF EXISTS `cuentadeahorro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cuentadeahorro` (
  `numero` int(11) DEFAULT NULL,
  `fechadisponibilidad` date DEFAULT NULL,
  `fechavencimiento` date DEFAULT NULL,
  `fechacontratacion` date DEFAULT NULL,
  `socioId` int(11) DEFAULT NULL,
  `tipoahorroId` varchar(100) DEFAULT NULL,
  `cuentadeahorroId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`cuentadeahorroId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuentadeahorro`
--

LOCK TABLES `cuentadeahorro` WRITE;
/*!40000 ALTER TABLE `cuentadeahorro` DISABLE KEYS */;
INSERT INTO `cuentadeahorro` VALUES (123,'2018-01-09','2018-01-09','2018-01-09',9,'esp2',9),(123456789,'2018-09-13','2018-09-20','2018-09-20',10,'v',10),(123,'2018-09-19','2018-09-19','2018-09-26',10,'nov',11);
/*!40000 ALTER TABLE `cuentadeahorro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departamento` (
  `representante` varchar(100) DEFAULT NULL,
  `nombredepto` varchar(100) DEFAULT NULL,
  `empresaId` int(11) DEFAULT NULL,
  `departamentoId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`departamentoId`),
  KEY `empresaId_idx` (`empresaId`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES ('Norma','001',10,10),('Lucía Juárez','Contabilidad',10,11),('Alfredo Reyes','Sistemas',10,12),('Noé López','Contabilidad',11,13),('Representante','Departamento',11,14),('JuanJo','DEPA',12,15),('sin empresa','hOLA',10,16);
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `domicilio`
--

DROP TABLE IF EXISTS `domicilio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `domicilio` (
  `ciudad` varchar(100) DEFAULT NULL,
  `cp` varchar(100) DEFAULT NULL,
  `estado` varchar(100) DEFAULT NULL,
  `calle` varchar(100) DEFAULT NULL,
  `socioId` int(11) DEFAULT NULL,
  `domicilioId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`domicilioId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `domicilio`
--

LOCK TABLES `domicilio` WRITE;
/*!40000 ALTER TABLE `domicilio` DISABLE KEYS */;
INSERT INTO `domicilio` VALUES ('Ciudad de México','02234','Ciudad de México','Av Eugenia 1115 ',9,9);
/*!40000 ALTER TABLE `domicilio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empresa` (
  `clave` varchar(100) DEFAULT NULL,
  `nombrecorto` varchar(100) DEFAULT NULL,
  `razonsocial` varchar(100) DEFAULT NULL,
  `empresaId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`empresaId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` VALUES ('123456789012345678901234567890','PRUEBA','Prueba',9),('KCM1234NGY2018','Kimberly MX','Kimberly-Clark de México',10),('SIG86932YYY2018','Sigma ','Sigma alimentos s.a. de c.v.',11),('ClrPt','Patos','Patito',12);
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `etiquetaasignada`
--

DROP TABLE IF EXISTS `etiquetaasignada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `etiquetaasignada` (
  `f5` int(11) NOT NULL,
  `sap` int(11) NOT NULL,
  `etiquetaasignadasxpalet` int(11) NOT NULL,
  `multiplo1` int(11) NOT NULL,
  `multiplo2` int(11) NOT NULL,
  `multiplo3` int(11) NOT NULL,
  `cliente1Id` int(11) DEFAULT NULL,
  `ordensimplificada1Id` int(11) DEFAULT NULL,
  `etiquetaasignadaId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`etiquetaasignadaId`),
  KEY `fk_clienteId_idx` (`cliente1Id`),
  KEY `fk_ordensimplificadaId_idx` (`ordensimplificada1Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `etiquetaasignada`
--

LOCK TABLES `etiquetaasignada` WRITE;
/*!40000 ALTER TABLE `etiquetaasignada` DISABLE KEYS */;
INSERT INTO `etiquetaasignada` VALUES (1,123,1234,1,2,3,1,1,1);
/*!40000 ALTER TABLE `etiquetaasignada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupo`
--

DROP TABLE IF EXISTS `grupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupo` (
  `id_grupo` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id_grupo`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupo`
--

LOCK TABLES `grupo` WRITE;
/*!40000 ALTER TABLE `grupo` DISABLE KEYS */;
INSERT INTO `grupo` VALUES (3,'MANAGE'),(7,'USER'),(8,'AUTHORITY'),(9,'APPLICATION'),(10,'FUNCTIONALSERVICE'),(11,'MENU'),(12,'MODULE'),(13,'CUENTADEAHORRO'),(14,'APORTACION'),(15,'DEPARTAMENTO'),(19,'EMPRESA'),(20,'PLANTA'),(21,'TASADEINTERES'),(25,'SOCIO'),(26,'PERFIL'),(27,'INTERES'),(28,'DOMICILIO'),(29,'BENEFICIARIO'),(30,'CUENTABANCARIA'),(31,'ORDENSIMPLIFICADA'),(32,'OPERADORPRODUCCION'),(33,'ETIQUETAASIGNADA'),(34,'CLIENTE'),(35,'AFILIADO'),(36,'BENEFICIARIO'),(37,'BENEFICIARIO'),(38,'TIPOPENSION');
/*!40000 ALTER TABLE `grupo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interes`
--

DROP TABLE IF EXISTS `interes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `interes` (
  `fecha` date DEFAULT NULL,
  `monto` decimal(10,0) DEFAULT NULL,
  `cuentadeahorroId` int(11) DEFAULT NULL,
  `interesId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`interesId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interes`
--

LOCK TABLES `interes` WRITE;
/*!40000 ALTER TABLE `interes` DISABLE KEYS */;
INSERT INTO `interes` VALUES ('2018-08-02',30000,9,10);
/*!40000 ALTER TABLE `interes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operadorproduccion`
--

DROP TABLE IF EXISTS `operadorproduccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `operadorproduccion` (
  `nombre` varchar(100) NOT NULL,
  `numeroempleado` int(11) NOT NULL,
  `operadorproduccionId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`operadorproduccionId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operadorproduccion`
--

LOCK TABLES `operadorproduccion` WRITE;
/*!40000 ALTER TABLE `operadorproduccion` DISABLE KEYS */;
INSERT INTO `operadorproduccion` VALUES ('Alejandro Hernandez',1,1),('Daniel Gómez',2,2),('Jaime Torres',3,3);
/*!40000 ALTER TABLE `operadorproduccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordensimplificada`
--

DROP TABLE IF EXISTS `ordensimplificada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordensimplificada` (
  `sap` int(11) DEFAULT NULL,
  `cantidadprogramada` int(11) DEFAULT NULL,
  `ordentrabajo` int(11) DEFAULT NULL,
  `fechafinal` date DEFAULT NULL,
  `cantidadproducida` int(11) DEFAULT NULL,
  `fechainicial` date DEFAULT NULL,
  `comentario` varchar(100) DEFAULT NULL,
  `linea1Id` varchar(100) DEFAULT NULL,
  `destino1Id` varchar(100) DEFAULT NULL,
  `estadoorden1Id` varchar(100) DEFAULT NULL,
  `estadoorden2Id` varchar(100) DEFAULT NULL,
  `operadorproduccion1Id` int(11) DEFAULT NULL,
  `operadorproduccion2Id` int(11) DEFAULT NULL,
  `cliente1Id` int(11) DEFAULT NULL,
  `ordensimplificadaId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ordensimplificadaId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordensimplificada`
--

LOCK TABLES `ordensimplificada` WRITE;
/*!40000 ALTER TABLE `ordensimplificada` DISABLE KEYS */;
INSERT INTO `ordensimplificada` VALUES (123,1234,1,'2018-09-03',1234,'2018-09-10','none','c','xx','xx','xx',1,1,1,1);
/*!40000 ALTER TABLE `ordensimplificada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfil`
--

DROP TABLE IF EXISTS `perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `perfil` (
  `nip` varchar(100) DEFAULT NULL,
  `usuario` varchar(100) DEFAULT NULL,
  `socioId` int(11) DEFAULT NULL,
  `perfilId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`perfilId`),
  KEY `socioId_idx` (`socioId`),
  CONSTRAINT `socioId` FOREIGN KEY (`socioId`) REFERENCES `socio` (`socioId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfil`
--

LOCK TABLES `perfil` WRITE;
/*!40000 ALTER TABLE `perfil` DISABLE KEYS */;
INSERT INTO `perfil` VALUES ('12345678','admin',9,9);
/*!40000 ALTER TABLE `perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planta`
--

DROP TABLE IF EXISTS `planta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `planta` (
  `direccion` varchar(100) DEFAULT NULL,
  `nombreplanta` varchar(100) DEFAULT NULL,
  `maximo` decimal(10,0) DEFAULT NULL,
  `diadepago` int(11) DEFAULT NULL,
  `minimo` decimal(10,0) DEFAULT NULL,
  `empresaId` int(11) NOT NULL,
  `plantaId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`plantaId`,`empresaId`),
  KEY `empresaId_idx` (`empresaId`),
  CONSTRAINT `empresaId` FOREIGN KEY (`empresaId`) REFERENCES `empresa` (`empresaId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planta`
--

LOCK TABLES `planta` WRITE;
/*!40000 ALTER TABLE `planta` DISABLE KEYS */;
INSERT INTO `planta` VALUES ('Domicilio conocido','Orizaba',5000,15,100,10,10),('Domicilio conocido','Ramos Arizpe',5000,20,100,10,11),('Domicilio conocido','Texmelucan',5000,5,100,10,12),('Ciudad de mexico','Iztacalco',5000,30,100,11,14),('Alvaro Obregon 123 CDMX','Santa Fe',-100,15,100,11,15);
/*!40000 ALTER TABLE `planta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `privilege`
--

DROP TABLE IF EXISTS `privilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `privilege` (
  `id_privilege` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `id_grupo` int(11) NOT NULL,
  `enabled` tinyint(4) NOT NULL,
  `creationdate` date DEFAULT NULL,
  `modifieddate` date DEFAULT NULL,
  PRIMARY KEY (`id_privilege`),
  KEY `id_group_idx` (`id_grupo`),
  CONSTRAINT `id_grupo` FOREIGN KEY (`id_grupo`) REFERENCES `grupo` (`id_grupo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `privilege`
--

LOCK TABLES `privilege` WRITE;
/*!40000 ALTER TABLE `privilege` DISABLE KEYS */;
INSERT INTO `privilege` VALUES (9,'MANAGESEARCH',3,1,'2018-07-02',NULL),(10,'MANAGEUPDATE',3,1,'2018-07-02',NULL),(23,'USERCREATE',7,1,'2018-07-02',NULL),(24,'USERSEARCH',7,1,'2018-07-02',NULL),(25,'USERUPDATE',7,1,'2018-07-02',NULL),(26,'USERDELETE',7,1,'2018-07-02',NULL),(27,'AUTHORITYCREATE',8,1,'2018-07-02',NULL),(28,'AUTHORITYUPDATE',8,1,'2018-07-02',NULL),(29,'AUTHORITYSEARCH',8,1,'2018-07-02',NULL),(30,'AUTHORITYDELETE',8,1,'2018-07-02',NULL),(31,'APPLICATIONSEARCH',9,1,'2018-07-18',NULL),(32,'APPLICATIONUPDATE',9,1,'2018-07-18',NULL),(33,'APPLICATIONDELETE',9,1,'2018-07-18',NULL),(34,'APPLICATIONCREATE',9,1,'2018-07-18',NULL),(35,'FUNCTIONALSERVICESEARCH',10,1,'2018-07-18',NULL),(36,'FUNCTIONALSERVICEUPDATE',10,1,'2018-07-18',NULL),(37,'FUNCTIONALSERVICEDELETE',10,1,'2018-07-18',NULL),(38,'FUNCTIONALSERVICECREATE',10,1,'2018-07-18',NULL),(39,'MENUSEARCH',11,1,'2018-07-18',NULL),(40,'MENUUPDATE',11,1,'2018-07-18',NULL),(41,'MENUDELETE',11,1,'2018-07-18',NULL),(42,'MENUCREATE',11,1,'2018-07-18',NULL),(43,'MODULESEARCH',12,1,'2018-07-18',NULL),(44,'MODULEUPDATE',12,1,'2018-07-18',NULL),(45,'MODULEDELETE',12,1,'2018-07-18',NULL),(46,'MODULECREATE',12,1,'2018-07-18',NULL),(47,'CUENTADEAHORROSEARCH',13,1,'2018-08-13',NULL),(48,'CUENTADEAHORROUPDATE',13,1,'2018-08-13',NULL),(49,'CUENTADEAHORRODELETE',13,1,'2018-08-13',NULL),(50,'CUENTADEAHORROCREATE',13,1,'2018-08-13',NULL),(51,'APORTACIONSEARCH',14,1,'2018-08-13',NULL),(52,'APORTACIONUPDATE',14,1,'2018-08-13',NULL),(53,'APORTACIONDELETE',14,1,'2018-08-13',NULL),(54,'APORTACIONCREATE',14,1,'2018-08-13',NULL),(55,'DEPARTAMENTOSEARCH',15,1,'2018-08-14',NULL),(56,'DEPARTAMENTOUPDATE',15,1,'2018-08-14',NULL),(57,'DEPARTAMENTODELETE',15,1,'2018-08-14',NULL),(58,'DEPARTAMENTOCREATE',15,1,'2018-08-14',NULL),(59,'EMPRESASEARCH',19,1,'2018-08-14',NULL),(60,'EMPRESAUPDATE',19,1,'2018-08-14',NULL),(61,'EMPRESADELETE',19,1,'2018-08-14',NULL),(62,'EMPRESACREATE',19,1,'2018-08-14',NULL),(63,'PLANTASEARCH',20,1,'2018-08-14',NULL),(64,'PLANTAUPDATE',20,1,'2018-08-14',NULL),(65,'PLANTADELETE',20,1,'2018-08-14',NULL),(66,'PLANTACREATE',20,1,'2018-08-14',NULL),(67,'TASADEINTERESSEARCH',21,1,'2018-08-14',NULL),(68,'TASADEINTERESUPDATE',21,1,'2018-08-14',NULL),(69,'TASADEINTERESDELETE',21,1,'2018-08-14',NULL),(70,'TASADEINTERESCREATE',21,1,'2018-08-14',NULL),(71,'SOCIOSEARCH',25,1,'2018-08-15',NULL),(72,'SOCIOUPDATE',25,1,'2018-08-15',NULL),(73,'SOCIODELETE',25,1,'2018-08-15',NULL),(74,'SOCIOCREATE',25,1,'2018-08-15',NULL),(75,'PERFILSEARCH',26,1,'2018-08-15',NULL),(76,'PERFILUPDATE',26,1,'2018-08-15',NULL),(77,'PERFILDELETE',26,1,'2018-08-15',NULL),(78,'PERFILCREATE',26,1,'2018-08-15',NULL),(79,'INTERESSEARCH',27,1,'2018-08-15',NULL),(80,'INTERESUPDATE',27,1,'2018-08-15',NULL),(81,'INTERESDELETE',27,1,'2018-08-15',NULL),(82,'INTERESCREATE',27,1,'2018-08-15',NULL),(83,'DOMICILIOSEARCH',28,1,'2018-08-15',NULL),(84,'DOMICILIOUPDATE',28,1,'2018-08-15',NULL),(85,'DOMICILIODELETE',28,1,'2018-08-15',NULL),(86,'DOMICILIOCREATE',28,1,'2018-08-15',NULL),(87,'DOMICILIOCREATE',28,1,'2018-08-15',NULL),(88,'BENEFICIARIOSEARCH',29,1,'2018-08-15',NULL),(89,'BENEFICIARIOUPDATE',29,1,'2018-08-15',NULL),(90,'BENEFICIARIODELETE',29,1,'2018-08-15',NULL),(91,'BENEFICIARIOCREATE',29,1,'2018-08-15',NULL),(92,'CUENTABANCARIASEARCH',30,1,'2018-08-16',NULL),(93,'CUENTABANCARIAUPDATE',30,1,'2018-08-16',NULL),(94,'CUENTABANCARIADELETE',30,1,'2018-08-16',NULL),(95,'CUENTABANCARIACREATE',30,1,'2018-08-16',NULL),(96,'ORDENSIMPLIFICADASEARCH',31,1,'2018-08-31',NULL),(97,'ORDENSIMPLIFICADAUPDATE',31,1,'2018-08-31',NULL),(98,'ORDENSIMPLIFICADADELETE',31,1,'2018-08-31',NULL),(99,'ORDENSIMPLIFICADACREATE',31,1,'2018-08-31',NULL),(100,'OPERADORPRODUCCIONSEARCH',32,1,'2018-08-31',NULL),(101,'OPERADORPRODUCCIONUPDATE',32,1,'2018-08-31',NULL),(102,'OPERADORPRODUCCIONDELETE',32,1,'2018-08-31',NULL),(103,'OPERADORPRODUCCIONCREATE',32,1,'2018-08-31',NULL),(104,'ETIQUETAASIGNADASEARCH',33,1,'2018-08-31',NULL),(105,'ETIQUETAASIGNADAUPDATE',33,1,'2018-08-31',NULL),(106,'ETIQUETAASIGNADADELETE',33,1,'2018-08-31',NULL),(107,'ETIQUETAASIGNADACREATE',33,1,'2018-08-31',NULL),(108,'CLIENTESEARCH',34,1,'2018-08-31',NULL),(109,'CLIENTEUPDATE',34,1,'2018-08-31',NULL),(110,'CLIENTEDELETE',34,1,'2018-08-31',NULL),(111,'CLIENTECREATE',34,1,'2018-08-31',NULL),(112,'AFILIADOSEARCH',35,1,'2018-10-01',NULL),(113,'AFILIADOUPDATE',35,1,'2018-10-01',NULL),(114,'AFILIADODELETE',35,1,'2018-10-01',NULL),(115,'AFILIADOCREATE',35,1,'2018-10-01',NULL),(116,'TIPOPENSIONSEARCH',38,1,'2018-10-01',NULL),(117,'TIPOPENSIONUPDATE',38,1,'2018-10-01',NULL),(118,'TIPOPENSIONDELETE',38,1,'2018-10-01',NULL),(119,'TIPOPENSIONCREATE',38,1,'2018-10-01',NULL);
/*!40000 ALTER TABLE `privilege` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `socio`
--

DROP TABLE IF EXISTS `socio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `socio` (
  `apellidopaterno` varchar(100) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `apellidomaterno` varchar(100) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `telefono` varchar(100) DEFAULT NULL,
  `generoId` varchar(100) DEFAULT NULL,
  `tipoempleadoId` varchar(100) DEFAULT NULL,
  `departamentoId` int(11) DEFAULT NULL,
  `plantaId` int(11) DEFAULT NULL,
  `socioId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`socioId`),
  KEY `departamentoId_idx` (`departamentoId`),
  KEY `plantaId_idx` (`plantaId`),
  CONSTRAINT `departamentoId` FOREIGN KEY (`departamentoId`) REFERENCES `departamento` (`departamentoId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `plantaId` FOREIGN KEY (`plantaId`) REFERENCES `planta` (`plantaId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socio`
--

LOCK TABLES `socio` WRITE;
/*!40000 ALTER TABLE `socio` DISABLE KEYS */;
INSERT INTO `socio` VALUES ('Velazquez',1,'Adriana','Ramirez','','123456','fem','p',10,12,9),('Zamora',1001,'Irma','Francisco','irma@gmail.com','56581111','fem','p',11,11,10);
/*!40000 ALTER TABLE `socio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitudpension`
--

DROP TABLE IF EXISTS `solicitudpension`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `solicitudpension` (
  `numero` int(11) DEFAULT NULL,
  `fecha_solicitud` date DEFAULT NULL,
  `observaciones` varchar(11) DEFAULT NULL,
  `afiliado1Id` int(11) DEFAULT NULL,
  `tipopension1Id` int(11) DEFAULT NULL,
  `solicitudpensionId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`solicitudpensionId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitudpension`
--

LOCK TABLES `solicitudpension` WRITE;
/*!40000 ALTER TABLE `solicitudpension` DISABLE KEYS */;
/*!40000 ALTER TABLE `solicitudpension` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasadeinteres`
--

DROP TABLE IF EXISTS `tasadeinteres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tasadeinteres` (
  `fechafin` date DEFAULT NULL,
  `fechainicio` date DEFAULT NULL,
  `tasa` decimal(10,0) DEFAULT NULL,
  `empresaId` int(11) NOT NULL,
  `tasadeinteresId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`tasadeinteresId`,`empresaId`),
  KEY `empresaId_idx` (`empresaId`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasadeinteres`
--

LOCK TABLES `tasadeinteres` WRITE;
/*!40000 ALTER TABLE `tasadeinteres` DISABLE KEYS */;
INSERT INTO `tasadeinteres` VALUES ('2019-08-11','2018-08-11',34,9,9),('2018-09-21','2018-09-21',2,11,10),('2018-09-05','2018-09-05',12,11,11),('2018-09-21','2018-09-05',57,11,12),('2018-09-20','2018-09-05',123,12,13),('2018-09-21','2018-09-06',123,10,14),('2018-08-31','2018-09-06',0,12,15);
/*!40000 ALTER TABLE `tasadeinteres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipopension`
--

DROP TABLE IF EXISTS `tipopension`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipopension` (
  `clave` varchar(100) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `tipopensionId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`tipopensionId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipopension`
--

LOCK TABLES `tipopension` WRITE;
/*!40000 ALTER TABLE `tipopension` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipopension` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `firstname` varchar(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT '1',
  `attemps` int(11) DEFAULT NULL,
  `lastpasswordresetdate` date DEFAULT NULL,
  `creationdate` date NOT NULL,
  `modifieddate` date DEFAULT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `USERNAME_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi','Normaysel','Carbajal','normaysel.carbajal@softtek.com',1,NULL,'2018-09-01','2018-06-25',NULL),(2,'user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','Javier','Aguilar','javieraguilar@softtek.com',1,NULL,'2018-07-15','2018-07-18','2018-07-18'),(3,'test','$2a$10$SdTyWGY5rKgWQWEI.FgX/ujMVVwt1T45fI3t1a4/VT/vd89A8zi4a','Juan','Perez','juanperez@softtek.com',1,NULL,'2018-07-07','2018-07-03',NULL),(6,'test2','$2a$10$vbxCj7sR6HvHSMEqtScfb.8gRtOLyR3W7edDLHBHqE5eETgrsiZD.','Marcos','Carrillo','marcos@softtek.com',1,NULL,'2018-07-13','2018-07-13','2018-07-13'),(8,'jaas79','$2a$10$4NYOvd/pyX86Z03r3nCn/ezNbVtOwStCfkzgGQ84KHSPSQ3ku4MQ.','Javier','Aguilar','javier.aguilar@softtek.com',1,NULL,'2018-07-09','2018-07-09','2018-07-09'),(21,'user-rol-disabled','$2a$10$daY8gikhmfnkGwXqBUJfxugHjd49xv4w3xqwBNXXDNQPOuf92aZ/i','User','Rol Disabled','user.disabled@email.com',1,NULL,'2018-06-13','2018-07-13',NULL),(22,'Normaysel','$2a$10$mWWqKl/gcVRuxnHnKfkky.vfkmvrxBWopW0HLyUD8HjF1fbHjRQtS','Normaysel','Carbajal','alexydiego@gmail.com',1,NULL,'2018-06-24','2018-07-24',NULL),(23,'admin3','$2a$10$w5jydiCFgav63JQgk82bHeW1gXB3/76dKZgEUng1pcqymIiP8MJr.','qwertyuiop','werty','asdasd@dsdf.com',1,NULL,'2018-09-07','2018-09-07',NULL),(24,'admin4','$2a$10$9GfVMAlla7XMSAOEK.izwOti5WwjzfA27IPv0REO6JO8s2ZwCgitq','qwertyuiop','wertyuiop','asdasd@dsdf.com',1,NULL,'2018-09-07','2018-09-07',NULL),(25,'admin5','$2a$10$c89Twm0qSdWFjjvcFbP0s.Tt4nv4DvadQslP.GP6E/SJe5psRenxK','qwertyuiop','asdfghjklñ','asdasd@dsdf.com',1,NULL,'2018-09-07','2018-09-07',NULL),(26,'admin6','$2a$10$dzQpzzDRcHu.YEuAM3m2o.TSl6MbkpO0dKS8Ea75yg1QO0QLxnJce','asdfghjklñ','asdfghjklñ','asdasd@dsdf.com',1,NULL,'2018-09-07','2018-09-07',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_authority`
--

DROP TABLE IF EXISTS `user_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_authority` (
  `id_user` int(11) NOT NULL,
  `id_authority` int(11) NOT NULL,
  `id_user_auth` int(11) NOT NULL AUTO_INCREMENT,
  `enabled` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_user_auth`),
  KEY `id_authority_idx` (`id_authority`),
  KEY `id_user_idx` (`id_user`),
  CONSTRAINT `id_authority` FOREIGN KEY (`id_authority`) REFERENCES `authority` (`id_authority`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_authority`
--

LOCK TABLES `user_authority` WRITE;
/*!40000 ALTER TABLE `user_authority` DISABLE KEYS */;
INSERT INTO `user_authority` VALUES (1,1,1,1),(21,8,67,1),(6,1,72,1),(2,2,73,1),(22,2,74,1),(23,1,75,1),(24,1,76,1),(25,1,77,1),(26,1,78,1);
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

-- Dump completed on 2018-10-01 19:03:48
