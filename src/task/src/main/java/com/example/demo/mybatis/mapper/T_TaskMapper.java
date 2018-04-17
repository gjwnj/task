package com.example.demo.mybatis.mapper;

import com.example.demo.mybatis.model.T_Task;
import com.example.demo.mybatis.model.T_TaskWithBLOBs;

public interface T_TaskMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(T_TaskWithBLOBs record);

    int insertSelective(T_TaskWithBLOBs record);

    T_TaskWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T_TaskWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(T_TaskWithBLOBs record);

    int updateByPrimaryKey(T_Task record);
}