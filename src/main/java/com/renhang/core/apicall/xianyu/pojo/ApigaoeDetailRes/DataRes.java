package com.renhang.core.apicall.xianyu.pojo.ApigaoeDetailRes;

import lombok.Data;

import java.util.List;

@Data
public class DataRes {
    /**
     * 审核引导图片
     */
    private List<String> auditPics;
    /**
     * 任务基础信息
     */
    private TaskInfoRes taskInfo;
    /**
     * 试玩步骤描述
     */
    private List<StepInfoRes> stepInfo;
    /**
     * 用于上传七牛图片（需媒体主接入七牛JS）
     */
    private String token;
}
