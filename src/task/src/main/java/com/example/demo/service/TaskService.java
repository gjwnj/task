package com.example.demo.service;

import com.example.demo.data.ResponseResult;
import com.example.demo.mybatis.model.T_Task;

public interface TaskService
{
	public ResponseResult addTask(T_Task tt);
	public ResponseResult getTask(String uid,String pageNo,String pageSize);
	public ResponseResult getTaskByName(String timevalue,String taskname,String uid);
	public ResponseResult updateTask(T_Task tt);
	public ResponseResult judgeTask(T_Task tt);

}
