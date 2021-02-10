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
        private int ep ;
        private int ad ;
        private int at;
        private int pl;
        private int pa;
        private int bn;

    }
}

