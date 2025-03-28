create database tlias;

use tlias;

create user 'tlias'@'%' identified by 'Cyq20020107.';

grant all on tlias.* to 'tlias'@'%';



-- 部门管理
create table dept(
                     id int unsigned primary key auto_increment comment '主键ID',
                     name varchar(10) not null unique comment '部门名称',
                     create_time datetime not null comment '创建时间',
                     update_time datetime not null comment '修改时间'
) comment '部门表';

insert into dept (id, name, create_time, update_time) values(1,'学工部',now(),now()),(2,'教研部',now(),now()),(3,'咨询部',now(),now()), (4,'就业部',now(),now()),(5,'人事部',now(),now());



-- 员工管理(带约束)
create table emp (
                     id int unsigned primary key auto_increment comment 'ID',
                     username varchar(20) not null unique comment '用户名',
                     password varchar(32) default '123456' comment '密码',
                     name varchar(10) not null comment '姓名',
                     gender tinyint unsigned not null comment '性别, 说明: 1 男, 2 女',
                     image varchar(300) comment '图像',
                     job tinyint unsigned comment '职位, 说明: 1 班主任,2 讲师, 3 学工主管, 4 教研主管, 5 咨询师',
                     entrydate date comment '入职时间',
                     dept_id int unsigned comment '部门ID',
                     create_time datetime not null comment '创建时间',
                     update_time datetime not null comment '修改时间'
) comment '员工表';

INSERT INTO emp
(id, username, password, name, gender, image, job, entrydate,dept_id, create_time, update_time) VALUES
                                                                                                    (1,'jinyong','123456','金庸',1,'1.jpg',4,'2000-01-01',2,now(),now()),
                                                                                                    (2,'zhangwuji','123456','张无忌',1,'2.jpg',2,'2015-01-01',2,now(),now()),
                                                                                                    (3,'yangxiao','123456','杨逍',1,'3.jpg',2,'2008-05-01',2,now(),now()),
                                                                                                    (4,'weiyixiao','123456','韦一笑',1,'4.jpg',2,'2007-01-01',2,now(),now()),
                                                                                                    (5,'changyuchun','123456','常遇春',1,'5.jpg',2,'2012-12-05',2,now(),now()),
                                                                                                    (6,'xiaozhao','123456','小昭',2,'6.jpg',3,'2013-09-05',1,now(),now()),
                                                                                                    (7,'jixiaofu','123456','纪晓芙',2,'7.jpg',1,'2005-08-01',1,now(),now()),
                                                                                                    (8,'zhouzhiruo','123456','周芷若',2,'8.jpg',1,'2014-11-09',1,now(),now()),
                                                                                                    (9,'dingminjun','123456','丁敏君',2,'9.jpg',1,'2011-03-11',1,now(),now()),
                                                                                                    (10,'zhaomin','123456','赵敏',2,'10.jpg',1,'2013-09-05',1,now(),now()),
                                                                                                    (11,'luzhangke','123456','鹿杖客',1,'11.jpg',5,'2007-02-01',3,now(),now()),
                                                                                                    (12,'hebiweng','123456','鹤笔翁',1,'12.jpg',5,'2008-08-18',3,now(),now()),
                                                                                                    (13,'fangdongbai','123456','方东白',1,'13.jpg',5,'2012-11-01',3,now(),now()),
                                                                                                    (14,'zhangsanfeng','123456','张三丰',1,'14.jpg',2,'2002-08-01',2,now(),now()),
                                                                                                    (15,'yulianzhou','123456','俞莲舟',1,'15.jpg',2,'2011-05-01',2,now(),now()),
                                                                                                    (16,'songyuanqiao','123456','宋远桥',1,'16.jpg',2,'2007-01-01',2,now(),now()),
                                                                                                    (17,'chenyouliang','123456','陈友谅',1,'17.jpg',NULL,'2015-03-21',NULL,now(),now());




select id, name, create_time, update_time
from dept;

select * from emp limit 0,10;

select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time from emp;

INSERT INTO emp (id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time)
VALUES
    (37, 'emp001', '123456', '陈晓', 1, 'default.jpg', 2, '2025-04-01', 6, NOW(), NOW()),
    (38, 'emp002', '123456', '林娜', 2, 'default.jpg', 2, '2025-04-02', 6, NOW(), NOW()),
    (39, 'emp003', '123456', '王浩', 1, 'default.jpg', 2, '2025-04-03', 6, NOW(), NOW()),
    (40, 'emp004', '123456', '赵敏', 2, 'default.jpg', 2, '2025-04-04', 6, NOW(), NOW()),
    (41, 'emp005', '123456', '张强', 1, 'default.jpg', 2, '2025-04-05', 6, NOW(), NOW()),
    (42, 'emp006', '123456', '李雪', 2, 'default.jpg', 2, '2025-04-06', 6, NOW(), NOW()),
    (43, 'emp007', '123456', '周杰', 1, 'default.jpg', 2, '2025-04-07', 6, NOW(), NOW()),
    (44, 'emp008', '123456', '吴婷', 2, 'default.jpg', 2, '2025-04-08', 6, NOW(), NOW()),
    (45, 'emp009', '123456', '郑宇', 1, 'default.jpg', 2, '2025-04-09', 6, NOW(), NOW()),
    (46, 'emp010', '123456', '孙莉', 2, 'default.jpg', 2, '2025-04-10', 6, NOW(), NOW());



# 创建事务记录表
create table dept_log(
                         id int auto_increment comment '主键ID' primary key,
                         create_time datetime null comment '操作时间',
                         description varchar(300) null comment '操作描述'
)comment '部门操作日志表';

