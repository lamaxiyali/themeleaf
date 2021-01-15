package com.example.themeleaf.dao;

import com.example.themeleaf.entity.PersonMessage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PersonMessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PersonMessage record);

    PersonMessage selectByPrimaryKey(Integer id);

    List<PersonMessage> selectAll();

    int updateByPrimaryKey(PersonMessage record);
}
