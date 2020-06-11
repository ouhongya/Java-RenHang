package com.renhang.core.callback.xiecheng.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class XieChenOrderCallbackVo {
    private Integer AllianceId;
    private Integer SID;
    private String OUID;
    private long OrderId;
    private String OrderStatus;
    private String OrderDescription;
    private BigDecimal Amount;
    private String PayCurrency;
    private Date BookingDate;
    private String BizCategory;
    private Date statusupdatetime;
    private ItemInfos itemInfos;
    @Data
    class ItemInfos{
        private String ordername;
        private Date startdatetime;
        private Date enddatetime;
    }
}
