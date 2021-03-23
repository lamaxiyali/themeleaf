package com.example.themeleaf.control;

import com.example.themeleaf.dao.SenseTaskInfoMapper;
import com.example.themeleaf.entity.AttrSet;
import com.example.themeleaf.entity.SenseTaskInfo;
import com.example.themeleaf.entity.UserAttributeSet;
import com.example.themeleaf.result.Result;
import com.example.themeleaf.service.TaskService;
import com.example.themeleaf.service.impl.FabricGateway;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hyperledger.fabric.gateway.Contract;
import org.hyperledger.fabric.gateway.ContractException;
import org.hyperledger.fabric.gateway.Network;
import org.hyperledger.fabric.sdk.Channel;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.util.Date;
import java.util.concurrent.TimeoutException;

@RestController
public class BlockTaskControl {

    @Resource
    TaskService taskService;
    @Resource
    SenseTaskInfoMapper senseTaskInfoMapper;
    @RequestMapping("/api/adduserinfo")
    public Result registerUserInfoToBlockchain(){
        Channel channel = FabricGateway.gateway.getNetwork("mychannel").getChannel();
        System.out.println(channel);
        return null;
    }
    @RequestMapping("testchaincode")
    public Result test() throws InterruptedException, TimeoutException, ContractException {
        Network network = FabricGateway.gateway.getNetwork("mychannel");
        Contract multiattributeranking = network.getContract("multiattributeranking");
        byte[] bytes = multiattributeranking.submitTransaction("BidStart1", "userattributesetupload", "mychannel", "k3ere07nvxsb", "ReadByTask_id", String.valueOf(System.currentTimeMillis()));
        System.out.println(bytes.length);
        System.out.println(new String(bytes));
        System.out.println(new String(bytes).length());
        return new Result(200);
    }
    @RequestMapping("/api/addattr")
    public Result addUserAttrSetToBlockchain(@RequestBody AttrSet attrSet) throws InterruptedException, TimeoutException, ContractException {
        SenseTaskInfo senseTaskInfo = senseTaskInfoMapper.selectByPrimaryKey(attrSet.getTask_id());
        Integer task_nowpartin = senseTaskInfo.getTask_nowpartin();
        Network network = FabricGateway.gateway.getNetwork("mychannel");
        Contract contract = network.getContract("userattributesetupload");
        long l = System.currentTimeMillis();
        Subject subject = SecurityUtils.getSubject();
        String user_id = subject.getPrincipal().toString();
        if(senseTaskInfo.getPeople_limit().equals(senseTaskInfo.getTask_nowpartin())){
//            401-----参与人数达到上线
            return new Result(401);
        }
        int re = taskService.partIn(attrSet.getTask_id(), user_id);
        if (re == 1) {
//              该账号已经参与该任务
            return new Result(400);
        }

        byte[] result = contract.submitTransaction("Set", user_id, attrSet.getTask_id(), String.valueOf(attrSet.getEp()), String.valueOf(attrSet.getAd()), String.valueOf(attrSet.getAt()), String.valueOf(attrSet.getPl()), String.valueOf(attrSet.getPa()), String.valueOf(attrSet.getBn()), String.valueOf(System.currentTimeMillis()));
        if(result.length == 0){
            senseTaskInfo.setTask_nowpartin(task_nowpartin + 1);
            if(senseTaskInfo.getPeople_limit().equals(senseTaskInfo.getTask_nowpartin())) {
                Contract multiattributeranking = network.getContract("multiattributeranking");
                multiattributeranking.submitTransaction("BidStart1", "userattributesetupload", "mychannel", attrSet.getTask_id(), "ReadByTask_id", String.valueOf(System.currentTimeMillis()));
            }
            senseTaskInfoMapper.updateTaskNowPartIn(senseTaskInfo);
            return new Result(200);
        }
//        链上属性插入逻辑错误
        return new Result(402);
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
