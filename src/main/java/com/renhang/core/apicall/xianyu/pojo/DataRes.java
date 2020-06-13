package com.renhang.core.apicall.xianyu.pojo;

import lombok.Data;

@Data
public class DataRes {
    /**
     * 截图试玩ID
     */
    private Integer id;
    /**
     * 投放限制设备。android、ios、all（android和ios）
     */
    private String type;
    /**
     * 试玩图标
     */
    private String logo;
    /**
     * 试玩标题
     */
    private String name;
    /**
     * 试玩引导语
     */
    private String guide;
    /**
     * 	用户奖励（已根据媒体配置的汇率进行转化后的值）
     */
    private double award;
    /**
     * 用户奖励的单位（已根据媒体配置的汇率进行转化后的单位）
     */
    private String unit;
    /**
     * 	媒体主收入（单位分，媒体主自有提现会包含给用户的奖励金额（分))
     */
    private Integer mediaIncome;
    /**
     * 任务开始时间（1970年1月1日到现在的秒数）
     */
    private Integer start_date;
    /**
     * 任务结束时间（1970年1月1日到现在的秒数）
     */
    private Integer end_date;
}
