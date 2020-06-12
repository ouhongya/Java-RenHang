package com.renhang.core.callback.xiaoju.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderDetail {
    private String id;
    private String outUserId;//第三方平台UserId
    private Long orderId;//3467771714635066313
    private Long storeId;//5105493875147414159
    private String storeName;//自动化测试门店4
    private String cityName;//杭州市
    private Integer gunNo;//枪号
    private String itemName;//92#
    private Long quantity;//商品升数1.2
    private Long totalMoney;//订单金额、单位是分800
    private Long realMoney;//实付 金额、单位是分800
    private Integer payStatus;//0未支付 1已支付1
    private String payTime;// 2019-11-28 07 03 50
    private Integer refundStatus;//0未退款 1已退款
    private String refundTime;   //未退款、无退款时间
    private Date createdTime;
}
