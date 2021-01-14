package com.example.themeleaf.control;

import com.example.themeleaf.service.impl.BlockTranInfoImpl;
import com.example.themeleaf.service.impl.FabricGateway;
import org.apache.commons.codec.binary.Hex;
import org.hyperledger.fabric.gateway.Contract;
import org.hyperledger.fabric.gateway.ContractException;
import org.hyperledger.fabric.gateway.Network;
import org.hyperledger.fabric.sdk.BlockInfo;
import org.hyperledger.fabric.sdk.Channel;
import org.hyperledger.fabric.sdk.exception.CryptoException;
import org.hyperledger.fabric.sdk.exception.InvalidArgumentException;
import org.hyperledger.fabric.sdk.exception.ProposalException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping("/")
public class GatewayControl {
    byte[] result;
    @RequestMapping("/chaincode")
    public String getChaincode() throws ContractException, TimeoutException, InterruptedException {
        Network network = FabricGateway.gateway.getNetwork("mychannel");
        //获取合约对象
        System.out.println("----------------Mytest Contract-----------------------");
        Contract contract = network.getContract("mycc");
        result = contract.evaluateTransaction("query","a");
        System.out.println(new String(result));
        contract.submitTransaction("invoke","b","a","10");
        System.out.println(new String(contract.evaluateTransaction("query","a")));
        return "getcc";
    }

    @RequestMapping("/getsingleblock")
    public List<Map> getSingleBlock(@RequestParam (value = "height") Integer height) throws ProposalException, InvalidArgumentException, IOException, IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, CryptoException {
        Network network = FabricGateway.gateway.getNetwork("mychannel");
        System.out.println("---------blockinfo----------");
        BlockInfo blockInfo = network.getChannel().queryBlockByNumber(height);
        System.out.println(Hex.encodeHexString(blockInfo.getPreviousHash()));
        System.out.println(blockInfo.getBlockNumber());
        System.out.println(BlockTranInfoImpl.caculateCurrentBlockhash(blockInfo));
        return BlockTranInfoImpl.getRWSetFromBlock(blockInfo);
        //获取合约对象
    }

    @RequestMapping("/alltranblock")
    public List<List<Map>> getAllTranBlock(@RequestParam (value = "maxheight") Integer maxheight) throws ProposalException, InvalidArgumentException, IOException, IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, CryptoException {
        Network network = FabricGateway.gateway.getNetwork("mychannel");
        System.out.println("---------blockinfo----------");
        Channel channel = network.getChannel();
        List<List<Map>> lists = new ArrayList<>();
        for (int i = 3; i < maxheight; i++) {
            lists.add(BlockTranInfoImpl.getRWSetFromBlock(channel.queryBlockByNumber(i)));
        }
        return lists;
        //获取合约对象
    }


}
