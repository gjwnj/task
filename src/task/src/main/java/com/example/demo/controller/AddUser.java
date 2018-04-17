package com.example.demo.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mybatis.model.T_User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api1/user")
public class AddUser
{
	@Resource(name="userservice")
	private UserService us;
	@RequestMapping(value="/",method=RequestMethod.POST)
    public boolean addUser(@RequestBody T_User user)
    {
    	
    	return us.adduser(user);
    }
}
