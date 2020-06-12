package com.renhang.core.callback.xiecheng.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class XieChenOrderCallbackVo {
    private String id;
    private String AllianceId;
    private String SID;
    private String OUID;
    private String OrderId;
    private String OrderStatus;
    private String OrderDescription;
    private String Amount;
    private String PayAmount;
    private String PayCurrency;
    private String BookingDate;
    private String BizCategory;
    private String statusupdatetime;
    private List<ItemInfos> itemInfos;
    private Date createdTime;
}
