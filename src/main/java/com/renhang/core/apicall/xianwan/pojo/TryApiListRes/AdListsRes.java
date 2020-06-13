package com.renhang.core.apicall.xianwan.pojo.TryApiListRes;

import lombok.Data;

@Data
public class AdListsRes {
    /**
     * 广告id
     */
    private String adid;
    /**
     * 广告名称；如果乱码，需URL解码，（注意捕获解码异常）
     */
    private String adname;
    /**
     * 广告名称缩写（不带期数）
     */
    private String adnamecut;
    /**
     * 广告期数
     */
    private String issue;
    /**
     * 广告类型；
     */
    private Integer adtype;
    /**
     * 广告简介；如果乱码，需URL解码，（注意捕获解码异常）
     */
    private String intro;
    /**
     * 广告应用APP大小 ；如果乱码，需URL解码，（注意捕获解码异常）
     */
    private String appsize;
    /**
     * 广告icon图片地址 ；如果乱码，需URL解码，（注意捕获解码异常）
     */
    private String imgurl;
    /**
     * 显示金额 ；如果乱码，需URL解码，（注意捕获解码异常）
     */
    private String showmoney;
    /**
     * 广告预计上线时间
     */
    private String starttime;
    /**
     * 广告预计下线时间 如果时间为2099则为长期合作
     */
    private String stoptime;
    /**
     * 用户当前状态 0：未下载； 1：触发过下载 ；2-3：已注册账号
     */
    private String ustatus;
    /**
     * 货币单位 ；如果乱码，需URL解码，（注意捕获解码异常）
     */
    private String unit;
    /**
     * 广告详情页地址 ；如果乱码，需URL解码，（注意捕获解码异常）
     */
    private String adlink;
    /**
     * 第一步奖励描述；如果乱码，需URL解码，（注意捕获解码异常）
     */
    private String first_des;
    /**
     * 奖励金额
     */
    private Double longMoney;
    /**
     * 包名
     */
    private String pagename;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 货币单位填充字段（万）：有值时填充单位（unit）之前 与longMoney、unit配套使用如 longMoney :100 magnitude:”万” unit:”金币” 组合后:100万金币
     */
    private String magnitude;
    /**
     * 参与人数描述
     */
    private String trialinfo;
    /**
     * 广告预计下线时间 如果时间为2099则为长期合作
     */
    private Integer stoptimsec;
}
