package com.example.themeleaf.entity.Metrics;

import java.util.concurrent.ExecutorService;

public class Ledger {
    //    fabric version--all
    String fabric_version;
    //    区块高度--9443--peer
    Double ledger_blockchain_height;
    //    处理的事务数--9443--peer
    Double ledger_transaction_count;
    //    收到的提案数量--9443--peer
    Double endorser_proposals_received;
    //    成功提案的数量--9443--peer
    Double endorser_successful_proposals;
    //    gossip 消息收到的消息数--9443--peer
    Double gossip_comm_messages_received;
    //    gossip 消息发送的消息树--9443--peer
    Double gossip_comm_messages_sent;
    //   当前安装的应用链码个数
    Double chaincode_launch_duration_count;

    public String getFabric_version() {
        return fabric_version;
    }

    public void setFabric_version(String fabric_version) {
        this.fabric_version = fabric_version;
    }

    public Double getLedger_blockchain_height() {
        return ledger_blockchain_height;
    }

    public void setLedger_blockchain_height(Double ledger_blockchain_height) {
        this.ledger_blockchain_height = ledger_blockchain_height;
    }

    public Double getLedger_transaction_count() {
        return ledger_transaction_count;
    }

    public void setLedger_transaction_count(Double ledger_transaction_count) {
        this.ledger_transaction_count = ledger_transaction_count;
    }

    public Double getEndorser_proposals_received() {
        return endorser_proposals_received;
    }

    public void setEndorser_proposals_received(Double endorser_proposals_received) {
        this.endorser_proposals_received = endorser_proposals_received;
    }

    public Double getEndorser_successful_proposals() {
        return endorser_successful_proposals;
    }

    public void setEndorser_successful_proposals(Double endorser_successful_proposals) {
        this.endorser_successful_proposals = endorser_successful_proposals;
    }

    public Double getGossip_comm_messages_received() {
        return gossip_comm_messages_received;
    }

    public void setGossip_comm_messages_received(Double gossip_comm_messages_received) {
        this.gossip_comm_messages_received = gossip_comm_messages_received;
    }

    public Double getGossip_comm_messages_sent() {
        return gossip_comm_messages_sent;
    }

    public void setGossip_comm_messages_sent(Double gossip_comm_messages_sent) {
        this.gossip_comm_messages_sent = gossip_comm_messages_sent;
    }

    public Double getChaincode_launch_duration_count() {
        return chaincode_launch_duration_count;
    }

    public void setChaincode_launch_duration_count(Double chaincode_launch_duration_count) {
        this.chaincode_launch_duration_count = chaincode_launch_duration_count;
    }

    @Override
    public String toString() {
        return "Ledger{" +
                "fabric_version='" + fabric_version + '\'' +
                ", ledger_blockchain_height=" + ledger_blockchain_height +
                ", ledger_transaction_count=" + ledger_transaction_count +
                ", endorser_proposals_received=" + endorser_proposals_received +
                ", endorser_successful_proposals=" + endorser_successful_proposals +
                ", gossip_comm_messages_received=" + gossip_comm_messages_received +
                ", gossip_comm_messages_sent=" + gossip_comm_messages_sent +
                '}';
    }
}
