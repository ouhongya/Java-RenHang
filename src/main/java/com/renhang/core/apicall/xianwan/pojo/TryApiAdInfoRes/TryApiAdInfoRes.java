package com.renhang.core.apicall.xianwan.pojo.TryApiAdInfoRes;

import lombok.Data;

import java.util.List;

@Data
public class TryApiAdInfoRes {
    private Integer status;
    private String msg;
    private String info;
    private String current_timestamp;
    private List<ActivityListRes> activityList;
    private AdChannelRes adChannel;
    private ADInfoRes ADInfo;
    private Long ptype;
    private Integer userId;
    private boolean supportAndroidQ;
}
