package com.renhang.core.apicall.xiaozhuzhuanqian.pojo;

import lombok.Data;

@Data
public class DataRes {
    /**
     * id	int	截图试玩ID
     * type	string	投放限制设备。android、ios、all（android和ios）
     * logo	string	试玩图标
     * name	string	试玩标题
     * guide	string	试玩引导语
     * award	double	用户奖励（已根据媒体配置的汇率进行转化后的值）
     * unit	string	用户奖励的单位（已根据媒体配置的汇率进行转化后的单位）
     * mediaIncome	int	媒体主收入（单位分，媒体主自有提现会包含给用户的奖励金额（分))
     * start_date	int	任务开始时间（1970年1月1日到现在的秒数）
     * end_date	int	任务结束时间（1970年1月1日到现在的秒数）
     */
    private Integer id;
    private String type;
    private String logo;
    private String name;
    private String guide;
    private double award;
    private String unit;
    private Integer mediaIncome;
    private Integer start_date;
    private Integer end_date;
}
