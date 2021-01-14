package com.example.themeleaf.dao;

import com.example.themeleaf.entity.BlockTranChange;
import com.example.themeleaf.entity.TransactionChange;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TransactionChangeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TransactionChange record);

    TransactionChange selectByPrimaryKey(Integer id);

    List<TransactionChange> selectAll();

    int updateByPrimaryKey(TransactionChange record);

    List<TransactionChange> getInfoList(int count);
    List<TransactionChange> selectByNormalAndConfig(Integer normal_tran, Integer config_tran);
}
