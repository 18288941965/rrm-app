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
  `id` varchar(36) NOT NULL COMMENT '主键ID',
  `entry_code` varchar(50) NOT NULL COMMENT '字典项编码',
  `entry_name` varchar(100) NOT NULL COMMENT '字典项名称',
  `type_code` varchar(50) NOT NULL COMMENT '字典类型代码',
  `parent_id` varchar(36) DEFAULT NULL COMMENT '父级字典项ID',
  `sort_order` int NOT NULL DEFAULT '0' COMMENT '排序',
  `status` tinyint NOT NULL DEFAULT '1' COMMENT '状态（1：启用 ，0：停用）',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `created_by` varchar(36) NOT NULL COMMENT '创建人',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(36) DEFAULT NULL COMMENT '更新人',
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `item_code` varchar(6) DEFAULT NULL COMMENT '项目代码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rrm_dict_entry`
--

LOCK TABLES `rrm_dict_entry` WRITE;
/*!40000 ALTER TABLE `rrm_dict_entry` DISABLE KEYS */;
INSERT INTO `rrm_dict_entry` VALUES ('10','02','蒙古族','dic_user_nation','0',2,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('11','03','回族','dic_user_nation','0',3,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('12','04','藏族','dic_user_nation','0',4,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('13','05','维吾尔族','dic_user_nation','0',5,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('14','06','苗族','dic_user_nation','0',6,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('15','07','彝族','dic_user_nation','0',7,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('16','08','壮族','dic_user_nation','0',8,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('17','09','布依族','dic_user_nation','0',9,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('18','10','朝鲜族','dic_user_nation','0',10,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('19','11','满族','dic_user_nation','0',11,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('20','12','侗族','dic_user_nation','0',12,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('21','13','瑶族','dic_user_nation','0',13,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('22','14','白族','dic_user_nation','0',14,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('23','15','土家族','dic_user_nation','0',15,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('24','16','哈尼族','dic_user_nation','0',16,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('25','17','哈萨克族','dic_user_nation','0',17,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('26','18','傣族','dic_user_nation','0',18,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('27','19','黎族','dic_user_nation','0',19,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('28','20','傈僳族','dic_user_nation','0',20,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('29','21','佤族','dic_user_nation','0',21,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('3','01','类型一','dic_org_type','0',0,1,'','1','2024-09-10 12:15:40','1','2024-09-13 15:18:57','100020'),('30','22','畲族','dic_user_nation','0',22,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('31','23','高山族','dic_user_nation','0',23,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('32','24','拉祜族','dic_user_nation','0',24,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('33','25','水族','dic_user_nation','0',25,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('34','26','东乡族','dic_user_nation','0',26,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('35','27','纳西族','dic_user_nation','0',27,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('36','28','景颇族','dic_user_nation','0',28,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('37','29','柯尔克孜族','dic_user_nation','0',29,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('38','30','土族','dic_user_nation','0',30,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('39','31','达斡尔族','dic_user_nation','0',31,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('4','02','类型二','dic_org_type','0',0,1,'','1','2024-09-10 12:15:55','1','2024-09-13 15:19:02','100020'),('40','32','仫佬族','dic_user_nation','0',32,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('41','33','羌族','dic_user_nation','0',33,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('42','34','布朗族','dic_user_nation','0',34,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('43','35','撒拉族','dic_user_nation','0',35,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('44','36','毛南族','dic_user_nation','0',36,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('45','37','仡佬族','dic_user_nation','0',37,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('46','38','锡伯族','dic_user_nation','0',38,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('47','39','阿昌族','dic_user_nation','0',39,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('48','40','普米族','dic_user_nation','0',40,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('49','41','塔吉克族','dic_user_nation','0',41,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('5','0','未知的性别','dic_user_gender','0',3,1,'','1','2024-09-11 16:21:30',NULL,'2024-09-12 06:21:37','100020'),('50','42','怒族','dic_user_nation','0',42,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('51','43','乌孜别克族','dic_user_nation','0',43,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('52','44','俄罗斯族','dic_user_nation','0',44,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('53','45','鄂温克族','dic_user_nation','0',45,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('54','46','德昂族','dic_user_nation','0',46,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('55','47','保安族','dic_user_nation','0',47,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('56','48','裕固族','dic_user_nation','0',48,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('57','49','京族','dic_user_nation','0',49,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('58','50','塔塔尔族','dic_user_nation','0',50,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('59','51','独龙族','dic_user_nation','0',51,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('6','1','男性','dic_user_gender','0',1,1,'','1','2024-09-11 16:21:40',NULL,'2024-09-12 06:21:37','100020'),('60','52','鄂伦春族','dic_user_nation','0',52,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('61','53','赫哲族','dic_user_nation','0',53,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('62','54','门巴族','dic_user_nation','0',54,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('63','55','珞巴族','dic_user_nation','0',55,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('64','56','基诺族','dic_user_nation','0',56,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('65','01','类型一','dic_user_type','0',1,1,'','1','2024-09-11 16:30:16','1','2024-09-13 15:19:29','100020'),('66','02','类型二','dic_user_type','0',2,1,'','1','2024-09-11 16:30:31','1','2024-09-13 15:19:34','100020'),('67','01','全部','dic_res_environment','0',0,1,'','1','2024-09-13 14:37:01','1','2024-10-31 12:49:17','100020'),('68','02','开发','dic_res_environment','0',0,1,'','1','2024-09-13 14:37:55','1','2024-10-31 12:49:22','100020'),('69','03','生产','dic_res_environment','0',0,1,'','1','2024-09-13 14:38:01','1','2024-10-31 12:49:27','100020'),('7','2','女性','dic_user_gender','0',2,1,'','1','2024-09-11 16:21:47',NULL,'2024-09-12 06:21:37','100020'),('70','10','授权','dic_res_auth_code','0',0,1,'','1','2024-09-13 14:44:10',NULL,'2024-09-13 06:48:38','100020'),('71','11','登录','dic_res_auth_code','0',0,1,'','1','2024-09-13 14:44:15',NULL,'2024-09-13 06:48:38','100020'),('72','12','开放','dic_res_auth_code','0',0,1,'','1','2024-09-13 14:44:23',NULL,'2024-09-13 06:48:38','100020'),('73','01','内部接口','dic_res_type','0',0,1,'','1','2024-09-13 14:46:52','1','2024-09-13 14:47:26','100020'),('74','99','外部接口','dic_res_type','0',0,1,'','1','2024-09-13 14:47:20',NULL,'2024-09-13 06:47:20','100020'),('75','01','类型一','dic_menu_type','0',0,1,'','1','2024-09-13 15:17:59',NULL,'2024-09-13 07:18:00','100020'),('76','02','类型二','dic_menu_type','0',0,1,'','1','2024-09-13 15:18:08',NULL,'2024-09-13 07:18:08','100020'),('77','01','按钮','dic_menu_element_type','0',0,1,'','1','2024-09-18 14:34:11',NULL,'2024-09-18 06:34:11','100020'),('78','02','tab页','dic_menu_element_type','0',0,1,'','1','2024-09-18 14:34:26',NULL,'2024-09-18 06:34:26','100020'),('79','03','链接','dic_menu_element_type','0',0,1,'','1','2024-09-18 14:34:36',NULL,'2024-09-18 06:34:35','100020'),('8','9','未说明的性别','dic_user_gender','0',4,1,'','1','2024-09-11 16:21:53',NULL,'2024-09-12 06:21:37','100020'),('80','GET','GET','dic_axios_type','0',1,1,'','1','2024-09-19 14:50:26',NULL,'2024-09-19 06:51:00','100020'),('81','POST','POST','dic_axios_type','0',2,1,'','1','2024-09-19 14:50:39',NULL,'2024-09-19 06:51:00','100020'),('82','PUT','PUT','dic_axios_type','0',3,1,'','1','2024-09-19 14:50:44',NULL,'2024-09-19 06:51:00','100020'),('83','DELETE','DELETE','dic_axios_type','0',4,1,'','1','2024-09-19 14:50:50',NULL,'2024-09-19 06:51:00','100020'),('84','01','普通角色','dic_role_type','0',0,1,'','1','2024-09-20 14:34:19',NULL,'2024-09-20 06:34:18','100020'),('85','99','超级管理员角色','dic_role_type','0',0,1,'','1','2024-09-20 14:34:32',NULL,'2024-09-20 06:34:32','100020'),('88','rrm','RRM','dic_service_name','0',0,1,'','1','2024-10-30 14:53:19',NULL,'2024-10-31 04:44:03','100020'),('89','01','pc','dic_terminal','0',0,1,'','1','2024-12-25 09:15:45','1','2024-12-25 09:16:30','100020'),('9','01','汉族','dic_user_nation','0',1,1,NULL,'1','2024-09-11 08:28:47',NULL,'2024-09-12 06:22:01','100020'),('90','02','mobile','dic_terminal','0',0,1,'','1','2024-12-25 09:16:22',NULL,'2024-12-25 01:16:21','100020'),('91','03','wx_mini','dic_terminal','0',0,1,'','1','2024-12-25 09:16:44',NULL,'2024-12-25 01:16:44','100020'),('92','01','Ⅰ类','dic_net_type','0',0,1,'','1','2024-12-25 09:18:35',NULL,'2024-12-25 01:18:35','100020'),('93','02','Ⅱ类','dic_net_type','0',0,1,'','1','2024-12-25 09:18:43',NULL,'2024-12-25 01:18:42','100020'),('94','03','Ⅲ类','dic_net_type','0',0,1,'','1','2024-12-25 09:18:51',NULL,'2024-12-25 01:18:51','100020'),('95','01','正常','dic_account_status','0',0,1,'','1','2024-12-26 11:30:07',NULL,'2024-12-26 03:30:07','100020'),('96','02','锁定','dic_account_status','0',0,1,'','1','2024-12-26 11:30:17',NULL,'2024-12-26 03:30:18','100020'),('97','03','禁用','dic_account_status','0',0,1,'','1','2024-12-26 11:30:34',NULL,'2024-12-26 03:30:34','100020'),('98','99','注销','dic_account_status','0',0,1,'','1','2024-12-26 11:30:40',NULL,'2024-12-26 03:30:40','100020'),('99','01','正常','dic_org_status','0',0,1,'','1','2024-12-26 17:20:55',NULL,'2024-12-26 09:20:56','100020');
/*!40000 ALTER TABLE `rrm_dict_entry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rrm_dict_type`
--

DROP TABLE IF EXISTS `rrm_dict_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rrm_dict_type` (
  `id` varchar(36) NOT NULL COMMENT '主键ID',
  `type_code` varchar(50) NOT NULL COMMENT '字典类型编码',
  `type_name` varchar(100) NOT NULL COMMENT '字典类型名称',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `created_by` varchar(36) NOT NULL COMMENT '创建人',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(36) DEFAULT NULL COMMENT '更新人',
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `item_code` varchar(6) NOT NULL COMMENT '项目代码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rrm_dict_type`
--

LOCK TABLES `rrm_dict_type` WRITE;
/*!40000 ALTER TABLE `rrm_dict_type` DISABLE KEYS */;
INSERT INTO `rrm_dict_type` VALUES ('10','dic_res_type','资源类型','','1','2024-09-13 14:46:43',NULL,'2024-09-13 06:46:43','100020'),('11','dic_menu_type','菜单类型','','1','2024-09-13 15:17:51',NULL,'2024-09-13 07:17:52','100020'),('12','dic_menu_element_type','菜单元素类型','','1','2024-09-18 14:33:25',NULL,'2024-09-18 06:33:25','100020'),('13','dic_axios_type','接口请求方式','','1','2024-09-19 14:49:32',NULL,'2024-09-19 06:49:33','100020'),('14','dic_role_type','角色类型','','1','2024-09-20 14:33:57',NULL,'2024-09-20 06:33:56','100020'),('16','dic_service_name','微服务','','1','2024-10-30 14:52:34',NULL,'2024-10-31 03:31:59','100020'),('17','dic_terminal','终端','','1','2024-12-25 09:15:11',NULL,'2024-12-25 01:15:10','100020'),('18','dic_net_type','网络类型','','1','2024-12-25 09:18:22',NULL,'2024-12-25 01:18:21','100020'),('19','dic_account_status','用户状态','','1','2024-12-26 11:29:52',NULL,'2024-12-26 03:29:53','100020'),('20','dic_org_status','单位状态','','1','2024-12-26 17:20:47',NULL,'2024-12-26 09:20:48','100020'),('3','dic_org_type','机构类型','','1','2024-09-10 12:10:44',NULL,'2024-09-10 04:10:45','100020'),('4','dic_user_gender','性别','','1','2024-09-11 16:21:07',NULL,'2024-09-11 08:21:07','100020'),('5','dic_user_nation','民族','','1','2024-09-11 16:24:55',NULL,'2024-09-11 08:24:54','100020'),('6','dic_user_type','用户类型','','1','2024-09-11 16:30:07',NULL,'2024-09-11 08:30:07','100020'),('8','dic_res_environment','环境','','1','2024-09-13 14:35:36',NULL,'2024-09-13 06:49:17','100020'),('9','dic_res_auth_code','授权码','','1','2024-09-13 14:39:27',NULL,'2024-09-13 06:48:19','100020');
/*!40000 ALTER TABLE `rrm_dict_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rrm_item`
--

DROP TABLE IF EXISTS `rrm_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rrm_item` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `item_name` varchar(255) NOT NULL COMMENT '项目名称',
  `item_code` varchar(6) NOT NULL COMMENT '项目编号',
  `created_by` varchar(36) NOT NULL COMMENT '创建人',
  `created_at` timestamp(6) NOT NULL COMMENT '创建时间',
  `updated_by` varchar(36) DEFAULT NULL COMMENT '更新人',
  `updated_at` timestamp(6) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='权限系统-项目管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rrm_item`
--

LOCK TABLES `rrm_item` WRITE;
/*!40000 ALTER TABLE `rrm_item` DISABLE KEYS */;
INSERT INTO `rrm_item` VALUES ('1','开发项目','100020','1','2024-09-02 17:18:39.962000','1','2024-09-12 16:53:23.251000'),('4','test1项目','102356','2','2024-09-13 09:29:32.676000',NULL,NULL);
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
  `created_by` varchar(36) NOT NULL COMMENT '创建人ID',
  `created_at` timestamp(6) NOT NULL COMMENT '创建时间',
  `updated_by` varchar(36) DEFAULT NULL COMMENT '更新人',
  `updated_at` timestamp(6) NULL DEFAULT NULL COMMENT '更新时间',
  `status` tinyint NOT NULL DEFAULT '1' COMMENT '状态（1：启用 ，0：停用）',
  `item_code` varchar(6) NOT NULL COMMENT '项目代码',
  `terminal` varchar(2) NOT NULL COMMENT '终端',
  `net_type` varchar(2) NOT NULL COMMENT '网络类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='接入系统菜单管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rrm_menu`
--

LOCK TABLES `rrm_menu` WRITE;
/*!40000 ALTER TABLE `rrm_menu` DISABLE KEYS */;
INSERT INTO `rrm_menu` VALUES ('19683e2a52820cb267dbd8192801035a','3b6195fe5f85577aee418df9edc94085','开发工具77',NULL,3,1,'/system/dev','01','_self',NULL,0,'1.0','1','2024-09-18 14:31:21.013000','1','2024-12-25 17:26:44.310000',1,'100020','01','01'),('2df1d2a48bf08929628b56a965857814','19683e2a52820cb267dbd8192801035a','代码生成',NULL,0,1,'/system/dev/code','01','_self',NULL,0,'1.0','1','2024-09-18 14:31:56.854000',NULL,NULL,1,'100020','01','01'),('3b6195fe5f85577aee418df9edc94085',NULL,'系统管理中心',NULL,2,1,'/system/dashboard','01','_blank',NULL,0,'1.0','1','2024-09-18 14:29:58.749000',NULL,NULL,1,'100020','01','01'),('8a5522cec0003b64bdde24e7d6bbfc8d',NULL,'数据采集',NULL,1,1,'/data','02','_blank',NULL,0,'1.0','1','2024-09-02 17:20:29.641000','1','2024-12-25 15:11:13.360000',1,'100020','03','03'),('8f3170fa29ac27b27e7f48cfaab5c571','3b6195fe5f85577aee418df9edc94085','菜单管理',NULL,1,1,'/system/menu','01','_self',NULL,0,'1.0','1','2024-09-18 14:30:53.655000',NULL,NULL,1,'100020','01','01');
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
  `status` tinyint NOT NULL DEFAULT '1' COMMENT '状态（1：启用 ，0：停用）',
  `created_by` varchar(36) NOT NULL COMMENT '创建人',
  `created_at` timestamp(6) NOT NULL COMMENT '创建时间',
  `updated_by` varchar(36) DEFAULT NULL COMMENT '更新人',
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
INSERT INTO `rrm_menu_element` VALUES ('b0158c7d40c80830eb19f4b9ab72dcdc','2df1d2a48bf08929628b56a965857814','GitHub','03',1,'1','2024-09-18 14:35:17.388000','1','2025-01-06 14:59:17.923000','100020'),('fe1ed87f0863d6f3caddb4981a41097a','8a5522cec0003b64bdde24e7d6bbfc8d','删除','01',1,'1','2024-09-03 08:57:41.076000','1','2024-09-03 09:33:33.372000','100020');
/*!40000 ALTER TABLE `rrm_menu_element` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rrm_menu_resource`
--

DROP TABLE IF EXISTS `rrm_menu_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rrm_menu_resource` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `menu_id` varchar(36) NOT NULL COMMENT '菜单ID',
  `resource_id` varchar(36) NOT NULL COMMENT '资源ID',
  `type` varchar(2) NOT NULL COMMENT '类型',
  `created_by` varchar(36) NOT NULL COMMENT '创建人',
  `created_at` timestamp(6) NOT NULL COMMENT '创建时间',
  `item_code` varchar(6) NOT NULL COMMENT '项目代码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='菜单（元素）资源关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rrm_menu_resource`
--

LOCK TABLES `rrm_menu_resource` WRITE;
/*!40000 ALTER TABLE `rrm_menu_resource` DISABLE KEYS */;
INSERT INTO `rrm_menu_resource` VALUES ('18734694b673395e58ffa7086c61b188','b0158c7d40c80830eb19f4b9ab72dcdc','10c5ccfc119287d8bdbc0d06ca541ace','02','1','2024-09-24 17:52:17.471000','100020'),('4bb161d70308109d5aa32c984eb82a06','b0158c7d40c80830eb19f4b9ab72dcdc','11aaf656d346c1000a6b489784a04b1a','02','1','2024-09-24 17:52:17.830000','100020'),('5e3f597d31eff59ec0ae4e56ee551c42','2df1d2a48bf08929628b56a965857814','10c5ccfc119287d8bdbc0d06ca541ace','01','1','2024-09-24 17:15:55.604000','100020'),('8b0b409e2102cf6612cdeb8505221665','2df1d2a48bf08929628b56a965857814','11aaf656d346c1000a6b489784a04b1a','01','1','2024-09-24 17:15:56.824000','100020'),('ae7b5c2f24adcbfd9692b6fc357bed94','b0158c7d40c80830eb19f4b9ab72dcdc','046d07b7daf2295a5de0afbc37cc9041','02','1','2024-09-24 17:52:18.562000','100020');
/*!40000 ALTER TABLE `rrm_menu_resource` ENABLE KEYS */;
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
  `parent_id` varchar(36) DEFAULT NULL COMMENT '上级机构ID',
  `name` varchar(500) NOT NULL COMMENT '机构名称',
  `abbr_name` varchar(500) DEFAULT NULL COMMENT '机构名称简称',
  `type` varchar(2) DEFAULT NULL COMMENT '机构类型（dic_org_type）',
  `status` varchar(2) NOT NULL DEFAULT '01' COMMENT '机构状态',
  `extended_field` varchar(255) DEFAULT NULL COMMENT '扩展字段',
  `extended_field2` varchar(255) DEFAULT NULL COMMENT '扩展字段2',
  `created_by` varchar(36) NOT NULL COMMENT '创建者',
  `created_at` timestamp(6) NOT NULL COMMENT '创建时间',
  `updated_by` varchar(36) DEFAULT NULL COMMENT '更新人',
  `updated_at` timestamp(6) NULL DEFAULT NULL COMMENT '更新时间',
  `item_code` varchar(6) NOT NULL COMMENT '项目代码',
  `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除',
  `deleted_at` timestamp(6) NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='任职机构';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rrm_org`
--

LOCK TABLES `rrm_org` WRITE;
/*!40000 ALTER TABLE `rrm_org` DISABLE KEYS */;
INSERT INTO `rrm_org` VALUES ('0851c8c96d4beb5090a004273edd9664','11','','22666','33','01','01',NULL,NULL,'1','2024-09-10 12:34:15.985000',NULL,'2024-11-06 16:04:54.333000','100020',0,NULL),('1','ORG001',NULL,'总部','总部','01','01',NULL,NULL,'1','2024-09-09 01:16:12.000000',NULL,NULL,'100020',0,NULL),('2','ORG002','','分公司A','分A','02','01',NULL,NULL,'1','2024-09-09 01:16:12.000000',NULL,NULL,'100020',0,NULL),('2ff2257eac8472c10ea395898614e955','1000','1','分公司','分公司',NULL,'01',NULL,NULL,'1','2024-12-31 10:52:53.426000',NULL,NULL,'100020',0,NULL),('3','ORG003','','分公司B55','分B55','01','01',NULL,NULL,'1','2024-09-09 01:16:12.000000',NULL,'2024-12-31 10:45:07.686000','100020',0,NULL),('3b7538576b0cf145bde2368ab7f20663','32423342','2','dssss','dssss','01','01',NULL,NULL,'1','2025-01-03 17:55:56.376000',NULL,NULL,'100020',0,NULL),('4','ORG004','','分公司A-子公司A1','A1','01','01',NULL,NULL,'1','2024-09-09 01:16:12.000000',NULL,'2024-11-06 15:56:56.916000','100020',0,NULL),('5','ORG005','','分公司A-子公司A2','A2','02','01',NULL,NULL,'1','2024-09-09 01:16:12.000000',NULL,'2024-11-06 15:57:07.367000','100020',0,NULL),('6','ORG006','','分公司B-子公司B1','B1','01','01',NULL,NULL,'1','2024-09-09 01:16:12.000000',NULL,'2025-01-06 10:09:04.113000','100020',1,'2025-01-06 10:09:04.113000'),('7','ORG007','','分公司A-子公司A1-部门A1-1','A1-1','01','01',NULL,NULL,'1','2024-09-09 01:16:13.000000',NULL,'2024-11-06 15:57:02.848000','100020',0,NULL),('bada6ddc7e6acba83555586590673846','532','','打饭打水','','01','01',NULL,NULL,'1','2024-09-10 12:18:21.792000',NULL,'2024-12-31 10:45:37.386000','100020',1,'2024-12-31 10:45:37.386000'),('c405448b8018dddc0d1459a5ea33452e','33',NULL,'dfadfas','','02','01',NULL,NULL,'1','2024-09-10 12:19:47.222000',NULL,'2024-11-07 09:23:22.087000','100020',0,NULL),('ebf2ed126dcd75f505ae3adebd43bfc8','88',NULL,'888gdsg','7877','01','01',NULL,NULL,'1','2024-09-10 12:20:40.867000',NULL,'2024-12-30 17:50:45.284000','100020',1,'2024-12-30 17:50:45.284000');
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
  `created_by` varchar(36) NOT NULL COMMENT '创建人',
  `created_at` timestamp(6) NOT NULL COMMENT '创建时间',
  `updated_by` varchar(36) DEFAULT NULL COMMENT '更新人',
  `updated_at` timestamp(6) NULL DEFAULT NULL COMMENT '更新时间',
  `status` tinyint NOT NULL DEFAULT '1' COMMENT '状态（1：启用 ，0：停用）',
  `item_code` varchar(6) NOT NULL COMMENT '项目代码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='资源管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rrm_resource`
--

LOCK TABLES `rrm_resource` WRITE;
/*!40000 ALTER TABLE `rrm_resource` DISABLE KEYS */;
INSERT INTO `rrm_resource` VALUES ('013eaac7b8e1f98bdbc6d463fce62b81','rrm','com.rrm.module.user.controller','RrmAuthController','isLogin','/auth/isLogin','GET','权限控制-检查是否登录','01','12','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('035ff6d6e651a43a1d0936c118eae928','rrm','com.rrm.module.menu.controller','RrmMenuResourceController','countMenuBindResourceByMenuId','/menu-resource/count/{menuId}','GET','菜单绑定资源-统计绑定数据量','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('0956cec5439561793055a3bf8e22d9dd','rrm','com.rrm.module.role.controller','RrmRoleMenuController','getRoleBindMenuByRoleId','/role-menu/{roleId}','GET','角色绑定菜单-查询绑定数据','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('0d61510843bd485a4a759655513c0a3f','rrm','com.rrm.module.item.controller','RrmItemController','getCorrelationUserId','/item/correlationUserId/{itemCode}','GET','项目管理-获取项目关联的用户信息','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('1058664a14e25018af47c18767766300','rrm','com.rrm.module.role.controller','RrmRoleController','updateRole','/role','PUT','角色管理-更新','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('1105a397497ded1e3d5d14f78bc17df3','rrm','com.rrm.module.dict.controller','RrmDictEntryController','updateDictEntry','/dict-entry','PUT','字典项-更新字典','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('136eea05702bfa613cf547b13007f136','rrm','com.rrm.module.dict.controller','RrmDictEntryController','searchDictEntryPage','/dict-entry/page','POST','字典项-分页查询','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('1591e116465719abfc69c26fc1a63b86','rrm','com.rrm.module.menu.controller','RrmMenuElementController','countByItemCode','/menu-element/count','GET','菜单控件管理-根据项目统计控件项','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('1753ea70fcb6ce06b205808821d8b904','rrm','com.rrm.module.users.controller','RrmUsersController','getUsers','/users/{id}','GET','用户管理-根据ID获取','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('17bf121d2fd7c92e8b49615167be93ad','rrm','com.rrm.module.dict.controller','RrmDictEntryController','createDictEntry','/dict-entry','POST','字典项-创建新的字典','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('18a330adc5a7b390afb1845f6f760ba4','rrm','com.rrm.module.menu.controller','RrmMenuElementController','createMenuElement','/menu-element','POST','菜单控件管理-创建菜单元素','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('18b2d1bee5d0d1e4acdc4236f3223091','rrm','com.rrm.module.dict.controller','RrmDictEntryController','deleteDictEntry','/dict-entry/{id}','DELETE','字典项-删除字典','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('1aa9a225f201b964adc7ff2c4ead90dc','rrm','com.rrm.module.menu.controller','RrmMenuElementController','deleteMenuElement','/menu-element/{id}','DELETE','菜单控件管理-删除菜单元素','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('1ba000322540ef114e36e228aacfd934','rrm','com.rrm.module.resource.controller','RrmResourceController','updateResourceStatus','/resource/status','PUT','资源管理-更新状态','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('1bf49410cc14acf0e81d1d921e41f949','rrm','com.rrm.module.item.controller','RrmItemController','updateItem','/item','PUT','项目管理-更新','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('2cd3b7c7791099bfd27462077a70b376','rrm','com.rrm.module.resource.controller','RrmResourceController','getPackageNameByTree','/resource/packageNameByTree','GET','资源管理-构建包为树结构','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('2de1c1facef7e533b0abc4dd4e5b3110','rrm','com.rrm.module.menu.controller','RrmMenuController','deleteMenu','/menu/{id}','DELETE','菜单管理-删除菜单','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('2ed9b885ae4070d57a71773b4ad4b8fe','rrm','com.rrm.module.role.controller','RrmRoleController','searchRolePage','/role/page','POST','角色管理-分页查询','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('2eff29120a8088bab321eefde3af7dbd','rrm','com.rrm.module.users.controller','RrmUsersController','searchUsersPage','/users/page','POST','用户管理-分页查询','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('3292f06f602438ef5f969f765cd558fb','rrm','com.rrm.module.menu.controller','RrmMenuElementController','getMenuElementByMenuId','/menu-element/{menuId}/children','GET','菜单控件管理-根据菜单id查询元素','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('33674d312b06305c80da69f56a9b7ff6','rrm','com.rrm.module.org.controller','RrmOrgController','getOrg','/org/{id}','GET','机构管理-根据ID获取','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('397a82b82a4345a59eacfb2170de94db','rrm','com.rrm.module.menu.controller','RrmMenuController','updateMenuSort','/menu/sort','PUT','菜单管理-菜单排序','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('3c6faf6dc662ff3302c81979be0425af','rrm','com.rrm.module.item.controller','RrmItemController','getItem','/item/{id}','GET','项目管理-根据ID查询','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('3eb2fb96bc6c0b383132a995ea15e3b7','rrm','com.rrm.module.role.controller','RrmRoleMenuController','unbindMenuResource','/role-menu/{roleId}/{menuId}/{type}','DELETE','角色绑定菜单-取消绑定','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('42d2b7b9e3bd9a93dc1abc1601f0ee74','rrm','com.rrm.module.users.controller','RrmUsersRoleController','unbindUsersRole','/users-role/{usersId}/{roleId}','DELETE','用户角色关联-取消绑定','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('42d6e42e8b44dbd6fe5c1adf2bc4e43c','rrm','com.rrm.module.dict.controller','RrmDictEntryController','updateDictEntryStatus','/dict-entry/status','PUT','字典项-更新字典状态','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('43426ce9b1d364c25cbff2e27e4f8350','rrm','com.rrm.module.user.controller','RrmUserController','getAllUserBase','/user/allUserBase','GET','用户信息管理-查询所有基本信息','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('43ce88c1db79fe2ca366dc567503c137','rrm','com.rrm.module.dict.controller','RrmDictEntryController','getDictEntry','/dict-entry/{id}','GET','字典项-根据ID查询字典','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('4742151b54715cda6d4235417181bd06','rrm','com.rrm.module.dict.controller','RrmDictTypeController','searchDictTypePage','/dict-type/page','POST','字典类型-分页查询','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('481aad646a38353841fb48474565eedc','rrm','com.rrm.module.menu.controller','RrmMenuController','getMenu','/menu/{id}','GET','菜单管理-根据ID查询','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('5238b75bba3151d5a1932b92f87aa32e','rrm','com.rrm.module.role.controller','RrmRoleController','createRole','/role','POST','角色管理-创建','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('5ac243ff78e6d9540709519c993fb8c1','rrm','com.rrm.module.item.controller','RrmItemController','createItem','/item','POST','项目管理-创建','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('5c05246032937fa6d977035e0f381353','rrm','com.rrm.module.user.controller','RrmAuthController','logOut','/auth/logout','GET','权限控制-退出登录','01','12','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('5da8b3c55ea0274cc8d32d8e934409ec','rrm','com.rrm.module.users.controller','RrmUsersRoleController','bindUsersRole','/users-role','POST','用户角色关联-绑定','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('60c0af2381e877c64ec84a9a04831cb3','rrm','com.rrm.module.org.controller','RrmOrgController','createOrg','/org','POST','机构管理-创建','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('60e2d9c6bd83679223913040136aeb95','rrm','com.rrm.module.menu.controller','RrmMenuElementController','updateMenuElement','/menu-element','PUT','菜单控件管理-更新菜单元素','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('619cd848a388c47f9da41bc467030524','rrm','com.rrm.module.role.controller','RrmRoleController','deleteRole','/role/{id}','DELETE','角色管理-删除','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('642966a57336e891c3b614583ae3d8c6','rrm','com.rrm.module.user.controller','RrmUserController','getAllUser','/user','GET','用户信息管理-查询所有','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('660a75f23223a6ec256509893791de4d','rrm','com.rrm.module.menu.controller','RrmMenuResourceController','getMenuBindResourceByMenuId','/menu-resource/{menuId}','GET','菜单绑定资源-查询绑定数据','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('6a3f5de8a900539a4595da1b1252d768','rrm','com.rrm.module.user.controller','RrmUserController','deleteUser','/user/{id}','DELETE','用户信息管理-删除','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('6ddb1c297ddeaa255bb8d060ad98775f','rrm','com.rrm.module.dict.controller','RrmDictTypeController','deleteDictType','/dict-type/{id}','DELETE','字典类型-删除字典类型','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('71e339fb77d9b00ca77d8adad7283fa6','rrm','com.rrm.module.menu.controller','RrmMenuController','countByItemCode','/menu/count','GET','菜单管理-根据项目统计菜单项','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('7382bfbada530ed837dfb2093db746cc','rrm','com.rrm.module.item.controller','RrmItemController','getAllItem','/item','GET','项目管理-查询所有','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('7c95817e79b96ead4681dc0813659701','rrm','com.rrm.module.dict.controller','RrmDictTypeController','getDictType','/dict-type/{id}','GET','字典类型-根据ID查询字典类型','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('7eb9963250ec2abcf9eea5bf9e345f2c','rrm','com.rrm.module.menu.controller','RrmMenuController','updateMenuParent','/menu/move','PUT','菜单管理-移动菜单','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('7f2ed7c82d60865a3fa2969c2dcc7f25','rrm','com.rrm.module.user.controller','RrmUserController','validatePass','/user/validatePass','POST','用户信息管理-验证密码','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('825b56e6451385fc41f27675e0ec360f','rrm','com.rrm.module.dict.controller','RrmDictEntryController','updateDictEntrySort','/dict-entry/sort','PUT','字典项-更新字典顺序','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('8327541ce7b605cb44333b6ac05874f6','rrm','com.rrm.module.users.controller','RrmUsersRoleController','getUsersBindRoleByUserId','/users-role/{usersId}','GET','用户角色关联-查询绑定数据','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('85173efea5588d38ca5f8d3266519ac1','rrm','com.rrm.module.org.controller','RrmOrgController','updateOrg','/org','PUT','机构管理-更新','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('8803d67737b1ef40fe83b80110254a7c','rrm','com.rrm.module.dict.controller','RrmDictTypeController','createDictType','/dict-type','POST','字典类型-创建新的字典类型','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('890c8d476b96d68683b4f6b046641d60','rrm','com.rrm.module.role.controller','RrmRoleMenuController','bindRoleMenu','/role-menu','POST','角色绑定菜单-绑定','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('8e4653489d5325153d184d7e828d82db','rrm','com.rrm.module.user.controller','RrmUserController','createUser','/user','POST','用户信息管理-创建','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('8e9753ab751a436026993d15ae43a7b4','rrm','com.rrm.module.dict.controller','RrmDictEntryController','getDictEntryByTypeCode','/dict-entry/subitems/{typeCode}','GET','字典项-根据字典类型代码查询字典','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('9395c951f5805aa0e81dd9fc882ae922','rrm','com.rrm.module.user.controller','RrmAuthController','logIn','/auth/login','POST','权限控制-登录','01','12','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('9a6db378bc90465860c1b187876e5755','rrm','com.rrm.module.menu.controller','RrmMenuController','getMenuTreeByItemCode','/menu/tree','GET','菜单管理-根据关联项目查询所有菜单并构建为tree','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('a0fdcb1bc33688f21747f5449d503250','rrm','com.rrm.module.menu.controller','RrmMenuController','createMenu','/menu','POST','菜单管理-创建菜单','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('a3a8d0712e3d06a2f211f3d952e5a921','rrm','com.rrm.module.user.controller','RrmUserController','updateUserDescription','/user/description','PUT','用户信息管理-修改用户描述','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('a800581c34611914d52bd54036eb041e','rrm','com.rrm.module.dict.controller','RrmDictTypeController','updateDictType','/dict-type','PUT','字典类型-更新字典类型','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('a81b28787ca0ee9c47062d9f5e4bf4bd','rrm','com.rrm.module.resource.controller','RrmResourceController','searchResourcePage','/resource/page','POST','资源管理-分页查询','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('a8ddccdf9e9d2c00d84ac0c3a5961b25','rrm','com.rrm.module.menu.controller','RrmMenuResourceController','unbindMenuResource','/menu-resource/{menuId}/{resourceId}','DELETE','菜单绑定资源-取消绑定','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('aa231e30374598d552ae6570812e0fbb','rrm','com.rrm.module.user.controller','RrmUserItemController','createUserItem','/user-item','POST','用户项目关联-创建关联信息','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('ac6bdbf07bfe946f69c0f16d6dc2e29d','rrm','com.rrm.module.menu.controller','RrmMenuController','getMenuByParentId','/menu/children/{parentId}','GET','菜单管理-根据parentId查询子菜单','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('af76047c3f27b74ea4a4f56713b4b66b','rrm','com.rrm.module.resource.controller','RrmResourceController','getServiceNameList','/resource/serviceNameList','GET','资源管理-去重查询所有微服务名','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('afa3c15d8a3606d423aa3280cb672216','rrm','com.rrm.module.user.controller','RrmAuthController','selectItem','/auth/select','PUT','权限控制-选择项目','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('b26a10b3a99bf1f6d5c091434c24b8ef','rrm','com.rrm.module.menu.controller','RrmMenuElementController','getMenuElement','/menu-element/{id}','GET','菜单控件管理-根据ID查询元素','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('b4b223ad2fa771246cedbe14809f640b','rrm','com.rrm.module.resource.controller','RrmResourceController','countResourceByItemCode','/resource/count','GET','资源管理-统计资源数','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('b76ce3aa04e46f94891e3761c2d826ea','rrm','com.rrm.module.item.controller','RrmItemController','deleteItem','/item/{id}','DELETE','项目管理-删除','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('ba83329f7aa75d96668cfcdea8903bb7','rrm','com.rrm.module.user.controller','RrmUserController','updateUserPassword','/user/password','PUT','用户信息管理-修改密码','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('bba8aba6f670d89fafac724132378b7c','rrm','com.rrm.module.users.controller','RrmUsersController','deleteUsers','/users/{id}','DELETE','用户管理-删除','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('c09530c5bee6b4affa68d628f2e00f27','rrm','com.rrm.module.role.controller','RrmRoleController','getRole','/role/{id}','GET','角色管理-根据ID获取','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('c74a362ec7bd2e5c7b55f6806d895f0b','rrm','com.rrm.module.org.controller','RrmOrgController','getOrgTreeByItemCode','/org/tree','GET','机构管理-根据关联项目查询所有机构并构建为tree','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('d0f651573f0809618534767249f4e4c6','rrm','com.rrm.module.users.controller','RrmUsersController','updateUsers','/users','PUT','用户管理-更新','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('d4e10d1e1138c4bb3092d6624fb5e47a','rrm','com.rrm.module.role.controller','RrmRoleController','updateRoleStatus','/role/status','PUT','角色管理-更新状态','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('d693c778a42f5d811897a9c9397b8cb2','rrm','com.rrm.module.menu.controller','RrmMenuController','updateMenu','/menu','PUT','菜单管理-更新菜单','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('d6bfb667f613ca94555b6feb3c073a9f','rrm','com.rrm.module.dict.controller','RrmDictEntryController','selectDictEntryByTypeCode','/dict-entry/select/{typeCode}','GET','字典项-根据字典类型代码查询字典','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('daa4207788ff262d132cb860ce7602f1','rrm','com.rrm.module.org.controller','RrmOrgController','deleteOrg','/org/{id}','DELETE','机构管理-删除','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('e2bacaa89912f01be3b37b4c1adfcb2e','rrm','com.rrm.module.user.controller','RrmUserItemController','deleteUserItem','/user-item/{userId}/{itemCode}','DELETE','用户项目关联-删除关联信息','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('e4bbbbf83fa2e802f6a26c882e2f846d','rrm','com.rrm.module.users.controller','RrmUsersController','createUsers','/users','POST','用户管理-创建','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('e6bac20b491d8d831fb9b04bce04ca04','rrm','com.rrm.module.menu.controller','RrmMenuResourceController','bindMenuResource','/menu-resource','POST','菜单绑定资源-绑定','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('fd700d526feca4a4d12df4002314c219','rrm','com.rrm.module.api.controller','ApiScannerController','run','/scanner/run','POST','资源扫描-资源扫描-执行','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020'),('fff171771bb810385f33c5feeb64e3d4','rrm','com.rrm.module.user.controller','RrmUserController','getUser','/user/{id}','GET','用户信息管理-根据ID获取','01','10','01','1','2024-10-31 16:57:26.945000',NULL,NULL,1,'100020');
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
  `type` varchar(2) NOT NULL DEFAULT '01' COMMENT '类型',
  `sort_order` int NOT NULL COMMENT '顺序号',
  `description` varchar(255) DEFAULT NULL COMMENT '角色描述',
  `created_by` varchar(36) NOT NULL COMMENT '创建人',
  `created_at` timestamp(6) NOT NULL COMMENT '创建时间',
  `updated_by` varchar(36) DEFAULT NULL COMMENT '更新人',
  `updated_at` timestamp(6) NULL DEFAULT NULL COMMENT '更新时间',
  `status` tinyint NOT NULL DEFAULT '1' COMMENT '状态（1：启用 ，0：停用）',
  `item_code` varchar(6) NOT NULL COMMENT '项目代码',
  `terminal` varchar(2) NOT NULL COMMENT '终端',
  `net_type` varchar(2) NOT NULL COMMENT '网络类型',
  `parent_id` varchar(36) DEFAULT NULL COMMENT '父角色ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rrm_role`
--

LOCK TABLES `rrm_role` WRITE;
/*!40000 ALTER TABLE `rrm_role` DISABLE KEYS */;
INSERT INTO `rrm_role` VALUES ('0f154b3a3adce8018a822b5881e2e917','普通角色','01',0,'ddd','1','2024-09-20 14:36:38.777000','1','2025-01-03 15:44:42.760000',1,'100020','01','01',NULL),('18c7de133849c359facdabd3d0d4cf40','区县角色','99',0,'dfsdf','1','2024-09-20 14:36:44.494000','1','2025-01-03 15:44:38.524000',0,'100020','01','01',NULL),('8528fd04ca8b22a781055e2678b5c99e','开发角色','01',0,'','1','2025-01-03 17:50:36.152000',NULL,NULL,1,'100020','01','01','0f154b3a3adce8018a822b5881e2e917'),('3dfed20faefa2635df6baf40913f5542','333','01',0,'','1','2025-01-03 17:52:59.971000',NULL,NULL,1,'100020','01','01','18c7de133849c359facdabd3d0d4cf40'),('cfb3cf7b588f74d5439ea5e933ade584','444','01',0,'','1','2025-01-03 17:55:33.709000',NULL,NULL,1,'100020','01','01','18c7de133849c359facdabd3d0d4cf40');
/*!40000 ALTER TABLE `rrm_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rrm_role_menu`
--

DROP TABLE IF EXISTS `rrm_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rrm_role_menu` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `role_id` varchar(36) NOT NULL COMMENT '角色ID',
  `menu_id` varchar(36) NOT NULL COMMENT '菜单或元素ID',
  `type` varchar(2) NOT NULL COMMENT '类型',
  `created_by` varchar(36) NOT NULL COMMENT '创建人',
  `created_at` timestamp(6) NOT NULL COMMENT '创建时间',
  `item_code` varchar(6) NOT NULL COMMENT '项目代码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色菜单（元素）关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rrm_role_menu`
--

LOCK TABLES `rrm_role_menu` WRITE;
/*!40000 ALTER TABLE `rrm_role_menu` DISABLE KEYS */;
INSERT INTO `rrm_role_menu` VALUES ('00de660da3f67004620ce6a825352259','18c7de133849c359facdabd3d0d4cf40','3b6195fe5f85577aee418df9edc94085','01','1','2024-09-26 10:49:42.567000','100020'),('74e443810daab3c23ed350da32ac0e47','18c7de133849c359facdabd3d0d4cf40','19683e2a52820cb267dbd8192801035a','01','1','2024-09-26 10:49:42.567000','100020'),('8c6985583540f276ecc7ae9217c159cf','18c7de133849c359facdabd3d0d4cf40','b0158c7d40c80830eb19f4b9ab72dcdc','02','1','2024-11-06 15:52:12.621000','100020'),('d8a20fd11f82870a7c71d02f081d242e','18c7de133849c359facdabd3d0d4cf40','2df1d2a48bf08929628b56a965857814','01','1','2024-09-26 10:49:42.567000','100020');
/*!40000 ALTER TABLE `rrm_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rrm_user`
--

DROP TABLE IF EXISTS `rrm_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rrm_user` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `username` varchar(50) NOT NULL COMMENT '账号',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `description` varchar(255) DEFAULT NULL COMMENT '用户描述',
  `created_by` varchar(36) DEFAULT NULL COMMENT '创建人',
  `created_at` timestamp(6) NULL DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(36) DEFAULT NULL COMMENT '更新人',
  `updated_at` timestamp(6) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `i_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rrm_user`
--

LOCK TABLES `rrm_user` WRITE;
/*!40000 ALTER TABLE `rrm_user` DISABLE KEYS */;
INSERT INTO `rrm_user` VALUES ('1','admin','e10adc3949ba59abbe56e057f20f883e','描述信息',NULL,NULL,NULL,NULL),('2','test1','5a105e8b9d40e1329780d62ea2265d8a','','1','2024-09-13 09:27:43.198000',NULL,NULL);
/*!40000 ALTER TABLE `rrm_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rrm_user_item`
--

DROP TABLE IF EXISTS `rrm_user_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rrm_user_item` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `user_id` varchar(36) NOT NULL COMMENT '用户ID',
  `created_by` varchar(36) DEFAULT NULL COMMENT '创建人',
  `created_at` timestamp(6) NULL DEFAULT NULL COMMENT '创建时间',
  `item_code` varchar(6) NOT NULL COMMENT '项目代码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户项目关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rrm_user_item`
--

LOCK TABLES `rrm_user_item` WRITE;
/*!40000 ALTER TABLE `rrm_user_item` DISABLE KEYS */;
INSERT INTO `rrm_user_item` VALUES ('3','1',NULL,NULL,'100020'),('5','2',NULL,NULL,'102356');
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
  `type` varchar(2) DEFAULT NULL COMMENT '用户类型（dic_user_type）',
  `description` varchar(500) DEFAULT NULL COMMENT ' 用户描述',
  `status` varchar(2) NOT NULL COMMENT '用户状态',
  `registration_date` timestamp(6) NULL DEFAULT NULL COMMENT ' 注册时间',
  `last_login_time` timestamp(6) NULL DEFAULT NULL COMMENT '最近登录时间',
  `failed_login_attempts` tinyint DEFAULT NULL COMMENT '登录失败次数',
  `login_count` int DEFAULT NULL COMMENT '登录次数',
  `extended_field` varchar(255) DEFAULT NULL COMMENT '扩展字段',
  `extended_field2` varchar(255) DEFAULT NULL COMMENT '扩展字段2',
  `created_by` varchar(36) NOT NULL COMMENT '创建者',
  `created_at` timestamp(6) NOT NULL COMMENT '创建时间',
  `updated_by` varchar(36) DEFAULT NULL COMMENT '更新者',
  `updated_at` timestamp(6) NULL DEFAULT NULL COMMENT '更新时间',
  `item_code` varchar(6) NOT NULL COMMENT '项目代码 ',
  `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除',
  `deleted_at` timestamp(6) NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='外部用户信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rrm_users`
--

LOCK TABLES `rrm_users` WRITE;
/*!40000 ALTER TABLE `rrm_users` DISABLE KEYS */;
INSERT INTO `rrm_users` VALUES ('7c8c56eeabf075e62c5dfab080d53e04','gbtg01','000000','果宝特攻','1','08','532626199302050325','2025-01-06','18255954685',NULL,'02','用户描述','01',NULL,NULL,NULL,NULL,NULL,NULL,'1','2025-01-06 10:22:44.914000',NULL,NULL,'100020',0,NULL),('91e1e8810999fad4783b9547d3075c85','569852','123454','张三丰','0','02','53262619960302251X','2024-09-13','18255469875',NULL,'01',NULL,'01',NULL,NULL,NULL,NULL,NULL,NULL,'1','2024-09-13 15:22:50.843000','1','2025-01-06 10:19:23.345000','100020',1,'2025-01-06 10:19:23.345000'),('bc3ea5e79338f0169f889c3c9cb2e462','125963','123456','西门吹雪','0','05','53262619960104200X','2024-08-16','18288954685',NULL,NULL,'','01',NULL,NULL,NULL,NULL,NULL,NULL,'1','2024-09-11 14:12:58.825000','1','2025-01-06 10:22:57.409000','100020',0,NULL);
/*!40000 ALTER TABLE `rrm_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rrm_users_org`
--

DROP TABLE IF EXISTS `rrm_users_org`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rrm_users_org` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `users_id` varchar(36) NOT NULL COMMENT '用户ID',
  `org_id` varchar(36) NOT NULL COMMENT '机构ID',
  `created_by` varchar(36) NOT NULL COMMENT '创建人',
  `created_at` timestamp(6) NOT NULL COMMENT '创建时间',
  `item_code` varchar(6) NOT NULL COMMENT '项目代码',
  `default_login` tinyint NOT NULL DEFAULT '0' COMMENT '默认登录',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rrm_users_org`
--

LOCK TABLES `rrm_users_org` WRITE;
/*!40000 ALTER TABLE `rrm_users_org` DISABLE KEYS */;
INSERT INTO `rrm_users_org` VALUES ('268b621d1ab705b530c4cba9bb5cb5f9','7c8c56eeabf075e62c5dfab080d53e04','2ff2257eac8472c10ea395898614e955','1','2025-01-06 10:22:44.930000','100020',0),('6c4a0261edeac3e0b1a012ce3d46aa75','bc3ea5e79338f0169f889c3c9cb2e462','c405448b8018dddc0d1459a5ea33452e','1','2025-01-06 10:22:57.428000','100020',0),('82afc0d4efdde2146249793643cbd531','bc3ea5e79338f0169f889c3c9cb2e462','2','1','2025-01-06 10:22:57.428000','100020',0),('90b4ba963b8214c67748161ef8336cbf','bc3ea5e79338f0169f889c3c9cb2e462','3','1','2025-01-06 10:22:57.428000','100020',0),('ba31831c4eb2a8eeb866c7894968f7df','bc3ea5e79338f0169f889c3c9cb2e462','2ff2257eac8472c10ea395898614e955','1','2025-01-06 10:22:57.428000','100020',0),('f90bf8ba06e2b21a0440920335de10e7','bc3ea5e79338f0169f889c3c9cb2e462','3b7538576b0cf145bde2368ab7f20663','1','2025-01-06 10:22:57.428000','100020',0);
/*!40000 ALTER TABLE `rrm_users_org` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rrm_users_role`
--

DROP TABLE IF EXISTS `rrm_users_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rrm_users_role` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `users_id` varchar(36) NOT NULL COMMENT '用户ID',
  `role_id` varchar(36) NOT NULL COMMENT '角色ID',
  `org_id` varchar(36) NOT NULL COMMENT '机构ID',
  `created_by` varchar(36) NOT NULL COMMENT '创建人',
  `created_at` timestamp(6) NOT NULL COMMENT '创建时间',
  `item_code` varchar(6) NOT NULL COMMENT '项目代码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户角色关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rrm_users_role`
--

LOCK TABLES `rrm_users_role` WRITE;
/*!40000 ALTER TABLE `rrm_users_role` DISABLE KEYS */;
INSERT INTO `rrm_users_role` VALUES ('34f6c8792f1a7576cb4e0f1b944ea828','7c8c56eeabf075e62c5dfab080d53e04','8528fd04ca8b22a781055e2678b5c99e','2ff2257eac8472c10ea395898614e955','1','2025-01-06 10:23:10.967000','100020'),('3f4642b26322e3914696b2d8d59123e6','7c8c56eeabf075e62c5dfab080d53e04','3dfed20faefa2635df6baf40913f5542','2ff2257eac8472c10ea395898614e955','1','2025-01-06 10:23:10.967000','100020'),('4407b403f7dcf63fdef9237cd5cb9980','7c8c56eeabf075e62c5dfab080d53e04','18c7de133849c359facdabd3d0d4cf40','2ff2257eac8472c10ea395898614e955','1','2025-01-06 10:23:10.967000','100020'),('551c54495039f8244d548062f1aca341','7c8c56eeabf075e62c5dfab080d53e04','0f154b3a3adce8018a822b5881e2e917','2ff2257eac8472c10ea395898614e955','1','2025-01-06 10:23:10.967000','100020'),('75a32cf33d016e0e19e2314c1e7434b7','7c8c56eeabf075e62c5dfab080d53e04','cfb3cf7b588f74d5439ea5e933ade584','2ff2257eac8472c10ea395898614e955','1','2025-01-06 10:23:10.967000','100020');
/*!40000 ALTER TABLE `rrm_users_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ynrk_lhryxx`
--

DROP TABLE IF EXISTS `ynrk_lhryxx`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ynrk_lhryxx` (
  `pkid` varchar(40) DEFAULT NULL,
  `zsqh` varchar(6) DEFAULT NULL,
  `ywfldm` varchar(10) DEFAULT NULL,
  `gxsj` datetime DEFAULT NULL,
  `xm` varchar(50) DEFAULT NULL,
  `gmsfhm` varchar(18) DEFAULT NULL,
  `xbdm` varchar(3) DEFAULT NULL,
  `mzdm` varchar(3) DEFAULT NULL,
  `csrq_gl` datetime DEFAULT NULL,
  `hjdz_qhnxxdz` varchar(120) DEFAULT NULL,
  `hjdz_ssxqdm` varchar(6) DEFAULT NULL,
  `lhdwmc` varchar(200) DEFAULT NULL,
  `lhgajgdwdm` varchar(22) DEFAULT NULL,
  `qcddwmc` varchar(200) DEFAULT NULL,
  `qcdgajgdwdm` varchar(22) DEFAULT NULL,
  `hyzkdm` varchar(3) DEFAULT NULL,
  `zjxydm` varchar(3) DEFAULT NULL,
  `byzkdm` varchar(3) DEFAULT NULL,
  `xldm` varchar(4) DEFAULT NULL,
  `xxdm` varchar(3) DEFAULT NULL,
  `sg` varchar(10) DEFAULT NULL,
  `cyzk_zylbdm` varchar(3) DEFAULT NULL,
  `cyzk_zy` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ynrk_lhryxx`
--

LOCK TABLES `ynrk_lhryxx` WRITE;
/*!40000 ALTER TABLE `ynrk_lhryxx` DISABLE KEYS */;
INSERT INTO `ynrk_lhryxx` VALUES ('bd6b5235-a592-11ef-9567-0242ac110002','530500','010101','2024-11-18 17:51:53','张三','123456789012345678','001','001','1990-01-01 00:00:00','北京市朝阳区某街道某小区1号楼101室','110105','某派出所','110105000000000001','某公安机关','110105000000000002','001','002','003','004','001','175','001','软件工程师'),('bd6fcaf4-a592-11ef-9567-0242ac110002','530500','010101','2024-11-16 17:51:53','李四','876543210987654321','002','002','1985-05-15 00:00:00','上海市浦东新区某街道某小区2号楼202室','310115','某派出所','310115000000000001','某公安机关','310115000000000002','002','003','004','005','002','180','002','建筑设计师'),('bd702500-a592-11ef-9567-0242ac110002','530500','010101','2024-11-18 17:51:53','王五','345678901234567890','001','003','1992-09-20 00:00:00','广州市天河区某街道某小区3号楼303室','440106','某派出所','440106000000000001','某公安机关','440106000000000002','003','004','005','006','003','165','003','医生');
/*!40000 ALTER TABLE `ynrk_lhryxx` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ynrk_qczxryxx`
--

DROP TABLE IF EXISTS `ynrk_qczxryxx`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ynrk_qczxryxx` (
  `pkid` varchar(40) DEFAULT NULL,
  `zsqh` varchar(6) DEFAULT NULL,
  `ywfldm` varchar(10) DEFAULT NULL,
  `gxsj` datetime DEFAULT NULL,
  `xm` varchar(50) DEFAULT NULL,
  `gmsfhm` varchar(18) DEFAULT NULL,
  `xbdm` varchar(3) DEFAULT NULL,
  `mzdm` varchar(3) DEFAULT NULL,
  `csrq_gl` datetime DEFAULT NULL,
  `hjdz_qhnxxdz` varchar(120) DEFAULT NULL,
  `hjdz_ssxqdm` varchar(6) DEFAULT NULL,
  `qczxdwmc` varchar(200) DEFAULT NULL,
  `qczxgajgdwdm` varchar(22) DEFAULT NULL,
  `hyzkdm` varchar(3) DEFAULT NULL,
  `xldm` varchar(4) DEFAULT NULL,
  `xxdm` varchar(3) DEFAULT NULL,
  `cyzk_zy` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ynrk_qczxryxx`
--

LOCK TABLES `ynrk_qczxryxx` WRITE;
/*!40000 ALTER TABLE `ynrk_qczxryxx` DISABLE KEYS */;
INSERT INTO `ynrk_qczxryxx` VALUES ('f333cfe4-a592-11ef-9567-0242ac110002','530500','010102_01','2024-11-18 17:53:23','张三','123456789012345678','001','01','1990-01-01 00:00:00','北京市朝阳区某小区1号楼101室','110105','朝阳区公安局','110105000000000001','001','004','001','软件工程师'),('f3344b12-a592-11ef-9567-0242ac110002','530500','010102_04','2024-11-18 18:53:23','李四','876543210987654321','002','02','1985-05-15 00:00:00','上海市浦东新区某小区2号楼202室','310115','浦东新区公安局','310115000000000002','002','005','002','建筑设计师'),('f33450e9-a592-11ef-9567-0242ac110002','530500','010102_01','2024-11-16 17:53:23','王五','345678901234567890','001','03','1992-09-20 00:00:00','广州市天河区某小区3号楼303室','440106','天河区公安局','440106000000000003','003','006','003','医生');
/*!40000 ALTER TABLE `ynrk_qczxryxx` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ynrk_rybgxmxx`
--

DROP TABLE IF EXISTS `ynrk_rybgxmxx`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ynrk_rybgxmxx` (
  `pkid` varchar(40) DEFAULT NULL,
  `zsqh` varchar(6) DEFAULT NULL,
  `ywfldm` varchar(10) DEFAULT NULL,
  `gxsj` datetime DEFAULT NULL,
  `bgr_xm` varchar(30) DEFAULT NULL,
  `bgr_gmsfhm` varchar(18) DEFAULT NULL,
  `bgr_xbdm` varchar(3) DEFAULT NULL,
  `bgr_mzdm` varchar(3) DEFAULT NULL,
  `bgr_csrq_gl` datetime DEFAULT NULL,
  `hjddwmc` varchar(200) DEFAULT NULL,
  `hjdgajgdwdm` varchar(22) DEFAULT NULL,
  `bggzsjxmc` varchar(30) DEFAULT NULL,
  `bggzqnrmc` varchar(200) DEFAULT NULL,
  `bggzhnrmc` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ynrk_rybgxmxx`
--

LOCK TABLES `ynrk_rybgxmxx` WRITE;
/*!40000 ALTER TABLE `ynrk_rybgxmxx` DISABLE KEYS */;
/*!40000 ALTER TABLE `ynrk_rybgxmxx` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ynrk_ryjbxx`
--

DROP TABLE IF EXISTS `ynrk_ryjbxx`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ynrk_ryjbxx` (
  `pkid` varchar(40) DEFAULT NULL,
  `zsqh` varchar(6) DEFAULT NULL,
  `gxsj` datetime DEFAULT NULL,
  `xm` varchar(50) DEFAULT NULL,
  `gmsfhm` varchar(18) DEFAULT NULL,
  `xbdm` varchar(3) DEFAULT NULL,
  `mzdm` varchar(3) DEFAULT NULL,
  `csrq_gl` datetime DEFAULT NULL,
  `hjdz_qhnxxdz` varchar(100) DEFAULT NULL,
  `hjdz_ssxqdm` varchar(6) DEFAULT NULL,
  `hjdpcsmc` varchar(200) DEFAULT NULL,
  `hjdgajgdwdm` varchar(22) DEFAULT NULL,
  `hyzkdm` varchar(3) DEFAULT NULL,
  `zjxydm` varchar(3) DEFAULT NULL,
  `byzkdm` varchar(3) DEFAULT NULL,
  `xldm` varchar(4) DEFAULT NULL,
  `xxdm` varchar(3) DEFAULT NULL,
  `sg` varchar(10) DEFAULT NULL,
  `cyzk_zylbdm` varchar(3) DEFAULT NULL,
  `cyzk_zy` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ynrk_ryjbxx`
--

LOCK TABLES `ynrk_ryjbxx` WRITE;
/*!40000 ALTER TABLE `ynrk_ryjbxx` DISABLE KEYS */;
/*!40000 ALTER TABLE `ynrk_ryjbxx` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-06  7:16:47
