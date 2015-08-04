CREATE DATABASE  IF NOT EXISTS `TALONDB` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `TALONDB`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: 192.168.1.201    Database: TALONDB
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CUSTOMER`
--

LOCK TABLES `CUSTOMER` WRITE;
/*!40000 ALTER TABLE `CUSTOMER` DISABLE KEYS */;
INSERT INTO `CUSTOMER` VALUES (1,'163572C0-9157-11E2-9E96-0800200C9A66','slvrstream',1),(2,'18e4ee40-ac25-11e2-9e96-0800200c9a66','testCustomer1',1),(3,'236c3e40-ac25-11e2-9e96-0800200c9a66','testCustomer2',1);
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
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FINACIAL_KEY`
--

LOCK TABLES `FINACIAL_KEY` WRITE;
/*!40000 ALTER TABLE `FINACIAL_KEY` DISABLE KEYS */;
INSERT INTO `FINACIAL_KEY` VALUES (24,'financed_net_yield_1__c'),(25,'monthly_cash_flow_with_financing_2__c'),(26,'financed_net_yield_2__c'),(27,'monthly_cash_flow_with_financing_1__c'),(28,'interest_rate_2__c'),(29,'interest_rate_1__c'),(30,'price_per_ft_c'),(31,'noi_with_financing_1__c'),(32,'noi_with_financing_2__c'),(33,'noi__c'),(34,'monthly_cash_flow__c'),(35,'est_replacement_cost__c'),(36,'est_replacement_cost_per_sq_ft__c'),(37,'cash_net_yield__c'),(38,'down_payment_1__c'),(39,'down_payment_2__c'),(40,'interest_payment_1__c'),(41,'yearly_interest_payment_1__c'),(42,'monthly_interest_payment_2__c');
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GROUPS`
--

LOCK TABLES `GROUPS` WRITE;
/*!40000 ALTER TABLE `GROUPS` DISABLE KEYS */;
INSERT INTO `GROUPS` VALUES (1,'cce779c0-ac1c-11e2-9e96-0800200c9a66','ADMINS','163572C0-9157-11E2-9E96-0800200C9A66');
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GROUP_MEMBERS`
--

LOCK TABLES `GROUP_MEMBERS` WRITE;
/*!40000 ALTER TABLE `GROUP_MEMBERS` DISABLE KEYS */;
INSERT INTO `GROUP_MEMBERS` VALUES (1,1,1);
/*!40000 ALTER TABLE `GROUP_MEMBERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `GROUP_ROLE_MAP`
--

DROP TABLE IF EXISTS `GROUP_ROLE_MAP`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GROUP_ROLE_MAP` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SYSTEM_ROLES_ID` int(11) NOT NULL,
  `GROUPS_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_GROUP_ROLE_MAP_SYSTEM_ROLES1_idx` (`SYSTEM_ROLES_ID`),
  KEY `fk_GROUP_ROLE_MAP_GROUPS1_idx` (`GROUPS_ID`),
  CONSTRAINT `fk_GROUP_ROLE_MAP_GROUPS1` FOREIGN KEY (`GROUPS_ID`) REFERENCES `GROUPS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_GROUP_ROLE_MAP_SYSTEM_ROLES1` FOREIGN KEY (`SYSTEM_ROLES_ID`) REFERENCES `SYSTEM_ROLES` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GROUP_ROLE_MAP`
--

LOCK TABLES `GROUP_ROLE_MAP` WRITE;
/*!40000 ALTER TABLE `GROUP_ROLE_MAP` DISABLE KEYS */;
INSERT INTO `GROUP_ROLE_MAP` VALUES (1,1,1);
/*!40000 ALTER TABLE `GROUP_ROLE_MAP` ENABLE KEYS */;
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
  `DESCRIPTION` varchar(2000) NOT NULL,
  `NUM_BEDS` float NOT NULL DEFAULT '0',
  `NUM_BATHS` float NOT NULL DEFAULT '0',
  `TYPE` varchar(45) NOT NULL,
  `STATUS` varchar(45) NOT NULL,
  `DATA_SOURCE_ID` int(11) NOT NULL,
  `ZIP_CODE` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UUID_UNIQUE` (`UUID`),
  KEY `fk_PROPERTY_DATA_DATA_SOURCE1_idx` (`DATA_SOURCE_ID`),
  KEY `fk_PROPERTY_DATA_ZIP_CODES1_idx` (`ZIP_CODE`),
  CONSTRAINT `fk_PROPERTY_DATA_DATA_SOURCE1` FOREIGN KEY (`DATA_SOURCE_ID`) REFERENCES `DATA_SOURCE` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_PROPERTY_DATA_ZIP_CODES1` FOREIGN KEY (`ZIP_CODE`) REFERENCES `ZIP_CODES` (`ZIP_CODE`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=456 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PROPERTY_DATA`
--

LOCK TABLES `PROPERTY_DATA` WRITE;
/*!40000 ALTER TABLE `PROPERTY_DATA` DISABLE KEYS */;
INSERT INTO `PROPERTY_DATA` VALUES (392,'1f80548a-9abe-4e4b-81d1-7745f9fa7f0c','444-446 Linwood',60000,'0','This 2032 square foot multi-family home has 4 bedrooms and 2 bathrooms (2 bed/1 bath per sides). The property has a lot size of 2,614 sq. ft. The average list price for similar homes for sale is $122,775 and the average sales price for similar recently sold homes is $161,007',4,2,'MFR','Active',1,43205),(393,'8189c973-faf4-4317-bd86-5fd2e39da7ce','534-536 Oakwood',70000,'0','This multi-family duplex has 6 beds, 2 baths (3 bed/1 bath per side), and approximately 2,784 square feet. The property has a lot size of 5,227 sq. ft. in historic Olde Town East area of Columbus. The average list price for similar homes for sale is $121,442 and the average sales price for similar recently sold homes is $161,007.',6,2,'MFR','Active',1,43205),(394,'2fafc815-eb02-4afa-9961-d83fa39219ed','568-570 Kimball',62000,'0','This multi-family duplex has 6 beds, 2 baths (3 bed/1 bath per side) and approximately 2,880 square feet. The property has a lot size of 7,405 sq. ft. and was built in 1913 in the South of Main area of Columbus. The average list price for similar homes for sale is $111,475 and the average sales price for similar recently sold homes is $161,007.',6,2,'MFR','Active',1,43205),(395,'de91df99-ccb1-42c8-b649-48266f867a81','564-566 Kimball',65000,'0','This 3006 square foot multi-family home with detached garage has 6 bedrooms and 2 bathrooms (3 bed/1 bath per side). The property has a lot size of 7,405 sq. ft. and was built in 1914. The average list price for similar homes for sale is $111,475 and the average sales price for similar recently sold homes is $161,007.',6,2,'MFR','Active',1,43205),(396,'401af556-ed38-49d1-97b8-427a77c610fa','3117 Huber St',60000,'0','This quaint 3 bedroom, 1 bath single family residence has a renter in place and has been completely rehabbed with attached garage and located in a great neighborhood. The average list price for similar homes for sale is $66,475. 3117 N Huber St is in the 46226 ZIP code in Indianapolis, IN. The average list price for ZIP code 46226 is $98,455. Garage',3,1,'SFR','Active',1,46226),(397,'a6389d13-19ad-4f98-9281-9baf66348507','2613 N Rural',69000,'0','This newer 2 bedroom, 1 bath ranch home in Oxford Terrace is approximately 1,064 sq. ft. on a lot size of 9,898 sq. ft. Built in 1990 this home has brand new carpet, paint and is move in ready. Two full bathrooms means never having to fight for who gets to go next. This home offers an open living concept in the living area and kitchen. A nice back yard has plenty of room for all your entertaining needs. A two car attached garage will keep you from scraping windows in the winter and still leaves room for extra storage. Hurry to schedule your showing, this property will not last long. The average sales price for similar recently sold homes is $82,500.',3,2,'SFR','Active',1,46218),(398,'f48180c2-11a2-4e4c-bc0d-d2a6c4bd3686','886-888 Fulton',60000,'0','This multi-family duplex has 6 beds, 2 baths (3 bed/1 bath per side), and is approximately 2,452 square feet. The property has a lot size of 6,534 sq. ft. in historic Olde Town East area of Columbus. The average list price for similar homes for sale is $126,339 and the average sales price for similar recently sold homes is $163,357.',6,2,'MFR','Active',1,43205),(399,'acdd73b9-5fd6-4f3b-a359-05204f49eb4b','5456 Ruskin PL',62000,'0','This cute little 3 bedroom, 1 bath single family home is near all the shopping areas. The property has a lot size of 6,615 sq. ft. and was built in 1957. Brand new carpet and paint in home; dryer included. Also, has economical and efficient gas range, furnace and hot water heater. Nice window treatments in most rooms. Nice big back yard with storage shed & large covered patio. The home is situated close to corner, so easy access to 38th street. Brand new garage door plus new front & back storm doors.',3,1,'SFR','Active',1,46224),(400,'a90b6e03-bc33-4633-9e2d-f800246d473f','6131 Tammin Dr',92000,'0','Tenant already in place. Great rental home on the West side of Indianapolis. New furnace. New paint. Property is in great condition!',3,1,'SFR','Sold',1,46254),(401,'275a29a1-ba98-4e97-b382-966056f4c41b','1232 Reisner',54900,'0','This property has all new flooring, paint, and vinyl windows. Large 3 BD home.',3,1.5,'SFR','Active',1,46221),(402,'67bdf0e5-d36c-4cb3-955a-264afcfce701','3907 Rookwood',51900,'0','Large 4 BD home. New roof and vinyl windows. Updated exterior siding, kitchen, water heater, and furnace.',4,1,'SFR','Active',1,46208),(403,'d956a7ab-1967-457b-b205-98922c899a41','801 Worth',57900,'0','This home has been updated inside and out. New vinyl windows. Currently occupied with a great sec 8 tenant.',3,1,'SFR','Active',1,46241),(404,'bbc863d3-a1ac-4317-a666-d79a1cc87f70','745 Holmes S',55900,'0','Charming 3 BD home close to downtown. Refinished hardwood flooring. All new paint. New flooring in kitchen and bath.',3,1,'SFR','Active',1,46221),(405,'f72b3435-2eb1-465e-b35c-49669fbd909d','2009 Legrande',53900,'0','Great 3 BD home with a fenced backyard. New kitchen with tile backsplash. 2 car garage.',3,1,'SFR','Active',1,46203),(406,'585d29e8-b484-48ee-a1fe-494e211fc5ef','1411 Lindley',53900,'0','Great little 2 BD home. Completely remodeled with hardwood floors in a great area. Cental A/C.',2,1,'SFR','Active',1,46241),(407,'f21ccfed-78ce-4843-9f57-7f6b4a2f30cf','1244 Moreland A/B',104000,'0','2 Homes on one lot! Both homes sit on a quiet street. Both homes are 3BD/2BA. Currently rented with great tenants. Great westside property.',5,2,'SFR','Active',1,46241),(408,'7094473d-988d-482a-9576-cbebd4fa76ed','110 N Linwood Ave',52900,'0','This one is rented and ready to cash flow. Extensive rehab just completed. New flooring and paint throughout. All new window coverings, new A/C. Big square footage for the money.',3,1.5,'SFR','Sold',1,46201),(409,'e0a73b8f-5ed9-4532-85a3-a97cb3df5858','3429 Payton',57900,'0','Nice 3 BD Ranch. Maintenance-free stone exterior. Big fenced yard. Deck with multiple levels in backyard. New paint. New tile, laminate and carpet throughout. New kitchen cabinets and countertops. Newer furnace and A/C.',3,1.5,'SFR','Active',1,46226),(410,'a27e5002-333c-4d67-a189-38067ac98c77','625 Melvenia Ave',54900,'0','Sweet little 3 BD bungalow on a corner lot. Full unfinished basement with laundry area. New vinyl windows. Glass tile backsplash in kitchen.',3,1,'SFR','Active',1,46226),(411,'867a9ef9-b92c-4a93-af6a-9d3b19f339ad','1404 Lindley',55900,'0','Completely remodeled with hardwood floors. 2 car oversized garage. Central A/C with fenced yard.',3,1.5,'SFR','Active',1,46241),(412,'8b0ea03c-4e8d-4efa-92dc-b07bd74f4e00','4249 Jamie Ct',56900,'0','Big ranch with great room addition on back with large fireplace and built-in grill. All new flooring and windows. Granite counters in the kitchen. One car attached garage.',3,2,'SFR','Active',1,46226),(413,'10171fe3-c38d-49bb-9362-8e60ce2e3623','2636 Foltz',55900,'0','Great little home on the West side. All new windows and kitchen. New flooring and paint throughout.',4,1.5,'SFR','Active',1,46241),(414,'3c4aa9c9-c57a-467b-a70d-5d87b97de70a','3818 Dearborne S',69900,'0','Large home with big rooms and extra family room in a great neighborhood. Limestone maintenance-free exterior. Big back yard with storage sheds. New kitchen, Vinyl windows, and refinished hardwood floors.',3,1,'SFR','Active',1,46237),(415,'53f57cc2-c85e-4dc7-a73e-a17d169551ef','1023 Worth',56900,'0','Great ranch house with new vinyl windows. Hardwood floors, new kitchen and bath.',3,1,'SFR','Active',1,46241),(416,'3191fb8d-6df0-4695-b136-3f0ee2edb778','849 S Worth Ave',53900,'0','This home sits in a great neighborhood. Easy to rent homes in the area. New flooring and paint. New kitchen.',3,1,'SFR','Sold',1,46241),(417,'4277a1c4-e958-4d3f-bc79-d980c9b5010f','3351 Butler Ave',53900,'0','Wonderful little home on the west side of Indianapolis. Updated exterior. New flooring and paint throughout. Upgraded kitchen.',3,1,'SFR','Active',1,46218),(418,'bb7160fa-f766-4409-97f6-1225ae51b502','3025 Alice Ave',57900,'0','Get a home in this desireable neighborhood for less than $40/sqft. New paint and carpet throughout. New A/C and water heater. Big house for the money.',3,1.5,'SFR','Sold',1,46237),(419,'109fe6da-3204-4303-b7e5-3058206d0908','7756 Mountain Stream',55000,'0','Amazing deal for this townhouse built in 2007! New furnace and A/C. New carpet and paint throughout.',4,3,'SFR','Sold',1,46239),(420,'82e5366a-0d1f-4adc-952f-84e4c5bae84a','1405 17th Way SW',55900,'0','Great home by the college. Quiet neighborhood. New roof. New flooring throughout. New paint throughout. Brand new Furnace and A/C.  Priced well under market at $34 Sqft.',3,1.5,'SFR','Active',1,35211),(421,'ad52a2b3-c873-4003-bd01-e064ed3482c0','5319 Scatterwood',89000,'0','Great price for a newer home. Brand new Furnace and A/C. All new flooring and paint throughout. New electrical. New water heater. Great access to parks, golf courses, and International airport.  Tax Value 100k+',3,2,'SFR','Sold',1,46221),(422,'ebe0af52-d307-435f-bafa-217d429b576d','325 Hiett Ave',32000,'0','Great home in a Great market!',3,1,'SFR','Sold',1,43609),(423,'a9af3c99-17e8-4d2a-81ba-1568306e66c8','3236 Welch Dr',57900,'0','New vinyl windows and siding.All new window treatments. New interior paint. All new appliances. New flooring throughout the house. New water heater. New roof.  High demand rental neighborhood located on the west side of Indianapolis.',4,1.5,'SFR','Sold',1,46224),(424,'dd9252c6-2d5d-4855-a918-5311cdafec8e','6530 Pike View Ct',82000,'0','Home just renovated. Built in 1989. Great long-term tenant. Great price for this home that is already cash-flowing. Great neighborhood close to some of the best schools in Indy.',3,2,'SFR','Sold',1,46268),(425,'6f4b7216-7c06-406e-8329-28c3e7fc1f15','3126 Gerrard Ave',57900,'0','Great home in a Great market!',3,2,'SFR','Sold',1,46224),(426,'bc3ad9da-45e0-4946-87a9-fea2428d8ba0','212 Mettler',39900,'0','Great home in a Great market!',3,1,'SFR','Active',1,43608),(427,'a6d9d6d7-b8ed-4ede-8af2-2c80118d71cb','3349 Winton Ave',57900,'0','All new windows. New flooring, paint, mechanicals. All new appliances. New light fixtures throughout.  Long-term tenant. Very desireable Eagledale neighborhood.',3,1,'SFR','Sold',1,46224),(428,'33441dcd-cf56-4dc5-9e1e-3da64f71791b','3525 N Payton Ave',56900,'0','Great home in a Great market!',3,1,'SFR','Sold',1,46226),(429,'dcdbd268-31a7-45d6-bff9-e8297eda5cd3','4900 Ave N',49500,'0','Great home in a Great market!',3,1.5,'SFR','Sold',1,35208),(430,'834cba98-a484-438e-a276-e6fd410277c6','1644 30th St Ensley',46000,'0','New heat pump, hardwood floors! Great long-term tenant!',3,2,'SFR','Sold',1,35208),(431,'327a6f24-5dd5-4c4d-9839-20bb4e6414fb','1505 S Leland Ave',54900,'0','Great home in a Great market!',3,1,'SFR','Sold',1,46203),(432,'834a104e-8e1a-4634-84eb-ce7b0962f0ed','1804 N Lesley Ave',56900,'0','Great home in a Great market!',3,1.5,'SFR','Sold',1,46222),(433,'600c3f3c-6f0a-4e9a-977d-1f90d033711d','4993 Beatrice Dr.',58000,'0','New cherry cabinets, windows, paint! Quiet neighborhood!',3,1.5,'SFR','Sold',1,43227),(434,'ad701847-f669-47ca-af17-0d4841e3060e','1521 33rd St Ensley',46500,'0','Fully remodeled less than 2yrs ago including new roof! Hardwod floors.',3,1,'SFR','Sold',1,35208),(435,'b76b2c53-dc96-4876-b10b-cc38bcb0ced0','218 Vann St',47000,'0','Great home in a Great market!',3,2,'SFR','Sold',1,35228),(436,'075f2512-1598-4d48-baec-a627056bc3fd','1441 Warrior Rd',47500,'0','Great home in a Great market!',3,1,'SFR','Sold',1,35208),(437,'896302c4-962f-4c81-a9dc-5810e9406fe6','1328 43rd St Ensley',46500,'0','Great home in a Great market!',3,1,'SFR','Active',1,35208),(438,'0294f5e0-53b5-4ce2-927e-d5cd06ab9d31','1401 46th St Ensley',47500,'0','New roof, New HVAC, all hardwood floors!Big Master and great tenant.',3,1,'SFR','Sold',1,35208),(439,'5a62d899-d81e-4c62-b80d-075de1653eb6','1341 44th St Ensley',52500,'0','Great home in a Great market!',3,1,'SFR','Sold',1,35208),(440,'7901b0ed-a686-435f-9b16-43c420b8f207','4708 Court O',39000,'0','Great home in a Great market!',2,1,'SFR','Active',1,35208),(441,'7cef0925-c5bb-450b-af9a-465c142bd253','5913 Avenue M',36000,'0','New windows. New kitchen. Roof only 2 years old. Hardwood floors throughout which means less maintenance. New HVAC system. Long-term tenant.  All of this for under 50k!',2,1,'SFR','Active',1,35228),(442,'12453af9-bb1a-4af2-ab65-688f3aaa43e7','2031 Center Street S',39000,'0','Great home in a Great market!',2,1,'SFR','Active',1,35205),(443,'5dac471b-86e0-4e63-a8fa-f62b5a73c2de','5900 Avenue M',49000,'0','New windows.Brand new roof with a 30 yr warranty. Brand new furnace and A/C. Great neighborhood and tenant is signed to a long-term lease. Can\'t beat a 1300 Sqft home for under 50k!',3,2,'SFR','Active',1,35228),(444,'f517f214-08e2-4d6d-998b-1a88130e71b5','2672 20th Street',39000,'0','Great Section 8 tenant! Full rehab. No carpet means less maintenance!',2,1,'SFR','Active',1,35208),(445,'9e9d835d-6ccc-422d-bc87-5ac59b1be01e','1147 North Berwick Avenue',54900,'0','Great tenant. All new appliances, new tile, hardwood floors which means less maintenance. Great curb appeal. Very Quiet neighborhood but very convenient to shopping and downtown. Very desireable Eagledale section of Indianapolis.',3,1,'SFR','Sold',1,46222),(446,'10f4b906-49c5-437c-b2d6-3ecc249e4a8c','4138 Breton St',53900,'0','Great home in a Great market!',3,1,'SFR','Sold',1,46222),(447,'898bb6a5-c46c-443b-bd3c-4ebcc0645cae','477 South Exeter',54900,'0','Great home in a Great market!',3,1,'SFR','Sold',1,46241),(448,'9f75eb7f-b884-4802-b2ba-bb70466e2070','6201 E Truman Road',82000,'0','Great duplex. Recent $3000 in rehab Unit A, Section 8, $1020 Unit A, owner pays utilities. 6 month rent gurantee $500 per month on Unit B. Undr good management.',6,2,'Duplex','Active',1,64126),(449,'92fec5e1-aef9-40c5-8ead-f85d63db5ab7','521/523 Jackson St',145000,'0','Great price for a 4-unit building. Fully rehabbed. Great location.',8,4,'4Plex','Active',1,64126),(450,'ef6af867-3eaf-436e-b96c-6391b9756037','5208 Garfield',52000,'0','Nice single-family home. All new flooring throughout. New Furnace and A/C. New water heater.   Great curb appeal with a stone front.',3,1,'SFR','Active',1,64126),(451,'8fce50a7-5691-4756-8482-50dc28640d09','2429 Hardesty',37000,'0','New roof. New Furnace and A/C. Hardwood floors. Good long-term Section 8 tenant. Great price on this single-family home. Grab this one with less than 20k down!',2,1,'SFR','Active',1,64127),(452,'327f6a33-0e92-47b5-aa30-cc31df85bce8','528 Cadillac',42000,'0','Great home in a Great market!',6,2,'Duplex','Sold',1,43610),(453,'3a19cb0e-e92d-4d82-934a-7543bfc7cf9c','8109 1st Avenue S',30000,'0','Great home in a Great market!',2,1,'SFR','Active',1,35206),(454,'16c55d0d-67da-473b-b2ed-a4e7e71a4402','2036 Mayfield',45900,'0','Great home in a Great market!',3,1,'SFR','Active',1,35023),(455,'37d7f0fb-a6fd-49fe-868e-4dec73d425cf','2937 Mussman Dr',54900,'0','Great home in a Great market!',4,2,'SFR','Sold',1,46222);
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
) ENGINE=InnoDB AUTO_INCREMENT=2439 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PROPERTY_FINACIAL`
--

LOCK TABLES `PROPERTY_FINACIAL` WRITE;
/*!40000 ALTER TABLE `PROPERTY_FINACIAL` DISABLE KEYS */;
INSERT INTO `PROPERTY_FINACIAL` VALUES (1424,13.70,24,'1f80548a-9abe-4e4b-81d1-7745f9fa7f0c'),(1425,494.26,25,'1f80548a-9abe-4e4b-81d1-7745f9fa7f0c'),(1426,32.95,26,'1f80548a-9abe-4e4b-81d1-7745f9fa7f0c'),(1427,616.47,27,'1f80548a-9abe-4e4b-81d1-7745f9fa7f0c'),(1428,8.00,29,'1f80548a-9abe-4e4b-81d1-7745f9fa7f0c'),(1429,7.00,28,'1f80548a-9abe-4e4b-81d1-7745f9fa7f0c'),(1430,29.53,30,'1f80548a-9abe-4e4b-81d1-7745f9fa7f0c'),(1431,7397.70,31,'1f80548a-9abe-4e4b-81d1-7745f9fa7f0c'),(1432,5931.12,32,'1f80548a-9abe-4e4b-81d1-7745f9fa7f0c'),(1433,8858.00,33,'1f80548a-9abe-4e4b-81d1-7745f9fa7f0c'),(1434,738.00,34,'1f80548a-9abe-4e4b-81d1-7745f9fa7f0c'),(1435,70.00,36,'1f80548a-9abe-4e4b-81d1-7745f9fa7f0c'),(1436,14.76,37,'1f80548a-9abe-4e4b-81d1-7745f9fa7f0c'),(1437,36.94,40,'1f80548a-9abe-4e4b-81d1-7745f9fa7f0c'),(1438,443.00,41,'1f80548a-9abe-4e4b-81d1-7745f9fa7f0c'),(1439,243.87,42,'1f80548a-9abe-4e4b-81d1-7745f9fa7f0c'),(1440,14.39,24,'8189c973-faf4-4317-bd86-5fd2e39da7ce'),(1441,612.65,25,'8189c973-faf4-4317-bd86-5fd2e39da7ce'),(1442,35.01,26,'8189c973-faf4-4317-bd86-5fd2e39da7ce'),(1443,755.23,27,'8189c973-faf4-4317-bd86-5fd2e39da7ce'),(1444,8.00,29,'8189c973-faf4-4317-bd86-5fd2e39da7ce'),(1445,7.00,28,'8189c973-faf4-4317-bd86-5fd2e39da7ce'),(1446,25.14,30,'8189c973-faf4-4317-bd86-5fd2e39da7ce'),(1447,9062.78,31,'8189c973-faf4-4317-bd86-5fd2e39da7ce'),(1448,7351.77,32,'8189c973-faf4-4317-bd86-5fd2e39da7ce'),(1449,897.00,34,'8189c973-faf4-4317-bd86-5fd2e39da7ce'),(1450,70.00,36,'8189c973-faf4-4317-bd86-5fd2e39da7ce'),(1451,15.38,37,'8189c973-faf4-4317-bd86-5fd2e39da7ce'),(1452,43.10,40,'8189c973-faf4-4317-bd86-5fd2e39da7ce'),(1453,517.00,41,'8189c973-faf4-4317-bd86-5fd2e39da7ce'),(1454,284.52,42,'8189c973-faf4-4317-bd86-5fd2e39da7ce'),(1455,14.17,24,'2fafc815-eb02-4afa-9961-d83fa39219ed'),(1456,532.45,25,'2fafc815-eb02-4afa-9961-d83fa39219ed'),(1457,34.35,26,'2fafc815-eb02-4afa-9961-d83fa39219ed'),(1458,658.74,27,'2fafc815-eb02-4afa-9961-d83fa39219ed'),(1459,8.00,29,'2fafc815-eb02-4afa-9961-d83fa39219ed'),(1460,7.00,28,'2fafc815-eb02-4afa-9961-d83fa39219ed'),(1461,21.53,30,'2fafc815-eb02-4afa-9961-d83fa39219ed'),(1462,7904.84,31,'2fafc815-eb02-4afa-9961-d83fa39219ed'),(1463,6389.37,32,'2fafc815-eb02-4afa-9961-d83fa39219ed'),(1464,9413.00,33,'2fafc815-eb02-4afa-9961-d83fa39219ed'),(1465,784.00,34,'2fafc815-eb02-4afa-9961-d83fa39219ed'),(1466,70.00,36,'2fafc815-eb02-4afa-9961-d83fa39219ed'),(1467,15.18,37,'2fafc815-eb02-4afa-9961-d83fa39219ed'),(1468,38.17,40,'2fafc815-eb02-4afa-9961-d83fa39219ed'),(1469,458.00,41,'2fafc815-eb02-4afa-9961-d83fa39219ed'),(1470,252.00,42,'2fafc815-eb02-4afa-9961-d83fa39219ed'),(1471,12.85,24,'de91df99-ccb1-42c8-b649-48266f867a81'),(1472,493.80,25,'de91df99-ccb1-42c8-b649-48266f867a81'),(1473,30.39,26,'de91df99-ccb1-42c8-b649-48266f867a81'),(1474,626.20,27,'de91df99-ccb1-42c8-b649-48266f867a81'),(1475,8.00,29,'de91df99-ccb1-42c8-b649-48266f867a81'),(1476,7.00,28,'de91df99-ccb1-42c8-b649-48266f867a81'),(1477,21.62,30,'de91df99-ccb1-42c8-b649-48266f867a81'),(1478,7514.44,31,'de91df99-ccb1-42c8-b649-48266f867a81'),(1479,5925.65,32,'de91df99-ccb1-42c8-b649-48266f867a81'),(1480,9096.00,33,'de91df99-ccb1-42c8-b649-48266f867a81'),(1481,758.00,34,'de91df99-ccb1-42c8-b649-48266f867a81'),(1482,70.00,36,'de91df99-ccb1-42c8-b649-48266f867a81'),(1483,13.99,37,'de91df99-ccb1-42c8-b649-48266f867a81'),(1484,40.02,40,'de91df99-ccb1-42c8-b649-48266f867a81'),(1485,480.00,41,'de91df99-ccb1-42c8-b649-48266f867a81'),(1486,264.20,42,'de91df99-ccb1-42c8-b649-48266f867a81'),(1487,10.65,24,'401af556-ed38-49d1-97b8-427a77c610fa'),(1488,356.96,25,'401af556-ed38-49d1-97b8-427a77c610fa'),(1489,23.80,26,'401af556-ed38-49d1-97b8-427a77c610fa'),(1490,479.17,27,'401af556-ed38-49d1-97b8-427a77c610fa'),(1491,8.00,29,'401af556-ed38-49d1-97b8-427a77c610fa'),(1492,7.00,28,'401af556-ed38-49d1-97b8-427a77c610fa'),(1493,62.50,30,'401af556-ed38-49d1-97b8-427a77c610fa'),(1494,5750.10,31,'401af556-ed38-49d1-97b8-427a77c610fa'),(1495,4283.52,32,'401af556-ed38-49d1-97b8-427a77c610fa'),(1496,7210.00,33,'401af556-ed38-49d1-97b8-427a77c610fa'),(1497,601.00,34,'401af556-ed38-49d1-97b8-427a77c610fa'),(1498,70.00,36,'401af556-ed38-49d1-97b8-427a77c610fa'),(1499,12.02,37,'401af556-ed38-49d1-97b8-427a77c610fa'),(1500,36.94,40,'401af556-ed38-49d1-97b8-427a77c610fa'),(1501,443.00,41,'401af556-ed38-49d1-97b8-427a77c610fa'),(1502,243.87,42,'401af556-ed38-49d1-97b8-427a77c610fa'),(1503,9.50,24,'a6389d13-19ad-4f98-9281-9baf66348507'),(1504,351.21,25,'a6389d13-19ad-4f98-9281-9baf66348507'),(1505,20.36,26,'a6389d13-19ad-4f98-9281-9baf66348507'),(1506,491.76,27,'a6389d13-19ad-4f98-9281-9baf66348507'),(1507,8.00,29,'a6389d13-19ad-4f98-9281-9baf66348507'),(1508,7.00,28,'a6389d13-19ad-4f98-9281-9baf66348507'),(1509,64.85,30,'a6389d13-19ad-4f98-9281-9baf66348507'),(1510,5901.11,31,'a6389d13-19ad-4f98-9281-9baf66348507'),(1511,4214.55,32,'a6389d13-19ad-4f98-9281-9baf66348507'),(1512,7580.00,33,'a6389d13-19ad-4f98-9281-9baf66348507'),(1513,632.00,34,'a6389d13-19ad-4f98-9281-9baf66348507'),(1514,70.00,36,'a6389d13-19ad-4f98-9281-9baf66348507'),(1515,10.99,37,'a6389d13-19ad-4f98-9281-9baf66348507'),(1516,42.48,40,'a6389d13-19ad-4f98-9281-9baf66348507'),(1517,510.00,41,'a6389d13-19ad-4f98-9281-9baf66348507'),(1518,280.45,42,'a6389d13-19ad-4f98-9281-9baf66348507'),(1519,13.38,24,'f48180c2-11a2-4e4c-bc0d-d2a6c4bd3686'),(1520,480.03,25,'f48180c2-11a2-4e4c-bc0d-d2a6c4bd3686'),(1521,32.00,26,'f48180c2-11a2-4e4c-bc0d-d2a6c4bd3686'),(1522,602.24,27,'f48180c2-11a2-4e4c-bc0d-d2a6c4bd3686'),(1523,8.00,29,'f48180c2-11a2-4e4c-bc0d-d2a6c4bd3686'),(1524,7.00,28,'f48180c2-11a2-4e4c-bc0d-d2a6c4bd3686'),(1525,24.47,30,'f48180c2-11a2-4e4c-bc0d-d2a6c4bd3686'),(1526,7226.90,31,'f48180c2-11a2-4e4c-bc0d-d2a6c4bd3686'),(1527,5760.32,32,'f48180c2-11a2-4e4c-bc0d-d2a6c4bd3686'),(1528,8687.00,33,'f48180c2-11a2-4e4c-bc0d-d2a6c4bd3686'),(1529,724.00,34,'f48180c2-11a2-4e4c-bc0d-d2a6c4bd3686'),(1530,70.00,36,'f48180c2-11a2-4e4c-bc0d-d2a6c4bd3686'),(1531,14.48,37,'f48180c2-11a2-4e4c-bc0d-d2a6c4bd3686'),(1532,36.94,40,'f48180c2-11a2-4e4c-bc0d-d2a6c4bd3686'),(1533,443.00,41,'f48180c2-11a2-4e4c-bc0d-d2a6c4bd3686'),(1534,243.87,42,'f48180c2-11a2-4e4c-bc0d-d2a6c4bd3686'),(1535,11.06,24,'acdd73b9-5fd6-4f3b-a359-05204f49eb4b'),(1536,388.00,25,'acdd73b9-5fd6-4f3b-a359-05204f49eb4b'),(1537,25.03,26,'acdd73b9-5fd6-4f3b-a359-05204f49eb4b'),(1538,514.29,27,'acdd73b9-5fd6-4f3b-a359-05204f49eb4b'),(1539,8.00,29,'acdd73b9-5fd6-4f3b-a359-05204f49eb4b'),(1540,7.00,28,'acdd73b9-5fd6-4f3b-a359-05204f49eb4b'),(1541,64.99,30,'acdd73b9-5fd6-4f3b-a359-05204f49eb4b'),(1542,6171.44,31,'acdd73b9-5fd6-4f3b-a359-05204f49eb4b'),(1543,4655.97,32,'acdd73b9-5fd6-4f3b-a359-05204f49eb4b'),(1544,7680.00,33,'acdd73b9-5fd6-4f3b-a359-05204f49eb4b'),(1545,640.00,34,'acdd73b9-5fd6-4f3b-a359-05204f49eb4b'),(1546,70.00,36,'acdd73b9-5fd6-4f3b-a359-05204f49eb4b'),(1547,12.39,37,'acdd73b9-5fd6-4f3b-a359-05204f49eb4b'),(1548,38.17,40,'acdd73b9-5fd6-4f3b-a359-05204f49eb4b'),(1549,458.00,41,'acdd73b9-5fd6-4f3b-a359-05204f49eb4b'),(1550,252.00,42,'acdd73b9-5fd6-4f3b-a359-05204f49eb4b'),(1551,14.47,24,'a90b6e03-bc33-4633-9e2d-f800246d473f'),(1552,628.01,25,'a90b6e03-bc33-4633-9e2d-f800246d473f'),(1553,27.30,26,'a90b6e03-bc33-4633-9e2d-f800246d473f'),(1554,388.17,27,'a90b6e03-bc33-4633-9e2d-f800246d473f'),(1555,10.00,29,'a90b6e03-bc33-4633-9e2d-f800246d473f'),(1556,4.85,28,'a90b6e03-bc33-4633-9e2d-f800246d473f'),(1557,72.44,30,'a90b6e03-bc33-4633-9e2d-f800246d473f'),(1558,4658.00,31,'a90b6e03-bc33-4633-9e2d-f800246d473f'),(1559,7536.16,32,'a90b6e03-bc33-4633-9e2d-f800246d473f'),(1560,886.50,34,'a90b6e03-bc33-4633-9e2d-f800246d473f'),(1561,70.00,36,'a90b6e03-bc33-4633-9e2d-f800246d473f'),(1562,11.56,37,'a90b6e03-bc33-4633-9e2d-f800246d473f'),(1563,498.33,40,'a90b6e03-bc33-4633-9e2d-f800246d473f'),(1564,5980.00,41,'a90b6e03-bc33-4633-9e2d-f800246d473f'),(1565,258.49,42,'a90b6e03-bc33-4633-9e2d-f800246d473f'),(1566,18.62,24,'275a29a1-ba98-4e97-b382-966056f4c41b'),(1567,441.25,25,'275a29a1-ba98-4e97-b382-966056f4c41b'),(1568,32.15,26,'275a29a1-ba98-4e97-b382-966056f4c41b'),(1569,298.13,27,'275a29a1-ba98-4e97-b382-966056f4c41b'),(1570,10.00,29,'275a29a1-ba98-4e97-b382-966056f4c41b'),(1571,4.85,28,'275a29a1-ba98-4e97-b382-966056f4c41b'),(1572,38.77,30,'275a29a1-ba98-4e97-b382-966056f4c41b'),(1573,3577.50,31,'275a29a1-ba98-4e97-b382-966056f4c41b'),(1574,5295.01,32,'275a29a1-ba98-4e97-b382-966056f4c41b'),(1575,7146.00,33,'275a29a1-ba98-4e97-b382-966056f4c41b'),(1576,595.50,34,'275a29a1-ba98-4e97-b382-966056f4c41b'),(1577,70.00,36,'275a29a1-ba98-4e97-b382-966056f4c41b'),(1578,13.02,37,'275a29a1-ba98-4e97-b382-966056f4c41b'),(1579,297.38,40,'275a29a1-ba98-4e97-b382-966056f4c41b'),(1580,3568.50,41,'275a29a1-ba98-4e97-b382-966056f4c41b'),(1581,154.25,42,'275a29a1-ba98-4e97-b382-966056f4c41b'),(1582,10.99,24,'67bdf0e5-d36c-4cb3-955a-264afcfce701'),(1583,301.68,25,'67bdf0e5-d36c-4cb3-955a-264afcfce701'),(1584,23.25,26,'67bdf0e5-d36c-4cb3-955a-264afcfce701'),(1585,166.38,27,'67bdf0e5-d36c-4cb3-955a-264afcfce701'),(1586,10.00,29,'67bdf0e5-d36c-4cb3-955a-264afcfce701'),(1587,4.85,28,'67bdf0e5-d36c-4cb3-955a-264afcfce701'),(1588,35.94,30,'67bdf0e5-d36c-4cb3-955a-264afcfce701'),(1589,1996.50,31,'67bdf0e5-d36c-4cb3-955a-264afcfce701'),(1590,3620.16,32,'67bdf0e5-d36c-4cb3-955a-264afcfce701'),(1591,5370.00,33,'67bdf0e5-d36c-4cb3-955a-264afcfce701'),(1592,447.50,34,'67bdf0e5-d36c-4cb3-955a-264afcfce701'),(1593,70.00,36,'67bdf0e5-d36c-4cb3-955a-264afcfce701'),(1594,10.35,37,'67bdf0e5-d36c-4cb3-955a-264afcfce701'),(1595,281.13,40,'67bdf0e5-d36c-4cb3-955a-264afcfce701'),(1596,3373.50,41,'67bdf0e5-d36c-4cb3-955a-264afcfce701'),(1597,145.82,42,'67bdf0e5-d36c-4cb3-955a-264afcfce701'),(1598,13.63,24,'d956a7ab-1967-457b-b205-98922c899a41'),(1599,381.16,25,'d956a7ab-1967-457b-b205-98922c899a41'),(1600,26.33,26,'d956a7ab-1967-457b-b205-98922c899a41'),(1601,230.21,27,'d956a7ab-1967-457b-b205-98922c899a41'),(1602,10.00,29,'d956a7ab-1967-457b-b205-98922c899a41'),(1603,4.85,28,'d956a7ab-1967-457b-b205-98922c899a41'),(1604,53.91,30,'d956a7ab-1967-457b-b205-98922c899a41'),(1605,2762.50,31,'d956a7ab-1967-457b-b205-98922c899a41'),(1606,4573.86,32,'d956a7ab-1967-457b-b205-98922c899a41'),(1607,6526.00,33,'d956a7ab-1967-457b-b205-98922c899a41'),(1608,543.83,34,'d956a7ab-1967-457b-b205-98922c899a41'),(1609,70.00,36,'d956a7ab-1967-457b-b205-98922c899a41'),(1610,11.27,37,'d956a7ab-1967-457b-b205-98922c899a41'),(1611,313.63,40,'d956a7ab-1967-457b-b205-98922c899a41'),(1612,3763.50,41,'d956a7ab-1967-457b-b205-98922c899a41'),(1613,162.68,42,'d956a7ab-1967-457b-b205-98922c899a41'),(1614,19.33,24,'bbc863d3-a1ac-4317-a666-d79a1cc87f70'),(1615,460.94,25,'bbc863d3-a1ac-4317-a666-d79a1cc87f70'),(1616,32.98,26,'bbc863d3-a1ac-4317-a666-d79a1cc87f70'),(1617,315.21,27,'bbc863d3-a1ac-4317-a666-d79a1cc87f70'),(1618,10.00,29,'bbc863d3-a1ac-4317-a666-d79a1cc87f70'),(1619,4.85,28,'bbc863d3-a1ac-4317-a666-d79a1cc87f70'),(1620,53.24,30,'bbc863d3-a1ac-4317-a666-d79a1cc87f70'),(1621,3782.50,31,'bbc863d3-a1ac-4317-a666-d79a1cc87f70'),(1622,5531.29,32,'bbc863d3-a1ac-4317-a666-d79a1cc87f70'),(1623,7416.00,33,'bbc863d3-a1ac-4317-a666-d79a1cc87f70'),(1624,618.00,34,'bbc863d3-a1ac-4317-a666-d79a1cc87f70'),(1625,70.00,36,'bbc863d3-a1ac-4317-a666-d79a1cc87f70'),(1626,13.27,37,'bbc863d3-a1ac-4317-a666-d79a1cc87f70'),(1627,302.79,40,'bbc863d3-a1ac-4317-a666-d79a1cc87f70'),(1628,3633.50,41,'bbc863d3-a1ac-4317-a666-d79a1cc87f70'),(1629,157.06,42,'bbc863d3-a1ac-4317-a666-d79a1cc87f70'),(1630,13.31,24,'f72b3435-2eb1-465e-b35c-49669fbd909d'),(1631,349.81,25,'f72b3435-2eb1-465e-b35c-49669fbd909d'),(1632,25.96,26,'f72b3435-2eb1-465e-b35c-49669fbd909d'),(1633,209.29,27,'f72b3435-2eb1-465e-b35c-49669fbd909d'),(1634,10.00,29,'f72b3435-2eb1-465e-b35c-49669fbd909d'),(1635,4.85,28,'f72b3435-2eb1-465e-b35c-49669fbd909d'),(1636,36.22,30,'f72b3435-2eb1-465e-b35c-49669fbd909d'),(1637,2511.50,31,'f72b3435-2eb1-465e-b35c-49669fbd909d'),(1638,4197.72,32,'f72b3435-2eb1-465e-b35c-49669fbd909d'),(1639,6015.00,33,'f72b3435-2eb1-465e-b35c-49669fbd909d'),(1640,501.25,34,'f72b3435-2eb1-465e-b35c-49669fbd909d'),(1641,70.00,36,'f72b3435-2eb1-465e-b35c-49669fbd909d'),(1642,11.16,37,'f72b3435-2eb1-465e-b35c-49669fbd909d'),(1643,291.96,40,'f72b3435-2eb1-465e-b35c-49669fbd909d'),(1644,3503.50,41,'f72b3435-2eb1-465e-b35c-49669fbd909d'),(1645,151.44,42,'f72b3435-2eb1-465e-b35c-49669fbd909d'),(1646,18.53,24,'585d29e8-b484-48ee-a1fe-494e211fc5ef'),(1647,431.89,25,'585d29e8-b484-48ee-a1fe-494e211fc5ef'),(1648,32.05,26,'585d29e8-b484-48ee-a1fe-494e211fc5ef'),(1649,291.38,27,'585d29e8-b484-48ee-a1fe-494e211fc5ef'),(1650,10.00,29,'585d29e8-b484-48ee-a1fe-494e211fc5ef'),(1651,4.85,28,'585d29e8-b484-48ee-a1fe-494e211fc5ef'),(1652,57.59,30,'585d29e8-b484-48ee-a1fe-494e211fc5ef'),(1653,3496.50,31,'585d29e8-b484-48ee-a1fe-494e211fc5ef'),(1654,5182.72,32,'585d29e8-b484-48ee-a1fe-494e211fc5ef'),(1655,7000.00,33,'585d29e8-b484-48ee-a1fe-494e211fc5ef'),(1656,583.33,34,'585d29e8-b484-48ee-a1fe-494e211fc5ef'),(1657,70.00,36,'585d29e8-b484-48ee-a1fe-494e211fc5ef'),(1658,12.99,37,'585d29e8-b484-48ee-a1fe-494e211fc5ef'),(1659,291.96,40,'585d29e8-b484-48ee-a1fe-494e211fc5ef'),(1660,3503.50,41,'585d29e8-b484-48ee-a1fe-494e211fc5ef'),(1661,151.44,42,'585d29e8-b484-48ee-a1fe-494e211fc5ef'),(1662,18.76,24,'f21ccfed-78ce-4843-9f57-7f6b4a2f30cf'),(1663,840.30,25,'f21ccfed-78ce-4843-9f57-7f6b4a2f30cf'),(1664,32.32,26,'f21ccfed-78ce-4843-9f57-7f6b4a2f30cf'),(1665,569.17,27,'f21ccfed-78ce-4843-9f57-7f6b4a2f30cf'),(1666,10.00,29,'f21ccfed-78ce-4843-9f57-7f6b4a2f30cf'),(1667,4.85,28,'f21ccfed-78ce-4843-9f57-7f6b4a2f30cf'),(1668,43.70,30,'f21ccfed-78ce-4843-9f57-7f6b4a2f30cf'),(1669,6830.00,31,'f21ccfed-78ce-4843-9f57-7f6b4a2f30cf'),(1670,1132.50,34,'f21ccfed-78ce-4843-9f57-7f6b4a2f30cf'),(1671,70.00,36,'f21ccfed-78ce-4843-9f57-7f6b4a2f30cf'),(1672,13.07,37,'f21ccfed-78ce-4843-9f57-7f6b4a2f30cf'),(1673,563.33,40,'f21ccfed-78ce-4843-9f57-7f6b4a2f30cf'),(1674,6760.00,41,'f21ccfed-78ce-4843-9f57-7f6b4a2f30cf'),(1675,292.20,42,'f21ccfed-78ce-4843-9f57-7f6b4a2f30cf'),(1676,19.71,24,'7094473d-988d-482a-9576-cbebd4fa76ed'),(1677,442.04,25,'7094473d-988d-482a-9576-cbebd4fa76ed'),(1678,33.42,26,'7094473d-988d-482a-9576-cbebd4fa76ed'),(1679,304.13,27,'7094473d-988d-482a-9576-cbebd4fa76ed'),(1680,10.00,29,'7094473d-988d-482a-9576-cbebd4fa76ed'),(1681,4.85,28,'7094473d-988d-482a-9576-cbebd4fa76ed'),(1682,30.28,30,'7094473d-988d-482a-9576-cbebd4fa76ed'),(1683,3649.50,31,'7094473d-988d-482a-9576-cbebd4fa76ed'),(1684,5304.44,32,'7094473d-988d-482a-9576-cbebd4fa76ed'),(1685,7088.00,33,'7094473d-988d-482a-9576-cbebd4fa76ed'),(1686,591.00,34,'7094473d-988d-482a-9576-cbebd4fa76ed'),(1687,70.00,36,'7094473d-988d-482a-9576-cbebd4fa76ed'),(1688,13.40,37,'7094473d-988d-482a-9576-cbebd4fa76ed'),(1689,286.54,40,'7094473d-988d-482a-9576-cbebd4fa76ed'),(1690,3439.00,41,'7094473d-988d-482a-9576-cbebd4fa76ed'),(1691,148.63,42,'7094473d-988d-482a-9576-cbebd4fa76ed'),(1692,17.34,24,'e0a73b8f-5ed9-4532-85a3-a97cb3df5858'),(1693,443.82,25,'e0a73b8f-5ed9-4532-85a3-a97cb3df5858'),(1694,30.66,26,'e0a73b8f-5ed9-4532-85a3-a97cb3df5858'),(1695,292.88,27,'e0a73b8f-5ed9-4532-85a3-a97cb3df5858'),(1696,10.00,29,'e0a73b8f-5ed9-4532-85a3-a97cb3df5858'),(1697,4.85,28,'e0a73b8f-5ed9-4532-85a3-a97cb3df5858'),(1698,47.62,30,'e0a73b8f-5ed9-4532-85a3-a97cb3df5858'),(1699,3514.50,31,'e0a73b8f-5ed9-4532-85a3-a97cb3df5858'),(1700,5325.86,32,'e0a73b8f-5ed9-4532-85a3-a97cb3df5858'),(1701,7278.00,33,'e0a73b8f-5ed9-4532-85a3-a97cb3df5858'),(1702,606.50,34,'e0a73b8f-5ed9-4532-85a3-a97cb3df5858'),(1703,70.00,36,'e0a73b8f-5ed9-4532-85a3-a97cb3df5858'),(1704,12.57,37,'e0a73b8f-5ed9-4532-85a3-a97cb3df5858'),(1705,313.63,40,'e0a73b8f-5ed9-4532-85a3-a97cb3df5858'),(1706,3763.50,41,'e0a73b8f-5ed9-4532-85a3-a97cb3df5858'),(1707,162.68,42,'e0a73b8f-5ed9-4532-85a3-a97cb3df5858'),(1708,18.70,24,'a27e5002-333c-4d67-a189-38067ac98c77'),(1709,442.58,25,'a27e5002-333c-4d67-a189-38067ac98c77'),(1710,32.25,26,'a27e5002-333c-4d67-a189-38067ac98c77'),(1711,299.46,27,'a27e5002-333c-4d67-a189-38067ac98c77'),(1712,10.00,29,'a27e5002-333c-4d67-a189-38067ac98c77'),(1713,4.85,28,'a27e5002-333c-4d67-a189-38067ac98c77'),(1714,33.27,30,'a27e5002-333c-4d67-a189-38067ac98c77'),(1715,3593.50,31,'a27e5002-333c-4d67-a189-38067ac98c77'),(1716,5311.01,32,'a27e5002-333c-4d67-a189-38067ac98c77'),(1717,7162.00,33,'a27e5002-333c-4d67-a189-38067ac98c77'),(1718,596.83,34,'a27e5002-333c-4d67-a189-38067ac98c77'),(1719,70.00,36,'a27e5002-333c-4d67-a189-38067ac98c77'),(1720,13.05,37,'a27e5002-333c-4d67-a189-38067ac98c77'),(1721,297.38,40,'a27e5002-333c-4d67-a189-38067ac98c77'),(1722,3568.50,41,'a27e5002-333c-4d67-a189-38067ac98c77'),(1723,154.25,42,'a27e5002-333c-4d67-a189-38067ac98c77'),(1724,17.72,24,'867a9ef9-b92c-4a93-af6a-9d3b19f339ad'),(1725,434.61,25,'867a9ef9-b92c-4a93-af6a-9d3b19f339ad'),(1726,31.10,26,'867a9ef9-b92c-4a93-af6a-9d3b19f339ad'),(1727,288.88,27,'867a9ef9-b92c-4a93-af6a-9d3b19f339ad'),(1728,10.00,29,'867a9ef9-b92c-4a93-af6a-9d3b19f339ad'),(1729,4.85,28,'867a9ef9-b92c-4a93-af6a-9d3b19f339ad'),(1730,55.46,30,'867a9ef9-b92c-4a93-af6a-9d3b19f339ad'),(1731,3466.50,31,'867a9ef9-b92c-4a93-af6a-9d3b19f339ad'),(1732,5215.29,32,'867a9ef9-b92c-4a93-af6a-9d3b19f339ad'),(1733,7100.00,33,'867a9ef9-b92c-4a93-af6a-9d3b19f339ad'),(1734,591.67,34,'867a9ef9-b92c-4a93-af6a-9d3b19f339ad'),(1735,70.00,36,'867a9ef9-b92c-4a93-af6a-9d3b19f339ad'),(1736,12.70,37,'867a9ef9-b92c-4a93-af6a-9d3b19f339ad'),(1737,302.79,40,'867a9ef9-b92c-4a93-af6a-9d3b19f339ad'),(1738,3633.50,41,'867a9ef9-b92c-4a93-af6a-9d3b19f339ad'),(1739,157.06,42,'867a9ef9-b92c-4a93-af6a-9d3b19f339ad'),(1740,10.49,24,'8b0ea03c-4e8d-4efa-92dc-b07bd74f4e00'),(1741,322.38,25,'8b0ea03c-4e8d-4efa-92dc-b07bd74f4e00'),(1742,22.66,26,'8b0ea03c-4e8d-4efa-92dc-b07bd74f4e00'),(1743,174.04,27,'8b0ea03c-4e8d-4efa-92dc-b07bd74f4e00'),(1744,10.00,29,'8b0ea03c-4e8d-4efa-92dc-b07bd74f4e00'),(1745,4.85,28,'8b0ea03c-4e8d-4efa-92dc-b07bd74f4e00'),(1746,35.92,30,'8b0ea03c-4e8d-4efa-92dc-b07bd74f4e00'),(1747,2088.50,31,'8b0ea03c-4e8d-4efa-92dc-b07bd74f4e00'),(1748,3868.58,32,'8b0ea03c-4e8d-4efa-92dc-b07bd74f4e00'),(1749,5787.00,33,'8b0ea03c-4e8d-4efa-92dc-b07bd74f4e00'),(1750,482.25,34,'8b0ea03c-4e8d-4efa-92dc-b07bd74f4e00'),(1751,70.00,36,'8b0ea03c-4e8d-4efa-92dc-b07bd74f4e00'),(1752,10.17,37,'8b0ea03c-4e8d-4efa-92dc-b07bd74f4e00'),(1753,308.21,40,'8b0ea03c-4e8d-4efa-92dc-b07bd74f4e00'),(1754,3698.50,41,'8b0ea03c-4e8d-4efa-92dc-b07bd74f4e00'),(1755,159.87,42,'8b0ea03c-4e8d-4efa-92dc-b07bd74f4e00'),(1756,17.80,24,'10171fe3-c38d-49bb-9362-8e60ce2e3623'),(1757,436.01,25,'10171fe3-c38d-49bb-9362-8e60ce2e3623'),(1758,31.20,26,'10171fe3-c38d-49bb-9362-8e60ce2e3623'),(1759,290.28,27,'10171fe3-c38d-49bb-9362-8e60ce2e3623'),(1760,10.00,29,'10171fe3-c38d-49bb-9362-8e60ce2e3623'),(1761,4.85,28,'10171fe3-c38d-49bb-9362-8e60ce2e3623'),(1762,55.90,30,'10171fe3-c38d-49bb-9362-8e60ce2e3623'),(1763,3483.30,31,'10171fe3-c38d-49bb-9362-8e60ce2e3623'),(1764,5232.09,32,'10171fe3-c38d-49bb-9362-8e60ce2e3623'),(1765,7117.00,33,'10171fe3-c38d-49bb-9362-8e60ce2e3623'),(1766,593.07,34,'10171fe3-c38d-49bb-9362-8e60ce2e3623'),(1767,70.00,36,'10171fe3-c38d-49bb-9362-8e60ce2e3623'),(1768,12.73,37,'10171fe3-c38d-49bb-9362-8e60ce2e3623'),(1769,302.79,40,'10171fe3-c38d-49bb-9362-8e60ce2e3623'),(1770,3633.50,41,'10171fe3-c38d-49bb-9362-8e60ce2e3623'),(1771,157.06,42,'10171fe3-c38d-49bb-9362-8e60ce2e3623'),(1772,14.54,24,'3c4aa9c9-c57a-467b-a70d-5d87b97de70a'),(1773,478.61,25,'3c4aa9c9-c57a-467b-a70d-5d87b97de70a'),(1774,27.39,26,'3c4aa9c9-c57a-467b-a70d-5d87b97de70a'),(1775,296.38,27,'3c4aa9c9-c57a-467b-a70d-5d87b97de70a'),(1776,10.00,29,'3c4aa9c9-c57a-467b-a70d-5d87b97de70a'),(1777,4.85,28,'3c4aa9c9-c57a-467b-a70d-5d87b97de70a'),(1778,53.65,30,'3c4aa9c9-c57a-467b-a70d-5d87b97de70a'),(1779,3556.50,31,'3c4aa9c9-c57a-467b-a70d-5d87b97de70a'),(1780,5743.27,32,'3c4aa9c9-c57a-467b-a70d-5d87b97de70a'),(1781,8100.00,33,'3c4aa9c9-c57a-467b-a70d-5d87b97de70a'),(1782,675.00,34,'3c4aa9c9-c57a-467b-a70d-5d87b97de70a'),(1783,70.00,36,'3c4aa9c9-c57a-467b-a70d-5d87b97de70a'),(1784,11.59,37,'3c4aa9c9-c57a-467b-a70d-5d87b97de70a'),(1785,378.63,40,'3c4aa9c9-c57a-467b-a70d-5d87b97de70a'),(1786,4543.50,41,'3c4aa9c9-c57a-467b-a70d-5d87b97de70a'),(1787,196.39,42,'3c4aa9c9-c57a-467b-a70d-5d87b97de70a'),(1788,14.91,24,'53f57cc2-c85e-4dc7-a73e-a17d169551ef'),(1789,395.80,25,'53f57cc2-c85e-4dc7-a73e-a17d169551ef'),(1790,27.82,26,'53f57cc2-c85e-4dc7-a73e-a17d169551ef'),(1791,247.46,27,'53f57cc2-c85e-4dc7-a73e-a17d169551ef'),(1792,10.00,29,'53f57cc2-c85e-4dc7-a73e-a17d169551ef'),(1793,4.85,28,'53f57cc2-c85e-4dc7-a73e-a17d169551ef'),(1794,51.73,30,'53f57cc2-c85e-4dc7-a73e-a17d169551ef'),(1795,2969.50,31,'53f57cc2-c85e-4dc7-a73e-a17d169551ef'),(1796,4749.58,32,'53f57cc2-c85e-4dc7-a73e-a17d169551ef'),(1797,6668.00,33,'53f57cc2-c85e-4dc7-a73e-a17d169551ef'),(1798,555.67,34,'53f57cc2-c85e-4dc7-a73e-a17d169551ef'),(1799,70.00,36,'53f57cc2-c85e-4dc7-a73e-a17d169551ef'),(1800,11.72,37,'53f57cc2-c85e-4dc7-a73e-a17d169551ef'),(1801,308.21,40,'53f57cc2-c85e-4dc7-a73e-a17d169551ef'),(1802,3698.50,41,'53f57cc2-c85e-4dc7-a73e-a17d169551ef'),(1803,159.87,42,'53f57cc2-c85e-4dc7-a73e-a17d169551ef'),(1804,17.34,24,'3191fb8d-6df0-4695-b136-3f0ee2edb778'),(1805,413.06,25,'3191fb8d-6df0-4695-b136-3f0ee2edb778'),(1806,30.65,26,'3191fb8d-6df0-4695-b136-3f0ee2edb778'),(1807,272.54,27,'3191fb8d-6df0-4695-b136-3f0ee2edb778'),(1808,10.00,29,'3191fb8d-6df0-4695-b136-3f0ee2edb778'),(1809,4.85,28,'3191fb8d-6df0-4695-b136-3f0ee2edb778'),(1810,53.47,30,'3191fb8d-6df0-4695-b136-3f0ee2edb778'),(1811,3270.50,31,'3191fb8d-6df0-4695-b136-3f0ee2edb778'),(1812,4956.72,32,'3191fb8d-6df0-4695-b136-3f0ee2edb778'),(1813,6774.00,33,'3191fb8d-6df0-4695-b136-3f0ee2edb778'),(1814,564.50,34,'3191fb8d-6df0-4695-b136-3f0ee2edb778'),(1815,70.00,36,'3191fb8d-6df0-4695-b136-3f0ee2edb778'),(1816,12.57,37,'3191fb8d-6df0-4695-b136-3f0ee2edb778'),(1817,291.96,40,'3191fb8d-6df0-4695-b136-3f0ee2edb778'),(1818,3503.50,41,'3191fb8d-6df0-4695-b136-3f0ee2edb778'),(1819,151.44,42,'3191fb8d-6df0-4695-b136-3f0ee2edb778'),(1820,15.91,24,'4277a1c4-e958-4d3f-bc79-d980c9b5010f'),(1821,390.56,25,'4277a1c4-e958-4d3f-bc79-d980c9b5010f'),(1822,28.98,26,'4277a1c4-e958-4d3f-bc79-d980c9b5010f'),(1823,250.04,27,'4277a1c4-e958-4d3f-bc79-d980c9b5010f'),(1824,10.00,29,'4277a1c4-e958-4d3f-bc79-d980c9b5010f'),(1825,4.85,28,'4277a1c4-e958-4d3f-bc79-d980c9b5010f'),(1826,60.16,30,'4277a1c4-e958-4d3f-bc79-d980c9b5010f'),(1827,3000.50,31,'4277a1c4-e958-4d3f-bc79-d980c9b5010f'),(1828,4686.72,32,'4277a1c4-e958-4d3f-bc79-d980c9b5010f'),(1829,6504.00,33,'4277a1c4-e958-4d3f-bc79-d980c9b5010f'),(1830,542.00,34,'4277a1c4-e958-4d3f-bc79-d980c9b5010f'),(1831,70.00,36,'4277a1c4-e958-4d3f-bc79-d980c9b5010f'),(1832,12.07,37,'4277a1c4-e958-4d3f-bc79-d980c9b5010f'),(1833,291.96,40,'4277a1c4-e958-4d3f-bc79-d980c9b5010f'),(1834,3503.50,41,'4277a1c4-e958-4d3f-bc79-d980c9b5010f'),(1835,151.44,42,'4277a1c4-e958-4d3f-bc79-d980c9b5010f'),(1836,18.93,24,'bb7160fa-f766-4409-97f6-1225ae51b502'),(1837,470.66,25,'bb7160fa-f766-4409-97f6-1225ae51b502'),(1838,32.52,26,'bb7160fa-f766-4409-97f6-1225ae51b502'),(1839,319.71,27,'bb7160fa-f766-4409-97f6-1225ae51b502'),(1840,10.00,29,'bb7160fa-f766-4409-97f6-1225ae51b502'),(1841,4.85,28,'bb7160fa-f766-4409-97f6-1225ae51b502'),(1842,37.72,30,'bb7160fa-f766-4409-97f6-1225ae51b502'),(1843,3836.50,31,'bb7160fa-f766-4409-97f6-1225ae51b502'),(1844,5647.86,32,'bb7160fa-f766-4409-97f6-1225ae51b502'),(1845,7600.00,33,'bb7160fa-f766-4409-97f6-1225ae51b502'),(1846,633.00,34,'bb7160fa-f766-4409-97f6-1225ae51b502'),(1847,70.00,36,'bb7160fa-f766-4409-97f6-1225ae51b502'),(1848,13.13,37,'bb7160fa-f766-4409-97f6-1225ae51b502'),(1849,313.63,40,'bb7160fa-f766-4409-97f6-1225ae51b502'),(1850,3764.00,41,'bb7160fa-f766-4409-97f6-1225ae51b502'),(1851,162.68,42,'bb7160fa-f766-4409-97f6-1225ae51b502'),(1852,16.23,24,'109fe6da-3204-4303-b7e5-3058206d0908'),(1853,403.80,25,'109fe6da-3204-4303-b7e5-3058206d0908'),(1854,29.37,26,'109fe6da-3204-4303-b7e5-3058206d0908'),(1855,260.42,27,'109fe6da-3204-4303-b7e5-3058206d0908'),(1856,10.00,29,'109fe6da-3204-4303-b7e5-3058206d0908'),(1857,4.85,28,'109fe6da-3204-4303-b7e5-3058206d0908'),(1858,33.21,30,'109fe6da-3204-4303-b7e5-3058206d0908'),(1859,3125.00,31,'109fe6da-3204-4303-b7e5-3058206d0908'),(1860,4845.64,32,'109fe6da-3204-4303-b7e5-3058206d0908'),(1861,6700.00,33,'109fe6da-3204-4303-b7e5-3058206d0908'),(1862,558.00,34,'109fe6da-3204-4303-b7e5-3058206d0908'),(1863,70.00,36,'109fe6da-3204-4303-b7e5-3058206d0908'),(1864,12.18,37,'109fe6da-3204-4303-b7e5-3058206d0908'),(1865,297.92,40,'109fe6da-3204-4303-b7e5-3058206d0908'),(1866,3575.00,41,'109fe6da-3204-4303-b7e5-3058206d0908'),(1867,154.53,42,'109fe6da-3204-4303-b7e5-3058206d0908'),(1868,16.56,24,'82e5366a-0d1f-4adc-952f-84e4c5bae84a'),(1869,415.69,25,'82e5366a-0d1f-4adc-952f-84e4c5bae84a'),(1870,29.75,26,'82e5366a-0d1f-4adc-952f-84e4c5bae84a'),(1871,269.96,27,'82e5366a-0d1f-4adc-952f-84e4c5bae84a'),(1872,10.00,29,'82e5366a-0d1f-4adc-952f-84e4c5bae84a'),(1873,4.85,28,'82e5366a-0d1f-4adc-952f-84e4c5bae84a'),(1874,33.98,30,'82e5366a-0d1f-4adc-952f-84e4c5bae84a'),(1875,3239.50,31,'82e5366a-0d1f-4adc-952f-84e4c5bae84a'),(1876,4988.29,32,'82e5366a-0d1f-4adc-952f-84e4c5bae84a'),(1877,6873.00,33,'82e5366a-0d1f-4adc-952f-84e4c5bae84a'),(1878,572.75,34,'82e5366a-0d1f-4adc-952f-84e4c5bae84a'),(1879,70.00,36,'82e5366a-0d1f-4adc-952f-84e4c5bae84a'),(1880,12.30,37,'82e5366a-0d1f-4adc-952f-84e4c5bae84a'),(1881,302.79,40,'82e5366a-0d1f-4adc-952f-84e4c5bae84a'),(1882,3633.50,41,'82e5366a-0d1f-4adc-952f-84e4c5bae84a'),(1883,157.06,42,'82e5366a-0d1f-4adc-952f-84e4c5bae84a'),(1884,13.95,24,'ad52a2b3-c873-4003-bd01-e064ed3482c0'),(1885,594.11,25,'ad52a2b3-c873-4003-bd01-e064ed3482c0'),(1886,26.70,26,'ad52a2b3-c873-4003-bd01-e064ed3482c0'),(1887,362.08,27,'ad52a2b3-c873-4003-bd01-e064ed3482c0'),(1888,10.00,29,'ad52a2b3-c873-4003-bd01-e064ed3482c0'),(1889,4.85,28,'ad52a2b3-c873-4003-bd01-e064ed3482c0'),(1890,57.79,30,'ad52a2b3-c873-4003-bd01-e064ed3482c0'),(1891,4345.00,31,'ad52a2b3-c873-4003-bd01-e064ed3482c0'),(1892,7129.30,32,'ad52a2b3-c873-4003-bd01-e064ed3482c0'),(1893,844.00,34,'ad52a2b3-c873-4003-bd01-e064ed3482c0'),(1894,70.00,36,'ad52a2b3-c873-4003-bd01-e064ed3482c0'),(1895,11.38,37,'ad52a2b3-c873-4003-bd01-e064ed3482c0'),(1896,482.08,40,'ad52a2b3-c873-4003-bd01-e064ed3482c0'),(1897,5785.00,41,'ad52a2b3-c873-4003-bd01-e064ed3482c0'),(1898,250.06,42,'ad52a2b3-c873-4003-bd01-e064ed3482c0'),(1899,15.92,24,'ebe0af52-d307-435f-bafa-217d429b576d'),(1900,239.76,25,'ebe0af52-d307-435f-bafa-217d429b576d'),(1901,29.97,26,'ebe0af52-d307-435f-bafa-217d429b576d'),(1902,212.26,27,'ebe0af52-d307-435f-bafa-217d429b576d'),(1903,8.00,29,'ebe0af52-d307-435f-bafa-217d429b576d'),(1904,4.85,28,'ebe0af52-d307-435f-bafa-217d429b576d'),(1905,27.59,30,'ebe0af52-d307-435f-bafa-217d429b576d'),(1906,2547.17,31,'ebe0af52-d307-435f-bafa-217d429b576d'),(1907,2877.10,32,'ebe0af52-d307-435f-bafa-217d429b576d'),(1908,3956.00,33,'ebe0af52-d307-435f-bafa-217d429b576d'),(1909,329.67,34,'ebe0af52-d307-435f-bafa-217d429b576d'),(1910,70.00,36,'ebe0af52-d307-435f-bafa-217d429b576d'),(1911,12.36,37,'ebe0af52-d307-435f-bafa-217d429b576d'),(1912,9600.00,39,'ebe0af52-d307-435f-bafa-217d429b576d'),(1913,106.26,40,'ebe0af52-d307-435f-bafa-217d429b576d'),(1914,1275.17,41,'ebe0af52-d307-435f-bafa-217d429b576d'),(1915,89.91,42,'ebe0af52-d307-435f-bafa-217d429b576d'),(1916,14.89,24,'a9af3c99-17e8-4d2a-81ba-1568306e66c8'),(1917,402.32,25,'a9af3c99-17e8-4d2a-81ba-1568306e66c8'),(1918,27.79,26,'a9af3c99-17e8-4d2a-81ba-1568306e66c8'),(1919,251.38,27,'a9af3c99-17e8-4d2a-81ba-1568306e66c8'),(1920,10.00,29,'a9af3c99-17e8-4d2a-81ba-1568306e66c8'),(1921,4.85,28,'a9af3c99-17e8-4d2a-81ba-1568306e66c8'),(1922,51.47,30,'a9af3c99-17e8-4d2a-81ba-1568306e66c8'),(1923,3016.50,31,'a9af3c99-17e8-4d2a-81ba-1568306e66c8'),(1924,4827.86,32,'a9af3c99-17e8-4d2a-81ba-1568306e66c8'),(1925,6780.00,33,'a9af3c99-17e8-4d2a-81ba-1568306e66c8'),(1926,565.00,34,'a9af3c99-17e8-4d2a-81ba-1568306e66c8'),(1927,70.00,36,'a9af3c99-17e8-4d2a-81ba-1568306e66c8'),(1928,11.71,37,'a9af3c99-17e8-4d2a-81ba-1568306e66c8'),(1929,313.63,40,'a9af3c99-17e8-4d2a-81ba-1568306e66c8'),(1930,3763.50,41,'a9af3c99-17e8-4d2a-81ba-1568306e66c8'),(1931,162.68,42,'a9af3c99-17e8-4d2a-81ba-1568306e66c8'),(1932,10.49,24,'dd9252c6-2d5d-4855-a918-5311cdafec8e'),(1933,464.61,25,'dd9252c6-2d5d-4855-a918-5311cdafec8e'),(1934,22.66,26,'dd9252c6-2d5d-4855-a918-5311cdafec8e'),(1935,250.83,27,'dd9252c6-2d5d-4855-a918-5311cdafec8e'),(1936,10.00,29,'dd9252c6-2d5d-4855-a918-5311cdafec8e'),(1937,4.85,28,'dd9252c6-2d5d-4855-a918-5311cdafec8e'),(1938,62.50,30,'dd9252c6-2d5d-4855-a918-5311cdafec8e'),(1939,3010.00,31,'dd9252c6-2d5d-4855-a918-5311cdafec8e'),(1940,5575.31,32,'dd9252c6-2d5d-4855-a918-5311cdafec8e'),(1941,8340.00,33,'dd9252c6-2d5d-4855-a918-5311cdafec8e'),(1942,695.00,34,'dd9252c6-2d5d-4855-a918-5311cdafec8e'),(1943,70.00,36,'dd9252c6-2d5d-4855-a918-5311cdafec8e'),(1944,10.17,37,'dd9252c6-2d5d-4855-a918-5311cdafec8e'),(1945,444.17,40,'dd9252c6-2d5d-4855-a918-5311cdafec8e'),(1946,5330.00,41,'dd9252c6-2d5d-4855-a918-5311cdafec8e'),(1947,230.39,42,'dd9252c6-2d5d-4855-a918-5311cdafec8e'),(1948,18.75,24,'6f4b7216-7c06-406e-8329-28c3e7fc1f15'),(1949,467.66,25,'6f4b7216-7c06-406e-8329-28c3e7fc1f15'),(1950,32.31,26,'6f4b7216-7c06-406e-8329-28c3e7fc1f15'),(1951,316.71,27,'6f4b7216-7c06-406e-8329-28c3e7fc1f15'),(1952,10.00,29,'6f4b7216-7c06-406e-8329-28c3e7fc1f15'),(1953,4.85,28,'6f4b7216-7c06-406e-8329-28c3e7fc1f15'),(1954,48.70,30,'6f4b7216-7c06-406e-8329-28c3e7fc1f15'),(1955,3800.50,31,'6f4b7216-7c06-406e-8329-28c3e7fc1f15'),(1956,5611.86,32,'6f4b7216-7c06-406e-8329-28c3e7fc1f15'),(1957,7564.00,33,'6f4b7216-7c06-406e-8329-28c3e7fc1f15'),(1958,630.33,34,'6f4b7216-7c06-406e-8329-28c3e7fc1f15'),(1959,70.00,36,'6f4b7216-7c06-406e-8329-28c3e7fc1f15'),(1960,13.06,37,'6f4b7216-7c06-406e-8329-28c3e7fc1f15'),(1961,313.63,40,'6f4b7216-7c06-406e-8329-28c3e7fc1f15'),(1962,3763.50,41,'6f4b7216-7c06-406e-8329-28c3e7fc1f15'),(1963,162.68,42,'6f4b7216-7c06-406e-8329-28c3e7fc1f15'),(1964,17.06,24,'bc3ad9da-45e0-4946-87a9-fea2428d8ba0'),(1965,304.56,25,'bc3ad9da-45e0-4946-87a9-fea2428d8ba0'),(1966,30.53,26,'bc3ad9da-45e0-4946-87a9-fea2428d8ba0'),(1967,283.67,27,'bc3ad9da-45e0-4946-87a9-fea2428d8ba0'),(1968,8.00,29,'bc3ad9da-45e0-4946-87a9-fea2428d8ba0'),(1969,4.85,28,'bc3ad9da-45e0-4946-87a9-fea2428d8ba0'),(1970,33.76,30,'bc3ad9da-45e0-4946-87a9-fea2428d8ba0'),(1971,3404.00,31,'bc3ad9da-45e0-4946-87a9-fea2428d8ba0'),(1972,3654.74,32,'bc3ad9da-45e0-4946-87a9-fea2428d8ba0'),(1973,5000.00,33,'bc3ad9da-45e0-4946-87a9-fea2428d8ba0'),(1974,416.67,34,'bc3ad9da-45e0-4946-87a9-fea2428d8ba0'),(1975,70.00,36,'bc3ad9da-45e0-4946-87a9-fea2428d8ba0'),(1976,12.53,37,'bc3ad9da-45e0-4946-87a9-fea2428d8ba0'),(1977,133.00,40,'bc3ad9da-45e0-4946-87a9-fea2428d8ba0'),(1978,1596.00,41,'bc3ad9da-45e0-4946-87a9-fea2428d8ba0'),(1979,112.10,42,'bc3ad9da-45e0-4946-87a9-fea2428d8ba0'),(1980,18.91,24,'a6d9d6d7-b8ed-4ede-8af2-2c80118d71cb'),(1981,470.32,25,'a6d9d6d7-b8ed-4ede-8af2-2c80118d71cb'),(1982,32.49,26,'a6d9d6d7-b8ed-4ede-8af2-2c80118d71cb'),(1983,319.38,27,'a6d9d6d7-b8ed-4ede-8af2-2c80118d71cb'),(1984,10.00,29,'a6d9d6d7-b8ed-4ede-8af2-2c80118d71cb'),(1985,4.85,28,'a6d9d6d7-b8ed-4ede-8af2-2c80118d71cb'),(1986,62.59,30,'a6d9d6d7-b8ed-4ede-8af2-2c80118d71cb'),(1987,3832.50,31,'a6d9d6d7-b8ed-4ede-8af2-2c80118d71cb'),(1988,5643.86,32,'a6d9d6d7-b8ed-4ede-8af2-2c80118d71cb'),(1989,7596.00,33,'a6d9d6d7-b8ed-4ede-8af2-2c80118d71cb'),(1990,633.00,34,'a6d9d6d7-b8ed-4ede-8af2-2c80118d71cb'),(1991,70.00,36,'a6d9d6d7-b8ed-4ede-8af2-2c80118d71cb'),(1992,13.12,37,'a6d9d6d7-b8ed-4ede-8af2-2c80118d71cb'),(1993,313.63,40,'a6d9d6d7-b8ed-4ede-8af2-2c80118d71cb'),(1994,3763.50,41,'a6d9d6d7-b8ed-4ede-8af2-2c80118d71cb'),(1995,162.68,42,'a6d9d6d7-b8ed-4ede-8af2-2c80118d71cb'),(1996,17.98,24,'33441dcd-cf56-4dc5-9e1e-3da64f71791b'),(1997,446.80,25,'33441dcd-cf56-4dc5-9e1e-3da64f71791b'),(1998,31.41,26,'33441dcd-cf56-4dc5-9e1e-3da64f71791b'),(1999,298.46,27,'33441dcd-cf56-4dc5-9e1e-3da64f71791b'),(2000,10.00,29,'33441dcd-cf56-4dc5-9e1e-3da64f71791b'),(2001,4.85,28,'33441dcd-cf56-4dc5-9e1e-3da64f71791b'),(2002,48.18,30,'33441dcd-cf56-4dc5-9e1e-3da64f71791b'),(2003,3581.50,31,'33441dcd-cf56-4dc5-9e1e-3da64f71791b'),(2004,5361.58,32,'33441dcd-cf56-4dc5-9e1e-3da64f71791b'),(2005,7280.00,33,'33441dcd-cf56-4dc5-9e1e-3da64f71791b'),(2006,606.67,34,'33441dcd-cf56-4dc5-9e1e-3da64f71791b'),(2007,70.00,36,'33441dcd-cf56-4dc5-9e1e-3da64f71791b'),(2008,12.79,37,'33441dcd-cf56-4dc5-9e1e-3da64f71791b'),(2009,308.21,40,'33441dcd-cf56-4dc5-9e1e-3da64f71791b'),(2010,3698.50,41,'33441dcd-cf56-4dc5-9e1e-3da64f71791b'),(2011,159.87,42,'33441dcd-cf56-4dc5-9e1e-3da64f71791b'),(2012,19.57,24,'dcdbd268-31a7-45d6-bff9-e8297eda5cd3'),(2013,411.59,25,'dcdbd268-31a7-45d6-bff9-e8297eda5cd3'),(2014,33.26,26,'dcdbd268-31a7-45d6-bff9-e8297eda5cd3'),(2015,282.54,27,'dcdbd268-31a7-45d6-bff9-e8297eda5cd3'),(2016,10.00,29,'dcdbd268-31a7-45d6-bff9-e8297eda5cd3'),(2017,4.85,28,'dcdbd268-31a7-45d6-bff9-e8297eda5cd3'),(2018,48.62,30,'dcdbd268-31a7-45d6-bff9-e8297eda5cd3'),(2019,3390.50,31,'dcdbd268-31a7-45d6-bff9-e8297eda5cd3'),(2020,4939.07,32,'dcdbd268-31a7-45d6-bff9-e8297eda5cd3'),(2021,6608.00,33,'dcdbd268-31a7-45d6-bff9-e8297eda5cd3'),(2022,550.67,34,'dcdbd268-31a7-45d6-bff9-e8297eda5cd3'),(2023,70.00,36,'dcdbd268-31a7-45d6-bff9-e8297eda5cd3'),(2024,13.35,37,'dcdbd268-31a7-45d6-bff9-e8297eda5cd3'),(2025,268.13,40,'dcdbd268-31a7-45d6-bff9-e8297eda5cd3'),(2026,3217.50,41,'dcdbd268-31a7-45d6-bff9-e8297eda5cd3'),(2027,139.08,42,'dcdbd268-31a7-45d6-bff9-e8297eda5cd3'),(2028,20.25,24,'834cba98-a484-438e-a276-e6fd410277c6'),(2029,391.56,25,'834cba98-a484-438e-a276-e6fd410277c6'),(2030,34.05,26,'834cba98-a484-438e-a276-e6fd410277c6'),(2031,271.63,27,'834cba98-a484-438e-a276-e6fd410277c6'),(2032,10.00,29,'834cba98-a484-438e-a276-e6fd410277c6'),(2033,4.85,28,'834cba98-a484-438e-a276-e6fd410277c6'),(2034,39.90,30,'834cba98-a484-438e-a276-e6fd410277c6'),(2035,3259.60,31,'834cba98-a484-438e-a276-e6fd410277c6'),(2036,4698.68,32,'834cba98-a484-438e-a276-e6fd410277c6'),(2037,6250.00,33,'834cba98-a484-438e-a276-e6fd410277c6'),(2038,520.80,34,'834cba98-a484-438e-a276-e6fd410277c6'),(2039,70.00,36,'834cba98-a484-438e-a276-e6fd410277c6'),(2040,13.59,37,'834cba98-a484-438e-a276-e6fd410277c6'),(2041,249.17,40,'834cba98-a484-438e-a276-e6fd410277c6'),(2042,2990.00,41,'834cba98-a484-438e-a276-e6fd410277c6'),(2043,129.24,42,'834cba98-a484-438e-a276-e6fd410277c6'),(2044,18.12,24,'327a6f24-5dd5-4c4d-9839-20bb4e6414fb'),(2045,433.25,25,'327a6f24-5dd5-4c4d-9839-20bb4e6414fb'),(2046,31.57,26,'327a6f24-5dd5-4c4d-9839-20bb4e6414fb'),(2047,290.13,27,'327a6f24-5dd5-4c4d-9839-20bb4e6414fb'),(2048,10.00,29,'327a6f24-5dd5-4c4d-9839-20bb4e6414fb'),(2049,4.85,28,'327a6f24-5dd5-4c4d-9839-20bb4e6414fb'),(2050,49.55,30,'327a6f24-5dd5-4c4d-9839-20bb4e6414fb'),(2051,3481.50,31,'327a6f24-5dd5-4c4d-9839-20bb4e6414fb'),(2052,5199.01,32,'327a6f24-5dd5-4c4d-9839-20bb4e6414fb'),(2053,7050.00,33,'327a6f24-5dd5-4c4d-9839-20bb4e6414fb'),(2054,587.50,34,'327a6f24-5dd5-4c4d-9839-20bb4e6414fb'),(2055,70.00,36,'327a6f24-5dd5-4c4d-9839-20bb4e6414fb'),(2056,12.84,37,'327a6f24-5dd5-4c4d-9839-20bb4e6414fb'),(2057,297.38,40,'327a6f24-5dd5-4c4d-9839-20bb4e6414fb'),(2058,3568.50,41,'327a6f24-5dd5-4c4d-9839-20bb4e6414fb'),(2059,154.25,42,'327a6f24-5dd5-4c4d-9839-20bb4e6414fb'),(2060,20.11,24,'834a104e-8e1a-4634-84eb-ce7b0962f0ed'),(2061,482.13,25,'834a104e-8e1a-4634-84eb-ce7b0962f0ed'),(2062,33.89,26,'834a104e-8e1a-4634-84eb-ce7b0962f0ed'),(2063,333.79,27,'834a104e-8e1a-4634-84eb-ce7b0962f0ed'),(2064,10.00,29,'834a104e-8e1a-4634-84eb-ce7b0962f0ed'),(2065,4.85,28,'834a104e-8e1a-4634-84eb-ce7b0962f0ed'),(2066,50.44,30,'834a104e-8e1a-4634-84eb-ce7b0962f0ed'),(2067,4005.50,31,'834a104e-8e1a-4634-84eb-ce7b0962f0ed'),(2068,5785.58,32,'834a104e-8e1a-4634-84eb-ce7b0962f0ed'),(2069,7704.00,33,'834a104e-8e1a-4634-84eb-ce7b0962f0ed'),(2070,642.00,34,'834a104e-8e1a-4634-84eb-ce7b0962f0ed'),(2071,70.00,36,'834a104e-8e1a-4634-84eb-ce7b0962f0ed'),(2072,13.54,37,'834a104e-8e1a-4634-84eb-ce7b0962f0ed'),(2073,308.21,40,'834a104e-8e1a-4634-84eb-ce7b0962f0ed'),(2074,3698.50,41,'834a104e-8e1a-4634-84eb-ce7b0962f0ed'),(2075,159.87,42,'834a104e-8e1a-4634-84eb-ce7b0962f0ed'),(2076,19.38,24,'600c3f3c-6f0a-4e9a-977d-1f90d033711d'),(2077,498.71,25,'600c3f3c-6f0a-4e9a-977d-1f90d033711d'),(2078,34.39,26,'600c3f3c-6f0a-4e9a-977d-1f90d033711d'),(2079,468.33,27,'600c3f3c-6f0a-4e9a-977d-1f90d033711d'),(2080,8.00,29,'600c3f3c-6f0a-4e9a-977d-1f90d033711d'),(2081,4.85,28,'600c3f3c-6f0a-4e9a-977d-1f90d033711d'),(2082,53.41,30,'600c3f3c-6f0a-4e9a-977d-1f90d033711d'),(2083,5620.00,31,'600c3f3c-6f0a-4e9a-977d-1f90d033711d'),(2084,5984.49,32,'600c3f3c-6f0a-4e9a-977d-1f90d033711d'),(2085,7940.00,33,'600c3f3c-6f0a-4e9a-977d-1f90d033711d'),(2086,661.67,34,'600c3f3c-6f0a-4e9a-977d-1f90d033711d'),(2087,68.00,36,'600c3f3c-6f0a-4e9a-977d-1f90d033711d'),(2088,13.69,37,'600c3f3c-6f0a-4e9a-977d-1f90d033711d'),(2089,193.33,40,'600c3f3c-6f0a-4e9a-977d-1f90d033711d'),(2090,2320.00,41,'600c3f3c-6f0a-4e9a-977d-1f90d033711d'),(2091,162.96,42,'600c3f3c-6f0a-4e9a-977d-1f90d033711d'),(2092,22.49,24,'ad701847-f669-47ca-af17-0d4841e3060e'),(2093,426.27,25,'ad701847-f669-47ca-af17-0d4841e3060e'),(2094,36.67,26,'ad701847-f669-47ca-af17-0d4841e3060e'),(2095,305.04,27,'ad701847-f669-47ca-af17-0d4841e3060e'),(2096,10.00,29,'ad701847-f669-47ca-af17-0d4841e3060e'),(2097,4.85,28,'ad701847-f669-47ca-af17-0d4841e3060e'),(2098,44.29,30,'ad701847-f669-47ca-af17-0d4841e3060e'),(2099,3660.50,31,'ad701847-f669-47ca-af17-0d4841e3060e'),(2100,5115.22,32,'ad701847-f669-47ca-af17-0d4841e3060e'),(2101,6683.00,33,'ad701847-f669-47ca-af17-0d4841e3060e'),(2102,556.92,34,'ad701847-f669-47ca-af17-0d4841e3060e'),(2103,70.00,36,'ad701847-f669-47ca-af17-0d4841e3060e'),(2104,14.37,37,'ad701847-f669-47ca-af17-0d4841e3060e'),(2105,251.88,40,'ad701847-f669-47ca-af17-0d4841e3060e'),(2106,3022.50,41,'ad701847-f669-47ca-af17-0d4841e3060e'),(2107,130.65,42,'ad701847-f669-47ca-af17-0d4841e3060e'),(2108,23.15,24,'b76b2c53-dc96-4876-b10b-cc38bcb0ced0'),(2109,439.85,25,'b76b2c53-dc96-4876-b10b-cc38bcb0ced0'),(2110,37.43,26,'b76b2c53-dc96-4876-b10b-cc38bcb0ced0'),(2111,317.32,27,'b76b2c53-dc96-4876-b10b-cc38bcb0ced0'),(2112,10.00,29,'b76b2c53-dc96-4876-b10b-cc38bcb0ced0'),(2113,4.85,28,'b76b2c53-dc96-4876-b10b-cc38bcb0ced0'),(2114,34.46,30,'b76b2c53-dc96-4876-b10b-cc38bcb0ced0'),(2115,3807.80,31,'b76b2c53-dc96-4876-b10b-cc38bcb0ced0'),(2116,5278.16,32,'b76b2c53-dc96-4876-b10b-cc38bcb0ced0'),(2117,6863.00,33,'b76b2c53-dc96-4876-b10b-cc38bcb0ced0'),(2118,571.90,34,'b76b2c53-dc96-4876-b10b-cc38bcb0ced0'),(2119,70.00,36,'b76b2c53-dc96-4876-b10b-cc38bcb0ced0'),(2120,14.60,37,'b76b2c53-dc96-4876-b10b-cc38bcb0ced0'),(2121,254.58,40,'b76b2c53-dc96-4876-b10b-cc38bcb0ced0'),(2122,3055.00,41,'b76b2c53-dc96-4876-b10b-cc38bcb0ced0'),(2123,132.05,42,'b76b2c53-dc96-4876-b10b-cc38bcb0ced0'),(2124,27.14,24,'075f2512-1598-4d48-baec-a627056bc3fd'),(2125,499.88,25,'075f2512-1598-4d48-baec-a627056bc3fd'),(2126,42.09,26,'075f2512-1598-4d48-baec-a627056bc3fd'),(2127,376.04,27,'075f2512-1598-4d48-baec-a627056bc3fd'),(2128,10.00,29,'075f2512-1598-4d48-baec-a627056bc3fd'),(2129,4.85,28,'075f2512-1598-4d48-baec-a627056bc3fd'),(2130,40.91,30,'075f2512-1598-4d48-baec-a627056bc3fd'),(2131,4512.50,31,'075f2512-1598-4d48-baec-a627056bc3fd'),(2132,5998.50,32,'075f2512-1598-4d48-baec-a627056bc3fd'),(2133,7600.00,33,'075f2512-1598-4d48-baec-a627056bc3fd'),(2134,633.33,34,'075f2512-1598-4d48-baec-a627056bc3fd'),(2135,70.00,36,'075f2512-1598-4d48-baec-a627056bc3fd'),(2136,16.00,37,'075f2512-1598-4d48-baec-a627056bc3fd'),(2137,257.29,40,'075f2512-1598-4d48-baec-a627056bc3fd'),(2138,3087.50,41,'075f2512-1598-4d48-baec-a627056bc3fd'),(2139,133.46,42,'075f2512-1598-4d48-baec-a627056bc3fd'),(2140,18.21,24,'896302c4-962f-4c81-a9dc-5810e9406fe6'),(2141,368.18,25,'896302c4-962f-4c81-a9dc-5810e9406fe6'),(2142,31.67,26,'896302c4-962f-4c81-a9dc-5810e9406fe6'),(2143,246.96,27,'896302c4-962f-4c81-a9dc-5810e9406fe6'),(2144,10.00,29,'896302c4-962f-4c81-a9dc-5810e9406fe6'),(2145,4.85,28,'896302c4-962f-4c81-a9dc-5810e9406fe6'),(2146,29.06,30,'896302c4-962f-4c81-a9dc-5810e9406fe6'),(2147,2963.50,31,'896302c4-962f-4c81-a9dc-5810e9406fe6'),(2148,4418.22,32,'896302c4-962f-4c81-a9dc-5810e9406fe6'),(2149,5986.00,33,'896302c4-962f-4c81-a9dc-5810e9406fe6'),(2150,498.83,34,'896302c4-962f-4c81-a9dc-5810e9406fe6'),(2151,70.00,36,'896302c4-962f-4c81-a9dc-5810e9406fe6'),(2152,12.87,37,'896302c4-962f-4c81-a9dc-5810e9406fe6'),(2153,251.88,40,'896302c4-962f-4c81-a9dc-5810e9406fe6'),(2154,3022.50,41,'896302c4-962f-4c81-a9dc-5810e9406fe6'),(2155,130.65,42,'896302c4-962f-4c81-a9dc-5810e9406fe6'),(2156,25.30,24,'0294f5e0-53b5-4ce2-927e-d5cd06ab9d31'),(2157,474.38,25,'0294f5e0-53b5-4ce2-927e-d5cd06ab9d31'),(2158,39.95,26,'0294f5e0-53b5-4ce2-927e-d5cd06ab9d31'),(2159,350.54,27,'0294f5e0-53b5-4ce2-927e-d5cd06ab9d31'),(2160,10.00,29,'0294f5e0-53b5-4ce2-927e-d5cd06ab9d31'),(2161,4.85,28,'0294f5e0-53b5-4ce2-927e-d5cd06ab9d31'),(2162,43.18,30,'0294f5e0-53b5-4ce2-927e-d5cd06ab9d31'),(2163,4206.50,31,'0294f5e0-53b5-4ce2-927e-d5cd06ab9d31'),(2164,5692.50,32,'0294f5e0-53b5-4ce2-927e-d5cd06ab9d31'),(2165,7294.00,33,'0294f5e0-53b5-4ce2-927e-d5cd06ab9d31'),(2166,607.83,34,'0294f5e0-53b5-4ce2-927e-d5cd06ab9d31'),(2167,70.00,36,'0294f5e0-53b5-4ce2-927e-d5cd06ab9d31'),(2168,15.36,37,'0294f5e0-53b5-4ce2-927e-d5cd06ab9d31'),(2169,257.29,40,'0294f5e0-53b5-4ce2-927e-d5cd06ab9d31'),(2170,3087.50,41,'0294f5e0-53b5-4ce2-927e-d5cd06ab9d31'),(2171,133.46,42,'0294f5e0-53b5-4ce2-927e-d5cd06ab9d31'),(2172,17.12,24,'5a62d899-d81e-4c62-b80d-075de1653eb6'),(2173,398.99,25,'5a62d899-d81e-4c62-b80d-075de1653eb6'),(2174,30.40,26,'5a62d899-d81e-4c62-b80d-075de1653eb6'),(2175,262.13,27,'5a62d899-d81e-4c62-b80d-075de1653eb6'),(2176,10.00,29,'5a62d899-d81e-4c62-b80d-075de1653eb6'),(2177,4.85,28,'5a62d899-d81e-4c62-b80d-075de1653eb6'),(2178,43.75,30,'5a62d899-d81e-4c62-b80d-075de1653eb6'),(2179,3145.50,31,'5a62d899-d81e-4c62-b80d-075de1653eb6'),(2180,4787.93,32,'5a62d899-d81e-4c62-b80d-075de1653eb6'),(2181,6558.00,33,'5a62d899-d81e-4c62-b80d-075de1653eb6'),(2182,546.50,34,'5a62d899-d81e-4c62-b80d-075de1653eb6'),(2183,70.00,36,'5a62d899-d81e-4c62-b80d-075de1653eb6'),(2184,12.49,37,'5a62d899-d81e-4c62-b80d-075de1653eb6'),(2185,284.38,40,'5a62d899-d81e-4c62-b80d-075de1653eb6'),(2186,3412.50,41,'5a62d899-d81e-4c62-b80d-075de1653eb6'),(2187,147.51,42,'5a62d899-d81e-4c62-b80d-075de1653eb6'),(2188,18.50,24,'7901b0ed-a686-435f-9b16-43c420b8f207'),(2189,312.09,25,'7901b0ed-a686-435f-9b16-43c420b8f207'),(2190,32.01,26,'7901b0ed-a686-435f-9b16-43c420b8f207'),(2191,210.42,27,'7901b0ed-a686-435f-9b16-43c420b8f207'),(2192,10.00,29,'7901b0ed-a686-435f-9b16-43c420b8f207'),(2193,4.85,28,'7901b0ed-a686-435f-9b16-43c420b8f207'),(2194,35.45,30,'7901b0ed-a686-435f-9b16-43c420b8f207'),(2195,2525.00,31,'7901b0ed-a686-435f-9b16-43c420b8f207'),(2196,3745.09,32,'7901b0ed-a686-435f-9b16-43c420b8f207'),(2197,5060.00,33,'7901b0ed-a686-435f-9b16-43c420b8f207'),(2198,421.67,34,'7901b0ed-a686-435f-9b16-43c420b8f207'),(2199,70.00,36,'7901b0ed-a686-435f-9b16-43c420b8f207'),(2200,12.97,37,'7901b0ed-a686-435f-9b16-43c420b8f207'),(2201,211.25,40,'7901b0ed-a686-435f-9b16-43c420b8f207'),(2202,2535.00,41,'7901b0ed-a686-435f-9b16-43c420b8f207'),(2203,109.58,42,'7901b0ed-a686-435f-9b16-43c420b8f207'),(2204,18.55,24,'7cef0925-c5bb-450b-af9a-465c142bd253'),(2205,288.60,25,'7cef0925-c5bb-450b-af9a-465c142bd253'),(2206,32.07,26,'7cef0925-c5bb-450b-af9a-465c142bd253'),(2207,194.75,27,'7cef0925-c5bb-450b-af9a-465c142bd253'),(2208,10.00,29,'7cef0925-c5bb-450b-af9a-465c142bd253'),(2209,4.85,28,'7cef0925-c5bb-450b-af9a-465c142bd253'),(2210,41.67,30,'7cef0925-c5bb-450b-af9a-465c142bd253'),(2211,2337.00,31,'7cef0925-c5bb-450b-af9a-465c142bd253'),(2212,3463.23,32,'7cef0925-c5bb-450b-af9a-465c142bd253'),(2213,4677.00,33,'7cef0925-c5bb-450b-af9a-465c142bd253'),(2214,390.00,34,'7cef0925-c5bb-450b-af9a-465c142bd253'),(2215,70.00,36,'7cef0925-c5bb-450b-af9a-465c142bd253'),(2216,12.99,37,'7cef0925-c5bb-450b-af9a-465c142bd253'),(2217,195.00,40,'7cef0925-c5bb-450b-af9a-465c142bd253'),(2218,2340.00,41,'7cef0925-c5bb-450b-af9a-465c142bd253'),(2219,101.15,42,'7cef0925-c5bb-450b-af9a-465c142bd253'),(2220,20.06,24,'12453af9-bb1a-4af2-ab65-688f3aaa43e7'),(2221,329.84,25,'12453af9-bb1a-4af2-ab65-688f3aaa43e7'),(2222,33.83,26,'12453af9-bb1a-4af2-ab65-688f3aaa43e7'),(2223,228.17,27,'12453af9-bb1a-4af2-ab65-688f3aaa43e7'),(2224,10.00,29,'12453af9-bb1a-4af2-ab65-688f3aaa43e7'),(2225,4.85,28,'12453af9-bb1a-4af2-ab65-688f3aaa43e7'),(2226,58.04,30,'12453af9-bb1a-4af2-ab65-688f3aaa43e7'),(2227,2738.00,31,'12453af9-bb1a-4af2-ab65-688f3aaa43e7'),(2228,3958.09,32,'12453af9-bb1a-4af2-ab65-688f3aaa43e7'),(2229,5273.00,33,'12453af9-bb1a-4af2-ab65-688f3aaa43e7'),(2230,439.42,34,'12453af9-bb1a-4af2-ab65-688f3aaa43e7'),(2231,70.00,36,'12453af9-bb1a-4af2-ab65-688f3aaa43e7'),(2232,13.52,37,'12453af9-bb1a-4af2-ab65-688f3aaa43e7'),(2233,211.25,40,'12453af9-bb1a-4af2-ab65-688f3aaa43e7'),(2234,2535.00,41,'12453af9-bb1a-4af2-ab65-688f3aaa43e7'),(2235,109.58,42,'12453af9-bb1a-4af2-ab65-688f3aaa43e7'),(2236,17.93,24,'5dac471b-86e0-4e63-a8fa-f62b5a73c2de'),(2237,383.99,25,'5dac471b-86e0-4e63-a8fa-f62b5a73c2de'),(2238,31.35,26,'5dac471b-86e0-4e63-a8fa-f62b5a73c2de'),(2239,256.25,27,'5dac471b-86e0-4e63-a8fa-f62b5a73c2de'),(2240,10.00,29,'5dac471b-86e0-4e63-a8fa-f62b5a73c2de'),(2241,4.85,28,'5dac471b-86e0-4e63-a8fa-f62b5a73c2de'),(2242,37.12,30,'5dac471b-86e0-4e63-a8fa-f62b5a73c2de'),(2243,3075.00,31,'5dac471b-86e0-4e63-a8fa-f62b5a73c2de'),(2244,4607.93,32,'5dac471b-86e0-4e63-a8fa-f62b5a73c2de'),(2245,6260.00,33,'5dac471b-86e0-4e63-a8fa-f62b5a73c2de'),(2246,521.67,34,'5dac471b-86e0-4e63-a8fa-f62b5a73c2de'),(2247,70.00,36,'5dac471b-86e0-4e63-a8fa-f62b5a73c2de'),(2248,12.78,37,'5dac471b-86e0-4e63-a8fa-f62b5a73c2de'),(2249,265.42,40,'5dac471b-86e0-4e63-a8fa-f62b5a73c2de'),(2250,3185.00,41,'5dac471b-86e0-4e63-a8fa-f62b5a73c2de'),(2251,137.67,42,'5dac471b-86e0-4e63-a8fa-f62b5a73c2de'),(2252,16.28,24,'f517f214-08e2-4d6d-998b-1a88130e71b5'),(2253,286.84,25,'f517f214-08e2-4d6d-998b-1a88130e71b5'),(2254,29.42,26,'f517f214-08e2-4d6d-998b-1a88130e71b5'),(2255,185.17,27,'f517f214-08e2-4d6d-998b-1a88130e71b5'),(2256,10.00,29,'f517f214-08e2-4d6d-998b-1a88130e71b5'),(2257,4.85,28,'f517f214-08e2-4d6d-998b-1a88130e71b5'),(2258,32.50,30,'f517f214-08e2-4d6d-998b-1a88130e71b5'),(2259,2222.00,31,'f517f214-08e2-4d6d-998b-1a88130e71b5'),(2260,3442.09,32,'f517f214-08e2-4d6d-998b-1a88130e71b5'),(2261,4757.00,33,'f517f214-08e2-4d6d-998b-1a88130e71b5'),(2262,396.42,34,'f517f214-08e2-4d6d-998b-1a88130e71b5'),(2263,70.00,36,'f517f214-08e2-4d6d-998b-1a88130e71b5'),(2264,12.20,37,'f517f214-08e2-4d6d-998b-1a88130e71b5'),(2265,211.25,40,'f517f214-08e2-4d6d-998b-1a88130e71b5'),(2266,2535.00,41,'f517f214-08e2-4d6d-998b-1a88130e71b5'),(2267,109.58,42,'f517f214-08e2-4d6d-998b-1a88130e71b5'),(2268,14.28,24,'9e9d835d-6ccc-422d-bc87-5ac59b1be01e'),(2269,371.75,25,'9e9d835d-6ccc-422d-bc87-5ac59b1be01e'),(2270,27.09,26,'9e9d835d-6ccc-422d-bc87-5ac59b1be01e'),(2271,228.63,27,'9e9d835d-6ccc-422d-bc87-5ac59b1be01e'),(2272,10.00,29,'9e9d835d-6ccc-422d-bc87-5ac59b1be01e'),(2273,4.85,28,'9e9d835d-6ccc-422d-bc87-5ac59b1be01e'),(2274,54.79,30,'9e9d835d-6ccc-422d-bc87-5ac59b1be01e'),(2275,2743.50,31,'9e9d835d-6ccc-422d-bc87-5ac59b1be01e'),(2276,4461.01,32,'9e9d835d-6ccc-422d-bc87-5ac59b1be01e'),(2277,6312.00,33,'9e9d835d-6ccc-422d-bc87-5ac59b1be01e'),(2278,526.00,34,'9e9d835d-6ccc-422d-bc87-5ac59b1be01e'),(2279,70.00,36,'9e9d835d-6ccc-422d-bc87-5ac59b1be01e'),(2280,11.50,37,'9e9d835d-6ccc-422d-bc87-5ac59b1be01e'),(2281,297.38,40,'9e9d835d-6ccc-422d-bc87-5ac59b1be01e'),(2282,3568.50,41,'9e9d835d-6ccc-422d-bc87-5ac59b1be01e'),(2283,154.25,42,'9e9d835d-6ccc-422d-bc87-5ac59b1be01e'),(2284,17.50,24,'10f4b906-49c5-437c-b2d6-3ecc249e4a8c'),(2285,415.56,25,'10f4b906-49c5-437c-b2d6-3ecc249e4a8c'),(2286,30.84,26,'10f4b906-49c5-437c-b2d6-3ecc249e4a8c'),(2287,275.04,27,'10f4b906-49c5-437c-b2d6-3ecc249e4a8c'),(2288,10.00,29,'10f4b906-49c5-437c-b2d6-3ecc249e4a8c'),(2289,4.85,28,'10f4b906-49c5-437c-b2d6-3ecc249e4a8c'),(2290,60.70,30,'10f4b906-49c5-437c-b2d6-3ecc249e4a8c'),(2291,3300.50,31,'10f4b906-49c5-437c-b2d6-3ecc249e4a8c'),(2292,4986.72,32,'10f4b906-49c5-437c-b2d6-3ecc249e4a8c'),(2293,6804.00,33,'10f4b906-49c5-437c-b2d6-3ecc249e4a8c'),(2294,567.00,34,'10f4b906-49c5-437c-b2d6-3ecc249e4a8c'),(2295,70.00,36,'10f4b906-49c5-437c-b2d6-3ecc249e4a8c'),(2296,12.62,37,'10f4b906-49c5-437c-b2d6-3ecc249e4a8c'),(2297,291.96,40,'10f4b906-49c5-437c-b2d6-3ecc249e4a8c'),(2298,3503.50,41,'10f4b906-49c5-437c-b2d6-3ecc249e4a8c'),(2299,151.44,42,'10f4b906-49c5-437c-b2d6-3ecc249e4a8c'),(2300,18.42,24,'898bb6a5-c46c-443b-bd3c-4ebcc0645cae'),(2301,428.08,25,'898bb6a5-c46c-443b-bd3c-4ebcc0645cae'),(2302,46.78,26,'898bb6a5-c46c-443b-bd3c-4ebcc0645cae'),(2303,421.37,27,'898bb6a5-c46c-443b-bd3c-4ebcc0645cae'),(2304,8.00,29,'898bb6a5-c46c-443b-bd3c-4ebcc0645cae'),(2305,4.85,28,'898bb6a5-c46c-443b-bd3c-4ebcc0645cae'),(2306,51.99,30,'898bb6a5-c46c-443b-bd3c-4ebcc0645cae'),(2307,5056.40,31,'898bb6a5-c46c-443b-bd3c-4ebcc0645cae'),(2308,5136.98,32,'898bb6a5-c46c-443b-bd3c-4ebcc0645cae'),(2309,7252.00,33,'898bb6a5-c46c-443b-bd3c-4ebcc0645cae'),(2310,604.00,34,'898bb6a5-c46c-443b-bd3c-4ebcc0645cae'),(2311,70.00,36,'898bb6a5-c46c-443b-bd3c-4ebcc0645cae'),(2312,13.21,37,'898bb6a5-c46c-443b-bd3c-4ebcc0645cae'),(2313,183.00,40,'898bb6a5-c46c-443b-bd3c-4ebcc0645cae'),(2314,2196.00,41,'898bb6a5-c46c-443b-bd3c-4ebcc0645cae'),(2315,176.28,42,'898bb6a5-c46c-443b-bd3c-4ebcc0645cae'),(2316,30.62,24,'9f75eb7f-b884-4802-b2ba-bb70466e2070'),(2317,974.74,25,'9f75eb7f-b884-4802-b2ba-bb70466e2070'),(2318,38.99,26,'9f75eb7f-b884-4802-b2ba-bb70466e2070'),(2319,1046.33,27,'9f75eb7f-b884-4802-b2ba-bb70466e2070'),(2320,8.00,29,'9f75eb7f-b884-4802-b2ba-bb70466e2070'),(2321,7.99,28,'9f75eb7f-b884-4802-b2ba-bb70466e2070'),(2322,37.10,30,'9f75eb7f-b884-4802-b2ba-bb70466e2070'),(2323,600.00,34,'9f75eb7f-b884-4802-b2ba-bb70466e2070'),(2324,70.00,36,'9f75eb7f-b884-4802-b2ba-bb70466e2070'),(2325,19.68,37,'9f75eb7f-b884-4802-b2ba-bb70466e2070'),(2326,273.33,40,'9f75eb7f-b884-4802-b2ba-bb70466e2070'),(2327,3280.00,41,'9f75eb7f-b884-4802-b2ba-bb70466e2070'),(2328,344.93,42,'9f75eb7f-b884-4802-b2ba-bb70466e2070'),(2329,17.66,24,'92fec5e1-aef9-40c5-8ead-f85d63db5ab7'),(2330,1142.60,25,'92fec5e1-aef9-40c5-8ead-f85d63db5ab7'),(2331,31.52,26,'92fec5e1-aef9-40c5-8ead-f85d63db5ab7'),(2332,1066.67,27,'92fec5e1-aef9-40c5-8ead-f85d63db5ab7'),(2333,8.00,29,'92fec5e1-aef9-40c5-8ead-f85d63db5ab7'),(2334,4.85,28,'92fec5e1-aef9-40c5-8ead-f85d63db5ab7'),(2335,41.26,30,'92fec5e1-aef9-40c5-8ead-f85d63db5ab7'),(2336,1550.00,34,'92fec5e1-aef9-40c5-8ead-f85d63db5ab7'),(2337,70.00,36,'92fec5e1-aef9-40c5-8ead-f85d63db5ab7'),(2338,15.31,37,'92fec5e1-aef9-40c5-8ead-f85d63db5ab7'),(2339,483.33,40,'92fec5e1-aef9-40c5-8ead-f85d63db5ab7'),(2340,5800.00,41,'92fec5e1-aef9-40c5-8ead-f85d63db5ab7'),(2341,407.40,42,'92fec5e1-aef9-40c5-8ead-f85d63db5ab7'),(2342,14.91,24,'ef6af867-3eaf-436e-b96c-6391b9756037'),(2343,350.23,25,'ef6af867-3eaf-436e-b96c-6391b9756037'),(2344,26.94,26,'ef6af867-3eaf-436e-b96c-6391b9756037'),(2345,323.00,27,'ef6af867-3eaf-436e-b96c-6391b9756037'),(2346,8.00,29,'ef6af867-3eaf-436e-b96c-6391b9756037'),(2347,4.85,28,'ef6af867-3eaf-436e-b96c-6391b9756037'),(2348,46.10,30,'ef6af867-3eaf-436e-b96c-6391b9756037'),(2349,3876.00,31,'ef6af867-3eaf-436e-b96c-6391b9756037'),(2350,4202.78,32,'ef6af867-3eaf-436e-b96c-6391b9756037'),(2351,5956.00,33,'ef6af867-3eaf-436e-b96c-6391b9756037'),(2352,496.33,34,'ef6af867-3eaf-436e-b96c-6391b9756037'),(2353,70.00,36,'ef6af867-3eaf-436e-b96c-6391b9756037'),(2354,11.45,37,'ef6af867-3eaf-436e-b96c-6391b9756037'),(2355,173.33,40,'ef6af867-3eaf-436e-b96c-6391b9756037'),(2356,2080.00,41,'ef6af867-3eaf-436e-b96c-6391b9756037'),(2357,146.10,42,'ef6af867-3eaf-436e-b96c-6391b9756037'),(2358,20.50,24,'8fce50a7-5691-4756-8482-50dc28640d09'),(2359,335.46,25,'8fce50a7-5691-4756-8482-50dc28640d09'),(2360,36.27,26,'8fce50a7-5691-4756-8482-50dc28640d09'),(2361,316.08,27,'8fce50a7-5691-4756-8482-50dc28640d09'),(2362,8.00,29,'8fce50a7-5691-4756-8482-50dc28640d09'),(2363,4.85,28,'8fce50a7-5691-4756-8482-50dc28640d09'),(2364,47.93,30,'8fce50a7-5691-4756-8482-50dc28640d09'),(2365,3793.00,31,'8fce50a7-5691-4756-8482-50dc28640d09'),(2366,4025.52,32,'8fce50a7-5691-4756-8482-50dc28640d09'),(2367,5273.00,33,'8fce50a7-5691-4756-8482-50dc28640d09'),(2368,439.00,34,'8fce50a7-5691-4756-8482-50dc28640d09'),(2369,70.00,36,'8fce50a7-5691-4756-8482-50dc28640d09'),(2370,14.25,37,'8fce50a7-5691-4756-8482-50dc28640d09'),(2371,123.33,40,'8fce50a7-5691-4756-8482-50dc28640d09'),(2372,1480.00,41,'8fce50a7-5691-4756-8482-50dc28640d09'),(2373,103.96,42,'8fce50a7-5691-4756-8482-50dc28640d09'),(2374,32.60,24,'327f6a33-0e92-47b5-aa30-cc31df85bce8'),(2375,606.66,25,'327f6a33-0e92-47b5-aa30-cc31df85bce8'),(2376,57.78,26,'327f6a33-0e92-47b5-aa30-cc31df85bce8'),(2377,570.58,27,'327f6a33-0e92-47b5-aa30-cc31df85bce8'),(2378,8.00,29,'327f6a33-0e92-47b5-aa30-cc31df85bce8'),(2379,4.85,28,'327f6a33-0e92-47b5-aa30-cc31df85bce8'),(2380,15.22,30,'327f6a33-0e92-47b5-aa30-cc31df85bce8'),(2381,6846.91,31,'327f6a33-0e92-47b5-aa30-cc31df85bce8'),(2382,7279.94,32,'327f6a33-0e92-47b5-aa30-cc31df85bce8'),(2383,8696.00,33,'327f6a33-0e92-47b5-aa30-cc31df85bce8'),(2384,724.67,34,'327f6a33-0e92-47b5-aa30-cc31df85bce8'),(2385,70.00,36,'327f6a33-0e92-47b5-aa30-cc31df85bce8'),(2386,20.70,37,'327f6a33-0e92-47b5-aa30-cc31df85bce8'),(2387,139.47,40,'327f6a33-0e92-47b5-aa30-cc31df85bce8'),(2388,1673.66,41,'327f6a33-0e92-47b5-aa30-cc31df85bce8'),(2389,118.00,42,'327f6a33-0e92-47b5-aa30-cc31df85bce8'),(2390,18.24,24,'3a19cb0e-e92d-4d82-934a-7543bfc7cf9c'),(2391,237.81,25,'3a19cb0e-e92d-4d82-934a-7543bfc7cf9c'),(2392,31.71,26,'3a19cb0e-e92d-4d82-934a-7543bfc7cf9c'),(2393,159.60,27,'3a19cb0e-e92d-4d82-934a-7543bfc7cf9c'),(2394,10.00,29,'3a19cb0e-e92d-4d82-934a-7543bfc7cf9c'),(2395,4.85,28,'3a19cb0e-e92d-4d82-934a-7543bfc7cf9c'),(2396,27.83,30,'3a19cb0e-e92d-4d82-934a-7543bfc7cf9c'),(2397,1915.20,31,'3a19cb0e-e92d-4d82-934a-7543bfc7cf9c'),(2398,2853.73,32,'3a19cb0e-e92d-4d82-934a-7543bfc7cf9c'),(2399,3865.00,33,'3a19cb0e-e92d-4d82-934a-7543bfc7cf9c'),(2400,322.10,34,'3a19cb0e-e92d-4d82-934a-7543bfc7cf9c'),(2401,70.00,36,'3a19cb0e-e92d-4d82-934a-7543bfc7cf9c'),(2402,12.88,37,'3a19cb0e-e92d-4d82-934a-7543bfc7cf9c'),(2403,9000.00,39,'3a19cb0e-e92d-4d82-934a-7543bfc7cf9c'),(2404,162.50,40,'3a19cb0e-e92d-4d82-934a-7543bfc7cf9c'),(2405,1950.00,41,'3a19cb0e-e92d-4d82-934a-7543bfc7cf9c'),(2406,84.29,42,'3a19cb0e-e92d-4d82-934a-7543bfc7cf9c'),(2407,29.16,24,'16c55d0d-67da-473b-b2ed-a4e7e71a4402'),(2408,452.70,25,'16c55d0d-67da-473b-b2ed-a4e7e71a4402'),(2409,39.45,26,'16c55d0d-67da-473b-b2ed-a4e7e71a4402'),(2410,390.42,27,'16c55d0d-67da-473b-b2ed-a4e7e71a4402'),(2411,10.00,29,'16c55d0d-67da-473b-b2ed-a4e7e71a4402'),(2412,4.85,28,'16c55d0d-67da-473b-b2ed-a4e7e71a4402'),(2413,40.84,30,'16c55d0d-67da-473b-b2ed-a4e7e71a4402'),(2414,4685.00,31,'16c55d0d-67da-473b-b2ed-a4e7e71a4402'),(2415,5432.45,32,'16c55d0d-67da-473b-b2ed-a4e7e71a4402'),(2416,6980.00,33,'16c55d0d-67da-473b-b2ed-a4e7e71a4402'),(2417,582.00,34,'16c55d0d-67da-473b-b2ed-a4e7e71a4402'),(2418,70.00,36,'16c55d0d-67da-473b-b2ed-a4e7e71a4402'),(2419,15.21,37,'16c55d0d-67da-473b-b2ed-a4e7e71a4402'),(2420,191.25,40,'16c55d0d-67da-473b-b2ed-a4e7e71a4402'),(2421,2295.00,41,'16c55d0d-67da-473b-b2ed-a4e7e71a4402'),(2422,128.96,42,'16c55d0d-67da-473b-b2ed-a4e7e71a4402'),(2423,21.07,24,'37d7f0fb-a6fd-49fe-868e-4dec73d425cf'),(2424,488.72,25,'37d7f0fb-a6fd-49fe-868e-4dec73d425cf'),(2425,53.41,26,'37d7f0fb-a6fd-49fe-868e-4dec73d425cf'),(2426,482.00,27,'37d7f0fb-a6fd-49fe-868e-4dec73d425cf'),(2427,8.00,29,'37d7f0fb-a6fd-49fe-868e-4dec73d425cf'),(2428,4.85,28,'37d7f0fb-a6fd-49fe-868e-4dec73d425cf'),(2429,36.31,30,'37d7f0fb-a6fd-49fe-868e-4dec73d425cf'),(2430,5784.00,31,'37d7f0fb-a6fd-49fe-868e-4dec73d425cf'),(2431,5864.58,32,'37d7f0fb-a6fd-49fe-868e-4dec73d425cf'),(2432,7980.00,33,'37d7f0fb-a6fd-49fe-868e-4dec73d425cf'),(2433,665.00,34,'37d7f0fb-a6fd-49fe-868e-4dec73d425cf'),(2434,70.00,36,'37d7f0fb-a6fd-49fe-868e-4dec73d425cf'),(2435,14.54,37,'37d7f0fb-a6fd-49fe-868e-4dec73d425cf'),(2436,183.00,40,'37d7f0fb-a6fd-49fe-868e-4dec73d425cf'),(2437,2196.00,41,'37d7f0fb-a6fd-49fe-868e-4dec73d425cf'),(2438,176.28,42,'37d7f0fb-a6fd-49fe-868e-4dec73d425cf');
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
  `TYPE` varchar(45) NOT NULL DEFAULT 'header',
  `SIZE` int(11) NOT NULL DEFAULT '0',
  `SRC_URL` varchar(150) NOT NULL,
  `PROPERTY_DATA_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_PROPERTY_IMAGES_PROPERTY_DATA1_idx` (`PROPERTY_DATA_ID`),
  CONSTRAINT `fk_PROPERTY_IMAGES_PROPERTY_DATA1` FOREIGN KEY (`PROPERTY_DATA_ID`) REFERENCES `PROPERTY_DATA` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2183 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PROPERTY_IMAGES`
--

LOCK TABLES `PROPERTY_IMAGES` WRITE;
/*!40000 ALTER TABLE `PROPERTY_IMAGES` DISABLE KEYS */;
INSERT INTO `PROPERTY_IMAGES` VALUES (1907,'Tammin.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9wv/5125185abaa60/Tammin.jpeg',400),(1908,'1_curb.jpeg','header',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9wx/512515b1797b9/1_curb.jpeg',401),(1909,'2_Liv_rm.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9wx/512515b5358b4/2_Liv_rm.jpeg',401),(1910,'3_Kit.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9wx/512515b840390/3_Kit.jpeg',401),(1911,'4_utility.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9wx/512515bb1fdb2/4_utility.jpeg',401),(1912,'5_Furn_whtr.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9wx/512515c06e192/5_Furn_whtr.jpeg',401),(1913,'7_bedrm.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9wx/512515c6a33fc/7_bedrm.jpeg',401),(1914,'8_Half_bath.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9wx/512515c9a5127/8_Half_bath.jpeg',401),(1915,'9_full_bath.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9wx/512515ccc6537/9_full_bath.jpeg',401),(1916,'10_Bedroom.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9wx/512515cfd3909/10_Bedroom.jpeg',401),(1917,'12_din_rm.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9wx/512515d997343/12_din_rm.jpeg',401),(1918,'13_side.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9wx/512515dd1b6be/13_side.jpeg',401),(1919,'14_Rear.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9wx/512515e17a279/14_Rear.jpeg',401),(1920,'15_BR_master.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9wx/512515e55f6a9/15_BR_master.jpeg',401),(1921,'1_curbnew_roof.jpeg','header',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9wy/51251d8b2b918/1_curbnew_roof.jpeg',402),(1922,'1_curbRookwood1.jpeg','header',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9wy/51251da03d5b7/1_curbRookwood1.jpeg',402),(1923,'Ritter Exteriors Sold 110.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9wz/512514d871386/Ritter Exteriors Sold 110.jpeg',403),(1924,'1_Curb_Holmes.jpeg','header',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x3/512510867ae19/1_Curb_Holmes.jpeg',404),(1925,'2_kitchen.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x3/5125108999e07/2_kitchen.jpeg',404),(1926,'3_Liv_rm.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x3/5125108cb4f75/3_Liv_rm.jpeg',404),(1927,'4_BR1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x3/5125108f4390b/4_BR1.jpeg',404),(1928,'5_Bath.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x3/51251091ee629/5_Bath.jpeg',404),(1929,'6_BR_2.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x3/5125109477678/6_BR_2.jpeg',404),(1930,'7_BR_bsmt.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x3/51251099f285f/7_BR_bsmt.jpeg',404),(1931,'8_Kit_w_appl.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x3/5125109c91272/8_Kit_w_appl.jpeg',404),(1932,'10_half_ba.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x3/512510a1a5a08/10_half_ba.jpeg',404),(1933,'9_bsmt.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x3/5125109f2ef25/9_bsmt.jpeg',404),(1934,'11_Storeage_bsmt.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x3/512510a45871b/11_Storeage_bsmt.jpeg',404),(1935,'13_Furn_wtr_htr.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x3/512510a733432/13_Furn_wtr_htr.jpeg',404),(1936,'Ritter_Exteriors_Sold_070.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x3/512510b0b66d9/Ritter_Exteriors_Sold_070.jpeg',404),(1937,'Ritter_Exteriors_Sold_071.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x3/512510b4537e2/Ritter_Exteriors_Sold_071.jpeg',404),(1938,'Ritter_Exteriors_Sold_072.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x3/512510b7d52de/Ritter_Exteriors_Sold_072.jpeg',404),(1939,'Ritter_Exteriors_Sold_073.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x3/512510bb72179/Ritter_Exteriors_Sold_073.jpeg',404),(1940,'Ritter_Exteriors_Sold_074.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x3/512510bf2214d/Ritter_Exteriors_Sold_074.jpeg',404),(1941,'Ritter_Exteriors_Sold_075.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x3/512510c2c17a7/Ritter_Exteriors_Sold_075.jpeg',404),(1942,'1_curb_2009_Legrand_n_new_east_siders_001.jpeg','header',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x5/512521bb36768/1_curb_2009_Legrand_n_new_east_siders_001.jpeg',405),(1943,'2_kit_2009_Legrand_n_new_east_siders_003.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x5/512521be66ce4/2_kit_2009_Legrand_n_new_east_siders_003.jpeg',405),(1944,'3_liv_rm_Legrand_n_new_east_siders_005.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x5/512521c108b5e/3_liv_rm_Legrand_n_new_east_siders_005.jpeg',405),(1945,'4_bath_Legrand_n_new_east_siders_007.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x5/512521c3c721c/4_bath_Legrand_n_new_east_siders_007.jpeg',405),(1946,'5_Bedroom_legrand_2009.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x5/512521c6e898c/5_Bedroom_legrand_2009.jpeg',405),(1947,'6_2nd_bedroom_legrand_2009.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x5/512521c97deae/6_2nd_bedroom_legrand_2009.jpeg',405),(1948,'1_Curb_painted_Lindley.jpeg','header',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x7/512522a80613b/1_Curb_painted_Lindley.jpeg',406),(1949,'2_new_kit_lindley.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x7/512522ae45b23/2_new_kit_lindley.jpeg',406),(1950,'3 _iv_rm.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x7/512522b15dd3d/3 _iv_rm.jpeg',406),(1951,'4_Bath.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x7/512522b3ec12f/4_Bath.jpeg',406),(1952,'5_Utility_Lindley_1411.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x7/512522b6ada70/5_Utility_Lindley_1411.jpeg',406),(1953,'6_BRmLindley_1411_009.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x7/512522b958ab7/6_BRmLindley_1411_009.jpeg',406),(1954,'7_Bedrm_Lindley_1411.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x7/512522bbd43dd/7_Bedrm_Lindley_1411.jpeg',406),(1955,'8_Rear_Lindley.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x7/512522be97056/8_Rear_Lindley.jpeg',406),(1956,'9_Garage_painted.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x7/512522c1b14ce/9_Garage_painted.jpeg',406),(1957,'1_curb_a_shutters.jpeg','header',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x9/5125234804e61/1_curb_a_shutters.jpeg',407),(1958,'2_a_Kit_done.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x9/5125234b9d865/2_a_Kit_done.jpeg',407),(1959,'2_Moreland_b_turnover_006.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x9/5125234ea2db8/2_Moreland_b_turnover_006.jpeg',407),(1960,'3_a_Bath_done.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x9/51252351a2c84/3_a_Bath_done.jpeg',407),(1961,'3_kit_b_done.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x9/512523548a7b6/3_kit_b_done.jpeg',407),(1962,'4_a_BR_done.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x9/5125235792694/4_a_BR_done.jpeg',407),(1963,'4_Bath_Mooreand_b.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x9/5125235acb3bf/4_Bath_Mooreand_b.jpeg',407),(1964,'5_B_BR2_done.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x9/5125235dbe0ef/5_B_BR2_done.jpeg',407),(1965,'5_Bedrm_Mooreland_b.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x9/5125236141b68/5_Bedrm_Mooreland_b.jpeg',407),(1966,'6_a_kit_closeup.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x9/512523646cd75/6_a_kit_closeup.jpeg',407),(1967,'6_Moreland_b_urnover_010.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x9/5125236745c55/6_Moreland_b_urnover_010.jpeg',407),(1968,'7_2nd_bath_mooreland_b.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x9/5125236a0268c/7_2nd_bath_mooreland_b.jpeg',407),(1969,'7_a_BR3_done.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x9/5125236d745de/7_a_BR3_done.jpeg',407),(1970,'8_2nd_bath_mooreland_b.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x9/512523703c6f7/8_2nd_bath_mooreland_b.jpeg',407),(1971,'8_a _iv_rm_done.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x9/512523730f931/8_a _iv_rm_done.jpeg',407),(1972,'Ritter_Exteriors_old_136.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x9/51252378e34af/Ritter_Exteriors_old_136.jpeg',407),(1973,'DSCN4502.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xB/5125257e73ccd/DSCN4502.jpeg',408),(1974,'DSCN4503.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xB/5125258730f5c/DSCN4503.jpeg',408),(1975,'DSCN4504.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xB/5125258ea3d09/DSCN4504.jpeg',408),(1976,'DSCN4505.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xB/5125259a01ad4/DSCN4505.jpeg',408),(1977,'DSCN4506.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xB/512525a2066ce/DSCN4506.jpeg',408),(1978,'DSCN4507.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xB/512525aa01642/DSCN4507.jpeg',408),(1979,'DSCN4508.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xB/512525b248ef1/DSCN4508.jpeg',408),(1980,'DSCN4509.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xB/512525c025d99/DSCN4509.jpeg',408),(1981,'DSCN4510.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xB/512525c9ef702/DSCN4510.jpeg',408),(1982,'DSCN4511.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xB/512525d2af648/DSCN4511.jpeg',408),(1983,'DSCN4512.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xB/512525db721ee/DSCN4512.jpeg',408),(1984,'DSCN4513.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xB/512525e4ab346/DSCN4513.jpeg',408),(1985,'DSCN4514.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xB/512525ed98477/DSCN4514.jpeg',408),(1986,'DSCN4515.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xB/512525f79b1dc/DSCN4515.jpeg',408),(1987,'DSCN4516.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xB/51252601528b5/DSCN4516.jpeg',408),(1988,'DSCN4518.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xB/5125260b28ce3/DSCN4518.jpeg',408),(1989,'DSCN4520.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xB/5125261497068/DSCN4520.jpeg',408),(1990,'DSCN4521.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xB/5125261f75f25/DSCN4521.jpeg',408),(1991,'DSCN4524.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xB/5125263503c56/DSCN4524.jpeg',408),(1992,'1_Curb_Payton_new.jpeg','header',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xA/512524aec501d/1_Curb_Payton_new.jpeg',409),(1993,'2_Kit_glass_3429_Payton.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xA/512524b22a3e8/2_Kit_glass_3429_Payton.jpeg',409),(1994,'5_Stove_payton.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xA/512524b526097/5_Stove_payton.jpeg',409),(1995,'7_BR_Payton.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xA/512524bc3c371/7_BR_Payton.jpeg',409),(1996,'7_Payton_Din_rm.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xA/512524bf789e9/7_Payton_Din_rm.jpeg',409),(1997,'8_Glass_tile_close_kit.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xA/512524c353b62/8_Glass_tile_close_kit.jpeg',409),(1998,'8_Payton_3429_2nd_bath.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xA/512524c7687a6/8_Payton_3429_2nd_bath.jpeg',409),(1999,'11_BR.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xA/512524cb0bb59/11_BR.jpeg',409),(2000,'1_Curb_new.jpeg','header',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x8/513637714ec02/1_Curb_new.jpeg',410),(2001,'5_garage.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x8/513637f6e853c/5_garage.jpeg',410),(2002,'1_Curb_Lindley_1404.jpeg','header',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x6/51252203de6d9/1_Curb_Lindley_1404.jpeg',411),(2003,'2_Liv_rm_lindley.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x6/51252207989dc/2_Liv_rm_lindley.jpeg',411),(2004,'3_Bedroom_lindley_1404.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x6/5125220a56a64/3_Bedroom_lindley_1404.jpeg',411),(2005,'3_Kitchen_Lindley.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x6/5125220d879d1/3_Kitchen_Lindley.jpeg',411),(2006,'4_Lindley_Bath.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x6/51252210c31df/4_Lindley_Bath.jpeg',411),(2007,'5_Bedroom_Lindley_1404.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x6/512522138ea4f/5_Bedroom_Lindley_1404.jpeg',411),(2008,'6_Bedr_2_Lindley_1404.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x6/51252216754a7/6_Bedr_2_Lindley_1404.jpeg',411),(2009,'Ritter_Exteriors_old_124.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x6/5125221dae163/Ritter_Exteriors_old_124.jpeg',411),(2010,'Ritter_Exteriors_old_131.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x6/512522215189a/Ritter_Exteriors_old_131.jpeg',411),(2011,'Ritter_Exteriors_Sold_128.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x6/51252233af329/Ritter_Exteriors_Sold_128.jpeg',411),(2012,'1_curb_jamie_ct_mar_11_012.jpeg','header',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x4/5125212ecb47b/1_curb_jamie_ct_mar_11_012.jpeg',412),(2013,'2_Rear_jamie_ct_mar_11_013.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x4/512521326f424/2_Rear_jamie_ct_mar_11_013.jpeg',412),(2014,'1.5_Kit_jamie_ct_mar_11_020.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x4/5125212820259/1.5_Kit_jamie_ct_mar_11_020.jpeg',412),(2015,'1.75_kit_jamie_ct.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x4/5125212b610d8/1.75_kit_jamie_ct.jpeg',412),(2016,'3_rear_jamie_ct_mar_11_015.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x4/51252136e91e3/3_rear_jamie_ct_mar_11_015.jpeg',412),(2017,'4_Fam_rm_jamie_ct_mar_11_023.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x4/5125213a913bf/4_Fam_rm_jamie_ct_mar_11_023.jpeg',412),(2018,'5_util_rm_jamie_ct_mar_11_025.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x4/5125213d6dc0d/5_util_rm_jamie_ct_mar_11_025.jpeg',412),(2019,'6_2nd_bath_jamie_ct_mar_11_026.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x4/5125214042057/6_2nd_bath_jamie_ct_mar_11_026.jpeg',412),(2020,'7_Din_rm_jamie_ct_mar_11_027.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x4/5125214311105/7_Din_rm_jamie_ct_mar_11_027.jpeg',412),(2021,'8_Bedrm_jamie_ct_mar_11_029.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x4/51252145b81f4/8_Bedrm_jamie_ct_mar_11_029.jpeg',412),(2022,'9_1st_bath_jamie_ct_mar_11_031.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x4/51252148965b7/9_1st_bath_jamie_ct_mar_11_031.jpeg',412),(2023,'11_liv_rm_jamie_ct_mar_11_034.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x4/5125214e03f20/11_liv_rm_jamie_ct_mar_11_034.jpeg',412),(2024,'12_garage_jamie_ct.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x4/51252150cd6a7/12_garage_jamie_ct.jpeg',412),(2025,'13_Master_br_jamie_ct_mar_11_030.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x4/5125215507e81/13_Master_br_jamie_ct_mar_11_030.jpeg',412),(2026,'1_Curb_Foltz_new.jpeg','header',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x2/51252093085d1/1_Curb_Foltz_new.jpeg',413),(2027,'2_Liv_rm_foltz_new.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x2/512520962e785/2_Liv_rm_foltz_new.jpeg',413),(2028,'3_Bath_Foltz.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x2/51252098de3ae/3_Bath_Foltz.jpeg',413),(2029,'5_Foltz_laundry.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x2/5125209ee7256/5_Foltz_laundry.jpeg',413),(2030,'4_Kit_Foltz.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x2/5125209c3623e/4_Kit_Foltz.jpeg',413),(2031,'6_Foltz_bath.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x2/512520a1db811/6_Foltz_bath.jpeg',413),(2032,'7_Foltz_brm.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x2/512520a4f0776/7_Foltz_brm.jpeg',413),(2033,'8_Foltz_office-4th_br.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x2/512520a7dbebf/8_Foltz_office-4th_br.jpeg',413),(2034,'9Foltz_3rd_BR.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x2/512520aab312f/9Foltz_3rd_BR.jpeg',413),(2035,'10_Foltz_forth_br.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x2/512520ad73a5d/10_Foltz_forth_br.jpeg',413),(2036,'1_Curb_Dearborn_3818.jpeg','header',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x1/512511cba8b60/1_Curb_Dearborn_3818.jpeg',414),(2037,'3_LR_new.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x1/51251212d39fd/3_LR_new.jpeg',414),(2038,'4 Bath dearborn 3818.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x1/512512188610a/4 Bath dearborn 3818.jpeg',414),(2039,'5_fam_rm_dearborn.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x1/51251220e5b72/5_fam_rm_dearborn.jpeg',414),(2040,'6 _iv_rm_dearborn.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x1/51251227006fa/6 _iv_rm_dearborn.jpeg',414),(2041,'8_Bedrm_dearborn.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x1/51251232cbdd7/8_Bedrm_dearborn.jpeg',414),(2042,'9_Bedrm_3rd_dearborn.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x1/5125123b2d594/9_Bedrm_3rd_dearborn.jpeg',414),(2043,'10_Bedrm_master_dearborn.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x1/5125123fcfae4/10_Bedrm_master_dearborn.jpeg',414),(2044,'7_util_rm_dearborn.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x1/5125122bdd6da/7_util_rm_dearborn.jpeg',414),(2045,'1_Curb_Worth_1023.jpeg','header',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x0/51251fa9bcd58/1_Curb_Worth_1023.jpeg',415),(2046,'2_Liv_rm_1023.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x0/51251fb944bbb/2_Liv_rm_1023.jpeg',415),(2047,'3_Kith_worth_1023.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x0/51251fc0b40e7/3_Kith_worth_1023.jpeg',415),(2048,'4_bath_worth_1023.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x0/51251fcca6cb4/4_bath_worth_1023.jpeg',415),(2049,'5_Bath_Beecher_1023.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x0/51251fd5794ff/5_Bath_Beecher_1023.jpeg',415),(2050,'6_BR_Beecher_1023.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x0/51251fdd23e48/6_BR_Beecher_1023.jpeg',415),(2051,'7_BR_Beecher_1023.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x0/51251fe712089/7_BR_Beecher_1023.jpeg',415),(2052,'Ritter Exteriors Sold 108.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x0/5125200896f10/Ritter Exteriors Sold 108.jpeg',415),(2053,'849_south_worth.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000003uR24/510fe78e31bd6/849_south_worth.jpeg',416),(2054,'3351_north_butler.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000003uR25/510fe7e10fae6/3351_north_butler.jpeg',417),(2055,'3025_alice.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000003uR27/510fe9b42f2e5/3025_alice.jpeg',418),(2056,'7756_Mountain_Stream_Way_front.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000003uR26/510fe834b6bec/7756_Mountain_Stream_Way_front.jpeg',419),(2057,'7756_Mountain_Stream_Way_back.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000003uR26/510fe831eca71/7756_Mountain_Stream_Way_back.jpeg',419),(2058,'1405 17th front.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000003SaoY/50f4a2b41a44b/1405 17th front.jpeg',420),(2059,'Scatterwood_1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000003Saoc/50f4a3783cc08/Scatterwood_1.jpeg',421),(2060,'Front1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE00000035X7Y/50de14fba3ed6/Front1.jpeg',422),(2061,'front2.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE00000035X7Y/50de1502155c4/front2.jpeg',422),(2062,'side1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE00000035X7Y/50de1534391d2/side1.jpeg',422),(2063,'porch.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE00000035X7Y/50de152dcd848/porch.jpeg',422),(2064,'backyard1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE00000035X7Y/50de14da70bff/backyard1.jpeg',422),(2065,'backyard2.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE00000035X7Y/50de14e0cf748/backyard2.jpeg',422),(2066,'dining.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE00000035X7Y/50de14f00d1fd/dining.jpeg',422),(2067,'kitchen1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE00000035X7Y/50de1512c004f/kitchen1.jpeg',422),(2068,'living2.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE00000035X7Y/50de1518a2f06/living2.jpeg',422),(2069,'coveredpatio.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE00000035X7Y/50de14eb35bf6/coveredpatio.jpeg',422),(2070,'bath2.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE00000035X7Y/50de14e60ab1a/bath2.jpeg',422),(2071,'waterheater.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE00000035X7Y/50de154def6fd/waterheater.jpeg',422),(2072,'DSC_0711 (1024x681).jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE000000357Zr/50cf95d0cc4a4/DSC_0711 (1024x681).jpeg',423),(2073,'6530_pike_view.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE000000357Zs/50cf956491555/6530 pike view.jpeg',424),(2074,'main.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002lmvW/50bcd9e93b136/main.jpeg',425),(2075,'Left_Side.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002lmvX/50bcdcc0a1665/Left_Side.jpeg',426),(2076,'212_Mettler_8-2011_completed_work_002.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002lmvX/50bcdc6769281/212_Mettler_8-2011_completed_work_002.jpeg',426),(2077,'212_Mettler_8-2011_completed_work_003.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002lmvX/50bcdc6bd2b67/212_Mettler_8-2011_completed_work_003.jpeg',426),(2078,'212_Mettler_8-2011_completed_work_007.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002lmvX/50bcdc6ff41d7/212_Mettler_8-2011_completed_work_007.jpeg',426),(2079,'212_Mettler 8-2011_completed_work_012.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002lmvX/50bcdc742db05/212_Mettler 8-2011_completed_work_012.jpeg',426),(2080,'212_Mettler_8-2011_completed_work_016.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002lmvX/50bcdc812128e/212_Mettler_8-2011_completed_work_016.jpeg',426),(2081,'Right_Side_2.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002lmvX/50bcdccb00477/Right_Side_2.jpeg',426),(2082,'212_Mettler_8-2011_completed_work_038.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002lmvX/50bcdca0a7340/212_Mettler_8-2011_completed_work_038.jpeg',426),(2083,'Address.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002lmvX/50bcdcaa1c3e5/Address.jpeg',426),(2084,'Right_Side.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002lmvX/50bcdcd3cc84c/Right_Side.jpeg',426),(2085,'Front.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002lmvX/50bcdcb58999e/Front.jpeg',426),(2086,'212_Mettler_8-2011_completed_work_018.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002lmvX/50bcdc858877e/212_Mettler_8-2011_completed_work_018.jpeg',426),(2087,'3349_Winton_Ave_12.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002dI0u/50a5bc7fa244f/3349_Winton_Ave_12.jpeg',427),(2088,'3349_Winton_Ave_11.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002dI0u/50a5bc9006371/3349_Winton_Ave_11.jpeg',427),(2089,'3349_Winton_Ave_1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002dI0u/50a5bc9d46536/3349_Winton_Ave_1.jpeg',427),(2090,'3349_Winton_Ave_3.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002dI0u/50a5bccf8eb81/3349_Winton_Ave_3.jpeg',427),(2091,'3349_Winton_Ave_4.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002dI0u/50a5bcd2461bd/3349_Winton_Ave_4.jpeg',427),(2092,'3525_Payton_Ave_1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002dI0v/50a5bd28c4f32/3525 Payton_Ave_1.jpeg',428),(2093,'3525_Payton_Ave_5.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002dI0v/50a5bd2bd68f6/3525 Payton_Ave_5.jpeg',428),(2094,'3525_Payton_Ave_6.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002dI0v/50a5bd2e460c4/3525 Payton_Ave_6.jpeg',428),(2095,'3525_Payton_Ave_7.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002dI0v/50a5bd30b41ce/3525 Payton_Ave_7.jpeg',428),(2096,'3525_Payton_Ave_8.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002dI0v/50a5bd3339ccb/3525 Payton_Ave_8.jpeg',428),(2097,'3525_Payton_Ave_2.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002dI0v/50a5bd3600882/3525_Payton_Ave_2.jpeg',428),(2098,'3525_Payton_Ave_3.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002dI0v/50a5bd387fa7d/3525_Payton_Ave_3.jpeg',428),(2099,'3525_Payton_Ave_4.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002dI0v/50a5bd3b15f39/3525_Payton_Ave_4.jpeg',428),(2100,'4900_Ave_N_2.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002ZtGb/50984b2d3ecd4/4900_Ave_N_2.jpeg',429),(2101,'4900_Ave_N_1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002ZtGb/50984b277f435/4900_Ave_N_1.jpeg',429),(2102,'4900_Ave_N_3.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002ZtGb/50984b33e8bc6/4900_Ave_N_3.jpeg',429),(2103,'1644_30th_Ensley_1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002ZtGc/50984acc23f03/1644_30th_Ensley_1.jpeg',430),(2104,'1644_30th_Ensley_2.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002ZtGc/50984ad1ecbee/1644_30th_Ensley_2.jpeg',430),(2105,'1644_30th_Ensley_3.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002ZtGc/50984ad758fd7/1644_30th_Ensley_3.jpeg',430),(2106,'SAM_0599.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002ZtGd/50984a4af1e0a/SAM_0599.jpeg',431),(2107,'SAM_0600.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002ZtGd/50984a5297433/SAM_0600.jpeg',431),(2108,'SAM_0601.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002ZtGd/50984a5a1db94/SAM_0601.jpeg',431),(2109,'SAM_0602.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002ZtGd/50984a618ab76/SAM_0602.jpeg',431),(2110,'SAM_0603.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002ZtGd/50984a68ef9e0/SAM_0603.jpeg',431),(2111,'SAM_0604.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002ZtGd/50984a700a64d/SAM_0604.jpeg',431),(2112,'SAM_0606.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002ZtGd/50984a77870f5/SAM_0606.jpeg',431),(2113,'SAM_0607.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002ZtGd/50984a7eb84f0/SAM_0607.jpeg',431),(2114,'Lesley.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002MvpC/508816361457c/Lesley.jpeg',432),(2115,'4993_Beatrice.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002GqN9/5085bd80b4734/4993_Beatrice.jpeg',433),(2116,'1521_33rd_Ensley_1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001Q437/506e022dd8209/1521_33rd_Ensley_1.jpeg',434),(2117,'1521_33rd_Ensley_2.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001Q437/506e023414205/1521_33rd_Ensley_2.jpeg',434),(2118,'1521_33rd_Ensley_3.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001Q437/506e023a838fa/1521_33rd_Ensley_3.jpeg',434),(2119,'1521_33rd_Ensley_4.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001Q437/506e02403a8a1/1521_33rd_Ensley_4.jpeg',434),(2120,'218_Vann_1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSW/5061f9dea914f/218_Vann_1.jpeg',435),(2121,'1441_Warrior_1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSX/5061fc8e7e8bf/1441_Warrior_1.jpeg',436),(2122,'1328_Ensley_1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSZ/5061faa621237/1328_Ensley_1.jpeg',437),(2123,'1401_46th_1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSY/5061fc0711686/1401_46th_1.jpeg',438),(2124,'1341_44th_1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSa/5061fb807b999/1341_44th_1.jpeg',439),(2125,'4708_CourtO_4.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSc/5069d87dd964f/4708_CourtO_4.jpeg',440),(2126,'4708_CourtO_1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSc/5069d8724e1ca/4708_CourtO_1.jpeg',440),(2127,'4708_CourtO_2.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSc/5069d87652b39/4708_CourtO_2.jpeg',440),(2128,'4708_CourtO_3.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSc/5069d87a2bcf9/4708_CourtO_3.jpeg',440),(2129,'4708_CourtO_5.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSc/5069d881a9c5b/4708_CourtO_5.jpeg',440),(2130,'4708_CourtO_6.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSc/5069d885a5231/4708_CourtO_6.jpeg',440),(2131,'4708_CourtO_7.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSc/5069d88962431/4708_CourtO_7.jpeg',440),(2132,'4708_CourtO_8.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSc/5069d88cb9416/4708_CourtO_8.jpeg',440),(2133,'4708_CourtO_9.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSc/5069d8912726c/4708_CourtO_9.jpeg',440),(2134,'5913_Ave_M_2.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSf/5061f55792f61/5913_Ave_M_2.jpeg',441),(2135,'5913_Ave_M_1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSf/5061f54673392/5913_Ave_M_1.jpeg',441),(2136,'2031_Center_1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSg/5061f5abac0d7/2031_Center_1.jpeg',442),(2137,'5900_Ave_M_1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSe/5061f50de5d84/5900_Ave_M_1.jpeg',443),(2138,'Main.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSb/5061f296c8215/Main.jpeg',444),(2139,'DSC_0582.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5G/504a4ed34cedc/DSC_0582.jpeg',445),(2140,'DSCN7697.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5G/504a4ed9d922f/DSCN7697.jpeg',445),(2141,'DSCN7700.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5G/504a4edcbcab5/DSCN7700.jpeg',445),(2142,'DSCN7701.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5G/504a4edfd48f4/DSCN7701.jpeg',445),(2143,'4138_Breton_1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5H/506ca0467402b/4138_Breton_1.jpeg',446),(2144,'4138_Breton_2.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5H/506ca04ba2e1d/4138_Breton_2.jpeg',446),(2145,'4138_Breton_5.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5H/506ca05ac2420/4138_Breton_5.jpeg',446),(2146,'4138_Breton_4.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5H/506ca0556d906/4138_Breton_4.jpeg',446),(2147,'DSC_0249.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5I/50635b2663934/DSC_0249.jpeg',447),(2148,'DSC_0719.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5I/50635b2bc13c9/DSC_0719.jpeg',447),(2149,'DSC_0724.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5I/50635b2ff2e31/DSC_0724.jpeg',447),(2150,'DSC_0729.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5I/50635b33e1c49/DSC_0729.jpeg',447),(2151,'DSC_0732.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5I/50635b392986c/DSC_0732.jpeg',447),(2152,'DSC_0734.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5I/50635b3cb4dff/DSC_0734.jpeg',447),(2153,'Truman.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5V/504a47863e307/Truman.jpeg',448),(2154,'Jackson_1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5W/50649e1adb952/Jackson_1.jpeg',449),(2155,'Jackson_6.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5W/50649e355f6b3/Jackson_6.jpeg',449),(2156,'Jackson_7.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5W/50649e39490b5/Jackson_7.jpeg',449),(2157,'Jackson_8.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5W/50649e3d05749/Jackson_8.jpeg',449),(2158,'Jackson_12.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5W/50649e5233b77/Jackson_12.jpeg',449),(2159,'Jackson_13.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5W/50649e57a1aea/Jackson_13.jpeg',449),(2160,'Garfield.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5X/506e0f4fc9234/Garfield.jpeg',450),(2161,'Hardesty.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5Y/506e0e3112e6b/Hardesty.jpeg',451),(2162,'Picture1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5Z/504a5f02a2539/Picture1.jpeg',452),(2163,'Picture2.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5Z/504a5f0696f59/Picture2.jpeg',452),(2164,'Picture4.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5Z/504a5f0d9a552/Picture4.jpeg',452),(2165,'Picture6.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5Z/504a5f1119b92/Picture6.jpeg',452),(2166,'Picture3.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5Z/504a5f0a37bce/Picture3.jpeg',452),(2167,'Picture7.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5Z/504a5f15545f1/Picture7.jpeg',452),(2168,'DSCN1669.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5c/50634dfa1606d/DSCN1669.jpeg',453),(2169,'DSCN1673.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5c/50634dfde9426/DSCN1673.jpeg',453),(2170,'DSCN1674.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5c/50634e0184a57/DSCN1674.jpeg',453),(2171,'DSCN1680.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5c/50634e0bd3100/DSCN1680.jpeg',453),(2172,'DSCN1682.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5c/50634e0ef3677/DSCN1682.jpeg',453),(2173,'DSCN1683.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5c/50634e1284c5f/DSCN1683.jpeg',453),(2174,'DSCN1684.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5c/50634e15626d1/DSCN1684.jpeg',453),(2175,'DSCN1685.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5c/50634e183dee9/DSCN1685.jpeg',453),(2176,'DSCN1702.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5c/50634e4bb130c/DSCN1702.jpeg',453),(2177,'2012-08-22_10-47-06_952.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5e/504a4ba9dc821/2012-08-22_10-47-06_952.jpeg',454),(2178,'2012-08-22_10-44-26_738.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5e/504a4b927e22d/2012-08-22_10-44-26_738.jpeg',454),(2179,'2012-08-22_10-44-46_266.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5e/504a4b9a1dc27/2012-08-22_10-44-46_266.jpeg',454),(2180,'2012-08-22_10-42-40_489.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5e/504a4b7564206/2012-08-22_10-42-40_489.jpeg',454),(2181,'2012-08-22_10-42-56_498.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5e/504a4b7b87bf1/2012-08-22_10-42-56_498.jpeg',454),(2182,'DSC_0093.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5f/504a537ce2786/DSC_0093.jpeg',455);
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
-- Table structure for table `STATE_CITY`
--

DROP TABLE IF EXISTS `STATE_CITY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `STATE_CITY` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `STATE` varchar(45) NOT NULL,
  `CITY` varchar(45) NOT NULL,
  `SUMMARY` varchar(255) DEFAULT NULL,
  `IMAGE_URL` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UDX1` (`STATE`,`CITY`)
) ENGINE=InnoDB AUTO_INCREMENT=321 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `STATE_CITY`
--

LOCK TABLES `STATE_CITY` WRITE;
/*!40000 ALTER TABLE `STATE_CITY` DISABLE KEYS */;
INSERT INTO `STATE_CITY` VALUES (257,'OH','COLUMBUS','na','na'),(261,'IN','INDIANAPOLIS','na','na'),(285,'AL','BIRMINGHAM','na','na'),(287,'OH','TOLEDO','na','na'),(313,'MO','KANSAS CITY','na','na'),(319,'AL','BESSEMER','na','na');
/*!40000 ALTER TABLE `STATE_CITY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `STATE_CITY_DETAIL`
--

DROP TABLE IF EXISTS `STATE_CITY_DETAIL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `STATE_CITY_DETAIL` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SUMMARY` varchar(255) NOT NULL,
  `IMAGE_URL` varchar(150) NOT NULL,
  `STATE_INFO_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_STATE_CITY_DETAIL_STATE_INFO1_idx` (`STATE_INFO_ID`),
  CONSTRAINT `fk_STATE_CITY_DETAIL_STATE_INFO1` FOREIGN KEY (`STATE_INFO_ID`) REFERENCES `STATE_INFO` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `STATE_CITY_DETAIL`
--

LOCK TABLES `STATE_CITY_DETAIL` WRITE;
/*!40000 ALTER TABLE `STATE_CITY_DETAIL` DISABLE KEYS */;
/*!40000 ALTER TABLE `STATE_CITY_DETAIL` ENABLE KEYS */;
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
/*!40000 ALTER TABLE `STATE_INFO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SYSTEM_ROLES`
--

DROP TABLE IF EXISTS `SYSTEM_ROLES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SYSTEM_ROLES` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ROLE` varchar(45) DEFAULT NULL,
  `ENABLED` tinyint(4) NOT NULL DEFAULT '0',
  `CRE_USER_ID` int(11) DEFAULT NULL,
  `CRE_DTM` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SYSTEM_ROLES`
--

LOCK TABLES `SYSTEM_ROLES` WRITE;
/*!40000 ALTER TABLE `SYSTEM_ROLES` DISABLE KEYS */;
INSERT INTO `SYSTEM_ROLES` VALUES (1,'Administrator',1,1,'2013-04-23 00:00:00'),(2,'Users',1,1,'2013-04-23 00:00:00');
/*!40000 ALTER TABLE `SYSTEM_ROLES` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USERS`
--

LOCK TABLES `USERS` WRITE;
/*!40000 ALTER TABLE `USERS` DISABLE KEYS */;
INSERT INTO `USERS` VALUES (1,'mcoletti',1,1,'2013-04-23 00:00:00');
/*!40000 ALTER TABLE `USERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ZIP_CODES`
--

DROP TABLE IF EXISTS `ZIP_CODES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ZIP_CODES` (
  `ZIP_CODE` int(11) NOT NULL,
  `STATE_CITY_ID` int(11) NOT NULL,
  PRIMARY KEY (`ZIP_CODE`),
  KEY `fk_ZIP_CODES_STATE_CITY1_idx` (`STATE_CITY_ID`),
  CONSTRAINT `fk_ZIP_CODES_STATE_CITY1` FOREIGN KEY (`STATE_CITY_ID`) REFERENCES `STATE_CITY` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ZIP_CODES`
--

LOCK TABLES `ZIP_CODES` WRITE;
/*!40000 ALTER TABLE `ZIP_CODES` DISABLE KEYS */;
INSERT INTO `ZIP_CODES` VALUES (43205,257),(43227,257),(46201,261),(46203,261),(46208,261),(46218,261),(46221,261),(46222,261),(46224,261),(46226,261),(46237,261),(46239,261),(46241,261),(46254,261),(46268,261),(35205,285),(35206,285),(35208,285),(35211,285),(35228,285),(43608,287),(43609,287),(43610,287),(64126,313),(64127,313),(35023,319);
/*!40000 ALTER TABLE `ZIP_CODES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `vw_Customers`
--

DROP TABLE IF EXISTS `vw_Customers`;
/*!50001 DROP VIEW IF EXISTS `vw_Customers`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vw_Customers` (
  `ID` int(11),
  `UUID` char(36),
  `CUST_NAME` varchar(45),
  `ENABLED` tinyint(4)
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

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
  `DESCRIPTION` varchar(2000),
  `NUM_BEDS` float,
  `NUM_BATHS` float,
  `TYPE` varchar(45),
  `STATUS` varchar(45),
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
  `PROPERTY_DATA_UUID` char(36),
  `PF_VALUE` decimal(6,2),
  `PF_KEY` varchar(75),
  `FINACIAL_KEY_ID` int(11)
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
  `TYPE` varchar(45),
  `URL` varchar(150),
  `PROPERTY_DATA_ID` int(11)
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vw_stateCityInfo`
--

DROP TABLE IF EXISTS `vw_stateCityInfo`;
/*!50001 DROP VIEW IF EXISTS `vw_stateCityInfo`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vw_stateCityInfo` (
  `ID` int(11),
  `STATE` varchar(45),
  `CITY` varchar(45),
  `SUMMARY` varchar(255),
  `IMAGE_URL` varchar(150),
  `ZIP_CODE` int(11)
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Dumping routines for database 'TALONDB'
--
/*!50003 DROP PROCEDURE IF EXISTS `pr_CleanPropertyImageData` */;
ALTER DATABASE `TALONDB` CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
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
ALTER DATABASE `TALONDB` CHARACTER SET utf8 COLLATE utf8_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `pr_GetCustomers` */;
ALTER DATABASE `TALONDB` CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `pr_GetCustomers`(IN filterValue VARCHAR(45),IN filterBy VARCHAR(45))
BEGIN
CASE filterBy
	WHEN "customerName" THEN
		SELECT 
		`vw_Customers`.*
		FROM `TALONDB`.`vw_Customers` WHERE CUST_NAME = filterValue;
	WHEN "uniqueId" THEN
		SELECT 
		`vw_Customers`.*
		FROM `TALONDB`.`vw_Customers` WHERE UUID = filterValue;
	WHEN "none" THEN
		SELECT 
		`vw_Customers`.*
		FROM `TALONDB`.`vw_Customers`;
END CASE;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `TALONDB` CHARACTER SET utf8 COLLATE utf8_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `pr_GetPropertyData` */;
ALTER DATABASE `TALONDB` CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
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
ALTER DATABASE `TALONDB` CHARACTER SET utf8 COLLATE utf8_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `pr_GetPropertyFinancialData` */;
ALTER DATABASE `TALONDB` CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
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
ALTER DATABASE `TALONDB` CHARACTER SET utf8 COLLATE utf8_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `pr_GetPropertyImageData` */;
ALTER DATABASE `TALONDB` CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
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
ALTER DATABASE `TALONDB` CHARACTER SET utf8 COLLATE utf8_general_ci ;

--
-- Final view structure for view `vw_Customers`
--

/*!50001 DROP TABLE IF EXISTS `vw_Customers`*/;
/*!50001 DROP VIEW IF EXISTS `vw_Customers`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_Customers` AS select `CUSTOMER`.`ID` AS `ID`,`CUSTOMER`.`UUID` AS `UUID`,`CUSTOMER`.`CUST_NAME` AS `CUST_NAME`,`CUSTOMER`.`ENABLED` AS `ENABLED` from `CUSTOMER` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

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
/*!50001 VIEW `vw_PropertyFeed` AS select `p`.`ID` AS `ID`,`p`.`UUID` AS `UUID`,`p`.`PROP_NAME` AS `PROP_NAME`,`p`.`PRICE` AS `PRICE`,`p`.`SQFT` AS `SQFT`,`p`.`DESCRIPTION` AS `DESCRIPTION`,`p`.`NUM_BEDS` AS `NUM_BEDS`,`p`.`NUM_BATHS` AS `NUM_BATHS`,`p`.`TYPE` AS `TYPE`,`p`.`STATUS` AS `STATUS`,`p`.`DATA_SOURCE_ID` AS `DATA_SOURCE_ID`,`d`.`CUST_UUID` AS `CUST_UUID`,`d`.`NAME` AS `DATASOURCE`,`s`.`STATE` AS `STATE`,`s`.`CITY` AS `CITY`,`s`.`ZIP_CODE` AS `ZIP` from ((`PROPERTY_DATA` `p` join `DATA_SOURCE` `d`) join `vw_stateCityInfo` `s`) where ((`p`.`DATA_SOURCE_ID` = `d`.`ID`) and (`p`.`ZIP_CODE` = `s`.`ZIP_CODE`)) */;
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
/*!50001 VIEW `vw_propertyFinacials` AS select `pf`.`ID` AS `ID`,`pf`.`PROPERTY_DATA_UUID` AS `PROPERTY_DATA_UUID`,`pf`.`VALUE` AS `PF_VALUE`,`fk`.`KEY` AS `PF_KEY`,`pf`.`FINACIAL_KEY_ID` AS `FINACIAL_KEY_ID` from (`PROPERTY_FINACIAL` `pf` join `FINACIAL_KEY` `fk`) where (`pf`.`FINACIAL_KEY_ID` = `fk`.`ID`) */;
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
/*!50001 VIEW `vw_propertyImages` AS select `i`.`ID` AS `ID`,`i`.`TITLE` AS `TITLE`,`i`.`TYPE` AS `TYPE`,`i`.`SRC_URL` AS `URL`,`i`.`PROPERTY_DATA_ID` AS `PROPERTY_DATA_ID` from `PROPERTY_IMAGES` `i` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_stateCityInfo`
--

/*!50001 DROP TABLE IF EXISTS `vw_stateCityInfo`*/;
/*!50001 DROP VIEW IF EXISTS `vw_stateCityInfo`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_stateCityInfo` AS select `sc`.`ID` AS `ID`,`sc`.`STATE` AS `STATE`,`sc`.`CITY` AS `CITY`,`sc`.`SUMMARY` AS `SUMMARY`,`sc`.`IMAGE_URL` AS `IMAGE_URL`,`z`.`ZIP_CODE` AS `ZIP_CODE` from (`STATE_CITY` `sc` join `ZIP_CODES` `z`) where (`sc`.`ID` = `z`.`STATE_CITY_ID`) */;
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

-- Dump completed on 2013-05-21  6:56:28
