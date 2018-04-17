package com.example.demo.mybatis.mapper;

import com.example.demo.mybatis.model.T_User;

public interface T_UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(T_User record);

    int insertSelective(T_User record);

    T_User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T_User record);

    int updateByPrimaryKey(T_User record);
}