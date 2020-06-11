package com.renhang.core.callback.kendeji.pojo;

import lombok.Data;

import java.util.List;

@Data
public class KfcOrderList {
    private boolean success;
    private Integer code;
    private String message;
    private List<KfcOrderVo> data;
}
