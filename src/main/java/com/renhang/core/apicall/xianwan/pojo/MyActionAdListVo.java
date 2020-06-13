package com.renhang.core.apicall.xianwan.pojo;

import lombok.Data;

@Data
public class MyActionAdListVo {
    /**
     * 	1 iPhone 2 安卓
     */
    private String  ptype;
    /**
     * IOS 忽略此参数 安卓操作系统版本号 如:29 、28 （android Q 对应 29）获取不到请传0
     */
    private String androidosv;
    /**
     * IOS 忽略此参数 安全联盟OAID （未接入安全联盟请传空字符串“”）
     *     private String appid	是	string	渠道id （由闲玩分配）
     */
    private String msaoaid;
    /**
     * 设备号 android取IMEI; iphone取IDFA 获取不到请传 0
     */
    private String deviceid;
    /**
     * 渠道用户编号(app中 用户ID) 唯一且不变
     */
    private String appsign;
    /**
     * 默认值 2 （2 ：表示已实现打开相册 scheme唤醒功能）
     */
    private String xwversion;
    /**
     * 广告类型 0：全部，-99:推荐，-98：简单广告，-97:有福利活动，1：益智 2：应用（已弃用）3：手游（不参与签名） 6：捕鱼
     */
    private String adtype;
    /**
     * 排序 0：默认 1 根据用户参与的广告最后领取时间降序 2 根据广告即将到期时间升序
     */
    private String orderby;
    /**查询页，默认1（不参与签名）
     *
     */
    private String page;
    /**
     * 	页大小，默认6条（不参与签名）
     */
    private String pagesize;
}
