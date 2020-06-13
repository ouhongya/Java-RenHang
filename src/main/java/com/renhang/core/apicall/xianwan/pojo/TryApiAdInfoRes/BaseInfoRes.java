package com.renhang.core.apicall.xianwan.pojo.TryApiAdInfoRes;

import lombok.Data;

@Data
public class BaseInfoRes {
    /**
     * 用户是否被限制体验 0：否 1：是 如果为是按钮不能点击并提示用户
     */
    private Integer limit;
    /**
     * 应用简介
     */
    private String appIntro;
    /**
     * 广告编号
     */
    private Integer adid;
    /**
     * 应用大小
     */
    private String appSize;
    /**
     * 应用详情介绍（需支持html）
     */
    private String appDescription;
    /**
     * 用户已获得金额 单位：元
     */
    private String unit;
    /**
     * 完成所有任务可获得总金额
     */
    private String appAMoney;
    /**
     * 显示信息（需支持html）
     */
    private String appShowMsg;
    /**
     * 应用大小
     */
    private boolean appBind;
    /**
     * 是否已注册游戏
     */
    private boolean appReg;
    /**
     * 应用名称
     */
    private String adName;
    /**
     * 不知道是啥文档没写
     */
    private String gameInfo;
    /**
     * 当前时间 精确到分
     */
    private String nowDate;
    /**
     * 广告停止时间 精确到分
     */
    private String stopTime;
    /**
     * 应用icon地址
     */
    private String imgUrl;
    /**
     * 完成所有任务可获得总金额
     */
    private String pageName;
    /**
     * 暂无
     */
    private Integer adtype;
    /**
     * 暂无
     */
    private boolean needActvivate;
    /**
     * 暂无
     */
    private String h5ActivateUrl;
    /**
     * 暂无
     */
    private String h5ActivateMethod;
    /**
     * 暂无
     */
    private String tipsNote;
    /**
     * 显示信息（需支持html）
     */
    private Integer amoney;
    /**
     * 用户已获得金额
     */
    private Integer AMoney;
}
