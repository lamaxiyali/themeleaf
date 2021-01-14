package com.example.themeleaf.entity.Metrics;

public class ChaincodeDesc {
    String name;
    String version;
    String status;
    String chaincode_number;
    String channel;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getChaincode_number() {
        return chaincode_number;
    }

    public void setChaincode_number(String chaincode_number) {
        this.chaincode_number = chaincode_number;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
}
