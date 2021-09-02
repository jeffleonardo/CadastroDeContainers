-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: dbcontainer
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `container`
--

DROP TABLE IF EXISTS `container`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `container` (
  `id` int NOT NULL AUTO_INCREMENT,
  `numContainer` varchar(12) DEFAULT NULL,
  `nomeCliente` varchar(50) NOT NULL,
  `tipo` varchar(2) NOT NULL,
  `statusAtual` varchar(5) DEFAULT NULL,
  `categoria` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `container`
--

LOCK TABLES `container` WRITE;
/*!40000 ALTER TABLE `container` DISABLE KEYS */;
INSERT INTO `container` VALUES (1,'lili1478529','miguel','40','Vazio','Exportacao'),(2,'jefa1784594','HamburgerSud','40','Vazio','Exportacao'),(3,'kaka1234567','livia','20','Vazio','Importacao'),(4,'otav1457845','otavio','40','Vazio','Importacao'),(5,'erik1234567','HamburgerSud','40','Cheio','Exportacao'),(6,'erik1234567','vasefude','40','Vazio','Importacao'),(7,'erik1234567','teste3','40','Vazio','Exportacao'),(8,'tutu1781594','arthur','20','Vazio','Exportacao'),(9,'test1784592','testeInput','20','Cheio','Importacao'),(10,'livi2468579','relatorio','40','Cheio','Importacao'),(11,'jefa1784594','teste3','40','Vazio','Importacao'),(12,'erik1234567','HamburgerSud','40','Cheio','Importacao'),(13,'sant1478523','santos','40','Vazio','Exportacao');
/*!40000 ALTER TABLE `container` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-01 22:38:56
