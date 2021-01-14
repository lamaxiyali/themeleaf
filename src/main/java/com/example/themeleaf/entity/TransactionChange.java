package com.example.themeleaf.entity;

import java.io.Serializable;

public class TransactionChange implements Serializable {
    private Integer id;

    private Integer normal_tran;

    private Integer config_tran;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNormal_tran() {
        return normal_tran;
    }

    public void setNormal_tran(Integer normal_tran) {
        this.normal_tran = normal_tran;
    }

    public Integer getConfig_tran() {
        return config_tran;
    }

    public void setConfig_tran(Integer config_tran) {
        this.config_tran = config_tran;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", normal_tran=").append(normal_tran);
        sb.append(", config_tran=").append(config_tran);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}