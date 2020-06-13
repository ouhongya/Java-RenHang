package com.renhang.core.apicall.xianyu.pojo.ApigaoeDetailRes;

import lombok.Data;

import java.util.List;

@Data
public class StepInfoRes {
    /**
     * 步骤说明
     */
    private String title;
    /**
     * 步骤引导图片数组
     */
    private String audit_idx;
    /**
     * 标记每步中第几张需要截图提交供审核
     */
    private List<String> pic;
}
