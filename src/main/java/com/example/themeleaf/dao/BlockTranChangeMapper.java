package com.example.themeleaf.dao;

import com.example.themeleaf.entity.BlockTranChange;
import com.example.themeleaf.entity.SenseTaskInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BlockTranChangeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlockTranChange record);

    BlockTranChange selectByPrimaryKey(Integer id);

    List<BlockTranChange> selectAll();

    int updateByPrimaryKey(BlockTranChange record);

    List<BlockTranChange> getInfoList(int count);
    List<BlockTranChange> selectByHeightAndNumber(Integer height, Integer tran_number);
}
