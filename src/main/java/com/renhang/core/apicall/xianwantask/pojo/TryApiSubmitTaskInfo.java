package com.renhang.core.apicall.xianwantask.pojo;

import lombok.Data;

@Data
public class TryApiSubmitTaskInfo {
    //广告ID
    private String adid;
    //任务详情分组ID，取自详情页接口当天的任务明细
    private String groupId;
    //任务详情ID
    private String itemId;
    //用户提交的答案，如果是截图则提交图片上传后的url
    private String answer;
}
