package com.example.demo.service.serviceimpl;

import javax.annotation.Resource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.mybatis.mapper.T_UserMapper;
import com.example.demo.mybatis.model.T_User;
import com.example.demo.service.UserService;

@Service("userservice")
public class UserServiceImpl implements UserService
{
	@Resource
	
	private T_UserMapper tu; 

	@Override
	public boolean adduser(T_User user)
	{
		//1成功  0失败
		int result=tu.insertSelective(user);
		if(result==1)
		{
			return true;
		}
		else
		{
			return false;
		}
		// TODO Auto-generated method stub
	}

}
