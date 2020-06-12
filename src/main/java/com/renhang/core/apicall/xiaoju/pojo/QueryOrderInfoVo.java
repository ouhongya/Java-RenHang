package com.renhang.core.apicall.xiaoju.pojo;

import lombok.Data;

@Data
public class QueryOrderInfoVo {
    private String outUserId;
    private String orderId;
    private String storeId;
    private String storeName;
    private String cityName;
    private String gunNo;
    private String itemName;
    private String quantity;
    private String totalMoney;
    private String realMoney;
    private String payStatus;
    private String payTime;
    private String refundStatus;
    private String refundTime;
}
