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
    created_at      timestamp(6)      not null comment '创建时间',
    updated_at      timestamp(6)      null comment '更新时间',
    item_code       varchar(6)        not null comment '项目代码'
)
    comment '任职机构';

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
    created_at            timestamp(6)      not null comment '创建时间',
    updated_at            timestamp(6)      null comment '更新时间',
    item_code             varchar(6)        not null comment '项目代码 '
)
    comment '外部用户信息';

