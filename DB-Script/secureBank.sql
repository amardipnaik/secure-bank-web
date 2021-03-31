/*
SQLyog Community v12.4.0 (64 bit)
MySQL - 5.6.26-log : Database - secure-bank
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`secure-bank` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `secure-bank`;

/*Table structure for table `transaction` */

DROP TABLE IF EXISTS `transaction`;

CREATE TABLE `transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `User_Code` varchar(255) DEFAULT NULL,
  `Bank_Name` varchar(255) DEFAULT NULL,
  `Trasaction_Type` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `State` varchar(255) DEFAULT NULL,
  `amount` varchar(255) DEFAULT NULL,
  `Trasaction_Date` varchar(255) DEFAULT NULL,
  `user_Account_Number` varchar(255) DEFAULT NULL,
  `benificiary_Account_Number` varchar(255) DEFAULT NULL,
  `Benificiary_IFSC_Code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `transaction` */

insert  into `transaction`(`id`,`User_Code`,`Bank_Name`,`Trasaction_Type`,`city`,`State`,`amount`,`Trasaction_Date`,`user_Account_Number`,`benificiary_Account_Number`,`Benificiary_IFSC_Code`) values 
(7,'6','NzE2SUNJQ0kgQmFuaw==','OTQ3OU5ldCBCYW5raW5n','Mumbai','Maharastra','MjE1MDYwMDA=','2017-04-07 01:37:20.5','NjU1MTM1MjE0NTIyMTQx','NzYxOTM2NTIxMTQyMjE=','NjI0MklGMzI1MjE=');

/*Table structure for table `user_table` */

DROP TABLE IF EXISTS `user_table`;

CREATE TABLE `user_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `First_Name` varchar(255) DEFAULT NULL,
  `Last_Name` varchar(255) DEFAULT NULL,
  `Code` varchar(255) DEFAULT NULL,
  `User_Role` varchar(255) DEFAULT NULL,
  `Contact_Number` varchar(255) DEFAULT NULL,
  `Mail_ID` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `profile` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `user_table` */

insert  into `user_table`(`id`,`login`,`password`,`First_Name`,`Last_Name`,`Code`,`User_Role`,`Contact_Number`,`Mail_ID`,`city`,`profile`) values 
(6,'QUVTTnVzZXI=','QUVTTnVzZXI=','MjQ4NXVzZXI=','NjY5M0FtYXJkaXA=',NULL,NULL,'OTg1Mzc1MjE0NTIxMjE=','ODU3MmFAZ21haWwuY29t','Pune','User'),
(7,'QUVTTmFkbWlu','QUVTTmFkbWlu','MTc1NWFkbWlu','Nzk4OWFkbWlu',NULL,NULL,'MzM4ODc1NDIyMTQyMTE=','NDQzYUBnbWFpbC5jb20=','admin','Admin');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
