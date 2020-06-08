package com.renhang.core.apicall.xianwan.pojo.TryApiAdInfoRes;

import lombok.Data;

import java.util.List;

@Data
public class ADInfoRes {
    private BaseInfoRes baseInfo;
    private AwardListRes awardList;
    private ButInfoRes butInfo;
    private List<String> awardName;
}
