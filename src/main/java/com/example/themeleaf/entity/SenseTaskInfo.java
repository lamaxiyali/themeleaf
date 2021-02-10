package com.example.themeleaf.entity;



import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
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

    private Integer task_nowpartin;

    private List<TaskPart> taskPartList;

    private static final long serialVersionUID = 1L;

}
