package com.renhang.core.apicall.yibangbang.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class UserVo {
    private int phone;
    private String channel;
    private Date time;
    private int area_code;
    private String signature;
}
