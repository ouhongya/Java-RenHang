package com.renhang.core.apicall.xianwan.pojo.TryApiAdInfoRes;

import lombok.Data;

import java.util.List;

@Data
public class ADInfoRes {
    /**
     *广告基础信息
     */
    private BaseInfoRes baseInfo;
    /**
     *奖励分组 对应awardList数组坐标
     */
    private AwardListRes awardList;
    /**
     *按钮对象
     */
    private ButInfoRes butInfo;
    /**
     *奖励分组 对应awardList数组坐标
     */
    private List<String> awardName;
}
