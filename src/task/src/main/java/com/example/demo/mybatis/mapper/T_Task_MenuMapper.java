package com.example.demo.mybatis.mapper;

import com.example.demo.mybatis.model.T_Task_Menu;

public interface T_Task_MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(T_Task_Menu record);

    int insertSelective(T_Task_Menu record);

    T_Task_Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T_Task_Menu record);

    int updateByPrimaryKey(T_Task_Menu record);
}