package com.example.demo.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.ResponseResult;
import com.example.demo.data.User_JM;
import com.example.demo.service.TaskMenuService;

@RestController
@RequestMapping("/api1/taskmenu")
public class TaskMenuController
{
	@Resource(name="taskmenuservice")
	private TaskMenuService ts;
	
	@RequestMapping(value="/{openid}",method=RequestMethod.GET)
	public ResponseResult GetType(@PathVariable String openid)
	{
		ResponseResult rr=ts.GetUserAllTaskType(openid);
		return rr;
	}

}
