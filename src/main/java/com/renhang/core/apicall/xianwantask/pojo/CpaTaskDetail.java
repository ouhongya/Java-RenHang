package com.renhang.core.apicall.xianwantask.pojo;

import lombok.Data;

@Data
public class CpaTaskDetail {
    //排序
    private  Integer sort;
    //用户完成任务状态：0未开启，1进行中，2已完成，3已失效，4审核中，5审核失败
    private  int status;
    //任务描述
    private  String describe;
    //任务奖励金额
    private  String rewardMoney;
    //是否当天任务
    private  boolean today;
    //今日任务布局：1单个布局，2列表布局
    private  int layoutType;
    //任务剩余时间（毫秒
    private  Long timeout;
    //步骤集合
    private CpaTaskStep stepList;
    //当日任务描述
    private  String remark;
}
