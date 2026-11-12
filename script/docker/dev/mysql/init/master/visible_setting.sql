create table sys_user_column_visible
(
    id          bigint primary key NOT NULL COMMENT '主键',

    user_id bigint not null comment '用户id',
    table_key         VARCHAR(128) NOT NULL COMMENT '表格唯一标识',
    column_visibility JSON         NOT NULL COMMENT '列显隐配置，键为列标识，值为布尔值',

    create_dept bigint(20) comment '创建部门',
    create_by   bigint(20) comment '创建者',
    create_time datetime comment '创建时间',
    update_by   bigint(20) comment '更新者',
    update_time datetime comment '更新时间',
    del_flag    char(1) default '0' comment '删除标志（0代表存在 1代表删除）',
    UNIQUE KEY uk_user_table (user_id, table_key)
) ENGINE = InnoDB COMMENT = '表格列显隐偏好';
