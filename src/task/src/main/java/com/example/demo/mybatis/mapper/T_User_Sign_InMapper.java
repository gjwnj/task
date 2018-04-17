package com.example.demo.mybatis.mapper;

import com.example.demo.mybatis.model.T_User_Sign_In;

public interface T_User_Sign_InMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(T_User_Sign_In record);

    int insertSelective(T_User_Sign_In record);

    T_User_Sign_In selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T_User_Sign_In record);

    int updateByPrimaryKey(T_User_Sign_In record);
}