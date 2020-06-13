package com.renhang.core.apicall.xianwan.pojo.TryApiAdInfoRes;

import lombok.Data;

import java.util.List;

@Data
public class ActivityListRes {
    /**
     *广告编号
     */
    private String adid;
    /**
     *活动id
     */
    private String actid;
    /**
     *活动时间
     */
    private String etime;
    /**
     *活动名称
     */
    private String aname;
    /**
     *奖励人数
     */
    private String pcount;
    /**
     *活动排序号
     */
    private String orderindex;
    /**
     *活动时间
     */
    private String dlevel;
    /**
     *不知道是啥
     */
    private String intro;
    /**
     *活动状态
     */
    private String status;
    /**
     *当前用户排名
     */
    private String userrank;
    /**
     *待奖励记录
     */
    private List<AwardrecordRes> awardrecord;
}
