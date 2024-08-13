create table rrm.rrm_dict_item
(
    id          bigint auto_increment comment '主键ID'
        primary key,
    item_code   varchar(50)                         not null comment '字典项编码',
    item_name   varchar(100)                        not null comment '字典项名称',
    type_code   varchar(50)                         not null comment '字典类型代码',
    parent_id   bigint                              null comment '父级字典项ID',
    sort_order  int       default 0                 null comment '排序',
    status      tinyint   default 1                 null comment '状态(1:启用, 0:禁用)',
    description varchar(255)                        null comment '描述',
    create_time timestamp default CURRENT_TIMESTAMP null comment '创建时间',
    update_time timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间'
);

create table rrm.rrm_dict_type
(
    id          bigint auto_increment comment '主键ID'
        primary key,
    type_code   varchar(50)                         not null comment '字典类型编码',
    type_name   varchar(100)                        not null comment '字典类型名称',
    description varchar(255)                        null comment '描述',
    create_time timestamp default CURRENT_TIMESTAMP null comment '创建时间',
    update_time timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间'
);



create table rrm.rrm_menu
(
    id          varchar(36)   not null comment '主键'
        primary key,
    parent_id   varchar(36)   null comment '父菜单ID',
    name        varchar(255)  not null comment '菜单名称',
    icon        varchar(255)  null comment '菜单图标',
    sort        int           not null comment '菜单排序',
    visibility  char          not null comment '菜单可见性',
    url         varchar(1000) not null comment '菜单地址',
    type        varchar(2)    null comment '菜单类型（dic_menu_type）',
    target      varchar(10)   not null comment '跳转方式',
    page_name   varchar(50)   null comment '页面名称（页面name属性）',
    page_cache  char          null comment '页面是否缓存（1：是，0：否）',
    version     varchar(20)   not null comment '版本号',
    create_by   varchar(50)   not null comment '创建人',
    create_time timestamp(6)  not null comment '创建时间',
    update_by   varchar(50)   not null comment '更新人',
    update_time timestamp(6)  not null comment '更新时间',
    item_code   varchar(6)    not null comment '关联的项目',
    jlbz        char          not null comment '记录标志（1：有效，0：无效）'
)
    comment '接入系统菜单管理';

