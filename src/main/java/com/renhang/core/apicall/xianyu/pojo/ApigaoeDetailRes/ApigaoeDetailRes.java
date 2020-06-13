package com.renhang.core.apicall.xianyu.pojo.ApigaoeDetailRes;

import lombok.Data;


@Data
public class ApigaoeDetailRes {
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
     * 数据字段
     */
    private DataRes data;
}
