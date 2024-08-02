create table rrm.rrm_item
(
    id          int auto_increment comment '主键'
        primary key,
    item_name   varchar(255) not null comment '项目名称',
    item_code   varchar(6)   not null comment '项目编号',
    create_time timestamp(6) not null comment '创建时间',
    user_id     int          not null comment '创建人'
)
    comment '权限系统-项目管理';

create table rrm.rrm_user
(
    id         int auto_increment comment '主键'
        primary key,
    username   varchar(50)  not null comment '账号',
    password   varchar(50)  not null comment '密码',
    role       tinyint      not null comment '角色',
    permission varchar(255) null comment '权限',
    comment    varchar(255) null comment '备注',
    constraint i_username
        unique (username)
);

create table rrm.rrm_user_item
(
    id      int auto_increment comment '主键'
        primary key,
    user_id int not null comment '用户ID',
    item_id int null comment '项目ID'
)
    comment '用户项目关联表';

