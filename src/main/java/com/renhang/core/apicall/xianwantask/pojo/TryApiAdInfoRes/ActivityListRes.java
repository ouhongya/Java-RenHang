package com.renhang.core.apicall.xianwantask.pojo.TryApiAdInfoRes;

import lombok.Data;

import java.util.List;

@Data
public class ActivityListRes {
    private String adid;
    private String actid;
    private String etime;
    private String aname;
    private String pcount;
    private String orderindex;
    private String dlevel;
    private String intro;
    private String status;
    private String userrank;
    private List<AwardrecordRes> awardrecord;
}
