package com.renhang.core.apicall.xianyu.pojo;

import lombok.Data;

import java.util.List;

@Data
public class ApigaoeListRes {
    /**
     * 	错误码，成功为0
     */
    private Integer code;
    /**
     * 	错误信息
     */
    private String msg;
    /**
     * 列表条数
     */
    private Integer count;
    /**
     * 列表信息
     */
    private List<DataRes> data;
}
