package com.renhang.core.callback.kendeji.pojo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 肯德基订单 model
 *
 * @author xuyanjun
 * @date 2020/4/10
 */
@Getter
@Setter
@ToString
public class KfcOrderVo implements Serializable {

    /**
     * 主键
     */
    private String id;
    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 最后更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 订单状态
     */
    private Integer status;

    /**
     * 订单状态描述
     */
    private String statusDesc;

    /**
     * 单价(元)
     */
    private BigDecimal unitPrice;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 总价(元)
     */
    private BigDecimal totalPrice;

    /**
     * 支付时间
     */
    private LocalDateTime paymentTime;

    /**
     * 支付金额(元)
     */
    private BigDecimal amount;

    /**
     * 佣金(元),此字段在交易完成时才会有值
     */
    private BigDecimal commissionPrice;

    /**
     * 退款金额(元)
     */
    private BigDecimal refundPrice;

    /**
     * 出票时间
     */
    private LocalDateTime drawTime;

    /**
     * 取餐码
     */
    private String ticket;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户备注
     */
    private String userRemark;

    /**
     * 用户的电话号码
     */
    private String userMobile;

    /**
     * 平台用户唯一信息
     */
    private String platformUniqueId;

    /**
     * 订单取消时间
     */
    private LocalDateTime cancelTime;

    /**
     * 下单手机后4位（非用户手机号）
     */
    private String kfcOrderMobileSuffix;

    /**
     *下单手机备注）
     */
    private String kfcOrderMobileRemark;


    /**
     * 下单信息
     */
    private KfcPlaceOrderVo kfcPlaceOrder;
}
