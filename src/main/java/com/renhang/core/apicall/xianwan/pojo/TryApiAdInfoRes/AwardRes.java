package com.renhang.core.apicall.xianwan.pojo.TryApiAdInfoRes;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AwardRes {
    private Integer num;
    private Integer dlevel;
    private Integer needlevel;
    private String event;
    private String progress;
    private boolean progressType;
    private BigDecimal money;
    private String unit;
    private String groupname;
}
