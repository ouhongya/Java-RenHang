package com.renhang.core.callback.yibangbang.pojo;

import lombok.Data;


@Data
public class reqData {
    //id
    private String id;
    //关联id
    private String task_id;
    //完成任务用户的手机号
    private String phone;
    //渠道标识
    private String channel;
    //用户完成的任务名称(cpc为cpc任务，其余为中文)
    private String task_name;
    //任务类型(cpc为cpc任务，其余为中文)
    private String task_type;
    //完成任务所获得的代币数
    private String coin;
    //渠道方获得代币数
    private String profit;
    //回调时间 10位时间戳
    private String callback_time;
    //创建时间
    private String create_time;

}
