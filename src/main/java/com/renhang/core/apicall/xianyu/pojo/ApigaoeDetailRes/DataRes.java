package com.renhang.core.apicall.xianyu.pojo.ApigaoeDetailRes;

import lombok.Data;

import java.util.List;

@Data
public class DataRes {
    private List<String> auditPics;
    private TaskInfoRes taskInfo;
    private List<StepInfoRes> stepInfo;
    private String token;
}
