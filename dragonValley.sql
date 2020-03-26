/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.21 : Database - valley
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`valley` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `valley`;

/*Table structure for table `activity` */

DROP TABLE IF EXISTS `activity`;

CREATE TABLE `activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `introduction` varchar(100) DEFAULT NULL,
  `state` varchar(10) NOT NULL,
  `exhibition_hall_id` int(11) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `activity_ibfk_1` (`exhibition_hall_id`),
  CONSTRAINT `activity_ibfk_1` FOREIGN KEY (`exhibition_hall_id`) REFERENCES `exhibition_hall` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `activity` */

/*Table structure for table `dragon` */

DROP TABLE IF EXISTS `dragon`;

CREATE TABLE `dragon` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(10) NOT NULL,
  `name` varchar(40) NOT NULL,
  `age` varchar(4) NOT NULL,
  `state` varchar(10) DEFAULT NULL,
  `exhibition_hall_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `dragon_ibfk_1` (`exhibition_hall_id`),
  CONSTRAINT `dragon_ibfk_1` FOREIGN KEY (`exhibition_hall_id`) REFERENCES `exhibition_hall` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `dragon` */

/*Table structure for table `evaluation` */

DROP TABLE IF EXISTS `evaluation`;

CREATE TABLE `evaluation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comments` varchar(300) DEFAULT NULL,
  `exhibition_hall_id` int(11) NOT NULL,
  `vistior_id` int(11) NOT NULL,
  `commit_time` date NOT NULL,
  `star` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `evaluation_ibfk_1` (`vistior_id`),
  KEY `evaluation_ibfk_2` (`exhibition_hall_id`),
  CONSTRAINT `evaluation_ibfk_1` FOREIGN KEY (`vistior_id`) REFERENCES `visitor` (`id`),
  CONSTRAINT `evaluation_ibfk_2` FOREIGN KEY (`exhibition_hall_id`) REFERENCES `exhibition_hall` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `evaluation` */

/*Table structure for table `exhibition_hall` */

DROP TABLE IF EXISTS `exhibition_hall`;

CREATE TABLE `exhibition_hall` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(10) NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `introduction` varchar(100) DEFAULT NULL,
  `master_id` int(11) NOT NULL,
  `address` varchar(30) DEFAULT NULL,
  `area` double(16,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `showroom_ibfk_1` (`master_id`),
  CONSTRAINT `exhibition_hall_ibfk_1` FOREIGN KEY (`master_id`) REFERENCES `master` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `exhibition_hall` */

/*Table structure for table `master` */

DROP TABLE IF EXISTS `master`;

CREATE TABLE `master` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) NOT NULL,
  `phone` varchar(16) NOT NULL,
  `account` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `master` */

insert  into `master`(`id`,`username`,`phone`,`account`,`password`) values (2,'zhangsan','124242','1246632','436357624');

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_time` datetime NOT NULL,
  `effective_time` datetime NOT NULL,
  `visitor_id` int(11) NOT NULL,
  `exhibition_hall_id` int(11) NOT NULL,
  `state` varchar(10) NOT NULL,
  `cost` double(16,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `vistor_id` (`visitor_id`),
  KEY `showroom_id` (`exhibition_hall_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`visitor_id`) REFERENCES `visitor` (`id`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`exhibition_hall_id`) REFERENCES `exhibition_hall` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `orders` */

/*Table structure for table `principal` */

DROP TABLE IF EXISTS `principal`;

CREATE TABLE `principal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) NOT NULL,
  `phone` varchar(16) NOT NULL,
  `account` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `principal` */

insert  into `principal`(`id`,`username`,`phone`,`account`,`password`) values (1,'小明','1884555','qerqtete','1884555'),(2,'小羊','19454331','134234145','124536'),(5,'小红','1545355','12352','rifidnng');

/*Table structure for table `visitor` */

DROP TABLE IF EXISTS `visitor`;

CREATE TABLE `visitor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) NOT NULL,
  `phone` varchar(16) NOT NULL,
  `account` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `visitor` */

insert  into `visitor`(`id`,`username`,`phone`,`account`,`password`) values (2,'jiaomei','19860204431','13452345','123456'),(3,'jiaoman','19860204431','13452345','124536'),(4,'messsi','18830203455','355352','18830203455'),(5,'aqua','1882356255','4563652','654724');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
