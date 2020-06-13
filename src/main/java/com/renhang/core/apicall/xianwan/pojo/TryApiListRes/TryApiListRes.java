package com.renhang.core.apicall.xianwan.pojo.TryApiListRes;

import lombok.Data;

import java.util.List;

@Data
public class TryApiListRes {
    /**
     * 状态码
     */
    private Integer status;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 返回信息
     */
    private String info;
    /**
     * 时间戳
     */
    private String current_timestamp;
    /**
     * 手机类型
     */
    private Integer ptype;
    private List<AdListsRes> items;
    /**
     * 用户id
     */
    private Long userId;
}
