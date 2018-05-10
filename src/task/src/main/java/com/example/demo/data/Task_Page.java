package com.example.demo.data;

import java.io.Serializable;

public class Task_Page implements Serializable
{
	public String uid;
	
	public Integer pageNo;
	
	public Integer pageSize;

	public String getUid()
	{
		return uid;
	}

	public void setUid(String uid)
	{
		this.uid = uid;
	}

	public Integer getPageNo()
	{
		return pageNo;
	}

	public void setPageNo(Integer pageNo)
	{
		this.pageNo = pageNo;
	}

	public Integer getPageSize()
	{
		return pageSize;
	}

	public void setPageSize(Integer pageSize)
	{
		this.pageSize = pageSize;
	}
	
}
