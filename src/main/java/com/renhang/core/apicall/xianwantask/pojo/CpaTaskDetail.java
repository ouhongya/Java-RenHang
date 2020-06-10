package com.renhang.core.apicall.xianwantask.pojo;

import lombok.Data;

@Data
public class CpaTaskDetail {
  private  Integer sort;
    private  int status;
    private  String describe;
    private  String rewardMoney;
    private  boolean today;
    private  int layoutType;
    private  Long timeout;
    private CpaTaskStep stepList;
    private  String remark;
}
