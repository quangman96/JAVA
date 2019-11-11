-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: inventory_management
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `brand`
--

DROP TABLE IF EXISTS `brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `brand` (
  `idBrand` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `isDelete` tinyint(1) DEFAULT '0',
  `deleteBy` varchar(45) DEFAULT NULL,
  `deleteDate` timestamp NULL DEFAULT NULL,
  `modifyBy` varchar(45) DEFAULT NULL,
  `modifyDate` timestamp NULL DEFAULT NULL,
  `createBy` varchar(45) NOT NULL,
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `new_column` int(11) DEFAULT NULL,
  PRIMARY KEY (`idBrand`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand`
--

LOCK TABLES `brand` WRITE;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` VALUES (1,'Apple',0,NULL,NULL,NULL,NULL,'Thanh','2019-11-09 12:26:13',NULL);
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detail_export_order`
--

DROP TABLE IF EXISTS `detail_export_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detail_export_order` (
  `idExportOrder` int(11) NOT NULL,
  `idPhone` int(11) NOT NULL,
  `phoneAmount` int(11) NOT NULL,
  `idDelete` tinyint(1) DEFAULT '0',
  `deleteBy` varchar(45) DEFAULT NULL,
  `deleteDate` timestamp NULL DEFAULT NULL,
  `modifyBy` varchar(45) DEFAULT NULL,
  `modifyDate` timestamp NULL DEFAULT NULL,
  `createBy` varchar(45) NOT NULL,
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idExportOrder`),
  KEY `FK_phone_detailEX_idx` (`idPhone`),
  CONSTRAINT `FK_ex_detailEx` FOREIGN KEY (`idExportOrder`) REFERENCES `export_order` (`idExportOrder`),
  CONSTRAINT `FK_phone_detailEX` FOREIGN KEY (`idPhone`) REFERENCES `phone` (`idPhone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detail_export_order`
--

LOCK TABLES `detail_export_order` WRITE;
/*!40000 ALTER TABLE `detail_export_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `detail_export_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detail_import_order`
--

DROP TABLE IF EXISTS `detail_import_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detail_import_order` (
  `idImportOrder` int(11) NOT NULL,
  `idPhone` int(11) NOT NULL,
  `phoneAmount` int(11) DEFAULT NULL,
  `idDelete` tinyint(1) DEFAULT '0',
  `deleteBy` varchar(45) DEFAULT NULL,
  `deleteDate` timestamp NULL DEFAULT NULL,
  `modifyBy` varchar(45) DEFAULT NULL,
  `modifyDate` timestamp NULL DEFAULT NULL,
  `createBy` varchar(45) NOT NULL,
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idImportOrder`,`idPhone`),
  KEY `FK_phone_IM_idx` (`idPhone`),
  CONSTRAINT `FK_detailIM_IM` FOREIGN KEY (`idImportOrder`) REFERENCES `import_order` (`idImportOrder`),
  CONSTRAINT `FK_phone_detailIM` FOREIGN KEY (`idPhone`) REFERENCES `phone` (`idPhone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detail_import_order`
--

LOCK TABLES `detail_import_order` WRITE;
/*!40000 ALTER TABLE `detail_import_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `detail_import_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detail_stock`
--

DROP TABLE IF EXISTS `detail_stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detail_stock` (
  `idStock` int(11) NOT NULL,
  `idPhone` int(11) NOT NULL,
  `phoneAmount` int(11) NOT NULL,
  `idDelete` tinyint(1) DEFAULT '0',
  `deleteBy` varchar(45) DEFAULT NULL,
  `deleteDate` timestamp NULL DEFAULT NULL,
  `modifyBy` varchar(45) DEFAULT NULL,
  `modifyDate` timestamp NULL DEFAULT NULL,
  `createBy` varchar(45) NOT NULL,
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idStock`,`idPhone`),
  KEY `FK_phone_detailStock_idx` (`idPhone`),
  CONSTRAINT `FK_phone_detailStock` FOREIGN KEY (`idPhone`) REFERENCES `phone` (`idPhone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detail_stock`
--

LOCK TABLES `detail_stock` WRITE;
/*!40000 ALTER TABLE `detail_stock` DISABLE KEYS */;
/*!40000 ALTER TABLE `detail_stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detail_store`
--

DROP TABLE IF EXISTS `detail_store`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detail_store` (
  `idStore` int(11) NOT NULL,
  `idPhone` int(11) NOT NULL,
  `phoneAmount` int(11) NOT NULL,
  `idDelete` tinyint(1) DEFAULT '0',
  `deleteBy` varchar(45) DEFAULT NULL,
  `deleteDate` timestamp NULL DEFAULT NULL,
  `modifyBy` varchar(45) DEFAULT NULL,
  `modifyDate` timestamp NULL DEFAULT NULL,
  `createBy` varchar(45) NOT NULL,
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idStore`,`idPhone`),
  KEY `FK_phone_Store_idx` (`idPhone`),
  CONSTRAINT `FK_store_detailStore` FOREIGN KEY (`idStore`) REFERENCES `store` (`idStore`),
  CONSTRAINT `Fk_phone_detailStore` FOREIGN KEY (`idPhone`) REFERENCES `phone` (`idPhone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detail_store`
--

LOCK TABLES `detail_store` WRITE;
/*!40000 ALTER TABLE `detail_store` DISABLE KEYS */;
/*!40000 ALTER TABLE `detail_store` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `export_order`
--

DROP TABLE IF EXISTS `export_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `export_order` (
  `idExportOrder` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `idStaff` int(11) NOT NULL,
  `idStock` int(11) DEFAULT NULL,
  `idStore` int(11) NOT NULL,
  `exportDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idDelete` tinyint(1) DEFAULT '0',
  `deleteBy` varchar(45) DEFAULT NULL,
  `deleteDate` timestamp NULL DEFAULT NULL,
  `modifyBy` varchar(45) DEFAULT NULL,
  `modifyDate` timestamp NULL DEFAULT NULL,
  `createBy` varchar(45) NOT NULL,
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idExportOrder`),
  KEY `FK_staff_Ex_idx` (`idStaff`),
  KEY `FK_store_EX_idx` (`idStore`),
  KEY `FK_stock_Ex_idx` (`idStock`),
  CONSTRAINT `FK_staff_Ex` FOREIGN KEY (`idStaff`) REFERENCES `staff` (`idStaff`),
  CONSTRAINT `FK_stock_Ex` FOREIGN KEY (`idStock`) REFERENCES `stock` (`idStock`),
  CONSTRAINT `FK_store_EX` FOREIGN KEY (`idStore`) REFERENCES `store` (`idStore`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `export_order`
--

LOCK TABLES `export_order` WRITE;
/*!40000 ALTER TABLE `export_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `export_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `import_order`
--

DROP TABLE IF EXISTS `import_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `import_order` (
  `idImportOrder` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `idStaff` int(11) NOT NULL,
  `idStock` int(11) NOT NULL,
  `importDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idDelete` tinyint(1) DEFAULT '0',
  `deleteBy` varchar(45) DEFAULT NULL,
  `deleteDate` timestamp NULL DEFAULT NULL,
  `modifyBy` varchar(45) DEFAULT NULL,
  `modifyDate` timestamp NULL DEFAULT NULL,
  `createBy` varchar(45) NOT NULL,
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idImportOrder`),
  KEY `FK_staff_IM_idx` (`idStaff`),
  KEY `FK_stock_IM_idx` (`idStock`),
  CONSTRAINT `FK_staff_IM` FOREIGN KEY (`idStaff`) REFERENCES `staff` (`idStaff`),
  CONSTRAINT `FK_stock_IM` FOREIGN KEY (`idStock`) REFERENCES `stock` (`idStock`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `import_order`
--

LOCK TABLES `import_order` WRITE;
/*!40000 ALTER TABLE `import_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `import_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone`
--

DROP TABLE IF EXISTS `phone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phone` (
  `idPhone` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `amount` int(11) NOT NULL,
  `information` text NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `idBrand` int(11) NOT NULL,
  `isDelete` tinyint(1) DEFAULT '0',
  `deleteBy` varchar(45) DEFAULT NULL,
  `deleteDate` timestamp NULL DEFAULT NULL,
  `modifyBy` varchar(45) DEFAULT NULL,
  `modifyDate` timestamp NULL DEFAULT NULL,
  `createBy` varchar(45) NOT NULL,
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idPhone`),
  KEY `fk_brand_phone_idx` (`idBrand`),
  CONSTRAINT `fk_brand_phone` FOREIGN KEY (`idBrand`) REFERENCES `brand` (`idBrand`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone`
--

LOCK TABLES `phone` WRITE;
/*!40000 ALTER TABLE `phone` DISABLE KEYS */;
INSERT INTO `phone` VALUES (2,'Iphone11',20,'abc','demo',1,0,NULL,NULL,NULL,NULL,'Thanh','2019-11-09 12:26:22'),(3,'Iphone X',30,'cxz','demo01',1,0,NULL,NULL,NULL,NULL,'Thanh','2019-11-09 16:46:11');
/*!40000 ALTER TABLE `phone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff` (
  `idStaff` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `address` varchar(255) NOT NULL,
  `phoneNumber` varchar(45) NOT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `idDelete` tinyint(1) DEFAULT '0',
  `deleteBy` varchar(45) DEFAULT NULL,
  `deleteDate` timestamp NULL DEFAULT NULL,
  `modifyBy` varchar(45) DEFAULT NULL,
  `modifyDate` timestamp NULL DEFAULT NULL,
  `createBy` varchar(45) NOT NULL,
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idStaff`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock` (
  `idStock` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phoneNumber` varchar(45) NOT NULL,
  `idDelete` tinyint(1) DEFAULT '0',
  `deleteBy` varchar(45) DEFAULT NULL,
  `deleteDate` timestamp NULL DEFAULT NULL,
  `modifyBy` varchar(45) DEFAULT NULL,
  `modifyDate` timestamp NULL DEFAULT NULL,
  `createBy` varchar(45) NOT NULL,
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idStock`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `store`
--

DROP TABLE IF EXISTS `store`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `store` (
  `idStore` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `address` varchar(45) NOT NULL,
  `phoneNumber` varchar(45) NOT NULL,
  `isDelete` tinyint(1) DEFAULT '0',
  `deleteBy` varchar(45) DEFAULT NULL,
  `deleteDate` timestamp NULL DEFAULT NULL,
  `modifyBy` varchar(45) DEFAULT NULL,
  `modifyDate` timestamp NULL DEFAULT NULL,
  `createBy` varchar(45) NOT NULL,
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idStore`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store`
--

LOCK TABLES `store` WRITE;
/*!40000 ALTER TABLE `store` DISABLE KEYS */;
/*!40000 ALTER TABLE `store` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-10  8:37:59
