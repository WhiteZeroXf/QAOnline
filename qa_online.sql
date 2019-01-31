/*
Navicat MySQL Data Transfer

Source Server         : 47.93.232.226
Source Server Version : 50724
Source Host           : 47.93.232.226:3306
Source Database       : qa_online

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-01-31 09:45:01
*/

CREATE Database qa_online;
USE qa_online;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_answer
-- ----------------------------
DROP TABLE IF EXISTS `t_answer`;
CREATE TABLE `t_answer` (
  `answer_id` varchar(32) NOT NULL,
  `question_id` varchar(32) DEFAULT NULL COMMENT '所属问题id',
  `user_id` varchar(32) DEFAULT NULL COMMENT '所属用户id',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `content` varchar(1000) DEFAULT NULL COMMENT '回复',
  PRIMARY KEY (`answer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_answer
-- ----------------------------
INSERT INTO `t_answer` VALUES ('13ec86dd4d8a386ce5b8d42ed6c69eeb', '6267e5687cc8a2b5cfbf2f33b1e4d113', '2', '2019-01-12 01:53:29', '0.0');
INSERT INTO `t_answer` VALUES ('148b10aa53b8787dfa86eb336dfa415e', '2', '1', '2019-01-09 06:06:19', '你好');
INSERT INTO `t_answer` VALUES ('3416c7786dfa35655f87b8a4dcbfde2a', '51a5766eba884b7c15e553d6468be264', '2', '2019-01-10 10:38:34', 'ok');
INSERT INTO `t_answer` VALUES ('4293057c36b1f8bf54659454116961f8', '2', '1', '2019-01-09 06:09:05', '可以的可以的');
INSERT INTO `t_answer` VALUES ('646ad039d4287c4273daa0564cc118f0', '2', '1', '2019-01-10 08:50:22', '我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了我也是服了');
INSERT INTO `t_answer` VALUES ('abdba8dfb02ae3073f8991d63da7a18b', 'b332bd5f093e768f155b6e642bf29bd7', '2', '2019-01-10 10:08:14', '22');
INSERT INTO `t_answer` VALUES ('c05e48ec211b64de947c877f0a39f965', '2', '1', '2019-01-10 08:49:52', '你怕不是个傻子吧');
INSERT INTO `t_answer` VALUES ('c2cef5ed8ab21582fb36d4849a3f0d0a', '2', '1', '2019-01-09 06:06:27', '这个问题不错');
INSERT INTO `t_answer` VALUES ('efe45256da6a6371fa651430083aa0de', '1', '1', '2019-01-09 06:10:01', '可以回复了');

-- ----------------------------
-- Table structure for t_class
-- ----------------------------
DROP TABLE IF EXISTS `t_class`;
CREATE TABLE `t_class` (
  `class_id` varchar(32) NOT NULL,
  `dept_id` varchar(32) DEFAULT NULL COMMENT '系id',
  `class_name` varchar(255) DEFAULT NULL COMMENT '班级名称',
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_class
-- ----------------------------

-- ----------------------------
-- Table structure for t_dept
-- ----------------------------
DROP TABLE IF EXISTS `t_dept`;
CREATE TABLE `t_dept` (
  `dept_id` varchar(32) NOT NULL,
  `detp_name` varchar(255) DEFAULT NULL COMMENT '系名称',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_dept
-- ----------------------------

-- ----------------------------
-- Table structure for t_question
-- ----------------------------
DROP TABLE IF EXISTS `t_question`;
CREATE TABLE `t_question` (
  `question_id` varchar(32) NOT NULL,
  `user_id` varchar(32) DEFAULT NULL COMMENT '发表用户',
  `question_title` varchar(32) DEFAULT NULL COMMENT '问题名称',
  `question_context` varchar(2047) DEFAULT NULL COMMENT '问题内容',
  `question_type` int(11) DEFAULT '0' COMMENT '0普通/1热点/2精品',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_question
-- ----------------------------
INSERT INTO `t_question` VALUES ('1', '1', '怎么安装JDK', 'balabala......', '1', '2019-01-08 05:04:34');
INSERT INTO `t_question` VALUES ('2', '1', 'Java从入门到放弃', '嗯，如需成功，请先自宫', '2', '2019-01-08 06:08:40');
INSERT INTO `t_question` VALUES ('27cf7ded53584e1d35080f0311089302', '1', '这个怎么解决啊', '怎么安装Java环境啊？', '0', '2019-01-10 04:40:05');
INSERT INTO `t_question` VALUES ('51a5766eba884b7c15e553d6468be264', '1', 'q', 'q', '0', '2019-01-10 10:06:11');
INSERT INTO `t_question` VALUES ('6267e5687cc8a2b5cfbf2f33b1e4d113', '1', 'Java', 'Javaweb', '0', '2019-01-12 01:52:53');
INSERT INTO `t_question` VALUES ('b332bd5f093e768f155b6e642bf29bd7', '9ae265996a2bc35efbd9e094f9a10f8f', '今天天气不错，提个问题吧', '你是谁？你在哪？你在干什么？', '0', '2019-01-10 06:17:26');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` varchar(32) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '登录密码',
  `user_type` int(11) DEFAULT '1' COMMENT '1学生/2教师/3管理员',
  `user_gender` varchar(10) DEFAULT NULL COMMENT '0女/1男',
  `user_class_id` varchar(32) DEFAULT NULL COMMENT '用户班级',
  `user_head_img` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `user_nick_name` varchar(255) DEFAULT NULL COMMENT '昵称',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '1', '1', '1', '女', '2', '/img/fcl.jpg', '1');
INSERT INTO `t_user` VALUES ('2', '2', '2', '2', '女', '2', '/img/fcl.jpg', '2');
INSERT INTO `t_user` VALUES ('874962e447c25710cfd718a1b508b85e', '3', '3', '3', '男', null, null, '3');
INSERT INTO `t_user` VALUES ('9ae265996a2bc35efbd9e094f9a10f8f', 'Saber', 'Saber', '1', '女', null, null, 'Saber');
INSERT INTO `t_user` VALUES ('admin', 'admin', 'admin', '3', '男', '2', '/img/fcl.jpg', 'admin');
