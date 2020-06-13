package com.renhang.core.apicall.kendeji.pojo;

import lombok.Data;

@Data
public class KfcFrontendUrlVo {
    /**
     * 状态 true成功 false失败
     */
    private boolean success;
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 数据
     */
    private KfcFrontendUrl data;
}
