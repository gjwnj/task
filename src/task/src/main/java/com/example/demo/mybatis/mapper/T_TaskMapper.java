package com.example.demo.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.data.vo.UserAllTaskVo;
import com.example.demo.mybatis.model.T_Task;
import com.example.demo.mybatis.model.T_TaskWithBLOBs;

public interface T_TaskMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(T_TaskWithBLOBs record);
    
    //int insertSelective(T_TaskWithBLOBs record);
    
    int insertOne(T_Task tt);

    //后端采用mybatis分页
    UserAllTaskVo selectByPrimaryKey(@Param("taskowner") String uid,@Param("isstarted") int isstarted);
    
    UserAllTaskVo selectByDone(@Param("taskowner") String uid);
    
    List<UserAllTaskVo> selectByNameOrTypeAndTime(@Param("taskowner") String uid,@Param("taskname") String taskname,@Param("tasktype") String tasktype);

    int updateByPrimaryKeySelective(T_Task record);

    int updateByPrimaryKeyWithBLOBs(T_TaskWithBLOBs record);

    int updateByPrimaryKey(T_Task record);
}