package com.renhang.core.apicall.xianwantask.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Cparesponse {
    //广告基础信息
    private CpaAdShowInfo adInfo;
    //每日任务及奖励信息
    private CpaTaskDetail rewardInfo;
    //奖励获取步骤浮层 eg.(1.下载安装 2.按要求试玩 3.提交截图即可获得奖励)
    private List<Integer> stepList;
    //无法获取CpaTaskStrategy任务攻略对象
//    private CpaTaskStrategy taskStrategy;
    //客服链接地址
    private String  supportUrl;
    //奖励通知url
    private String  rewardNoticeUrl;
    //无法获取CpaButtons按钮信息对象
//    private CpaButtons  buttons;
}
