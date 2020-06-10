package com.renhang.core.apicall.yibangbang.pojo;

import lombok.Data;


@Data
public class TaskEntry {
    //用户手机号
    private String phone;
    //渠道别名
    private String channel;
    //链接生成时间戳
    private String time;
    //MD5(phone+channel+密钥)
    private String signature;
}
