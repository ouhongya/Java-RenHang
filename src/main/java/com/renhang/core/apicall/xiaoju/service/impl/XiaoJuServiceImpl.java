package com.renhang.core.apicall.xiaoju.service.impl;

import com.renhang.core.apicall.xiaoju.pojo.QueryEnergyUrlVo;
import com.renhang.core.apicall.xiaoju.pojo.QueryOrderInfoVo;
import com.renhang.core.apicall.xiaoju.pojo.QueryOrderListVo;
import com.renhang.core.apicall.xiaoju.pojo.QueryStoreListData;
import com.renhang.core.apicall.xiaoju.service.XiaoJuService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class XiaoJuServiceImpl implements XiaoJuService {

    @Value("${origin.appKey}")
    private String appKey;
    @Value("${origin.appSecret}")
    private String appSecret;
    @Value("${origin.dataSecret}")
    private String dataSecret;
    @Value("${origin.sigSecret}")
    private String sigSecret;

    /**
     * Token查询
     *
     * @return
     */
    @Override
    public String queryToken() {
        String str = "http://epower-openapi.xiaojukeji.com/energy/v1/";

        return null;
    }

    /**
     * 油站列表查询
     *
     * @return
     */
    @Override
    public QueryStoreListData queryStoreList() {
        return null;
    }

    /**
     * 油站实时价格批量查询
     *
     * @return
     */
    @Override
    public QueryStoreListData queryStorePrice() {
        return null;
    }

    /**
     * 订单查询
     *
     * @return
     */
    @Override
    public QueryOrderInfoVo queryOrderInfo() {
        return null;
    }

    /**
     * 跳转地址查询
     *
     * @return
     */
    @Override
    public QueryEnergyUrlVo queryEnergyUrl() {
        return null;
    }

    /**
     * 订单批量查询
     * @return
     */
    @Override
    public QueryOrderListVo queryOrderList() {
        return null;
    }


}
