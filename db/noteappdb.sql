CREATE DATABASE  IF NOT EXISTS `noteapp` /*!40100 DEFAULT CHARACTER SET utf8mb3 COLLATE utf8mb3_swedish_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `noteapp`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: noteapp
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `note`
--

DROP TABLE IF EXISTS `note`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `note` (
  `note_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `note_title` varchar(45) COLLATE utf8mb3_swedish_ci DEFAULT NULL,
  `note_content` text COLLATE utf8mb3_swedish_ci,
  `created_at` date DEFAULT NULL,
  `updated_at` date DEFAULT NULL,
  `is_marked` int DEFAULT NULL,
  PRIMARY KEY (`note_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `note`
--

LOCK TABLES `note` WRITE;
/*!40000 ALTER TABLE `note` DISABLE KEYS */;
INSERT INTO `note` VALUES (1,6,'Chủ đề 1 đã sửa','Nội dung 1','2024-07-31','2024-08-01',0),(2,6,'Chủ đề 2','Nội dung 2','2024-07-31','2024-07-31',0),(3,6,'Chủ đề 3','Nội dung 3','2024-08-20','2024-08-20',0),(4,6,'Chủ đề 4','Nội dung 4','2024-08-20','2024-08-20',0),(5,6,'Chủ đề 5','Nội dung 5','2024-08-20','2024-08-20',0),(6,6,'Chủ đề 6','Nội dung 6','2024-08-20','2024-08-20',0),(9,6,'Chủ đề 9','Nội dung 9','2024-09-20','2024-09-20',0),(10,6,'Chủ đề 10','Nội dung 10','2024-09-20','2024-09-20',1),(11,6,'Chủ đề 11','Nội dung 11','2024-09-20','2024-09-20',0),(12,6,'Chủ đề 12','Nội dung 12','2024-09-20','2024-09-20',0),(13,6,'Chủ đề 13','Nội dung 13','2024-09-20','2024-09-20',1),(19,6,'Chủ đề 19','Nội dung 19 sửa','2024-10-10','2024-08-01',1),(20,6,'Chủ đề 20','Nội dung 20','2024-10-10','2024-10-10',0),(21,6,'Chủ đề 21','Nội dung 21','2024-10-10','2024-10-10',0),(22,6,'Chủ đề 22','Nội dung 22','2024-08-01','2024-08-01',1),(23,6,'Chủ đề 23Chủ đề 23Chủ đề 23Chủ đề 23','Nội dung 23Nội dung 23Nội dung 23Nội dung 23Nội dung 23Nội dung 23Nội dung 23\r\nNội dung 23\r\nNội dung 23\r\nNội dung 23\r\nNội dung 23\r\nNội dung 23','2024-08-01','2024-08-01',0),(24,6,'Ghi chú 18','Nội\r\ndung \r\n18','2024-08-01','2024-08-01',0),(25,6,'Ghi chú 19 mới nhất','ok','2024-08-01','2024-08-01',0);
/*!40000 ALTER TABLE `note` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) COLLATE utf8mb3_swedish_ci DEFAULT NULL,
  `user_password` varchar(100) COLLATE utf8mb3_swedish_ci DEFAULT NULL,
  `user_email` varchar(45) COLLATE utf8mb3_swedish_ci DEFAULT NULL,
  `created_at` date NOT NULL,
  PRIMARY KEY (`user_id`,`created_at`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'user1','123456','user1@gmail.com','2024-07-31'),(2,'user2','123456','user2@gmail.com','2024-07-31'),(6,'user3','$2a$10$6qFp8d3monuydO4vVb9SmuUqMRsDRjG.hVT2hrvyfJ9EgT4AHpUMu','user3@gmail.com','2024-08-05'),(7,'user4','$2a$10$VEBzcG0oRzVz9WO.VH5bxeB3d9gNg9II7du7SGTrSYFL5PXMMg9M2','user4@gmail.com','2024-08-05');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-07 11:29:12
