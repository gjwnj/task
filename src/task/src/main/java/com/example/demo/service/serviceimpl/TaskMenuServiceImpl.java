package com.example.demo.service.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.data.ResponseResult;
import com.example.demo.data.ResultCode;
import com.example.demo.data.vo.UserAllTaskType;
import com.example.demo.mybatis.mapper.T_TaskMapper;
import com.example.demo.mybatis.mapper.T_Task_MenuMapper;
import com.example.demo.mybatis.model.T_Task_Menu;
import com.example.demo.service.TaskMenuService;
@Service("taskmenuservice")
public class TaskMenuServiceImpl implements TaskMenuService
{
	@Resource
	private T_Task_MenuMapper tt;
	
	public ResponseResult GetUserAllTaskType(String uid)
	{
		List<UserAllTaskType> re=tt.selectUserAllTaskType(uid);
		
		return new ResponseResult(ResultCode.SUCCESS,re);
	}

	@Override
	public ResponseResult AddTaskType(T_Task_Menu typevalue)
	{
		// TODO Auto-generated method stub
		int re=tt.insertSelective(typevalue);
		if(re>0)
		{
			return new ResponseResult();
		}
		else
		{
			return new ResponseResult(ResultCode.INTERNAL_ERROR);
		}
	}

}
