/*
SQLyog Ultimate v9.63 
MySQL - 5.7.21-20-log : Database - sonar
*********************************************************************
*/

CREATE DATABASE /*!32312 IF NOT EXISTS*/`sonar` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `sonar`;

/*Table structure for table `bug_weekly_statistic` */

CREATE TABLE `bug_weekly_statistic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `keyword` varchar(50) DEFAULT NULL COMMENT 'keytype为1，这里为用户名；\r\nkeytype为2，这里为产品名。',
  `bugcount` int(11) DEFAULT NULL COMMENT 'bug数量',
  `keytype` int(2) DEFAULT NULL COMMENT '用于标识统计的是人员信息还是项目信息。\r\nkeytype=1：统计人员信息；\r\nkeytype=2：统计项目信息。',
  `week` varchar(255) DEFAULT NULL COMMENT '统计周（第几周的统计信息）',
  `starttime` datetime DEFAULT NULL COMMENT '统计时间范围：开始时间',
  `endtime` datetime DEFAULT NULL COMMENT '统计时间范围：结束时间',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '本记录创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1103 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Table structure for table `case_weekly_statistic` */

CREATE TABLE `case_weekly_statistic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `keyword` varchar(50) DEFAULT NULL COMMENT 'keytype为1，这里为用户名；\r\nkeytype为2，这里为产品名。',
  `casecount` int(11) DEFAULT NULL COMMENT 'bug数量',
  `keytype` int(1) DEFAULT NULL COMMENT '用于标识统计的是人员信息还是项目信息。\r\nkeytype=1：统计人员信息；\r\nkeytype=2：统计项目信息。',
  `week` int(2) DEFAULT NULL COMMENT '统计周（第几周的统计信息）',
  `starttime` datetime DEFAULT NULL COMMENT '统计时间范围：开始时间',
  `endtime` datetime DEFAULT NULL COMMENT '统计时间范围：结束时间',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '本记录创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=663 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Table structure for table `jira_bug` */

CREATE TABLE `jira_bug` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `issueid` int(11) NOT NULL,
  `reporter` varchar(20) DEFAULT NULL COMMENT '提交bug人员',
  `solver` varchar(20) DEFAULT NULL COMMENT '处理bug人员',
  `summary` varchar(255) DEFAULT NULL COMMENT 'bug描述',
  `project` varchar(255) DEFAULT NULL COMMENT 'bug所属项目',
  `priority` varchar(10) DEFAULT NULL COMMENT '优先级',
  `status` varchar(10) DEFAULT NULL COMMENT '状态',
  `createtime` datetime DEFAULT NULL COMMENT '创建日期',
  `resolutionresult` varchar(10) DEFAULT NULL COMMENT '解决结果',
  `resolutiondate` datetime DEFAULT NULL COMMENT '解决日期',
  `bugtype` varchar(10) DEFAULT NULL COMMENT '缺陷类型',
  `updatetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '本条记录更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `issueid` (`issueid`)
) ENGINE=InnoDB AUTO_INCREMENT=456 DEFAULT CHARSET=utf8;

/*Table structure for table `jira_bug_copy1` */

CREATE TABLE `jira_bug_copy1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `issueid` int(11) NOT NULL,
  `reporter` varchar(20) DEFAULT NULL COMMENT '提交bug测试人员',
  `solver` varchar(20) DEFAULT NULL COMMENT '处理bug研发人员',
  `summary` varchar(255) DEFAULT NULL COMMENT 'bug描述',
  `project` varchar(255) DEFAULT NULL COMMENT 'bug所属项目',
  `priority` varchar(10) DEFAULT NULL COMMENT '优先级',
  `status` varchar(10) DEFAULT NULL COMMENT '状态',
  `createtime` datetime DEFAULT NULL COMMENT '创建日期',
  `resolutionresult` varchar(10) DEFAULT NULL COMMENT '解决结果',
  `resolutiondate` datetime DEFAULT NULL COMMENT '解决日期',
  `bugtype` varchar(10) DEFAULT NULL COMMENT '缺陷类型',
  `updatetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`,`issueid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=168 DEFAULT CHARSET=utf8;

/*Table structure for table `sonar_fileinfo` */

CREATE TABLE `sonar_fileinfo` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NOT NULL,
  `filename` varchar(255) NOT NULL,
  `author` varchar(30) NOT NULL COMMENT '提交人',
  `commit_time` datetime DEFAULT NULL COMMENT '本次提交时间',
  `lastcommit_time` datetime DEFAULT NULL COMMENT '上次提交时间',
  `commit_revision` varchar(30) DEFAULT NULL COMMENT '提交版本',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `filelines` int(11) DEFAULT NULL COMMENT '代码行数',
  `ncloc` int(11) DEFAULT NULL COMMENT '有效代码行数',
  `comment_lines` int(11) DEFAULT NULL COMMENT '注释行数',
  `comment_lines_density` float(11,2) DEFAULT NULL COMMENT '注释率',
  `directories` int(11) DEFAULT NULL COMMENT '目录数',
  `classes` int(11) DEFAULT NULL COMMENT '类数',
  `statements` int(11) DEFAULT NULL COMMENT '声明个数',
  `functions` int(11) DEFAULT NULL COMMENT '方法数',
  `code_smells` int(11) DEFAULT NULL COMMENT '坏味道',
  `bugs` int(11) DEFAULT NULL COMMENT 'bug数',
  `vulnerabilities` int(11) DEFAULT NULL COMMENT '漏洞数',
  `coverage` float(11,2) DEFAULT NULL COMMENT '覆盖率',
  `line_coverage` float(11,2) DEFAULT NULL COMMENT '行覆盖率',
  `test_success_density` float(11,2) DEFAULT NULL COMMENT '单元测试成功率',
  `lines_to_cover` int(11) DEFAULT NULL COMMENT '需要覆盖的代码行',
  `uncovered_lines` int(11) DEFAULT NULL COMMENT '未覆盖的代码行',
  `test_failures` int(11) NOT NULL COMMENT '单元测试失败数',
  `test_errors` int(11) DEFAULT NULL COMMENT '单元测试错误数',
  `skipped_tests` int(11) DEFAULT NULL COMMENT '单元测试忽略数',
  `duplicated_lines_density` float(11,2) DEFAULT NULL COMMENT '重复密度',
  `duplicated_blocks` int(11) DEFAULT NULL COMMENT '重复块',
  `duplicated_files` int(11) DEFAULT NULL COMMENT '重复文件',
  `duplicated_lines` int(11) DEFAULT NULL COMMENT '重复行',
  `blocker_violations` int(11) DEFAULT NULL COMMENT '阻断违规',
  `critical_violations` int(11) DEFAULT NULL COMMENT '严重违规',
  `major_violations` int(11) DEFAULT NULL COMMENT '主要违规',
  `minor_violations` int(11) DEFAULT NULL COMMENT '次要违规',
  `info_violations` int(11) DEFAULT NULL COMMENT '提示违规',
  `new_lines` int(11) DEFAULT NULL COMMENT '新增行数',
  `violations` int(11) DEFAULT NULL COMMENT '违规总数',
  `sqale_index` int(11) DEFAULT NULL COMMENT '技术债务',
  `complexity` int(11) DEFAULT NULL COMMENT '复杂度',
  `cognitive_complexity` int(11) DEFAULT NULL COMMENT '认知复杂度',
  `modifytype` varchar(10) DEFAULT NULL COMMENT '提交类型',
  `new_minor_violations` int(11) DEFAULT NULL COMMENT '新增次要违规数',
  `new_critical_violations` int(11) DEFAULT NULL COMMENT '新增严重违规数',
  `new_major_violations` int(11) DEFAULT NULL COMMENT '新增主要违规数',
  `new_reliability_rating` float(10,2) DEFAULT NULL COMMENT '新代码可靠性评级\r\nA = 0错误\r\nB =至少1次轻微错误\r\nC =至少1次重大错误\r\nD =至少1次严重错误\r\nE =至少1次阻止程序错误',
  `new_blocker_violations` int(11) DEFAULT NULL COMMENT '新增阻断违规数',
  `new_lines_to_cover` int(11) DEFAULT NULL COMMENT '新增需要覆盖的代码行',
  `new_technical_debt` int(11) DEFAULT NULL COMMENT '新增技术债务',
  `new_info_violations` int(11) DEFAULT NULL COMMENT '新增提示违规数',
  `new_uncovered_lines` int(11) DEFAULT NULL COMMENT '新增未覆盖的代码行',
  `new_reliability_remediation_effort` int(11) DEFAULT NULL COMMENT '新代码的可靠性修复工作',
  `new_violations` int(11) DEFAULT NULL COMMENT '新增违规数',
  `new_duplicated_blocks` int(11) DEFAULT NULL COMMENT '新增重复块',
  `new_conditions_to_cover` int(11) DEFAULT NULL COMMENT '新的或更新代码的条件覆盖数 ',
  `new_sqale_debt_ratio` float(10,2) DEFAULT NULL COMMENT '新代码的技术债务比率',
  `new_uncovered_conditions` int(11) DEFAULT NULL COMMENT '新的或更新代码中未覆盖的条件数',
  `new_security_rating` float(10,2) DEFAULT NULL COMMENT '新代码安全评级',
  `new_vulnerabilities` int(11) DEFAULT NULL COMMENT '新增漏洞数',
  `new_bugs` int(11) DEFAULT NULL COMMENT '新增bug数',
  `new_duplicated_lines` int(11) DEFAULT NULL COMMENT '新增重复行',
  `new_code_smells` int(11) DEFAULT NULL COMMENT '新增坏味道',
  `new_maintainability_rating` float(10,2) DEFAULT NULL COMMENT '新增代码可靠性评级',
  `new_security_remediation_effort` int(11) DEFAULT NULL COMMENT '新增代码安全修复工作',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `project_id+filename` (`project_id`,`filename`)
) ENGINE=InnoDB AUTO_INCREMENT=2838 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Table structure for table `sonar_filerule` */

CREATE TABLE `sonar_filerule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) DEFAULT NULL,
  `filename` varchar(255) DEFAULT NULL,
  `rule` varchar(50) DEFAULT NULL COMMENT '规则id',
  `severity` varchar(15) DEFAULT NULL COMMENT '严重程度',
  `issuetype` varchar(15) DEFAULT NULL COMMENT '问题类型',
  `message` varchar(255) DEFAULT NULL COMMENT '规则描述',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `key` varchar(50) DEFAULT NULL COMMENT 'sonar中对应的问题key',
  PRIMARY KEY (`id`),
  KEY `project_id-key` (`project_id`,`key`)
) ENGINE=InnoDB AUTO_INCREMENT=28730 DEFAULT CHARSET=utf8;

/*Table structure for table `sonar_project_report_daily` */

CREATE TABLE `sonar_project_report_daily` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) DEFAULT NULL,
  `collect_date` varchar(12) DEFAULT NULL,
  `files` int(11) NOT NULL COMMENT '文件数',
  `lines` int(11) DEFAULT NULL COMMENT '行数',
  `ncloc` int(11) DEFAULT NULL COMMENT '有效代码行数',
  `comment_lines` int(11) DEFAULT NULL COMMENT '注释行数',
  `comment_lines_density` float(11,2) DEFAULT NULL COMMENT '注释率',
  `directories` int(11) DEFAULT NULL COMMENT '目录数',
  `classes` int(11) DEFAULT NULL COMMENT '类',
  `statements` int(11) DEFAULT NULL COMMENT '声明个数',
  `functions` int(11) DEFAULT NULL COMMENT '方法',
  `code_smells` int(11) DEFAULT NULL COMMENT '坏味道',
  `bugs` int(11) DEFAULT NULL COMMENT 'bugs',
  `vulnerabilities` int(11) DEFAULT NULL COMMENT '漏洞',
  `lines_to_cover` int(11) DEFAULT NULL COMMENT '需要覆盖的代码行',
  `uncovered_lines` int(11) DEFAULT NULL COMMENT '未覆盖的代码行',
  `coverage` float(11,2) DEFAULT NULL COMMENT '覆盖率',
  `line_coverage` float(11,2) DEFAULT NULL COMMENT '行覆盖率',
  `test_success_density` float(11,0) DEFAULT NULL COMMENT '单元测试成功率',
  `test_failures` int(11) DEFAULT NULL COMMENT '单元测试失败数',
  `test_errors` int(11) DEFAULT NULL COMMENT '单元测试错误数',
  `skipped_tests` int(11) DEFAULT NULL COMMENT '单元测试忽略数',
  `duplicated_lines_density` float(11,2) DEFAULT NULL COMMENT '重复率',
  `duplicated_blocks` int(11) DEFAULT NULL COMMENT '重复块',
  `duplicated_files` int(11) DEFAULT NULL COMMENT '重复文件',
  `duplicated_lines` int(11) DEFAULT NULL COMMENT '重复行',
  `blocker_violations` int(11) DEFAULT NULL COMMENT '阻断违规',
  `critical_violations` int(11) DEFAULT NULL COMMENT '严重违规',
  `major_violations` int(11) DEFAULT NULL COMMENT '主要违规',
  `minor_violations` int(11) DEFAULT NULL COMMENT '次要违规',
  `info_violations` int(11) DEFAULT NULL COMMENT '提示违规',
  `new_lines` int(11) DEFAULT NULL COMMENT '新增行数',
  `violations` int(11) DEFAULT NULL COMMENT '违规数',
  `sqale_index` int(11) DEFAULT NULL COMMENT '技术债务',
  `complexity` int(11) DEFAULT NULL COMMENT '复杂度',
  `cognitive_complexity` int(11) DEFAULT NULL COMMENT '认知复杂度',
  `new_minor_violations` int(11) DEFAULT NULL COMMENT '新增次要违规数',
  `new_critical_violations` int(11) DEFAULT NULL COMMENT '新增严重违规数',
  `new_major_violations` int(11) DEFAULT NULL COMMENT '新增主要违规数',
  `new_reliability_rating` float(10,2) DEFAULT NULL COMMENT '新代码可靠性评级\r\nA = 0错误\r\nB =至少1次轻微错误\r\nC =至少1次重大错误\r\nD =至少1次严重错误\r\nE =至少1次阻止程序错误',
  `new_blocker_violations` int(11) NOT NULL COMMENT '新增阻断违规数',
  `new_lines_to_cover` int(11) DEFAULT NULL COMMENT '新增需要覆盖的代码行',
  `new_technical_debt` int(11) DEFAULT NULL COMMENT '新增技术债务',
  `new_info_violations` int(11) DEFAULT NULL COMMENT '新增提示违规数',
  `new_uncovered_lines` int(11) DEFAULT NULL COMMENT '新增未覆盖的代码行',
  `new_reliability_remediation_effort` int(11) DEFAULT NULL COMMENT '新代码的可靠性修复工作',
  `new_violations` int(11) DEFAULT NULL COMMENT '新增违规数',
  `new_duplicated_blocks` int(11) DEFAULT NULL COMMENT '新增重复块',
  `new_conditions_to_cover` int(11) DEFAULT NULL COMMENT '新的或更新代码的条件覆盖数 ',
  `new_sqale_debt_ratio` float(10,2) DEFAULT NULL COMMENT '新代码的技术债务比率',
  `new_uncovered_conditions` int(11) DEFAULT NULL COMMENT '新的或更新代码中未覆盖的条件数',
  `new_security_rating` float(10,2) DEFAULT NULL COMMENT '新代码安全评级',
  `new_vulnerabilities` int(11) DEFAULT NULL COMMENT '新增漏洞数',
  `new_bugs` int(11) DEFAULT NULL COMMENT '新增bug数',
  `new_duplicated_lines` int(11) DEFAULT NULL COMMENT '新增重复行',
  `new_code_smells` int(11) DEFAULT NULL COMMENT '新增坏味道',
  `new_maintainability_rating` float(10,2) DEFAULT NULL COMMENT '新增代码可靠性评级',
  `new_security_remediation_effort` int(11) DEFAULT NULL COMMENT '新增代码安全修复工作',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `project_date` (`project_id`,`collect_date`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=615 DEFAULT CHARSET=utf8;

/*Table structure for table `sonar_user_report_daily` */

CREATE TABLE `sonar_user_report_daily` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) DEFAULT NULL,
  `author` varchar(30) DEFAULT NULL,
  `collect_date` varchar(12) DEFAULT NULL,
  `files_count` int(11) DEFAULT NULL COMMENT '文件数',
  `lines_count` int(11) DEFAULT NULL COMMENT '行数',
  `ncloc_count` int(11) DEFAULT NULL COMMENT '有效代码行数',
  `comment_lines_count` int(11) DEFAULT NULL COMMENT '注释行数',
  `comment_lines_density_avg` float(11,2) DEFAULT NULL COMMENT '注释率',
  `directories_count` int(11) DEFAULT NULL COMMENT '目录数',
  `classes_count` int(11) DEFAULT NULL COMMENT '类数',
  `statements_count` int(11) DEFAULT NULL COMMENT '声明个数',
  `functions_count` int(11) DEFAULT NULL COMMENT '方法数',
  `code_smells_count` int(11) DEFAULT NULL COMMENT '坏味道',
  `bugs_count` int(11) DEFAULT NULL COMMENT 'bug数',
  `vulnerabilities_count` int(11) DEFAULT NULL COMMENT '漏洞数',
  `coverage_avg` float(11,2) DEFAULT NULL COMMENT '覆盖率',
  `line_coverage_avg` float(11,2) DEFAULT NULL COMMENT '行覆盖率',
  `test_success_density_avg` float(11,2) DEFAULT NULL COMMENT '单元测试成功率',
  `lines_to_cover_count` int(11) DEFAULT NULL COMMENT '需要覆盖的代码行',
  `uncovered_lines_count` int(11) DEFAULT NULL COMMENT '未覆盖的代码行',
  `test_failures_count` int(11) DEFAULT NULL COMMENT '单元测试失败数',
  `test_errors_count` int(11) DEFAULT NULL COMMENT '单元测试错误数',
  `skipped_tests_count` int(11) DEFAULT NULL COMMENT '单元测试忽略数',
  `duplicated_lines_density_avg` float(11,2) DEFAULT NULL COMMENT '重复密度',
  `duplicated_blocks_count` int(11) DEFAULT NULL COMMENT '重复块',
  `duplicated_files_count` int(11) DEFAULT NULL COMMENT '重复文件',
  `duplicated_lines_count` int(11) DEFAULT NULL COMMENT '重复行',
  `blocker_violations_count` int(11) DEFAULT NULL COMMENT '阻断违规',
  `critical_violations_count` int(11) DEFAULT NULL COMMENT '严重违规',
  `major_violations_count` int(11) DEFAULT NULL COMMENT '主要违规',
  `minor_violations_count` int(11) DEFAULT NULL COMMENT '次要违规',
  `info_violations_count` int(11) DEFAULT NULL COMMENT '提示违规',
  `new_lines_count` int(11) DEFAULT NULL COMMENT '新增行数',
  `violations_count` int(11) DEFAULT NULL COMMENT '违规总数',
  `sqale_index_count` int(11) DEFAULT NULL COMMENT '技术债务',
  `complexity_count` int(11) DEFAULT NULL COMMENT '复杂度',
  `cognitive_complexity_count` int(11) DEFAULT NULL COMMENT '认知复杂度',
  `new_major_violations_count` int(11) DEFAULT NULL COMMENT '新增主要违规数',
  `new_minor_violations_count` int(11) DEFAULT NULL COMMENT '新增次要违规数',
  `new_critical_violations_count` int(11) DEFAULT NULL COMMENT '新增严重违规数',
  `new_reliability_rating_avg` float(10,2) DEFAULT NULL COMMENT '新代码可靠性评级\r\nA = 0错误\r\nB =至少1次轻微错误\r\nC =至少1次重大错误\r\nD =至少1次严重错误\r\nE =至少1次阻止程序错误',
  `new_blocker_violations_count` int(11) DEFAULT NULL COMMENT '新增阻断违规数',
  `new_lines_to_cover_count` int(11) DEFAULT NULL COMMENT '新增需要覆盖的代码行',
  `new_technical_debt_count` int(11) DEFAULT NULL COMMENT '新增技术债务',
  `new_info_violations_count` int(11) DEFAULT NULL COMMENT '新增提示违规数',
  `new_uncovered_lines_count` int(11) DEFAULT NULL COMMENT '新增未覆盖的代码行',
  `new_reliability_remediation_effort_count` int(11) DEFAULT NULL COMMENT '新代码的可靠性修复工作',
  `new_violations_count` int(11) DEFAULT NULL COMMENT '新增违规数',
  `new_duplicated_blocks_count` int(11) DEFAULT NULL COMMENT '新增重复块',
  `new_conditions_to_cover_count` int(11) DEFAULT NULL COMMENT '新的或更新代码的条件覆盖数 ',
  `new_sqale_debt_ratio_avg` float(10,2) DEFAULT NULL COMMENT '新代码的技术债务比率',
  `new_uncovered_conditions_count` int(11) DEFAULT NULL COMMENT '新的或更新代码中未覆盖的条件数',
  `new_security_rating_avg` float(10,2) DEFAULT NULL COMMENT '新代码安全评级',
  `new_vulnerabilities_count` int(11) DEFAULT NULL COMMENT '新增漏洞数',
  `new_bugs_count` int(11) DEFAULT NULL COMMENT '新增bug数',
  `new_duplicated_lines_count` int(11) DEFAULT NULL COMMENT '新增重复行',
  `new_code_smells_count` int(11) DEFAULT NULL COMMENT '新增坏味道',
  `new_maintainability_rating_avg` float(10,2) DEFAULT NULL COMMENT '新增代码可靠性评级',
  `new_security_remediation_effort_count` int(11) DEFAULT NULL COMMENT '新增代码安全修复工作',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `project_id+author+collectdate` (`project_id`,`author`,`collect_date`)
) ENGINE=InnoDB AUTO_INCREMENT=588 DEFAULT CHARSET=utf8;

/*Table structure for table `svn_project` */

CREATE TABLE `svn_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(100) DEFAULT NULL,
  `artifactId` varchar(100) DEFAULT NULL COMMENT '项目在sonar中的标识，maven项目为pom.xml中的name部分，c项目为sonar-project.properties 中的sonar.projectName配置',
  `svn_path` varchar(255) DEFAULT NULL COMMENT '项目在svn中的路径，不包含svn_url部分',
  `project_type` int(2) DEFAULT NULL COMMENT '1：maven项目\r\n2：c项目\r\n',
  `description` varchar(255) DEFAULT NULL COMMENT '项目描述',
  `check_cycle` varchar(20) DEFAULT NULL COMMENT '扫描周期，单位为天',
  `remote_path` varchar(255) DEFAULT NULL COMMENT '项目在编译环境上的路径',
  `remote_ip` varchar(50) DEFAULT NULL COMMENT '编译主机',
  `remote_port` varchar(5) DEFAULT NULL COMMENT '编译主机ssh端口',
  `remote_user` varchar(50) DEFAULT NULL COMMENT '用户名',
  `remote_password` varchar(50) DEFAULT NULL COMMENT '密码',
  `env_file` varchar(255) DEFAULT NULL COMMENT '环境变量文件，java项目需要',
  `last_checktime` datetime DEFAULT NULL COMMENT '上次扫描时间',
  `creator` varchar(50) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `group_id` int(11) DEFAULT NULL COMMENT '项目组id',
  `scanflag` int(1) DEFAULT '0' COMMENT '是否扫描此项目，0扫描；1不扫描。默认为0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Table structure for table `svn_project_group` */

CREATE TABLE `svn_project_group` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '项目组id',
  `group_name` varchar(50) NOT NULL COMMENT '项目组名称',
  `group_path` varchar(200) DEFAULT NULL COMMENT '项目组目录路径',
  `description` varchar(500) DEFAULT NULL COMMENT '项目组描述',
  `creator` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Table structure for table `svn_userproject` */

CREATE TABLE `svn_userproject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `project_id` (`project_id`,`username`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

/*Table structure for table `sys_config` */

CREATE TABLE `sys_config` (
  `param` varchar(30) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `sys_permission` */

CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_id` varchar(20) NOT NULL COMMENT '权限id',
  `name` varchar(100) NOT NULL COMMENT '权限名称',
  `description` varchar(255) DEFAULT NULL COMMENT '权限描述',
  `url` varchar(255) DEFAULT NULL COMMENT '权限访问路径',
  `perms` varchar(255) DEFAULT NULL COMMENT '权限标识',
  `parent_id` int(11) DEFAULT NULL COMMENT '父级权限id',
  `type` int(1) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `order_num` int(3) DEFAULT '0' COMMENT '排序',
  `icon` varchar(50) DEFAULT NULL COMMENT '图标',
  `status` int(1) NOT NULL COMMENT '状态：1有效；2删除',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

/*Table structure for table `sys_role` */

CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` varchar(20) NOT NULL COMMENT '角色id',
  `name` varchar(50) NOT NULL COMMENT '角色名称',
  `description` varchar(255) DEFAULT NULL COMMENT '角色描述',
  `status` int(1) NOT NULL COMMENT '状态：1有效；2删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Table structure for table `sys_role_permission` */

CREATE TABLE `sys_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` varchar(20) NOT NULL COMMENT '角色id',
  `permission_id` varchar(20) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1562 DEFAULT CHARSET=utf8;

/*Table structure for table `sys_user_role` */

CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) NOT NULL COMMENT '用户id',
  `role_id` varchar(20) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Table structure for table `sys_userinfo` */

CREATE TABLE `sys_userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) NOT NULL COMMENT '用户id',
  `username` varchar(50) NOT NULL COMMENT '用户名(svn账号)',
  `nt` varchar(50) DEFAULT NULL COMMENT 'nt账号',
  `realname` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `password` varchar(50) NOT NULL,
  `department` varchar(100) DEFAULT NULL COMMENT '部门',
  `salt` varchar(128) DEFAULT NULL COMMENT '加密盐值',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(50) DEFAULT NULL COMMENT '联系方式',
  `sex` int(1) DEFAULT NULL COMMENT '年龄：1男2女',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `status` int(1) NOT NULL COMMENT '用户状态：1有效; 2删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`id`,`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Table structure for table `zbox_case` */

CREATE TABLE `zbox_case` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `zboxid` int(11) DEFAULT NULL COMMENT '禅道中该case的id',
  `username` varchar(10) DEFAULT NULL COMMENT '用户名',
  `summary` varchar(255) DEFAULT NULL COMMENT 'case描述',
  `product` varchar(100) DEFAULT NULL COMMENT 'case是哪个产品下的',
  `priority` int(1) DEFAULT NULL COMMENT 'case优先级',
  `createtime` datetime DEFAULT NULL COMMENT 'case创建时间',
  `updatetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '本条记录更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `zboxid` (`zboxid`)
) ENGINE=InnoDB AUTO_INCREMENT=875 DEFAULT CHARSET=utf8;


