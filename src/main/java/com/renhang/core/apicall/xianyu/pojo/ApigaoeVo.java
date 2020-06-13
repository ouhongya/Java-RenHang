package com.renhang.core.apicall.xianyu.pojo;

import lombok.Data;

@Data
public class ApigaoeVo {
    /**
     * 错误码。成功为0
     */
    private Integer code;
    /**
     * 错误信息
     */
    private String msg;
    /**
     *data字段数据条数
     */
    private Integer count;
    /**
     * 返回的信息
     */
    private String data;
}
