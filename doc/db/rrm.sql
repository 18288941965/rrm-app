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
    level       int           not null comment '菜单层级',
    type        varchar(2)    null comment '菜单类型（dic_menu_type）',
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

