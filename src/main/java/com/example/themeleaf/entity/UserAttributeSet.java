package com.example.themeleaf.entity;

import lombok.Data;

@Data
public class UserAttributeSet {
    private String key;
    private Record record;

    @Data
    class Record {
        //用户期望价格（ep）、采样频率（ad）、采样时间（at）、感知位置（pl）、定位精度（pa）和未中标次数（bn）
        private String docType;
        private String user_id;
        private String task_id;
//范围：任务价格/任务允许参与人数
        private int ep ;
//范围：1-10次
        private int ad ;
//范围：10-100s
        private int at;
//范围：1-1000m
        private int pl;
//范围：5-50m
        private int pa;
//范围：目前默认为0
        private int bn;

    }
}

