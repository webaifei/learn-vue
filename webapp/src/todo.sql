create database TodoDB;
use TodoDB;

CREATE TABLE `todos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `status` tinyint(1) DEFAULT '0',
  `statusDesc` varchar(10) DEFAULT '未完成',
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8