package com.renhang.core.apicall.xianwantask.pojo.TryApiAdInfoRes;

import lombok.Data;

@Data
public class TryApiSubmitTask {
    //渠道id （由闲玩分配）
    private String appid;
    //渠道用户编号(app中 用户ID)唯一且不变
    private String appsign;
    //1 iPhone 2 安卓
    private String ptype;
    //设备号 android取IMEI; iphone取IDFA 获取不到请传 0
    private String deviceid;
    //IOS 忽略此参数 安全联盟OAID （未接入安全联盟请传空字符串“”）
    private String msaoaid;
    //IOS 忽略此参数 安卓操作系统版本号 如:安卓10对应的是参数：androidosv=29 （androidQ即安卓10对应androidosv=29）获取不到请传0
    private String androidosv;
    //加密校验 MD5(appid+deviceid+msaoaid+androidosv+ptype+appsign+appsecret)
    private String keycode;
    //广告ID
    private String adid;
    //任务详情分组ID，取自详情页接口当天的任务明细
    private Integer groupId;
    //任务详情ID
    private Integer itemId;
    //用户提交的答案，如果是截图则提交图片上传后的url
    private String answer;
}
