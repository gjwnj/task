package com.example.demo.data;

import java.io.Serializable;

public enum ResultCode implements Serializable
{
	SUCCESS("200","成功"),INTERNAL_ERROR("500","内部服务器错误"),KONG("000","不存在该用户");
	private String code;
	private String msg;
	private  ResultCode(String code,String msg)
	{
		this.code=code;
		this.msg=msg;
	}
	public String getCode()
	{
		return code;
	}
	public void setCode(String code)
	{
		this.code = code;
	}
	public String getMsg()
	{
		return msg;
	}
	public void setMsg(String msg)
	{
		this.msg = msg;
	}

}
