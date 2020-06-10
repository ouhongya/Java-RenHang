package com.renhang.core.apicall.xiaoju.pojo;

import lombok.Data;

@Data
public class QueryResponseVo {
    private String appKey;
    private String data;
    private String code;
    private String msg;
    private String sig;
}
