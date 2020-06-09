package com.renhang.core.callback.xianwantask.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class XianwanCallbackVo {
    private String id;
    private int appId;
    private String appSign;
    private Integer adid;
    private String adName;
    private String adImg;
    private int taskId;
    private String describe;
    private int dayNo;
    private double award;
    private int itemId;
    private int itemType;
    private String answer;
    private int status;
    private String rejectCause;
    private String sign;
    @JsonFormat(pattern = "yyyy-HH-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdTime;
}
