package com.renhang.core.apicall.xianwan.pojo.TryApiAdInfoRes;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AwardRes {
    /**
     * 广告奖励编号从小到大1，2，3升序
     */
    private Integer num;
    /**
     *广告奖励级别 单个任务唯一
     */
    private Integer dlevel;
    /**
     *完成任务所需数值
     */
    private Integer needlevel;
    /**
     *奖励说明
     */
    private String event;
    /**
     *用户当前奖励进度描述
     */
    private String progress;
    /**
     *
     */
    private boolean progressType;
    /**
     *单步奖励金额
     */
    private BigDecimal money;
    /**
     *货币单位名称	单位：元
     */
    private String unit;
    /**
     *奖励名称
     */
    private String groupname;
}
