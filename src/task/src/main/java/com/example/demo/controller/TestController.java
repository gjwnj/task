package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.ResponseResult;

@RestController
@RequestMapping("/test")
public class TestController {
	@RequestMapping(value="",method=RequestMethod.GET)
	public ResponseResult Test()
	{
		ResponseResult rr=new ResponseResult();
		rr.setCode("000");
		rr.setMsg("success");
		rr.setObj("test");
		return rr;
	}

}
