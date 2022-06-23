-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: web_dam_hoi
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `email` varchar(250) NOT NULL,
  `password` varchar(250) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('ka@gmail.com','1'),('quang@gmail.com','1'),('trung@gmail.com','1');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `billexport`
--

DROP TABLE IF EXISTS `billexport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `billexport` (
  `id` int NOT NULL AUTO_INCREMENT,
  `note` text,
  `total` int NOT NULL,
  `created_at` datetime NOT NULL,
  `id_staff_created` int NOT NULL,
  `updated_at` datetime NOT NULL,
  `id_staff_updated` int NOT NULL,
  `id_custom` int NOT NULL,
  `id_carrier` int NOT NULL,
  `time_start_borrowed` date NOT NULL,
  `time_end_borrowed` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_custom` (`id_custom`),
  KEY `id_staff_created` (`id_staff_created`),
  KEY `id_staff_updated` (`id_staff_updated`),
  KEY `id_carrier` (`id_carrier`),
  CONSTRAINT `billexport_ibfk_2` FOREIGN KEY (`id_staff_created`) REFERENCES `staff` (`id`),
  CONSTRAINT `billexport_ibfk_3` FOREIGN KEY (`id_staff_updated`) REFERENCES `staff` (`id`),
  CONSTRAINT `billexport_ibfk_4` FOREIGN KEY (`id_carrier`) REFERENCES `staff` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billexport`
--

LOCK TABLES `billexport` WRITE;
/*!40000 ALTER TABLE `billexport` DISABLE KEYS */;
INSERT INTO `billexport` VALUES (4,NULL,0,'2022-06-21 01:17:56',5,'2022-06-21 01:17:56',5,1,8,'2000-12-14','2000-12-16'),(9,'',20000,'2022-06-22 06:06:55',5,'2022-06-23 12:26:19',5,2,8,'2000-12-12','2000-12-14'),(10,'',10000,'2022-06-23 07:54:39',5,'2022-06-23 01:27:25',5,2,8,'2000-02-01','2000-01-01');
/*!40000 ALTER TABLE `billexport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `billexport_detail`
--

DROP TABLE IF EXISTS `billexport_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `billexport_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_product` int NOT NULL,
  `id_billexport` int NOT NULL,
  `count` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_billexport` (`id_billexport`),
  KEY `id_product` (`id_product`),
  CONSTRAINT `billexport_detail_ibfk_1` FOREIGN KEY (`id_billexport`) REFERENCES `billexport` (`id`),
  CONSTRAINT `billexport_detail_ibfk_2` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billexport_detail`
--

LOCK TABLES `billexport_detail` WRITE;
/*!40000 ALTER TABLE `billexport_detail` DISABLE KEYS */;
INSERT INTO `billexport_detail` VALUES (4,3,9,2),(5,3,10,1);
/*!40000 ALTER TABLE `billexport_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `billimport`
--

DROP TABLE IF EXISTS `billimport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `billimport` (
  `id` int NOT NULL AUTO_INCREMENT,
  `total` int NOT NULL,
  `created_at` datetime NOT NULL,
  `id_staff_created` int NOT NULL,
  `updated_at` datetime NOT NULL,
  `id_staff_updated` int NOT NULL,
  `id_supplier` int NOT NULL,
  `id_carrier` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_supplier` (`id_supplier`),
  KEY `id_staff_created` (`id_staff_created`),
  KEY `id_staff_updated` (`id_staff_updated`),
  KEY `id_carrier` (`id_carrier`),
  CONSTRAINT `billimport_ibfk_1` FOREIGN KEY (`id_supplier`) REFERENCES `supplier` (`id`),
  CONSTRAINT `billimport_ibfk_2` FOREIGN KEY (`id_staff_created`) REFERENCES `staff` (`id`),
  CONSTRAINT `billimport_ibfk_3` FOREIGN KEY (`id_staff_updated`) REFERENCES `staff` (`id`),
  CONSTRAINT `billimport_ibfk_4` FOREIGN KEY (`id_carrier`) REFERENCES `staff` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billimport`
--

LOCK TABLES `billimport` WRITE;
/*!40000 ALTER TABLE `billimport` DISABLE KEYS */;
INSERT INTO `billimport` VALUES (1,0,'2022-06-22 12:55:24',5,'2022-06-22 10:17:59',5,1,8),(2,180000,'2022-06-22 12:55:31',5,'2022-06-23 12:06:43',5,2,8),(6,100000,'2022-06-23 07:55:56',5,'2022-06-23 07:56:17',5,2,8);
/*!40000 ALTER TABLE `billimport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `billimport_detail`
--

DROP TABLE IF EXISTS `billimport_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `billimport_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_billimport` int NOT NULL,
  `id_product` int NOT NULL,
  `price` int NOT NULL,
  `count` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_billimport` (`id_billimport`),
  KEY `id_product` (`id_product`),
  CONSTRAINT `billimport_detail_ibfk_1` FOREIGN KEY (`id_billimport`) REFERENCES `billimport` (`id`),
  CONSTRAINT `billimport_detail_ibfk_2` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billimport_detail`
--

LOCK TABLES `billimport_detail` WRITE;
/*!40000 ALTER TABLE `billimport_detail` DISABLE KEYS */;
INSERT INTO `billimport_detail` VALUES (6,2,3,20000,3),(7,2,4,30000,4),(8,6,3,20000,5);
/*!40000 ALTER TABLE `billimport_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Bàn ghế'),(2,'Phông bạt');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `custom`
--

DROP TABLE IF EXISTS `custom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `custom` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fullname` varchar(100) NOT NULL,
  `gender` varchar(25) NOT NULL,
  `email` varchar(250) NOT NULL,
  `phoneNumber` varchar(50) NOT NULL,
  `address` varchar(250) NOT NULL,
  `created_at` datetime NOT NULL,
  `id_staff_created` int NOT NULL,
  `updated_at` datetime NOT NULL,
  `id_staff_updated` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_staff_created` (`id_staff_created`),
  KEY `id_staff_updated` (`id_staff_updated`),
  CONSTRAINT `custom_ibfk_1` FOREIGN KEY (`id_staff_created`) REFERENCES `staff` (`id`),
  CONSTRAINT `custom_ibfk_2` FOREIGN KEY (`id_staff_updated`) REFERENCES `staff` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `custom`
--

LOCK TABLES `custom` WRITE;
/*!40000 ALTER TABLE `custom` DISABLE KEYS */;
INSERT INTO `custom` VALUES (1,'Nguyễn Văn A','Nam','nva@gmail.com','231321','HN','2022-06-21 01:17:56',5,'2022-06-21 01:17:56',5),(2,'Nguyễn Văn B','Nam','nvb@gmail.com','34343','HN','2022-06-22 11:22:30',5,'2022-06-22 11:47:55',5);
/*!40000 ALTER TABLE `custom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category_id` int NOT NULL,
  `title` varchar(250) NOT NULL,
  `description` varchar(500) NOT NULL,
  `linkimage` text NOT NULL,
  `price` int NOT NULL,
  `count` int NOT NULL,
  `created_at` datetime NOT NULL,
  `id_staff_created` int NOT NULL,
  `updated_at` datetime NOT NULL,
  `id_staff_updated` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_staff_created` (`id_staff_created`),
  KEY `id_staff_updated` (`id_staff_updated`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`id_staff_created`) REFERENCES `staff` (`id`),
  CONSTRAINT `product_ibfk_2` FOREIGN KEY (`id_staff_updated`) REFERENCES `staff` (`id`),
  CONSTRAINT `product_ibfk_3` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (3,1,'Bàn ghế Louis 2','Bàn ghế','C:\\Users\\Dell\\Downloads\\Cac-hinh-anh-ban-ghe-go-phong-khach-dep-1.jpg',10000,5,'2022-06-19 11:54:53',5,'2022-06-23 07:56:17',5),(4,1,'Bàn ghế Louis 1','Bàn ghế','C:\\Users\\Dell\\Downloads\\ban_ghe.jpg',50000,4,'2022-06-22 11:54:19',5,'2022-06-23 01:45:39',5),(5,1,'Bàn ghế Louis 3','Bàn ghế','C:\\Users\\Dell\\Downloads\\Cac-hinh-anh-ban-ghe-go-phong-khach-dep-1.jpg',60000,0,'2022-06-23 08:40:37',5,'2022-06-23 08:41:14',5);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Quản lý'),(2,'Nhân viên tư vấn khách hàng'),(3,'Nhân viên kho'),(4,'Nhân viên giao hàng');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fullname` varchar(100) NOT NULL,
  `gender` varchar(25) NOT NULL,
  `email` varchar(250) NOT NULL,
  `phoneNumber` varchar(50) NOT NULL,
  `address` varchar(250) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `role_id` int NOT NULL,
  `status` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  KEY `email` (`email`),
  CONSTRAINT `staff_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `staff_ibfk_2` FOREIGN KEY (`email`) REFERENCES `account` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (5,'Trung','Nam','trung@gmail.com','3213','31312','2000-12-12 01:01:01','2000-12-12 01:01:01',1,'Đang làm'),(7,'Nguyễn Hồng Quang','Nam','quang@gmail.com','2313131','VP','2022-06-20 10:22:32','2022-06-20 10:22:32',2,'Đang làm'),(8,'Nguyễn Thị Kim Anh','Nữ','ka@gmail.com','4342342','TB','2022-06-20 10:24:58','2022-06-22 10:17:50',4,'Đang làm');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `phoneNumber` int NOT NULL,
  `email` varchar(250) NOT NULL,
  `address` varchar(500) NOT NULL,
  `created_at` datetime NOT NULL,
  `id_staff_created` int NOT NULL,
  `updated_at` datetime NOT NULL,
  `id_staff_updated` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_staff_created` (`id_staff_created`),
  KEY `id_staff_updated` (`id_staff_updated`),
  CONSTRAINT `supplier_ibfk_1` FOREIGN KEY (`id_staff_created`) REFERENCES `staff` (`id`),
  CONSTRAINT `supplier_ibfk_2` FOREIGN KEY (`id_staff_updated`) REFERENCES `staff` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES (1,'Bàn ghế DD',232312,'dd@gmail.com','HP','2022-06-21 07:10:09',5,'2022-06-21 07:13:42',5),(2,'Bàn ghế AA',321321,'aa@gmail.com','HN','2022-06-22 11:57:29',5,'2022-06-22 11:57:29',5);
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-23 23:16:25
