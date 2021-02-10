package com.example.themeleaf.control;

import com.example.themeleaf.entity.UserAttributeSet;
import com.example.themeleaf.result.Result;
import com.example.themeleaf.service.impl.FabricGateway;
import org.hyperledger.fabric.gateway.Contract;
import org.hyperledger.fabric.gateway.ContractException;
import org.hyperledger.fabric.gateway.Network;
import org.hyperledger.fabric.sdk.Channel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.util.concurrent.TimeoutException;

@RestController
public class BlockTaskControl {

    @RequestMapping("/api/adduserinfo")
    public Result registerUserInfoToBlockchain(){
        Channel channel = FabricGateway.gateway.getNetwork("mychannel").getChannel();
        System.out.println(channel);
        return null;
    }
    @RequestMapping("/api/addattr")
    public Result addUserAttrSetToBlockchain() throws InterruptedException, TimeoutException, ContractException {
        Network network = FabricGateway.gateway.getNetwork("mychannel");
        Contract contract = network.getContract("userattributesetupload");
        byte[] result = contract.submitTransaction("Set", "aaaa", "0000", "0", "0", "0", "0", "0", "0", "aaaa");
        System.out.println(new String(result));
        System.out.println(result.length);
        return null;
    }

    @RequestMapping("/api/getrank")
    public Result getUserTaskRank(){
        Channel channel = FabricGateway.gateway.getNetwork("mychannel").getChannel();
        System.out.println(channel);
        return null;
    }

    @RequestMapping("/api/updatecredit")
    public Result updateUserCredit(){
        Channel channel = FabricGateway.gateway.getNetwork("mychannel").getChannel();
        System.out.println(channel);
        return null;
    }

}
