/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : wxxs

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2021-03-02 19:49:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `content` varchar(255) DEFAULT NULL COMMENT '介绍',
  `area` varchar(255) DEFAULT NULL COMMENT '上课地点',
  `keshi` varchar(255) DEFAULT NULL COMMENT '所需课时',
  `gmtTime` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='课程信息';

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '发打算发大水发', '的放大法', '三楼', '3课时', '2021-03-02 13:59:20');
INSERT INTO `course` VALUES ('2', '111', '321321', '32132', '1321', '2021-03-02 13:59:20');
INSERT INTO `course` VALUES ('3', '高等数学', '看发大水发大厦', '4F', '3', '2021-03-02 19:45:34');

-- ----------------------------
-- Table structure for holiday
-- ----------------------------
DROP TABLE IF EXISTS `holiday`;
CREATE TABLE `holiday` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `paike` bigint(20) DEFAULT NULL COMMENT '课程',
  `user` bigint(20) DEFAULT NULL COMMENT '请假人',
  `type` varchar(255) DEFAULT NULL COMMENT '类型',
  `reason` varchar(255) DEFAULT NULL COMMENT '原因',
  `state` varchar(255) DEFAULT NULL COMMENT '审批结果',
  `gmtTime` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='请假信息';

-- ----------------------------
-- Records of holiday
-- ----------------------------
INSERT INTO `holiday` VALUES ('1', '2', '3', '事假', '321', '同意', '2021-03-02 13:59:20');
INSERT INTO `holiday` VALUES ('2', '4', '4', '事假', '321', '同意', '2021-03-02 13:59:20');
INSERT INTO `holiday` VALUES ('3', '5', '4', '事假', '321', '同意', '2021-03-02 13:59:20');
INSERT INTO `holiday` VALUES ('4', '5', '4', '事假', '321321', '同意', '2021-03-02 19:46:52');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` text COMMENT '内容',
  `gmtTime` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='通知公告';

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('1', '32', '1321', '2021-03-02 13:59:20');
INSERT INTO `news` VALUES ('2', 'f', '范德萨发顺丰打发大水', '2021-03-02 13:59:20');

-- ----------------------------
-- Table structure for paike
-- ----------------------------
DROP TABLE IF EXISTS `paike`;
CREATE TABLE `paike` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `course` bigint(20) DEFAULT NULL COMMENT '课程信息',
  `time` datetime DEFAULT NULL COMMENT '上课时间',
  `gmtTime` datetime DEFAULT NULL COMMENT '添加时间',
  `end` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='课程安排';

-- ----------------------------
-- Records of paike
-- ----------------------------
INSERT INTO `paike` VALUES ('1', '1', '2021-03-02 13:59:20', '2021-03-02 13:59:20', '2021-03-02 13:59:20');
INSERT INTO `paike` VALUES ('2', '1', '2021-03-02 13:59:20', '2021-03-02 13:59:20', '2021-03-02 13:59:20');
INSERT INTO `paike` VALUES ('3', '2', '2021-03-02 13:59:20', '2021-03-02 13:59:20', '2021-03-02 13:59:20');
INSERT INTO `paike` VALUES ('4', '2', '2021-03-02 13:59:20', '2021-03-02 13:59:20', '2021-03-02 13:59:20');
INSERT INTO `paike` VALUES ('5', '2', '2021-03-02 13:59:20', '2021-03-02 13:59:20', '2021-03-02 13:59:20');
INSERT INTO `paike` VALUES ('6', '3', '2021-03-02 19:47:38', '2021-03-02 19:45:53', '2021-03-02 22:45:40');

-- ----------------------------
-- Table structure for qian
-- ----------------------------
DROP TABLE IF EXISTS `qian`;
CREATE TABLE `qian` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `paike` bigint(20) DEFAULT NULL COMMENT '课程',
  `user` bigint(20) DEFAULT NULL COMMENT '学生',
  `gmtTime` datetime DEFAULT NULL COMMENT '添加时间',
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='签到信息';

-- ----------------------------
-- Records of qian
-- ----------------------------
INSERT INTO `qian` VALUES ('1', '2', '1', '2021-03-02 13:59:20', null);
INSERT INTO `qian` VALUES ('2', '2', '3', '2021-03-02 13:59:20', null);
INSERT INTO `qian` VALUES ('6', '4', '4', '2021-03-02 13:59:20', null);
INSERT INTO `qian` VALUES ('7', '5', '3', '2021-03-02 13:59:20', null);
INSERT INTO `qian` VALUES ('14', '5', '4', '2021-03-02 13:59:20', null);
INSERT INTO `qian` VALUES ('15', '5', '4', '2021-03-02 13:59:20', null);
INSERT INTO `qian` VALUES ('16', '3', '4', '2021-03-02 19:24:45', '缺勤');
INSERT INTO `qian` VALUES ('17', '1', '3', '2021-03-02 19:24:45', '缺勤');
INSERT INTO `qian` VALUES ('18', '6', '4', '2021-03-02 19:47:37', '正常');

-- ----------------------------
-- Table structure for stucourse
-- ----------------------------
DROP TABLE IF EXISTS `stucourse`;
CREATE TABLE `stucourse` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `course` bigint(20) DEFAULT NULL COMMENT '课程信息',
  `user` bigint(20) DEFAULT NULL COMMENT '学生',
  `gmtTime` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='学生课程';

-- ----------------------------
-- Records of stucourse
-- ----------------------------
INSERT INTO `stucourse` VALUES ('1', '1', '3', '2021-03-02 13:59:20');
INSERT INTO `stucourse` VALUES ('2', '2', '4', '2021-03-02 13:59:20');
INSERT INTO `stucourse` VALUES ('3', '3', '4', '2021-03-02 19:45:59');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('2', '0', '学生管理', 'sys/user.html', null, '1', 'fa fa-user', '1');
INSERT INTO `sys_menu` VALUES ('3', '0', '角色管理', 'sys/role.html', null, '1', 'fa fa-user-secret', '2');
INSERT INTO `sys_menu` VALUES ('4', '0', '菜单管理', 'sys/menu.html', null, '1', 'fa fa-th-list', '3');
INSERT INTO `sys_menu` VALUES ('15', '2', '查看', null, 'sys:user:list,sys:user:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('16', '2', '新增', null, 'sys:user:save,sys:role:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('17', '2', '修改', null, 'sys:user:update,sys:role:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('18', '2', '删除', null, 'sys:user:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('19', '3', '查看', null, 'sys:role:list,sys:role:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('20', '3', '新增', null, 'sys:role:save,sys:menu:perms', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('21', '3', '修改', null, 'sys:role:update,sys:menu:perms', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('22', '3', '删除', null, 'sys:role:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('23', '4', '查看', null, 'sys:menu:list,sys:menu:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('24', '4', '新增', null, 'sys:menu:save,sys:menu:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('25', '4', '修改', null, 'sys:menu:update,sys:menu:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('26', '4', '删除', null, 'sys:menu:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('28', '0', '代码生成器', 'sys/generator.html', 'sys:generator:list,sys:generator:code', '1', 'fa fa-rocket', '8');
INSERT INTO `sys_menu` VALUES ('76', '0', '通知公告', 'admin/news.html', null, '1', null, '6');
INSERT INTO `sys_menu` VALUES ('77', '76', '查看', null, 'news:list,news:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('78', '76', '新增', null, 'news:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('79', '76', '修改', null, 'news:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('80', '76', '删除', null, 'news:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('81', '0', '课程信息', 'admin/course.html', null, '1', null, '6');
INSERT INTO `sys_menu` VALUES ('82', '81', '查看', null, 'course:list,course:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('83', '81', '新增', null, 'course:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('84', '81', '修改', null, 'course:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('85', '81', '删除', null, 'course:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('86', '0', '课程安排', 'admin/paike.html', null, '1', null, '6');
INSERT INTO `sys_menu` VALUES ('87', '86', '查看', null, 'paike:list,paike:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('88', '86', '新增', null, 'paike:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('89', '86', '修改', null, 'paike:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('90', '86', '删除', null, 'paike:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('91', '0', '学生课程', 'admin/stucourse.html', null, '1', null, '6');
INSERT INTO `sys_menu` VALUES ('92', '91', '查看', null, 'stucourse:list,stucourse:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('93', '91', '新增', null, 'stucourse:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('94', '91', '修改', null, 'stucourse:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('95', '91', '删除', null, 'stucourse:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('96', '0', '签到信息', 'admin/qian.html', null, '1', null, '8');
INSERT INTO `sys_menu` VALUES ('97', '96', '查看', null, 'qian:list,qian:info', '2', null, '8');
INSERT INTO `sys_menu` VALUES ('98', '96', '新增', null, 'qian:save', '2', null, '8');
INSERT INTO `sys_menu` VALUES ('99', '96', '修改', null, 'qian:update', '2', null, '8');
INSERT INTO `sys_menu` VALUES ('100', '96', '删除', null, 'qian:delete', '2', null, '8');
INSERT INTO `sys_menu` VALUES ('101', '0', '请假信息', 'admin/holiday.html', null, '1', null, '8');
INSERT INTO `sys_menu` VALUES ('102', '101', '查看', null, 'holiday:list,holiday:info', '2', null, '8');
INSERT INTO `sys_menu` VALUES ('103', '101', '新增', null, 'holiday:save', '2', null, '8');
INSERT INTO `sys_menu` VALUES ('104', '101', '修改', null, 'holiday:update', '2', null, '8');
INSERT INTO `sys_menu` VALUES ('105', '101', '删除', null, 'holiday:delete', '2', null, '8');
INSERT INTO `sys_menu` VALUES ('106', '0', '教学资料', 'admin/ziliao.html', null, '1', null, '8');
INSERT INTO `sys_menu` VALUES ('107', '106', '查看', null, 'ziliao:list,ziliao:info', '2', null, '8');
INSERT INTO `sys_menu` VALUES ('108', '106', '新增', null, 'ziliao:save', '2', null, '8');
INSERT INTO `sys_menu` VALUES ('109', '106', '修改', null, 'ziliao:update', '2', null, '8');
INSERT INTO `sys_menu` VALUES ('110', '106', '删除', null, 'ziliao:delete', '2', null, '8');
INSERT INTO `sys_menu` VALUES ('111', '0', '我的签到', 'admin/qian2.html', null, '1', null, '6');
INSERT INTO `sys_menu` VALUES ('112', '0', '我的请假', 'admin/holiday2.html', null, '1', null, '6');
INSERT INTO `sys_menu` VALUES ('113', '0', '开始签到', 'admin/add.html', null, '1', null, '7');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '普通', null, '1', '2018-04-17 10:26:34');
INSERT INTO `sys_role` VALUES ('2', '系统管理员', null, '-1', '2018-04-17 15:24:04');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=204 DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('115', '1', '76');
INSERT INTO `sys_role_menu` VALUES ('116', '1', '77');
INSERT INTO `sys_role_menu` VALUES ('117', '1', '86');
INSERT INTO `sys_role_menu` VALUES ('118', '1', '87');
INSERT INTO `sys_role_menu` VALUES ('119', '1', '106');
INSERT INTO `sys_role_menu` VALUES ('120', '1', '107');
INSERT INTO `sys_role_menu` VALUES ('121', '1', '111');
INSERT INTO `sys_role_menu` VALUES ('122', '1', '112');
INSERT INTO `sys_role_menu` VALUES ('163', '2', '2');
INSERT INTO `sys_role_menu` VALUES ('164', '2', '15');
INSERT INTO `sys_role_menu` VALUES ('165', '2', '16');
INSERT INTO `sys_role_menu` VALUES ('166', '2', '17');
INSERT INTO `sys_role_menu` VALUES ('167', '2', '18');
INSERT INTO `sys_role_menu` VALUES ('168', '2', '76');
INSERT INTO `sys_role_menu` VALUES ('169', '2', '77');
INSERT INTO `sys_role_menu` VALUES ('170', '2', '78');
INSERT INTO `sys_role_menu` VALUES ('171', '2', '79');
INSERT INTO `sys_role_menu` VALUES ('172', '2', '80');
INSERT INTO `sys_role_menu` VALUES ('173', '2', '81');
INSERT INTO `sys_role_menu` VALUES ('174', '2', '82');
INSERT INTO `sys_role_menu` VALUES ('175', '2', '83');
INSERT INTO `sys_role_menu` VALUES ('176', '2', '84');
INSERT INTO `sys_role_menu` VALUES ('177', '2', '85');
INSERT INTO `sys_role_menu` VALUES ('178', '2', '86');
INSERT INTO `sys_role_menu` VALUES ('179', '2', '87');
INSERT INTO `sys_role_menu` VALUES ('180', '2', '88');
INSERT INTO `sys_role_menu` VALUES ('181', '2', '89');
INSERT INTO `sys_role_menu` VALUES ('182', '2', '90');
INSERT INTO `sys_role_menu` VALUES ('183', '2', '91');
INSERT INTO `sys_role_menu` VALUES ('184', '2', '92');
INSERT INTO `sys_role_menu` VALUES ('185', '2', '93');
INSERT INTO `sys_role_menu` VALUES ('186', '2', '94');
INSERT INTO `sys_role_menu` VALUES ('187', '2', '95');
INSERT INTO `sys_role_menu` VALUES ('188', '2', '113');
INSERT INTO `sys_role_menu` VALUES ('189', '2', '96');
INSERT INTO `sys_role_menu` VALUES ('190', '2', '97');
INSERT INTO `sys_role_menu` VALUES ('191', '2', '98');
INSERT INTO `sys_role_menu` VALUES ('192', '2', '99');
INSERT INTO `sys_role_menu` VALUES ('193', '2', '100');
INSERT INTO `sys_role_menu` VALUES ('194', '2', '101');
INSERT INTO `sys_role_menu` VALUES ('195', '2', '102');
INSERT INTO `sys_role_menu` VALUES ('196', '2', '103');
INSERT INTO `sys_role_menu` VALUES ('197', '2', '104');
INSERT INTO `sys_role_menu` VALUES ('198', '2', '105');
INSERT INTO `sys_role_menu` VALUES ('199', '2', '106');
INSERT INTO `sys_role_menu` VALUES ('200', '2', '107');
INSERT INTO `sys_role_menu` VALUES ('201', '2', '108');
INSERT INTO `sys_role_menu` VALUES ('202', '2', '109');
INSERT INTO `sys_role_menu` VALUES ('203', '2', '110');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `type` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('-1', 'admin', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', 'root@renren.io', '321321', '1', null, '2021-03-02 13:59:20', null, null);
INSERT INTO `sys_user` VALUES ('1', 'admin1', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', 'admin@admin.com', '13612345678', '1', null, '2021-03-02 13:59:20', null, null);
INSERT INTO `sys_user` VALUES ('3', '张明', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', null, null, '1', '1', '2021-03-02 13:59:20', '1', '0004080665');
INSERT INTO `sys_user` VALUES ('4', '李成', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', null, '13223232323', '1', '-1', '2021-03-02 13:59:20', '1', '/cdn//cdn/fb013d9d-ebd4-429c-9e52-3ef0a5656a0a.png');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('6', '8', '1');
INSERT INTO `sys_user_role` VALUES ('7', '-1', '2');
INSERT INTO `sys_user_role` VALUES ('8', '2', '1');
INSERT INTO `sys_user_role` VALUES ('14', '3', '1');
INSERT INTO `sys_user_role` VALUES ('16', '4', '1');

-- ----------------------------
-- Table structure for ziliao
-- ----------------------------
DROP TABLE IF EXISTS `ziliao`;
CREATE TABLE `ziliao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `content` text COMMENT '介绍',
  `url` varchar(255) DEFAULT NULL COMMENT '文件',
  `gmtTime` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='教学资料';

-- ----------------------------
-- Records of ziliao
-- ----------------------------
INSERT INTO `ziliao` VALUES ('1', '1321321', '21321321', '/cdn//cdn/ac58a679-0c16-47a5-95f1-2344102bcc80.pptx', '2021-03-02 13:59:20');
INSERT INTO `ziliao` VALUES ('2', 'FDSAF', 'DSAFDSAFDSA', '/cdn//cdn/2d59fddd-2b89-49f6-98f0-ca9d5b73a8cd.jpg', '2021-03-02 13:59:20');
INSERT INTO `ziliao` VALUES ('3', '高等数学预习资料', '看范德萨范德萨', '/cdn//cdn/a78bd85d-4416-4f45-9a4d-052f476e9c46.jpg', '2021-03-02 19:46:17');
