package com.example.themeleaf.service;

import com.google.protobuf.InvalidProtocolBufferException;
import org.hyperledger.fabric.sdk.BlockInfo;

import java.util.List;
import java.util.Map;

public interface BlockTranInfo {
    public List<Map> getRWSetFromBlock(BlockInfo blockInfo) throws InvalidProtocolBufferException;
}
