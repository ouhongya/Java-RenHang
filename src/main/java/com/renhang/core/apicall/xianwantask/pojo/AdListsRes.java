package com.renhang.core.apicall.xianwantask.pojo;

import lombok.Data;

import java.util.List;

@Data
public class AdListsRes {
    //类型 1：CPL 2：CPA
    private Integer type;
    //广告编号，获取详情页需传入
    private String adid;
    //广告名称
    private String adname;
    //广告简介
    private String intro;
    //广告包名
    private String pagename;
    //广告icon图片地址
    private String imgurl;
    //金额
    private String money;
    //金额单位
    private String unit;
    //显示金额
    private String showmoney;
    //广告预计下线时间 如果时间为2099则为长期合作
    private String stoptime;
    //广告上线时间
    private String starttime;
    //状态 -1未参与、0未下载、1已下载、2已安装、3部分完成、4全部完成、5已失效
    private String ustatus;
    //广告详情页地址
    private String adlink;
    //广告标签
    private List gameTag;
    //广告标签 全角逗号分割(中文逗号)
    private String tag;
    //当日剩余数量
    private Integer dayCount;
    //总剩余数量
    private Integer totalCount;
    //下一个任务时间(如果今日任务未完成，则该时间就是今天)
    private String nextTaskTime;
    //最近审核状态 -1 无、0审核中、1审核通过、2审核不通过
    private Integer auditStatus;
    //拒绝原因，审核状态是拒绝时提供
    private String rejectCause;
}
