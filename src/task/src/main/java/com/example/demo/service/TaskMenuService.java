package com.example.demo.service;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.data.ResponseResult;
import com.example.demo.mybatis.mapper.T_TaskMapper;
import com.example.demo.mybatis.model.T_Task_Menu;

public interface TaskMenuService
{
	//包含系统定义和用户自定义的
	public ResponseResult GetUserAllTaskType(String uid);
	public ResponseResult AddTaskType(@RequestBody T_Task_Menu typevalue);

}
