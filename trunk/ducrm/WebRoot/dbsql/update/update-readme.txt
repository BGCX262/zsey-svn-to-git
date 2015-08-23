部门的升级
1.首先把base_category表的sort的字段值为DEPARTMENT的记录插入到base_department表中，SQL语句如下：
insert into base_department (id, createTime, updateTime, flag, status, code, name, 
fk_department_id) select id, createTime, updateTime, flag, status, code, name, 
fk_category_id from base_category where sort='DEPARTMENT';

2.更新流水号表
insert into sys_app_sequence (createtime, updatetime, flag, status, enseqname, cnseqname, seqvalue)
values (now(), now(), true, true, 'DEPARTMENT_CODE', '部门编号', '2');
insert into sys_app_sequence (createtime, updatetime, flag, status, enseqname, cnseqname, seqvalue)
values (now(), now(), true, true, 'DEPARTMENT_CODE_01', '部门编号', '1');

3.更新员工表base_employee的fk_department_id字段
ALTER TABLE `ducrm`.`base_employee`
 DROP FOREIGN KEY `FKC8B62C5C352E1508`;

ALTER TABLE `ducrm`.`base_employee` ADD CONSTRAINT `FKC8B62C5C352E1508` FOREIGN KEY `FKC8B62C5C352E1508` (`fk_department_id`)
    REFERENCES `base_department` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT;
    
4.删除base_category表的sort的字段值为DEPARTMENT的记录。
delete from
    base_category
where
    sort = 'DEPARTMENT' and fk_category_id is not null;

delete from
    base_category
where
    sort = 'DEPARTMENT' and fk_category_id is null;
    
地区
insert into base_area (id, createTime, updateTime, flag, status, code, name, 
fk_area_id) select id, createTime, updateTime, flag, status, code, name, 
fk_category_id from base_category where sort='AREA';

把base_employee表的province和area的修改为area表的id值

insert into sys_dict (id, createTime, updateTime, flag, status, code, name, 
sort) select id, createTime, updateTime, flag, status, code, name, 
sort from base_category where sort in ('DUTY','CERTIFICATE','POLITY','NATION');

insert into sys_app_sequence (createtime, updatetime, flag, status, enseqname, cnseqname, seqvalue)
values (now(), now(), true, true, 'SYSDICT_NATION', '字典项编号', '56');

insert into sys_app_sequence (createtime, updatetime, flag, status, enseqname, cnseqname, seqvalue)
values (now(), now(), true, true, 'SYSDICT_POLITY', '字典项编号', '3');

insert into sys_app_sequence (createtime, updatetime, flag, status, enseqname, cnseqname, seqvalue)
values (now(), now(), true, true, 'SYSDICT_CERTIFICATE', '字典项编号', '8');

insert into sys_app_sequence (createtime, updatetime, flag, status, enseqname, cnseqname, seqvalue)
values (now(), now(), true, true, 'SYSDICT_DUTY', '字典项编号', '2');

delete from base_category where sort in ('DUTY','CERTIFICATE','POLITY','NATION');

--客户表
insert into sys_dict (id, createTime, updateTime, flag, status, code, name, 
sort) select id, createTime, updateTime, flag, status, code, name, 
sort from base_category where sort ='CUSTOMER';

delete from base_category where sort in ('CUSTOMER');

insert into sys_app_sequence (createtime, updatetime, flag, status, enseqname, cnseqname, seqvalue)
values (now(), now(), true, true, 'CUSTOMER', '字典项编号', '7');

delete from base_category where sort in ('AREA') and fk_category_id is not null;

delete from base_category where sort in ('AREA');

insert into sys_dict (id, createTime, updateTime, flag, status, code, name, 
sort) select id, createTime, updateTime, flag, status, code, name, 
sort from base_category where sort in ('UNIT');

delete from base_category where sort ='DUTY';

insert into sys_dict (id, createTime, updateTime, flag, status, code, name, 
sort) select id, createTime, updateTime, flag, status, code, name, 
sort from base_category where sort in ('SELL');

delete from base_category where sort ='SELL';