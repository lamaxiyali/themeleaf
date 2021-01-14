package com.example.themeleaf.utils;

import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class RealAuthDO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Date createTime;
    private String creatTimeStr;
    public SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    public SimpleDateFormat stf = new SimpleDateFormat("HH:mm:ss");
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        String time = sdf.format(createTime);
        setCreatTimeStr(time);
    }

    public String getCreatTimeStr() {
        return creatTimeStr;
    }

    public void setCreatTimeStr(String creatTimeStr) {
        this.creatTimeStr = creatTimeStr;
    }
}
