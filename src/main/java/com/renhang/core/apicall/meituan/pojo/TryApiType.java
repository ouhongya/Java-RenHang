package com.renhang.core.apicall.meituan.pojo;

import lombok.Data;

@Data
public class TryApiType {
    //请求Id，媒体⽅⽣成，不超过32位
    private  String requestId;
    //媒体code，对接时由美团侧⽣成
    private  String utmSource;
    //版本,默认：2.0
    private  String version;
    //鉴权信息
    private  String accessToken;
    //时间戳，精确到秒或毫秒
    private  Long timestamp;






}
