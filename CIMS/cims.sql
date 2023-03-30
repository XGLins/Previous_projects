/*
 Navicat Premium Data Transfer

 Source Server         : BigTwo
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : cims

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 16/10/2022 23:06:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `did` int(0) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `dname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门名称',
  `info` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门（介绍）信息',
  PRIMARY KEY (`did`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, '总部', '管理所有子部门，计划并决策部门事宜。');
INSERT INTO `department` VALUES (2, '声乐部', '欢乐的唱歌俱乐部~^');
INSERT INTO `department` VALUES (3, '舞蹈部', '优雅的舞蹈俱乐部~');
INSERT INTO `department` VALUES (4, '吉他社', '吉他手的天堂，初学者的福地……');
INSERT INTO `department` VALUES (23, 'Lambda', '就是一个函数思想，一种简洁的思维');
INSERT INTO `department` VALUES (25, '羽毛球社', '锻炼身体');

-- ----------------------------
-- Table structure for equipment
-- ----------------------------
DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment`  (
  `eid` int(0) NOT NULL AUTO_INCREMENT,
  `ename` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `edescribe` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `edname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`eid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of equipment
-- ----------------------------
INSERT INTO `equipment` VALUES (1, '空调', '用于解暑……', '总部');
INSERT INTO `equipment` VALUES (2, '路由器', '上网', '总部');
INSERT INTO `equipment` VALUES (3, '电视', '用于看视屏……', NULL);
INSERT INTO `equipment` VALUES (4, '电视2', '用于看视屏……', '综合');
INSERT INTO `equipment` VALUES (8, '小米电视机', 'sfd', '士大夫');
INSERT INTO `equipment` VALUES (10, '小米电视机01', '看电视', '羽毛球社');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户id（账号）',
  `uname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名称',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `phone` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `role` int(0) NULL DEFAULT NULL COMMENT '类型：0-管理员，1-社团成员',
  `did` int(0) NULL DEFAULT NULL COMMENT '部门id',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10030 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (110, 'xgl', '123456', '18898451245', 0, 2);
INSERT INTO `user` VALUES (1000, 'admin', '123456', '18133334444', 0, 1);
INSERT INTO `user` VALUES (10024, 'xingxing', '123456', '1008611', 1, 14);
INSERT INTO `user` VALUES (10030, '隶属', '123456', '10086', 0, 25);

SET FOREIGN_KEY_CHECKS = 1;
