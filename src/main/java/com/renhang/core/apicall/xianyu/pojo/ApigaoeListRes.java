package com.renhang.core.apicall.xianyu.pojo;

import lombok.Data;

import java.util.List;

@Data
public class ApigaoeListRes {
    private Integer code;
    private String msg;
    private Integer count;
    private List<DataRes> data;

}
