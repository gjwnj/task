package com.example.demo;


import java.net.MalformedURLException;
import java.net.URL;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.data.ResponseResult;
import com.example.demo.utils.LogFactory;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TaskApplication.class,webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TaskApplicationTests {
	@LocalServerPort
	private int port;
	
	Logger logger = LogFactory.getBusinessLogger();
	
	private URL base;
	@Resource
	private TestRestTemplate restTemplate;
	@Before
	public void setUp() throws MalformedURLException 
	{
		String url=String.format("http://localhost:%d/", port);
		logger.info(String.format("port is : [%d]",port));
		this.base=new URL(url);
		
	}
	@Test
	public void test1()
	{
		ResponseEntity<ResponseResult> re=this.restTemplate.getForEntity(this.base.toString()+"/test", ResponseResult.class);
		logger.info(String.format("测试结果：%s", re.getBody().getMsg()));
	}

//	@Test
//	public void contextLoads() {
//	}

}
