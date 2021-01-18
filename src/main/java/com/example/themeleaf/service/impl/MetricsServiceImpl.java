package com.example.themeleaf.service.impl;

import com.example.themeleaf.dao.BlockTranChangeMapper;
import com.example.themeleaf.dao.TransactionChangeMapper;
import com.example.themeleaf.entity.BlockTranChange;
import com.example.themeleaf.entity.Metrics.Chaincode;
import com.example.themeleaf.entity.Metrics.ChaincodeDesc;
import com.example.themeleaf.entity.Metrics.Channel;
import com.example.themeleaf.entity.Metrics.Ledger;
import com.example.themeleaf.entity.TransactionChange;
import com.example.themeleaf.service.MetricsService;
import com.example.themeleaf.utils.HttpUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
//ssssss
@Service
public class MetricsServiceImpl implements MetricsService {

    Map<String, Double> response;
    @Resource
    BlockTranChangeMapper blockTranChangeMapper;
    @Resource
    TransactionChangeMapper transactionChangeMapper;
    @Override
    public Map<String, Double> getMetrics(int tag) {
        if (tag == 0){
//            获取peer节点开放运维数据
            response = HttpUtil.httpsRequest("http://118.178.253.55:9443/metrics", "GET", "");
            return  response;
        }else{
//            获取order节点开放运维数据
            response = HttpUtil.httpsRequest("http://118.178.253.55:8443/metrics", "GET", "");
            return response;
        }
    }

    @Override
    public Ledger getLedgerMetrics() {
        Map<String, Double> mapper = getMetrics(0);
        Ledger ledger = new Ledger();
        Set keys = mapper.keySet();
        for (Object s: keys
        ) {
            if(s.toString().startsWith("fabric_version")){
                String version = s.toString().substring(s.toString().indexOf('{'), s.toString().indexOf('}'));
                ledger.setFabric_version(version);
            }
            if(s.toString().startsWith("ledger_blockchain_height")){
                ledger.setLedger_blockchain_height(mapper.get(s));
            }
            if(s.toString().startsWith("ledger_transaction_count{chaincode=\"userbasicinfo:1\",channel=\"mychannel\",transaction_type=\"ENDORSER_TRANSACTION\",validation_code=\"VALID\"}")){
                ledger.setLedger_transaction_count(mapper.get(s));
            }
            if(s.toString().startsWith("endorser_proposals_received")){
                ledger.setEndorser_proposals_received(mapper.get(s));
            }
            if(s.toString().startsWith("endorser_successful_proposals")){
                ledger.setEndorser_successful_proposals(mapper.get(s));
            }
            if(s.toString().startsWith("gossip_comm_messages_received")){
                ledger.setGossip_comm_messages_received(mapper.get(s));
            }
            if(s.toString().startsWith("gossip_comm_messages_sent")){
                ledger.setGossip_comm_messages_sent(mapper.get(s));
            }
            if(s.toString().startsWith("chaincode_launch_duration_count")){
                ledger.setChaincode_launch_duration_count(mapper.get(s));
            }

        }
        System.out.println(ledger.toString());
        BlockTranChange blockTranChange = new BlockTranChange();
        blockTranChange.setHeight(ledger.getLedger_blockchain_height().intValue());
        blockTranChange.setTran_number(ledger.getLedger_transaction_count().intValue());
        List<BlockTranChange> blockTranChange1 = blockTranChangeMapper.selectByHeightAndNumber(blockTranChange.getHeight(), blockTranChange.getTran_number());
        if(blockTranChange1.size() == 0){
            blockTranChangeMapper.insert(blockTranChange);
        }
        return ledger;
    }

    @Override
    public Chaincode getChaincodeMetrics() {
        Map<String, Double> mapper = getMetrics(0);
        Chaincode chaincode = new Chaincode();
        Set<String> keys = mapper.keySet();
        List<ChaincodeDesc> listchaincode = new ArrayList<>();
        for (String s: keys
             ) {
            if(s.startsWith("chaincode_launch_duration_count")){
                if(s.contains("multiattributeranking")){
                    listchaincode.add(getDesc("multiattributeranking", "mychannel", s));
                }
                if(s.contains("userattributesetupload")){
                    listchaincode.add(getDesc("userattributesetupload", "mychannel", s));
                }
                if(s.contains("userbasicinfo")){
                    listchaincode.add(getDesc("userbasicinfo", "mychannel", s));
                }
            }
            if(s.startsWith("chaincode_shim_requests_completed{chaincode=\"userbasicinfo_1:67877d1ee7e4846e93fc392a6d21c78250a2d2121652fefc2b00b1003340a6ef\",channel=\"mychannel\",success=\"true\",type=\"GET_STATE\"}")){
                chaincode.setChaincode_shim_requests_completed_get(mapper.get(s));
            }
            if(s.startsWith("chaincode_shim_requests_completed{chaincode=\"userbasicinfo_1:67877d1ee7e4846e93fc392a6d21c78250a2d2121652fefc2b00b1003340a6ef\",channel=\"mychannel\",success=\"true\",type=\"PUT_STATE\"}")){
                chaincode.setChaincode_shim_requests_completed_put(mapper.get(s));
            }
            if(s.startsWith("chaincode_shim_requests_received{chaincode=\"userbasicinfo_1:67877d1ee7e4846e93fc392a6d21c78250a2d2121652fefc2b00b1003340a6ef\",channel=\"mychannel\",type=\"GET_STATE\"}")){
                chaincode.setChaincode_shim_requests_received_get(mapper.get(s));
            }
            if(s.startsWith("chaincode_shim_requests_received{chaincode=\"userbasicinfo_1:67877d1ee7e4846e93fc392a6d21c78250a2d2121652fefc2b00b1003340a6ef\",channel=\"mychannel\",type=\"PUT_STATE\"}")){
                chaincode.setChaincode_shim_requests_received_put(mapper.get(s));
            }
        }
        chaincode.setChaincode_launch_duration_count((double) listchaincode.size());
        chaincode.setList(listchaincode);
        return chaincode;
    }

    @Override
    public Channel getChannelMetrics() {
        Map<String, Double> mapper = getMetrics(1);
        Channel channel = new Channel();
        Set<String> keys = mapper.keySet();
        for (String s: keys
             ) {
            if(s.startsWith("broadcast_processed_count{channel=\"mychannel\",status=\"SUCCESS\",type=\"CONFIG_UPDATE\"}")){
                channel.setBroadcast_processed_count_update(mapper.get(s));
            }
            if(s.startsWith("broadcast_processed_count{channel=\"mychannel\",status=\"SUCCESS\",type=\"ENDORSER_TRANSACTION\"}")){
                channel.setBroadcast_processed_count_endorse(mapper.get(s));
            }
            if(s.startsWith("consensus_etcdraft_active_nodes{channel=\"mychannel\"}")){
                channel.setConsensus_etcdraft_active_nodes(mapper.get(s));
            }
            if(s.startsWith("consensus_etcdraft_cluster_size{channel=\"mychannel\"}")){
                channel.setConsensus_etcdraft_cluster_size(mapper.get(s));
            }
            if(s.startsWith("consensus_etcdraft_committed_block_number{channel=\"mychannel\"}")){
                channel.setConsensus_etcdraft_committed_block_number(mapper.get(s));
            }
            if(s.startsWith("consensus_etcdraft_config_proposals_received{channel=\"mychannel\"}")){
                channel.setConsensus_etcdraft_config_proposals_received(mapper.get(s));
            }
            if(s.startsWith("consensus_etcdraft_normal_proposals_received{channel=\"mychannel\"}")){
                channel.setConsensus_etcdraft_normal_proposals_received(mapper.get(s));
            }
        }
        TransactionChange transactionChange = new TransactionChange();
        transactionChange.setNormal_tran(channel.getConsensus_etcdraft_normal_proposals_received().intValue());
        transactionChange.setConfig_tran(channel.getConsensus_etcdraft_config_proposals_received().intValue());
        System.out.println(channel.getConsensus_etcdraft_config_proposals_received().intValue());
        System.out.println(channel.getConsensus_etcdraft_normal_proposals_received().intValue());
        List<TransactionChange> list = transactionChangeMapper.selectByNormalAndConfig(transactionChange.getNormal_tran(), transactionChange.getConfig_tran());
        if(list.size() == 0){
            transactionChangeMapper.insert(transactionChange);
        }
        return channel;
    }

    private ChaincodeDesc getDesc(String name, String channel, String s){
        String str1 = s.substring(s.indexOf('{'), s.indexOf('}')+1);
        String[] strs = str1.split(",");
        String id = strs[0].substring(strs[0].indexOf('"')+1, strs[0].lastIndexOf('"'));
        String status = strs[1].substring(strs[1].indexOf('"')+1, strs[1].lastIndexOf('"'));
        String version = id.substring(id.indexOf('_')+1, id.indexOf(':'));
        ChaincodeDesc chaincodeDesc = new ChaincodeDesc();
        chaincodeDesc.setName(name);
        if(status.equals("true")){
            chaincodeDesc.setStatus("success");
        }else{
            chaincodeDesc.setStatus("failure");
        }
        chaincodeDesc.setVersion(version);
        chaincodeDesc.setChaincode_number(id);
        chaincodeDesc.setChannel(channel);
        return chaincodeDesc;
    }
}
