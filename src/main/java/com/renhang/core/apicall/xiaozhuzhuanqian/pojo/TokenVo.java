package com.renhang.core.apicall.xiaozhuzhuanqian.pojo;

import lombok.Data;

@Data
public class TokenVo {
    //媒体ID
    private  Integer id;
    //媒体方用户UID
    private  Integer uid;
    //媒体方用户设备。iOS - IDFA；Android - IMEI（卡槽1）(安卓10以上系统使用UUID)
    private  String device;
    //媒体方用户设备。iOS - 空；Android - IMEI（卡槽2）(安卓10以上空)
    private  String device2;
    //媒体方用户设备类型。Android - 1；iOS - 2
    private  Integer phone;
}
