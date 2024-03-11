-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: elsys
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `benefits_info`
--

DROP TABLE IF EXISTS `benefits_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `benefits_info` (
  `benefit_name` varchar(255) NOT NULL,
  `benefit_value` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`benefit_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `benefits_info`
--

LOCK TABLES `benefits_info` WRITE;
/*!40000 ALTER TABLE `benefits_info` DISABLE KEYS */;
INSERT INTO `benefits_info` VALUES ('元旦加班补贴',888.00),('绩效未达标',-300.00);
/*!40000 ALTER TABLE `benefits_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department_info`
--

DROP TABLE IF EXISTS `department_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department_info` (
  `department_name` varchar(255) DEFAULT NULL,
  `job_title_name` varchar(255) DEFAULT NULL,
  `job_title_salary` decimal(10,2) DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department_info`
--

LOCK TABLES `department_info` WRITE;
/*!40000 ALTER TABLE `department_info` DISABLE KEYS */;
INSERT INTO `department_info` VALUES ('产品部门','产品总监',6000.00,6),('产品部门','产品经理',4600.00,7),('产品部门','产品助理',2000.00,8),('运营部门','运营总监',5500.00,9),('运营部门','活动运营',2200.00,10),('研发部','前端',4800.00,11),('研发部','测试',2200.00,12),('研发部','运维',2600.00,13),('研发部','后端',9500.00,14),('设计部','UI',2000.00,15);
/*!40000 ALTER TABLE `department_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_info`
--

DROP TABLE IF EXISTS `employee_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_info` (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `employee_name` varchar(255) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `post` varchar(255) DEFAULT NULL,
  `salary_level` int DEFAULT NULL,
  `work_year` int DEFAULT NULL,
  `salary_amount` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10029 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_info`
--

LOCK TABLES `employee_info` WRITE;
/*!40000 ALTER TABLE `employee_info` DISABLE KEYS */;
INSERT INTO `employee_info` VALUES (10001,'小张','男','产品部门','产品总监',2,5,10588.00),(10002,'刘骥宇','男','产品部门','产品经理',5,1,9488.00),(10003,'刘华春','其他','产品部门','产品助理',1,7,6588.00),(10004,'白相宇','男','运营部门','运营总监',5,3,10588.00),(10022,'张帅磊','其他','运营部门','活动运营',1,10,7088.00),(10023,'李二狗','男','研发部','前端',3,5,9588.00),(10024,'王翠花','女','研发部','测试',1,1,6188.00),(10025,'孙铁蛋','男','研发部','运维',2,2,6888.00),(10026,'张大锤','男','研发部','后端',7,5,15388.00),(10027,'赵西瓜','其他','设计部','UI',4,5,7088.00),(10028,'复诊森','其他','研发部','测试',1,10,7088.00);
/*!40000 ALTER TABLE `employee_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary_info`
--

DROP TABLE IF EXISTS `salary_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salary_info` (
  `employee_id` int NOT NULL,
  `employee_name` varchar(255) DEFAULT NULL,
  `base_salary` decimal(10,2) DEFAULT NULL,
  `job_title_salary` decimal(10,2) DEFAULT NULL,
  `experience_salary` decimal(10,2) DEFAULT NULL,
  `benefits_salary` decimal(10,2) DEFAULT NULL,
  `net_salary` decimal(10,2) DEFAULT NULL,
  `salary_Level_salary` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary_info`
--

LOCK TABLES `salary_info` WRITE;
/*!40000 ALTER TABLE `salary_info` DISABLE KEYS */;
INSERT INTO `salary_info` VALUES (10001,'小张',3000.00,6000.00,500.00,588.00,10588.00,500.00),(10002,'刘骥宇',3000.00,4600.00,100.00,588.00,9488.00,1200.00),(10003,'刘华春',3000.00,2000.00,700.00,588.00,6588.00,300.00),(10004,'白相宇',3000.00,5500.00,300.00,588.00,10588.00,1200.00),(10022,'张帅磊',3000.00,2200.00,1000.00,588.00,7088.00,300.00),(10023,'李二狗',3000.00,4800.00,500.00,588.00,9588.00,700.00),(10024,'王翠花',3000.00,2200.00,100.00,588.00,6188.00,300.00),(10025,'孙铁蛋',3000.00,2600.00,200.00,588.00,6888.00,500.00),(10026,'张大锤',3000.00,9500.00,500.00,588.00,15388.00,1800.00),(10027,'赵西瓜',3000.00,2000.00,500.00,588.00,7088.00,1000.00),(10028,'复诊森',3000.00,2200.00,1000.00,588.00,7088.00,300.00);
/*!40000 ALTER TABLE `salary_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary_level_info`
--

DROP TABLE IF EXISTS `salary_level_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salary_level_info` (
  `salary_level` int NOT NULL,
  `salary_amount` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`salary_level`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary_level_info`
--

LOCK TABLES `salary_level_info` WRITE;
/*!40000 ALTER TABLE `salary_level_info` DISABLE KEYS */;
INSERT INTO `salary_level_info` VALUES (1,150.00),(2,300.00),(3,500.00),(4,800.00),(5,1200.00),(6,1800.00),(7,2200.00),(8,3000.00);
/*!40000 ALTER TABLE `salary_level_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `employee_id` int DEFAULT NULL,
  `role` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'liujiyu','fcea920f7412b5da7be0cf42b8c93759',10001,'admin'),(2,'liergou','e10adc3949ba59abbe56e057f20f883e',NULL,NULL),(10,'lihua','e10adc3949ba59abbe56e057f20f883e',NULL,NULL),(11,'qqqqq','e10adc3949ba59abbe56e057f20f883e',NULL,NULL),(12,'wwwww','96e79218965eb72c92a549dd5a330112',NULL,NULL),(13,'suuuu','96e79218965eb72c92a549dd5a330112',NULL,NULL),(14,'rrrrrrrr','96e79218965eb72c92a549dd5a330112',NULL,NULL);
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

-- Dump completed on 2024-03-11  9:29:45
