package com.example.themeleaf.control;

import com.example.themeleaf.result.Result;
import com.example.themeleaf.service.impl.FabricGateway;
import org.hyperledger.fabric.gateway.Network;
import org.hyperledger.fabric.sdk.Channel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.ResultSet;

@RestController
public class BlockTaskControl {

    @RequestMapping("/api/adduserinfo")
    public Result registerUserInfoToBlockchain(){
        Channel channel = FabricGateway.gateway.getNetwork("mychannel").getChannel();
        System.out.println(channel);
        return null;
    }
    @RequestMapping("/api/addattr")
    public Result addUserAttrSetToBlockchain(){
        Channel channel = FabricGateway.gateway.getNetwork("mychannel").getChannel();
        System.out.println(channel);
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
