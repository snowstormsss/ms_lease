/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50615
Source Host           : localhost:3306
Source Database       : ms_sale

Target Server Type    : MYSQL
Target Server Version : 50615
File Encoding         : 65001

Date: 2018-02-08 13:21:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_category`
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category` (
  `categoryid` int(11) NOT NULL AUTO_INCREMENT,
  `categoryname` varchar(255) NOT NULL,
  PRIMARY KEY (`categoryid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_category
-- ----------------------------

-- ----------------------------
-- Table structure for `t_category_commodity`
-- ----------------------------
DROP TABLE IF EXISTS `t_category_commodity`;
CREATE TABLE `t_category_commodity` (
  `category_id` int(11) NOT NULL,
  `commodity_id` int(11) NOT NULL,
  KEY `FKcmb9gx0v7p4w97bb43fiogq5p` (`commodity_id`),
  KEY `FKvh5djertrsopulj2jhfu3snu` (`category_id`),
  CONSTRAINT `FKcmb9gx0v7p4w97bb43fiogq5p` FOREIGN KEY (`commodity_id`) REFERENCES `t_commodity` (`commodityid`),
  CONSTRAINT `FKvh5djertrsopulj2jhfu3snu` FOREIGN KEY (`category_id`) REFERENCES `t_category` (`categoryid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_category_commodity
-- ----------------------------

-- ----------------------------
-- Table structure for `t_collection`
-- ----------------------------
DROP TABLE IF EXISTS `t_collection`;
CREATE TABLE `t_collection` (
  `collectionid` int(11) NOT NULL AUTO_INCREMENT,
  `before_price` double NOT NULL,
  `commodity_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`collectionid`),
  KEY `FKodgslexkqxsk7blhvk2jpmo88` (`commodity_id`),
  CONSTRAINT `FKodgslexkqxsk7blhvk2jpmo88` FOREIGN KEY (`commodity_id`) REFERENCES `t_commodity` (`commodityid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_collection
-- ----------------------------

-- ----------------------------
-- Table structure for `t_comment`
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `commentid` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) NOT NULL,
  `commodity_id` int(11) DEFAULT NULL,
  `parent_commentid` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`commentid`),
  KEY `FKq6t75vwcudo61a8of1xj6kblm` (`commodity_id`),
  KEY `FK8f6bivimmo3wrqld8glu23796` (`parent_commentid`),
  KEY `FKtamaoacctq4qpko6bvtv0ke1p` (`user_id`),
  CONSTRAINT `FK8f6bivimmo3wrqld8glu23796` FOREIGN KEY (`parent_commentid`) REFERENCES `t_comment` (`commentid`),
  CONSTRAINT `FKq6t75vwcudo61a8of1xj6kblm` FOREIGN KEY (`commodity_id`) REFERENCES `t_commodity` (`commodityid`),
  CONSTRAINT `FKtamaoacctq4qpko6bvtv0ke1p` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_comment
-- ----------------------------

-- ----------------------------
-- Table structure for `t_commodity`
-- ----------------------------
DROP TABLE IF EXISTS `t_commodity`;
CREATE TABLE `t_commodity` (
  `commodityid` int(11) NOT NULL AUTO_INCREMENT,
  `commodity_status` int(11) NOT NULL,
  `commodityname` varchar(255) NOT NULL,
  `information` varchar(255) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`commodityid`),
  KEY `FKq8htv9yw9pr8ryvnl664ahqet` (`user_id`),
  CONSTRAINT `FKq8htv9yw9pr8ryvnl664ahqet` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_commodity
-- ----------------------------

-- ----------------------------
-- Table structure for `t_commodity_detail`
-- ----------------------------
DROP TABLE IF EXISTS `t_commodity_detail`;
CREATE TABLE `t_commodity_detail` (
  `commoditydetailid` int(11) NOT NULL AUTO_INCREMENT,
  `begintime` varchar(255) NOT NULL,
  `commodity_detail_status` int(11) NOT NULL,
  `endtime` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `commodity_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`commoditydetailid`),
  KEY `FK5xv4ufjb7kchcq6f6khd05d78` (`commodity_id`),
  CONSTRAINT `FK5xv4ufjb7kchcq6f6khd05d78` FOREIGN KEY (`commodity_id`) REFERENCES `t_commodity` (`commodityid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_commodity_detail
-- ----------------------------

-- ----------------------------
-- Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `orderid` int(11) NOT NULL AUTO_INCREMENT,
  `order_status` int(11) NOT NULL,
  `receiver_status` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderid`),
  KEY `FKho2r4qgj3txpy8964fnla95ub` (`user_id`),
  CONSTRAINT `FKho2r4qgj3txpy8964fnla95ub` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------

-- ----------------------------
-- Table structure for `t_order_detail`
-- ----------------------------
DROP TABLE IF EXISTS `t_order_detail`;
CREATE TABLE `t_order_detail` (
  `orderdetailid` int(11) NOT NULL AUTO_INCREMENT,
  `commoditydetail_id` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderdetailid`),
  KEY `FKs74ltaf022xbw17bmi3w0cqdy` (`commoditydetail_id`),
  KEY `FKrldcrqix0q1dx0mrmlm96exi7` (`order_id`),
  CONSTRAINT `FKrldcrqix0q1dx0mrmlm96exi7` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`orderid`),
  CONSTRAINT `FKs74ltaf022xbw17bmi3w0cqdy` FOREIGN KEY (`commoditydetail_id`) REFERENCES `t_commodity_detail` (`commoditydetailid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order_detail
-- ----------------------------

-- ----------------------------
-- Table structure for `t_permission`
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permissionname` varchar(255) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1rwkq1j8auw69w9t99r1wsamf` (`role_id`),
  CONSTRAINT `FK1rwkq1j8auw69w9t99r1wsamf` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES ('1', 'allow', '1');

-- ----------------------------
-- Table structure for `t_picture`
-- ----------------------------
DROP TABLE IF EXISTS `t_picture`;
CREATE TABLE `t_picture` (
  `picture_id` int(11) NOT NULL AUTO_INCREMENT,
  `commodity_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`picture_id`),
  KEY `FKox2x85rulhcpweg5bfkt873p6` (`commodity_id`),
  CONSTRAINT `FKox2x85rulhcpweg5bfkt873p6` FOREIGN KEY (`commodity_id`) REFERENCES `t_commodity` (`commodityid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_picture
-- ----------------------------

-- ----------------------------
-- Table structure for `t_picture_detail`
-- ----------------------------
DROP TABLE IF EXISTS `t_picture_detail`;
CREATE TABLE `t_picture_detail` (
  `picturedetailid` int(11) NOT NULL AUTO_INCREMENT,
  `path` varchar(255) NOT NULL,
  `picture_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`picturedetailid`),
  KEY `FK9ibvf9f37tp83lt20orxymttq` (`picture_id`),
  CONSTRAINT `FK9ibvf9f37tp83lt20orxymttq` FOREIGN KEY (`picture_id`) REFERENCES `t_picture` (`picture_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_picture_detail
-- ----------------------------

-- ----------------------------
-- Table structure for `t_recommend`
-- ----------------------------
DROP TABLE IF EXISTS `t_recommend`;
CREATE TABLE `t_recommend` (
  `recommendid` int(11) NOT NULL AUTO_INCREMENT,
  `commodity_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`recommendid`),
  KEY `FKe717jdxpnjdty47xk5acm87mi` (`commodity_id`),
  CONSTRAINT `FKe717jdxpnjdty47xk5acm87mi` FOREIGN KEY (`commodity_id`) REFERENCES `t_commodity` (`commodityid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_recommend
-- ----------------------------

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', 'admin');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'xyc', 'xyc');

-- ----------------------------
-- Table structure for `t_user_collection`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_collection`;
CREATE TABLE `t_user_collection` (
  `user_id` int(11) NOT NULL,
  `collection_id` int(11) NOT NULL,
  KEY `FKojg0hknadkij4c5d0174mkb6y` (`collection_id`),
  KEY `FKc2ocvt9an7lnssvr8vcbba8y2` (`user_id`),
  CONSTRAINT `FKc2ocvt9an7lnssvr8vcbba8y2` FOREIGN KEY (`user_id`) REFERENCES `t_collection` (`collectionid`),
  CONSTRAINT `FKojg0hknadkij4c5d0174mkb6y` FOREIGN KEY (`collection_id`) REFERENCES `t_user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_collection
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `role_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  KEY `FKq5un6x7ecoef5w1n39cop66kl` (`user_id`),
  KEY `FKa9c8iiy6ut0gnx491fqx4pxam` (`role_id`),
  CONSTRAINT `FKa9c8iiy6ut0gnx491fqx4pxam` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`),
  CONSTRAINT `FKq5un6x7ecoef5w1n39cop66kl` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '1');
