package com.renhang.core.apicall.xianwantask.pojo;

import lombok.Data;


@Data
public class TryApiList {
    //渠道id （由闲玩分配）
    private String appid;
    //渠道id （由闲玩分配）
    private String appsecret;
    //渠道用户编号(app中 用户ID)唯一且不变
    private String appsign;
    //1 iPhone 2 安卓
    private String ptype;
    //设备号 android取IMEI; iphone取IDFA 获取不到请传 0
    private String deviceid;
    //IOS 忽略此参数 安全联盟OAID （未接入安全联盟请传空字符串“”）
    private String msaoaid;
    //IOS 忽略此参数 安卓操作系统版本号 如:安卓10对应的是参数：androidosv=29 （androidQ即安卓10对应androidosv=29）获取不到请传0
    private String androidosv;
    //加密校验 MD5(appid+deviceid+msaoaid+androidosv+ptype+appsign+appsecret)
    private String keycode;
    //传 0：全部 1：正在参与
    private Integer adListType;
    //广告类型 0全部(默认) ；10下载任务； 11免下载任务； 12问卷任务
    private Integer adType;
    //排序方式 0：默认排序，1最近体验，2即将到期 ，3最新上架, 4随机排序
    private Integer sortType;
    //按广告名称查询
    private String adName;
    //按标签查询
    private String tag;
    //按广告开始时间查询 格式 yyyy-MM-dd HH:mm:ss
    private String startTime;
    //按任务类型查询 0全部；1截图任务；2非截图任务
    private Integer taskType;
    //用户年龄
    private Integer age;
    //用户IP地址
    private String userIp;
    //查询页，默认1（不参与签名）
    private String page;
    //页大小，默认200（不参与签名）
    private String  pagesize;

}
