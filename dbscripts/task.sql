-- 用户表
CREATE TABLE t_user
(
id INT PRIMARY KEY AUTO_INCREMENT, -- 用户id
uid INT,			   -- 微信默认id
credits INT DEFAULT 0			   -- 用户积分
) ENGINE=INNODB DEFAULT CHARSET=utf8;

DROP TABLE t_user

-- 任务表
CREATE TABLE t_task
(
id INT PRIMARY KEY AUTO_INCREMENT, -- 自定任务id
taskname VARCHAR(200), -- 自定任务名
starttime DATE,	  -- 自定义开始时间
endtime DATE,     -- 自定义结束时间
actualusingtime LONG, -- 实际用时时长 ms计时
parentcheck TEXT,     -- 管理人检查评语
self_assessment INT   -- 自我评分（1-5分）
) ENGINE=INNODB DEFAULT CHARSET=utf8;

USE ZTE
-- 任务类别表
CREATE TABLE t_task_menu
(
id INT PRIMARY KEY, -- 任务id
NAME VARCHAR(200), -- 任务名
creater INT -- 创建人
) ENGINE=INNODB DEFAULT CHARSET=utf8;


-- 签到表
CREATE TABLE t_user_sign_in
(
id INT PRIMARY KEY AUTO_INCREMENT, -- 签到id
uid INT, -- 用户id
signin_time DATE, -- 签到时间
lastday INT -- 连续签到天数
) ENGINE=INNODB DEFAULT CHARSET=utf8;

SELECT * FROM t_user
INSERT INTO t_user(uid) VALUES(127)



