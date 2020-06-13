package com.renhang.core.apicall.xianwan.pojo;

import lombok.Data;

import java.util.List;

@Data
public class MyActionAdListVoRes {
    /**
     * 状态判断 0：正常 其他错误
     */
    private Integer status;
    /**
     *
     */
    private String msg;
    private String info;
    private String current_timestamp;
    private String ptype;
    private String total;
    private String userId;
    private List<ListRes> list;
    @Data
    class ListRes{
        /**
         * 广告编号，获取详情页需传入
         */
        private String adid;
        /**
         * 广告名称；需URL解码
         */
        private String adname;
        /**
         * 广告名称缩写（不带期数）
         */
        private String adnamecut;
        /**
         * 广告期数描述 如：”1期”
         */
        private String issue;
        /**
         * 广告类型；
         */
        private String adtype;
        /**
         * 图片
         */
        private String imgurl;
        /**
         * 显示金额
         */
        private String showmoney;
        /**
         *当前已赚取金额
         */
        private String earnmoney;
        /**
         * 广告预计上线时间
         */
        private String starttime;
        /**
         *广告预计下线时间 如果时间为2099则为长期合作
         */
        private String stoptime;
        /**
         * 货币单位 ；需URL解码
         */
        private String unit;
        /**
         * 广告详情页地址 ；需URL解码
         */
        private String adlink;
        /**
         *广告下载时间
         */
        private String bindtime;
        /**
         * 广告注册时间
         */
        private String regtime;
    }
}
