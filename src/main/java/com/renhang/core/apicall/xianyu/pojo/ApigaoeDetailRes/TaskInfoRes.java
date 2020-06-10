package com.renhang.core.apicall.xianyu.pojo.ApigaoeDetailRes;

import lombok.Data;

import java.util.List;

@Data
public class TaskInfoRes {
    private String id;
    private String name;
    private String status;
    private String logo;
    private String link;
    private String sub_option;
    private String other_option;
    private List<String> notice;
    private String qr_code;
    private String task_type;
    private String auditing_day;
    private String unit;
    private Integer lessNum;
    private String award;
    private String fstep;
}
