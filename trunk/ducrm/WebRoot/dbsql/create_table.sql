--========================================== 系统表 start ==========================================
--系统流水号
drop table if exists sys_app_sequence;
create table sys_app_sequence (
	id bigint(20) unsigned not null auto_increment comment '流水号',
	createtime varchar(19) not null comment '创建时间',
	updatetime varchar(19) not null comment '更新时间',
	flag bit(1) not null comment '标记',
	status bit(1) not null comment '状态',
	enseqname varchar(50) not null comment '名称',
	cnseqname varchar(50) not null comment '备注',
	seqvalue varchar(22) not null comment '值',
	constraint pk_sequence_id primary key (id),
	constraint un_sequence_code unique (enseqname)
) engine=innodb default charset=utf8;

--系统用户表
drop table if exists sys_user;
CREATE TABLE sys_user (
	id bigint(20) unsigned not null comment '流水号',
	createtime varchar(19) not null comment '创建时间',
	updatetime varchar(19) not null comment '更新时间',
	flag bit(1) not null comment '标记',
	status bit(1) not null comment '状态',
	username varchar(50) NOT NULL comment '账号',
	password varchar(50) NOT NULL comment '密码',
	fk_employee_id bigint(20) DEFAULT NULL comment '所属员工ID',
	constraint pk_user_id primary key (id),
	constraint un_user_code unique (username)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--系统角色用户表
drop table if exists sys_role_user;
CREATE TABLE sys_role_user (
 	id bigint(20) unsigned not null comment '流水号',
	createtime varchar(19) not null comment '创建时间',
	updatetime varchar(19) not null comment '更新时间',
	flag bit(1) not null comment '标记',
	status bit(1) not null comment '状态',
	fk_role_id bigint(20) DEFAULT NULL comment '所属角色ID',
	fk_user_id bigint(20) DEFAULT NULL comment '所属用户ID',
	constraint pk_role_user_id primary key (id),
	constraint un_role_user unique (fk_role_id,fk_user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--系统角色菜单表
drop table if exists sys_role_menu;
CREATE TABLE sys_role_menu (
	id bigint(20) unsigned not null comment '流水号',
	createtime varchar(19) not null comment '创建时间',
	updatetime varchar(19) not null comment '更新时间',
	flag bit(1) not null comment '标记',
	status bit(1) not null comment '状态',
	fk_menu_id bigint(20) DEFAULT NULL comment '所属菜单ID',
	fk_role_id bigint(20) DEFAULT NULL comment '所属角色ID',
	constraint pk_role_menu_id primary key (id),
	constraint un_role_menu unique (fk_menu_id,fk_role_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--系统角色表
drop table if exists sys_role;
CREATE TABLE sys_role (
	id bigint(20) unsigned not null comment '流水号',
	createtime varchar(19) not null comment '创建时间',
	updatetime varchar(19) not null comment '更新时间',
	flag bit(1) not null comment '标记',
	status bit(1) not null comment '状态',
	code varchar(9) NOT NULL comment '编号',
	name varchar(30) NOT NULL comment '名称',
	caption varchar(50) DEFAULT NULL comment '备注',
	constraint pk_role_id primary key (id),
	constraint un_role_code unique (code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--系统菜单表
drop table if exists sys_menu;
CREATE TABLE sys_menu (
	id bigint(20) unsigned not null comment '流水号',
	createtime varchar(19) not null comment '创建时间',
	updatetime varchar(19) not null comment '更新时间',
	flag bit(1) not null comment '标记',
	status bit(1) not null comment '状态',
	chName varchar(50) NOT NULL comment '显示名称',
	enName varchar(50) NOT NULL comment '菜单名称',
	href varchar(255) DEFAULT NULL comment '地址',
	sort int(11) NOT NULL comment '排序',
	parentId bigint(20) DEFAULT NULL comment '所属菜单ID',
	constraint pk_menu_id primary key (id),
	constraint un_menu_enName unique (enName)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--系统字典项表
drop table if exists sys_dict;
create table sys_dict (
	id bigint(20) not null comment '流水号',
	createtime varchar(19) not null comment '创建时间',
	updatetime varchar(19) not null comment '更新时间',
	flag bit(1) not null comment '标记',
	status bit(1) not null comment '状态',
	code varchar(9) not null comment '编号',
	name varchar(50) not null comment '名称',
	sort varchar(20) not null comment '分类',
	caption varchar(50) comment '备注',
	constraint pk_dict_id primary key (id),
	constraint un_dict_code_sort unique (code,sort)
) engine=innodb default charset=utf8;

--系统设置表
drop table if exists sys_cfg;
create table sys_cfg (
 	id bigint(20) not null comment '流水号',
	createtime varchar(19) not null comment '创建时间',
	updatetime varchar(19) not null comment '更新时间',
	flag bit(1) not null comment '标记',
	status bit(1) not null comment '状态',
	address varchar(50) DEFAULT NULL comment '地址',
	badd1 varchar(50) DEFAULT NULL comment '开户地址1',
	badd2 varchar(50) DEFAULT NULL comment '开户地址2',
	bcode1 varchar(30) DEFAULT NULL comment '银行账号1',
	bcode2 varchar(30) DEFAULT NULL comment '银行账号2',
	bman1 varchar(30) DEFAULT NULL comment '开户人1',
	bman2 varchar(30) DEFAULT NULL comment '开户人2',
	bname1 varchar(30) DEFAULT NULL comment '银行名称1',
	bname2 varchar(30) DEFAULT NULL comment '银行名称2',
	email1 varchar(50) DEFAULT NULL comment '邮箱1',
	email2 varchar(50) DEFAULT NULL comment '邮箱2',
	fax1 varchar(20) DEFAULT NULL comment '传真1',
	fax2 varchar(20) DEFAULT NULL comment '传真2',
	linkman1 varchar(50) DEFAULT NULL comment '联系人1',
	linkman2 varchar(10) DEFAULT NULL comment '联系人2',
	mobile1 varchar(11) DEFAULT NULL comment '手机1',
	mobile2 varchar(11) DEFAULT NULL comment '手机2',
	name varchar(50) DEFAULT NULL comment '公司名称',
	phone1 varchar(20) DEFAULT NULL comment '电话1',
	phone2 varchar(20) DEFAULT NULL comment '电话2',
	postcode varchar(6) DEFAULT NULL comment '邮编',
	qq1 varchar(20) DEFAULT NULL comment 'QQ1',
	qq2 varchar(20) DEFAULT NULL comment 'QQ2',
	tel1 varchar(20) DEFAULT NULL comment '联系人电话1',
	tel2 varchar(20) DEFAULT NULL comment '联系人电话2',
	web varchar(50) DEFAULT NULL comment '网址',
	constraint pk_cfg_id primary key (id),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--========================================== 系统表 end   ==========================================

--========================================== 基本数据表 start ==========================================
--附件
drop table if exists base_accessory;
create table base_accessory (
	id bigint(20) not null comment '流水号',
	createTime varchar(19) not null comment '创建时间',
	updateTime varchar(19) not null comment '更新时间',
	flag bit(1) not null comment '标记',
	status bit(1) not null comment '状态',
	dataId bigint(20) NOT NULL comment '数据ID',
	name varchar(255) NOT NULL comment '文件名',
	path varchar(255) NOT NULL comment '路径',
	userid bigint(20) NOT NULL comment '上传人ID',
	realname varchar(20) NOT NULL comment '上传人',
	sort varchar(20) NOT NULL comment '类型',
	constraint pk_accessory_id primary key (id)
) engine=innodb default charset=utf8;

--分类
drop table if exists base_category;
drop table base_category;
create table base_category (
	id bigint(20) not null comment '流水号',
	createTime varchar(19) not null comment '创建时间',
	updateTime varchar(19) not null comment '更新时间',
	flag bit(1) not null comment '标记',
	status bit(1) not null comment '状态',
	code varchar(20) NOT NULL comment '编号',
	name varchar(50) NOT NULL comment '名称',
	sort varchar(20) NOT NULL comment '类型',
	fk_category_id bigint(20) DEFAULT NULL comment '所属分类',
	constraint pk_category_id primary key (id),
	constraint un_category_code unique (code)
) engine=innodb default charset=utf8;

--地区
drop table if exists base_area;
create table base_area (
	id bigint(20) not null comment '流水号',
	createTime varchar(19) not null comment '创建时间',
	updateTime varchar(19) not null comment '更新时间',
	flag bit(1) not null comment '标记',
	status bit(1) not null comment '状态',
	code varchar(10) not null comment '编号',
	name varchar(50) not null comment '名称',
	fk_area_id bigint(20) comment '所属地区',
	constraint pk_area_id primary key (id),
	constraint un_area_code unique (code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--客户
drop table if exists base_customer;
create table base_customer (
	id bigint(20) not null comment '流水号',
	createTime varchar(19) not null comment '创建时间',
	updateTime varchar(19) not null comment '更新时间',
	flag bit(1) not null comment '标记',
	status bit(1) not null comment '状态',
	code varchar(10) NOT NULL comment '编号',
	name varchar(50) NOT NULL comment '名称',
	shortName varchar(20) DEFAULT NULL comment '简称',
	linkman varchar(20) DEFAULT NULL comment '联系人',
	email varchar(50) DEFAULT NULL comment '邮箱',
	fax varchar(20) DEFAULT NULL comment '传真',
	mobile varchar(11) DEFAULT NULL comment '手机',
	phone varchar(20) DEFAULT NULL comment '单位电话',
	qq varchar(20) DEFAULT NULL comment 'QQ',
	tel varchar(20) DEFAULT NULL comment '联系人电话',
	web varchar(50) DEFAULT NULL comment '网站',
	postcode varchar(6) DEFAULT NULL comment '邮编',
	fk_city_id bigint(20) DEFAULT NULL comment '城市',
	fk_province_id bigint(20) DEFAULT NULL comment '省份',
	address varchar(50) DEFAULT NULL comment '地址',
	fk_sort_id bigint(20) DEFAULT NULL comment '类型',
	bcode varchar(30) DEFAULT NULL comment '银行账号',
	bman varchar(50) DEFAULT NULL comment '开户人姓名',
	bname varchar(50) DEFAULT NULL comment '银行名称',
	badd varchar(100) DEFAULT NULL comment '开户地址',
	constraint pk_customer_id primary key (id),
	constraint un_customer_code unique (code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--供应商
drop table if exists base_provider;
create table base_provider (
	id bigint(20) not null comment '流水号',
	createTime varchar(19) not null comment '创建时间',
	updateTime varchar(19) not null comment '更新时间',
	flag bit(1) not null comment '标记',
	status bit(1) not null comment '状态',
	code varchar(10) NOT NULL comment '编号',
	name varchar(50) NOT NULL comment '名称',
	shortName varchar(20) DEFAULT NULL comment '简称',
	linkman varchar(20) DEFAULT NULL comment '联系人',
	email varchar(50) DEFAULT NULL comment '邮箱',
	fax varchar(20) DEFAULT NULL comment '传真',
	mobile varchar(11) DEFAULT NULL comment '手机',
	phone varchar(20) DEFAULT NULL comment '单位电话',
	qq varchar(20) DEFAULT NULL comment 'QQ',
	tel varchar(20) DEFAULT NULL comment '联系人电话',
	web varchar(50) DEFAULT NULL comment '网站',
	postcode varchar(6) DEFAULT NULL comment '邮编',
	fk_city_id bigint(20) DEFAULT NULL comment '城市',
	fk_province_id bigint(20) DEFAULT NULL comment '省份',
	address varchar(50) DEFAULT NULL comment '地址',
	bcode varchar(30) DEFAULT NULL comment '银行账号',
	bman varchar(50) DEFAULT NULL comment '开户人姓名',
	bname varchar(50) DEFAULT NULL comment '银行名称',
	badd varchar(100) DEFAULT NULL comment '开户地址',
	constraint pk_provider_id primary key (id),
	constraint un_provider_code unique (code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--联系人
drop table if exists base_linkman;
create table base_linkman (
	id bigint(20) not null comment '流水号',
	createTime varchar(19) not null comment '创建时间',
	updateTime varchar(19) not null comment '更新时间',
	flag bit(1) not null comment '标记',
	status bit(1) not null comment '状态',
	name varchar(20) NOT NULL comment '名称',
	duty varchar(10) DEFAULT NULL comment '职务',
	email varchar(50) DEFAULT NULL comment '邮箱',
	mobile varchar(20) DEFAULT NULL comment '手机',
	phone varchar(20) DEFAULT NULL comment '电话',
	qq varchar(20) DEFAULT NULL comment 'QQ',
	company varchar(20) DEFAULT NULL comment '工作单位或部门',
	fk_relation_id bigint(20) DEFAULT NULL comment '所属关系',
	dataId bigint(20) NOT NULL comment '记录ID',
	sort varchar(20) NOT NULL comment '类型',
	constraint pk_linkman_id primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--部门
drop table if exists base_department;
create table base_department (
	id bigint(20) not null comment '流水号',
	createTime varchar(19) not null comment '创建时间',
	updateTime varchar(19) not null comment '更新时间',
	flag bit(1) not null comment '标记',
	status bit(1) not null comment '状态',
	code varchar(10) not null comment '编号',
	name varchar(20) not null comment '名称',
	fk_department_id bigint(20) comment '所属部门',
	managerId bigint(20) comment '部门经理ID',
	manager varchar(10) comment '部门经理',
	phone varchar(20) comment '部门电话',
	fax varchar(20) comment '部门传真',
	constraint pk_department_id primary key (id),
	constraint un_department_code unique (code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--员工
drop table if exists base_employee;
create table base_employee (
	id bigint(20) not null comment '流水号',
	createTime varchar(19) not null comment '创建时间',
	updateTime varchar(19) not null comment '更新时间',
	flag bit(1) not null comment '标记',
	status bit(1) not null comment '状态',
	blood varchar(10) comment '血型',
	born varchar(10) comment '出生日期',
	email varchar(50) comment '邮箱',
	height varchar(3) comment '身高',
	love varchar(50) comment '爱好',
	mobile varchar(11) comment '手机',
	name varchar(10) comment '姓名',
	phone varchar(20) comment '电话',
	postcode varchar(6) comment '邮编',
	qq varchar(20) comment 'QQ',
	sex varchar(10) comment '性别',
	weight varchar(3) comment '体重',
	code varchar(10) comment '编号',
	idcard varchar(255) comment '证件号码',
	fk_idtype_id bigint(20) comment '证件类型',
	fk_department_id bigint(20) comment '所属部门',
	fk_duty_id bigint(20) comment '所属职务',
	badd varchar(100) comment '银行开户地址',
	bcode varchar(25) comment '银行账号',
	bman varchar(20) comment '开户人',
	bname varchar(50) comment '银行名称',
	fk_nation_id bigint(20) comment '民族',
	fk_polity_id bigint(20) comment '政治面貌',
	address varchar(50) comment '详细地址',
	photo varchar(255) comment '照片',
	fk_city_id bigint(20) comment '所属城市',
	fk_province_id bigint(20) comment '所属省份',
	degree varchar(10) comment '学历',
	school varchar(30) comment '毕业学校',
	specialty varchar(30) comment '所学专业',
	constraint pk_employee_id primary key (id),
	constraint un_employee_code unique (code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--物料
drop table if exists base_material;
CREATE TABLE base_material (
	id bigint(20) NOT NULL comment '流水号',
	createtime varchar(19) not null comment '创建时间',
	updatetime varchar(19) not null comment '更新时间',
	flag bit(1) not null comment '标记',
	status bit(1) not null comment '状态',
	fk_provider_id bigint(20) comment '所属供应商ID',
	code varchar(10) comment '编号',
	name varchar(50) comment '名称',
	spec varchar(20) comment '规格',
	price decimal(12,2) comment '价格',
	fk_unit_id bigint(20) comment '所属单位ID',
	fk_category_id bigint(20) comment '所属分类ID',
	caption varchar(50) comment '备注',
	constraint pk_material_id primary key (id),
	constraint un_material_code unique (code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--工序
drop table if exists base_work;
CREATE TABLE base_work (
	id bigint(20) NOT NULL comment '流水号',
	createtime varchar(19) not null comment '创建时间',
	updatetime varchar(19) not null comment '更新时间',
	flag bit(1) not null comment '标记',
	status bit(1) not null comment '状态',
	code varchar(10) NOT NULL comment '编号',
	name varchar(50) NOT NULL comment '名称',
	price decimal(12,2) NOT NULL comment '工价',
	remark varchar(50) comment '备注',
	constraint pk_work_id primary key (id),
	constraint un_work_code unique (code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--产品
drop table if exists base_product;
create table base_product (
	id bigint(20) NOT NULL comment '流水号',
	createtime varchar(19) not null comment '创建时间',
	updatetime varchar(19) not null comment '更新时间',
	flag bit(1) not null comment '标记',
	status bit(1) not null comment '状态',
	code varchar(10) NOT NULL comment '编号',
	name varchar(50) NOT NULL comment '名称',
	price decimal(12,2) NOT NULL comment '价格',
	type varchar(10) NOT NULL comment '类型，INSIDE：内部产品，OUTSIDE：外部产品',  
	fk_sort_id bigint(20) DEFAULT NULL comment '所属分类',
	fk_unit_id bigint(20) DEFAULT NULL comment '所属单位',
	fk_customer_id bigint(20) DEFAULT NULL comment '所属客户',
	cost decimal(12,2) DEFAULT NULL comment '成本',
	constraint pk_product_id primary key (id),
	constraint un_product_code unique (code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--产品物料
drop table if exists xm_product_mate;
CREATE TABLE xm_product_mate (
	id bigint(20) NOT NULL comment '流水号',
	createtime varchar(19) not null comment '创建时间',
	updatetime varchar(19) not null comment '更新时间',
	flag bit(1) not null comment '标记',
	status bit(1) not null comment '状态',
	proId bigint(20) NOT NULL comment '产品ID',
	mateId bigint(20) NOT NULL comment '物料ID',
	code varchar(10) NOT NULL comment '物料编号',
	name varchar(60) NOT NULL comment '物料名称',
	amount decimal(12,2) NOT NULL comment '数量',
	price decimal(12,2) NOT NULL comment '价格',
	total decimal(12,2) NOT NULL comment '金额',
	unit varchar(10) NOT NULL comment '单位',
	constraint pk_pro_mate_id primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--产品工序
drop table if exists xm_product_work;
CREATE TABLE xm_product_work (
	id bigint(20) NOT NULL comment '流水号',
	createtime varchar(19) not null comment '创建时间',
	updatetime varchar(19) not null comment '更新时间',
	flag bit(1) not null comment '标记',
	status bit(1) not null comment '状态',
	fk_product_id bigint(20) NOT NULL comment '产品ID',
	workId bigint(20) NOT NULL comment '工序ID',
	code varchar(10) NOT NULL comment '工序编号',
	name varchar(60) NOT NULL comment '工序名称',
	amount decimal(12,2) NOT NULL comment '数量',
	price decimal(12,2) NOT NULL comment '价格',
	total decimal(12,2) NOT NULL comment '金额',
	constraint pk_pro_work_id primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--仓库信息
drop table if exists base_store;
CREATE TABLE base_store (
	id bigint(20) NOT NULL comment '流水号',
	createtime varchar(19) not null comment '创建时间',
	updatetime varchar(19) not null comment '更新时间',
	flag bit(1) not null comment '标记',
	status bit(1) not null comment '状态',
	name varchar(50) NOT NULL comment '名称',
	constraint pk_store_id primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--库存信息
drop table if exists base_storage;
CREATE TABLE base_storage (
	id bigint(20) NOT NULL comment '流水号',
	createtime varchar(19) not null comment '创建时间',
	updatetime varchar(19) not null comment '更新时间',
	flag bit(1) not null comment '标记',
	status bit(1) not null comment '状态',
	name varchar(50) NOT NULL comment '名称',
	size varchar(10) DEFAULT NULL comment '码数',
	amount decimal(12,2) NOT NULL comment '数量',
	sort varchar(10) NOT NULL comment '类型',
	dataId bigint(20) NOT NULL comment '记录ID',
	storeId bigint(20) NOT NULL comment '仓库ID',
	up decimal(12,2) DEFAULT NULL comment '上限',
	down decimal(12,2) DEFAULT NULL comment '下限',
	state varchar(10) DEFAULT NULL comment '盘点状态',
	constraint pk_storage_id primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--========================================== 基本数据表 end   ==========================================

--========================================== 采购相关表 start ==========================================
--物料采购表
drop table if exists xm_buy_order;
create table xm_buy_order (
	id bigint(20) not null comment '流水号',
	createtime varchar(19) not null comment '创建时间',
	updatetime varchar(19) not null comment '更新时间',
	flag bit(1) not null comment '标记',
	status bit(1) not null comment '状态',
	clientId bigint(20) DEFAULT NULL comment '供应商ID',
	code varchar(15) NOT NULL comment '供应商编号',
	name varchar(30) DEFAULT NULL comment '供应商名称',
	grade varchar(10) DEFAULT NULL comment '级别',
	deliver varchar(10) DEFAULT NULL comment '到货日期',
	nopay decimal(12,2) DEFAULT NULL comment '未付金额',
	payfor decimal(12,2) DEFAULT NULL comment '已付金额',
	payment decimal(12,2) DEFAULT NULL comment '应付金额',
	total decimal(12,2) DEFAULT NULL comment '总数',
	inState varchar(10) DEFAULT NULL comment '入库状态',
	fk_payment_id bigint(20) DEFAULT NULL comment '所属付款类型',
	fk_ticket_id bigint(20) DEFAULT NULL comment '所属票据类型',
	linkman varchar(20) DEFAULT NULL comment '联系人',
	tel varchar(20) DEFAULT NULL comment '联系人电话',
	mobile varchar(20) DEFAULT NULL comment '手机',
	phone varchar(20) DEFAULT NULL comment '单位电话',
	fax varchar(20) DEFAULT NULL comment '单位传真',
	postcode varchar(6) DEFAULT NULL comment '邮编',
	addDate varchar(10) DEFAULT NULL comment '添加日期',
	addId bigint(20) DEFAULT NULL comment '添加人ID',
	addName varchar(20) DEFAULT NULL comment '添加人',
	address varchar(50) DEFAULT NULL comment '地址',
	auditDate varchar(10) DEFAULT NULL comment '审核日期',
	auditId bigint(20) DEFAULT NULL comment '审核人ID',
	auditName varchar(20) DEFAULT NULL comment '审核人',
	auditState varchar(20) DEFAULT NULL comment '审核状态',
	followDate varchar(10) DEFAULT NULL comment '跟单日期',
	followId bigint(20) DEFAULT NULL comment '跟单人Id',
	followName varchar(20) DEFAULT NULL comment '跟单人',
	followState varchar(20) DEFAULT NULL comment '跟单状态',
	backState varchar(15) DEFAULT NULL comment '退回状态',
	balanceState varchar(20) DEFAULT NULL comment '预算状态',
	cause varchar(50) DEFAULT NULL comment '退回原因',
	state varchar(20) DEFAULT NULL comment '状态',
	constraint pk_buy_id primary key (id),
	constraint un_buy_code unique (code)
) engine=innodb default charset=utf8;

--物料采购明细表
drop table if exists xm_buy_order_list;
create table xm_buy_order_list (
	id bigint(20) not null comment '流水号',
	createtime varchar(19) not null comment '创建时间',
	updatetime varchar(19) not null comment '更新时间',
	flag bit(1) not null comment '标记',
	status bit(1) not null comment '状态',
	fk_order_id bigint(20) DEFAULT NULL comment '所属采购单ID',
	mateId bigint(20) DEFAULT NULL comment '物料ID',
	name varchar(50) DEFAULT NULL comment '名称',
	spec varchar(20) DEFAULT NULL comment '规格',
	unit varchar(10) DEFAULT NULL comment '单位',
	amount decimal(12,2) DEFAULT NULL comment '采购数',
	price decimal(12,2) DEFAULT NULL comment '价格',
	remark varchar(50) DEFAULT NULL comment '备注',
	constraint pk_buy_list_id primary key (id)
) engine=innodb default charset=utf8;

--物料询价表
drop table if exists xm_buy_price;
create table xm_buy_price (
	id bigint(20) not null comment '流水号',
	createtime varchar(19) not null comment '创建时间',
	updatetime varchar(19) not null comment '更新时间',
	flag bit(1) not null comment '标记',
	status bit(1) not null comment '状态',
	addDate varchar(10) DEFAULT NULL comment '添加日期',
	addId bigint(20) DEFAULT NULL comment '添加人ID',
	addName varchar(20) DEFAULT NULL comment '添加人',
	address varchar(50) DEFAULT NULL comment '地址',
	auditDate varchar(10) DEFAULT NULL comment '审核日期',
	auditId bigint(20) DEFAULT NULL comment '审核人ID',
	auditName varchar(20) DEFAULT NULL comment '审核人',
	auditState varchar(20) DEFAULT NULL comment '审核状态',
	clientId bigint(20) DEFAULT NULL comment '供应商ID',
	code varchar(15) NOT NULL comment '询价单号',
	fax varchar(20) DEFAULT NULL comment '传真',
	followDate varchar(10) DEFAULT NULL comment '跟单日期',
	followId bigint(20) DEFAULT NULL comment '跟单人ID',
	followName varchar(20) DEFAULT NULL comment '跟单人',
	followState varchar(20) DEFAULT NULL comment '跟单状态',
	grade varchar(10) DEFAULT NULL comment '级别',
	linkman varchar(20) DEFAULT NULL comment '联系人',
	mobile varchar(20) DEFAULT NULL comment '手机',
	name varchar(30) DEFAULT NULL comment '供应商名称',
	nopay decimal(12,2) DEFAULT NULL comment '未付金额',
	payfor decimal(12,2) DEFAULT NULL comment '已付金额',
	payment decimal(12,2) DEFAULT NULL comment '应付金额',
	phone varchar(20) DEFAULT NULL comment '电话',
	postcode varchar(6) DEFAULT NULL comment '邮编',
	state varchar(20) DEFAULT NULL comment '状态',
	tel varchar(20) DEFAULT NULL comment '联系人电话',
	total decimal(12,2) DEFAULT NULL comment '总数',
	askType varchar(10) DEFAULT NULL comment '询价方式',
	fk_payment_id bigint(20) DEFAULT NULL comment '付款方式',
	fk_ticket_id bigint(20) DEFAULT NULL comment '票据类型',
	constraint pk_buy_id primary key (id),
	constraint un_buy_code unique (code)
) engine=innodb default charset=utf8;

--物料询价明细表
drop table if exists xm_buy_price_list;
create table xm_buy_price_list (
	id bigint(20) not null comment '流水号',
	createtime varchar(19) not null comment '创建时间',
	updatetime varchar(19) not null comment '更新时间',
	flag bit(1) not null comment '标记',
	status bit(1) not null comment '状态',
	fk_order_id bigint(20) DEFAULT NULL comment '所属物料询价单ID',
	mateId bigint(20) DEFAULT NULL comment '物料ID',
	name varchar(50) DEFAULT NULL comment '物料名称',
	spec varchar(20) DEFAULT NULL comment '规格',
	amount decimal(12,2) DEFAULT NULL comment '数量',
	price decimal(12,2) DEFAULT NULL comment '价格',
	unit varchar(10) DEFAULT NULL comment '单位',
	remark varchar(50) DEFAULT NULL comment '备注',
	constraint pk_buy_list_id primary key (id)
) engine=innodb default charset=utf8;
--========================================== 采购相关表 end   ==========================================

--========================================== 销售相关表 start ==========================================
--产品报价表
drop table xm_product_price;
create table xm_product_price (
	id bigint(20) not null comment '流水号',
	createtime varchar(19) not null comment '创建时间',
	updatetime varchar(19) not null comment '更新时间',
	flag bit(1) not null comment '标记',
	status bit(1) not null comment '状态',
	addDate varchar(10) DEFAULT NULL comment '添加日期',
	addId bigint(20) DEFAULT NULL comment '添加人ID',
	addName varchar(20) DEFAULT NULL comment '添加人',
	address varchar(50) DEFAULT NULL comment '地址',
	auditDate varchar(10) DEFAULT NULL comment '审核日期',
	auditId bigint(20) DEFAULT NULL comment '审核人ID',
	auditName varchar(20) DEFAULT NULL comment '审核人',
	auditState varchar(20) DEFAULT NULL comment '审核状态',
	clientId bigint(20) DEFAULT NULL comment '客户ID',
	code varchar(15) NOT NULL comment '报价单号',
	fax varchar(20) DEFAULT NULL comment '单位传真',
	followDate varchar(10) DEFAULT NULL comment '跟单日期',
	followId bigint(20) DEFAULT NULL comment '跟单人ID',
	followName varchar(20) DEFAULT NULL comment '跟单人',
	followState varchar(20) DEFAULT NULL comment '跟单状态',
	grade varchar(10) DEFAULT NULL comment '级别',
	linkman varchar(20) DEFAULT NULL comment '联系人',
	mobile varchar(20) DEFAULT NULL comment '手机',
	name varchar(30) DEFAULT NULL comment '客户名称',
	nopay decimal(12,2) DEFAULT NULL comment '未收金额',
	payfor decimal(12,2) DEFAULT NULL comment '已收金额',
	payment decimal(12,2) DEFAULT NULL comment '应收金额',
	phone varchar(20) DEFAULT NULL comment '单位电话',
	postcode varchar(6) DEFAULT NULL comment '邮编',
	state varchar(20) DEFAULT NULL comment '状态',
	tel varchar(20) DEFAULT NULL comment '联系人电话',
	total decimal(12,2) DEFAULT NULL comment '总数',
	askState varchar(15) DEFAULT NULL comment '报价状态',
	askType varchar(10) DEFAULT NULL comment '报价方式',
	fk_payment_id bigint(20) DEFAULT NULL comment '付款方式',
	fk_ticket_id bigint(20) DEFAULT NULL comment '杜撰类型',
	constraint pk_price_id primary key (id),
	constraint un_price_code unique (code)
) engine=innodb default charset=utf8;

--产品报价明细表
drop table xm_product_price_list;
create table xm_product_price_list (
	id bigint(20) not null comment '流水号',
	createtime varchar(19) not null comment '创建时间',
	updatetime varchar(19) not null comment '更新时间',
	flag bit(1) not null comment '标记',
	status bit(1) not null comment '状态',
	amount int(11) DEFAULT NULL comment '数量',
	name varchar(100) NOT NULL comment '名称',
	price decimal(12,2) DEFAULT NULL comment '价格',
	proId bigint(20) DEFAULT NULL comment '产品ID',
	remark varchar(50) DEFAULT NULL comment '备注',
	size varchar(10) NOT NULL comment '码数',
	unit varchar(10) DEFAULT NULL comment '单位',
	fk_order_id bigint(20) DEFAULT NULL comment '所属报价单ID',
	constraint pk_list_id primary key (id)
) engine=innodb default charset=utf8;

--产品订单表
drop table xm_sell_order;
create table xm_sell_order (
	id bigint(20) not null comment '流水号',
	createtime varchar(19) not null comment '创建时间',
	updatetime varchar(19) not null comment '更新时间',
	flag bit(1) not null comment '标记',
	status bit(1) not null comment '状态',
	clientId bigint(20) DEFAULT NULL comment '客户ID',
	name varchar(50) DEFAULT NULL comment '客户名称',
	code varchar(15) NOT NULL comment '订单编号',
	phone varchar(20) DEFAULT NULL comment '单位电话',
	fax varchar(20) DEFAULT NULL comment '单位传真',
	linkman varchar(10) DEFAULT NULL comment '联系人',
	mobile varchar(20) DEFAULT NULL comment '联系人手机',
	tel varchar(20) DEFAULT NULL comment '联系人电话',
	postcode varchar(6) DEFAULT NULL comment '邮政编码',
	address varchar(50) DEFAULT NULL comment '地址',
	total decimal(12,2) DEFAULT NULL comment '总数',
	nopay decimal(12,2) DEFAULT NULL comment '未收金额',
	payfor decimal(12,2) DEFAULT NULL comment '已收金额',
	payment decimal(12,2) DEFAULT NULL comment '应收金额',
	deliver varchar(10) DEFAULT NULL comment '交货日期',
	sort varchar(20) DEFAULT NULL comment '订单类型',
	grade varchar(10) DEFAULT NULL comment '紧急度',
	addDate varchar(10) DEFAULT NULL comment '添加日期',
	addId bigint(20) DEFAULT NULL comment '添加人ID',
	addName varchar(20) DEFAULT NULL comment '添加人',
	audit varchar(12) DEFAULT NULL comment '审核状态',
	make varchar(12) DEFAULT NULL comment '生产状态',
	constraint pk_sell_id primary key (id),
	constraint un_sell_code unique (code)
) engine=innodb default charset=utf8;

--产品订单明细表
drop table xm_sell_order_list;
create table xm_sell_order_list (
	id bigint(20) not null comment '流水号',
	createtime varchar(19) not null comment '创建时间',
	updatetime varchar(19) not null comment '更新时间',
	flag bit(1) not null comment '标记',
	status bit(1) not null comment '状态',
	fk_order_id bigint(20) DEFAULT NULL comment '所属产品订单ID',
	proId bigint(20) DEFAULT NULL comment '产品ID',
	code varchar(10) DEFAULT NULL comment '产品编号',
	name varchar(50) DEFAULT NULL comment '产品名称',
	size varchar(10) DEFAULT NULL comment '码数',
	unit varchar(255) DEFAULT NULL comment '单位',
	amount int(11) DEFAULT NULL comment '数量',
	price decimal(12,2) DEFAULT NULL comment '价格',
	total decimal(12,2) DEFAULT NULL comment '金额',
	remark varchar(255) DEFAULT NULL comment '备注',
	constraint pk_list_id primary key (id)
	
) engine=innodb default charset=utf8;

--项目订单预算
drop table xm_order_budget;
create table xm_order_budget (
	id bigint(20) not null comment '流水号',
	createtime varchar(19) not null comment '创建时间',
	updatetime varchar(19) not null comment '更新时间',
	flag bit(1) not null comment '标记',
	status bit(1) not null comment '状态',
	amount decimal(12,2) NOT NULL comment '数量',
	code varchar(15) NOT NULL comment '所属订单（采购）编号',
	dataId bigint(20) NOT NULL comment '所属订单明细（采购明细）ID',
	name varchar(100) NOT NULL comment '名称',
	price decimal(12,2) NOT NULL comment '价格',
	remark varchar(50) DEFAULT NULL comment '备注',
	sort varchar(10) NOT NULL comment '类型',
	unit varchar(10) NOT NULL comment '单位',
	constraint pk_budget_id primary key (id)
) engine=innodb default charset=utf8;
--========================================== 销售相关表 end   ==========================================

--========================================== 项目相关表 start ==========================================
--审核意见
DROP TABLE IF EXISTS xm_audit_mind;
create table xm_audit_mind (
	id bigint(20) not null comment '流水号',
	createtime varchar(19) not null comment '创建时间',
	updatetime varchar(19) not null comment '更新时间',
	flag bit(1) not null comment '标记',
	status bit(1) not null comment '状态',
	sort varchar(20) not null comment '类型',
	dataid bigint(20) not null comment '记录id',
	mind varchar(255) not null comment '审核意见',
	auditdate varchar(10) not null comment '审核日期',
	realname varchar(20) not null comment '审核人',
	state varchar(15) not null comment '审核状态',
	constraint pk_mind_id primary key (id)
) engine=innodb default charset=utf8;

--工作报告
DROP TABLE IF EXISTS xm_work_report;
CREATE TABLE xm_work_report (
	id bigint(20) NOT NULL comment '流水号',
	createtime varchar(19) not null comment '创建时间',
	updatetime varchar(19) not null comment '更新时间',
	flag bit(1) not null comment '标记',
	status bit(1) not null comment '状态',	
	empId bigint(20) comment '员工ID',
	empCode varchar(9) comment '员工编号',
	empName varchar(10) comment '员工姓名',
	proId bigint(20) comment '产品ID',
	proCode varchar(9) comment '产品编号',
	proName varchar(50) comment '产品名称',
	workId bigint(20) comment '工序ID',
	workCode varchar(9) comment '工序编号',
	workName varchar(50) comment '工序名称',
	amount decimal(12,2) comment '数量',
	price decimal(12,2) comment '工价',
	total decimal(12,2) comment '金额',
	state varchar(15) comment '结算状态',
	addDate varchar(10) comment '添加日期',
	constraint pk_report_id primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--========================================== 项目相关表  end   ==========================================