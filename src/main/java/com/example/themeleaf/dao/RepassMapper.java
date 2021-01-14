package com.example.themeleaf.dao;

import com.example.themeleaf.entity.Repass;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface RepassMapper {
    int deleteByPrimaryKey(String email);

    int insert(Repass record);

    Repass selectByPrimaryKey(String email);

    Repass selectByCode(String code);

    List<Repass> selectAll();

    int updateByPrimaryKey(Repass record);

}