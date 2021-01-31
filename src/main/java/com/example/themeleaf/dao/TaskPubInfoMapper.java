package com.example.themeleaf.dao;

import com.example.themeleaf.entity.Repass;
import com.example.themeleaf.entity.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TaskPubInfoMapper {
    int deleteByPrimaryKey(String username);

    int insert(Userinfo record);

    Userinfo selectByPrimaryKey(String username);

    List<Userinfo> selectAll();

    int updateByPrimaryKey(Userinfo record);

    Userinfo selectByEmail(String email);

    Userinfo selectByUsername(String username);

    int updateByEmail(Userinfo record);

    int updateByUsername(Userinfo record);

    int count();

    List<Userinfo> getInfoList(int before, int after);
}
