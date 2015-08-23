--========================================== ϵͳ�� start ==========================================
--ϵͳ��ˮ��
drop table if exists sys_app_sequence;
create table sys_app_sequence (
	id bigint(20) unsigned not null auto_increment comment '��ˮ��',
	createtime varchar(19) not null comment '����ʱ��',
	updatetime varchar(19) not null comment '����ʱ��',
	flag bit(1) not null comment '���',
	status bit(1) not null comment '״̬',
	enseqname varchar(50) not null comment '����',
	cnseqname varchar(50) not null comment '��ע',
	seqvalue varchar(22) not null comment 'ֵ',
	constraint pk_sequence_id primary key (id),
	constraint un_sequence_code unique (enseqname)
) engine=innodb default charset=utf8;

--ϵͳ�û���
drop table if exists sys_user;
CREATE TABLE sys_user (
	id bigint(20) unsigned not null comment '��ˮ��',
	createtime varchar(19) not null comment '����ʱ��',
	updatetime varchar(19) not null comment '����ʱ��',
	flag bit(1) not null comment '���',
	status bit(1) not null comment '״̬',
	username varchar(50) NOT NULL comment '�˺�',
	password varchar(50) NOT NULL comment '����',
	fk_employee_id bigint(20) DEFAULT NULL comment '����Ա��ID',
	constraint pk_user_id primary key (id),
	constraint un_user_code unique (username)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--ϵͳ��ɫ�û���
drop table if exists sys_role_user;
CREATE TABLE sys_role_user (
 	id bigint(20) unsigned not null comment '��ˮ��',
	createtime varchar(19) not null comment '����ʱ��',
	updatetime varchar(19) not null comment '����ʱ��',
	flag bit(1) not null comment '���',
	status bit(1) not null comment '״̬',
	fk_role_id bigint(20) DEFAULT NULL comment '������ɫID',
	fk_user_id bigint(20) DEFAULT NULL comment '�����û�ID',
	constraint pk_role_user_id primary key (id),
	constraint un_role_user unique (fk_role_id,fk_user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--ϵͳ��ɫ�˵���
drop table if exists sys_role_menu;
CREATE TABLE sys_role_menu (
	id bigint(20) unsigned not null comment '��ˮ��',
	createtime varchar(19) not null comment '����ʱ��',
	updatetime varchar(19) not null comment '����ʱ��',
	flag bit(1) not null comment '���',
	status bit(1) not null comment '״̬',
	fk_menu_id bigint(20) DEFAULT NULL comment '�����˵�ID',
	fk_role_id bigint(20) DEFAULT NULL comment '������ɫID',
	constraint pk_role_menu_id primary key (id),
	constraint un_role_menu unique (fk_menu_id,fk_role_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--ϵͳ��ɫ��
drop table if exists sys_role;
CREATE TABLE sys_role (
	id bigint(20) unsigned not null comment '��ˮ��',
	createtime varchar(19) not null comment '����ʱ��',
	updatetime varchar(19) not null comment '����ʱ��',
	flag bit(1) not null comment '���',
	status bit(1) not null comment '״̬',
	code varchar(9) NOT NULL comment '���',
	name varchar(30) NOT NULL comment '����',
	caption varchar(50) DEFAULT NULL comment '��ע',
	constraint pk_role_id primary key (id),
	constraint un_role_code unique (code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--ϵͳ�˵���
drop table if exists sys_menu;
CREATE TABLE sys_menu (
	id bigint(20) unsigned not null comment '��ˮ��',
	createtime varchar(19) not null comment '����ʱ��',
	updatetime varchar(19) not null comment '����ʱ��',
	flag bit(1) not null comment '���',
	status bit(1) not null comment '״̬',
	chName varchar(50) NOT NULL comment '��ʾ����',
	enName varchar(50) NOT NULL comment '�˵�����',
	href varchar(255) DEFAULT NULL comment '��ַ',
	sort int(11) NOT NULL comment '����',
	parentId bigint(20) DEFAULT NULL comment '�����˵�ID',
	constraint pk_menu_id primary key (id),
	constraint un_menu_enName unique (enName)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--ϵͳ�ֵ����
drop table if exists sys_dict;
create table sys_dict (
	id bigint(20) not null comment '��ˮ��',
	createtime varchar(19) not null comment '����ʱ��',
	updatetime varchar(19) not null comment '����ʱ��',
	flag bit(1) not null comment '���',
	status bit(1) not null comment '״̬',
	code varchar(9) not null comment '���',
	name varchar(50) not null comment '����',
	sort varchar(20) not null comment '����',
	caption varchar(50) comment '��ע',
	constraint pk_dict_id primary key (id),
	constraint un_dict_code_sort unique (code,sort)
) engine=innodb default charset=utf8;

--ϵͳ���ñ�
drop table if exists sys_cfg;
create table sys_cfg (
 	id bigint(20) not null comment '��ˮ��',
	createtime varchar(19) not null comment '����ʱ��',
	updatetime varchar(19) not null comment '����ʱ��',
	flag bit(1) not null comment '���',
	status bit(1) not null comment '״̬',
	address varchar(50) DEFAULT NULL comment '��ַ',
	badd1 varchar(50) DEFAULT NULL comment '������ַ1',
	badd2 varchar(50) DEFAULT NULL comment '������ַ2',
	bcode1 varchar(30) DEFAULT NULL comment '�����˺�1',
	bcode2 varchar(30) DEFAULT NULL comment '�����˺�2',
	bman1 varchar(30) DEFAULT NULL comment '������1',
	bman2 varchar(30) DEFAULT NULL comment '������2',
	bname1 varchar(30) DEFAULT NULL comment '��������1',
	bname2 varchar(30) DEFAULT NULL comment '��������2',
	email1 varchar(50) DEFAULT NULL comment '����1',
	email2 varchar(50) DEFAULT NULL comment '����2',
	fax1 varchar(20) DEFAULT NULL comment '����1',
	fax2 varchar(20) DEFAULT NULL comment '����2',
	linkman1 varchar(50) DEFAULT NULL comment '��ϵ��1',
	linkman2 varchar(10) DEFAULT NULL comment '��ϵ��2',
	mobile1 varchar(11) DEFAULT NULL comment '�ֻ�1',
	mobile2 varchar(11) DEFAULT NULL comment '�ֻ�2',
	name varchar(50) DEFAULT NULL comment '��˾����',
	phone1 varchar(20) DEFAULT NULL comment '�绰1',
	phone2 varchar(20) DEFAULT NULL comment '�绰2',
	postcode varchar(6) DEFAULT NULL comment '�ʱ�',
	qq1 varchar(20) DEFAULT NULL comment 'QQ1',
	qq2 varchar(20) DEFAULT NULL comment 'QQ2',
	tel1 varchar(20) DEFAULT NULL comment '��ϵ�˵绰1',
	tel2 varchar(20) DEFAULT NULL comment '��ϵ�˵绰2',
	web varchar(50) DEFAULT NULL comment '��ַ',
	constraint pk_cfg_id primary key (id),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--========================================== ϵͳ�� end   ==========================================

--========================================== �������ݱ� start ==========================================
--����
drop table if exists base_accessory;
create table base_accessory (
	id bigint(20) not null comment '��ˮ��',
	createTime varchar(19) not null comment '����ʱ��',
	updateTime varchar(19) not null comment '����ʱ��',
	flag bit(1) not null comment '���',
	status bit(1) not null comment '״̬',
	dataId bigint(20) NOT NULL comment '����ID',
	name varchar(255) NOT NULL comment '�ļ���',
	path varchar(255) NOT NULL comment '·��',
	userid bigint(20) NOT NULL comment '�ϴ���ID',
	realname varchar(20) NOT NULL comment '�ϴ���',
	sort varchar(20) NOT NULL comment '����',
	constraint pk_accessory_id primary key (id)
) engine=innodb default charset=utf8;

--����
drop table if exists base_category;
drop table base_category;
create table base_category (
	id bigint(20) not null comment '��ˮ��',
	createTime varchar(19) not null comment '����ʱ��',
	updateTime varchar(19) not null comment '����ʱ��',
	flag bit(1) not null comment '���',
	status bit(1) not null comment '״̬',
	code varchar(20) NOT NULL comment '���',
	name varchar(50) NOT NULL comment '����',
	sort varchar(20) NOT NULL comment '����',
	fk_category_id bigint(20) DEFAULT NULL comment '��������',
	constraint pk_category_id primary key (id),
	constraint un_category_code unique (code)
) engine=innodb default charset=utf8;

--����
drop table if exists base_area;
create table base_area (
	id bigint(20) not null comment '��ˮ��',
	createTime varchar(19) not null comment '����ʱ��',
	updateTime varchar(19) not null comment '����ʱ��',
	flag bit(1) not null comment '���',
	status bit(1) not null comment '״̬',
	code varchar(10) not null comment '���',
	name varchar(50) not null comment '����',
	fk_area_id bigint(20) comment '��������',
	constraint pk_area_id primary key (id),
	constraint un_area_code unique (code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--�ͻ�
drop table if exists base_customer;
create table base_customer (
	id bigint(20) not null comment '��ˮ��',
	createTime varchar(19) not null comment '����ʱ��',
	updateTime varchar(19) not null comment '����ʱ��',
	flag bit(1) not null comment '���',
	status bit(1) not null comment '״̬',
	code varchar(10) NOT NULL comment '���',
	name varchar(50) NOT NULL comment '����',
	shortName varchar(20) DEFAULT NULL comment '���',
	linkman varchar(20) DEFAULT NULL comment '��ϵ��',
	email varchar(50) DEFAULT NULL comment '����',
	fax varchar(20) DEFAULT NULL comment '����',
	mobile varchar(11) DEFAULT NULL comment '�ֻ�',
	phone varchar(20) DEFAULT NULL comment '��λ�绰',
	qq varchar(20) DEFAULT NULL comment 'QQ',
	tel varchar(20) DEFAULT NULL comment '��ϵ�˵绰',
	web varchar(50) DEFAULT NULL comment '��վ',
	postcode varchar(6) DEFAULT NULL comment '�ʱ�',
	fk_city_id bigint(20) DEFAULT NULL comment '����',
	fk_province_id bigint(20) DEFAULT NULL comment 'ʡ��',
	address varchar(50) DEFAULT NULL comment '��ַ',
	fk_sort_id bigint(20) DEFAULT NULL comment '����',
	bcode varchar(30) DEFAULT NULL comment '�����˺�',
	bman varchar(50) DEFAULT NULL comment '����������',
	bname varchar(50) DEFAULT NULL comment '��������',
	badd varchar(100) DEFAULT NULL comment '������ַ',
	constraint pk_customer_id primary key (id),
	constraint un_customer_code unique (code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--��Ӧ��
drop table if exists base_provider;
create table base_provider (
	id bigint(20) not null comment '��ˮ��',
	createTime varchar(19) not null comment '����ʱ��',
	updateTime varchar(19) not null comment '����ʱ��',
	flag bit(1) not null comment '���',
	status bit(1) not null comment '״̬',
	code varchar(10) NOT NULL comment '���',
	name varchar(50) NOT NULL comment '����',
	shortName varchar(20) DEFAULT NULL comment '���',
	linkman varchar(20) DEFAULT NULL comment '��ϵ��',
	email varchar(50) DEFAULT NULL comment '����',
	fax varchar(20) DEFAULT NULL comment '����',
	mobile varchar(11) DEFAULT NULL comment '�ֻ�',
	phone varchar(20) DEFAULT NULL comment '��λ�绰',
	qq varchar(20) DEFAULT NULL comment 'QQ',
	tel varchar(20) DEFAULT NULL comment '��ϵ�˵绰',
	web varchar(50) DEFAULT NULL comment '��վ',
	postcode varchar(6) DEFAULT NULL comment '�ʱ�',
	fk_city_id bigint(20) DEFAULT NULL comment '����',
	fk_province_id bigint(20) DEFAULT NULL comment 'ʡ��',
	address varchar(50) DEFAULT NULL comment '��ַ',
	bcode varchar(30) DEFAULT NULL comment '�����˺�',
	bman varchar(50) DEFAULT NULL comment '����������',
	bname varchar(50) DEFAULT NULL comment '��������',
	badd varchar(100) DEFAULT NULL comment '������ַ',
	constraint pk_provider_id primary key (id),
	constraint un_provider_code unique (code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--��ϵ��
drop table if exists base_linkman;
create table base_linkman (
	id bigint(20) not null comment '��ˮ��',
	createTime varchar(19) not null comment '����ʱ��',
	updateTime varchar(19) not null comment '����ʱ��',
	flag bit(1) not null comment '���',
	status bit(1) not null comment '״̬',
	name varchar(20) NOT NULL comment '����',
	duty varchar(10) DEFAULT NULL comment 'ְ��',
	email varchar(50) DEFAULT NULL comment '����',
	mobile varchar(20) DEFAULT NULL comment '�ֻ�',
	phone varchar(20) DEFAULT NULL comment '�绰',
	qq varchar(20) DEFAULT NULL comment 'QQ',
	company varchar(20) DEFAULT NULL comment '������λ����',
	fk_relation_id bigint(20) DEFAULT NULL comment '������ϵ',
	dataId bigint(20) NOT NULL comment '��¼ID',
	sort varchar(20) NOT NULL comment '����',
	constraint pk_linkman_id primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--����
drop table if exists base_department;
create table base_department (
	id bigint(20) not null comment '��ˮ��',
	createTime varchar(19) not null comment '����ʱ��',
	updateTime varchar(19) not null comment '����ʱ��',
	flag bit(1) not null comment '���',
	status bit(1) not null comment '״̬',
	code varchar(10) not null comment '���',
	name varchar(20) not null comment '����',
	fk_department_id bigint(20) comment '��������',
	managerId bigint(20) comment '���ž���ID',
	manager varchar(10) comment '���ž���',
	phone varchar(20) comment '���ŵ绰',
	fax varchar(20) comment '���Ŵ���',
	constraint pk_department_id primary key (id),
	constraint un_department_code unique (code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--Ա��
drop table if exists base_employee;
create table base_employee (
	id bigint(20) not null comment '��ˮ��',
	createTime varchar(19) not null comment '����ʱ��',
	updateTime varchar(19) not null comment '����ʱ��',
	flag bit(1) not null comment '���',
	status bit(1) not null comment '״̬',
	blood varchar(10) comment 'Ѫ��',
	born varchar(10) comment '��������',
	email varchar(50) comment '����',
	height varchar(3) comment '���',
	love varchar(50) comment '����',
	mobile varchar(11) comment '�ֻ�',
	name varchar(10) comment '����',
	phone varchar(20) comment '�绰',
	postcode varchar(6) comment '�ʱ�',
	qq varchar(20) comment 'QQ',
	sex varchar(10) comment '�Ա�',
	weight varchar(3) comment '����',
	code varchar(10) comment '���',
	idcard varchar(255) comment '֤������',
	fk_idtype_id bigint(20) comment '֤������',
	fk_department_id bigint(20) comment '��������',
	fk_duty_id bigint(20) comment '����ְ��',
	badd varchar(100) comment '���п�����ַ',
	bcode varchar(25) comment '�����˺�',
	bman varchar(20) comment '������',
	bname varchar(50) comment '��������',
	fk_nation_id bigint(20) comment '����',
	fk_polity_id bigint(20) comment '������ò',
	address varchar(50) comment '��ϸ��ַ',
	photo varchar(255) comment '��Ƭ',
	fk_city_id bigint(20) comment '��������',
	fk_province_id bigint(20) comment '����ʡ��',
	degree varchar(10) comment 'ѧ��',
	school varchar(30) comment '��ҵѧУ',
	specialty varchar(30) comment '��ѧרҵ',
	constraint pk_employee_id primary key (id),
	constraint un_employee_code unique (code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--����
drop table if exists base_material;
CREATE TABLE base_material (
	id bigint(20) NOT NULL comment '��ˮ��',
	createtime varchar(19) not null comment '����ʱ��',
	updatetime varchar(19) not null comment '����ʱ��',
	flag bit(1) not null comment '���',
	status bit(1) not null comment '״̬',
	fk_provider_id bigint(20) comment '������Ӧ��ID',
	code varchar(10) comment '���',
	name varchar(50) comment '����',
	spec varchar(20) comment '���',
	price decimal(12,2) comment '�۸�',
	fk_unit_id bigint(20) comment '������λID',
	fk_category_id bigint(20) comment '��������ID',
	caption varchar(50) comment '��ע',
	constraint pk_material_id primary key (id),
	constraint un_material_code unique (code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--����
drop table if exists base_work;
CREATE TABLE base_work (
	id bigint(20) NOT NULL comment '��ˮ��',
	createtime varchar(19) not null comment '����ʱ��',
	updatetime varchar(19) not null comment '����ʱ��',
	flag bit(1) not null comment '���',
	status bit(1) not null comment '״̬',
	code varchar(10) NOT NULL comment '���',
	name varchar(50) NOT NULL comment '����',
	price decimal(12,2) NOT NULL comment '����',
	remark varchar(50) comment '��ע',
	constraint pk_work_id primary key (id),
	constraint un_work_code unique (code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--��Ʒ
drop table if exists base_product;
create table base_product (
	id bigint(20) NOT NULL comment '��ˮ��',
	createtime varchar(19) not null comment '����ʱ��',
	updatetime varchar(19) not null comment '����ʱ��',
	flag bit(1) not null comment '���',
	status bit(1) not null comment '״̬',
	code varchar(10) NOT NULL comment '���',
	name varchar(50) NOT NULL comment '����',
	price decimal(12,2) NOT NULL comment '�۸�',
	type varchar(10) NOT NULL comment '���ͣ�INSIDE���ڲ���Ʒ��OUTSIDE���ⲿ��Ʒ',  
	fk_sort_id bigint(20) DEFAULT NULL comment '��������',
	fk_unit_id bigint(20) DEFAULT NULL comment '������λ',
	fk_customer_id bigint(20) DEFAULT NULL comment '�����ͻ�',
	cost decimal(12,2) DEFAULT NULL comment '�ɱ�',
	constraint pk_product_id primary key (id),
	constraint un_product_code unique (code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--��Ʒ����
drop table if exists xm_product_mate;
CREATE TABLE xm_product_mate (
	id bigint(20) NOT NULL comment '��ˮ��',
	createtime varchar(19) not null comment '����ʱ��',
	updatetime varchar(19) not null comment '����ʱ��',
	flag bit(1) not null comment '���',
	status bit(1) not null comment '״̬',
	proId bigint(20) NOT NULL comment '��ƷID',
	mateId bigint(20) NOT NULL comment '����ID',
	code varchar(10) NOT NULL comment '���ϱ��',
	name varchar(60) NOT NULL comment '��������',
	amount decimal(12,2) NOT NULL comment '����',
	price decimal(12,2) NOT NULL comment '�۸�',
	total decimal(12,2) NOT NULL comment '���',
	unit varchar(10) NOT NULL comment '��λ',
	constraint pk_pro_mate_id primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--��Ʒ����
drop table if exists xm_product_work;
CREATE TABLE xm_product_work (
	id bigint(20) NOT NULL comment '��ˮ��',
	createtime varchar(19) not null comment '����ʱ��',
	updatetime varchar(19) not null comment '����ʱ��',
	flag bit(1) not null comment '���',
	status bit(1) not null comment '״̬',
	fk_product_id bigint(20) NOT NULL comment '��ƷID',
	workId bigint(20) NOT NULL comment '����ID',
	code varchar(10) NOT NULL comment '������',
	name varchar(60) NOT NULL comment '��������',
	amount decimal(12,2) NOT NULL comment '����',
	price decimal(12,2) NOT NULL comment '�۸�',
	total decimal(12,2) NOT NULL comment '���',
	constraint pk_pro_work_id primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--�ֿ���Ϣ
drop table if exists base_store;
CREATE TABLE base_store (
	id bigint(20) NOT NULL comment '��ˮ��',
	createtime varchar(19) not null comment '����ʱ��',
	updatetime varchar(19) not null comment '����ʱ��',
	flag bit(1) not null comment '���',
	status bit(1) not null comment '״̬',
	name varchar(50) NOT NULL comment '����',
	constraint pk_store_id primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--�����Ϣ
drop table if exists base_storage;
CREATE TABLE base_storage (
	id bigint(20) NOT NULL comment '��ˮ��',
	createtime varchar(19) not null comment '����ʱ��',
	updatetime varchar(19) not null comment '����ʱ��',
	flag bit(1) not null comment '���',
	status bit(1) not null comment '״̬',
	name varchar(50) NOT NULL comment '����',
	size varchar(10) DEFAULT NULL comment '����',
	amount decimal(12,2) NOT NULL comment '����',
	sort varchar(10) NOT NULL comment '����',
	dataId bigint(20) NOT NULL comment '��¼ID',
	storeId bigint(20) NOT NULL comment '�ֿ�ID',
	up decimal(12,2) DEFAULT NULL comment '����',
	down decimal(12,2) DEFAULT NULL comment '����',
	state varchar(10) DEFAULT NULL comment '�̵�״̬',
	constraint pk_storage_id primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--========================================== �������ݱ� end   ==========================================

--========================================== �ɹ���ر� start ==========================================
--���ϲɹ���
drop table if exists xm_buy_order;
create table xm_buy_order (
	id bigint(20) not null comment '��ˮ��',
	createtime varchar(19) not null comment '����ʱ��',
	updatetime varchar(19) not null comment '����ʱ��',
	flag bit(1) not null comment '���',
	status bit(1) not null comment '״̬',
	clientId bigint(20) DEFAULT NULL comment '��Ӧ��ID',
	code varchar(15) NOT NULL comment '��Ӧ�̱��',
	name varchar(30) DEFAULT NULL comment '��Ӧ������',
	grade varchar(10) DEFAULT NULL comment '����',
	deliver varchar(10) DEFAULT NULL comment '��������',
	nopay decimal(12,2) DEFAULT NULL comment 'δ�����',
	payfor decimal(12,2) DEFAULT NULL comment '�Ѹ����',
	payment decimal(12,2) DEFAULT NULL comment 'Ӧ�����',
	total decimal(12,2) DEFAULT NULL comment '����',
	inState varchar(10) DEFAULT NULL comment '���״̬',
	fk_payment_id bigint(20) DEFAULT NULL comment '������������',
	fk_ticket_id bigint(20) DEFAULT NULL comment '����Ʊ������',
	linkman varchar(20) DEFAULT NULL comment '��ϵ��',
	tel varchar(20) DEFAULT NULL comment '��ϵ�˵绰',
	mobile varchar(20) DEFAULT NULL comment '�ֻ�',
	phone varchar(20) DEFAULT NULL comment '��λ�绰',
	fax varchar(20) DEFAULT NULL comment '��λ����',
	postcode varchar(6) DEFAULT NULL comment '�ʱ�',
	addDate varchar(10) DEFAULT NULL comment '�������',
	addId bigint(20) DEFAULT NULL comment '�����ID',
	addName varchar(20) DEFAULT NULL comment '�����',
	address varchar(50) DEFAULT NULL comment '��ַ',
	auditDate varchar(10) DEFAULT NULL comment '�������',
	auditId bigint(20) DEFAULT NULL comment '�����ID',
	auditName varchar(20) DEFAULT NULL comment '�����',
	auditState varchar(20) DEFAULT NULL comment '���״̬',
	followDate varchar(10) DEFAULT NULL comment '��������',
	followId bigint(20) DEFAULT NULL comment '������Id',
	followName varchar(20) DEFAULT NULL comment '������',
	followState varchar(20) DEFAULT NULL comment '����״̬',
	backState varchar(15) DEFAULT NULL comment '�˻�״̬',
	balanceState varchar(20) DEFAULT NULL comment 'Ԥ��״̬',
	cause varchar(50) DEFAULT NULL comment '�˻�ԭ��',
	state varchar(20) DEFAULT NULL comment '״̬',
	constraint pk_buy_id primary key (id),
	constraint un_buy_code unique (code)
) engine=innodb default charset=utf8;

--���ϲɹ���ϸ��
drop table if exists xm_buy_order_list;
create table xm_buy_order_list (
	id bigint(20) not null comment '��ˮ��',
	createtime varchar(19) not null comment '����ʱ��',
	updatetime varchar(19) not null comment '����ʱ��',
	flag bit(1) not null comment '���',
	status bit(1) not null comment '״̬',
	fk_order_id bigint(20) DEFAULT NULL comment '�����ɹ���ID',
	mateId bigint(20) DEFAULT NULL comment '����ID',
	name varchar(50) DEFAULT NULL comment '����',
	spec varchar(20) DEFAULT NULL comment '���',
	unit varchar(10) DEFAULT NULL comment '��λ',
	amount decimal(12,2) DEFAULT NULL comment '�ɹ���',
	price decimal(12,2) DEFAULT NULL comment '�۸�',
	remark varchar(50) DEFAULT NULL comment '��ע',
	constraint pk_buy_list_id primary key (id)
) engine=innodb default charset=utf8;

--����ѯ�۱�
drop table if exists xm_buy_price;
create table xm_buy_price (
	id bigint(20) not null comment '��ˮ��',
	createtime varchar(19) not null comment '����ʱ��',
	updatetime varchar(19) not null comment '����ʱ��',
	flag bit(1) not null comment '���',
	status bit(1) not null comment '״̬',
	addDate varchar(10) DEFAULT NULL comment '�������',
	addId bigint(20) DEFAULT NULL comment '�����ID',
	addName varchar(20) DEFAULT NULL comment '�����',
	address varchar(50) DEFAULT NULL comment '��ַ',
	auditDate varchar(10) DEFAULT NULL comment '�������',
	auditId bigint(20) DEFAULT NULL comment '�����ID',
	auditName varchar(20) DEFAULT NULL comment '�����',
	auditState varchar(20) DEFAULT NULL comment '���״̬',
	clientId bigint(20) DEFAULT NULL comment '��Ӧ��ID',
	code varchar(15) NOT NULL comment 'ѯ�۵���',
	fax varchar(20) DEFAULT NULL comment '����',
	followDate varchar(10) DEFAULT NULL comment '��������',
	followId bigint(20) DEFAULT NULL comment '������ID',
	followName varchar(20) DEFAULT NULL comment '������',
	followState varchar(20) DEFAULT NULL comment '����״̬',
	grade varchar(10) DEFAULT NULL comment '����',
	linkman varchar(20) DEFAULT NULL comment '��ϵ��',
	mobile varchar(20) DEFAULT NULL comment '�ֻ�',
	name varchar(30) DEFAULT NULL comment '��Ӧ������',
	nopay decimal(12,2) DEFAULT NULL comment 'δ�����',
	payfor decimal(12,2) DEFAULT NULL comment '�Ѹ����',
	payment decimal(12,2) DEFAULT NULL comment 'Ӧ�����',
	phone varchar(20) DEFAULT NULL comment '�绰',
	postcode varchar(6) DEFAULT NULL comment '�ʱ�',
	state varchar(20) DEFAULT NULL comment '״̬',
	tel varchar(20) DEFAULT NULL comment '��ϵ�˵绰',
	total decimal(12,2) DEFAULT NULL comment '����',
	askType varchar(10) DEFAULT NULL comment 'ѯ�۷�ʽ',
	fk_payment_id bigint(20) DEFAULT NULL comment '���ʽ',
	fk_ticket_id bigint(20) DEFAULT NULL comment 'Ʊ������',
	constraint pk_buy_id primary key (id),
	constraint un_buy_code unique (code)
) engine=innodb default charset=utf8;

--����ѯ����ϸ��
drop table if exists xm_buy_price_list;
create table xm_buy_price_list (
	id bigint(20) not null comment '��ˮ��',
	createtime varchar(19) not null comment '����ʱ��',
	updatetime varchar(19) not null comment '����ʱ��',
	flag bit(1) not null comment '���',
	status bit(1) not null comment '״̬',
	fk_order_id bigint(20) DEFAULT NULL comment '��������ѯ�۵�ID',
	mateId bigint(20) DEFAULT NULL comment '����ID',
	name varchar(50) DEFAULT NULL comment '��������',
	spec varchar(20) DEFAULT NULL comment '���',
	amount decimal(12,2) DEFAULT NULL comment '����',
	price decimal(12,2) DEFAULT NULL comment '�۸�',
	unit varchar(10) DEFAULT NULL comment '��λ',
	remark varchar(50) DEFAULT NULL comment '��ע',
	constraint pk_buy_list_id primary key (id)
) engine=innodb default charset=utf8;
--========================================== �ɹ���ر� end   ==========================================

--========================================== ������ر� start ==========================================
--��Ʒ���۱�
drop table xm_product_price;
create table xm_product_price (
	id bigint(20) not null comment '��ˮ��',
	createtime varchar(19) not null comment '����ʱ��',
	updatetime varchar(19) not null comment '����ʱ��',
	flag bit(1) not null comment '���',
	status bit(1) not null comment '״̬',
	addDate varchar(10) DEFAULT NULL comment '�������',
	addId bigint(20) DEFAULT NULL comment '�����ID',
	addName varchar(20) DEFAULT NULL comment '�����',
	address varchar(50) DEFAULT NULL comment '��ַ',
	auditDate varchar(10) DEFAULT NULL comment '�������',
	auditId bigint(20) DEFAULT NULL comment '�����ID',
	auditName varchar(20) DEFAULT NULL comment '�����',
	auditState varchar(20) DEFAULT NULL comment '���״̬',
	clientId bigint(20) DEFAULT NULL comment '�ͻ�ID',
	code varchar(15) NOT NULL comment '���۵���',
	fax varchar(20) DEFAULT NULL comment '��λ����',
	followDate varchar(10) DEFAULT NULL comment '��������',
	followId bigint(20) DEFAULT NULL comment '������ID',
	followName varchar(20) DEFAULT NULL comment '������',
	followState varchar(20) DEFAULT NULL comment '����״̬',
	grade varchar(10) DEFAULT NULL comment '����',
	linkman varchar(20) DEFAULT NULL comment '��ϵ��',
	mobile varchar(20) DEFAULT NULL comment '�ֻ�',
	name varchar(30) DEFAULT NULL comment '�ͻ�����',
	nopay decimal(12,2) DEFAULT NULL comment 'δ�ս��',
	payfor decimal(12,2) DEFAULT NULL comment '���ս��',
	payment decimal(12,2) DEFAULT NULL comment 'Ӧ�ս��',
	phone varchar(20) DEFAULT NULL comment '��λ�绰',
	postcode varchar(6) DEFAULT NULL comment '�ʱ�',
	state varchar(20) DEFAULT NULL comment '״̬',
	tel varchar(20) DEFAULT NULL comment '��ϵ�˵绰',
	total decimal(12,2) DEFAULT NULL comment '����',
	askState varchar(15) DEFAULT NULL comment '����״̬',
	askType varchar(10) DEFAULT NULL comment '���۷�ʽ',
	fk_payment_id bigint(20) DEFAULT NULL comment '���ʽ',
	fk_ticket_id bigint(20) DEFAULT NULL comment '��׫����',
	constraint pk_price_id primary key (id),
	constraint un_price_code unique (code)
) engine=innodb default charset=utf8;

--��Ʒ������ϸ��
drop table xm_product_price_list;
create table xm_product_price_list (
	id bigint(20) not null comment '��ˮ��',
	createtime varchar(19) not null comment '����ʱ��',
	updatetime varchar(19) not null comment '����ʱ��',
	flag bit(1) not null comment '���',
	status bit(1) not null comment '״̬',
	amount int(11) DEFAULT NULL comment '����',
	name varchar(100) NOT NULL comment '����',
	price decimal(12,2) DEFAULT NULL comment '�۸�',
	proId bigint(20) DEFAULT NULL comment '��ƷID',
	remark varchar(50) DEFAULT NULL comment '��ע',
	size varchar(10) NOT NULL comment '����',
	unit varchar(10) DEFAULT NULL comment '��λ',
	fk_order_id bigint(20) DEFAULT NULL comment '�������۵�ID',
	constraint pk_list_id primary key (id)
) engine=innodb default charset=utf8;

--��Ʒ������
drop table xm_sell_order;
create table xm_sell_order (
	id bigint(20) not null comment '��ˮ��',
	createtime varchar(19) not null comment '����ʱ��',
	updatetime varchar(19) not null comment '����ʱ��',
	flag bit(1) not null comment '���',
	status bit(1) not null comment '״̬',
	clientId bigint(20) DEFAULT NULL comment '�ͻ�ID',
	name varchar(50) DEFAULT NULL comment '�ͻ�����',
	code varchar(15) NOT NULL comment '�������',
	phone varchar(20) DEFAULT NULL comment '��λ�绰',
	fax varchar(20) DEFAULT NULL comment '��λ����',
	linkman varchar(10) DEFAULT NULL comment '��ϵ��',
	mobile varchar(20) DEFAULT NULL comment '��ϵ���ֻ�',
	tel varchar(20) DEFAULT NULL comment '��ϵ�˵绰',
	postcode varchar(6) DEFAULT NULL comment '��������',
	address varchar(50) DEFAULT NULL comment '��ַ',
	total decimal(12,2) DEFAULT NULL comment '����',
	nopay decimal(12,2) DEFAULT NULL comment 'δ�ս��',
	payfor decimal(12,2) DEFAULT NULL comment '���ս��',
	payment decimal(12,2) DEFAULT NULL comment 'Ӧ�ս��',
	deliver varchar(10) DEFAULT NULL comment '��������',
	sort varchar(20) DEFAULT NULL comment '��������',
	grade varchar(10) DEFAULT NULL comment '������',
	addDate varchar(10) DEFAULT NULL comment '�������',
	addId bigint(20) DEFAULT NULL comment '�����ID',
	addName varchar(20) DEFAULT NULL comment '�����',
	audit varchar(12) DEFAULT NULL comment '���״̬',
	make varchar(12) DEFAULT NULL comment '����״̬',
	constraint pk_sell_id primary key (id),
	constraint un_sell_code unique (code)
) engine=innodb default charset=utf8;

--��Ʒ������ϸ��
drop table xm_sell_order_list;
create table xm_sell_order_list (
	id bigint(20) not null comment '��ˮ��',
	createtime varchar(19) not null comment '����ʱ��',
	updatetime varchar(19) not null comment '����ʱ��',
	flag bit(1) not null comment '���',
	status bit(1) not null comment '״̬',
	fk_order_id bigint(20) DEFAULT NULL comment '������Ʒ����ID',
	proId bigint(20) DEFAULT NULL comment '��ƷID',
	code varchar(10) DEFAULT NULL comment '��Ʒ���',
	name varchar(50) DEFAULT NULL comment '��Ʒ����',
	size varchar(10) DEFAULT NULL comment '����',
	unit varchar(255) DEFAULT NULL comment '��λ',
	amount int(11) DEFAULT NULL comment '����',
	price decimal(12,2) DEFAULT NULL comment '�۸�',
	total decimal(12,2) DEFAULT NULL comment '���',
	remark varchar(255) DEFAULT NULL comment '��ע',
	constraint pk_list_id primary key (id)
	
) engine=innodb default charset=utf8;

--��Ŀ����Ԥ��
drop table xm_order_budget;
create table xm_order_budget (
	id bigint(20) not null comment '��ˮ��',
	createtime varchar(19) not null comment '����ʱ��',
	updatetime varchar(19) not null comment '����ʱ��',
	flag bit(1) not null comment '���',
	status bit(1) not null comment '״̬',
	amount decimal(12,2) NOT NULL comment '����',
	code varchar(15) NOT NULL comment '�����������ɹ������',
	dataId bigint(20) NOT NULL comment '����������ϸ���ɹ���ϸ��ID',
	name varchar(100) NOT NULL comment '����',
	price decimal(12,2) NOT NULL comment '�۸�',
	remark varchar(50) DEFAULT NULL comment '��ע',
	sort varchar(10) NOT NULL comment '����',
	unit varchar(10) NOT NULL comment '��λ',
	constraint pk_budget_id primary key (id)
) engine=innodb default charset=utf8;
--========================================== ������ر� end   ==========================================

--========================================== ��Ŀ��ر� start ==========================================
--������
DROP TABLE IF EXISTS xm_audit_mind;
create table xm_audit_mind (
	id bigint(20) not null comment '��ˮ��',
	createtime varchar(19) not null comment '����ʱ��',
	updatetime varchar(19) not null comment '����ʱ��',
	flag bit(1) not null comment '���',
	status bit(1) not null comment '״̬',
	sort varchar(20) not null comment '����',
	dataid bigint(20) not null comment '��¼id',
	mind varchar(255) not null comment '������',
	auditdate varchar(10) not null comment '�������',
	realname varchar(20) not null comment '�����',
	state varchar(15) not null comment '���״̬',
	constraint pk_mind_id primary key (id)
) engine=innodb default charset=utf8;

--��������
DROP TABLE IF EXISTS xm_work_report;
CREATE TABLE xm_work_report (
	id bigint(20) NOT NULL comment '��ˮ��',
	createtime varchar(19) not null comment '����ʱ��',
	updatetime varchar(19) not null comment '����ʱ��',
	flag bit(1) not null comment '���',
	status bit(1) not null comment '״̬',	
	empId bigint(20) comment 'Ա��ID',
	empCode varchar(9) comment 'Ա�����',
	empName varchar(10) comment 'Ա������',
	proId bigint(20) comment '��ƷID',
	proCode varchar(9) comment '��Ʒ���',
	proName varchar(50) comment '��Ʒ����',
	workId bigint(20) comment '����ID',
	workCode varchar(9) comment '������',
	workName varchar(50) comment '��������',
	amount decimal(12,2) comment '����',
	price decimal(12,2) comment '����',
	total decimal(12,2) comment '���',
	state varchar(15) comment '����״̬',
	addDate varchar(10) comment '�������',
	constraint pk_report_id primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--========================================== ��Ŀ��ر�  end   ==========================================