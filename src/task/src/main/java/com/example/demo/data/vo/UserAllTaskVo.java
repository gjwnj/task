package com.example.demo.data.vo;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class UserAllTaskVo implements Serializable
{
    private String taskdesc;

    private String taskname;
    
    @JSONField(format="yyyy-MM-dd HH:mm:ss") 
    private Date starttime;
    
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date endtime;
    
    private int pageSum;
    
    private int id;
    
    private Date actualfinishtime;
    
    private String tasktype;
    
    private String childeva;

    private Integer selfAssessment;
    
    private String parentcheck;

	public String getTaskdesc()
	{
		return taskdesc;
	}

	public void setTaskdesc(String taskdesc)
	{
		this.taskdesc = taskdesc;
	}

	public String getTaskname()
	{
		return taskname;
	}

	public void setTaskname(String taskname)
	{
		this.taskname = taskname;
	}

	public Date getStarttime()
	{
		return starttime;
	}

	public void setStarttime(Date starttime)
	{
		this.starttime = starttime;
	}

	public Date getEndtime()
	{
		return endtime;
	}

	public void setEndtime(Date endtime)
	{
		this.endtime = endtime;
	}

	public int getPageSum()
	{
		return pageSum;
	}

	public void setPageSum(int pageSum)
	{
		this.pageSum = pageSum;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Date getActualfinishtime()
	{
		return actualfinishtime;
	}

	public void setActualfinishtime(Date actualfinishtime)
	{
		this.actualfinishtime = actualfinishtime;
	}

	public String getTasktype()
	{
		return tasktype;
	}

	public void setTasktype(String tasktype)
	{
		this.tasktype = tasktype;
	}

	public String getChildeva()
	{
		return childeva;
	}

	public void setChildeva(String childeva)
	{
		this.childeva = childeva;
	}

	public Integer getSelfAssessment()
	{
		return selfAssessment;
	}

	public void setSelfAssessment(Integer selfAssessment)
	{
		this.selfAssessment = selfAssessment;
	}

	public String getParentcheck()
	{
		return parentcheck;
	}

	public void setParentcheck(String parentcheck)
	{
		this.parentcheck = parentcheck;
	}


}
