package com.renhang.core.apicall.xiaoju.pojo.queryStoreListVo;

import lombok.Data;

@Data
public class ItemInfoListVo {
    private String itemName;
    //金额分
    private Long cityPrice;
    private Long storePrice;
}
