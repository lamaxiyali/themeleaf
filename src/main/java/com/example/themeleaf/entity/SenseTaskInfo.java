package com.example.themeleaf.entity;



import java.io.Serializable;
import java.util.List;

public class SenseTaskInfo implements Serializable {
    private String tid;

    private String task_name;

    private String task_from;

    private Integer people_limit;

    private String task_type;

    private String task_area;

    private String task_date;

    private String task_startTime;

    private String task_endTime;

    private Integer task_price;

    private String task_status;

    private String task_desc;

    private List<TaskPart> taskPartList;

    private static final long serialVersionUID = 1L;

    public List<TaskPart> getTaskPartList() {
        return taskPartList;
    }

    public void setTaskPartList(List<TaskPart> taskPartList) {
        this.taskPartList = taskPartList;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid == null ? null : tid.trim();
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name == null ? null : task_name.trim();
    }

    public String getTask_from() {
        return task_from;
    }

    public void setTask_from(String task_from) {
        this.task_from = task_from == null ? null : task_from.trim();
    }

    public Integer getPeople_limit() {
        return people_limit;
    }

    public void setPeople_limit(Integer people_limit) {
        this.people_limit = people_limit;
    }

    public String getTask_type() {
        return task_type;
    }

    public void setTask_type(String task_type) {
        this.task_type = task_type == null ? null : task_type.trim();
    }

    public String getTask_area() {
        return task_area;
    }

    public void setTask_area(String task_area) {
        this.task_area = task_area == null ? null : task_area.trim();
    }

    public String getTask_date() {
        return task_date;
    }

    public void setTask_date(String task_date) {
        this.task_date = task_date == null ? null : task_date.trim();
    }

    public String getTask_startTime() {
        return task_startTime;
    }

    public void setTask_startTime(String task_startTime) {
        this.task_startTime = task_startTime == null ? null : task_startTime.trim();
    }

    public String getTask_endTime() {
        return task_endTime;
    }

    public void setTask_endTime(String task_endTime) {
        this.task_endTime = task_endTime == null ? null : task_endTime.trim();
    }

    public Integer getTask_price() {
        return task_price;
    }

    public void setTask_price(Integer task_price) {
        this.task_price = task_price;
    }

    public String getTask_status() {
        return task_status;
    }

    public void setTask_status(String task_status) {
        this.task_status = task_status == null ? null : task_status.trim();
    }

    public String getTask_desc() {
        return task_desc;
    }

    public void setTask_desc(String task_desc) {
        this.task_desc = task_desc == null ? null : task_desc.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tid=").append(tid);
        sb.append(", task_name=").append(task_name);
        sb.append(", task_from=").append(task_from);
        sb.append(", people_limit=").append(people_limit);
        sb.append(", task_type=").append(task_type);
        sb.append(", task_area=").append(task_area);
        sb.append(", task_date=").append(task_date);
        sb.append(", task_startTime=").append(task_startTime);
        sb.append(", task_endTime=").append(task_endTime);
        sb.append(", task_price=").append(task_price);
        sb.append(", task_status=").append(task_status);
        sb.append(", task_desc=").append(task_desc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
