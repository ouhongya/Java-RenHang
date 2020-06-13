package com.renhang.core.apicall.meituan.pojo;

import lombok.Data;

import java.util.List;

@Data
public class TryApiList {
    //请求Id，媒体⽅⽣成，不超过32位
    private  String requestId;
//    //媒体code，对接时由美团侧⽣成
//    private  String utmSource;
    //版本,默认：2.0
    private  String version;
//    //鉴权信息
//    private  String accessToken;
//    //时间戳，精确到秒或毫秒
//    private  Long timestamp;


    //订单核验起始⽇期⽀持⽇期与时间格式⽇期：2019-05-08 时间：2019-05-08 00:00:00
    private String startVerifyDate;
    //订单核验结束⽇期，⽀持⽇期与时间格式。⽇期：2019-05-08 时间：2019-05-08 23:59:59
    private String endVerifyDate;
    //订单新增起始⽇期仅⽀持⽇期格式⽇期：2019-05-08
    private String startAddDate;
    //订单新增结束⽇期仅⽀持⽇期格式 ⽇期：2019-05-08
    private String endAddDate;
    //订单最后更新起始⽇期，⽀持⽇期与时间格式。⽇期：2019-05-08 时间：2019-05-08 00:00:00
    private String startModifyDate;
    //订单最后更新结束⽇期，⽀持⽇期与时间格式。⽇期：2019-05-08 时间：2019-05-08 23:59:59
    private String endModifyDate;
    //唯⼀⼦订单Id每次查询限制100个
    private List<Long> uniqueItemIds;
    //C端展示订单Id,每次查询限制100个
    private List<String> viewOrderIds;
    //订单查询时间区间类型，详⻅下⽅QueryTypeEnum    CODE 1  按照⼦订单⽀付时间查询  CODE 2  按照⼦订单核验时间查询（注: 等同于startVerifyDate和endVerifyDate查询，切勿混⽤） CODE 3  按照⼦订单结算时间查询
    private Integer queryType;
    //订单查询开始时间（注: 配置queryType使⽤才会⽣效）
    private String startTime;
    //订单查询结束时间（注: 配置queryType使⽤才会⽣效）
    private String endTime;
    //⻚数，从1开始
    private  Integer  page;
    //每⻚数据
    private  Integer size;
}
