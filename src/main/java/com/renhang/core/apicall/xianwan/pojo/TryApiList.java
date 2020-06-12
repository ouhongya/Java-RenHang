package com.renhang.core.apicall.xianwan.pojo;

import lombok.Data;



@Data
public class TryApiList {
    //1 iPhone 2 安卓
    private String ptype;
    //IOS 忽略此参数 安卓操作系统版本号 如:安卓10对应的是参数：androidosv=29 （androidQ即安卓10对应androidosv=29）获取不到请传0
    private String androidosv;
    //IOS 忽略此参数 安全联盟OAID （未接入安全联盟请传空字符串“”）
    private String msaoaid;
    //设备号 android取IMEI; iphone取IDFA 获取不到请传 0
    private String deviceid;
    //渠道用户编号(app中 用户ID)唯一且不变
    private String appsign;
    //默认值 2 （2 ：表示已实现打开相册 scheme唤醒功能）
    private Integer xwversion;
    //广告类型 0：全部，-99:推荐，-98：简单广告，-97:有福利活动，1：益智 2：应用（已弃用）3：手游（不参与签名） 6：捕鱼
    private String adtype;
    //按广告名称查询（不参与签名）
    private String adname;
    //查询页，默认1（不参与签名）
    private String page;
    //页大小，默认200（不参与签名）
    private String  pagesize;
}
