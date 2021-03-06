package com.example.demo.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.ResponseResult;
import com.example.demo.mybatis.model.T_Task;
import com.example.demo.service.TaskService;
import com.example.demo.utils.LogFactory;

@RestController
@RequestMapping("/api1/task")
public class TaskController
{
	Logger logger=LogFactory.getBusinessLogger();
	//处理新增任务
	@Resource(name="taskservice")
	private TaskService ts;
	@RequestMapping(value="/",method=RequestMethod.POST)
	public ResponseResult addTask(@RequestBody T_Task tt)
	{
		//System.out.println("start:"+tt.getStarttime());
		ResponseResult rr=ts.addTask(tt);
		return rr;
	}
	//处理按时间查询已完成任务
	@RequestMapping(value={"/time/{timevalue}/taskname/{taskname}/uid/{uid}","/time/{timevalue}/tasktype/{tasktype}/uid/{uid}","/time/{timevalue}/taskname/{taskname}/tasktype/{tasktype}/uid/{uid}"},method=RequestMethod.GET)
	public ResponseResult getTaskByName(@PathVariable String timevalue,@PathVariable(required=false) String taskname,@PathVariable(required=false) String tasktype,@PathVariable String uid)
	{
		ResponseResult rr=ts.getTaskByTime(timevalue, taskname, tasktype,uid);
		return rr;
	}
	@RequestMapping(value="/all/{uid}/{pageNo}/{pageSize}",method=RequestMethod.GET)
	public ResponseResult getDoneTask(@PathVariable String uid,@PathVariable String pageNo,@PathVariable String pageSize)
	{
		ResponseResult rr=ts.getDoneTask(uid, pageNo, pageSize);
		return rr;
	}
	//处理请求未完成任务
	@RequestMapping(value="/{uid}/{pageNo}/{pageSize}/{isstarted}",method=RequestMethod.GET)
	public ResponseResult getTask(@PathVariable String uid, @PathVariable String pageNo,@PathVariable String pageSize,@PathVariable int isstarted)
	{
		//System.out.println("uid:"+uid);
		ResponseResult rr=ts.getTask(uid, pageNo, pageSize,isstarted);
		return rr;
	}
	//处理结束任务
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public ResponseResult FinishTask(@RequestBody T_Task tt)
	{
//		System.out.println(tt.getTaskdesc());
//		System.out.println(tt.getId());
		logger.debug("taskdesc:",tt.getTaskdesc());
		ResponseResult rr=ts.updateTask(tt);
		return rr;
	}
	//处理评价业务
	@RequestMapping(value="/judge/",method=RequestMethod.PUT)
	public ResponseResult JudgeTask(@RequestBody T_Task tt)
	{
//		System.out.println(tt.getChildeva());
//		System.out.println(tt.getSelfAssessment());
//		System.out.println(tt.getParentcheck());
//		System.out.println(tt.getId());
		ResponseResult rr=ts.judgeTask(tt);
		return rr;
	}
	
}
