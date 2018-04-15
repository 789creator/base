/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : shop

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 15/04/2018 22:45:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for b2c_goods
-- ----------------------------
DROP TABLE IF EXISTS `b2c_goods`;
CREATE TABLE `b2c_goods`  (
  `goods_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `cat_id1` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '一级分类id',
  `cat_id2` int(11) NULL DEFAULT 0 COMMENT '二级分类',
  `cat_id3` int(11) NULL DEFAULT 0 COMMENT '三级分类',
  `store_cat_id1` int(11) NULL DEFAULT 0 COMMENT '本店一级分类',
  `store_cat_id2` int(11) NULL DEFAULT 0 COMMENT '本店二级分类',
  `goods_sn` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '商品编号',
  `goods_name` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '商品名称',
  `click_count` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '点击数',
  `brand_id` smallint(5) UNSIGNED NOT NULL DEFAULT 0 COMMENT '品牌id',
  `store_count` smallint(5) UNSIGNED NOT NULL DEFAULT 10 COMMENT '库存数量',
  `collect_sum` int(10) NULL DEFAULT 0 COMMENT '商品收藏数',
  `comment_count` smallint(5) NULL DEFAULT 0 COMMENT '商品评论数',
  `weight` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '商品重量克为单位',
  `market_price` decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT '市场价',
  `shop_price` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '本店价',
  `cost_price` decimal(10, 2) NULL DEFAULT 0.00 COMMENT '商品成本价',
  `exchange_integral` int(10) NOT NULL DEFAULT 0 COMMENT 'COMMENT \'积分兑换：0不参与积分兑换',
  `keywords` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '商品关键词',
  `goods_remark` varchar(420) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '商品简单描述',
  `original_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '商品上传原始图',
  `is_virtual` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否为虚拟商品 1是，0否',
  `virtual_indate` int(11) NULL DEFAULT 0 COMMENT '虚拟商品有效期',
  `virtual_limit` smallint(6) NULL DEFAULT 0 COMMENT '虚拟商品购买上限',
  `virtual_refund` tinyint(1) NULL DEFAULT 1 COMMENT '是否允许过期退款， 1是，0否',
  `is_on_sale` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '0下架1上架2违规下架',
  `is_free_shipping` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否包邮0否1是',
  `on_time` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '商品上架时间',
  `sort` smallint(4) UNSIGNED NOT NULL DEFAULT 50 COMMENT '商品排序',
  `is_recommend` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否推荐',
  `is_new` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否新品',
  `is_hot` tinyint(1) NULL DEFAULT 0 COMMENT '是否热卖',
  `last_update` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '最后更新时间',
  `goods_type` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '商品所属类型id，取值表goods_type的id',
  `give_integral` int(11) NULL DEFAULT 0 COMMENT '购买商品赠送积分',
  `sales_sum` int(11) NULL DEFAULT 0 COMMENT '商品销量',
  `prom_type` tinyint(1) NULL DEFAULT 0 COMMENT '0默认1抢购2团购3优惠促销',
  `prom_id` int(11) NULL DEFAULT 0 COMMENT '优惠活动id',
  `distribut` decimal(10, 2) NULL DEFAULT 0.00 COMMENT '佣金用于分销分成',
  `store_id` int(11) NULL DEFAULT 0 COMMENT '商家店铺ID',
  `spu` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT 'SPU',
  `sku` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT 'SKU',
  `goods_state` tinyint(1) NULL DEFAULT 1 COMMENT '0待审核1审核通过2审核失败',
  `close_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '违规下架原因',
  `suppliers_id` smallint(5) UNSIGNED NULL DEFAULT 0 COMMENT '供应商ID',
  `shipping_area_ids` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '配送物流shipping_area_id,以逗号分隔',
  `is_own_shop` tinyint(1) NULL DEFAULT 0 COMMENT '1:第三方自营店,2:总平台自营店',
  PRIMARY KEY (`goods_id`) USING BTREE,
  INDEX `goods_sn`(`goods_sn`) USING BTREE,
  INDEX `cat_id`(`cat_id1`) USING BTREE,
  INDEX `last_update`(`last_update`) USING BTREE,
  INDEX `brand_id`(`brand_id`) USING BTREE,
  INDEX `goods_number`(`store_count`) USING BTREE,
  INDEX `goods_weight`(`weight`) USING BTREE,
  INDEX `sort_order`(`sort`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of b2c_goods
-- ----------------------------
INSERT INTO `b2c_goods` VALUES (1, 1, 5, 7, 0, 0, 'TP0000001', '王者荣耀', 53, 0, 94, 4, 1, 0, 188888.00, 99999.00, 0.00, 0, '', '', '/public/upload/goods/2017/07-13/89e7fdb9bd8d32549570792c863e0843.png', 0, 0, 1, 0, 2, 0, 1499996033, 50, 0, 0, 0, 0, 1, 0, 6, 0, 0, 0.00, 1, '', '', 1, '无备注', 0, '', 2);
INSERT INTO `b2c_goods` VALUES (2, 1, 5, 7, 0, 0, 'TP0000002', '暗黑破坏神', 49, 0, 80, 10, 7, 0, 88888.00, 8888.00, 0.00, 0, '', '', '/public/upload/goods/2017/07-04/6239e6c3937a13abf1a3f04f92eb7d59.jpg', 0, 0, 1, 0, 0, 0, 1499242233, 50, 1, 1, 1, 0, 1, 0, 20, 0, 0, 0.00, 2, '', '', 1, NULL, 0, '', 1);
INSERT INTO `b2c_goods` VALUES (3, 1, 5, 7, 0, 0, 'TP0000003', '测试商品', 84, 0, 67, 6, 5, 0, 8888.00, 8888.00, 0.00, 0, '', '', '/public/upload/goods/2017/07-04/960658da36634f58765f3b4c0f838cfa.jpg', 0, 0, 1, 0, 1, 0, 1499768611, 1000, 1, 1, 1, 0, 1, 0, 17, 0, 0, 0.00, 2, '', '', 1, NULL, 0, '', 1);
INSERT INTO `b2c_goods` VALUES (4, 1, 5, 7, 0, 0, 'TP0000004', '王者荣耀礼包', 39, 0, 1085, 5, 4, 0, 130.00, 100.00, 0.00, 0, '', '', '/public/upload/goods/2017/07-04/7f29ac07e9289942c053219d7141ff62.jpg', 1, 1504195200, 10, 0, 2, 0, 1500283921, 50, 0, 0, 0, 0, 1, 0, 115, 0, 0, 0.00, 2, '', '', 1, '11', 0, '', 1);
INSERT INTO `b2c_goods` VALUES (5, 1, 5, 7, 0, 0, 'TP0000005', '测试商品5', 18, 0, 100, 1, 0, 0, 188.00, 168.00, 100.00, 0, '', '', '', 1, 1543593600, 1, 0, 1, 0, 1500257082, 50, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0.00, 2, '', '', 1, NULL, 0, '', 1);
INSERT INTO `b2c_goods` VALUES (6, 2, 3, 13, 0, 0, 'TP0000006', '新商品1', 22, 0, 1800, 1, 0, 0, 10.00, 10.00, 10.00, 10, '10', '新商品1', '', 0, 0, 1, 0, 1, 1, 1500449094, 50, 0, 0, 0, 0, 0, 10, 0, 0, 0, 0.00, 2, '', '', 1, NULL, 0, '', 1);
INSERT INTO `b2c_goods` VALUES (7, 4, 21, 52, 0, 0, 'TP0000007', '小霸王', 7, 0, 4, 0, 0, 0, 465.00, 124.00, 56.00, 0, '', '哈哈哈', '', 0, 0, 1, 0, 1, 1, 1500272761, 50, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0.00, 2, '', '', 1, NULL, 0, '', 1);
INSERT INTO `b2c_goods` VALUES (8, 2, 3, 13, 0, 0, 'TP0000008', 'F-02', 31, 0, 89, 5, 5, 0, 100.00, 10.00, 1.00, 0, '', '问道-再续前缘', '/public/upload/goods/2017/07-18/66e4981369093457fdf571a50f5cb423.jpg', 0, 0, 1, 0, 1, 1, 1500454266, 50, 0, 0, 0, 0, 0, 0, 11, 0, 0, 0.00, 3, '', '', 1, NULL, 0, '', 0);
INSERT INTO `b2c_goods` VALUES (9, 2, 3, 13, 0, 0, 'TP0000009', 'F-01', 33, 0, 87, 3, 5, 0, 100.00, 20.00, 1.00, 0, '', '红色警戒2', '/public/upload/goods/2017/07-18/b3bee9304a6d3fe603bc986e52d3544b.jpg', 0, 0, 1, 0, 1, 1, 1500454213, 50, 0, 0, 0, 0, 0, 0, 13, 0, 0, 0.00, 3, '', '', 1, NULL, 0, '', 0);
INSERT INTO `b2c_goods` VALUES (10, 2, 18, 45, 0, 0, 'TP0000010', '毒奶粉', 13, 0, 100, 0, 0, 0, 1.00, 1.00, 1.00, 1, '', '毒奶粉毒奶粉毒奶粉毒奶粉毒奶粉毒奶粉', '/public/upload/goods/2017/07-18/1d11170ae2b2ae5d3511234fd9798177.png', 0, -28800, 1, 0, 1, 1, 1500344590, 50, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0.00, 2, '', '', 1, NULL, 0, '', 1);
INSERT INTO `b2c_goods` VALUES (11, 2, 17, 41, 0, 0, 'TP0000011', '商品1', 22, 0, 3, 4, 6, 0, 100.00, 100.00, 100.00, 0, '', '商品1商品1', '/public/upload/goods/2017/07-18/51906c9967ca8b358e9e376007466d7f.jpg', 0, 0, 1, 0, 1, 0, 1500373463, 4, 1, 1, 1, 0, 0, 100, 22, 0, 0, 0.00, 4, '', '', 1, NULL, 0, '', 0);
INSERT INTO `b2c_goods` VALUES (12, 4, 22, 56, 0, 0, 'TP0000012', '商品2', 18, 0, 46, 2, 7, 0, 100.00, 100.00, 100.00, 100, '', '商品2商品2商品2', '/public/upload/goods/2017/07-18/36ef2070b2980e6f10aeddf220a0ddc0.jpg', 0, -28800, 1, 0, 2, 0, 1500373452, 3, 0, 0, 0, 0, 1, 100, 54, 0, 0, 0.00, 4, '', '', 1, '11', 0, '', 0);
INSERT INTO `b2c_goods` VALUES (13, 4, 22, 56, 0, 0, 'TP0000013', '商品3', 4, 0, 100, 5, 0, 0, 1000.00, 1000.00, 10.00, 0, '', '商品3商品3商品3', '/public/upload/goods/2017/07-18/06a1c463da41196ac913f6e1a320c3b3.jpg', 0, -28800, 1, 0, 2, 0, 1500373506, 5, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0.00, 4, '', '', 1, '无备注', 0, '', 0);
INSERT INTO `b2c_goods` VALUES (14, 4, 22, 56, 0, 0, 'TP0000014', '商品4', 6, 0, 99, 2, 0, 0, 5000.00, 5000.00, 5000.00, 0, '', '商品3', '/public/upload/goods/2017/07-18/e17df46fe988db1eb35741075e426133.jpg', 0, -28800, 1, 0, 2, 0, 1500373540, 1, 0, 0, 0, 0, 1, 5000, 1, 0, 0, 0.00, 4, '', '', 1, '无备注', 0, '', 0);
INSERT INTO `b2c_goods` VALUES (15, 2, 17, 41, 0, 0, 'TP0000015', '111111111', 8, 0, 89, 0, 0, 0, 100.00, 100.00, 1010.00, 10, '10', '<script>\r\nalert(1);\r\n</script>', '', 0, 0, 1, 0, 2, 0, 1501739882, 50, 0, 0, 0, 0, 0, 10, 11, 0, 0, 0.00, 4, '', '', 1, '无备注', 0, '', 0);
INSERT INTO `b2c_goods` VALUES (16, 2, 3, 13, 0, 0, 'TP0000016', '2k18', 7, 0, 999, 0, 1, 0, 300.00, 200.00, 10.00, 10, '篮球 竞技', '2k18', '/public/upload/goods/2017/08-04/1cb2f5678a4f7de94b03583386068e9d.jpg', 0, -28800, 1, 0, 2, 0, 1501831166, 50, 0, 0, 0, 0, 0, 200, 1, 0, 0, 0.00, 3, '', '', 1, '无备注', 0, '', 0);
INSERT INTO `b2c_goods` VALUES (22, 1, 5, 7, 0, 0, 'TP0000022', '烈火之歌', 1, 0, 100, 0, 0, 0, 20000.00, 10000.00, 0.00, 0, '', '', '/public/upload/goods/2017/08-24/d8026cb55a5d4c58508c29672dacb4fb.png', 0, -28800, 1, 0, 2, 0, 1503544249, 50, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0.00, 5, '', '', 1, '无备注', 0, '', 0);
INSERT INTO `b2c_goods` VALUES (23, 1, 5, 35, 0, 0, 'TP0000023', '《天琊》', 11, 0, 100, 0, 0, 0, 5000.00, 3000.00, 0.00, 0, '', '2017年仙侠题材ARPG超炫酷仙侠手游巨作《天琊》重磅上线！极品宠物个性时装，狂打BOSS仙魔大战，多种技能装备组合让玩家体验爽快动作打击感，更有丰富的仙盟挑战战玩法，强大的真人PK让你欲罢不能，婚礼玩法带你喜结良缘，交友游戏两不误！ 唯美画质，御剑飞行、万人国战，打造充满爱恨情仇的蜀山仙侠大世界~', '/public/upload/goods/2017/08-31/f258cfa1c232783b441541d73d46e57d.png', 0, -28800, 1, 0, 0, 0, 1504144474, 50, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0.00, 5, '', '', 1, NULL, 0, '', 0);
INSERT INTO `b2c_goods` VALUES (24, 1, 5, 35, 0, 0, 'TP0000024', '圣魔战纪', 6, 0, 1, 0, 0, 0, 5000.00, 3000.00, 0.00, 0, '', '2017年纯正3DMMORPG手机游戏，支持千人大世界同时在线的《圣魔战记》火爆上线，以完全自主原创西方剑与魔法的世界观为背景，融合了东方流行元素。在游戏里，玩家可以体验角色养成，装备打造，技能符文、即时竞技、野外探索、交友结婚、世界BOSS、公会合作及争夺等核心玩法，海量不同外形的技能、装备、坐骑、魔灵、翅膀供收集，更有无数精彩独特的关卡和副本等待玩家的挑战。', '/public/upload/goods/2017/08-31/0f1b2ce37d5923859137c3c0ae109c7e.png', 0, 0, 1, 0, 1, 0, 1505180258, 50, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0.00, 5, '', '', 1, NULL, 0, '', 0);
INSERT INTO `b2c_goods` VALUES (25, 1, 5, 35, 0, 0, 'TP0000025', '烈火之歌', 1, 0, 100, 0, 0, 0, 3000.00, 3000.00, 3000.00, 0, '', '大型MMORPG游戏《烈火之歌》，传承1.76版本精华。 在这里不仅还原了其经典场景和玩法，更打造出极致快感的动作PK，在这里，怀旧画风让你重回青春。更有绝对公平游戏机制让你挑战RMB玩家！战士、法师、道士三大职业热血回归，熟悉的场景，带你重回记忆中的玛法大陆，无尽的杀戮，让你感受最真实的沙巴克远征！', '/public/upload/goods/2017/09-11/bc72792ba1fc975dfc2743d4b194c8a2.png', 0, 0, 1, 0, 1, 0, 1505180141, 50, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0.00, 5, '', '', 1, NULL, 0, '', 0);
INSERT INTO `b2c_goods` VALUES (26, 1, 5, 35, 0, 0, 'TP0000026', '黑铁传世', 1, 0, 3, 0, 0, 0, 3000.00, 3000.00, 0.00, 0, '', '《黑铁传世》手游是一款仿传奇世界MMORPG手机游戏，游戏具有战法道三大经典职业，领地战（热沙）、夺宝奇兵、凌云顶、天降横财、秦陵地宫、满汉全席、除魔副本、神魔界、封魔塔、狩猎场、夜袭沙城等丰富玩法，独特系统“装备强化、宝石合成、装备进阶、装备投保、装备洗炼”，更可实时多人PK，再战经典万人攻沙，帮你成就真男人团战梦想！酷炫技能、霸气称号，让你战力再度飙升！更有热血沸腾的生存大乱斗。等级划分战场，完全比拼战力，让你热血沸腾，与战友一同厮杀。野外PK让你血腥弑杀，争夺神兵利器让你问鼎天下。', '/public/upload/goods/2017/09-12/019c930271f4e4d2c4be68f73c1b7dea.png', 0, 0, 1, 0, 0, 0, 1505180682, 50, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0.00, 5, '', '', 1, NULL, 0, '', 0);
INSERT INTO `b2c_goods` VALUES (27, 1, 5, 9, 0, 0, 'TP0000027', '口袋妖怪', 2, 0, 100, 0, 0, 0, 3000.00, 3000.00, 0.00, 0, '', '重温经典，激情不减！高还原Game Boy Advance手游力作《口袋妖怪》进入第四世代，加入超过100只全新超强小精灵，更有新增神秘精灵（超进化）震撼来袭，引爆最强宿命对决！与此同时，数个新都市的开放、数十个道具饰品的更新以及公会玩法更是让人深陷其中不能自拔！《口袋妖怪》忠实还原十七种原作属性，在对战中完美重现属性相克系统，新版本开放后将有超过540只原作小精灵（后续版本还会持续更新），多达445种原作精灵技能让你目不暇接！还有独树一帜的闪光精灵系统，野外探险精灵捕捉系统，精灵进化深度培养系统，真正一对一（面对面）高还原GBA模式手动对战系统，业内首创多路径冒险系统，野外神兽捕捉系统；再融入PVP单人对战，PVP跨服精灵大师联赛，世界精灵训练师联赛，好友聊天系统，精灵技能回忆，精灵交换以及捕虫大会等互动元素，让人根本停不下来！赶紧来挑战道馆夺取冠军的头衔吧！', '/public/upload/goods/2017/09-12/8cbfee55ec378c49f781659ab7163ef2.png', 0, 0, 1, 0, 1, 0, 1505180657, 50, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0.00, 5, '', '', 1, NULL, 0, '', 0);

-- ----------------------------
-- Table structure for b2c_goods_attr
-- ----------------------------
DROP TABLE IF EXISTS `b2c_goods_attr`;
CREATE TABLE `b2c_goods_attr`  (
  `goods_attr_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '商品属性id自增',
  `goods_id` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '商品id',
  `attr_id` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '属性id',
  `attr_value` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '属性值',
  `attr_price` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '属性价格',
  PRIMARY KEY (`goods_attr_id`) USING BTREE,
  INDEX `goods_id`(`goods_id`) USING BTREE,
  INDEX `attr_id`(`attr_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品与商品属性关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for b2c_goods_attribute
-- ----------------------------
DROP TABLE IF EXISTS `b2c_goods_attribute`;
CREATE TABLE `b2c_goods_attribute`  (
  `attr_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '属性id',
  `attr_name` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '属性名称',
  `type_id` smallint(5) UNSIGNED NOT NULL DEFAULT 0 COMMENT '属性分类id',
  `attr_index` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '0不需要检索 1关键字检索',
  `attr_type` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '下拉框展示给商家选择',
  `attr_input_type` tinyint(1) UNSIGNED NOT NULL DEFAULT 2 COMMENT '2多行文本框,平台属性录入方式',
  `attr_values` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '可选值列表',
  `order` tinyint(3) UNSIGNED NOT NULL DEFAULT 50 COMMENT '属性排序',
  PRIMARY KEY (`attr_id`) USING BTREE,
  INDEX `cat_id`(`type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品属性' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of b2c_goods_attribute
-- ----------------------------
INSERT INTO `b2c_goods_attribute` VALUES (1, '测试', 1, 1, 1, 2, '12', 50);
INSERT INTO `b2c_goods_attribute` VALUES (2, '312', 2, 1, 1, 2, 'rtewyre', 60);
INSERT INTO `b2c_goods_attribute` VALUES (3, 'wqew', 6, 0, 1, 23, 'dsds;dsfdsf;', 10);
INSERT INTO `b2c_goods_attribute` VALUES (4, '11', 6, 0, 0, 11, '11', 11);
INSERT INTO `b2c_goods_attribute` VALUES (5, '11', 6, 0, 0, 11, '11', 11);
INSERT INTO `b2c_goods_attribute` VALUES (6, '1', 1, 1, 1, 12, '1212', 12);
INSERT INTO `b2c_goods_attribute` VALUES (7, '121', 6, 0, 0, 12, '12', 21);
INSERT INTO `b2c_goods_attribute` VALUES (10, '11', 6, 0, 0, 11, '11', 12);

-- ----------------------------
-- Table structure for b2c_goods_browse
-- ----------------------------
DROP TABLE IF EXISTS `b2c_goods_browse`;
CREATE TABLE `b2c_goods_browse`  (
  `goods_id` int(11) NOT NULL COMMENT '商品ID',
  `member_id` int(11) NOT NULL COMMENT '会员ID',
  `browsetime` int(11) NOT NULL COMMENT '浏览时间',
  `gc_id` int(11) NOT NULL COMMENT '商品分类',
  `gc_id_1` int(11) NOT NULL COMMENT '商品一级分类',
  `gc_id_2` int(11) NOT NULL COMMENT '商品二级分类',
  `gc_id_3` int(11) NOT NULL COMMENT '商品三级分类',
  PRIMARY KEY (`goods_id`, `member_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品浏览历史表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for b2c_goods_category
-- ----------------------------
DROP TABLE IF EXISTS `b2c_goods_category`;
CREATE TABLE `b2c_goods_category`  (
  `id` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '商品分类id',
  `name` varchar(90) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '商品分类名称',
  `mobile_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '手机端显示的商品分类名',
  `parent_id` smallint(5) UNSIGNED NOT NULL DEFAULT 0 COMMENT '父id',
  `parent_id_path` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '家族图谱',
  `level` tinyint(1) NULL DEFAULT 0 COMMENT '等级',
  `sort_order` tinyint(1) UNSIGNED NOT NULL DEFAULT 50 COMMENT '顺序排序',
  `is_show` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '是否显示',
  `image` varchar(512) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '分类图片',
  `is_hot` tinyint(1) NULL DEFAULT 0 COMMENT '是否推荐为热门分类',
  `cat_group` tinyint(1) NULL DEFAULT 0 COMMENT '分类分组默认0',
  `commission` tinyint(2) NULL DEFAULT 0 COMMENT '佣金比例',
  `commission_rate` tinyint(1) NULL DEFAULT 0 COMMENT '分佣比例用于分销',
  `type_id` int(11) NULL DEFAULT 0 COMMENT '对应的类型id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `parent_id`(`parent_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 73 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品分类' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of b2c_goods_category
-- ----------------------------
INSERT INTO `b2c_goods_category` VALUES (1, '手机游戏', '手机游戏', 0, '0_1', 1, 1, 1, 'http://img0.imgtn.bdimg.com/it/u=2890875214,2860395108&fm=200&gp=0.jpg', 1, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (2, '电脑版网络游戏', '电脑版网络游戏', 0, '0_2', 1, 3, 0, 'http://img1.imgtn.bdimg.com/it/u=1018493182,3108903981&fm=200&gp=0.jpg', 0, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (3, '角色扮演', '角色扮演', 2, '0_2_3', 2, 0, 1, 'http://img4.imgtn.bdimg.com/it/u=3055716218,2031189246&fm=200&gp=0.jpg', 1, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (4, '电脑网页版网络游戏', '电脑网页版网络游戏', 0, '0_4', 1, 4, 0, 'http://img0.imgtn.bdimg.com/it/u=3780110955,1561831255&fm=200&gp=0.jpg', 0, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (5, '手机游戏', '手机游戏', 0, '0_1_5', 1, 2, 1, 'http://img0.imgtn.bdimg.com/it/u=2890875214,2860395108&fm=200&gp=0.jpg', 1, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (6, '棋牌游戏', '棋牌游戏', 1, '0_1_6', 2, 0, 0, 'http://img5.imgtn.bdimg.com/it/u=3695374973,1536915856&fm=200&gp=0.jpg', 0, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (7, '即时', '即时', 5, '0_1_5_7', 3, 0, 1, 'http://img2.imgtn.bdimg.com/it/u=3882264344,622295380&fm=200&gp=0.jpg', 1, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (8, '游戏开服广告套餐', '游戏开服广告套餐', 0, '0_8', 1, 5, 1, 'http://img2.imgtn.bdimg.com/it/u=3655225608,3562929096&fm=27&gp=0.jpg', 1, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (9, '回合', '回合', 5, '0_1_5_9', 3, 0, 1, 'http://img2.imgtn.bdimg.com/it/u=3056131684,1896878804&fm=27&gp=0.jpg', 1, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (10, '斗地主', '斗地主', 6, '0_1_6_10', 3, 0, 0, 'http://img3.imgtn.bdimg.com/it/u=550445438,3823160021&fm=200&gp=0.jpg', 0, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (11, '休闲娱乐', '休闲娱乐', 1, '0_1_11', 2, 0, 0, 'http://img5.imgtn.bdimg.com/it/u=3076921710,2190335961&fm=27&gp=0.jpg', 0, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (12, '动作射击', '动作射击', 1, '0_1_12', 2, 0, 0, 'http://img0.imgtn.bdimg.com/it/u=2890875214,2860395108&fm=200&gp=0.jpg', 0, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (13, '即时', '即时', 3, '0_2_3_13', 3, 0, 1, 'http://img1.imgtn.bdimg.com/it/u=1018493182,3108903981&fm=200&gp=0.jpg', 0, 0, 0, 0, 0);
INSERT INTO `b2c_goods_category` VALUES (14, '回合', '回合', 3, '0_2_3_14', 3, 0, 1, 'http://img4.imgtn.bdimg.com/it/u=3055716218,2031189246&fm=200&gp=0.jpg', 0, 0, 0, 0, 0);
INSERT INTO `b2c_goods_category` VALUES (15, 'RPG', 'RPG', 3, '0_2_3_15', 3, 0, 0, 'http://img0.imgtn.bdimg.com/it/u=3780110955,1561831255&fm=200&gp=0.jpg', 0, 0, 0, 0, 0);
INSERT INTO `b2c_goods_category` VALUES (16, '棋牌游戏', '棋牌游戏', 2, '0_2_16', 2, 0, 1, 'http://img0.imgtn.bdimg.com/it/u=1906276814,1517610826&fm=200&gp=0.jpg', 1, 0, 0, 0, 0);
INSERT INTO `b2c_goods_category` VALUES (17, '休闲娱乐', '休闲娱乐', 2, '0_2_17', 2, 0, 1, 'http://img5.imgtn.bdimg.com/it/u=3695374973,1536915856&fm=200&gp=0.jpg', 1, 0, 0, 0, 0);
INSERT INTO `b2c_goods_category` VALUES (18, '动作射击', '动作射击', 2, '0_2_18', 2, 0, 1, 'http://img2.imgtn.bdimg.com/it/u=3882264344,622295380&fm=200&gp=0.jpg', 1, 0, 0, 0, 0);
INSERT INTO `b2c_goods_category` VALUES (19, '角色扮演', '角色扮演', 4, '0_4_19', 2, 0, 1, 'http://img2.imgtn.bdimg.com/it/u=3655225608,3562929096&fm=27&gp=0.jpg', 1, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (20, '棋牌游戏', '棋牌游戏', 4, '0_4_20', 2, 0, 1, 'http://img2.imgtn.bdimg.com/it/u=3056131684,1896878804&fm=27&gp=0.jpg', 1, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (21, '休闲娱乐', '休闲娱乐', 4, '0_4_21', 2, 0, 1, 'http://img3.imgtn.bdimg.com/it/u=550445438,3823160021&fm=200&gp=0.jpg', 1, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (22, '动作射击', '动作射击', 4, '0_4_22', 2, 0, 1, 'http://img0.imgtn.bdimg.com/it/u=2890875214,2860395108&fm=200&gp=0.jpg', 1, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (23, '角色扮演', '角色扮演', 8, '0_8_23', 2, 0, 1, 'http://img1.imgtn.bdimg.com/it/u=1018493182,3108903981&fm=200&gp=0.jpg', 1, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (24, '棋牌游戏', '棋牌游戏', 8, '0_8_24', 2, 0, 0, 'http://img4.imgtn.bdimg.com/it/u=3055716218,2031189246&fm=200&gp=0.jpg', 0, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (25, '休闲娱乐', '休闲娱乐', 8, '0_8_25', 2, 0, 0, 'http://img0.imgtn.bdimg.com/it/u=3780110955,1561831255&fm=200&gp=0.jpg', 0, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (26, '动作射击', '动作射击', 8, '0_8_26', 2, 0, 0, 'http://img0.imgtn.bdimg.com/it/u=1906276814,1517610826&fm=200&gp=0.jpg', 0, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (27, '麻将', '麻将', 6, '0_1_6_27', 3, 0, 0, 'http://img5.imgtn.bdimg.com/it/u=3695374973,1536915856&fm=200&gp=0.jpg', 0, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (28, '扑克', '扑克', 6, '0_1_6_28', 3, 0, 0, 'http://img2.imgtn.bdimg.com/it/u=3882264344,622295380&fm=200&gp=0.jpg', 0, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (29, '跑酷', '跑酷', 11, '0_1_11_29', 3, 0, 0, 'http://img2.imgtn.bdimg.com/it/u=3655225608,3562929096&fm=27&gp=0.jpg', 0, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (30, '消除', '消除', 11, '0_1_11_30', 3, 0, 0, 'http://img2.imgtn.bdimg.com/it/u=3056131684,1896878804&fm=27&gp=0.jpg', 0, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (31, '捕鱼', '捕鱼', 11, '0_1_11_31', 3, 0, 0, '', 0, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (32, '枪战', '枪战', 12, '0_1_12_32', 3, 0, 1, '', 0, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (33, '飞行', '飞行', 12, '0_1_12_33', 3, 0, 1, 'http://img0.imgtn.bdimg.com/it/u=2890875214,2860395108&fm=200&gp=0.jpg', 0, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (34, '格斗', '格斗', 12, '0_1_12_34', 3, 0, 1, 'http://img1.imgtn.bdimg.com/it/u=1018493182,3108903981&fm=200&gp=0.jpg', 0, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (35, 'RPG', 'RPG', 5, '0_1_5_35', 3, 0, 1, 'http://img4.imgtn.bdimg.com/it/u=3055716218,2031189246&fm=200&gp=0.jpg', 1, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (36, 'RPG', 'RPG', 3, '0_2_3_36', 3, 0, 1, 'http://img0.imgtn.bdimg.com/it/u=3780110955,1561831255&fm=200&gp=0.jpg', 0, 0, 0, 0, 0);
INSERT INTO `b2c_goods_category` VALUES (37, '斗地主', '斗地主', 16, '0_2_16_37', 3, 0, 1, 'http://img0.imgtn.bdimg.com/it/u=1906276814,1517610826&fm=200&gp=0.jpg', 0, 0, 0, 0, 0);
INSERT INTO `b2c_goods_category` VALUES (38, '麻将', '麻将', 16, '0_2_16_38', 3, 0, 1, 'http://img5.imgtn.bdimg.com/it/u=3695374973,1536915856&fm=200&gp=0.jpg', 0, 0, 0, 0, 0);
INSERT INTO `b2c_goods_category` VALUES (39, '扑克', '扑克', 16, '0_2_16_39', 3, 0, 1, 'http://img2.imgtn.bdimg.com/it/u=3882264344,622295380&fm=200&gp=0.jpg', 0, 0, 0, 0, 0);
INSERT INTO `b2c_goods_category` VALUES (40, '跑酷', '跑酷', 17, '0_2_17_40', 3, 0, 1, 'http://img2.imgtn.bdimg.com/it/u=3655225608,3562929096&fm=27&gp=0.jpg', 0, 0, 0, 0, 0);
INSERT INTO `b2c_goods_category` VALUES (41, '消除', '消除', 17, '0_2_17_41', 3, 0, 1, 'http://img2.imgtn.bdimg.com/it/u=3056131684,1896878804&fm=27&gp=0.jpg', 0, 0, 0, 0, 0);
INSERT INTO `b2c_goods_category` VALUES (43, '枪战', '枪战', 18, '0_2_18_43', 3, 0, 1, 'http://img3.imgtn.bdimg.com/it/u=550445438,3823160021&fm=200&gp=0.jpg', 0, 0, 0, 0, 0);
INSERT INTO `b2c_goods_category` VALUES (44, '飞行', '飞行', 18, '0_2_18_44', 3, 0, 1, 'http://img5.imgtn.bdimg.com/it/u=3076921710,2190335961&fm=27&gp=0.jpg', 0, 0, 0, 0, 0);
INSERT INTO `b2c_goods_category` VALUES (45, '格斗', '格斗', 18, '0_2_18_45', 3, 0, 1, 'http://img0.imgtn.bdimg.com/it/u=2890875214,2860395108&fm=200&gp=0.jpg', 0, 0, 0, 0, 0);
INSERT INTO `b2c_goods_category` VALUES (46, '即时', '即时', 19, '0_4_19_46', 3, 0, 1, 'http://img1.imgtn.bdimg.com/it/u=1018493182,3108903981&fm=200&gp=0.jpg', 0, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (47, '回合', '回合', 19, '0_4_19_47', 3, 0, 1, 'http://img4.imgtn.bdimg.com/it/u=3055716218,2031189246&fm=200&gp=0.jpg', 0, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (48, 'RPG', 'RPG', 19, '0_4_19_48', 3, 0, 1, 'http://img0.imgtn.bdimg.com/it/u=3780110955,1561831255&fm=200&gp=0.jpg', 0, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (49, '斗地主', '斗地主', 20, '0_4_20_49', 3, 0, 1, 'http://img0.imgtn.bdimg.com/it/u=1906276814,1517610826&fm=200&gp=0.jpg', 0, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (50, '麻将', '麻将', 20, '0_4_20_50', 3, 0, 1, 'http://img5.imgtn.bdimg.com/it/u=3695374973,1536915856&fm=200&gp=0.jpg', 0, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (51, '扑克', '扑克', 20, '0_4_20_51', 3, 0, 1, 'http://img2.imgtn.bdimg.com/it/u=3882264344,622295380&fm=200&gp=0.jpg', 0, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (52, '跑酷', '跑酷', 21, '0_4_21_52', 3, 0, 1, 'http://img2.imgtn.bdimg.com/it/u=3655225608,3562929096&fm=27&gp=0.jpg', 0, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (53, '消除', '消除', 21, '0_4_21_53', 3, 0, 1, 'http://img2.imgtn.bdimg.com/it/u=3056131684,1896878804&fm=27&gp=0.jpg', 0, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (54, '捕鱼', '捕鱼', 21, '0_4_21_54', 3, 0, 1, 'http://img3.imgtn.bdimg.com/it/u=550445438,3823160021&fm=200&gp=0.jpg', 0, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (55, '枪战', '枪战', 22, '0_4_22_55', 3, 0, 1, 'http://img5.imgtn.bdimg.com/it/u=3076921710,2190335961&fm=27&gp=0.jpg', 0, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (56, '飞行', '飞行', 22, '0_4_22_56', 3, 0, 1, '', 0, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (57, '格斗', '格斗', 22, '0_4_22_57', 3, 0, 1, '', 0, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (58, '捕鱼', '捕鱼', 17, '0_2_17_58', 3, 0, 1, '', 0, 0, 0, 0, 0);
INSERT INTO `b2c_goods_category` VALUES (59, '即时', '即时', 23, '0_8_23_59', 3, 0, 1, 'http://img0.imgtn.bdimg.com/it/u=2890875214,2860395108&fm=200&gp=0.jpg', 1, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (60, '回合', '回合', 23, '0_8_23_60', 3, 0, 1, 'http://img1.imgtn.bdimg.com/it/u=1018493182,3108903981&fm=200&gp=0.jpg', 1, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (61, 'RPG', 'RPG', 23, '0_8_23_61', 3, 0, 1, 'http://img4.imgtn.bdimg.com/it/u=3055716218,2031189246&fm=200&gp=0.jpg', 1, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (62, '斗地主', '斗地主', 24, '0_8_24_62', 3, 0, 0, 'http://img0.imgtn.bdimg.com/it/u=3780110955,1561831255&fm=200&gp=0.jpg', 0, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (63, '麻将', '麻将', 24, '0_8_24_63', 3, 0, 0, 'http://img0.imgtn.bdimg.com/it/u=1906276814,1517610826&fm=200&gp=0.jpg', 0, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (64, '扑克', '扑克', 24, '0_8_24_64', 3, 0, 0, 'http://img5.imgtn.bdimg.com/it/u=3695374973,1536915856&fm=200&gp=0.jpg', 0, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (65, '跑酷', '跑酷', 25, '0_8_25_65', 3, 0, 0, 'http://img2.imgtn.bdimg.com/it/u=3882264344,622295380&fm=200&gp=0.jpg', 0, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (66, '消除', '消除', 25, '0_8_25_66', 3, 0, 0, 'http://img2.imgtn.bdimg.com/it/u=3655225608,3562929096&fm=27&gp=0.jpg', 0, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (67, '捕鱼', '捕鱼', 25, '0_8_25_67', 3, 0, 0, 'http://img2.imgtn.bdimg.com/it/u=3056131684,1896878804&fm=27&gp=0.jpg', 0, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (68, '枪战', '枪战', 26, '0_8_26_68', 3, 0, 1, 'http://img3.imgtn.bdimg.com/it/u=550445438,3823160021&fm=200&gp=0.jpg', 0, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (69, '飞行', '飞行', 26, '0_8_26_69', 3, 0, 1, 'http://img5.imgtn.bdimg.com/it/u=3076921710,2190335961&fm=27&gp=0.jpg', 0, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (70, '格斗', '格斗', 26, '0_8_26_70', 3, 0, 1, '', 0, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (71, '卡牌', '卡牌策略', 5, '0_1_5_71', 3, 0, 1, '/public/upload/category/2017/09-11/f5fe76578d35d054f6dcb66d4d5a379a.png', 1, 0, 0, 0, 1);
INSERT INTO `b2c_goods_category` VALUES (72, '卡牌', '卡牌', 23, '0_8_23_72', 3, 0, 1, '/public/upload/category/2017/09-11/1b3802e43c71cdd48467aa20e7f5a55b.png', 1, 0, 0, 0, 1);

-- ----------------------------
-- Table structure for b2c_goods_collect
-- ----------------------------
DROP TABLE IF EXISTS `b2c_goods_collect`;
CREATE TABLE `b2c_goods_collect`  (
  `collect_id` mediumint(8) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` mediumint(8) UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户id',
  `goods_id` mediumint(8) UNSIGNED NOT NULL DEFAULT 0 COMMENT '商品id',
  `cat_id3` mediumint(8) NOT NULL DEFAULT 0,
  `add_time` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '添加时间',
  PRIMARY KEY (`collect_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `goods_id`(`goods_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 42 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品收藏' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of b2c_goods_collect
-- ----------------------------
INSERT INTO `b2c_goods_collect` VALUES (1, 8, 2, 0, 1499418314);
INSERT INTO `b2c_goods_collect` VALUES (11, 9, 4, 0, 1500001334);
INSERT INTO `b2c_goods_collect` VALUES (28, 4, 3, 0, 1500449333);
INSERT INTO `b2c_goods_collect` VALUES (29, 13, 2, 0, 1500449665);
INSERT INTO `b2c_goods_collect` VALUES (31, 4, 2, 0, 1500449785);
INSERT INTO `b2c_goods_collect` VALUES (37, 10, 11, 0, 1501053130);
INSERT INTO `b2c_goods_collect` VALUES (40, 10, 14, 0, 1501126648);
INSERT INTO `b2c_goods_collect` VALUES (41, 10, 13, 0, 1501126655);

-- ----------------------------
-- Table structure for b2c_goods_consult
-- ----------------------------
DROP TABLE IF EXISTS `b2c_goods_consult`;
CREATE TABLE `b2c_goods_consult`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品咨询id',
  `goods_id` int(11) NULL DEFAULT 0 COMMENT '商品id',
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '网名',
  `add_time` int(11) NULL DEFAULT 0 COMMENT '咨询时间',
  `consult_type` tinyint(1) NULL DEFAULT 1 COMMENT '1 商品咨询 2 支付咨询 3 配送 4 售后',
  `content` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '咨询内容',
  `parent_id` int(11) NULL DEFAULT 0 COMMENT '父id 用于管理员回复',
  `store_id` int(11) NULL DEFAULT 0 COMMENT '店铺id',
  `is_show` tinyint(1) NULL DEFAULT 0 COMMENT '是否显示',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品咨询' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for b2c_goods_content
-- ----------------------------
DROP TABLE IF EXISTS `b2c_goods_content`;
CREATE TABLE `b2c_goods_content`  (
  `goods_content_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '商品详细id',
  `goods_id` int(11) UNSIGNED NOT NULL COMMENT '商品id',
  `goods_content` text CHARACTER SET utf16 COLLATE utf16_general_ci NULL COMMENT '商品详细描述',
  PRIMARY KEY (`goods_content_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for b2c_goods_coupon
-- ----------------------------
DROP TABLE IF EXISTS `b2c_goods_coupon`;
CREATE TABLE `b2c_goods_coupon`  (
  `coupon_id` int(8) NOT NULL COMMENT '优惠券id',
  `goods_id` int(11) NOT NULL DEFAULT 0 COMMENT '指定的商品id：为零表示不指定商品',
  `goods_category_id` smallint(5) NOT NULL DEFAULT 0 COMMENT '指定的商品分类：为零表示不指定分类',
  PRIMARY KEY (`coupon_id`, `goods_id`, `goods_category_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '商品与优惠券关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for b2c_goods_images
-- ----------------------------
DROP TABLE IF EXISTS `b2c_goods_images`;
CREATE TABLE `b2c_goods_images`  (
  `img_id` mediumint(8) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '图片id 自增',
  `goods_id` mediumint(8) UNSIGNED NOT NULL DEFAULT 0 COMMENT '商品id',
  `image_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '图片地址',
  `img_sort` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT 0 COMMENT '商品缩略图排序,最小的拍最前面',
  PRIMARY KEY (`img_id`) USING BTREE,
  INDEX `goods_id`(`goods_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品图片' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of b2c_goods_images
-- ----------------------------
INSERT INTO `b2c_goods_images` VALUES (5, 4, '/public/upload/goods/2017/07-04/7f29ac07e9289942c053219d7141ff62.jpg', 0);
INSERT INTO `b2c_goods_images` VALUES (6, 3, '/public/upload/goods/2017/07-04/960658da36634f58765f3b4c0f838cfa.jpg', 0);
INSERT INTO `b2c_goods_images` VALUES (7, 2, '/public/upload/goods/2017/07-04/6239e6c3937a13abf1a3f04f92eb7d59.jpg', 0);
INSERT INTO `b2c_goods_images` VALUES (8, 4, '/public/upload/goods/2017/07-04/02ba1e5f4864e70b868dfb83682746c5.jpg', 0);
INSERT INTO `b2c_goods_images` VALUES (9, 3, '/public/upload/goods/2017/07-04/e96e8886554c8fd4be4654639b183a08.png', 0);
INSERT INTO `b2c_goods_images` VALUES (10, 2, '/public/upload/goods/2017/07-05/7ea9e425be2c487eb4ca6390477c6f34.png', 0);
INSERT INTO `b2c_goods_images` VALUES (11, 1, '/public/upload/goods/2017/07-13/89e7fdb9bd8d32549570792c863e0843.png', 0);
INSERT INTO `b2c_goods_images` VALUES (12, 1, '/public/upload/goods/2017/07-14/76ef3ff81eba76d908724f7c29ab656a.jpg', 0);
INSERT INTO `b2c_goods_images` VALUES (13, 10, '/public/upload/goods/2017/07-18/1d11170ae2b2ae5d3511234fd9798177.png', 0);
INSERT INTO `b2c_goods_images` VALUES (14, 9, '/public/upload/goods/2017/07-18/b3bee9304a6d3fe603bc986e52d3544b.jpg', 0);
INSERT INTO `b2c_goods_images` VALUES (15, 8, '/public/upload/goods/2017/07-18/66e4981369093457fdf571a50f5cb423.jpg', 0);
INSERT INTO `b2c_goods_images` VALUES (16, 12, '/public/upload/goods/2017/07-18/36ef2070b2980e6f10aeddf220a0ddc0.jpg', 0);
INSERT INTO `b2c_goods_images` VALUES (17, 11, '/public/upload/goods/2017/07-18/51906c9967ca8b358e9e376007466d7f.jpg', 0);
INSERT INTO `b2c_goods_images` VALUES (18, 13, '/public/upload/goods/2017/07-18/06a1c463da41196ac913f6e1a320c3b3.jpg', 0);
INSERT INTO `b2c_goods_images` VALUES (19, 14, '/public/upload/goods/2017/07-18/e17df46fe988db1eb35741075e426133.jpg', 0);
INSERT INTO `b2c_goods_images` VALUES (20, 16, '/public/upload/goods/2017/08-04/1cb2f5678a4f7de94b03583386068e9d.jpg', 0);
INSERT INTO `b2c_goods_images` VALUES (26, 22, '/public/upload/goods/2017/08-24/d8026cb55a5d4c58508c29672dacb4fb.png', 0);
INSERT INTO `b2c_goods_images` VALUES (27, 23, '/public/upload/goods/2017/08-31/f258cfa1c232783b441541d73d46e57d.png', 0);
INSERT INTO `b2c_goods_images` VALUES (28, 24, '/public/upload/goods/2017/08-31/0f1b2ce37d5923859137c3c0ae109c7e.png', 0);
INSERT INTO `b2c_goods_images` VALUES (29, 25, '/public/upload/goods/2017/09-11/bc72792ba1fc975dfc2743d4b194c8a2.png', 0);
INSERT INTO `b2c_goods_images` VALUES (30, 27, '/public/upload/goods/2017/09-12/8cbfee55ec378c49f781659ab7163ef2.png', 0);
INSERT INTO `b2c_goods_images` VALUES (31, 26, '/public/upload/goods/2017/09-12/019c930271f4e4d2c4be68f73c1b7dea.png', 0);

-- ----------------------------
-- Table structure for b2c_goods_type
-- ----------------------------
DROP TABLE IF EXISTS `b2c_goods_type`;
CREATE TABLE `b2c_goods_type`  (
  `id` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id自增',
  `name` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '类型名称',
  `cat_id1` smallint(5) NULL DEFAULT 0 COMMENT '一级分类id',
  `cat_id2` smallint(5) NULL DEFAULT 0 COMMENT '二级分类id',
  `cat_id3` smallint(5) NULL DEFAULT 0 COMMENT '三级分类id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品类型（模型）' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of b2c_goods_type
-- ----------------------------
INSERT INTO `b2c_goods_type` VALUES (1, '服务器', 0, 0, 0);
INSERT INTO `b2c_goods_type` VALUES (3, '121', 4, 21, 54);

-- ----------------------------
-- Table structure for b2c_goods_visit
-- ----------------------------
DROP TABLE IF EXISTS `b2c_goods_visit`;
CREATE TABLE `b2c_goods_visit`  (
  `goods_id` int(11) NOT NULL COMMENT '商品ID',
  `user_id` int(11) NOT NULL COMMENT '会员ID',
  `visittime` int(11) NOT NULL COMMENT '浏览时间',
  `cat_id1` int(11) NOT NULL COMMENT '商品一级分类',
  `cat_id2` int(11) NOT NULL COMMENT '商品二级分类',
  `cat_id3` int(11) NOT NULL COMMENT '商品三级分类',
  `visit_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  PRIMARY KEY (`goods_id`, `user_id`, `visit_id`) USING BTREE,
  INDEX `visit_id`(`visit_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 117 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品浏览历史表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of b2c_goods_visit
-- ----------------------------
INSERT INTO `b2c_goods_visit` VALUES (1, 2, 1498463474, 1, 5, 7, 2);
INSERT INTO `b2c_goods_visit` VALUES (1, 3, 1498463873, 1, 5, 7, 1);
INSERT INTO `b2c_goods_visit` VALUES (1, 4, 1500862319, 1, 5, 7, 34);
INSERT INTO `b2c_goods_visit` VALUES (1, 6, 1499310149, 1, 5, 7, 11);
INSERT INTO `b2c_goods_visit` VALUES (1, 8, 1500256101, 1, 5, 7, 41);
INSERT INTO `b2c_goods_visit` VALUES (1, 9, 1501741066, 1, 5, 7, 21);
INSERT INTO `b2c_goods_visit` VALUES (1, 10, 1501147346, 1, 5, 7, 94);
INSERT INTO `b2c_goods_visit` VALUES (1, 11, 1502678119, 1, 5, 7, 40);
INSERT INTO `b2c_goods_visit` VALUES (1, 15, 1500603369, 1, 5, 7, 83);
INSERT INTO `b2c_goods_visit` VALUES (1, 17, 1505123194, 1, 5, 7, 115);
INSERT INTO `b2c_goods_visit` VALUES (2, 1, 1499841198, 1, 5, 7, 32);
INSERT INTO `b2c_goods_visit` VALUES (2, 4, 1500623510, 1, 5, 7, 33);
INSERT INTO `b2c_goods_visit` VALUES (2, 8, 1500284691, 1, 5, 7, 29);
INSERT INTO `b2c_goods_visit` VALUES (2, 9, 1500618205, 1, 5, 7, 20);
INSERT INTO `b2c_goods_visit` VALUES (2, 10, 1501147866, 1, 5, 7, 97);
INSERT INTO `b2c_goods_visit` VALUES (2, 11, 1502351920, 1, 5, 7, 39);
INSERT INTO `b2c_goods_visit` VALUES (2, 13, 1501752933, 1, 5, 7, 105);
INSERT INTO `b2c_goods_visit` VALUES (2, 14, 1500451630, 1, 5, 7, 71);
INSERT INTO `b2c_goods_visit` VALUES (2, 15, 1500603286, 1, 5, 7, 78);
INSERT INTO `b2c_goods_visit` VALUES (3, 1, 1499840936, 1, 5, 7, 31);
INSERT INTO `b2c_goods_visit` VALUES (3, 4, 1502678483, 1, 5, 7, 35);
INSERT INTO `b2c_goods_visit` VALUES (3, 7, 1499755417, 1, 5, 7, 24);
INSERT INTO `b2c_goods_visit` VALUES (3, 8, 1500256717, 1, 5, 7, 22);
INSERT INTO `b2c_goods_visit` VALUES (3, 9, 1501735142, 1, 5, 7, 19);
INSERT INTO `b2c_goods_visit` VALUES (3, 11, 1502673057, 1, 5, 7, 38);
INSERT INTO `b2c_goods_visit` VALUES (4, 1, 1499841902, 1, 5, 7, 30);
INSERT INTO `b2c_goods_visit` VALUES (4, 4, 1500622317, 1, 5, 7, 36);
INSERT INTO `b2c_goods_visit` VALUES (4, 7, 1499758203, 1, 5, 7, 10);
INSERT INTO `b2c_goods_visit` VALUES (4, 8, 1500284599, 1, 5, 7, 25);
INSERT INTO `b2c_goods_visit` VALUES (4, 9, 1500618743, 1, 5, 7, 18);
INSERT INTO `b2c_goods_visit` VALUES (4, 10, 1501052849, 1, 5, 7, 91);
INSERT INTO `b2c_goods_visit` VALUES (4, 11, 1502678174, 1, 5, 7, 37);
INSERT INTO `b2c_goods_visit` VALUES (4, 14, 1500451592, 1, 5, 7, 70);
INSERT INTO `b2c_goods_visit` VALUES (5, 4, 1500448025, 1, 5, 7, 67);
INSERT INTO `b2c_goods_visit` VALUES (5, 8, 1500258548, 1, 5, 7, 42);
INSERT INTO `b2c_goods_visit` VALUES (5, 9, 1501735145, 1, 5, 7, 101);
INSERT INTO `b2c_goods_visit` VALUES (5, 10, 1501052726, 1, 5, 7, 90);
INSERT INTO `b2c_goods_visit` VALUES (5, 11, 1502349993, 1, 5, 7, 43);
INSERT INTO `b2c_goods_visit` VALUES (5, 15, 1500603372, 1, 5, 7, 84);
INSERT INTO `b2c_goods_visit` VALUES (6, 4, 1500624344, 2, 3, 13, 61);
INSERT INTO `b2c_goods_visit` VALUES (6, 7, 1500449145, 2, 3, 13, 69);
INSERT INTO `b2c_goods_visit` VALUES (6, 9, 1502074169, 2, 3, 14, 44);
INSERT INTO `b2c_goods_visit` VALUES (6, 11, 1500287419, 2, 3, 13, 48);
INSERT INTO `b2c_goods_visit` VALUES (6, 13, 1501831203, 2, 3, 13, 103);
INSERT INTO `b2c_goods_visit` VALUES (6, 14, 1501748433, 2, 3, 13, 104);
INSERT INTO `b2c_goods_visit` VALUES (6, 15, 1500603354, 2, 3, 13, 81);
INSERT INTO `b2c_goods_visit` VALUES (7, 9, 1500631819, 4, 21, 52, 87);
INSERT INTO `b2c_goods_visit` VALUES (7, 10, 1501147392, 4, 21, 52, 95);
INSERT INTO `b2c_goods_visit` VALUES (8, 4, 1500449473, 1, 5, 7, 66);
INSERT INTO `b2c_goods_visit` VALUES (8, 9, 1502074135, 2, 3, 13, 85);
INSERT INTO `b2c_goods_visit` VALUES (8, 13, 1501749428, 1, 5, 7, 72);
INSERT INTO `b2c_goods_visit` VALUES (8, 15, 1500603348, 2, 3, 13, 79);
INSERT INTO `b2c_goods_visit` VALUES (9, 4, 1500621074, 2, 3, 13, 58);
INSERT INTO `b2c_goods_visit` VALUES (9, 8, 1500288305, 2, 3, 13, 49);
INSERT INTO `b2c_goods_visit` VALUES (9, 10, 1501147886, 2, 3, 13, 98);
INSERT INTO `b2c_goods_visit` VALUES (9, 11, 1502678265, 2, 3, 13, 63);
INSERT INTO `b2c_goods_visit` VALUES (9, 13, 1501808972, 2, 3, 13, 74);
INSERT INTO `b2c_goods_visit` VALUES (9, 14, 1500453857, 2, 3, 13, 73);
INSERT INTO `b2c_goods_visit` VALUES (9, 15, 1500603351, 2, 3, 13, 80);
INSERT INTO `b2c_goods_visit` VALUES (10, 4, 1500623948, 2, 18, 45, 75);
INSERT INTO `b2c_goods_visit` VALUES (10, 11, 1500360293, 2, 18, 45, 52);
INSERT INTO `b2c_goods_visit` VALUES (11, 4, 1500447924, 2, 17, 41, 68);
INSERT INTO `b2c_goods_visit` VALUES (11, 9, 1501744710, 2, 17, 41, 86);
INSERT INTO `b2c_goods_visit` VALUES (11, 10, 1501053128, 2, 17, 41, 92);
INSERT INTO `b2c_goods_visit` VALUES (11, 11, 1502677041, 2, 17, 41, 100);
INSERT INTO `b2c_goods_visit` VALUES (11, 14, 1500622069, 2, 17, 41, 62);
INSERT INTO `b2c_goods_visit` VALUES (11, 15, 1500603363, 2, 17, 41, 82);
INSERT INTO `b2c_goods_visit` VALUES (12, 9, 1501746800, 4, 22, 56, 88);
INSERT INTO `b2c_goods_visit` VALUES (12, 10, 1501147619, 4, 22, 56, 96);
INSERT INTO `b2c_goods_visit` VALUES (12, 11, 1502677045, 4, 22, 56, 99);
INSERT INTO `b2c_goods_visit` VALUES (12, 13, 1501830046, 4, 22, 56, 106);
INSERT INTO `b2c_goods_visit` VALUES (12, 14, 1501836755, 4, 22, 56, 55);
INSERT INTO `b2c_goods_visit` VALUES (13, 10, 1501053244, 4, 22, 56, 89);
INSERT INTO `b2c_goods_visit` VALUES (14, 4, 1500458196, 4, 22, 56, 76);
INSERT INTO `b2c_goods_visit` VALUES (14, 7, 1500601927, 4, 22, 56, 77);
INSERT INTO `b2c_goods_visit` VALUES (14, 10, 1501053253, 4, 22, 56, 93);
INSERT INTO `b2c_goods_visit` VALUES (14, 14, 1500376491, 4, 22, 56, 56);
INSERT INTO `b2c_goods_visit` VALUES (15, 14, 1501836426, 2, 17, 41, 102);
INSERT INTO `b2c_goods_visit` VALUES (16, 13, 1501839213, 2, 3, 13, 107);
INSERT INTO `b2c_goods_visit` VALUES (17, 11, 1504061729, 1, 5, 7, 108);
INSERT INTO `b2c_goods_visit` VALUES (17, 17, 1502681260, 1, 5, 7, 110);
INSERT INTO `b2c_goods_visit` VALUES (18, 14, 1502695833, 1, 5, 7, 112);
INSERT INTO `b2c_goods_visit` VALUES (18, 17, 1502682095, 1, 5, 7, 111);
INSERT INTO `b2c_goods_visit` VALUES (19, 11, 1502681196, 1, 5, 7, 109);
INSERT INTO `b2c_goods_visit` VALUES (19, 19, 1502766736, 1, 5, 7, 113);
INSERT INTO `b2c_goods_visit` VALUES (20, 11, 1504061746, 1, 5, 7, 114);
INSERT INTO `b2c_goods_visit` VALUES (23, 17, 1505124711, 1, 5, 35, 116);

-- ----------------------------
-- Table structure for b2c_spec
-- ----------------------------
DROP TABLE IF EXISTS `b2c_spec`;
CREATE TABLE `b2c_spec`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '规格表',
  `name` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规格名称',
  `order` int(11) NULL DEFAULT 50 COMMENT '排序',
  `search_index` tinyint(1) NULL DEFAULT 0 COMMENT '是否需要检索',
  `cat_id1` int(11) NULL DEFAULT 0 COMMENT '一级分类',
  `cat_id2` int(11) NULL DEFAULT 0 COMMENT '二级分类',
  `cat_id3` int(11) NULL DEFAULT 0 COMMENT '三级分类',
  `spec_val_type` tinyint(1) NULL DEFAULT NULL COMMENT '规格值类型',
  `spec_val` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '规格值内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品规格' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of b2c_spec
-- ----------------------------
INSERT INTO `b2c_spec` VALUES (1, '开服时长', 50, 1, 1, 6, 27, 2, '1:3个月\r\n2:6个月\r\n3:9个月\r\n4:12个月');
INSERT INTO `b2c_spec` VALUES (2, '承载在线', 50, 0, 5, 71, 0, 2, '1:500人在线\r\n2:1000人在线\r\n3:1500人在线\r\n4:2500人在线');
INSERT INTO `b2c_spec` VALUES (3, '开服频率', 50, 0, 8, 26, 70, 2, '1:10天1服\r\n2:1周1服\r\n3:1天1服');
INSERT INTO `b2c_spec` VALUES (4, '121', 212, 1, 0, 0, 0, 1, '1212\n');
INSERT INTO `b2c_spec` VALUES (5, '开服时长', 50, 1, 8, 26, 70, 2, '1:3个月\r\n2:6个月\r\n3:9个月\r\n4:12个月');
INSERT INTO `b2c_spec` VALUES (6, '承载在线', 50, 1, 8, 26, 70, 2, '1:500人在线\r\n2:1000人在线\r\n3:1500人在线\r\n4:2500人在线');

-- ----------------------------
-- Table structure for b2c_spec_goods_price
-- ----------------------------
DROP TABLE IF EXISTS `b2c_spec_goods_price`;
CREATE TABLE `b2c_spec_goods_price`  (
  `item_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '规格商品id',
  `goods_id` int(11) NULL DEFAULT 0 COMMENT '商品id',
  `goods_mark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品规格备注',
  `key` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '规格键名',
  `key_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '规格键名中文',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `store_count` int(11) UNSIGNED NULL DEFAULT 10 COMMENT '库存数量',
  `bar_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '商品条形码',
  `sku` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'SKU',
  `store_id` int(11) NULL DEFAULT 0 COMMENT '店铺商家id',
  `spec_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规格商品主图',
  `prom_id` int(10) NULL DEFAULT 0 COMMENT '参加活动id',
  `prom_type` tinyint(2) NULL DEFAULT 0 COMMENT '参加活动类型',
  PRIMARY KEY (`item_id`) USING BTREE,
  INDEX `gk`(`goods_id`, `key`) USING BTREE,
  INDEX `goods_id`(`goods_id`) USING BTREE,
  INDEX `store_id`(`store_id`) USING BTREE,
  INDEX `key`(`key`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 258 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品规格对应价格表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of b2c_spec_goods_price
-- ----------------------------
INSERT INTO `b2c_spec_goods_price` VALUES (229, 3, NULL, '16_19', '承载在线:500人在线 开服时长:3个月', 100.00, 7, '', '', 2, NULL, 0, 0);
INSERT INTO `b2c_spec_goods_price` VALUES (230, 3, NULL, '17_19', '承载在线:1000人在线 开服时长:3个月', 200.00, 9, '', '', 2, NULL, 0, 0);
INSERT INTO `b2c_spec_goods_price` VALUES (231, 3, NULL, '18_19', '承载在线:1500人在线 开服时长:3个月', 300.00, 11, '', '', 2, NULL, 0, 0);
INSERT INTO `b2c_spec_goods_price` VALUES (232, 3, NULL, '16_20', '承载在线:500人在线 开服时长:6个月', 200.00, 13, '', '', 2, NULL, 0, 0);
INSERT INTO `b2c_spec_goods_price` VALUES (233, 3, NULL, '17_20', '承载在线:1000人在线 开服时长:6个月', 400.00, 12, '', '', 2, NULL, 0, 0);
INSERT INTO `b2c_spec_goods_price` VALUES (234, 3, NULL, '18_20', '承载在线:1500人在线 开服时长:6个月', 600.00, 15, '', '', 2, NULL, 0, 0);
INSERT INTO `b2c_spec_goods_price` VALUES (237, 4, NULL, '16_19', '承载在线:500人在线 开服时长:3个月', 10.00, 985, '', '', 2, NULL, 0, 0);
INSERT INTO `b2c_spec_goods_price` VALUES (238, 4, NULL, '16_20', '承载在线:500人在线 开服时长:6个月', 10.00, 100, '', '', 2, NULL, 0, 0);
INSERT INTO `b2c_spec_goods_price` VALUES (240, 6, NULL, '16_19_27', '承载在线:500人在线 开服时长:3个月 开服频率:10天1服', 100.00, 100, '', '', 2, NULL, 0, 0);
INSERT INTO `b2c_spec_goods_price` VALUES (241, 6, NULL, '17_19_27', '承载在线:1000人在线 开服时长:3个月 开服频率:10天1服', 200.00, 100, '', '', 2, NULL, 0, 0);
INSERT INTO `b2c_spec_goods_price` VALUES (242, 6, NULL, '18_19_27', '承载在线:1500人在线 开服时长:3个月 开服频率:10天1服', 300.00, 100, '', '', 2, NULL, 0, 0);
INSERT INTO `b2c_spec_goods_price` VALUES (243, 6, NULL, '16_19_28', '承载在线:500人在线 开服时长:3个月 开服频率:1周1服', 50.00, 100, '', '', 2, NULL, 0, 0);
INSERT INTO `b2c_spec_goods_price` VALUES (244, 6, NULL, '17_19_28', '承载在线:1000人在线 开服时长:3个月 开服频率:1周1服', 100.00, 100, '', '', 2, NULL, 0, 0);
INSERT INTO `b2c_spec_goods_price` VALUES (245, 6, NULL, '18_19_28', '承载在线:1500人在线 开服时长:3个月 开服频率:1周1服', 150.00, 100, '', '', 2, NULL, 0, 0);
INSERT INTO `b2c_spec_goods_price` VALUES (246, 6, NULL, '16_19_29', '承载在线:500人在线 开服时长:3个月 开服频率:1天1服', 10.00, 100, '', '', 2, NULL, 0, 0);
INSERT INTO `b2c_spec_goods_price` VALUES (247, 6, NULL, '17_19_29', '承载在线:1000人在线 开服时长:3个月 开服频率:1天1服', 20.00, 100, '', '', 2, NULL, 0, 0);
INSERT INTO `b2c_spec_goods_price` VALUES (248, 6, NULL, '18_19_29', '承载在线:1500人在线 开服时长:3个月 开服频率:1天1服', 30.00, 100, '', '', 2, NULL, 0, 0);
INSERT INTO `b2c_spec_goods_price` VALUES (249, 6, NULL, '16_20_27', '承载在线:500人在线 开服时长:6个月 开服频率:10天1服', 200.00, 100, '', '', 2, NULL, 0, 0);
INSERT INTO `b2c_spec_goods_price` VALUES (250, 6, NULL, '17_20_27', '承载在线:1000人在线 开服时长:6个月 开服频率:10天1服', 400.00, 100, '', '', 2, NULL, 0, 0);
INSERT INTO `b2c_spec_goods_price` VALUES (251, 6, NULL, '18_20_27', '承载在线:1500人在线 开服时长:6个月 开服频率:10天1服', 600.00, 100, '', '', 2, NULL, 0, 0);
INSERT INTO `b2c_spec_goods_price` VALUES (252, 6, NULL, '16_20_28', '承载在线:500人在线 开服时长:6个月 开服频率:1周1服', 100.00, 100, '', '', 2, NULL, 0, 0);
INSERT INTO `b2c_spec_goods_price` VALUES (253, 6, NULL, '17_20_28', '承载在线:1000人在线 开服时长:6个月 开服频率:1周1服', 200.00, 100, '', '', 2, NULL, 0, 0);
INSERT INTO `b2c_spec_goods_price` VALUES (254, 6, NULL, '18_20_28', '承载在线:1500人在线 开服时长:6个月 开服频率:1周1服', 300.00, 100, '', '', 2, NULL, 0, 0);
INSERT INTO `b2c_spec_goods_price` VALUES (255, 6, NULL, '16_20_29', '承载在线:500人在线 开服时长:6个月 开服频率:1天1服', 20.00, 100, '', '', 2, NULL, 0, 0);
INSERT INTO `b2c_spec_goods_price` VALUES (256, 6, NULL, '17_20_29', '承载在线:1000人在线 开服时长:6个月 开服频率:1天1服', 40.00, 100, '', '', 2, NULL, 0, 0);
INSERT INTO `b2c_spec_goods_price` VALUES (257, 6, NULL, '18_20_29', '承载在线:1500人在线 开服时长:6个月 开服频率:1天1服', 60.00, 100, '', '', 2, NULL, 0, 0);

-- ----------------------------
-- Table structure for b2c_spec_image
-- ----------------------------
DROP TABLE IF EXISTS `b2c_spec_image`;
CREATE TABLE `b2c_spec_image`  (
  `goods_id` int(11) NULL DEFAULT 0 COMMENT '商品规格图片表id',
  `spec_image_id` int(11) NULL DEFAULT 0 COMMENT '规格项id',
  `src` varchar(512) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '商品规格图片路径',
  `store_id` int(11) NULL DEFAULT 0 COMMENT '商家id',
  INDEX `goods_id`(`goods_id`) USING BTREE,
  INDEX `spec_img_id`(`spec_image_id`) USING BTREE,
  INDEX `store_id`(`store_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品规格图片' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for b2c_spec_item
-- ----------------------------
DROP TABLE IF EXISTS `b2c_spec_item`;
CREATE TABLE `b2c_spec_item`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '规格项id',
  `spec_id` int(11) NULL DEFAULT NULL COMMENT '规格id',
  `item` varchar(54) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规格项',
  `store_id` int(11) NULL DEFAULT 0 COMMENT '商家id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `spec_id`(`spec_id`) USING BTREE,
  INDEX `item`(`item`) USING BTREE,
  INDEX `store_id`(`store_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品规格值' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of b2c_spec_item
-- ----------------------------
INSERT INTO `b2c_spec_item` VALUES (16, 2, '500人在线', 2);
INSERT INTO `b2c_spec_item` VALUES (17, 2, '1000人在线', 2);
INSERT INTO `b2c_spec_item` VALUES (18, 2, '1500人在线', 2);
INSERT INTO `b2c_spec_item` VALUES (19, 1, '3个月', 2);
INSERT INTO `b2c_spec_item` VALUES (20, 1, '6个月', 2);
INSERT INTO `b2c_spec_item` VALUES (27, 3, '10天1服', 2);
INSERT INTO `b2c_spec_item` VALUES (28, 3, '1周1服', 2);
INSERT INTO `b2c_spec_item` VALUES (29, 3, '1天1服', 2);

-- ----------------------------
-- Table structure for b2c_spec_type
-- ----------------------------
DROP TABLE IF EXISTS `b2c_spec_type`;
CREATE TABLE `b2c_spec_type`  (
  `type_id` int(10) UNSIGNED NOT NULL COMMENT '类型id',
  `spec_id` int(10) UNSIGNED NOT NULL COMMENT '规格id'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品类型与规格对应表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of b2c_spec_type
-- ----------------------------
INSERT INTO `b2c_spec_type` VALUES (1, 1);
INSERT INTO `b2c_spec_type` VALUES (1, 2);
INSERT INTO `b2c_spec_type` VALUES (1, 3);

-- ----------------------------
-- Table structure for b_user
-- ----------------------------
DROP TABLE IF EXISTS `b_user`;
CREATE TABLE `b_user`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `mobile` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of b_user
-- ----------------------------
INSERT INTO `b_user` VALUES (1, 'mark', '13612345678', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '2017-03-23 22:37:41');

-- ----------------------------
-- Table structure for qrtz_blob_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_blob_triggers`;
CREATE TABLE `qrtz_blob_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `BLOB_DATA` blob NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `SCHED_NAME`(`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for qrtz_calendars
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_calendars`;
CREATE TABLE `qrtz_calendars`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CALENDAR_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `CALENDAR_NAME`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for qrtz_cron_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_cron_triggers`;
CREATE TABLE `qrtz_cron_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CRON_EXPRESSION` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TIME_ZONE_ID` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_cron_triggers
-- ----------------------------
INSERT INTO `qrtz_cron_triggers` VALUES ('B2cshopScheduler', 'TASK_1', 'DEFAULT', '0 0/30 * * * ?', 'Asia/Shanghai');
INSERT INTO `qrtz_cron_triggers` VALUES ('B2cshopScheduler', 'TASK_2', 'DEFAULT', '0 0/30 * * * ?', 'Asia/Shanghai');
INSERT INTO `qrtz_cron_triggers` VALUES ('RenrenScheduler', 'TASK_1', 'DEFAULT', '0 0/30 * * * ?', 'Asia/Shanghai');
INSERT INTO `qrtz_cron_triggers` VALUES ('RenrenScheduler', 'TASK_2', 'DEFAULT', '0 0/30 * * * ?', 'Asia/Shanghai');

-- ----------------------------
-- Table structure for qrtz_fired_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_fired_triggers`;
CREATE TABLE `qrtz_fired_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ENTRY_ID` varchar(95) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `INSTANCE_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `JOB_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`, `ENTRY_ID`) USING BTREE,
  INDEX `IDX_QRTZ_FT_TRIG_INST_NAME`(`SCHED_NAME`, `INSTANCE_NAME`) USING BTREE,
  INDEX `IDX_QRTZ_FT_INST_JOB_REQ_RCVRY`(`SCHED_NAME`, `INSTANCE_NAME`, `REQUESTS_RECOVERY`) USING BTREE,
  INDEX `IDX_QRTZ_FT_J_G`(`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_FT_JG`(`SCHED_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_FT_T_G`(`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_FT_TG`(`SCHED_NAME`, `TRIGGER_GROUP`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for qrtz_job_details
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_job_details`;
CREATE TABLE `qrtz_job_details`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `DESCRIPTION` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `IS_DURABLE` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `IS_NONCONCURRENT` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `IS_UPDATE_DATA` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_DATA` blob NULL,
  PRIMARY KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_J_REQ_RECOVERY`(`SCHED_NAME`, `REQUESTS_RECOVERY`) USING BTREE,
  INDEX `IDX_QRTZ_J_GRP`(`SCHED_NAME`, `JOB_GROUP`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_job_details
-- ----------------------------
INSERT INTO `qrtz_job_details` VALUES ('B2cshopScheduler', 'TASK_1', 'DEFAULT', NULL, 'com.b2cshop.modules.job.utils.ScheduleJob', '0', '0', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B455973720030636F6D2E62326373686F702E6D6F64756C65732E6A6F622E656E746974792E5363686564756C654A6F62456E7469747900000000000000010200084C00086265616E4E616D657400124C6A6176612F6C616E672F537472696E673B4C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C000E63726F6E45787072657373696F6E71007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C000A6D6574686F644E616D6571007E00094C0006706172616D7371007E00094C000672656D61726B71007E00094C00067374617475737400134C6A6176612F6C616E672F496E74656765723B7870740008746573745461736B7372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000158BAF593307874000E3020302F3330202A202A202A203F7372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B020000787000000000000000017400047465737474000672656E72656E74000FE69C89E58F82E695B0E6B58BE8AF95737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C75657871007E0013000000007800);
INSERT INTO `qrtz_job_details` VALUES ('B2cshopScheduler', 'TASK_2', 'DEFAULT', NULL, 'com.b2cshop.modules.job.utils.ScheduleJob', '0', '0', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B455973720030636F6D2E62326373686F702E6D6F64756C65732E6A6F622E656E746974792E5363686564756C654A6F62456E7469747900000000000000010200084C00086265616E4E616D657400124C6A6176612F6C616E672F537472696E673B4C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C000E63726F6E45787072657373696F6E71007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C000A6D6574686F644E616D6571007E00094C0006706172616D7371007E00094C000672656D61726B71007E00094C00067374617475737400134C6A6176612F6C616E672F496E74656765723B7870740008746573745461736B7372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000158C377C4607874000E3020302F3330202A202A202A203F7372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B0200007870000000000000000274000574657374327074000FE697A0E58F82E695B0E6B58BE8AF95737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C75657871007E0013000000017800);
INSERT INTO `qrtz_job_details` VALUES ('RenrenScheduler', 'TASK_1', 'DEFAULT', NULL, 'com.b2cshop.modules.job.utils.ScheduleJob', '0', '0', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B45597372002E696F2E72656E72656E2E6D6F64756C65732E6A6F622E656E746974792E5363686564756C654A6F62456E7469747900000000000000010200084C00086265616E4E616D657400124C6A6176612F6C616E672F537472696E673B4C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C000E63726F6E45787072657373696F6E71007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C000A6D6574686F644E616D6571007E00094C0006706172616D7371007E00094C000672656D61726B71007E00094C00067374617475737400134C6A6176612F6C616E672F496E74656765723B7870740008746573745461736B7372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000158BAF593307874000E3020302F3330202A202A202A203F7372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B020000787000000000000000017400047465737474000672656E72656E74000FE69C89E58F82E695B0E6B58BE8AF95737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C75657871007E0013000000007800);
INSERT INTO `qrtz_job_details` VALUES ('RenrenScheduler', 'TASK_2', 'DEFAULT', NULL, 'com.b2cshop.modules.job.utils.ScheduleJob', '0', '0', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B45597372002E696F2E72656E72656E2E6D6F64756C65732E6A6F622E656E746974792E5363686564756C654A6F62456E7469747900000000000000010200084C00086265616E4E616D657400124C6A6176612F6C616E672F537472696E673B4C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C000E63726F6E45787072657373696F6E71007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C000A6D6574686F644E616D6571007E00094C0006706172616D7371007E00094C000672656D61726B71007E00094C00067374617475737400134C6A6176612F6C616E672F496E74656765723B7870740008746573745461736B7372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000158C377C4607874000E3020302F3330202A202A202A203F7372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B0200007870000000000000000274000574657374327074000FE697A0E58F82E695B0E6B58BE8AF95737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C75657871007E0013000000017800);

-- ----------------------------
-- Table structure for qrtz_locks
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_locks`;
CREATE TABLE `qrtz_locks`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `LOCK_NAME` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `LOCK_NAME`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_locks
-- ----------------------------
INSERT INTO `qrtz_locks` VALUES ('B2cshopScheduler', 'STATE_ACCESS');
INSERT INTO `qrtz_locks` VALUES ('B2cshopScheduler', 'TRIGGER_ACCESS');
INSERT INTO `qrtz_locks` VALUES ('B2shopScheduler', 'STATE_ACCESS');
INSERT INTO `qrtz_locks` VALUES ('B2shopScheduler', 'TRIGGER_ACCESS');

-- ----------------------------
-- Table structure for qrtz_paused_trigger_grps
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
CREATE TABLE `qrtz_paused_trigger_grps`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_GROUP`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for qrtz_scheduler_state
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_scheduler_state`;
CREATE TABLE `qrtz_scheduler_state`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `INSTANCE_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `INSTANCE_NAME`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_scheduler_state
-- ----------------------------
INSERT INTO `qrtz_scheduler_state` VALUES ('B2cshopScheduler', 'DESKTOP-2A5688B1523433362999', 1523435157426, 15000);
INSERT INTO `qrtz_scheduler_state` VALUES ('B2shopScheduler', 'DESKTOP-2A5688B1522221202857', 1522221947745, 15000);
INSERT INTO `qrtz_scheduler_state` VALUES ('RenrenScheduler', 'DESKTOP-2A5688B1522221202857', 1522224693159, 15000);

-- ----------------------------
-- Table structure for qrtz_simple_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simple_triggers`;
CREATE TABLE `qrtz_simple_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for qrtz_simprop_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
CREATE TABLE `qrtz_simprop_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `STR_PROP_1` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STR_PROP_2` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STR_PROP_3` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `INT_PROP_1` int(11) NULL DEFAULT NULL,
  `INT_PROP_2` int(11) NULL DEFAULT NULL,
  `LONG_PROP_1` bigint(20) NULL DEFAULT NULL,
  `LONG_PROP_2` bigint(20) NULL DEFAULT NULL,
  `DEC_PROP_1` decimal(13, 4) NULL DEFAULT NULL,
  `DEC_PROP_2` decimal(13, 4) NULL DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for qrtz_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_triggers`;
CREATE TABLE `qrtz_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `DESCRIPTION` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) NULL DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) NULL DEFAULT NULL,
  `PRIORITY` int(11) NULL DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_TYPE` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) NULL DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) NULL DEFAULT NULL,
  `JOB_DATA` blob NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_J`(`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_JG`(`SCHED_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_C`(`SCHED_NAME`, `CALENDAR_NAME`) USING BTREE,
  INDEX `IDX_QRTZ_T_G`(`SCHED_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_STATE`(`SCHED_NAME`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_N_STATE`(`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_N_G_STATE`(`SCHED_NAME`, `TRIGGER_GROUP`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_NEXT_FIRE_TIME`(`SCHED_NAME`, `NEXT_FIRE_TIME`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_ST`(`SCHED_NAME`, `TRIGGER_STATE`, `NEXT_FIRE_TIME`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_MISFIRE`(`SCHED_NAME`, `MISFIRE_INSTR`, `NEXT_FIRE_TIME`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_ST_MISFIRE`(`SCHED_NAME`, `MISFIRE_INSTR`, `NEXT_FIRE_TIME`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_ST_MISFIRE_GRP`(`SCHED_NAME`, `MISFIRE_INSTR`, `NEXT_FIRE_TIME`, `TRIGGER_GROUP`, `TRIGGER_STATE`) USING BTREE,
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `qrtz_job_details` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_triggers
-- ----------------------------
INSERT INTO `qrtz_triggers` VALUES ('B2cshopScheduler', 'TASK_1', 'DEFAULT', 'TASK_1', 'DEFAULT', NULL, 1523435400000, 1523433600000, 5, 'WAITING', 'CRON', 1522235710000, 0, NULL, 2, 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B455973720030636F6D2E62326373686F702E6D6F64756C65732E6A6F622E656E746974792E5363686564756C654A6F62456E7469747900000000000000010200084C00086265616E4E616D657400124C6A6176612F6C616E672F537472696E673B4C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C000E63726F6E45787072657373696F6E71007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C000A6D6574686F644E616D6571007E00094C0006706172616D7371007E00094C000672656D61726B71007E00094C00067374617475737400134C6A6176612F6C616E672F496E74656765723B7870740008746573745461736B7372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000158BAF593307874000E3020302F3330202A202A202A203F7372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B020000787000000000000000017400047465737474000672656E72656E74000FE69C89E58F82E695B0E6B58BE8AF95737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C75657871007E0013000000007800);
INSERT INTO `qrtz_triggers` VALUES ('B2cshopScheduler', 'TASK_2', 'DEFAULT', 'TASK_2', 'DEFAULT', NULL, 1522236600000, -1, 5, 'PAUSED', 'CRON', 1522235711000, 0, NULL, 2, 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B455973720030636F6D2E62326373686F702E6D6F64756C65732E6A6F622E656E746974792E5363686564756C654A6F62456E7469747900000000000000010200084C00086265616E4E616D657400124C6A6176612F6C616E672F537472696E673B4C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C000E63726F6E45787072657373696F6E71007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C000A6D6574686F644E616D6571007E00094C0006706172616D7371007E00094C000672656D61726B71007E00094C00067374617475737400134C6A6176612F6C616E672F496E74656765723B7870740008746573745461736B7372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000158C377C4607874000E3020302F3330202A202A202A203F7372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B0200007870000000000000000274000574657374327074000FE697A0E58F82E695B0E6B58BE8AF95737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C75657871007E0013000000017800);
INSERT INTO `qrtz_triggers` VALUES ('RenrenScheduler', 'TASK_1', 'DEFAULT', 'TASK_1', 'DEFAULT', NULL, 1522211400000, -1, 5, 'WAITING', 'CRON', 1522210265000, 0, NULL, 2, 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B455973720030636F6D2E62326373686F702E6D6F64756C65732E6A6F622E656E746974792E5363686564756C654A6F62456E7469747900000000000000010200084C00086265616E4E616D657400124C6A6176612F6C616E672F537472696E673B4C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C000E63726F6E45787072657373696F6E71007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C000A6D6574686F644E616D6571007E00094C0006706172616D7371007E00094C000672656D61726B71007E00094C00067374617475737400134C6A6176612F6C616E672F496E74656765723B7870740008746573745461736B7372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000158BAF593307874000E3020302F3330202A202A202A203F7372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B020000787000000000000000017400047465737474000672656E72656E74000FE69C89E58F82E695B0E6B58BE8AF95737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C75657871007E0013000000007800);
INSERT INTO `qrtz_triggers` VALUES ('RenrenScheduler', 'TASK_2', 'DEFAULT', 'TASK_2', 'DEFAULT', NULL, 1522211400000, -1, 5, 'PAUSED', 'CRON', 1522210266000, 0, NULL, 2, 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B455973720030636F6D2E62326373686F702E6D6F64756C65732E6A6F622E656E746974792E5363686564756C654A6F62456E7469747900000000000000010200084C00086265616E4E616D657400124C6A6176612F6C616E672F537472696E673B4C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C000E63726F6E45787072657373696F6E71007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C000A6D6574686F644E616D6571007E00094C0006706172616D7371007E00094C000672656D61726B71007E00094C00067374617475737400134C6A6176612F6C616E672F496E74656765723B7870740008746573745461736B7372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000158C377C4607874000E3020302F3330202A202A202A203F7372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B0200007870000000000000000274000574657374327074000FE697A0E58F82E695B0E6B58BE8AF95737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C75657871007E0013000000017800);

-- ----------------------------
-- Table structure for schedule_job
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job`;
CREATE TABLE `schedule_job`  (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务id',
  `bean_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'spring bean名称',
  `method_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '方法名',
  `params` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数',
  `cron_expression` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'cron表达式',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '任务状态  0：正常  1：暂停',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '定时任务' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of schedule_job
-- ----------------------------
INSERT INTO `schedule_job` VALUES (1, 'testTask', 'test', 'renren', '0 0/30 * * * ?', 0, '有参数测试', '2016-12-01 23:16:46');
INSERT INTO `schedule_job` VALUES (2, 'testTask', 'test2', NULL, '0 0/30 * * * ?', 1, '无参数测试', '2016-12-03 14:55:56');

-- ----------------------------
-- Table structure for schedule_job_log
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job_log`;
CREATE TABLE `schedule_job_log`  (
  `log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志id',
  `job_id` bigint(20) NOT NULL COMMENT '任务id',
  `bean_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'spring bean名称',
  `method_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '方法名',
  `params` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数',
  `status` tinyint(4) NOT NULL COMMENT '任务状态    0：成功    1：失败',
  `error` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '失败信息',
  `times` int(11) NOT NULL COMMENT '耗时(单位：毫秒)',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`log_id`) USING BTREE,
  INDEX `job_id`(`job_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 156 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '定时任务日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of schedule_job_log
-- ----------------------------
INSERT INTO `schedule_job_log` VALUES (1, 1, 'testTask', 'test', 'renren', 0, NULL, 1261, '2018-03-28 12:30:00');
INSERT INTO `schedule_job_log` VALUES (2, 1, 'testTask', 'test', 'renren', 0, NULL, 1244, '2018-03-28 13:00:00');
INSERT INTO `schedule_job_log` VALUES (3, 1, 'testTask', 'test', 'renren', 0, NULL, 1343, '2018-03-28 19:30:00');
INSERT INTO `schedule_job_log` VALUES (4, 1, 'testTask', 'test', 'renren', 0, NULL, 1303, '2018-03-28 20:00:00');
INSERT INTO `schedule_job_log` VALUES (5, 1, 'testTask', 'test', 'renren', 0, NULL, 1421, '2018-03-28 20:30:00');
INSERT INTO `schedule_job_log` VALUES (6, 1, 'testTask', 'test', 'renren', 0, NULL, 1221, '2018-03-28 21:00:00');
INSERT INTO `schedule_job_log` VALUES (7, 1, 'testTask', 'test', 'renren', 0, NULL, 1112, '2018-03-28 21:30:00');
INSERT INTO `schedule_job_log` VALUES (8, 1, 'testTask', 'test', 'renren', 0, NULL, 1183, '2018-03-29 09:00:00');
INSERT INTO `schedule_job_log` VALUES (9, 1, 'testTask', 'test', 'renren', 0, NULL, 1134, '2018-03-29 09:30:00');
INSERT INTO `schedule_job_log` VALUES (10, 1, 'testTask', 'test', 'renren', 0, NULL, 1024, '2018-03-29 10:00:00');
INSERT INTO `schedule_job_log` VALUES (11, 1, 'testTask', 'test', 'renren', 0, NULL, 1050, '2018-03-29 10:30:00');
INSERT INTO `schedule_job_log` VALUES (12, 1, 'testTask', 'test', 'renren', 0, NULL, 1021, '2018-03-29 11:00:00');
INSERT INTO `schedule_job_log` VALUES (13, 1, 'testTask', 'test', 'renren', 0, NULL, 1013, '2018-03-29 11:30:00');
INSERT INTO `schedule_job_log` VALUES (14, 1, 'testTask', 'test', 'renren', 0, NULL, 1056, '2018-03-29 12:00:00');
INSERT INTO `schedule_job_log` VALUES (15, 1, 'testTask', 'test', 'renren', 0, NULL, 1012, '2018-03-29 12:30:00');
INSERT INTO `schedule_job_log` VALUES (16, 1, 'testTask', 'test', 'renren', 0, NULL, 1023, '2018-03-29 13:00:00');
INSERT INTO `schedule_job_log` VALUES (17, 1, 'testTask', 'test', 'renren', 0, NULL, 1005, '2018-03-29 13:30:00');
INSERT INTO `schedule_job_log` VALUES (18, 1, 'testTask', 'test', 'renren', 0, NULL, 1072, '2018-03-29 14:00:00');
INSERT INTO `schedule_job_log` VALUES (19, 1, 'testTask', 'test', 'renren', 0, NULL, 1041, '2018-03-29 14:30:00');
INSERT INTO `schedule_job_log` VALUES (20, 1, 'testTask', 'test', 'renren', 0, NULL, 1014, '2018-03-29 15:00:00');
INSERT INTO `schedule_job_log` VALUES (21, 1, 'testTask', 'test', 'renren', 0, NULL, 1007, '2018-03-29 15:30:00');
INSERT INTO `schedule_job_log` VALUES (22, 1, 'testTask', 'test', 'renren', 0, NULL, 1068, '2018-03-29 16:30:00');
INSERT INTO `schedule_job_log` VALUES (23, 1, 'testTask', 'test', 'renren', 0, NULL, 1006, '2018-03-29 17:00:00');
INSERT INTO `schedule_job_log` VALUES (24, 1, 'testTask', 'test', 'renren', 0, NULL, 1005, '2018-03-29 17:30:00');
INSERT INTO `schedule_job_log` VALUES (25, 1, 'testTask', 'test', 'renren', 0, NULL, 1141, '2018-03-29 20:00:00');
INSERT INTO `schedule_job_log` VALUES (26, 1, 'testTask', 'test', 'renren', 0, NULL, 1188, '2018-03-29 20:30:00');
INSERT INTO `schedule_job_log` VALUES (27, 1, 'testTask', 'test', 'renren', 0, NULL, 1026, '2018-03-29 21:00:00');
INSERT INTO `schedule_job_log` VALUES (28, 1, 'testTask', 'test', 'renren', 0, NULL, 1065, '2018-03-29 21:30:00');
INSERT INTO `schedule_job_log` VALUES (29, 1, 'testTask', 'test', 'renren', 0, NULL, 1012, '2018-03-29 22:00:00');
INSERT INTO `schedule_job_log` VALUES (30, 1, 'testTask', 'test', 'renren', 0, NULL, 1098, '2018-03-31 07:00:00');
INSERT INTO `schedule_job_log` VALUES (31, 1, 'testTask', 'test', 'renren', 0, NULL, 1015, '2018-03-31 07:30:00');
INSERT INTO `schedule_job_log` VALUES (32, 1, 'testTask', 'test', 'renren', 0, NULL, 1011, '2018-03-31 08:00:00');
INSERT INTO `schedule_job_log` VALUES (33, 1, 'testTask', 'test', 'renren', 0, NULL, 1009, '2018-03-31 08:30:00');
INSERT INTO `schedule_job_log` VALUES (34, 1, 'testTask', 'test', 'renren', 0, NULL, 1022, '2018-03-31 09:00:00');
INSERT INTO `schedule_job_log` VALUES (35, 1, 'testTask', 'test', 'renren', 0, NULL, 1013, '2018-03-31 09:30:00');
INSERT INTO `schedule_job_log` VALUES (36, 1, 'testTask', 'test', 'renren', 0, NULL, 1032, '2018-03-31 10:00:00');
INSERT INTO `schedule_job_log` VALUES (37, 1, 'testTask', 'test', 'renren', 0, NULL, 1067, '2018-03-31 10:30:00');
INSERT INTO `schedule_job_log` VALUES (38, 1, 'testTask', 'test', 'renren', 0, NULL, 1015, '2018-03-31 11:00:00');
INSERT INTO `schedule_job_log` VALUES (39, 1, 'testTask', 'test', 'renren', 0, NULL, 1124, '2018-04-01 10:00:00');
INSERT INTO `schedule_job_log` VALUES (40, 1, 'testTask', 'test', 'renren', 0, NULL, 1078, '2018-04-01 10:30:00');
INSERT INTO `schedule_job_log` VALUES (41, 1, 'testTask', 'test', 'renren', 0, NULL, 1011, '2018-04-01 11:00:00');
INSERT INTO `schedule_job_log` VALUES (42, 1, 'testTask', 'test', 'renren', 0, NULL, 1091, '2018-04-01 11:30:00');
INSERT INTO `schedule_job_log` VALUES (43, 1, 'testTask', 'test', 'renren', 0, NULL, 1032, '2018-04-01 12:00:00');
INSERT INTO `schedule_job_log` VALUES (44, 1, 'testTask', 'test', 'renren', 0, NULL, 1055, '2018-04-01 12:30:00');
INSERT INTO `schedule_job_log` VALUES (45, 1, 'testTask', 'test', 'renren', 0, NULL, 1060, '2018-04-01 13:00:00');
INSERT INTO `schedule_job_log` VALUES (46, 1, 'testTask', 'test', 'renren', 0, NULL, 1010, '2018-04-01 13:30:00');
INSERT INTO `schedule_job_log` VALUES (47, 1, 'testTask', 'test', 'renren', 0, NULL, 1053, '2018-04-01 14:00:00');
INSERT INTO `schedule_job_log` VALUES (48, 1, 'testTask', 'test', 'renren', 0, NULL, 1006, '2018-04-01 14:30:00');
INSERT INTO `schedule_job_log` VALUES (49, 1, 'testTask', 'test', 'renren', 0, NULL, 1063, '2018-04-01 15:00:00');
INSERT INTO `schedule_job_log` VALUES (50, 1, 'testTask', 'test', 'renren', 0, NULL, 1006, '2018-04-01 15:30:00');
INSERT INTO `schedule_job_log` VALUES (51, 1, 'testTask', 'test', 'renren', 0, NULL, 1006, '2018-04-01 16:00:00');
INSERT INTO `schedule_job_log` VALUES (52, 1, 'testTask', 'test', 'renren', 0, NULL, 1156, '2018-04-01 16:30:00');
INSERT INTO `schedule_job_log` VALUES (53, 1, 'testTask', 'test', 'renren', 0, NULL, 1060, '2018-04-01 17:00:00');
INSERT INTO `schedule_job_log` VALUES (54, 1, 'testTask', 'test', 'renren', 0, NULL, 1057, '2018-04-01 17:30:00');
INSERT INTO `schedule_job_log` VALUES (55, 1, 'testTask', 'test', 'renren', 0, NULL, 1020, '2018-04-01 18:00:00');
INSERT INTO `schedule_job_log` VALUES (56, 1, 'testTask', 'test', 'renren', 0, NULL, 1009, '2018-04-01 18:30:00');
INSERT INTO `schedule_job_log` VALUES (57, 1, 'testTask', 'test', 'renren', 0, NULL, 1188, '2018-04-01 19:00:00');
INSERT INTO `schedule_job_log` VALUES (58, 1, 'testTask', 'test', 'renren', 0, NULL, 1010, '2018-04-01 20:00:00');
INSERT INTO `schedule_job_log` VALUES (59, 1, 'testTask', 'test', 'renren', 0, NULL, 1014, '2018-04-01 20:30:00');
INSERT INTO `schedule_job_log` VALUES (60, 1, 'testTask', 'test', 'renren', 0, NULL, 1028, '2018-04-01 21:00:00');
INSERT INTO `schedule_job_log` VALUES (61, 1, 'testTask', 'test', 'renren', 0, NULL, 1049, '2018-04-01 21:30:00');
INSERT INTO `schedule_job_log` VALUES (62, 1, 'testTask', 'test', 'renren', 0, NULL, 1086, '2018-04-02 12:30:00');
INSERT INTO `schedule_job_log` VALUES (63, 1, 'testTask', 'test', 'renren', 0, NULL, 1039, '2018-04-02 13:00:00');
INSERT INTO `schedule_job_log` VALUES (64, 1, 'testTask', 'test', 'renren', 0, NULL, 1046, '2018-04-02 13:30:00');
INSERT INTO `schedule_job_log` VALUES (65, 1, 'testTask', 'test', 'renren', 0, NULL, 1053, '2018-04-02 14:00:00');
INSERT INTO `schedule_job_log` VALUES (66, 1, 'testTask', 'test', 'renren', 0, NULL, 1070, '2018-04-02 14:30:00');
INSERT INTO `schedule_job_log` VALUES (67, 1, 'testTask', 'test', 'renren', 0, NULL, 1006, '2018-04-02 15:00:00');
INSERT INTO `schedule_job_log` VALUES (68, 1, 'testTask', 'test', 'renren', 0, NULL, 1009, '2018-04-02 15:30:00');
INSERT INTO `schedule_job_log` VALUES (69, 1, 'testTask', 'test', 'renren', 0, NULL, 1103, '2018-04-02 16:00:00');
INSERT INTO `schedule_job_log` VALUES (70, 1, 'testTask', 'test', 'renren', 0, NULL, 1065, '2018-04-02 16:30:00');
INSERT INTO `schedule_job_log` VALUES (71, 1, 'testTask', 'test', 'renren', 0, NULL, 1086, '2018-04-02 17:00:00');
INSERT INTO `schedule_job_log` VALUES (72, 1, 'testTask', 'test', 'renren', 0, NULL, 1095, '2018-04-02 17:30:00');
INSERT INTO `schedule_job_log` VALUES (73, 1, 'testTask', 'test', 'renren', 0, NULL, 1097, '2018-04-02 19:00:00');
INSERT INTO `schedule_job_log` VALUES (74, 1, 'testTask', 'test', 'renren', 0, NULL, 1019, '2018-04-02 19:30:00');
INSERT INTO `schedule_job_log` VALUES (75, 1, 'testTask', 'test', 'renren', 0, NULL, 1071, '2018-04-02 20:00:00');
INSERT INTO `schedule_job_log` VALUES (76, 1, 'testTask', 'test', 'renren', 0, NULL, 1061, '2018-04-02 20:30:00');
INSERT INTO `schedule_job_log` VALUES (77, 1, 'testTask', 'test', 'renren', 0, NULL, 1011, '2018-04-02 21:00:00');
INSERT INTO `schedule_job_log` VALUES (78, 1, 'testTask', 'test', 'renren', 0, NULL, 1033, '2018-04-02 21:30:00');
INSERT INTO `schedule_job_log` VALUES (79, 1, 'testTask', 'test', 'renren', 0, NULL, 1013, '2018-04-02 22:00:00');
INSERT INTO `schedule_job_log` VALUES (80, 1, 'testTask', 'test', 'renren', 0, NULL, 1114, '2018-04-03 08:30:00');
INSERT INTO `schedule_job_log` VALUES (81, 1, 'testTask', 'test', 'renren', 0, NULL, 1173, '2018-04-03 09:00:00');
INSERT INTO `schedule_job_log` VALUES (82, 1, 'testTask', 'test', 'renren', 0, NULL, 1015, '2018-04-03 09:30:00');
INSERT INTO `schedule_job_log` VALUES (83, 1, 'testTask', 'test', 'renren', 0, NULL, 1085, '2018-04-03 10:00:00');
INSERT INTO `schedule_job_log` VALUES (84, 1, 'testTask', 'test', 'renren', 0, NULL, 1014, '2018-04-03 10:30:00');
INSERT INTO `schedule_job_log` VALUES (85, 1, 'testTask', 'test', 'renren', 0, NULL, 1019, '2018-04-03 11:00:00');
INSERT INTO `schedule_job_log` VALUES (86, 1, 'testTask', 'test', 'renren', 0, NULL, 1034, '2018-04-03 11:30:00');
INSERT INTO `schedule_job_log` VALUES (87, 1, 'testTask', 'test', 'renren', 0, NULL, 1059, '2018-04-03 12:00:00');
INSERT INTO `schedule_job_log` VALUES (88, 1, 'testTask', 'test', 'renren', 0, NULL, 1062, '2018-04-03 12:30:00');
INSERT INTO `schedule_job_log` VALUES (89, 1, 'testTask', 'test', 'renren', 0, NULL, 1058, '2018-04-03 13:00:00');
INSERT INTO `schedule_job_log` VALUES (90, 1, 'testTask', 'test', 'renren', 0, NULL, 1052, '2018-04-03 13:30:00');
INSERT INTO `schedule_job_log` VALUES (91, 1, 'testTask', 'test', 'renren', 0, NULL, 1056, '2018-04-03 14:00:00');
INSERT INTO `schedule_job_log` VALUES (92, 1, 'testTask', 'test', 'renren', 0, NULL, 1020, '2018-04-03 14:30:00');
INSERT INTO `schedule_job_log` VALUES (93, 1, 'testTask', 'test', 'renren', 0, NULL, 1062, '2018-04-03 15:00:00');
INSERT INTO `schedule_job_log` VALUES (94, 1, 'testTask', 'test', 'renren', 0, NULL, 1027, '2018-04-03 15:30:00');
INSERT INTO `schedule_job_log` VALUES (95, 1, 'testTask', 'test', 'renren', 0, NULL, 1010, '2018-04-03 16:00:00');
INSERT INTO `schedule_job_log` VALUES (96, 1, 'testTask', 'test', 'renren', 0, NULL, 1011, '2018-04-03 16:30:00');
INSERT INTO `schedule_job_log` VALUES (97, 1, 'testTask', 'test', 'renren', 0, NULL, 1071, '2018-04-03 17:00:00');
INSERT INTO `schedule_job_log` VALUES (98, 1, 'testTask', 'test', 'renren', 0, NULL, 1109, '2018-04-03 17:30:00');
INSERT INTO `schedule_job_log` VALUES (99, 1, 'testTask', 'test', 'renren', 0, NULL, 1121, '2018-04-03 19:30:00');
INSERT INTO `schedule_job_log` VALUES (100, 1, 'testTask', 'test', 'renren', 0, NULL, 1035, '2018-04-03 20:00:00');
INSERT INTO `schedule_job_log` VALUES (101, 1, 'testTask', 'test', 'renren', 0, NULL, 1146, '2018-04-03 20:30:00');
INSERT INTO `schedule_job_log` VALUES (102, 1, 'testTask', 'test', 'renren', 0, NULL, 1031, '2018-04-03 21:00:00');
INSERT INTO `schedule_job_log` VALUES (103, 1, 'testTask', 'test', 'renren', 0, NULL, 1154, '2018-04-05 08:30:00');
INSERT INTO `schedule_job_log` VALUES (104, 1, 'testTask', 'test', 'renren', 0, NULL, 1023, '2018-04-05 09:00:00');
INSERT INTO `schedule_job_log` VALUES (105, 1, 'testTask', 'test', 'renren', 0, NULL, 1021, '2018-04-05 09:30:00');
INSERT INTO `schedule_job_log` VALUES (106, 1, 'testTask', 'test', 'renren', 0, NULL, 1044, '2018-04-05 10:00:00');
INSERT INTO `schedule_job_log` VALUES (107, 1, 'testTask', 'test', 'renren', 0, NULL, 1030, '2018-04-05 10:30:00');
INSERT INTO `schedule_job_log` VALUES (108, 1, 'testTask', 'test', 'renren', 0, NULL, 1010, '2018-04-05 11:30:00');
INSERT INTO `schedule_job_log` VALUES (109, 1, 'testTask', 'test', 'renren', 0, NULL, 1110, '2018-04-05 12:00:00');
INSERT INTO `schedule_job_log` VALUES (110, 1, 'testTask', 'test', 'renren', 0, NULL, 1018, '2018-04-05 12:30:00');
INSERT INTO `schedule_job_log` VALUES (111, 1, 'testTask', 'test', 'renren', 0, NULL, 2180, '2018-04-05 15:59:58');
INSERT INTO `schedule_job_log` VALUES (112, 1, 'testTask', 'test', 'renren', 0, NULL, 1049, '2018-04-05 19:30:00');
INSERT INTO `schedule_job_log` VALUES (113, 1, 'testTask', 'test', 'renren', 0, NULL, 1122, '2018-04-05 20:00:00');
INSERT INTO `schedule_job_log` VALUES (114, 1, 'testTask', 'test', 'renren', 0, NULL, 1068, '2018-04-05 20:30:00');
INSERT INTO `schedule_job_log` VALUES (115, 1, 'testTask', 'test', 'renren', 0, NULL, 1059, '2018-04-05 21:00:00');
INSERT INTO `schedule_job_log` VALUES (116, 1, 'testTask', 'test', 'renren', 0, NULL, 1062, '2018-04-06 09:00:00');
INSERT INTO `schedule_job_log` VALUES (117, 1, 'testTask', 'test', 'renren', 0, NULL, 1041, '2018-04-06 09:30:00');
INSERT INTO `schedule_job_log` VALUES (118, 1, 'testTask', 'test', 'renren', 0, NULL, 1011, '2018-04-06 10:00:00');
INSERT INTO `schedule_job_log` VALUES (119, 1, 'testTask', 'test', 'renren', 0, NULL, 1701, '2018-04-06 14:00:00');
INSERT INTO `schedule_job_log` VALUES (120, 1, 'testTask', 'test', 'renren', 0, NULL, 1045, '2018-04-07 15:30:00');
INSERT INTO `schedule_job_log` VALUES (121, 1, 'testTask', 'test', 'renren', 0, NULL, 1093, '2018-04-07 16:00:00');
INSERT INTO `schedule_job_log` VALUES (122, 1, 'testTask', 'test', 'renren', 0, NULL, 1010, '2018-04-07 16:30:00');
INSERT INTO `schedule_job_log` VALUES (123, 1, 'testTask', 'test', 'renren', 0, NULL, 1004, '2018-04-07 17:00:00');
INSERT INTO `schedule_job_log` VALUES (124, 1, 'testTask', 'test', 'renren', 0, NULL, 1078, '2018-04-07 17:30:00');
INSERT INTO `schedule_job_log` VALUES (125, 1, 'testTask', 'test', 'renren', 0, NULL, 1012, '2018-04-07 18:00:00');
INSERT INTO `schedule_job_log` VALUES (126, 1, 'testTask', 'test', 'renren', 0, NULL, 1072, '2018-04-07 18:30:00');
INSERT INTO `schedule_job_log` VALUES (127, 1, 'testTask', 'test', 'renren', 0, NULL, 1019, '2018-04-07 19:00:00');
INSERT INTO `schedule_job_log` VALUES (128, 1, 'testTask', 'test', 'renren', 0, NULL, 1077, '2018-04-07 19:30:00');
INSERT INTO `schedule_job_log` VALUES (129, 1, 'testTask', 'test', 'renren', 0, NULL, 1016, '2018-04-07 20:00:00');
INSERT INTO `schedule_job_log` VALUES (130, 1, 'testTask', 'test', 'renren', 0, NULL, 1016, '2018-04-07 20:30:00');
INSERT INTO `schedule_job_log` VALUES (131, 1, 'testTask', 'test', 'renren', 0, NULL, 1077, '2018-04-08 20:30:00');
INSERT INTO `schedule_job_log` VALUES (132, 1, 'testTask', 'test', 'renren', 0, NULL, 1082, '2018-04-08 21:00:00');
INSERT INTO `schedule_job_log` VALUES (133, 1, 'testTask', 'test', 'renren', 0, NULL, 1050, '2018-04-09 09:30:00');
INSERT INTO `schedule_job_log` VALUES (134, 1, 'testTask', 'test', 'renren', 0, NULL, 1061, '2018-04-09 10:00:00');
INSERT INTO `schedule_job_log` VALUES (135, 1, 'testTask', 'test', 'renren', 0, NULL, 1036, '2018-04-09 10:30:00');
INSERT INTO `schedule_job_log` VALUES (136, 1, 'testTask', 'test', 'renren', 0, NULL, 1093, '2018-04-09 11:00:00');
INSERT INTO `schedule_job_log` VALUES (137, 1, 'testTask', 'test', 'renren', 0, NULL, 1045, '2018-04-09 11:30:00');
INSERT INTO `schedule_job_log` VALUES (138, 1, 'testTask', 'test', 'renren', 0, NULL, 1027, '2018-04-09 12:00:00');
INSERT INTO `schedule_job_log` VALUES (139, 1, 'testTask', 'test', 'renren', 0, NULL, 1110, '2018-04-09 12:30:00');
INSERT INTO `schedule_job_log` VALUES (140, 1, 'testTask', 'test', 'renren', 0, NULL, 1014, '2018-04-09 13:00:00');
INSERT INTO `schedule_job_log` VALUES (141, 1, 'testTask', 'test', 'renren', 0, NULL, 1316, '2018-04-09 21:00:00');
INSERT INTO `schedule_job_log` VALUES (142, 1, 'testTask', 'test', 'renren', 0, NULL, 1060, '2018-04-11 08:30:00');
INSERT INTO `schedule_job_log` VALUES (143, 1, 'testTask', 'test', 'renren', 0, NULL, 1027, '2018-04-11 09:00:00');
INSERT INTO `schedule_job_log` VALUES (144, 1, 'testTask', 'test', 'renren', 0, NULL, 1087, '2018-04-11 09:30:00');
INSERT INTO `schedule_job_log` VALUES (145, 1, 'testTask', 'test', 'renren', 0, NULL, 1093, '2018-04-11 11:00:00');
INSERT INTO `schedule_job_log` VALUES (146, 1, 'testTask', 'test', 'renren', 0, NULL, 1022, '2018-04-11 11:30:00');
INSERT INTO `schedule_job_log` VALUES (147, 1, 'testTask', 'test', 'renren', 0, NULL, 1030, '2018-04-11 12:00:00');
INSERT INTO `schedule_job_log` VALUES (148, 1, 'testTask', 'test', 'renren', 0, NULL, 1073, '2018-04-11 12:30:00');
INSERT INTO `schedule_job_log` VALUES (149, 1, 'testTask', 'test', 'renren', 0, NULL, 1084, '2018-04-11 13:00:00');
INSERT INTO `schedule_job_log` VALUES (150, 1, 'testTask', 'test', 'renren', 0, NULL, 1065, '2018-04-11 13:30:00');
INSERT INTO `schedule_job_log` VALUES (151, 1, 'testTask', 'test', 'renren', 0, NULL, 1126, '2018-04-11 14:00:00');
INSERT INTO `schedule_job_log` VALUES (152, 1, 'testTask', 'test', 'renren', 0, NULL, 1108, '2018-04-11 14:30:00');
INSERT INTO `schedule_job_log` VALUES (153, 1, 'testTask', 'test', 'renren', 0, NULL, 1084, '2018-04-11 15:00:00');
INSERT INTO `schedule_job_log` VALUES (154, 1, 'testTask', 'test', 'renren', 0, NULL, 1069, '2018-04-11 15:30:00');
INSERT INTO `schedule_job_log` VALUES (155, 1, 'testTask', 'test', 'renren', 0, NULL, 1134, '2018-04-11 16:00:00');

-- ----------------------------
-- Table structure for sys_captcha
-- ----------------------------
DROP TABLE IF EXISTS `sys_captcha`;
CREATE TABLE `sys_captcha`  (
  `uuid` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'uuid',
  `code` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '验证码',
  `expire_time` datetime(0) NULL DEFAULT NULL COMMENT '过期时间',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统验证码' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_captcha
-- ----------------------------
INSERT INTO `sys_captcha` VALUES ('7eba0213-f760-46c0-86df-88c465aef5ab', 'wnb7f', '2018-04-11 08:23:17');

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `key` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'key',
  `value` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'value',
  `status` tinyint(4) NULL DEFAULT 1 COMMENT '状态   0：隐藏   1：显示',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `key`(`key`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统配置信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES (1, 'CLOUD_STORAGE_CONFIG_KEY', '{\"type\":1,\"qiniuDomain\":\"http://oyp0rvrqg.bkt.clouddn.com\",\"qiniuPrefix\":\"upload\",\"qiniuAccessKey\":\"TPvNAkTC3KA0xSGoIZEa_qxgU8Mwuihg5rBjK1db\",\"qiniuSecretKey\":\"RALFBIcWpiGOaFn7LonIL54AUfXw84eGHNTmnIiW\",\"qiniuBucketName\":\"abc001\",\"aliyunDomain\":\"\",\"aliyunPrefix\":\"\",\"aliyunEndPoint\":\"\",\"aliyunAccessKeyId\":\"\",\"aliyunAccessKeySecret\":\"\",\"aliyunBucketName\":\"\",\"qcloudDomain\":\"\",\"qcloudPrefix\":\"\",\"qcloudSecretId\":\"\",\"qcloudSecretKey\":\"\",\"qcloudBucketName\":\"\"}', 0, '云存储配置信息');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求参数',
  `time` bigint(20) NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES (1, 'admin', '保存菜单', 'com.b2cshop.modules.sys.controller.SysMenuController.save()', '{\"menuId\":96,\"parentId\":0,\"name\":\"商品管理\",\"url\":\"\",\"perms\":\"\",\"type\":0,\"icon\":\"\",\"orderNum\":1}', 43, '127.0.0.1', '2018-03-28 21:04:31');
INSERT INTO `sys_log` VALUES (2, 'admin', '修改菜单', 'com.b2cshop.modules.sys.controller.SysMenuController.update()', '{\"menuId\":31,\"parentId\":96,\"name\":\"商品\",\"url\":\"modules/shop/goods.html\",\"type\":1,\"icon\":\"fa fa-file-code-o\",\"orderNum\":6}', 87, '127.0.0.1', '2018-03-28 21:04:55');
INSERT INTO `sys_log` VALUES (3, 'admin', '修改菜单', 'com.b2cshop.modules.sys.controller.SysMenuController.update()', '{\"menuId\":36,\"parentId\":96,\"name\":\"商品与商品属性关系表\",\"url\":\"modules/shop/goodsattr.html\",\"type\":1,\"icon\":\"fa fa-file-code-o\",\"orderNum\":6}', 86, '127.0.0.1', '2018-03-28 21:05:41');
INSERT INTO `sys_log` VALUES (4, 'admin', '修改菜单', 'com.b2cshop.modules.sys.controller.SysMenuController.update()', '{\"menuId\":41,\"parentId\":96,\"name\":\"商品收藏\",\"url\":\"modules/shop/goodscollect.html\",\"type\":1,\"icon\":\"fa fa-file-code-o\",\"orderNum\":6}', 96, '127.0.0.1', '2018-03-28 21:05:53');
INSERT INTO `sys_log` VALUES (5, 'admin', '修改菜单', 'com.b2cshop.modules.sys.controller.SysMenuController.update()', '{\"menuId\":46,\"parentId\":96,\"name\":\"商品与商品属性关系表\",\"url\":\"modules/shop/goodsattr.html\",\"type\":1,\"icon\":\"fa fa-file-code-o\",\"orderNum\":6}', 38, '127.0.0.1', '2018-03-28 21:06:06');
INSERT INTO `sys_log` VALUES (6, 'admin', '修改菜单', 'com.b2cshop.modules.sys.controller.SysMenuController.update()', '{\"menuId\":51,\"parentId\":96,\"name\":\"商品属性\",\"url\":\"modules/shop/goodsattribute.html\",\"type\":1,\"icon\":\"fa fa-file-code-o\",\"orderNum\":6}', 71, '127.0.0.1', '2018-03-28 21:06:19');
INSERT INTO `sys_log` VALUES (7, 'admin', '删除菜单', 'com.b2cshop.modules.sys.controller.SysMenuController.delete()', '36', 15, '127.0.0.1', '2018-03-29 15:13:45');
INSERT INTO `sys_log` VALUES (8, 'admin', '修改菜单', 'com.b2cshop.modules.sys.controller.SysMenuController.update()', '{\"menuId\":36,\"parentId\":96,\"name\":\"商品与商品属性关系表\",\"url\":\"modules/shop/goodsattr.html\",\"type\":0,\"icon\":\"fa fa-file-code-o\",\"orderNum\":6}', 63, '127.0.0.1', '2018-03-29 15:14:17');
INSERT INTO `sys_log` VALUES (9, 'admin', '删除菜单', 'com.b2cshop.modules.sys.controller.SysMenuController.delete()', '37', 302, '127.0.0.1', '2018-03-29 15:14:49');
INSERT INTO `sys_log` VALUES (10, 'admin', '修改菜单', 'com.b2cshop.modules.sys.controller.SysMenuController.update()', '{\"menuId\":97,\"parentId\":96,\"name\":\"商品规格\",\"url\":\"modules/shop/spec.html\",\"type\":1,\"icon\":\"fa fa-file-code-o\",\"orderNum\":6}', 52, '127.0.0.1', '2018-04-01 16:35:04');
INSERT INTO `sys_log` VALUES (11, 'admin', '保存菜单', 'com.b2cshop.modules.sys.controller.SysMenuController.save()', '{\"menuId\":102,\"parentId\":96,\"name\":\"商品发布\",\"url\":\"modules/shop/spec.html\",\"perms\":\"shop:spec:save\",\"type\":1,\"icon\":\"\",\"orderNum\":0}', 99, '127.0.0.1', '2018-04-03 10:47:31');
INSERT INTO `sys_log` VALUES (12, 'admin', '修改菜单', 'com.b2cshop.modules.sys.controller.SysMenuController.update()', '{\"menuId\":102,\"parentId\":96,\"name\":\"商品发布\",\"url\":\"modules/shop/addGoods.html\",\"perms\":\"shop:spec:save\",\"type\":1,\"orderNum\":0}', 81, '127.0.0.1', '2018-04-03 10:48:25');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) NULL DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 103 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, '系统管理', NULL, NULL, 0, 'fa fa-cog', 0);
INSERT INTO `sys_menu` VALUES (2, 1, '管理员列表', 'modules/sys/user.html', NULL, 1, 'fa fa-user', 1);
INSERT INTO `sys_menu` VALUES (3, 1, '角色管理', 'modules/sys/role.html', NULL, 1, 'fa fa-user-secret', 2);
INSERT INTO `sys_menu` VALUES (4, 1, '菜单管理', 'modules/sys/menu.html', NULL, 1, 'fa fa-th-list', 3);
INSERT INTO `sys_menu` VALUES (5, 1, 'SQL监控', 'druid/sql.html', NULL, 1, 'fa fa-bug', 4);
INSERT INTO `sys_menu` VALUES (6, 1, '定时任务', 'modules/job/schedule.html', NULL, 1, 'fa fa-tasks', 5);
INSERT INTO `sys_menu` VALUES (7, 6, '查看', NULL, 'sys:schedule:list,sys:schedule:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (8, 6, '新增', NULL, 'sys:schedule:save', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (9, 6, '修改', NULL, 'sys:schedule:update', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (10, 6, '删除', NULL, 'sys:schedule:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (11, 6, '暂停', NULL, 'sys:schedule:pause', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (12, 6, '恢复', NULL, 'sys:schedule:resume', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (13, 6, '立即执行', NULL, 'sys:schedule:run', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (14, 6, '日志列表', NULL, 'sys:schedule:log', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (15, 2, '查看', NULL, 'sys:user:list,sys:user:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (16, 2, '新增', NULL, 'sys:user:save,sys:role:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (17, 2, '修改', NULL, 'sys:user:update,sys:role:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (18, 2, '删除', NULL, 'sys:user:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (19, 3, '查看', NULL, 'sys:role:list,sys:role:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (20, 3, '新增', NULL, 'sys:role:save,sys:menu:list', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (21, 3, '修改', NULL, 'sys:role:update,sys:menu:list', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (22, 3, '删除', NULL, 'sys:role:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (23, 4, '查看', NULL, 'sys:menu:list,sys:menu:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (24, 4, '新增', NULL, 'sys:menu:save,sys:menu:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (25, 4, '修改', NULL, 'sys:menu:update,sys:menu:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (26, 4, '删除', NULL, 'sys:menu:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (27, 1, '参数管理', 'modules/sys/config.html', 'sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete', 1, 'fa fa-sun-o', 6);
INSERT INTO `sys_menu` VALUES (29, 1, '系统日志', 'modules/sys/log.html', 'sys:log:list', 1, 'fa fa-file-text-o', 7);
INSERT INTO `sys_menu` VALUES (30, 1, '文件上传', 'modules/oss/oss.html', 'sys:oss:all', 1, 'fa fa-file-image-o', 6);
INSERT INTO `sys_menu` VALUES (31, 96, '商品', 'modules/shop/goods.html', NULL, 1, 'fa fa-file-code-o', 6);
INSERT INTO `sys_menu` VALUES (32, 31, '查看', NULL, 'shop:goods:list,shop:goods:info', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (33, 31, '新增', NULL, 'shop:goods:save', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (34, 31, '修改', NULL, 'shop:goods:update', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (35, 31, '删除', NULL, 'shop:goods:delete', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (51, 96, '商品属性', 'modules/shop/goodsattribute.html', NULL, 1, 'fa fa-file-code-o', 6);
INSERT INTO `sys_menu` VALUES (52, 51, '查看', NULL, 'shop:goodsattribute:list,shop:goodsattribute:info', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (53, 51, '新增', NULL, 'shop:goodsattribute:save', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (54, 51, '修改', NULL, 'shop:goodsattribute:update', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (55, 51, '删除', NULL, 'shop:goodsattribute:delete', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (61, 96, '商品分类', 'modules/shop/goodscategory.html', NULL, 1, 'fa fa-file-code-o', 6);
INSERT INTO `sys_menu` VALUES (62, 61, '查看', NULL, 'shop:goodscategory:list,shop:goodscategory:info', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (63, 61, '新增', NULL, 'shop:goodscategory:save', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (64, 61, '修改', NULL, 'shop:goodscategory:update', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (65, 61, '删除', NULL, 'shop:goodscategory:delete', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (71, 96, '商品咨询', 'modules/shop/goodsconsult.html', NULL, 1, 'fa fa-file-code-o', 6);
INSERT INTO `sys_menu` VALUES (72, 71, '查看', NULL, 'shop:goodsconsult:list,shop:goodsconsult:info', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (73, 71, '新增', NULL, 'shop:goodsconsult:save', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (74, 71, '修改', NULL, 'shop:goodsconsult:update', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (75, 71, '删除', NULL, 'shop:goodsconsult:delete', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (76, 96, '商品与优惠券关系表', 'modules/shop/goodscoupon.html', NULL, 1, 'fa fa-file-code-o', 6);
INSERT INTO `sys_menu` VALUES (77, 76, '查看', NULL, 'shop:goodscoupon:list,shop:goodscoupon:info', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (78, 76, '新增', NULL, 'shop:goodscoupon:save', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (79, 76, '修改', NULL, 'shop:goodscoupon:update', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (80, 76, '删除', NULL, 'shop:goodscoupon:delete', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (81, 96, '商品图片', 'modules/shop/goodsimages.html', NULL, 1, 'fa fa-file-code-o', 6);
INSERT INTO `sys_menu` VALUES (82, 81, '查看', NULL, 'shop:goodsimages:list,shop:goodsimages:info', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (83, 81, '新增', NULL, 'shop:goodsimages:save', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (84, 81, '修改', NULL, 'shop:goodsimages:update', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (85, 81, '删除', NULL, 'shop:goodsimages:delete', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (86, 96, '商品模型', 'modules/shop/goodstype.html', NULL, 1, 'fa fa-file-code-o', 6);
INSERT INTO `sys_menu` VALUES (87, 86, '查看', NULL, 'shop:goodstype:list,shop:goodstype:info', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (88, 86, '新增', NULL, 'shop:goodstype:save', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (89, 86, '修改', NULL, 'shop:goodstype:update', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (90, 86, '删除', NULL, 'shop:goodstype:delete', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (96, 0, '商品管理', NULL, NULL, 0, NULL, 1);
INSERT INTO `sys_menu` VALUES (97, 96, '商品规格', 'modules/shop/spec.html', NULL, 1, 'fa fa-file-code-o', 6);
INSERT INTO `sys_menu` VALUES (98, 97, '查看', NULL, 'shop:spec:list,shop:spec:info', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (99, 97, '新增', NULL, 'shop:spec:save', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (100, 97, '修改', NULL, 'shop:spec:update', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (101, 97, '删除', NULL, 'shop:spec:delete', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (102, 96, '商品发布', 'modules/shop/addGoods.html', 'shop:spec:save', 1, NULL, 0);

-- ----------------------------
-- Table structure for sys_oss
-- ----------------------------
DROP TABLE IF EXISTS `sys_oss`;
CREATE TABLE `sys_oss`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'URL地址',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 60 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文件上传' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_oss
-- ----------------------------
INSERT INTO `sys_oss` VALUES (1, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180331/b8aaf12daa2740e0b167541943203196.jpg', '2018-03-31 07:26:34');
INSERT INTO `sys_oss` VALUES (2, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180331/d80eb1fc8beb4878b995ead949468c6e.jpg', '2018-03-31 07:31:29');
INSERT INTO `sys_oss` VALUES (3, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180331/e5fafa3b18e949eebbd214333e10e540.jpg', '2018-03-31 07:32:42');
INSERT INTO `sys_oss` VALUES (4, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180331/bc771e98b1014d7e8d460fb56726239c.jpg', '2018-03-31 07:33:34');
INSERT INTO `sys_oss` VALUES (5, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180331/4c204b995dca4d0c9e1a9af1657cace6.jpg', '2018-03-31 07:47:15');
INSERT INTO `sys_oss` VALUES (6, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180331/d8a845a25e6e4f23a39f2b1dd213d751.jpg', '2018-03-31 07:48:05');
INSERT INTO `sys_oss` VALUES (7, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180331/a77bbb95c11d4ed0b5d616bb700dd1a6.jpg', '2018-03-31 07:49:22');
INSERT INTO `sys_oss` VALUES (8, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180331/36c2917f403942f586c6f0471ab65a4d.jpg', '2018-03-31 07:54:12');
INSERT INTO `sys_oss` VALUES (9, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180331/44372d8a03874146b3af9894d2787886.jpg', '2018-03-31 07:55:24');
INSERT INTO `sys_oss` VALUES (10, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180331/fa9372937c764bc59458d79e0509520d.jpg', '2018-03-31 07:56:19');
INSERT INTO `sys_oss` VALUES (11, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180331/74162d34fecc473a8166a1a4c9d68410.jpg', '2018-03-31 07:56:44');
INSERT INTO `sys_oss` VALUES (12, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180331/11d98d2cf0d444218c3e923d04ec5102.jpg', '2018-03-31 07:57:15');
INSERT INTO `sys_oss` VALUES (13, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180331/b49e0fdaa9ce4f9da415e2b35b5b2aba.jpg', '2018-03-31 08:08:08');
INSERT INTO `sys_oss` VALUES (14, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180403/eeba85c0e7314d239d81ab04c7d07af0.jpg', '2018-04-03 17:25:16');
INSERT INTO `sys_oss` VALUES (15, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180403/c1e8f2c0970b458db44f632237e38c0a.jpg', '2018-04-03 17:25:36');
INSERT INTO `sys_oss` VALUES (16, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180403/f74573eb1f724ebcbb3c48296728fe30.jpg', '2018-04-03 17:25:55');
INSERT INTO `sys_oss` VALUES (17, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180403/21b5e307f109482c8592c5717b251eea.jpg', '2018-04-03 17:36:39');
INSERT INTO `sys_oss` VALUES (18, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180403/25b3355a3b534ccd813f3a5c5e851126.jpg', '2018-04-03 17:37:19');
INSERT INTO `sys_oss` VALUES (19, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180403/e7d0d1ac15a4414f860d5c0920ba9a00.jpg', '2018-04-03 19:34:50');
INSERT INTO `sys_oss` VALUES (20, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180403/04eefbb7bf264bd48607d6dd642531ca.jpg', '2018-04-03 19:34:58');
INSERT INTO `sys_oss` VALUES (21, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180403/fbd10a3b30b74984af01c1e26e9f20a3.jpg', '2018-04-03 19:35:14');
INSERT INTO `sys_oss` VALUES (22, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180403/ab8fa5b581ad441587614e5e0c30feb0.jpg', '2018-04-03 19:44:22');
INSERT INTO `sys_oss` VALUES (23, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180403/bf1a881da74c4c9fbcb8d2cb2408902e.jpg', '2018-04-03 19:44:27');
INSERT INTO `sys_oss` VALUES (24, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180403/34772dcdfb974a9daac3707dff101fd6.jpg', '2018-04-03 19:46:00');
INSERT INTO `sys_oss` VALUES (25, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180403/cf851f5bf43a43b2a48dd15e2471988d.jpg', '2018-04-03 19:46:04');
INSERT INTO `sys_oss` VALUES (26, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180403/d6520f3352d14cd1ac7f47f67110d8a8.jpg', '2018-04-03 19:46:59');
INSERT INTO `sys_oss` VALUES (27, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180405/af74cace9d294d1fb2cf2869140efeca.jpg', '2018-04-05 19:32:15');
INSERT INTO `sys_oss` VALUES (28, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180405/dc6b5c6855b9474ca51b71210900648c.jpg', '2018-04-05 19:46:40');
INSERT INTO `sys_oss` VALUES (29, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180405/da00584d14ce46c498290732400d7675.jpg', '2018-04-05 19:48:12');
INSERT INTO `sys_oss` VALUES (30, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180405/455feb02b90b4c07b7b922d0f4b42756.jpg', '2018-04-05 19:48:17');
INSERT INTO `sys_oss` VALUES (31, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180405/a4c2977ba2fa4797ab181ce36cb68003.jpg', '2018-04-05 19:58:39');
INSERT INTO `sys_oss` VALUES (32, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180405/eace6830e3924fceae47deaf3b4ec02a.jpg', '2018-04-05 19:58:51');
INSERT INTO `sys_oss` VALUES (33, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180405/6de777f710614bdaa022e8f5c9762f2d.jpg', '2018-04-05 20:18:43');
INSERT INTO `sys_oss` VALUES (34, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180405/c1bc8798c9234f41b8425bd7944c0ade.jpg', '2018-04-05 20:18:43');
INSERT INTO `sys_oss` VALUES (35, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180405/39ee0fb3cb514ad3b01e6ea87a156da8.jpg', '2018-04-05 20:19:51');
INSERT INTO `sys_oss` VALUES (36, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180405/94d35f2b17fe482a96c59a67d713fb0b.jpg', '2018-04-05 20:19:54');
INSERT INTO `sys_oss` VALUES (37, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180405/fb206d8d25004ba69805f7ff74b60c16.jpg', '2018-04-05 20:22:25');
INSERT INTO `sys_oss` VALUES (38, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180405/3840b564f516453098af061c2ddc32a2.jpg', '2018-04-05 20:22:29');
INSERT INTO `sys_oss` VALUES (39, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180405/dca67e34d56d49ddbd47303dd6282f36.jpg', '2018-04-05 20:24:18');
INSERT INTO `sys_oss` VALUES (40, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180405/b701e28d884f4a88b844dbc2044c6986.jpg', '2018-04-05 20:26:21');
INSERT INTO `sys_oss` VALUES (41, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180405/cda50fd5c5df4b5382af9de84dd6f607.jpg', '2018-04-05 20:27:03');
INSERT INTO `sys_oss` VALUES (42, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180405/adeb5a472ef346bc95723eb6e520d1bc.jpg', '2018-04-05 20:28:00');
INSERT INTO `sys_oss` VALUES (43, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180405/ef980fac29d645c2948731c9cb01cbd2.jpg', '2018-04-05 20:31:16');
INSERT INTO `sys_oss` VALUES (44, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180405/a88ea58e46c64541a9c06efdd0289a7a.jpg', '2018-04-05 20:33:24');
INSERT INTO `sys_oss` VALUES (45, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180405/91d752296e2d4db4810078556ff6a3c5.jpg', '2018-04-05 20:36:49');
INSERT INTO `sys_oss` VALUES (46, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180405/f196f7b6cbf64de7843cac4f7917ad52.jpg', '2018-04-05 20:39:23');
INSERT INTO `sys_oss` VALUES (47, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180405/42e4df1af1764a21a1c7ea162e334a9a.jpg', '2018-04-05 20:43:14');
INSERT INTO `sys_oss` VALUES (48, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180405/20dcedf744044369b2f22fabb5a70be2.jpg', '2018-04-05 20:45:23');
INSERT INTO `sys_oss` VALUES (49, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180405/60b0d99f486742ce84b4984efeb9fbb7.jpg', '2018-04-05 20:47:39');
INSERT INTO `sys_oss` VALUES (50, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180405/b284cf504d4d47f9b4be1d68379cf7a3.jpg', '2018-04-05 20:53:04');
INSERT INTO `sys_oss` VALUES (51, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180406/b1ed683be9c243bd8381507f0dae7af6.jpg', '2018-04-06 08:48:51');
INSERT INTO `sys_oss` VALUES (52, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180406/1e3dd1d0acec4feba510f6fb54b26ddb.jpg', '2018-04-06 08:59:11');
INSERT INTO `sys_oss` VALUES (53, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180406/bbe6bac5d0fe422ba7ea1d9584e6f745.jpg', '2018-04-06 09:01:18');
INSERT INTO `sys_oss` VALUES (54, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180406/f4c69fded49141acb27685cac176019c.jpg', '2018-04-06 09:02:26');
INSERT INTO `sys_oss` VALUES (55, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180406/ad50411cee2f4ad484e35d71715b9a81.jpg', '2018-04-06 09:03:11');
INSERT INTO `sys_oss` VALUES (56, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180406/cb3fc169c401472aae52e13f76da6a4a.jpg', '2018-04-06 09:03:25');
INSERT INTO `sys_oss` VALUES (57, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180406/69474df13f1f45f4a5104dea1d0940b3.jpg', '2018-04-06 09:04:11');
INSERT INTO `sys_oss` VALUES (58, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180406/89b388027b474833b2323dcec77125f5.jpg', '2018-04-06 09:04:13');
INSERT INTO `sys_oss` VALUES (59, 'http://oyp0rvrqg.bkt.clouddn.com/upload/20180406/6bd1d9319188472180827312367a5e10.jpg', '2018-04-06 09:04:13');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NULL DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色与菜单对应关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `salt` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '盐',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '9ec9750e709431dad22365cabc5c625482e574c74adaebba7dd02f1129e4ce1d', 'YzcmCZNvbXocrsz9dm8e', 'root@renren.io', '13612345678', 1, 1, '2016-11-11 11:11:11');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户与角色对应关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user_token
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_token`;
CREATE TABLE `sys_user_token`  (
  `user_id` bigint(20) NOT NULL,
  `token` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'token',
  `expire_time` datetime(0) NULL DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `token`(`token`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统用户Token' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_token
-- ----------------------------
INSERT INTO `sys_user_token` VALUES (1, 'ed6dbd08b8b17f4735c8aef238b61c56', '2018-04-11 20:18:51', '2018-04-11 08:18:51');

SET FOREIGN_KEY_CHECKS = 1;
