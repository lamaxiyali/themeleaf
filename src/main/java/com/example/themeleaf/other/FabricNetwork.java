package com.example.themeleaf.other;
import org.hyperledger.fabric.gateway.Gateway;
import org.hyperledger.fabric.gateway.impl.GatewayImpl;

//获取区块链sdk网关
public interface FabricNetwork {
    public Gateway getGateway();
}
