package com.renhang.core.callback.kendeji.pojo;

import lombok.Data;

@Data
public class KfcOrder {
    private boolean success;
    private Integer code;
    private String message;
    private KfcOrderVo data;
}
