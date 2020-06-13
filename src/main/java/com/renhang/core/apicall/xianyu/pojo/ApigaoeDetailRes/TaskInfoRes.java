package com.renhang.core.apicall.xianyu.pojo.ApigaoeDetailRes;

import lombok.Data;

import java.util.List;

@Data
public class TaskInfoRes {
    /**
     * 	试玩id
     */
    private String id;
    /**
     * 试玩名称
     */
    private String name;
    /**
     * 任务当前状态.1-在线;3-下线
     */
    private String status;
    /**
     * 试玩图标
     */
    private String logo;
    /**
     * 用于task_type=1时，产品下载链接
     */
    private String link;
    /**
     * 需要提交的项目的字段
     */
    private String sub_option;
    /**
     *?
     */
    private String other_option;
    /**
     * 注意点引导语
     */
    private List<String> notice;
    /**
     * 用于task_type=3时，二维码图片链接
     */
    private String qr_code;
    /**
     * 试玩类型:
     * 1：APP注册
     * 3：图片二维码
     */
    private String task_type;
    /**
     *任务预计审核天数
     */
    private String auditing_day;
    /**
     * 用户奖励的单位（已根据媒体配置的汇率进行转化后的单位）
     */
    private String unit;
    /**
     * 剩余份数
     */
    private Integer lessNum;
    /**
     *用户奖励（已根据媒体配置的汇率进行转化后的值）
     */
    private String award;
    /**
     * 首个步骤的引导语
     */
    private String fstep;
}
