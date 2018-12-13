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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
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
  CONSTRAINT `fk_id_privilege` FOREIGN KEY (`id_privilege`) REFERENCES `privilege` (`id_privilege`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=568 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authority_privilege`
--

LOCK TABLES `authority_privilege` WRITE;
/*!40000 ALTER TABLE `authority_privilege` DISABLE KEYS */;
INSERT INTO `authority_privilege` VALUES (1,9,17,1),(1,10,18,1),(1,23,37,1),(1,24,38,1),(1,25,39,1),(1,26,40,1),(1,27,41,1),(1,28,42,1),(1,29,43,1),(1,30,44,1),(2,30,48,0),(3,30,49,1),(6,30,50,1),(7,30,51,0),(2,31,62,0),(2,32,63,0),(2,33,64,0),(2,34,65,0),(2,39,292,0),(2,40,293,0),(2,41,294,0),(2,42,295,0),(2,43,296,0),(2,44,297,0),(2,45,298,0),(2,46,299,0),(2,35,300,0),(2,36,301,0),(2,37,302,0),(2,38,303,0),(1,31,304,1),(1,32,305,1),(1,33,306,1),(1,34,307,1),(1,35,308,1),(1,36,309,1),(1,37,310,1),(1,38,311,1),(1,39,312,1),(1,40,313,1),(1,41,314,1),(1,42,315,1),(1,43,316,1),(1,44,317,1),(1,45,318,1),(1,46,319,1),(1,47,320,1),(1,48,321,1),(1,49,322,1),(1,50,323,1),(1,51,324,1),(1,52,325,1),(1,53,326,1),(1,54,327,1),(1,55,328,1),(1,56,329,1),(1,57,330,1),(1,58,331,1),(1,59,332,1),(1,60,333,1),(1,61,334,1),(1,62,335,1),(1,63,336,1),(1,64,337,1),(1,65,338,1),(1,66,339,1),(1,67,340,1),(1,68,341,1),(1,69,342,1),(1,70,343,1),(2,47,344,0),(2,48,345,0),(2,49,346,0),(2,51,347,0),(2,54,348,0),(1,86,350,1),(1,85,351,1),(1,84,352,1),(1,83,353,1),(1,82,354,1),(1,81,355,1),(1,80,356,1),(1,79,357,1),(1,78,358,1),(1,75,359,1),(1,76,360,1),(1,77,361,1),(1,71,362,1),(1,72,363,1),(1,73,364,1),(1,74,365,1),(1,88,366,1),(1,89,367,1),(1,90,368,1),(1,91,369,1),(1,92,370,1),(1,93,371,1),(1,94,372,1),(1,95,373,1),(1,96,374,1),(1,97,375,1),(1,98,376,1),(1,99,377,1),(1,100,378,1),(1,101,379,1),(1,102,380,1),(1,103,381,1),(1,104,382,1),(1,106,383,1),(1,105,384,1),(1,107,385,1),(1,108,386,1),(1,109,387,1),(1,110,388,1),(1,111,389,1),(1,112,390,1),(1,113,391,1),(1,114,392,1),(1,115,393,1),(1,116,394,1),(1,117,395,1),(1,118,396,1),(1,119,397,1),(1,124,398,1),(1,125,399,1),(1,126,400,1),(1,127,401,1),(1,128,402,1),(1,129,403,1),(1,131,404,1),(1,133,405,1),(1,132,406,1),(1,134,407,1),(1,130,408,1),(1,135,409,1),(1,136,410,1),(1,140,411,1),(1,138,412,1),(1,137,413,1),(1,139,414,1),(1,141,415,1),(1,142,416,1),(1,143,417,1),(1,145,418,1),(1,146,419,1),(1,144,420,1),(1,147,421,1),(1,151,422,1),(1,149,423,1),(1,152,424,1),(1,150,425,1),(1,148,426,1),(1,153,427,1),(1,154,428,1),(1,155,429,1),(1,156,430,1),(1,159,431,1),(1,158,432,1),(1,157,433,1),(1,160,434,1),(1,161,435,1),(1,163,436,1),(1,162,437,1),(1,165,438,1),(1,164,439,1),(1,167,440,1),(1,166,441,1),(1,168,442,1),(1,169,443,1),(1,170,444,1),(1,173,445,1),(1,172,446,1),(1,171,447,1),(1,174,448,1),(1,175,449,1),(1,179,450,1),(1,177,451,1),(1,176,452,1),(1,178,453,1),(4,31,454,0),(2,179,455,1),(2,178,456,1),(2,177,457,1),(2,176,458,1),(4,176,459,1),(2,175,460,1),(2,174,461,1),(2,173,462,1),(2,172,463,1),(4,172,464,1),(2,171,465,1),(2,170,466,1),(2,169,467,1),(2,168,468,1),(4,168,469,1),(4,167,470,1),(4,166,471,1),(4,165,472,1),(4,164,473,1),(2,164,474,1),(4,163,475,0),(4,162,476,0),(4,161,477,0),(4,160,478,1),(2,160,479,1),(4,155,480,1),(4,154,481,1),(4,153,482,1),(4,152,483,1),(2,152,484,1),(4,151,485,0),(4,150,486,0),(4,149,487,0),(4,148,488,1),(2,148,489,1),(4,144,490,1),(4,140,491,1),(2,139,492,1),(2,138,493,1),(2,137,494,1),(4,136,495,1),(2,136,496,1),(2,135,497,1),(2,134,498,1),(2,133,499,1),(2,132,500,1),(4,132,501,1),(4,128,502,1),(3,9,503,1),(3,10,504,1),(3,23,505,1),(3,24,506,1),(3,25,507,1),(3,26,508,1),(3,27,509,1),(3,28,510,1),(3,29,511,1),(3,31,512,1),(3,32,513,1),(3,33,514,1),(3,34,515,1),(3,35,516,1),(3,36,517,1),(3,37,518,1),(3,38,519,1),(3,40,520,1),(3,41,521,1),(3,39,522,1),(3,42,523,1),(3,43,524,1),(3,44,525,1),(3,45,526,1),(3,46,527,1),(3,83,528,1),(4,129,529,0),(4,130,530,0),(4,131,531,0),(4,141,532,0),(4,142,533,0),(4,143,534,0),(3,128,535,1),(4,24,536,1),(3,132,537,1),(3,136,538,1),(3,140,539,1),(3,141,540,1),(3,143,541,1),(3,142,542,1),(3,144,543,1),(3,145,544,1),(3,146,545,1),(3,147,546,1),(3,148,547,1),(3,149,548,1),(3,150,549,1),(3,151,550,1),(3,152,551,1),(3,156,552,1),(3,157,553,1),(3,158,554,1),(3,159,555,1),(3,160,556,1),(3,161,557,1),(3,162,558,1),(3,163,559,1),(3,164,560,1),(3,168,561,1),(3,172,562,1),(3,176,563,1),(3,178,564,1),(3,129,565,1),(3,130,566,1),(3,131,567,1);
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `beneficiario`
--

LOCK TABLES `beneficiario` WRITE;
/*!40000 ALTER TABLE `beneficiario` DISABLE KEYS */;
/*!40000 ALTER TABLE `beneficiario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `candidato`
--

DROP TABLE IF EXISTS `candidato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `candidato` (
  `fecha` date DEFAULT NULL,
  `apellidomaterno` varchar(100) DEFAULT NULL,
  `apellidopaterno` varchar(100) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `generoId` varchar(100) DEFAULT NULL,
  `estatuscandidatoId` varchar(100) DEFAULT NULL,
  `candidatoId` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`candidatoId`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidato`
--

LOCK TABLES `candidato` WRITE;
/*!40000 ALTER TABLE `candidato` DISABLE KEYS */;
INSERT INTO `candidato` VALUES ('2018-10-07','Dominguez','Hernandez','Adriana','fem','e1',1,NULL),('2018-10-19','qwqwqw','qwqwqw','qqwqw','fem','e5',2,''),('2018-10-04','sdsd','sdsd','ss','mas','e1',16,''),('1999-09-28','Hdz','Alvarado','Jesus','mas','e2',22,''),('1981-01-16','Muñiz','Carbajal','Normaysel','fem','e1',23,'Candidato');
/*!40000 ALTER TABLE `candidato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `candidatosolicitud`
--

DROP TABLE IF EXISTS `candidatosolicitud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `candidatosolicitud` (
  `candidatosolicitudId` int(11) NOT NULL AUTO_INCREMENT,
  `candidatoId` int(11) NOT NULL,
  `solicitudId` int(11) NOT NULL,
  PRIMARY KEY (`candidatosolicitudId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidatosolicitud`
--

LOCK TABLES `candidatosolicitud` WRITE;
/*!40000 ALTER TABLE `candidatosolicitud` DISABLE KEYS */;
INSERT INTO `candidatosolicitud` VALUES (1,1,1),(2,5,1),(3,6,1),(4,7,1),(5,8,1),(6,9,1),(7,1,2);
/*!40000 ALTER TABLE `candidatosolicitud` ENABLE KEYS */;
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
-- Table structure for table `direccion`
--

DROP TABLE IF EXISTS `direccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `direccion` (
  `estado` varchar(100) DEFAULT NULL,
  `cp` varchar(100) DEFAULT NULL,
  `ciudad` varchar(100) DEFAULT NULL,
  `calle` varchar(100) DEFAULT NULL,
  `candidatoId` int(11) DEFAULT NULL,
  `direccionId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`direccionId`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `direccion`
--

LOCK TABLES `direccion` WRITE;
/*!40000 ALTER TABLE `direccion` DISABLE KEYS */;
INSERT INTO `direccion` VALUES ('Ciudad de México','07210','Ciudad de México','Benito Juarez',1,1),('Nuevo leon','67160','Monterrey','Paseo',22,18),('Ciudad de México','07210','Ciudad de México','Benito Juarez',23,19);
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
  `size` int(11) DEFAULT NULL,
  `documentoId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`documentoId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documento`
--

LOCK TABLES `documento` WRITE;
/*!40000 ALTER TABLE `documento` DISABLE KEYS */;
INSERT INTO `documento` VALUES ('Acta de Nacimiento','Documento de identificación oficial',1,1),('Diploma','Diploma de primer lugar de gamer en softtek',1,4),('IFE 1','IFE 1234567777',1,8);
/*!40000 ALTER TABLE `documento` ENABLE KEYS */;
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
-- Table structure for table `evento`
--

DROP TABLE IF EXISTS `evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evento` (
  `responsable` varchar(100) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `feedback` varchar(100) DEFAULT NULL,
  `responsablereal` varchar(100) DEFAULT NULL,
  `fechareal` date DEFAULT NULL,
  `comentarios` varchar(100) DEFAULT NULL,
  `notas` varchar(100) DEFAULT NULL,
  `tipoeventoId` varchar(100) DEFAULT NULL,
  `posicionId` int(11) DEFAULT NULL,
  `candidatoId` int(11) DEFAULT NULL,
  `estatuseventoId` varchar(100) DEFAULT NULL,
  `eventoId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`eventoId`),
  KEY `fk_posicion_idx` (`posicionId`),
  KEY `fk_candidato_idx` (`candidatoId`),
  CONSTRAINT `fk_candidato` FOREIGN KEY (`candidatoId`) REFERENCES `candidato` (`candidatoId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_posicion` FOREIGN KEY (`posicionId`) REFERENCES `posicion` (`posicionId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento`
--

LOCK TABLES `evento` WRITE;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
INSERT INTO `evento` VALUES ('test_evento','2018-11-18','test_evento','test_evento','test_evento','2018-11-18','test_evento','test_evento','a',1,1,'e1',1),('Maria Concepción Dominguez de la Cruz','2018-10-31','Entrevista técnica presencial','','','2018-10-25','ninguno','Es su horario de comida, solo tiene una hora exacta para la entrevista','c',3,2,'e1',2),('test_evento','2018-11-18','test_evento','test_evento','test_evento','2018-11-18','test_evento','test_evento','a',1,1,'e1',8),('Edgar Felipe Fuentes Perea','2018-10-17','Entrevista telefónica con el candidato','Pasa al siguiente proceso','Edgar Felipe Fuentes Perea','2018-10-17','La entrevista fue satisfactoria, por lo que el candidato es apto para avanzar a la siguiente fase.','Llamar entre 9:00 - 11:00 am.','a',1,2,'e2',9),('JJAH','2018-10-25','Llamada primer contacto','bien1','josej.alvarado','2018-11-25','bien','ok','a',7,22,'e1',11);
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `filial`
--

DROP TABLE IF EXISTS `filial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `filial` (
  `sitio` varchar(100) DEFAULT NULL,
  `telefono` varchar(100) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `ciudad` varchar(100) DEFAULT NULL,
  `estado` varchar(100) DEFAULT NULL,
  `ubicacion` varchar(100) DEFAULT NULL,
  `contacto` varchar(100) DEFAULT NULL,
  `notas` varchar(100) DEFAULT NULL,
  `filialId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`filialId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `filial`
--

LOCK TABLES `filial` WRITE;
/*!40000 ALTER TABLE `filial` DISABLE KEYS */;
INSERT INTO `filial` VALUES ('https://www.montepiedad.com.mx','5512345678','Metro Portales-Benito Juárez, CDMX - 8','Ciudad de México','Ciudad de México',' Metro Portales-Benito Juárez, CDMX - 8 Emperadores # 63, Col. Portales, Del. Benito Juárez','Sr. Juan López','notas',1),('https://www.montepiedad.com.mx','01 800 356 6683','B Grand -  San Ángel','Ciudad de México','CDMX','Calle Iglesia No.270','Roberto Garza','Prueba Alta Filial',3);
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
  `id_grupo` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id_grupo`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupo`
--

LOCK TABLES `grupo` WRITE;
/*!40000 ALTER TABLE `grupo` DISABLE KEYS */;
INSERT INTO `grupo` VALUES (3,'MANAGE'),(7,'USER'),(8,'AUTHORITY'),(9,'APPLICATION'),(10,'FUNCTIONALSERVICE'),(11,'MENU'),(12,'MODULE'),(13,'CUENTADEAHORRO'),(14,'APORTACION'),(15,'DEPARTAMENTO'),(19,'EMPRESA'),(20,'PLANTA'),(21,'TASADEINTERES'),(25,'SOCIO'),(26,'PERFIL'),(27,'INTERES'),(28,'DOMICILIO'),(29,'BENEFICIARIO'),(30,'CUENTABANCARIA'),(31,'ORDENSIMPLIFICADA'),(32,'OPERADORPRODUCCION'),(33,'ETIQUETAASIGNADA'),(34,'CLIENTE'),(35,'AFILIADO'),(36,'BENEFICIARIO'),(37,'BENEFICIARIO'),(38,'TIPOPENSION'),(39,'SOLICITUDPENSION'),(40,'USUARIO'),(41,'TRAYECTORIA'),(42,'SOLICITUD'),(43,'ROL'),(44,'RECLUTADOR'),(45,'RECLUTADOR'),(46,'PUESTO'),(47,'POSICION'),(48,'PERMISO'),(49,'FILIAL'),(50,'EVENTO'),(51,'DOCUMENTO'),(52,'DIRECCION'),(53,'CANDIDATO');
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
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log` (
  `logId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `fechaIngreso` timestamp NULL DEFAULT NULL,
  `fechaSalida` timestamp NULL DEFAULT NULL,
  `accionId` varchar(200) DEFAULT NULL,
  `fechaCreacion` timestamp NULL DEFAULT NULL,
  `fechaModificacion` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`logId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
/*!40000 ALTER TABLE `log` ENABLE KEYS */;
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
-- Table structure for table `permiso`
--

DROP TABLE IF EXISTS `permiso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permiso` (
  `ruta` varchar(100) DEFAULT NULL,
  `funcion` varchar(100) DEFAULT NULL,
  `nivelpermiso` varchar(100) DEFAULT NULL,
  `rolId` int(11) DEFAULT NULL,
  `permisoId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`permisoId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permiso`
--

LOCK TABLES `permiso` WRITE;
/*!40000 ALTER TABLE `permiso` DISABLE KEYS */;
/*!40000 ALTER TABLE `permiso` ENABLE KEYS */;
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
-- Table structure for table `posicion`
--

DROP TABLE IF EXISTS `posicion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `posicion` (
  `descripcion` varchar(100) DEFAULT NULL,
  `contacto` varchar(100) DEFAULT NULL,
  `salario` decimal(10,0) DEFAULT NULL,
  `vacantes` int(11) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `filialId` int(11) DEFAULT NULL,
  `puestoId` int(11) DEFAULT NULL,
  `tiponominaId` varchar(100) DEFAULT NULL,
  `reclutadorId` int(11) DEFAULT NULL,
  `estatusposicionId` varchar(100) DEFAULT NULL,
  `posicionId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`posicionId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posicion`
--

LOCK TABLES `posicion` WRITE;
/*!40000 ALTER TABLE `posicion` DISABLE KEYS */;
INSERT INTO `posicion` VALUES ('test','test',20000,1,'test1','2018-10-25',1,2,'a',3,'e1',1),('Test2','Test2',20000,2,'Test2','2018-10-13',1,3,'a',3,'e1',2),('Más de 10 años de experiencia en empresa similar al monte de piedad. Licencia vigente.','Director de cambaceo Juan Lopez Martinez',10,5,'Promotor Senior','2018-10-22',1,12,'b',3,'e1',3),('Mozo desc','JJAH',7900,2,'Mozo nivel 1','2018-10-25',1,5,'a',16,'e1',7);
/*!40000 ALTER TABLE `posicion` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=180 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `privilege`
--

LOCK TABLES `privilege` WRITE;
/*!40000 ALTER TABLE `privilege` DISABLE KEYS */;
INSERT INTO `privilege` VALUES (9,'MANAGESEARCH',3,1,'2018-07-02',NULL),(10,'MANAGEUPDATE',3,1,'2018-07-02',NULL),(23,'USERCREATE',7,1,'2018-07-02',NULL),(24,'USERSEARCH',7,1,'2018-07-02',NULL),(25,'USERUPDATE',7,1,'2018-07-02',NULL),(26,'USERDELETE',7,1,'2018-07-02',NULL),(27,'AUTHORITYCREATE',8,1,'2018-07-02',NULL),(28,'AUTHORITYUPDATE',8,1,'2018-07-02',NULL),(29,'AUTHORITYSEARCH',8,1,'2018-07-02',NULL),(30,'AUTHORITYDELETE',8,1,'2018-07-02',NULL),(31,'APPLICATIONSEARCH',9,1,'2018-07-18',NULL),(32,'APPLICATIONUPDATE',9,1,'2018-07-18',NULL),(33,'APPLICATIONDELETE',9,1,'2018-07-18',NULL),(34,'APPLICATIONCREATE',9,1,'2018-07-18',NULL),(35,'FUNCTIONALSERVICESEARCH',10,1,'2018-07-18',NULL),(36,'FUNCTIONALSERVICEUPDATE',10,1,'2018-07-18',NULL),(37,'FUNCTIONALSERVICEDELETE',10,1,'2018-07-18',NULL),(38,'FUNCTIONALSERVICECREATE',10,1,'2018-07-18',NULL),(39,'MENUSEARCH',11,1,'2018-07-18',NULL),(40,'MENUUPDATE',11,1,'2018-07-18',NULL),(41,'MENUDELETE',11,1,'2018-07-18',NULL),(42,'MENUCREATE',11,1,'2018-07-18',NULL),(43,'MODULESEARCH',12,1,'2018-07-18',NULL),(44,'MODULEUPDATE',12,1,'2018-07-18',NULL),(45,'MODULEDELETE',12,1,'2018-07-18',NULL),(46,'MODULECREATE',12,1,'2018-07-18',NULL),(47,'CUENTADEAHORROSEARCH',13,1,'2018-08-13',NULL),(48,'CUENTADEAHORROUPDATE',13,1,'2018-08-13',NULL),(49,'CUENTADEAHORRODELETE',13,1,'2018-08-13',NULL),(50,'CUENTADEAHORROCREATE',13,1,'2018-08-13',NULL),(51,'APORTACIONSEARCH',14,1,'2018-08-13',NULL),(52,'APORTACIONUPDATE',14,1,'2018-08-13',NULL),(53,'APORTACIONDELETE',14,1,'2018-08-13',NULL),(54,'APORTACIONCREATE',14,1,'2018-08-13',NULL),(55,'DEPARTAMENTOSEARCH',15,1,'2018-08-14',NULL),(56,'DEPARTAMENTOUPDATE',15,1,'2018-08-14',NULL),(57,'DEPARTAMENTODELETE',15,1,'2018-08-14',NULL),(58,'DEPARTAMENTOCREATE',15,1,'2018-08-14',NULL),(59,'EMPRESASEARCH',19,1,'2018-08-14',NULL),(60,'EMPRESAUPDATE',19,1,'2018-08-14',NULL),(61,'EMPRESADELETE',19,1,'2018-08-14',NULL),(62,'EMPRESACREATE',19,1,'2018-08-14',NULL),(63,'PLANTASEARCH',20,1,'2018-08-14',NULL),(64,'PLANTAUPDATE',20,1,'2018-08-14',NULL),(65,'PLANTADELETE',20,1,'2018-08-14',NULL),(66,'PLANTACREATE',20,1,'2018-08-14',NULL),(67,'TASADEINTERESSEARCH',21,1,'2018-08-14',NULL),(68,'TASADEINTERESUPDATE',21,1,'2018-08-14',NULL),(69,'TASADEINTERESDELETE',21,1,'2018-08-14',NULL),(70,'TASADEINTERESCREATE',21,1,'2018-08-14',NULL),(71,'SOCIOSEARCH',25,1,'2018-08-15',NULL),(72,'SOCIOUPDATE',25,1,'2018-08-15',NULL),(73,'SOCIODELETE',25,1,'2018-08-15',NULL),(74,'SOCIOCREATE',25,1,'2018-08-15',NULL),(75,'PERFILSEARCH',26,1,'2018-08-15',NULL),(76,'PERFILUPDATE',26,1,'2018-08-15',NULL),(77,'PERFILDELETE',26,1,'2018-08-15',NULL),(78,'PERFILCREATE',26,1,'2018-08-15',NULL),(79,'INTERESSEARCH',27,1,'2018-08-15',NULL),(80,'INTERESUPDATE',27,1,'2018-08-15',NULL),(81,'INTERESDELETE',27,1,'2018-08-15',NULL),(82,'INTERESCREATE',27,1,'2018-08-15',NULL),(83,'DOMICILIOSEARCH',28,1,'2018-08-15',NULL),(84,'DOMICILIOUPDATE',28,1,'2018-08-15',NULL),(85,'DOMICILIODELETE',28,1,'2018-08-15',NULL),(86,'DOMICILIOCREATE',28,1,'2018-08-15',NULL),(88,'BENEFICIARIOSEARCH',29,1,'2018-08-15',NULL),(89,'BENEFICIARIOUPDATE',29,1,'2018-08-15',NULL),(90,'BENEFICIARIODELETE',29,1,'2018-08-15',NULL),(91,'BENEFICIARIOCREATE',29,1,'2018-08-15',NULL),(92,'CUENTABANCARIASEARCH',30,1,'2018-08-16',NULL),(93,'CUENTABANCARIAUPDATE',30,1,'2018-08-16',NULL),(94,'CUENTABANCARIADELETE',30,1,'2018-08-16',NULL),(95,'CUENTABANCARIACREATE',30,1,'2018-08-16',NULL),(96,'ORDENSIMPLIFICADASEARCH',31,1,'2018-08-31',NULL),(97,'ORDENSIMPLIFICADAUPDATE',31,1,'2018-08-31',NULL),(98,'ORDENSIMPLIFICADADELETE',31,1,'2018-08-31',NULL),(99,'ORDENSIMPLIFICADACREATE',31,1,'2018-08-31',NULL),(100,'OPERADORPRODUCCIONSEARCH',32,1,'2018-08-31',NULL),(101,'OPERADORPRODUCCIONUPDATE',32,1,'2018-08-31',NULL),(102,'OPERADORPRODUCCIONDELETE',32,1,'2018-08-31',NULL),(103,'OPERADORPRODUCCIONCREATE',32,1,'2018-08-31',NULL),(104,'ETIQUETAASIGNADASEARCH',33,1,'2018-08-31',NULL),(105,'ETIQUETAASIGNADAUPDATE',33,1,'2018-08-31',NULL),(106,'ETIQUETAASIGNADADELETE',33,1,'2018-08-31',NULL),(107,'ETIQUETAASIGNADACREATE',33,1,'2018-08-31',NULL),(108,'CLIENTESEARCH',34,1,'2018-08-31',NULL),(109,'CLIENTEUPDATE',34,1,'2018-08-31',NULL),(110,'CLIENTEDELETE',34,1,'2018-08-31',NULL),(111,'CLIENTECREATE',34,1,'2018-08-31',NULL),(112,'AFILIADOSEARCH',35,1,'2018-10-01',NULL),(113,'AFILIADOUPDATE',35,1,'2018-10-01',NULL),(114,'AFILIADODELETE',35,1,'2018-10-01',NULL),(115,'AFILIADOCREATE',35,1,'2018-10-01',NULL),(116,'TIPOPENSIONSEARCH',38,1,'2018-10-01',NULL),(117,'TIPOPENSIONUPDATE',38,1,'2018-10-01',NULL),(118,'TIPOPENSIONDELETE',38,1,'2018-10-01',NULL),(119,'TIPOPENSIONCREATE',38,1,'2018-10-01',NULL),(124,'SOLICITUDPENSIONSEARCH',39,1,'2018-10-01',NULL),(125,'SOLICITUDPENSIONDELETE',39,1,'2018-10-01',NULL),(126,'SOLICITUDPENSIONCREATE',39,1,'2018-10-01',NULL),(127,'SOLICITUDPENSIONUPDATE',39,1,'2018-10-01',NULL),(128,'USUARIOSEARCH',40,1,'2018-10-10',NULL),(129,'USUARIOUPDATE',40,1,'2018-10-10',NULL),(130,'USUARIODELETE',40,1,'2018-10-10',NULL),(131,'USUARIOCREATE',40,1,'2018-10-10',NULL),(132,'TRAYECTORIASEARCH',41,1,'2018-10-10',NULL),(133,'TRAYECTORIAUPDATE',41,1,'2018-10-10',NULL),(134,'TRAYECTORIADELETE',41,1,'2018-10-10',NULL),(135,'TRAYECTORIACREATE',41,1,'2018-10-10',NULL),(136,'SOLICITUDSEARCH',42,1,'2018-10-10',NULL),(137,'SOLICITUDUPDATE',42,1,'2018-10-10',NULL),(138,'SOLICITUDDELETE',42,1,'2018-10-10',NULL),(139,'SOLICITUDCREATE',42,1,'2018-10-10',NULL),(140,'ROLSEARCH',43,1,'2018-10-10',NULL),(141,'ROLUPDATE',43,1,'2018-10-10',NULL),(142,'ROLDELETE',43,1,'2018-10-10',NULL),(143,'ROLCREATE',43,1,'2018-10-10',NULL),(144,'RECLUTADORSEARCH',44,1,'2018-10-10',NULL),(145,'RECLUTADORUPDATE',44,1,'2018-10-10',NULL),(146,'RECLUTADORDELETE',44,1,'2018-10-10',NULL),(147,'RECLUTADORCREATE',44,1,'2018-10-10',NULL),(148,'PUESTOSEARCH',46,1,'2018-10-10',NULL),(149,'PUESTOUPDATE',46,1,'2018-10-10',NULL),(150,'PUESTODELETE',46,1,'2018-10-10',NULL),(151,'PUESTOCREATE',46,1,'2018-10-10',NULL),(152,'POSICIONSEARCH',47,1,'2018-10-10',NULL),(153,'POSICIONUPDATE',47,1,'2018-10-10',NULL),(154,'POSICIONDELETE',47,1,'2018-10-10',NULL),(155,'POSICIONCREATE',47,1,'2018-10-10',NULL),(156,'PERMISOSEARCH',48,1,'2018-10-10',NULL),(157,'PERMISOUPDATE',48,1,'2018-10-10',NULL),(158,'PERMISODELETE',48,1,'2018-10-10',NULL),(159,'PERMISOCREATE',48,1,'2018-10-10',NULL),(160,'FILIALSEARCH',49,1,'2018-10-10',NULL),(161,'FILIALUPDATE',49,1,'2018-10-10',NULL),(162,'FILIALDELETE',49,1,'2018-10-10',NULL),(163,'FILIALCREATE',49,1,'2018-10-10',NULL),(164,'EVENTOSEARCH',50,1,'2018-10-10',NULL),(165,'EVENTOUPDATE',50,1,'2018-10-10',NULL),(166,'EVENTODELETE',50,1,'2018-10-10',NULL),(167,'EVENTOCREATE',50,1,'2018-10-10',NULL),(168,'DOCUMENTOSEARCH',51,1,'2018-10-10',NULL),(169,'DOCUMENTOUPDATE',51,1,'2018-10-10',NULL),(170,'DOCUMENTODELETE',51,1,'2018-10-10',NULL),(171,'DOCUMENTOCREATE',51,1,'2018-10-10',NULL),(172,'DIRECCIONSEARCH',52,1,'2018-10-10',NULL),(173,'DIRECCIONUPDATE',52,1,'2018-10-10',NULL),(174,'DIRECCIONDELETE',52,1,'2018-10-10',NULL),(175,'DIRECCIONCREATE',52,1,'2018-10-10',NULL),(176,'CANDIDATOSEARCH',53,1,'2018-10-10',NULL),(177,'CANDIDATOUPDATE',53,1,'2018-10-10',NULL),(178,'CANDIDATODELETE',53,1,'2018-10-10',NULL),(179,'CANDIDATOCREATE',53,1,'2018-10-10',NULL);
/*!40000 ALTER TABLE `privilege` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puesto`
--

DROP TABLE IF EXISTS `puesto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `puesto` (
  `descripcion` varchar(100) DEFAULT NULL,
  `puestosId` varchar(100) DEFAULT NULL,
  `puestoId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`puestoId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puesto`
--

LOCK TABLES `puesto` WRITE;
/*!40000 ALTER TABLE `puesto` DISABLE KEYS */;
INSERT INTO `puesto` VALUES ('Descripción del puesto de Promotor de Cambaceo','a',1),('Descripción del puesto de Valuador','b',2),('Descripción del puesto de Mecanógrafo','c',3),('Descripción del puesto de Expendedor','d',4),('puesto de Almacenista','e',5),('Descripción del puesto de Mozo','f',6),('Descripción del puesto de Cajero','g',7),('Ninguna','a',8),('Conoce la ciudad. Experiencia en cambaceo de joyería y electrónica. ','a',12),('Puesto Cajero - Prueba Monte de Piedad','g',13),('Puesto Mozo - Prueba','f',14);
/*!40000 ALTER TABLE `puesto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reclutador`
--

DROP TABLE IF EXISTS `reclutador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reclutador` (
  `apellidomaterno` varchar(100) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `apellidopaterno` varchar(100) DEFAULT NULL,
  `generoId` varchar(100) DEFAULT NULL,
  `reclutadorId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`reclutadorId`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reclutador`
--

LOCK TABLES `reclutador` WRITE;
/*!40000 ALTER TABLE `reclutador` DISABLE KEYS */;
INSERT INTO `reclutador` VALUES ('Muñiz','Alejandro','Hernandez','mas',2),('Dominguez','Adriana','Velazquez','fem',3),('test','Adriana','test','fem',4),('Martinez','Pedro ','Lopez','mas',5),('Garza','Roberto ','Martínez ','mas',6),('automatizador','jose','tester','mas',9),('automatizador','jose','tester','mas',10),('Auto','Jose','Tester','mas',14),('Auto','Jose','Tester','mas',15),('Hdz','JJAH','Alvarado','mas',16),('tester','jose','perez','mas',17),('Automatizador ','Jose','Tester','mas',18),('Ruiz ','Alejandro ','García ','fem',19),('Automatizado','Jos','Teste','mas',20);
/*!40000 ALTER TABLE `reclutador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rol` (
  `activo` int(11) DEFAULT NULL,
  `clave` int(11) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `rolId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`rolId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,1,'Test',1);
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
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
-- Table structure for table `solicitud`
--

DROP TABLE IF EXISTS `solicitud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `solicitud` (
  `salario` decimal(10,0) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `telefono` varchar(100) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `posicionId` int(11) DEFAULT NULL,
  `candidatoId` int(11) DEFAULT NULL,
  `estatussolicitudId` varchar(100) DEFAULT NULL,
  `solicitudId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`solicitudId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitud`
--

LOCK TABLES `solicitud` WRITE;
/*!40000 ALTER TABLE `solicitud` DISABLE KEYS */;
INSERT INTO `solicitud` VALUES (30000,'javier@afiliado.com','5512345678','2018-10-28',1,2,'e1',2),(9000,'Rulo@nomebusques.com.mx','45555555','2018-10-22',3,2,'e2',3),(5000,'jjah@stk.com','123457890','2018-10-10',2,22,'e1',5),(300000,'asdasd@asdasd.com','2121212','2018-12-08',1,23,'e1',6);
/*!40000 ALTER TABLE `solicitud` ENABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipopension`
--

LOCK TABLES `tipopension` WRITE;
/*!40000 ALTER TABLE `tipopension` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipopension` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trayectoria`
--

DROP TABLE IF EXISTS `trayectoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trayectoria` (
  `clave` varchar(100) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `candidatoId` int(11) DEFAULT NULL,
  `tipotrayectoriaId` varchar(100) DEFAULT NULL,
  `documentoId` int(11) DEFAULT NULL,
  `trayectoriaId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`trayectoriaId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trayectoria`
--

LOCK TABLES `trayectoria` WRITE;
/*!40000 ALTER TABLE `trayectoria` DISABLE KEYS */;
INSERT INTO `trayectoria` VALUES ('io','gamer ',2,'e',4,1),('ventas','Curso ventas',22,'g',4,3);
/*!40000 ALTER TABLE `trayectoria` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi','Normaysel','Carbajal','normaysel.carbajal@softtek.com',1,NULL,'2018-11-13','2018-06-25',NULL),(2,'user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','Javier','Aguilar','javieraguilar@softtek.com',1,NULL,'2018-07-15','2018-07-18','2018-07-18'),(3,'test','$2a$10$SdTyWGY5rKgWQWEI.FgX/ujMVVwt1T45fI3t1a4/VT/vd89A8zi4a','Juan','Perez','juanperez@softtek.com',1,NULL,'2018-07-07','2018-07-03',NULL),(8,'jaas79','$2a$10$4NYOvd/pyX86Z03r3nCn/ezNbVtOwStCfkzgGQ84KHSPSQ3ku4MQ.','Javier','Aguilar','javier.aguilar@softtek.com',1,NULL,'2018-07-09','2018-07-09','2018-07-09'),(21,'user-rol-disabled','$2a$10$daY8gikhmfnkGwXqBUJfxugHjd49xv4w3xqwBNXXDNQPOuf92aZ/i','User','Rol Disabled','user.disabled@email.com',1,NULL,'2018-06-13','2018-07-13',NULL),(22,'Normaysel','$2a$10$mWWqKl/gcVRuxnHnKfkky.vfkmvrxBWopW0HLyUD8HjF1fbHjRQtS','Normaysel','Carbajal','alexydiego@gmail.com',1,NULL,'2018-06-24','2018-07-24',NULL),(27,'Reclutador','$2a$10$Rcn0okKKuID/Y03Jbr/9Wuuxx4g1YZPYso6TIranbg/O9cpvDYATa','Usuario para pruebas','reclutador','reclutador@softtek.com',1,NULL,'2018-09-24','2018-10-22','2018-10-22'),(28,'Candidato','$2a$10$WFSEoQOM47QC2Z8PvzlQNeH9qi8Ov1gWnUvYeq51/FX33mKjUIeCG','Usuario para pruebas 2','candidato','candidato@softtek.com',1,NULL,'2018-11-13','2018-10-22',NULL),(29,'Administrador','$2a$10$HH2OkZcc64D43h5Q139E1enDQnVoWeLDW/hg1jJ0RegTZWfojt0Uq','Administrador','del sistema','administrador@softtek.com',1,NULL,'2018-11-13','2018-10-23','2018-10-23');
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
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_authority`
--

LOCK TABLES `user_authority` WRITE;
/*!40000 ALTER TABLE `user_authority` DISABLE KEYS */;
INSERT INTO `user_authority` VALUES (1,1,1,1),(21,8,67,1),(2,2,73,1),(22,2,74,1),(28,2,80,1),(27,4,81,1),(29,3,83,1);
/*!40000 ALTER TABLE `user_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `activo` int(11) DEFAULT NULL,
  `nombreclave` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `rolId` int(11) DEFAULT NULL,
  `usuarioId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`usuarioId`),
  KEY `rolId_idx` (`rolId`),
  CONSTRAINT `rolId` FOREIGN KEY (`rolId`) REFERENCES `rol` (`rolId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
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

-- Dump completed on 2018-12-13 10:32:40
