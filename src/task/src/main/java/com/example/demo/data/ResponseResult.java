package com.example.demo.data;

import java.io.Serializable;

public class ResponseResult<T> implements Serializable
{
	private String code;
	private String msg;
	//@JsonInclude(Include.NON_NULL) 
	private T obj;
	public ResponseResult()
	{
		this.code=ResultCode.SUCCESS.getCode();
		//this.code="111";
		this.msg=ResultCode.SUCCESS.getMsg();
		this.obj=null;
		//this.msg=ResultCode.SUCCESS.getMsg();
		//this.obj=null;
	}
	public ResponseResult(ResultCode rc)
	{
		this.code=rc.getCode();
		this.msg=rc.getMsg();
		this.obj=null;
	}
	public ResponseResult(ResultCode rc,T obj)
	{
		this.code=rc.getCode();
		this.msg=rc.getMsg();
		this.obj=obj;
	}
	public ResponseResult(String code,String msg,T obj)
	{
		this.code=code;
		this.msg=msg;
		this.obj=obj;
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
	public T getObj()
	{
		return obj;
	}
	public void setObj(T obj)
	{
		this.obj = obj;
	}
}
