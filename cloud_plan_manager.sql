/*
 Navicat Premium Data Transfer

 Source Server         : 本地mysql
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : localhost:3306
 Source Schema         : cloud_plan_manager

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 06/12/2021 16:49:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pm_list
-- ----------------------------
DROP TABLE IF EXISTS `pm_list`;
CREATE TABLE `pm_list`  (
  `list_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`list_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '任务列表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pm_list
-- ----------------------------
INSERT INTO `pm_list` VALUES (1, '测试', 1, '2021-11-03 15:41:26', '2021-11-03 15:41:26', 0);
INSERT INTO `pm_list` VALUES (2, '测试2', 1, '2021-11-04 10:41:36', '2021-11-04 10:41:36', 0);
INSERT INTO `pm_list` VALUES (3, '每日任务', 4, '2021-11-04 15:38:21', '2021-11-04 15:38:21', 0);
INSERT INTO `pm_list` VALUES (4, '每日任务', 2, '2021-11-10 09:38:25', '2021-11-10 09:38:25', 0);
INSERT INTO `pm_list` VALUES (5, '每日任务', 2, '2021-11-10 11:02:42', '2021-11-10 11:02:42', 1);
INSERT INTO `pm_list` VALUES (6, '分配给我的', 2, '2021-11-10 11:28:47', '2021-11-10 11:28:47', 1);
INSERT INTO `pm_list` VALUES (7, '我的任务', 6, '2021-11-10 17:07:20', '2021-11-10 17:07:20', 0);
INSERT INTO `pm_list` VALUES (8, '清单2', 6, '2021-11-14 04:58:37', '2021-11-14 04:58:37', 0);

-- ----------------------------
-- Table structure for pm_list_task
-- ----------------------------
DROP TABLE IF EXISTS `pm_list_task`;
CREATE TABLE `pm_list_task`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `list_id` int(11) NOT NULL COMMENT '任务列表id',
  `task_id` int(11) NOT NULL COMMENT '任务id',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '列表任务关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pm_list_task
-- ----------------------------
INSERT INTO `pm_list_task` VALUES (1, 1, 4, '2021-11-03 16:08:08', '2021-11-03 16:08:08', 0);
INSERT INTO `pm_list_task` VALUES (2, 4, 5, '2021-11-10 11:26:13', '2021-11-10 11:26:13', 1);
INSERT INTO `pm_list_task` VALUES (3, 4, 6, '2021-11-10 11:27:35', '2021-11-10 11:27:35', 1);
INSERT INTO `pm_list_task` VALUES (4, 7, 7, '2021-11-10 17:07:34', '2021-11-10 17:07:34', 0);
INSERT INTO `pm_list_task` VALUES (5, 8, 8, '2021-11-14 04:58:45', '2021-11-14 04:58:45', 0);
INSERT INTO `pm_list_task` VALUES (6, 7, 9, '2021-11-14 09:17:42', '2021-11-14 09:17:42', 0);
INSERT INTO `pm_list_task` VALUES (7, 7, 10, '2021-11-14 15:43:11', '2021-11-14 15:43:11', 0);
INSERT INTO `pm_list_task` VALUES (8, 7, 11, '2021-11-14 15:44:38', '2021-11-14 15:44:38', 0);
INSERT INTO `pm_list_task` VALUES (9, 4, 12, '2021-11-15 00:08:43', '2021-11-15 00:08:43', 1);

-- ----------------------------
-- Table structure for pm_step
-- ----------------------------
DROP TABLE IF EXISTS `pm_step`;
CREATE TABLE `pm_step`  (
  `step_id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `checked` tinyint(1) NULL DEFAULT NULL,
  `task_id` int(11) NOT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`step_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '任务步骤表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pm_step
-- ----------------------------
INSERT INTO `pm_step` VALUES (1, '测试', 0, 4, '2021-11-03 16:08:08', '2021-11-03 16:08:08', 1);
INSERT INTO `pm_step` VALUES (2, '1122', 0, 4, '2021-11-03 16:26:18', '2021-11-03 16:26:18', 1);
INSERT INTO `pm_step` VALUES (3, '测试', 0, 4, '2021-11-03 16:31:38', '2021-11-03 16:31:38', 1);
INSERT INTO `pm_step` VALUES (4, '1122', 0, 4, '2021-11-03 16:32:31', '2021-11-03 16:32:31', 1);
INSERT INTO `pm_step` VALUES (5, '1122', 0, 4, '2021-11-03 16:35:37', '2021-11-03 16:35:37', 1);
INSERT INTO `pm_step` VALUES (6, '1122', 0, 4, '2021-11-03 16:40:31', '2021-11-03 16:40:31', 0);
INSERT INTO `pm_step` VALUES (7, '打开ps5', 0, 5, '2021-11-10 11:26:13', '2021-11-10 11:26:13', 1);
INSERT INTO `pm_step` VALUES (8, '打开刺客信条', 0, 5, '2021-11-10 11:26:13', '2021-11-10 11:26:13', 1);
INSERT INTO `pm_step` VALUES (9, '脱鞋子', 0, 6, '2021-11-10 11:27:35', '2021-11-10 11:27:35', 0);
INSERT INTO `pm_step` VALUES (10, '脱袜子', 0, 6, '2021-11-10 11:27:35', '2021-11-10 11:27:35', 0);
INSERT INTO `pm_step` VALUES (11, '上床', 0, 6, '2021-11-10 11:27:35', '2021-11-10 11:27:35', 0);
INSERT INTO `pm_step` VALUES (12, '盖被子', 0, 6, '2021-11-10 11:27:35', '2021-11-10 11:27:35', 0);
INSERT INTO `pm_step` VALUES (13, '睡觉', 0, 6, '2021-11-10 11:27:35', '2021-11-10 11:27:35', 0);
INSERT INTO `pm_step` VALUES (14, '打开ps5', 1, 5, '2021-11-11 11:47:36', '2021-11-11 11:47:36', 1);
INSERT INTO `pm_step` VALUES (15, '打开刺客信条', 0, 5, '2021-11-11 11:47:36', '2021-11-11 11:47:36', 1);
INSERT INTO `pm_step` VALUES (20, '打开ps5', 1, 5, '2021-11-15 06:49:55', '2021-11-15 06:49:55', 1);
INSERT INTO `pm_step` VALUES (21, '打开刺客信条', 0, 5, '2021-11-15 06:49:55', '2021-11-15 06:49:55', 1);
INSERT INTO `pm_step` VALUES (22, '111', NULL, 7, '2021-11-15 13:27:49', '2021-11-15 13:27:49', 1);
INSERT INTO `pm_step` VALUES (23, '222', NULL, 9, '2021-11-15 13:28:01', '2021-11-15 13:28:01', 1);
INSERT INTO `pm_step` VALUES (24, '222', 1, 9, '2021-11-15 13:28:06', '2021-11-15 13:28:06', 0);
INSERT INTO `pm_step` VALUES (25, '111', 1, 7, '2021-11-15 13:28:40', '2021-11-15 13:28:40', 0);

-- ----------------------------
-- Table structure for pm_task
-- ----------------------------
DROP TABLE IF EXISTS `pm_task`;
CREATE TABLE `pm_task`  (
  `task_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `deadline` datetime NULL DEFAULT NULL,
  `remind_time` datetime NULL DEFAULT NULL COMMENT '提醒日期',
  `appendix` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '附件',
  `user_id` int(11) NOT NULL COMMENT '发布者ID',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` tinyint(1) NULL DEFAULT 0,
  `checked` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`task_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '任务表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pm_task
-- ----------------------------
INSERT INTO `pm_task` VALUES (1, 'string', 'string', '2021-11-01 14:29:27', '2021-11-01 14:29:27', 'string', 1, '2021-11-01 14:29:27', '2021-11-01 14:29:27', 1, 0);
INSERT INTO `pm_task` VALUES (2, 'string', 'string', '2021-11-01 14:29:27', '2021-11-01 22:32:56', 'string', 1, '2021-11-01 22:32:56', '2021-11-01 22:32:56', 1, 0);
INSERT INTO `pm_task` VALUES (3, '111', '111', '2021-11-02 00:35:00', '2021-11-02 08:36:15', NULL, 1, '2021-11-02 08:36:15', '2021-11-02 08:36:15', 0, 0);
INSERT INTO `pm_task` VALUES (4, '测试', '测试', '2021-11-03 00:00:00', '2021-11-03 16:06:00', '[{\"name\":\"58x58.png\",\"path\":\"https://my-community.oss-cn-qingdao.aliyuncs.com/plan-manager/2021110316402858x58.png\",\"status\":\"finish\"}]', 1, '2021-11-03 16:08:08', '2021-11-03 16:08:08', 0, 1);
INSERT INTO `pm_task` VALUES (5, '回去玩刺客信条', '无', '2021-11-10 12:25:41', '2021-11-10 11:26:13', '[{\"name\":\"58x58.png\",\"path\":\"https://my-community.oss-cn-qingdao.aliyuncs.com/plan-manager/2021111011260858x58.png\",\"status\":\"finish\"},{\"name\":\"google.txt\",\"path\":\"https://my-community.oss-cn-qingdao.aliyuncs.com/plan-manager/20211115064501google.txt\",\"status\":\"finish\"}]', 2, '2021-11-10 11:26:13', '2021-11-10 11:26:13', 0, 1);
INSERT INTO `pm_task` VALUES (6, '回去睡觉', '好好睡觉', '2021-11-10 11:27:35', '2021-11-10 11:27:35', NULL, 2, '2021-11-10 11:27:35', '2021-11-10 11:27:35', 0, 0);
INSERT INTO `pm_task` VALUES (7, '测试', NULL, '2021-11-10 17:07:34', '2021-11-10 17:07:34', NULL, 6, '2021-11-10 17:07:34', '2021-11-10 17:07:34', 0, 1);
INSERT INTO `pm_task` VALUES (8, '无', NULL, '2021-11-14 04:58:45', '2021-11-14 04:58:45', NULL, 6, '2021-11-14 04:58:45', '2021-11-14 04:58:45', 0, 0);
INSERT INTO `pm_task` VALUES (9, '测试2', NULL, '2021-11-14 09:17:42', '2021-11-14 09:17:42', NULL, 6, '2021-11-14 09:17:42', '2021-11-14 09:17:42', 0, 0);
INSERT INTO `pm_task` VALUES (10, '测试3', NULL, '2021-11-14 15:43:11', '2021-11-14 15:43:11', NULL, 6, '2021-11-14 15:43:11', '2021-11-14 15:43:11', 0, 0);
INSERT INTO `pm_task` VALUES (11, '测试3', NULL, '2021-11-14 15:44:38', '2021-11-14 15:44:38', NULL, 6, '2021-11-14 15:44:38', '2021-11-14 15:44:38', 0, 0);
INSERT INTO `pm_task` VALUES (12, '秀秀是憨憨', NULL, '2021-11-15 00:08:43', '2021-11-15 00:08:43', NULL, 2, '2021-11-15 00:08:43', '2021-11-15 00:08:43', 0, 0);

-- ----------------------------
-- Table structure for pm_task_user
-- ----------------------------
DROP TABLE IF EXISTS `pm_task_user`;
CREATE TABLE `pm_task_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '任务成员id',
  `task_id` int(11) NOT NULL COMMENT '任务id',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '任务成员关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pm_task_user
-- ----------------------------
INSERT INTO `pm_task_user` VALUES (1, 6, 5, '2021-11-10 17:03:53', '2021-11-10 17:03:53', 0);
INSERT INTO `pm_task_user` VALUES (2, 2, 7, '2021-11-10 17:09:27', '2021-11-10 17:09:27', 1);
INSERT INTO `pm_task_user` VALUES (3, 7, 12, '2021-11-15 00:11:28', '2021-11-15 00:11:28', 0);
INSERT INTO `pm_task_user` VALUES (4, 7, 12, '2021-11-15 00:11:44', '2021-11-15 00:11:44', 0);

-- ----------------------------
-- Table structure for pm_user
-- ----------------------------
DROP TABLE IF EXISTS `pm_user`;
CREATE TABLE `pm_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `sys_user_id` int(11) NOT NULL,
  `nick_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` tinyint(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `gender` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '保密',
  `phone_number` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pm_user
-- ----------------------------
INSERT INTO `pm_user` VALUES (1, 2, '起凡', 'https://my-community.oss-cn-qingdao.aliyuncs.com/plan-manager/20211110162844192x192.png', '2021-11-10 09:22:53', '2021-11-10 09:22:53', 0, '女', NULL);
INSERT INTO `pm_user` VALUES (2, 6, 'admin', 'https://my-community.oss-cn-qingdao.aliyuncs.com/plan-manager/202111140545431636868741734_-23c8a0bbfa2467a7.jpg', '2021-11-10 16:41:20', '2021-11-10 16:41:20', 0, '保密', NULL);
INSERT INTO `pm_user` VALUES (3, 7, '123456789', NULL, '2021-11-15 00:07:36', '2021-11-15 00:07:36', 0, '保密', NULL);

SET FOREIGN_KEY_CHECKS = 1;
