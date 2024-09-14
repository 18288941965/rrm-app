-- MySQL dump 10.13  Distrib 9.0.0, for Linux (x86_64)
--
-- Host: localhost    Database: rrm
-- ------------------------------------------------------
-- Server version	9.0.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `rrm_dict_entry`
--

DROP TABLE IF EXISTS `rrm_dict_entry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rrm_dict_entry` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `entry_code` varchar(50) NOT NULL COMMENT '字典项编码',
  `entry_name` varchar(100) NOT NULL COMMENT '字典项名称',
  `type_code` varchar(50) NOT NULL COMMENT '字典类型代码',
  `parent_id` bigint DEFAULT NULL COMMENT '父级字典项ID',
  `sort_order` int NOT NULL DEFAULT '0' COMMENT '排序',
  `status` tinyint NOT NULL DEFAULT '1' COMMENT '状态(1:启用, 0:禁用)',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `created_by` int NOT NULL COMMENT '创建人',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` int DEFAULT NULL COMMENT '更新人',
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `item_code` varchar(6) DEFAULT NULL COMMENT '项目代码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rrm_dict_entry`
--

LOCK TABLES `rrm_dict_entry` WRITE;
/*!40000 ALTER TABLE `rrm_dict_entry` DISABLE KEYS */;
INSERT INTO `rrm_dict_entry` VALUES (3,'01','类型一','dic_org_type',0,0,1,'',1,'2024-09-10 12:15:40',1,'2024-09-13 15:18:57','100020'),(4,'02','类型二','dic_org_type',0,0,1,'',1,'2024-09-10 12:15:55',1,'2024-09-13 15:19:02','100020'),(5,'0','未知的性别','dic_user_gender',0,3,1,'',1,'2024-09-11 16:21:30',NULL,'2024-09-12 06:21:37','100020'),(6,'1','男性','dic_user_gender',0,1,1,'',1,'2024-09-11 16:21:40',NULL,'2024-09-12 06:21:37','100020'),(7,'2','女性','dic_user_gender',0,2,1,'',1,'2024-09-11 16:21:47',NULL,'2024-09-12 06:21:37','100020'),(8,'9','未说明的性别','dic_user_gender',0,4,1,'',1,'2024-09-11 16:21:53',NULL,'2024-09-12 06:21:37','100020'),(9,'01','汉族','dic_user_nation',0,1,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(10,'02','蒙古族','dic_user_nation',0,2,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(11,'03','回族','dic_user_nation',0,3,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(12,'04','藏族','dic_user_nation',0,4,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(13,'05','维吾尔族','dic_user_nation',0,5,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(14,'06','苗族','dic_user_nation',0,6,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(15,'07','彝族','dic_user_nation',0,7,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(16,'08','壮族','dic_user_nation',0,8,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(17,'09','布依族','dic_user_nation',0,9,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(18,'10','朝鲜族','dic_user_nation',0,10,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(19,'11','满族','dic_user_nation',0,11,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(20,'12','侗族','dic_user_nation',0,12,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(21,'13','瑶族','dic_user_nation',0,13,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(22,'14','白族','dic_user_nation',0,14,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(23,'15','土家族','dic_user_nation',0,15,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(24,'16','哈尼族','dic_user_nation',0,16,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(25,'17','哈萨克族','dic_user_nation',0,17,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(26,'18','傣族','dic_user_nation',0,18,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(27,'19','黎族','dic_user_nation',0,19,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(28,'20','傈僳族','dic_user_nation',0,20,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(29,'21','佤族','dic_user_nation',0,21,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(30,'22','畲族','dic_user_nation',0,22,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(31,'23','高山族','dic_user_nation',0,23,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(32,'24','拉祜族','dic_user_nation',0,24,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(33,'25','水族','dic_user_nation',0,25,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(34,'26','东乡族','dic_user_nation',0,26,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(35,'27','纳西族','dic_user_nation',0,27,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(36,'28','景颇族','dic_user_nation',0,28,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(37,'29','柯尔克孜族','dic_user_nation',0,29,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(38,'30','土族','dic_user_nation',0,30,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(39,'31','达斡尔族','dic_user_nation',0,31,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(40,'32','仫佬族','dic_user_nation',0,32,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(41,'33','羌族','dic_user_nation',0,33,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(42,'34','布朗族','dic_user_nation',0,34,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(43,'35','撒拉族','dic_user_nation',0,35,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(44,'36','毛南族','dic_user_nation',0,36,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(45,'37','仡佬族','dic_user_nation',0,37,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(46,'38','锡伯族','dic_user_nation',0,38,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(47,'39','阿昌族','dic_user_nation',0,39,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(48,'40','普米族','dic_user_nation',0,40,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(49,'41','塔吉克族','dic_user_nation',0,41,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(50,'42','怒族','dic_user_nation',0,42,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(51,'43','乌孜别克族','dic_user_nation',0,43,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(52,'44','俄罗斯族','dic_user_nation',0,44,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(53,'45','鄂温克族','dic_user_nation',0,45,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(54,'46','德昂族','dic_user_nation',0,46,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(55,'47','保安族','dic_user_nation',0,47,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(56,'48','裕固族','dic_user_nation',0,48,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(57,'49','京族','dic_user_nation',0,49,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(58,'50','塔塔尔族','dic_user_nation',0,50,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(59,'51','独龙族','dic_user_nation',0,51,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(60,'52','鄂伦春族','dic_user_nation',0,52,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(61,'53','赫哲族','dic_user_nation',0,53,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(62,'54','门巴族','dic_user_nation',0,54,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(63,'55','珞巴族','dic_user_nation',0,55,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(64,'56','基诺族','dic_user_nation',0,56,1,NULL,1,'2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),(65,'01','类型一','dic_user_type',0,1,1,'',1,'2024-09-11 16:30:16',1,'2024-09-13 15:19:29','100020'),(66,'02','类型二','dic_user_type',0,2,1,'',1,'2024-09-11 16:30:31',1,'2024-09-13 15:19:34','100020'),(67,'01','all','dic_res_environment',0,0,1,'',1,'2024-09-13 14:37:01',1,'2024-09-13 06:49:10','100020'),(68,'02','dev','dic_res_environment',0,0,1,'',1,'2024-09-13 14:37:55',NULL,'2024-09-13 06:49:10','100020'),(69,'03','prod','dic_res_environment',0,0,1,'',1,'2024-09-13 14:38:01',NULL,'2024-09-13 06:49:10','100020'),(70,'10','授权','dic_res_auth_code',0,0,1,'',1,'2024-09-13 14:44:10',NULL,'2024-09-13 06:48:38','100020'),(71,'11','登录','dic_res_auth_code',0,0,1,'',1,'2024-09-13 14:44:15',NULL,'2024-09-13 06:48:38','100020'),(72,'12','开放','dic_res_auth_code',0,0,1,'',1,'2024-09-13 14:44:23',NULL,'2024-09-13 06:48:38','100020'),(73,'01','内部接口','dic_res_type',0,0,1,'',1,'2024-09-13 14:46:52',1,'2024-09-13 14:47:26','100020'),(74,'99','外部接口','dic_res_type',0,0,1,'',1,'2024-09-13 14:47:20',NULL,'2024-09-13 06:47:20','100020'),(75,'01','类型一','dic_menu_type',0,0,1,'',1,'2024-09-13 15:17:59',NULL,'2024-09-13 07:18:00','100020'),(76,'02','类型二','dic_menu_type',0,0,1,'',1,'2024-09-13 15:18:08',NULL,'2024-09-13 07:18:08','100020');
/*!40000 ALTER TABLE `rrm_dict_entry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rrm_dict_type`
--

DROP TABLE IF EXISTS `rrm_dict_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rrm_dict_type` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `type_code` varchar(50) NOT NULL COMMENT '字典类型编码',
  `type_name` varchar(100) NOT NULL COMMENT '字典类型名称',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `created_by` int NOT NULL COMMENT '创建人',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` int DEFAULT NULL COMMENT '更新人',
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `item_code` varchar(6) NOT NULL COMMENT '项目代码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rrm_dict_type`
--

LOCK TABLES `rrm_dict_type` WRITE;
/*!40000 ALTER TABLE `rrm_dict_type` DISABLE KEYS */;
INSERT INTO `rrm_dict_type` VALUES (3,'dic_org_type','机构类型','',1,'2024-09-10 12:10:44',NULL,'2024-09-10 04:10:45','100020'),(4,'dic_user_gender','性别','',1,'2024-09-11 16:21:07',NULL,'2024-09-11 08:21:07','100020'),(5,'dic_user_nation','民族','',1,'2024-09-11 16:24:55',NULL,'2024-09-11 08:24:54','100020'),(6,'dic_user_type','用户类型','',1,'2024-09-11 16:30:07',NULL,'2024-09-11 08:30:07','100020'),(8,'dic_res_environment','环境','',1,'2024-09-13 14:35:36',NULL,'2024-09-13 06:49:17','100020'),(9,'dic_res_auth_code','授权码','',1,'2024-09-13 14:39:27',NULL,'2024-09-13 06:48:19','100020'),(10,'dic_res_type','资源类型','',1,'2024-09-13 14:46:43',NULL,'2024-09-13 06:46:43','100020'),(11,'dic_menu_type','菜单类型','',1,'2024-09-13 15:17:51',NULL,'2024-09-13 07:17:52','100020');
/*!40000 ALTER TABLE `rrm_dict_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rrm_item`
--

DROP TABLE IF EXISTS `rrm_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rrm_item` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `item_name` varchar(255) NOT NULL COMMENT '项目名称',
  `item_code` varchar(6) NOT NULL COMMENT '项目编号',
  `created_by` int NOT NULL COMMENT '创建人',
  `created_at` timestamp(6) NOT NULL COMMENT '创建时间',
  `updated_by` int DEFAULT NULL COMMENT '更新人',
  `updated_at` timestamp(6) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='权限系统-项目管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rrm_item`
--

LOCK TABLES `rrm_item` WRITE;
/*!40000 ALTER TABLE `rrm_item` DISABLE KEYS */;
INSERT INTO `rrm_item` VALUES (1,'开发项目','100020',1,'2024-09-02 17:18:39.962000',1,'2024-09-12 16:53:23.251000'),(4,'test1项目','102356',2,'2024-09-13 09:29:32.676000',NULL,NULL);
/*!40000 ALTER TABLE `rrm_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rrm_menu`
--

DROP TABLE IF EXISTS `rrm_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rrm_menu` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `parent_id` varchar(36) DEFAULT NULL COMMENT '父菜单ID',
  `name` varchar(255) NOT NULL COMMENT '菜单名称',
  `icon` varchar(255) DEFAULT NULL COMMENT '菜单图标',
  `sort_order` int NOT NULL COMMENT '菜单排序',
  `visibility` tinyint NOT NULL COMMENT '菜单可见性',
  `path` varchar(1000) NOT NULL COMMENT '菜单路径',
  `type` varchar(2) DEFAULT NULL COMMENT '菜单类型（dic_menu_type）',
  `target` varchar(10) NOT NULL COMMENT '跳转方式',
  `page_name` varchar(50) DEFAULT NULL COMMENT '页面名称（页面name属性）',
  `page_cache` tinyint DEFAULT NULL COMMENT '页面是否缓存（1：是，0：否）',
  `version` varchar(20) NOT NULL COMMENT '版本号',
  `created_by` int NOT NULL COMMENT '创建人ID',
  `created_at` timestamp(6) NOT NULL COMMENT '创建时间',
  `updated_by` int DEFAULT NULL COMMENT '更新人',
  `updated_at` timestamp(6) NULL DEFAULT NULL COMMENT '更新时间',
  `status` tinyint NOT NULL DEFAULT '1' COMMENT '状态（1：有效，0：无效）',
  `item_code` varchar(6) NOT NULL COMMENT '项目代码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='接入系统菜单管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rrm_menu`
--

LOCK TABLES `rrm_menu` WRITE;
/*!40000 ALTER TABLE `rrm_menu` DISABLE KEYS */;
INSERT INTO `rrm_menu` VALUES ('8a5522cec0003b64bdde24e7d6bbfc8d',NULL,'11',NULL,2,1,'11','01','_self',NULL,0,'1.0',1,'2024-09-02 17:20:29.641000',NULL,NULL,1,'100020');
/*!40000 ALTER TABLE `rrm_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rrm_menu_element`
--

DROP TABLE IF EXISTS `rrm_menu_element`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rrm_menu_element` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `menu_id` varchar(36) NOT NULL COMMENT '菜单ID',
  `name` varchar(255) NOT NULL COMMENT '控件名称',
  `type` varchar(2) NOT NULL COMMENT '类型',
  `status` tinyint NOT NULL DEFAULT '1' COMMENT '状态（1：可用，0：不可用）',
  `created_by` int NOT NULL COMMENT '创建人',
  `created_at` timestamp(6) NOT NULL COMMENT '创建时间',
  `updated_by` int DEFAULT NULL COMMENT '更新人',
  `updated_at` timestamp(6) NULL DEFAULT NULL COMMENT '更新时间',
  `item_code` varchar(6) NOT NULL COMMENT '项目代码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='菜单组件';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rrm_menu_element`
--

LOCK TABLES `rrm_menu_element` WRITE;
/*!40000 ALTER TABLE `rrm_menu_element` DISABLE KEYS */;
INSERT INTO `rrm_menu_element` VALUES ('e2c4d9813b8cc4b643124b43a4ab97d3','8a5522cec0003b64bdde24e7d6bbfc8d','编辑按钮','01',0,1,'2024-09-03 08:54:59.578000',1,'2024-09-03 09:35:52.867000','100020'),('fe1ed87f0863d6f3caddb4981a41097a','8a5522cec0003b64bdde24e7d6bbfc8d','删除','01',0,1,'2024-09-03 08:57:41.076000',1,'2024-09-03 09:33:33.372000','100020');
/*!40000 ALTER TABLE `rrm_menu_element` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rrm_org`
--

DROP TABLE IF EXISTS `rrm_org`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rrm_org` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `code` varchar(20) NOT NULL COMMENT '机构代码',
  `parent_code` varchar(20) DEFAULT NULL COMMENT '上级机构代码',
  `name` varchar(500) NOT NULL COMMENT '机构名称',
  `abbr_name` varchar(500) DEFAULT NULL COMMENT '机构名称简称',
  `type` varchar(2) DEFAULT NULL COMMENT '机构类型（dic_org_type）',
  `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除（注销）（1：是，0：否）',
  `deleted_at` timestamp(6) NULL DEFAULT NULL COMMENT '删除（注销）时间',
  `extended_field` varchar(255) DEFAULT NULL COMMENT '扩展字段',
  `extended_field2` varchar(255) DEFAULT NULL COMMENT '扩展字段2',
  `created_by` int NOT NULL COMMENT '创建者',
  `created_at` timestamp(6) NOT NULL COMMENT '创建时间',
  `updated_by` int DEFAULT NULL COMMENT '更新人',
  `updated_at` timestamp(6) NULL DEFAULT NULL COMMENT '更新时间',
  `item_code` varchar(6) NOT NULL COMMENT '项目代码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='任职机构';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rrm_org`
--

LOCK TABLES `rrm_org` WRITE;
/*!40000 ALTER TABLE `rrm_org` DISABLE KEYS */;
INSERT INTO `rrm_org` VALUES ('0851c8c96d4beb5090a004273edd9664','11','532','22666','33','01',0,NULL,NULL,NULL,1,'2024-09-10 12:34:15.985000',NULL,'2024-09-10 14:17:06.058000','100020'),('1','ORG001',NULL,'总部','总部','01',0,NULL,NULL,NULL,1,'2024-09-09 01:16:12.000000',NULL,NULL,'100020'),('2','ORG002','ORG001','分公司A','分A','02',0,NULL,NULL,NULL,1,'2024-09-09 01:16:12.000000',NULL,NULL,'100020'),('3','ORG003','ORG001','分公司B','分B','02',0,NULL,NULL,NULL,1,'2024-09-09 01:16:12.000000',NULL,NULL,'100020'),('4','ORG004','ORG002','分公司A-子公司A1','A1','03',0,NULL,NULL,NULL,1,'2024-09-09 01:16:12.000000',NULL,NULL,'100020'),('5','ORG005','ORG002','分公司A-子公司A2','A2','03',0,NULL,NULL,NULL,1,'2024-09-09 01:16:12.000000',NULL,NULL,'100020'),('6','ORG006','ORG003','分公司B-子公司B1','B1','03',0,NULL,NULL,NULL,1,'2024-09-09 01:16:12.000000',NULL,NULL,'100020'),('7','ORG007','ORG004','分公司A-子公司A1-部门A1-1','A1-1','04',0,NULL,NULL,NULL,1,'2024-09-09 01:16:13.000000',NULL,NULL,'100020'),('bada6ddc7e6acba83555586590673846','532','','打饭打水','','01',0,NULL,NULL,NULL,1,'2024-09-10 12:18:21.792000',NULL,'2024-09-10 12:38:17.665000','100020'),('c405448b8018dddc0d1459a5ea33452e','33',NULL,'dfadfas','','',0,NULL,NULL,NULL,1,'2024-09-10 12:19:47.222000',NULL,NULL,'100020'),('ebf2ed126dcd75f505ae3adebd43bfc8','88',NULL,'888',NULL,NULL,1,'2024-09-10 12:45:49.571000',NULL,NULL,1,'2024-09-10 12:20:40.867000',NULL,'2024-09-10 12:45:49.571000','100020');
/*!40000 ALTER TABLE `rrm_org` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rrm_resource`
--

DROP TABLE IF EXISTS `rrm_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rrm_resource` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `service_name` varchar(255) NOT NULL COMMENT '服务名称',
  `package_name` varchar(255) NOT NULL COMMENT '包名',
  `class_name` varchar(255) NOT NULL COMMENT '类名',
  `method_name` varchar(100) NOT NULL COMMENT '方法名',
  `request_path` varchar(500) NOT NULL COMMENT '请求路径',
  `request_method` varchar(20) NOT NULL COMMENT '请求方式',
  `resource_name` varchar(255) NOT NULL COMMENT '资源名称',
  `resource_type` varchar(2) DEFAULT NULL COMMENT '资源类型(字典)',
  `auth_code` char(2) NOT NULL COMMENT '授权码',
  `environment` varchar(2) DEFAULT NULL COMMENT '资源环境（dev,prod）',
  `created_by` int NOT NULL COMMENT '创建人',
  `created_at` timestamp(6) NOT NULL COMMENT '创建时间',
  `updated_by` int DEFAULT NULL COMMENT '更新人',
  `updated_at` timestamp(6) NULL DEFAULT NULL COMMENT '更新时间',
  `status` tinyint NOT NULL DEFAULT '1' COMMENT '状态(1：启用，0：停用)',
  `item_code` varchar(6) NOT NULL COMMENT '项目代码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='资源管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rrm_resource`
--

LOCK TABLES `rrm_resource` WRITE;
/*!40000 ALTER TABLE `rrm_resource` DISABLE KEYS */;
INSERT INTO `rrm_resource` VALUES ('046d07b7daf2295a5de0afbc37cc9041','RRM','com.rrm.module.user.controller','RrmUserController','getAllUser','/user','GET','用户信息管理-查询所有','01','10','01',1,'2024-09-13 14:49:28.730000',NULL,NULL,1,'100020'),('10c5ccfc119287d8bdbc0d06ca541ace','RRM','com.rrm.module.dict.controller','RrmDictTypeController','deleteDictType','/dict-type/{id}','DELETE','字典类型-删除字典类型','01','10','01',1,'2024-09-13 14:49:28.726000',NULL,NULL,1,'100020'),('11aaf656d346c1000a6b489784a04b1a','RRM','com.rrm.module.dict.controller','RrmDictEntryController','searchDictEntryPage','/dict-entry/page','POST','字典项-分页查询','01','10','01',1,'2024-09-13 14:49:28.730000',NULL,NULL,1,'100020'),('1319c36b2392cd77f052669cd61b332d','RRM','com.rrm.module.dict.controller','RrmDictEntryController','getDictEntry','/dict-entry/{id}','GET','字典项-根据ID查询字典','01','10','01',1,'2024-09-13 14:49:28.726000',NULL,NULL,1,'100020'),('160d26f86569ed1bdcbf548ba69b7a76','RRM','com.rrm.module.menu.controller','RrmMenuController','getMenu','/menu/{id}','GET','菜单管理-根据ID查询','01','10','01',1,'2024-09-13 14:49:28.730000',NULL,NULL,1,'100020'),('1f580396f07bf583a9d4504e18a9ac14','RRM','com.rrm.module.menu.controller','RrmMenuController','updateMenuSort','/menu/sort','PUT','菜单管理-菜单排序','01','10','01',1,'2024-09-13 14:49:28.734000',NULL,NULL,1,'100020'),('219efd620b2392a1a197c56338263116','RRM','com.rrm.module.item.controller','RrmItemController','updateItem','/item','PUT','项目管理-更新','01','10','01',1,'2024-09-13 14:49:28.730000',NULL,NULL,1,'100020'),('24a15ab849c8c830b675c1258e18b90f','RRM','com.rrm.module.role.controller','RrmRoleController','updateRoleStatus','/role/status','PUT','角色管理-更新状态','01','10','01',1,'2024-09-13 14:49:28.726000',NULL,NULL,1,'100020'),('284a246cb3e3d7268a35bd43ef67055c','RRM','com.rrm.module.user.controller','AuthController','logOut','/auth/logout','GET','权限控制-退出登录','01','10','01',1,'2024-09-13 14:49:28.734000',NULL,NULL,1,'100020'),('28b559777721fe273f0a39d4fc9e543b','RRM','com.rrm.module.menu.controller','RrmMenuController','updateMenu','/menu','PUT','菜单管理-更新菜单','01','10','01',1,'2024-09-13 14:49:28.726000',NULL,NULL,1,'100020'),('2ad63329cd2989e379ab5413cb07c23a','RRM','com.rrm.module.role.controller','RrmRoleController','createRole','/role','POST','角色管理-创建','01','10','01',1,'2024-09-13 14:49:28.730000',NULL,NULL,1,'100020'),('2b48ed0a367e0893b3615653f6398bfc','RRM','com.rrm.module.user.controller','RrmUserItemController','deleteUserItem','/user-item/{userId}/{itemId}','DELETE','用户项目关联-删除关联信息','01','10','01',1,'2024-09-13 14:49:28.726000',NULL,NULL,1,'100020'),('2e42545fc565a2f902689f90c3dc002e','RRM','com.rrm.module.dict.controller','RrmDictEntryController','updateDictEntryStatus','/dict-entry/status','PUT','字典项-更新字典状态','01','10','01',1,'2024-09-13 14:49:28.726000',NULL,NULL,1,'100020'),('3083ad30f9cc075b46338b9f8fe9eeb6','RRM','com.rrm.module.dict.controller','RrmDictEntryController','updateDictEntrySort','/dict-entry/sort','PUT','字典项-更新字典顺序','01','10','01',1,'2024-09-13 14:49:28.730000',NULL,NULL,1,'100020'),('31ee42dec20f01c1e6ed57d72c9bcdde','RRM','com.rrm.module.role.controller','RrmRoleController','deleteRole','/role/{id}','DELETE','角色管理-删除','01','10','01',1,'2024-09-13 14:49:28.726000',NULL,NULL,1,'100020'),('3b7850f13fa126cd213af2ce22dd3024','RRM','com.rrm.module.user.controller','RrmUserController','createUser','/user','POST','用户信息管理-创建','01','10','01',1,'2024-09-13 14:49:28.734000',NULL,NULL,1,'100020'),('3d061ab6aea8c670d4a968e223502997','RRM','com.rrm.module.dict.controller','RrmDictEntryController','deleteDictEntry','/dict-entry/{id}','DELETE','字典项-删除字典','01','10','01',1,'2024-09-13 14:49:28.730000',NULL,NULL,1,'100020'),('4130af2bef6c61f93c8f909c585b2893','RRM','com.rrm.module.user.controller','RrmUserController','getUser','/user/{id}','GET','用户信息管理-根据ID获取','01','10','01',1,'2024-09-13 14:49:28.730000',NULL,NULL,1,'100020'),('41f47e8315e3d7e00fef23ab6011df26','RRM','com.rrm.module.user.controller','RrmUserController','getAllUserBase','/user/allUserBase','GET','用户信息管理-查询所有基本信息','01','10','01',1,'2024-09-13 14:49:28.730000',NULL,NULL,1,'100020'),('457515cb671b0f23bab04f13cc77851e','RRM','com.rrm.module.resource.controller','RrmResourceController','searchResourcePage','/resource/page','POST','资源管理-分页查询','01','10','01',1,'2024-09-13 14:49:28.726000',NULL,NULL,1,'100020'),('4742416fcaf34b9f92d25b8dea9dc857','RRM','com.rrm.module.users.controller','RrmUsersController','searchUsersPage','/users/page','POST','用户管理-分页查询','01','10','01',1,'2024-09-13 14:49:28.730000',NULL,NULL,1,'100020'),('4ac6ca4a4346c0d6016cecc84c9934cd','RRM','com.rrm.module.menu.controller','RrmMenuElementController','deleteMenuElement','/menu-element/{id}','DELETE','菜单控件管理-删除菜单元素','01','10','01',1,'2024-09-13 14:49:28.723000',NULL,NULL,1,'100020'),('4cd19c44c35d276677a87a566e3a2c97','RRM','com.rrm.module.dict.controller','RrmDictTypeController','createDictType','/dict-type','POST','字典类型-创建新的字典类型','01','10','01',1,'2024-09-13 14:49:28.730000',NULL,NULL,1,'100020'),('5376e438e2ce497a870e2d51a62ed84f','RRM','com.rrm.module.users.controller','RrmUsersController','deleteUsers','/users/{id}','DELETE','用户管理-删除','01','10','01',1,'2024-09-13 14:49:28.730000',NULL,NULL,1,'100020'),('5c7f5d4c658c1c25854c3349580d13a1','RRM','com.rrm.module.org.controller','RrmOrgController','createOrg','/org','POST','机构管理-创建','01','10','01',1,'2024-09-13 14:49:28.734000',NULL,NULL,1,'100020'),('5fcbac2959663c925c310a6e4b8f348b','RRM','com.rrm.module.role.controller','RrmRoleController','searchRolePage','/role/page','POST','角色管理-分页查询','01','10','01',1,'2024-09-13 14:49:28.725000',NULL,NULL,1,'100020'),('63d85146425f990bf22f3b20b2432607','RRM','com.rrm.module.user.controller','RrmUserController','deleteUser','/user/{id}','DELETE','用户信息管理-删除','01','10','01',1,'2024-09-13 14:49:28.726000',NULL,NULL,1,'100020'),('65840cf5d2f68da3e3e2221d07ca425e','RRM','com.rrm.module.org.controller','RrmOrgController','getOrgTreeByItemCode','/org/tree','GET','机构管理-根据关联项目查询所有机构并构建为tree','01','10','01',1,'2024-09-13 14:49:28.719000',NULL,NULL,1,'100020'),('65f06502277495e321922a9b993243d2','RRM','com.rrm.module.users.controller','RrmUsersController','createUsers','/users','POST','用户管理-创建','01','10','01',1,'2024-09-13 14:49:28.730000',NULL,NULL,1,'100020'),('66f78b6e9768e70834d9ef3b5d915ad8','RRM','com.rrm.module.item.controller','RrmItemController','getCorrelationUserId','/item/correlationUserId/{id}','GET','项目管理-获取关联信息','01','10','01',1,'2024-09-13 14:49:28.725000',NULL,NULL,1,'100020'),('689e147bf8bb59ca06c97223f834689d','RRM','com.rrm.module.org.controller','RrmOrgController','deleteOrg','/org/{id}','DELETE','机构管理-删除','01','10','01',1,'2024-09-13 14:49:28.726000',NULL,NULL,1,'100020'),('732ae2789f9f1b1520394baa90e7a406','RRM','com.rrm.module.org.controller','RrmOrgController','getOrg','/org/{id}','GET','机构管理-根据ID获取','01','10','01',1,'2024-09-13 14:49:28.730000',NULL,NULL,1,'100020'),('76b21624c3227f244896c630147bdd23','RRM','com.rrm.module.dict.controller','RrmDictEntryController','getDictEntryByTypeCode','/dict-entry/subitems/{typeCode}','GET','字典项-根据字典类型代码查询字典','01','10','01',1,'2024-09-13 14:49:28.723000',NULL,NULL,1,'100020'),('773608b8ffebaeb8eea49622cc85141d','RRM','com.rrm.module.dict.controller','RrmDictTypeController','getDictType','/dict-type/{id}','GET','字典类型-根据ID查询字典类型','01','10','01',1,'2024-09-13 14:49:28.730000',NULL,NULL,1,'100020'),('7a478903f9a8330e79e49de1b92d6d6c','RRM','com.rrm.module.user.controller','AuthController','isLogin','/auth/isLogin','GET','权限控制-检查是否登录','01','10','01',1,'2024-09-13 14:49:28.730000',NULL,NULL,1,'100020'),('7aef47c737abe64d466a3c2e29c5907e','RRM','com.rrm.module.dict.controller','RrmDictTypeController','updateDictType','/dict-type','PUT','字典类型-更新字典类型','01','10','01',1,'2024-09-13 14:49:28.726000',NULL,NULL,1,'100020'),('808b31571e67320a7d8a627303f98590','RRM','com.rrm.module.menu.controller','RrmMenuController','getMenuByParentId','/menu/children/{parentId}','GET','菜单管理-根据parentId查询子菜单','01','10','01',1,'2024-09-13 14:49:28.719000',NULL,NULL,1,'100020'),('8232b970c6bfcce474050c808ee1f7c0','RRM','com.rrm.module.user.controller','RrmUserController','updateUserDescription','/user/description','PUT','用户信息管理-修改用户描述','01','10','01',1,'2024-09-13 14:49:28.734000',NULL,NULL,1,'100020'),('8570654cd64269389b59f2a4ed2c5696','RRM','com.rrm.module.role.controller','RrmRoleController','getRole','/role/{id}','GET','角色管理-根据ID获取','01','10','01',1,'2024-09-13 14:49:28.726000',NULL,NULL,1,'100020'),('872b3ae9f9c2bfbfc7917800453d4481','RRM','com.rrm.module.resource.controller','EndpointScanner','scanEndpoints','/scanner','GET','资源扫描-扫描系统资源','01','10','01',1,'2024-09-13 14:49:28.726000',NULL,NULL,1,'100020'),('917379bb04a5debf076a00f416957bfe','RRM','com.rrm.module.menu.controller','RrmMenuController','updateMenuParent','/menu/move','PUT','菜单管理-移动菜单','01','10','01',1,'2024-09-13 14:49:28.726000',NULL,NULL,1,'100020'),('922ba850afcdf8f9d6536dbb42bced70','RRM','com.rrm.module.menu.controller','RrmMenuElementController','updateMenuElement','/menu-element','PUT','菜单控件管理-更新菜单元素','01','10','01',1,'2024-09-13 14:49:28.734000',NULL,NULL,1,'100020'),('931d0c60ba25a6bdb9821ae16a7696ab','RRM','com.rrm.module.menu.controller','RrmMenuElementController','createMenuElement','/menu-element','POST','菜单控件管理-创建菜单元素','01','10','01',1,'2024-09-13 14:49:28.730000',NULL,NULL,1,'100020'),('934065ac5438ca36dc73653fcd89ef85','RRM','com.rrm.module.dict.controller','RrmDictTypeController','searchDictTypePage','/dict-type/page','POST','字典类型-分页查询','01','10','01',1,'2024-09-13 14:49:28.726000',NULL,NULL,1,'100020'),('955f9b5d6caef0a6b33cc96bc14c821d','RRM','com.rrm.module.menu.controller','RrmMenuElementController','getMenuElement','/menu-element/{id}','GET','菜单控件管理-根据ID查询元素','01','10','01',1,'2024-09-13 14:49:28.726000',NULL,NULL,1,'100020'),('9c4cb02a6b093647c2c5efa195e21685','RRM','com.rrm.module.dict.controller','RrmDictEntryController','selectDictEntryByTypeCode','/dict-entry/select/{typeCode}','GET','字典项-根据字典类型代码查询字典','01','10','01',1,'2024-09-13 14:49:28.734000',NULL,NULL,1,'100020'),('a3d37734a7b8da24d31675742dee9126','RRM','com.rrm.module.role.controller','RrmRoleController','updateRole','/role','PUT','角色管理-更新','01','10','01',1,'2024-09-13 14:49:28.730000',NULL,NULL,1,'100020'),('a51c153b27e1055dd5b8669f2cee9d52','RRM','com.rrm.module.item.controller','RrmItemController','getAllItem','/item','GET','项目管理-查询所有','01','10','01',1,'2024-09-13 14:49:28.730000',NULL,NULL,1,'100020'),('a7be26d2abefd6e26c97fd3282d33be1','RRM','com.rrm.module.user.controller','AuthController','selectItem','/auth/select','PUT','权限控制-选择项目','01','10','01',1,'2024-09-13 14:49:28.726000',NULL,NULL,1,'100020'),('aa4eda248136e7a73894ed8e67801a4b','RRM','com.rrm.module.user.controller','AuthController','logIn','/auth/login','POST','权限控制-登录','01','10','01',1,'2024-09-13 14:49:28.734000',NULL,NULL,1,'100020'),('aea379a4a42c9895d78a6cf2cf1a7f7e','RRM','com.rrm.module.item.controller','RrmItemController','deleteItem','/item/{id}','DELETE','项目管理-删除','01','10','01',1,'2024-09-13 14:49:28.730000',NULL,NULL,1,'100020'),('b5b7134b775e7ab0eee6ffee394c988f','RRM','com.rrm.module.item.controller','RrmItemController','getItem','/item/{id}','GET','项目管理-根据ID查询','01','10','01',1,'2024-09-13 14:49:28.730000',NULL,NULL,1,'100020'),('b5f37cb907a5079a6a6ad01cc3002f84','RRM','com.rrm.module.menu.controller','RrmMenuController','getMenuTreeByItemCode','/menu/tree','GET','菜单管理-根据关联项目查询所有菜单并构建为tree','01','10','01',1,'2024-09-13 14:49:28.726000',NULL,NULL,1,'100020'),('b82df3863b5cd3fbb6e0f4dac5ddb7ad','RRM','com.rrm.module.item.controller','RrmItemController','createItem','/item','POST','项目管理-创建','01','10','01',1,'2024-09-13 14:49:28.726000',NULL,NULL,1,'100020'),('b89b91d723dfdd2232e51b54f9ad207b','RRM','com.rrm.module.user.controller','RrmUserItemController','createUserItem','/user-item','POST','用户项目关联-创建关联信息','01','10','01',1,'2024-09-13 14:49:28.726000',NULL,NULL,1,'100020'),('c0bd0df35b3826b7d09f2365e4cf3c47','RRM','com.rrm.module.menu.controller','RrmMenuController','deleteMenu','/menu/{id}','DELETE','菜单管理-删除菜单','01','10','01',1,'2024-09-13 14:49:28.734000',NULL,NULL,1,'100020'),('ce6c6acf53b884bb75bf445d15e43e3b','RRM','com.rrm.module.users.controller','RrmUsersController','updateUsers','/users','PUT','用户管理-更新','01','10','01',1,'2024-09-13 14:49:28.723000',NULL,NULL,1,'100020'),('dbca7f71dfb1dca1bf5f8ac376f5e20c','RRM','com.rrm.module.dict.controller','RrmDictEntryController','createDictEntry','/dict-entry','POST','字典项-创建新的字典','01','10','01',1,'2024-09-13 14:49:28.726000',NULL,NULL,1,'100020'),('dc49305b4c76afa3b1736ae9a63418a9','RRM','com.rrm.module.menu.controller','RrmMenuController','createMenu','/menu','POST','菜单管理-创建菜单','01','10','01',1,'2024-09-13 14:49:28.734000',NULL,NULL,1,'100020'),('e52a208a36d604abfc4fb9f74e353034','RRM','com.rrm.module.users.controller','RrmUsersController','getUsers','/users/{id}','GET','用户管理-根据ID获取','01','10','01',1,'2024-09-13 14:49:28.730000',NULL,NULL,1,'100020'),('eae61bb7a78ece1b42252721678daa21','RRM','com.rrm.module.user.controller','RrmUserController','validatePass','/user/validatePass','POST','用户信息管理-验证密码','01','10','01',1,'2024-09-13 14:49:28.734000',NULL,NULL,1,'100020'),('f17c005cced7bac9bf3a23340070521b','RRM','com.rrm.module.dict.controller','RrmDictEntryController','updateDictEntry','/dict-entry','PUT','字典项-更新字典','01','10','01',1,'2024-09-13 14:49:28.734000',NULL,NULL,1,'100020'),('f2827b1e00f0068229a5aac32548668c','RRM','com.rrm.module.user.controller','RrmUserController','updateUserPassword','/user/password','PUT','用户信息管理-修改密码','01','10','01',1,'2024-09-13 14:49:28.726000',NULL,NULL,1,'100020'),('f92d0b1353d996bcaebe6a78fcf880a8','RRM','com.rrm.module.resource.controller','RrmResourceController','updateResourceStatus','/resource/status','PUT','资源管理-更新状态','01','10','01',1,'2024-09-13 14:49:28.734000',NULL,NULL,1,'100020'),('fb99a478f6828b52d29c2339fe93891b','RRM','com.rrm.module.org.controller','RrmOrgController','updateOrg','/org','PUT','机构管理-更新','01','10','01',1,'2024-09-13 14:49:28.723000',NULL,NULL,1,'100020'),('ff460bd9afb7da45583ec5aa57f06be3','RRM','com.rrm.module.menu.controller','RrmMenuElementController','getMenuElementByMenuId','/menu-element/{menuId}/children','GET','菜单控件管理-根据菜单id查询元素','01','10','01',1,'2024-09-13 14:49:28.734000',NULL,NULL,1,'100020');
/*!40000 ALTER TABLE `rrm_resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rrm_role`
--

DROP TABLE IF EXISTS `rrm_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rrm_role` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `name` varchar(255) NOT NULL COMMENT '名称',
  `level` int NOT NULL DEFAULT '0' COMMENT '等级（权限从小到大）',
  `sort_order` int NOT NULL COMMENT '顺序号',
  `description` varchar(255) DEFAULT NULL COMMENT '角色描述',
  `created_by` int NOT NULL COMMENT '创建人',
  `created_at` timestamp(6) NOT NULL COMMENT '创建时间',
  `updated_by` int DEFAULT NULL COMMENT '更新人',
  `updated_at` timestamp(6) NULL DEFAULT NULL COMMENT '更新时间',
  `status` tinyint NOT NULL DEFAULT '1' COMMENT '状态（1：启用，0：停用）',
  `item_code` varchar(6) NOT NULL COMMENT '项目代码'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rrm_role`
--

LOCK TABLES `rrm_role` WRITE;
/*!40000 ALTER TABLE `rrm_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `rrm_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rrm_user`
--

DROP TABLE IF EXISTS `rrm_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rrm_user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(50) NOT NULL COMMENT '账号',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `description` varchar(255) DEFAULT NULL COMMENT '用户描述',
  `created_by` int DEFAULT NULL COMMENT '创建人',
  `created_at` timestamp(6) NULL DEFAULT NULL COMMENT '创建时间',
  `updated_by` int DEFAULT NULL COMMENT '更新人',
  `updated_at` timestamp(6) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `i_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rrm_user`
--

LOCK TABLES `rrm_user` WRITE;
/*!40000 ALTER TABLE `rrm_user` DISABLE KEYS */;
INSERT INTO `rrm_user` VALUES (1,'admin','e10adc3949ba59abbe56e057f20f883e',NULL,NULL,NULL,NULL,NULL),(2,'test1','5a105e8b9d40e1329780d62ea2265d8a','',1,'2024-09-13 09:27:43.198000',NULL,NULL);
/*!40000 ALTER TABLE `rrm_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rrm_user_item`
--

DROP TABLE IF EXISTS `rrm_user_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rrm_user_item` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int NOT NULL COMMENT '用户ID',
  `item_id` int DEFAULT NULL COMMENT '项目ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户项目关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rrm_user_item`
--

LOCK TABLES `rrm_user_item` WRITE;
/*!40000 ALTER TABLE `rrm_user_item` DISABLE KEYS */;
INSERT INTO `rrm_user_item` VALUES (3,1,1),(5,2,4);
/*!40000 ALTER TABLE `rrm_user_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rrm_users`
--

DROP TABLE IF EXISTS `rrm_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rrm_users` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(36) NOT NULL COMMENT '密码',
  `name` varchar(100) NOT NULL COMMENT '姓名',
  `gender` varchar(2) DEFAULT NULL COMMENT ' 性别 （dic_user_gender）',
  `nation` varchar(2) DEFAULT NULL COMMENT '民族 （dic_user_nation）',
  `id_number` varchar(18) NOT NULL COMMENT '身份证号',
  `date_of_birth` date DEFAULT NULL COMMENT '出生日期',
  `phone_number` varchar(20) NOT NULL COMMENT '联系电话',
  `avatar` text COMMENT '头像（base64）',
  `org_code` varchar(20) NOT NULL COMMENT '任职机构代码',
  `org_name` varchar(500) NOT NULL COMMENT '任职机构名称',
  `type` varchar(2) DEFAULT NULL COMMENT '用户类型（dic_user_type）',
  `description` varchar(500) DEFAULT NULL COMMENT ' 用户描述',
  `account_status` tinyint NOT NULL COMMENT '账户状态（1：活跃，-1：锁定、0：禁用）',
  `registration_date` timestamp(6) NULL DEFAULT NULL COMMENT ' 注册时间',
  `last_login_time` timestamp(6) NULL DEFAULT NULL COMMENT '最近登录时间',
  `failed_login_attempts` tinyint DEFAULT NULL COMMENT '登录失败次数',
  `login_count` int DEFAULT NULL COMMENT '登录次数',
  `approval_status` tinyint DEFAULT NULL COMMENT '审核状态（-1：审核中，1：审核通过，0：审核不通过）',
  `approval_at` timestamp(6) NULL DEFAULT NULL COMMENT ' 审核时间',
  `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除（注销）(1：是，0：否)',
  `deleted_at` timestamp(6) NULL DEFAULT NULL COMMENT '删除（注销时间）',
  `extended_field` varchar(255) DEFAULT NULL COMMENT '扩展字段',
  `extended_field2` varchar(255) DEFAULT NULL COMMENT '扩展字段2',
  `created_by` int NOT NULL COMMENT '创建者',
  `created_at` timestamp(6) NOT NULL COMMENT '创建时间',
  `updated_by` int DEFAULT NULL COMMENT '更新者',
  `updated_at` timestamp(6) NULL DEFAULT NULL COMMENT '更新时间',
  `item_code` varchar(6) NOT NULL COMMENT '项目代码 ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='外部用户信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rrm_users`
--

LOCK TABLES `rrm_users` WRITE;
/*!40000 ALTER TABLE `rrm_users` DISABLE KEYS */;
INSERT INTO `rrm_users` VALUES ('91e1e8810999fad4783b9547d3075c85','usabcc','123454','sf','0','02','53262619960302251X','2024-09-13','18255469875',NULL,'11','22666','01',NULL,1,NULL,NULL,NULL,NULL,-1,NULL,0,NULL,NULL,NULL,1,'2024-09-13 15:22:50.843000',NULL,NULL,'100020'),('bc3ea5e79338f0169f889c3c9cb2e462','usabc','123456','111','0','05','53262619960104200X','2024-08-16','18288954685',NULL,'ORG002','分公司A',NULL,'',1,NULL,NULL,NULL,NULL,-1,NULL,0,NULL,NULL,NULL,1,'2024-09-11 14:12:58.825000',NULL,'2024-09-12 12:24:53.013000','100020');
/*!40000 ALTER TABLE `rrm_users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-14  9:25:34
