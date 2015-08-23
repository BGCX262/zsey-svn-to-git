���ŵ�����
1.���Ȱ�base_category���sort���ֶ�ֵΪDEPARTMENT�ļ�¼���뵽base_department���У�SQL������£�
insert into base_department (id, createTime, updateTime, flag, status, code, name, 
fk_department_id) select id, createTime, updateTime, flag, status, code, name, 
fk_category_id from base_category where sort='DEPARTMENT';

2.������ˮ�ű�
insert into sys_app_sequence (createtime, updatetime, flag, status, enseqname, cnseqname, seqvalue)
values (now(), now(), true, true, 'DEPARTMENT_CODE', '���ű��', '2');
insert into sys_app_sequence (createtime, updatetime, flag, status, enseqname, cnseqname, seqvalue)
values (now(), now(), true, true, 'DEPARTMENT_CODE_01', '���ű��', '1');

3.����Ա����base_employee��fk_department_id�ֶ�
ALTER TABLE `ducrm`.`base_employee`
 DROP FOREIGN KEY `FKC8B62C5C352E1508`;

ALTER TABLE `ducrm`.`base_employee` ADD CONSTRAINT `FKC8B62C5C352E1508` FOREIGN KEY `FKC8B62C5C352E1508` (`fk_department_id`)
    REFERENCES `base_department` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT;
    
4.ɾ��base_category���sort���ֶ�ֵΪDEPARTMENT�ļ�¼��
delete from
    base_category
where
    sort = 'DEPARTMENT' and fk_category_id is not null;

delete from
    base_category
where
    sort = 'DEPARTMENT' and fk_category_id is null;
    
����
insert into base_area (id, createTime, updateTime, flag, status, code, name, 
fk_area_id) select id, createTime, updateTime, flag, status, code, name, 
fk_category_id from base_category where sort='AREA';

��base_employee���province��area���޸�Ϊarea���idֵ

insert into sys_dict (id, createTime, updateTime, flag, status, code, name, 
sort) select id, createTime, updateTime, flag, status, code, name, 
sort from base_category where sort in ('DUTY','CERTIFICATE','POLITY','NATION');

insert into sys_app_sequence (createtime, updatetime, flag, status, enseqname, cnseqname, seqvalue)
values (now(), now(), true, true, 'SYSDICT_NATION', '�ֵ�����', '56');

insert into sys_app_sequence (createtime, updatetime, flag, status, enseqname, cnseqname, seqvalue)
values (now(), now(), true, true, 'SYSDICT_POLITY', '�ֵ�����', '3');

insert into sys_app_sequence (createtime, updatetime, flag, status, enseqname, cnseqname, seqvalue)
values (now(), now(), true, true, 'SYSDICT_CERTIFICATE', '�ֵ�����', '8');

insert into sys_app_sequence (createtime, updatetime, flag, status, enseqname, cnseqname, seqvalue)
values (now(), now(), true, true, 'SYSDICT_DUTY', '�ֵ�����', '2');

delete from base_category where sort in ('DUTY','CERTIFICATE','POLITY','NATION');

--�ͻ���
insert into sys_dict (id, createTime, updateTime, flag, status, code, name, 
sort) select id, createTime, updateTime, flag, status, code, name, 
sort from base_category where sort ='CUSTOMER';

delete from base_category where sort in ('CUSTOMER');

insert into sys_app_sequence (createtime, updatetime, flag, status, enseqname, cnseqname, seqvalue)
values (now(), now(), true, true, 'CUSTOMER', '�ֵ�����', '7');

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