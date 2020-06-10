package com.renhang.core.apicall.xiaoju.pojo.queryStoreListVo;

import lombok.Data;

import java.util.List;

@Data
public class StoreInfoListVo {
    private String storeId;
    private String storeName;
    private String storeLogo;
    private String cityName;
    private String provinceName;
    private String address;
    private Float lon;
    private Float lat;
    private String brandName;
    private List<ItemInfoListVo> itemInfoList;
    private List<String> huiLabels;
}
