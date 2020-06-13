package com.renhang.core.apicall.xianwan.pojo.TryApiAdInfoRes;

import lombok.Data;

import java.util.List;

@Data
public class TryApiAdInfoRes {
    /**
     * 状态判断 0：正常 其他错误
     */
    private Integer status;
    /**
     *返回消息
     */
    private String msg;
    /**
     * 返回消息
     */
    private String info;
    /**
     * 时间戳
     */
    private String current_timestamp;
    /**
     *活动数据
     */
    private List<ActivityListRes> activityList;
    /**
     * 这我也不晓得是啥,api文档也没有对应的说明
     */
    private AdChannelRes adChannel;
    /**
     *返回广告详情数组
     */
    private ADInfoRes ADInfo;
}
