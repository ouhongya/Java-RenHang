package com.renhang.core.apicall.xiecheng.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderDetails {
    private List<Orders> orders;
    private Result Result;
    private ResponseStatus ResponseStatus;
    @Data
    class Orders {
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
