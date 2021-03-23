package com.example.themeleaf.entity;

import lombok.Data;

@Data
public class UserBaicInfoInBlockchain {
    private String key;
    private Record record;

    @Data
    static class Record {
        private String user_name;
        private String docType;
        private String email;
        private float credit;
        private float reward;
    }
}

