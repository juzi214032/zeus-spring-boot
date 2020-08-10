/*
 Navicat Premium Data Transfer

 Source Server         : ssm
 Source Server Type    : MySQL
 Source Server Version : 50716
 Source Host           : localhost:3306
 Source Schema         : work1

 Target Server Type    : MySQL
 Target Server Version : 50716
 File Encoding         : 65001

 Date: 10/08/2020 10:51:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for contract
-- ----------------------------
DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract`  (
  `transactionContractNumber` int(11) NOT NULL AUTO_INCREMENT COMMENT '交易合同编号',
  `signDate` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '签署日期',
  `dId` int(11) NOT NULL COMMENT '需求表单id',
  `qId` int(11) NOT NULL COMMENT '报价表单id',
  `price` decimal(10, 2) NOT NULL COMMENT '签约价格',
  `amount` int(11) NOT NULL COMMENT '签约量',
  `status` int(11) NOT NULL COMMENT '合同状态，0：合同创建状态，1：合同完善状态（写合同+保存合同+签合同），2：合同完成状态',
  `url` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合同附件保存的url',
  PRIMARY KEY (`transactionContractNumber`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
