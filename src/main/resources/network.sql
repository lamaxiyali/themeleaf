-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: network
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
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
 SET character_set_client = utf8mb4 ;
CREATE TABLE `block_tran_change` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `height` int(11) NOT NULL,
  `tran_number` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=167 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `block_tran_change`
--

LOCK TABLES `block_tran_change` WRITE;
/*!40000 ALTER TABLE `block_tran_change` DISABLE KEYS */;
INSERT INTO `block_tran_change` VALUES (151,9,3),(152,10,4),(153,13,7),(154,14,8),(155,15,9),(156,16,10),(157,17,11),(158,20,14),(159,24,14),(160,25,15),(161,38,28),(162,40,30),(163,41,31),(164,42,32),(165,45,35),(166,30,16);
/*!40000 ALTER TABLE `block_tran_change` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fabric`
--

DROP TABLE IF EXISTS `fabric`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `fabric` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
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
 SET character_set_client = utf8mb4 ;
CREATE TABLE `person_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(45) NOT NULL,
  `message` varchar(255) NOT NULL,
  `messagetype` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_message`
--

LOCK TABLES `person_message` WRITE;
/*!40000 ALTER TABLE `person_message` DISABLE KEYS */;
INSERT INTO `person_message` VALUES (1,'system','公共消息---系统更新---鉴于用户反馈，对系统延迟较大进行了更新---2021-1-15 20:44:45','系统消息'),(2,'system','公共消息---系统更新---鉴于用户反馈，对系统延迟较大进行了更新---2021-1-15 21:07:08','系统消息'),(3,'admin','个人消息---任务提醒1---鉴于您已参与任务，请及时提交相关数据---2021-1-15 21:17:30','个人消息'),(4,'lamaxiya','个人消息---任务提醒---鉴于您已参与任务，请及时提交相关数据---2021-1-15 21:17:30','个人消息'),(5,'admin','个人消息---任务提醒---鉴于您已参与任务，请及时提交相关数据---2021-1-15 21:17:30','系统消息');
/*!40000 ALTER TABLE `person_message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `repass`
--

DROP TABLE IF EXISTS `repass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
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
INSERT INTO `repass` VALUES ('3293376887@qq.com','720610'),('baohuili@bupt.edu.cn','676148');
/*!40000 ALTER TABLE `repass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sence_data`
--

DROP TABLE IF EXISTS `sence_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
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
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sense_task_info` (
  `tid` varchar(45) NOT NULL,
  `task_name` varchar(45) NOT NULL,
  `task_from` varchar(45) DEFAULT NULL,
  `people_limit` int(11) NOT NULL,
  `task_type` enum('温度感知','噪声感知','空气质量感知') NOT NULL,
  `task_area` varchar(45) NOT NULL,
  `task_date` varchar(45) NOT NULL,
  `task_startTime` varchar(45) NOT NULL,
  `task_endTime` varchar(45) NOT NULL,
  `task_price` int(11) NOT NULL,
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
 SET character_set_client = utf8mb4 ;
CREATE TABLE `task_bidding_attr` (
  `taskid` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `expectprice` int(11) NOT NULL,
  `samplingfrequency` int(11) NOT NULL,
  `samplingtime` int(11) NOT NULL,
  `locationaware` int(11) NOT NULL,
  `positioningaccuracy` int(11) NOT NULL,
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
 SET character_set_client = utf8mb4 ;
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
INSERT INTO `task_part` VALUES ('36gayn','admin'),('36gayn','admin2'),('36gayn','lamaxiya'),('dgp5y5','lamaxiya'),('pjmhmh','lamaxiya');
/*!40000 ALTER TABLE `task_part` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taskpub_info`
--

DROP TABLE IF EXISTS `taskpub_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `taskpub_info` (
  `username` varchar(225) NOT NULL,
  `email` varchar(225) NOT NULL,
  `password` varchar(225) NOT NULL,
  `salt` varchar(225) NOT NULL,
  `phone` varchar(225) DEFAULT NULL,
  `name` varchar(225) DEFAULT NULL,
  `cardid` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taskpub_info`
--

LOCK TABLES `taskpub_info` WRITE;
/*!40000 ALTER TABLE `taskpub_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `taskpub_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_change`
--

DROP TABLE IF EXISTS `transaction_change`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `transaction_change` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `normal_tran` int(11) NOT NULL,
  `config_tran` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_change`
--

LOCK TABLES `transaction_change` WRITE;
/*!40000 ALTER TABLE `transaction_change` DISABLE KEYS */;
INSERT INTO `transaction_change` VALUES (1,22,2),(2,23,2),(3,26,2),(4,27,2),(5,29,2),(6,31,2),(7,33,2),(8,35,2),(9,37,2),(10,42,2);
/*!40000 ALTER TABLE `transaction_change` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_credit_reward`
--

DROP TABLE IF EXISTS `user_credit_reward`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_credit_reward` (
  `username` varchar(255) NOT NULL,
  `currentcredit` int(11) NOT NULL,
  `currentreward` int(11) NOT NULL,
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
 SET character_set_client = utf8mb4 ;
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
 SET character_set_client = utf8mb4 ;
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
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` VALUES ('admin','f0a9ecdf5d7f6383b0843cd2165be113','1VcI8ffhrCMPlOnSj4Wkew==','3293376887@qq.com','',NULL,'','','','',0),('admin2','e40ec2f8e691dad487e672eaf716b682','pH7XWHViO1ghzoZUG8sfnA==','3293376887q@gmail.com','',NULL,'','','','',0),('lamaxiya','eabb0d0aed44680c58c1294506aa7c29','ZguYT6McNUX88L4Ca6xKDw==','baohuili@bupt.edu.cn','',NULL,'','','','',0),('test1','d724396d1337b0650ccf7e95cea0f2bd','GoJwlNPoQX7s+tPDEV/LvA==','121212@qqq.com','13831275102',NULL,'411***117411','teacher','Dr','计算机技术',25),('test2','5f1b4ddd80296bf2505353b26dd829f3','BSrEZDZ9jSDVc+VGaD8Aew==','12@qq.com','13831275102','lama li','411**7732','student','graduate','计算机技术',24);
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'network'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-31 10:22:26
