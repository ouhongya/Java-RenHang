package com.renhang.core.apicall.xianwan.pojo.TryApiAdInfoRes;

import lombok.Data;

@Data
public class AwardrecordRes {
    /**
     *排名
     */
    private String arank;
    /**
     *奖励金额
     */
    private String money;
    /**
     *活动id
     */
    private String actid;
    /**
     *用户游戏id（没有达到时显示“虚位以待”）
     */
    private String merid;
    /**
     * 秘钥
     */
    private String keycode;
    /**
     *不知道是啥文档没说
     */
    private String itime;
}
