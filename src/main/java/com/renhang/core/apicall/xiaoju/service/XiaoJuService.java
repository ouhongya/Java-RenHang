package com.renhang.core.apicall.xiaoju.service;

import com.renhang.core.apicall.xiaoju.pojo.*;

public interface XiaoJuService {

    String queryToken() throws Exception;

    QueryStoreListData queryStoreList(Integer pageIndex,Integer pageSize) throws Exception;

    QueryStorePriceData queryStorePrice(String lon,String lat,String openChannel,String itemName,String[] storeIdLists) throws Exception;

    QueryOrderInfoVo queryOrderInfo(String orderId) throws Exception;

    QueryEnergyUrlVo queryEnergyUrl(String lon,String lat,String mobile,String outUserId,String storeId,String itemName) throws Exception;

    QueryOrderListVo queryOrderList(Integer pageIndex,Integer pageSize,String queryEndTime,String queryStartTime) throws Exception;
}
