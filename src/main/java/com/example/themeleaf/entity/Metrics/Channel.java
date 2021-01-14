package com.example.themeleaf.entity.Metrics;

public class Channel {
    //    活跃节点数--order--8443
    Double consensus_etcdraft_active_nodes;
    //     提交的最新块号
    Double consensus_etcdraft_committed_block_number;
    //    收到的正常事务类型
    Double consensus_etcdraft_normal_proposals_received;
    //    为配置类型事务收到的建议总数
    Double consensus_etcdraft_config_proposals_received;
    //    处理的事务数升级事务--order--8443
    Double broadcast_processed_count_update;
    //    处理的事务数normal事务--order--8443
    Double broadcast_processed_count_endorse;
    //    通道中节点个数
    Double consensus_etcdraft_cluster_size;

    public Double getConsensus_etcdraft_active_nodes() {
        return consensus_etcdraft_active_nodes;
    }

    public void setConsensus_etcdraft_active_nodes(Double consensus_etcdraft_active_nodes) {
        this.consensus_etcdraft_active_nodes = consensus_etcdraft_active_nodes;
    }

    public Double getConsensus_etcdraft_committed_block_number() {
        return consensus_etcdraft_committed_block_number;
    }

    public void setConsensus_etcdraft_committed_block_number(Double consensus_etcdraft_committed_block_number) {
        this.consensus_etcdraft_committed_block_number = consensus_etcdraft_committed_block_number;
    }

    public Double getConsensus_etcdraft_normal_proposals_received() {
        return consensus_etcdraft_normal_proposals_received;
    }

    public void setConsensus_etcdraft_normal_proposals_received(Double consensus_etcdraft_normal_proposals_received) {
        this.consensus_etcdraft_normal_proposals_received = consensus_etcdraft_normal_proposals_received;
    }

    public Double getConsensus_etcdraft_config_proposals_received() {
        return consensus_etcdraft_config_proposals_received;
    }

    public void setConsensus_etcdraft_config_proposals_received(Double consensus_etcdraft_config_proposals_received) {
        this.consensus_etcdraft_config_proposals_received = consensus_etcdraft_config_proposals_received;
    }

    public Double getBroadcast_processed_count_update() {
        return broadcast_processed_count_update;
    }

    public void setBroadcast_processed_count_update(Double broadcast_processed_count_update) {
        this.broadcast_processed_count_update = broadcast_processed_count_update;
    }

    public Double getBroadcast_processed_count_endorse() {
        return broadcast_processed_count_endorse;
    }

    public void setBroadcast_processed_count_endorse(Double broadcast_processed_count_endorse) {
        this.broadcast_processed_count_endorse = broadcast_processed_count_endorse;
    }

    public Double getConsensus_etcdraft_cluster_size() {
        return consensus_etcdraft_cluster_size;
    }

    public void setConsensus_etcdraft_cluster_size(Double consensus_etcdraft_cluster_size) {
        this.consensus_etcdraft_cluster_size = consensus_etcdraft_cluster_size;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "consensus_etcdraft_active_nodes=" + consensus_etcdraft_active_nodes +
                ", consensus_etcdraft_committed_block_number=" + consensus_etcdraft_committed_block_number +
                ", consensus_etcdraft_normal_proposals_received=" + consensus_etcdraft_normal_proposals_received +
                ", consensus_etcdraft_config_proposals_received=" + consensus_etcdraft_config_proposals_received +
                ", broadcast_processed_count_update=" + broadcast_processed_count_update +
                ", broadcast_processed_count_endorse=" + broadcast_processed_count_endorse +
                '}';
    }
}
