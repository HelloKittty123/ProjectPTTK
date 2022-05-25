-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: web_dam_cuoi
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
-- Table structure for table `bill_export`
--

DROP TABLE IF EXISTS `bill_export`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill_export` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_id` int DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `id_create_staff` int DEFAULT NULL,
  `id_carrier` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  KEY `id_create_staff` (`id_create_staff`),
  KEY `id_carrier` (`id_carrier`),
  CONSTRAINT `bill_export_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `bill_export_ibfk_2` FOREIGN KEY (`id_create_staff`) REFERENCES `user` (`id`),
  CONSTRAINT `bill_export_ibfk_3` FOREIGN KEY (`id_carrier`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill_export`
--

LOCK TABLES `bill_export` WRITE;
/*!40000 ALTER TABLE `bill_export` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill_export` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill_import`
--

DROP TABLE IF EXISTS `bill_import`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill_import` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_product` int DEFAULT NULL,
  `count` int DEFAULT NULL,
  `id_supplier` int DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `id_create_staff` int DEFAULT NULL,
  `id_carrier` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_product` (`id_product`),
  KEY `id_supplier` (`id_supplier`),
  CONSTRAINT `bill_import_ibfk_1` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`),
  CONSTRAINT `bill_import_ibfk_2` FOREIGN KEY (`id_supplier`) REFERENCES `supplier` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill_import`
--

LOCK TABLES `bill_import` WRITE;
/*!40000 ALTER TABLE `bill_import` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill_import` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `h4_content` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `h5_content` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (44,'Bàn Ghế','AABC12','Cưới hỏi trọn gói abc với sự đầu tư 100% bàn ghế đám cưới mới phục vụ cưới hỏi, cùng với kinh nghiệm lâu năm trong lĩnh vực cưới hỏi trọn gói và tổ chức sự kiện, đã tạo được uy tín với khách hàng quanh khu vực phía Bắc, đặc biệt là tại Hà Nội. Hiện nay chúng tôi đang cung cấp và cho thuê bàn ghế cưới hỏi với nhiều tông màu cùng với rất nhiều kiểu dáng khác nhau đáp ứng mọi nhu cầu của quý khách.'),(46,'Phông Bạt','aaaa','aaaa');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_user` int DEFAULT NULL,
  `note` varchar(500) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_user` (`id_user`),
  CONSTRAINT `feedback_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_user`
--

DROP TABLE IF EXISTS `order_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `count` int DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_user`
--

LOCK TABLES `order_user` WRITE;
/*!40000 ALTER TABLE `order_user` DISABLE KEYS */;
INSERT INTO `order_user` VALUES (26,56,41,1,1),(28,56,62,1,1),(29,56,1,1,1),(30,61,1,1,0),(31,61,78,1,0),(32,61,79,1,0),(33,65,1,1,1),(34,65,1,3,1);
/*!40000 ALTER TABLE `order_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `fullname` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone_number` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `address` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `note` varchar(250) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `total` int DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (27,65,'Nguyễn Thị Kim Anh','434343','ka1510@gmail.com','21212','2121',2360000,'2022-05-24 19:26:23',0);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category_id` int DEFAULT NULL,
  `title` varchar(350) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` int DEFAULT NULL,
  `thumbnail` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` longtext CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `count` int DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,44,'Bàn ghế Louis',590000,'https://cuoihoihoangquan.vn/wp-content/uploads/2020/02/IMG_0313-1030x772.jpg','<ul style=\"padding-left: 30px;\">\n<li style=\"padding: 10px 0;\">1 bộ bao gồm 1 bàn 6 ghế: <span style=\"color: #b02b2c;\">500.000/bộ</span></li>\n<li style=\"padding: 10px 0;\">1 bộ ấm chén VIP có hoa văn bao gồm 1 ấm – 6 chén tách – 1 đĩa bánh kẹo ba tầng – 1 gạt tàn: <span style=\"color: #b02b2c;\">50.000/bộ</span></li>\n<li style=\"padding: 10px 0;\">Hoa lụa để bàn : <span style=\"color: #b02b2c;\">40.000/bàn</span></li>\n</ul>\n</br>Ghế này được làm theo lệnh của vua Louis XVI mang phong cách tân cổ điển Pháp có lưng ghế hình bầu dục và thường có đệm nhung hoặc đệm vải lanh tự nhiên. Ghế Louis hướng đến phục vụ trong những nhà hàng, hội nghị, sự kiện cưới sang trọng.',NULL,NULL,NULL),(24,44,'Bàn ghế Chiavari',540000,'https://cuoihoihoangquan.vn/wp-content/uploads/2020/02/IMG_0648-1030x772.jpg','<ul style=\"padding-left : 30px;\">\n	<li style=\"padding: 10px 0;\">1 bộ bao gồm 1 bàn 6 ghế và decor trang trí ghế : <span style=\"color: #b02b2c;\">300.000/bộ</span></li>\n	<li style=\"padding: 10px 0;\">1 bộ ấm chén thường bao gồm 1 ấm – 6 chén tách – 1 đĩa bánh kẹo ba tầng – 1 gạt tàn: <span style=\"color: #b02b2c;\">30.000/bộ</span></li>\n	<li style=\"padding: 10px 0;\">1 bộ ấm chén VIP có hoa văn bao gồm 1 ấm – 6 chén tách – 1 đĩa bánh kẹo ba tầng – 1 gạt tàn: <span style=\"color: #b02b2c;\">50.000/bộ</span></li>\n	<li style=\"padding: 10px 0;\">Hoa lụa để bàn : <span style=\"color: #b02b2c;\">40.000/bàn</span></li>\n	</ul> </br>\n<strong  style=\"color: #b02b2c;\">Ghế Chiavari</strong> hay còn gọi là <span style=\"color: #b02b2c;\"><strong> ghế Tiffany</strong></span> là loại ghế chuyên sử dụng trong các loại tiệc và đám cưới đẳng cấp. Ưu điểm của loại ghế Chiavari là ghế có thiết kế rất đẹp, phù hợp với cả phong cách tiệc cưới thanh lịch hiện đại.\r</br> \r Trang trí: <strong  style=\"color: #b02b2c;\">Ghế Chiavari</strong> để trần không trang trí gì lẫn kết hợp với các loại phụ kiện như hoa, phale, ruy băng đều đẹp và tôn không gian phòng tiệc cưới lên rất nhiều.',NULL,NULL,NULL),(58,44,'Bàn tròn – Ghế Chiavary ',760000,'https://cuoihoihoangquan.vn/wp-content/uploads/2020/10/IMG_0377.jpg','<ul style =\"padding-left: 30px;\">\n	<li style=\"padding: 10px 0;\">1 bộ bao gồm 1 bàn tron 1,2m + 8 ghế và decor trang trí ghế : <span style=\"color: #b02b2c;\">600.000/bộ</span></li>\n	<li style=\"padding: 10px 0;\">1 bộ ấm chén thường bao gồm 1 ấm – 8 chén tách – 1 đĩa bánh kẹo ba tầng – 1 gạt tàn: <span style=\"color:#b02b2c;\">50.000/bộ</span></li>\n	<li style=\"padding: 10px 0;\">1 bộ ấm chén VIP có hoa văn bao gồm 1 ấm – 8 chén tách – 1 đĩa bánh kẹo ba tầng – 1 gạt tàn: <span style=\"color: #b02b2c;\">70.000/bộ</span></li>\n	<li style=\"padding: 10px 0;\">Hoa lụa để bàn : <span style=\"color:#b02b2c;\">40.000/bàn</span></li>\n	</ul>\n</br><span style=\"color:#b02b2c;\"><strong>Ghế Chiavari</strong></span> kết hợp bàn tròn dành cho các bữa tiệc đẳng cấp.',NULL,NULL,NULL),(59,44,'Bàn ghế tựa lưng cao ',320000,'https://cuoihoihoangquan.vn/wp-content/uploads/2020/08/117383720_3105825256139734_5156113698400793552_o-1030x782.jpg','<ul style=\"padding-left: 30px;\">\n<li style=\"padding: 10px 0;\">1 bộ bao gồm 1 bàn 6 ghế đã bao gồm áo nơ : <span style=\"color: #b02b2c;\">200.000/bộ</span></li>\n<li style=\"padding: 10px 0;\">1 Ấm chén bao gồm : 1 ấm – 6 chén tách – đĩa 3 tầng – 1 gạt tàn: <span style=\"color: #b02b2c;\">30.000/bộ</span></li>\n<li style=\"padding: 10px 0;\">1 Ấm chén VIP có hoa văn bao gồm : 1 ấm – 6 chén tách – đĩa 3 tầng – 1 gạt tàn: <span style=\"color: #b02b2c;\">50.000/bộ</span></li>\n<li style=\"padding: 10px 0;\">Hoa lụa để bàn :&nbsp;<span style=\"color: #b02b2c;\">40.000/bàn</span></li>\n</ul>\n</br>Đây là loại ghế thường được sử dụng trong các khách sạn sang trọng và rất được yêu thích sử dụng trong mùa cưới hỏi từ 2017. Ưu điểm của <strong style=\"color: #b02b2c;\">Ghế Banquet</strong> là sự chắc chắn, có đệm êm ái, có tựa lưng cao kết hợp với kiểu dáng tối ưu giúp cho khách mời vô cùng thoải mái khi sử dụng.',NULL,NULL,NULL),(60,44,'Bàn ghế nhựa nơ váy',170000,'https://cuoihoihoangquan.vn/wp-content/uploads/2017/10/faceu_1581407272246-1030x773.jpeg','<ul style=\"padding-left: 30px;\">\n<li style=\"padding: 10px 0;\">1 bộ bao gồm 1 bàn 6 ghế và áo nơ bọc ghế :&nbsp;<span style=\"color: #b02b2c;\">100.000/bộ</span></li>\n<li style=\"padding: 10px 0;\">1 Ấm chén bao gồm 1 ấm 6 chén tách 2 đĩa bánh kẹo 1 gạt tàn:&nbsp;<span style=\"color: #b02b2c;\">30.000/bộ</span></li>\n<li style=\"padding: 10px 0;\">Hoa lụa để bàn :&nbsp;<span style=\"color: #b02b2c;\">40.000/bàn</span></li>\n</ul>\n</br>Với những không gian hẹp và cần nhiều bàn ghế để tiếp khách thì Bàn ghế nhựa áo nơ là sự lựa chọn hoàn hảo cho mọi nhà. Với giá thành rẻ, vận chuyển tiện lợi thi Bàn ghế nhựa áo nơ cũng mang lại nhiều tiện lợi cho khách hàng.',NULL,NULL,NULL),(61,46,'Phông Bạt VIP',2000000,'https://cuoihoihoangquan.vn/wp-content/uploads/2021/12/258440836_4456215514434028_8771031304552802333_n-Sao-chep-1030x773.jpg','<p style=\"color:#cf1b15;\">Kích thước Cao 3m – Rộng 4m</p>\n<p style=\"color:#cf1b15;\">Phông trên 4m thêm 500.000/m</p>\n<p style=\"color:#cf1b15;\">Khuyến mãi đèn led mưa sau phông\nhoặc đèn chiếu phông</p>',NULL,NULL,NULL),(62,46,'Phông bạt thường',1800000,'https://cuoihoihoangquan.vn/wp-content/uploads/2020/08/117581953_3105825299473063_4655466981981648398_o-1030x773.jpg','<p style=\"color:#cf1b15;\">Kích thước Cao 3m – Rộng 4m</p>\n<p style=\"color:#cf1b15;\">Phông trên 4m thêm 500.000/m</p>\n<p style=\"color:#cf1b15;\">Khuyến mãi đèn led mưa sau phông\nhoặc đèn chiếu phông</p>',NULL,NULL,NULL),(67,46,'NHÀ BẠT CƯỚI THẢ PHÔNG ',5000000,'https://cuoihoihoangquan.vn/wp-content/uploads/2017/10/faceu_1581407272246-1030x773.jpeg','<ul style=\"padding-left : 30px;\">\n<li style=\"padding:  5px 0;\">Nhà bạt lụa với đầy đủ màu sắc cơ bản</li>\n<li style=\"padding:  5px 0;\">Khung rạp bằng sắt, linh hoạt, tùy chọn kích thước</li>\n<li style=\"padding:  5px 0;\">Trang trí phông lụa thẳng xếp ly – đèn thả cách đoạn</li>\n<li style=\"padding:  5px 0;\">Túm trang trí theo tone màu</li>\n<li style=\"padding:  5px 0;\">Trần vải kèm đèn chùm</li>\n<li style=\"padding:  5px 0;\">Mái quây bằng bạt trắng</li>\n<li style=\"padding:  5px 0;\">Thảm cỏ trải sàn</li>\n</ul>\n<p>Giá thành: <span style=\"color:#cf1b15;\">150.000</span>đ/m2</p>\n<p>Dưới 20m2 tính = 20m2 (<span style=\"color:#cf1b15;\">3.000.000/nhà </span>)</p>\n<p>Ưu đãi:</p>\n<ul style=\"padding-left : 30px;\">\n<li style=\"padding:  5px 0;\">Miễn phí khảo sát, tư vấn</li>\n<li style=\"padding:  5px 0;\">Miễn phí vận chuyển Nội thành Hà Nội</li>\n<li style=\"padding:  5px 0;\">Miễn phí lắp đặt</li>\n</ul>',NULL,NULL,NULL),(68,46,'NHÀ BẠT CAO CẤP VÁCH TÚM – DECOR',4000000,'https://cuoihoihoangquan.vn/wp-content/uploads/2020/02/faceu_1577699227762-1030x773.jpg','<ul style=\"padding-left : 30px;\">\n<li style=\"padding:  5px 0;\">Nhà bạt lụa hoặc kim tuyến với đầy đủ màu sắc hiện đại</li>\n<li style=\"padding:  5px 0;\">Khung rạp bằng sắt không rỉ, dễ dàng lắp đặt, linh động kích thước</li>\n<li style=\"padding:  5px 0;\">Khung sắt hình sơn nhũ vàng</li>\n<li style=\"padding:  5px 0;\">Trang trí viền dây led và đèn chùm cao cấp</li>\n<li style=\"padding:  5px 0;\">Quanh nhà rạp trang trí trụ hoa lụa – bồn hoa trắng</li>\n<li style=\"padding:  5px 0;\">Có trần bằng vải lụa trắng và đèn chùm</li>\n<li style=\"padding:  5px 0;\">Thảm cỏ trải sàn</li>\n</ul>\n<p>Giá thành: <span style=\"color:#cf1b15;\">150.000</span>đ/m2</p>\n<p>Dưới 20m2 tính = 20m2 (<span style=\"color:#cf1b15;\">4.000.000/nhà </span>)</p>\n<p>Ưu đãi:</p>\n<ul style=\"padding-left : 30px;\">\n<li style=\"padding:  5px 0;\">Miễn phí khảo sát, tư vấn</li>\n<li style=\"padding:  5px 0;\">Miễn phí vận chuyển Nội thành Hà Nội</li>\n<li style=\"padding:  5px 0;\">Miễn phí lắp đặt</li>\n</ul>',NULL,NULL,NULL),(83,44,'123',123,'../image/ban_ghe.jpg','123',NULL,'2022-05-22 08:38:50','2022-05-22 11:54:54'),(84,44,'12345',123,NULL,'123',NULL,'2022-05-22 09:00:46','2022-05-22 09:24:03'),(85,46,'123',123,'123','123',NULL,'2022-05-22 09:11:11','2022-05-22 09:28:32'),(86,44,'aaa',12345,'https://cf.shopee.vn/file/f551778344ae975ec385005c60f8f64a','2112',NULL,'2022-05-22 09:30:12','2022-05-22 09:34:57');
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
  `name` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Quản lý'),(2,'Nhân viên tư vấn khách hàng'),(3,'Nhân viên kho'),(4,'Nhân viên dịch vụ'),(5,'Khách hàng');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(250) DEFAULT NULL,
  `phone_number` varchar(50) DEFAULT NULL,
  `email` varchar(250) DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES (1,'123','123','1231','123','2022-05-25 04:22:24','2022-05-25 04:22:24'),(2,'2121123','123','123','123','2022-05-25 04:27:06','2022-05-25 04:27:06');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fullname` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `gender` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(150) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `role_id` int DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (62,'aa','Nam','2121212','12121312312','323232','321312',1,'2022-05-23 04:42:13','2022-05-24 12:05:56'),(64,'123','Nam','212131','31232131','1231','21213',4,'2022-05-23 11:44:44','2022-05-24 12:06:17'),(65,'Nguyễn Thị Kim Anh',NULL,'ka1510@gmail.com',NULL,NULL,'123456',5,'2022-05-24 18:16:29','2022-05-24 18:16:29');
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

-- Dump completed on 2022-05-25 17:33:51
