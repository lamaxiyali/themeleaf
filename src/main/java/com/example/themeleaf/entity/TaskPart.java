package com.example.themeleaf.entity;

import java.io.Serializable;

public class TaskPart implements Serializable {
    private String task_id;

    private String task_userid;

    private static final long serialVersionUID = 1L;

    public String getTask_id() {
        return task_id;
    }

    public void setTask_id(String task_id) {
        this.task_id = task_id == null ? null : task_id.trim();
    }

    public String getTask_userid() {
        return task_userid;
    }

    public void setTask_userid(String task_userid) {
        this.task_userid = task_userid == null ? null : task_userid.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", task_id=").append(task_id);
        sb.append(", task_userid=").append(task_userid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
