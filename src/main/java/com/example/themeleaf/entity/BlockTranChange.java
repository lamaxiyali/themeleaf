package com.example.themeleaf.entity;

import java.io.Serializable;

public class BlockTranChange implements Serializable {
    private Integer id;

    private Integer height;

    private Integer tran_number;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getTran_number() {
        return tran_number;
    }

    public void setTran_number(Integer tran_number) {
        this.tran_number = tran_number;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", height=").append(height);
        sb.append(", tran_number=").append(tran_number);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}