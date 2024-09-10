create table rrm.rrm_dict_entry
(
    id          bigint auto_increment comment '主键ID'
        primary key,
    entry_code  varchar(50)                         not null comment '字典项编码',
    entry_name  varchar(100)                        not null comment '字典项名称',
    type_id     bigint                              not null comment '字典类型ID',
    parent_id   bigint                              null comment '父级字典项ID',
    sort_order  int       default 0                 not null comment '排序',
    status      tinyint   default 1                 not null comment '状态(1:启用, 0:禁用)',
    description varchar(255)                        null comment '描述',
    created_by  int                                 not null comment '创建人',
    created_at  timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    updated_by  int                                 null comment '更新人',
    updated_at  timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间'
);

create table rrm.rrm_dict_type
(
    id          bigint auto_increment comment '主键ID'
        primary key,
    type_code   varchar(50)                         not null comment '字典类型编码',
    type_name   varchar(100)                        not null comment '字典类型名称',
    description varchar(255)                        null comment '描述',
    created_by  int                                 not null comment '创建人',
    created_at  timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    updated_by  int                                 null comment '更新人',
    updated_at  timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
    item_code   varchar(6)                          not null comment '项目代码'
);

create table rrm.rrm_item
(
    id         int auto_increment comment '主键'
        primary key,
    item_name  varchar(255) not null comment '项目名称',
    item_code  varchar(6)   not null comment '项目编号',
    created_by int          not null comment '创建人',
    created_at timestamp(6) not null comment '创建时间',
    updated_by int          null comment '更新人',
    updated_at timestamp(6) null comment '更新时间'
)
    comment '权限系统-项目管理';

create table rrm.rrm_menu
(
    id         varchar(36)       not null comment '主键'
        primary key,
    parent_id  varchar(36)       null comment '父菜单ID',
    name       varchar(255)      not null comment '菜单名称',
    icon       varchar(255)      null comment '菜单图标',
    sort_order int               not null comment '菜单排序',
    visibility tinyint           not null comment '菜单可见性',
    path       varchar(1000)     not null comment '菜单路径',
    type       varchar(2)        null comment '菜单类型（dic_menu_type）',
    target     varchar(10)       not null comment '跳转方式',
    page_name  varchar(50)       null comment '页面名称（页面name属性）',
    page_cache tinyint           null comment '页面是否缓存（1：是，0：否）',
    version    varchar(20)       not null comment '版本号',
    created_by int               not null comment '创建人ID',
    created_at timestamp(6)      not null comment '创建时间',
    updated_by int               null comment '更新人',
    updated_at timestamp(6)      null comment '更新时间',
    status     tinyint default 1 not null comment '状态（1：有效，0：无效）',
    item_code  varchar(6)        not null comment '项目代码'
)
    comment '接入系统菜单管理';

create table rrm.rrm_menu_element
(
    id         varchar(36)       not null comment '主键'
        primary key,
    menu_id    varchar(36)       not null comment '菜单ID',
    name       varchar(255)      not null comment '控件名称',
    type       varchar(2)        not null comment '类型',
    created_by int               not null comment '创建人',
    created_at timestamp(6)      not null comment '创建时间',
    updated_by int               null comment '更新人',
    updated_at timestamp(6)      null comment '更新时间',
    status     tinyint default 1 not null comment '状态（1：可用，0：不可用）'
)
    comment '菜单组件';

create table rrm.rrm_org
(
    id              varchar(36)       not null comment '主键'
        primary key,
    code            varchar(20)       not null comment '机构代码',
    parent_code     varchar(20)       null comment '上级机构代码',
    name            varchar(500)      not null comment '机构名称',
    abbr_name       varchar(500)      null comment '机构名称简称',
    type            varchar(2)        null comment '机构类型（dic_org_type）',
    is_deleted      tinyint default 0 not null comment '是否删除（注销）（1：是，0：否）',
    deleted_at      timestamp(6)      null comment '删除（注销）时间',
    extended_field  varchar(255)      null comment '扩展字段',
    extended_field2 varchar(255)      null comment '扩展字段2',
    created_by      int               not null comment '创建者',
    created_at      timestamp(6)      not null comment '创建时间',
    updated_by      int               null comment '更新人',
    updated_at      timestamp(6)      null comment '更新时间',
    item_code       varchar(6)        not null comment '项目代码'
)
    comment '任职机构';

create table rrm.rrm_resource
(
    id             varchar(36)       not null comment '主键'
        primary key,
    service_name   varchar(255)      not null comment '服务名称',
    package_name   varchar(255)      not null comment '包名',
    class_name     varchar(255)      not null comment '类名',
    method_name    varchar(100)      not null comment '方法名',
    request_path   varchar(500)      not null comment '请求路径',
    request_method varchar(20)       not null comment '请求方式',
    resource_name  varchar(255)      not null comment '资源名称',
    resource_type  varchar(2)        null comment '资源类型(字典)',
    auth_code      int               not null comment '授权码',
    environment    varchar(2)        null comment '资源环境（dev,production）',
    created_by     int               not null comment '创建人',
    created_at     timestamp(6)      not null comment '创建时间',
    updated_by     int               null comment '更新人',
    updated_at     timestamp(6)      null comment '更新时间',
    status         tinyint default 1 not null comment '状态(1：启用，0：停用)',
    item_code      varchar(6)        not null comment '项目代码'
)
    comment '资源管理';

create table rrm.rrm_role
(
    id          varchar(36)       not null comment '主键',
    name        varchar(255)      not null comment '名称',
    level       int     default 0 not null comment '等级（权限从小到大）',
    sort_order  int               not null comment '顺序号',
    description varchar(255)      null comment '角色描述',
    created_by  int               not null comment '创建人',
    created_at  timestamp(6)      not null comment '创建时间',
    updated_by  int               null comment '更新人',
    updated_at  timestamp(6)      null comment '更新时间',
    status      tinyint default 1 not null comment '状态（1：启用，0：停用）',
    item_code   varchar(6)        not null comment '项目代码'
)
    comment '角色管理';

create table rrm.rrm_user
(
    id          int auto_increment comment '主键'
        primary key,
    username    varchar(50)  not null comment '账号',
    password    varchar(50)  not null comment '密码',
    description varchar(255) null comment '用户描述',
    created_by  int          null comment '创建人',
    created_at  timestamp(6) null comment '创建时间',
    updated_by  int          null comment '更新人',
    updated_at  timestamp(6) null comment '更新时间',
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

create table rrm.rrm_users
(
    id                    varchar(36)       not null comment '主键'
        primary key,
    username              varchar(20)       not null comment '用户名',
    password              varchar(36)       not null comment '密码',
    name                  varchar(100)      not null comment '姓名',
    gender                varchar(2)        null comment ' 性别 （dic_user_gender）',
    nation                varchar(2)        null comment '民族 （dic_user_nation）',
    id_number             varchar(18)       not null comment '身份证号',
    date_of_birth         date              null comment '出生日期',
    phone_number          varchar(20)       not null comment '联系电话',
    avatar                text              null comment '头像（base64）',
    org_code              varchar(20)       not null comment '任职机构代码',
    org_name              varchar(500)      not null comment '任职机构名称',
    type                  varchar(2)        null comment '用户类型（dic_user_type）',
    description           varchar(500)      null comment ' 用户描述',
    account_status        tinyint           not null comment '账户状态（1：活跃，-1：锁定、0：禁用）',
    registration_date     timestamp(6)      null comment ' 注册时间',
    last_login_time       timestamp(6)      null comment '最近登录时间',
    failed_login_attempts tinyint           null comment '登录失败次数',
    login_count           int               null comment '登录次数',
    approval_status       tinyint           null comment '审核状态（-1：审核中，1：审核通过，0：审核不通过）',
    approval_at           timestamp(6)      null comment ' 审核时间',
    is_deleted            tinyint default 0 not null comment '是否删除（注销）(1：是，0：否)',
    deleted_at            timestamp(6)      null comment '删除（注销时间）',
    extended_field        varchar(255)      null comment '扩展字段',
    extended_field2       varchar(255)      null comment '扩展字段2',
    created_by            int               not null comment '创建者',
    created_at            timestamp(6)      not null comment '创建时间',
    updated_by            int               null comment '更新者',
    updated_at            timestamp(6)      null comment '更新时间',
    item_code             varchar(6)        not null comment '项目代码 '
)
    comment '外部用户信息';

