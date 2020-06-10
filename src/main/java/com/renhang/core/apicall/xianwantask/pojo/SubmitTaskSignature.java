package com.renhang.core.apicall.xianwantask.pojo;

import lombok.Data;

@Data
public class SubmitTaskSignature {
    private Integer status;
    private String msg;
    private String info;
    private SubmitTaskSignatureinfo data;
}
