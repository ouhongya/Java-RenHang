package com.renhang.core.apicall.xianwantask.pojo;

import lombok.Data;

@Data
public class TaskDesc {
    private  String appUrl;
    private  String downloadType;
    private  long timeout;
    private  String downMethod;
    private  String openMethod;
}
