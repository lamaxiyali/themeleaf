package com.example.themeleaf.dao;

import com.example.themeleaf.entity.SenseTaskInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SenseTaskInfoMapper {
    int deleteByPrimaryKey(String tid);

    int insert(SenseTaskInfo record);

    SenseTaskInfo selectByPrimaryKey(String tid);

    List<SenseTaskInfo> selectAll();

    int updateByPrimaryKey(SenseTaskInfo record);

    int count();

    List<SenseTaskInfo> getInfoList(int before, int after);

    void updateTaskStatus(SenseTaskInfo senseTaskInfo);
}
