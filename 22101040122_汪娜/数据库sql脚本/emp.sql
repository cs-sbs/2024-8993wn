/*
SQLyog Ultimate v12.14 (64 bit)
MySQL - 5.5.40 : Database - emp
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`emp` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `emp`;

/*Table structure for table `admindt` */

DROP TABLE IF EXISTS `admindt`;

CREATE TABLE `admindt` (
  `id` bigint(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `againcode` char(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `admindt` */

insert  into `admindt`(`id`,`username`,`password`,`againcode`) values 
(1,'admin','admin','admin'),
(2,'2','1464179427','123456'),
(3,'3','1464179427','123456');

/*Table structure for table `books` */

DROP TABLE IF EXISTS `books`;

CREATE TABLE `books` (
  `ID` bigint(11) NOT NULL AUTO_INCREMENT,
  `ISBN` varchar(30) NOT NULL,
  `TITLE` varchar(30) NOT NULL,
  `PUBLISH` varchar(30) NOT NULL,
  `STOCK` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

/*Data for the table `books` */

insert  into `books`(`ID`,`ISBN`,`TITLE`,`PUBLISH`,`STOCK`) values 
(1,'978-7-5628-3717-6','英语四级词汇速成词根',' 华东理工大学出版社',2),
(2,'345-3-5776-3455-2','狼图腾','中国人民出版社',1),
(3,'301-1-5317-3991-2','左慈传','复旦大学出版社',1),
(4,'564-2-7120-2311-1','C++语言程序设计','清华大学出版社',1),
(5,'121-5-3412-7120-8','目送','广西师范大学出版社',1),
(6,'732-5-3313-6174-2','PHP实战开发','清华大学出版社',1),
(7,'321-5-3443-3121-8','人才培养方案','科技大学出版社',1),
(8,'501-4-7211-6130-2','谁动了我的奶酪','公共艺术出版社',1),
(9,'757-1-1453-8123-0','小王子','中央人民出版社',0),
(10,'129-3-1482-7321-9','戏说PHP','则以出版社',3),
(11,'191-7-9419-4123-8','雷锋的故事','中国人民出版社',10),
(12,'624-5-1413-1127-8','钢铁是怎样炼成的','国际文学出版社',2),
(13,'978-7-80740-931-1','梁启超传．上',' 上海文化出版社',1),
(14,'978-7-5618-3724-5','建筑地带A-Z',' 天津大学出版社',1),
(15,'978-7-5038-6414-8','企业学习力研究及案例分析','中国林业出版社',1),
(16,'978-7-01-012704-0','中国与全球金融风险报告','人民出版社',1),
(17,'978-7-04-032302-3','复变函数与积分变换','高等教育出版社',1),
(18,'7-5091-0147-6　','穴位用药治百病','人民军医出版社',1),
(19,'978-7-122-22476-7','图解水暖电工技能一本通',' 化学工业出版社',1),
(20,'978-7-5502-4465-8　','无言的宇宙：隐藏在24个数学公式背后的故事','北京联合出版公司',1),
(21,'978-7-5067-7614-1','坚持走路的健身奇效',' 中国医药科技出版社',1),
(22,'978-7-122-22644-0','员工不安全行为图集','化学工业出版社',1),
(23,'978-7-5067-7613-4','冻龄美女的经络美容书','中国医药科技出版社',2),
(24,'978-7-122-23658-6','徒手格斗一学就会',' 化学工业出版社',2),
(25,'978-7-122-24082-8','酒类生产工艺与配方','化学工业出版社',1),
(26,'978-7-122-24021-7','腻子与建筑涂料新技术','化学工业出版社',1),
(27,'978-7-5067-7571-7','肾病',' 中国医药科技出版社',2),
(28,'978-7-122-24413-0','时尚健身实务指导','化学工业出版社',1),
(29,'978-7-5067-7582-3','支气管炎',' 中国医药科技出版社',1),
(30,'978-7-5027-7582-3','致命锋刃：全球军用刀具50','化学工业出版社',1),
(31,'978-7-122-23622-7','单片机应用技术入门','化学工业出版社',1),
(32,'978-7-122-23485-8','环境化学物质风险评估方法与应用','化学工业出版社',1),
(33,'978-7-5537-4873-3','王敬：能救命的刮痧书',' 江苏凤凰科学技术出版社',1),
(34,'978-7-5680-0979-9','Ruby元编程','华中科技大学出版社',1),
(35,'978-7-5390-5294-6','图解舌诊：伸伸舌头百病消',' 江西科学技术出版社',1),
(36,'978-7-5060-7887-0','民国遗民：章太炎传','东方出版社',1),
(39,'978-5623-5557-9','数据库原理与设计教程','北京邮电大学出版社',2);

/*Table structure for table `borrow` */

DROP TABLE IF EXISTS `borrow`;

CREATE TABLE `borrow` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `book` varchar(30) NOT NULL,
  `reader` varchar(30) NOT NULL,
  `borrow_date` date NOT NULL,
  `return_date` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `borrow` */

insert  into `borrow`(`ID`,`book`,`reader`,`borrow_date`,`return_date`) values 
(1,'谁动了我的奶酪','王五','2016-12-05','2016-12-16'),
(2,'小王子','张三','2016-12-05','2016-12-16'),
(4,'戏说PHP','李四','2016-12-05','2016-12-16'),
(5,'钢铁是怎样炼成的','李四','2016-12-13','2016-12-14');

/*Table structure for table `readers` */

DROP TABLE IF EXISTS `readers`;

CREATE TABLE `readers` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `code` varchar(30) NOT NULL,
  `major` varchar(30) NOT NULL,
  `stu_id` varchar(30) NOT NULL,
  `sex` varchar(2) NOT NULL,
  `born` bigint(10) NOT NULL,
  `fine` bigint(10) DEFAULT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `readers` */

insert  into `readers`(`ID`,`name`,`code`,`major`,`stu_id`,`sex`,`born`,`fine`,`date`) values 
(1,'张三','qaz123','软件工程','20140040102','男',1997,0,'2016-12-05'),
(2,'王五','uio123','会计学专业','20160103012','女',1997,0,'2016-12-05'),
(3,'路十一','123456','计算机科学','20150200101','男',1997,0,'2016-12-05'),
(4,'李四','654321','计算机科学','20150200102','男',1997,0,'2016-12-05'),
(6,'测试','123456','测试专业','2020012345','男',2000,0,'2020-07-11');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
