package com.renhang.core.callback.yibangbang.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class reqData {
    private String id;
    private String task_id;
    private String phone;
    private String channel;
    private String task_name;
    private String task_type;
    private String coin;
    private String profit;
    private String callback_time;
    private Date create_time;

}
