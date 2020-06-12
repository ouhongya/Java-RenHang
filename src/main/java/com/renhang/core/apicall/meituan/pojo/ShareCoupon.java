package com.renhang.core.apicall.meituan.pojo;

import lombok.Data;

@Data
public class ShareCoupon {
    //渠道 ID
    private String utmSource;
    //子媒体 ID
    private String utmMedium;
    //渠道生成
    private String access_toke;
    //渠道生成
    private String timestamp;
    //渠道生成
    private String requestId;
    //外卖活动id-商务给出
    private String activity;
}
