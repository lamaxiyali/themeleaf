-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: network
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `block_tran_change`
--

DROP TABLE IF EXISTS `block_tran_change`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `block_tran_change` (
  `id` int NOT NULL AUTO_INCREMENT,
  `height` int NOT NULL,
  `tran_number` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=174 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `block_tran_change`
--

LOCK TABLES `block_tran_change` WRITE;
/*!40000 ALTER TABLE `block_tran_change` DISABLE KEYS */;
INSERT INTO `block_tran_change` VALUES (151,9,3),(152,10,4),(153,13,7),(154,14,8),(155,15,9),(156,16,10),(157,17,11),(158,20,14),(159,24,14),(160,25,15),(161,38,28),(162,40,30),(163,41,31),(164,42,32),(165,45,35),(166,8,2),(167,55,18),(168,15,1),(169,21,7),(170,24,10),(171,25,11),(172,26,12),(173,27,13);
/*!40000 ALTER TABLE `block_tran_change` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fabric`
--

DROP TABLE IF EXISTS `fabric`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fabric` (
  `id` int NOT NULL AUTO_INCREMENT,
  `number` varchar(256) NOT NULL,
  `name` varchar(256) NOT NULL,
  `color` varchar(256) NOT NULL,
  `type` varchar(256) NOT NULL,
  `owner` varchar(256) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fabric`
--

LOCK TABLES `fabric` WRITE;
/*!40000 ALTER TABLE `fabric` DISABLE KEYS */;
INSERT INTO `fabric` VALUES (1,'aa','aa','aa','aa','aa'),(2,'CAR0','Toyota','blue','Prius','Tomoko'),(3,'CAR1','Ford','red','Mustang','Brad'),(4,'CAR10','VW10','Grey','Polo','Mary'),(5,'CAR11','VW','Grey','Polo','Archie'),(6,'CAR2','Hyundai','green','Tucson','Jin Soo'),(7,'CAR3','Volkswagen','yellow','Passat','Max'),(8,'CAR4','Tesla','black','S','Adriana'),(9,'CAR5','Peugeot','purple','205','Michel'),(10,'CAR6','Chery','white','S22L','Aarav'),(11,'CAR7','Fiat','violet','Punto','Pari'),(12,'CAR8','Tata','indigo','Nano','Valeria'),(13,'CAR9','Holden','brown','Barina','Shotaro'),(14,'CAR0','Toyota','blue','Prius','Tomoko'),(15,'CAR1','Ford','red','Mustang','Brad'),(16,'CAR10','10','10','10','10'),(17,'CAR11','11','11','11','lamaxiya'),(18,'CAR2','Hyundai','green','Tucson','Jin Soo'),(19,'CAR3','Volkswagen','yellow','Passat','Max'),(20,'CAR4','Tesla','black','S','Adriana'),(21,'CAR5','Peugeot','purple','205','Michel'),(22,'CAR6','Chery','white','S22L','Aarav'),(23,'CAR7','Fiat','violet','Punto','Pari'),(24,'CAR8','Tata','indigo','Nano','Valeria'),(25,'CAR9','Holden','brown','Barina','Shotaro');
/*!40000 ALTER TABLE `fabric` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_message`
--

DROP TABLE IF EXISTS `person_message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person_message` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uname` varchar(45) NOT NULL,
  `message` varchar(255) NOT NULL,
  `messagetype` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_message`
--

LOCK TABLES `person_message` WRITE;
/*!40000 ALTER TABLE `person_message` DISABLE KEYS */;
INSERT INTO `person_message` VALUES (1,'system','公共消息---系统更新---鉴于用户反馈，对系统延迟较大进行了更新---2021-1-15 20:44:45','系统消息'),(2,'system','公共消息---系统更新---鉴于用户反馈，对系统延迟较大进行了更新---2021-1-15 21:07:08','系统消息'),(3,'admin','个人消息---任务提醒1---鉴于您已参与任务，请及时提交相关数据---2021-1-15 21:17:30','个人消息'),(4,'lamaxiya','个人消息---任务提醒---鉴于您已参与任务，请及时提交相关数据---2021-1-15 21:17:30','个人消息'),(5,'admin','个人消息---任务提醒---鉴于您已参与任务，请及时提交相关数据---2021-1-15 21:17:30','个人消息'),(6,'test5','个人消息---注册信息---您已经成功注册信息到区块链上---2021-1-18 21:41:46','个人消息');
/*!40000 ALTER TABLE `person_message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `repass`
--

DROP TABLE IF EXISTS `repass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `repass` (
  `email` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repass`
--

LOCK TABLES `repass` WRITE;
/*!40000 ALTER TABLE `repass` DISABLE KEYS */;
INSERT INTO `repass` VALUES ('3293376887@qq.com','305138'),('baohuili@bupt.edu.cn','676148');
/*!40000 ALTER TABLE `repass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sence_data`
--

DROP TABLE IF EXISTS `sence_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sence_data` (
  `taskid` varchar(255) NOT NULL,
  PRIMARY KEY (`taskid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sence_data`
--

LOCK TABLES `sence_data` WRITE;
/*!40000 ALTER TABLE `sence_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `sence_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sense_task_info`
--

DROP TABLE IF EXISTS `sense_task_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sense_task_info` (
  `tid` varchar(45) NOT NULL,
  `task_name` varchar(45) NOT NULL,
  `task_from` varchar(45) DEFAULT NULL,
  `people_limit` int NOT NULL,
  `task_type` enum('温度感知','噪声感知','空气质量感知') NOT NULL,
  `task_area` varchar(45) NOT NULL,
  `task_date` varchar(45) NOT NULL,
  `task_startTime` varchar(45) NOT NULL,
  `task_endTime` varchar(45) NOT NULL,
  `task_price` int NOT NULL,
  `task_status` enum('未开始','已结束','进行中') NOT NULL,
  `task_desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sense_task_info`
--

LOCK TABLES `sense_task_info` WRITE;
/*!40000 ALTER TABLE `sense_task_info` DISABLE KEYS */;
INSERT INTO `sense_task_info` VALUES ('36gayn','感知任务1','company1',45,'温度感知','海淀区','2020-12-15','08:45','09:30',234,'进行中','感知任务测试'),('82r852faqasm','感知任务4','company3',45,'温度感知','海淀区','2020-12-17','09:00','12:15',234,'未开始','感知任务测试'),('9hvlyv','感知任务2','company1',45,'温度感知','朝阳区','2020-12-15','09:30','11:45',245,'未开始','感知任务测试'),('dgp5y5','感知任务3','company2',45,'温度感知','西土城区','2020-12-16','09:15','11:45',223,'进行中','感知任务测试'),('pjmhmh','感知任务1','company2',45,'空气质量感知','西土城区','2020-12-15','09:15','11:45',223,'进行中','感知任务测试'),('pxsh5ln02ec3','感知任务5','company1',45,'温度感知','朝阳区','2020-12-15T16:00:00.000Z','08:45','10:45',212,'未开始','感知任务测试'),('q7g2kn','感知任务2','company2',45,'噪声感知','西土城区','2020-12-15','09:15','11:45',223,'进行中','感知任务测试'),('ubeno8hvweyy','感知任务4','company4',45,'噪声感知','朝阳区','2020-12-15T16:00:00.000Z','08:45','12:45',234,'未开始','感知任务测试'),('uzjhhm','感知任务3','company1',45,'噪声感知','西土城区','2020-12-15','09:15','11:45',248,'未开始','感知任务测试'),('zy8mb8m8ysdo','感知任务1','company5',45,'温度感知','朝阳区','2020-12-16T16:00:00.000Z','08:30','08:45',234,'未开始','感知任务测试');
/*!40000 ALTER TABLE `sense_task_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_bidding_attr`
--

DROP TABLE IF EXISTS `task_bidding_attr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `task_bidding_attr` (
  `taskid` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `expectprice` int NOT NULL,
  `samplingfrequency` int NOT NULL,
  `samplingtime` int NOT NULL,
  `locationaware` int NOT NULL,
  `positioningaccuracy` int NOT NULL,
  `biddingnot` int NOT NULL,
  PRIMARY KEY (`taskid`,`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_bidding_attr`
--

LOCK TABLES `task_bidding_attr` WRITE;
/*!40000 ALTER TABLE `task_bidding_attr` DISABLE KEYS */;
/*!40000 ALTER TABLE `task_bidding_attr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_part`
--

DROP TABLE IF EXISTS `task_part`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `task_part` (
  `task_id` varchar(45) NOT NULL,
  `task_userid` varchar(45) NOT NULL,
  PRIMARY KEY (`task_id`,`task_userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_part`
--

LOCK TABLES `task_part` WRITE;
/*!40000 ALTER TABLE `task_part` DISABLE KEYS */;
INSERT INTO `task_part` VALUES ('36gayn','admin'),('36gayn','admin2'),('36gayn','lamaxiya'),('36gayn','test1'),('dgp5y5','lamaxiya'),('pjmhmh','lamaxiya');
/*!40000 ALTER TABLE `task_part` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_change`
--

DROP TABLE IF EXISTS `transaction_change`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction_change` (
  `id` int NOT NULL AUTO_INCREMENT,
  `normal_tran` int NOT NULL,
  `config_tran` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_change`
--

LOCK TABLES `transaction_change` WRITE;
/*!40000 ALTER TABLE `transaction_change` DISABLE KEYS */;
INSERT INTO `transaction_change` VALUES (1,22,2),(2,23,2),(3,26,2),(4,27,2),(5,29,2),(6,31,2),(7,33,2),(8,35,2),(9,37,2),(10,42,2),(11,50,2),(12,52,2),(13,12,2),(14,18,2);
/*!40000 ALTER TABLE `transaction_change` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_credit_reward`
--

DROP TABLE IF EXISTS `user_credit_reward`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_credit_reward` (
  `username` varchar(255) NOT NULL,
  `currentcredit` int NOT NULL,
  `currentreward` int NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_credit_reward`
--

LOCK TABLES `user_credit_reward` WRITE;
/*!40000 ALTER TABLE `user_credit_reward` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_credit_reward` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_task_info`
--

DROP TABLE IF EXISTS `user_task_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_task_info` (
  `taskid` varchar(255) NOT NULL,
  `tasktitle` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `tasktype` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `username` varchar(255) NOT NULL,
  `taskbidding` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`taskid`,`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_task_info`
--

LOCK TABLES `user_task_info` WRITE;
/*!40000 ALTER TABLE `user_task_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_task_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinfo`
--

DROP TABLE IF EXISTS `userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userinfo` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `cardid` varchar(255) DEFAULT NULL,
  `profession` varchar(255) DEFAULT NULL,
  `education` varchar(255) DEFAULT NULL,
  `major` varchar(255) DEFAULT NULL,
  `age` int DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` VALUES ('aaaa','ead66bf8d4b04463f4090b38e9a38691','+nJvHoeYHzVfuXI0U7RJIw==','0@qq.com','','aa','','','','',23),('admin','f0a9ecdf5d7f6383b0843cd2165be113','1VcI8ffhrCMPlOnSj4Wkew==','3293376887@qq.com','',NULL,'','','','',0),('admin2','e40ec2f8e691dad487e672eaf716b682','pH7XWHViO1ghzoZUG8sfnA==','3293376887q@gmail.com','',NULL,'','','','',0),('lama','0d4f71e95ef6280955e52d2bf988b3d2','1a8f21+BBSq6d3awEPgmIw==','123@qq.com','','','','','','',23),('lamaxiya','eabb0d0aed44680c58c1294506aa7c29','ZguYT6McNUX88L4Ca6xKDw==','baohuili@bupt.edu.cn','',NULL,'','','','',0),('test1','36340b204983df74ef9f7c392368b8db','RBzWLK5d22TqqzIZF4A43g==','1@qq.com','','','','student','undergraduate','',21),('test2','0492dfe4aa9ba190b6beed881fa4623a','Biw8BQvLLlnKPdXeHef5aA==','2@qq.com','12232323','lama li','','teacher','Dr','',22),('test3','9d7a7783ff4fbaeafbba7d55b14a9cf8','5v4dRU+5uE+Y+qRetCEnRw==','3@qq.com','','','','student','','',23),('test4','8dd6f3996d4229ecd1c65d1ecc338b79','7XD1h6y/yvaJELrRYM2xzQ==','4@qq.com','','','','student','','',25),('test5','c65cfae7c218324cfacb297aee53739a','SduhjBZoH+G3GVdlKU8+9g==','5@qq.com','','','','student','other','',23);
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-18 21:59:34
