package com.renhang.core.apicall.xianwantask.pojo;

import lombok.Data;

@Data
public class LinkTask {
    private Integer status;
    private String msg;
    private String info;
    private TaskDesc data;
}
