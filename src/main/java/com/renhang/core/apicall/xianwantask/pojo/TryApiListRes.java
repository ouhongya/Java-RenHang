package com.renhang.core.apicall.xianwantask.pojo;

import lombok.Data;

import java.util.List;

@Data
public class TryApiListRes {
    // 是否成功 0成功、其他失败
    private Integer status;
    // 显示消息（可显示给用户）
    private String msg;
    //内部消息（查错用）
    private String info;
    //广告列表
    private List<AdListsRes> items;


}
