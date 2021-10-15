/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.40 : Database - xskc
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`xskc` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `xskc`;

/*Table structure for table `commentinfo` */

DROP TABLE IF EXISTS `commentinfo`;

CREATE TABLE `commentinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自动增长',
  `studentid` varchar(32) NOT NULL COMMENT '学号',
  `schoolid` int(11) NOT NULL COMMENT '课程编号',
  `info` varchar(200) DEFAULT NULL COMMENT '评论内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8 COMMENT='用户评论';

/*Data for the table `commentinfo` */

insert  into `commentinfo`(`id`,`studentid`,`schoolid`,`info`) values (1,'20190151017',1001,'第一个评论'),(3,'20190151018',1001,'我的测试2'),(4,'20190151017',1001,'第二个评论'),(47,'123123',1001,'这是一次'),(48,'123123',1007,'hahaha真开心啊'),(49,'123123',1008,'1008'),(50,'123123',1004,'真不错'),(51,'123123',1006,'123'),(52,'123123',1004,'123'),(53,'123123',1009,'66666'),(54,'999999',1005,'不好看'),(55,'999999',1007,'是嘛？'),(56,'999999',1004,'奥里给兄弟们'),(57,'20190151015',1003,'老师讲的真好'),(58,'20190151015',1003,'不错啊'),(59,'20190151015',1003,'真好'),(60,'20190151015',1003,'取关了取关了'),(61,'20190151015',1010,'666'),(62,'20190151015',1001,'ss'),(63,'0003',1002,'哈哈哈');

/*Table structure for table `jspuser` */

DROP TABLE IF EXISTS `jspuser`;

CREATE TABLE `jspuser` (
  `username` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `jspuser` */

insert  into `jspuser`(`username`,`password`) values ('admin','admin');

/*Table structure for table `schoolinfo` */

DROP TABLE IF EXISTS `schoolinfo`;

CREATE TABLE `schoolinfo` (
  `schoolid` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程编号',
  `schoolname` varchar(32) NOT NULL COMMENT '课程名称',
  `schooltype` varchar(10) NOT NULL COMMENT '课程类别',
  `schoolcount` decimal(10,0) NOT NULL COMMENT '课程收藏人数',
  `schoolinfo` varchar(200) DEFAULT NULL COMMENT '课程简介',
  `schoolteacherinfo` varchar(200) DEFAULT NULL COMMENT '老师简介',
  `schoolteachername` varchar(32) DEFAULT NULL COMMENT '老师姓名',
  `schoolurl` varchar(2000) DEFAULT NULL COMMENT '视频url',
  `schoolimg` varchar(2000) DEFAULT NULL COMMENT '课程图片url',
  PRIMARY KEY (`schoolid`)
) ENGINE=InnoDB AUTO_INCREMENT=1047 DEFAULT CHARSET=utf8 COMMENT='课程表';

/*Data for the table `schoolinfo` */

insert  into `schoolinfo`(`schoolid`,`schoolname`,`schooltype`,`schoolcount`,`schoolinfo`,`schoolteacherinfo`,`schoolteachername`,`schoolurl`,`schoolimg`) values (1001,'高数','数学','4','这是高等数学的简介','这是老师的简介','王老师','http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804102ca905ce620b1241b726bc41dcff44e00204012882540400&bizid=1023&hy=SH&fileparam=302c020101042530230204136ffd93020457e3c4ff02024ef202031e8d7f02030f42400204045a320a0201000400','https://img.ivsky.com/img/tupian/m/202004/01/xueren-011.jpg'),(1002,'语文','语文','5','这是语文的简介','语文老师的简介','白老师','http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804102ca905ce620b1241b726bc41dcff44e00204012882540400&bizid=1023&hy=SH&fileparam=302c020101042530230204136ffd93020457e3c4ff02024ef202031e8d7f02030f42400204045a320a0201000400','https://img.ivsky.com/img/tupian/m/202004/01/xueren-011.jpg'),(1003,'大学英语Ⅰ','英语','3','这是大学英语的简介','英语老师的简介','王老师','http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804102ca905ce620b1241b726bc41dcff44e00204012882540400&bizid=1023&hy=SH&fileparam=302c020101042530230204136ffd93020457e3c4ff02024ef202031e8d7f02030f42400204045a320a0201000400','https://img.ivsky.com/img/tupian/m/202004/01/xueren-011.jpg'),(1004,'离散数学','数学','4','这是离散数学的简介','离散数学老师的简介','陆老师','http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804102ca905ce620b1241b726bc41dcff44e00204012882540400&bizid=1023&hy=SH&fileparam=302c020101042530230204136ffd93020457e3c4ff02024ef202031e8d7f02030f42400204045a320a0201000400','https://img.ivsky.com/img/tupian/m/202004/01/xueren-011.jpg'),(1005,'概率论','数学','3','这是概率论的简介','概率论老师的简介','宋老师','http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804102ca905ce620b1241b726bc41dcff44e00204012882540400&bizid=1023&hy=SH&fileparam=302c020101042530230204136ffd93020457e3c4ff02024ef202031e8d7f02030f42400204045a320a0201000400','https://img.ivsky.com/img/tupian/m/202004/01/xueren-011.jpg'),(1006,'古代汉语','语文','5','这是古代汉语的简介','古代汉语老师的简介','刘老师','http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804102ca905ce620b1241b726bc41dcff44e00204012882540400&bizid=1023&hy=SH&fileparam=302c020101042530230204136ffd93020457e3c4ff02024ef202031e8d7f02030f42400204045a320a0201000400','https://img.ivsky.com/img/tupian/m/202004/01/xueren-011.jpg'),(1007,'现代汉语教学','语文','4','这是现代汉语教学的简介','现代汉语教学老师的简介','张老师','http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804102ca905ce620b1241b726bc41dcff44e00204012882540400&bizid=1023&hy=SH&fileparam=302c020101042530230204136ffd93020457e3c4ff02024ef202031e8d7f02030f42400204045a320a0201000400','https://img.ivsky.com/img/tupian/m/202004/01/xueren-011.jpg'),(1008,'大学英语Ⅱ','英语','1','大学英语Ⅱ的简介','大学英语Ⅱ老师的简介','林老师','http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804102ca905ce620b1241b726bc41dcff44e00204012882540400&bizid=1023&hy=SH&fileparam=302c020101042530230204136ffd93020457e3c4ff02024ef202031e8d7f02030f42400204045a320a0201000400','https://img.ivsky.com/img/tupian/m/202004/01/xueren-011.jpg'),(1009,'听力英语','英语','3','这是听力英语的简介','听力英语老师的简介','王老师','http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804102ca905ce620b1241b726bc41dcff44e00204012882540400&bizid=1023&hy=SH&fileparam=302c020101042530230204136ffd93020457e3c4ff02024ef202031e8d7f02030f42400204045a320a0201000400','https://img.ivsky.com/img/tupian/m/202004/01/xueren-011.jpg'),(1010,'大学英语Ⅲ','英语','26','大学英语Ⅲ的简介','大学英语Ⅲ老师的简介','郑老师','http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804102ca905ce620b1241b726bc41dcff44e00204012882540400&bizid=1023&hy=SH&fileparam=302c020101042530230204136ffd93020457e3c4ff02024ef202031e8d7f02030f42400204045a320a0201000400','https://img.ivsky.com/img/tupian/m/202004/01/xueren-011.jpg'),(1019,'add.html','add.html','0','add.html','add.html','add.html','add.html','add.html'),(1020,'add.ht22','add.ht22','0','add.ht22','add.ht22','add.ht22','add.ht22','add.ht22'),(1021,'add.ht22','add.ht22','0','add.ht22','add.ht22','add.ht22','add.ht22','add.ht22'),(1022,'add.ht22add.ht22','add.ht22','0','add.ht22','add.ht22','add.ht22add.ht22','add.ht22','add.ht22'),(1023,'add.ht22','add.ht22','0','add.ht22','add.ht22','add.ht22','add.ht22','add.ht22'),(1024,'add.ht22','add.ht22','0','add.ht22','add.ht22','add.ht22','add.ht22','add.ht22');

/*Table structure for table `user_school` */

DROP TABLE IF EXISTS `user_school`;

CREATE TABLE `user_school` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自动增长',
  `studentid` varchar(32) NOT NULL COMMENT '学号',
  `schoolid` int(11) NOT NULL COMMENT '课程编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8 COMMENT='用户课程关联';

/*Data for the table `user_school` */

insert  into `user_school`(`id`,`studentid`,`schoolid`) values (27,'123456789',1001),(40,'123123',1004),(63,'0003',1002),(64,'0003',1007);

/*Table structure for table `userinfo` */

DROP TABLE IF EXISTS `userinfo`;

CREATE TABLE `userinfo` (
  `studentid` varchar(32) NOT NULL COMMENT '学号',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `username` varchar(32) NOT NULL COMMENT '用户姓名',
  PRIMARY KEY (`studentid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息';

/*Data for the table `userinfo` */

insert  into `userinfo`(`studentid`,`password`,`username`) values ('0003','004','小飞侠');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
