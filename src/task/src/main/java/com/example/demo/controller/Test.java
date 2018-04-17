package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api1")
public class Test
{
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public void Test()
	{
		System.out.println("success");
	}
	
	@RequestMapping(value="/send",method=RequestMethod.POST)
	public void send()
	{
		System.out.println("post success");
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	public void delete()
	{
		System.out.println("delete success");
	}
	
	@RequestMapping(value="/put",method=RequestMethod.PUT)
	public void put()
	{
		System.out.println("put success");
	}

}
