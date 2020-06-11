package com.renhang.core.apicall.xianwantask.pojo;

import lombok.Data;

import java.util.List;

@Data
public class AdListsRes {
    private Integer type;
    private String adid;
    private String adname;
    private String intro;
    private String pagename;
    private String imgurl;
    private String money;
    private String unit;
    private String showmoney;
    private String stoptime;
    private String starttime;
    private String ustatus;
    private String adlink;
    private List gameTag;
    private String tag;
    private Integer dayCount;
    private Integer totalCount;
    private String nextTaskTime;
    private Integer auditStatus;
    private String rejectCause;
}
