package com.example.demo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.data.PublicCommonVar;
import com.example.demo.data.ResponseResult;
import com.example.demo.data.ResultCode;
import com.example.demo.data.User_JM;
import com.example.demo.mybatis.model.T_User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api1/user")
public class UserController
{
	@Resource(name="userservice")
	private UserService us;
	@RequestMapping(value="/",method=RequestMethod.POST)
    public ResponseResult addUser(@RequestBody User_JM ujm)
    {
		String url = PublicCommonVar.URL+"?appid="+PublicCommonVar.appid+
				"&secret="+PublicCommonVar.secret+"&js_code="+ujm.getCode()
				+"&grant_type=authorization_code";
		OkHttpClient ohc=new OkHttpClient();
		Request rq=new Request.Builder().url(url).build();
		try
		{
			Response rp=ohc.newCall(rq).execute();
			String result=rp.body().string();
			JSONObject obj=JSON.parseObject(result);
			//System.out.println(obj.get("openid").toString());
			T_User tu=new T_User();
			tu.setUid(obj.get("openid").toString());
			boolean rb=us.adduser(tu);
			if(rb)
			{
				Map map=new HashMap();
				map.put("openid", tu.getUid());
				ResponseResult rr=new ResponseResult(ResultCode.SUCCESS,map);
				return rr;
			}
			else
			{
				return new ResponseResult(ResultCode.INTERNAL_ERROR);
			}
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return new ResponseResult(ResultCode.INTERNAL_ERROR);
    	//return us.adduser(user);
    }
	
}
