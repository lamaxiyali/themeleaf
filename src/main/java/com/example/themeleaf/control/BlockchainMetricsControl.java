package com.example.themeleaf.control;

import com.example.themeleaf.dao.BlockTranChangeMapper;
import com.example.themeleaf.dao.TransactionChangeMapper;
import com.example.themeleaf.entity.BlockTranChange;
import com.example.themeleaf.entity.Metrics.Chaincode;
import com.example.themeleaf.entity.Metrics.Channel;
import com.example.themeleaf.entity.Metrics.Ledger;
import com.example.themeleaf.entity.TransactionChange;
import com.example.themeleaf.result.Accpt1;
import com.example.themeleaf.service.MetricsService;
import com.example.themeleaf.service.impl.BlockTranInfoImpl;
import com.example.themeleaf.service.impl.FabricGateway;
import org.hyperledger.fabric.gateway.Network;
import org.hyperledger.fabric.sdk.BlockInfo;
import org.hyperledger.fabric.sdk.exception.CryptoException;
import org.hyperledger.fabric.sdk.exception.InvalidArgumentException;
import org.hyperledger.fabric.sdk.exception.ProposalException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class BlockchainMetricsControl {
    @Resource
    MetricsService metricsService;
    @Resource
    TransactionChangeMapper transactionChangeMapper;
    @Resource
    BlockTranChangeMapper blockTranChangeMapper;
    @RequestMapping("/api/ledgermetrics")
    public Ledger getLedgerMetrics(){
        return metricsService.getLedgerMetrics();
    }

    @RequestMapping("/api/chaincodemetrics")
    public Chaincode getChaincodeMetrics(){
        return metricsService.getChaincodeMetrics();
    }

    @RequestMapping("/api/channelmetrics")
    public Channel getChannelMetrics(){
        return metricsService.getChannelMetrics();
    }

    @RequestMapping("/api/ledgerchange")
    public List<BlockTranChange> getChange(@RequestBody Accpt1 accpt1){
        return blockTranChangeMapper.getInfoList(accpt1.getCode());
    }

    @RequestMapping("/api/channelchange")
    public List<TransactionChange> getChannelChange(@RequestBody Accpt1 accpt1){
        return transactionChangeMapper.getInfoList(accpt1.getCode());
    }

    @RequestMapping("/api/getsingleblock")
    public List<Map> getSingleBlock(@RequestBody Accpt1 height) throws ProposalException, InvalidArgumentException, IOException, IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, CryptoException {
        Network network = FabricGateway.getGateway().getNetwork("mychannel");
        System.out.println("---------blockinfo----------");
        BlockInfo blockInfo = network.getChannel().queryBlockByNumber(height.getCode());
        return BlockTranInfoImpl.getRWSetFromBlock(blockInfo);
        //获取合约对象
    }

    @RequestMapping("/api/alltranblock")
    public List<List<Map>> getAllTranBlock() throws ProposalException, InvalidArgumentException, IOException, IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, CryptoException {
        int maxheight =  metricsService.getLedgerMetrics().getLedger_blockchain_height().intValue();
        Network network = FabricGateway.getGateway().getNetwork("mychannel");
        System.out.println("---------blockinfo----------");
        org.hyperledger.fabric.sdk.Channel channel = network.getChannel();
        List<List<Map>> lists = new ArrayList<>();
        for (int i = 3; i < maxheight; i++) {
            lists.add(BlockTranInfoImpl.getRWSetFromBlock(channel.queryBlockByNumber(i)));
        }
        return lists;
        //获取合约对象
    }
}
