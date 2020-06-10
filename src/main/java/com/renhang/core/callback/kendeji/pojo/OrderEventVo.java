package com.renhang.core.callback.kendeji.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderEventVo {

    /**
     * 主键
     */
    private String id;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 事件类型
     */
    private Integer eventType;

    /**
     * 平台id
     */
    private Integer platformId;

    /**
     * 平台 固定为 qianzhu
     */
    private String platform;

    /**
     * 签名
     */
    private String sign;

    /**
     * data
     */
    private OrderEventData data;

    @Getter
    @Setter
    @Accessors(chain = true)
    @ToString
    public static class OrderEventData{

        /**
         * 取消原因
         */
        private String cancelReason;

        /**
         * 取消的商品
         */
        private String cancelProducts;

        /**
         * 退款金额
         */
        private BigDecimal  refundAmount;

        /**
         * 退款时间
         */
        private String refundTime;
    }
}
