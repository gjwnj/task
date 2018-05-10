package com.example.demo.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.ResponseResult;
import com.example.demo.service.SignInService;

@RestController
@RequestMapping("/api1/signin")
public class SignInController
{
	@Resource(name="signinservice")
	private SignInService sis;
	@RequestMapping(value="/{uid}/",method=RequestMethod.GET)
	public ResponseResult isSignIn(@PathVariable String uid)
	{
		//System.out.println(uid);
		ResponseResult rr=sis.isSignIn(uid);
		return rr;
	}
	@RequestMapping(value="/{uid}/",method=RequestMethod.PUT)
	public ResponseResult SignIn(@PathVariable String uid)
	{
		ResponseResult rr=sis.SignIn(uid);
		return rr;
	}

}
