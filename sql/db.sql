CREATE DATABASE IF NOT EXISTS hrm
DEFAULT CHAR SET utf8
DEFAULT COLLATE utf8_chinese_ci;

USE hrm;

CREATE TABLE IF NOT EXISTS `user`(
    id int primary key auto_increment comment '用户id',
    `username` varchar(30) unique comment '用户名',
    password varchar(30) comment '密码'
)engine = innodb default charset = utf8mb4;

CREATE TABLE IF NOT EXISTS employee(
    id int primary key auto_increment comment '员工id',
    department_id int comment '所属部门',
    `name` varchar(30) comment '员工姓名',
    sex char(2) comment '员工性别',
    phone_number varchar(11) comment '员工电话',
    email varchar(30) comment '员工邮箱'
)engine = innodb default charset = utf8mb4;

CREATE TABLE IF NOT EXISTS department(
    id int primary key auto_increment comment '部门id',
    `name` varchar(30) comment '部门名称',
    address varchar(50) comment '部门所在地'
)engine = innodb default charset = utf8mb4;

CREATE TABLE IF NOT EXISTS employee_img(
    id int primary key comment '所属员工的员工id',
    img_url varchar(256) comment '员工图片地址'
)engine = innodb default charset = utf8mb4;
