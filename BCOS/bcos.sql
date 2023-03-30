/*
 Navicat Premium Data Transfer

 Source Server         : ProjectOne
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : bcos

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 30/03/2023 22:21:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for card
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card`  (
  `cid` int(0) NOT NULL AUTO_INCREMENT COMMENT '卡号',
  `type` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '卡类型：金卡、银卡、钻石卡...',
  `account` double NULL DEFAULT NULL COMMENT '余额',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '开卡时间',
  `uid` int(0) NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6261010 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '银行卡表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of card
-- ----------------------------
INSERT INTO `card` VALUES (6261000, '钻石卡', 1300, '2021-07-22 10:00:00', 1000);
INSERT INTO `card` VALUES (6261001, '金卡', 1000, '2021-07-22 10:30:00', 1001);
INSERT INTO `card` VALUES (6261002, '钻石卡', 100, '2022-10-18 21:48:26', 1000);
INSERT INTO `card` VALUES (6261003, '银卡', 1700, '2022-10-18 21:50:19', 1003);
INSERT INTO `card` VALUES (6261007, '银卡', 2077, '2022-10-18 22:11:41', 1003);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户id（账号）',
  `uname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名称',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `phone` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `idcard` char(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '开户时间',
  `role` int(0) NULL DEFAULT NULL COMMENT '类型：0-管理员，1-普通用户',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1012 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1000, 'admin', '123456', '18133334444', '52232220010116123X', '2021-07-20 10:00:00', 0);
INSERT INTO `user` VALUES (1001, 'Alice', '123456', '18255551386', '622322200101162345', '2021-07-20 10:00:00', 1);
INSERT INTO `user` VALUES (1002, 'Bob', '123456', '18934568981', '5223221234116235X', '2021-07-20 10:00:00', 1);
INSERT INTO `user` VALUES (1003, 'Clover', '123456', '18066668899', '622322199005071234', '2021-07-21 10:00:00', 1);
INSERT INTO `user` VALUES (1004, 'Divid', '123456', '19938204321', '622322198001168945', '2021-07-21 10:00:00', 1);
INSERT INTO `user` VALUES (1005, 'Elen', '123456', '18211995678', '522322200201162345', '2021-07-21 10:00:00', 1);
INSERT INTO `user` VALUES (1009, 'TTAS', '123456', '10086', '110110101010101', '2022-10-22 22:05:31', 0);

SET FOREIGN_KEY_CHECKS = 1;
