package com.renhang.core.apicall.xiaoju.pojo;

import lombok.Data;

/**
 * {
 *    "outUserId": "out123456789",//第三方平台UserId
 *    "orderId": "3467771714635066313",
 *    "storeId": "5105493875147414159",
 *    "storeName": "自动化测试门店4",
 *    "cityName": "杭州市",
 *    "gunNo": "2",//枪号
 *    "itemName": "92#",
 *    "quantity": 1.2,//商品升数
 *    "totalMoney": 800,//订单金额、单位是分
 *    "realMoney": 800,//实付金额、单位是分
 *    "payStatus": 1,//0未支付 1已支付
 *    "payTime": "2019-11-28 07:03:50",
 *    "refundStatus": 0,//0未退款 1已退款
 *    "refundTime": null //未退款、无退款时间
 * }
 */
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
