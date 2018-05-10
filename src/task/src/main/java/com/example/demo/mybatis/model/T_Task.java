package com.example.demo.mybatis.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

public class T_Task implements Serializable 
{
    private Integer id;
    
    private String taskowner;

    private String taskdesc;

    private String taskname;
//    @JSONField(format="yyyy-MM-dd HH:mm:ss") 
//    private Date starttime;
    private LocalDateTime starttime;
//    @JSONField(format="yyyy-MM-dd HH:mm:ss")
//    private Date endtime;
    private LocalDateTime endtime;

    private String childeva;

    private Integer selfAssessment;
    
    private String parentcheck;
//    @JSONField(format="yyyy-MM-dd HH:mm:ss")
//    private Date actualfinishtime;
    private LocalDateTime actualfinishtime;
    
    private String tasktype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskdesc() {
        return taskdesc;
    }

    public void setTaskdesc(String taskdesc) {
        this.taskdesc = taskdesc == null ? null : taskdesc.trim();
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname == null ? null : taskname.trim();
    }

    public LocalDateTime getStarttime() {
        return starttime;
    }

    public void setStarttime(LocalDateTime starttime) {
        this.starttime = starttime;
    }

    public LocalDateTime getEndtime() {
        return endtime;
    }

    public void setEndtime(LocalDateTime endtime) {
        this.endtime = endtime;
    }

    public String getChildeva() {
        return childeva;
    }

    public void setChildeva(String childeva) {
        this.childeva = childeva == null ? null : childeva.trim();
    }

    public Integer getSelfAssessment() {
        return selfAssessment;
    }

    public void setSelfAssessment(Integer selfAssessment) {
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

	public String getTaskowner()
	{
		return taskowner;
	}

	public void setTaskowner(String taskowner)
	{
		this.taskowner = taskowner;
	}

	public LocalDateTime getActualfinishtime()
	{
		return actualfinishtime;
	}

	public void setActualfinishtime(LocalDateTime actualfinishtime)
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
}