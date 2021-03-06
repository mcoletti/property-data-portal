SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `PDPDB` ;
CREATE SCHEMA IF NOT EXISTS `PDPDB` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;

-- -----------------------------------------------------
-- Table `PDPDB`.`ROLE_AUTH`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`ROLE_AUTH` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `ROLE` VARCHAR(45) NOT NULL ,
  `ENABLED` TINYINT(1) NOT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`AUTHORITIES`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`AUTHORITIES` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `AUTHORITY` VARCHAR(50) NOT NULL ,
  `ENABLED` TINYINT NOT NULL DEFAULT 0 ,
  `API_URL` VARCHAR(255) NOT NULL ,
  `API__AUTH_TOKEN` VARCHAR(255) NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`GROUPS`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`GROUPS` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `GROUP_NAME` VARCHAR(50) NOT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`CUSTOMER`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`CUSTOMER` (
  `UUID` CHAR(36) NOT NULL ,
  `NAME` VARCHAR(45) NOT NULL ,
  `DELETE_IND` TINYINT NOT NULL DEFAULT 0 ,
  PRIMARY KEY (`UUID`) ,
  UNIQUE INDEX `UUID_UNIQUE` (`UUID` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`ETL_JOB`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`ETL_JOB` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `JOB_NAME` VARCHAR(75) NOT NULL ,
  `CRE_DTM` DATETIME NOT NULL ,
  `ENABLED` TINYINT NOT NULL DEFAULT 0 ,
  `CUST_UUID` CHAR(36) NOT NULL ,
  `CRE_USER_UUID` CHAR(36) NOT NULL ,
  PRIMARY KEY (`ID`) ,
  UNIQUE INDEX `JOB_NAME_UNIQUE` (`JOB_NAME` ASC) ,
  UNIQUE INDEX `UDX1` (`JOB_NAME` ASC, `CUST_UUID` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`ETL_CONFIG_KEYS`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`ETL_CONFIG_KEYS` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `KEY` VARCHAR(75) NOT NULL ,
  `VALUE` TEXT NOT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`ETL_JOB_CONFIG_MAP`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`ETL_JOB_CONFIG_MAP` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `ETL_JOB_ID` INT NOT NULL ,
  `ETL_JOB_CONFIG_ID` INT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `fk_ETL_JOB_PROP_MAP_ETL_JOB1_idx` (`ETL_JOB_ID` ASC) ,
  INDEX `fk_ETL_JOB_PROP_MAP_ETL_JOB_PROPERTIES1_idx` (`ETL_JOB_CONFIG_ID` ASC) ,
  CONSTRAINT `fk_ETL_JOB_PROP_MAP_ETL_JOB1`
    FOREIGN KEY (`ETL_JOB_ID` )
    REFERENCES `PDPDB`.`ETL_JOB` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ETL_JOB_PROP_MAP_ETL_JOB_PROPERTIES1`
    FOREIGN KEY (`ETL_JOB_CONFIG_ID` )
    REFERENCES `PDPDB`.`ETL_CONFIG_KEYS` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`ETL_JOB_SCHEDULE`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`ETL_JOB_SCHEDULE` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `RUN_DAY` VARCHAR(2) NOT NULL ,
  `RUN_HOUR` VARCHAR(2) NOT NULL ,
  `RUN_MIN` VARCHAR(2) NOT NULL ,
  `ENABLED` TINYINT NOT NULL DEFAULT '0' ,
  `CRE_DTM` DATETIME NULL ,
  `CRE_USER` INT NULL ,
  `ETL_JOB_ID` INT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `fk_ETL_JOB_SCHEDULE_ETL_JOB1_idx` (`ETL_JOB_ID` ASC) ,
  CONSTRAINT `fk_ETL_JOB_SCHEDULE_ETL_JOB1`
    FOREIGN KEY (`ETL_JOB_ID` )
    REFERENCES `PDPDB`.`ETL_JOB` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`JOB_SERVER`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`JOB_SERVER` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `HOST` VARCHAR(75) NOT NULL ,
  `ACTIVE` TINYINT(1) NOT NULL DEFAULT '0' ,
  `IP_ADDRESS` VARCHAR(20) NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`JOB_STATUS`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`JOB_STATUS` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `STATUS` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`ETL_JOB_QUEUE`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`ETL_JOB_QUEUE` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `RUN_DTM` DATETIME NOT NULL ,
  `END_DTM` DATETIME NOT NULL ,
  `RUNNING` TINYINT NOT NULL DEFAULT 0 ,
  `ASSIGNED` TINYINT NOT NULL DEFAULT 0 ,
  `COMPLETE` TINYINT NOT NULL DEFAULT 0 ,
  `JOB_SERVER_ID` INT NOT NULL ,
  `ETL_JOB_ID` INT NOT NULL ,
  `JOB_STATUS_ID` INT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `fk_ETL_JOB_QUEUE_JOB_SERVER1_idx` (`JOB_SERVER_ID` ASC) ,
  INDEX `fk_ETL_JOB_QUEUE_ETL_JOB1_idx` (`ETL_JOB_ID` ASC) ,
  INDEX `fk_ETL_JOB_QUEUE_STATUS1_idx` (`JOB_STATUS_ID` ASC) ,
  CONSTRAINT `fk_ETL_JOB_QUEUE_JOB_SERVER1`
    FOREIGN KEY (`JOB_SERVER_ID` )
    REFERENCES `PDPDB`.`JOB_SERVER` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ETL_JOB_QUEUE_ETL_JOB1`
    FOREIGN KEY (`ETL_JOB_ID` )
    REFERENCES `PDPDB`.`ETL_JOB` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ETL_JOB_QUEUE_STATUS1`
    FOREIGN KEY (`JOB_STATUS_ID` )
    REFERENCES `PDPDB`.`JOB_STATUS` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`DATA_SOURCE`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`DATA_SOURCE` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `NAME` VARCHAR(45) NOT NULL ,
  `CUSTOMER_UUID` CHAR(36) NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `fk_DATA_SOURCE_CUSTOMER1_idx` (`CUSTOMER_UUID` ASC) ,
  CONSTRAINT `fk_DATA_SOURCE_CUSTOMER1`
    FOREIGN KEY (`CUSTOMER_UUID` )
    REFERENCES `PDPDB`.`CUSTOMER` (`UUID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`STATE`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`STATE` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `STATE` VARCHAR(45) NOT NULL ,
  `FULL_NAME` VARCHAR(150) NULL ,
  PRIMARY KEY (`ID`) ,
  UNIQUE INDEX `STATE_UNIQUE` (`STATE` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`CITY`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`CITY` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `CITY` VARCHAR(150) NOT NULL ,
  `SUMMARY` TEXT NULL ,
  `IMAGE_URL` VARCHAR(150) NULL ,
  `STATE_ID` INT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  UNIQUE INDEX `CITY_UNIQUE` (`CITY` ASC) ,
  INDEX `fk_CITY_STATE1_idx` (`STATE_ID` ASC) ,
  CONSTRAINT `fk_CITY_STATE1`
    FOREIGN KEY (`STATE_ID` )
    REFERENCES `PDPDB`.`STATE` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`ZIP_CODES`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`ZIP_CODES` (
  `ZIP_CODE` INT NOT NULL ,
  `CITY_ID` INT NOT NULL ,
  PRIMARY KEY (`ZIP_CODE`) ,
  INDEX `fk_ZIP_CODES_CITY1_idx` (`CITY_ID` ASC) ,
  CONSTRAINT `fk_ZIP_CODES_CITY1`
    FOREIGN KEY (`CITY_ID` )
    REFERENCES `PDPDB`.`CITY` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`PROPERTY_STATUS`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`PROPERTY_STATUS` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `STATUS` VARCHAR(45) NOT NULL ,
  `DELETE_IND` TINYINT NOT NULL DEFAULT 0 ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`PROPERTY_TYPE`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`PROPERTY_TYPE` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `TYPE` VARCHAR(45) NOT NULL ,
  `DELETE_IND` TINYINT NOT NULL DEFAULT 0 ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`PROPERTY_DATA`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`PROPERTY_DATA` (
  `UUID` CHAR(36) NOT NULL ,
  `PROP_NAME` VARCHAR(150) NOT NULL ,
  `PRICE` FLOAT NOT NULL DEFAULT 0 ,
  `SQFT` FLOAT NOT NULL DEFAULT 0 ,
  `DESCRIPTION` TEXT NOT NULL ,
  `NUM_BEDS` FLOAT NOT NULL DEFAULT 0 ,
  `NUM_BATHS` FLOAT NOT NULL DEFAULT 0 ,
  `DATA_SOURCE_ID` INT NOT NULL ,
  `ZIP_CODE` INT NOT NULL ,
  `PROPERTY_STATUS_ID` INT NOT NULL ,
  `PROPERTY_TYPE_ID` INT NOT NULL ,
  PRIMARY KEY (`UUID`) ,
  INDEX `fk_PROPERTY_DATA_DATA_SOURCE1_idx` (`DATA_SOURCE_ID` ASC) ,
  INDEX `fk_PROPERTY_DATA_ZIP_CODES1_idx` (`ZIP_CODE` ASC) ,
  INDEX `fk_PROPERTY_DATA_PROPERTY_STATUS1_idx` (`PROPERTY_STATUS_ID` ASC) ,
  INDEX `fk_PROPERTY_DATA_PROPERTY_TYPE1_idx` (`PROPERTY_TYPE_ID` ASC) ,
  CONSTRAINT `fk_PROPERTY_DATA_DATA_SOURCE1`
    FOREIGN KEY (`DATA_SOURCE_ID` )
    REFERENCES `PDPDB`.`DATA_SOURCE` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PROPERTY_DATA_ZIP_CODES1`
    FOREIGN KEY (`ZIP_CODE` )
    REFERENCES `PDPDB`.`ZIP_CODES` (`ZIP_CODE` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PROPERTY_DATA_PROPERTY_STATUS1`
    FOREIGN KEY (`PROPERTY_STATUS_ID` )
    REFERENCES `PDPDB`.`PROPERTY_STATUS` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PROPERTY_DATA_PROPERTY_TYPE1`
    FOREIGN KEY (`PROPERTY_TYPE_ID` )
    REFERENCES `PDPDB`.`PROPERTY_TYPE` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`RAW_DATA`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`RAW_DATA` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `DATA_VALUE` TEXT NOT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`DATA_TYPE`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`DATA_TYPE` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `TYPE` VARCHAR(75) NOT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`PROPERTY_ATTRIBUTES`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`PROPERTY_ATTRIBUTES` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `KEY` VARCHAR(75) NOT NULL ,
  `DATA_TYPE_ID` INT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  UNIQUE INDEX `KEY_UNIQUE` (`KEY` ASC) ,
  INDEX `fk_PROPERTY_ATTRIBUTES_DATA_TYPE1_idx` (`DATA_TYPE_ID` ASC) ,
  CONSTRAINT `fk_PROPERTY_ATTRIBUTES_DATA_TYPE1`
    FOREIGN KEY (`DATA_TYPE_ID` )
    REFERENCES `PDPDB`.`DATA_TYPE` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`PROPERTY_ATTRIBUTE_DATA`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`PROPERTY_ATTRIBUTE_DATA` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `VALUE_PREFIX` VARCHAR(255) NOT NULL ,
  `SORT_ORDER` INT NOT NULL DEFAULT 0 ,
  `RAW_DATA_ID` INT NULL ,
  `PROPERTY_ATTRIBUTES_ID` INT NOT NULL ,
  `PROPERTY_DATA_UUID` CHAR(36) NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `fk_DYNAMIC_DATA_RAW_DATA1_idx` (`RAW_DATA_ID` ASC) ,
  INDEX `fk_PROPERTY_ATTRIBUTE_DATA_PROPERTY_ATTRIBUTES1_idx` (`PROPERTY_ATTRIBUTES_ID` ASC) ,
  INDEX `fk_PROPERTY_ATTRIBUTE_DATA_PROPERTY_DATA1_idx` (`PROPERTY_DATA_UUID` ASC) ,
  CONSTRAINT `fk_DYNAMIC_DATA_RAW_DATA1`
    FOREIGN KEY (`RAW_DATA_ID` )
    REFERENCES `PDPDB`.`RAW_DATA` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PROPERTY_ATTRIBUTE_DATA_PROPERTY_ATTRIBUTES1`
    FOREIGN KEY (`PROPERTY_ATTRIBUTES_ID` )
    REFERENCES `PDPDB`.`PROPERTY_ATTRIBUTES` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PROPERTY_ATTRIBUTE_DATA_PROPERTY_DATA1`
    FOREIGN KEY (`PROPERTY_DATA_UUID` )
    REFERENCES `PDPDB`.`PROPERTY_DATA` (`UUID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`PROPERTY_IMAGES`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`PROPERTY_IMAGES` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `TITLE` VARCHAR(155) NOT NULL ,
  `TYPE` VARCHAR(45) NOT NULL DEFAULT 'header' ,
  `SIZE` INT NOT NULL DEFAULT 0 ,
  `SRC_URL` VARCHAR(150) NOT NULL ,
  `PROPERTY_DATA_UUID` CHAR(36) NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `fk_PROPERTY_IMAGES_PROPERTY_DATA1_idx` (`PROPERTY_DATA_UUID` ASC) ,
  CONSTRAINT `fk_PROPERTY_IMAGES_PROPERTY_DATA1`
    FOREIGN KEY (`PROPERTY_DATA_UUID` )
    REFERENCES `PDPDB`.`PROPERTY_DATA` (`UUID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`FINACIAL_KEY`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`FINACIAL_KEY` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `KEY` VARCHAR(75) NOT NULL ,
  `DISPLAY_NAME` VARCHAR(75) NULL ,
  `UI_SECTION_GROUP_KEY` VARCHAR(45) NOT NULL ,
  `FINACIAL_KEY_ORDER` INT NOT NULL DEFAULT 0 ,
  PRIMARY KEY (`ID`) ,
  UNIQUE INDEX `KEY_UNIQUE` (`KEY` ASC) ,
  UNIQUE INDEX `UI_SECTION_GROUP_KEY_UNIQUE` (`UI_SECTION_GROUP_KEY` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`PROPERTY_FINACIAL`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`PROPERTY_FINACIAL` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `VALUE` DECIMAL(18,2) NOT NULL DEFAULT '0.00' ,
  `FINACIAL_KEY_ID` INT NOT NULL ,
  `PROPERTY_DATA_UUID` CHAR(36) NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `fk_PROPERTY_FINACIALS_FINACIAL_KEY1_idx` (`FINACIAL_KEY_ID` ASC) ,
  UNIQUE INDEX `udx1` (`FINACIAL_KEY_ID` ASC) ,
  INDEX `fk_PROPERTY_FINACIAL_PROPERTY_DATA1_idx` (`PROPERTY_DATA_UUID` ASC) ,
  CONSTRAINT `fk_PROPERTY_FINACIALS_FINACIAL_KEY1`
    FOREIGN KEY (`FINACIAL_KEY_ID` )
    REFERENCES `PDPDB`.`FINACIAL_KEY` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PROPERTY_FINACIAL_PROPERTY_DATA1`
    FOREIGN KEY (`PROPERTY_DATA_UUID` )
    REFERENCES `PDPDB`.`PROPERTY_DATA` (`UUID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`PROPERTY_FINACIAL`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`PROPERTY_FINACIAL` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `VALUE` DECIMAL(18,2) NOT NULL DEFAULT '0.00' ,
  `FINACIAL_KEY_ID` INT NOT NULL ,
  `PROPERTY_DATA_UUID` CHAR(36) NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `fk_PROPERTY_FINACIALS_FINACIAL_KEY1_idx` (`FINACIAL_KEY_ID` ASC) ,
  UNIQUE INDEX `udx1` (`FINACIAL_KEY_ID` ASC) ,
  INDEX `fk_PROPERTY_FINACIAL_PROPERTY_DATA1_idx` (`PROPERTY_DATA_UUID` ASC) ,
  CONSTRAINT `fk_PROPERTY_FINACIALS_FINACIAL_KEY1`
    FOREIGN KEY (`FINACIAL_KEY_ID` )
    REFERENCES `PDPDB`.`FINACIAL_KEY` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PROPERTY_FINACIAL_PROPERTY_DATA1`
    FOREIGN KEY (`PROPERTY_DATA_UUID` )
    REFERENCES `PDPDB`.`PROPERTY_DATA` (`UUID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`ETL_JOB_LOG`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`ETL_JOB_LOG` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `LOG` VARCHAR(255) NOT NULL ,
  `CRE_DTM` DATETIME NOT NULL ,
  `ETL_JOB_QUEUE_ID` INT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `fk_ETL_JOB_LOG_ETL_JOB_QUEUE1_idx` (`ETL_JOB_QUEUE_ID` ASC) ,
  CONSTRAINT `fk_ETL_JOB_LOG_ETL_JOB_QUEUE1`
    FOREIGN KEY (`ETL_JOB_QUEUE_ID` )
    REFERENCES `PDPDB`.`ETL_JOB_QUEUE` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`SYSTEM_ROLES`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`SYSTEM_ROLES` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `ROLE_NAME` VARCHAR(75) NOT NULL ,
  `ACTIVE_IND` TINYINT NOT NULL DEFAULT 0 ,
  `CRE_USER_ID` INT NOT NULL ,
  `CRE_DTM` DATETIME NOT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`ROLE_DATA`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`ROLE_DATA` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `ROLE_NAME` VARCHAR(75) NOT NULL ,
  `DELETE_IND` TINYINT NOT NULL DEFAULT 0 ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`USER`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`USER` (
  `UUID` CHAR(36) NOT NULL ,
  `USER_NAME` VARCHAR(75) NOT NULL ,
  `FIRST_NAME` VARCHAR(75) NOT NULL ,
  `LAST_NAME` VARCHAR(75) NOT NULL ,
  `PRIMARY_EMAIL` VARCHAR(255) NOT NULL ,
  `REFERRED_BY` VARCHAR(150) NOT NULL ,
  `GENDER` VARCHAR(25) NOT NULL ,
  `DELETE_IND` TINYINT NOT NULL DEFAULT 0 ,
  `CUSTOMER_UUID` CHAR(36) NOT NULL ,
  `ROLE_DATA_ID` INT NOT NULL ,
  `LAST_LOGIN_DTM` DATETIME NULL ,
  `LOCK_IND` TINYINT NOT NULL DEFAULT 0 ,
  PRIMARY KEY (`UUID`) ,
  INDEX `fk_CLIENT_DATA_CUSTOMER1_idx` (`CUSTOMER_UUID` ASC) ,
  INDEX `fk_USER_ROLE_DATA1_idx` (`ROLE_DATA_ID` ASC) ,
  UNIQUE INDEX `UUID_UNIQUE` (`UUID` ASC) ,
  CONSTRAINT `fk_CLIENT_DATA_CUSTOMER1`
    FOREIGN KEY (`CUSTOMER_UUID` )
    REFERENCES `PDPDB`.`CUSTOMER` (`UUID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_USER_ROLE_DATA1`
    FOREIGN KEY (`ROLE_DATA_ID` )
    REFERENCES `PDPDB`.`ROLE_DATA` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`SYSTEM_GROUP_MEMBERS`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`SYSTEM_GROUP_MEMBERS` (
  `SYSTEM_ROLES_ID` INT NOT NULL ,
  `GROUPS_ID` INT NOT NULL ,
  `USER_UUID` CHAR(36) NOT NULL ,
  INDEX `fk_GROUP_ROLE_MAP_SYSTEM_ROLES1_idx` (`SYSTEM_ROLES_ID` ASC) ,
  INDEX `fk_GROUP_ROLE_MAP_GROUPS1_idx` (`GROUPS_ID` ASC) ,
  INDEX `fk_SYSTEM_GROUPS_USER1_idx` (`USER_UUID` ASC) ,
  CONSTRAINT `fk_GROUP_ROLE_MAP_SYSTEM_ROLES1`
    FOREIGN KEY (`SYSTEM_ROLES_ID` )
    REFERENCES `PDPDB`.`SYSTEM_ROLES` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_GROUP_ROLE_MAP_GROUPS1`
    FOREIGN KEY (`GROUPS_ID` )
    REFERENCES `PDPDB`.`GROUPS` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SYSTEM_GROUPS_USER1`
    FOREIGN KEY (`USER_UUID` )
    REFERENCES `PDPDB`.`USER` (`UUID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`UI_PAGE_LAYOUT`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`UI_PAGE_LAYOUT` (
  `ID` INT NOT NULL ,
  `UI_PAGE` VARCHAR(75) NOT NULL ,
  PRIMARY KEY (`ID`) ,
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`UI_SECTIONS`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`UI_SECTIONS` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `SECTION_KEY` VARCHAR(45) NOT NULL ,
  `DISPLAY_NAME` VARCHAR(255) NOT NULL ,
  `SECTION_ORDER` INT NOT NULL DEFAULT 0 ,
  `UI_PAGE_LAYOUT_ID` INT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  UNIQUE INDEX `SECTION_KEY_UNIQUE` (`SECTION_KEY` ASC) ,
  INDEX `fk_UI_SECTIONS_UI_PAGE_LAYOUT1_idx` (`UI_PAGE_LAYOUT_ID` ASC) ,
  CONSTRAINT `fk_UI_SECTIONS_UI_PAGE_LAYOUT1`
    FOREIGN KEY (`UI_PAGE_LAYOUT_ID` )
    REFERENCES `PDPDB`.`UI_PAGE_LAYOUT` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`UI_ELEMENT_TYPES`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`UI_ELEMENT_TYPES` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `TYPE_KEY` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`UI_SECTION_GROUPS`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`UI_SECTION_GROUPS` (
  `INT` INT NOT NULL AUTO_INCREMENT ,
  `GROUP_KEY` VARCHAR(45) NOT NULL ,
  `DISPLAY_NAME` VARCHAR(255) NOT NULL ,
  `GROUP_ORDER` INT NOT NULL DEFAULT 0 ,
  `SECTION_KEY` VARCHAR(45) NOT NULL ,
  `DEFAULT_GROUP` TINYINT NOT NULL DEFAULT 0 ,
  `UI_ELEMENT_TYPES_ID` INT NULL ,
  PRIMARY KEY (`INT`) ,
  UNIQUE INDEX `GROUP_KEY_UNIQUE` (`GROUP_KEY` ASC) ,
  INDEX `fk_UI_SECTION_GROUPS_UI_ELEMENT_TYPES1_idx` (`UI_ELEMENT_TYPES_ID` ASC) ,
  CONSTRAINT `fkSectionKey`
    FOREIGN KEY (`SECTION_KEY` )
    REFERENCES `PDPDB`.`UI_SECTIONS` (`SECTION_KEY` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_UI_SECTION_GROUPS_UI_ELEMENT_TYPES1`
    FOREIGN KEY (`UI_ELEMENT_TYPES_ID` )
    REFERENCES `PDPDB`.`UI_ELEMENT_TYPES` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`ATTRIBUTES`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`ATTRIBUTES` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `KEY` VARCHAR(75) NOT NULL ,
  PRIMARY KEY (`ID`) ,
  UNIQUE INDEX `KEY_UNIQUE` (`KEY` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`UI_PAGE_ATTRIBUTES`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`UI_PAGE_ATTRIBUTES` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `ATTRUIBUTE_VALUE` VARCHAR(255) NOT NULL ,
  `ATTRIBUTES_ID` INT NOT NULL ,
  `UI_PAGE_LAYOUT_ID` INT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `fk_UI_PAGE_ATTRIBUTES_ATTRIBUTES1_idx` (`ATTRIBUTES_ID` ASC) ,
  INDEX `fk_UI_PAGE_ATTRIBUTES_UI_PAGE_LAYOUT1_idx` (`UI_PAGE_LAYOUT_ID` ASC) ,
  CONSTRAINT `fk_UI_PAGE_ATTRIBUTES_ATTRIBUTES1`
    FOREIGN KEY (`ATTRIBUTES_ID` )
    REFERENCES `PDPDB`.`ATTRIBUTES` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_UI_PAGE_ATTRIBUTES_UI_PAGE_LAYOUT1`
    FOREIGN KEY (`UI_PAGE_LAYOUT_ID` )
    REFERENCES `PDPDB`.`UI_PAGE_LAYOUT` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`UI_ELEMENT_TYPE_ATTRIBUTES`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`UI_ELEMENT_TYPE_ATTRIBUTES` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `ATTRIBUTE_VALUE` VARCHAR(255) NOT NULL ,
  `UI_ELEMENT_TYPES_ID` INT NOT NULL ,
  `ATTRIBUTES_ID` INT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `fk_UI_ELEMENT_TYPE_ATTRIBUTES_UI_ELEMENT_TYPES1_idx` (`UI_ELEMENT_TYPES_ID` ASC) ,
  INDEX `fk_UI_ELEMENT_TYPE_ATTRIBUTES_ATTRIBUTES1_idx` (`ATTRIBUTES_ID` ASC) ,
  CONSTRAINT `fk_UI_ELEMENT_TYPE_ATTRIBUTES_UI_ELEMENT_TYPES1`
    FOREIGN KEY (`UI_ELEMENT_TYPES_ID` )
    REFERENCES `PDPDB`.`UI_ELEMENT_TYPES` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_UI_ELEMENT_TYPE_ATTRIBUTES_ATTRIBUTES1`
    FOREIGN KEY (`ATTRIBUTES_ID` )
    REFERENCES `PDPDB`.`ATTRIBUTES` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`ATTRIBUTES`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`ATTRIBUTES` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `KEY` VARCHAR(75) NOT NULL ,
  PRIMARY KEY (`ID`) ,
  UNIQUE INDEX `KEY_UNIQUE` (`KEY` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`USER_ATTRIBUTES`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`USER_ATTRIBUTES` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `ATTRIBUTE_VALUE` VARCHAR(255) NOT NULL ,
  `ATTRIBUTES_ID` INT NOT NULL ,
  `USER_UUID` CHAR(36) NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `fk_CLIENT_ATTRIBUTES_ATTRIBUTES1_idx` (`ATTRIBUTES_ID` ASC) ,
  INDEX `fk_USER_ATTRIBUTES_USER1_idx` (`USER_UUID` ASC) ,
  CONSTRAINT `fk_CLIENT_ATTRIBUTES_ATTRIBUTES1`
    FOREIGN KEY (`ATTRIBUTES_ID` )
    REFERENCES `PDPDB`.`ATTRIBUTES` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_USER_ATTRIBUTES_USER1`
    FOREIGN KEY (`USER_UUID` )
    REFERENCES `PDPDB`.`USER` (`UUID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`CUSTOMER_ATTRIBUTES`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`CUSTOMER_ATTRIBUTES` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `ATTRIBUTE_VALUE` VARCHAR(255) NOT NULL ,
  `CUSTOMER_UUID` CHAR(36) NOT NULL ,
  `ATTRIBUTES_ID` INT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `fk_CUSTOMER_ATTRIBUTES_CUSTOMER1_idx` (`CUSTOMER_UUID` ASC) ,
  INDEX `fk_CUSTOMER_ATTRIBUTES_ATTRIBUTES1_idx` (`ATTRIBUTES_ID` ASC) ,
  CONSTRAINT `fk_CUSTOMER_ATTRIBUTES_CUSTOMER1`
    FOREIGN KEY (`CUSTOMER_UUID` )
    REFERENCES `PDPDB`.`CUSTOMER` (`UUID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CUSTOMER_ATTRIBUTES_ATTRIBUTES1`
    FOREIGN KEY (`ATTRIBUTES_ID` )
    REFERENCES `PDPDB`.`ATTRIBUTES` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`GROUP_MEMBERS`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`GROUP_MEMBERS` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `USER_UUID` CHAR(36) NOT NULL ,
  `GROUPS_ID` INT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `fk_GROUP_MEMBERS_USER1_idx` (`USER_UUID` ASC) ,
  INDEX `fk_GROUP_MEMBERS_GROUPS1_idx` (`GROUPS_ID` ASC) ,
  CONSTRAINT `fk_GROUP_MEMBERS_USER1`
    FOREIGN KEY (`USER_UUID` )
    REFERENCES `PDPDB`.`USER` (`UUID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_GROUP_MEMBERS_GROUPS1`
    FOREIGN KEY (`GROUPS_ID` )
    REFERENCES `PDPDB`.`GROUPS` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PDPDB`.`USER_ACTIVITY_LOG`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `PDPDB`.`USER_ACTIVITY_LOG` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `LOG_DETAIL` VARCHAR(255) NOT NULL ,
  `LOG_DTM` DATETIME NOT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB;

USE `PDPDB` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
