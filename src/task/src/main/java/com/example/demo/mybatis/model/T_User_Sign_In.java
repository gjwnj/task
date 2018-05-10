package com.example.demo.mybatis.model;

import java.time.LocalDateTime;
import java.util.Date;

public class T_User_Sign_In {
    private Integer id;

    private String uid;

    private LocalDateTime signinTime;

    private Integer lastday;
    
    private Integer credits;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public LocalDateTime getSigninTime() {
        return signinTime;
    }

    public void setSigninTime(LocalDateTime signinTime) {
        this.signinTime = signinTime;
    }

    public Integer getLastday() {
        return lastday;
    }

    public void setLastday(Integer lastday) {
        this.lastday = lastday;
    }

	public Integer getCredits()
	{
		return credits;
	}

	public void setCredits(Integer credits)
	{
		this.credits = credits;
	}
}