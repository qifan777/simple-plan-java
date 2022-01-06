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

 Date: 06/01/2022 11:05:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pm_feedback
-- ----------------------------
DROP TABLE IF EXISTS `pm_feedback`;
CREATE TABLE `pm_feedback`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `images` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` tinyint(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '反馈表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pm_feedback
-- ----------------------------
INSERT INTO `pm_feedback` VALUES (1, '测试反馈', NULL, 9, '2021-12-09 11:48:02', '2021-12-09 11:48:02', 0);
INSERT INTO `pm_feedback` VALUES (2, '测试反馈', NULL, 9, '2021-12-09 11:48:40', '2021-12-09 11:48:40', 0);

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
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '任务列表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pm_list
-- ----------------------------
INSERT INTO `pm_list` VALUES (1, '测试', 1, '2021-11-03 15:41:26', '2021-11-03 15:41:26', 0);
INSERT INTO `pm_list` VALUES (2, '测试2', 1, '2021-11-04 10:41:36', '2021-11-04 10:41:36', 0);
INSERT INTO `pm_list` VALUES (3, '每日任务', 4, '2021-11-04 15:38:21', '2021-11-04 15:38:21', 0);
INSERT INTO `pm_list` VALUES (4, '期末考试', 2, '2021-11-10 09:38:25', '2021-11-10 09:38:25', 0);
INSERT INTO `pm_list` VALUES (5, '每日任务', 2, '2021-11-10 11:02:42', '2021-11-10 11:02:42', 1);
INSERT INTO `pm_list` VALUES (6, '分配给我的', 2, '2021-11-10 11:28:47', '2021-11-10 11:28:47', 1);
INSERT INTO `pm_list` VALUES (7, '我的任务', 6, '2021-11-10 17:07:20', '2021-11-10 17:07:20', 0);
INSERT INTO `pm_list` VALUES (8, '清单2', 6, '2021-11-14 04:58:37', '2021-11-14 04:58:37', 0);
INSERT INTO `pm_list` VALUES (9, '好好学习', 7, '2021-11-16 15:53:46', '2021-11-16 15:53:46', 0);
INSERT INTO `pm_list` VALUES (10, '修改风险管理', 7, '2021-11-17 01:04:07', '2021-11-17 01:04:07', 0);
INSERT INTO `pm_list` VALUES (11, '每周任务', 2, '2021-11-22 12:51:18', '2021-11-22 12:51:18', 1);
INSERT INTO `pm_list` VALUES (12, '大作业', 2, '2021-12-06 10:54:40', '2021-12-06 10:54:40', 0);
INSERT INTO `pm_list` VALUES (13, '日常作业', 2, '2021-12-06 10:58:24', '2021-12-06 10:58:24', 0);
INSERT INTO `pm_list` VALUES (14, '频繁模式挖掘算法实现', 2, '2021-12-06 11:00:19', '2021-12-06 11:00:19', 1);
INSERT INTO `pm_list` VALUES (15, '测试任务', 9, '2021-12-07 16:38:46', '2021-12-07 16:38:46', 0);

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
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '列表任务关系表' ROW_FORMAT = Dynamic;

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
INSERT INTO `pm_list_task` VALUES (10, 9, 13, '2021-11-16 15:54:28', '2021-11-16 15:54:28', 0);
INSERT INTO `pm_list_task` VALUES (11, 4, 14, '2021-11-16 15:56:38', '2021-11-16 15:56:38', 1);
INSERT INTO `pm_list_task` VALUES (12, 11, 15, '2021-11-30 02:24:32', '2021-11-30 02:24:32', 1);
INSERT INTO `pm_list_task` VALUES (13, 11, 16, '2021-11-30 02:28:30', '2021-11-30 02:28:30', 1);
INSERT INTO `pm_list_task` VALUES (14, 4, 17, '2021-11-30 02:48:25', '2021-11-30 02:48:25', 0);
INSERT INTO `pm_list_task` VALUES (15, 4, 18, '2021-12-06 10:53:26', '2021-12-06 10:53:26', 0);
INSERT INTO `pm_list_task` VALUES (16, 4, 19, '2021-12-06 10:54:11', '2021-12-06 10:54:11', 0);
INSERT INTO `pm_list_task` VALUES (17, 12, 20, '2021-12-06 10:56:20', '2021-12-06 10:56:20', 0);
INSERT INTO `pm_list_task` VALUES (18, 12, 21, '2021-12-06 10:56:47', '2021-12-06 10:56:47', 0);
INSERT INTO `pm_list_task` VALUES (19, 12, 22, '2021-12-06 10:57:49', '2021-12-06 10:57:49', 0);
INSERT INTO `pm_list_task` VALUES (20, 13, 23, '2021-12-06 10:58:56', '2021-12-06 10:58:56', 0);
INSERT INTO `pm_list_task` VALUES (21, 13, 24, '2021-12-06 10:59:32', '2021-12-06 10:59:32', 0);
INSERT INTO `pm_list_task` VALUES (22, 13, 25, '2021-12-06 11:00:36', '2021-12-06 11:00:36', 0);
INSERT INTO `pm_list_task` VALUES (23, 12, 26, '2021-12-06 11:01:57', '2021-12-06 11:01:57', 0);
INSERT INTO `pm_list_task` VALUES (24, 12, 27, '2021-12-06 11:02:35', '2021-12-06 11:02:35', 0);
INSERT INTO `pm_list_task` VALUES (25, 13, 28, '2021-12-06 11:03:27', '2021-12-06 11:03:27', 0);
INSERT INTO `pm_list_task` VALUES (26, 13, 29, '2021-12-06 11:04:00', '2021-12-06 11:04:00', 0);
INSERT INTO `pm_list_task` VALUES (27, 15, 30, '2021-12-07 16:38:52', '2021-12-07 16:38:52', 0);
INSERT INTO `pm_list_task` VALUES (29, 15, 32, '2021-12-09 01:02:20', '2021-12-09 01:02:20', 1);
INSERT INTO `pm_list_task` VALUES (30, 15, 33, '2021-12-09 01:03:56', '2021-12-09 01:03:56', 1);
INSERT INTO `pm_list_task` VALUES (31, 15, 34, '2021-12-09 01:04:31', '2021-12-09 01:04:31', 1);
INSERT INTO `pm_list_task` VALUES (32, 15, 35, '2021-12-09 01:04:51', '2021-12-09 01:04:51', 0);

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
) ENGINE = InnoDB AUTO_INCREMENT = 102 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '任务步骤表' ROW_FORMAT = Dynamic;

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
INSERT INTO `pm_step` VALUES (24, '222', 1, 9, '2021-11-15 13:28:06', '2021-11-15 13:28:06', 1);
INSERT INTO `pm_step` VALUES (25, '111', 1, 7, '2021-11-15 13:28:40', '2021-11-15 13:28:40', 0);
INSERT INTO `pm_step` VALUES (26, '测试1', 0, 12, '2021-11-15 13:46:45', '2021-11-15 13:46:45', 1);
INSERT INTO `pm_step` VALUES (27, '测试1', 1, 12, '2021-11-15 13:46:49', '2021-11-15 13:46:49', 1);
INSERT INTO `pm_step` VALUES (28, '1', 0, 12, '2021-11-15 15:44:19', '2021-11-15 15:44:19', 1);
INSERT INTO `pm_step` VALUES (29, '抱住我的秀宝', 0, 14, '2021-11-16 15:56:38', '2021-11-16 15:56:38', 1);
INSERT INTO `pm_step` VALUES (30, '亲亲', 0, 14, '2021-11-16 15:56:38', '2021-11-16 15:56:38', 1);
INSERT INTO `pm_step` VALUES (31, '听一段听力', 0, 13, '2021-11-16 16:00:17', '2021-11-16 16:00:17', 1);
INSERT INTO `pm_step` VALUES (32, '听一段听力', 0, 13, '2021-11-16 16:03:29', '2021-11-16 16:03:29', 1);
INSERT INTO `pm_step` VALUES (33, '听一段听力', 0, 13, '2021-11-16 16:03:57', '2021-11-16 16:03:57', 1);
INSERT INTO `pm_step` VALUES (34, '成成是憨憨', 0, 13, '2021-11-16 16:03:57', '2021-11-16 16:03:57', 1);
INSERT INTO `pm_step` VALUES (35, '听一段听力', 0, 13, '2021-11-16 16:06:10', '2021-11-16 16:06:10', 1);
INSERT INTO `pm_step` VALUES (36, '成成是憨憨', 0, 13, '2021-11-16 16:06:10', '2021-11-16 16:06:10', 1);
INSERT INTO `pm_step` VALUES (37, '秀秀是憨憨', 0, 13, '2021-11-16 16:06:10', '2021-11-16 16:06:10', 1);
INSERT INTO `pm_step` VALUES (38, '听一段听力', 0, 13, '2021-11-17 01:49:09', '2021-11-17 01:49:09', 1);
INSERT INTO `pm_step` VALUES (39, '成成是憨憨', 0, 13, '2021-11-17 01:49:09', '2021-11-17 01:49:09', 1);
INSERT INTO `pm_step` VALUES (40, '秀秀是憨憨', 1, 13, '2021-11-17 01:49:09', '2021-11-17 01:49:09', 1);
INSERT INTO `pm_step` VALUES (41, '听一段听力', 0, 13, '2021-11-17 01:49:11', '2021-11-17 01:49:11', 1);
INSERT INTO `pm_step` VALUES (42, '成成是憨憨', 0, 13, '2021-11-17 01:49:11', '2021-11-17 01:49:11', 1);
INSERT INTO `pm_step` VALUES (43, '秀秀是憨憨', 1, 13, '2021-11-17 01:49:11', '2021-11-17 01:49:11', 1);
INSERT INTO `pm_step` VALUES (44, '听一段听力', 0, 13, '2021-11-17 01:49:12', '2021-11-17 01:49:12', 1);
INSERT INTO `pm_step` VALUES (45, '成成是憨憨', 0, 13, '2021-11-17 01:49:12', '2021-11-17 01:49:12', 1);
INSERT INTO `pm_step` VALUES (46, '秀秀是憨憨', 1, 13, '2021-11-17 01:49:12', '2021-11-17 01:49:12', 1);
INSERT INTO `pm_step` VALUES (47, '听一段听力', 0, 13, '2021-11-17 16:01:08', '2021-11-17 16:01:08', 1);
INSERT INTO `pm_step` VALUES (48, '成成是憨憨', 0, 13, '2021-11-17 16:01:08', '2021-11-17 16:01:08', 1);
INSERT INTO `pm_step` VALUES (49, '秀秀是憨憨', 1, 13, '2021-11-17 16:01:08', '2021-11-17 16:01:08', 1);
INSERT INTO `pm_step` VALUES (50, '听一段听力', 0, 13, '2021-11-17 16:01:33', '2021-11-17 16:01:33', 1);
INSERT INTO `pm_step` VALUES (51, '成成是憨憨', 0, 13, '2021-11-17 16:01:33', '2021-11-17 16:01:33', 1);
INSERT INTO `pm_step` VALUES (52, '秀秀是憨憨', 1, 13, '2021-11-17 16:01:33', '2021-11-17 16:01:33', 1);
INSERT INTO `pm_step` VALUES (53, '听一段听力', 0, 13, '2021-11-17 16:06:13', '2021-11-17 16:06:13', 1);
INSERT INTO `pm_step` VALUES (54, '成成是憨憨', 0, 13, '2021-11-17 16:06:13', '2021-11-17 16:06:13', 1);
INSERT INTO `pm_step` VALUES (55, '秀秀是憨憨', 1, 13, '2021-11-17 16:06:13', '2021-11-17 16:06:13', 1);
INSERT INTO `pm_step` VALUES (56, '听一段听力', 0, 13, '2021-11-17 16:07:03', '2021-11-17 16:07:03', 1);
INSERT INTO `pm_step` VALUES (57, '成成是憨憨', 0, 13, '2021-11-17 16:07:03', '2021-11-17 16:07:03', 1);
INSERT INTO `pm_step` VALUES (58, '秀秀是憨憨', 1, 13, '2021-11-17 16:07:03', '2021-11-17 16:07:03', 1);
INSERT INTO `pm_step` VALUES (59, '听一段听力', 0, 13, '2021-11-17 16:07:09', '2021-11-17 16:07:09', 1);
INSERT INTO `pm_step` VALUES (60, '成成是憨憨', 0, 13, '2021-11-17 16:07:09', '2021-11-17 16:07:09', 1);
INSERT INTO `pm_step` VALUES (61, '秀秀是憨憨', 1, 13, '2021-11-17 16:07:09', '2021-11-17 16:07:09', 1);
INSERT INTO `pm_step` VALUES (62, '听一段听力', 0, 13, '2021-11-17 16:07:21', '2021-11-17 16:07:21', 1);
INSERT INTO `pm_step` VALUES (63, '成成是憨憨', 0, 13, '2021-11-17 16:07:21', '2021-11-17 16:07:21', 1);
INSERT INTO `pm_step` VALUES (64, '秀秀是憨憨', 1, 13, '2021-11-17 16:07:21', '2021-11-17 16:07:21', 1);
INSERT INTO `pm_step` VALUES (65, '听一段听力', 0, 13, '2021-11-17 16:07:24', '2021-11-17 16:07:24', 1);
INSERT INTO `pm_step` VALUES (66, '成成是憨憨', 0, 13, '2021-11-17 16:07:24', '2021-11-17 16:07:24', 1);
INSERT INTO `pm_step` VALUES (67, '秀秀是憨憨', 1, 13, '2021-11-17 16:07:24', '2021-11-17 16:07:24', 1);
INSERT INTO `pm_step` VALUES (68, '听一段听力', 0, 13, '2021-11-17 16:07:28', '2021-11-17 16:07:28', 1);
INSERT INTO `pm_step` VALUES (69, '成成是憨憨', 0, 13, '2021-11-17 16:07:28', '2021-11-17 16:07:28', 1);
INSERT INTO `pm_step` VALUES (70, '秀秀是憨憨', 1, 13, '2021-11-17 16:07:28', '2021-11-17 16:07:28', 1);
INSERT INTO `pm_step` VALUES (71, '测试', 0, 11, '2021-11-18 06:59:30', '2021-11-18 06:59:30', 1);
INSERT INTO `pm_step` VALUES (72, '听一段听力', 0, 13, '2021-11-18 07:12:17', '2021-11-18 07:12:17', 1);
INSERT INTO `pm_step` VALUES (73, '成成是憨憨', 0, 13, '2021-11-18 07:12:17', '2021-11-18 07:12:17', 1);
INSERT INTO `pm_step` VALUES (74, '秀秀是憨憨', 1, 13, '2021-11-18 07:12:17', '2021-11-18 07:12:17', 1);
INSERT INTO `pm_step` VALUES (75, '听一段听力', 0, 13, '2021-11-18 07:12:38', '2021-11-18 07:12:38', 1);
INSERT INTO `pm_step` VALUES (76, '成成是憨憨', 0, 13, '2021-11-18 07:12:38', '2021-11-18 07:12:38', 1);
INSERT INTO `pm_step` VALUES (77, '秀秀是憨憨', 1, 13, '2021-11-18 07:12:38', '2021-11-18 07:12:38', 1);
INSERT INTO `pm_step` VALUES (78, '222', 1, 9, '2021-11-18 08:06:07', '2021-11-18 08:06:07', 0);
INSERT INTO `pm_step` VALUES (79, '听一段听力', 0, 13, '2021-11-19 11:08:48', '2021-11-19 11:08:48', 1);
INSERT INTO `pm_step` VALUES (80, '成成是憨憨', 0, 13, '2021-11-19 11:08:48', '2021-11-19 11:08:48', 1);
INSERT INTO `pm_step` VALUES (81, '秀秀是憨憨', 1, 13, '2021-11-19 11:08:48', '2021-11-19 11:08:48', 1);
INSERT INTO `pm_step` VALUES (82, '听一段听力', 0, 13, '2021-11-19 14:49:40', '2021-11-19 14:49:40', 1);
INSERT INTO `pm_step` VALUES (83, '成成是憨憨', 0, 13, '2021-11-19 14:49:40', '2021-11-19 14:49:40', 1);
INSERT INTO `pm_step` VALUES (84, '秀秀是憨憨', 1, 13, '2021-11-19 14:49:40', '2021-11-19 14:49:40', 1);
INSERT INTO `pm_step` VALUES (85, '听一段听力', 0, 13, '2021-11-19 14:50:04', '2021-11-19 14:50:04', 1);
INSERT INTO `pm_step` VALUES (86, '成成是憨憨', 0, 13, '2021-11-19 14:50:04', '2021-11-19 14:50:04', 1);
INSERT INTO `pm_step` VALUES (87, '秀秀是憨憨', 1, 13, '2021-11-19 14:50:04', '2021-11-19 14:50:04', 1);
INSERT INTO `pm_step` VALUES (88, '听一段听力', 0, 13, '2021-11-19 14:50:27', '2021-11-19 14:50:27', 1);
INSERT INTO `pm_step` VALUES (89, '成成是憨憨', 0, 13, '2021-11-19 14:50:27', '2021-11-19 14:50:27', 1);
INSERT INTO `pm_step` VALUES (90, '秀秀是憨憨', 1, 13, '2021-11-19 14:50:27', '2021-11-19 14:50:27', 1);
INSERT INTO `pm_step` VALUES (91, '听一段听力', 0, 13, '2021-11-19 14:50:31', '2021-11-19 14:50:31', 1);
INSERT INTO `pm_step` VALUES (92, '成成是憨憨', 0, 13, '2021-11-19 14:50:31', '2021-11-19 14:50:31', 1);
INSERT INTO `pm_step` VALUES (93, '秀秀是憨憨', 1, 13, '2021-11-19 14:50:31', '2021-11-19 14:50:31', 1);
INSERT INTO `pm_step` VALUES (94, '听一段听力', 0, 13, '2021-11-19 14:53:44', '2021-11-19 14:53:44', 1);
INSERT INTO `pm_step` VALUES (95, '成成是憨憨', 0, 13, '2021-11-19 14:53:44', '2021-11-19 14:53:44', 1);
INSERT INTO `pm_step` VALUES (96, '秀秀是憨憨', 1, 13, '2021-11-19 14:53:44', '2021-11-19 14:53:44', 1);
INSERT INTO `pm_step` VALUES (97, '听一段听力', 0, 13, '2021-11-19 14:55:57', '2021-11-19 14:55:57', 1);
INSERT INTO `pm_step` VALUES (98, '成成是憨憨', 0, 13, '2021-11-19 14:55:57', '2021-11-19 14:55:57', 1);
INSERT INTO `pm_step` VALUES (99, '秀秀是憨憨', 1, 13, '2021-11-19 14:55:57', '2021-11-19 14:55:57', 1);
INSERT INTO `pm_step` VALUES (100, '第一步', 0, 17, '2021-11-30 12:42:07', '2021-11-30 12:42:07', 1);
INSERT INTO `pm_step` VALUES (101, '第二步', 0, 17, '2021-11-30 12:42:07', '2021-11-30 12:42:07', 1);

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
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '任务表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pm_task
-- ----------------------------
INSERT INTO `pm_task` VALUES (1, 'string', 'string', '2021-11-01 14:29:27', '2021-11-01 14:29:27', 'string', 1, '2021-11-01 14:29:27', '2021-11-01 14:29:27', 1, 0);
INSERT INTO `pm_task` VALUES (2, 'string', 'string', '2021-11-01 14:29:27', '2021-11-01 22:32:56', 'string', 1, '2021-11-01 22:32:56', '2021-11-01 22:32:56', 1, 0);
INSERT INTO `pm_task` VALUES (3, '111', '111', '2021-11-02 00:35:00', '2021-11-02 08:36:15', NULL, 1, '2021-11-02 08:36:15', '2021-11-02 08:36:15', 0, 0);
INSERT INTO `pm_task` VALUES (4, '测试', '测试', '2021-11-03 00:00:00', '2021-11-03 16:06:00', '[{\"name\":\"58x58.png\",\"path\":\"https://my-community.oss-cn-qingdao.aliyuncs.com/plan-manager/2021110316402858x58.png\",\"status\":\"finish\"}]', 1, '2021-11-03 16:08:08', '2021-11-03 16:08:08', 0, 1);
INSERT INTO `pm_task` VALUES (5, '回去玩刺客信条', '<p style=\"text-align: center;\">测试<span class=\"ql-cursor\">﻿</span></p>', '2021-11-10 12:25:41', '2021-11-10 11:26:13', '[]', 2, '2021-11-10 11:26:13', '2021-11-10 11:26:13', 0, 0);
INSERT INTO `pm_task` VALUES (6, '回去睡觉', '好好睡觉', '2021-11-10 11:27:35', '2021-11-10 11:27:35', NULL, 2, '2021-11-10 11:27:35', '2021-11-10 11:27:35', 0, 0);
INSERT INTO `pm_task` VALUES (7, '测试', NULL, '2021-11-10 17:07:34', '2021-11-10 17:07:34', NULL, 6, '2021-11-10 17:07:34', '2021-11-10 17:07:34', 0, 1);
INSERT INTO `pm_task` VALUES (8, '无', NULL, '2021-11-14 04:58:45', '2021-11-14 04:58:45', NULL, 6, '2021-11-14 04:58:45', '2021-11-14 04:58:45', 0, 0);
INSERT INTO `pm_task` VALUES (9, '测试2', NULL, '2021-11-17 09:17:42', '2021-11-14 09:17:42', '[]', 6, '2021-11-14 09:17:42', '2021-11-14 09:17:42', 0, 0);
INSERT INTO `pm_task` VALUES (10, '测试3', NULL, '2021-11-14 15:43:11', '2021-11-14 15:43:11', NULL, 6, '2021-11-14 15:43:11', '2021-11-14 15:43:11', 0, 0);
INSERT INTO `pm_task` VALUES (11, '测试3', NULL, '2021-11-14 15:44:38', '2021-11-14 15:44:38', NULL, 6, '2021-11-14 15:44:38', '2021-11-14 15:44:38', 0, 0);
INSERT INTO `pm_task` VALUES (12, '秀秀是憨憨', NULL, '2021-11-15 00:08:43', '2021-11-15 00:08:43', NULL, 2, '2021-11-15 00:08:43', '2021-11-15 00:08:43', 0, 1);
INSERT INTO `pm_task` VALUES (13, '背单词', '好好背单词', '2021-11-18 23:54:23', '2021-11-16 15:54:28', '[]', 7, '2021-11-16 15:54:28', '2021-11-16 15:54:28', 0, 0);
INSERT INTO `pm_task` VALUES (14, '和秀宝见面', NULL, '2022-01-10 00:00:00', '2021-11-16 15:56:38', NULL, 2, '2021-11-16 15:56:38', '2021-11-16 15:56:38', 0, 0);
INSERT INTO `pm_task` VALUES (15, '测试', '<p><br></p>', '2021-11-30 02:24:32', '2021-11-30 02:24:32', '[]', 2, '2021-11-30 02:24:32', '2021-11-30 02:24:32', 0, 0);
INSERT INTO `pm_task` VALUES (16, '测试2', '<p><br></p>', '2021-11-30 02:28:30', '2021-11-30 02:28:30', '[]', 2, '2021-11-30 02:28:30', '2021-11-30 02:28:30', 0, 0);
INSERT INTO `pm_task` VALUES (17, '数据挖掘考试', '<ul data-checked=\"true\"><li>1111</li></ul><ol><li>2</li><li>3</li><li><img src=\"https://my-community.oss-cn-qingdao.aliyuncs.com/plan-manager/20211130124129application.png\" width=\"99\" data-custom=\"id=abcd&amp;role=god\"><img src=\"https://my-community.oss-cn-qingdao.aliyuncs.com/plan-manager/202112051603541638720233872_IMG_20211202_172458.jpg\" width=\"80%\" data-custom=\"id=abcd&amp;role=god\"></li></ol>', '2021-12-28 00:00:00', NULL, '[]', 2, '2021-11-30 02:48:25', '2021-11-30 02:48:25', 0, 0);
INSERT INTO `pm_task` VALUES (18, '微观经济学考试', '<p><br></p>', '2021-12-30 00:00:00', NULL, '[]', 2, '2021-12-06 10:53:26', '2021-12-06 10:53:26', 0, 0);
INSERT INTO `pm_task` VALUES (19, 'uml考试', '<p><br></p>', '2022-01-05 00:00:00', NULL, '[]', 2, '2021-12-06 10:54:11', '2021-12-06 10:54:11', 0, 0);
INSERT INTO `pm_task` VALUES (20, 'erp大作业', '<p><br></p>', '2021-12-20 00:00:00', NULL, '[]', 2, '2021-12-06 10:56:20', '2021-12-06 10:56:20', 0, 0);
INSERT INTO `pm_task` VALUES (21, '数学建模报告', '<p><br></p>', '2021-12-15 00:00:00', NULL, '[]', 2, '2021-12-06 10:56:47', '2021-12-06 10:56:47', 0, 0);
INSERT INTO `pm_task` VALUES (22, '市场调研报告', '<p><br></p>', '2021-12-17 00:00:00', NULL, '[]', 2, '2021-12-06 10:57:49', '2021-12-06 10:57:49', 0, 0);
INSERT INTO `pm_task` VALUES (23, '决策树实现', '<p><br></p>', '2021-11-25 00:00:00', NULL, '[]', 2, '2021-12-06 10:58:56', '2021-12-06 10:58:56', 0, 1);
INSERT INTO `pm_task` VALUES (24, '市场调研计划', '<p><br></p>', '2021-11-26 00:00:00', NULL, '[]', 2, '2021-12-06 10:59:32', '2021-12-06 10:59:32', 0, 1);
INSERT INTO `pm_task` VALUES (25, '频繁模式挖掘算法实现', '<p><br></p>', '2021-11-12 00:00:00', NULL, '[]', 2, '2021-12-06 11:00:36', '2021-12-06 11:00:36', 0, 1);
INSERT INTO `pm_task` VALUES (26, '现代信息服务系统大作业', '<p><br></p>', '2021-12-20 00:00:00', NULL, '[]', 2, '2021-12-06 11:01:57', '2021-12-06 11:01:57', 0, 1);
INSERT INTO `pm_task` VALUES (27, 'dss3000字论文', '<p><br></p>', NULL, NULL, '[]', 2, '2021-12-06 11:02:35', '2021-12-06 11:02:35', 0, 0);
INSERT INTO `pm_task` VALUES (28, '朴素贝叶斯算法', '<p><br></p>', '2021-12-01 00:00:00', NULL, '[]', 2, '2021-12-06 11:03:27', '2021-12-06 11:03:27', 0, 0);
INSERT INTO `pm_task` VALUES (29, '市场调研报告', '<p><br></p>', '2021-11-26 00:00:00', NULL, '[]', 2, '2021-12-06 11:04:00', '2021-12-06 11:04:00', 0, 0);
INSERT INTO `pm_task` VALUES (30, '11', '<p><br></p>', NULL, '2021-12-09 01:01:25', '[]', 9, '2021-12-07 16:38:52', '2021-12-07 16:38:52', 0, 0);
INSERT INTO `pm_task` VALUES (32, '测试任务2', '<p><br></p>', NULL, '2021-12-09 01:02:03', '[]', 9, '2021-12-09 01:02:20', '2021-12-09 01:02:20', 0, 0);
INSERT INTO `pm_task` VALUES (33, '测试任务', '<p><br></p>', NULL, '2021-12-09 01:07:37', '[]', 9, '2021-12-09 01:03:56', '2021-12-09 01:03:56', 0, 0);
INSERT INTO `pm_task` VALUES (34, '233', '<p><br></p>', NULL, NULL, '[]', 9, '2021-12-09 01:04:31', '2021-12-09 01:04:31', 0, 0);
INSERT INTO `pm_task` VALUES (35, '测试任务', '<p><br></p>', NULL, '2021-12-09 01:06:45', '[]', 9, '2021-12-09 01:04:51', '2021-12-09 01:04:51', 0, 0);

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
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '任务成员关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pm_task_user
-- ----------------------------
INSERT INTO `pm_task_user` VALUES (1, 6, 5, '2021-11-10 17:03:53', '2021-11-10 17:03:53', 0);
INSERT INTO `pm_task_user` VALUES (2, 2, 7, '2021-11-10 17:09:27', '2021-11-10 17:09:27', 1);
INSERT INTO `pm_task_user` VALUES (3, 7, 12, '2021-11-15 00:11:28', '2021-11-15 00:11:28', 0);
INSERT INTO `pm_task_user` VALUES (4, 7, 12, '2021-11-15 00:11:44', '2021-11-15 00:11:44', 0);
INSERT INTO `pm_task_user` VALUES (5, 2, 13, '2021-11-16 16:02:39', '2021-11-16 16:02:39', 0);
INSERT INTO `pm_task_user` VALUES (6, 2, 14, '2021-11-23 02:08:09', '2021-11-23 02:08:09', 1);

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
  `open_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pm_user
-- ----------------------------
INSERT INTO `pm_user` VALUES (1, 2, '起凡', 'https://my-community.oss-cn-qingdao.aliyuncs.com/plan-manager/20211110162844192x192.png', '2021-11-10 09:22:53', '2021-11-10 09:22:53', 0, '女', NULL, NULL);
INSERT INTO `pm_user` VALUES (2, 6, 'admin', 'https://my-community.oss-cn-qingdao.aliyuncs.com/plan-manager/202111140545431636868741734_-23c8a0bbfa2467a7.jpg', '2021-11-10 16:41:20', '2021-11-10 16:41:20', 0, '保密', NULL, NULL);
INSERT INTO `pm_user` VALUES (3, 7, '宝拉ouou', NULL, '2021-11-15 00:07:36', '2021-11-15 00:07:36', 0, '保密', NULL, NULL);
INSERT INTO `pm_user` VALUES (5, 8, '测试账号', NULL, '2021-12-07 15:20:33', '2021-12-07 15:20:33', 0, '保密', NULL, NULL);
INSERT INTO `pm_user` VALUES (6, 9, '起凡', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKrxzVuKWm8dyb1Ak4SpCVmdgf8FboR6U4SYcBVfP4J6GNCJcLDAOVmBz9qg3zjSw2DGTKYlQmK3A/132', '2021-12-07 15:35:59', '2021-12-07 15:35:59', 0, '男', NULL, 'o3NR_5PjqgjI351JuCqnV4ecMK_8');

SET FOREIGN_KEY_CHECKS = 1;
