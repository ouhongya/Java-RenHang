package com.renhang.core.apicall.xiaoju.pojo;

import lombok.Data;

@Data
public class ItemInfoListVo {

    private String storeId;
    private String itemName;
    //挂牌价，单位是分
    private Long storePrice;
    //小桔价，单位是分
    private Long vipPrice;
    //发改委价，单位是分
    private Long cityPrice;
}
