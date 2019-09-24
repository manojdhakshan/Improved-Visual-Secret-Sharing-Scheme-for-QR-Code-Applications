/*
SQLyog Community v12.02 (32 bit)
MySQL - 5.5.29 : Database - visual
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`visual` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `visual`;

/*Table structure for table `msg` */

DROP TABLE IF EXISTS `msg`;

CREATE TABLE `msg` (
  `id` int(200) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `uid` varchar(200) DEFAULT NULL,
  `txt` varchar(200) DEFAULT NULL,
  `enc` varchar(200) DEFAULT NULL,
  `skey` varchar(200) DEFAULT NULL,
  `iname` varchar(200) DEFAULT NULL,
  `rname` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `msg` */

insert  into `msg`(`id`,`name`,`uid`,`txt`,`enc`,`skey`,`iname`,`rname`) values (1,'moni','1','hi how ar','4173426C850CB1969A2EDD7D3111650F','5985','5985img1','david'),(2,'moni','1','e you goo','BAE6B32D7EF592925E4CC7EFEF27F184','5985','5985img2','david'),(3,'moni','1','d morning','CF07DE977FA378B454C6626D1CF958A0','5985','5985img3','david'),(4,'moni','1',' and hh h','E38B6AB7F955252C7CB549D4CC6B8EAD','5985','5985img4','david'),(5,'moni','1','ello dlk wat dng','59D3520629086AEEAB305D058B286E64FEB959B7D4642FCB','5985','5985img5','david');

/*Table structure for table `reg` */

DROP TABLE IF EXISTS `reg`;

CREATE TABLE `reg` (
  `id` int(200) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `pass` varchar(200) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `mob` varchar(200) DEFAULT NULL,
  `city` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `reg` */

insert  into `reg`(`id`,`name`,`pass`,`email`,`mob`,`city`) values (1,'moni','moni','1croreprojects.javateam@gmail.com','7708336858','chennai'),(4,'david','david','1croreprojects.javateam@gmail.com','7708336858','chennai');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
