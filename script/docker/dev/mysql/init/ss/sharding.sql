create database db_ss_0;
create database db_ss_1;
create database db_ss_2;

use db_ss_0;
create table intelligent_sms_0
(
    id          bigint primary key auto_increment not null comment 'id',
    phone       varchar(15)                       not null comment '手机号',
    status      int comment '状态',
    create_dept bigint(20) comment '创建部门',
    create_by   bigint(20) comment '创建者',
    create_time datetime comment '创建时间',
    update_by   bigint(20) comment '更新者',
    update_time datetime comment '更新时间',
    del_flag    char(1) default '0' comment '删除标志（0代表存在 1代表删除）'
) comment '智能短信表';
create table intelligent_sms_1
(
    id          bigint primary key auto_increment not null comment 'id',
    phone       varchar(15)                       not null comment '手机号',
    status      int comment '状态',
    create_dept bigint(20) comment '创建部门',
    create_by   bigint(20) comment '创建者',
    create_time datetime comment '创建时间',
    update_by   bigint(20) comment '更新者',
    update_time datetime comment '更新时间',
    del_flag    char(1) default '0' comment '删除标志（0代表存在 1代表删除）'
) comment '智能短信表';
create table intelligent_sms_2
(
    id          bigint primary key auto_increment not null comment 'id',
    phone       varchar(15)                       not null comment '手机号',
    status      int comment '状态',
    create_dept bigint(20) comment '创建部门',
    create_by   bigint(20) comment '创建者',
    create_time datetime comment '创建时间',
    update_by   bigint(20) comment '更新者',
    update_time datetime comment '更新时间',
    del_flag    char(1) default '0' comment '删除标志（0代表存在 1代表删除）'
) comment '智能短信表';
create table intelligent_sms_3
(
    id          bigint primary key auto_increment not null comment 'id',
    phone       varchar(15)                       not null comment '手机号',
    status      int comment '状态',
    create_dept bigint(20) comment '创建部门',
    create_by   bigint(20) comment '创建者',
    create_time datetime comment '创建时间',
    update_by   bigint(20) comment '更新者',
    update_time datetime comment '更新时间',
    del_flag    char(1) default '0' comment '删除标志（0代表存在 1代表删除）'
) comment '智能短信表';

use db_ss_1;
create table intelligent_sms_0
(
    id          bigint primary key auto_increment not null comment 'id',
    phone       varchar(15)                       not null comment '手机号',
    status      int comment '状态',
    create_dept bigint(20) comment '创建部门',
    create_by   bigint(20) comment '创建者',
    create_time datetime comment '创建时间',
    update_by   bigint(20) comment '更新者',
    update_time datetime comment '更新时间',
    del_flag    char(1) default '0' comment '删除标志（0代表存在 1代表删除）'
) comment '智能短信表';
create table intelligent_sms_1
(
    id          bigint primary key auto_increment not null comment 'id',
    phone       varchar(15)                       not null comment '手机号',
    status      int comment '状态',
    create_dept bigint(20) comment '创建部门',
    create_by   bigint(20) comment '创建者',
    create_time datetime comment '创建时间',
    update_by   bigint(20) comment '更新者',
    update_time datetime comment '更新时间',
    del_flag    char(1) default '0' comment '删除标志（0代表存在 1代表删除）'
) comment '智能短信表';
create table intelligent_sms_2
(
    id          bigint primary key auto_increment not null comment 'id',
    phone       varchar(15)                       not null comment '手机号',
    status      int comment '状态',
    create_dept bigint(20) comment '创建部门',
    create_by   bigint(20) comment '创建者',
    create_time datetime comment '创建时间',
    update_by   bigint(20) comment '更新者',
    update_time datetime comment '更新时间',
    del_flag    char(1) default '0' comment '删除标志（0代表存在 1代表删除）'
) comment '智能短信表';
create table intelligent_sms_3
(
    id          bigint primary key auto_increment not null comment 'id',
    phone       varchar(15)                       not null comment '手机号',
    status      int comment '状态',
    create_dept bigint(20) comment '创建部门',
    create_by   bigint(20) comment '创建者',
    create_time datetime comment '创建时间',
    update_by   bigint(20) comment '更新者',
    update_time datetime comment '更新时间',
    del_flag    char(1) default '0' comment '删除标志（0代表存在 1代表删除）'
) comment '智能短信表';

use db_ss_2;
create table intelligent_sms_0
(
    id          bigint primary key auto_increment not null comment 'id',
    phone       varchar(15)                       not null comment '手机号',
    status      int comment '状态',
    create_dept bigint(20) comment '创建部门',
    create_by   bigint(20) comment '创建者',
    create_time datetime comment '创建时间',
    update_by   bigint(20) comment '更新者',
    update_time datetime comment '更新时间',
    del_flag    char(1) default '0' comment '删除标志（0代表存在 1代表删除）'
) comment '智能短信表';
create table intelligent_sms_1
(
    id          bigint primary key auto_increment not null comment 'id',
    phone       varchar(15)                       not null comment '手机号',
    status      int comment '状态',
    create_dept bigint(20) comment '创建部门',
    create_by   bigint(20) comment '创建者',
    create_time datetime comment '创建时间',
    update_by   bigint(20) comment '更新者',
    update_time datetime comment '更新时间',
    del_flag    char(1) default '0' comment '删除标志（0代表存在 1代表删除）'
) comment '智能短信表';
create table intelligent_sms_2
(
    id          bigint primary key auto_increment not null comment 'id',
    phone       varchar(15)                       not null comment '手机号',
    status      int comment '状态',
    create_dept bigint(20) comment '创建部门',
    create_by   bigint(20) comment '创建者',
    create_time datetime comment '创建时间',
    update_by   bigint(20) comment '更新者',
    update_time datetime comment '更新时间',
    del_flag    char(1) default '0' comment '删除标志（0代表存在 1代表删除）'
) comment '智能短信表';
create table intelligent_sms_3
(
    id          bigint primary key auto_increment not null comment 'id',
    phone       varchar(15)                       not null comment '手机号',
    status      int comment '状态',
    create_dept bigint(20) comment '创建部门',
    create_by   bigint(20) comment '创建者',
    create_time datetime comment '创建时间',
    update_by   bigint(20) comment '更新者',
    update_time datetime comment '更新时间',
    del_flag    char(1) default '0' comment '删除标志（0代表存在 1代表删除）'
) comment '智能短信表';
