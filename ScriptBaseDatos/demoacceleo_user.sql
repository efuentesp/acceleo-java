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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi','Normaysel','Carbajal','normaysel.carbajal@softtek.com',1,NULL,'2018-07-03','2018-06-25',NULL),(2,'user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','Javier','Aguilar','javieraguilar@softtek.com',1,NULL,'2018-07-03','2018-07-18','2018-07-18'),(3,'test','$2a$10$SdTyWGY5rKgWQWEI.FgX/ujMVVwt1T45fI3t1a4/VT/vd89A8zi4a','Juan','Perez','juanperez@softtek.com',1,NULL,'2018-07-07','2018-07-03',NULL),(6,'test2','$2a$10$vbxCj7sR6HvHSMEqtScfb.8gRtOLyR3W7edDLHBHqE5eETgrsiZD.','Marcos','Carrillo','marcos@softtek.com',1,NULL,'2018-07-13','2018-07-13','2018-07-13'),(8,'jaas79','$2a$10$4NYOvd/pyX86Z03r3nCn/ezNbVtOwStCfkzgGQ84KHSPSQ3ku4MQ.','Javier','Aguilar','javier.aguilar@softtek.com',1,NULL,'2018-07-09','2018-07-09','2018-07-09'),(21,'user-rol-disabled','$2a$10$daY8gikhmfnkGwXqBUJfxugHjd49xv4w3xqwBNXXDNQPOuf92aZ/i','User','Rol Disabled','user.disabled@email.com',1,NULL,'2018-06-13','2018-07-13',NULL),(22,'Normaysel','$2a$10$mWWqKl/gcVRuxnHnKfkky.vfkmvrxBWopW0HLyUD8HjF1fbHjRQtS','Normaysel','Carbajal','alexydiego@gmail.com',1,NULL,'2018-06-24','2018-07-24',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-06 12:00:14