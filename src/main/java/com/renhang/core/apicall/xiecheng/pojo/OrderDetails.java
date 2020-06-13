package com.renhang.core.apicall.xiecheng.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderDetails {
    /**
     * 用户订单
     */
    private List<Orders> orders;
    /**
     *请求执行结果
     */
    private Result Result;
    /**
     * 请求执行结果
     */
    private ResponseStatus ResponseStatus;
    @Data
    class Orders {
        /**
         * OrderID Y long 订单号
         * SourceOrderID N string 来源订单号
         * BizType Y string 业务类型，同请求体 OrderType
         * OrderType N string 订单类型，以 BizType 为准
         * Amount Y double 订单下单金额
         * ActualAmount Y double 订单成交金额
         * Currency Y string 货币种类
         * AmountByCurrency N double 货币对应的金额
         * Discount N decimal 折扣
         * CreatedTime Y dateTime 订单预定时间
         * OperateTime Y dateTime 订单最后修改时间
         * CompletedTime Y dateTime 订单完成时间
         * UsedTime N dateTime 订单使用时间
         * Remark N string 备注
         * OrderBasicInfo Y OrderItemBa
         * sicInfo
         * 订单项列表
         * ExpiredTime Y dateTime 过期时间
         * 团购：过期时间
         * 当地活动：最晚使用时间
         * Channels N string 订单渠道
         * H5、App、Online
         */
        private Integer OrderID;
        private String SourceOrderID;
        private String BizType;
        private String OrderType;
        private BigDecimal Amount;
        private BigDecimal ActualAmount;
        private String Currency;
        private Integer AmountByCurrency;
        private BigDecimal Discount;
        private String CreatedTime;
        private String OperateTime;
        private String CompletedTime;
        private String UsedTime;
        private String Remark;
        private List<OrderBasicInfo> OrderBasicInfo;
        private String ExpiredTime;
        private List<String> Channels;

        @Data
        class OrderBasicInfo {
            /**
             * ItemID Y long 订单项编号
             * BizType Y string 业务类型
             * ProductID N string 产品ID.
             * ProductType N string 产品类型(酒店为售卖房型英文名)
             * ProductNameCN N string 产品中文名
             * 携程旅行网-开放平台-API 文档
             * ProductNameEN N string 产品英文名
             * Description N string 产品描述
             * ProviderName N string 产品供应商名称
             * Price Y double 价格
             * Quantity N int 数量
             * FromLocation N string 出发地
             * ToLocation N string 目的地
             * StartDateTime N dateTime 出发时间
             * EndDateTime N dateTime 到达时间
             * FlightWay N string 行程名称.(机票：单程、往返、联程)
             * LastArrivalTime N dateTime 最晚到达时间.(酒店：非凌晨入住最晚到店时间)
             * MorningLastArrivalTime N dateTime 酒店：凌晨入住最晚到店时间
             * ProductCategory N string 产品种类
             * FromAddressInfo N AddressInfo 出发地址信息
             * ToAddressInfo N AddressInfo 到达地址信息
             * ItemStatus N string 订单子项状态
             * ImageURL N string 产品图片URL
             */
            private Integer ItemID;
            private String BizType;
            private String ProductID;
            private String ProductNameCN;
            private String Description;
            private BigDecimal Price;
            private Integer Quantity;
            private String FromLocation;
            private String ToLocation;
            private String StartDateTime;
            private String EndDateTime;
            private String LastArrivalTime;
            private String MorningLastArrivalTime;
            private FromAddressInfo FromAddressInfo;
            private ToAddressInfo ToAddressInfo;

            @Data
            class FromAddressInfo {
                private String CityCode;
                private String CityName;
            }

            @Data
            class ToAddressInfo {
                private String CityCode;
                private String CityName;
            }
        }
    }

    @Data
    class Result {
        private Integer Code;
        private String Description;
    }

    @Data
    class ResponseStatus {
        private String Timestamp;
        private String Ack;
        private List<String> Errors;

        @Data
        class Extension {
            private String Id;
            private String Value;
        }
    }
}
