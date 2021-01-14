package com.example.themeleaf.metrics;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class YarnMetrics implements MeterBinder {
    public Map<String, Double> map = new HashMap<>();
    public final List<String> YARN_METRICS_NAMES = Arrays.asList(
            "appsCompleted",  //已完成任务数
            "appsPending",  //排队任务数
            "appsRunning", //运行job数
            "totalMB",  // 总内存大小
            "allocatedMB", // 已使用内存
            "availableMB", // 空闲内存
            "totalVirtualCores", // 总核数
            "allocatedVirtualCores", // 已用核数
            "availableVirtualCores", // 空闲核数
            "totalNodes", // 总节点数
            "activeNodes", // 激活节点数
            "decommissionedNodes" // 退役节点数
    );
    public final String YARN_METRICS_PREFIX = "yarn_";

    @Override
    public void bindTo(MeterRegistry meterRegistry) {
        for (String s: YARN_METRICS_NAMES
             ) {
            Gauge.builder(YARN_METRICS_PREFIX.concat(s), map, m->m.get(s)).register(meterRegistry);
        }
    }
}
