CREATE DATABASE  IF NOT EXISTS `TALONDB` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `TALONDB`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: 192.168.1.254    Database: TALONDB
-- ------------------------------------------------------
-- Server version	5.5.29-0ubuntu0.12.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `AUTHORITIES`
--

DROP TABLE IF EXISTS `AUTHORITIES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `AUTHORITIES` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `AUTHORITY` varchar(50) NOT NULL,
  `USERS_ID` int(11) DEFAULT NULL,
  `ENABLED` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  KEY `fk_authorities_users1_idx` (`USERS_ID`),
  CONSTRAINT `fk_authorities_users1` FOREIGN KEY (`USERS_ID`) REFERENCES `USERS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AUTHORITIES`
--

LOCK TABLES `AUTHORITIES` WRITE;
/*!40000 ALTER TABLE `AUTHORITIES` DISABLE KEYS */;
/*!40000 ALTER TABLE `AUTHORITIES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CUSTOMER`
--

DROP TABLE IF EXISTS `CUSTOMER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CUSTOMER` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `UUID` char(36) NOT NULL,
  `CUST_NAME` varchar(45) NOT NULL,
  `ENABLED` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UUID_UNIQUE` (`UUID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CUSTOMER`
--

LOCK TABLES `CUSTOMER` WRITE;
/*!40000 ALTER TABLE `CUSTOMER` DISABLE KEYS */;
INSERT INTO `CUSTOMER` VALUES (1,'163572C0-9157-11E2-9E96-0800200C9A66','slvrstream',0);
/*!40000 ALTER TABLE `CUSTOMER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CUSTOMER_CUSTOM_DATA_SET`
--

DROP TABLE IF EXISTS `CUSTOMER_CUSTOM_DATA_SET`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CUSTOMER_CUSTOM_DATA_SET` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DATA_SET_NAME` varchar(45) NOT NULL,
  `CUSTOMER_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_CUSTOMER_DS_CUSTOMER1_idx` (`CUSTOMER_ID`),
  CONSTRAINT `fk_CUSTOMER_DS_CUSTOMER1` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `CUSTOMER` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CUSTOMER_CUSTOM_DATA_SET`
--

LOCK TABLES `CUSTOMER_CUSTOM_DATA_SET` WRITE;
/*!40000 ALTER TABLE `CUSTOMER_CUSTOM_DATA_SET` DISABLE KEYS */;
/*!40000 ALTER TABLE `CUSTOMER_CUSTOM_DATA_SET` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CUSTOM_DATA`
--

DROP TABLE IF EXISTS `CUSTOM_DATA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CUSTOM_DATA` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(75) NOT NULL,
  `VALUE_PREFIX` varchar(255) NOT NULL,
  `SORT_ORDER` int(11) NOT NULL DEFAULT '0',
  `RAW_DATA_ID` int(11) DEFAULT NULL,
  `DATA_TYPE_ID` int(11) NOT NULL,
  `PROPERTY_DATA_UUID` char(36) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `PROPERTY_DATA_UUID_UNIQUE` (`PROPERTY_DATA_UUID`),
  KEY `fk_DYNAMIC_DATA_RAW_DATA1_idx` (`RAW_DATA_ID`),
  KEY `fk_DYNAMIC_DATA_DATA_TYPE1_idx` (`DATA_TYPE_ID`),
  KEY `fk_CUSTOM_DATA_PROPERTY_DATA1_idx` (`PROPERTY_DATA_UUID`),
  CONSTRAINT `fk_CUSTOM_DATA_PROPERTY_DATA1` FOREIGN KEY (`PROPERTY_DATA_UUID`) REFERENCES `PROPERTY_DATA` (`UUID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_DYNAMIC_DATA_DATA_TYPE1` FOREIGN KEY (`DATA_TYPE_ID`) REFERENCES `DATA_TYPE` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_DYNAMIC_DATA_RAW_DATA1` FOREIGN KEY (`RAW_DATA_ID`) REFERENCES `RAW_DATA` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CUSTOM_DATA`
--

LOCK TABLES `CUSTOM_DATA` WRITE;
/*!40000 ALTER TABLE `CUSTOM_DATA` DISABLE KEYS */;
/*!40000 ALTER TABLE `CUSTOM_DATA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DATA_SET_DATA`
--

DROP TABLE IF EXISTS `DATA_SET_DATA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DATA_SET_DATA` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FIELD_NAME` varchar(75) NOT NULL,
  `VALUE_PREFIX` varchar(255) NOT NULL,
  `SORT_ORDER` int(11) NOT NULL,
  `DATA_TYPE_ID` int(11) NOT NULL,
  `CUSTOMER_DS_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_DS_DATA_DATA_TYPE1_idx` (`DATA_TYPE_ID`),
  KEY `fk_DS_DATA_CUSTOMER_DS1_idx` (`CUSTOMER_DS_ID`),
  CONSTRAINT `fk_DS_DATA_CUSTOMER_DS1` FOREIGN KEY (`CUSTOMER_DS_ID`) REFERENCES `CUSTOMER_CUSTOM_DATA_SET` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_DS_DATA_DATA_TYPE1` FOREIGN KEY (`DATA_TYPE_ID`) REFERENCES `DATA_TYPE` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DATA_SET_DATA`
--

LOCK TABLES `DATA_SET_DATA` WRITE;
/*!40000 ALTER TABLE `DATA_SET_DATA` DISABLE KEYS */;
/*!40000 ALTER TABLE `DATA_SET_DATA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DATA_SOURCE`
--

DROP TABLE IF EXISTS `DATA_SOURCE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DATA_SOURCE` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `CUST_UUID` char(36) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_custUUid_idx` (`CUST_UUID`),
  CONSTRAINT `fk_custUUid` FOREIGN KEY (`CUST_UUID`) REFERENCES `CUSTOMER` (`UUID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DATA_SOURCE`
--

LOCK TABLES `DATA_SOURCE` WRITE;
/*!40000 ALTER TABLE `DATA_SOURCE` DISABLE KEYS */;
INSERT INTO `DATA_SOURCE` VALUES (1,'PropertyBase Prop Listings','163572C0-9157-11E2-9E96-0800200C9A66');
/*!40000 ALTER TABLE `DATA_SOURCE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DATA_TYPE`
--

DROP TABLE IF EXISTS `DATA_TYPE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DATA_TYPE` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DATA_TYPE`
--

LOCK TABLES `DATA_TYPE` WRITE;
/*!40000 ALTER TABLE `DATA_TYPE` DISABLE KEYS */;
/*!40000 ALTER TABLE `DATA_TYPE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ETL_JOB`
--

DROP TABLE IF EXISTS `ETL_JOB`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ETL_JOB` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `JOB_NAME` varchar(75) NOT NULL,
  `CRE_DTM` datetime NOT NULL,
  `ENABLED` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `JOB_NAME_UNIQUE` (`JOB_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ETL_JOB`
--

LOCK TABLES `ETL_JOB` WRITE;
/*!40000 ALTER TABLE `ETL_JOB` DISABLE KEYS */;
/*!40000 ALTER TABLE `ETL_JOB` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ETL_JOB_PROPERTIES`
--

DROP TABLE IF EXISTS `ETL_JOB_PROPERTIES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ETL_JOB_PROPERTIES` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `KEY` varchar(75) NOT NULL,
  `VALUE` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ETL_JOB_PROPERTIES`
--

LOCK TABLES `ETL_JOB_PROPERTIES` WRITE;
/*!40000 ALTER TABLE `ETL_JOB_PROPERTIES` DISABLE KEYS */;
/*!40000 ALTER TABLE `ETL_JOB_PROPERTIES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ETL_JOB_PROP_MAP`
--

DROP TABLE IF EXISTS `ETL_JOB_PROP_MAP`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ETL_JOB_PROP_MAP` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ETL_JOB_ID` int(11) NOT NULL,
  `ETL_JOB_PROPERTIES_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_ETL_JOB_PROP_MAP_ETL_JOB1_idx` (`ETL_JOB_ID`),
  KEY `fk_ETL_JOB_PROP_MAP_ETL_JOB_PROPERTIES1_idx` (`ETL_JOB_PROPERTIES_ID`),
  CONSTRAINT `fk_ETL_JOB_PROP_MAP_ETL_JOB1` FOREIGN KEY (`ETL_JOB_ID`) REFERENCES `ETL_JOB` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ETL_JOB_PROP_MAP_ETL_JOB_PROPERTIES1` FOREIGN KEY (`ETL_JOB_PROPERTIES_ID`) REFERENCES `ETL_JOB_PROPERTIES` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ETL_JOB_PROP_MAP`
--

LOCK TABLES `ETL_JOB_PROP_MAP` WRITE;
/*!40000 ALTER TABLE `ETL_JOB_PROP_MAP` DISABLE KEYS */;
/*!40000 ALTER TABLE `ETL_JOB_PROP_MAP` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ETL_JOB_QUEUE`
--

DROP TABLE IF EXISTS `ETL_JOB_QUEUE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ETL_JOB_QUEUE` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `RUN_DTM` datetime NOT NULL,
  `END_DTM` datetime NOT NULL,
  `RUNNING` tinyint(4) NOT NULL DEFAULT '0',
  `ASSIGNED` tinyint(4) NOT NULL DEFAULT '0',
  `COMPLETE` tinyint(4) NOT NULL DEFAULT '0',
  `JOB_SERVER_ID` int(11) NOT NULL,
  `ETL_JOB_ID` int(11) NOT NULL,
  `JOB_STATUS_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_ETL_JOB_QUEUE_JOB_SERVER1_idx` (`JOB_SERVER_ID`),
  KEY `fk_ETL_JOB_QUEUE_ETL_JOB1_idx` (`ETL_JOB_ID`),
  KEY `fk_ETL_JOB_QUEUE_STATUS1_idx` (`JOB_STATUS_ID`),
  CONSTRAINT `fk_ETL_JOB_QUEUE_ETL_JOB1` FOREIGN KEY (`ETL_JOB_ID`) REFERENCES `ETL_JOB` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ETL_JOB_QUEUE_JOB_SERVER1` FOREIGN KEY (`JOB_SERVER_ID`) REFERENCES `JOB_SERVER` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ETL_JOB_QUEUE_STATUS1` FOREIGN KEY (`JOB_STATUS_ID`) REFERENCES `JOB_STATUS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ETL_JOB_QUEUE`
--

LOCK TABLES `ETL_JOB_QUEUE` WRITE;
/*!40000 ALTER TABLE `ETL_JOB_QUEUE` DISABLE KEYS */;
/*!40000 ALTER TABLE `ETL_JOB_QUEUE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ETL_JOB_SCHEDULE`
--

DROP TABLE IF EXISTS `ETL_JOB_SCHEDULE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ETL_JOB_SCHEDULE` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `RUN_DAY` varchar(2) NOT NULL,
  `RUN_HOUR` varchar(2) NOT NULL,
  `RUN_MIN` varchar(2) NOT NULL,
  `ENABLED` tinyint(4) NOT NULL DEFAULT '0',
  `CRE_DTM` datetime DEFAULT NULL,
  `CRE_USER` int(11) DEFAULT NULL,
  `ETL_JOB_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_ETL_JOB_SCHEDULE_ETL_JOB1_idx` (`ETL_JOB_ID`),
  CONSTRAINT `fk_ETL_JOB_SCHEDULE_ETL_JOB1` FOREIGN KEY (`ETL_JOB_ID`) REFERENCES `ETL_JOB` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ETL_JOB_SCHEDULE`
--

LOCK TABLES `ETL_JOB_SCHEDULE` WRITE;
/*!40000 ALTER TABLE `ETL_JOB_SCHEDULE` DISABLE KEYS */;
/*!40000 ALTER TABLE `ETL_JOB_SCHEDULE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `FINACIAL_KEY`
--

DROP TABLE IF EXISTS `FINACIAL_KEY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `FINACIAL_KEY` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `KEY` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FINACIAL_KEY`
--

LOCK TABLES `FINACIAL_KEY` WRITE;
/*!40000 ALTER TABLE `FINACIAL_KEY` DISABLE KEYS */;
INSERT INTO `FINACIAL_KEY` VALUES (24,'financed_net_yield_1__c'),(25,'monthly_cash_flow_with_financing_2__c'),(26,'financed_net_yield_2__c'),(27,'monthly_cash_flow_with_financing_1__c'),(28,'interest_rate_2__c');
/*!40000 ALTER TABLE `FINACIAL_KEY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `GROUPS`
--

DROP TABLE IF EXISTS `GROUPS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GROUPS` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `UUID` char(36) NOT NULL,
  `GROUP_NAME` varchar(50) NOT NULL,
  `CUST_UUID` char(36) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UUID_UNIQUE` (`UUID`),
  KEY `fk_CustUUId2_idx` (`CUST_UUID`),
  CONSTRAINT `fk_CustUUId2` FOREIGN KEY (`CUST_UUID`) REFERENCES `CUSTOMER` (`UUID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GROUPS`
--

LOCK TABLES `GROUPS` WRITE;
/*!40000 ALTER TABLE `GROUPS` DISABLE KEYS */;
/*!40000 ALTER TABLE `GROUPS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `GROUP_MEMBERS`
--

DROP TABLE IF EXISTS `GROUP_MEMBERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GROUP_MEMBERS` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `GROUPS_ID` int(11) NOT NULL,
  `USERS_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_group_members_groups1_idx` (`GROUPS_ID`),
  KEY `fk_group_members_users1_idx` (`USERS_ID`),
  CONSTRAINT `fk_group_members_groups1` FOREIGN KEY (`GROUPS_ID`) REFERENCES `GROUPS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_group_members_users1` FOREIGN KEY (`USERS_ID`) REFERENCES `USERS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GROUP_MEMBERS`
--

LOCK TABLES `GROUP_MEMBERS` WRITE;
/*!40000 ALTER TABLE `GROUP_MEMBERS` DISABLE KEYS */;
/*!40000 ALTER TABLE `GROUP_MEMBERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `JOB_SERVER`
--

DROP TABLE IF EXISTS `JOB_SERVER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `JOB_SERVER` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `HOST` varchar(75) NOT NULL,
  `ACTIVE` tinyint(1) NOT NULL DEFAULT '0',
  `IP_ADDRESS` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `JOB_SERVER`
--

LOCK TABLES `JOB_SERVER` WRITE;
/*!40000 ALTER TABLE `JOB_SERVER` DISABLE KEYS */;
/*!40000 ALTER TABLE `JOB_SERVER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `JOB_STATUS`
--

DROP TABLE IF EXISTS `JOB_STATUS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `JOB_STATUS` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `STATUS` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `JOB_STATUS`
--

LOCK TABLES `JOB_STATUS` WRITE;
/*!40000 ALTER TABLE `JOB_STATUS` DISABLE KEYS */;
/*!40000 ALTER TABLE `JOB_STATUS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LEADS`
--

DROP TABLE IF EXISTS `LEADS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `LEADS` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SOURCE` varchar(150) NOT NULL,
  `CRE_DTM` datetime NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LEADS`
--

LOCK TABLES `LEADS` WRITE;
/*!40000 ALTER TABLE `LEADS` DISABLE KEYS */;
/*!40000 ALTER TABLE `LEADS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PERSISTENT_LOGINS`
--

DROP TABLE IF EXISTS `PERSISTENT_LOGINS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PERSISTENT_LOGINS` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(11) NOT NULL,
  `TOKEN` varchar(64) NOT NULL,
  `LAST_USED` datetime NOT NULL,
  `USERS__ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_persistent_logins_users1_idx` (`USERS__ID`),
  CONSTRAINT `fk_persistent_logins_users1` FOREIGN KEY (`USERS__ID`) REFERENCES `USERS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PERSISTENT_LOGINS`
--

LOCK TABLES `PERSISTENT_LOGINS` WRITE;
/*!40000 ALTER TABLE `PERSISTENT_LOGINS` DISABLE KEYS */;
/*!40000 ALTER TABLE `PERSISTENT_LOGINS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PROPERTY_DATA`
--

DROP TABLE IF EXISTS `PROPERTY_DATA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PROPERTY_DATA` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `UUID` char(36) NOT NULL,
  `PROP_NAME` varchar(150) NOT NULL,
  `PRICE` float NOT NULL DEFAULT '0',
  `SQFT` varchar(45) NOT NULL,
  `DESCRIPTION` varchar(255) NOT NULL,
  `NUM_BEDS` float NOT NULL DEFAULT '0',
  `NUM_BATHS` float NOT NULL DEFAULT '0',
  `TYPE` varchar(45) NOT NULL,
  `STATUS` varchar(45) NOT NULL,
  `STATE_INFO_ID` int(11) NOT NULL,
  `DATA_SOURCE_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UUID_UNIQUE` (`UUID`),
  KEY `fk_PROPERTY_DATA_STATE_INFO1_idx` (`STATE_INFO_ID`),
  KEY `fk_PROPERTY_DATA_DATA_SOURCE1_idx` (`DATA_SOURCE_ID`),
  CONSTRAINT `fk_PROPERTY_DATA_DATA_SOURCE1` FOREIGN KEY (`DATA_SOURCE_ID`) REFERENCES `DATA_SOURCE` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_PROPERTY_DATA_STATE_INFO1` FOREIGN KEY (`STATE_INFO_ID`) REFERENCES `STATE_INFO` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=280 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PROPERTY_DATA`
--

LOCK TABLES `PROPERTY_DATA` WRITE;
/*!40000 ALTER TABLE `PROPERTY_DATA` DISABLE KEYS */;
INSERT INTO `PROPERTY_DATA` VALUES (91,'a24c3351-4a90-43d4-af3d-78068eadc74c','5456 Ruskin PL',57900,'1500','This 3 BD is located in a great neighborhood! Extensive rehab will include new tile and carpet, new paint, new A/C, window coverings. Home has nice sized backward with fence and an attached garage.',3,1,'SFR','Active',65,1),(92,'0ee2378a-1b0a-45e8-9122-cbd70ce32e14','5138 W 32nd',54900,'1500','Extensive rehab done on this one. Great West Indy property. New windows. New interior and exterior paint. New flooring throughout including tile in the kitchen and living room. New roof.',3,1,'SFR','Under Contract',65,1),(93,'c87c9e0c-8946-49cf-a544-65d08540a4cf','1232 Reisner',54900,'1500','This property has all new flooring, paint, and vinyl windows. Large 3 BD home.',3,1.5,'SFR','Active',74,1),(94,'45ce4f14-5b5d-42ae-b9ef-86b220b60813','801 Worth',57900,'1500','This home has been updated inside and out. New vinyl windows. Currently occupied with a great sec 8 tenant.',3,1,'SFR','Active',64,1),(95,'37602c5f-5000-44ec-b93e-5d47177d7b7b','3907 Rookwood',51900,'1500','Large 4 BD home. New roof and vinyl windows. Updated exterior siding, kitchen, water heater, and furnace.',4,1,'SFR','Active',50,1),(96,'45fd75f5-285f-4840-90f0-c75fc00344a9','2636 Foltz',55900,'1500','Great little home on the West side. All new windows and kitchen. New flooring and paint throughout.',4,1.5,'SFR','Active',64,1),(97,'1a2a8a1f-acac-4137-8505-0e5446f62564','4249 Jamie Ct',56900,'1500','Big ranch with great room addition on back with large fireplace and built-in grill. All new flooring and windows. Granite counters in the kitchen. One car attached garage.',3,2,'SFR','Active',75,1),(98,'7d0361d5-83db-47e8-aa6b-f38c90ef30ff','1404 Lindley',55900,'1500','Completely remodeled with hardwood floors. 2 car oversized garage. Central A/C with fenced yard.',3,1.5,'SFR','Active',64,1),(99,'5558d431-a65b-467f-90e7-6559098da727','625 Melvenia Ave',54900,'1500','Sweet little 3 BD bungalow on a corner lot. Full unfinished basement with laundry area. New vinyl windows. Glass tile backsplash in kitchen.',3,1,'SFR','Active',75,1),(100,'2bcd4143-88cb-4fca-9a7d-b1154614ea43','3429 Payton',57900,'1500','Nice 3 BD Ranch. Maintenance-free stone exterior. Big fenced yard. Deck with multiple levels in backyard. New paint. New tile, laminate and carpet throughout. New kitchen cabinets and countertops. Newer furnace and A/C.',3,1.5,'SFR','Active',75,1),(101,'5e910925-dcef-46e4-9ab6-1fb5838709bb','715 South Burgess Ave',62500,'1500','Very nice 3 bed  and one bathroom 2 level home is a great investor deal!  Hardwood flooring, one car garage, large basement and very clean.',3,1,'SFR','Under Contract',56,1),(102,'2371db65-a3d9-42c4-b4a5-ab237504357d','5327 Traditions Dr',75900,'1500','Great newer home in Indianapolis. Hard to find under $50/sqft. New paint and flooring throughout. New appliances. This home will perform for years to come.',3,2.5,'SFR','Active',57,1),(103,'a91f2902-6897-4305-87b5-2e90cefad2cd','110 N Linwood Ave',52900,'1500','This one is rented and ready to cash flow. Extensive rehab just completed. New flooring and paint throughout. All new window coverings, new A/C. Big square footage for the money.',3,1.5,'SFR','Under Contract',58,1),(104,'840d1e5d-a973-4bfd-a4da-17b20fee461d','1244 Moreland A/B',104000,'1500','2 Homes on one lot! Both homes sit on a quiet street. Both homes are 3BD/2BA. Currently rented with great tenants. Great westside property.',5,2,'SFR','Active',64,1),(105,'8870d0a1-10e6-442b-9ada-7511603f5d04','1411 Lindley',53900,'1500','Great little 2 BD home. Completely remodeled with hardwood floors in a great area. Cental A/C.',2,1,'SFR','Active',64,1),(106,'41514bfd-04bf-4ef8-963a-9cff1a63f2bb','2009 Legrande',53900,'1500','Great 3 BD home with a fenced backyard. New kitchen with tile backsplash. 2 car garage.',3,1,'SFR','Active',61,1),(107,'e58f1dab-9540-4845-b39e-08bf7509f3c4','745 Holmes S',55900,'1500','Charming 3 BD home close to downtown. Refinished hardwood flooring. All new paint. New flooring in kitchen and bath.',3,1,'SFR','Active',74,1),(108,'764872f0-4ea4-4d2a-b830-3beee8e0a51e','3818 Dearborne S',69900,'1500','Large home with big rooms and extra family room in a great neighborhood. Limestone maintenance-free exterior. Big back yard with storage sheds. New kitchen, Vinyl windows, and refinished hardwood floors.',3,1,'SFR','Active',67,1),(109,'b4035b13-0c53-4213-8ddd-028c77e95b54','1023 Worth',56900,'1500','Great ranch house with new vinyl windows. Hardwood floors, new kitchen and bath.',3,1,'SFR','Active',64,1),(110,'84285886-295b-4003-91b3-0087266aef6a','2807 Eagledale Dr',53900,'1500','Tenant already in place. Great rental home on the West side of Indianapolis. New furnace. New paint. Property is in great condition!',3,1,'SFR','Under Contract',65,1),(111,'60b97baf-1a39-430f-9771-78787f77f826','3351 Butler Ave',53900,'1500','Wonderful little home on the west side of Indianapolis. Updated exterior. New flooring and paint throughout. Upgraded kitchen.',3,1,'SFR','Active',66,1),(112,'430515ff-bff8-4453-a74d-140aff7a5451','3025 Alice Ave',57900,'1500','Get a home in this desireable neighborhood for less than $40/sqft. New paint and carpet throughout. New A/C and water heater. Big house for the money.',3,1.5,'SFR','Under Contract',67,1),(113,'fcbdee6a-3602-4c97-9a4f-ee2ddc1d9f9b','7756 Mountain Stream',55000,'1500','Amazing deal for this townhouse built in 2007! New furnace and A/C. New carpet and paint throughout.',4,3,'SFR','Under Contract',68,1),(114,'01414c72-1179-4a9d-87b0-70e7187a3e99','189 N Post Rd',65000,'1500','Great long-term potential. New flooring and paint. New water heater. New garage door.',3,2,'SFR','Active',69,1),(115,'1c6d4ee4-c2d8-4f3d-9e48-ecc0089ddf6b','12151 Southeastern Avenue',89000,'1500','This home sits on a huge lot! Comparables in the area are over 100k. New roof, flooring, kitchen, A/C, water heater. Brand new deck.',3,2,'SFR','Under Contract',70,1),(116,'1dcd1b75-a66a-4cea-ba2f-74b148ca7a88','1405 17th Way SW',55900,'1500','Great home by the college. Quiet neighborhood. New roof. New flooring throughout. New paint throughout. Brand new Furnace and A/C.  Priced well under market at $34 Sqft.',3,1.5,'SFR','Active',71,1),(117,'55ecaa83-1bc2-4e7f-acf8-113fab9dd5db','428 27th Ave NW',75000,'1500','All new paint thoughout the home. New roof. New Furnace and A/C. Highly desireable neighborhood in CenterPoint. This property has a tax value of over 100k. Great potential for a lease/purchase tenant.',3,1.5,'SFR','Under Contract',72,1),(118,'4ed86619-2312-47dc-9361-75177e5b1b0d','6143 E 43rd Pl',57900,'1500','Fenced yard. New A/C unit. New electric water heater. New carpet and paint throughout. Centrally located to schools, shopping, and downtown. Highly desireable neighborhood on the west side of Indianapolis. Amazing deal for $30/sqft',3,1.5,'SFR','Under Contract',75,1),(119,'28a1711d-2ceb-479b-bcfc-23f89f288aca','5319 Scatterwood',89000,'1500','Great price for a newer home. Brand new Furnace and A/C. All new flooring and paint throughout. New electrical. New water heater. Great access to parks, golf courses, and International airport.  Tax Value 100k+',3,2,'SFR','Under Contract',74,1),(120,'003ab89b-75fa-4c65-9e9a-f4cbb8b01b8e','6602 E 52nd St',57900,'1500','New 2-tone paint throughout the house. New A/C. All new window coverings and appliances. All new flooring. Very desireable Brookhaven neighborhood in Indianapolis. Avg listing price in the area is 100k.',3,2,'SFR','Under Contract',75,1),(121,'bf67f694-18d2-4f6e-a5bd-95a468330169','212 Mettler',39900,'1500','Great home in a Great market!',3,1,'SFR','Active',76,1),(122,'6493af2d-2a3d-4577-9ec5-f0cbf135c159','1328 43rd St Ensley',46500,'1500','Great home in a Great market!',3,1,'SFR','Active',79,1),(123,'164db751-c8fb-41a3-a19d-a2272ce98f2a','2672 20th Street',39000,'1500','Great Section 8 tenant! Full rehab. No carpet means less maintenance!',2,1,'SFR','Active',79,1),(124,'7af304db-6f50-4657-81cd-398712fbb43b','4708 Court O',39000,'1500','Great home in a Great market!',2,1,'SFR','Active',79,1),(125,'e0500146-d63c-4c12-917b-1d9d86754521','5913 Avenue M',36000,'1500','New windows. New kitchen. Roof only 2 years old. Hardwood floors throughout which means less maintenance. New HVAC system. Long-term tenant.  All of this for under 50k!',2,1,'SFR','Active',82,1),(126,'32c9797a-8cb5-4aef-9f46-497369109356','2031 Center Street S',39000,'1500','Great home in a Great market!',2,1,'SFR','Active',81,1),(127,'03ee2d83-2d1b-4435-9df6-9d0dc868cb4e','5900 Avenue M',49000,'1500','New windows.Brand new roof with a 30 yr warranty. Brand new furnace and A/C. Great neighborhood and tenant is signed to a long-term lease. Can\'t beat a 1300 Sqft home for under 50k!',3,2,'SFR','Active',82,1),(128,'f45e9aaf-4e8d-4ca6-96b2-ca828122f274','7740 Madrid Ave',99900,'1500','4 units for under 100k! New electrical, bathrooms, kitchens, flooring!',8,4,'4-Plex','Under Contract',88,1),(129,'107d8a1a-9096-40fa-b16d-bef8d6234010','Truman Road',82000,'1500','Great home in a Great market!',6,2,'Duplex','Active',86,1),(130,'0a3c9f87-2f7a-4961-b957-473d8792fda1','521/523 Jackson St',145000,'1500','Great price for a 4-unit building. Fully rehabbed. Great location.',8,4,'4Plex','Active',86,1),(131,'2a05df5d-aa04-4d79-9a33-49bfe3033e8a','5208 Garfield',52000,'1500','Nice single-family home. All new flooring throughout. New Furnace and A/C. New water heater.   Great curb appeal with a stone front.',3,1,'SFR','Active',86,1),(132,'ff5a2e1b-9c7f-4062-b1dc-a5fc3e040898','2429 Hardesty',37000,'1500','New roof. New Furnace and A/C. Hardwood floors. Good long-term Section 8 tenant. Great price on this single-family home. Grab this one with less than 20k down!',2,1,'SFR','Active',87,1),(133,'96840926-36b7-4841-8fba-71af5f8be2cd','8109 1st Avenue S',30000,'1500','Great home in a Great market!',2,1,'SFR','Active',88,1),(134,'fc3160c5-6dff-4100-8e99-32301aced1d4','2036 Mayfield',45900,'1500','Great home in a Great market!',3,1,'SFR','Active',89,1),(257,'3e269e02-af57-4a88-abe1-9c258c463030','6131 Tammin Dr',92000,'1500','Tenant already in place. Great rental home on the West side of Indianapolis. New furnace. New paint. Property is in great condition!',3,1,'SFR','Sold',90,1),(258,'268185a4-5d3f-47cc-bb1b-5dea97652b0c','849 S Worth Ave',53900,'1500','This home sits in a great neighborhood. Easy to rent homes in the area. New flooring and paint. New kitchen.',3,1,'SFR','Sold',64,1),(259,'d9e2641c-4d71-4175-a51b-49e09b0da0c3','325 Hiett Ave',32000,'1500','Great home in a Great market!',3,1,'SFR','Sold',91,1),(260,'f5d77ca5-247c-4d78-922b-6cc7866f7b02','3236 Welch Dr',57900,'1500','New vinyl windows and siding.All new window treatments. New interior paint. All new appliances. New flooring throughout the house. New water heater. New roof.  High demand rental neighborhood located on the west side of Indianapolis.',4,1.5,'SFR','Sold',65,1),(261,'85b7a159-e422-478b-a8bb-c3458b431530','6530 Pike View Ct',82000,'1500','Home just renovated. Built in 1989. Great long-term tenant. Great price for this home that is already cash-flowing. Great neighborhood close to some of the best schools in Indy.',3,2,'SFR','Sold',92,1),(262,'d9c97ced-e1f5-488b-b42f-d5c035d4d97a','3126 Gerrard Ave',57900,'1500','Great home in a Great market!',3,2,'SFR','Sold',65,1),(263,'76792f03-e9fa-407a-8ff9-cee9f383f5a3','3349 Winton Ave',57900,'1500','All new windows. New flooring, paint, mechanicals. All new appliances. New light fixtures throughout.  Long-term tenant. Very desireable Eagledale neighborhood.',3,1,'SFR','Sold',65,1),(264,'96a6b137-8b60-4450-9200-76f87a405438','3525 N Payton Ave',56900,'1500','Great home in a Great market!',3,1,'SFR','Sold',75,1),(265,'4e4cabf3-f275-40bb-b5a6-5a112f4b5813','4900 Ave N',49500,'1500','Great home in a Great market!',3,1.5,'SFR','Sold',79,1),(266,'c078913b-d91c-44f7-a291-7c58c037e5a2','1644 30th St Ensley',46000,'1500','New heat pump, hardwood floors! Great long-term tenant!',3,2,'SFR','Sold',79,1),(267,'99d50243-fcea-4c67-bb80-d46acea65dea','1505 S Leland Ave',54900,'1500','Great home in a Great market!',3,1,'SFR','Sold',61,1),(268,'4f3e7674-ec01-4cf9-b356-822b381b60fe','1804 N Lesley Ave',56900,'1500','Great home in a Great market!',3,1.5,'SFR','Sold',125,1),(269,'d5f3ff4a-e533-4536-9cf0-ece5953405b9','4993 Beatrice Dr.',58000,'1500','New cherry cabinets, windows, paint! Quiet neighborhood!',3,1.5,'SFR','Sold',94,1),(270,'a75f99df-c53c-4854-b155-a62be45d3a19','1521 33rd St Ensley',46500,'1500','Fully remodeled less than 2yrs ago including new roof! Hardwod floors.',3,1,'SFR','Sold',79,1),(271,'e5029437-58d7-4e55-a9fc-2272b0abac12','218 Vann St',47000,'1500','Great home in a Great market!',3,2,'SFR','Sold',82,1),(272,'eadfc72f-dbbc-45d2-bbb4-821f20fbe855','1441 Warrior Rd',47500,'1500','Great home in a Great market!',3,1,'SFR','Sold',79,1),(273,'fb467a9a-d1d4-4955-b6ba-b63e0c45981b','1401 46th St Ensley',47500,'1500','New roof, New HVAC, all hardwood floors!Big Master and great tenant.',3,1,'SFR','Sold',79,1),(274,'39651d08-5006-45e0-b641-bdc900bd432d','1341 44th St Ensley',52500,'1500','Great home in a Great market!',3,1,'SFR','Sold',79,1),(275,'bb060123-91d1-44cc-9c2b-3ed70e9f5d22','1147 North Berwick Avenue',54900,'1500','Great tenant. All new appliances, new tile, hardwood floors which means less maintenance. Great curb appeal. Very Quiet neighborhood but very convenient to shopping and downtown. Very desireable Eagledale section of Indianapolis.',3,1,'SFR','Sold',125,1),(276,'6df07f62-f389-4444-a11e-5a1c777244f4','4138 Breton St',53900,'1500','Great home in a Great market!',3,1,'SFR','Sold',125,1),(277,'4f5cc3c4-5b08-4c43-9194-f9f70b088e71','477 South Exeter',54900,'1500','Great home in a Great market!',3,1,'SFR','Sold',64,1),(278,'13530e36-6e04-439d-af40-970ced1437fb','528 Cadillac',42000,'1500','Great home in a Great market!',6,2,'Duplex','Sold',112,1),(279,'cc5b2155-b525-4982-997a-b70e0fdda268','2937 Mussman Dr',54900,'1500','Great home in a Great market!',4,2,'SFR','Sold',125,1);
/*!40000 ALTER TABLE `PROPERTY_DATA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PROPERTY_FINACIAL`
--

DROP TABLE IF EXISTS `PROPERTY_FINACIAL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PROPERTY_FINACIAL` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `VALUE` decimal(6,2) NOT NULL DEFAULT '0.00',
  `FINACIAL_KEY_ID` int(11) NOT NULL,
  `PROPERTY_DATA_UUID` char(36) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `udx1` (`FINACIAL_KEY_ID`,`PROPERTY_DATA_UUID`),
  KEY `fk_PROPERTY_FINACIALS_FINACIAL_KEY1_idx` (`FINACIAL_KEY_ID`),
  KEY `fk_PROPERTY_FINACIALS_PROPERTY_DATA1_idx` (`PROPERTY_DATA_UUID`),
  CONSTRAINT `fk_PROPERTY_FINACIALS_FINACIAL_KEY1` FOREIGN KEY (`FINACIAL_KEY_ID`) REFERENCES `FINACIAL_KEY` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_PROPERTY_FINACIALS_PROPERTY_DATA1` FOREIGN KEY (`PROPERTY_DATA_UUID`) REFERENCES `PROPERTY_DATA` (`UUID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=824 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PROPERTY_FINACIAL`
--

LOCK TABLES `PROPERTY_FINACIAL` WRITE;
/*!40000 ALTER TABLE `PROPERTY_FINACIAL` DISABLE KEYS */;
INSERT INTO `PROPERTY_FINACIAL` VALUES (489,19.56,24,'a24c3351-4a90-43d4-af3d-78068eadc74c'),(490,481.32,25,'a24c3351-4a90-43d4-af3d-78068eadc74c'),(491,33.25,26,'a24c3351-4a90-43d4-af3d-78068eadc74c'),(492,330.38,27,'a24c3351-4a90-43d4-af3d-78068eadc74c'),(493,4.85,28,'a24c3351-4a90-43d4-af3d-78068eadc74c'),(494,16.56,24,'0ee2378a-1b0a-45e8-9122-cbd70ce32e14'),(495,408.25,25,'0ee2378a-1b0a-45e8-9122-cbd70ce32e14'),(496,29.75,26,'0ee2378a-1b0a-45e8-9122-cbd70ce32e14'),(497,265.13,27,'0ee2378a-1b0a-45e8-9122-cbd70ce32e14'),(498,4.85,28,'0ee2378a-1b0a-45e8-9122-cbd70ce32e14'),(499,18.62,24,'c87c9e0c-8946-49cf-a544-65d08540a4cf'),(500,441.25,25,'c87c9e0c-8946-49cf-a544-65d08540a4cf'),(501,32.15,26,'c87c9e0c-8946-49cf-a544-65d08540a4cf'),(502,298.13,27,'c87c9e0c-8946-49cf-a544-65d08540a4cf'),(503,4.85,28,'c87c9e0c-8946-49cf-a544-65d08540a4cf'),(504,13.63,24,'45ce4f14-5b5d-42ae-b9ef-86b220b60813'),(505,381.16,25,'45ce4f14-5b5d-42ae-b9ef-86b220b60813'),(506,26.33,26,'45ce4f14-5b5d-42ae-b9ef-86b220b60813'),(507,230.21,27,'45ce4f14-5b5d-42ae-b9ef-86b220b60813'),(508,4.85,28,'45ce4f14-5b5d-42ae-b9ef-86b220b60813'),(509,10.99,24,'37602c5f-5000-44ec-b93e-5d47177d7b7b'),(510,301.68,25,'37602c5f-5000-44ec-b93e-5d47177d7b7b'),(511,23.25,26,'37602c5f-5000-44ec-b93e-5d47177d7b7b'),(512,166.38,27,'37602c5f-5000-44ec-b93e-5d47177d7b7b'),(513,4.85,28,'37602c5f-5000-44ec-b93e-5d47177d7b7b'),(514,17.80,24,'45fd75f5-285f-4840-90f0-c75fc00344a9'),(515,436.01,25,'45fd75f5-285f-4840-90f0-c75fc00344a9'),(516,31.20,26,'45fd75f5-285f-4840-90f0-c75fc00344a9'),(517,290.28,27,'45fd75f5-285f-4840-90f0-c75fc00344a9'),(518,4.85,28,'45fd75f5-285f-4840-90f0-c75fc00344a9'),(519,10.49,24,'1a2a8a1f-acac-4137-8505-0e5446f62564'),(520,322.38,25,'1a2a8a1f-acac-4137-8505-0e5446f62564'),(521,22.66,26,'1a2a8a1f-acac-4137-8505-0e5446f62564'),(522,174.04,27,'1a2a8a1f-acac-4137-8505-0e5446f62564'),(523,4.85,28,'1a2a8a1f-acac-4137-8505-0e5446f62564'),(524,17.72,24,'7d0361d5-83db-47e8-aa6b-f38c90ef30ff'),(525,434.61,25,'7d0361d5-83db-47e8-aa6b-f38c90ef30ff'),(526,31.10,26,'7d0361d5-83db-47e8-aa6b-f38c90ef30ff'),(527,288.88,27,'7d0361d5-83db-47e8-aa6b-f38c90ef30ff'),(528,4.85,28,'7d0361d5-83db-47e8-aa6b-f38c90ef30ff'),(529,18.70,24,'5558d431-a65b-467f-90e7-6559098da727'),(530,442.58,25,'5558d431-a65b-467f-90e7-6559098da727'),(531,32.25,26,'5558d431-a65b-467f-90e7-6559098da727'),(532,299.46,27,'5558d431-a65b-467f-90e7-6559098da727'),(533,4.85,28,'5558d431-a65b-467f-90e7-6559098da727'),(534,17.34,24,'2bcd4143-88cb-4fca-9a7d-b1154614ea43'),(535,443.82,25,'2bcd4143-88cb-4fca-9a7d-b1154614ea43'),(536,30.66,26,'2bcd4143-88cb-4fca-9a7d-b1154614ea43'),(537,292.88,27,'2bcd4143-88cb-4fca-9a7d-b1154614ea43'),(538,4.85,28,'2bcd4143-88cb-4fca-9a7d-b1154614ea43'),(539,16.27,24,'5e910925-dcef-46e4-9ab6-1fb5838709bb'),(540,459.56,25,'5e910925-dcef-46e4-9ab6-1fb5838709bb'),(541,29.41,26,'5e910925-dcef-46e4-9ab6-1fb5838709bb'),(542,296.63,27,'5e910925-dcef-46e4-9ab6-1fb5838709bb'),(543,4.85,28,'5e910925-dcef-46e4-9ab6-1fb5838709bb'),(544,14.47,24,'2371db65-a3d9-42c4-b4a5-ab237504357d'),(545,518.25,25,'2371db65-a3d9-42c4-b4a5-ab237504357d'),(546,27.31,26,'2371db65-a3d9-42c4-b4a5-ab237504357d'),(547,320.38,27,'2371db65-a3d9-42c4-b4a5-ab237504357d'),(548,4.85,28,'2371db65-a3d9-42c4-b4a5-ab237504357d'),(549,19.71,24,'a91f2902-6897-4305-87b5-2e90cefad2cd'),(550,442.04,25,'a91f2902-6897-4305-87b5-2e90cefad2cd'),(551,33.42,26,'a91f2902-6897-4305-87b5-2e90cefad2cd'),(552,304.13,27,'a91f2902-6897-4305-87b5-2e90cefad2cd'),(553,4.85,28,'a91f2902-6897-4305-87b5-2e90cefad2cd'),(554,18.76,24,'840d1e5d-a973-4bfd-a4da-17b20fee461d'),(555,840.30,25,'840d1e5d-a973-4bfd-a4da-17b20fee461d'),(556,32.32,26,'840d1e5d-a973-4bfd-a4da-17b20fee461d'),(557,569.17,27,'840d1e5d-a973-4bfd-a4da-17b20fee461d'),(558,4.85,28,'840d1e5d-a973-4bfd-a4da-17b20fee461d'),(559,18.53,24,'8870d0a1-10e6-442b-9ada-7511603f5d04'),(560,431.89,25,'8870d0a1-10e6-442b-9ada-7511603f5d04'),(561,32.05,26,'8870d0a1-10e6-442b-9ada-7511603f5d04'),(562,291.38,27,'8870d0a1-10e6-442b-9ada-7511603f5d04'),(563,4.85,28,'8870d0a1-10e6-442b-9ada-7511603f5d04'),(564,13.31,24,'41514bfd-04bf-4ef8-963a-9cff1a63f2bb'),(565,349.81,25,'41514bfd-04bf-4ef8-963a-9cff1a63f2bb'),(566,25.96,26,'41514bfd-04bf-4ef8-963a-9cff1a63f2bb'),(567,209.29,27,'41514bfd-04bf-4ef8-963a-9cff1a63f2bb'),(568,4.85,28,'41514bfd-04bf-4ef8-963a-9cff1a63f2bb'),(569,19.33,24,'e58f1dab-9540-4845-b39e-08bf7509f3c4'),(570,460.94,25,'e58f1dab-9540-4845-b39e-08bf7509f3c4'),(571,32.98,26,'e58f1dab-9540-4845-b39e-08bf7509f3c4'),(572,315.21,27,'e58f1dab-9540-4845-b39e-08bf7509f3c4'),(573,4.85,28,'e58f1dab-9540-4845-b39e-08bf7509f3c4'),(574,14.54,24,'764872f0-4ea4-4d2a-b830-3beee8e0a51e'),(575,478.61,25,'764872f0-4ea4-4d2a-b830-3beee8e0a51e'),(576,27.39,26,'764872f0-4ea4-4d2a-b830-3beee8e0a51e'),(577,296.38,27,'764872f0-4ea4-4d2a-b830-3beee8e0a51e'),(578,4.85,28,'764872f0-4ea4-4d2a-b830-3beee8e0a51e'),(579,14.91,24,'b4035b13-0c53-4213-8ddd-028c77e95b54'),(580,395.80,25,'b4035b13-0c53-4213-8ddd-028c77e95b54'),(581,27.82,26,'b4035b13-0c53-4213-8ddd-028c77e95b54'),(582,247.46,27,'b4035b13-0c53-4213-8ddd-028c77e95b54'),(583,4.85,28,'b4035b13-0c53-4213-8ddd-028c77e95b54'),(584,14.44,24,'84285886-295b-4003-91b3-0087266aef6a'),(585,367.56,25,'84285886-295b-4003-91b3-0087266aef6a'),(586,27.28,26,'84285886-295b-4003-91b3-0087266aef6a'),(587,227.04,27,'84285886-295b-4003-91b3-0087266aef6a'),(588,4.85,28,'84285886-295b-4003-91b3-0087266aef6a'),(589,15.91,24,'60b97baf-1a39-430f-9771-78787f77f826'),(590,390.56,25,'60b97baf-1a39-430f-9771-78787f77f826'),(591,28.98,26,'60b97baf-1a39-430f-9771-78787f77f826'),(592,250.04,27,'60b97baf-1a39-430f-9771-78787f77f826'),(593,4.85,28,'60b97baf-1a39-430f-9771-78787f77f826'),(594,18.93,24,'430515ff-bff8-4453-a74d-140aff7a5451'),(595,470.66,25,'430515ff-bff8-4453-a74d-140aff7a5451'),(596,32.52,26,'430515ff-bff8-4453-a74d-140aff7a5451'),(597,319.71,27,'430515ff-bff8-4453-a74d-140aff7a5451'),(598,4.85,28,'430515ff-bff8-4453-a74d-140aff7a5451'),(599,16.23,24,'fcbdee6a-3602-4c97-9a4f-ee2ddc1d9f9b'),(600,403.80,25,'fcbdee6a-3602-4c97-9a4f-ee2ddc1d9f9b'),(601,29.37,26,'fcbdee6a-3602-4c97-9a4f-ee2ddc1d9f9b'),(602,260.42,27,'fcbdee6a-3602-4c97-9a4f-ee2ddc1d9f9b'),(603,4.85,28,'fcbdee6a-3602-4c97-9a4f-ee2ddc1d9f9b'),(604,11.28,24,'01414c72-1179-4a9d-87b0-70e7187a3e99'),(605,383.37,25,'01414c72-1179-4a9d-87b0-70e7187a3e99'),(606,23.59,26,'01414c72-1179-4a9d-87b0-70e7187a3e99'),(607,213.92,27,'01414c72-1179-4a9d-87b0-70e7187a3e99'),(608,4.85,28,'01414c72-1179-4a9d-87b0-70e7187a3e99'),(609,10.56,24,'1c6d4ee4-c2d8-4f3d-9e48-ecc0089ddf6b'),(610,506.11,25,'1c6d4ee4-c2d8-4f3d-9e48-ecc0089ddf6b'),(611,22.75,26,'1c6d4ee4-c2d8-4f3d-9e48-ecc0089ddf6b'),(612,274.08,27,'1c6d4ee4-c2d8-4f3d-9e48-ecc0089ddf6b'),(613,4.85,28,'1c6d4ee4-c2d8-4f3d-9e48-ecc0089ddf6b'),(614,16.56,24,'1dcd1b75-a66a-4cea-ba2f-74b148ca7a88'),(615,415.69,25,'1dcd1b75-a66a-4cea-ba2f-74b148ca7a88'),(616,29.75,26,'1dcd1b75-a66a-4cea-ba2f-74b148ca7a88'),(617,269.96,27,'1dcd1b75-a66a-4cea-ba2f-74b148ca7a88'),(618,4.85,28,'1dcd1b75-a66a-4cea-ba2f-74b148ca7a88'),(619,13.60,24,'55ecaa83-1bc2-4e7f-acf8-113fab9dd5db'),(620,493.03,25,'55ecaa83-1bc2-4e7f-acf8-113fab9dd5db'),(621,26.29,26,'55ecaa83-1bc2-4e7f-acf8-113fab9dd5db'),(622,297.50,27,'55ecaa83-1bc2-4e7f-acf8-113fab9dd5db'),(623,4.85,28,'55ecaa83-1bc2-4e7f-acf8-113fab9dd5db'),(624,15.24,24,'4ed86619-2312-47dc-9361-75177e5b1b0d'),(625,408.32,25,'4ed86619-2312-47dc-9361-75177e5b1b0d'),(626,28.21,26,'4ed86619-2312-47dc-9361-75177e5b1b0d'),(627,257.38,27,'4ed86619-2312-47dc-9361-75177e5b1b0d'),(628,4.85,28,'4ed86619-2312-47dc-9361-75177e5b1b0d'),(629,13.95,24,'28a1711d-2ceb-479b-bcfc-23f89f288aca'),(630,594.11,25,'28a1711d-2ceb-479b-bcfc-23f89f288aca'),(631,26.70,26,'28a1711d-2ceb-479b-bcfc-23f89f288aca'),(632,362.08,27,'28a1711d-2ceb-479b-bcfc-23f89f288aca'),(633,4.85,28,'28a1711d-2ceb-479b-bcfc-23f89f288aca'),(634,18.86,24,'003ab89b-75fa-4c65-9e9a-f4cbb8b01b8e'),(635,469.49,25,'003ab89b-75fa-4c65-9e9a-f4cbb8b01b8e'),(636,32.43,26,'003ab89b-75fa-4c65-9e9a-f4cbb8b01b8e'),(637,318.54,27,'003ab89b-75fa-4c65-9e9a-f4cbb8b01b8e'),(638,4.85,28,'003ab89b-75fa-4c65-9e9a-f4cbb8b01b8e'),(639,17.06,24,'bf67f694-18d2-4f6e-a5bd-95a468330169'),(640,304.56,25,'bf67f694-18d2-4f6e-a5bd-95a468330169'),(641,30.53,26,'bf67f694-18d2-4f6e-a5bd-95a468330169'),(642,283.67,27,'bf67f694-18d2-4f6e-a5bd-95a468330169'),(643,4.85,28,'bf67f694-18d2-4f6e-a5bd-95a468330169'),(644,18.21,24,'6493af2d-2a3d-4577-9ec5-f0cbf135c159'),(645,368.18,25,'6493af2d-2a3d-4577-9ec5-f0cbf135c159'),(646,31.67,26,'6493af2d-2a3d-4577-9ec5-f0cbf135c159'),(647,246.96,27,'6493af2d-2a3d-4577-9ec5-f0cbf135c159'),(648,4.85,28,'6493af2d-2a3d-4577-9ec5-f0cbf135c159'),(649,16.28,24,'164db751-c8fb-41a3-a19d-a2272ce98f2a'),(650,286.84,25,'164db751-c8fb-41a3-a19d-a2272ce98f2a'),(651,29.42,26,'164db751-c8fb-41a3-a19d-a2272ce98f2a'),(652,185.17,27,'164db751-c8fb-41a3-a19d-a2272ce98f2a'),(653,4.85,28,'164db751-c8fb-41a3-a19d-a2272ce98f2a'),(654,18.50,24,'7af304db-6f50-4657-81cd-398712fbb43b'),(655,312.09,25,'7af304db-6f50-4657-81cd-398712fbb43b'),(656,32.01,26,'7af304db-6f50-4657-81cd-398712fbb43b'),(657,210.42,27,'7af304db-6f50-4657-81cd-398712fbb43b'),(658,4.85,28,'7af304db-6f50-4657-81cd-398712fbb43b'),(659,18.55,24,'e0500146-d63c-4c12-917b-1d9d86754521'),(660,288.60,25,'e0500146-d63c-4c12-917b-1d9d86754521'),(661,32.07,26,'e0500146-d63c-4c12-917b-1d9d86754521'),(662,194.75,27,'e0500146-d63c-4c12-917b-1d9d86754521'),(663,4.85,28,'e0500146-d63c-4c12-917b-1d9d86754521'),(664,20.06,24,'32c9797a-8cb5-4aef-9f46-497369109356'),(665,329.84,25,'32c9797a-8cb5-4aef-9f46-497369109356'),(666,33.83,26,'32c9797a-8cb5-4aef-9f46-497369109356'),(667,228.17,27,'32c9797a-8cb5-4aef-9f46-497369109356'),(668,4.85,28,'32c9797a-8cb5-4aef-9f46-497369109356'),(669,17.93,24,'03ee2d83-2d1b-4435-9df6-9d0dc868cb4e'),(670,383.99,25,'03ee2d83-2d1b-4435-9df6-9d0dc868cb4e'),(671,31.35,26,'03ee2d83-2d1b-4435-9df6-9d0dc868cb4e'),(672,256.25,27,'03ee2d83-2d1b-4435-9df6-9d0dc868cb4e'),(673,4.85,28,'03ee2d83-2d1b-4435-9df6-9d0dc868cb4e'),(674,40.63,24,'f45e9aaf-4e8d-4ca6-96b2-ca828122f274'),(675,1444.32,25,'f45e9aaf-4e8d-4ca6-96b2-ca828122f274'),(676,57.83,26,'f45e9aaf-4e8d-4ca6-96b2-ca828122f274'),(677,1183.88,27,'f45e9aaf-4e8d-4ca6-96b2-ca828122f274'),(678,4.85,28,'f45e9aaf-4e8d-4ca6-96b2-ca828122f274'),(679,12.33,24,'107d8a1a-9096-40fa-b16d-bef8d6234010'),(680,464.28,25,'107d8a1a-9096-40fa-b16d-bef8d6234010'),(681,22.65,26,'107d8a1a-9096-40fa-b16d-bef8d6234010'),(682,421.33,27,'107d8a1a-9096-40fa-b16d-bef8d6234010'),(683,4.85,28,'107d8a1a-9096-40fa-b16d-bef8d6234010'),(684,17.66,24,'0a3c9f87-2f7a-4961-b957-473d8792fda1'),(685,1142.60,25,'0a3c9f87-2f7a-4961-b957-473d8792fda1'),(686,31.52,26,'0a3c9f87-2f7a-4961-b957-473d8792fda1'),(687,1066.67,27,'0a3c9f87-2f7a-4961-b957-473d8792fda1'),(688,4.85,28,'0a3c9f87-2f7a-4961-b957-473d8792fda1'),(689,14.91,24,'2a05df5d-aa04-4d79-9a33-49bfe3033e8a'),(690,350.23,25,'2a05df5d-aa04-4d79-9a33-49bfe3033e8a'),(691,26.94,26,'2a05df5d-aa04-4d79-9a33-49bfe3033e8a'),(692,323.00,27,'2a05df5d-aa04-4d79-9a33-49bfe3033e8a'),(693,4.85,28,'2a05df5d-aa04-4d79-9a33-49bfe3033e8a'),(694,20.50,24,'ff5a2e1b-9c7f-4062-b1dc-a5fc3e040898'),(695,335.46,25,'ff5a2e1b-9c7f-4062-b1dc-a5fc3e040898'),(696,36.27,26,'ff5a2e1b-9c7f-4062-b1dc-a5fc3e040898'),(697,316.08,27,'ff5a2e1b-9c7f-4062-b1dc-a5fc3e040898'),(698,4.85,28,'ff5a2e1b-9c7f-4062-b1dc-a5fc3e040898'),(699,18.24,24,'96840926-36b7-4841-8fba-71af5f8be2cd'),(700,237.81,25,'96840926-36b7-4841-8fba-71af5f8be2cd'),(701,31.71,26,'96840926-36b7-4841-8fba-71af5f8be2cd'),(702,159.60,27,'96840926-36b7-4841-8fba-71af5f8be2cd'),(703,4.85,28,'96840926-36b7-4841-8fba-71af5f8be2cd'),(704,29.16,24,'fc3160c5-6dff-4100-8e99-32301aced1d4'),(705,452.70,25,'fc3160c5-6dff-4100-8e99-32301aced1d4'),(706,39.45,26,'fc3160c5-6dff-4100-8e99-32301aced1d4'),(707,390.42,27,'fc3160c5-6dff-4100-8e99-32301aced1d4'),(708,4.85,28,'fc3160c5-6dff-4100-8e99-32301aced1d4'),(709,14.47,24,'3e269e02-af57-4a88-abe1-9c258c463030'),(710,628.01,25,'3e269e02-af57-4a88-abe1-9c258c463030'),(711,27.30,26,'3e269e02-af57-4a88-abe1-9c258c463030'),(712,388.17,27,'3e269e02-af57-4a88-abe1-9c258c463030'),(713,4.85,28,'3e269e02-af57-4a88-abe1-9c258c463030'),(714,17.34,24,'268185a4-5d3f-47cc-bb1b-5dea97652b0c'),(715,413.06,25,'268185a4-5d3f-47cc-bb1b-5dea97652b0c'),(716,30.65,26,'268185a4-5d3f-47cc-bb1b-5dea97652b0c'),(717,272.54,27,'268185a4-5d3f-47cc-bb1b-5dea97652b0c'),(718,4.85,28,'268185a4-5d3f-47cc-bb1b-5dea97652b0c'),(719,15.92,24,'d9e2641c-4d71-4175-a51b-49e09b0da0c3'),(720,239.76,25,'d9e2641c-4d71-4175-a51b-49e09b0da0c3'),(721,29.97,26,'d9e2641c-4d71-4175-a51b-49e09b0da0c3'),(722,212.26,27,'d9e2641c-4d71-4175-a51b-49e09b0da0c3'),(723,4.85,28,'d9e2641c-4d71-4175-a51b-49e09b0da0c3'),(724,14.89,24,'f5d77ca5-247c-4d78-922b-6cc7866f7b02'),(725,402.32,25,'f5d77ca5-247c-4d78-922b-6cc7866f7b02'),(726,27.79,26,'f5d77ca5-247c-4d78-922b-6cc7866f7b02'),(727,251.38,27,'f5d77ca5-247c-4d78-922b-6cc7866f7b02'),(728,4.85,28,'f5d77ca5-247c-4d78-922b-6cc7866f7b02'),(729,10.49,24,'85b7a159-e422-478b-a8bb-c3458b431530'),(730,464.61,25,'85b7a159-e422-478b-a8bb-c3458b431530'),(731,22.66,26,'85b7a159-e422-478b-a8bb-c3458b431530'),(732,250.83,27,'85b7a159-e422-478b-a8bb-c3458b431530'),(733,4.85,28,'85b7a159-e422-478b-a8bb-c3458b431530'),(734,18.75,24,'d9c97ced-e1f5-488b-b42f-d5c035d4d97a'),(735,467.66,25,'d9c97ced-e1f5-488b-b42f-d5c035d4d97a'),(736,32.31,26,'d9c97ced-e1f5-488b-b42f-d5c035d4d97a'),(737,316.71,27,'d9c97ced-e1f5-488b-b42f-d5c035d4d97a'),(738,4.85,28,'d9c97ced-e1f5-488b-b42f-d5c035d4d97a'),(739,18.91,24,'76792f03-e9fa-407a-8ff9-cee9f383f5a3'),(740,470.32,25,'76792f03-e9fa-407a-8ff9-cee9f383f5a3'),(741,32.49,26,'76792f03-e9fa-407a-8ff9-cee9f383f5a3'),(742,319.38,27,'76792f03-e9fa-407a-8ff9-cee9f383f5a3'),(743,4.85,28,'76792f03-e9fa-407a-8ff9-cee9f383f5a3'),(744,17.98,24,'96a6b137-8b60-4450-9200-76f87a405438'),(745,446.80,25,'96a6b137-8b60-4450-9200-76f87a405438'),(746,31.41,26,'96a6b137-8b60-4450-9200-76f87a405438'),(747,298.46,27,'96a6b137-8b60-4450-9200-76f87a405438'),(748,4.85,28,'96a6b137-8b60-4450-9200-76f87a405438'),(749,19.57,24,'4e4cabf3-f275-40bb-b5a6-5a112f4b5813'),(750,411.59,25,'4e4cabf3-f275-40bb-b5a6-5a112f4b5813'),(751,33.26,26,'4e4cabf3-f275-40bb-b5a6-5a112f4b5813'),(752,282.54,27,'4e4cabf3-f275-40bb-b5a6-5a112f4b5813'),(753,4.85,28,'4e4cabf3-f275-40bb-b5a6-5a112f4b5813'),(754,20.25,24,'c078913b-d91c-44f7-a291-7c58c037e5a2'),(755,391.56,25,'c078913b-d91c-44f7-a291-7c58c037e5a2'),(756,34.05,26,'c078913b-d91c-44f7-a291-7c58c037e5a2'),(757,271.63,27,'c078913b-d91c-44f7-a291-7c58c037e5a2'),(758,4.85,28,'c078913b-d91c-44f7-a291-7c58c037e5a2'),(759,18.12,24,'99d50243-fcea-4c67-bb80-d46acea65dea'),(760,433.25,25,'99d50243-fcea-4c67-bb80-d46acea65dea'),(761,31.57,26,'99d50243-fcea-4c67-bb80-d46acea65dea'),(762,290.13,27,'99d50243-fcea-4c67-bb80-d46acea65dea'),(763,4.85,28,'99d50243-fcea-4c67-bb80-d46acea65dea'),(764,20.11,24,'4f3e7674-ec01-4cf9-b356-822b381b60fe'),(765,482.13,25,'4f3e7674-ec01-4cf9-b356-822b381b60fe'),(766,33.89,26,'4f3e7674-ec01-4cf9-b356-822b381b60fe'),(767,333.79,27,'4f3e7674-ec01-4cf9-b356-822b381b60fe'),(768,4.85,28,'4f3e7674-ec01-4cf9-b356-822b381b60fe'),(769,19.38,24,'d5f3ff4a-e533-4536-9cf0-ece5953405b9'),(770,498.71,25,'d5f3ff4a-e533-4536-9cf0-ece5953405b9'),(771,34.39,26,'d5f3ff4a-e533-4536-9cf0-ece5953405b9'),(772,468.33,27,'d5f3ff4a-e533-4536-9cf0-ece5953405b9'),(773,4.85,28,'d5f3ff4a-e533-4536-9cf0-ece5953405b9'),(774,22.49,24,'a75f99df-c53c-4854-b155-a62be45d3a19'),(775,426.27,25,'a75f99df-c53c-4854-b155-a62be45d3a19'),(776,36.67,26,'a75f99df-c53c-4854-b155-a62be45d3a19'),(777,305.04,27,'a75f99df-c53c-4854-b155-a62be45d3a19'),(778,4.85,28,'a75f99df-c53c-4854-b155-a62be45d3a19'),(779,23.15,24,'e5029437-58d7-4e55-a9fc-2272b0abac12'),(780,439.85,25,'e5029437-58d7-4e55-a9fc-2272b0abac12'),(781,37.43,26,'e5029437-58d7-4e55-a9fc-2272b0abac12'),(782,317.32,27,'e5029437-58d7-4e55-a9fc-2272b0abac12'),(783,4.85,28,'e5029437-58d7-4e55-a9fc-2272b0abac12'),(784,27.14,24,'eadfc72f-dbbc-45d2-bbb4-821f20fbe855'),(785,499.88,25,'eadfc72f-dbbc-45d2-bbb4-821f20fbe855'),(786,42.09,26,'eadfc72f-dbbc-45d2-bbb4-821f20fbe855'),(787,376.04,27,'eadfc72f-dbbc-45d2-bbb4-821f20fbe855'),(788,4.85,28,'eadfc72f-dbbc-45d2-bbb4-821f20fbe855'),(789,25.30,24,'fb467a9a-d1d4-4955-b6ba-b63e0c45981b'),(790,474.38,25,'fb467a9a-d1d4-4955-b6ba-b63e0c45981b'),(791,39.95,26,'fb467a9a-d1d4-4955-b6ba-b63e0c45981b'),(792,350.54,27,'fb467a9a-d1d4-4955-b6ba-b63e0c45981b'),(793,4.85,28,'fb467a9a-d1d4-4955-b6ba-b63e0c45981b'),(794,17.12,24,'39651d08-5006-45e0-b641-bdc900bd432d'),(795,398.99,25,'39651d08-5006-45e0-b641-bdc900bd432d'),(796,30.40,26,'39651d08-5006-45e0-b641-bdc900bd432d'),(797,262.13,27,'39651d08-5006-45e0-b641-bdc900bd432d'),(798,4.85,28,'39651d08-5006-45e0-b641-bdc900bd432d'),(799,14.28,24,'bb060123-91d1-44cc-9c2b-3ed70e9f5d22'),(800,371.75,25,'bb060123-91d1-44cc-9c2b-3ed70e9f5d22'),(801,27.09,26,'bb060123-91d1-44cc-9c2b-3ed70e9f5d22'),(802,228.63,27,'bb060123-91d1-44cc-9c2b-3ed70e9f5d22'),(803,4.85,28,'bb060123-91d1-44cc-9c2b-3ed70e9f5d22'),(804,17.50,24,'6df07f62-f389-4444-a11e-5a1c777244f4'),(805,415.56,25,'6df07f62-f389-4444-a11e-5a1c777244f4'),(806,30.84,26,'6df07f62-f389-4444-a11e-5a1c777244f4'),(807,275.04,27,'6df07f62-f389-4444-a11e-5a1c777244f4'),(808,4.85,28,'6df07f62-f389-4444-a11e-5a1c777244f4'),(809,18.42,24,'4f5cc3c4-5b08-4c43-9194-f9f70b088e71'),(810,428.08,25,'4f5cc3c4-5b08-4c43-9194-f9f70b088e71'),(811,46.78,26,'4f5cc3c4-5b08-4c43-9194-f9f70b088e71'),(812,421.37,27,'4f5cc3c4-5b08-4c43-9194-f9f70b088e71'),(813,4.85,28,'4f5cc3c4-5b08-4c43-9194-f9f70b088e71'),(814,32.60,24,'13530e36-6e04-439d-af40-970ced1437fb'),(815,606.66,25,'13530e36-6e04-439d-af40-970ced1437fb'),(816,57.78,26,'13530e36-6e04-439d-af40-970ced1437fb'),(817,570.58,27,'13530e36-6e04-439d-af40-970ced1437fb'),(818,4.85,28,'13530e36-6e04-439d-af40-970ced1437fb'),(819,21.07,24,'cc5b2155-b525-4982-997a-b70e0fdda268'),(820,488.72,25,'cc5b2155-b525-4982-997a-b70e0fdda268'),(821,53.41,26,'cc5b2155-b525-4982-997a-b70e0fdda268'),(822,482.00,27,'cc5b2155-b525-4982-997a-b70e0fdda268'),(823,4.85,28,'cc5b2155-b525-4982-997a-b70e0fdda268');
/*!40000 ALTER TABLE `PROPERTY_FINACIAL` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PROPERTY_IMAGES`
--

DROP TABLE IF EXISTS `PROPERTY_IMAGES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PROPERTY_IMAGES` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(150) NOT NULL,
  `SIZE` int(11) NOT NULL DEFAULT '0',
  `SRC_URL` varchar(150) NOT NULL,
  `PROPERTY_DATA_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_PROPERTY_IMAGES_PROPERTY_DATA1_idx` (`PROPERTY_DATA_ID`),
  CONSTRAINT `fk_PROPERTY_IMAGES_PROPERTY_DATA1` FOREIGN KEY (`PROPERTY_DATA_ID`) REFERENCES `PROPERTY_DATA` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=481 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PROPERTY_IMAGES`
--

LOCK TABLES `PROPERTY_IMAGES` WRITE;
/*!40000 ALTER TABLE `PROPERTY_IMAGES` DISABLE KEYS */;
INSERT INTO `PROPERTY_IMAGES` VALUES (188,'715_south_burgess front.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xD/51250bfb8bf7b/715 south  burgess front.jpeg',101),(189,'5327_Traditions_1.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xC/51250bc7b23df/5327_Traditions_1.jpeg',102),(190,'DSCN4502.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xB/5125257e73ccd/DSCN4502.jpeg',103),(191,'1_curb_a_shutters.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x9/5125234804e61/1_curb_a_shutters.jpeg',104),(192,'1_Curb_painted_Lindley.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x7/512522a80613b/1_Curb_painted_Lindley.jpeg',105),(193,'1_curb_2009_Legrand_n_new_east_siders_001.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x5/512521bb36768/1_curb_2009_Legrand_n_new_east_siders_001.jpeg',106),(194,'1_Curb_Holmes.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x3/512510867ae19/1_Curb_Holmes.jpeg',107),(195,'1_Curb_Dearborn_3818.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x1/512511cba8b60/1_Curb_Dearborn_3818.jpeg',108),(196,'1_Curb_Worth_1023.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x0/51251fa9bcd58/1_Curb_Worth_1023.jpeg',109),(197,'2807_Eagledale_Drive_Pic.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000003uR23/510fe8e41ef97/2807_Eagledale_Drive_Pic.jpeg',110),(198,'3351_north_butler.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000003uR25/510fe7e10fae6/3351_north_butler.jpeg',111),(199,'3025_alice.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000003uR27/510fe9b42f2e5/3025_alice.jpeg',112),(200,'7756_Mountain_Stream_Way_front.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000003uR26/510fe834b6bec/7756_Mountain_Stream_Way_front.jpeg',113),(201,'Post_Rd_1.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000003uR28/510fe949ef5fc/Post_Rd_1.jpeg',114),(202,'12151_southeastern.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000003uR29/510fe6d478f4e/12151_southeastern.jpeg',115),(203,'1405 17th front.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000003SaoY/50f4a2b41a44b/1405 17th front.jpeg',116),(204,'428-27th-ave-nw-birmingham-alabama-35215.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000003SaoZ/50f4a5502db62/428-27th-ave-nw-birmingham-alabama-35215.jpeg',117),(205,'43rd_1.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000003Saoa/50f4a3efe81ef/43rd_1.jpeg',118),(206,'Scatterwood_1.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000003Saoc/50f4a3783cc08/Scatterwood_1.jpeg',119),(207,'52nd_1.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000003Saob/50f4a2fb410ed/52nd_1.jpeg',120),(208,'Left_Side.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002lmvX/50bcdcc0a1665/Left_Side.jpeg',121),(209,'1328_Ensley_1.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSZ/5061faa621237/1328_Ensley_1.jpeg',122),(210,'Main.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSb/5061f296c8215/Main.jpeg',123),(211,'4708_CourtO_4.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSc/5069d87dd964f/4708_CourtO_4.jpeg',124),(212,'5913_Ave_M_2.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSf/5061f55792f61/5913_Ave_M_2.jpeg',125),(213,'2031_Center_1.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSg/5061f5abac0d7/2031_Center_1.jpeg',126),(214,'5900_Ave_M_1.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSe/5061f50de5d84/5900_Ave_M_1.jpeg',127),(215,'Front.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5C/5058c32129f14/Front.jpeg',128),(216,'Truman.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5V/504a47863e307/Truman.jpeg',129),(217,'Jackson_1.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5W/50649e1adb952/Jackson_1.jpeg',130),(218,'Garfield.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5X/506e0f4fc9234/Garfield.jpeg',131),(219,'Hardesty.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5Y/506e0e3112e6b/Hardesty.jpeg',132),(220,'DSCN1669.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5c/50634dfa1606d/DSCN1669.jpeg',133),(221,'2012-08-22_10-47-06_952.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5e/504a4ba9dc821/2012-08-22_10-47-06_952.jpeg',134),(327,'1_Curb_Payton_new.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xA/512524aec501d/1_Curb_Payton_new.jpeg',100),(329,'1_Curb_new.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x8/513637714ec02/1_Curb_new.jpeg',99),(331,'1_Curb_Lindley_1404.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x6/51252203de6d9/1_Curb_Lindley_1404.jpeg',98),(332,'1_curb_jamie_ct_mar_11_012.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x4/5125212ecb47b/1_curb_jamie_ct_mar_11_012.jpeg',97),(333,'1_Curb_Foltz_new.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x2/51252093085d1/1_Curb_Foltz_new.jpeg',96),(401,'Ritter Exteriors Sold 110.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9wz/512514d871386/Ritter Exteriors Sold 110.jpeg',94),(413,'Tammin.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9wv/5125185abaa60/Tammin.jpeg',257),(414,'849_south_worth.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000003uR24/510fe78e31bd6/849_south_worth.jpeg',258),(415,'Front1.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE00000035X7Y/50de14fba3ed6/Front1.jpeg',259),(416,'DSC_0711 (1024x681).jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE000000357Zr/50cf95d0cc4a4/DSC_0711 (1024x681).jpeg',260),(417,'6530_pike_view.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE000000357Zs/50cf956491555/6530 pike view.jpeg',261),(418,'main.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002lmvW/50bcd9e93b136/main.jpeg',262),(419,'3349_Winton_Ave_12.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002dI0u/50a5bc7fa244f/3349_Winton_Ave_12.jpeg',263),(420,'3525_Payton_Ave_1.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002dI0v/50a5bd28c4f32/3525 Payton_Ave_1.jpeg',264),(421,'4900_Ave_N_2.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002ZtGb/50984b2d3ecd4/4900_Ave_N_2.jpeg',265),(422,'1644_30th_Ensley_1.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002ZtGc/50984acc23f03/1644_30th_Ensley_1.jpeg',266),(423,'SAM_0599.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002ZtGd/50984a4af1e0a/SAM_0599.jpeg',267),(424,'Lesley.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002MvpC/508816361457c/Lesley.jpeg',268),(425,'4993_Beatrice.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002GqN9/5085bd80b4734/4993_Beatrice.jpeg',269),(426,'1521_33rd_Ensley_1.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001Q437/506e022dd8209/1521_33rd_Ensley_1.jpeg',270),(427,'218_Vann_1.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSW/5061f9dea914f/218_Vann_1.jpeg',271),(428,'1441_Warrior_1.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSX/5061fc8e7e8bf/1441_Warrior_1.jpeg',272),(429,'1401_46th_1.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSY/5061fc0711686/1401_46th_1.jpeg',273),(430,'1341_44th_1.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSa/5061fb807b999/1341_44th_1.jpeg',274),(431,'DSC_0582.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5G/504a4ed34cedc/DSC_0582.jpeg',275),(432,'4138_Breton_1.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5H/506ca0467402b/4138_Breton_1.jpeg',276),(433,'DSC_0249.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5I/50635b2663934/DSC_0249.jpeg',277),(434,'Picture1.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5Z/504a5f02a2539/Picture1.jpeg',278),(435,'DSC_0093.jpeg',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5f/504a537ce2786/DSC_0093.jpeg',279);
/*!40000 ALTER TABLE `PROPERTY_IMAGES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RAW_DATA`
--

DROP TABLE IF EXISTS `RAW_DATA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `RAW_DATA` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DATA_VALUE` text NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RAW_DATA`
--

LOCK TABLES `RAW_DATA` WRITE;
/*!40000 ALTER TABLE `RAW_DATA` DISABLE KEYS */;
/*!40000 ALTER TABLE `RAW_DATA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ROLE_AUTH`
--

DROP TABLE IF EXISTS `ROLE_AUTH`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ROLE_AUTH` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ROLE` varchar(45) NOT NULL,
  `ENABLED` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ROLE_AUTH`
--

LOCK TABLES `ROLE_AUTH` WRITE;
/*!40000 ALTER TABLE `ROLE_AUTH` DISABLE KEYS */;
/*!40000 ALTER TABLE `ROLE_AUTH` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `STATE_INFO`
--

DROP TABLE IF EXISTS `STATE_INFO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `STATE_INFO` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `STATE` varchar(45) NOT NULL,
  `CITY` varchar(45) NOT NULL,
  `ZIP` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=134 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `STATE_INFO`
--

LOCK TABLES `STATE_INFO` WRITE;
/*!40000 ALTER TABLE `STATE_INFO` DISABLE KEYS */;
INSERT INTO `STATE_INFO` VALUES (46,'IN','INDIANAPOLIS',46224),(47,'IN','INDIANAPOLIS',46224),(48,'IN','INDIANAPOLIS',46221),(49,'IN','INDIANAPOLIS',46241),(50,'IN','INDIANAPOLIS',46208),(51,'IN','INDIANAPOLIS',46241),(52,'IN','INDIANAPOLIS',46226),(53,'IN','INDIANAPOLIS',46241),(54,'IN','INDIANAPOLIS',46226),(55,'IN','INDIANAPOLIS',46226),(56,'OH','COLUMBUS',43204),(57,'IN','INDIANAPOLIS',46235),(58,'IN','INDIANAPOLIS',46201),(59,'IN','INDIANAPOLIS',46241),(60,'IN','INDIANAPOLIS',46241),(61,'IN','INDIANAPOLIS',46203),(62,'IN','INDIANAPOLIS',46221),(63,'IN','INDIANAPOLIS',46237),(64,'IN','INDIANAPOLIS',46241),(65,'IN','INDIANAPOLIS',46224),(66,'IN','INDIANAPOLIS',46218),(67,'IN','INDIANAPOLIS',46237),(68,'IN','INDIANAPOLIS',46239),(69,'IN','INDIANAPOLIS',46219),(70,'IN','INDIANAPOLIS',46259),(71,'AL','BIRMINGHAM',35211),(72,'AL','BIRMINGHAM',35215),(73,'IN','INDIANAPOLIS',46226),(74,'IN','INDIANAPOLIS',46221),(75,'IN','INDIANAPOLIS',46226),(76,'OH','TOLEDO',43608),(77,'AL','BIRMINGHAM',35208),(78,'AL','BIRMINGHAM',35208),(79,'AL','BIRMINGHAM',35208),(80,'AL','BIRMINGHAM',35228),(81,'AL','BIRMINGHAM',35205),(82,'AL','BIRMINGHAM',35228),(83,'AL','BIRMINGHAM',35206),(84,'MO','KANSAS CITY',64126),(85,'MO','KANSAS CITY',64126),(86,'MO','KANSAS CITY',64126),(87,'MO','KANSAS CITY',64127),(88,'AL','BIRMINGHAM',35206),(89,'AL','BESSEMER',35023),(90,'IN','INDIANAPOLIS',46254),(91,'OH','TOLEDO',43609),(92,'IN','INDIANAPOLIS',46268),(93,'IN','INDIANAPOLIS',46222),(94,'OH','COLUMBUS',43227),(95,'GA','LITHONIA',30058),(96,'GA','JONESBORO',30236),(97,'GA','DECATUR',30031),(98,'TN','MEMPHIS',38127),(99,'GA','JONESBORO',30238),(100,'IN','INDIANAPOLIS',46222),(101,'MS','SOUTHAVEN',38671),(102,'AL','BIRMINGHAM',35217),(103,'AL','BIRMINGHAM',35217),(104,'TN','CORDOVA',38018),(105,'AL','BESSEMER',35022),(106,'AL','BIRMINGHAM',35217),(107,'AL','BIRMINGHAM',35217),(108,'AL','BESSEMER',35020),(109,'TN','MEMPHIS',38134),(110,'TN','MEMPHIS',38133),(111,'IL','EAST SAINT LOUIS',62206),(112,'OH','TOLEDO',43610),(113,'IL','EAST SAINT LOUIS',62206),(114,'IL','EAST SAINT LOUIS',62206),(115,'AL','BIRMINGHAM',35212),(116,'IN','INDIANAPOLIS',46222),(117,'IL','EAST SAINT LOUIS',62206),(118,'MO','KANSAS CITY',64132),(119,'MO','KANSAS CITY',64138),(120,'MO','KANSAS CITY',64134),(121,'MS','JACKSON',39206),(122,'MS','JACKSON',39212),(123,'MS','JACKSON',39212),(124,'IN','INDIANAPOLIS',46222),(125,'IN','INDIANAPOLIS',46222),(126,'MI','MUSKEGON',49444),(127,'MI','MUSKEGON',49444),(128,'TN','MEMPHIS',38128),(129,'TN','MEMPHIS',38115),(130,'TN','MEMPHIS',38109),(131,'UT','WEST JORDAN',84088),(132,'TX','AUSTIN',78701),(133,'HI','KOLOA',96756);
/*!40000 ALTER TABLE `STATE_INFO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USERS`
--

DROP TABLE IF EXISTS `USERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USERS` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(75) NOT NULL,
  `ENABLED` tinyint(4) NOT NULL DEFAULT '0',
  `CRE_USER_ID` int(11) DEFAULT NULL,
  `CRE_DTM` datetime NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USERS`
--

LOCK TABLES `USERS` WRITE;
/*!40000 ALTER TABLE `USERS` DISABLE KEYS */;
/*!40000 ALTER TABLE `USERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `vw_PropertyFeed`
--

DROP TABLE IF EXISTS `vw_PropertyFeed`;
/*!50001 DROP VIEW IF EXISTS `vw_PropertyFeed`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vw_PropertyFeed` (
  `ID` int(11),
  `UUID` char(36),
  `PROP_NAME` varchar(150),
  `PRICE` float,
  `SQFT` varchar(45),
  `DESCRIPTION` varchar(255),
  `NUM_BEDS` float,
  `NUM_BATHS` float,
  `TYPE` varchar(45),
  `STATUS` varchar(45),
  `STATE_INFO_ID` int(11),
  `DATA_SOURCE_ID` int(11),
  `CUST_UUID` char(36),
  `DATASOURCE` varchar(45),
  `STATE` varchar(45),
  `CITY` varchar(45),
  `ZIP` int(11)
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vw_propertyFinacials`
--

DROP TABLE IF EXISTS `vw_propertyFinacials`;
/*!50001 DROP VIEW IF EXISTS `vw_propertyFinacials`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vw_propertyFinacials` (
  `ID` int(11),
  `PF_VALUE` decimal(6,2),
  `FINACIAL_KEY_ID` int(11),
  `PROPERTY_DATA_UUID` char(36),
  `KEY_ID` int(11),
  `PF_KEY` varchar(75)
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vw_propertyImages`
--

DROP TABLE IF EXISTS `vw_propertyImages`;
/*!50001 DROP VIEW IF EXISTS `vw_propertyImages`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vw_propertyImages` (
  `ID` int(11),
  `TITLE` varchar(150),
  `URL` varchar(150),
  `PROPERTY_DATA_ID` int(11)
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Dumping routines for database 'TALONDB'
--
/*!50003 DROP PROCEDURE IF EXISTS `pr_CleanPropertyImageData` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `pr_CleanPropertyImageData`()
BEGIN
	DELETE FROM `TALONDB`.`PROPERTY_IMAGES`;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pr_GetPropertyData` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `pr_GetPropertyData`(IN filterValue VARCHAR(45),IN filterBy VARCHAR(45),IN custUUId CHAR(36))
BEGIN 

CASE filterBy
	WHEN "customer" THEN
		SELECT 
		`vw_PropertyFeed`.*
		FROM `TALONDB`.`vw_PropertyFeed` WHERE CUST_UUID = custUUId;
	WHEN "property" THEN
		SELECT 
		`vw_PropertyFeed`.*
		FROM `TALONDB`.`vw_PropertyFeed` WHERE UUID=filterValue AND CUST_UUID = custUUId;
END CASE;

/*	IF propName = "ALL" THEN
		SELECT 
		`vw_PropertyFeed`.*
		FROM `TALONDB`.`vw_PropertyFeed`;
		
	ELSE
		SELECT 
		`vw_PropertyFeed`.*
		FROM `TALONDB`.`vw_PropertyFeed` WHERE PROP_NAME=propName;
	END IF;
*/
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pr_GetPropertyFinancialData` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `pr_GetPropertyFinancialData`(IN PROPUUID CHAR(36))
BEGIN
	

	IF PROPUUID = "ALL" THEN
		SELECT * FROM `TALONDB`.`vw_propertyFinacials`;
	ELSE
		SELECT * FROM `TALONDB`.`vw_propertyFinacials` WHERE PROPERTY_DATA_UUID = PROPUUID;
	END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pr_GetPropertyImageData` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `pr_GetPropertyImageData`(IN PropertyDataId INT)
BEGIN
	
	
	/*SELECT propertyUUId = UUID FROM `TALONDB`.`PROPERTY_DATA` WHERE UUID = propertyUUId; */

	SELECT * FROM `TALONDB`.`vw_propertyImages` WHERE PROPERTY_DATA_ID = PropertyDataId;
	
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `vw_PropertyFeed`
--

/*!50001 DROP TABLE IF EXISTS `vw_PropertyFeed`*/;
/*!50001 DROP VIEW IF EXISTS `vw_PropertyFeed`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_PropertyFeed` AS select `p`.`ID` AS `ID`,`p`.`UUID` AS `UUID`,`p`.`PROP_NAME` AS `PROP_NAME`,`p`.`PRICE` AS `PRICE`,`p`.`SQFT` AS `SQFT`,`p`.`DESCRIPTION` AS `DESCRIPTION`,`p`.`NUM_BEDS` AS `NUM_BEDS`,`p`.`NUM_BATHS` AS `NUM_BATHS`,`p`.`TYPE` AS `TYPE`,`p`.`STATUS` AS `STATUS`,`p`.`STATE_INFO_ID` AS `STATE_INFO_ID`,`p`.`DATA_SOURCE_ID` AS `DATA_SOURCE_ID`,`d`.`CUST_UUID` AS `CUST_UUID`,`d`.`NAME` AS `DATASOURCE`,`s`.`STATE` AS `STATE`,`s`.`CITY` AS `CITY`,`s`.`ZIP` AS `ZIP` from ((`PROPERTY_DATA` `p` join `DATA_SOURCE` `d`) join `STATE_INFO` `s`) where ((`p`.`DATA_SOURCE_ID` = `d`.`ID`) and (`p`.`STATE_INFO_ID` = `s`.`ID`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_propertyFinacials`
--

/*!50001 DROP TABLE IF EXISTS `vw_propertyFinacials`*/;
/*!50001 DROP VIEW IF EXISTS `vw_propertyFinacials`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_propertyFinacials` AS select `pf`.`ID` AS `ID`,`pf`.`VALUE` AS `PF_VALUE`,`pf`.`FINACIAL_KEY_ID` AS `FINACIAL_KEY_ID`,`pf`.`PROPERTY_DATA_UUID` AS `PROPERTY_DATA_UUID`,`fk`.`ID` AS `KEY_ID`,`fk`.`KEY` AS `PF_KEY` from (`PROPERTY_FINACIAL` `pf` join `FINACIAL_KEY` `fk`) where (`pf`.`FINACIAL_KEY_ID` = `fk`.`ID`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_propertyImages`
--

/*!50001 DROP TABLE IF EXISTS `vw_propertyImages`*/;
/*!50001 DROP VIEW IF EXISTS `vw_propertyImages`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_propertyImages` AS select `i`.`ID` AS `ID`,`i`.`TITLE` AS `TITLE`,`i`.`SRC_URL` AS `URL`,`i`.`PROPERTY_DATA_ID` AS `PROPERTY_DATA_ID` from `PROPERTY_IMAGES` `i` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-04-23  4:06:00
