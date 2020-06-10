package com.renhang.core.apicall.xianwantask.pojo;

import lombok.Data;

@Data
public class Cparesponse {
    private CpaAdShowInfo adInfo;
    private CpaTaskDetail rewardInfo;
    private Integer[] stepList;
    //    private CpaTaskStrategy taskStrategy;
    private String  supportUrl;
    private String  rewardNoticeUrl;
//    private CpaButtons  buttons;
}
