package com.example.demo.mybatis.model;

public class T_TaskWithBLOBs extends T_Task {
    private String actualusingtime;

    private String parentcheck;

    public String getActualusingtime() {
        return actualusingtime;
    }

    public void setActualusingtime(String actualusingtime) {
        this.actualusingtime = actualusingtime == null ? null : actualusingtime.trim();
    }

    public String getParentcheck() {
        return parentcheck;
    }

    public void setParentcheck(String parentcheck) {
        this.parentcheck = parentcheck == null ? null : parentcheck.trim();
    }
}