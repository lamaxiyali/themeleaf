package com.example.themeleaf.entity.Metrics;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Chaincode {
    //    调用链码读操作完成次数--9443--peer
    Double chaincode_shim_requests_completed_get;
    //    调用链码写操作完成次数--9443-peer
    Double chaincode_shim_requests_completed_put;
    //    调用链码读操作请求数--9443-peer
    Double chaincode_shim_requests_received_get;
    //    调用链码写操作请求数--9443-peer
    Double chaincode_shim_requests_received_put;
//          当前安装的应用链码个数
    Double chaincode_launch_duration_count;
    List<ChaincodeDesc> list;

    public Double getChaincode_shim_requests_completed_get() {
        return chaincode_shim_requests_completed_get;
    }

    public void setChaincode_shim_requests_completed_get(Double chaincode_shim_requests_completed_get) {
        this.chaincode_shim_requests_completed_get = chaincode_shim_requests_completed_get;
    }

    public Double getChaincode_shim_requests_completed_put() {
        return chaincode_shim_requests_completed_put;
    }

    public void setChaincode_shim_requests_completed_put(Double chaincode_shim_requests_completed_put) {
        this.chaincode_shim_requests_completed_put = chaincode_shim_requests_completed_put;
    }

    public Double getChaincode_shim_requests_received_get() {
        return chaincode_shim_requests_received_get;
    }

    public void setChaincode_shim_requests_received_get(Double chaincode_shim_requests_received_get) {
        this.chaincode_shim_requests_received_get = chaincode_shim_requests_received_get;
    }

    public Double getChaincode_shim_requests_received_put() {
        return chaincode_shim_requests_received_put;
    }

    public void setChaincode_shim_requests_received_put(Double chaincode_shim_requests_received_put) {
        this.chaincode_shim_requests_received_put = chaincode_shim_requests_received_put;
    }

    public Double getChaincode_launch_duration_count() {
        return chaincode_launch_duration_count;
    }

    public void setChaincode_launch_duration_count(Double chaincode_launch_duration_count) {
        this.chaincode_launch_duration_count = chaincode_launch_duration_count;
    }

    public List<ChaincodeDesc> getList() {
        return list;
    }

    public void setList(List<ChaincodeDesc> list) {
        Map<String, String> map = new LinkedHashMap<>();
        this.list = list;
    }

    @Override
    public String toString() {
        return "Chaincode{" +
                "chaincode_shim_requests_completed_get=" + chaincode_shim_requests_completed_get +
                ", chaincode_shim_requests_completed_put=" + chaincode_shim_requests_completed_put +
                ", chaincode_shim_requests_received_get=" + chaincode_shim_requests_received_get +
                ", chaincode_shim_requests_received_put=" + chaincode_shim_requests_received_put +
                ", chaincode_launch_duration_count=" + chaincode_launch_duration_count +
                '}';
    }
}


