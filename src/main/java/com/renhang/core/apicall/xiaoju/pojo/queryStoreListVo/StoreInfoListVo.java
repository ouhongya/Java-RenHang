package com.renhang.core.apicall.xiaoju.pojo.queryStoreListVo;

import lombok.Data;

import java.util.List;

@Data
public class StoreInfoListVo {
    /**
     * "data": {
     *    "pageIndex": 1,
     *    "pageSize": 5,
     *    "totalSize": 98,
     *    "storeInfoList": [
     *     {
     *        "storeId": "5131588228085193415",//油站ID
     *        "storeName": "合同优化门店1",
     *        "storeLogo": "http://10.90.28.42:8052/static/anything/b57f62fc-e845-4c2a-9bfa-28bd4d76a845.png",
     *        "cityName": "杭州市",
     * 			 "provinceName": "浙江省",
     *        "address": "西溪水岸花苑",
     *        "lon": 120.04969,//Float类型
     *        "lat": 30.28198,//Float类型
     * 			 "brandName":"中国石化",//品牌名称
     *        "itemInfoList": [
     *         {
     *            "itemName": "95#",
     *            "cityPrice": 790, //单位是分
     *            "storePrice": 780
     *         }
     *       ],
     * 			"huiLabels":[
     * 					"壳牌净擎汽油，清洁积碳，一路畅行"
     * 			]
     *     },
     *     {
     *        "storeId": "5131634411818195846",
     *        "storeName": "专用门店测试",
     *        "storeLogo": "http://10.90.28.42:8052/static/anything/b57f62fc-e845-4c2a-9bfa-28bd4d76a845.png",
     *        "cityName": "杭州市",
     * 			 "provinceName": "浙江省",
     *        "address": "余杭区九橙创投中心",
     * 			 "brandName":"中国石油",//品牌名称
     *        "lon": 116.290276,
     *        "lat": 40.043476,
     *        "itemInfoList": [
     *         {
     *            "itemName": "92#",
     *            "cityPrice": 690, //单位是分
     *            "storePrice": 680 //单位是分
     *         }
     *       ],
     * 			"huiLabels":[
     * 					"加油送免费洗车、免费加玻璃水服务"
     * 			]
     *     }
     *   ]
     * }
     */
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
