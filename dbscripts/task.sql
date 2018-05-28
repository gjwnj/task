-- 用户表
CREATE TABLE t_user
(
id INT PRIMARY KEY AUTO_INCREMENT, -- 用户id
uid VARCHAR(30)			   -- 微信默认id
) ENGINE=INNODB DEFAULT CHARSET=utf8;


-- 任务表
CREATE TABLE t_task
(
id INT PRIMARY KEY AUTO_INCREMENT, -- 自定任务id
taskowner VARCHAR(30),-- 自定任务拥有者
tasktype VARCHAR(20), -- 任务类型
taskdesc VARCHAR(200), -- 自定任务描述
taskname VARCHAR(200), -- 自定任务名
starttime DATETIME,	  -- 自定义开始时间
endtime DATETIME,     -- 自定义结束时间
actualfinishtime DATETIME, -- 实际用时时长 ms计时
childeva VARCHAR(200), -- 自我评价（evaluate)
parentcheck TEXT,     -- 管理人检查评语
self_assessment INT   -- 自我评分（1-5分）
) ENGINE=INNODB DEFAULT CHARSET=utf8;


-- 任务类别表
CREATE TABLE t_task_menu
(
id INT PRIMARY KEY AUTO_INCREMENT, -- 任务id
NAME VARCHAR(200), -- 任务名
creater VARCHAR(30) -- 创建人
) ENGINE=INNODB DEFAULT CHARSET=utf8;


-- 签到表
CREATE TABLE t_user_sign_in
(
id INT PRIMARY KEY AUTO_INCREMENT, -- 签到id
uid VARCHAR(30), -- 用户id
signin_time DATETIME, -- 签到时间
lastday INT, -- 连续签到天数
credits INT DEFAULT 0			   -- 用户积分
) ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO t_task_menu(NAME,creater) VALUES
("语文","system"),
("数学","system"),
("英语","system");

INSERT INTO t_task_menu(NAME,creater) VALUES
("书法","system"),
("乐器","system");

--
DELIMITER
CREATE PROCEDURE pro_sign_in(IN userid VARCHAR(30))
BEGIN
DECLARE tname VARCHAR(50); 
SET total_count= '111'; 
  -- if st is null then
   -- insert into t_user_sign_in(uid) values(userid);
  -- end if;
END
DELIMITER;


-- DROP TABLE t_task
-- DROP TABLE t_task_menu
-- DROP TABLE t_user_sign_in
-- SELECT * FROM t_task_menu
-- INSERT INTO t_user(uid) VALUES(127)
-- select * from t_user_sign_in
-- 查询上一周已完成的任务
SELECT 
  * 
FROM
  t_task 
WHERE taskowner = 'oU6C35cw4RrAy1Fa1EjA8hwgWSWs' 
  AND actualfinishtime IS NOT NULL 
  AND YEARWEEK(DATE_FORMAT(actualfinishtime,'%Y-%m-%d'))=YEARWEEK(NOW())-1
  
-- 查询未开始的任务
SELECT 
  * 
FROM
  t_task 
WHERE taskowner = 'oU6C35cw4RrAy1Fa1EjA8hwgWSWs' 
  AND actualfinishtime IS NULL 
  AND starttime>NOW()
-- and starttime>date_add(curdate(),interval 30 minute)，这句SQL不正确，但却不会影响上面语句的执行
  ORDER BY  starttime 
  
-- 查询已开始但未完成的任务
SELECT taskdesc, taskname, starttime, endtime,id
    FROM t_task
    WHERE taskowner='oU6C35cw4RrAy1Fa1EjA8hwgWSWs' 
    AND actualfinishtime IS NULL
    AND starttime<=NOW()
    ORDER BY endtime
  
-- 查询最近7天已完成的任务
SELECT 
  * 
FROM
  t_task 
WHERE taskowner = 'oU6C35cw4RrAy1Fa1EjA8hwgWSWs'
  AND taskname LIKE '%test%' 
  AND actualfinishtime IS NOT NULL 
  AND DATE(endtime)>=DATE_SUB(CURDATE(),INTERVAL 6 DAY)
  ORDER BY endtime





