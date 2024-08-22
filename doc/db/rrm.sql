create table rrm.rrm_dict_entry
(
    id          bigint auto_increment comment '主键ID'
        primary key,
    entry_code  varchar(50)                         not null comment '字典项编码',
    entry_name  varchar(100)                        not null comment '字典项名称',
    type_id     bigint                              not null comment '字典类型ID',
    parent_id   bigint                              null comment '父级字典项ID',
    sort_order  int       default 0                 null comment '排序',
    status      tinyint   default 1                 null comment '状态(1:启用, 0:禁用)',
    description varchar(255)                        null comment '描述',
    created_at  timestamp default CURRENT_TIMESTAMP null comment '创建时间',
    updated_at  timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间'
);

create table rrm.rrm_dict_type
(
    id          bigint auto_increment comment '主键ID'
        primary key,
    type_code   varchar(50)                         not null comment '字典类型编码',
    type_name   varchar(100)                        not null comment '字典类型名称',
    description varchar(255)                        null comment '描述',
    created_at  timestamp default CURRENT_TIMESTAMP null comment '创建时间',
    updated_at  timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
    item_code   varchar(6)                          not null comment '项目代码'
);

create table rrm.rrm_item
(
    id         int auto_increment comment '主键'
        primary key,
    item_name  varchar(255) not null comment '项目名称',
    item_code  varchar(6)   not null comment '项目编号',
    created_at timestamp(6) not null comment '创建时间',
    user_id    int          not null comment '创建人'
)
    comment '权限系统-项目管理';

create table rrm.rrm_menu
(
    id         varchar(36)   not null comment '主键'
        primary key,
    parent_id  varchar(36)   null comment '父菜单ID',
    name       varchar(255)  not null comment '菜单名称',
    icon       varchar(255)  null comment '菜单图标',
    sort_order int           not null comment '菜单排序',
    visibility char          not null comment '菜单可见性',
    path       varchar(1000) not null comment '菜单路径',
    type       varchar(2)    null comment '菜单类型（dic_menu_type）',
    target     varchar(10)   not null comment '跳转方式',
    page_name  varchar(50)   null comment '页面名称（页面name属性）',
    page_cache char          null comment '页面是否缓存（1：是，0：否）',
    version    varchar(20)   not null comment '版本号',
    created_by varchar(50)   not null comment '创建人',
    created_at timestamp(6)  not null comment '创建时间',
    updated_by varchar(50)   not null comment '更新人',
    updated_at timestamp(6)  not null comment '更新时间',
    status     tinyint       not null comment '状态（1：有效，0：无效）',
    item_code  varchar(6)    not null comment '项目代码'
)
    comment '接入系统菜单管理';

create table rrm.rrm_user
(
    id       int auto_increment comment '主键'
        primary key,
    username varchar(50)  not null comment '账号',
    password varchar(50)  not null comment '密码',
    comment  varchar(255) null comment '备注',
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

