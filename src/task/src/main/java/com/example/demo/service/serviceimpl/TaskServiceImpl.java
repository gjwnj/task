package com.example.demo.service.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.data.ResponseResult;
import com.example.demo.data.ResultCode;
import com.example.demo.data.vo.UserAllTaskVo;
import com.example.demo.mybatis.mapper.T_TaskMapper;
import com.example.demo.mybatis.model.T_Task;
import com.example.demo.service.TaskService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service("taskservice")
public class TaskServiceImpl implements TaskService
{
	@Resource
	private T_TaskMapper ttm;

	@Override
	public ResponseResult addTask(T_Task tt)
	{
		// TODO Auto-generated method stub
		int rr=ttm.insertOne(tt);
		if(rr>0)
		{
			//幸福的人生的总是相似的
			return new ResponseResult();
		}
		else
		{
			//不幸的人生各有不同
			return new ResponseResult(ResultCode.INTERNAL_ERROR);
		}
	}

	@Override
	public ResponseResult getTask(String uid,String pageNo,String pageSize,int isstarted)
	{
		Page p=PageHelper.startPage(Integer.parseInt(pageNo),
				Integer.parseInt(pageSize));
		UserAllTaskVo result=ttm.selectByPrimaryKey(uid,isstarted);
		int pageSum=p.getPages();
		if(result!=null)
		{
			result.setPageSum(pageSum);
		}
		return new ResponseResult(ResultCode.SUCCESS,result);
	}

	@Override
	public ResponseResult updateTask(T_Task tt)
	{
		// TODO Auto-generated method stub
		int rr=ttm.updateByPrimaryKeySelective(tt);
		if(rr==1)
		{
			return new ResponseResult();
		}
		else
		{
			return new ResponseResult(ResultCode.INTERNAL_ERROR);
		}
	}

	@Override
	public ResponseResult getTaskByTime(String timevalue,String taskname,String tasktype,String uid)
	{
		// TODO Auto-generated method stub
		List<UserAllTaskVo> result=ttm.selectByNameOrTypeAndTime(uid, taskname, tasktype);
		
		return new ResponseResult(ResultCode.SUCCESS,result);
	}

	@Override
	public ResponseResult judgeTask(T_Task tt)
	{
		// TODO Auto-generated method stub
		int rr=ttm.updateByPrimaryKeySelective(tt);
		if(rr==1)
		{
			return new ResponseResult();
		}
		else
		{
			return new ResponseResult(ResultCode.INTERNAL_ERROR);
		}
	}

	@Override
	public ResponseResult getDoneTask(String uid, String pageNo, String pageSize)
	{
		Page p=PageHelper.startPage(Integer.parseInt(pageNo),
				Integer.parseInt(pageSize));
		UserAllTaskVo result=ttm.selectByDone(uid);
		int pageSum=p.getPages();
		if(result!=null)
		{
			result.setPageSum(pageSum);
		}
		return new ResponseResult(ResultCode.SUCCESS,result);
	}

}
