package com.example.demo.service.serviceimpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.data.PublicCommonVar;
import com.example.demo.data.ResponseResult;
import com.example.demo.data.ResultCode;
import com.example.demo.mybatis.mapper.T_User_Sign_InMapper;
import com.example.demo.mybatis.model.T_User_Sign_In;
import com.example.demo.service.SignInService;

@Service("signinservice")
public class SignInServiceImpl implements SignInService
{
	@Resource
	private T_User_Sign_InMapper tusi;
	@Override
	public ResponseResult isSignIn(String uid)
	{
		T_User_Sign_In result=tusi.selectByPrimaryKey(uid);
		if(result==null)
		{
			//该用户不存在
			return new ResponseResult(ResultCode.KONG);
		}
		else
		{
			LocalDate now=LocalDate.now();
			LocalDateTime rdt=result.getSigninTime();
			LocalDate rd=LocalDate.of(rdt.getYear(),rdt.getMonthValue(), 
					rdt.getDayOfMonth());
			//该用户已签到
			if(now.equals(rd))
			{
				return new ResponseResult("200","已签到",result);
			}
			//该用户未签到，但未断签
			else if(now.equals(rd.plusDays(1)))
			{
				return new ResponseResult(PublicCommonVar.UNSIGNED,
						"连签中",result);
			}
			else
			{
				//连签天数重置为0
				result.setLastday(0);
				return new ResponseResult(PublicCommonVar.UNSIGNED,
						"已断签",result);
			}
		}
	}
	@Override
	public ResponseResult SignIn(String uid)
	{
		//检查用户是否存在
		ResponseResult<T_User_Sign_In> temrr=this.isSignIn(uid);
		//用户不存在，则插入一条记录,并签到，加10积分
		if(temrr.getCode()==ResultCode.KONG.getCode())
		{
			//java8时间api,要求mysql-connector-java>=5.1.37
			LocalDateTime now=LocalDateTime.now(); 
			T_User_Sign_In record= new T_User_Sign_In();
			record.setUid(uid);
			record.setLastday(1);
			record.setSigninTime(now);
			record.setCredits(10);
			int i=tusi.insertSelective(record);
			//判断数据库操作成不成功
			if(i>0)
			{
				return new ResponseResult<>();
			}
			else
			{
				return new ResponseResult<>(ResultCode.INTERNAL_ERROR);
			}
		}
		else
		{
			//未签到
			if(temrr.getCode().equals(PublicCommonVar.UNSIGNED))
			{
				ResponseResult<T_User_Sign_In> rr=temrr;
				T_User_Sign_In temobj=rr.getObj();
				LocalDateTime rdatetime=temobj.getSigninTime();
				LocalDate rdate=LocalDate.of(rdatetime.getYear(), 
						rdatetime.getMonthValue(), rdatetime.getDayOfMonth());
				//未断签,加10积分，如果签满七天，另加30积分
				if(LocalDate.now().minusDays(1).equals(rdate))
				{
					temobj.setCredits(temobj.getCredits()+10);
					temobj.setLastday(temobj.getLastday()+1);
					if(temobj.getLastday()%7==0)
					{
						temobj.setCredits(temobj.getCredits()+30);
					}
				}
				//断签，连签天数重置为1，并加10积分
				else
				{
					temobj.setLastday(1);
					temobj.setCredits(temobj.getCredits()+10);	
				}
			    //执行签到
				temobj.setSigninTime(LocalDateTime.now());
				int j=tusi.updateByPrimaryKeySelective(temobj);
				//判断数据库操作成不成功
				if(j>0)
				{
					return new ResponseResult<>("200","已签到",temobj);
				}
				else
				{
					return new ResponseResult<>(ResultCode.INTERNAL_ERROR);
				}
			}
			//已签到，直接返回
			else
			{
				return new ResponseResult<T_User_Sign_In>("200","已签到",temrr.getObj());
			}	
		}
	}
}
