-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.30


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema crmtest
--

CREATE DATABASE IF NOT EXISTS ducrm;
USE ducrm;

--
-- Definition of table `base_accessory`
--

DROP TABLE IF EXISTS `base_accessory`;
CREATE TABLE `base_accessory` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `dataId` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `path` varchar(255) NOT NULL,
  `realname` varchar(255) NOT NULL,
  `sort` varchar(255) NOT NULL,
  `userid` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `base_accessory`
--

/*!40000 ALTER TABLE `base_accessory` DISABLE KEYS */;
/*!40000 ALTER TABLE `base_accessory` ENABLE KEYS */;


--
-- Definition of table `base_area`
--

DROP TABLE IF EXISTS `base_area`;
CREATE TABLE `base_area` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `code` varchar(4) NOT NULL,
  `name` varchar(20) NOT NULL,
  `fk_area_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK93B31D3B93E397FC` (`fk_area_id`),
  CONSTRAINT `FK93B31D3B93E397FC` FOREIGN KEY (`fk_area_id`) REFERENCES `base_area` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `base_area`
--

/*!40000 ALTER TABLE `base_area` DISABLE KEYS */;
/*!40000 ALTER TABLE `base_area` ENABLE KEYS */;


--
-- Definition of table `base_category`
--

DROP TABLE IF EXISTS `base_category`;
CREATE TABLE `base_category` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `sort` varchar(255) NOT NULL,
  `fk_category_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `code` (`code`,`sort`),
  KEY `FK849602ACA175F55C` (`fk_category_id`),
  CONSTRAINT `FK849602ACA175F55C` FOREIGN KEY (`fk_category_id`) REFERENCES `base_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `base_category`
--

/*!40000 ALTER TABLE `base_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `base_category` ENABLE KEYS */;


--
-- Definition of table `base_company`
--

DROP TABLE IF EXISTS `base_company`;
CREATE TABLE `base_company` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `address` varchar(30) DEFAULT NULL,
  `badd` varchar(255) DEFAULT NULL,
  `bcode` varchar(30) DEFAULT NULL,
  `bman` varchar(20) DEFAULT NULL,
  `bname` varchar(50) DEFAULT NULL,
  `code` varchar(10) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `fax` varchar(20) DEFAULT NULL,
  `linkman` varchar(20) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `postcode` varchar(6) DEFAULT NULL,
  `qq` varchar(20) DEFAULT NULL,
  `shortName` varchar(20) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `web` varchar(50) DEFAULT NULL,
  `fk_city_id` bigint(20) DEFAULT NULL,
  `fk_province_id` bigint(20) DEFAULT NULL,
  `fk_company_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `code` (`code`),
  KEY `FK5DDD890FFC026379` (`fk_province_id`),
  KEY `FK5DDD890F46B61FF3` (`fk_company_id`),
  KEY `FK5DDD890FEF32BA5E` (`fk_city_id`),
  CONSTRAINT `FK5DDD890FEF32BA5E` FOREIGN KEY (`fk_city_id`) REFERENCES `base_area` (`id`),
  CONSTRAINT `FK5DDD890F46B61FF3` FOREIGN KEY (`fk_company_id`) REFERENCES `base_company` (`id`),
  CONSTRAINT `FK5DDD890FFC026379` FOREIGN KEY (`fk_province_id`) REFERENCES `base_area` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `base_company`
--

/*!40000 ALTER TABLE `base_company` DISABLE KEYS */;
/*!40000 ALTER TABLE `base_company` ENABLE KEYS */;


--
-- Definition of table `base_customer`
--

DROP TABLE IF EXISTS `base_customer`;
CREATE TABLE `base_customer` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `address` varchar(30) DEFAULT NULL,
  `badd` varchar(255) DEFAULT NULL,
  `bcode` varchar(30) DEFAULT NULL,
  `bman` varchar(20) DEFAULT NULL,
  `bname` varchar(50) DEFAULT NULL,
  `code` varchar(10) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `fax` varchar(20) DEFAULT NULL,
  `linkman` varchar(20) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `postcode` varchar(6) DEFAULT NULL,
  `qq` varchar(20) DEFAULT NULL,
  `shortName` varchar(20) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `web` varchar(50) DEFAULT NULL,
  `fk_city_id` bigint(20) DEFAULT NULL,
  `fk_province_id` bigint(20) DEFAULT NULL,
  `fk_sort_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `code` (`code`),
  KEY `FKA5B4C58CE3EDA422` (`fk_sort_id`),
  KEY `FKA5B4C58CFC026379` (`fk_province_id`),
  KEY `FKA5B4C58CEF32BA5E` (`fk_city_id`),
  CONSTRAINT `FKA5B4C58CEF32BA5E` FOREIGN KEY (`fk_city_id`) REFERENCES `base_area` (`id`),
  CONSTRAINT `FKA5B4C58CE3EDA422` FOREIGN KEY (`fk_sort_id`) REFERENCES `sys_dict` (`id`),
  CONSTRAINT `FKA5B4C58CFC026379` FOREIGN KEY (`fk_province_id`) REFERENCES `base_area` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `base_customer`
--

/*!40000 ALTER TABLE `base_customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `base_customer` ENABLE KEYS */;


--
-- Definition of table `base_customer_log`
--

DROP TABLE IF EXISTS `base_customer_log`;
CREATE TABLE `base_customer_log` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `context` varchar(255) NOT NULL,
  `fk_customer_id` bigint(20) DEFAULT NULL,
  `fk_employee_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK8BABF211FD4C895C` (`fk_customer_id`),
  KEY `FK8BABF2114FB4DAC1` (`fk_employee_id`),
  CONSTRAINT `FK8BABF2114FB4DAC1` FOREIGN KEY (`fk_employee_id`) REFERENCES `base_employee` (`id`),
  CONSTRAINT `FK8BABF211FD4C895C` FOREIGN KEY (`fk_customer_id`) REFERENCES `base_customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `base_customer_log`
--

/*!40000 ALTER TABLE `base_customer_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `base_customer_log` ENABLE KEYS */;


--
-- Definition of table `base_customer_plan`
--

DROP TABLE IF EXISTS `base_customer_plan`;
CREATE TABLE `base_customer_plan` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `context` varchar(255) NOT NULL,
  `sort` varchar(255) NOT NULL,
  `fk_customer_id` bigint(20) DEFAULT NULL,
  `fk_employee_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKE9D415FCFD4C895C` (`fk_customer_id`),
  KEY `FKE9D415FC4FB4DAC1` (`fk_employee_id`),
  CONSTRAINT `FKE9D415FC4FB4DAC1` FOREIGN KEY (`fk_employee_id`) REFERENCES `base_employee` (`id`),
  CONSTRAINT `FKE9D415FCFD4C895C` FOREIGN KEY (`fk_customer_id`) REFERENCES `base_customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `base_customer_plan`
--

/*!40000 ALTER TABLE `base_customer_plan` DISABLE KEYS */;
/*!40000 ALTER TABLE `base_customer_plan` ENABLE KEYS */;


--
-- Definition of table `base_department`
--

DROP TABLE IF EXISTS `base_department`;
CREATE TABLE `base_department` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `code` varchar(10) NOT NULL,
  `fax` varchar(20) DEFAULT NULL,
  `manager` varchar(10) DEFAULT NULL,
  `managerId` bigint(20) DEFAULT NULL,
  `name` varchar(20) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `fk_department_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK9C66D5802634D45C` (`fk_department_id`),
  CONSTRAINT `FK9C66D5802634D45C` FOREIGN KEY (`fk_department_id`) REFERENCES `base_department` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `base_department`
--

/*!40000 ALTER TABLE `base_department` DISABLE KEYS */;
/*!40000 ALTER TABLE `base_department` ENABLE KEYS */;


--
-- Definition of table `base_employee`
--

DROP TABLE IF EXISTS `base_employee`;
CREATE TABLE `base_employee` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `address` varchar(50) DEFAULT NULL,
  `badd` varchar(100) DEFAULT NULL,
  `bcode` varchar(30) DEFAULT NULL,
  `blood` varchar(10) DEFAULT NULL,
  `bman` varchar(20) DEFAULT NULL,
  `bname` varchar(50) DEFAULT NULL,
  `born` varchar(10) DEFAULT NULL,
  `code` varchar(10) NOT NULL,
  `degree` varchar(10) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `height` varchar(10) DEFAULT NULL,
  `idcard` varchar(20) NOT NULL,
  `love` varchar(20) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `name` varchar(20) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `postcode` varchar(6) DEFAULT NULL,
  `qq` varchar(20) DEFAULT NULL,
  `school` varchar(30) DEFAULT NULL,
  `sex` varchar(10) NOT NULL,
  `specialty` varchar(30) DEFAULT NULL,
  `weight` varchar(10) DEFAULT NULL,
  `fk_city_id` bigint(20) DEFAULT NULL,
  `fk_department_id` bigint(20) DEFAULT NULL,
  `fk_duty_id` bigint(20) DEFAULT NULL,
  `fk_idtype_id` bigint(20) DEFAULT NULL,
  `fk_nation_id` bigint(20) DEFAULT NULL,
  `fk_polity_id` bigint(20) DEFAULT NULL,
  `fk_province_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `code` (`code`),
  KEY `FKC8B62C5C3955F459` (`fk_nation_id`),
  KEY `FKC8B62C5CA6FADA0B` (`fk_idtype_id`),
  KEY `FKC8B62C5CD4CBB3EA` (`fk_duty_id`),
  KEY `FKC8B62C5C2634D45C` (`fk_department_id`),
  KEY `FKC8B62C5CFC026379` (`fk_province_id`),
  KEY `FKC8B62C5CEF32BA5E` (`fk_city_id`),
  KEY `FKC8B62C5C6948E21F` (`fk_polity_id`),
  CONSTRAINT `FKC8B62C5C6948E21F` FOREIGN KEY (`fk_polity_id`) REFERENCES `sys_dict` (`id`),
  CONSTRAINT `FKC8B62C5C2634D45C` FOREIGN KEY (`fk_department_id`) REFERENCES `base_department` (`id`),
  CONSTRAINT `FKC8B62C5C3955F459` FOREIGN KEY (`fk_nation_id`) REFERENCES `sys_dict` (`id`),
  CONSTRAINT `FKC8B62C5CA6FADA0B` FOREIGN KEY (`fk_idtype_id`) REFERENCES `sys_dict` (`id`),
  CONSTRAINT `FKC8B62C5CD4CBB3EA` FOREIGN KEY (`fk_duty_id`) REFERENCES `sys_dict` (`id`),
  CONSTRAINT `FKC8B62C5CEF32BA5E` FOREIGN KEY (`fk_city_id`) REFERENCES `base_area` (`id`),
  CONSTRAINT `FKC8B62C5CFC026379` FOREIGN KEY (`fk_province_id`) REFERENCES `base_area` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `base_employee`
--

/*!40000 ALTER TABLE `base_employee` DISABLE KEYS */;
/*!40000 ALTER TABLE `base_employee` ENABLE KEYS */;


--
-- Definition of table `base_linkman`
--

DROP TABLE IF EXISTS `base_linkman`;
CREATE TABLE `base_linkman` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `company` varchar(20) DEFAULT NULL,
  `dataId` bigint(20) NOT NULL,
  `duty` varchar(10) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `name` varchar(20) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `qq` varchar(20) DEFAULT NULL,
  `sort` varchar(10) NOT NULL,
  `fk_relation_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK2FC487B28F9EAF9E` (`fk_relation_id`),
  CONSTRAINT `FK2FC487B28F9EAF9E` FOREIGN KEY (`fk_relation_id`) REFERENCES `base_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `base_linkman`
--

/*!40000 ALTER TABLE `base_linkman` DISABLE KEYS */;
/*!40000 ALTER TABLE `base_linkman` ENABLE KEYS */;


--
-- Definition of table `base_material`
--

DROP TABLE IF EXISTS `base_material`;
CREATE TABLE `base_material` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `caption` varchar(50) DEFAULT NULL,
  `code` varchar(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `price` decimal(12,2) DEFAULT NULL,
  `spec` varchar(20) DEFAULT NULL,
  `fk_category_id` bigint(20) DEFAULT NULL,
  `fk_provider_id` bigint(20) DEFAULT NULL,
  `fk_unit_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `code` (`code`),
  KEY `FK9366AAD582FF6C7C` (`fk_provider_id`),
  KEY `FK9366AAD5A175F55C` (`fk_category_id`),
  KEY `FK9366AAD54B866E7C` (`fk_unit_id`),
  CONSTRAINT `FK9366AAD54B866E7C` FOREIGN KEY (`fk_unit_id`) REFERENCES `sys_dict` (`id`),
  CONSTRAINT `FK9366AAD582FF6C7C` FOREIGN KEY (`fk_provider_id`) REFERENCES `base_provider` (`id`),
  CONSTRAINT `FK9366AAD5A175F55C` FOREIGN KEY (`fk_category_id`) REFERENCES `base_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `base_material`
--

/*!40000 ALTER TABLE `base_material` DISABLE KEYS */;
/*!40000 ALTER TABLE `base_material` ENABLE KEYS */;


--
-- Definition of table `base_product`
--

DROP TABLE IF EXISTS `base_product`;
CREATE TABLE `base_product` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `code` varchar(10) NOT NULL,
  `cost` decimal(12,2) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `price` decimal(12,2) NOT NULL,
  `type` varchar(10) NOT NULL,
  `fk_sort_id` bigint(20) DEFAULT NULL,
  `fk_customer_id` bigint(20) DEFAULT NULL,
  `fk_unit_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `code` (`code`),
  KEY `FK12C41981FD4C895C` (`fk_customer_id`),
  KEY `FK12C419811D7F2BBC` (`fk_sort_id`),
  KEY `FK12C419814B866E7C` (`fk_unit_id`),
  CONSTRAINT `FK12C419814B866E7C` FOREIGN KEY (`fk_unit_id`) REFERENCES `sys_dict` (`id`),
  CONSTRAINT `FK12C419811D7F2BBC` FOREIGN KEY (`fk_sort_id`) REFERENCES `base_category` (`id`),
  CONSTRAINT `FK12C41981FD4C895C` FOREIGN KEY (`fk_customer_id`) REFERENCES `base_customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `base_product`
--

/*!40000 ALTER TABLE `base_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `base_product` ENABLE KEYS */;


--
-- Definition of table `base_prov_mate`
--

DROP TABLE IF EXISTS `base_prov_mate`;
CREATE TABLE `base_prov_mate` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `fk_material_id` bigint(20) DEFAULT NULL,
  `fk_provider_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `fk_provider_id` (`fk_provider_id`,`fk_material_id`),
  KEY `FK8FA9462D82FF6C7C` (`fk_provider_id`),
  KEY `FK8FA9462DBBE798BC` (`fk_material_id`),
  CONSTRAINT `FK8FA9462DBBE798BC` FOREIGN KEY (`fk_material_id`) REFERENCES `base_material` (`id`),
  CONSTRAINT `FK8FA9462D82FF6C7C` FOREIGN KEY (`fk_provider_id`) REFERENCES `base_provider` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `base_prov_mate`
--

/*!40000 ALTER TABLE `base_prov_mate` DISABLE KEYS */;
/*!40000 ALTER TABLE `base_prov_mate` ENABLE KEYS */;


--
-- Definition of table `base_provider`
--

DROP TABLE IF EXISTS `base_provider`;
CREATE TABLE `base_provider` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `address` varchar(30) DEFAULT NULL,
  `badd` varchar(255) DEFAULT NULL,
  `bcode` varchar(30) DEFAULT NULL,
  `bman` varchar(20) DEFAULT NULL,
  `bname` varchar(50) DEFAULT NULL,
  `code` varchar(10) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `fax` varchar(20) DEFAULT NULL,
  `linkman` varchar(20) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `postcode` varchar(6) DEFAULT NULL,
  `qq` varchar(20) DEFAULT NULL,
  `shortName` varchar(20) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `web` varchar(50) DEFAULT NULL,
  `fk_city_id` bigint(20) DEFAULT NULL,
  `fk_province_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `code` (`code`),
  KEY `FK46B74B9FFC026379` (`fk_province_id`),
  KEY `FK46B74B9FEF32BA5E` (`fk_city_id`),
  CONSTRAINT `FK46B74B9FEF32BA5E` FOREIGN KEY (`fk_city_id`) REFERENCES `base_area` (`id`),
  CONSTRAINT `FK46B74B9FFC026379` FOREIGN KEY (`fk_province_id`) REFERENCES `base_area` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `base_provider`
--

/*!40000 ALTER TABLE `base_provider` DISABLE KEYS */;
/*!40000 ALTER TABLE `base_provider` ENABLE KEYS */;


--
-- Definition of table `base_storage`
--

DROP TABLE IF EXISTS `base_storage`;
CREATE TABLE `base_storage` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `amount` decimal(12,2) NOT NULL,
  `dataId` bigint(20) NOT NULL,
  `down` decimal(12,2) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `size` varchar(10) DEFAULT NULL,
  `sort` varchar(10) NOT NULL,
  `state` varchar(10) DEFAULT NULL,
  `storeId` bigint(20) NOT NULL,
  `up` decimal(12,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `base_storage`
--

/*!40000 ALTER TABLE `base_storage` DISABLE KEYS */;
/*!40000 ALTER TABLE `base_storage` ENABLE KEYS */;


--
-- Definition of table `base_store`
--

DROP TABLE IF EXISTS `base_store`;
CREATE TABLE `base_store` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `base_store`
--

/*!40000 ALTER TABLE `base_store` DISABLE KEYS */;
/*!40000 ALTER TABLE `base_store` ENABLE KEYS */;


--
-- Definition of table `base_work`
--

DROP TABLE IF EXISTS `base_work`;
CREATE TABLE `base_work` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `code` varchar(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `price` decimal(12,2) NOT NULL,
  `remark` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `base_work`
--

/*!40000 ALTER TABLE `base_work` DISABLE KEYS */;
/*!40000 ALTER TABLE `base_work` ENABLE KEYS */;


--
-- Definition of table `bg_day_report`
--

DROP TABLE IF EXISTS `bg_day_report`;
CREATE TABLE `bg_day_report` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `afterEnd` varchar(255) DEFAULT NULL,
  `afterStart` varchar(255) DEFAULT NULL,
  `departId` bigint(20) NOT NULL,
  `departName` varchar(255) NOT NULL,
  `empCode` varchar(255) NOT NULL,
  `empId` bigint(20) NOT NULL,
  `empName` varchar(255) NOT NULL,
  `mornEnd` varchar(255) DEFAULT NULL,
  `mornStart` varchar(255) DEFAULT NULL,
  `nightEnd` varchar(255) DEFAULT NULL,
  `nightStart` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `workDate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bg_day_report`
--

/*!40000 ALTER TABLE `bg_day_report` DISABLE KEYS */;
/*!40000 ALTER TABLE `bg_day_report` ENABLE KEYS */;


--
-- Definition of table `bg_month_report`
--

DROP TABLE IF EXISTS `bg_month_report`;
CREATE TABLE `bg_month_report` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `departId` bigint(20) NOT NULL,
  `departName` varchar(255) NOT NULL,
  `empCode` varchar(255) NOT NULL,
  `empId` bigint(20) NOT NULL,
  `empName` varchar(255) NOT NULL,
  `lateHour` decimal(10,2) DEFAULT NULL,
  `leaveHour` decimal(10,2) DEFAULT NULL,
  `noDays` decimal(10,2) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `workDate` varchar(255) DEFAULT NULL,
  `workDays` decimal(10,2) DEFAULT NULL,
  `workHour` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bg_month_report`
--

/*!40000 ALTER TABLE `bg_month_report` DISABLE KEYS */;
/*!40000 ALTER TABLE `bg_month_report` ENABLE KEYS */;


--
-- Definition of table `bg_produce_report`
--

DROP TABLE IF EXISTS `bg_produce_report`;
CREATE TABLE `bg_produce_report` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `amount` int(11) DEFAULT NULL,
  `departId` bigint(20) NOT NULL,
  `departName` varchar(255) NOT NULL,
  `empCode` varchar(255) NOT NULL,
  `empId` bigint(20) NOT NULL,
  `empName` varchar(255) NOT NULL,
  `orderId` bigint(20) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `proId` bigint(20) DEFAULT NULL,
  `proName` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `workDate` varchar(255) DEFAULT NULL,
  `workId` bigint(20) DEFAULT NULL,
  `workName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bg_produce_report`
--

/*!40000 ALTER TABLE `bg_produce_report` DISABLE KEYS */;
/*!40000 ALTER TABLE `bg_produce_report` ENABLE KEYS */;


--
-- Definition of table `bg_wage_report`
--

DROP TABLE IF EXISTS `bg_wage_report`;
CREATE TABLE `bg_wage_report` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `allowance` decimal(10,2) DEFAULT NULL,
  `amerce` decimal(10,2) DEFAULT NULL,
  `basic` decimal(10,2) DEFAULT NULL,
  `bonus` decimal(10,2) DEFAULT NULL,
  `countwork` decimal(10,2) DEFAULT NULL,
  `departId` bigint(20) NOT NULL,
  `departName` varchar(255) NOT NULL,
  `empCode` varchar(255) NOT NULL,
  `empId` bigint(20) NOT NULL,
  `empName` varchar(255) NOT NULL,
  `fact` decimal(10,2) DEFAULT NULL,
  `insurance` decimal(10,2) DEFAULT NULL,
  `overtime` decimal(10,2) DEFAULT NULL,
  `percent` decimal(10,2) DEFAULT NULL,
  `revenue` decimal(10,2) DEFAULT NULL,
  `should` decimal(10,2) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `timework` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bg_wage_report`
--

/*!40000 ALTER TABLE `bg_wage_report` DISABLE KEYS */;
/*!40000 ALTER TABLE `bg_wage_report` ENABLE KEYS */;


--
-- Definition of table `sys_app_sequence`
--

DROP TABLE IF EXISTS `sys_app_sequence`;
CREATE TABLE `sys_app_sequence` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `cnSeqName` varchar(255) NOT NULL,
  `enSeqName` varchar(255) NOT NULL,
  `seqValue` varchar(22) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `enSeqName` (`enSeqName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sys_app_sequence`
--

/*!40000 ALTER TABLE `sys_app_sequence` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_app_sequence` ENABLE KEYS */;


--
-- Definition of table `sys_dict`
--

DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `caption` varchar(50) DEFAULT NULL,
  `code` varchar(4) NOT NULL,
  `name` varchar(30) NOT NULL,
  `sort` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `code` (`code`,`sort`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sys_dict`
--

/*!40000 ALTER TABLE `sys_dict` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_dict` ENABLE KEYS */;


--
-- Definition of table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `chName` varchar(255) NOT NULL,
  `enName` varchar(255) NOT NULL,
  `href` varchar(255) DEFAULT NULL,
  `sort` int(11) NOT NULL,
  `parentId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `enName` (`enName`),
  KEY `FK74A44791C83CF32E` (`parentId`),
  CONSTRAINT `FK74A44791C83CF32E` FOREIGN KEY (`parentId`) REFERENCES `sys_menu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sys_menu`
--

/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;


--
-- Definition of table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `caption` varchar(255) DEFAULT NULL,
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sys_role`
--

/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;


--
-- Definition of table `sys_role_menu`
--

DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `fk_menu_id` bigint(20) DEFAULT NULL,
  `fk_role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `fk_role_id` (`fk_role_id`,`fk_menu_id`),
  KEY `FK65D48496AEB27F0A` (`fk_role_id`),
  KEY `FK65D484969543EA6A` (`fk_menu_id`),
  CONSTRAINT `FK65D484969543EA6A` FOREIGN KEY (`fk_menu_id`) REFERENCES `sys_menu` (`id`),
  CONSTRAINT `FK65D48496AEB27F0A` FOREIGN KEY (`fk_role_id`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sys_role_menu`
--

/*!40000 ALTER TABLE `sys_role_menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_role_menu` ENABLE KEYS */;


--
-- Definition of table `sys_role_user`
--

DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `fk_role_id` bigint(20) DEFAULT NULL,
  `fk_user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `fk_role_id` (`fk_role_id`,`fk_user_id`),
  KEY `FK65D85B02AEB27F0A` (`fk_role_id`),
  KEY `FK65D85B0253DD42EA` (`fk_user_id`),
  CONSTRAINT `FK65D85B0253DD42EA` FOREIGN KEY (`fk_user_id`) REFERENCES `sys_user` (`id`),
  CONSTRAINT `FK65D85B02AEB27F0A` FOREIGN KEY (`fk_role_id`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sys_role_user`
--

/*!40000 ALTER TABLE `sys_role_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_role_user` ENABLE KEYS */;


--
-- Definition of table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `fk_employee_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `username` (`username`),
  KEY `FK74A81DFD4FB4DAC1` (`fk_employee_id`),
  CONSTRAINT `FK74A81DFD4FB4DAC1` FOREIGN KEY (`fk_employee_id`) REFERENCES `base_employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sys_user`
--

/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;


--
-- Definition of table `xm_audit_mind`
--

DROP TABLE IF EXISTS `xm_audit_mind`;
CREATE TABLE `xm_audit_mind` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `auditDate` varchar(255) NOT NULL,
  `dataId` bigint(20) NOT NULL,
  `mind` varchar(255) NOT NULL,
  `realname` varchar(255) NOT NULL,
  `sort` varchar(20) NOT NULL,
  `state` varchar(15) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `xm_audit_mind`
--

/*!40000 ALTER TABLE `xm_audit_mind` DISABLE KEYS */;
/*!40000 ALTER TABLE `xm_audit_mind` ENABLE KEYS */;


--
-- Definition of table `xm_buy_order`
--

DROP TABLE IF EXISTS `xm_buy_order`;
CREATE TABLE `xm_buy_order` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `addDate` varchar(10) DEFAULT NULL,
  `addId` bigint(20) DEFAULT NULL,
  `addName` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `auditDate` varchar(10) DEFAULT NULL,
  `auditId` bigint(20) DEFAULT NULL,
  `auditName` varchar(20) DEFAULT NULL,
  `auditState` varchar(20) DEFAULT NULL,
  `clientId` bigint(20) DEFAULT NULL,
  `code` varchar(15) NOT NULL,
  `fax` varchar(20) DEFAULT NULL,
  `followDate` varchar(10) DEFAULT NULL,
  `followId` bigint(20) DEFAULT NULL,
  `followName` varchar(20) DEFAULT NULL,
  `followState` varchar(20) DEFAULT NULL,
  `grade` varchar(10) DEFAULT NULL,
  `linkman` varchar(20) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `nopay` decimal(12,2) DEFAULT NULL,
  `payfor` decimal(12,2) DEFAULT NULL,
  `payment` decimal(12,2) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `postcode` varchar(6) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `total` decimal(12,2) DEFAULT NULL,
  `backState` varchar(20) DEFAULT NULL,
  `balanceState` varchar(20) DEFAULT NULL,
  `cause` varchar(50) DEFAULT NULL,
  `deliver` varchar(255) DEFAULT NULL,
  `inState` varchar(20) DEFAULT NULL,
  `fk_payment_id` bigint(20) DEFAULT NULL,
  `fk_ticket_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `code` (`code`),
  KEY `FK8D42878B9C34A388` (`fk_payment_id`),
  KEY `FK8D42878BAB210E0E` (`fk_ticket_id`),
  CONSTRAINT `FK8D42878BAB210E0E` FOREIGN KEY (`fk_ticket_id`) REFERENCES `base_category` (`id`),
  CONSTRAINT `FK8D42878B9C34A388` FOREIGN KEY (`fk_payment_id`) REFERENCES `base_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `xm_buy_order`
--

/*!40000 ALTER TABLE `xm_buy_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `xm_buy_order` ENABLE KEYS */;


--
-- Definition of table `xm_buy_order_list`
--

DROP TABLE IF EXISTS `xm_buy_order_list`;
CREATE TABLE `xm_buy_order_list` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `amount` decimal(12,2) DEFAULT NULL,
  `inAmount` decimal(12,2) DEFAULT NULL,
  `mateId` bigint(20) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `price` decimal(12,2) DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL,
  `spec` varchar(20) DEFAULT NULL,
  `unit` varchar(10) DEFAULT NULL,
  `fk_order_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKBCD8E0D2CDD816D2` (`fk_order_id`),
  CONSTRAINT `FKBCD8E0D2CDD816D2` FOREIGN KEY (`fk_order_id`) REFERENCES `xm_buy_order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `xm_buy_order_list`
--

/*!40000 ALTER TABLE `xm_buy_order_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `xm_buy_order_list` ENABLE KEYS */;


--
-- Definition of table `xm_buy_price`
--

DROP TABLE IF EXISTS `xm_buy_price`;
CREATE TABLE `xm_buy_price` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `addDate` varchar(10) DEFAULT NULL,
  `addId` bigint(20) DEFAULT NULL,
  `addName` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `auditDate` varchar(10) DEFAULT NULL,
  `auditId` bigint(20) DEFAULT NULL,
  `auditName` varchar(20) DEFAULT NULL,
  `auditState` varchar(20) DEFAULT NULL,
  `clientId` bigint(20) DEFAULT NULL,
  `code` varchar(15) NOT NULL,
  `fax` varchar(20) DEFAULT NULL,
  `followDate` varchar(10) DEFAULT NULL,
  `followId` bigint(20) DEFAULT NULL,
  `followName` varchar(20) DEFAULT NULL,
  `followState` varchar(20) DEFAULT NULL,
  `grade` varchar(10) DEFAULT NULL,
  `linkman` varchar(20) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `nopay` decimal(12,2) DEFAULT NULL,
  `payfor` decimal(12,2) DEFAULT NULL,
  `payment` decimal(12,2) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `postcode` varchar(6) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `total` decimal(12,2) DEFAULT NULL,
  `askType` varchar(10) DEFAULT NULL,
  `fk_payment_id` bigint(20) DEFAULT NULL,
  `fk_ticket_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `code` (`code`),
  KEY `FK8D50B1869C34A388` (`fk_payment_id`),
  KEY `FK8D50B186AB210E0E` (`fk_ticket_id`),
  CONSTRAINT `FK8D50B186AB210E0E` FOREIGN KEY (`fk_ticket_id`) REFERENCES `base_category` (`id`),
  CONSTRAINT `FK8D50B1869C34A388` FOREIGN KEY (`fk_payment_id`) REFERENCES `base_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `xm_buy_price`
--

/*!40000 ALTER TABLE `xm_buy_price` DISABLE KEYS */;
/*!40000 ALTER TABLE `xm_buy_price` ENABLE KEYS */;


--
-- Definition of table `xm_buy_price_list`
--

DROP TABLE IF EXISTS `xm_buy_price_list`;
CREATE TABLE `xm_buy_price_list` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `amount` decimal(12,2) DEFAULT NULL,
  `mateId` bigint(20) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `price` decimal(12,2) DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL,
  `spec` varchar(20) DEFAULT NULL,
  `unit` varchar(10) DEFAULT NULL,
  `fk_order_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK388CBBB7CDE640CD` (`fk_order_id`),
  CONSTRAINT `FK388CBBB7CDE640CD` FOREIGN KEY (`fk_order_id`) REFERENCES `xm_buy_price` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `xm_buy_price_list`
--

/*!40000 ALTER TABLE `xm_buy_price_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `xm_buy_price_list` ENABLE KEYS */;


--
-- Definition of table `xm_order_budget`
--

DROP TABLE IF EXISTS `xm_order_budget`;
CREATE TABLE `xm_order_budget` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `amount` decimal(12,2) NOT NULL,
  `code` varchar(15) NOT NULL,
  `dataId` bigint(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `price` decimal(12,2) NOT NULL,
  `remark` varchar(50) DEFAULT NULL,
  `sort` varchar(10) NOT NULL,
  `unit` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `xm_order_budget`
--

/*!40000 ALTER TABLE `xm_order_budget` DISABLE KEYS */;
/*!40000 ALTER TABLE `xm_order_budget` ENABLE KEYS */;


--
-- Definition of table `xm_product_mate`
--

DROP TABLE IF EXISTS `xm_product_mate`;
CREATE TABLE `xm_product_mate` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `amount` decimal(12,2) NOT NULL,
  `code` varchar(10) NOT NULL,
  `mateId` bigint(20) NOT NULL,
  `name` varchar(60) NOT NULL,
  `price` decimal(12,2) NOT NULL,
  `proId` bigint(20) NOT NULL,
  `total` decimal(12,2) NOT NULL,
  `unit` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `xm_product_mate`
--

/*!40000 ALTER TABLE `xm_product_mate` DISABLE KEYS */;
/*!40000 ALTER TABLE `xm_product_mate` ENABLE KEYS */;


--
-- Definition of table `xm_product_price`
--

DROP TABLE IF EXISTS `xm_product_price`;
CREATE TABLE `xm_product_price` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `addDate` varchar(10) DEFAULT NULL,
  `addId` bigint(20) DEFAULT NULL,
  `addName` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `auditDate` varchar(10) DEFAULT NULL,
  `auditId` bigint(20) DEFAULT NULL,
  `auditName` varchar(20) DEFAULT NULL,
  `auditState` varchar(20) DEFAULT NULL,
  `clientId` bigint(20) DEFAULT NULL,
  `code` varchar(15) NOT NULL,
  `fax` varchar(20) DEFAULT NULL,
  `followDate` varchar(10) DEFAULT NULL,
  `followId` bigint(20) DEFAULT NULL,
  `followName` varchar(20) DEFAULT NULL,
  `followState` varchar(20) DEFAULT NULL,
  `grade` varchar(10) DEFAULT NULL,
  `linkman` varchar(20) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `nopay` decimal(12,2) DEFAULT NULL,
  `payfor` decimal(12,2) DEFAULT NULL,
  `payment` decimal(12,2) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `postcode` varchar(6) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `total` decimal(12,2) DEFAULT NULL,
  `askState` varchar(15) DEFAULT NULL,
  `askType` varchar(10) DEFAULT NULL,
  `fk_payment_id` bigint(20) DEFAULT NULL,
  `fk_ticket_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `code` (`code`),
  KEY `FK228C422F9C34A388` (`fk_payment_id`),
  KEY `FK228C422FAB210E0E` (`fk_ticket_id`),
  CONSTRAINT `FK228C422FAB210E0E` FOREIGN KEY (`fk_ticket_id`) REFERENCES `base_category` (`id`),
  CONSTRAINT `FK228C422F9C34A388` FOREIGN KEY (`fk_payment_id`) REFERENCES `base_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `xm_product_price`
--

/*!40000 ALTER TABLE `xm_product_price` DISABLE KEYS */;
/*!40000 ALTER TABLE `xm_product_price` ENABLE KEYS */;


--
-- Definition of table `xm_product_price_list`
--

DROP TABLE IF EXISTS `xm_product_price_list`;
CREATE TABLE `xm_product_price_list` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `amount` decimal(12,2) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `price` decimal(12,2) DEFAULT NULL,
  `proId` bigint(20) DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL,
  `size` varchar(10) NOT NULL,
  `unit` varchar(10) DEFAULT NULL,
  `fk_order_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK8A6E2CAEBA9F8C40` (`fk_order_id`),
  CONSTRAINT `FK8A6E2CAEBA9F8C40` FOREIGN KEY (`fk_order_id`) REFERENCES `xm_product_price` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `xm_product_price_list`
--

/*!40000 ALTER TABLE `xm_product_price_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `xm_product_price_list` ENABLE KEYS */;


--
-- Definition of table `xm_product_work`
--

DROP TABLE IF EXISTS `xm_product_work`;
CREATE TABLE `xm_product_work` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `amount` decimal(12,2) NOT NULL,
  `code` varchar(10) NOT NULL,
  `name` varchar(60) NOT NULL,
  `price` decimal(12,2) NOT NULL,
  `total` decimal(12,2) NOT NULL,
  `workId` bigint(20) NOT NULL,
  `fk_product_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK962816B3F6BF6B8` (`fk_product_id`),
  CONSTRAINT `FK962816B3F6BF6B8` FOREIGN KEY (`fk_product_id`) REFERENCES `base_product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `xm_product_work`
--

/*!40000 ALTER TABLE `xm_product_work` DISABLE KEYS */;
/*!40000 ALTER TABLE `xm_product_work` ENABLE KEYS */;


--
-- Definition of table `xm_sell_order`
--

DROP TABLE IF EXISTS `xm_sell_order`;
CREATE TABLE `xm_sell_order` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `addDate` varchar(10) DEFAULT NULL,
  `addId` bigint(20) DEFAULT NULL,
  `addName` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `auditDate` varchar(10) DEFAULT NULL,
  `auditId` bigint(20) DEFAULT NULL,
  `auditName` varchar(20) DEFAULT NULL,
  `auditState` varchar(20) DEFAULT NULL,
  `clientId` bigint(20) DEFAULT NULL,
  `code` varchar(15) NOT NULL,
  `fax` varchar(20) DEFAULT NULL,
  `followDate` varchar(10) DEFAULT NULL,
  `followId` bigint(20) DEFAULT NULL,
  `followName` varchar(20) DEFAULT NULL,
  `followState` varchar(20) DEFAULT NULL,
  `grade` varchar(10) DEFAULT NULL,
  `linkman` varchar(20) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `nopay` decimal(12,2) DEFAULT NULL,
  `payfor` decimal(12,2) DEFAULT NULL,
  `payment` decimal(12,2) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `postcode` varchar(6) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `total` decimal(12,2) DEFAULT NULL,
  `askState` varchar(20) DEFAULT NULL,
  `balance` decimal(12,2) DEFAULT NULL,
  `balanceState` varchar(20) DEFAULT NULL,
  `budget` decimal(12,2) DEFAULT NULL,
  `budgetState` varchar(20) DEFAULT NULL,
  `cost` decimal(12,2) DEFAULT NULL,
  `costkState` varchar(20) DEFAULT NULL,
  `deliver` varchar(10) DEFAULT NULL,
  `makeState` varchar(20) DEFAULT NULL,
  `outState` varchar(20) DEFAULT NULL,
  `signState` varchar(20) DEFAULT NULL,
  `fk_payment_id` bigint(20) DEFAULT NULL,
  `fk_ticket_id` bigint(20) DEFAULT NULL,
  `fk_ask_id` bigint(20) DEFAULT NULL,
  `fk_sort_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `code` (`code`),
  KEY `FK5D783FAB1D7F2BBC` (`fk_sort_id`),
  KEY `FK5D783FAB9C34A388` (`fk_payment_id`),
  KEY `FK5D783FABAB210E0E` (`fk_ticket_id`),
  KEY `FK5D783FAB879D8F35` (`fk_ask_id`),
  CONSTRAINT `FK5D783FAB879D8F35` FOREIGN KEY (`fk_ask_id`) REFERENCES `base_category` (`id`),
  CONSTRAINT `FK5D783FAB1D7F2BBC` FOREIGN KEY (`fk_sort_id`) REFERENCES `base_category` (`id`),
  CONSTRAINT `FK5D783FAB9C34A388` FOREIGN KEY (`fk_payment_id`) REFERENCES `base_category` (`id`),
  CONSTRAINT `FK5D783FABAB210E0E` FOREIGN KEY (`fk_ticket_id`) REFERENCES `base_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `xm_sell_order`
--

/*!40000 ALTER TABLE `xm_sell_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `xm_sell_order` ENABLE KEYS */;


--
-- Definition of table `xm_sell_order_list`
--

DROP TABLE IF EXISTS `xm_sell_order_list`;
CREATE TABLE `xm_sell_order_list` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `amount` decimal(12,2) DEFAULT NULL,
  `budget` decimal(12,2) DEFAULT NULL,
  `code` varchar(10) DEFAULT NULL,
  `inAmount` decimal(12,2) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `outAmount` decimal(12,2) DEFAULT NULL,
  `price` decimal(12,2) DEFAULT NULL,
  `proId` bigint(20) DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL,
  `size` varchar(10) NOT NULL,
  `unit` varchar(10) DEFAULT NULL,
  `fk_order_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKF8113CB298C4CC42` (`fk_order_id`),
  CONSTRAINT `FKF8113CB298C4CC42` FOREIGN KEY (`fk_order_id`) REFERENCES `xm_sell_order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `xm_sell_order_list`
--

/*!40000 ALTER TABLE `xm_sell_order_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `xm_sell_order_list` ENABLE KEYS */;


--
-- Definition of table `xm_store_record`
--

DROP TABLE IF EXISTS `xm_store_record`;
CREATE TABLE `xm_store_record` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `addId` bigint(20) NOT NULL,
  `addName` varchar(50) NOT NULL,
  `amount` decimal(12,2) NOT NULL,
  `name` varchar(50) NOT NULL,
  `sort` varchar(20) NOT NULL,
  `storeId` bigint(20) NOT NULL,
  `storeName` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `xm_store_record`
--

/*!40000 ALTER TABLE `xm_store_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `xm_store_record` ENABLE KEYS */;


--
-- Definition of table `xm_visit_plan`
--

DROP TABLE IF EXISTS `xm_visit_plan`;
CREATE TABLE `xm_visit_plan` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `comId` bigint(20) DEFAULT NULL,
  `comName` bigint(20) DEFAULT NULL,
  `context` varchar(255) NOT NULL,
  `sort` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `fk_contact_id` bigint(20) DEFAULT NULL,
  `fk_employee_id` bigint(20) DEFAULT NULL,
  `fk_ploy_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKE6CF59274468432E` (`fk_contact_id`),
  KEY `FKE6CF59277985EF74` (`fk_ploy_id`),
  KEY `FKE6CF59274FB4DAC1` (`fk_employee_id`),
  CONSTRAINT `FKE6CF59274FB4DAC1` FOREIGN KEY (`fk_employee_id`) REFERENCES `base_employee` (`id`),
  CONSTRAINT `FKE6CF59274468432E` FOREIGN KEY (`fk_contact_id`) REFERENCES `base_category` (`id`),
  CONSTRAINT `FKE6CF59277985EF74` FOREIGN KEY (`fk_ploy_id`) REFERENCES `base_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `xm_visit_plan`
--

/*!40000 ALTER TABLE `xm_visit_plan` DISABLE KEYS */;
/*!40000 ALTER TABLE `xm_visit_plan` ENABLE KEYS */;


--
-- Definition of table `xm_work_report`
--

DROP TABLE IF EXISTS `xm_work_report`;
CREATE TABLE `xm_work_report` (
  `id` bigint(20) NOT NULL,
  `createTime` varchar(19) NOT NULL,
  `flag` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `updateTime` varchar(19) NOT NULL,
  `addDate` varchar(10) DEFAULT NULL,
  `amount` decimal(12,2) DEFAULT NULL,
  `code` varchar(10) DEFAULT NULL,
  `name` varchar(60) DEFAULT NULL,
  `price` decimal(12,2) DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL,
  `total` decimal(12,2) DEFAULT NULL,
  `workId` bigint(20) DEFAULT NULL,
  `fk_employee_id` bigint(20) DEFAULT NULL,
  `fk_product_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK46274BD84FB4DAC1` (`fk_employee_id`),
  KEY `FK46274BD83F6BF6B8` (`fk_product_id`),
  CONSTRAINT `FK46274BD83F6BF6B8` FOREIGN KEY (`fk_product_id`) REFERENCES `base_product` (`id`),
  CONSTRAINT `FK46274BD84FB4DAC1` FOREIGN KEY (`fk_employee_id`) REFERENCES `base_employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `xm_work_report`
--

/*!40000 ALTER TABLE `xm_work_report` DISABLE KEYS */;
/*!40000 ALTER TABLE `xm_work_report` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
