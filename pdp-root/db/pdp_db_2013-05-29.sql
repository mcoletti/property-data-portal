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
  `ENABLED` tinyint(4) NOT NULL DEFAULT '0',
  `API_URL` varchar(255) NOT NULL,
  `API__AUTH_TOKEN` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
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
-- Table structure for table `CITY`
--

DROP TABLE IF EXISTS `CITY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CITY` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CITY` varchar(150) NOT NULL,
  `SUMMARY` text,
  `IMAGE_URL` varchar(150) DEFAULT NULL,
  `STATE_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `CITY_UNIQUE` (`CITY`),
  KEY `fk_CITY_STATE1_idx` (`STATE_ID`),
  CONSTRAINT `fk_CITY_STATE1` FOREIGN KEY (`STATE_ID`) REFERENCES `STATE` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CITY`
--

LOCK TABLES `CITY` WRITE;
/*!40000 ALTER TABLE `CITY` DISABLE KEYS */;
INSERT INTO `CITY` VALUES (1,'COLUMBUS','Columbus, Ohio has a generally strong and diverse economy based on education, insurance, banking, fashion, defense, aviation, food, logistics, steel, energy, medical research, health care, hospitality, retail, and technology. Overall, it was ranked as one of the top 10 best big cities in the country in 2010, according to Relocate America, a real estate research firm.  MarketWatch ranked Columbus and its metro area as the No. 7 best place in the country to operate a business in 2008.  In 2007, the cityName was ranked No. 3 in the United States by fDi magazine for “Cities of the Future”, and No. 4 for most business-friendly in the country. Columbus was ranked as the seventh strongest economy in the United States in 2006, and the best in Ohio, according to Policom Corp. In 2011, the Columbus metropolitan area’s GDP was $94.7 billion, up from $90 billion in 2009, up from $85.5 billion in 2006, $75.43 billion in 2005, and $69.98 billion in 2001.','columbus.jpg',1),(7,'INDIANAPOLIS','Kansas City, Missouri may seem to be well deserving of its “cow-town” reputation.  After all, historically speaking, Kansas City grew up out of the prosperity created by the local cattle markets strategically located at the crossroads of key national rail lines.  However, any local will tell you that it would be a mistake to reduce Kansas City to a stagnant creature of its historical origins.','indy.png',8),(35,'TOLEDO','Toledo, Ohio  is the fourth most populous cityName in the U.S. stateName of Ohio and is the county seat of Lucas County. Toledo is in northwest Ohio, located on the Maumee River on the western end of Lake Erie, and borders the State of Michigan.  It is one of the most productive Ports on the Great Lakes/St. Lawrence Seaway, and is a designated Foreign Trade Zone area. The Port of Toledo handles coal, ore, general cargo, and ship repairs, as well as having storage for over 22 million bushels of grain for export. The diverse architecture of Toledo rivals larger cities like Chicago. It is also home to Libby Glass, the founders of which had a tremendously positive influence on the amenities of the City.','toledo.jpg',1),(42,'BIRMINGHAM','Birmingham, Alabama is a municipal corporation under the laws of the State of Alabama. Birmingham is the largest cityName in the stateName with a population currently estimated at 242,820, and a metro population of 1,079,089.','birmingham.png',36),(61,'KANSAS CITY','Kansas City, Missouri may seem to be well deserving of its “cow-town” reputation.  After all, historically speaking, Kansas City grew up out of the prosperity created by the local cattle markets strategically located at the crossroads of key national rail lines.  However, any local will tell you that it would be a mistake to reduce Kansas City to a stagnant creature of its historical origins.','kansascity.png',64),(66,'BESSEMER','na','na',36);
/*!40000 ALTER TABLE `CITY` ENABLE KEYS */;
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
  `FULL_NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UUID_UNIQUE` (`UUID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CUSTOMER`
--

LOCK TABLES `CUSTOMER` WRITE;
/*!40000 ALTER TABLE `CUSTOMER` DISABLE KEYS */;
INSERT INTO `CUSTOMER` VALUES (1,'a4e62a00-c217-11e2-8b8b-0800200c9a66','slvrstream',1,NULL);
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
  CONSTRAINT `fk_DYNAMIC_DATA_RAW_DATA1` FOREIGN KEY (`RAW_DATA_ID`) REFERENCES `RAW_DATA` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_DYNAMIC_DATA_DATA_TYPE1` FOREIGN KEY (`DATA_TYPE_ID`) REFERENCES `DATA_TYPE` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_CUSTOM_DATA_PROPERTY_DATA1` FOREIGN KEY (`PROPERTY_DATA_UUID`) REFERENCES `PROPERTY_DATA` (`UUID`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
  CONSTRAINT `fk_DS_DATA_DATA_TYPE1` FOREIGN KEY (`DATA_TYPE_ID`) REFERENCES `DATA_TYPE` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_DS_DATA_CUSTOMER_DS1` FOREIGN KEY (`CUSTOMER_DS_ID`) REFERENCES `CUSTOMER_CUSTOM_DATA_SET` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
INSERT INTO `DATA_SOURCE` VALUES (1,'Property Base','a4e62a00-c217-11e2-8b8b-0800200c9a66');
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
-- Table structure for table `ETL_CONFIG_KEYS`
--

DROP TABLE IF EXISTS `ETL_CONFIG_KEYS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ETL_CONFIG_KEYS` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `KEY` varchar(75) NOT NULL,
  `VALUE` text NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ETL_CONFIG_KEYS`
--

LOCK TABLES `ETL_CONFIG_KEYS` WRITE;
/*!40000 ALTER TABLE `ETL_CONFIG_KEYS` DISABLE KEYS */;
/*!40000 ALTER TABLE `ETL_CONFIG_KEYS` ENABLE KEYS */;
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
  `CUST_UUID` char(36) NOT NULL,
  `CRE_USER_UUID` char(36) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `JOB_NAME_UNIQUE` (`JOB_NAME`),
  UNIQUE KEY `UDX1` (`JOB_NAME`,`CUST_UUID`)
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
-- Table structure for table `ETL_JOB_CONFIG_MAP`
--

DROP TABLE IF EXISTS `ETL_JOB_CONFIG_MAP`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ETL_JOB_CONFIG_MAP` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ETL_JOB_ID` int(11) NOT NULL,
  `ETL_JOB_CONFIG_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_ETL_JOB_PROP_MAP_ETL_JOB1_idx` (`ETL_JOB_ID`),
  KEY `fk_ETL_JOB_PROP_MAP_ETL_JOB_PROPERTIES1_idx` (`ETL_JOB_CONFIG_ID`),
  CONSTRAINT `fk_ETL_JOB_PROP_MAP_ETL_JOB1` FOREIGN KEY (`ETL_JOB_ID`) REFERENCES `ETL_JOB` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ETL_JOB_PROP_MAP_ETL_JOB_PROPERTIES1` FOREIGN KEY (`ETL_JOB_CONFIG_ID`) REFERENCES `ETL_CONFIG_KEYS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ETL_JOB_CONFIG_MAP`
--

LOCK TABLES `ETL_JOB_CONFIG_MAP` WRITE;
/*!40000 ALTER TABLE `ETL_JOB_CONFIG_MAP` DISABLE KEYS */;
/*!40000 ALTER TABLE `ETL_JOB_CONFIG_MAP` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ETL_JOB_LOG`
--

DROP TABLE IF EXISTS `ETL_JOB_LOG`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ETL_JOB_LOG` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `LOG` varchar(255) NOT NULL,
  `CRE_DTM` datetime NOT NULL,
  `ETL_JOB_QUEUE_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_ETL_JOB_LOG_ETL_JOB_QUEUE1_idx` (`ETL_JOB_QUEUE_ID`),
  CONSTRAINT `fk_ETL_JOB_LOG_ETL_JOB_QUEUE1` FOREIGN KEY (`ETL_JOB_QUEUE_ID`) REFERENCES `ETL_JOB_QUEUE` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ETL_JOB_LOG`
--

LOCK TABLES `ETL_JOB_LOG` WRITE;
/*!40000 ALTER TABLE `ETL_JOB_LOG` DISABLE KEYS */;
/*!40000 ALTER TABLE `ETL_JOB_LOG` ENABLE KEYS */;
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
  CONSTRAINT `fk_ETL_JOB_QUEUE_JOB_SERVER1` FOREIGN KEY (`JOB_SERVER_ID`) REFERENCES `JOB_SERVER` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ETL_JOB_QUEUE_ETL_JOB1` FOREIGN KEY (`ETL_JOB_ID`) REFERENCES `ETL_JOB` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
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
  `ETL_JOB_ID` int(11) NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FINACIAL_KEY`
--

LOCK TABLES `FINACIAL_KEY` WRITE;
/*!40000 ALTER TABLE `FINACIAL_KEY` DISABLE KEYS */;
INSERT INTO `FINACIAL_KEY` VALUES (1,'financed_net_yield_1__c'),(2,'monthly_cash_flow_with_financing_2__c'),(3,'financed_net_yield_2__c'),(4,'monthly_cash_flow_with_financing_1__c'),(5,'interest_rate_1__c'),(6,'interest_rate_2__c'),(7,'price_per_ft_c'),(8,'noi_with_financing_1__c'),(9,'noi_with_financing_2__c'),(10,'noi__c'),(11,'monthly_cash_flow__c'),(12,'est_replacement_cost__c'),(13,'est_replacement_cost_per_sq_ft__c'),(14,'cash_net_yield__c'),(15,'down_payment_1__c'),(16,'down_payment_2__c'),(17,'interest_payment_1__c'),(18,'yearly_interest_payment_1__c'),(19,'monthly_interest_payment_2__c');
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
-- Table structure for table `GROUP_ROLE_MAP`
--

DROP TABLE IF EXISTS `GROUP_ROLE_MAP`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GROUP_ROLE_MAP` (
  `SYSTEM_ROLES_ID` int(11) NOT NULL,
  `GROUPS_ID` int(11) NOT NULL,
  KEY `fk_GROUP_ROLE_MAP_SYSTEM_ROLES1_idx` (`SYSTEM_ROLES_ID`),
  KEY `fk_GROUP_ROLE_MAP_GROUPS1_idx` (`GROUPS_ID`),
  CONSTRAINT `fk_GROUP_ROLE_MAP_SYSTEM_ROLES1` FOREIGN KEY (`SYSTEM_ROLES_ID`) REFERENCES `SYSTEM_ROLES` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_GROUP_ROLE_MAP_GROUPS1` FOREIGN KEY (`GROUPS_ID`) REFERENCES `GROUPS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GROUP_ROLE_MAP`
--

LOCK TABLES `GROUP_ROLE_MAP` WRITE;
/*!40000 ALTER TABLE `GROUP_ROLE_MAP` DISABLE KEYS */;
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
  `DESCRIPTION` text NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PROPERTY_DATA`
--

LOCK TABLES `PROPERTY_DATA` WRITE;
/*!40000 ALTER TABLE `PROPERTY_DATA` DISABLE KEYS */;
INSERT INTO `PROPERTY_DATA` VALUES (1,'5bb5c7a7-6438-4a7b-aa25-801de5a1f7a5','1438 Ohio',53000,'0','3 bedroom with full basement. Large fenced, grass backyard. 2 car garage. Nice quiet residential neighborhood. Improvements include: New kitchen/dining room with hardwood floors, appliances, carpet, lighting fixtures, plumbing, electrical, new water heater, paint, siding.',3,1,'SFR','Sold',1,43206),(2,'862253b1-1ac3-474d-bed7-d3fe2e247225','1515 Lillian',60000,'0','4 bedroom 2 bath on slab in nice quiet South Whitehall neighborhood. Den w/ fireplace, laundry room, large fenced backyard. Improvements include: New carpet, refurbished kitchen, counters, appliances, hardwood floors, entry tile, light fixtures, plumbing, electrical, new water heater.',4,2,'SFR','Sold',1,43227),(3,'7c19363f-940a-4a7a-8b57-8834eee02969','444-446 Linwood',60000,'0','This 2032 square foot multi-family home has 4 bedrooms and 2 bathrooms (2 bed/1 bath per sides). The property has a lot size of 2,614 sq. ft. The average list price for similar homes for sale is $122,775 and the average sales price for similar recently sold homes is $161,007',4,2,'MFR','Active',1,43205),(4,'e3188389-92be-4963-aa09-fc0394d6d55f','2684 Fern',50000,'0','New roof, new steel front and back exterior doors. Interior doors replaced. Hardwood floors, new carpet, railings, and light fixtures throughout. New ceiling fans, kitchen and bath cabinets. New laundry room, plumbing, electrical, and main sewer line between house and cityName connection. Security lights on fron/side/back of house.',3,2,'SFR','Sold',1,43211),(5,'d14ec930-7b94-46ad-8fe3-3a9a84b30c3c','564-566 Kimball',65000,'0','This 3006 square foot multi-family home with detached garage has 6 bedrooms and 2 bathrooms (3 bed/1 bath per side). The property has a lot size of 7,405 sq. ft. and was built in 1914. The average list price for similar homes for sale is $111,475 and the average sales price for similar recently sold homes is $161,007.',6,2,'MFR','Active',1,43205),(6,'20f98bc4-ab0f-4632-8b15-2ee4d59a1a0c','617-619 Oakwood',80000,'0','Originally a 2 story triplex, property was converted into an extra large duplex containing a 3 bedroom, 2 bath ground unit with full basement and laundry, and a 3 bedroom, 2 story second floor unit with separate sun room and laundry room on the back and screened in sun porch in the front. On the 3rd floor is a completely renovated(insulated) column free attic space that can be used as a 4th bedroom or spacious family room. Each unit has a private front entrance and rear exits. Improvements include: New steel exterior doors and security gate, interior doors, hardwood floors, carpet, light fixtures, ceiling fans, new appliances, major plumbing/electrical upgrades, 2 electric water heaters, 2 refurbished furnaces, security lights. Front/ back off street parking.',5,2,'MFR','Sold',1,43205),(7,'8a62660f-8613-4239-a65e-91780453b350','898 Studer',46500,'0','3 bedroom 2 bath with full basement and laundry, large fenced backyard. Improvements include: Screened front porch with storm doors/windows, interior doors, hardwood floors, drywall replacement throughout, ceiling fans, new appliances, plumbing, electrical, new water heater, refurbished furnace, security lights, garage.',3,2,'SFR','Sold',1,43206),(8,'812a09ce-8a9f-436d-97fe-9b3ecd599d4a','3117 Huber St',60000,'0','This quaint 3 bedroom, 1 bath single family residence has a renter in place and has been completely rehabbed with attached garage and located in a great neighborhood. The average list price for similar homes for sale is $66,475. 3117 N Huber St is in the 46226 ZIP code in Indianapolis, IN. The average list price for ZIP code 46226 is $98,455. Garage',3,1,'SFR','Active',1,46226),(9,'67c12bb6-607e-4ac8-a477-4444fa728c8d','2613 N Rural',69000,'0','This newer 2 bedroom, 1 bath ranch home in Oxford Terrace is approximately 1,064 sq. ft. on a lot size of 9,898 sq. ft. Built in 1990 this home has brand new carpet, paint and is move in ready. Two full bathrooms means never having to fight for who gets to go next. This home offers an open living concept in the living area and kitchen. A nice back yard has plenty of room for all your entertaining needs. A two car attached garage will keep you from scraping windows in the winter and still leaves room for extra storage. Hurry to schedule your showing, this property will not last long. The average sales price for similar recently sold homes is $82,500.',3,2,'SFR','Active',1,46218),(10,'4043cd8f-128f-4b08-98fb-cc642a8a22c7','886-888 Fulton',60000,'0','This multi-family duplex has 6 beds, 2 baths (3 bed/1 bath per side), and is approximately 2,452 square feet. The property has a lot size of 6,534 sq. ft. in historic Olde Town East area of Columbus. The average list price for similar homes for sale is $126,339 and the average sales price for similar recently sold homes is $163,357.',6,2,'MFR','Active',1,43205),(11,'6fa936d2-f02c-45a2-86a7-d2808f8c0b1b','568-570 Kimball',62000,'0','This multi-family duplex has 6 beds, 2 baths (3 bed/1 bath per side) and approximately 2,880 square feet. The property has a lot size of 7,405 sq. ft. and was built in 1913 in the South of Main area of Columbus. The average list price for similar homes for sale is $111,475 and the average sales price for similar recently sold homes is $161,007.',6,2,'MFR','Active',1,43205),(12,'0cf37f9e-ae24-43d8-90e6-9cd8e02fc22d','534-536 Oakwood',70000,'0','This multi-family duplex has 6 beds, 2 baths (3 bed/1 bath per side), and approximately 2,784 square feet. The property has a lot size of 5,227 sq. ft. in historic Olde Town East area of Columbus. The average list price for similar homes for sale is $121,442 and the average sales price for similar recently sold homes is $161,007.',6,2,'MFR','Active',1,43205),(13,'3655c5e1-f787-419b-b462-81a42ec4762c','4997 Folger',60000,'0','4 bedroom 2 bath with large fenced backyard. Quiet residential neighborhood. Improvements include: Hardwood floors, new kitchen cabinets/counters/sink and appliances, pantry, added family room with with base board heat and separate laundry room, carpet, light fixtures, plumbing, electrical, new water heater, paint, siding. Nice curb appeal.',4,1.5,'SFR','Sold',1,43227),(14,'390eed56-38aa-4586-9d99-f2ed4c77ce10','5456 Ruskin PL',62000,'0','This cute little 3 bedroom, 1 bath single family home is near all the shopping areas. The property has a lot size of 6,615 sq. ft. and was built in 1957. Brand new carpet and paint in home; dryer included. Also, has economical and efficient gas range, furnace and hot water heater. Nice window treatments in most rooms. Nice big back yard with storage shed & large covered patio. The home is situated close to corner, so easy access to 38th street. Brand new garage door plus new front & back storm doors.',3,1,'SFR','Active',1,46224),(15,'23ff2f2f-afee-425a-ba30-a43a3ea65ad6','6131 Tammin Dr',92000,'0','Tenant already in place. Great rental home on the West side of Indianapolis. New furnace. New paint. Property is in great condition!',3,1,'SFR','Sold',1,46254),(16,'27467f6d-222c-4585-be98-c3431bf11fd5','1232 Reisner',54900,'0','This property has all new flooring, paint, and vinyl windows. Large 3 BD home.',3,1.5,'SFR','Active',1,46221),(17,'ef0699fc-b4da-491c-8d7d-d46eb6582437','3907 Rookwood',51900,'0','Large 4 BD home. New roof and vinyl windows. Updated exterior siding, kitchen, water heater, and furnace.',4,1,'SFR','Active',1,46208),(18,'626d65c3-ae63-4f78-9c02-1758012c992f','801 Worth',57900,'0','This home has been updated inside and out. New vinyl windows. Currently occupied with a great sec 8 tenant.',3,1,'SFR','Active',1,46241),(19,'eef4f639-84fb-4981-b53f-87a4cac780a1','745 Holmes S',55900,'0','Charming 3 BD home close to downtown. Refinished hardwood flooring. All new paint. New flooring in kitchen and bath.',3,1,'SFR','Active',1,46221),(20,'22858a85-ebed-4c30-870d-35ede80f9d43','2009 Legrande',53900,'0','Great 3 BD home with a fenced backyard. New kitchen with tile backsplash. 2 car garage.',3,1,'SFR','Active',1,46203),(21,'2e43b092-3326-4147-9269-925c92b5d4b9','1411 Lindley',53900,'0','Great little 2 BD home. Completely remodeled with hardwood floors in a great area. Cental A/C.',2,1,'SFR','Active',1,46241),(22,'59f95bd5-cb43-4155-b081-fdc8cd41d041','1244 Moreland A/B',104000,'0','2 Homes on one lot! Both homes sit on a quiet street. Both homes are 3BD/2BA. Currently rented with great tenants. Great westside property.',5,2,'SFR','Active',1,46241),(23,'511394ce-6af6-43e2-ab2e-c76619d4e0a0','110 N Linwood Ave',52900,'0','This one is rented and ready to cash flow. Extensive rehab just completed. New flooring and paint throughout. All new window coverings, new A/C. Big square footage for the money.',3,1.5,'SFR','Sold',1,46201),(24,'98c070e9-774e-498b-84be-65e8d49238e6','5327 Traditions Dr',75900,'0','Great newer home in Indianapolis. Hard to find under $50/sqft. New paint and flooring throughout. New appliances. This home will perform for years to come.',3,2.5,'SFR','Sold',1,46235),(25,'a4f6abc1-bc01-4aa2-9ec4-1f6031aea995','3429 Payton',57900,'0','Nice 3 BD Ranch. Maintenance-free stone exterior. Big fenced yard. Deck with multiple levels in backyard. New paint. New tile, laminate and carpet throughout. New kitchen cabinets and countertops. Newer furnace and A/C.',3,1.5,'SFR','Active',1,46226),(26,'f5cc078b-fa96-4678-99f1-4de15a238013','625 Melvenia Ave',54900,'0','Sweet little 3 BD bungalow on a corner lot. Full unfinished basement with laundry area. New vinyl windows. Glass tile backsplash in kitchen.',3,1,'SFR','Active',1,46226),(27,'a04f69c3-03a6-4a75-9f6e-48fbef1e53c7','1404 Lindley',55900,'0','Completely remodeled with hardwood floors. 2 car oversized garage. Central A/C with fenced yard.',3,1.5,'SFR','Active',1,46241),(28,'192bcc3f-cd37-447f-9603-dc665c89fcdb','4249 Jamie Ct',56900,'0','Big ranch with great room addition on back with large fireplace and built-in grill. All new flooring and windows. Granite counters in the kitchen. One car attached garage.',3,2,'SFR','Active',1,46226),(29,'4a6e242b-bb85-45c7-89c2-3bbfd2a2aadf','2636 Foltz',55900,'0','Great little home on the West side. All new windows and kitchen. New flooring and paint throughout.',4,1.5,'SFR','Active',1,46241),(30,'f5639883-c055-4e7e-8ff5-07f934c9a5f2','3818 Dearborne S',69900,'0','Large home with big rooms and extra family room in a great neighborhood. Limestone maintenance-free exterior. Big back yard with storage sheds. New kitchen, Vinyl windows, and refinished hardwood floors.',3,1,'SFR','Active',1,46237),(31,'5478e68f-7a96-44c7-a370-e71e3a8e9473','1023 Worth',56900,'0','Great ranch house with new vinyl windows. Hardwood floors, new kitchen and bath.',3,1,'SFR','Active',1,46241),(32,'e8316eac-53b7-42c1-b4cc-d1448534ea56','849 S Worth Ave',53900,'0','This home sits in a great neighborhood. Easy to rent homes in the area. New flooring and paint. New kitchen.',3,1,'SFR','Sold',1,46241),(33,'d510b66a-cfd8-41e7-bf2c-92355a46b8f5','3351 Butler Ave',53900,'0','Wonderful little home on the west side of Indianapolis. Updated exterior. New flooring and paint throughout. Upgraded kitchen.',3,1,'SFR','Active',1,46218),(34,'796b7f27-301e-42f8-8c32-466ca1f17796','3025 Alice Ave',57900,'0','Get a home in this desireable neighborhood for less than $40/sqft. New paint and carpet throughout. New A/C and water heater. Big house for the money.',3,1.5,'SFR','Sold',1,46237),(35,'0881c81c-c3ce-4987-8b15-c344942a9b59','7756 Mountain Stream',55000,'0','Amazing deal for this townhouse built in 2007! New furnace and A/C. New carpet and paint throughout.',4,3,'SFR','Sold',1,46239),(36,'a1b48900-5944-4c7d-b877-04a7332ceb7d','1405 17th Way SW',55900,'0','Great home by the college. Quiet neighborhood. New roof. New flooring throughout. New paint throughout. Brand new Furnace and A/C.  Priced well under market at $34 Sqft.',3,1.5,'SFR','Active',1,35211),(37,'330d65db-e9b5-4a3a-b616-2bf5aa6bb897','5319 Scatterwood',89000,'0','Great price for a newer home. Brand new Furnace and A/C. All new flooring and paint throughout. New electrical. New water heater. Great access to parks, golf courses, and International airport.  Tax Value 100k+',3,2,'SFR','Sold',1,46221),(38,'22802a1e-fc96-4f25-9e87-84040be2ca2e','325 Hiett Ave',32000,'0','Great home in a Great market!',3,1,'SFR','Sold',1,43609),(39,'dcc04529-f5d2-466f-a170-4b9316e1b9b4','3236 Welch Dr',57900,'0','New vinyl windows and siding.All new window treatments. New interior paint. All new appliances. New flooring throughout the house. New water heater. New roof.  High demand rental neighborhood located on the west side of Indianapolis.',4,1.5,'SFR','Sold',1,46224),(40,'e175e126-908d-43d9-81e5-a3489a8d58e6','6530 Pike View Ct',82000,'0','Home just renovated. Built in 1989. Great long-term tenant. Great price for this home that is already cash-flowing. Great neighborhood close to some of the best schools in Indy.',3,2,'SFR','Sold',1,46268),(41,'e2f6c512-8327-401e-8f3a-ea8c57c8b59a','3126 Gerrard Ave',57900,'0','Great home in a Great market!',3,2,'SFR','Sold',1,46224),(42,'783eddaf-8efe-4c7c-b3e9-edbe702b5dd1','212 Mettler',39900,'0','Great home in a Great market!',3,1,'SFR','Active',1,43608),(43,'298c0b92-b5b6-48e5-9ae1-528bff4d548f','3349 Winton Ave',57900,'0','All new windows. New flooring, paint, mechanicals. All new appliances. New light fixtures throughout.  Long-term tenant. Very desireable Eagledale neighborhood.',3,1,'SFR','Sold',1,46224),(44,'ece8374d-df4b-404e-9961-19a699a7ce91','3525 N Payton Ave',56900,'0','Great home in a Great market!',3,1,'SFR','Sold',1,46226),(45,'b90744c6-b9d0-430d-927e-312fe1fb93d2','4900 Ave N',49500,'0','Great home in a Great market!',3,1.5,'SFR','Sold',1,35208),(46,'ef22d2cc-e160-44d9-848c-0740f1e97ab2','1644 30th St Ensley',46000,'0','New heat pump, hardwood floors! Great long-term tenant!',3,2,'SFR','Sold',1,35208),(47,'1cf7457f-e9ee-4801-80e6-ded44b3a1b7a','1505 S Leland Ave',54900,'0','Great home in a Great market!',3,1,'SFR','Sold',1,46203),(48,'18668aac-5320-4c10-b72f-0a5d8fe56985','1804 N Lesley Ave',56900,'0','Great home in a Great market!',3,1.5,'SFR','Sold',1,46222),(49,'8eff875f-0d68-41c3-a7c2-e7923bdf0559','4993 Beatrice Dr.',58000,'0','New cherry cabinets, windows, paint! Quiet neighborhood!',3,1.5,'SFR','Sold',1,43227),(50,'f91fa59e-4905-4877-b366-9456815c019f','1521 33rd St Ensley',46500,'0','Fully remodeled less than 2yrs ago including new roof! Hardwod floors.',3,1,'SFR','Sold',1,35208),(51,'2c5a23b9-ffc4-4212-820d-87aa9b1a9959','218 Vann St',47000,'0','Great home in a Great market!',3,2,'SFR','Sold',1,35228),(52,'d4d9bfc2-9758-4734-b55d-16dfba41fd4d','1441 Warrior Rd',47500,'0','Great home in a Great market!',3,1,'SFR','Sold',1,35208),(53,'eb4e2198-6224-4ca9-86d3-0461aa5f6d5c','1328 43rd St Ensley',46500,'0','Great home in a Great market!',3,1,'SFR','Active',1,35208),(54,'66d77963-5aa0-49fd-9fce-2fca654bac4c','1401 46th St Ensley',47500,'0','New roof, New HVAC, all hardwood floors!Big Master and great tenant.',3,1,'SFR','Sold',1,35208),(55,'1882100a-b3fb-4f48-91fd-f86d836e5806','1341 44th St Ensley',52500,'0','Great home in a Great market!',3,1,'SFR','Sold',1,35208),(56,'620c3352-316a-4d20-b7ea-3e651c86c19b','4708 Court O',39000,'0','Great home in a Great market!',2,1,'SFR','Active',1,35208),(57,'f6ac9845-6b56-4703-a09e-86eaeff92392','5913 Avenue M',36000,'0','New windows. New kitchen. Roof only 2 years old. Hardwood floors throughout which means less maintenance. New HVAC system. Long-term tenant.  All of this for under 50k!',2,1,'SFR','Active',1,35228),(58,'b5d8e52c-c775-43a0-82dd-d3b263c6d812','2031 Center Street S',39000,'0','Great home in a Great market!',2,1,'SFR','Active',1,35205),(59,'afb55670-6dfe-4bc8-8d4a-0b0edd9c7e48','5900 Avenue M',49000,'0','New windows.Brand new roof with a 30 yr warranty. Brand new furnace and A/C. Great neighborhood and tenant is signed to a long-term lease. Can\'t beat a 1300 Sqft home for under 50k!',3,2,'SFR','Active',1,35228),(60,'1f99dee2-d892-439a-a9ce-2570fce95a94','2672 20th Street',39000,'0','Great Section 8 tenant! Full rehab. No carpet means less maintenance!',2,1,'SFR','Active',1,35208),(61,'ffa86c4b-3b05-4f1d-b495-49f6b7b26c05','1147 North Berwick Avenue',54900,'0','Great tenant. All new appliances, new tile, hardwood floors which means less maintenance. Great curb appeal. Very Quiet neighborhood but very convenient to shopping and downtown. Very desireable Eagledale section of Indianapolis.',3,1,'SFR','Sold',1,46222),(62,'ae532bb0-d8bc-4c06-9605-33fc398752af','4138 Breton St',53900,'0','Great home in a Great market!',3,1,'SFR','Sold',1,46222),(63,'c5a4ba7d-c5f4-4698-9a21-d253a2c72bbd','477 South Exeter',54900,'0','Great home in a Great market!',3,1,'SFR','Sold',1,46241),(64,'3da49a80-30e3-4eaa-8bef-8326083b5547','6201 E Truman Road',82000,'0','Great duplex. Recent $3000 in rehab Unit A, Section 8, $1020 Unit A, owner pays utilities. 6 month rent gurantee $500 per month on Unit B. Undr good management.',6,2,'Duplex','Active',1,64126),(65,'5a96a627-3957-4eab-af33-d788e88fa623','521/523 Jackson St',145000,'0','Great price for a 4-unit building. Fully rehabbed. Great location.',8,4,'4Plex','Active',1,64126),(66,'7534d59e-9aad-4bc8-b6eb-05646195cd91','5208 Garfield',52000,'0','Nice single-family home. All new flooring throughout. New Furnace and A/C. New water heater.   Great curb appeal with a stone front.',3,1,'SFR','Active',1,64126),(67,'3ff8af11-cbd8-477a-a71f-d405ff8711c4','2429 Hardesty',37000,'0','New roof. New Furnace and A/C. Hardwood floors. Good long-term Section 8 tenant. Great price on this single-family home. Grab this one with less than 20k down!',2,1,'SFR','Active',1,64127),(68,'fd032ae1-01ac-4fc1-bbd3-c0d92c44a3b3','528 Cadillac',42000,'0','Great home in a Great market!',6,2,'Duplex','Sold',1,43610),(69,'f1c89e6e-103b-411a-8520-c5ebf5285018','8109 1st Avenue S',30000,'0','Great home in a Great market!',2,1,'SFR','Active',1,35206),(70,'a93db55c-7b3a-4000-b610-59c99e6461e4','2036 Mayfield',45900,'0','Great home in a Great market!',3,1,'SFR','Active',1,35023),(71,'9bd953b4-2196-4c44-9149-1c7a80a2ea4f','2937 Mussman Dr',54900,'0','Great home in a Great market!',4,2,'SFR','Sold',1,46222);
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
  `VALUE` decimal(5,2) NOT NULL DEFAULT '0.00',
  `FINACIAL_KEY_ID` int(11) NOT NULL,
  `PROPERTY_DATA_UUID` char(36) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `udx1` (`FINACIAL_KEY_ID`,`PROPERTY_DATA_UUID`),
  KEY `fk_PROPERTY_FINACIALS_FINACIAL_KEY1_idx` (`FINACIAL_KEY_ID`),
  KEY `fk_PROPERTY_FINACIALS_PROPERTY_DATA1_idx` (`PROPERTY_DATA_UUID`),
  CONSTRAINT `fk_PROPERTY_FINACIALS_FINACIAL_KEY1` FOREIGN KEY (`FINACIAL_KEY_ID`) REFERENCES `FINACIAL_KEY` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_PROPERTY_FINACIALS_PROPERTY_DATA1` FOREIGN KEY (`PROPERTY_DATA_UUID`) REFERENCES `PROPERTY_DATA` (`UUID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=862 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PROPERTY_FINACIAL`
--

LOCK TABLES `PROPERTY_FINACIAL` WRITE;
/*!40000 ALTER TABLE `PROPERTY_FINACIAL` DISABLE KEYS */;
INSERT INTO `PROPERTY_FINACIAL` VALUES (1,10.23,1,'5bb5c7a7-6438-4a7b-aa25-801de5a1f7a5'),(2,287.46,2,'5bb5c7a7-6438-4a7b-aa25-801de5a1f7a5'),(3,22.55,3,'5bb5c7a7-6438-4a7b-aa25-801de5a1f7a5'),(4,391.34,4,'5bb5c7a7-6438-4a7b-aa25-801de5a1f7a5'),(5,8.00,5,'5bb5c7a7-6438-4a7b-aa25-801de5a1f7a5'),(6,7.00,6,'5bb5c7a7-6438-4a7b-aa25-801de5a1f7a5'),(7,45.86,7,'5bb5c7a7-6438-4a7b-aa25-801de5a1f7a5'),(8,495.00,11,'5bb5c7a7-6438-4a7b-aa25-801de5a1f7a5'),(9,70.00,13,'5bb5c7a7-6438-4a7b-aa25-801de5a1f7a5'),(10,11.20,14,'5bb5c7a7-6438-4a7b-aa25-801de5a1f7a5'),(11,31.40,17,'5bb5c7a7-6438-4a7b-aa25-801de5a1f7a5'),(12,377.00,18,'5bb5c7a7-6438-4a7b-aa25-801de5a1f7a5'),(13,207.29,19,'5bb5c7a7-6438-4a7b-aa25-801de5a1f7a5'),(14,9.67,1,'862253b1-1ac3-474d-bed7-d3fe2e247225'),(15,312.98,2,'862253b1-1ac3-474d-bed7-d3fe2e247225'),(16,20.87,3,'862253b1-1ac3-474d-bed7-d3fe2e247225'),(17,435.19,4,'862253b1-1ac3-474d-bed7-d3fe2e247225'),(18,8.00,5,'862253b1-1ac3-474d-bed7-d3fe2e247225'),(19,7.00,6,'862253b1-1ac3-474d-bed7-d3fe2e247225'),(20,37.93,7,'862253b1-1ac3-474d-bed7-d3fe2e247225'),(21,557.00,11,'862253b1-1ac3-474d-bed7-d3fe2e247225'),(22,70.00,13,'862253b1-1ac3-474d-bed7-d3fe2e247225'),(23,11.14,14,'862253b1-1ac3-474d-bed7-d3fe2e247225'),(24,36.94,17,'862253b1-1ac3-474d-bed7-d3fe2e247225'),(25,443.00,18,'862253b1-1ac3-474d-bed7-d3fe2e247225'),(26,243.87,19,'862253b1-1ac3-474d-bed7-d3fe2e247225'),(27,13.70,1,'7c19363f-940a-4a7a-8b57-8834eee02969'),(28,494.26,2,'7c19363f-940a-4a7a-8b57-8834eee02969'),(29,32.95,3,'7c19363f-940a-4a7a-8b57-8834eee02969'),(30,616.47,4,'7c19363f-940a-4a7a-8b57-8834eee02969'),(31,8.00,5,'7c19363f-940a-4a7a-8b57-8834eee02969'),(32,7.00,6,'7c19363f-940a-4a7a-8b57-8834eee02969'),(33,29.53,7,'7c19363f-940a-4a7a-8b57-8834eee02969'),(34,738.00,11,'7c19363f-940a-4a7a-8b57-8834eee02969'),(35,70.00,13,'7c19363f-940a-4a7a-8b57-8834eee02969'),(36,14.76,14,'7c19363f-940a-4a7a-8b57-8834eee02969'),(37,36.94,17,'7c19363f-940a-4a7a-8b57-8834eee02969'),(38,443.00,18,'7c19363f-940a-4a7a-8b57-8834eee02969'),(39,243.87,19,'7c19363f-940a-4a7a-8b57-8834eee02969'),(40,10.17,1,'e3188389-92be-4963-aa09-fc0394d6d55f'),(41,278.85,2,'e3188389-92be-4963-aa09-fc0394d6d55f'),(42,22.35,3,'e3188389-92be-4963-aa09-fc0394d6d55f'),(43,380.49,4,'e3188389-92be-4963-aa09-fc0394d6d55f'),(44,8.00,5,'e3188389-92be-4963-aa09-fc0394d6d55f'),(45,7.00,6,'e3188389-92be-4963-aa09-fc0394d6d55f'),(46,32.36,7,'e3188389-92be-4963-aa09-fc0394d6d55f'),(47,482.00,11,'e3188389-92be-4963-aa09-fc0394d6d55f'),(48,70.00,13,'e3188389-92be-4963-aa09-fc0394d6d55f'),(49,11.56,14,'e3188389-92be-4963-aa09-fc0394d6d55f'),(50,30.72,17,'e3188389-92be-4963-aa09-fc0394d6d55f'),(51,369.00,18,'e3188389-92be-4963-aa09-fc0394d6d55f'),(52,202.82,19,'e3188389-92be-4963-aa09-fc0394d6d55f'),(53,12.85,1,'d14ec930-7b94-46ad-8fe3-3a9a84b30c3c'),(54,493.80,2,'d14ec930-7b94-46ad-8fe3-3a9a84b30c3c'),(55,30.39,3,'d14ec930-7b94-46ad-8fe3-3a9a84b30c3c'),(56,626.20,4,'d14ec930-7b94-46ad-8fe3-3a9a84b30c3c'),(57,8.00,5,'d14ec930-7b94-46ad-8fe3-3a9a84b30c3c'),(58,7.00,6,'d14ec930-7b94-46ad-8fe3-3a9a84b30c3c'),(59,21.62,7,'d14ec930-7b94-46ad-8fe3-3a9a84b30c3c'),(60,758.00,11,'d14ec930-7b94-46ad-8fe3-3a9a84b30c3c'),(61,70.00,13,'d14ec930-7b94-46ad-8fe3-3a9a84b30c3c'),(62,13.99,14,'d14ec930-7b94-46ad-8fe3-3a9a84b30c3c'),(63,40.02,17,'d14ec930-7b94-46ad-8fe3-3a9a84b30c3c'),(64,480.00,18,'d14ec930-7b94-46ad-8fe3-3a9a84b30c3c'),(65,264.20,19,'d14ec930-7b94-46ad-8fe3-3a9a84b30c3c'),(66,10.98,1,'20f98bc4-ab0f-4632-8b15-2ee4d59a1a0c'),(67,495.92,2,'20f98bc4-ab0f-4632-8b15-2ee4d59a1a0c'),(68,24.80,3,'20f98bc4-ab0f-4632-8b15-2ee4d59a1a0c'),(69,658.87,4,'20f98bc4-ab0f-4632-8b15-2ee4d59a1a0c'),(70,8.00,5,'20f98bc4-ab0f-4632-8b15-2ee4d59a1a0c'),(71,7.00,6,'20f98bc4-ab0f-4632-8b15-2ee4d59a1a0c'),(72,50.00,7,'20f98bc4-ab0f-4632-8b15-2ee4d59a1a0c'),(73,821.00,11,'20f98bc4-ab0f-4632-8b15-2ee4d59a1a0c'),(74,70.00,13,'20f98bc4-ab0f-4632-8b15-2ee4d59a1a0c'),(75,12.32,14,'20f98bc4-ab0f-4632-8b15-2ee4d59a1a0c'),(76,49.25,17,'20f98bc4-ab0f-4632-8b15-2ee4d59a1a0c'),(77,591.00,18,'20f98bc4-ab0f-4632-8b15-2ee4d59a1a0c'),(78,325.16,19,'20f98bc4-ab0f-4632-8b15-2ee4d59a1a0c'),(79,11.97,1,'8a62660f-8613-4239-a65e-91780453b350'),(80,322.66,2,'8a62660f-8613-4239-a65e-91780453b350'),(81,27.76,3,'8a62660f-8613-4239-a65e-91780453b350'),(82,417.38,4,'8a62660f-8613-4239-a65e-91780453b350'),(83,8.00,5,'8a62660f-8613-4239-a65e-91780453b350'),(84,7.00,6,'8a62660f-8613-4239-a65e-91780453b350'),(85,29.47,7,'8a62660f-8613-4239-a65e-91780453b350'),(86,512.00,11,'8a62660f-8613-4239-a65e-91780453b350'),(87,70.00,13,'8a62660f-8613-4239-a65e-91780453b350'),(88,12.53,14,'8a62660f-8613-4239-a65e-91780453b350'),(89,28.63,17,'8a62660f-8613-4239-a65e-91780453b350'),(90,344.00,18,'8a62660f-8613-4239-a65e-91780453b350'),(91,189.00,19,'8a62660f-8613-4239-a65e-91780453b350'),(92,10.65,1,'812a09ce-8a9f-436d-97fe-9b3ecd599d4a'),(93,356.96,2,'812a09ce-8a9f-436d-97fe-9b3ecd599d4a'),(94,23.80,3,'812a09ce-8a9f-436d-97fe-9b3ecd599d4a'),(95,479.17,4,'812a09ce-8a9f-436d-97fe-9b3ecd599d4a'),(96,8.00,5,'812a09ce-8a9f-436d-97fe-9b3ecd599d4a'),(97,7.00,6,'812a09ce-8a9f-436d-97fe-9b3ecd599d4a'),(98,62.50,7,'812a09ce-8a9f-436d-97fe-9b3ecd599d4a'),(99,601.00,11,'812a09ce-8a9f-436d-97fe-9b3ecd599d4a'),(100,70.00,13,'812a09ce-8a9f-436d-97fe-9b3ecd599d4a'),(101,12.02,14,'812a09ce-8a9f-436d-97fe-9b3ecd599d4a'),(102,36.94,17,'812a09ce-8a9f-436d-97fe-9b3ecd599d4a'),(103,443.00,18,'812a09ce-8a9f-436d-97fe-9b3ecd599d4a'),(104,243.87,19,'812a09ce-8a9f-436d-97fe-9b3ecd599d4a'),(105,9.50,1,'67c12bb6-607e-4ac8-a477-4444fa728c8d'),(106,351.21,2,'67c12bb6-607e-4ac8-a477-4444fa728c8d'),(107,20.36,3,'67c12bb6-607e-4ac8-a477-4444fa728c8d'),(108,491.76,4,'67c12bb6-607e-4ac8-a477-4444fa728c8d'),(109,8.00,5,'67c12bb6-607e-4ac8-a477-4444fa728c8d'),(110,7.00,6,'67c12bb6-607e-4ac8-a477-4444fa728c8d'),(111,64.85,7,'67c12bb6-607e-4ac8-a477-4444fa728c8d'),(112,632.00,11,'67c12bb6-607e-4ac8-a477-4444fa728c8d'),(113,70.00,13,'67c12bb6-607e-4ac8-a477-4444fa728c8d'),(114,10.99,14,'67c12bb6-607e-4ac8-a477-4444fa728c8d'),(115,42.48,17,'67c12bb6-607e-4ac8-a477-4444fa728c8d'),(116,510.00,18,'67c12bb6-607e-4ac8-a477-4444fa728c8d'),(117,280.45,19,'67c12bb6-607e-4ac8-a477-4444fa728c8d'),(118,13.38,1,'4043cd8f-128f-4b08-98fb-cc642a8a22c7'),(119,480.03,2,'4043cd8f-128f-4b08-98fb-cc642a8a22c7'),(120,32.00,3,'4043cd8f-128f-4b08-98fb-cc642a8a22c7'),(121,602.24,4,'4043cd8f-128f-4b08-98fb-cc642a8a22c7'),(122,8.00,5,'4043cd8f-128f-4b08-98fb-cc642a8a22c7'),(123,7.00,6,'4043cd8f-128f-4b08-98fb-cc642a8a22c7'),(124,24.47,7,'4043cd8f-128f-4b08-98fb-cc642a8a22c7'),(125,724.00,11,'4043cd8f-128f-4b08-98fb-cc642a8a22c7'),(126,70.00,13,'4043cd8f-128f-4b08-98fb-cc642a8a22c7'),(127,14.48,14,'4043cd8f-128f-4b08-98fb-cc642a8a22c7'),(128,36.94,17,'4043cd8f-128f-4b08-98fb-cc642a8a22c7'),(129,443.00,18,'4043cd8f-128f-4b08-98fb-cc642a8a22c7'),(130,243.87,19,'4043cd8f-128f-4b08-98fb-cc642a8a22c7'),(131,14.17,1,'6fa936d2-f02c-45a2-86a7-d2808f8c0b1b'),(132,532.45,2,'6fa936d2-f02c-45a2-86a7-d2808f8c0b1b'),(133,34.35,3,'6fa936d2-f02c-45a2-86a7-d2808f8c0b1b'),(134,658.74,4,'6fa936d2-f02c-45a2-86a7-d2808f8c0b1b'),(135,8.00,5,'6fa936d2-f02c-45a2-86a7-d2808f8c0b1b'),(136,7.00,6,'6fa936d2-f02c-45a2-86a7-d2808f8c0b1b'),(137,21.53,7,'6fa936d2-f02c-45a2-86a7-d2808f8c0b1b'),(138,784.00,11,'6fa936d2-f02c-45a2-86a7-d2808f8c0b1b'),(139,70.00,13,'6fa936d2-f02c-45a2-86a7-d2808f8c0b1b'),(140,15.18,14,'6fa936d2-f02c-45a2-86a7-d2808f8c0b1b'),(141,38.17,17,'6fa936d2-f02c-45a2-86a7-d2808f8c0b1b'),(142,458.00,18,'6fa936d2-f02c-45a2-86a7-d2808f8c0b1b'),(143,252.00,19,'6fa936d2-f02c-45a2-86a7-d2808f8c0b1b'),(144,14.39,1,'0cf37f9e-ae24-43d8-90e6-9cd8e02fc22d'),(145,612.65,2,'0cf37f9e-ae24-43d8-90e6-9cd8e02fc22d'),(146,35.01,3,'0cf37f9e-ae24-43d8-90e6-9cd8e02fc22d'),(147,755.23,4,'0cf37f9e-ae24-43d8-90e6-9cd8e02fc22d'),(148,8.00,5,'0cf37f9e-ae24-43d8-90e6-9cd8e02fc22d'),(149,7.00,6,'0cf37f9e-ae24-43d8-90e6-9cd8e02fc22d'),(150,25.14,7,'0cf37f9e-ae24-43d8-90e6-9cd8e02fc22d'),(151,897.00,11,'0cf37f9e-ae24-43d8-90e6-9cd8e02fc22d'),(152,70.00,13,'0cf37f9e-ae24-43d8-90e6-9cd8e02fc22d'),(153,15.38,14,'0cf37f9e-ae24-43d8-90e6-9cd8e02fc22d'),(154,43.10,17,'0cf37f9e-ae24-43d8-90e6-9cd8e02fc22d'),(155,517.00,18,'0cf37f9e-ae24-43d8-90e6-9cd8e02fc22d'),(156,284.52,19,'0cf37f9e-ae24-43d8-90e6-9cd8e02fc22d'),(157,10.43,1,'3655c5e1-f787-419b-b462-81a42ec4762c'),(158,347.29,2,'3655c5e1-f787-419b-b462-81a42ec4762c'),(159,23.15,3,'3655c5e1-f787-419b-b462-81a42ec4762c'),(160,469.51,4,'3655c5e1-f787-419b-b462-81a42ec4762c'),(161,8.00,5,'3655c5e1-f787-419b-b462-81a42ec4762c'),(162,7.00,6,'3655c5e1-f787-419b-b462-81a42ec4762c'),(163,37.93,7,'3655c5e1-f787-419b-b462-81a42ec4762c'),(164,591.00,11,'3655c5e1-f787-419b-b462-81a42ec4762c'),(165,70.00,13,'3655c5e1-f787-419b-b462-81a42ec4762c'),(166,11.82,14,'3655c5e1-f787-419b-b462-81a42ec4762c'),(167,36.94,17,'3655c5e1-f787-419b-b462-81a42ec4762c'),(168,443.00,18,'3655c5e1-f787-419b-b462-81a42ec4762c'),(169,243.87,19,'3655c5e1-f787-419b-b462-81a42ec4762c'),(170,11.06,1,'390eed56-38aa-4586-9d99-f2ed4c77ce10'),(171,388.00,2,'390eed56-38aa-4586-9d99-f2ed4c77ce10'),(172,25.03,3,'390eed56-38aa-4586-9d99-f2ed4c77ce10'),(173,514.29,4,'390eed56-38aa-4586-9d99-f2ed4c77ce10'),(174,8.00,5,'390eed56-38aa-4586-9d99-f2ed4c77ce10'),(175,7.00,6,'390eed56-38aa-4586-9d99-f2ed4c77ce10'),(176,64.99,7,'390eed56-38aa-4586-9d99-f2ed4c77ce10'),(177,640.00,11,'390eed56-38aa-4586-9d99-f2ed4c77ce10'),(178,70.00,13,'390eed56-38aa-4586-9d99-f2ed4c77ce10'),(179,12.39,14,'390eed56-38aa-4586-9d99-f2ed4c77ce10'),(180,38.17,17,'390eed56-38aa-4586-9d99-f2ed4c77ce10'),(181,458.00,18,'390eed56-38aa-4586-9d99-f2ed4c77ce10'),(182,252.00,19,'390eed56-38aa-4586-9d99-f2ed4c77ce10'),(183,14.47,1,'23ff2f2f-afee-425a-ba30-a43a3ea65ad6'),(184,628.01,2,'23ff2f2f-afee-425a-ba30-a43a3ea65ad6'),(185,27.30,3,'23ff2f2f-afee-425a-ba30-a43a3ea65ad6'),(186,388.17,4,'23ff2f2f-afee-425a-ba30-a43a3ea65ad6'),(187,10.00,5,'23ff2f2f-afee-425a-ba30-a43a3ea65ad6'),(188,4.85,6,'23ff2f2f-afee-425a-ba30-a43a3ea65ad6'),(189,72.44,7,'23ff2f2f-afee-425a-ba30-a43a3ea65ad6'),(190,886.50,11,'23ff2f2f-afee-425a-ba30-a43a3ea65ad6'),(191,70.00,13,'23ff2f2f-afee-425a-ba30-a43a3ea65ad6'),(192,11.56,14,'23ff2f2f-afee-425a-ba30-a43a3ea65ad6'),(193,498.33,17,'23ff2f2f-afee-425a-ba30-a43a3ea65ad6'),(194,258.49,19,'23ff2f2f-afee-425a-ba30-a43a3ea65ad6'),(195,18.62,1,'27467f6d-222c-4585-be98-c3431bf11fd5'),(196,441.25,2,'27467f6d-222c-4585-be98-c3431bf11fd5'),(197,32.15,3,'27467f6d-222c-4585-be98-c3431bf11fd5'),(198,298.13,4,'27467f6d-222c-4585-be98-c3431bf11fd5'),(199,10.00,5,'27467f6d-222c-4585-be98-c3431bf11fd5'),(200,4.85,6,'27467f6d-222c-4585-be98-c3431bf11fd5'),(201,38.77,7,'27467f6d-222c-4585-be98-c3431bf11fd5'),(202,595.50,11,'27467f6d-222c-4585-be98-c3431bf11fd5'),(203,70.00,13,'27467f6d-222c-4585-be98-c3431bf11fd5'),(204,13.02,14,'27467f6d-222c-4585-be98-c3431bf11fd5'),(205,297.38,17,'27467f6d-222c-4585-be98-c3431bf11fd5'),(206,154.25,19,'27467f6d-222c-4585-be98-c3431bf11fd5'),(207,10.99,1,'ef0699fc-b4da-491c-8d7d-d46eb6582437'),(208,301.68,2,'ef0699fc-b4da-491c-8d7d-d46eb6582437'),(209,23.25,3,'ef0699fc-b4da-491c-8d7d-d46eb6582437'),(210,166.38,4,'ef0699fc-b4da-491c-8d7d-d46eb6582437'),(211,10.00,5,'ef0699fc-b4da-491c-8d7d-d46eb6582437'),(212,4.85,6,'ef0699fc-b4da-491c-8d7d-d46eb6582437'),(213,35.94,7,'ef0699fc-b4da-491c-8d7d-d46eb6582437'),(214,447.50,11,'ef0699fc-b4da-491c-8d7d-d46eb6582437'),(215,70.00,13,'ef0699fc-b4da-491c-8d7d-d46eb6582437'),(216,10.35,14,'ef0699fc-b4da-491c-8d7d-d46eb6582437'),(217,281.13,17,'ef0699fc-b4da-491c-8d7d-d46eb6582437'),(218,145.82,19,'ef0699fc-b4da-491c-8d7d-d46eb6582437'),(219,13.63,1,'626d65c3-ae63-4f78-9c02-1758012c992f'),(220,381.16,2,'626d65c3-ae63-4f78-9c02-1758012c992f'),(221,26.33,3,'626d65c3-ae63-4f78-9c02-1758012c992f'),(222,230.21,4,'626d65c3-ae63-4f78-9c02-1758012c992f'),(223,10.00,5,'626d65c3-ae63-4f78-9c02-1758012c992f'),(224,4.85,6,'626d65c3-ae63-4f78-9c02-1758012c992f'),(225,53.91,7,'626d65c3-ae63-4f78-9c02-1758012c992f'),(226,543.83,11,'626d65c3-ae63-4f78-9c02-1758012c992f'),(227,70.00,13,'626d65c3-ae63-4f78-9c02-1758012c992f'),(228,11.27,14,'626d65c3-ae63-4f78-9c02-1758012c992f'),(229,313.63,17,'626d65c3-ae63-4f78-9c02-1758012c992f'),(230,162.68,19,'626d65c3-ae63-4f78-9c02-1758012c992f'),(231,19.33,1,'eef4f639-84fb-4981-b53f-87a4cac780a1'),(232,460.94,2,'eef4f639-84fb-4981-b53f-87a4cac780a1'),(233,32.98,3,'eef4f639-84fb-4981-b53f-87a4cac780a1'),(234,315.21,4,'eef4f639-84fb-4981-b53f-87a4cac780a1'),(235,10.00,5,'eef4f639-84fb-4981-b53f-87a4cac780a1'),(236,4.85,6,'eef4f639-84fb-4981-b53f-87a4cac780a1'),(237,53.24,7,'eef4f639-84fb-4981-b53f-87a4cac780a1'),(238,618.00,11,'eef4f639-84fb-4981-b53f-87a4cac780a1'),(239,70.00,13,'eef4f639-84fb-4981-b53f-87a4cac780a1'),(240,13.27,14,'eef4f639-84fb-4981-b53f-87a4cac780a1'),(241,302.79,17,'eef4f639-84fb-4981-b53f-87a4cac780a1'),(242,157.06,19,'eef4f639-84fb-4981-b53f-87a4cac780a1'),(243,13.31,1,'22858a85-ebed-4c30-870d-35ede80f9d43'),(244,349.81,2,'22858a85-ebed-4c30-870d-35ede80f9d43'),(245,25.96,3,'22858a85-ebed-4c30-870d-35ede80f9d43'),(246,209.29,4,'22858a85-ebed-4c30-870d-35ede80f9d43'),(247,10.00,5,'22858a85-ebed-4c30-870d-35ede80f9d43'),(248,4.85,6,'22858a85-ebed-4c30-870d-35ede80f9d43'),(249,36.22,7,'22858a85-ebed-4c30-870d-35ede80f9d43'),(250,501.25,11,'22858a85-ebed-4c30-870d-35ede80f9d43'),(251,70.00,13,'22858a85-ebed-4c30-870d-35ede80f9d43'),(252,11.16,14,'22858a85-ebed-4c30-870d-35ede80f9d43'),(253,291.96,17,'22858a85-ebed-4c30-870d-35ede80f9d43'),(254,151.44,19,'22858a85-ebed-4c30-870d-35ede80f9d43'),(255,18.53,1,'2e43b092-3326-4147-9269-925c92b5d4b9'),(256,431.89,2,'2e43b092-3326-4147-9269-925c92b5d4b9'),(257,32.05,3,'2e43b092-3326-4147-9269-925c92b5d4b9'),(258,291.38,4,'2e43b092-3326-4147-9269-925c92b5d4b9'),(259,10.00,5,'2e43b092-3326-4147-9269-925c92b5d4b9'),(260,4.85,6,'2e43b092-3326-4147-9269-925c92b5d4b9'),(261,57.59,7,'2e43b092-3326-4147-9269-925c92b5d4b9'),(262,583.33,11,'2e43b092-3326-4147-9269-925c92b5d4b9'),(263,70.00,13,'2e43b092-3326-4147-9269-925c92b5d4b9'),(264,12.99,14,'2e43b092-3326-4147-9269-925c92b5d4b9'),(265,291.96,17,'2e43b092-3326-4147-9269-925c92b5d4b9'),(266,151.44,19,'2e43b092-3326-4147-9269-925c92b5d4b9'),(267,18.76,1,'59f95bd5-cb43-4155-b081-fdc8cd41d041'),(268,840.30,2,'59f95bd5-cb43-4155-b081-fdc8cd41d041'),(269,32.32,3,'59f95bd5-cb43-4155-b081-fdc8cd41d041'),(270,569.17,4,'59f95bd5-cb43-4155-b081-fdc8cd41d041'),(271,10.00,5,'59f95bd5-cb43-4155-b081-fdc8cd41d041'),(272,4.85,6,'59f95bd5-cb43-4155-b081-fdc8cd41d041'),(273,43.70,7,'59f95bd5-cb43-4155-b081-fdc8cd41d041'),(274,70.00,13,'59f95bd5-cb43-4155-b081-fdc8cd41d041'),(275,13.07,14,'59f95bd5-cb43-4155-b081-fdc8cd41d041'),(276,563.33,17,'59f95bd5-cb43-4155-b081-fdc8cd41d041'),(277,292.20,19,'59f95bd5-cb43-4155-b081-fdc8cd41d041'),(278,19.71,1,'511394ce-6af6-43e2-ab2e-c76619d4e0a0'),(279,442.04,2,'511394ce-6af6-43e2-ab2e-c76619d4e0a0'),(280,33.42,3,'511394ce-6af6-43e2-ab2e-c76619d4e0a0'),(281,304.13,4,'511394ce-6af6-43e2-ab2e-c76619d4e0a0'),(282,10.00,5,'511394ce-6af6-43e2-ab2e-c76619d4e0a0'),(283,4.85,6,'511394ce-6af6-43e2-ab2e-c76619d4e0a0'),(284,30.28,7,'511394ce-6af6-43e2-ab2e-c76619d4e0a0'),(285,591.00,11,'511394ce-6af6-43e2-ab2e-c76619d4e0a0'),(286,70.00,13,'511394ce-6af6-43e2-ab2e-c76619d4e0a0'),(287,13.40,14,'511394ce-6af6-43e2-ab2e-c76619d4e0a0'),(288,286.54,17,'511394ce-6af6-43e2-ab2e-c76619d4e0a0'),(289,148.63,19,'511394ce-6af6-43e2-ab2e-c76619d4e0a0'),(290,14.47,1,'98c070e9-774e-498b-84be-65e8d49238e6'),(291,518.25,2,'98c070e9-774e-498b-84be-65e8d49238e6'),(292,27.31,3,'98c070e9-774e-498b-84be-65e8d49238e6'),(293,320.38,4,'98c070e9-774e-498b-84be-65e8d49238e6'),(294,10.00,5,'98c070e9-774e-498b-84be-65e8d49238e6'),(295,4.85,6,'98c070e9-774e-498b-84be-65e8d49238e6'),(296,52.71,7,'98c070e9-774e-498b-84be-65e8d49238e6'),(297,732.00,11,'98c070e9-774e-498b-84be-65e8d49238e6'),(298,70.00,13,'98c070e9-774e-498b-84be-65e8d49238e6'),(299,11.57,14,'98c070e9-774e-498b-84be-65e8d49238e6'),(300,411.13,17,'98c070e9-774e-498b-84be-65e8d49238e6'),(301,213.25,19,'98c070e9-774e-498b-84be-65e8d49238e6'),(302,17.34,1,'a4f6abc1-bc01-4aa2-9ec4-1f6031aea995'),(303,443.82,2,'a4f6abc1-bc01-4aa2-9ec4-1f6031aea995'),(304,30.66,3,'a4f6abc1-bc01-4aa2-9ec4-1f6031aea995'),(305,292.88,4,'a4f6abc1-bc01-4aa2-9ec4-1f6031aea995'),(306,10.00,5,'a4f6abc1-bc01-4aa2-9ec4-1f6031aea995'),(307,4.85,6,'a4f6abc1-bc01-4aa2-9ec4-1f6031aea995'),(308,47.62,7,'a4f6abc1-bc01-4aa2-9ec4-1f6031aea995'),(309,606.50,11,'a4f6abc1-bc01-4aa2-9ec4-1f6031aea995'),(310,70.00,13,'a4f6abc1-bc01-4aa2-9ec4-1f6031aea995'),(311,12.57,14,'a4f6abc1-bc01-4aa2-9ec4-1f6031aea995'),(312,313.63,17,'a4f6abc1-bc01-4aa2-9ec4-1f6031aea995'),(313,162.68,19,'a4f6abc1-bc01-4aa2-9ec4-1f6031aea995'),(314,18.70,1,'f5cc078b-fa96-4678-99f1-4de15a238013'),(315,442.58,2,'f5cc078b-fa96-4678-99f1-4de15a238013'),(316,32.25,3,'f5cc078b-fa96-4678-99f1-4de15a238013'),(317,299.46,4,'f5cc078b-fa96-4678-99f1-4de15a238013'),(318,10.00,5,'f5cc078b-fa96-4678-99f1-4de15a238013'),(319,4.85,6,'f5cc078b-fa96-4678-99f1-4de15a238013'),(320,33.27,7,'f5cc078b-fa96-4678-99f1-4de15a238013'),(321,596.83,11,'f5cc078b-fa96-4678-99f1-4de15a238013'),(322,70.00,13,'f5cc078b-fa96-4678-99f1-4de15a238013'),(323,13.05,14,'f5cc078b-fa96-4678-99f1-4de15a238013'),(324,297.38,17,'f5cc078b-fa96-4678-99f1-4de15a238013'),(325,154.25,19,'f5cc078b-fa96-4678-99f1-4de15a238013'),(326,17.72,1,'a04f69c3-03a6-4a75-9f6e-48fbef1e53c7'),(327,434.61,2,'a04f69c3-03a6-4a75-9f6e-48fbef1e53c7'),(328,31.10,3,'a04f69c3-03a6-4a75-9f6e-48fbef1e53c7'),(329,288.88,4,'a04f69c3-03a6-4a75-9f6e-48fbef1e53c7'),(330,10.00,5,'a04f69c3-03a6-4a75-9f6e-48fbef1e53c7'),(331,4.85,6,'a04f69c3-03a6-4a75-9f6e-48fbef1e53c7'),(332,55.46,7,'a04f69c3-03a6-4a75-9f6e-48fbef1e53c7'),(333,591.67,11,'a04f69c3-03a6-4a75-9f6e-48fbef1e53c7'),(334,70.00,13,'a04f69c3-03a6-4a75-9f6e-48fbef1e53c7'),(335,12.70,14,'a04f69c3-03a6-4a75-9f6e-48fbef1e53c7'),(336,302.79,17,'a04f69c3-03a6-4a75-9f6e-48fbef1e53c7'),(337,157.06,19,'a04f69c3-03a6-4a75-9f6e-48fbef1e53c7'),(338,10.49,1,'192bcc3f-cd37-447f-9603-dc665c89fcdb'),(339,322.38,2,'192bcc3f-cd37-447f-9603-dc665c89fcdb'),(340,22.66,3,'192bcc3f-cd37-447f-9603-dc665c89fcdb'),(341,174.04,4,'192bcc3f-cd37-447f-9603-dc665c89fcdb'),(342,10.00,5,'192bcc3f-cd37-447f-9603-dc665c89fcdb'),(343,4.85,6,'192bcc3f-cd37-447f-9603-dc665c89fcdb'),(344,35.92,7,'192bcc3f-cd37-447f-9603-dc665c89fcdb'),(345,482.25,11,'192bcc3f-cd37-447f-9603-dc665c89fcdb'),(346,70.00,13,'192bcc3f-cd37-447f-9603-dc665c89fcdb'),(347,10.17,14,'192bcc3f-cd37-447f-9603-dc665c89fcdb'),(348,308.21,17,'192bcc3f-cd37-447f-9603-dc665c89fcdb'),(349,159.87,19,'192bcc3f-cd37-447f-9603-dc665c89fcdb'),(350,17.80,1,'4a6e242b-bb85-45c7-89c2-3bbfd2a2aadf'),(351,436.01,2,'4a6e242b-bb85-45c7-89c2-3bbfd2a2aadf'),(352,31.20,3,'4a6e242b-bb85-45c7-89c2-3bbfd2a2aadf'),(353,290.28,4,'4a6e242b-bb85-45c7-89c2-3bbfd2a2aadf'),(354,10.00,5,'4a6e242b-bb85-45c7-89c2-3bbfd2a2aadf'),(355,4.85,6,'4a6e242b-bb85-45c7-89c2-3bbfd2a2aadf'),(356,55.90,7,'4a6e242b-bb85-45c7-89c2-3bbfd2a2aadf'),(357,593.07,11,'4a6e242b-bb85-45c7-89c2-3bbfd2a2aadf'),(358,70.00,13,'4a6e242b-bb85-45c7-89c2-3bbfd2a2aadf'),(359,12.73,14,'4a6e242b-bb85-45c7-89c2-3bbfd2a2aadf'),(360,302.79,17,'4a6e242b-bb85-45c7-89c2-3bbfd2a2aadf'),(361,157.06,19,'4a6e242b-bb85-45c7-89c2-3bbfd2a2aadf'),(362,14.54,1,'f5639883-c055-4e7e-8ff5-07f934c9a5f2'),(363,478.61,2,'f5639883-c055-4e7e-8ff5-07f934c9a5f2'),(364,27.39,3,'f5639883-c055-4e7e-8ff5-07f934c9a5f2'),(365,296.38,4,'f5639883-c055-4e7e-8ff5-07f934c9a5f2'),(366,10.00,5,'f5639883-c055-4e7e-8ff5-07f934c9a5f2'),(367,4.85,6,'f5639883-c055-4e7e-8ff5-07f934c9a5f2'),(368,53.65,7,'f5639883-c055-4e7e-8ff5-07f934c9a5f2'),(369,675.00,11,'f5639883-c055-4e7e-8ff5-07f934c9a5f2'),(370,70.00,13,'f5639883-c055-4e7e-8ff5-07f934c9a5f2'),(371,11.59,14,'f5639883-c055-4e7e-8ff5-07f934c9a5f2'),(372,378.63,17,'f5639883-c055-4e7e-8ff5-07f934c9a5f2'),(373,196.39,19,'f5639883-c055-4e7e-8ff5-07f934c9a5f2'),(374,14.91,1,'5478e68f-7a96-44c7-a370-e71e3a8e9473'),(375,395.80,2,'5478e68f-7a96-44c7-a370-e71e3a8e9473'),(376,27.82,3,'5478e68f-7a96-44c7-a370-e71e3a8e9473'),(377,247.46,4,'5478e68f-7a96-44c7-a370-e71e3a8e9473'),(378,10.00,5,'5478e68f-7a96-44c7-a370-e71e3a8e9473'),(379,4.85,6,'5478e68f-7a96-44c7-a370-e71e3a8e9473'),(380,51.73,7,'5478e68f-7a96-44c7-a370-e71e3a8e9473'),(381,555.67,11,'5478e68f-7a96-44c7-a370-e71e3a8e9473'),(382,70.00,13,'5478e68f-7a96-44c7-a370-e71e3a8e9473'),(383,11.72,14,'5478e68f-7a96-44c7-a370-e71e3a8e9473'),(384,308.21,17,'5478e68f-7a96-44c7-a370-e71e3a8e9473'),(385,159.87,19,'5478e68f-7a96-44c7-a370-e71e3a8e9473'),(386,17.34,1,'e8316eac-53b7-42c1-b4cc-d1448534ea56'),(387,413.06,2,'e8316eac-53b7-42c1-b4cc-d1448534ea56'),(388,30.65,3,'e8316eac-53b7-42c1-b4cc-d1448534ea56'),(389,272.54,4,'e8316eac-53b7-42c1-b4cc-d1448534ea56'),(390,10.00,5,'e8316eac-53b7-42c1-b4cc-d1448534ea56'),(391,4.85,6,'e8316eac-53b7-42c1-b4cc-d1448534ea56'),(392,53.47,7,'e8316eac-53b7-42c1-b4cc-d1448534ea56'),(393,564.50,11,'e8316eac-53b7-42c1-b4cc-d1448534ea56'),(394,70.00,13,'e8316eac-53b7-42c1-b4cc-d1448534ea56'),(395,12.57,14,'e8316eac-53b7-42c1-b4cc-d1448534ea56'),(396,291.96,17,'e8316eac-53b7-42c1-b4cc-d1448534ea56'),(397,151.44,19,'e8316eac-53b7-42c1-b4cc-d1448534ea56'),(398,15.91,1,'d510b66a-cfd8-41e7-bf2c-92355a46b8f5'),(399,390.56,2,'d510b66a-cfd8-41e7-bf2c-92355a46b8f5'),(400,28.98,3,'d510b66a-cfd8-41e7-bf2c-92355a46b8f5'),(401,250.04,4,'d510b66a-cfd8-41e7-bf2c-92355a46b8f5'),(402,10.00,5,'d510b66a-cfd8-41e7-bf2c-92355a46b8f5'),(403,4.85,6,'d510b66a-cfd8-41e7-bf2c-92355a46b8f5'),(404,60.16,7,'d510b66a-cfd8-41e7-bf2c-92355a46b8f5'),(405,542.00,11,'d510b66a-cfd8-41e7-bf2c-92355a46b8f5'),(406,70.00,13,'d510b66a-cfd8-41e7-bf2c-92355a46b8f5'),(407,12.07,14,'d510b66a-cfd8-41e7-bf2c-92355a46b8f5'),(408,291.96,17,'d510b66a-cfd8-41e7-bf2c-92355a46b8f5'),(409,151.44,19,'d510b66a-cfd8-41e7-bf2c-92355a46b8f5'),(410,18.93,1,'796b7f27-301e-42f8-8c32-466ca1f17796'),(411,470.66,2,'796b7f27-301e-42f8-8c32-466ca1f17796'),(412,32.52,3,'796b7f27-301e-42f8-8c32-466ca1f17796'),(413,319.71,4,'796b7f27-301e-42f8-8c32-466ca1f17796'),(414,10.00,5,'796b7f27-301e-42f8-8c32-466ca1f17796'),(415,4.85,6,'796b7f27-301e-42f8-8c32-466ca1f17796'),(416,37.72,7,'796b7f27-301e-42f8-8c32-466ca1f17796'),(417,633.00,11,'796b7f27-301e-42f8-8c32-466ca1f17796'),(418,70.00,13,'796b7f27-301e-42f8-8c32-466ca1f17796'),(419,13.13,14,'796b7f27-301e-42f8-8c32-466ca1f17796'),(420,313.63,17,'796b7f27-301e-42f8-8c32-466ca1f17796'),(421,162.68,19,'796b7f27-301e-42f8-8c32-466ca1f17796'),(422,16.23,1,'0881c81c-c3ce-4987-8b15-c344942a9b59'),(423,403.80,2,'0881c81c-c3ce-4987-8b15-c344942a9b59'),(424,29.37,3,'0881c81c-c3ce-4987-8b15-c344942a9b59'),(425,260.42,4,'0881c81c-c3ce-4987-8b15-c344942a9b59'),(426,10.00,5,'0881c81c-c3ce-4987-8b15-c344942a9b59'),(427,4.85,6,'0881c81c-c3ce-4987-8b15-c344942a9b59'),(428,33.21,7,'0881c81c-c3ce-4987-8b15-c344942a9b59'),(429,558.00,11,'0881c81c-c3ce-4987-8b15-c344942a9b59'),(430,70.00,13,'0881c81c-c3ce-4987-8b15-c344942a9b59'),(431,12.18,14,'0881c81c-c3ce-4987-8b15-c344942a9b59'),(432,297.92,17,'0881c81c-c3ce-4987-8b15-c344942a9b59'),(433,154.53,19,'0881c81c-c3ce-4987-8b15-c344942a9b59'),(434,16.56,1,'a1b48900-5944-4c7d-b877-04a7332ceb7d'),(435,415.69,2,'a1b48900-5944-4c7d-b877-04a7332ceb7d'),(436,29.75,3,'a1b48900-5944-4c7d-b877-04a7332ceb7d'),(437,269.96,4,'a1b48900-5944-4c7d-b877-04a7332ceb7d'),(438,10.00,5,'a1b48900-5944-4c7d-b877-04a7332ceb7d'),(439,4.85,6,'a1b48900-5944-4c7d-b877-04a7332ceb7d'),(440,33.98,7,'a1b48900-5944-4c7d-b877-04a7332ceb7d'),(441,572.75,11,'a1b48900-5944-4c7d-b877-04a7332ceb7d'),(442,70.00,13,'a1b48900-5944-4c7d-b877-04a7332ceb7d'),(443,12.30,14,'a1b48900-5944-4c7d-b877-04a7332ceb7d'),(444,302.79,17,'a1b48900-5944-4c7d-b877-04a7332ceb7d'),(445,157.06,19,'a1b48900-5944-4c7d-b877-04a7332ceb7d'),(446,13.95,1,'330d65db-e9b5-4a3a-b616-2bf5aa6bb897'),(447,594.11,2,'330d65db-e9b5-4a3a-b616-2bf5aa6bb897'),(448,26.70,3,'330d65db-e9b5-4a3a-b616-2bf5aa6bb897'),(449,362.08,4,'330d65db-e9b5-4a3a-b616-2bf5aa6bb897'),(450,10.00,5,'330d65db-e9b5-4a3a-b616-2bf5aa6bb897'),(451,4.85,6,'330d65db-e9b5-4a3a-b616-2bf5aa6bb897'),(452,57.79,7,'330d65db-e9b5-4a3a-b616-2bf5aa6bb897'),(453,844.00,11,'330d65db-e9b5-4a3a-b616-2bf5aa6bb897'),(454,70.00,13,'330d65db-e9b5-4a3a-b616-2bf5aa6bb897'),(455,11.38,14,'330d65db-e9b5-4a3a-b616-2bf5aa6bb897'),(456,482.08,17,'330d65db-e9b5-4a3a-b616-2bf5aa6bb897'),(457,250.06,19,'330d65db-e9b5-4a3a-b616-2bf5aa6bb897'),(458,15.92,1,'22802a1e-fc96-4f25-9e87-84040be2ca2e'),(459,239.76,2,'22802a1e-fc96-4f25-9e87-84040be2ca2e'),(460,29.97,3,'22802a1e-fc96-4f25-9e87-84040be2ca2e'),(461,212.26,4,'22802a1e-fc96-4f25-9e87-84040be2ca2e'),(462,8.00,5,'22802a1e-fc96-4f25-9e87-84040be2ca2e'),(463,4.85,6,'22802a1e-fc96-4f25-9e87-84040be2ca2e'),(464,27.59,7,'22802a1e-fc96-4f25-9e87-84040be2ca2e'),(465,329.67,11,'22802a1e-fc96-4f25-9e87-84040be2ca2e'),(466,70.00,13,'22802a1e-fc96-4f25-9e87-84040be2ca2e'),(467,12.36,14,'22802a1e-fc96-4f25-9e87-84040be2ca2e'),(468,106.26,17,'22802a1e-fc96-4f25-9e87-84040be2ca2e'),(469,89.91,19,'22802a1e-fc96-4f25-9e87-84040be2ca2e'),(470,14.89,1,'dcc04529-f5d2-466f-a170-4b9316e1b9b4'),(471,402.32,2,'dcc04529-f5d2-466f-a170-4b9316e1b9b4'),(472,27.79,3,'dcc04529-f5d2-466f-a170-4b9316e1b9b4'),(473,251.38,4,'dcc04529-f5d2-466f-a170-4b9316e1b9b4'),(474,10.00,5,'dcc04529-f5d2-466f-a170-4b9316e1b9b4'),(475,4.85,6,'dcc04529-f5d2-466f-a170-4b9316e1b9b4'),(476,51.47,7,'dcc04529-f5d2-466f-a170-4b9316e1b9b4'),(477,565.00,11,'dcc04529-f5d2-466f-a170-4b9316e1b9b4'),(478,70.00,13,'dcc04529-f5d2-466f-a170-4b9316e1b9b4'),(479,11.71,14,'dcc04529-f5d2-466f-a170-4b9316e1b9b4'),(480,313.63,17,'dcc04529-f5d2-466f-a170-4b9316e1b9b4'),(481,162.68,19,'dcc04529-f5d2-466f-a170-4b9316e1b9b4'),(482,10.49,1,'e175e126-908d-43d9-81e5-a3489a8d58e6'),(483,464.61,2,'e175e126-908d-43d9-81e5-a3489a8d58e6'),(484,22.66,3,'e175e126-908d-43d9-81e5-a3489a8d58e6'),(485,250.83,4,'e175e126-908d-43d9-81e5-a3489a8d58e6'),(486,10.00,5,'e175e126-908d-43d9-81e5-a3489a8d58e6'),(487,4.85,6,'e175e126-908d-43d9-81e5-a3489a8d58e6'),(488,62.50,7,'e175e126-908d-43d9-81e5-a3489a8d58e6'),(489,695.00,11,'e175e126-908d-43d9-81e5-a3489a8d58e6'),(490,70.00,13,'e175e126-908d-43d9-81e5-a3489a8d58e6'),(491,10.17,14,'e175e126-908d-43d9-81e5-a3489a8d58e6'),(492,444.17,17,'e175e126-908d-43d9-81e5-a3489a8d58e6'),(493,230.39,19,'e175e126-908d-43d9-81e5-a3489a8d58e6'),(494,18.75,1,'e2f6c512-8327-401e-8f3a-ea8c57c8b59a'),(495,467.66,2,'e2f6c512-8327-401e-8f3a-ea8c57c8b59a'),(496,32.31,3,'e2f6c512-8327-401e-8f3a-ea8c57c8b59a'),(497,316.71,4,'e2f6c512-8327-401e-8f3a-ea8c57c8b59a'),(498,10.00,5,'e2f6c512-8327-401e-8f3a-ea8c57c8b59a'),(499,4.85,6,'e2f6c512-8327-401e-8f3a-ea8c57c8b59a'),(500,48.70,7,'e2f6c512-8327-401e-8f3a-ea8c57c8b59a'),(501,630.33,11,'e2f6c512-8327-401e-8f3a-ea8c57c8b59a'),(502,70.00,13,'e2f6c512-8327-401e-8f3a-ea8c57c8b59a'),(503,13.06,14,'e2f6c512-8327-401e-8f3a-ea8c57c8b59a'),(504,313.63,17,'e2f6c512-8327-401e-8f3a-ea8c57c8b59a'),(505,162.68,19,'e2f6c512-8327-401e-8f3a-ea8c57c8b59a'),(506,17.06,1,'783eddaf-8efe-4c7c-b3e9-edbe702b5dd1'),(507,304.56,2,'783eddaf-8efe-4c7c-b3e9-edbe702b5dd1'),(508,30.53,3,'783eddaf-8efe-4c7c-b3e9-edbe702b5dd1'),(509,283.67,4,'783eddaf-8efe-4c7c-b3e9-edbe702b5dd1'),(510,8.00,5,'783eddaf-8efe-4c7c-b3e9-edbe702b5dd1'),(511,4.85,6,'783eddaf-8efe-4c7c-b3e9-edbe702b5dd1'),(512,33.76,7,'783eddaf-8efe-4c7c-b3e9-edbe702b5dd1'),(513,416.67,11,'783eddaf-8efe-4c7c-b3e9-edbe702b5dd1'),(514,70.00,13,'783eddaf-8efe-4c7c-b3e9-edbe702b5dd1'),(515,12.53,14,'783eddaf-8efe-4c7c-b3e9-edbe702b5dd1'),(516,133.00,17,'783eddaf-8efe-4c7c-b3e9-edbe702b5dd1'),(517,112.10,19,'783eddaf-8efe-4c7c-b3e9-edbe702b5dd1'),(518,18.91,1,'298c0b92-b5b6-48e5-9ae1-528bff4d548f'),(519,470.32,2,'298c0b92-b5b6-48e5-9ae1-528bff4d548f'),(520,32.49,3,'298c0b92-b5b6-48e5-9ae1-528bff4d548f'),(521,319.38,4,'298c0b92-b5b6-48e5-9ae1-528bff4d548f'),(522,10.00,5,'298c0b92-b5b6-48e5-9ae1-528bff4d548f'),(523,4.85,6,'298c0b92-b5b6-48e5-9ae1-528bff4d548f'),(524,62.59,7,'298c0b92-b5b6-48e5-9ae1-528bff4d548f'),(525,633.00,11,'298c0b92-b5b6-48e5-9ae1-528bff4d548f'),(526,70.00,13,'298c0b92-b5b6-48e5-9ae1-528bff4d548f'),(527,13.12,14,'298c0b92-b5b6-48e5-9ae1-528bff4d548f'),(528,313.63,17,'298c0b92-b5b6-48e5-9ae1-528bff4d548f'),(529,162.68,19,'298c0b92-b5b6-48e5-9ae1-528bff4d548f'),(530,17.98,1,'ece8374d-df4b-404e-9961-19a699a7ce91'),(531,446.80,2,'ece8374d-df4b-404e-9961-19a699a7ce91'),(532,31.41,3,'ece8374d-df4b-404e-9961-19a699a7ce91'),(533,298.46,4,'ece8374d-df4b-404e-9961-19a699a7ce91'),(534,10.00,5,'ece8374d-df4b-404e-9961-19a699a7ce91'),(535,4.85,6,'ece8374d-df4b-404e-9961-19a699a7ce91'),(536,48.18,7,'ece8374d-df4b-404e-9961-19a699a7ce91'),(537,606.67,11,'ece8374d-df4b-404e-9961-19a699a7ce91'),(538,70.00,13,'ece8374d-df4b-404e-9961-19a699a7ce91'),(539,12.79,14,'ece8374d-df4b-404e-9961-19a699a7ce91'),(540,308.21,17,'ece8374d-df4b-404e-9961-19a699a7ce91'),(541,159.87,19,'ece8374d-df4b-404e-9961-19a699a7ce91'),(542,19.57,1,'b90744c6-b9d0-430d-927e-312fe1fb93d2'),(543,411.59,2,'b90744c6-b9d0-430d-927e-312fe1fb93d2'),(544,33.26,3,'b90744c6-b9d0-430d-927e-312fe1fb93d2'),(545,282.54,4,'b90744c6-b9d0-430d-927e-312fe1fb93d2'),(546,10.00,5,'b90744c6-b9d0-430d-927e-312fe1fb93d2'),(547,4.85,6,'b90744c6-b9d0-430d-927e-312fe1fb93d2'),(548,48.62,7,'b90744c6-b9d0-430d-927e-312fe1fb93d2'),(549,550.67,11,'b90744c6-b9d0-430d-927e-312fe1fb93d2'),(550,70.00,13,'b90744c6-b9d0-430d-927e-312fe1fb93d2'),(551,13.35,14,'b90744c6-b9d0-430d-927e-312fe1fb93d2'),(552,268.13,17,'b90744c6-b9d0-430d-927e-312fe1fb93d2'),(553,139.08,19,'b90744c6-b9d0-430d-927e-312fe1fb93d2'),(554,20.25,1,'ef22d2cc-e160-44d9-848c-0740f1e97ab2'),(555,391.56,2,'ef22d2cc-e160-44d9-848c-0740f1e97ab2'),(556,34.05,3,'ef22d2cc-e160-44d9-848c-0740f1e97ab2'),(557,271.63,4,'ef22d2cc-e160-44d9-848c-0740f1e97ab2'),(558,10.00,5,'ef22d2cc-e160-44d9-848c-0740f1e97ab2'),(559,4.85,6,'ef22d2cc-e160-44d9-848c-0740f1e97ab2'),(560,39.90,7,'ef22d2cc-e160-44d9-848c-0740f1e97ab2'),(561,520.80,11,'ef22d2cc-e160-44d9-848c-0740f1e97ab2'),(562,70.00,13,'ef22d2cc-e160-44d9-848c-0740f1e97ab2'),(563,13.59,14,'ef22d2cc-e160-44d9-848c-0740f1e97ab2'),(564,249.17,17,'ef22d2cc-e160-44d9-848c-0740f1e97ab2'),(565,129.24,19,'ef22d2cc-e160-44d9-848c-0740f1e97ab2'),(566,18.12,1,'1cf7457f-e9ee-4801-80e6-ded44b3a1b7a'),(567,433.25,2,'1cf7457f-e9ee-4801-80e6-ded44b3a1b7a'),(568,31.57,3,'1cf7457f-e9ee-4801-80e6-ded44b3a1b7a'),(569,290.13,4,'1cf7457f-e9ee-4801-80e6-ded44b3a1b7a'),(570,10.00,5,'1cf7457f-e9ee-4801-80e6-ded44b3a1b7a'),(571,4.85,6,'1cf7457f-e9ee-4801-80e6-ded44b3a1b7a'),(572,49.55,7,'1cf7457f-e9ee-4801-80e6-ded44b3a1b7a'),(573,587.50,11,'1cf7457f-e9ee-4801-80e6-ded44b3a1b7a'),(574,70.00,13,'1cf7457f-e9ee-4801-80e6-ded44b3a1b7a'),(575,12.84,14,'1cf7457f-e9ee-4801-80e6-ded44b3a1b7a'),(576,297.38,17,'1cf7457f-e9ee-4801-80e6-ded44b3a1b7a'),(577,154.25,19,'1cf7457f-e9ee-4801-80e6-ded44b3a1b7a'),(578,20.11,1,'18668aac-5320-4c10-b72f-0a5d8fe56985'),(579,482.13,2,'18668aac-5320-4c10-b72f-0a5d8fe56985'),(580,33.89,3,'18668aac-5320-4c10-b72f-0a5d8fe56985'),(581,333.79,4,'18668aac-5320-4c10-b72f-0a5d8fe56985'),(582,10.00,5,'18668aac-5320-4c10-b72f-0a5d8fe56985'),(583,4.85,6,'18668aac-5320-4c10-b72f-0a5d8fe56985'),(584,50.44,7,'18668aac-5320-4c10-b72f-0a5d8fe56985'),(585,642.00,11,'18668aac-5320-4c10-b72f-0a5d8fe56985'),(586,70.00,13,'18668aac-5320-4c10-b72f-0a5d8fe56985'),(587,13.54,14,'18668aac-5320-4c10-b72f-0a5d8fe56985'),(588,308.21,17,'18668aac-5320-4c10-b72f-0a5d8fe56985'),(589,159.87,19,'18668aac-5320-4c10-b72f-0a5d8fe56985'),(590,19.38,1,'8eff875f-0d68-41c3-a7c2-e7923bdf0559'),(591,498.71,2,'8eff875f-0d68-41c3-a7c2-e7923bdf0559'),(592,34.39,3,'8eff875f-0d68-41c3-a7c2-e7923bdf0559'),(593,468.33,4,'8eff875f-0d68-41c3-a7c2-e7923bdf0559'),(594,8.00,5,'8eff875f-0d68-41c3-a7c2-e7923bdf0559'),(595,4.85,6,'8eff875f-0d68-41c3-a7c2-e7923bdf0559'),(596,53.41,7,'8eff875f-0d68-41c3-a7c2-e7923bdf0559'),(597,661.67,11,'8eff875f-0d68-41c3-a7c2-e7923bdf0559'),(598,68.00,13,'8eff875f-0d68-41c3-a7c2-e7923bdf0559'),(599,13.69,14,'8eff875f-0d68-41c3-a7c2-e7923bdf0559'),(600,193.33,17,'8eff875f-0d68-41c3-a7c2-e7923bdf0559'),(601,162.96,19,'8eff875f-0d68-41c3-a7c2-e7923bdf0559'),(602,22.49,1,'f91fa59e-4905-4877-b366-9456815c019f'),(603,426.27,2,'f91fa59e-4905-4877-b366-9456815c019f'),(604,36.67,3,'f91fa59e-4905-4877-b366-9456815c019f'),(605,305.04,4,'f91fa59e-4905-4877-b366-9456815c019f'),(606,10.00,5,'f91fa59e-4905-4877-b366-9456815c019f'),(607,4.85,6,'f91fa59e-4905-4877-b366-9456815c019f'),(608,44.29,7,'f91fa59e-4905-4877-b366-9456815c019f'),(609,556.92,11,'f91fa59e-4905-4877-b366-9456815c019f'),(610,70.00,13,'f91fa59e-4905-4877-b366-9456815c019f'),(611,14.37,14,'f91fa59e-4905-4877-b366-9456815c019f'),(612,251.88,17,'f91fa59e-4905-4877-b366-9456815c019f'),(613,130.65,19,'f91fa59e-4905-4877-b366-9456815c019f'),(614,23.15,1,'2c5a23b9-ffc4-4212-820d-87aa9b1a9959'),(615,439.85,2,'2c5a23b9-ffc4-4212-820d-87aa9b1a9959'),(616,37.43,3,'2c5a23b9-ffc4-4212-820d-87aa9b1a9959'),(617,317.32,4,'2c5a23b9-ffc4-4212-820d-87aa9b1a9959'),(618,10.00,5,'2c5a23b9-ffc4-4212-820d-87aa9b1a9959'),(619,4.85,6,'2c5a23b9-ffc4-4212-820d-87aa9b1a9959'),(620,34.46,7,'2c5a23b9-ffc4-4212-820d-87aa9b1a9959'),(621,571.90,11,'2c5a23b9-ffc4-4212-820d-87aa9b1a9959'),(622,70.00,13,'2c5a23b9-ffc4-4212-820d-87aa9b1a9959'),(623,14.60,14,'2c5a23b9-ffc4-4212-820d-87aa9b1a9959'),(624,254.58,17,'2c5a23b9-ffc4-4212-820d-87aa9b1a9959'),(625,132.05,19,'2c5a23b9-ffc4-4212-820d-87aa9b1a9959'),(626,27.14,1,'d4d9bfc2-9758-4734-b55d-16dfba41fd4d'),(627,499.88,2,'d4d9bfc2-9758-4734-b55d-16dfba41fd4d'),(628,42.09,3,'d4d9bfc2-9758-4734-b55d-16dfba41fd4d'),(629,376.04,4,'d4d9bfc2-9758-4734-b55d-16dfba41fd4d'),(630,10.00,5,'d4d9bfc2-9758-4734-b55d-16dfba41fd4d'),(631,4.85,6,'d4d9bfc2-9758-4734-b55d-16dfba41fd4d'),(632,40.91,7,'d4d9bfc2-9758-4734-b55d-16dfba41fd4d'),(633,633.33,11,'d4d9bfc2-9758-4734-b55d-16dfba41fd4d'),(634,70.00,13,'d4d9bfc2-9758-4734-b55d-16dfba41fd4d'),(635,16.00,14,'d4d9bfc2-9758-4734-b55d-16dfba41fd4d'),(636,257.29,17,'d4d9bfc2-9758-4734-b55d-16dfba41fd4d'),(637,133.46,19,'d4d9bfc2-9758-4734-b55d-16dfba41fd4d'),(638,18.21,1,'eb4e2198-6224-4ca9-86d3-0461aa5f6d5c'),(639,368.18,2,'eb4e2198-6224-4ca9-86d3-0461aa5f6d5c'),(640,31.67,3,'eb4e2198-6224-4ca9-86d3-0461aa5f6d5c'),(641,246.96,4,'eb4e2198-6224-4ca9-86d3-0461aa5f6d5c'),(642,10.00,5,'eb4e2198-6224-4ca9-86d3-0461aa5f6d5c'),(643,4.85,6,'eb4e2198-6224-4ca9-86d3-0461aa5f6d5c'),(644,29.06,7,'eb4e2198-6224-4ca9-86d3-0461aa5f6d5c'),(645,498.83,11,'eb4e2198-6224-4ca9-86d3-0461aa5f6d5c'),(646,70.00,13,'eb4e2198-6224-4ca9-86d3-0461aa5f6d5c'),(647,12.87,14,'eb4e2198-6224-4ca9-86d3-0461aa5f6d5c'),(648,251.88,17,'eb4e2198-6224-4ca9-86d3-0461aa5f6d5c'),(649,130.65,19,'eb4e2198-6224-4ca9-86d3-0461aa5f6d5c'),(650,25.30,1,'66d77963-5aa0-49fd-9fce-2fca654bac4c'),(651,474.38,2,'66d77963-5aa0-49fd-9fce-2fca654bac4c'),(652,39.95,3,'66d77963-5aa0-49fd-9fce-2fca654bac4c'),(653,350.54,4,'66d77963-5aa0-49fd-9fce-2fca654bac4c'),(654,10.00,5,'66d77963-5aa0-49fd-9fce-2fca654bac4c'),(655,4.85,6,'66d77963-5aa0-49fd-9fce-2fca654bac4c'),(656,43.18,7,'66d77963-5aa0-49fd-9fce-2fca654bac4c'),(657,607.83,11,'66d77963-5aa0-49fd-9fce-2fca654bac4c'),(658,70.00,13,'66d77963-5aa0-49fd-9fce-2fca654bac4c'),(659,15.36,14,'66d77963-5aa0-49fd-9fce-2fca654bac4c'),(660,257.29,17,'66d77963-5aa0-49fd-9fce-2fca654bac4c'),(661,133.46,19,'66d77963-5aa0-49fd-9fce-2fca654bac4c'),(662,17.12,1,'1882100a-b3fb-4f48-91fd-f86d836e5806'),(663,398.99,2,'1882100a-b3fb-4f48-91fd-f86d836e5806'),(664,30.40,3,'1882100a-b3fb-4f48-91fd-f86d836e5806'),(665,262.13,4,'1882100a-b3fb-4f48-91fd-f86d836e5806'),(666,10.00,5,'1882100a-b3fb-4f48-91fd-f86d836e5806'),(667,4.85,6,'1882100a-b3fb-4f48-91fd-f86d836e5806'),(668,43.75,7,'1882100a-b3fb-4f48-91fd-f86d836e5806'),(669,546.50,11,'1882100a-b3fb-4f48-91fd-f86d836e5806'),(670,70.00,13,'1882100a-b3fb-4f48-91fd-f86d836e5806'),(671,12.49,14,'1882100a-b3fb-4f48-91fd-f86d836e5806'),(672,284.38,17,'1882100a-b3fb-4f48-91fd-f86d836e5806'),(673,147.51,19,'1882100a-b3fb-4f48-91fd-f86d836e5806'),(674,18.50,1,'620c3352-316a-4d20-b7ea-3e651c86c19b'),(675,312.09,2,'620c3352-316a-4d20-b7ea-3e651c86c19b'),(676,32.01,3,'620c3352-316a-4d20-b7ea-3e651c86c19b'),(677,210.42,4,'620c3352-316a-4d20-b7ea-3e651c86c19b'),(678,10.00,5,'620c3352-316a-4d20-b7ea-3e651c86c19b'),(679,4.85,6,'620c3352-316a-4d20-b7ea-3e651c86c19b'),(680,35.45,7,'620c3352-316a-4d20-b7ea-3e651c86c19b'),(681,421.67,11,'620c3352-316a-4d20-b7ea-3e651c86c19b'),(682,70.00,13,'620c3352-316a-4d20-b7ea-3e651c86c19b'),(683,12.97,14,'620c3352-316a-4d20-b7ea-3e651c86c19b'),(684,211.25,17,'620c3352-316a-4d20-b7ea-3e651c86c19b'),(685,109.58,19,'620c3352-316a-4d20-b7ea-3e651c86c19b'),(686,18.55,1,'f6ac9845-6b56-4703-a09e-86eaeff92392'),(687,288.60,2,'f6ac9845-6b56-4703-a09e-86eaeff92392'),(688,32.07,3,'f6ac9845-6b56-4703-a09e-86eaeff92392'),(689,194.75,4,'f6ac9845-6b56-4703-a09e-86eaeff92392'),(690,10.00,5,'f6ac9845-6b56-4703-a09e-86eaeff92392'),(691,4.85,6,'f6ac9845-6b56-4703-a09e-86eaeff92392'),(692,41.67,7,'f6ac9845-6b56-4703-a09e-86eaeff92392'),(693,390.00,11,'f6ac9845-6b56-4703-a09e-86eaeff92392'),(694,70.00,13,'f6ac9845-6b56-4703-a09e-86eaeff92392'),(695,12.99,14,'f6ac9845-6b56-4703-a09e-86eaeff92392'),(696,195.00,17,'f6ac9845-6b56-4703-a09e-86eaeff92392'),(697,101.15,19,'f6ac9845-6b56-4703-a09e-86eaeff92392'),(698,20.06,1,'b5d8e52c-c775-43a0-82dd-d3b263c6d812'),(699,329.84,2,'b5d8e52c-c775-43a0-82dd-d3b263c6d812'),(700,33.83,3,'b5d8e52c-c775-43a0-82dd-d3b263c6d812'),(701,228.17,4,'b5d8e52c-c775-43a0-82dd-d3b263c6d812'),(702,10.00,5,'b5d8e52c-c775-43a0-82dd-d3b263c6d812'),(703,4.85,6,'b5d8e52c-c775-43a0-82dd-d3b263c6d812'),(704,58.04,7,'b5d8e52c-c775-43a0-82dd-d3b263c6d812'),(705,439.42,11,'b5d8e52c-c775-43a0-82dd-d3b263c6d812'),(706,70.00,13,'b5d8e52c-c775-43a0-82dd-d3b263c6d812'),(707,13.52,14,'b5d8e52c-c775-43a0-82dd-d3b263c6d812'),(708,211.25,17,'b5d8e52c-c775-43a0-82dd-d3b263c6d812'),(709,109.58,19,'b5d8e52c-c775-43a0-82dd-d3b263c6d812'),(710,17.93,1,'afb55670-6dfe-4bc8-8d4a-0b0edd9c7e48'),(711,383.99,2,'afb55670-6dfe-4bc8-8d4a-0b0edd9c7e48'),(712,31.35,3,'afb55670-6dfe-4bc8-8d4a-0b0edd9c7e48'),(713,256.25,4,'afb55670-6dfe-4bc8-8d4a-0b0edd9c7e48'),(714,10.00,5,'afb55670-6dfe-4bc8-8d4a-0b0edd9c7e48'),(715,4.85,6,'afb55670-6dfe-4bc8-8d4a-0b0edd9c7e48'),(716,37.12,7,'afb55670-6dfe-4bc8-8d4a-0b0edd9c7e48'),(717,521.67,11,'afb55670-6dfe-4bc8-8d4a-0b0edd9c7e48'),(718,70.00,13,'afb55670-6dfe-4bc8-8d4a-0b0edd9c7e48'),(719,12.78,14,'afb55670-6dfe-4bc8-8d4a-0b0edd9c7e48'),(720,265.42,17,'afb55670-6dfe-4bc8-8d4a-0b0edd9c7e48'),(721,137.67,19,'afb55670-6dfe-4bc8-8d4a-0b0edd9c7e48'),(722,16.28,1,'1f99dee2-d892-439a-a9ce-2570fce95a94'),(723,286.84,2,'1f99dee2-d892-439a-a9ce-2570fce95a94'),(724,29.42,3,'1f99dee2-d892-439a-a9ce-2570fce95a94'),(725,185.17,4,'1f99dee2-d892-439a-a9ce-2570fce95a94'),(726,10.00,5,'1f99dee2-d892-439a-a9ce-2570fce95a94'),(727,4.85,6,'1f99dee2-d892-439a-a9ce-2570fce95a94'),(728,32.50,7,'1f99dee2-d892-439a-a9ce-2570fce95a94'),(729,396.42,11,'1f99dee2-d892-439a-a9ce-2570fce95a94'),(730,70.00,13,'1f99dee2-d892-439a-a9ce-2570fce95a94'),(731,12.20,14,'1f99dee2-d892-439a-a9ce-2570fce95a94'),(732,211.25,17,'1f99dee2-d892-439a-a9ce-2570fce95a94'),(733,109.58,19,'1f99dee2-d892-439a-a9ce-2570fce95a94'),(734,14.28,1,'ffa86c4b-3b05-4f1d-b495-49f6b7b26c05'),(735,371.75,2,'ffa86c4b-3b05-4f1d-b495-49f6b7b26c05'),(736,27.09,3,'ffa86c4b-3b05-4f1d-b495-49f6b7b26c05'),(737,228.63,4,'ffa86c4b-3b05-4f1d-b495-49f6b7b26c05'),(738,10.00,5,'ffa86c4b-3b05-4f1d-b495-49f6b7b26c05'),(739,4.85,6,'ffa86c4b-3b05-4f1d-b495-49f6b7b26c05'),(740,54.79,7,'ffa86c4b-3b05-4f1d-b495-49f6b7b26c05'),(741,526.00,11,'ffa86c4b-3b05-4f1d-b495-49f6b7b26c05'),(742,70.00,13,'ffa86c4b-3b05-4f1d-b495-49f6b7b26c05'),(743,11.50,14,'ffa86c4b-3b05-4f1d-b495-49f6b7b26c05'),(744,297.38,17,'ffa86c4b-3b05-4f1d-b495-49f6b7b26c05'),(745,154.25,19,'ffa86c4b-3b05-4f1d-b495-49f6b7b26c05'),(746,17.50,1,'ae532bb0-d8bc-4c06-9605-33fc398752af'),(747,415.56,2,'ae532bb0-d8bc-4c06-9605-33fc398752af'),(748,30.84,3,'ae532bb0-d8bc-4c06-9605-33fc398752af'),(749,275.04,4,'ae532bb0-d8bc-4c06-9605-33fc398752af'),(750,10.00,5,'ae532bb0-d8bc-4c06-9605-33fc398752af'),(751,4.85,6,'ae532bb0-d8bc-4c06-9605-33fc398752af'),(752,60.70,7,'ae532bb0-d8bc-4c06-9605-33fc398752af'),(753,567.00,11,'ae532bb0-d8bc-4c06-9605-33fc398752af'),(754,70.00,13,'ae532bb0-d8bc-4c06-9605-33fc398752af'),(755,12.62,14,'ae532bb0-d8bc-4c06-9605-33fc398752af'),(756,291.96,17,'ae532bb0-d8bc-4c06-9605-33fc398752af'),(757,151.44,19,'ae532bb0-d8bc-4c06-9605-33fc398752af'),(758,18.42,1,'c5a4ba7d-c5f4-4698-9a21-d253a2c72bbd'),(759,428.08,2,'c5a4ba7d-c5f4-4698-9a21-d253a2c72bbd'),(760,46.78,3,'c5a4ba7d-c5f4-4698-9a21-d253a2c72bbd'),(761,421.37,4,'c5a4ba7d-c5f4-4698-9a21-d253a2c72bbd'),(762,8.00,5,'c5a4ba7d-c5f4-4698-9a21-d253a2c72bbd'),(763,4.85,6,'c5a4ba7d-c5f4-4698-9a21-d253a2c72bbd'),(764,51.99,7,'c5a4ba7d-c5f4-4698-9a21-d253a2c72bbd'),(765,604.00,11,'c5a4ba7d-c5f4-4698-9a21-d253a2c72bbd'),(766,70.00,13,'c5a4ba7d-c5f4-4698-9a21-d253a2c72bbd'),(767,13.21,14,'c5a4ba7d-c5f4-4698-9a21-d253a2c72bbd'),(768,183.00,17,'c5a4ba7d-c5f4-4698-9a21-d253a2c72bbd'),(769,176.28,19,'c5a4ba7d-c5f4-4698-9a21-d253a2c72bbd'),(770,30.62,1,'3da49a80-30e3-4eaa-8bef-8326083b5547'),(771,974.74,2,'3da49a80-30e3-4eaa-8bef-8326083b5547'),(772,38.99,3,'3da49a80-30e3-4eaa-8bef-8326083b5547'),(773,8.00,5,'3da49a80-30e3-4eaa-8bef-8326083b5547'),(774,7.99,6,'3da49a80-30e3-4eaa-8bef-8326083b5547'),(775,37.10,7,'3da49a80-30e3-4eaa-8bef-8326083b5547'),(776,600.00,11,'3da49a80-30e3-4eaa-8bef-8326083b5547'),(777,70.00,13,'3da49a80-30e3-4eaa-8bef-8326083b5547'),(778,19.68,14,'3da49a80-30e3-4eaa-8bef-8326083b5547'),(779,273.33,17,'3da49a80-30e3-4eaa-8bef-8326083b5547'),(780,344.93,19,'3da49a80-30e3-4eaa-8bef-8326083b5547'),(781,17.66,1,'5a96a627-3957-4eab-af33-d788e88fa623'),(782,31.52,3,'5a96a627-3957-4eab-af33-d788e88fa623'),(783,8.00,5,'5a96a627-3957-4eab-af33-d788e88fa623'),(784,4.85,6,'5a96a627-3957-4eab-af33-d788e88fa623'),(785,41.26,7,'5a96a627-3957-4eab-af33-d788e88fa623'),(786,70.00,13,'5a96a627-3957-4eab-af33-d788e88fa623'),(787,15.31,14,'5a96a627-3957-4eab-af33-d788e88fa623'),(788,483.33,17,'5a96a627-3957-4eab-af33-d788e88fa623'),(789,407.40,19,'5a96a627-3957-4eab-af33-d788e88fa623'),(790,14.91,1,'7534d59e-9aad-4bc8-b6eb-05646195cd91'),(791,350.23,2,'7534d59e-9aad-4bc8-b6eb-05646195cd91'),(792,26.94,3,'7534d59e-9aad-4bc8-b6eb-05646195cd91'),(793,323.00,4,'7534d59e-9aad-4bc8-b6eb-05646195cd91'),(794,8.00,5,'7534d59e-9aad-4bc8-b6eb-05646195cd91'),(795,4.85,6,'7534d59e-9aad-4bc8-b6eb-05646195cd91'),(796,46.10,7,'7534d59e-9aad-4bc8-b6eb-05646195cd91'),(797,496.33,11,'7534d59e-9aad-4bc8-b6eb-05646195cd91'),(798,70.00,13,'7534d59e-9aad-4bc8-b6eb-05646195cd91'),(799,11.45,14,'7534d59e-9aad-4bc8-b6eb-05646195cd91'),(800,173.33,17,'7534d59e-9aad-4bc8-b6eb-05646195cd91'),(801,146.10,19,'7534d59e-9aad-4bc8-b6eb-05646195cd91'),(802,20.50,1,'3ff8af11-cbd8-477a-a71f-d405ff8711c4'),(803,335.46,2,'3ff8af11-cbd8-477a-a71f-d405ff8711c4'),(804,36.27,3,'3ff8af11-cbd8-477a-a71f-d405ff8711c4'),(805,316.08,4,'3ff8af11-cbd8-477a-a71f-d405ff8711c4'),(806,8.00,5,'3ff8af11-cbd8-477a-a71f-d405ff8711c4'),(807,4.85,6,'3ff8af11-cbd8-477a-a71f-d405ff8711c4'),(808,47.93,7,'3ff8af11-cbd8-477a-a71f-d405ff8711c4'),(809,439.00,11,'3ff8af11-cbd8-477a-a71f-d405ff8711c4'),(810,70.00,13,'3ff8af11-cbd8-477a-a71f-d405ff8711c4'),(811,14.25,14,'3ff8af11-cbd8-477a-a71f-d405ff8711c4'),(812,123.33,17,'3ff8af11-cbd8-477a-a71f-d405ff8711c4'),(813,103.96,19,'3ff8af11-cbd8-477a-a71f-d405ff8711c4'),(814,32.60,1,'fd032ae1-01ac-4fc1-bbd3-c0d92c44a3b3'),(815,606.66,2,'fd032ae1-01ac-4fc1-bbd3-c0d92c44a3b3'),(816,57.78,3,'fd032ae1-01ac-4fc1-bbd3-c0d92c44a3b3'),(817,570.58,4,'fd032ae1-01ac-4fc1-bbd3-c0d92c44a3b3'),(818,8.00,5,'fd032ae1-01ac-4fc1-bbd3-c0d92c44a3b3'),(819,4.85,6,'fd032ae1-01ac-4fc1-bbd3-c0d92c44a3b3'),(820,15.22,7,'fd032ae1-01ac-4fc1-bbd3-c0d92c44a3b3'),(821,724.67,11,'fd032ae1-01ac-4fc1-bbd3-c0d92c44a3b3'),(822,70.00,13,'fd032ae1-01ac-4fc1-bbd3-c0d92c44a3b3'),(823,20.70,14,'fd032ae1-01ac-4fc1-bbd3-c0d92c44a3b3'),(824,139.47,17,'fd032ae1-01ac-4fc1-bbd3-c0d92c44a3b3'),(825,118.00,19,'fd032ae1-01ac-4fc1-bbd3-c0d92c44a3b3'),(826,18.24,1,'f1c89e6e-103b-411a-8520-c5ebf5285018'),(827,237.81,2,'f1c89e6e-103b-411a-8520-c5ebf5285018'),(828,31.71,3,'f1c89e6e-103b-411a-8520-c5ebf5285018'),(829,159.60,4,'f1c89e6e-103b-411a-8520-c5ebf5285018'),(830,10.00,5,'f1c89e6e-103b-411a-8520-c5ebf5285018'),(831,4.85,6,'f1c89e6e-103b-411a-8520-c5ebf5285018'),(832,27.83,7,'f1c89e6e-103b-411a-8520-c5ebf5285018'),(833,322.10,11,'f1c89e6e-103b-411a-8520-c5ebf5285018'),(834,70.00,13,'f1c89e6e-103b-411a-8520-c5ebf5285018'),(835,12.88,14,'f1c89e6e-103b-411a-8520-c5ebf5285018'),(836,162.50,17,'f1c89e6e-103b-411a-8520-c5ebf5285018'),(837,84.29,19,'f1c89e6e-103b-411a-8520-c5ebf5285018'),(838,29.16,1,'a93db55c-7b3a-4000-b610-59c99e6461e4'),(839,452.70,2,'a93db55c-7b3a-4000-b610-59c99e6461e4'),(840,39.45,3,'a93db55c-7b3a-4000-b610-59c99e6461e4'),(841,390.42,4,'a93db55c-7b3a-4000-b610-59c99e6461e4'),(842,10.00,5,'a93db55c-7b3a-4000-b610-59c99e6461e4'),(843,4.85,6,'a93db55c-7b3a-4000-b610-59c99e6461e4'),(844,40.84,7,'a93db55c-7b3a-4000-b610-59c99e6461e4'),(845,582.00,11,'a93db55c-7b3a-4000-b610-59c99e6461e4'),(846,70.00,13,'a93db55c-7b3a-4000-b610-59c99e6461e4'),(847,15.21,14,'a93db55c-7b3a-4000-b610-59c99e6461e4'),(848,191.25,17,'a93db55c-7b3a-4000-b610-59c99e6461e4'),(849,128.96,19,'a93db55c-7b3a-4000-b610-59c99e6461e4'),(850,21.07,1,'9bd953b4-2196-4c44-9149-1c7a80a2ea4f'),(851,488.72,2,'9bd953b4-2196-4c44-9149-1c7a80a2ea4f'),(852,53.41,3,'9bd953b4-2196-4c44-9149-1c7a80a2ea4f'),(853,482.00,4,'9bd953b4-2196-4c44-9149-1c7a80a2ea4f'),(854,8.00,5,'9bd953b4-2196-4c44-9149-1c7a80a2ea4f'),(855,4.85,6,'9bd953b4-2196-4c44-9149-1c7a80a2ea4f'),(856,36.31,7,'9bd953b4-2196-4c44-9149-1c7a80a2ea4f'),(857,665.00,11,'9bd953b4-2196-4c44-9149-1c7a80a2ea4f'),(858,70.00,13,'9bd953b4-2196-4c44-9149-1c7a80a2ea4f'),(859,14.54,14,'9bd953b4-2196-4c44-9149-1c7a80a2ea4f'),(860,183.00,17,'9bd953b4-2196-4c44-9149-1c7a80a2ea4f'),(861,176.28,19,'9bd953b4-2196-4c44-9149-1c7a80a2ea4f');
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
  `TITLE` varchar(155) NOT NULL,
  `TYPE` varchar(45) NOT NULL DEFAULT 'header',
  `SIZE` int(11) NOT NULL DEFAULT '0',
  `SRC_URL` varchar(150) NOT NULL,
  `PROPERTY_DATA_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_PROPERTY_IMAGES_PROPERTY_DATA1_idx` (`PROPERTY_DATA_ID`),
  CONSTRAINT `fk_PROPERTY_IMAGES_PROPERTY_DATA1` FOREIGN KEY (`PROPERTY_DATA_ID`) REFERENCES `PROPERTY_DATA` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=555 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PROPERTY_IMAGES`
--

LOCK TABLES `PROPERTY_IMAGES` WRITE;
/*!40000 ALTER TABLE `PROPERTY_IMAGES` DISABLE KEYS */;
INSERT INTO `PROPERTY_IMAGES` VALUES (1,'Tammin.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9wv/5125185abaa60/Tammin.jpeg',15),(2,'1_curb.jpeg','header',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9wx/512515b1797b9/1_curb.jpeg',16),(3,'2_Liv_rm.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9wx/512515b5358b4/2_Liv_rm.jpeg',16),(4,'3_Kit.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9wx/512515b840390/3_Kit.jpeg',16),(5,'4_utility.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9wx/512515bb1fdb2/4_utility.jpeg',16),(6,'5_Furn_whtr.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9wx/512515c06e192/5_Furn_whtr.jpeg',16),(7,'7_bedrm.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9wx/512515c6a33fc/7_bedrm.jpeg',16),(8,'8_Half_bath.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9wx/512515c9a5127/8_Half_bath.jpeg',16),(9,'9_full_bath.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9wx/512515ccc6537/9_full_bath.jpeg',16),(10,'10_Bedroom.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9wx/512515cfd3909/10_Bedroom.jpeg',16),(11,'12_din_rm.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9wx/512515d997343/12_din_rm.jpeg',16),(12,'13_side.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9wx/512515dd1b6be/13_side.jpeg',16),(13,'14_Rear.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9wx/512515e17a279/14_Rear.jpeg',16),(14,'15_BR_master.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9wx/512515e55f6a9/15_BR_master.jpeg',16),(15,'1_curbnew_roof.jpeg','header',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9wy/51251d8b2b918/1_curbnew_roof.jpeg',17),(16,'1_curbRookwood1.jpeg','header',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9wy/51251da03d5b7/1_curbRookwood1.jpeg',17),(17,'Ritter Exteriors Sold 110.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9wz/512514d871386/Ritter+Exteriors+Sold+110.jpeg',18),(18,'1_Curb_Holmes.jpeg','header',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x3/512510867ae19/1_Curb_Holmes.jpeg',19),(19,'2_kitchen.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x3/5125108999e07/2_kitchen.jpeg',19),(20,'3_Liv_rm.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x3/5125108cb4f75/3_Liv_rm.jpeg',19),(21,'4_BR1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x3/5125108f4390b/4_BR1.jpeg',19),(22,'5_Bath.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x3/51251091ee629/5_Bath.jpeg',19),(23,'6_BR_2.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x3/5125109477678/6_BR_2.jpeg',19),(24,'7_BR_bsmt.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x3/51251099f285f/7_BR_bsmt.jpeg',19),(25,'8_Kit_w_appl.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x3/5125109c91272/8_Kit_w_appl.jpeg',19),(26,'10_half_ba.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x3/512510a1a5a08/10_half_ba.jpeg',19),(27,'9_bsmt.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x3/5125109f2ef25/9_bsmt.jpeg',19),(28,'11_Storeage_bsmt.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x3/512510a45871b/11_Storeage_bsmt.jpeg',19),(29,'13_Furn_wtr_htr.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x3/512510a733432/13_Furn_wtr_htr.jpeg',19),(30,'Ritter_Exteriors_Sold_070.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x3/512510b0b66d9/Ritter_Exteriors_Sold_070.jpeg',19),(31,'Ritter_Exteriors_Sold_071.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x3/512510b4537e2/Ritter_Exteriors_Sold_071.jpeg',19),(32,'Ritter_Exteriors_Sold_072.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x3/512510b7d52de/Ritter_Exteriors_Sold_072.jpeg',19),(33,'Ritter_Exteriors_Sold_073.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x3/512510bb72179/Ritter_Exteriors_Sold_073.jpeg',19),(34,'Ritter_Exteriors_Sold_074.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x3/512510bf2214d/Ritter_Exteriors_Sold_074.jpeg',19),(35,'Ritter_Exteriors_Sold_075.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x3/512510c2c17a7/Ritter_Exteriors_Sold_075.jpeg',19),(36,'1_curb_2009_Legrand_n_new_east_siders_001.jpeg','header',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x5/512521bb36768/1_curb_2009_Legrand_n_new_east_siders_001.jpeg',20),(37,'2_kit_2009_Legrand_n_new_east_siders_003.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x5/512521be66ce4/2_kit_2009_Legrand_n_new_east_siders_003.jpeg',20),(38,'3_liv_rm_Legrand_n_new_east_siders_005.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x5/512521c108b5e/3_liv_rm_Legrand_n_new_east_siders_005.jpeg',20),(39,'4_bath_Legrand_n_new_east_siders_007.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x5/512521c3c721c/4_bath_Legrand_n_new_east_siders_007.jpeg',20),(40,'5_Bedroom_legrand_2009.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x5/512521c6e898c/5_Bedroom_legrand_2009.jpeg',20),(41,'6_2nd_bedroom_legrand_2009.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x5/512521c97deae/6_2nd_bedroom_legrand_2009.jpeg',20),(42,'1_Curb_painted_Lindley.jpeg','header',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x7/512522a80613b/1_Curb_painted_Lindley.jpeg',21),(43,'2_new_kit_lindley.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x7/512522ae45b23/2_new_kit_lindley.jpeg',21),(44,'3 _iv_rm.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x7/512522b15dd3d/3+_iv_rm.jpeg',21),(45,'4_Bath.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x7/512522b3ec12f/4_Bath.jpeg',21),(46,'5_Utility_Lindley_1411.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x7/512522b6ada70/5_Utility_Lindley_1411.jpeg',21),(47,'6_BRmLindley_1411_009.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x7/512522b958ab7/6_BRmLindley_1411_009.jpeg',21),(48,'7_Bedrm_Lindley_1411.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x7/512522bbd43dd/7_Bedrm_Lindley_1411.jpeg',21),(49,'8_Rear_Lindley.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x7/512522be97056/8_Rear_Lindley.jpeg',21),(50,'9_Garage_painted.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x7/512522c1b14ce/9_Garage_painted.jpeg',21),(51,'1_curb_a_shutters.jpeg','header',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x9/5125234804e61/1_curb_a_shutters.jpeg',22),(52,'2_a_Kit_done.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x9/5125234b9d865/2_a_Kit_done.jpeg',22),(53,'2_Moreland_b_turnover_006.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x9/5125234ea2db8/2_Moreland_b_turnover_006.jpeg',22),(54,'3_a_Bath_done.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x9/51252351a2c84/3_a_Bath_done.jpeg',22),(55,'3_kit_b_done.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x9/512523548a7b6/3_kit_b_done.jpeg',22),(56,'4_a_BR_done.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x9/5125235792694/4_a_BR_done.jpeg',22),(57,'4_Bath_Mooreand_b.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x9/5125235acb3bf/4_Bath_Mooreand_b.jpeg',22),(58,'5_B_BR2_done.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x9/5125235dbe0ef/5_B_BR2_done.jpeg',22),(59,'5_Bedrm_Mooreland_b.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x9/5125236141b68/5_Bedrm_Mooreland_b.jpeg',22),(60,'6_a_kit_closeup.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x9/512523646cd75/6_a_kit_closeup.jpeg',22),(61,'6_Moreland_b_urnover_010.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x9/5125236745c55/6_Moreland_b_urnover_010.jpeg',22),(62,'7_2nd_bath_mooreland_b.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x9/5125236a0268c/7_2nd_bath_mooreland_b.jpeg',22),(63,'7_a_BR3_done.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x9/5125236d745de/7_a_BR3_done.jpeg',22),(64,'8_2nd_bath_mooreland_b.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x9/512523703c6f7/8_2nd_bath_mooreland_b.jpeg',22),(65,'8_a _iv_rm_done.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x9/512523730f931/8_a+_iv_rm_done.jpeg',22),(66,'Ritter_Exteriors_old_136.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x9/51252378e34af/Ritter_Exteriors_old_136.jpeg',22),(67,'DSCN4502.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xB/5125257e73ccd/DSCN4502.jpeg',23),(68,'DSCN4503.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xB/5125258730f5c/DSCN4503.jpeg',23),(69,'DSCN4504.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xB/5125258ea3d09/DSCN4504.jpeg',23),(70,'DSCN4505.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xB/5125259a01ad4/DSCN4505.jpeg',23),(71,'DSCN4506.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xB/512525a2066ce/DSCN4506.jpeg',23),(72,'DSCN4507.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xB/512525aa01642/DSCN4507.jpeg',23),(73,'DSCN4508.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xB/512525b248ef1/DSCN4508.jpeg',23),(74,'DSCN4509.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xB/512525c025d99/DSCN4509.jpeg',23),(75,'DSCN4510.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xB/512525c9ef702/DSCN4510.jpeg',23),(76,'DSCN4511.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xB/512525d2af648/DSCN4511.jpeg',23),(77,'DSCN4512.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xB/512525db721ee/DSCN4512.jpeg',23),(78,'DSCN4513.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xB/512525e4ab346/DSCN4513.jpeg',23),(79,'DSCN4514.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xB/512525ed98477/DSCN4514.jpeg',23),(80,'DSCN4515.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xB/512525f79b1dc/DSCN4515.jpeg',23),(81,'DSCN4516.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xB/51252601528b5/DSCN4516.jpeg',23),(82,'DSCN4518.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xB/5125260b28ce3/DSCN4518.jpeg',23),(83,'DSCN4520.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xB/5125261497068/DSCN4520.jpeg',23),(84,'DSCN4521.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xB/5125261f75f25/DSCN4521.jpeg',23),(85,'DSCN4524.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xB/5125263503c56/DSCN4524.jpeg',23),(86,'5327_Traditions_1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xC/51250bc7b23df/5327_Traditions_1.jpeg',24),(87,'1_Curb_Payton_new.jpeg','header',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xA/512524aec501d/1_Curb_Payton_new.jpeg',25),(88,'2_Kit_glass_3429_Payton.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xA/512524b22a3e8/2_Kit_glass_3429_Payton.jpeg',25),(89,'5_Stove_payton.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xA/512524b526097/5_Stove_payton.jpeg',25),(90,'7_BR_Payton.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xA/512524bc3c371/7_BR_Payton.jpeg',25),(91,'7_Payton_Din_rm.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xA/512524bf789e9/7_Payton_Din_rm.jpeg',25),(92,'8_Glass_tile_close_kit.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xA/512524c353b62/8_Glass_tile_close_kit.jpeg',25),(93,'8_Payton_3429_2nd_bath.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xA/512524c7687a6/8_Payton_3429_2nd_bath.jpeg',25),(94,'11_BR.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9xA/512524cb0bb59/11_BR.jpeg',25),(95,'1_Curb_new.jpeg','header',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x8/513637714ec02/1_Curb_new.jpeg',26),(96,'5_garage.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x8/513637f6e853c/5_garage.jpeg',26),(97,'1_Curb_Lindley_1404.jpeg','header',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x6/51252203de6d9/1_Curb_Lindley_1404.jpeg',27),(98,'2_Liv_rm_lindley.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x6/51252207989dc/2_Liv_rm_lindley.jpeg',27),(99,'3_Bedroom_lindley_1404.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x6/5125220a56a64/3_Bedroom_lindley_1404.jpeg',27),(100,'3_Kitchen_Lindley.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x6/5125220d879d1/3_Kitchen_Lindley.jpeg',27),(101,'4_Lindley_Bath.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x6/51252210c31df/4_Lindley_Bath.jpeg',27),(102,'5_Bedroom_Lindley_1404.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x6/512522138ea4f/5_Bedroom_Lindley_1404.jpeg',27),(103,'6_Bedr_2_Lindley_1404.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x6/51252216754a7/6_Bedr_2_Lindley_1404.jpeg',27),(104,'Ritter_Exteriors_old_124.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x6/5125221dae163/Ritter_Exteriors_old_124.jpeg',27),(105,'Ritter_Exteriors_old_131.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x6/512522215189a/Ritter_Exteriors_old_131.jpeg',27),(106,'Ritter_Exteriors_Sold_128.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x6/51252233af329/Ritter_Exteriors_Sold_128.jpeg',27),(107,'1_curb_jamie_ct_mar_11_012.jpeg','header',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x4/5125212ecb47b/1_curb_jamie_ct_mar_11_012.jpeg',28),(108,'2_Rear_jamie_ct_mar_11_013.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x4/512521326f424/2_Rear_jamie_ct_mar_11_013.jpeg',28),(109,'1.5_Kit_jamie_ct_mar_11_020.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x4/5125212820259/1.5_Kit_jamie_ct_mar_11_020.jpeg',28),(110,'1.75_kit_jamie_ct.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x4/5125212b610d8/1.75_kit_jamie_ct.jpeg',28),(111,'3_rear_jamie_ct_mar_11_015.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x4/51252136e91e3/3_rear_jamie_ct_mar_11_015.jpeg',28),(112,'4_Fam_rm_jamie_ct_mar_11_023.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x4/5125213a913bf/4_Fam_rm_jamie_ct_mar_11_023.jpeg',28),(113,'5_util_rm_jamie_ct_mar_11_025.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x4/5125213d6dc0d/5_util_rm_jamie_ct_mar_11_025.jpeg',28),(114,'6_2nd_bath_jamie_ct_mar_11_026.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x4/5125214042057/6_2nd_bath_jamie_ct_mar_11_026.jpeg',28),(115,'7_Din_rm_jamie_ct_mar_11_027.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x4/5125214311105/7_Din_rm_jamie_ct_mar_11_027.jpeg',28),(116,'8_Bedrm_jamie_ct_mar_11_029.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x4/51252145b81f4/8_Bedrm_jamie_ct_mar_11_029.jpeg',28),(117,'9_1st_bath_jamie_ct_mar_11_031.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x4/51252148965b7/9_1st_bath_jamie_ct_mar_11_031.jpeg',28),(118,'11_liv_rm_jamie_ct_mar_11_034.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x4/5125214e03f20/11_liv_rm_jamie_ct_mar_11_034.jpeg',28),(119,'12_garage_jamie_ct.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x4/51252150cd6a7/12_garage_jamie_ct.jpeg',28),(120,'13_Master_br_jamie_ct_mar_11_030.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x4/5125215507e81/13_Master_br_jamie_ct_mar_11_030.jpeg',28),(121,'1_Curb_Foltz_new.jpeg','header',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x2/51252093085d1/1_Curb_Foltz_new.jpeg',29),(122,'2_Liv_rm_foltz_new.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x2/512520962e785/2_Liv_rm_foltz_new.jpeg',29),(123,'3_Bath_Foltz.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x2/51252098de3ae/3_Bath_Foltz.jpeg',29),(124,'5_Foltz_laundry.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x2/5125209ee7256/5_Foltz_laundry.jpeg',29),(125,'4_Kit_Foltz.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x2/5125209c3623e/4_Kit_Foltz.jpeg',29),(126,'6_Foltz_bath.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x2/512520a1db811/6_Foltz_bath.jpeg',29),(127,'7_Foltz_brm.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x2/512520a4f0776/7_Foltz_brm.jpeg',29),(128,'8_Foltz_office-4th_br.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x2/512520a7dbebf/8_Foltz_office-4th_br.jpeg',29),(129,'9Foltz_3rd_BR.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x2/512520aab312f/9Foltz_3rd_BR.jpeg',29),(130,'10_Foltz_forth_br.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x2/512520ad73a5d/10_Foltz_forth_br.jpeg',29),(131,'1_Curb_Dearborn_3818.jpeg','header',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x1/512511cba8b60/1_Curb_Dearborn_3818.jpeg',30),(132,'3_LR_new.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x1/51251212d39fd/3_LR_new.jpeg',30),(133,'4 Bath dearborn 3818.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x1/512512188610a/4+Bath+dearborn+3818.jpeg',30),(134,'5_fam_rm_dearborn.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x1/51251220e5b72/5_fam_rm_dearborn.jpeg',30),(135,'6 _iv_rm_dearborn.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x1/51251227006fa/6+_iv_rm_dearborn.jpeg',30),(136,'8_Bedrm_dearborn.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x1/51251232cbdd7/8_Bedrm_dearborn.jpeg',30),(137,'9_Bedrm_3rd_dearborn.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x1/5125123b2d594/9_Bedrm_3rd_dearborn.jpeg',30),(138,'10_Bedrm_master_dearborn.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x1/5125123fcfae4/10_Bedrm_master_dearborn.jpeg',30),(139,'7_util_rm_dearborn.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x1/5125122bdd6da/7_util_rm_dearborn.jpeg',30),(140,'1_Curb_Worth_1023.jpeg','header',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x0/51251fa9bcd58/1_Curb_Worth_1023.jpeg',31),(141,'2_Liv_rm_1023.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x0/51251fb944bbb/2_Liv_rm_1023.jpeg',31),(142,'3_Kith_worth_1023.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x0/51251fc0b40e7/3_Kith_worth_1023.jpeg',31),(143,'4_bath_worth_1023.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x0/51251fcca6cb4/4_bath_worth_1023.jpeg',31),(144,'5_Bath_Beecher_1023.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x0/51251fd5794ff/5_Bath_Beecher_1023.jpeg',31),(145,'6_BR_Beecher_1023.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x0/51251fdd23e48/6_BR_Beecher_1023.jpeg',31),(146,'7_BR_Beecher_1023.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x0/51251fe712089/7_BR_Beecher_1023.jpeg',31),(147,'Ritter Exteriors Sold 108.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x0/5125200896f10/Ritter+Exteriors+Sold+108.jpeg',31),(148,'849_south_worth.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000003uR24/510fe78e31bd6/849_south_worth.jpeg',32),(149,'3351_north_butler.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000003uR25/510fe7e10fae6/3351_north_butler.jpeg',33),(150,'3025_alice.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000003uR27/510fe9b42f2e5/3025_alice.jpeg',34),(151,'7756_Mountain_Stream_Way_front.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000003uR26/510fe834b6bec/7756_Mountain_Stream_Way_front.jpeg',35),(152,'7756_Mountain_Stream_Way_back.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000003uR26/510fe831eca71/7756_Mountain_Stream_Way_back.jpeg',35),(153,'1405 17th front.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000003SaoY/50f4a2b41a44b/1405+17th+front.jpeg',36),(154,'Scatterwood_1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000003Saoc/50f4a3783cc08/Scatterwood_1.jpeg',37),(155,'Front1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE00000035X7Y/50de14fba3ed6/Front1.jpeg',38),(156,'front2.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE00000035X7Y/50de1502155c4/front2.jpeg',38),(157,'side1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE00000035X7Y/50de1534391d2/side1.jpeg',38),(158,'porch.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE00000035X7Y/50de152dcd848/porch.jpeg',38),(159,'backyard1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE00000035X7Y/50de14da70bff/backyard1.jpeg',38),(160,'backyard2.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE00000035X7Y/50de14e0cf748/backyard2.jpeg',38),(161,'dining.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE00000035X7Y/50de14f00d1fd/dining.jpeg',38),(162,'kitchen1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE00000035X7Y/50de1512c004f/kitchen1.jpeg',38),(163,'living2.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE00000035X7Y/50de1518a2f06/living2.jpeg',38),(164,'coveredpatio.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE00000035X7Y/50de14eb35bf6/coveredpatio.jpeg',38),(165,'bath2.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE00000035X7Y/50de14e60ab1a/bath2.jpeg',38),(166,'waterheater.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE00000035X7Y/50de154def6fd/waterheater.jpeg',38),(167,'DSC_0711 (1024x681).jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE000000357Zr/50cf95d0cc4a4/DSC_0711+%281024x681%29.jpeg',39),(168,'6530_pike_view.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE000000357Zs/50cf956491555/6530+pike+view.jpeg',40),(169,'main.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002lmvW/50bcd9e93b136/main.jpeg',41),(170,'Left_Side.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002lmvX/50bcdcc0a1665/Left_Side.jpeg',42),(171,'212_Mettler_8-2011_completed_work_002.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002lmvX/50bcdc6769281/212_Mettler_8-2011_completed_work_002.jpeg',42),(172,'212_Mettler_8-2011_completed_work_003.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002lmvX/50bcdc6bd2b67/212_Mettler_8-2011_completed_work_003.jpeg',42),(173,'212_Mettler_8-2011_completed_work_007.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002lmvX/50bcdc6ff41d7/212_Mettler_8-2011_completed_work_007.jpeg',42),(174,'212_Mettler 8-2011_completed_work_012.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002lmvX/50bcdc742db05/212_Mettler+8-2011_completed_work_012.jpeg',42),(175,'212_Mettler_8-2011_completed_work_016.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002lmvX/50bcdc812128e/212_Mettler_8-2011_completed_work_016.jpeg',42),(176,'Right_Side_2.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002lmvX/50bcdccb00477/Right_Side_2.jpeg',42),(177,'212_Mettler_8-2011_completed_work_038.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002lmvX/50bcdca0a7340/212_Mettler_8-2011_completed_work_038.jpeg',42),(178,'Address.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002lmvX/50bcdcaa1c3e5/Address.jpeg',42),(179,'Right_Side.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002lmvX/50bcdcd3cc84c/Right_Side.jpeg',42),(180,'Front.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002lmvX/50bcdcb58999e/Front.jpeg',42),(181,'212_Mettler_8-2011_completed_work_018.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002lmvX/50bcdc858877e/212_Mettler_8-2011_completed_work_018.jpeg',42),(182,'3349_Winton_Ave_12.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002dI0u/50a5bc7fa244f/3349_Winton_Ave_12.jpeg',43),(183,'3349_Winton_Ave_11.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002dI0u/50a5bc9006371/3349_Winton_Ave_11.jpeg',43),(184,'3349_Winton_Ave_1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002dI0u/50a5bc9d46536/3349_Winton_Ave_1.jpeg',43),(185,'3349_Winton_Ave_3.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002dI0u/50a5bccf8eb81/3349_Winton_Ave_3.jpeg',43),(186,'3349_Winton_Ave_4.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002dI0u/50a5bcd2461bd/3349_Winton_Ave_4.jpeg',43),(187,'3525_Payton_Ave_1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002dI0v/50a5bd28c4f32/3525+Payton_Ave_1.jpeg',44),(188,'3525_Payton_Ave_5.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002dI0v/50a5bd2bd68f6/3525+Payton_Ave_5.jpeg',44),(189,'3525_Payton_Ave_6.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002dI0v/50a5bd2e460c4/3525+Payton_Ave_6.jpeg',44),(190,'3525_Payton_Ave_7.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002dI0v/50a5bd30b41ce/3525+Payton_Ave_7.jpeg',44),(191,'3525_Payton_Ave_8.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002dI0v/50a5bd3339ccb/3525+Payton_Ave_8.jpeg',44),(192,'3525_Payton_Ave_2.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002dI0v/50a5bd3600882/3525_Payton_Ave_2.jpeg',44),(193,'3525_Payton_Ave_3.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002dI0v/50a5bd387fa7d/3525_Payton_Ave_3.jpeg',44),(194,'3525_Payton_Ave_4.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002dI0v/50a5bd3b15f39/3525_Payton_Ave_4.jpeg',44),(195,'4900_Ave_N_2.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002ZtGb/50984b2d3ecd4/4900_Ave_N_2.jpeg',45),(196,'4900_Ave_N_1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002ZtGb/50984b277f435/4900_Ave_N_1.jpeg',45),(197,'4900_Ave_N_3.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002ZtGb/50984b33e8bc6/4900_Ave_N_3.jpeg',45),(198,'1644_30th_Ensley_1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002ZtGc/50984acc23f03/1644_30th_Ensley_1.jpeg',46),(199,'1644_30th_Ensley_2.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002ZtGc/50984ad1ecbee/1644_30th_Ensley_2.jpeg',46),(200,'1644_30th_Ensley_3.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002ZtGc/50984ad758fd7/1644_30th_Ensley_3.jpeg',46),(201,'SAM_0599.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002ZtGd/50984a4af1e0a/SAM_0599.jpeg',47),(202,'SAM_0600.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002ZtGd/50984a5297433/SAM_0600.jpeg',47),(203,'SAM_0601.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002ZtGd/50984a5a1db94/SAM_0601.jpeg',47),(204,'SAM_0602.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002ZtGd/50984a618ab76/SAM_0602.jpeg',47),(205,'SAM_0603.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002ZtGd/50984a68ef9e0/SAM_0603.jpeg',47),(206,'SAM_0604.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002ZtGd/50984a700a64d/SAM_0604.jpeg',47),(207,'SAM_0606.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002ZtGd/50984a77870f5/SAM_0606.jpeg',47),(208,'SAM_0607.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002ZtGd/50984a7eb84f0/SAM_0607.jpeg',47),(209,'Lesley.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002MvpC/508816361457c/Lesley.jpeg',48),(210,'4993_Beatrice.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000002GqN9/5085bd80b4734/4993_Beatrice.jpeg',49),(211,'1521_33rd_Ensley_1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001Q437/506e022dd8209/1521_33rd_Ensley_1.jpeg',50),(212,'1521_33rd_Ensley_2.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001Q437/506e023414205/1521_33rd_Ensley_2.jpeg',50),(213,'1521_33rd_Ensley_3.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001Q437/506e023a838fa/1521_33rd_Ensley_3.jpeg',50),(214,'1521_33rd_Ensley_4.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001Q437/506e02403a8a1/1521_33rd_Ensley_4.jpeg',50),(215,'218_Vann_1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSW/5061f9dea914f/218_Vann_1.jpeg',51),(216,'1441_Warrior_1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSX/5061fc8e7e8bf/1441_Warrior_1.jpeg',52),(217,'1328_Ensley_1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSZ/5061faa621237/1328_Ensley_1.jpeg',53),(218,'1401_46th_1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSY/5061fc0711686/1401_46th_1.jpeg',54),(219,'1341_44th_1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSa/5061fb807b999/1341_44th_1.jpeg',55),(220,'4708_CourtO_4.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSc/5069d87dd964f/4708_CourtO_4.jpeg',56),(221,'4708_CourtO_1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSc/5069d8724e1ca/4708_CourtO_1.jpeg',56),(222,'4708_CourtO_2.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSc/5069d87652b39/4708_CourtO_2.jpeg',56),(223,'4708_CourtO_3.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSc/5069d87a2bcf9/4708_CourtO_3.jpeg',56),(224,'4708_CourtO_5.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSc/5069d881a9c5b/4708_CourtO_5.jpeg',56),(225,'4708_CourtO_6.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSc/5069d885a5231/4708_CourtO_6.jpeg',56),(226,'4708_CourtO_7.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSc/5069d88962431/4708_CourtO_7.jpeg',56),(227,'4708_CourtO_8.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSc/5069d88cb9416/4708_CourtO_8.jpeg',56),(228,'4708_CourtO_9.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSc/5069d8912726c/4708_CourtO_9.jpeg',56),(229,'5913_Ave_M_2.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSf/5061f55792f61/5913_Ave_M_2.jpeg',57),(230,'5913_Ave_M_1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSf/5061f54673392/5913_Ave_M_1.jpeg',57),(231,'2031_Center_1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSg/5061f5abac0d7/2031_Center_1.jpeg',58),(232,'5900_Ave_M_1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSe/5061f50de5d84/5900_Ave_M_1.jpeg',59),(233,'Main.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSb/5061f296c8215/Main.jpeg',60),(234,'DSC_0582.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5G/504a4ed34cedc/DSC_0582.jpeg',61),(235,'DSCN7697.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5G/504a4ed9d922f/DSCN7697.jpeg',61),(236,'DSCN7700.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5G/504a4edcbcab5/DSCN7700.jpeg',61),(237,'DSCN7701.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5G/504a4edfd48f4/DSCN7701.jpeg',61),(238,'4138_Breton_1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5H/506ca0467402b/4138_Breton_1.jpeg',62),(239,'4138_Breton_2.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5H/506ca04ba2e1d/4138_Breton_2.jpeg',62),(240,'4138_Breton_5.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5H/506ca05ac2420/4138_Breton_5.jpeg',62),(241,'4138_Breton_4.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5H/506ca0556d906/4138_Breton_4.jpeg',62),(242,'DSC_0249.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5I/50635b2663934/DSC_0249.jpeg',63),(243,'DSC_0719.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5I/50635b2bc13c9/DSC_0719.jpeg',63),(244,'DSC_0724.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5I/50635b2ff2e31/DSC_0724.jpeg',63),(245,'DSC_0729.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5I/50635b33e1c49/DSC_0729.jpeg',63),(246,'DSC_0732.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5I/50635b392986c/DSC_0732.jpeg',63),(247,'DSC_0734.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5I/50635b3cb4dff/DSC_0734.jpeg',63),(248,'Truman.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5V/504a47863e307/Truman.jpeg',64),(249,'Jackson_1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5W/50649e1adb952/Jackson_1.jpeg',65),(250,'Jackson_6.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5W/50649e355f6b3/Jackson_6.jpeg',65),(251,'Jackson_7.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5W/50649e39490b5/Jackson_7.jpeg',65),(252,'Jackson_8.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5W/50649e3d05749/Jackson_8.jpeg',65),(253,'Jackson_12.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5W/50649e5233b77/Jackson_12.jpeg',65),(254,'Jackson_13.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5W/50649e57a1aea/Jackson_13.jpeg',65),(255,'Garfield.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5X/506e0f4fc9234/Garfield.jpeg',66),(256,'Hardesty.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5Y/506e0e3112e6b/Hardesty.jpeg',67),(257,'Picture1.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5Z/504a5f02a2539/Picture1.jpeg',68),(258,'Picture2.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5Z/504a5f0696f59/Picture2.jpeg',68),(259,'Picture4.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5Z/504a5f0d9a552/Picture4.jpeg',68),(260,'Picture6.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5Z/504a5f1119b92/Picture6.jpeg',68),(261,'Picture3.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5Z/504a5f0a37bce/Picture3.jpeg',68),(262,'Picture7.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5Z/504a5f15545f1/Picture7.jpeg',68),(263,'DSCN1669.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5c/50634dfa1606d/DSCN1669.jpeg',69),(264,'DSCN1673.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5c/50634dfde9426/DSCN1673.jpeg',69),(265,'DSCN1674.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5c/50634e0184a57/DSCN1674.jpeg',69),(266,'DSCN1680.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5c/50634e0bd3100/DSCN1680.jpeg',69),(267,'DSCN1682.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5c/50634e0ef3677/DSCN1682.jpeg',69),(268,'DSCN1683.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5c/50634e1284c5f/DSCN1683.jpeg',69),(269,'DSCN1684.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5c/50634e15626d1/DSCN1684.jpeg',69),(270,'DSCN1685.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5c/50634e183dee9/DSCN1685.jpeg',69),(271,'DSCN1702.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5c/50634e4bb130c/DSCN1702.jpeg',69),(272,'2012-08-22_10-47-06_952.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5e/504a4ba9dc821/2012-08-22_10-47-06_952.jpeg',70),(273,'2012-08-22_10-44-26_738.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5e/504a4b927e22d/2012-08-22_10-44-26_738.jpeg',70),(274,'2012-08-22_10-44-46_266.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5e/504a4b9a1dc27/2012-08-22_10-44-46_266.jpeg',70),(275,'2012-08-22_10-42-40_489.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5e/504a4b7564206/2012-08-22_10-42-40_489.jpeg',70),(276,'2012-08-22_10-42-56_498.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5e/504a4b7b87bf1/2012-08-22_10-42-56_498.jpeg',70),(277,'DSC_0093.jpeg','gallery',0,'https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001ON5f/504a537ce2786/DSC_0093.jpeg',71);
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
-- Table structure for table `STATE`
--

DROP TABLE IF EXISTS `STATE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `STATE` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `STATE` varchar(45) NOT NULL,
  `FULL_NAME` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `STATE_UNIQUE` (`STATE`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `STATE`
--

LOCK TABLES `STATE` WRITE;
/*!40000 ALTER TABLE `STATE` DISABLE KEYS */;
INSERT INTO `STATE` VALUES (1,'OH',NULL),(8,'IN',NULL),(36,'AL',NULL),(64,'MO',NULL);
/*!40000 ALTER TABLE `STATE` ENABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SYSTEM_ROLES`
--

LOCK TABLES `SYSTEM_ROLES` WRITE;
/*!40000 ALTER TABLE `SYSTEM_ROLES` DISABLE KEYS */;
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
  `UUID` char(36) NOT NULL,
  `USER_NAME` varchar(75) NOT NULL,
  `ENABLED` tinyint(4) NOT NULL DEFAULT '0',
  `CRE_USER_ID` int(11) DEFAULT NULL,
  `CRE_DTM` datetime NOT NULL,
  `AUTHORITIES_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UUID_UNIQUE` (`UUID`),
  KEY `fk_USERS_AUTHORITIES1_idx` (`AUTHORITIES_ID`),
  CONSTRAINT `fk_USERS_AUTHORITIES1` FOREIGN KEY (`AUTHORITIES_ID`) REFERENCES `AUTHORITIES` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
-- Table structure for table `ZIP_CODES`
--

DROP TABLE IF EXISTS `ZIP_CODES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ZIP_CODES` (
  `ZIP_CODE` int(11) NOT NULL,
  `CITY_ID` int(11) NOT NULL,
  PRIMARY KEY (`ZIP_CODE`),
  KEY `fk_ZIP_CODES_CITY1_idx` (`CITY_ID`),
  CONSTRAINT `fk_ZIP_CODES_CITY1` FOREIGN KEY (`CITY_ID`) REFERENCES `CITY` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ZIP_CODES`
--

LOCK TABLES `ZIP_CODES` WRITE;
/*!40000 ALTER TABLE `ZIP_CODES` DISABLE KEYS */;
INSERT INTO `ZIP_CODES` VALUES (43205,1),(43206,1),(43211,1),(43227,1),(46201,7),(46203,7),(46208,7),(46218,7),(46221,7),(46222,7),(46224,7),(46226,7),(46235,7),(46237,7),(46239,7),(46241,7),(46254,7),(46268,7),(43608,35),(43609,35),(43610,35),(35205,42),(35206,42),(35208,42),(35211,42),(35228,42),(64126,61),(64127,61),(35023,66);
/*!40000 ALTER TABLE `ZIP_CODES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `vw_CustomerDataSource`
--

DROP TABLE IF EXISTS `vw_CustomerDataSource`;
/*!50001 DROP VIEW IF EXISTS `vw_CustomerDataSource`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vw_CustomerDataSource` (
  `CUSTOMER_ID` int(11),
  `CUSTOMER_NAME` varchar(45),
  `ENABLED` tinyint(4),
  `DATA_SOURCE_ID` int(11),
  `DATASOURCE` varchar(45)
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

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
  `FULL_NAME` varchar(255),
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
  `DESCRIPTION` text,
  `NUM_BEDS` float,
  `NUM_BATHS` float,
  `TYPE` varchar(45),
  `STATUS` varchar(45),
  `DATA_SOURCE_ID` int(11),
  `CUST_UUID` char(36),
  `DATASOURCE` varchar(45),
  `STATE` varchar(45),
  `CITY` varchar(150),
  `ZIP` int(11)
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vw_PropertyFinacials`
--

DROP TABLE IF EXISTS `vw_PropertyFinacials`;
/*!50001 DROP VIEW IF EXISTS `vw_PropertyFinacials`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vw_PropertyFinacials` (
  `ID` int(11),
  `PF_VALUE` decimal(5,2),
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
  `TITLE` varchar(155),
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
  `CITY` varchar(150),
  `SUMMARY` text,
  `IMAGE_URL` varchar(150),
  `ZIP_CODE` int(11)
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Dumping routines for database 'TALONDB'
--
/*!50003 DROP PROCEDURE IF EXISTS `pr_GetPropertyImageData` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
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
-- Final view structure for view `vw_CustomerDataSource`
--

/*!50001 DROP TABLE IF EXISTS `vw_CustomerDataSource`*/;
/*!50001 DROP VIEW IF EXISTS `vw_CustomerDataSource`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_CustomerDataSource` AS select `c`.`ID` AS `CUSTOMER_ID`,`c`.`CUST_NAME` AS `CUSTOMER_NAME`,`c`.`ENABLED` AS `ENABLED`,`ds`.`ID` AS `DATA_SOURCE_ID`,`ds`.`NAME` AS `DATASOURCE` from (`vw_Customers` `c` join `DATA_SOURCE` `ds`) where (`c`.`UUID` = `ds`.`CUST_UUID`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

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
/*!50001 VIEW `vw_Customers` AS select `CUSTOMER`.`ID` AS `ID`,`CUSTOMER`.`UUID` AS `UUID`,`CUSTOMER`.`CUST_NAME` AS `CUST_NAME`,`CUSTOMER`.`FULL_NAME` AS `FULL_NAME`,`CUSTOMER`.`ENABLED` AS `ENABLED` from `CUSTOMER` */;
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
-- Final view structure for view `vw_PropertyFinacials`
--

/*!50001 DROP TABLE IF EXISTS `vw_PropertyFinacials`*/;
/*!50001 DROP VIEW IF EXISTS `vw_PropertyFinacials`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_PropertyFinacials` AS select `pf`.`ID` AS `ID`,`pf`.`VALUE` AS `PF_VALUE`,`pf`.`FINACIAL_KEY_ID` AS `FINACIAL_KEY_ID`,`pf`.`PROPERTY_DATA_UUID` AS `PROPERTY_DATA_UUID`,`fk`.`ID` AS `KEY_ID`,`fk`.`KEY` AS `PF_KEY` from (`PROPERTY_FINACIAL` `pf` join `FINACIAL_KEY` `fk`) where (`pf`.`FINACIAL_KEY_ID` = `fk`.`ID`) */;
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
/*!50001 VIEW `vw_stateCityInfo` AS select `s`.`ID` AS `ID`,`s`.`STATE` AS `STATE`,`c`.`CITY` AS `CITY`,`c`.`SUMMARY` AS `SUMMARY`,`c`.`IMAGE_URL` AS `IMAGE_URL`,`z`.`ZIP_CODE` AS `ZIP_CODE` from ((`STATE` `s` join `ZIP_CODES` `z`) join `CITY` `c`) where ((`s`.`ID` = `c`.`STATE_ID`) and (`z`.`CITY_ID` = `c`.`ID`)) */;
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

-- Dump completed on 2013-05-29  8:22:42
