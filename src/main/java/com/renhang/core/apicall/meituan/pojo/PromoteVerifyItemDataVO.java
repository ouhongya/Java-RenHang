package com.renhang.core.apicall.meituan.pojo;

import lombok.Data;

@Data
public class PromoteVerifyItemDataVO {
    //核验时间，时间格式：yyyy-MM-dd HH:mm:ss
   private  String verifyTime;
    //唯⼀⼦订单Id建议使⽤
    private  Long uniqueItemId;
    //⼦订单Id, 不再建议使⽤
    private  Long itemId;
    //⽀付时间，时间格式：yyyy-MM-dd HH:mm:ss
    private  String orderPayTime;
    //订单号
    private  String orderId;
    //⼦订单实际⽀付价格，单位元，保留两位⼩数
    private  String actualItemAmount;
    //订单实际⽀付总价格，单位元，保留两位⼩数
    private  String actualOrderAmount;
    //商户Id
    private  Integer shopId;
    //商户名称
    private  String shopName;
    //城市名称
    private  String cityName;
    //⼀级⾏业
    private  String cat0Name;
    //⼆级⾏业
    private  String cat1Name;
    //订单类型
    private  String orderType;
    //抵⽤券Id
    private  String couponId;
    //券组Id
    private  Integer couponGroupId;
    //抵⽤券满减⾦额单位元保留两位⼩数
    private  String couponDiscountAmount;
    //抵⽤券⻔槛单位元保留两位⼩数
    private  String couponPriceLimit;
    //佣⾦⾦额单位元
    private  String balanceAmount;
    //佣⾦⽐例
    private  String balanceCommissionRatio;
    //⼦订单状态返回codecode详情⻅ItemStatus枚举信息  CODE 0 未使⽤：已经购买，但是并未到店核验  CODE 1 已使⽤：已经购买且已到店核验 CODE 2 退款中：该⼦订单正在发⽣退款⾏为  CODE 3 已退款：该⼦订单退款已完成 CODE 5 已消费退款：到店核销后，发⽣退款⾏为
    private  Integer itemStatus;
    //⼦订单结算，返回code，code详情⻅BalanceStatus枚举信息    CODE 1 已结算：⼦订单已经核验并且完成结算流程可以结算   CODE 2 待结算：⼦订单已经完成核验，正在进⾏结算流程，是中间态  CODE 99 ⽆需结算：⼦订单已经完成核验，没有通过结算标准，⽆需结算
    private  Integer balanceStatus;
    //点评 美团
    private  String orderPlatform;
    //⽤户Id，需脱敏处理
    private  String orderUserId;
    //额外信息，JSON结构，⽬前存储⽆需结算原因
    private  String extraInfo;
    //订单状态(聚合),详情⻅ ItemBizStatusEnum    //CODE 1 ⽀付成功,表示订单已经完成⽀付  CODE 2 核销成功，表示订单已经到店核验  CODE 3 结算成功，标识订单已经完成结算，会有佣⾦  CODE 99⽆效订单：标识订单⽆需结算，会有结算失败理由  CODE 999未知状态：异常订单，正常情况下不会出现该状态
    private  Integer itemBizStatus;
    //结算时间，时间格式：yyyy-MM-dd HH:mm:ss
    private  String settleTime;
    //⻔店头图可能会缺失
    private  String shopImage;
    //媒体Code
    private  Long utmSource;
    //⼦媒体信息如配置加密则需使⽤AES解密
    private  String utmMedium;
    //最新更改时间，时间格式：yyyy-MM-dd HH:mm:ss
    private  String modifyTime;
}
