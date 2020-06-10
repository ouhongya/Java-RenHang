package com.renhang.core.apicall.xiaoju.service;

import com.renhang.core.apicall.xiaoju.pojo.QueryEnergyUrlVo;
import com.renhang.core.apicall.xiaoju.pojo.QueryOrderInfoVo;
import com.renhang.core.apicall.xiaoju.pojo.QueryOrderListVo;
import com.renhang.core.apicall.xiaoju.pojo.QueryStoreListData;

public interface XiaoJuService {

    String queryToken();

    QueryStoreListData queryStoreList();

    QueryStoreListData queryStorePrice();

    QueryOrderInfoVo queryOrderInfo();

    QueryEnergyUrlVo queryEnergyUrl();

    QueryOrderListVo queryOrderList();
}
