package com.example.themeleaf.dao;

import com.example.themeleaf.entity.Fabric;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FabricMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Fabric record);

    Fabric selectByPrimaryKey(Integer id);

    List<Fabric> selectAll();

    int updateByPrimaryKey(Fabric record);
}