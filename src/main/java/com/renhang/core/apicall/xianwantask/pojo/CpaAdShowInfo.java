package com.renhang.core.apicall.xianwantask.pojo;

import lombok.Data;

import java.util.List;

@Data
public class CpaAdShowInfo {
    //广告ID
    private String adid;
    //广告名称
    private String adName;
    //广告标签数组 eg.[“截图”,”免审”]
    private List gameTag;
    //金额
    private String money;
    //金额
    private String unit;
    //展示金额
    private String showMoney;
    //展示金额
    private String imgUrl;
    //包名
    private String packageName;
    //包名
    private Integer packageSize;
    //下载地址
    private String  linkUrl;
    //开始时间
    private String  startTime;
    //开始时间
    private String  endTime;
    //开始时间
    private Integer  limit;
    //广告描述
    private String  describe;
    //体验第几天
    private int  dayNum;
    //体验第几天
    private Integer  totalDayNum;
    //是否绑定
    private boolean  appBind;
    //广告类型 0下载体验；1免下载任务
    private Integer  adType;
    //是否模糊图片
    private boolean  shouldBlurImage;
    //是否模糊图片
    private String  downMethod;
    //渠道提供的打开url方法
    private String  openMethod;

}
