package com.renhang.core.apicall.xianwantask.pojo;

import lombok.Data;

import java.util.List;

@Data
public class TryApiListRes {
    private Integer status;
    private String msg;
    private String info;
//    private String current_timestamp;
//    private Integer ptype;
    private List<AdListsRes> items;
//    private Long userId;
}
