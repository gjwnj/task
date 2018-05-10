package com.example.demo.service;

import javax.annotation.Resource;

import com.example.demo.data.ResponseResult;
import com.example.demo.mybatis.mapper.T_TaskMapper;

public interface TaskMenuService
{
	//包含系统定义和用户自定义的
	public ResponseResult GetUserAllTaskType(String uid);

}
