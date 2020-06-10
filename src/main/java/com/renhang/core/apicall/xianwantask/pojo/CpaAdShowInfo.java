package com.renhang.core.apicall.xianwantask.pojo;

import lombok.Data;

import java.util.List;

@Data
public class CpaAdShowInfo {
    private String adid;
    private String adName;
    private List gameTag;
    private String money;
    private String unit;
    private String showMoney;
    private String imgUrl;
    private String packageName;
    private Integer packageSize;
    private String  linkUrl;
    private String  startTime;
    private String  endTime;
    private Integer  limit;
    private String  describe;
    private int  dayNum;
    private Integer  totalDayNum;
    private boolean  appBind;
    private Integer  adType;
    private boolean  shouldBlurImage;
    private String  downMethod;
    private String  openMethod;

}
