/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : base

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 14/04/2018 22:11:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cms_article
-- ----------------------------
DROP TABLE IF EXISTS `cms_article`;
CREATE TABLE `cms_article`  (
  `article_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '文章编号',
  `topic_id` int(11) NULL DEFAULT NULL COMMENT '所属专题',
  `title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文章标题',
  `author` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文章原作者',
  `fromurl` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '转载来源网址',
  `image` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '封面图',
  `keywords` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '关键字',
  `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '简介',
  `type` tinyint(4) NOT NULL DEFAULT 1 COMMENT '类型(1:普通,2:热门...)',
  `allowcomments` tinyint(4) NOT NULL DEFAULT 1 COMMENT '是否允许评论(0:不允许,1:允许)',
  `status` tinyint(4) NOT NULL DEFAULT 1 COMMENT '状态(-1:不通过,0未审核,1:通过)',
  `content` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '内容',
  `user_id` int(10) UNSIGNED NOT NULL COMMENT '发布人id',
  `readnumber` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '阅读数量',
  `top` int(11) NOT NULL DEFAULT 0 COMMENT '置顶等级',
  `system_id` int(11) NULL DEFAULT NULL COMMENT '所属系统',
  `ctime` bigint(20) UNSIGNED NOT NULL COMMENT '创建时间',
  `orders` bigint(20) UNSIGNED NOT NULL COMMENT '排序',
  PRIMARY KEY (`article_id`) USING BTREE,
  INDEX `cms_article_orders`(`orders`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cms_article
-- ----------------------------
INSERT INTO `cms_article` VALUES (3, 0, '中国经济标题1', '1', '1', '1', '1', '1', 1, 1, 0, '资讯内容', 1, 0, 0, 1, 1489827019528, 1489827019528);
INSERT INTO `cms_article` VALUES (4, 0, '中国经济标题2', '2', '2', '2', '2', '2', 1, 1, -1, '资讯内容', 1, 0, 0, 1, 1489827340870, 1489827340870);
INSERT INTO `cms_article` VALUES (5, 0, '中国经济标题3', '3', '3', '3', '3', '3', 1, 1, 1, '资讯内容', 1, 0, 0, 1, 1489827581414, 1489827581414);
INSERT INTO `cms_article` VALUES (8, 1, '日本从地球消失，我们倍(喜)感(大)心(普)痛(奔)', 'shuzheng', '网络', '', '日本消失,日本地震', '日本从地震中消失', 1, 1, 1, '好悲(gao)伤(xing)啊', 1, 12, 0, 1, 1489845594355, 1489845594355);
INSERT INTO `cms_article` VALUES (9, 0, '中国经济标题4', '4', '4', '4', '4', '4', 1, 1, 1, '资讯内容', 1, 0, 0, 1, 1490460546198, 1490460546198);
INSERT INTO `cms_article` VALUES (10, 0, '中国经济标题5', '5', '5', '5', '5', '5', 1, 1, 1, '资讯内容', 1, 0, 0, 1, 1490460567137, 1490460567137);
INSERT INTO `cms_article` VALUES (11, 0, '中国经济标题6', '6', '6', '6', '6', '6', 1, 1, 1, '资讯内容', 1, 0, 0, 1, 1490460575304, 1490460575304);
INSERT INTO `cms_article` VALUES (12, 0, '中国经济标题7', '7', '7', '7', '7', '7', 1, 1, 1, '资讯内容', 1, 0, 0, 1, 1490460582004, 1490460582004);
INSERT INTO `cms_article` VALUES (13, 0, '中国经济标题8', '8', '8', '8', '8', '8', 1, 1, 1, '资讯内容', 1, 0, 0, 1, 1490460588840, 1490460588840);
INSERT INTO `cms_article` VALUES (14, 0, '中国经济标题9', '9', '9', '9', '9', '9', 1, 1, 1, '资讯内容', 1, 0, 0, 1, 1490460596394, 1490460596394);
INSERT INTO `cms_article` VALUES (15, 0, '中国经济标题10', '10', '10', '10', '10', '10', 1, 1, 1, '资讯内容', 1, 0, 0, 1, 1490460612370, 1490460612370);
INSERT INTO `cms_article` VALUES (16, 0, '中国经济标题11', '11', '11', '11', '11', '11', 1, 1, 1, '资讯内容', 1, 0, 0, 1, 1490460782767, 1490460782767);
INSERT INTO `cms_article` VALUES (17, 0, '中国经济标题12', '12', '12', '12', '12', '12', 1, 1, 1, '资讯内容', 1, 0, 0, 1, 1490460792501, 1490460792501);
INSERT INTO `cms_article` VALUES (18, 0, '中国经济标题13', '13', '13', '13', '13', '13', 1, 1, 1, '资讯内容', 1, 0, 0, 1, 1490460800634, 1490460800634);
INSERT INTO `cms_article` VALUES (19, 0, '人为什么谈恋爱？', 'test', 'test', 'test', 'test', 'test', 1, 1, 1, '人为什么谈恋爱？', 1, 0, 0, 2, 1490460800635, 1490460800635);
INSERT INTO `cms_article` VALUES (20, 0, 'java开发笔记', 'test', 'test', 'test', 'test', 'test', 1, 1, 1, '好记性不如烂笔头', 1, 0, 0, 3, 1490460800636, 1490460800636);

-- ----------------------------
-- Table structure for cms_article_category
-- ----------------------------
DROP TABLE IF EXISTS `cms_article_category`;
CREATE TABLE `cms_article_category`  (
  `article_category_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `article_id` int(10) UNSIGNED NOT NULL COMMENT '文章编号',
  `category_id` int(10) UNSIGNED NOT NULL COMMENT '类目编号',
  PRIMARY KEY (`article_category_id`) USING BTREE,
  INDEX `cms_article_category_article_id`(`article_id`) USING BTREE,
  INDEX `cms_article_category_category_id`(`category_id`) USING BTREE,
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`category_id`) REFERENCES `cms_category` (`category_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`article_id`) REFERENCES `cms_article` (`article_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章类目关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cms_article_category
-- ----------------------------
INSERT INTO `cms_article_category` VALUES (1, 3, 6);
INSERT INTO `cms_article_category` VALUES (2, 4, 6);
INSERT INTO `cms_article_category` VALUES (3, 5, 6);
INSERT INTO `cms_article_category` VALUES (4, 9, 6);
INSERT INTO `cms_article_category` VALUES (5, 10, 6);
INSERT INTO `cms_article_category` VALUES (6, 11, 6);
INSERT INTO `cms_article_category` VALUES (7, 12, 6);
INSERT INTO `cms_article_category` VALUES (8, 12, 6);
INSERT INTO `cms_article_category` VALUES (9, 13, 6);
INSERT INTO `cms_article_category` VALUES (10, 14, 6);
INSERT INTO `cms_article_category` VALUES (11, 15, 6);
INSERT INTO `cms_article_category` VALUES (12, 16, 6);
INSERT INTO `cms_article_category` VALUES (13, 17, 6);
INSERT INTO `cms_article_category` VALUES (14, 18, 6);
INSERT INTO `cms_article_category` VALUES (15, 8, 7);
INSERT INTO `cms_article_category` VALUES (16, 19, 8);
INSERT INTO `cms_article_category` VALUES (17, 20, 9);

-- ----------------------------
-- Table structure for cms_article_tag
-- ----------------------------
DROP TABLE IF EXISTS `cms_article_tag`;
CREATE TABLE `cms_article_tag`  (
  `article_tag_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `article_id` int(10) UNSIGNED NOT NULL COMMENT '文章编号',
  `tag_id` int(10) UNSIGNED NOT NULL COMMENT '标签编号',
  PRIMARY KEY (`article_tag_id`) USING BTREE,
  INDEX `cms_article_tag_article_id`(`article_id`) USING BTREE,
  INDEX `cms_article_tag_tag_id`(`tag_id`) USING BTREE,
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`article_id`) REFERENCES `cms_article` (`article_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`tag_id`) REFERENCES `cms_tag` (`tag_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章标签关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cms_article_tag
-- ----------------------------
INSERT INTO `cms_article_tag` VALUES (1, 19, 4);
INSERT INTO `cms_article_tag` VALUES (2, 20, 5);

-- ----------------------------
-- Table structure for cms_category
-- ----------------------------
DROP TABLE IF EXISTS `cms_category`;
CREATE TABLE `cms_category`  (
  `category_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '类目编号',
  `pid` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '上级编号',
  `level` tinyint(4) NOT NULL COMMENT '层级',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `icon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图标',
  `type` tinyint(3) NOT NULL DEFAULT 1 COMMENT '类型(1:普通,2:热门...)',
  `alias` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '别名',
  `system_id` int(11) NULL DEFAULT NULL COMMENT '所属系统',
  `ctime` bigint(20) UNSIGNED NOT NULL COMMENT '创建时间',
  `orders` bigint(255) UNSIGNED NOT NULL COMMENT '排序',
  PRIMARY KEY (`category_id`) USING BTREE,
  INDEX `cms_category_orders`(`orders`) USING BTREE,
  INDEX `cms_category_pid`(`pid`) USING BTREE,
  INDEX `cms_category_alias`(`alias`) USING BTREE,
  INDEX `cms_category_level`(`level`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '类目表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cms_category
-- ----------------------------
INSERT INTO `cms_category` VALUES (5, NULL, 1, '经济', '经济类目', '', 1, 'economic', 1, 1489590733919, 1489590733919);
INSERT INTO `cms_category` VALUES (6, 5, 2, '中国经济', '中国经济类目', '', 1, 'chinaeconomic', 1, 1489590768989, 1489590768989);
INSERT INTO `cms_category` VALUES (7, 5, 2, '日本经济', '日本经济类目', '', 1, 'japaneconomic', 1, 1491636586316, 1491636586316);
INSERT INTO `cms_category` VALUES (8, NULL, 1, '人类', '人类问题', '', 1, 'people', 2, 1491636586317, 1491636586317);
INSERT INTO `cms_category` VALUES (9, NULL, 1, '技术', '技术博文', NULL, 1, 'technic', 3, 1491636586318, 1491636586318);

-- ----------------------------
-- Table structure for cms_category_tag
-- ----------------------------
DROP TABLE IF EXISTS `cms_category_tag`;
CREATE TABLE `cms_category_tag`  (
  `category_tag_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `category_id` int(10) UNSIGNED NOT NULL COMMENT '类目编号',
  `tag_id` int(10) UNSIGNED NOT NULL COMMENT '标签编号',
  PRIMARY KEY (`category_tag_id`) USING BTREE,
  INDEX `cms_category_tag_tag_id`(`tag_id`) USING BTREE,
  INDEX `cms_category_tag_category_id`(`category_id`) USING BTREE,
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`category_id`) REFERENCES `cms_category` (`category_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`tag_id`) REFERENCES `cms_tag` (`tag_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '类目标签关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cms_comment
-- ----------------------------
DROP TABLE IF EXISTS `cms_comment`;
CREATE TABLE `cms_comment`  (
  `comment_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `pid` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '回复楼中楼编号回复楼中楼编号',
  `article_id` int(10) UNSIGNED NOT NULL COMMENT '文章编号',
  `user_id` int(10) UNSIGNED NOT NULL COMMENT '用户编号',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '评论内容',
  `status` tinyint(4) NOT NULL DEFAULT 1 COMMENT '状态(-1:不通过,0:未审核,1:通过)',
  `ip` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '评论人ip地址',
  `agent` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '评论人终端信息',
  `system_id` int(11) NULL DEFAULT NULL COMMENT '所属系统',
  `ctime` bigint(20) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`comment_id`) USING BTREE,
  INDEX `cms_comment_article_id`(`article_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cms_comment
-- ----------------------------
INSERT INTO `cms_comment` VALUES (1, NULL, 8, 1, '1', 1, '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36', 1, 1490535749413);
INSERT INTO `cms_comment` VALUES (2, NULL, 8, 1, '2', 1, '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36', 1, 1490536186447);
INSERT INTO `cms_comment` VALUES (3, NULL, 8, 1, '3', 1, '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36', 1, 1490536192205);
INSERT INTO `cms_comment` VALUES (4, NULL, 8, 1, '4', 1, '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36', 1, 1490536460544);
INSERT INTO `cms_comment` VALUES (5, NULL, 8, 1, '5', 1, '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36', 1, 1490536462182);
INSERT INTO `cms_comment` VALUES (6, NULL, 8, 1, '6', 1, '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36', 1, 1490536463614);
INSERT INTO `cms_comment` VALUES (7, NULL, 8, 1, '7', 1, '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36', 1, 1490536464870);
INSERT INTO `cms_comment` VALUES (8, NULL, 8, 1, '8', 1, '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36', 1, 1490536465926);
INSERT INTO `cms_comment` VALUES (9, NULL, 8, 1, '9', 1, '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36', 1, 1490536466853);
INSERT INTO `cms_comment` VALUES (10, NULL, 8, 1, '10', 1, '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36', 1, 1490536467821);
INSERT INTO `cms_comment` VALUES (11, NULL, 19, 1, '1', 1, '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36', 2, 1491737900448);
INSERT INTO `cms_comment` VALUES (12, NULL, 19, 1, '3', 1, '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36', 2, 1491737902517);
INSERT INTO `cms_comment` VALUES (13, NULL, 19, 1, '4', 1, '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36', 2, 1491737903420);
INSERT INTO `cms_comment` VALUES (14, NULL, 19, 1, '5', 1, '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36', 2, 1491737904428);
INSERT INTO `cms_comment` VALUES (15, NULL, 19, 1, '6', 1, '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36', 2, 1491737905236);
INSERT INTO `cms_comment` VALUES (16, NULL, 19, 1, '7', 1, '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36', 2, 1491737905980);

-- ----------------------------
-- Table structure for cms_menu
-- ----------------------------
DROP TABLE IF EXISTS `cms_menu`;
CREATE TABLE `cms_menu`  (
  `menu_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `pid` int(11) NULL DEFAULT NULL COMMENT '父菜单',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
  `url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '链接',
  `target` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '打开方式',
  `orders` bigint(20) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '菜单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cms_menu
-- ----------------------------
INSERT INTO `cms_menu` VALUES (1, NULL, '首页', '/', '_self', 1489847080380);
INSERT INTO `cms_menu` VALUES (2, NULL, '问答', '/qa', '_self', 1489847186644);
INSERT INTO `cms_menu` VALUES (3, NULL, '博客', '/blog', '_self', 1489847186645);
INSERT INTO `cms_menu` VALUES (4, NULL, '资讯', '/news', '_self', 1489847080381);
INSERT INTO `cms_menu` VALUES (5, NULL, '专题', '/topic/list', '_self', 1489847186646);
INSERT INTO `cms_menu` VALUES (6, NULL, '关于', '/page/about', '_self', 1489847186647);

-- ----------------------------
-- Table structure for cms_page
-- ----------------------------
DROP TABLE IF EXISTS `cms_page`;
CREATE TABLE `cms_page`  (
  `page_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编码',
  `pid` int(10) NULL DEFAULT NULL COMMENT '父页面',
  `title` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标题',
  `alias` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '别名',
  `content` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '页面内容',
  `keywords` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '关键字',
  `description` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `ctime` bigint(20) NULL DEFAULT NULL COMMENT '创建时间',
  `orders` bigint(20) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`page_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '页面' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cms_page
-- ----------------------------
INSERT INTO `cms_page` VALUES (1, NULL, '关于', 'about', '作者：张恕征', '单页关键字', '单页描述', 1489839705049, 1489839705049);

-- ----------------------------
-- Table structure for cms_setting
-- ----------------------------
DROP TABLE IF EXISTS `cms_setting`;
CREATE TABLE `cms_setting`  (
  `setting_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `setting_key` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `setting_value` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`setting_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '网站配置' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cms_setting
-- ----------------------------
INSERT INTO `cms_setting` VALUES (1, 'copyright', '© 2017 Zhang Shuzheng');

-- ----------------------------
-- Table structure for cms_system
-- ----------------------------
DROP TABLE IF EXISTS `cms_system`;
CREATE TABLE `cms_system`  (
  `system_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '系统名称',
  `code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '别名',
  `description` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `ctime` bigint(20) NULL DEFAULT NULL COMMENT '创建时间',
  `orders` bigint(20) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`system_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cms_system
-- ----------------------------
INSERT INTO `cms_system` VALUES (1, '资讯', 'news', '资讯', 1, 1);
INSERT INTO `cms_system` VALUES (2, '问答', 'qa', '问答', 2, 2);
INSERT INTO `cms_system` VALUES (3, '博客', 'blog', '博客', 3, 3);

-- ----------------------------
-- Table structure for cms_tag
-- ----------------------------
DROP TABLE IF EXISTS `cms_tag`;
CREATE TABLE `cms_tag`  (
  `tag_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '标签编号',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `icon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图标',
  `type` tinyint(4) NOT NULL DEFAULT 1 COMMENT '类型(1:普通,2:热门...)',
  `alias` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '别名',
  `system_id` int(11) NULL DEFAULT NULL COMMENT '所属系统',
  `ctime` bigint(20) UNSIGNED NOT NULL COMMENT '创建时间',
  `orders` bigint(20) UNSIGNED NOT NULL COMMENT '排序',
  PRIMARY KEY (`tag_id`) USING BTREE,
  INDEX `cms_tag_orders`(`orders`) USING BTREE,
  INDEX `cms_tag_alias`(`alias`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '标签表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cms_tag
-- ----------------------------
INSERT INTO `cms_tag` VALUES (1, 'JAVA', 'java标签', '', 1, 'java', 1, 1489585694864, 1489585694864);
INSERT INTO `cms_tag` VALUES (2, 'Android', 'android标签', '', 1, 'android', 1, 1489585720382, 1489585720382);
INSERT INTO `cms_tag` VALUES (3, 'zheng', 'zheng标签', '', 2, 'zheng', 1, 1489585815042, 1489585815042);
INSERT INTO `cms_tag` VALUES (4, '谈恋爱', '谈恋爱标签', '', 1, 'love', 2, 1489585815043, 1489585815043);
INSERT INTO `cms_tag` VALUES (5, 'java', 'java标签', '', 1, 'java', 3, 1489585815044, 1489585815044);

-- ----------------------------
-- Table structure for cms_topic
-- ----------------------------
DROP TABLE IF EXISTS `cms_topic`;
CREATE TABLE `cms_topic`  (
  `topic_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标题',
  `description` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '链接',
  `ctime` bigint(20) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`topic_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '专题' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cms_topic
-- ----------------------------
INSERT INTO `cms_topic` VALUES (1, '日本地震专题', '日本经历灭国性地震，彻底沉入海底', '/topic/1', 1489843484448);

-- ----------------------------
-- Table structure for pay_in_order
-- ----------------------------
DROP TABLE IF EXISTS `pay_in_order`;
CREATE TABLE `pay_in_order`  (
  `pay_in_order_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `pay_vendor_id` int(10) NULL DEFAULT NULL,
  `pay_mch_id` int(10) NULL DEFAULT NULL,
  `amount` decimal(10, 0) NOT NULL,
  `status` tinyint(4) NOT NULL,
  `ctime` bigint(20) UNSIGNED NOT NULL,
  PRIMARY KEY (`pay_in_order_id`) USING BTREE,
  INDEX `FK_Reference_32`(`pay_vendor_id`) USING BTREE,
  INDEX `FK_Reference_38`(`pay_mch_id`) USING BTREE,
  CONSTRAINT `FK_Reference_32` FOREIGN KEY (`pay_vendor_id`) REFERENCES `pay_vendor` (`pay_vendor_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_38` FOREIGN KEY (`pay_mch_id`) REFERENCES `pay_mch` (`pay_mch_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '收入订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pay_in_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `pay_in_order_detail`;
CREATE TABLE `pay_in_order_detail`  (
  `pay_in_order_detail_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `pay_in_order_id` int(10) NULL DEFAULT NULL,
  `product_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `product_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `product_price` decimal(10, 0) NULL DEFAULT NULL,
  `product_count` int(10) NULL DEFAULT NULL,
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`pay_in_order_detail_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '收入订单明细表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pay_mch
-- ----------------------------
DROP TABLE IF EXISTS `pay_mch`;
CREATE TABLE `pay_mch`  (
  `pay_mch_id` int(10) NOT NULL AUTO_INCREMENT,
  `mch_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `reqKey` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `resKey` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`pay_mch_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '支付中心商户管理表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pay_out_order
-- ----------------------------
DROP TABLE IF EXISTS `pay_out_order`;
CREATE TABLE `pay_out_order`  (
  `pay_out_order_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `pay_mch_id` int(10) NULL DEFAULT NULL,
  `pay_vendor_id` int(10) NULL DEFAULT NULL,
  `amount` decimal(10, 0) NOT NULL,
  `status` tinyint(4) NOT NULL,
  `ctime` bigint(20) UNSIGNED NOT NULL,
  PRIMARY KEY (`pay_out_order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '支出订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pay_out_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `pay_out_order_detail`;
CREATE TABLE `pay_out_order_detail`  (
  `pay_out_order_detail_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `pay_out_order_id` int(10) NULL DEFAULT NULL,
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`pay_out_order_detail_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '支出订单明细表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pay_pay
-- ----------------------------
DROP TABLE IF EXISTS `pay_pay`;
CREATE TABLE `pay_pay`  (
  `pay_pay_id` int(10) NOT NULL AUTO_INCREMENT,
  `pay_type_id` int(10) NULL DEFAULT NULL,
  `param` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`pay_pay_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '支付参数配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pay_type
-- ----------------------------
DROP TABLE IF EXISTS `pay_type`;
CREATE TABLE `pay_type`  (
  `pay_type_id` int(10) NOT NULL AUTO_INCREMENT,
  `pay_vendor_id` int(10) NULL DEFAULT NULL,
  `pay_mch_id` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`pay_type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商户支持支付类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pay_type
-- ----------------------------
INSERT INTO `pay_type` VALUES (1, 1, 1);

-- ----------------------------
-- Table structure for pay_vendor
-- ----------------------------
DROP TABLE IF EXISTS `pay_vendor`;
CREATE TABLE `pay_vendor`  (
  `pay_vendor_id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `appid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `appsecret` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `config` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`pay_vendor_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '第三方支付标识表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pay_vest
-- ----------------------------
DROP TABLE IF EXISTS `pay_vest`;
CREATE TABLE `pay_vest`  (
  `pay_vest_id` int(10) NOT NULL AUTO_INCREMENT,
  `pay_type_id` int(10) NULL DEFAULT NULL,
  `prefix` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `param` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`pay_vest_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '马甲支付参数配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ucenter_oauth
-- ----------------------------
DROP TABLE IF EXISTS `ucenter_oauth`;
CREATE TABLE `ucenter_oauth`  (
  `oauth_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '认证方式名称',
  PRIMARY KEY (`oauth_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '认证方式表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ucenter_oauth
-- ----------------------------
INSERT INTO `ucenter_oauth` VALUES (1, '手机');
INSERT INTO `ucenter_oauth` VALUES (2, '微信');
INSERT INTO `ucenter_oauth` VALUES (3, 'QQ');
INSERT INTO `ucenter_oauth` VALUES (4, '微博');

-- ----------------------------
-- Table structure for ucenter_user
-- ----------------------------
DROP TABLE IF EXISTS `ucenter_user`;
CREATE TABLE `ucenter_user`  (
  `user_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码(MD5(密码+盐))',
  `salt` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '盐',
  `nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `sex` tinyint(4) NULL DEFAULT 0 COMMENT '性别(0:未知,1:男,2:女)',
  `avatar` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  `create_ip` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '注册IP地址',
  `last_login_time` timestamp(0) NOT NULL COMMENT '最后登录时间',
  `last_login_ip` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '最后登录IP地址',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ucenter_user_details
-- ----------------------------
DROP TABLE IF EXISTS `ucenter_user_details`;
CREATE TABLE `ucenter_user_details`  (
  `user_id` int(10) UNSIGNED NOT NULL COMMENT '编号',
  `signature` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '个性签名',
  `real_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `birthday` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '出生日期',
  `question` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '帐号安全问题',
  `answer` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '帐号安全答案',
  PRIMARY KEY (`user_id`) USING BTREE,
  CONSTRAINT `FK_Reference_41` FOREIGN KEY (`user_id`) REFERENCES `ucenter_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户详情表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ucenter_user_log
-- ----------------------------
DROP TABLE IF EXISTS `ucenter_user_log`;
CREATE TABLE `ucenter_user_log`  (
  `user_log_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '用户编号',
  `content` varbinary(100) NULL DEFAULT NULL COMMENT '内容',
  `ip` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作IP地址',
  `agent` varbinary(200) NULL DEFAULT NULL COMMENT '操作环境',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '操作时间',
  PRIMARY KEY (`user_log_id`) USING BTREE,
  INDEX `FK_Reference_44`(`user_id`) USING BTREE,
  CONSTRAINT `FK_Reference_44` FOREIGN KEY (`user_id`) REFERENCES `ucenter_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户操作日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ucenter_user_oauth
-- ----------------------------
DROP TABLE IF EXISTS `ucenter_user_oauth`;
CREATE TABLE `ucenter_user_oauth`  (
  `user_oauth_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` int(10) UNSIGNED NOT NULL COMMENT '帐号编号',
  `oauth_id` int(10) UNSIGNED NOT NULL COMMENT '认证方式编号',
  `open_id` varbinary(50) NOT NULL COMMENT '第三方ID',
  `status` tinyint(4) UNSIGNED NULL DEFAULT NULL COMMENT '绑定状态(0:解绑,1:绑定)',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`user_oauth_id`) USING BTREE,
  INDEX `FK_Reference_42`(`user_id`) USING BTREE,
  INDEX `FK_Reference_43`(`oauth_id`) USING BTREE,
  CONSTRAINT `FK_Reference_42` FOREIGN KEY (`user_id`) REFERENCES `ucenter_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_43` FOREIGN KEY (`oauth_id`) REFERENCES `ucenter_oauth` (`oauth_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户认证方式表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for upms_log
-- ----------------------------
DROP TABLE IF EXISTS `upms_log`;
CREATE TABLE `upms_log`  (
  `log_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作描述',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作用户',
  `start_time` bigint(20) NULL DEFAULT NULL COMMENT '操作时间',
  `spend_time` int(11) NULL DEFAULT NULL COMMENT '消耗时间',
  `base_path` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '根路径',
  `uri` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'URI',
  `url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'URL',
  `method` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求类型',
  `parameter` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `user_agent` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户标识',
  `ip` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
  `result` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `permissions` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限值',
  PRIMARY KEY (`log_id`) USING BTREE,
  INDEX `log_id`(`log_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 955 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '操作日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of upms_log
-- ----------------------------
INSERT INTO `upms_log` VALUES (780, '登录', 'admin', 1519695594965, 248, 'http://upms.zhangshuzheng.cn:1111', '/sso/login', 'http://upms.zhangshuzheng.cn:1111/sso/login', 'POST', '{password=[123456],rememberMe=[false],backurl=[],username=[admin]}', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"code\":1,\"data\":\"http://upms.zhangshuzheng.cn:1111\",\"message\":\"success\"}', NULL);
INSERT INTO `upms_log` VALUES (781, '后台首页', 'admin', 1519695595479, 233, 'http://upms.zhangshuzheng.cn:1111', '/manage/index', 'http://upms.zhangshuzheng.cn:1111/manage/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/index.jsp\"', NULL);
INSERT INTO `upms_log` VALUES (782, '系统首页', 'admin', 1519695602736, 19, 'http://upms.zhangshuzheng.cn:1111', '/manage/system/index', 'http://upms.zhangshuzheng.cn:1111/manage/system/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/system/index.jsp\"', 'upms:system:read');
INSERT INTO `upms_log` VALUES (783, '系统列表', 'admin', 1519695604319, 51, 'http://upms.zhangshuzheng.cn:1111', '/manage/system/list', 'http://upms.zhangshuzheng.cn:1111/manage/system/list', 'GET', 'order=asc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"total\":5,\"rows\":[{\"banner\":\"/resources/zheng-admin/images/zheng-upms.png\",\"basepath\":\"http://upms.zhangshuzheng.cn:1111\",\"ctime\":1,\"description\":\"用户权限管理系统（RBAC细粒度用户权限、统一后台、单点登录、会话管理）\",\"icon\":\"zmdi zmdi-shield-security\",\"name\":\"zheng-upms-server\",\"orders\":1,\"status\":1,\"systemId\":1,\"theme\":\"#29A176\",\"title\":\"权限管理系统\"},{\"banner\":\"/resources/zheng-admin/images/zheng-cms.png\",\"basepath\":\"http://cms.zhangshuzheng.cn:2222\",\"ctime\":2,\"description\":\"内容管理系统（门户、博客、论坛、问答等）\",\"icon\":\"zmdi zmdi-wikipedia\",\"name\":\"zheng-cms-admin\",\"orders\":2,\"status\":1,\"systemId\":2,\"theme\":\"#455EC5\",\"title\":\"内容管理系统\"},{\"banner\":\"/resources/zheng-admin/images/zheng-pay.png\",\"basepath\":\"http://pay.zhangshuzheng.cn:3331\",\"ctime\":3,\"description\":\"支付管理系统\",\"icon\":\"zmdi zmdi-paypal-alt\",\"name\":\"zheng-pay-admin\",\"orders\":3,\"status\":1,\"systemId\":3,\"theme\":\"#F06292\",\"title\":\"支付管理系统\"},{\"banner\":\"/resources/zheng-admin/images/zheng-ucenter.png\",\"basepath\":\"http://ucenter.zhangshuzheng.cn:4441\",\"ctime\":4,\"description\":\"用户管理系统\",\"icon\":\"zmdi zmdi-account\",\"name\":\"zheng-ucenter-home\",\"orders\":4,\"status\":1,\"systemId\":4,\"theme\":\"#6539B4\",\"title\":\"用户管理系统\"},{\"banner\":\"/resources/zheng-admin/images/zheng-oss.png\",\"basepath\":\"http://oss.zhangshuzheng.cn:7771\",\"ctime\":5,\"description\":\"存储管理系统\",\"icon\":\"zmdi zmdi-cloud\",\"name\":\"zheng-oss-web\",\"orders\":5,\"status\":1,\"systemId\":5,\"theme\":\"#0B8DE5\",\"title\":\"存储管理系统\"}]}', 'upms:system:read');
INSERT INTO `upms_log` VALUES (784, '组织首页', 'admin', 1519695608051, 18, 'http://upms.zhangshuzheng.cn:1111', '/manage/organization/index', 'http://upms.zhangshuzheng.cn:1111/manage/organization/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/organization/index.jsp\"', 'upms:organization:read');
INSERT INTO `upms_log` VALUES (785, '组织列表', 'admin', 1519695608869, 61, 'http://upms.zhangshuzheng.cn:1111', '/manage/organization/list', 'http://upms.zhangshuzheng.cn:1111/manage/organization/list', 'GET', 'order=asc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"total\":5,\"rows\":[{\"ctime\":1,\"description\":\"北京总部\",\"name\":\"总部\",\"organizationId\":1},{\"ctime\":1488122466236,\"description\":\"河北石家庄\",\"name\":\"河北分部\",\"organizationId\":4},{\"ctime\":1488122480265,\"description\":\"河南郑州\",\"name\":\"河南分部\",\"organizationId\":5},{\"ctime\":1488122493265,\"description\":\"湖北武汉\",\"name\":\"湖北分部\",\"organizationId\":6},{\"ctime\":1488122502752,\"description\":\"湖南长沙\",\"name\":\"湖南分部\",\"organizationId\":7}]}', 'upms:organization:read');
INSERT INTO `upms_log` VALUES (786, '用户首页', 'admin', 1519695632791, 27, 'http://upms.zhangshuzheng.cn:1111', '/manage/user/index', 'http://upms.zhangshuzheng.cn:1111/manage/user/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/user/index.jsp\"', 'upms:user:read');
INSERT INTO `upms_log` VALUES (787, '用户列表', 'admin', 1519695633995, 25, 'http://upms.zhangshuzheng.cn:1111', '/manage/user/list', 'http://upms.zhangshuzheng.cn:1111/manage/user/list', 'GET', 'order=asc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"total\":2,\"rows\":[{\"avatar\":\"/resources/zheng-admin/images/avatar.jpg\",\"ctime\":1,\"email\":\"469741414@qq.com\",\"locked\":0,\"password\":\"3038D9CB63B3152A79B8153FB06C02F7\",\"phone\":\"\",\"realname\":\"张恕征\",\"salt\":\"66f1b370c660445a8657bf8bf1794486\",\"sex\":1,\"userId\":1,\"username\":\"admin\"},{\"avatar\":\"/resources/zheng-admin/images/avatar.jpg\",\"ctime\":1493394720495,\"email\":\"469741414@qq.com\",\"locked\":0,\"password\":\"285C9762F5F9046F5893F752DFAF3476\",\"phone\":\"\",\"realname\":\"张恕征\",\"salt\":\"d2d0d03310444ad388a8b290b0fe8564\",\"sex\":1,\"userId\":2,\"username\":\"test\"}]}', 'upms:user:read');
INSERT INTO `upms_log` VALUES (790, '登录', '', 1519698137400, 2, 'http://upms.zhangshuzheng.cn:1111', '/sso/login', 'http://upms.zhangshuzheng.cn:1111/sso/login', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/sso/login.jsp\"', NULL);
INSERT INTO `upms_log` VALUES (791, '登录', '', 1519698137885, 0, 'http://upms.zhangshuzheng.cn:1111', '/sso/login', 'http://upms.zhangshuzheng.cn:1111/sso/login', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/sso/login.jsp\"', NULL);
INSERT INTO `upms_log` VALUES (792, '登录', 'admin', 1519698139877, 47, 'http://upms.zhangshuzheng.cn:1111', '/sso/login', 'http://upms.zhangshuzheng.cn:1111/sso/login', 'POST', '{password=[123456],rememberMe=[false],backurl=[],username=[admin]}', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"code\":1,\"data\":\"http://upms.zhangshuzheng.cn:1111\",\"message\":\"success\"}', NULL);
INSERT INTO `upms_log` VALUES (793, '后台首页', 'admin', 1519698140040, 60, 'http://upms.zhangshuzheng.cn:1111', '/manage/index', 'http://upms.zhangshuzheng.cn:1111/manage/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/index.jsp\"', NULL);
INSERT INTO `upms_log` VALUES (794, '用户首页', 'admin', 1519698143946, 0, 'http://upms.zhangshuzheng.cn:1111', '/manage/user/index', 'http://upms.zhangshuzheng.cn:1111/manage/user/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/user/index.jsp\"', 'upms:user:read');
INSERT INTO `upms_log` VALUES (795, '用户列表', 'admin', 1519698145261, 29, 'http://upms.zhangshuzheng.cn:1111', '/manage/user/list', 'http://upms.zhangshuzheng.cn:1111/manage/user/list', 'GET', 'order=asc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"total\":2,\"rows\":[{\"avatar\":\"/resources/zheng-admin/images/avatar.jpg\",\"ctime\":1,\"email\":\"469741414@qq.com\",\"locked\":0,\"password\":\"3038D9CB63B3152A79B8153FB06C02F7\",\"phone\":\"\",\"realname\":\"张恕征\",\"salt\":\"66f1b370c660445a8657bf8bf1794486\",\"sex\":1,\"userId\":1,\"username\":\"admin\"},{\"avatar\":\"/resources/zheng-admin/images/avatar.jpg\",\"ctime\":1493394720495,\"email\":\"469741414@qq.com\",\"locked\":0,\"password\":\"285C9762F5F9046F5893F752DFAF3476\",\"phone\":\"\",\"realname\":\"张恕征\",\"salt\":\"d2d0d03310444ad388a8b290b0fe8564\",\"sex\":1,\"userId\":2,\"username\":\"test\"}]}', 'upms:user:read');
INSERT INTO `upms_log` VALUES (796, '角色首页', 'admin', 1519698147590, 14, 'http://upms.zhangshuzheng.cn:1111', '/manage/role/index', 'http://upms.zhangshuzheng.cn:1111/manage/role/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/role/index.jsp\"', 'upms:role:read');
INSERT INTO `upms_log` VALUES (797, '角色列表', 'admin', 1519698148506, 65, 'http://upms.zhangshuzheng.cn:1111', '/manage/role/list', 'http://upms.zhangshuzheng.cn:1111/manage/role/list', 'GET', 'order=asc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"total\":2,\"rows\":[{\"ctime\":1,\"description\":\"拥有所有权限\",\"name\":\"super\",\"orders\":1,\"roleId\":1,\"title\":\"超级管理员\"},{\"ctime\":1487471013117,\"description\":\"拥有除权限管理系统外的所有权限\",\"name\":\"admin\",\"orders\":1487471013117,\"roleId\":2,\"title\":\"管理员\"}]}', 'upms:role:read');
INSERT INTO `upms_log` VALUES (798, '角色列表', 'admin', 1519698463886, 15, 'http://upms.zhangshuzheng.cn:1111', '/manage/role/list', 'http://upms.zhangshuzheng.cn:1111/manage/role/list', 'GET', 'order=asc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"total\":2,\"rows\":[{\"ctime\":1,\"description\":\"拥有所有权限\",\"name\":\"super\",\"orders\":1,\"roleId\":1,\"title\":\"超级管理员\"},{\"ctime\":1487471013117,\"description\":\"拥有除权限管理系统外的所有权限\",\"name\":\"admin\",\"orders\":1487471013117,\"roleId\":2,\"title\":\"管理员\"}]}', 'upms:role:read');
INSERT INTO `upms_log` VALUES (799, '后台首页', 'admin', 1519699260719, 35, 'http://upms.zhangshuzheng.cn:1111', '/manage/index', 'http://upms.zhangshuzheng.cn:1111/manage/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/index.jsp\"', NULL);
INSERT INTO `upms_log` VALUES (800, '系统首页', 'admin', 1519699609051, 0, 'http://upms.zhangshuzheng.cn:1111', '/manage/system/index', 'http://upms.zhangshuzheng.cn:1111/manage/system/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/system/index.jsp\"', 'upms:system:read');
INSERT INTO `upms_log` VALUES (801, '系统列表', 'admin', 1519699609841, 21, 'http://upms.zhangshuzheng.cn:1111', '/manage/system/list', 'http://upms.zhangshuzheng.cn:1111/manage/system/list', 'GET', 'order=asc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"total\":5,\"rows\":[{\"banner\":\"/resources/zheng-admin/images/zheng-upms.png\",\"basepath\":\"http://upms.zhangshuzheng.cn:1111\",\"ctime\":1,\"description\":\"用户权限管理系统（RBAC细粒度用户权限、统一后台、单点登录、会话管理）\",\"icon\":\"zmdi zmdi-shield-security\",\"name\":\"zheng-upms-server\",\"orders\":1,\"status\":1,\"systemId\":1,\"theme\":\"#29A176\",\"title\":\"权限管理系统\"},{\"banner\":\"/resources/zheng-admin/images/zheng-cms.png\",\"basepath\":\"http://cms.zhangshuzheng.cn:2222\",\"ctime\":2,\"description\":\"内容管理系统（门户、博客、论坛、问答等）\",\"icon\":\"zmdi zmdi-wikipedia\",\"name\":\"zheng-cms-admin\",\"orders\":2,\"status\":1,\"systemId\":2,\"theme\":\"#455EC5\",\"title\":\"内容管理系统\"},{\"banner\":\"/resources/zheng-admin/images/zheng-pay.png\",\"basepath\":\"http://pay.zhangshuzheng.cn:3331\",\"ctime\":3,\"description\":\"支付管理系统\",\"icon\":\"zmdi zmdi-paypal-alt\",\"name\":\"zheng-pay-admin\",\"orders\":3,\"status\":1,\"systemId\":3,\"theme\":\"#F06292\",\"title\":\"支付管理系统\"},{\"banner\":\"/resources/zheng-admin/images/zheng-ucenter.png\",\"basepath\":\"http://ucenter.zhangshuzheng.cn:4441\",\"ctime\":4,\"description\":\"用户管理系统\",\"icon\":\"zmdi zmdi-account\",\"name\":\"zheng-ucenter-home\",\"orders\":4,\"status\":1,\"systemId\":4,\"theme\":\"#6539B4\",\"title\":\"用户管理系统\"},{\"banner\":\"/resources/zheng-admin/images/zheng-oss.png\",\"basepath\":\"http://oss.zhangshuzheng.cn:7771\",\"ctime\":5,\"description\":\"存储管理系统\",\"icon\":\"zmdi zmdi-cloud\",\"name\":\"zheng-oss-web\",\"orders\":5,\"status\":1,\"systemId\":5,\"theme\":\"#0B8DE5\",\"title\":\"存储管理系统\"}]}', 'upms:system:read');
INSERT INTO `upms_log` VALUES (802, '组织首页', 'admin', 1519699618621, 0, 'http://upms.zhangshuzheng.cn:1111', '/manage/organization/index', 'http://upms.zhangshuzheng.cn:1111/manage/organization/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/organization/index.jsp\"', 'upms:organization:read');
INSERT INTO `upms_log` VALUES (803, '组织列表', 'admin', 1519699619226, 18, 'http://upms.zhangshuzheng.cn:1111', '/manage/organization/list', 'http://upms.zhangshuzheng.cn:1111/manage/organization/list', 'GET', 'order=asc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"total\":5,\"rows\":[{\"ctime\":1,\"description\":\"北京总部\",\"name\":\"总部\",\"organizationId\":1},{\"ctime\":1488122466236,\"description\":\"河北石家庄\",\"name\":\"河北分部\",\"organizationId\":4},{\"ctime\":1488122480265,\"description\":\"河南郑州\",\"name\":\"河南分部\",\"organizationId\":5},{\"ctime\":1488122493265,\"description\":\"湖北武汉\",\"name\":\"湖北分部\",\"organizationId\":6},{\"ctime\":1488122502752,\"description\":\"湖南长沙\",\"name\":\"湖南分部\",\"organizationId\":7}]}', 'upms:organization:read');
INSERT INTO `upms_log` VALUES (804, '用户首页', 'admin', 1519699720521, 0, 'http://upms.zhangshuzheng.cn:1111', '/manage/user/index', 'http://upms.zhangshuzheng.cn:1111/manage/user/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/user/index.jsp\"', 'upms:user:read');
INSERT INTO `upms_log` VALUES (805, '用户列表', 'admin', 1519699721238, 9, 'http://upms.zhangshuzheng.cn:1111', '/manage/user/list', 'http://upms.zhangshuzheng.cn:1111/manage/user/list', 'GET', 'order=asc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"total\":2,\"rows\":[{\"avatar\":\"/resources/zheng-admin/images/avatar.jpg\",\"ctime\":1,\"email\":\"469741414@qq.com\",\"locked\":0,\"password\":\"3038D9CB63B3152A79B8153FB06C02F7\",\"phone\":\"\",\"realname\":\"张恕征\",\"salt\":\"66f1b370c660445a8657bf8bf1794486\",\"sex\":1,\"userId\":1,\"username\":\"admin\"},{\"avatar\":\"/resources/zheng-admin/images/avatar.jpg\",\"ctime\":1493394720495,\"email\":\"469741414@qq.com\",\"locked\":0,\"password\":\"285C9762F5F9046F5893F752DFAF3476\",\"phone\":\"\",\"realname\":\"张恕征\",\"salt\":\"d2d0d03310444ad388a8b290b0fe8564\",\"sex\":1,\"userId\":2,\"username\":\"test\"}]}', 'upms:user:read');
INSERT INTO `upms_log` VALUES (806, '登录', '', 1519699739254, 1, 'http://upms.zhangshuzheng.cn:1111', '/sso/login', 'http://upms.zhangshuzheng.cn:1111/sso/login', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/sso/login.jsp\"', NULL);
INSERT INTO `upms_log` VALUES (807, '登录', '', 1519699739516, 1, 'http://upms.zhangshuzheng.cn:1111', '/sso/login', 'http://upms.zhangshuzheng.cn:1111/sso/login', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/sso/login.jsp\"', NULL);
INSERT INTO `upms_log` VALUES (808, '登录', 'admin', 1519699741710, 24, 'http://upms.zhangshuzheng.cn:1111', '/sso/login', 'http://upms.zhangshuzheng.cn:1111/sso/login', 'POST', '{password=[123456],rememberMe=[false],backurl=[],username=[admin]}', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"code\":1,\"data\":\"http://upms.zhangshuzheng.cn:1111\",\"message\":\"success\"}', NULL);
INSERT INTO `upms_log` VALUES (809, '后台首页', 'admin', 1519699741820, 25, 'http://upms.zhangshuzheng.cn:1111', '/manage/index', 'http://upms.zhangshuzheng.cn:1111/manage/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/index.jsp\"', NULL);
INSERT INTO `upms_log` VALUES (810, '登录', '', 1519699808339, 0, 'http://upms.zhangshuzheng.cn:1111', '/sso/login', 'http://upms.zhangshuzheng.cn:1111/sso/login', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/sso/login.jsp\"', NULL);
INSERT INTO `upms_log` VALUES (811, '登录', 'admin', 1519699809674, 21, 'http://upms.zhangshuzheng.cn:1111', '/sso/login', 'http://upms.zhangshuzheng.cn:1111/sso/login', 'POST', '{password=[123456],rememberMe=[false],backurl=[],username=[admin]}', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"code\":1,\"data\":\"http://upms.zhangshuzheng.cn:1111\",\"message\":\"success\"}', NULL);
INSERT INTO `upms_log` VALUES (812, '后台首页', 'admin', 1519699809817, 35, 'http://upms.zhangshuzheng.cn:1111', '/manage/index', 'http://upms.zhangshuzheng.cn:1111/manage/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/index.jsp\"', NULL);
INSERT INTO `upms_log` VALUES (813, '登录', '', 1519704075533, 1, 'http://upms.zhangshuzheng.cn:1111', '/sso/login', 'http://upms.zhangshuzheng.cn:1111/sso/login', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/sso/login.jsp\"', NULL);
INSERT INTO `upms_log` VALUES (814, '登录', 'admin', 1519704077161, 33, 'http://upms.zhangshuzheng.cn:1111', '/sso/login', 'http://upms.zhangshuzheng.cn:1111/sso/login', 'POST', '{password=[123456],rememberMe=[false],backurl=[],username=[admin]}', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"code\":1,\"data\":\"http://upms.zhangshuzheng.cn:1111\",\"message\":\"success\"}', NULL);
INSERT INTO `upms_log` VALUES (815, '后台首页', 'admin', 1519704077322, 42, 'http://upms.zhangshuzheng.cn:1111', '/manage/index', 'http://upms.zhangshuzheng.cn:1111/manage/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/index.jsp\"', NULL);
INSERT INTO `upms_log` VALUES (816, '系统首页', 'admin', 1519704141554, 0, 'http://upms.zhangshuzheng.cn:1111', '/manage/system/index', 'http://upms.zhangshuzheng.cn:1111/manage/system/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/system/index.jsp\"', 'upms:system:read');
INSERT INTO `upms_log` VALUES (817, '系统列表', 'admin', 1519704142128, 14, 'http://upms.zhangshuzheng.cn:1111', '/manage/system/list', 'http://upms.zhangshuzheng.cn:1111/manage/system/list', 'GET', 'order=asc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"total\":5,\"rows\":[{\"banner\":\"/resources/zheng-admin/images/zheng-upms.png\",\"basepath\":\"http://upms.zhangshuzheng.cn:1111\",\"ctime\":1,\"description\":\"用户权限管理系统（RBAC细粒度用户权限、统一后台、单点登录、会话管理）\",\"icon\":\"zmdi zmdi-shield-security\",\"name\":\"zheng-upms-server\",\"orders\":1,\"status\":1,\"systemId\":1,\"theme\":\"#29A176\",\"title\":\"权限管理系统\"},{\"banner\":\"/resources/zheng-admin/images/zheng-cms.png\",\"basepath\":\"http://cms.zhangshuzheng.cn:2222\",\"ctime\":2,\"description\":\"内容管理系统（门户、博客、论坛、问答等）\",\"icon\":\"zmdi zmdi-wikipedia\",\"name\":\"zheng-cms-admin\",\"orders\":2,\"status\":1,\"systemId\":2,\"theme\":\"#455EC5\",\"title\":\"内容管理系统\"},{\"banner\":\"/resources/zheng-admin/images/zheng-pay.png\",\"basepath\":\"http://pay.zhangshuzheng.cn:3331\",\"ctime\":3,\"description\":\"支付管理系统\",\"icon\":\"zmdi zmdi-paypal-alt\",\"name\":\"zheng-pay-admin\",\"orders\":3,\"status\":1,\"systemId\":3,\"theme\":\"#F06292\",\"title\":\"支付管理系统\"},{\"banner\":\"/resources/zheng-admin/images/zheng-ucenter.png\",\"basepath\":\"http://ucenter.zhangshuzheng.cn:4441\",\"ctime\":4,\"description\":\"用户管理系统\",\"icon\":\"zmdi zmdi-account\",\"name\":\"zheng-ucenter-home\",\"orders\":4,\"status\":1,\"systemId\":4,\"theme\":\"#6539B4\",\"title\":\"用户管理系统\"},{\"banner\":\"/resources/zheng-admin/images/zheng-oss.png\",\"basepath\":\"http://oss.zhangshuzheng.cn:7771\",\"ctime\":5,\"description\":\"存储管理系统\",\"icon\":\"zmdi zmdi-cloud\",\"name\":\"zheng-oss-web\",\"orders\":5,\"status\":1,\"systemId\":5,\"theme\":\"#0B8DE5\",\"title\":\"存储管理系统\"}]}', 'upms:system:read');
INSERT INTO `upms_log` VALUES (818, '后台首页', 'admin', 1519704187594, 25, 'http://upms.zhangshuzheng.cn:1111', '/manage/index', 'http://upms.zhangshuzheng.cn:1111/manage/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/index.jsp\"', NULL);
INSERT INTO `upms_log` VALUES (819, '系统首页', 'admin', 1519704190371, 0, 'http://upms.zhangshuzheng.cn:1111', '/manage/system/index', 'http://upms.zhangshuzheng.cn:1111/manage/system/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/system/index.jsp\"', 'upms:system:read');
INSERT INTO `upms_log` VALUES (820, '系统列表', 'admin', 1519704191062, 30, 'http://upms.zhangshuzheng.cn:1111', '/manage/system/list', 'http://upms.zhangshuzheng.cn:1111/manage/system/list', 'GET', 'order=asc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"total\":5,\"rows\":[{\"banner\":\"/resources/zheng-admin/images/zheng-upms.png\",\"basepath\":\"http://upms.zhangshuzheng.cn:1111\",\"ctime\":1,\"description\":\"用户权限管理系统（RBAC细粒度用户权限、统一后台、单点登录、会话管理）\",\"icon\":\"zmdi zmdi-shield-security\",\"name\":\"zheng-upms-server\",\"orders\":1,\"status\":1,\"systemId\":1,\"theme\":\"#29A176\",\"title\":\"权限管理系统\"},{\"banner\":\"/resources/zheng-admin/images/zheng-cms.png\",\"basepath\":\"http://cms.zhangshuzheng.cn:2222\",\"ctime\":2,\"description\":\"内容管理系统（门户、博客、论坛、问答等）\",\"icon\":\"zmdi zmdi-wikipedia\",\"name\":\"zheng-cms-admin\",\"orders\":2,\"status\":1,\"systemId\":2,\"theme\":\"#455EC5\",\"title\":\"内容管理系统\"},{\"banner\":\"/resources/zheng-admin/images/zheng-pay.png\",\"basepath\":\"http://pay.zhangshuzheng.cn:3331\",\"ctime\":3,\"description\":\"支付管理系统\",\"icon\":\"zmdi zmdi-paypal-alt\",\"name\":\"zheng-pay-admin\",\"orders\":3,\"status\":1,\"systemId\":3,\"theme\":\"#F06292\",\"title\":\"支付管理系统\"},{\"banner\":\"/resources/zheng-admin/images/zheng-ucenter.png\",\"basepath\":\"http://ucenter.zhangshuzheng.cn:4441\",\"ctime\":4,\"description\":\"用户管理系统\",\"icon\":\"zmdi zmdi-account\",\"name\":\"zheng-ucenter-home\",\"orders\":4,\"status\":1,\"systemId\":4,\"theme\":\"#6539B4\",\"title\":\"用户管理系统\"},{\"banner\":\"/resources/zheng-admin/images/zheng-oss.png\",\"basepath\":\"http://oss.zhangshuzheng.cn:7771\",\"ctime\":5,\"description\":\"存储管理系统\",\"icon\":\"zmdi zmdi-cloud\",\"name\":\"zheng-oss-web\",\"orders\":5,\"status\":1,\"systemId\":5,\"theme\":\"#0B8DE5\",\"title\":\"存储管理系统\"}]}', 'upms:system:read');
INSERT INTO `upms_log` VALUES (821, '组织首页', 'admin', 1519704191992, 0, 'http://upms.zhangshuzheng.cn:1111', '/manage/organization/index', 'http://upms.zhangshuzheng.cn:1111/manage/organization/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/organization/index.jsp\"', 'upms:organization:read');
INSERT INTO `upms_log` VALUES (822, '组织列表', 'admin', 1519704192337, 11, 'http://upms.zhangshuzheng.cn:1111', '/manage/organization/list', 'http://upms.zhangshuzheng.cn:1111/manage/organization/list', 'GET', 'order=asc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"total\":5,\"rows\":[{\"ctime\":1,\"description\":\"北京总部\",\"name\":\"总部\",\"organizationId\":1},{\"ctime\":1488122466236,\"description\":\"河北石家庄\",\"name\":\"河北分部\",\"organizationId\":4},{\"ctime\":1488122480265,\"description\":\"河南郑州\",\"name\":\"河南分部\",\"organizationId\":5},{\"ctime\":1488122493265,\"description\":\"湖北武汉\",\"name\":\"湖北分部\",\"organizationId\":6},{\"ctime\":1488122502752,\"description\":\"湖南长沙\",\"name\":\"湖南分部\",\"organizationId\":7}]}', 'upms:organization:read');
INSERT INTO `upms_log` VALUES (823, '后台首页', 'admin', 1519704322778, 33, 'http://upms.zhangshuzheng.cn:1111', '/manage/index', 'http://upms.zhangshuzheng.cn:1111/manage/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/index.jsp\"', NULL);
INSERT INTO `upms_log` VALUES (824, '后台首页', 'admin', 1519704694509, 33, 'http://upms.zhangshuzheng.cn:1111', '/manage/index', 'http://upms.zhangshuzheng.cn:1111/manage/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/index.jsp\"', NULL);
INSERT INTO `upms_log` VALUES (825, '登录', '', 1519704786992, 0, 'http://upms.zhangshuzheng.cn:1111', '/sso/login', 'http://upms.zhangshuzheng.cn:1111/sso/login', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/sso/login.jsp\"', NULL);
INSERT INTO `upms_log` VALUES (826, '登录', 'admin', 1519704789751, 25, 'http://upms.zhangshuzheng.cn:1111', '/sso/login', 'http://upms.zhangshuzheng.cn:1111/sso/login', 'POST', '{password=[123456],rememberMe=[false],backurl=[],username=[admin]}', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"code\":1,\"data\":\"http://upms.zhangshuzheng.cn:1111\",\"message\":\"success\"}', NULL);
INSERT INTO `upms_log` VALUES (827, '后台首页', 'admin', 1519704791556, 30, 'http://upms.zhangshuzheng.cn:1111', '/manage/index', 'http://upms.zhangshuzheng.cn:1111/manage/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/index.jsp\"', NULL);
INSERT INTO `upms_log` VALUES (828, '登录', '', 1519707721978, 25, 'http://upms.zhangshuzheng.cn:1111', '/sso/login', 'http://upms.zhangshuzheng.cn:1111/sso/login', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/sso/login.jsp\"', NULL);
INSERT INTO `upms_log` VALUES (829, '登录', 'admin', 1519707725469, 236, 'http://upms.zhangshuzheng.cn:1111', '/sso/login', 'http://upms.zhangshuzheng.cn:1111/sso/login', 'POST', '{password=[123456],rememberMe=[false],backurl=[],username=[admin]}', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"code\":1,\"data\":\"http://upms.zhangshuzheng.cn:1111\",\"message\":\"success\"}', NULL);
INSERT INTO `upms_log` VALUES (830, '后台首页', 'admin', 1519707726108, 127, 'http://upms.zhangshuzheng.cn:1111', '/manage/index', 'http://upms.zhangshuzheng.cn:1111/manage/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/index.jsp\"', NULL);
INSERT INTO `upms_log` VALUES (831, '登录', '', 1519717345759, 33, 'http://upms.zhangshuzheng.cn:1111', '/sso/login', 'http://upms.zhangshuzheng.cn:1111/sso/login', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/sso/login.jsp\"', NULL);
INSERT INTO `upms_log` VALUES (832, '登录', 'admin', 1519717448083, 229, 'http://upms.zhangshuzheng.cn:1111', '/sso/login', 'http://upms.zhangshuzheng.cn:1111/sso/login', 'POST', '{password=[123456],rememberMe=[false],backurl=[],username=[admin]}', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"code\":1,\"data\":\"http://upms.zhangshuzheng.cn:1111\",\"message\":\"success\"}', NULL);
INSERT INTO `upms_log` VALUES (833, '后台首页', 'admin', 1519717448809, 157, 'http://upms.zhangshuzheng.cn:1111', '/manage/index', 'http://upms.zhangshuzheng.cn:1111/manage/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/index.jsp\"', NULL);
INSERT INTO `upms_log` VALUES (834, '后台首页', 'admin', 1519718212507, 77, 'http://upms.zhangshuzheng.cn:1111', '/manage/index', 'http://upms.zhangshuzheng.cn:1111/manage/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/index.jsp\"', NULL);
INSERT INTO `upms_log` VALUES (835, '认证中心首页', 'admin', 1519718215462, 13, 'http://upms.zhangshuzheng.cn:1111', '/sso/index', 'http://upms.zhangshuzheng.cn:1111/sso/index', 'GET', 'appid=zheng-cms-admin&backurl=http%3A%2F%2Fcms.zhangshuzheng.cn%3A2222%2Fmanage%2Ftag%2Findex', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"redirect:/sso/login?backurl=http%3A%2F%2Fcms.zhangshuzheng.cn%3A2222%2Fmanage%2Ftag%2Findex\"', NULL);
INSERT INTO `upms_log` VALUES (836, '登录', 'admin', 1519718215652, 1, 'http://upms.zhangshuzheng.cn:1111', '/sso/login', 'http://upms.zhangshuzheng.cn:1111/sso/login', 'GET', 'backurl=http%3A%2F%2Fcms.zhangshuzheng.cn%3A2222%2Fmanage%2Ftag%2Findex', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"redirect:http://cms.zhangshuzheng.cn:2222/manage/tag/index?upms_code=89a2ab69-3747-4c90-96c5-65d59d589e06&upms_username=admin\"', NULL);
INSERT INTO `upms_log` VALUES (837, '校验code', '', 1519718216057, 1, 'http://upms.zhangshuzheng.cn:1111', '/sso/code', 'http://upms.zhangshuzheng.cn:1111/sso/code', 'POST', '{code=[89a2ab69-3747-4c90-96c5-65d59d589e06]}', 'Apache-HttpClient/4.5.2 (Java/1.8.0_161)', '127.0.0.1', '{\"code\":1,\"data\":\"89a2ab69-3747-4c90-96c5-65d59d589e06\",\"message\":\"success\"}', NULL);
INSERT INTO `upms_log` VALUES (838, '评论首页', 'admin', 1519718216316, 18, 'http://cms.zhangshuzheng.cn:2222', '/manage/tag/index', 'http://cms.zhangshuzheng.cn:2222/manage/tag/index', 'GET', 'upms_code=89a2ab69-3747-4c90-96c5-65d59d589e06&upms_username=admin', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/tag/index.jsp\"', 'cms:tag:read');
INSERT INTO `upms_log` VALUES (839, '评论首页', 'admin', 1519718218396, 0, 'http://cms.zhangshuzheng.cn:2222', '/manage/tag/index', 'http://cms.zhangshuzheng.cn:2222/manage/tag/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/tag/index.jsp\"', 'cms:tag:read');
INSERT INTO `upms_log` VALUES (840, '评论列表', 'admin', 1519718219538, 458, 'http://cms.zhangshuzheng.cn:2222', '/manage/tag/list', 'http://cms.zhangshuzheng.cn:2222/manage/tag/list', 'GET', 'order=asc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"rows\":[{\"alias\":\"java\",\"ctime\":1489585694864,\"description\":\"java标签\",\"icon\":\"\",\"name\":\"JAVA\",\"orders\":1489585694864,\"systemId\":1,\"tagId\":1,\"type\":1},{\"alias\":\"android\",\"ctime\":1489585720382,\"description\":\"android标签\",\"icon\":\"\",\"name\":\"Android\",\"orders\":1489585720382,\"systemId\":1,\"tagId\":2,\"type\":1},{\"alias\":\"zheng\",\"ctime\":1489585815042,\"description\":\"zheng标签\",\"icon\":\"\",\"name\":\"zheng\",\"orders\":1489585815042,\"systemId\":1,\"tagId\":3,\"type\":2},{\"alias\":\"love\",\"ctime\":1489585815043,\"description\":\"谈恋爱标签\",\"icon\":\"\",\"name\":\"谈恋爱\",\"orders\":1489585815043,\"systemId\":2,\"tagId\":4,\"type\":1},{\"alias\":\"java\",\"ctime\":1489585815044,\"description\":\"java标签\",\"icon\":\"\",\"name\":\"java\",\"orders\":1489585815044,\"systemId\":3,\"tagId\":5,\"type\":1}],\"total\":5}', 'cms:tag:read');
INSERT INTO `upms_log` VALUES (841, '类目首页', 'admin', 1519718257768, 33, 'http://cms.zhangshuzheng.cn:2222', '/manage/category/index', 'http://cms.zhangshuzheng.cn:2222/manage/category/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/category/index.jsp\"', 'cms:category:read');
INSERT INTO `upms_log` VALUES (842, '类目列表', 'admin', 1519718258934, 89, 'http://cms.zhangshuzheng.cn:2222', '/manage/category/list', 'http://cms.zhangshuzheng.cn:2222/manage/category/list', 'GET', 'order=asc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"rows\":[{\"alias\":\"economic\",\"categoryId\":5,\"ctime\":1489590733919,\"description\":\"经济类目\",\"icon\":\"\",\"level\":1,\"name\":\"经济\",\"orders\":1489590733919,\"systemId\":1,\"type\":1},{\"alias\":\"chinaeconomic\",\"categoryId\":6,\"ctime\":1489590768989,\"description\":\"中国经济类目\",\"icon\":\"\",\"level\":2,\"name\":\"中国经济\",\"orders\":1489590768989,\"pid\":5,\"systemId\":1,\"type\":1},{\"alias\":\"japaneconomic\",\"categoryId\":7,\"ctime\":1491636586316,\"description\":\"日本经济类目\",\"icon\":\"\",\"level\":2,\"name\":\"日本经济\",\"orders\":1491636586316,\"pid\":5,\"systemId\":1,\"type\":1},{\"alias\":\"people\",\"categoryId\":8,\"ctime\":1491636586317,\"description\":\"人类问题\",\"icon\":\"\",\"level\":1,\"name\":\"人类\",\"orders\":1491636586317,\"systemId\":2,\"type\":1},{\"alias\":\"technic\",\"categoryId\":9,\"ctime\":1491636586318,\"description\":\"技术博文\",\"level\":1,\"name\":\"技术\",\"orders\":1491636586318,\"systemId\":3,\"type\":1}],\"total\":5}', 'cms:category:read');
INSERT INTO `upms_log` VALUES (843, '类目首页', 'admin', 1519718708692, 0, 'http://cms.zhangshuzheng.cn:2222', '/manage/category/index', 'http://cms.zhangshuzheng.cn:2222/manage/category/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/category/index.jsp\"', 'cms:category:read');
INSERT INTO `upms_log` VALUES (844, '类目列表', 'admin', 1519718713381, 31, 'http://cms.zhangshuzheng.cn:2222', '/manage/category/list', 'http://cms.zhangshuzheng.cn:2222/manage/category/list', 'GET', 'order=asc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"rows\":[{\"alias\":\"economic\",\"categoryId\":5,\"ctime\":1489590733919,\"description\":\"经济类目\",\"icon\":\"\",\"level\":1,\"name\":\"经济\",\"orders\":1489590733919,\"systemId\":1,\"type\":1},{\"alias\":\"chinaeconomic\",\"categoryId\":6,\"ctime\":1489590768989,\"description\":\"中国经济类目\",\"icon\":\"\",\"level\":2,\"name\":\"中国经济\",\"orders\":1489590768989,\"pid\":5,\"systemId\":1,\"type\":1},{\"alias\":\"japaneconomic\",\"categoryId\":7,\"ctime\":1491636586316,\"description\":\"日本经济类目\",\"icon\":\"\",\"level\":2,\"name\":\"日本经济\",\"orders\":1491636586316,\"pid\":5,\"systemId\":1,\"type\":1},{\"alias\":\"people\",\"categoryId\":8,\"ctime\":1491636586317,\"description\":\"人类问题\",\"icon\":\"\",\"level\":1,\"name\":\"人类\",\"orders\":1491636586317,\"systemId\":2,\"type\":1},{\"alias\":\"technic\",\"categoryId\":9,\"ctime\":1491636586318,\"description\":\"技术博文\",\"level\":1,\"name\":\"技术\",\"orders\":1491636586318,\"systemId\":3,\"type\":1}],\"total\":5}', 'cms:category:read');
INSERT INTO `upms_log` VALUES (845, '文章首页', 'admin', 1519719150843, 19, 'http://cms.zhangshuzheng.cn:2222', '/manage/article/index', 'http://cms.zhangshuzheng.cn:2222/manage/article/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/article/index.jsp\"', 'cms:article:read');
INSERT INTO `upms_log` VALUES (846, '文章列表', 'admin', 1519719163618, 151, 'http://cms.zhangshuzheng.cn:2222', '/manage/article/list', 'http://cms.zhangshuzheng.cn:2222/manage/article/list', 'GET', 'sort=orders&order=desc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"rows\":[{\"allowcomments\":1,\"articleId\":20,\"author\":\"test\",\"ctime\":1490460800636,\"description\":\"test\",\"fromurl\":\"test\",\"image\":\"test\",\"keywords\":\"test\",\"orders\":1490460800636,\"readnumber\":0,\"status\":1,\"systemId\":3,\"title\":\"java开发笔记\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":19,\"author\":\"test\",\"ctime\":1490460800635,\"description\":\"test\",\"fromurl\":\"test\",\"image\":\"test\",\"keywords\":\"test\",\"orders\":1490460800635,\"readnumber\":0,\"status\":1,\"systemId\":2,\"title\":\"人为什么谈恋爱？\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":18,\"author\":\"13\",\"ctime\":1490460800634,\"description\":\"13\",\"fromurl\":\"13\",\"image\":\"13\",\"keywords\":\"13\",\"orders\":1490460800634,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题13\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":17,\"author\":\"12\",\"ctime\":1490460792501,\"description\":\"12\",\"fromurl\":\"12\",\"image\":\"12\",\"keywords\":\"12\",\"orders\":1490460792501,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题12\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":16,\"author\":\"11\",\"ctime\":1490460782767,\"description\":\"11\",\"fromurl\":\"11\",\"image\":\"11\",\"keywords\":\"11\",\"orders\":1490460782767,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题11\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":15,\"author\":\"10\",\"ctime\":1490460612370,\"description\":\"10\",\"fromurl\":\"10\",\"image\":\"10\",\"keywords\":\"10\",\"orders\":1490460612370,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题10\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":14,\"author\":\"9\",\"ctime\":1490460596394,\"description\":\"9\",\"fromurl\":\"9\",\"image\":\"9\",\"keywords\":\"9\",\"orders\":1490460596394,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题9\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":13,\"author\":\"8\",\"ctime\":1490460588840,\"description\":\"8\",\"fromurl\":\"8\",\"image\":\"8\",\"keywords\":\"8\",\"orders\":1490460588840,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题8\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":12,\"author\":\"7\",\"ctime\":1490460582004,\"description\":\"7\",\"fromurl\":\"7\",\"image\":\"7\",\"keywords\":\"7\",\"orders\":1490460582004,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题7\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":11,\"author\":\"6\",\"ctime\":1490460575304,\"description\":\"6\",\"fromurl\":\"6\",\"image\":\"6\",\"keywords\":\"6\",\"orders\":1490460575304,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题6\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1}],\"total\":16}', 'cms:article:read');
INSERT INTO `upms_log` VALUES (847, '后台首页', 'admin', 1519719231908, 69, 'http://upms.zhangshuzheng.cn:1111', '/manage/index', 'http://upms.zhangshuzheng.cn:1111/manage/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/index.jsp\"', NULL);
INSERT INTO `upms_log` VALUES (848, '评论首页', 'admin', 1519719247524, 0, 'http://cms.zhangshuzheng.cn:2222', '/manage/tag/index', 'http://cms.zhangshuzheng.cn:2222/manage/tag/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/tag/index.jsp\"', 'cms:tag:read');
INSERT INTO `upms_log` VALUES (849, '评论列表', 'admin', 1519719252962, 21, 'http://cms.zhangshuzheng.cn:2222', '/manage/tag/list', 'http://cms.zhangshuzheng.cn:2222/manage/tag/list', 'GET', 'order=asc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"rows\":[{\"alias\":\"java\",\"ctime\":1489585694864,\"description\":\"java标签\",\"icon\":\"\",\"name\":\"JAVA\",\"orders\":1489585694864,\"systemId\":1,\"tagId\":1,\"type\":1},{\"alias\":\"android\",\"ctime\":1489585720382,\"description\":\"android标签\",\"icon\":\"\",\"name\":\"Android\",\"orders\":1489585720382,\"systemId\":1,\"tagId\":2,\"type\":1},{\"alias\":\"zheng\",\"ctime\":1489585815042,\"description\":\"zheng标签\",\"icon\":\"\",\"name\":\"zheng\",\"orders\":1489585815042,\"systemId\":1,\"tagId\":3,\"type\":2},{\"alias\":\"love\",\"ctime\":1489585815043,\"description\":\"谈恋爱标签\",\"icon\":\"\",\"name\":\"谈恋爱\",\"orders\":1489585815043,\"systemId\":2,\"tagId\":4,\"type\":1},{\"alias\":\"java\",\"ctime\":1489585815044,\"description\":\"java标签\",\"icon\":\"\",\"name\":\"java\",\"orders\":1489585815044,\"systemId\":3,\"tagId\":5,\"type\":1}],\"total\":5}', 'cms:tag:read');
INSERT INTO `upms_log` VALUES (850, '类目首页', 'admin', 1519719262852, 0, 'http://cms.zhangshuzheng.cn:2222', '/manage/category/index', 'http://cms.zhangshuzheng.cn:2222/manage/category/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/category/index.jsp\"', 'cms:category:read');
INSERT INTO `upms_log` VALUES (851, '类目列表', 'admin', 1519719263343, 23, 'http://cms.zhangshuzheng.cn:2222', '/manage/category/list', 'http://cms.zhangshuzheng.cn:2222/manage/category/list', 'GET', 'order=asc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"rows\":[{\"alias\":\"economic\",\"categoryId\":5,\"ctime\":1489590733919,\"description\":\"经济类目\",\"icon\":\"\",\"level\":1,\"name\":\"经济\",\"orders\":1489590733919,\"systemId\":1,\"type\":1},{\"alias\":\"chinaeconomic\",\"categoryId\":6,\"ctime\":1489590768989,\"description\":\"中国经济类目\",\"icon\":\"\",\"level\":2,\"name\":\"中国经济\",\"orders\":1489590768989,\"pid\":5,\"systemId\":1,\"type\":1},{\"alias\":\"japaneconomic\",\"categoryId\":7,\"ctime\":1491636586316,\"description\":\"日本经济类目\",\"icon\":\"\",\"level\":2,\"name\":\"日本经济\",\"orders\":1491636586316,\"pid\":5,\"systemId\":1,\"type\":1},{\"alias\":\"people\",\"categoryId\":8,\"ctime\":1491636586317,\"description\":\"人类问题\",\"icon\":\"\",\"level\":1,\"name\":\"人类\",\"orders\":1491636586317,\"systemId\":2,\"type\":1},{\"alias\":\"technic\",\"categoryId\":9,\"ctime\":1491636586318,\"description\":\"技术博文\",\"level\":1,\"name\":\"技术\",\"orders\":1491636586318,\"systemId\":3,\"type\":1}],\"total\":5}', 'cms:category:read');
INSERT INTO `upms_log` VALUES (852, '后台首页', 'admin', 1519720553416, 49, 'http://upms.zhangshuzheng.cn:1111', '/manage/index', 'http://upms.zhangshuzheng.cn:1111/manage/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/index.jsp\"', NULL);
INSERT INTO `upms_log` VALUES (853, '文章首页', 'admin', 1519720688582, 1, 'http://cms.zhangshuzheng.cn:2222', '/manage/article/index', 'http://cms.zhangshuzheng.cn:2222/manage/article/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/article/index.jsp\"', 'cms:article:read');
INSERT INTO `upms_log` VALUES (854, '文章列表', 'admin', 1519720689227, 69, 'http://cms.zhangshuzheng.cn:2222', '/manage/article/list', 'http://cms.zhangshuzheng.cn:2222/manage/article/list', 'GET', 'sort=orders&order=desc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"rows\":[{\"allowcomments\":1,\"articleId\":20,\"author\":\"test\",\"ctime\":1490460800636,\"description\":\"test\",\"fromurl\":\"test\",\"image\":\"test\",\"keywords\":\"test\",\"orders\":1490460800636,\"readnumber\":0,\"status\":1,\"systemId\":3,\"title\":\"java开发笔记\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":19,\"author\":\"test\",\"ctime\":1490460800635,\"description\":\"test\",\"fromurl\":\"test\",\"image\":\"test\",\"keywords\":\"test\",\"orders\":1490460800635,\"readnumber\":0,\"status\":1,\"systemId\":2,\"title\":\"人为什么谈恋爱？\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":18,\"author\":\"13\",\"ctime\":1490460800634,\"description\":\"13\",\"fromurl\":\"13\",\"image\":\"13\",\"keywords\":\"13\",\"orders\":1490460800634,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题13\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":17,\"author\":\"12\",\"ctime\":1490460792501,\"description\":\"12\",\"fromurl\":\"12\",\"image\":\"12\",\"keywords\":\"12\",\"orders\":1490460792501,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题12\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":16,\"author\":\"11\",\"ctime\":1490460782767,\"description\":\"11\",\"fromurl\":\"11\",\"image\":\"11\",\"keywords\":\"11\",\"orders\":1490460782767,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题11\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":15,\"author\":\"10\",\"ctime\":1490460612370,\"description\":\"10\",\"fromurl\":\"10\",\"image\":\"10\",\"keywords\":\"10\",\"orders\":1490460612370,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题10\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":14,\"author\":\"9\",\"ctime\":1490460596394,\"description\":\"9\",\"fromurl\":\"9\",\"image\":\"9\",\"keywords\":\"9\",\"orders\":1490460596394,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题9\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":13,\"author\":\"8\",\"ctime\":1490460588840,\"description\":\"8\",\"fromurl\":\"8\",\"image\":\"8\",\"keywords\":\"8\",\"orders\":1490460588840,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题8\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":12,\"author\":\"7\",\"ctime\":1490460582004,\"description\":\"7\",\"fromurl\":\"7\",\"image\":\"7\",\"keywords\":\"7\",\"orders\":1490460582004,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题7\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":11,\"author\":\"6\",\"ctime\":1490460575304,\"description\":\"6\",\"fromurl\":\"6\",\"image\":\"6\",\"keywords\":\"6\",\"orders\":1490460575304,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题6\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1}],\"total\":16}', 'cms:article:read');
INSERT INTO `upms_log` VALUES (855, '评论首页', 'admin', 1519720698058, 31, 'http://cms.zhangshuzheng.cn:2222', '/manage/comment/index', 'http://cms.zhangshuzheng.cn:2222/manage/comment/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/comment/index.jsp\"', 'cms:comment:read');
INSERT INTO `upms_log` VALUES (856, '评论列表', 'admin', 1519720698922, 130, 'http://cms.zhangshuzheng.cn:2222', '/manage/comment/list', 'http://cms.zhangshuzheng.cn:2222/manage/comment/list', 'GET', 'order=desc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"rows\":[{\"agent\":\"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36\",\"articleId\":8,\"commentId\":1,\"content\":\"1\",\"ctime\":1490535749413,\"ip\":\"127.0.0.1\",\"status\":1,\"systemId\":1,\"userId\":1},{\"agent\":\"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36\",\"articleId\":8,\"commentId\":2,\"content\":\"2\",\"ctime\":1490536186447,\"ip\":\"127.0.0.1\",\"status\":1,\"systemId\":1,\"userId\":1},{\"agent\":\"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36\",\"articleId\":8,\"commentId\":3,\"content\":\"3\",\"ctime\":1490536192205,\"ip\":\"127.0.0.1\",\"status\":1,\"systemId\":1,\"userId\":1},{\"agent\":\"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36\",\"articleId\":8,\"commentId\":4,\"content\":\"4\",\"ctime\":1490536460544,\"ip\":\"127.0.0.1\",\"status\":1,\"systemId\":1,\"userId\":1},{\"agent\":\"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36\",\"articleId\":8,\"commentId\":5,\"content\":\"5\",\"ctime\":1490536462182,\"ip\":\"127.0.0.1\",\"status\":1,\"systemId\":1,\"userId\":1},{\"agent\":\"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36\",\"articleId\":8,\"commentId\":6,\"content\":\"6\",\"ctime\":1490536463614,\"ip\":\"127.0.0.1\",\"status\":1,\"systemId\":1,\"userId\":1},{\"agent\":\"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36\",\"articleId\":8,\"commentId\":7,\"content\":\"7\",\"ctime\":1490536464870,\"ip\":\"127.0.0.1\",\"status\":1,\"systemId\":1,\"userId\":1},{\"agent\":\"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36\",\"articleId\":8,\"commentId\":8,\"content\":\"8\",\"ctime\":1490536465926,\"ip\":\"127.0.0.1\",\"status\":1,\"systemId\":1,\"userId\":1},{\"agent\":\"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36\",\"articleId\":8,\"commentId\":9,\"content\":\"9\",\"ctime\":1490536466853,\"ip\":\"127.0.0.1\",\"status\":1,\"systemId\":1,\"userId\":1},{\"agent\":\"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36\",\"articleId\":8,\"commentId\":10,\"content\":\"10\",\"ctime\":1490536467821,\"ip\":\"127.0.0.1\",\"status\":1,\"systemId\":1,\"userId\":1}],\"total\":16}', 'cms:comment:read');
INSERT INTO `upms_log` VALUES (857, '评论首页', 'admin', 1519720703477, 21, 'http://cms.zhangshuzheng.cn:2222', '/manage/page/index', 'http://cms.zhangshuzheng.cn:2222/manage/page/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/page/index.jsp\"', 'cms:page:read');
INSERT INTO `upms_log` VALUES (858, '评论列表', 'admin', 1519720704311, 119, 'http://cms.zhangshuzheng.cn:2222', '/manage/page/list', 'http://cms.zhangshuzheng.cn:2222/manage/page/list', 'GET', 'order=asc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"rows\":[{\"alias\":\"about\",\"ctime\":1489839705049,\"description\":\"单页描述\",\"keywords\":\"单页关键字\",\"orders\":1489839705049,\"pageId\":1,\"title\":\"关于\"}],\"total\":1}', 'cms:page:read');
INSERT INTO `upms_log` VALUES (859, '评论首页', 'admin', 1519720705706, 10, 'http://cms.zhangshuzheng.cn:2222', '/manage/topic/index', 'http://cms.zhangshuzheng.cn:2222/manage/topic/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/topic/index.jsp\"', 'cms:topic:read');
INSERT INTO `upms_log` VALUES (860, '评论列表', 'admin', 1519720706281, 94, 'http://cms.zhangshuzheng.cn:2222', '/manage/topic/list', 'http://cms.zhangshuzheng.cn:2222/manage/topic/list', 'GET', 'order=asc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"rows\":[{\"ctime\":1489843484448,\"description\":\"日本经历灭国性地震，彻底沉入海底\",\"title\":\"日本地震专题\",\"topicId\":1,\"url\":\"/topic/1\"}],\"total\":1}', 'cms:topic:read');
INSERT INTO `upms_log` VALUES (861, '系统首页', 'admin', 1519720742733, 26, 'http://upms.zhangshuzheng.cn:1111', '/manage/system/index', 'http://upms.zhangshuzheng.cn:1111/manage/system/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/system/index.jsp\"', 'upms:system:read');
INSERT INTO `upms_log` VALUES (862, '系统列表', 'admin', 1519720744340, 177, 'http://upms.zhangshuzheng.cn:1111', '/manage/system/list', 'http://upms.zhangshuzheng.cn:1111/manage/system/list', 'GET', 'order=asc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"total\":5,\"rows\":[{\"banner\":\"/resources/zheng-admin/images/zheng-upms.png\",\"basepath\":\"http://upms.zhangshuzheng.cn:1111\",\"ctime\":1,\"description\":\"用户权限管理系统（RBAC细粒度用户权限、统一后台、单点登录、会话管理）\",\"icon\":\"zmdi zmdi-shield-security\",\"name\":\"zheng-upms-server\",\"orders\":1,\"status\":1,\"systemId\":1,\"theme\":\"#29A176\",\"title\":\"权限管理系统\"},{\"banner\":\"/resources/zheng-admin/images/zheng-cms.png\",\"basepath\":\"http://cms.zhangshuzheng.cn:2222\",\"ctime\":2,\"description\":\"内容管理系统（门户、博客、论坛、问答等）\",\"icon\":\"zmdi zmdi-wikipedia\",\"name\":\"zheng-cms-admin\",\"orders\":2,\"status\":1,\"systemId\":2,\"theme\":\"#455EC5\",\"title\":\"内容管理系统\"},{\"banner\":\"/resources/zheng-admin/images/zheng-pay.png\",\"basepath\":\"http://pay.zhangshuzheng.cn:3331\",\"ctime\":3,\"description\":\"支付管理系统\",\"icon\":\"zmdi zmdi-paypal-alt\",\"name\":\"zheng-pay-admin\",\"orders\":3,\"status\":1,\"systemId\":3,\"theme\":\"#F06292\",\"title\":\"支付管理系统\"},{\"banner\":\"/resources/zheng-admin/images/zheng-ucenter.png\",\"basepath\":\"http://ucenter.zhangshuzheng.cn:4441\",\"ctime\":4,\"description\":\"用户管理系统\",\"icon\":\"zmdi zmdi-account\",\"name\":\"zheng-ucenter-home\",\"orders\":4,\"status\":1,\"systemId\":4,\"theme\":\"#6539B4\",\"title\":\"用户管理系统\"},{\"banner\":\"/resources/zheng-admin/images/zheng-oss.png\",\"basepath\":\"http://oss.zhangshuzheng.cn:7771\",\"ctime\":5,\"description\":\"存储管理系统\",\"icon\":\"zmdi zmdi-cloud\",\"name\":\"zheng-oss-web\",\"orders\":5,\"status\":1,\"systemId\":5,\"theme\":\"#0B8DE5\",\"title\":\"存储管理系统\"}]}', 'upms:system:read');
INSERT INTO `upms_log` VALUES (863, '组织首页', 'admin', 1519720912877, 16, 'http://upms.zhangshuzheng.cn:1111', '/manage/organization/index', 'http://upms.zhangshuzheng.cn:1111/manage/organization/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/organization/index.jsp\"', 'upms:organization:read');
INSERT INTO `upms_log` VALUES (864, '组织列表', 'admin', 1519720913869, 62, 'http://upms.zhangshuzheng.cn:1111', '/manage/organization/list', 'http://upms.zhangshuzheng.cn:1111/manage/organization/list', 'GET', 'order=asc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"total\":5,\"rows\":[{\"ctime\":1,\"description\":\"北京总部\",\"name\":\"总部\",\"organizationId\":1},{\"ctime\":1488122466236,\"description\":\"河北石家庄\",\"name\":\"河北分部\",\"organizationId\":4},{\"ctime\":1488122480265,\"description\":\"河南郑州\",\"name\":\"河南分部\",\"organizationId\":5},{\"ctime\":1488122493265,\"description\":\"湖北武汉\",\"name\":\"湖北分部\",\"organizationId\":6},{\"ctime\":1488122502752,\"description\":\"湖南长沙\",\"name\":\"湖南分部\",\"organizationId\":7}]}', 'upms:organization:read');
INSERT INTO `upms_log` VALUES (865, '新增组织', 'admin', 1519720918817, 0, 'http://upms.zhangshuzheng.cn:1111', '/manage/organization/create', 'http://upms.zhangshuzheng.cn:1111/manage/organization/create', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/organization/create.jsp\"', 'upms:organization:create');
INSERT INTO `upms_log` VALUES (866, '修改组织', 'admin', 1519720929925, 7, 'http://upms.zhangshuzheng.cn:1111', '/manage/organization/update/1', 'http://upms.zhangshuzheng.cn:1111/manage/organization/update/1', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/organization/update.jsp\"', 'upms:organization:update');
INSERT INTO `upms_log` VALUES (867, '用户首页', 'admin', 1519720937298, 21, 'http://upms.zhangshuzheng.cn:1111', '/manage/user/index', 'http://upms.zhangshuzheng.cn:1111/manage/user/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/user/index.jsp\"', 'upms:user:read');
INSERT INTO `upms_log` VALUES (868, '用户列表', 'admin', 1519720938360, 19, 'http://upms.zhangshuzheng.cn:1111', '/manage/user/list', 'http://upms.zhangshuzheng.cn:1111/manage/user/list', 'GET', 'order=asc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"total\":2,\"rows\":[{\"avatar\":\"/resources/zheng-admin/images/avatar.jpg\",\"ctime\":1,\"email\":\"469741414@qq.com\",\"locked\":0,\"password\":\"3038D9CB63B3152A79B8153FB06C02F7\",\"phone\":\"\",\"realname\":\"张恕征\",\"salt\":\"66f1b370c660445a8657bf8bf1794486\",\"sex\":1,\"userId\":1,\"username\":\"admin\"},{\"avatar\":\"/resources/zheng-admin/images/avatar.jpg\",\"ctime\":1493394720495,\"email\":\"469741414@qq.com\",\"locked\":0,\"password\":\"285C9762F5F9046F5893F752DFAF3476\",\"phone\":\"\",\"realname\":\"张恕征\",\"salt\":\"d2d0d03310444ad388a8b290b0fe8564\",\"sex\":1,\"userId\":2,\"username\":\"test\"}]}', 'upms:user:read');
INSERT INTO `upms_log` VALUES (869, '角色首页', 'admin', 1519720940596, 16, 'http://upms.zhangshuzheng.cn:1111', '/manage/role/index', 'http://upms.zhangshuzheng.cn:1111/manage/role/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/role/index.jsp\"', 'upms:role:read');
INSERT INTO `upms_log` VALUES (870, '角色列表', 'admin', 1519720941264, 46, 'http://upms.zhangshuzheng.cn:1111', '/manage/role/list', 'http://upms.zhangshuzheng.cn:1111/manage/role/list', 'GET', 'order=asc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"total\":2,\"rows\":[{\"ctime\":1,\"description\":\"拥有所有权限\",\"name\":\"super\",\"orders\":1,\"roleId\":1,\"title\":\"超级管理员\"},{\"ctime\":1487471013117,\"description\":\"拥有除权限管理系统外的所有权限\",\"name\":\"admin\",\"orders\":1487471013117,\"roleId\":2,\"title\":\"管理员\"}]}', 'upms:role:read');
INSERT INTO `upms_log` VALUES (871, '修改角色', 'admin', 1519720952429, 8, 'http://upms.zhangshuzheng.cn:1111', '/manage/role/update/2', 'http://upms.zhangshuzheng.cn:1111/manage/role/update/2', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/role/update.jsp\"', 'upms:role:update');
INSERT INTO `upms_log` VALUES (872, '角色权限', 'admin', 1519720960282, 4, 'http://upms.zhangshuzheng.cn:1111', '/manage/role/permission/2', 'http://upms.zhangshuzheng.cn:1111/manage/role/permission/2', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/role/permission.jsp\"', 'upms:role:permission');
INSERT INTO `upms_log` VALUES (873, '角色权限列表', 'admin', 1519720960668, 187, 'http://upms.zhangshuzheng.cn:1111', '/manage/permission/role/2', 'http://upms.zhangshuzheng.cn:1111/manage/permission/role/2', 'POST', '{}', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '[{\"children\":[{\"children\":[{\"children\":[{\"name\":\"新增系统\",\"id\":24,\"open\":true},{\"name\":\"编辑系统\",\"id\":25,\"open\":true},{\"name\":\"删除系统\",\"id\":26,\"open\":true}],\"name\":\"系统管理\",\"id\":2,\"open\":true},{\"children\":[{\"name\":\"新增组织\",\"id\":27,\"open\":true},{\"name\":\"编辑组织\",\"id\":28,\"open\":true},{\"name\":\"删除组织\",\"id\":29,\"open\":true}],\"name\":\"组织管理\",\"id\":3,\"open\":true}],\"name\":\"系统组织管理\",\"id\":1,\"open\":true},{\"children\":[{\"children\":[{\"name\":\"新增用户\",\"id\":30,\"open\":true},{\"name\":\"编辑用户\",\"id\":31,\"open\":true},{\"name\":\"删除用户\",\"id\":32,\"open\":true},{\"name\":\"用户权限\",\"id\":51,\"open\":true},{\"name\":\"用户组织\",\"id\":48,\"open\":true},{\"name\":\"用户角色\",\"id\":50,\"open\":true}],\"name\":\"用户管理\",\"id\":6,\"open\":true},{\"children\":[{\"name\":\"新增角色\",\"id\":33,\"open\":true},{\"name\":\"编辑角色\",\"id\":34,\"open\":true},{\"name\":\"删除角色\",\"id\":35,\"open\":true},{\"name\":\"角色权限\",\"id\":46,\"open\":true}],\"name\":\"角色管理\",\"id\":5,\"open\":true}],\"name\":\"角色用户管理\",\"id\":4,\"open\":true},{\"children\":[{\"children\":[{\"name\":\"新增权限\",\"id\":36,\"open\":true},{\"name\":\"编辑权限\",\"id\":37,\"open\":true},{\"name\":\"删除权限\",\"id\":38,\"open\":true}],\"name\":\"权限管理\",\"id\":39,\"open\":true}],\"name\":\"权限资源管理\",\"id\":7,\"open\":true},{\"children\":[{\"children\":[{\"name\":\"强制退出\",\"id\":53,\"open\":true}],\"name\":\"会话管理\",\"id\":14,\"open\":true},{\"children\":[{\"name\":\"删除权限\",\"id\":57,\"open\":true}],\"name\":\"日志记录\",\"id\":15,\"open\":true}],\"name\":\"其他数据管理\",\"id\":12,\"open\":true}],\"name\":\"权限管理系统\",\"id\":1,\"nocheck\":true,\"open\":true},{\"children\":[{\"children\":[{\"children\":[{\"name\":\"新增标签\",\"id\":54,\"open\":true},{\"name\":\"编辑标签\",\"id\":55,\"open\":true},{\"name\":\"删除标签\",\"id\":56,\"open\":true}],\"name\":\"标签管理\",\"id\":18,\"open\":true},{\"children\":[{\"name\":\"编辑类目\",\"id\":58,\"open\":true},{\"name\":\"删除类目\",\"id\":59,\"open\":true},{\"name\":\"新增类目\",\"id\":60,\"open\":true}],\"name\":\"类目管理\",\"id\":19,\"open\":true}],\"name\":\"标签类目管理\",\"id\":17,\"open\":true},{\"children\":[{\"children\":[{\"name\":\"新增文章\",\"id\":76,\"open\":true},{\"name\":\"编辑文章\",\"id\":77,\"open\":true},{\"name\":\"删除文章\",\"id\":78,\"open\":true}],\"name\":\"文章管理\",\"id\":21,\"open\":true},{\"name\":\"回收管理\",\"id\":22,\"open\":true},{\"children\":[{\"name\":\"删除评论\",\"id\":63,\"open\":true}],\"name\":\"评论管理\",\"id\":62,\"open\":true}],\"name\":\"文章评论管理\",\"id\":20,\"open\":true},{\"children\":[{\"children\":[{\"name\":\"新增单页\",\"id\":65,\"open\":true},{\"name\":\"编辑单页\",\"id\":66,\"open\":true},{\"name\":\"删除单页\",\"id\":67,\"open\":true}],\"name\":\"单页管理\",\"id\":64,\"open\":true},{\"children\":[{\"name\":\"新增专题\",\"id\":81,\"open\":true},{\"name\":\"编辑专题\",\"id\":82,\"open\":true},{\"name\":\"删除专题\",\"id\":83,\"open\":true}],\"name\":\"专题管理\",\"id\":80,\"open\":true}],\"name\":\"单页专题管理\",\"id\":79,\"open\":true},{\"children\":[{\"children\":[{\"name\":\"新增菜单\",\"id\":69,\"open\":true},{\"name\":\"编辑菜单\",\"id\":70,\"open\":true},{\"name\":\"删除菜单\",\"id\":71,\"open\":true},{\"name\":\"上移菜单\",\"id\":84,\"open\":true},{\"name\":\"下移菜单\",\"id\":85,\"open\":true}],\"name\":\"菜单管理\",\"id\":68,\"open\":true},{\"children\":[{\"name\":\"新增设置\",\"id\":73,\"open\":true},{\"name\":\"编辑设置\",\"id\":74,\"open\":true},{\"name\":\"删除设置\",\"id\":75,\"open\":true}],\"name\":\"系统设置\",\"id\":72,\"open\":true}],\"name\":\"其他数据管理\",\"id\":61,\"open\":true}],\"name\":\"内容管理系统\",\"id\":2,\"nocheck\":true,\"open\":true},{\"name\":\"支付管理系统\",\"id\":3,\"nocheck\":true,\"open\":true},{\"name\":\"用户管理系统\",\"id\":4,\"nocheck\":true,\"open\":true},{\"name\":\"存储管理系统\",\"id\":5,\"nocheck\":true,\"open\":true}]', 'upms:permission:read');
INSERT INTO `upms_log` VALUES (874, '角色权限', 'admin', 1519721109488, 4, 'http://upms.zhangshuzheng.cn:1111', '/manage/role/permission/2', 'http://upms.zhangshuzheng.cn:1111/manage/role/permission/2', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/role/permission.jsp\"', 'upms:role:permission');
INSERT INTO `upms_log` VALUES (875, '角色权限列表', 'admin', 1519721109864, 50, 'http://upms.zhangshuzheng.cn:1111', '/manage/permission/role/2', 'http://upms.zhangshuzheng.cn:1111/manage/permission/role/2', 'POST', '{}', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '[{\"children\":[{\"children\":[{\"children\":[{\"name\":\"新增系统\",\"id\":24,\"open\":true},{\"name\":\"编辑系统\",\"id\":25,\"open\":true},{\"name\":\"删除系统\",\"id\":26,\"open\":true}],\"name\":\"系统管理\",\"id\":2,\"open\":true},{\"children\":[{\"name\":\"新增组织\",\"id\":27,\"open\":true},{\"name\":\"编辑组织\",\"id\":28,\"open\":true},{\"name\":\"删除组织\",\"id\":29,\"open\":true}],\"name\":\"组织管理\",\"id\":3,\"open\":true}],\"name\":\"系统组织管理\",\"id\":1,\"open\":true},{\"children\":[{\"children\":[{\"name\":\"新增用户\",\"id\":30,\"open\":true},{\"name\":\"编辑用户\",\"id\":31,\"open\":true},{\"name\":\"删除用户\",\"id\":32,\"open\":true},{\"name\":\"用户权限\",\"id\":51,\"open\":true},{\"name\":\"用户组织\",\"id\":48,\"open\":true},{\"name\":\"用户角色\",\"id\":50,\"open\":true}],\"name\":\"用户管理\",\"id\":6,\"open\":true},{\"children\":[{\"name\":\"新增角色\",\"id\":33,\"open\":true},{\"name\":\"编辑角色\",\"id\":34,\"open\":true},{\"name\":\"删除角色\",\"id\":35,\"open\":true},{\"name\":\"角色权限\",\"id\":46,\"open\":true}],\"name\":\"角色管理\",\"id\":5,\"open\":true}],\"name\":\"角色用户管理\",\"id\":4,\"open\":true},{\"children\":[{\"children\":[{\"name\":\"新增权限\",\"id\":36,\"open\":true},{\"name\":\"编辑权限\",\"id\":37,\"open\":true},{\"name\":\"删除权限\",\"id\":38,\"open\":true}],\"name\":\"权限管理\",\"id\":39,\"open\":true}],\"name\":\"权限资源管理\",\"id\":7,\"open\":true},{\"children\":[{\"children\":[{\"name\":\"强制退出\",\"id\":53,\"open\":true}],\"name\":\"会话管理\",\"id\":14,\"open\":true},{\"children\":[{\"name\":\"删除权限\",\"id\":57,\"open\":true}],\"name\":\"日志记录\",\"id\":15,\"open\":true}],\"name\":\"其他数据管理\",\"id\":12,\"open\":true}],\"name\":\"权限管理系统\",\"id\":1,\"nocheck\":true,\"open\":true},{\"children\":[{\"children\":[{\"children\":[{\"name\":\"新增标签\",\"id\":54,\"open\":true},{\"name\":\"编辑标签\",\"id\":55,\"open\":true},{\"name\":\"删除标签\",\"id\":56,\"open\":true}],\"name\":\"标签管理\",\"id\":18,\"open\":true},{\"children\":[{\"name\":\"编辑类目\",\"id\":58,\"open\":true},{\"name\":\"删除类目\",\"id\":59,\"open\":true},{\"name\":\"新增类目\",\"id\":60,\"open\":true}],\"name\":\"类目管理\",\"id\":19,\"open\":true}],\"name\":\"标签类目管理\",\"id\":17,\"open\":true},{\"children\":[{\"children\":[{\"name\":\"新增文章\",\"id\":76,\"open\":true},{\"name\":\"编辑文章\",\"id\":77,\"open\":true},{\"name\":\"删除文章\",\"id\":78,\"open\":true}],\"name\":\"文章管理\",\"id\":21,\"open\":true},{\"name\":\"回收管理\",\"id\":22,\"open\":true},{\"children\":[{\"name\":\"删除评论\",\"id\":63,\"open\":true}],\"name\":\"评论管理\",\"id\":62,\"open\":true}],\"name\":\"文章评论管理\",\"id\":20,\"open\":true},{\"children\":[{\"children\":[{\"name\":\"新增单页\",\"id\":65,\"open\":true},{\"name\":\"编辑单页\",\"id\":66,\"open\":true},{\"name\":\"删除单页\",\"id\":67,\"open\":true}],\"name\":\"单页管理\",\"id\":64,\"open\":true},{\"children\":[{\"name\":\"新增专题\",\"id\":81,\"open\":true},{\"name\":\"编辑专题\",\"id\":82,\"open\":true},{\"name\":\"删除专题\",\"id\":83,\"open\":true}],\"name\":\"专题管理\",\"id\":80,\"open\":true}],\"name\":\"单页专题管理\",\"id\":79,\"open\":true},{\"children\":[{\"children\":[{\"name\":\"新增菜单\",\"id\":69,\"open\":true},{\"name\":\"编辑菜单\",\"id\":70,\"open\":true},{\"name\":\"删除菜单\",\"id\":71,\"open\":true},{\"name\":\"上移菜单\",\"id\":84,\"open\":true},{\"name\":\"下移菜单\",\"id\":85,\"open\":true}],\"name\":\"菜单管理\",\"id\":68,\"open\":true},{\"children\":[{\"name\":\"新增设置\",\"id\":73,\"open\":true},{\"name\":\"编辑设置\",\"id\":74,\"open\":true},{\"name\":\"删除设置\",\"id\":75,\"open\":true}],\"name\":\"系统设置\",\"id\":72,\"open\":true}],\"name\":\"其他数据管理\",\"id\":61,\"open\":true}],\"name\":\"内容管理系统\",\"id\":2,\"nocheck\":true,\"open\":true},{\"name\":\"支付管理系统\",\"id\":3,\"nocheck\":true,\"open\":true},{\"name\":\"用户管理系统\",\"id\":4,\"nocheck\":true,\"open\":true},{\"name\":\"存储管理系统\",\"id\":5,\"nocheck\":true,\"open\":true}]', 'upms:permission:read');
INSERT INTO `upms_log` VALUES (876, '类目首页', 'admin', 1519721137344, 0, 'http://cms.zhangshuzheng.cn:2222', '/manage/category/index', 'http://cms.zhangshuzheng.cn:2222/manage/category/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/category/index.jsp\"', 'cms:category:read');
INSERT INTO `upms_log` VALUES (877, '评论首页', 'admin', 1519721137768, 0, 'http://cms.zhangshuzheng.cn:2222', '/manage/tag/index', 'http://cms.zhangshuzheng.cn:2222/manage/tag/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/tag/index.jsp\"', 'cms:tag:read');
INSERT INTO `upms_log` VALUES (878, '类目列表', 'admin', 1519721137905, 48, 'http://cms.zhangshuzheng.cn:2222', '/manage/category/list', 'http://cms.zhangshuzheng.cn:2222/manage/category/list', 'GET', 'order=asc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"rows\":[{\"alias\":\"economic\",\"categoryId\":5,\"ctime\":1489590733919,\"description\":\"经济类目\",\"icon\":\"\",\"level\":1,\"name\":\"经济\",\"orders\":1489590733919,\"systemId\":1,\"type\":1},{\"alias\":\"chinaeconomic\",\"categoryId\":6,\"ctime\":1489590768989,\"description\":\"中国经济类目\",\"icon\":\"\",\"level\":2,\"name\":\"中国经济\",\"orders\":1489590768989,\"pid\":5,\"systemId\":1,\"type\":1},{\"alias\":\"japaneconomic\",\"categoryId\":7,\"ctime\":1491636586316,\"description\":\"日本经济类目\",\"icon\":\"\",\"level\":2,\"name\":\"日本经济\",\"orders\":1491636586316,\"pid\":5,\"systemId\":1,\"type\":1},{\"alias\":\"people\",\"categoryId\":8,\"ctime\":1491636586317,\"description\":\"人类问题\",\"icon\":\"\",\"level\":1,\"name\":\"人类\",\"orders\":1491636586317,\"systemId\":2,\"type\":1},{\"alias\":\"technic\",\"categoryId\":9,\"ctime\":1491636586318,\"description\":\"技术博文\",\"level\":1,\"name\":\"技术\",\"orders\":1491636586318,\"systemId\":3,\"type\":1}],\"total\":5}', 'cms:category:read');
INSERT INTO `upms_log` VALUES (879, '评论列表', 'admin', 1519721138080, 26, 'http://cms.zhangshuzheng.cn:2222', '/manage/tag/list', 'http://cms.zhangshuzheng.cn:2222/manage/tag/list', 'GET', 'order=asc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"rows\":[{\"alias\":\"java\",\"ctime\":1489585694864,\"description\":\"java标签\",\"icon\":\"\",\"name\":\"JAVA\",\"orders\":1489585694864,\"systemId\":1,\"tagId\":1,\"type\":1},{\"alias\":\"android\",\"ctime\":1489585720382,\"description\":\"android标签\",\"icon\":\"\",\"name\":\"Android\",\"orders\":1489585720382,\"systemId\":1,\"tagId\":2,\"type\":1},{\"alias\":\"zheng\",\"ctime\":1489585815042,\"description\":\"zheng标签\",\"icon\":\"\",\"name\":\"zheng\",\"orders\":1489585815042,\"systemId\":1,\"tagId\":3,\"type\":2},{\"alias\":\"love\",\"ctime\":1489585815043,\"description\":\"谈恋爱标签\",\"icon\":\"\",\"name\":\"谈恋爱\",\"orders\":1489585815043,\"systemId\":2,\"tagId\":4,\"type\":1},{\"alias\":\"java\",\"ctime\":1489585815044,\"description\":\"java标签\",\"icon\":\"\",\"name\":\"java\",\"orders\":1489585815044,\"systemId\":3,\"tagId\":5,\"type\":1}],\"total\":5}', 'cms:tag:read');
INSERT INTO `upms_log` VALUES (880, '评论首页', 'admin', 1519721167366, 0, 'http://cms.zhangshuzheng.cn:2222', '/manage/tag/index', 'http://cms.zhangshuzheng.cn:2222/manage/tag/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/tag/index.jsp\"', 'cms:tag:read');
INSERT INTO `upms_log` VALUES (881, '评论列表', 'admin', 1519721167777, 31, 'http://cms.zhangshuzheng.cn:2222', '/manage/tag/list', 'http://cms.zhangshuzheng.cn:2222/manage/tag/list', 'GET', 'order=asc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"rows\":[{\"alias\":\"java\",\"ctime\":1489585694864,\"description\":\"java标签\",\"icon\":\"\",\"name\":\"JAVA\",\"orders\":1489585694864,\"systemId\":1,\"tagId\":1,\"type\":1},{\"alias\":\"android\",\"ctime\":1489585720382,\"description\":\"android标签\",\"icon\":\"\",\"name\":\"Android\",\"orders\":1489585720382,\"systemId\":1,\"tagId\":2,\"type\":1},{\"alias\":\"zheng\",\"ctime\":1489585815042,\"description\":\"zheng标签\",\"icon\":\"\",\"name\":\"zheng\",\"orders\":1489585815042,\"systemId\":1,\"tagId\":3,\"type\":2},{\"alias\":\"love\",\"ctime\":1489585815043,\"description\":\"谈恋爱标签\",\"icon\":\"\",\"name\":\"谈恋爱\",\"orders\":1489585815043,\"systemId\":2,\"tagId\":4,\"type\":1},{\"alias\":\"java\",\"ctime\":1489585815044,\"description\":\"java标签\",\"icon\":\"\",\"name\":\"java\",\"orders\":1489585815044,\"systemId\":3,\"tagId\":5,\"type\":1}],\"total\":5}', 'cms:tag:read');
INSERT INTO `upms_log` VALUES (882, '类目首页', 'admin', 1519721170143, 0, 'http://cms.zhangshuzheng.cn:2222', '/manage/category/index', 'http://cms.zhangshuzheng.cn:2222/manage/category/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/category/index.jsp\"', 'cms:category:read');
INSERT INTO `upms_log` VALUES (883, '类目列表', 'admin', 1519721170426, 18, 'http://cms.zhangshuzheng.cn:2222', '/manage/category/list', 'http://cms.zhangshuzheng.cn:2222/manage/category/list', 'GET', 'order=asc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"rows\":[{\"alias\":\"economic\",\"categoryId\":5,\"ctime\":1489590733919,\"description\":\"经济类目\",\"icon\":\"\",\"level\":1,\"name\":\"经济\",\"orders\":1489590733919,\"systemId\":1,\"type\":1},{\"alias\":\"chinaeconomic\",\"categoryId\":6,\"ctime\":1489590768989,\"description\":\"中国经济类目\",\"icon\":\"\",\"level\":2,\"name\":\"中国经济\",\"orders\":1489590768989,\"pid\":5,\"systemId\":1,\"type\":1},{\"alias\":\"japaneconomic\",\"categoryId\":7,\"ctime\":1491636586316,\"description\":\"日本经济类目\",\"icon\":\"\",\"level\":2,\"name\":\"日本经济\",\"orders\":1491636586316,\"pid\":5,\"systemId\":1,\"type\":1},{\"alias\":\"people\",\"categoryId\":8,\"ctime\":1491636586317,\"description\":\"人类问题\",\"icon\":\"\",\"level\":1,\"name\":\"人类\",\"orders\":1491636586317,\"systemId\":2,\"type\":1},{\"alias\":\"technic\",\"categoryId\":9,\"ctime\":1491636586318,\"description\":\"技术博文\",\"level\":1,\"name\":\"技术\",\"orders\":1491636586318,\"systemId\":3,\"type\":1}],\"total\":5}', 'cms:category:read');
INSERT INTO `upms_log` VALUES (884, '评论首页', 'admin', 1519721176820, 0, 'http://cms.zhangshuzheng.cn:2222', '/manage/comment/index', 'http://cms.zhangshuzheng.cn:2222/manage/comment/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/comment/index.jsp\"', 'cms:comment:read');
INSERT INTO `upms_log` VALUES (885, '评论列表', 'admin', 1519721177093, 43, 'http://cms.zhangshuzheng.cn:2222', '/manage/comment/list', 'http://cms.zhangshuzheng.cn:2222/manage/comment/list', 'GET', 'order=desc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"rows\":[{\"agent\":\"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36\",\"articleId\":8,\"commentId\":1,\"content\":\"1\",\"ctime\":1490535749413,\"ip\":\"127.0.0.1\",\"status\":1,\"systemId\":1,\"userId\":1},{\"agent\":\"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36\",\"articleId\":8,\"commentId\":2,\"content\":\"2\",\"ctime\":1490536186447,\"ip\":\"127.0.0.1\",\"status\":1,\"systemId\":1,\"userId\":1},{\"agent\":\"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36\",\"articleId\":8,\"commentId\":3,\"content\":\"3\",\"ctime\":1490536192205,\"ip\":\"127.0.0.1\",\"status\":1,\"systemId\":1,\"userId\":1},{\"agent\":\"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36\",\"articleId\":8,\"commentId\":4,\"content\":\"4\",\"ctime\":1490536460544,\"ip\":\"127.0.0.1\",\"status\":1,\"systemId\":1,\"userId\":1},{\"agent\":\"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36\",\"articleId\":8,\"commentId\":5,\"content\":\"5\",\"ctime\":1490536462182,\"ip\":\"127.0.0.1\",\"status\":1,\"systemId\":1,\"userId\":1},{\"agent\":\"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36\",\"articleId\":8,\"commentId\":6,\"content\":\"6\",\"ctime\":1490536463614,\"ip\":\"127.0.0.1\",\"status\":1,\"systemId\":1,\"userId\":1},{\"agent\":\"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36\",\"articleId\":8,\"commentId\":7,\"content\":\"7\",\"ctime\":1490536464870,\"ip\":\"127.0.0.1\",\"status\":1,\"systemId\":1,\"userId\":1},{\"agent\":\"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36\",\"articleId\":8,\"commentId\":8,\"content\":\"8\",\"ctime\":1490536465926,\"ip\":\"127.0.0.1\",\"status\":1,\"systemId\":1,\"userId\":1},{\"agent\":\"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36\",\"articleId\":8,\"commentId\":9,\"content\":\"9\",\"ctime\":1490536466853,\"ip\":\"127.0.0.1\",\"status\":1,\"systemId\":1,\"userId\":1},{\"agent\":\"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36\",\"articleId\":8,\"commentId\":10,\"content\":\"10\",\"ctime\":1490536467821,\"ip\":\"127.0.0.1\",\"status\":1,\"systemId\":1,\"userId\":1}],\"total\":16}', 'cms:comment:read');
INSERT INTO `upms_log` VALUES (886, '文章列表', 'admin', 1519721183186, 16, 'http://cms.zhangshuzheng.cn:2222', '/manage/article/list', 'http://cms.zhangshuzheng.cn:2222/manage/article/list', 'GET', 'sort=orders&order=desc&offset=10&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"rows\":[{\"allowcomments\":1,\"articleId\":10,\"author\":\"5\",\"ctime\":1490460567137,\"description\":\"5\",\"fromurl\":\"5\",\"image\":\"5\",\"keywords\":\"5\",\"orders\":1490460567137,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题5\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":9,\"author\":\"4\",\"ctime\":1490460546198,\"description\":\"4\",\"fromurl\":\"4\",\"image\":\"4\",\"keywords\":\"4\",\"orders\":1490460546198,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题4\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":8,\"author\":\"shuzheng\",\"ctime\":1489845594355,\"description\":\"日本从地震中消失\",\"fromurl\":\"网络\",\"image\":\"\",\"keywords\":\"日本消失,日本地震\",\"orders\":1489845594355,\"readnumber\":12,\"status\":1,\"systemId\":1,\"title\":\"日本从地球消失，我们倍(喜)感(大)心(普)痛(奔)\",\"top\":0,\"topicId\":1,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":5,\"author\":\"3\",\"ctime\":1489827581414,\"description\":\"3\",\"fromurl\":\"3\",\"image\":\"3\",\"keywords\":\"3\",\"orders\":1489827581414,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题3\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":4,\"author\":\"2\",\"ctime\":1489827340870,\"description\":\"2\",\"fromurl\":\"2\",\"image\":\"2\",\"keywords\":\"2\",\"orders\":1489827340870,\"readnumber\":0,\"status\":-1,\"systemId\":1,\"title\":\"中国经济标题2\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":3,\"author\":\"1\",\"ctime\":1489827019528,\"description\":\"1\",\"fromurl\":\"1\",\"image\":\"1\",\"keywords\":\"1\",\"orders\":1489827019528,\"readnumber\":0,\"status\":0,\"systemId\":1,\"title\":\"中国经济标题1\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1}],\"total\":16}', 'cms:article:read');
INSERT INTO `upms_log` VALUES (887, '文章列表', 'admin', 1519721183962, 20, 'http://cms.zhangshuzheng.cn:2222', '/manage/article/list', 'http://cms.zhangshuzheng.cn:2222/manage/article/list', 'GET', 'sort=orders&order=desc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"rows\":[{\"allowcomments\":1,\"articleId\":20,\"author\":\"test\",\"ctime\":1490460800636,\"description\":\"test\",\"fromurl\":\"test\",\"image\":\"test\",\"keywords\":\"test\",\"orders\":1490460800636,\"readnumber\":0,\"status\":1,\"systemId\":3,\"title\":\"java开发笔记\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":19,\"author\":\"test\",\"ctime\":1490460800635,\"description\":\"test\",\"fromurl\":\"test\",\"image\":\"test\",\"keywords\":\"test\",\"orders\":1490460800635,\"readnumber\":0,\"status\":1,\"systemId\":2,\"title\":\"人为什么谈恋爱？\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":18,\"author\":\"13\",\"ctime\":1490460800634,\"description\":\"13\",\"fromurl\":\"13\",\"image\":\"13\",\"keywords\":\"13\",\"orders\":1490460800634,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题13\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":17,\"author\":\"12\",\"ctime\":1490460792501,\"description\":\"12\",\"fromurl\":\"12\",\"image\":\"12\",\"keywords\":\"12\",\"orders\":1490460792501,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题12\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":16,\"author\":\"11\",\"ctime\":1490460782767,\"description\":\"11\",\"fromurl\":\"11\",\"image\":\"11\",\"keywords\":\"11\",\"orders\":1490460782767,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题11\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":15,\"author\":\"10\",\"ctime\":1490460612370,\"description\":\"10\",\"fromurl\":\"10\",\"image\":\"10\",\"keywords\":\"10\",\"orders\":1490460612370,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题10\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":14,\"author\":\"9\",\"ctime\":1490460596394,\"description\":\"9\",\"fromurl\":\"9\",\"image\":\"9\",\"keywords\":\"9\",\"orders\":1490460596394,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题9\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":13,\"author\":\"8\",\"ctime\":1490460588840,\"description\":\"8\",\"fromurl\":\"8\",\"image\":\"8\",\"keywords\":\"8\",\"orders\":1490460588840,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题8\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":12,\"author\":\"7\",\"ctime\":1490460582004,\"description\":\"7\",\"fromurl\":\"7\",\"image\":\"7\",\"keywords\":\"7\",\"orders\":1490460582004,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题7\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":11,\"author\":\"6\",\"ctime\":1490460575304,\"description\":\"6\",\"fromurl\":\"6\",\"image\":\"6\",\"keywords\":\"6\",\"orders\":1490460575304,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题6\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1}],\"total\":16}', 'cms:article:read');
INSERT INTO `upms_log` VALUES (888, '评论首页', 'admin', 1519721220601, 14, 'http://cms.zhangshuzheng.cn:2222', '/manage/menu/index', 'http://cms.zhangshuzheng.cn:2222/manage/menu/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/menu/index.jsp\"', 'cms:menu:read');
INSERT INTO `upms_log` VALUES (889, '评论列表', 'admin', 1519721221493, 94, 'http://cms.zhangshuzheng.cn:2222', '/manage/menu/list', 'http://cms.zhangshuzheng.cn:2222/manage/menu/list', 'GET', 'sort=orders&order=asc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"rows\":[{\"menuId\":1,\"name\":\"首页\",\"orders\":1489847080380,\"target\":\"_self\",\"url\":\"/\"},{\"menuId\":4,\"name\":\"资讯\",\"orders\":1489847080381,\"target\":\"_self\",\"url\":\"/news\"},{\"menuId\":2,\"name\":\"问答\",\"orders\":1489847186644,\"target\":\"_self\",\"url\":\"/qa\"},{\"menuId\":3,\"name\":\"博客\",\"orders\":1489847186645,\"target\":\"_self\",\"url\":\"/blog\"},{\"menuId\":5,\"name\":\"专题\",\"orders\":1489847186646,\"target\":\"_self\",\"url\":\"/topic/list\"},{\"menuId\":6,\"name\":\"关于\",\"orders\":1489847186647,\"target\":\"_self\",\"url\":\"/page/about\"}],\"total\":6}', 'cms:menu:read');
INSERT INTO `upms_log` VALUES (890, '评论首页', 'admin', 1519721225162, 11, 'http://cms.zhangshuzheng.cn:2222', '/manage/setting/index', 'http://cms.zhangshuzheng.cn:2222/manage/setting/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/setting/index.jsp\"', 'cms:setting:read');
INSERT INTO `upms_log` VALUES (891, '评论列表', 'admin', 1519721225817, 58, 'http://cms.zhangshuzheng.cn:2222', '/manage/setting/list', 'http://cms.zhangshuzheng.cn:2222/manage/setting/list', 'GET', 'order=asc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"rows\":[{\"settingId\":1,\"settingKey\":\"copyright\",\"settingValue\":\"© 2017 Zhang Shuzheng\"}],\"total\":1}', 'cms:setting:read');
INSERT INTO `upms_log` VALUES (892, '新增设置', 'admin', 1519721229964, 0, 'http://cms.zhangshuzheng.cn:2222', '/manage/setting/create', 'http://cms.zhangshuzheng.cn:2222/manage/setting/create', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/setting/create.jsp\"', 'cms:setting:create');
INSERT INTO `upms_log` VALUES (893, '权限首页', 'admin', 1519721262275, 0, 'http://upms.zhangshuzheng.cn:1111', '/manage/permission/index', 'http://upms.zhangshuzheng.cn:1111/manage/permission/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/permission/index.jsp\"', 'upms:permission:read');
INSERT INTO `upms_log` VALUES (894, '权限列表', 'admin', 1519721263112, 95, 'http://upms.zhangshuzheng.cn:1111', '/manage/permission/list', 'http://upms.zhangshuzheng.cn:1111/manage/permission/list', 'GET', 'order=asc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"total\":69,\"rows\":[{\"ctime\":1,\"icon\":\"zmdi zmdi-accounts-list\",\"name\":\"系统组织管理\",\"orders\":1,\"permissionId\":1,\"permissionValue\":\"\",\"pid\":0,\"status\":1,\"systemId\":1,\"type\":1,\"uri\":\"\"},{\"ctime\":2,\"icon\":\"\",\"name\":\"系统管理\",\"orders\":2,\"permissionId\":2,\"permissionValue\":\"upms:system:read\",\"pid\":1,\"status\":1,\"systemId\":1,\"type\":2,\"uri\":\"/manage/system/index\"},{\"ctime\":3,\"icon\":\"\",\"name\":\"组织管理\",\"orders\":3,\"permissionId\":3,\"permissionValue\":\"upms:organization:read\",\"pid\":1,\"status\":1,\"systemId\":1,\"type\":2,\"uri\":\"/manage/organization/index\"},{\"ctime\":4,\"icon\":\"zmdi zmdi-accounts\",\"name\":\"角色用户管理\",\"orders\":4,\"permissionId\":4,\"permissionValue\":\"\",\"pid\":0,\"status\":1,\"systemId\":1,\"type\":1,\"uri\":\"\"},{\"ctime\":6,\"icon\":\"\",\"name\":\"角色管理\",\"orders\":6,\"permissionId\":5,\"permissionValue\":\"upms:role:read\",\"pid\":4,\"status\":1,\"systemId\":1,\"type\":2,\"uri\":\"/manage/role/index\"},{\"ctime\":5,\"icon\":\"\",\"name\":\"用户管理\",\"orders\":5,\"permissionId\":6,\"permissionValue\":\"upms:user:read\",\"pid\":4,\"status\":1,\"systemId\":1,\"type\":2,\"uri\":\"/manage/user/index\"},{\"ctime\":7,\"icon\":\"zmdi zmdi-lock-outline\",\"name\":\"权限资源管理\",\"orders\":7,\"permissionId\":7,\"permissionValue\":\"\",\"pid\":0,\"status\":1,\"systemId\":1,\"type\":1,\"uri\":\"\"},{\"ctime\":12,\"icon\":\"zmdi zmdi-more\",\"name\":\"其他数据管理\",\"orders\":12,\"permissionId\":12,\"permissionValue\":\"\",\"pid\":0,\"status\":1,\"systemId\":1,\"type\":1,\"uri\":\"\"},{\"ctime\":14,\"icon\":\"\",\"name\":\"会话管理\",\"orders\":14,\"permissionId\":14,\"permissionValue\":\"upms:session:read\",\"pid\":12,\"status\":1,\"systemId\":1,\"type\":2,\"uri\":\"/manage/session/index\"},{\"ctime\":15,\"icon\":\"\",\"name\":\"日志记录\",\"orders\":15,\"permissionId\":15,\"permissionValue\":\"upms:log:read\",\"pid\":12,\"status\":1,\"systemId\":1,\"type\":2,\"uri\":\"/manage/log/index\"}]}', 'upms:permission:read');
INSERT INTO `upms_log` VALUES (895, '权限列表', 'admin', 1519721276757, 10, 'http://upms.zhangshuzheng.cn:1111', '/manage/permission/list', 'http://upms.zhangshuzheng.cn:1111/manage/permission/list', 'GET', 'order=asc&offset=10&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"total\":69,\"rows\":[{\"ctime\":17,\"icon\":\"zmdi zmdi-menu\",\"name\":\"标签类目管理\",\"orders\":17,\"permissionId\":17,\"pid\":0,\"status\":1,\"systemId\":2,\"type\":1},{\"ctime\":18,\"name\":\"标签管理\",\"orders\":18,\"permissionId\":18,\"permissionValue\":\"cms:tag:read\",\"pid\":17,\"status\":1,\"systemId\":2,\"type\":2,\"uri\":\"/manage/tag/index\"},{\"ctime\":19,\"name\":\"类目管理\",\"orders\":19,\"permissionId\":19,\"permissionValue\":\"cms:category:read\",\"pid\":17,\"status\":1,\"systemId\":2,\"type\":2,\"uri\":\"/manage/category/index\"},{\"ctime\":20,\"icon\":\"zmdi zmdi-collection-text\",\"name\":\"文章评论管理\",\"orders\":20,\"permissionId\":20,\"pid\":0,\"status\":1,\"systemId\":2,\"type\":1},{\"ctime\":21,\"name\":\"文章管理\",\"orders\":21,\"permissionId\":21,\"permissionValue\":\"cms:article:read\",\"pid\":20,\"status\":1,\"systemId\":2,\"type\":2,\"uri\":\"/manage/article/index\"},{\"ctime\":22,\"name\":\"回收管理\",\"orders\":22,\"permissionId\":22,\"permissionValue\":\"cms:article:read\",\"pid\":20,\"status\":1,\"systemId\":2,\"type\":2,\"uri\":\"/manage/article/recycle\"},{\"ctime\":24,\"icon\":\"zmdi zmdi-plus\",\"name\":\"新增系统\",\"orders\":24,\"permissionId\":24,\"permissionValue\":\"upms:system:create\",\"pid\":2,\"status\":1,\"systemId\":1,\"type\":3,\"uri\":\"/manage/system/create\"},{\"ctime\":25,\"icon\":\"zmdi zmdi-edit\",\"name\":\"编辑系统\",\"orders\":25,\"permissionId\":25,\"permissionValue\":\"upms:system:update\",\"pid\":2,\"status\":1,\"systemId\":1,\"type\":3,\"uri\":\"/manage/system/update\"},{\"ctime\":26,\"icon\":\"zmdi zmdi-close\",\"name\":\"删除系统\",\"orders\":26,\"permissionId\":26,\"permissionValue\":\"upms:system:delete\",\"pid\":2,\"status\":1,\"systemId\":1,\"type\":3,\"uri\":\"/manage/system/delete\"},{\"ctime\":27,\"icon\":\"zmdi zmdi-plus\",\"name\":\"新增组织\",\"orders\":27,\"permissionId\":27,\"permissionValue\":\"upms:organization:create\",\"pid\":3,\"status\":1,\"systemId\":1,\"type\":3,\"uri\":\"/manage/organization/create\"}]}', 'upms:permission:read');
INSERT INTO `upms_log` VALUES (896, '登录', '', 1519735971915, 29, 'http://upms.zhangshuzheng.cn:1111', '/sso/login', 'http://upms.zhangshuzheng.cn:1111/sso/login', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/sso/login.jsp\"', NULL);
INSERT INTO `upms_log` VALUES (897, '登录', 'admin', 1519735976053, 238, 'http://upms.zhangshuzheng.cn:1111', '/sso/login', 'http://upms.zhangshuzheng.cn:1111/sso/login', 'POST', '{password=[123456],rememberMe=[false],backurl=[],username=[admin]}', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"code\":1,\"data\":\"http://upms.zhangshuzheng.cn:1111\",\"message\":\"success\"}', NULL);
INSERT INTO `upms_log` VALUES (898, '后台首页', 'admin', 1519735976709, 283, 'http://upms.zhangshuzheng.cn:1111', '/manage/index', 'http://upms.zhangshuzheng.cn:1111/manage/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/index.jsp\"', NULL);
INSERT INTO `upms_log` VALUES (899, '系统首页', 'admin', 1519735980487, 19, 'http://upms.zhangshuzheng.cn:1111', '/manage/system/index', 'http://upms.zhangshuzheng.cn:1111/manage/system/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/system/index.jsp\"', 'upms:system:read');
INSERT INTO `upms_log` VALUES (900, '系统列表', 'admin', 1519735982097, 65, 'http://upms.zhangshuzheng.cn:1111', '/manage/system/list', 'http://upms.zhangshuzheng.cn:1111/manage/system/list', 'GET', 'order=asc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"total\":5,\"rows\":[{\"banner\":\"/resources/zheng-admin/images/zheng-upms.png\",\"basepath\":\"http://upms.zhangshuzheng.cn:1111\",\"ctime\":1,\"description\":\"用户权限管理系统（RBAC细粒度用户权限、统一后台、单点登录、会话管理）\",\"icon\":\"zmdi zmdi-shield-security\",\"name\":\"zheng-upms-server\",\"orders\":1,\"status\":1,\"systemId\":1,\"theme\":\"#29A176\",\"title\":\"权限管理系统\"},{\"banner\":\"/resources/zheng-admin/images/zheng-cms.png\",\"basepath\":\"http://cms.zhangshuzheng.cn:2222\",\"ctime\":2,\"description\":\"内容管理系统（门户、博客、论坛、问答等）\",\"icon\":\"zmdi zmdi-wikipedia\",\"name\":\"zheng-cms-admin\",\"orders\":2,\"status\":1,\"systemId\":2,\"theme\":\"#455EC5\",\"title\":\"内容管理系统\"},{\"banner\":\"/resources/zheng-admin/images/zheng-pay.png\",\"basepath\":\"http://pay.zhangshuzheng.cn:3331\",\"ctime\":3,\"description\":\"支付管理系统\",\"icon\":\"zmdi zmdi-paypal-alt\",\"name\":\"zheng-pay-admin\",\"orders\":3,\"status\":1,\"systemId\":3,\"theme\":\"#F06292\",\"title\":\"支付管理系统\"},{\"banner\":\"/resources/zheng-admin/images/zheng-ucenter.png\",\"basepath\":\"http://ucenter.zhangshuzheng.cn:4441\",\"ctime\":4,\"description\":\"用户管理系统\",\"icon\":\"zmdi zmdi-account\",\"name\":\"zheng-ucenter-home\",\"orders\":4,\"status\":1,\"systemId\":4,\"theme\":\"#6539B4\",\"title\":\"用户管理系统\"},{\"banner\":\"/resources/zheng-admin/images/zheng-oss.png\",\"basepath\":\"http://oss.zhangshuzheng.cn:7771\",\"ctime\":5,\"description\":\"存储管理系统\",\"icon\":\"zmdi zmdi-cloud\",\"name\":\"zheng-oss-web\",\"orders\":5,\"status\":1,\"systemId\":5,\"theme\":\"#0B8DE5\",\"title\":\"存储管理系统\"}]}', 'upms:system:read');
INSERT INTO `upms_log` VALUES (901, '组织首页', 'admin', 1519735982900, 16, 'http://upms.zhangshuzheng.cn:1111', '/manage/organization/index', 'http://upms.zhangshuzheng.cn:1111/manage/organization/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/organization/index.jsp\"', 'upms:organization:read');
INSERT INTO `upms_log` VALUES (902, '组织列表', 'admin', 1519735983735, 51, 'http://upms.zhangshuzheng.cn:1111', '/manage/organization/list', 'http://upms.zhangshuzheng.cn:1111/manage/organization/list', 'GET', 'order=asc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"total\":5,\"rows\":[{\"ctime\":1,\"description\":\"北京总部\",\"name\":\"总部\",\"organizationId\":1},{\"ctime\":1488122466236,\"description\":\"河北石家庄\",\"name\":\"河北分部\",\"organizationId\":4},{\"ctime\":1488122480265,\"description\":\"河南郑州\",\"name\":\"河南分部\",\"organizationId\":5},{\"ctime\":1488122493265,\"description\":\"湖北武汉\",\"name\":\"湖北分部\",\"organizationId\":6},{\"ctime\":1488122502752,\"description\":\"湖南长沙\",\"name\":\"湖南分部\",\"organizationId\":7}]}', 'upms:organization:read');
INSERT INTO `upms_log` VALUES (903, '登录', '', 1520168509140, 102, 'http://upms.zhangshuzheng.cn:1111', '/sso/login', 'http://upms.zhangshuzheng.cn:1111/sso/login', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/sso/login.jsp\"', NULL);
INSERT INTO `upms_log` VALUES (904, '登录', 'admin', 1520168514309, 555, 'http://upms.zhangshuzheng.cn:1111', '/sso/login', 'http://upms.zhangshuzheng.cn:1111/sso/login', 'POST', '{password=[123456],rememberMe=[false],backurl=[],username=[admin]}', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"code\":1,\"data\":\"http://upms.zhangshuzheng.cn:1111\",\"message\":\"success\"}', NULL);
INSERT INTO `upms_log` VALUES (905, '后台首页', 'admin', 1520168515125, 529, 'http://upms.zhangshuzheng.cn:1111', '/manage/index', 'http://upms.zhangshuzheng.cn:1111/manage/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/index.jsp\"', NULL);
INSERT INTO `upms_log` VALUES (906, '系统首页', 'admin', 1520168548716, 19, 'http://upms.zhangshuzheng.cn:1111', '/manage/system/index', 'http://upms.zhangshuzheng.cn:1111/manage/system/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/system/index.jsp\"', 'upms:system:read');
INSERT INTO `upms_log` VALUES (907, '系统列表', 'admin', 1520168550573, 35, 'http://upms.zhangshuzheng.cn:1111', '/manage/system/list', 'http://upms.zhangshuzheng.cn:1111/manage/system/list', 'GET', 'order=asc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"total\":5,\"rows\":[{\"banner\":\"/resources/zheng-admin/images/zheng-upms.png\",\"basepath\":\"http://upms.zhangshuzheng.cn:1111\",\"ctime\":1,\"description\":\"用户权限管理系统（RBAC细粒度用户权限、统一后台、单点登录、会话管理）\",\"icon\":\"zmdi zmdi-shield-security\",\"name\":\"zheng-upms-server\",\"orders\":1,\"status\":1,\"systemId\":1,\"theme\":\"#29A176\",\"title\":\"权限管理系统\"},{\"banner\":\"/resources/zheng-admin/images/zheng-cms.png\",\"basepath\":\"http://cms.zhangshuzheng.cn:2222\",\"ctime\":2,\"description\":\"内容管理系统（门户、博客、论坛、问答等）\",\"icon\":\"zmdi zmdi-wikipedia\",\"name\":\"zheng-cms-admin\",\"orders\":2,\"status\":1,\"systemId\":2,\"theme\":\"#455EC5\",\"title\":\"内容管理系统\"},{\"banner\":\"/resources/zheng-admin/images/zheng-pay.png\",\"basepath\":\"http://pay.zhangshuzheng.cn:3331\",\"ctime\":3,\"description\":\"支付管理系统\",\"icon\":\"zmdi zmdi-paypal-alt\",\"name\":\"zheng-pay-admin\",\"orders\":3,\"status\":1,\"systemId\":3,\"theme\":\"#F06292\",\"title\":\"支付管理系统\"},{\"banner\":\"/resources/zheng-admin/images/zheng-ucenter.png\",\"basepath\":\"http://ucenter.zhangshuzheng.cn:4441\",\"ctime\":4,\"description\":\"用户管理系统\",\"icon\":\"zmdi zmdi-account\",\"name\":\"zheng-ucenter-home\",\"orders\":4,\"status\":1,\"systemId\":4,\"theme\":\"#6539B4\",\"title\":\"用户管理系统\"},{\"banner\":\"/resources/zheng-admin/images/zheng-oss.png\",\"basepath\":\"http://oss.zhangshuzheng.cn:7771\",\"ctime\":5,\"description\":\"存储管理系统\",\"icon\":\"zmdi zmdi-cloud\",\"name\":\"zheng-oss-web\",\"orders\":5,\"status\":1,\"systemId\":5,\"theme\":\"#0B8DE5\",\"title\":\"存储管理系统\"}]}', 'upms:system:read');
INSERT INTO `upms_log` VALUES (908, '组织首页', 'admin', 1520168552131, 21, 'http://upms.zhangshuzheng.cn:1111', '/manage/organization/index', 'http://upms.zhangshuzheng.cn:1111/manage/organization/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/organization/index.jsp\"', 'upms:organization:read');
INSERT INTO `upms_log` VALUES (909, '组织列表', 'admin', 1520168552944, 86, 'http://upms.zhangshuzheng.cn:1111', '/manage/organization/list', 'http://upms.zhangshuzheng.cn:1111/manage/organization/list', 'GET', 'order=asc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"total\":5,\"rows\":[{\"ctime\":1,\"description\":\"北京总部\",\"name\":\"总部\",\"organizationId\":1},{\"ctime\":1488122466236,\"description\":\"河北石家庄\",\"name\":\"河北分部\",\"organizationId\":4},{\"ctime\":1488122480265,\"description\":\"河南郑州\",\"name\":\"河南分部\",\"organizationId\":5},{\"ctime\":1488122493265,\"description\":\"湖北武汉\",\"name\":\"湖北分部\",\"organizationId\":6},{\"ctime\":1488122502752,\"description\":\"湖南长沙\",\"name\":\"湖南分部\",\"organizationId\":7}]}', 'upms:organization:read');
INSERT INTO `upms_log` VALUES (910, '新增组织', 'admin', 1520168556693, 1, 'http://upms.zhangshuzheng.cn:1111', '/manage/organization/create', 'http://upms.zhangshuzheng.cn:1111/manage/organization/create', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/organization/create.jsp\"', 'upms:organization:create');
INSERT INTO `upms_log` VALUES (911, '修改组织', 'admin', 1520168563364, 22, 'http://upms.zhangshuzheng.cn:1111', '/manage/organization/update/1', 'http://upms.zhangshuzheng.cn:1111/manage/organization/update/1', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/organization/update.jsp\"', 'upms:organization:update');
INSERT INTO `upms_log` VALUES (912, '权限首页', 'admin', 1520168573542, 17, 'http://upms.zhangshuzheng.cn:1111', '/manage/permission/index', 'http://upms.zhangshuzheng.cn:1111/manage/permission/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/permission/index.jsp\"', 'upms:permission:read');
INSERT INTO `upms_log` VALUES (913, '权限列表', 'admin', 1520168574365, 94, 'http://upms.zhangshuzheng.cn:1111', '/manage/permission/list', 'http://upms.zhangshuzheng.cn:1111/manage/permission/list', 'GET', 'order=asc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"total\":69,\"rows\":[{\"ctime\":1,\"icon\":\"zmdi zmdi-accounts-list\",\"name\":\"系统组织管理\",\"orders\":1,\"permissionId\":1,\"permissionValue\":\"\",\"pid\":0,\"status\":1,\"systemId\":1,\"type\":1,\"uri\":\"\"},{\"ctime\":2,\"icon\":\"\",\"name\":\"系统管理\",\"orders\":2,\"permissionId\":2,\"permissionValue\":\"upms:system:read\",\"pid\":1,\"status\":1,\"systemId\":1,\"type\":2,\"uri\":\"/manage/system/index\"},{\"ctime\":3,\"icon\":\"\",\"name\":\"组织管理\",\"orders\":3,\"permissionId\":3,\"permissionValue\":\"upms:organization:read\",\"pid\":1,\"status\":1,\"systemId\":1,\"type\":2,\"uri\":\"/manage/organization/index\"},{\"ctime\":4,\"icon\":\"zmdi zmdi-accounts\",\"name\":\"角色用户管理\",\"orders\":4,\"permissionId\":4,\"permissionValue\":\"\",\"pid\":0,\"status\":1,\"systemId\":1,\"type\":1,\"uri\":\"\"},{\"ctime\":6,\"icon\":\"\",\"name\":\"角色管理\",\"orders\":6,\"permissionId\":5,\"permissionValue\":\"upms:role:read\",\"pid\":4,\"status\":1,\"systemId\":1,\"type\":2,\"uri\":\"/manage/role/index\"},{\"ctime\":5,\"icon\":\"\",\"name\":\"用户管理\",\"orders\":5,\"permissionId\":6,\"permissionValue\":\"upms:user:read\",\"pid\":4,\"status\":1,\"systemId\":1,\"type\":2,\"uri\":\"/manage/user/index\"},{\"ctime\":7,\"icon\":\"zmdi zmdi-lock-outline\",\"name\":\"权限资源管理\",\"orders\":7,\"permissionId\":7,\"permissionValue\":\"\",\"pid\":0,\"status\":1,\"systemId\":1,\"type\":1,\"uri\":\"\"},{\"ctime\":12,\"icon\":\"zmdi zmdi-more\",\"name\":\"其他数据管理\",\"orders\":12,\"permissionId\":12,\"permissionValue\":\"\",\"pid\":0,\"status\":1,\"systemId\":1,\"type\":1,\"uri\":\"\"},{\"ctime\":14,\"icon\":\"\",\"name\":\"会话管理\",\"orders\":14,\"permissionId\":14,\"permissionValue\":\"upms:session:read\",\"pid\":12,\"status\":1,\"systemId\":1,\"type\":2,\"uri\":\"/manage/session/index\"},{\"ctime\":15,\"icon\":\"\",\"name\":\"日志记录\",\"orders\":15,\"permissionId\":15,\"permissionValue\":\"upms:log:read\",\"pid\":12,\"status\":1,\"systemId\":1,\"type\":2,\"uri\":\"/manage/log/index\"}]}', 'upms:permission:read');
INSERT INTO `upms_log` VALUES (914, '登录', '', 1520224133388, 783, 'http://upms.zhangshuzheng.cn:1111', '/sso/login', 'http://upms.zhangshuzheng.cn:1111/sso/login', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/sso/login.jsp\"', NULL);
INSERT INTO `upms_log` VALUES (915, '登录', 'admin', 1520224139370, 189, 'http://upms.zhangshuzheng.cn:1111', '/sso/login', 'http://upms.zhangshuzheng.cn:1111/sso/login', 'POST', '{password=[123456],rememberMe=[false],backurl=[],username=[admin]}', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"code\":1,\"data\":\"http://upms.zhangshuzheng.cn:1111\",\"message\":\"success\"}', NULL);
INSERT INTO `upms_log` VALUES (916, '后台首页', 'admin', 1520224140076, 118, 'http://upms.zhangshuzheng.cn:1111', '/manage/index', 'http://upms.zhangshuzheng.cn:1111/manage/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/index.jsp\"', NULL);
INSERT INTO `upms_log` VALUES (917, '登录', '', 1520227384701, 0, 'http://upms.zhangshuzheng.cn:1111', '/sso/login', 'http://upms.zhangshuzheng.cn:1111/sso/login', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/sso/login.jsp\"', NULL);
INSERT INTO `upms_log` VALUES (918, '登录', '', 1520227385028, 1, 'http://upms.zhangshuzheng.cn:1111', '/sso/login', 'http://upms.zhangshuzheng.cn:1111/sso/login', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/sso/login.jsp\"', NULL);
INSERT INTO `upms_log` VALUES (919, '登录', 'admin', 1520227387869, 26, 'http://upms.zhangshuzheng.cn:1111', '/sso/login', 'http://upms.zhangshuzheng.cn:1111/sso/login', 'POST', '{password=[123456],rememberMe=[false],backurl=[],username=[admin]}', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"code\":1,\"data\":\"http://upms.zhangshuzheng.cn:1111\",\"message\":\"success\"}', NULL);
INSERT INTO `upms_log` VALUES (920, '后台首页', 'admin', 1520227388000, 54, 'http://upms.zhangshuzheng.cn:1111', '/manage/index', 'http://upms.zhangshuzheng.cn:1111/manage/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/index.jsp\"', NULL);
INSERT INTO `upms_log` VALUES (921, '系统首页', 'admin', 1520227390199, 40, 'http://upms.zhangshuzheng.cn:1111', '/manage/system/index', 'http://upms.zhangshuzheng.cn:1111/manage/system/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/system/index.jsp\"', 'upms:system:read');
INSERT INTO `upms_log` VALUES (922, '系统列表', 'admin', 1520227392013, 41, 'http://upms.zhangshuzheng.cn:1111', '/manage/system/list', 'http://upms.zhangshuzheng.cn:1111/manage/system/list', 'GET', 'order=asc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"total\":5,\"rows\":[{\"banner\":\"/resources/zheng-admin/images/zheng-upms.png\",\"basepath\":\"http://upms.zhangshuzheng.cn:1111\",\"ctime\":1,\"description\":\"用户权限管理系统（RBAC细粒度用户权限、统一后台、单点登录、会话管理）\",\"icon\":\"zmdi zmdi-shield-security\",\"name\":\"zheng-upms-server\",\"orders\":1,\"status\":1,\"systemId\":1,\"theme\":\"#29A176\",\"title\":\"权限管理系统\"},{\"banner\":\"/resources/zheng-admin/images/zheng-cms.png\",\"basepath\":\"http://cms.zhangshuzheng.cn:2222\",\"ctime\":2,\"description\":\"内容管理系统（门户、博客、论坛、问答等）\",\"icon\":\"zmdi zmdi-wikipedia\",\"name\":\"zheng-cms-admin\",\"orders\":2,\"status\":1,\"systemId\":2,\"theme\":\"#455EC5\",\"title\":\"内容管理系统\"},{\"banner\":\"/resources/zheng-admin/images/zheng-pay.png\",\"basepath\":\"http://pay.zhangshuzheng.cn:3331\",\"ctime\":3,\"description\":\"支付管理系统\",\"icon\":\"zmdi zmdi-paypal-alt\",\"name\":\"zheng-pay-admin\",\"orders\":3,\"status\":1,\"systemId\":3,\"theme\":\"#F06292\",\"title\":\"支付管理系统\"},{\"banner\":\"/resources/zheng-admin/images/zheng-ucenter.png\",\"basepath\":\"http://ucenter.zhangshuzheng.cn:4441\",\"ctime\":4,\"description\":\"用户管理系统\",\"icon\":\"zmdi zmdi-account\",\"name\":\"zheng-ucenter-home\",\"orders\":4,\"status\":1,\"systemId\":4,\"theme\":\"#6539B4\",\"title\":\"用户管理系统\"},{\"banner\":\"/resources/zheng-admin/images/zheng-oss.png\",\"basepath\":\"http://oss.zhangshuzheng.cn:7771\",\"ctime\":5,\"description\":\"存储管理系统\",\"icon\":\"zmdi zmdi-cloud\",\"name\":\"zheng-oss-web\",\"orders\":5,\"status\":1,\"systemId\":5,\"theme\":\"#0B8DE5\",\"title\":\"存储管理系统\"}]}', 'upms:system:read');
INSERT INTO `upms_log` VALUES (923, '组织首页', 'admin', 1520227393089, 14, 'http://upms.zhangshuzheng.cn:1111', '/manage/organization/index', 'http://upms.zhangshuzheng.cn:1111/manage/organization/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/organization/index.jsp\"', 'upms:organization:read');
INSERT INTO `upms_log` VALUES (924, '组织列表', 'admin', 1520227393821, 42, 'http://upms.zhangshuzheng.cn:1111', '/manage/organization/list', 'http://upms.zhangshuzheng.cn:1111/manage/organization/list', 'GET', 'order=asc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"total\":5,\"rows\":[{\"ctime\":1,\"description\":\"北京总部\",\"name\":\"总部\",\"organizationId\":1},{\"ctime\":1488122466236,\"description\":\"河北石家庄\",\"name\":\"河北分部\",\"organizationId\":4},{\"ctime\":1488122480265,\"description\":\"河南郑州\",\"name\":\"河南分部\",\"organizationId\":5},{\"ctime\":1488122493265,\"description\":\"湖北武汉\",\"name\":\"湖北分部\",\"organizationId\":6},{\"ctime\":1488122502752,\"description\":\"湖南长沙\",\"name\":\"湖南分部\",\"organizationId\":7}]}', 'upms:organization:read');
INSERT INTO `upms_log` VALUES (925, '登录', '', 1520231996711, 23146, 'http://upms.zhangshuzheng.cn:1111', '/sso/login', 'http://upms.zhangshuzheng.cn:1111/sso/login', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/sso/login.jsp\"', NULL);
INSERT INTO `upms_log` VALUES (926, '登录', 'admin', 1520232078983, 276, 'http://upms.zhangshuzheng.cn:1111', '/sso/login', 'http://upms.zhangshuzheng.cn:1111/sso/login', 'POST', '{password=[123456],rememberMe=[false],backurl=[],username=[admin]}', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"code\":1,\"data\":\"http://upms.zhangshuzheng.cn:1111\",\"message\":\"success\"}', NULL);
INSERT INTO `upms_log` VALUES (927, '后台首页', 'admin', 1520232079553, 325, 'http://upms.zhangshuzheng.cn:1111', '/manage/index', 'http://upms.zhangshuzheng.cn:1111/manage/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/index.jsp\"', NULL);
INSERT INTO `upms_log` VALUES (928, '后台首页', 'admin', 1520232889715, 61, 'http://upms.zhangshuzheng.cn:1111', '/manage/index', 'http://upms.zhangshuzheng.cn:1111/manage/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/index.jsp\"', NULL);
INSERT INTO `upms_log` VALUES (929, '认证中心首页', 'admin', 1520232897131, 15, 'http://upms.zhangshuzheng.cn:1111', '/sso/index', 'http://upms.zhangshuzheng.cn:1111/sso/index', 'GET', 'appid=zheng-cms-admin&backurl=http%3A%2F%2Fcms.zhangshuzheng.cn%3A2222%2Fmanage%2Ftag%2Findex', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"redirect:/sso/login?backurl=http%3A%2F%2Fcms.zhangshuzheng.cn%3A2222%2Fmanage%2Ftag%2Findex\"', NULL);
INSERT INTO `upms_log` VALUES (930, '登录', 'admin', 1520232897479, 2, 'http://upms.zhangshuzheng.cn:1111', '/sso/login', 'http://upms.zhangshuzheng.cn:1111/sso/login', 'GET', 'backurl=http%3A%2F%2Fcms.zhangshuzheng.cn%3A2222%2Fmanage%2Ftag%2Findex', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"redirect:http://cms.zhangshuzheng.cn:2222/manage/tag/index?upms_code=0d8d7550-a4f0-486a-8e38-789f31155960&upms_username=admin\"', NULL);
INSERT INTO `upms_log` VALUES (931, '校验code', '', 1520232897939, 0, 'http://upms.zhangshuzheng.cn:1111', '/sso/code', 'http://upms.zhangshuzheng.cn:1111/sso/code', 'POST', '{code=[0d8d7550-a4f0-486a-8e38-789f31155960]}', 'Apache-HttpClient/4.5.2 (Java/1.8.0_161)', '127.0.0.1', '{\"code\":1,\"data\":\"0d8d7550-a4f0-486a-8e38-789f31155960\",\"message\":\"success\"}', NULL);
INSERT INTO `upms_log` VALUES (932, '评论首页', 'admin', 1520232898455, 16, 'http://cms.zhangshuzheng.cn:2222', '/manage/tag/index', 'http://cms.zhangshuzheng.cn:2222/manage/tag/index', 'GET', 'upms_code=0d8d7550-a4f0-486a-8e38-789f31155960&upms_username=admin', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/tag/index.jsp\"', 'cms:tag:read');
INSERT INTO `upms_log` VALUES (933, '评论首页', 'admin', 1520232900543, 0, 'http://cms.zhangshuzheng.cn:2222', '/manage/tag/index', 'http://cms.zhangshuzheng.cn:2222/manage/tag/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/tag/index.jsp\"', 'cms:tag:read');
INSERT INTO `upms_log` VALUES (934, '评论列表', 'admin', 1520232902146, 599, 'http://cms.zhangshuzheng.cn:2222', '/manage/tag/list', 'http://cms.zhangshuzheng.cn:2222/manage/tag/list', 'GET', 'order=asc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"rows\":[{\"alias\":\"java\",\"ctime\":1489585694864,\"description\":\"java标签\",\"icon\":\"\",\"name\":\"JAVA\",\"orders\":1489585694864,\"systemId\":1,\"tagId\":1,\"type\":1},{\"alias\":\"android\",\"ctime\":1489585720382,\"description\":\"android标签\",\"icon\":\"\",\"name\":\"Android\",\"orders\":1489585720382,\"systemId\":1,\"tagId\":2,\"type\":1},{\"alias\":\"zheng\",\"ctime\":1489585815042,\"description\":\"zheng标签\",\"icon\":\"\",\"name\":\"zheng\",\"orders\":1489585815042,\"systemId\":1,\"tagId\":3,\"type\":2},{\"alias\":\"love\",\"ctime\":1489585815043,\"description\":\"谈恋爱标签\",\"icon\":\"\",\"name\":\"谈恋爱\",\"orders\":1489585815043,\"systemId\":2,\"tagId\":4,\"type\":1},{\"alias\":\"java\",\"ctime\":1489585815044,\"description\":\"java标签\",\"icon\":\"\",\"name\":\"java\",\"orders\":1489585815044,\"systemId\":3,\"tagId\":5,\"type\":1}],\"total\":5}', 'cms:tag:read');
INSERT INTO `upms_log` VALUES (935, '类目首页', 'admin', 1520232911832, 74, 'http://cms.zhangshuzheng.cn:2222', '/manage/category/index', 'http://cms.zhangshuzheng.cn:2222/manage/category/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/category/index.jsp\"', 'cms:category:read');
INSERT INTO `upms_log` VALUES (936, '类目列表', 'admin', 1520232913123, 139, 'http://cms.zhangshuzheng.cn:2222', '/manage/category/list', 'http://cms.zhangshuzheng.cn:2222/manage/category/list', 'GET', 'order=asc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"rows\":[{\"alias\":\"economic\",\"categoryId\":5,\"ctime\":1489590733919,\"description\":\"经济类目\",\"icon\":\"\",\"level\":1,\"name\":\"经济\",\"orders\":1489590733919,\"systemId\":1,\"type\":1},{\"alias\":\"chinaeconomic\",\"categoryId\":6,\"ctime\":1489590768989,\"description\":\"中国经济类目\",\"icon\":\"\",\"level\":2,\"name\":\"中国经济\",\"orders\":1489590768989,\"pid\":5,\"systemId\":1,\"type\":1},{\"alias\":\"japaneconomic\",\"categoryId\":7,\"ctime\":1491636586316,\"description\":\"日本经济类目\",\"icon\":\"\",\"level\":2,\"name\":\"日本经济\",\"orders\":1491636586316,\"pid\":5,\"systemId\":1,\"type\":1},{\"alias\":\"people\",\"categoryId\":8,\"ctime\":1491636586317,\"description\":\"人类问题\",\"icon\":\"\",\"level\":1,\"name\":\"人类\",\"orders\":1491636586317,\"systemId\":2,\"type\":1},{\"alias\":\"technic\",\"categoryId\":9,\"ctime\":1491636586318,\"description\":\"技术博文\",\"level\":1,\"name\":\"技术\",\"orders\":1491636586318,\"systemId\":3,\"type\":1}],\"total\":5}', 'cms:category:read');
INSERT INTO `upms_log` VALUES (937, '文章首页', 'admin', 1520232954639, 15, 'http://cms.zhangshuzheng.cn:2222', '/manage/article/index', 'http://cms.zhangshuzheng.cn:2222/manage/article/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/article/index.jsp\"', 'cms:article:read');
INSERT INTO `upms_log` VALUES (938, '文章列表', 'admin', 1520232955704, 199, 'http://cms.zhangshuzheng.cn:2222', '/manage/article/list', 'http://cms.zhangshuzheng.cn:2222/manage/article/list', 'GET', 'sort=orders&order=desc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"rows\":[{\"allowcomments\":1,\"articleId\":20,\"author\":\"test\",\"ctime\":1490460800636,\"description\":\"test\",\"fromurl\":\"test\",\"image\":\"test\",\"keywords\":\"test\",\"orders\":1490460800636,\"readnumber\":0,\"status\":1,\"systemId\":3,\"title\":\"java开发笔记\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":19,\"author\":\"test\",\"ctime\":1490460800635,\"description\":\"test\",\"fromurl\":\"test\",\"image\":\"test\",\"keywords\":\"test\",\"orders\":1490460800635,\"readnumber\":0,\"status\":1,\"systemId\":2,\"title\":\"人为什么谈恋爱？\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":18,\"author\":\"13\",\"ctime\":1490460800634,\"description\":\"13\",\"fromurl\":\"13\",\"image\":\"13\",\"keywords\":\"13\",\"orders\":1490460800634,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题13\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":17,\"author\":\"12\",\"ctime\":1490460792501,\"description\":\"12\",\"fromurl\":\"12\",\"image\":\"12\",\"keywords\":\"12\",\"orders\":1490460792501,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题12\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":16,\"author\":\"11\",\"ctime\":1490460782767,\"description\":\"11\",\"fromurl\":\"11\",\"image\":\"11\",\"keywords\":\"11\",\"orders\":1490460782767,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题11\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":15,\"author\":\"10\",\"ctime\":1490460612370,\"description\":\"10\",\"fromurl\":\"10\",\"image\":\"10\",\"keywords\":\"10\",\"orders\":1490460612370,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题10\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":14,\"author\":\"9\",\"ctime\":1490460596394,\"description\":\"9\",\"fromurl\":\"9\",\"image\":\"9\",\"keywords\":\"9\",\"orders\":1490460596394,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题9\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":13,\"author\":\"8\",\"ctime\":1490460588840,\"description\":\"8\",\"fromurl\":\"8\",\"image\":\"8\",\"keywords\":\"8\",\"orders\":1490460588840,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题8\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":12,\"author\":\"7\",\"ctime\":1490460582004,\"description\":\"7\",\"fromurl\":\"7\",\"image\":\"7\",\"keywords\":\"7\",\"orders\":1490460582004,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题7\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":11,\"author\":\"6\",\"ctime\":1490460575304,\"description\":\"6\",\"fromurl\":\"6\",\"image\":\"6\",\"keywords\":\"6\",\"orders\":1490460575304,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题6\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1}],\"total\":16}', 'cms:article:read');
INSERT INTO `upms_log` VALUES (939, '修改文章', 'admin', 1520232970406, 134, 'http://cms.zhangshuzheng.cn:2222', '/manage/article/update/20', 'http://cms.zhangshuzheng.cn:2222/manage/article/update/20', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/article/update.jsp\"', 'cms:article:update');
INSERT INTO `upms_log` VALUES (940, '修改文章', 'admin', 1520232976710, 143, 'http://cms.zhangshuzheng.cn:2222', '/manage/article/update/20', 'http://cms.zhangshuzheng.cn:2222/manage/article/update/20', 'POST', '{image=[test],systemId=[3],keywords=[test],author=[test],description=[test],title=[java开发笔记],type=[1],userId=[1],content=[好记性不如烂笔头],allowcomments=[1],topicId=[0],fromurl=[test],status=[1]}', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"code\":1,\"data\":1,\"message\":\"success\"}', 'cms:article:update');
INSERT INTO `upms_log` VALUES (941, '文章列表', 'admin', 1520232976998, 66, 'http://cms.zhangshuzheng.cn:2222', '/manage/article/list', 'http://cms.zhangshuzheng.cn:2222/manage/article/list', 'GET', 'sort=orders&order=desc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"rows\":[{\"allowcomments\":1,\"articleId\":20,\"author\":\"test\",\"ctime\":1490460800636,\"description\":\"test\",\"fromurl\":\"test\",\"image\":\"test\",\"keywords\":\"test\",\"orders\":1490460800636,\"readnumber\":0,\"status\":1,\"systemId\":3,\"title\":\"java开发笔记\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":19,\"author\":\"test\",\"ctime\":1490460800635,\"description\":\"test\",\"fromurl\":\"test\",\"image\":\"test\",\"keywords\":\"test\",\"orders\":1490460800635,\"readnumber\":0,\"status\":1,\"systemId\":2,\"title\":\"人为什么谈恋爱？\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":18,\"author\":\"13\",\"ctime\":1490460800634,\"description\":\"13\",\"fromurl\":\"13\",\"image\":\"13\",\"keywords\":\"13\",\"orders\":1490460800634,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题13\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":17,\"author\":\"12\",\"ctime\":1490460792501,\"description\":\"12\",\"fromurl\":\"12\",\"image\":\"12\",\"keywords\":\"12\",\"orders\":1490460792501,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题12\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":16,\"author\":\"11\",\"ctime\":1490460782767,\"description\":\"11\",\"fromurl\":\"11\",\"image\":\"11\",\"keywords\":\"11\",\"orders\":1490460782767,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题11\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":15,\"author\":\"10\",\"ctime\":1490460612370,\"description\":\"10\",\"fromurl\":\"10\",\"image\":\"10\",\"keywords\":\"10\",\"orders\":1490460612370,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题10\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":14,\"author\":\"9\",\"ctime\":1490460596394,\"description\":\"9\",\"fromurl\":\"9\",\"image\":\"9\",\"keywords\":\"9\",\"orders\":1490460596394,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题9\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":13,\"author\":\"8\",\"ctime\":1490460588840,\"description\":\"8\",\"fromurl\":\"8\",\"image\":\"8\",\"keywords\":\"8\",\"orders\":1490460588840,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题8\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":12,\"author\":\"7\",\"ctime\":1490460582004,\"description\":\"7\",\"fromurl\":\"7\",\"image\":\"7\",\"keywords\":\"7\",\"orders\":1490460582004,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题7\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":11,\"author\":\"6\",\"ctime\":1490460575304,\"description\":\"6\",\"fromurl\":\"6\",\"image\":\"6\",\"keywords\":\"6\",\"orders\":1490460575304,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题6\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1}],\"total\":16}', 'cms:article:read');
INSERT INTO `upms_log` VALUES (942, '文章列表', 'admin', 1520232983645, 23, 'http://cms.zhangshuzheng.cn:2222', '/manage/article/list', 'http://cms.zhangshuzheng.cn:2222/manage/article/list', 'GET', 'sort=orders&order=desc&offset=10&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"rows\":[{\"allowcomments\":1,\"articleId\":10,\"author\":\"5\",\"ctime\":1490460567137,\"description\":\"5\",\"fromurl\":\"5\",\"image\":\"5\",\"keywords\":\"5\",\"orders\":1490460567137,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题5\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":9,\"author\":\"4\",\"ctime\":1490460546198,\"description\":\"4\",\"fromurl\":\"4\",\"image\":\"4\",\"keywords\":\"4\",\"orders\":1490460546198,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题4\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":8,\"author\":\"shuzheng\",\"ctime\":1489845594355,\"description\":\"日本从地震中消失\",\"fromurl\":\"网络\",\"image\":\"\",\"keywords\":\"日本消失,日本地震\",\"orders\":1489845594355,\"readnumber\":12,\"status\":1,\"systemId\":1,\"title\":\"日本从地球消失，我们倍(喜)感(大)心(普)痛(奔)\",\"top\":0,\"topicId\":1,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":5,\"author\":\"3\",\"ctime\":1489827581414,\"description\":\"3\",\"fromurl\":\"3\",\"image\":\"3\",\"keywords\":\"3\",\"orders\":1489827581414,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题3\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":4,\"author\":\"2\",\"ctime\":1489827340870,\"description\":\"2\",\"fromurl\":\"2\",\"image\":\"2\",\"keywords\":\"2\",\"orders\":1489827340870,\"readnumber\":0,\"status\":-1,\"systemId\":1,\"title\":\"中国经济标题2\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":3,\"author\":\"1\",\"ctime\":1489827019528,\"description\":\"1\",\"fromurl\":\"1\",\"image\":\"1\",\"keywords\":\"1\",\"orders\":1489827019528,\"readnumber\":0,\"status\":0,\"systemId\":1,\"title\":\"中国经济标题1\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1}],\"total\":16}', 'cms:article:read');
INSERT INTO `upms_log` VALUES (943, '评论首页', 'admin', 1520233344148, 24, 'http://cms.zhangshuzheng.cn:2222', '/manage/page/index', 'http://cms.zhangshuzheng.cn:2222/manage/page/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/page/index.jsp\"', 'cms:page:read');
INSERT INTO `upms_log` VALUES (944, '评论列表', 'admin', 1520233345175, 100, 'http://cms.zhangshuzheng.cn:2222', '/manage/page/list', 'http://cms.zhangshuzheng.cn:2222/manage/page/list', 'GET', 'order=asc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"rows\":[{\"alias\":\"about\",\"ctime\":1489839705049,\"description\":\"单页描述\",\"keywords\":\"单页关键字\",\"orders\":1489839705049,\"pageId\":1,\"title\":\"关于\"}],\"total\":1}', 'cms:page:read');
INSERT INTO `upms_log` VALUES (945, '评论首页', 'admin', 1520233347287, 22, 'http://cms.zhangshuzheng.cn:2222', '/manage/topic/index', 'http://cms.zhangshuzheng.cn:2222/manage/topic/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/topic/index.jsp\"', 'cms:topic:read');
INSERT INTO `upms_log` VALUES (946, '评论列表', 'admin', 1520233348092, 26, 'http://cms.zhangshuzheng.cn:2222', '/manage/topic/list', 'http://cms.zhangshuzheng.cn:2222/manage/topic/list', 'GET', 'order=asc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"rows\":[{\"ctime\":1489843484448,\"description\":\"日本经历灭国性地震，彻底沉入海底\",\"title\":\"日本地震专题\",\"topicId\":1,\"url\":\"/topic/1\"}],\"total\":1}', 'cms:topic:read');
INSERT INTO `upms_log` VALUES (947, '新增文章', 'admin', 1520233351366, 19, 'http://cms.zhangshuzheng.cn:2222', '/manage/article/create', 'http://cms.zhangshuzheng.cn:2222/manage/article/create', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/article/create.jsp\"', 'cms:article:create');
INSERT INTO `upms_log` VALUES (948, '新增文章', 'admin', 1520233361158, 7, 'http://cms.zhangshuzheng.cn:2222', '/manage/article/create', 'http://cms.zhangshuzheng.cn:2222/manage/article/create', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/article/create.jsp\"', 'cms:article:create');
INSERT INTO `upms_log` VALUES (949, '评论首页', 'admin', 1520233375354, 14, 'http://cms.zhangshuzheng.cn:2222', '/manage/comment/index', 'http://cms.zhangshuzheng.cn:2222/manage/comment/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/comment/index.jsp\"', 'cms:comment:read');
INSERT INTO `upms_log` VALUES (950, '评论列表', 'admin', 1520233376243, 105, 'http://cms.zhangshuzheng.cn:2222', '/manage/comment/list', 'http://cms.zhangshuzheng.cn:2222/manage/comment/list', 'GET', 'order=desc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"rows\":[{\"agent\":\"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36\",\"articleId\":8,\"commentId\":1,\"content\":\"1\",\"ctime\":1490535749413,\"ip\":\"127.0.0.1\",\"status\":1,\"systemId\":1,\"userId\":1},{\"agent\":\"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36\",\"articleId\":8,\"commentId\":2,\"content\":\"2\",\"ctime\":1490536186447,\"ip\":\"127.0.0.1\",\"status\":1,\"systemId\":1,\"userId\":1},{\"agent\":\"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36\",\"articleId\":8,\"commentId\":3,\"content\":\"3\",\"ctime\":1490536192205,\"ip\":\"127.0.0.1\",\"status\":1,\"systemId\":1,\"userId\":1},{\"agent\":\"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36\",\"articleId\":8,\"commentId\":4,\"content\":\"4\",\"ctime\":1490536460544,\"ip\":\"127.0.0.1\",\"status\":1,\"systemId\":1,\"userId\":1},{\"agent\":\"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36\",\"articleId\":8,\"commentId\":5,\"content\":\"5\",\"ctime\":1490536462182,\"ip\":\"127.0.0.1\",\"status\":1,\"systemId\":1,\"userId\":1},{\"agent\":\"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36\",\"articleId\":8,\"commentId\":6,\"content\":\"6\",\"ctime\":1490536463614,\"ip\":\"127.0.0.1\",\"status\":1,\"systemId\":1,\"userId\":1},{\"agent\":\"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36\",\"articleId\":8,\"commentId\":7,\"content\":\"7\",\"ctime\":1490536464870,\"ip\":\"127.0.0.1\",\"status\":1,\"systemId\":1,\"userId\":1},{\"agent\":\"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36\",\"articleId\":8,\"commentId\":8,\"content\":\"8\",\"ctime\":1490536465926,\"ip\":\"127.0.0.1\",\"status\":1,\"systemId\":1,\"userId\":1},{\"agent\":\"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36\",\"articleId\":8,\"commentId\":9,\"content\":\"9\",\"ctime\":1490536466853,\"ip\":\"127.0.0.1\",\"status\":1,\"systemId\":1,\"userId\":1},{\"agent\":\"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36\",\"articleId\":8,\"commentId\":10,\"content\":\"10\",\"ctime\":1490536467821,\"ip\":\"127.0.0.1\",\"status\":1,\"systemId\":1,\"userId\":1}],\"total\":16}', 'cms:comment:read');
INSERT INTO `upms_log` VALUES (951, '后台首页', 'admin', 1520233395128, 48, 'http://upms.zhangshuzheng.cn:1111', '/manage/index', 'http://upms.zhangshuzheng.cn:1111/manage/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/index.jsp\"', NULL);
INSERT INTO `upms_log` VALUES (952, '文章首页', 'admin', 1520233399092, 0, 'http://cms.zhangshuzheng.cn:2222', '/manage/article/index', 'http://cms.zhangshuzheng.cn:2222/manage/article/index', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/article/index.jsp\"', 'cms:article:read');
INSERT INTO `upms_log` VALUES (953, '文章列表', 'admin', 1520233399593, 31, 'http://cms.zhangshuzheng.cn:2222', '/manage/article/list', 'http://cms.zhangshuzheng.cn:2222/manage/article/list', 'GET', 'sort=orders&order=desc&offset=0&limit=10', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '{\"rows\":[{\"allowcomments\":1,\"articleId\":20,\"author\":\"test\",\"ctime\":1490460800636,\"description\":\"test\",\"fromurl\":\"test\",\"image\":\"test\",\"keywords\":\"test\",\"orders\":1490460800636,\"readnumber\":0,\"status\":1,\"systemId\":3,\"title\":\"java开发笔记\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":19,\"author\":\"test\",\"ctime\":1490460800635,\"description\":\"test\",\"fromurl\":\"test\",\"image\":\"test\",\"keywords\":\"test\",\"orders\":1490460800635,\"readnumber\":0,\"status\":1,\"systemId\":2,\"title\":\"人为什么谈恋爱？\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":18,\"author\":\"13\",\"ctime\":1490460800634,\"description\":\"13\",\"fromurl\":\"13\",\"image\":\"13\",\"keywords\":\"13\",\"orders\":1490460800634,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题13\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":17,\"author\":\"12\",\"ctime\":1490460792501,\"description\":\"12\",\"fromurl\":\"12\",\"image\":\"12\",\"keywords\":\"12\",\"orders\":1490460792501,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题12\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":16,\"author\":\"11\",\"ctime\":1490460782767,\"description\":\"11\",\"fromurl\":\"11\",\"image\":\"11\",\"keywords\":\"11\",\"orders\":1490460782767,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题11\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":15,\"author\":\"10\",\"ctime\":1490460612370,\"description\":\"10\",\"fromurl\":\"10\",\"image\":\"10\",\"keywords\":\"10\",\"orders\":1490460612370,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题10\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":14,\"author\":\"9\",\"ctime\":1490460596394,\"description\":\"9\",\"fromurl\":\"9\",\"image\":\"9\",\"keywords\":\"9\",\"orders\":1490460596394,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题9\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":13,\"author\":\"8\",\"ctime\":1490460588840,\"description\":\"8\",\"fromurl\":\"8\",\"image\":\"8\",\"keywords\":\"8\",\"orders\":1490460588840,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题8\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":12,\"author\":\"7\",\"ctime\":1490460582004,\"description\":\"7\",\"fromurl\":\"7\",\"image\":\"7\",\"keywords\":\"7\",\"orders\":1490460582004,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题7\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1},{\"allowcomments\":1,\"articleId\":11,\"author\":\"6\",\"ctime\":1490460575304,\"description\":\"6\",\"fromurl\":\"6\",\"image\":\"6\",\"keywords\":\"6\",\"orders\":1490460575304,\"readnumber\":0,\"status\":1,\"systemId\":1,\"title\":\"中国经济标题6\",\"top\":0,\"topicId\":0,\"type\":1,\"userId\":1}],\"total\":16}', 'cms:article:read');
INSERT INTO `upms_log` VALUES (954, '修改文章', 'admin', 1520233441164, 52, 'http://cms.zhangshuzheng.cn:2222', '/manage/article/update/20', 'http://cms.zhangshuzheng.cn:2222/manage/article/update/20', 'GET', NULL, 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '127.0.0.1', '\"/manage/article/update.jsp\"', 'cms:article:update');

-- ----------------------------
-- Table structure for upms_organization
-- ----------------------------
DROP TABLE IF EXISTS `upms_organization`;
CREATE TABLE `upms_organization`  (
  `organization_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `pid` int(10) NULL DEFAULT NULL COMMENT '所属上级',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '组织名称',
  `description` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '组织描述',
  `ctime` bigint(20) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`organization_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '组织' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of upms_organization
-- ----------------------------
INSERT INTO `upms_organization` VALUES (1, NULL, '总部', '北京总部', 1);
INSERT INTO `upms_organization` VALUES (4, NULL, '河北分部', '河北石家庄', 1488122466236);
INSERT INTO `upms_organization` VALUES (5, NULL, '河南分部', '河南郑州', 1488122480265);
INSERT INTO `upms_organization` VALUES (6, NULL, '湖北分部', '湖北武汉', 1488122493265);
INSERT INTO `upms_organization` VALUES (7, NULL, '湖南分部', '湖南长沙', 1488122502752);

-- ----------------------------
-- Table structure for upms_permission
-- ----------------------------
DROP TABLE IF EXISTS `upms_permission`;
CREATE TABLE `upms_permission`  (
  `permission_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `system_id` int(10) UNSIGNED NOT NULL COMMENT '所属系统',
  `pid` int(10) NULL DEFAULT NULL COMMENT '所属上级',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
  `type` tinyint(4) NULL DEFAULT NULL COMMENT '类型(1:目录,2:菜单,3:按钮)',
  `permission_value` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限值',
  `uri` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '路径',
  `icon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图标',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '状态(0:禁止,1:正常)',
  `ctime` bigint(20) NULL DEFAULT NULL COMMENT '创建时间',
  `orders` bigint(20) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`permission_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 88 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '权限' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of upms_permission
-- ----------------------------
INSERT INTO `upms_permission` VALUES (1, 1, 0, '系统组织管理', 1, '', '', 'zmdi zmdi-accounts-list', 1, 1, 1);
INSERT INTO `upms_permission` VALUES (2, 1, 1, '系统管理', 2, 'upms:system:read', '/sys/upmsSystem/index', '', 1, 2, 2);
INSERT INTO `upms_permission` VALUES (3, 1, 1, '组织管理', 2, 'upms:organization:read', '/sys/upmsOrganization/index', '', 1, 3, 3);
INSERT INTO `upms_permission` VALUES (4, 1, 0, '角色用户管理', 1, '', '', 'zmdi zmdi-accounts', 1, 4, 4);
INSERT INTO `upms_permission` VALUES (5, 1, 4, '角色管理', 2, 'upms:role:read', '/sys/upmsRole/index', '', 1, 6, 6);
INSERT INTO `upms_permission` VALUES (6, 1, 4, '用户管理', 2, 'upms:user:read', '/sys/upmsUser/index', '', 1, 5, 5);
INSERT INTO `upms_permission` VALUES (7, 1, 0, '权限资源管理', 1, '', '', 'zmdi zmdi-lock-outline', 1, 7, 7);
INSERT INTO `upms_permission` VALUES (12, 1, 0, '其他数据管理', 1, '', '', 'zmdi zmdi-more', 1, 12, 12);
INSERT INTO `upms_permission` VALUES (14, 1, 12, '会话管理', 2, 'upms:session:read', '/sys/upmsSession/index', '', 1, 14, 14);
INSERT INTO `upms_permission` VALUES (15, 1, 12, '日志记录', 2, 'upms:log:read', '/sys/upmsLog/index', '', 1, 15, 15);
INSERT INTO `upms_permission` VALUES (17, 2, 0, '标签类目管理', 1, NULL, NULL, 'zmdi zmdi-menu', 1, 17, 17);
INSERT INTO `upms_permission` VALUES (18, 2, 17, '标签管理', 2, 'cms:tag:read', '/manage/tag/index', NULL, 1, 18, 18);
INSERT INTO `upms_permission` VALUES (19, 2, 17, '类目管理', 2, 'cms:category:read', '/manage/category/index', NULL, 1, 19, 19);
INSERT INTO `upms_permission` VALUES (20, 2, 0, '文章评论管理', 1, NULL, NULL, 'zmdi zmdi-collection-text', 1, 20, 20);
INSERT INTO `upms_permission` VALUES (21, 2, 20, '文章管理', 2, 'cms:article:read', '/manage/article/index', NULL, 1, 21, 21);
INSERT INTO `upms_permission` VALUES (22, 2, 20, '回收管理', 2, 'cms:article:read', '/manage/article/recycle', NULL, 1, 22, 22);
INSERT INTO `upms_permission` VALUES (24, 1, 2, '新增系统', 3, 'upms:system:create', '/manage/system/create', 'zmdi zmdi-plus', 1, 24, 24);
INSERT INTO `upms_permission` VALUES (25, 1, 2, '编辑系统', 3, 'upms:system:update', '/manage/system/update', 'zmdi zmdi-edit', 1, 25, 25);
INSERT INTO `upms_permission` VALUES (26, 1, 2, '删除系统', 3, 'upms:system:delete', '/manage/system/delete', 'zmdi zmdi-close', 1, 26, 26);
INSERT INTO `upms_permission` VALUES (27, 1, 3, '新增组织', 3, 'upms:organization:create', '/manage/organization/create', 'zmdi zmdi-plus', 1, 27, 27);
INSERT INTO `upms_permission` VALUES (28, 1, 3, '编辑组织', 3, 'upms:organization:update', '/manage/organization/update', 'zmdi zmdi-edit', 1, 28, 28);
INSERT INTO `upms_permission` VALUES (29, 1, 3, '删除组织', 3, 'upms:organization:delete', '/manage/organization/delete', 'zmdi zmdi-close', 1, 29, 29);
INSERT INTO `upms_permission` VALUES (30, 1, 6, '新增用户', 3, 'upms:user:create', '/manage/user/create', 'zmdi zmdi-plus', 1, 30, 30);
INSERT INTO `upms_permission` VALUES (31, 1, 6, '编辑用户', 3, 'upms:user:update', '/manage/user/update', 'zmdi zmdi-edit', 1, 31, 31);
INSERT INTO `upms_permission` VALUES (32, 1, 6, '删除用户', 3, 'upms:user:delete', '/manage/user/delete', 'zmdi zmdi-close', 1, 32, 32);
INSERT INTO `upms_permission` VALUES (33, 1, 5, '新增角色', 3, 'upms:role:create', '/manage/role/create', 'zmdi zmdi-plus', 1, 33, 33);
INSERT INTO `upms_permission` VALUES (34, 1, 5, '编辑角色', 3, 'upms:role:update', '/manage/role/update', 'zmdi zmdi-edit', 1, 34, 34);
INSERT INTO `upms_permission` VALUES (35, 1, 5, '删除角色', 3, 'upms:role:delete', '/manage/role/delete', 'zmdi zmdi-close', 1, 35, 35);
INSERT INTO `upms_permission` VALUES (36, 1, 39, '新增权限', 3, 'upms:permission:create', '/manage/permission/create', 'zmdi zmdi-plus', 1, 36, 36);
INSERT INTO `upms_permission` VALUES (37, 1, 39, '编辑权限', 3, 'upms:permission:update', '/manage/permission/update', 'zmdi zmdi-edit', 1, 37, 37);
INSERT INTO `upms_permission` VALUES (38, 1, 39, '删除权限', 3, 'upms:permission:delete', '/manage/permission/delete', 'zmdi zmdi-close', 1, 38, 38);
INSERT INTO `upms_permission` VALUES (39, 1, 7, '权限管理', 2, 'upms:permission:read', '/sys/upmsPermission/index', NULL, 1, 39, 39);
INSERT INTO `upms_permission` VALUES (46, 1, 5, '角色权限', 3, 'upms:role:permission', '/manage/role/permission', 'zmdi zmdi-key', 1, 1488091928257, 1488091928257);
INSERT INTO `upms_permission` VALUES (48, 1, 6, '用户组织', 3, 'upms:user:organization', '/manage/user/organization', 'zmdi zmdi-accounts-list', 1, 1488120011165, 1488120011165);
INSERT INTO `upms_permission` VALUES (50, 1, 6, '用户角色', 3, 'upms:user:role', '/manage/user/role', 'zmdi zmdi-accounts', 1, 1488120554175, 1488120554175);
INSERT INTO `upms_permission` VALUES (51, 1, 6, '用户权限', 3, 'upms:user:permission', '/manage/user/permission', 'zmdi zmdi-key', 1, 1488092013302, 1488092013302);
INSERT INTO `upms_permission` VALUES (53, 1, 14, '强制退出', 3, 'upms:session:forceout', '/manage/session/forceout', 'zmdi zmdi-run', 1, 1488379514715, 1488379514715);
INSERT INTO `upms_permission` VALUES (54, 2, 18, '新增标签', 3, 'cms:tag:create', '/manage/tag/create', 'zmdi zmdi-plus', 1, 1489417315159, 1489417315159);
INSERT INTO `upms_permission` VALUES (55, 2, 18, '编辑标签', 3, 'cms:tag:update', 'zmdi zmdi-edit', 'zmdi zmdi-widgets', 1, 1489417344931, 1489417344931);
INSERT INTO `upms_permission` VALUES (56, 2, 18, '删除标签', 3, 'cms:tag:delete', '/manage/tag/delete', 'zmdi zmdi-close', 1, 1489417372114, 1489417372114);
INSERT INTO `upms_permission` VALUES (57, 1, 15, '删除权限', 3, 'upms:log:delete', '/manage/log/delete', 'zmdi zmdi-close', 1, 1489503867909, 1489503867909);
INSERT INTO `upms_permission` VALUES (58, 2, 19, '编辑类目', 3, 'cms:category:update', '/manage/category/update', 'zmdi zmdi-edit', 1, 1489586600462, 1489586600462);
INSERT INTO `upms_permission` VALUES (59, 2, 19, '删除类目', 3, 'cms:category:delete', '/manage/category/delete', 'zmdi zmdi-close', 1, 1489586633059, 1489586633059);
INSERT INTO `upms_permission` VALUES (60, 2, 19, '新增类目', 3, 'cms:category:create', '/manage/category/create', 'zmdi zmdi-plus', 1, 1489590342089, 1489590342089);
INSERT INTO `upms_permission` VALUES (61, 2, 0, '其他数据管理', 1, '', '', 'zmdi zmdi-more', 1, 1489835455359, 1489835455359);
INSERT INTO `upms_permission` VALUES (62, 2, 20, '评论管理', 2, 'cms:comment:read', '/manage/comment/index', '', 1, 1489591408224, 1489591408224);
INSERT INTO `upms_permission` VALUES (63, 2, 62, '删除评论', 3, 'cms:comment:delete', '/manage/comment/delete', 'zmdi zmdi-close', 1, 1489591449614, 1489591449614);
INSERT INTO `upms_permission` VALUES (64, 2, 79, '单页管理', 2, 'cms:page:read', '/manage/page/index', '', 1, 1489591332779, 1489591332779);
INSERT INTO `upms_permission` VALUES (65, 2, 64, '新增单页', 3, 'cms:page:create', '/manage/page/create', 'zmdi zmdi-plus', 1, 1489591614473, 1489591614473);
INSERT INTO `upms_permission` VALUES (66, 2, 64, '编辑单页', 3, 'cms:page:update', '/manage/page/update', 'zmdi zmdi-edit', 1, 1489591653000, 1489591653000);
INSERT INTO `upms_permission` VALUES (67, 2, 64, '删除单页', 3, 'cms:page:delete', '/manage/page/delete', 'zmdi zmdi-close', 1, 1489591683552, 1489591683552);
INSERT INTO `upms_permission` VALUES (68, 2, 61, '菜单管理', 2, 'cms:menu:read', '/manage/menu/index', 'zmdi zmdi-widgets', 1, 1489591746846, 1489591746846);
INSERT INTO `upms_permission` VALUES (69, 2, 68, '新增菜单', 3, 'cms:menu:create', '/manage/menu/create', 'zmdi zmdi-plus', 1, 1489591791747, 1489591791747);
INSERT INTO `upms_permission` VALUES (70, 2, 68, '编辑菜单', 3, 'cms:menu:update', '/manage/menu/update', 'zmdi zmdi-edit', 1, 1489591831878, 1489591831878);
INSERT INTO `upms_permission` VALUES (71, 2, 68, '删除菜单', 3, 'cms:menu:delete', '/manage/menu/delete', 'zmdi zmdi-close', 1, 1489591865454, 1489591865454);
INSERT INTO `upms_permission` VALUES (72, 2, 61, '系统设置', 2, 'cms:setting:read', '/manage/setting/index', 'zmdi zmdi-widgets', 1, 1489591981165, 1489591981165);
INSERT INTO `upms_permission` VALUES (73, 2, 72, '新增设置', 3, 'cms:setting:create', '/manage/setting/create', 'zmdi zmdi-plus', 1, 1489592024762, 1489592024762);
INSERT INTO `upms_permission` VALUES (74, 2, 72, '编辑设置', 3, 'cms:setting:update', '/manage/setting/update', 'zmdi zmdi-edit', 1, 1489592052582, 1489592052582);
INSERT INTO `upms_permission` VALUES (75, 2, 72, '删除设置', 3, 'cms:setting:delete', '/manage/setting/delete', 'zmdi zmdi-close', 1, 1489592081426, 1489592081426);
INSERT INTO `upms_permission` VALUES (76, 2, 21, '新增文章', 3, 'cms:article:create', '/manage/article/create', 'zmdi zmdi-plus', 1, 1489820150404, 1489820150404);
INSERT INTO `upms_permission` VALUES (77, 2, 21, '编辑文章', 3, 'cms:article:update', '/manage/article/update', 'zmdi zmdi-edit', 1, 1489820178269, 1489820178269);
INSERT INTO `upms_permission` VALUES (78, 2, 21, '删除文章', 3, 'cms:article:delete', '/manage/article/delete', 'zmdi zmdi-close', 1, 1489820207607, 1489820207607);
INSERT INTO `upms_permission` VALUES (79, 2, 0, '单页专题管理', 1, '', '', 'zmdi zmdi-view-web', 1, 1489835320327, 1489835320327);
INSERT INTO `upms_permission` VALUES (80, 2, 79, '专题管理', 2, 'cms:topic:read', '/manage/topic/index', 'zmdi zmdi-widgets', 1, 1489591507566, 1489591507566);
INSERT INTO `upms_permission` VALUES (81, 2, 80, '新增专题', 3, 'cms:topic:create', '/manage/topic/create', 'zmdi zmdi-plus', 1, 1489843327028, 1489843327028);
INSERT INTO `upms_permission` VALUES (82, 2, 80, '编辑专题', 3, 'cms:topic:update', '/manage/topic/update', 'zmdi zmdi-edit', 1, 1489843351513, 1489843351513);
INSERT INTO `upms_permission` VALUES (83, 2, 80, '删除专题', 3, 'cms:topic:delete', '/manage/topic/delete', 'zmdi zmdi-close', 1, 1489843379953, 1489843379953);
INSERT INTO `upms_permission` VALUES (84, 2, 68, '上移菜单', 3, 'cms:menu:up', '/manage/menu/up', 'zmdi zmdi-long-arrow-up', 1, 1489846486548, 1489846486548);
INSERT INTO `upms_permission` VALUES (85, 2, 68, '下移菜单', 3, 'cms:menu:down', '/manage/menu/down', 'zmdi zmdi-long-arrow-down', 1, 1489846578051, 1489846578051);
INSERT INTO `upms_permission` VALUES (86, 10, 0, '121', 1, NULL, NULL, 'zmdi zmdi-widgets', 1, 1521427709045, 1521427709045);
INSERT INTO `upms_permission` VALUES (87, 10, 0, '34123421', 1, NULL, NULL, 'zmdi zmdi-widgets', 1, 1521427763460, 1521427763460);

-- ----------------------------
-- Table structure for upms_role
-- ----------------------------
DROP TABLE IF EXISTS `upms_role`;
CREATE TABLE `upms_role`  (
  `role_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `title` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色标题',
  `description` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `ctime` bigint(20) NOT NULL COMMENT '创建时间',
  `orders` bigint(20) NOT NULL COMMENT '排序',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of upms_role
-- ----------------------------
INSERT INTO `upms_role` VALUES (1, 'super', '超级管理员', '拥有所有权限', 1, 1);
INSERT INTO `upms_role` VALUES (2, 'admin', '管理员', '拥有除权限管理系统外的所有权限', 1487471013117, 1487471013117);
INSERT INTO `upms_role` VALUES (4, '121', '121', '12', 1521425426162, 1521425426162);

-- ----------------------------
-- Table structure for upms_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `upms_role_permission`;
CREATE TABLE `upms_role_permission`  (
  `role_permission_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role_id` int(10) UNSIGNED NOT NULL COMMENT '角色编号',
  `permission_id` int(10) UNSIGNED NOT NULL COMMENT '权限编号',
  PRIMARY KEY (`role_permission_id`) USING BTREE,
  INDEX `FK_Reference_23`(`role_id`) USING BTREE,
  CONSTRAINT `FK_Reference_23` FOREIGN KEY (`role_id`) REFERENCES `upms_role` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 126 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色权限关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of upms_role_permission
-- ----------------------------
INSERT INTO `upms_role_permission` VALUES (1, 1, 1);
INSERT INTO `upms_role_permission` VALUES (2, 1, 2);
INSERT INTO `upms_role_permission` VALUES (3, 1, 3);
INSERT INTO `upms_role_permission` VALUES (4, 1, 4);
INSERT INTO `upms_role_permission` VALUES (5, 1, 5);
INSERT INTO `upms_role_permission` VALUES (6, 1, 6);
INSERT INTO `upms_role_permission` VALUES (7, 1, 7);
INSERT INTO `upms_role_permission` VALUES (8, 1, 39);
INSERT INTO `upms_role_permission` VALUES (12, 1, 12);
INSERT INTO `upms_role_permission` VALUES (14, 1, 14);
INSERT INTO `upms_role_permission` VALUES (15, 1, 15);
INSERT INTO `upms_role_permission` VALUES (17, 1, 17);
INSERT INTO `upms_role_permission` VALUES (19, 1, 19);
INSERT INTO `upms_role_permission` VALUES (20, 1, 20);
INSERT INTO `upms_role_permission` VALUES (21, 1, 21);
INSERT INTO `upms_role_permission` VALUES (24, 1, 24);
INSERT INTO `upms_role_permission` VALUES (27, 1, 27);
INSERT INTO `upms_role_permission` VALUES (28, 1, 28);
INSERT INTO `upms_role_permission` VALUES (29, 1, 29);
INSERT INTO `upms_role_permission` VALUES (30, 1, 30);
INSERT INTO `upms_role_permission` VALUES (31, 1, 31);
INSERT INTO `upms_role_permission` VALUES (32, 1, 32);
INSERT INTO `upms_role_permission` VALUES (33, 1, 33);
INSERT INTO `upms_role_permission` VALUES (34, 1, 34);
INSERT INTO `upms_role_permission` VALUES (35, 1, 35);
INSERT INTO `upms_role_permission` VALUES (36, 1, 36);
INSERT INTO `upms_role_permission` VALUES (37, 1, 37);
INSERT INTO `upms_role_permission` VALUES (38, 1, 38);
INSERT INTO `upms_role_permission` VALUES (39, 1, 46);
INSERT INTO `upms_role_permission` VALUES (40, 1, 51);
INSERT INTO `upms_role_permission` VALUES (44, 1, 48);
INSERT INTO `upms_role_permission` VALUES (45, 1, 50);
INSERT INTO `upms_role_permission` VALUES (47, 1, 53);
INSERT INTO `upms_role_permission` VALUES (48, 1, 18);
INSERT INTO `upms_role_permission` VALUES (49, 1, 54);
INSERT INTO `upms_role_permission` VALUES (50, 1, 54);
INSERT INTO `upms_role_permission` VALUES (51, 1, 55);
INSERT INTO `upms_role_permission` VALUES (52, 1, 54);
INSERT INTO `upms_role_permission` VALUES (53, 1, 55);
INSERT INTO `upms_role_permission` VALUES (54, 1, 56);
INSERT INTO `upms_role_permission` VALUES (55, 1, 57);
INSERT INTO `upms_role_permission` VALUES (56, 1, 58);
INSERT INTO `upms_role_permission` VALUES (57, 1, 58);
INSERT INTO `upms_role_permission` VALUES (58, 1, 59);
INSERT INTO `upms_role_permission` VALUES (59, 1, 60);
INSERT INTO `upms_role_permission` VALUES (60, 1, 61);
INSERT INTO `upms_role_permission` VALUES (61, 1, 62);
INSERT INTO `upms_role_permission` VALUES (62, 1, 62);
INSERT INTO `upms_role_permission` VALUES (63, 1, 63);
INSERT INTO `upms_role_permission` VALUES (64, 1, 62);
INSERT INTO `upms_role_permission` VALUES (65, 1, 63);
INSERT INTO `upms_role_permission` VALUES (66, 1, 64);
INSERT INTO `upms_role_permission` VALUES (67, 1, 62);
INSERT INTO `upms_role_permission` VALUES (68, 1, 63);
INSERT INTO `upms_role_permission` VALUES (69, 1, 64);
INSERT INTO `upms_role_permission` VALUES (70, 1, 65);
INSERT INTO `upms_role_permission` VALUES (71, 1, 62);
INSERT INTO `upms_role_permission` VALUES (72, 1, 63);
INSERT INTO `upms_role_permission` VALUES (73, 1, 64);
INSERT INTO `upms_role_permission` VALUES (74, 1, 65);
INSERT INTO `upms_role_permission` VALUES (75, 1, 66);
INSERT INTO `upms_role_permission` VALUES (76, 1, 62);
INSERT INTO `upms_role_permission` VALUES (77, 1, 63);
INSERT INTO `upms_role_permission` VALUES (78, 1, 64);
INSERT INTO `upms_role_permission` VALUES (79, 1, 65);
INSERT INTO `upms_role_permission` VALUES (80, 1, 66);
INSERT INTO `upms_role_permission` VALUES (81, 1, 67);
INSERT INTO `upms_role_permission` VALUES (82, 1, 68);
INSERT INTO `upms_role_permission` VALUES (83, 1, 69);
INSERT INTO `upms_role_permission` VALUES (84, 1, 69);
INSERT INTO `upms_role_permission` VALUES (85, 1, 70);
INSERT INTO `upms_role_permission` VALUES (86, 1, 69);
INSERT INTO `upms_role_permission` VALUES (87, 1, 70);
INSERT INTO `upms_role_permission` VALUES (88, 1, 71);
INSERT INTO `upms_role_permission` VALUES (89, 1, 72);
INSERT INTO `upms_role_permission` VALUES (90, 1, 72);
INSERT INTO `upms_role_permission` VALUES (91, 1, 73);
INSERT INTO `upms_role_permission` VALUES (92, 1, 72);
INSERT INTO `upms_role_permission` VALUES (93, 1, 73);
INSERT INTO `upms_role_permission` VALUES (94, 1, 74);
INSERT INTO `upms_role_permission` VALUES (95, 1, 72);
INSERT INTO `upms_role_permission` VALUES (96, 1, 73);
INSERT INTO `upms_role_permission` VALUES (97, 1, 74);
INSERT INTO `upms_role_permission` VALUES (98, 1, 75);
INSERT INTO `upms_role_permission` VALUES (99, 1, 76);
INSERT INTO `upms_role_permission` VALUES (100, 1, 76);
INSERT INTO `upms_role_permission` VALUES (101, 1, 77);
INSERT INTO `upms_role_permission` VALUES (102, 1, 76);
INSERT INTO `upms_role_permission` VALUES (103, 1, 77);
INSERT INTO `upms_role_permission` VALUES (105, 1, 79);
INSERT INTO `upms_role_permission` VALUES (106, 1, 80);
INSERT INTO `upms_role_permission` VALUES (107, 1, 81);
INSERT INTO `upms_role_permission` VALUES (108, 1, 81);
INSERT INTO `upms_role_permission` VALUES (109, 1, 82);
INSERT INTO `upms_role_permission` VALUES (110, 1, 81);
INSERT INTO `upms_role_permission` VALUES (111, 1, 82);
INSERT INTO `upms_role_permission` VALUES (112, 1, 83);
INSERT INTO `upms_role_permission` VALUES (113, 1, 84);
INSERT INTO `upms_role_permission` VALUES (114, 1, 84);
INSERT INTO `upms_role_permission` VALUES (115, 1, 85);
INSERT INTO `upms_role_permission` VALUES (121, 1, 78);
INSERT INTO `upms_role_permission` VALUES (122, 1, 78);
INSERT INTO `upms_role_permission` VALUES (124, 1, 25);
INSERT INTO `upms_role_permission` VALUES (125, 1, 26);

-- ----------------------------
-- Table structure for upms_system
-- ----------------------------
DROP TABLE IF EXISTS `upms_system`;
CREATE TABLE `upms_system`  (
  `system_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `icon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图标',
  `banner` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '背景',
  `theme` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '主题',
  `basepath` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '根目录',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '状态(-1:黑名单,1:正常)',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '系统名称',
  `title` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '系统标题',
  `description` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '系统描述',
  `ctime` bigint(20) NULL DEFAULT NULL COMMENT '创建时间',
  `orders` bigint(20) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`system_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of upms_system
-- ----------------------------
INSERT INTO `upms_system` VALUES (1, 'zmdi zmdi-shield-security', '/resources/zheng-admin/images/zheng-upms.png', '#29A176', 'http://upms.zhangshuzheng.cn:1111', 1, 'zheng-upms-server', '权限管理系统', '用户权限管理系统（RBAC细粒度用户权限、统一后台、单点登录、会话管理）', 1, 1);
INSERT INTO `upms_system` VALUES (2, 'zmdi zmdi-wikipedia', '/resources/zheng-admin/images/zheng-cms.png', '#455EC5', 'http://cms.zhangshuzheng.cn:2222', 1, 'zheng-cms-admin', '内容管理系统', '内容管理系统（门户、博客、论坛、问答等）', 2, 2);
INSERT INTO `upms_system` VALUES (3, 'zmdi zmdi-paypal-alt', '/resources/zheng-admin/images/zheng-pay.png', '#F06292', 'http://pay.zhangshuzheng.cn:3331', 1, 'zheng-pay-admin', '支付管理系统', '支付管理系统', 3, 3);
INSERT INTO `upms_system` VALUES (4, 'zmdi zmdi-account', '/resources/zheng-admin/images/zheng-ucenter.png', '#6539B4', 'http://ucenter.zhangshuzheng.cn:4441', 1, 'zheng-ucenter-home', '用户管理系统', '用户管理系统', 4, 4);
INSERT INTO `upms_system` VALUES (5, 'zmdi zmdi-cloud', '/resources/zheng-admin/images/zheng-oss.png', '#0B8DE5', 'http://oss.zhangshuzheng.cn:7771', 1, 'zheng-oss-web', '存储管理系统', '存储管理系统', 5, 5);
INSERT INTO `upms_system` VALUES (10, '12', '12', '#000000', '12', 1, '222', '12', '12', 1521331846515, 1521331846515);

-- ----------------------------
-- Table structure for upms_user
-- ----------------------------
DROP TABLE IF EXISTS `upms_user`;
CREATE TABLE `upms_user`  (
  `user_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '帐号',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码MD5(密码+盐)',
  `salt` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '盐',
  `realname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `avatar` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `sex` tinyint(4) NULL DEFAULT NULL COMMENT '性别',
  `locked` tinyint(4) NULL DEFAULT NULL COMMENT '状态(0:正常,1:锁定)',
  `ctime` bigint(20) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of upms_user
-- ----------------------------
INSERT INTO `upms_user` VALUES (1, 'admin', '3038D9CB63B3152A79B8153FB06C02F7', '66f1b370c660445a8657bf8bf1794486', '张恕征', '/resources/zheng-admin/images/avatar.jpg', '', '469741414@qq.com', 1, 0, 1);
INSERT INTO `upms_user` VALUES (2, 'test', '285C9762F5F9046F5893F752DFAF3476', 'd2d0d03310444ad388a8b290b0fe8564', '张恕征', '/resources/zheng-admin/images/avatar.jpg', '', '469741414@qq.com', 1, 0, 1493394720495);
INSERT INTO `upms_user` VALUES (7, '22', '21B1638DA8B5DE896773525A289E658D', 'afc6a344e5b247089f66d5f2c8c6bac3', '33', '33', '33', '33', 1, 0, 1521373439025);

-- ----------------------------
-- Table structure for upms_user_organization
-- ----------------------------
DROP TABLE IF EXISTS `upms_user_organization`;
CREATE TABLE `upms_user_organization`  (
  `user_organization_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` int(10) UNSIGNED NOT NULL COMMENT '用户编号',
  `organization_id` int(10) UNSIGNED NOT NULL COMMENT '组织编号',
  PRIMARY KEY (`user_organization_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户组织关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of upms_user_organization
-- ----------------------------
INSERT INTO `upms_user_organization` VALUES (19, 1, 1);
INSERT INTO `upms_user_organization` VALUES (20, 1, 4);
INSERT INTO `upms_user_organization` VALUES (21, 1, 5);
INSERT INTO `upms_user_organization` VALUES (22, 1, 6);
INSERT INTO `upms_user_organization` VALUES (23, 1, 7);
INSERT INTO `upms_user_organization` VALUES (30, 2, 4);
INSERT INTO `upms_user_organization` VALUES (31, 2, 5);
INSERT INTO `upms_user_organization` VALUES (32, 2, 6);
INSERT INTO `upms_user_organization` VALUES (33, 6, 1);
INSERT INTO `upms_user_organization` VALUES (34, 6, 4);
INSERT INTO `upms_user_organization` VALUES (35, 6, 5);
INSERT INTO `upms_user_organization` VALUES (36, 6, 6);

-- ----------------------------
-- Table structure for upms_user_permission
-- ----------------------------
DROP TABLE IF EXISTS `upms_user_permission`;
CREATE TABLE `upms_user_permission`  (
  `user_permission_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` int(10) UNSIGNED NOT NULL COMMENT '用户编号',
  `permission_id` int(10) UNSIGNED NOT NULL COMMENT '权限编号',
  `type` tinyint(4) NOT NULL COMMENT '权限类型(-1:减权限,1:增权限)',
  PRIMARY KEY (`user_permission_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户权限关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of upms_user_permission
-- ----------------------------
INSERT INTO `upms_user_permission` VALUES (3, 1, 22, -1);
INSERT INTO `upms_user_permission` VALUES (4, 1, 22, 1);
INSERT INTO `upms_user_permission` VALUES (5, 2, 24, -1);
INSERT INTO `upms_user_permission` VALUES (6, 2, 26, -1);
INSERT INTO `upms_user_permission` VALUES (7, 2, 27, -1);
INSERT INTO `upms_user_permission` VALUES (8, 2, 29, -1);
INSERT INTO `upms_user_permission` VALUES (9, 2, 32, -1);
INSERT INTO `upms_user_permission` VALUES (10, 2, 51, -1);
INSERT INTO `upms_user_permission` VALUES (11, 2, 48, -1);
INSERT INTO `upms_user_permission` VALUES (12, 2, 50, -1);
INSERT INTO `upms_user_permission` VALUES (13, 2, 35, -1);
INSERT INTO `upms_user_permission` VALUES (14, 2, 46, -1);
INSERT INTO `upms_user_permission` VALUES (15, 2, 37, -1);
INSERT INTO `upms_user_permission` VALUES (16, 2, 38, -1);
INSERT INTO `upms_user_permission` VALUES (17, 2, 57, -1);
INSERT INTO `upms_user_permission` VALUES (18, 2, 56, -1);
INSERT INTO `upms_user_permission` VALUES (19, 2, 59, -1);
INSERT INTO `upms_user_permission` VALUES (20, 2, 78, -1);
INSERT INTO `upms_user_permission` VALUES (21, 2, 67, -1);
INSERT INTO `upms_user_permission` VALUES (22, 2, 83, -1);
INSERT INTO `upms_user_permission` VALUES (23, 2, 71, -1);
INSERT INTO `upms_user_permission` VALUES (24, 2, 75, -1);
INSERT INTO `upms_user_permission` VALUES (31, 2, 24, 1);
INSERT INTO `upms_user_permission` VALUES (32, 2, 25, 1);
INSERT INTO `upms_user_permission` VALUES (33, 2, 26, 1);
INSERT INTO `upms_user_permission` VALUES (34, 2, 27, 1);
INSERT INTO `upms_user_permission` VALUES (35, 2, 28, 1);
INSERT INTO `upms_user_permission` VALUES (36, 2, 29, 1);
INSERT INTO `upms_user_permission` VALUES (37, 2, 30, 1);
INSERT INTO `upms_user_permission` VALUES (38, 2, 31, 1);
INSERT INTO `upms_user_permission` VALUES (39, 2, 32, 1);
INSERT INTO `upms_user_permission` VALUES (40, 2, 51, 1);
INSERT INTO `upms_user_permission` VALUES (41, 2, 48, 1);
INSERT INTO `upms_user_permission` VALUES (42, 2, 50, 1);
INSERT INTO `upms_user_permission` VALUES (43, 2, 33, 1);
INSERT INTO `upms_user_permission` VALUES (44, 2, 34, 1);
INSERT INTO `upms_user_permission` VALUES (45, 2, 35, 1);
INSERT INTO `upms_user_permission` VALUES (46, 2, 46, 1);

-- ----------------------------
-- Table structure for upms_user_role
-- ----------------------------
DROP TABLE IF EXISTS `upms_user_role`;
CREATE TABLE `upms_user_role`  (
  `user_role_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` int(10) UNSIGNED NOT NULL COMMENT '用户编号',
  `role_id` int(10) NULL DEFAULT NULL COMMENT '角色编号',
  PRIMARY KEY (`user_role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of upms_user_role
-- ----------------------------
INSERT INTO `upms_user_role` VALUES (4, 1, 1);
INSERT INTO `upms_user_role` VALUES (5, 1, 2);
INSERT INTO `upms_user_role` VALUES (6, 2, 1);
INSERT INTO `upms_user_role` VALUES (7, 2, 2);
INSERT INTO `upms_user_role` VALUES (10, 7, 1);

SET FOREIGN_KEY_CHECKS = 1;
