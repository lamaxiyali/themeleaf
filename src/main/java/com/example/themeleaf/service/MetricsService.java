package com.example.themeleaf.service;

import com.example.themeleaf.entity.Metrics.Chaincode;
import com.example.themeleaf.entity.Metrics.Channel;
import com.example.themeleaf.entity.Metrics.Ledger;

import java.util.Map;

public interface MetricsService {
    public Map<String,Double> getMetrics(int tag);
    public Ledger getLedgerMetrics();
    public Chaincode getChaincodeMetrics();
    public Channel getChannelMetrics();



}
