package com.renhang.core.apicall.xiaoju.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.renhang.common.Utils.GlobalUtils;
import com.renhang.common.Utils.HttpClientUtils;
import com.renhang.common.Utils.SecurityUtil;
import com.renhang.core.apicall.xiaoju.pojo.*;
import com.renhang.core.apicall.xiaoju.service.XiaoJuService;
import com.renhang.core.callback.xiaoju.pojo.QueryResponseVo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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
    public String queryToken() throws Exception {
        String str = "http://epower-openapi.xiaojukeji.com/energy/v1";
        Map<String,Object> map = new HashMap<>();
        map.put("appSecret",appSecret);
        String originRequestDataJsonStr = JSON.toJSONString(map);
        map.put("appKey",appKey);
        String data = SecurityUtil.encrypt(originRequestDataJsonStr, dataSecret, dataSecret);
        map.put("data",data );
        String timestamp = GlobalUtils.format();
        map.put("timeStamp",timestamp);
        String requestSignStr = SecurityUtil.signRequest(appKey, sigSecret, data, String.valueOf(timestamp));
        map.put("sig",requestSignStr);
        String jsonString = JSON.toJSONString(map);
        String json = HttpClientUtils.doPostJson(str,jsonString);
        QueryResponseVo queryResponseVo = JSONObject.parseObject(json, QueryResponseVo.class);
        //解密后的数据
        String response = SecurityUtil.decrypt(queryResponseVo.getData(), dataSecret, dataSecret);
        return response;
    }

    /**
     * 油站列表查询
     *
     * @return
     */
    @Override
    public QueryStoreListData queryStoreList(Integer pageIndex,Integer pageSize) throws Exception {
        String str = "http://epower-openapi.xiaojukeji.com/energy/v1/";
        Map<String,Object> map = new HashMap<>();
        map.put("pageIndex",pageIndex);
        map.put("pageSize",pageSize);
        String originRequestDataJsonStr = JSON.toJSONString(map);
        map.put("appKey",appKey);
        String data = SecurityUtil.encrypt(originRequestDataJsonStr, dataSecret, dataSecret);
        map.put("data",data );
        String timestamp = GlobalUtils.format();
        map.put("timeStamp",timestamp);
        String requestSignStr = SecurityUtil.signRequest(appKey, sigSecret, data, String.valueOf(timestamp));
        map.put("sig",requestSignStr);
        String json = HttpClientUtils.doPostJson(str, JSON.toJSONString(map));
        QueryResponseVo queryResponseVo = JSONObject.parseObject(json, QueryResponseVo.class);
        //解密后的数据
        String response = SecurityUtil.decrypt(queryResponseVo.getData(), dataSecret, dataSecret);
        QueryStoreListData queryStoreListData = JSONObject.parseObject(response, QueryStoreListData.class);
        return queryStoreListData;
    }

    /**
     * 油站实时价格批量查询
     *
     * @return
     */
    @Override
    public QueryStorePriceData queryStorePrice(String lon,String lat,String openChannel,String itemName,String[] storeIdLists) throws Exception {
        String str = "http://epower-openapi.xiaojukeji.com/energy/v1/";
        Map<String,Object> map = new HashMap<>();
        map.put("lon",lon);
        map.put("lat",lat);
        map.put("openChannel",openChannel);
        map.put("itemName",itemName);
        map.put("storeIdList",storeIdLists);
        String originRequestDataJsonStr = JSON.toJSONString(map);
        map.put("appKey",appKey);
        String data = SecurityUtil.encrypt(originRequestDataJsonStr, dataSecret, dataSecret);
        map.put("data",data );
        String timestamp = GlobalUtils.format();
        map.put("timeStamp",timestamp);
        String requestSignStr = SecurityUtil.signRequest(appKey, sigSecret, data, String.valueOf(timestamp));
        map.put("sig",requestSignStr);
        String json = HttpClientUtils.doPostJson(str, JSON.toJSONString(map));
        QueryResponseVo queryResponseVo = JSONObject.parseObject(json, QueryResponseVo.class);
        //解密后的数据
        String response = SecurityUtil.decrypt(queryResponseVo.getData(), dataSecret, dataSecret);
        QueryStorePriceData queryStoreListData = JSONObject.parseObject(response, QueryStorePriceData.class);
        return queryStoreListData;
    }

    /**
     * 订单查询
     *
     * @return
     */
    @Override
    public QueryOrderInfoVo queryOrderInfo(String orderId) throws Exception {
        String str = "http://epower-openapi.xiaojukeji.com/energy/v1/";
        Map<String,Object> map = new HashMap<>();
        map.put("orderId",orderId);
        String originRequestDataJsonStr = JSON.toJSONString(map);
        map.put("appKey",appKey);
        String data = SecurityUtil.encrypt(originRequestDataJsonStr, dataSecret, dataSecret);
        map.put("data",data );
        String timestamp = GlobalUtils.format();
        map.put("timeStamp",timestamp);
        String requestSignStr = SecurityUtil.signRequest(appKey, sigSecret, data, String.valueOf(timestamp));
        map.put("sig",requestSignStr);
        String json = HttpClientUtils.doPostJson(str, JSON.toJSONString(map));
        QueryResponseVo queryResponseVo = JSONObject.parseObject(json, QueryResponseVo.class);
        //解密后的数据
        String response = SecurityUtil.decrypt(queryResponseVo.getData(), dataSecret, dataSecret);
        QueryOrderInfoVo queryOrderInfoVo = JSONObject.parseObject(response, QueryOrderInfoVo.class);
        return queryOrderInfoVo;
    }

    /**
     * 跳转地址查询
     *
     * @return
     */
    @Override
    public QueryEnergyUrlVo queryEnergyUrl(String lon,String lat,String mobile,String outUserId,String storeId,String itemName) throws Exception {
        String str = "http://epower-openapi.xiaojukeji.com/energy/v1/";
        Map<String,Object> map = new HashMap<>();
        map.put("lon",lon);
        map.put("lat",lat);
        map.put("openChannel",1);
        map.put("mobile",mobile);
        map.put("outUserId",outUserId);
        map.put("storeId",storeId);
        map.put("itemName",itemName);
        String originRequestDataJsonStr = JSON.toJSONString(map);
        map.put("appKey",appKey);
        String data = SecurityUtil.encrypt(originRequestDataJsonStr, dataSecret, dataSecret);
        map.put("data",data );
        String timestamp = GlobalUtils.format();
        map.put("timeStamp",timestamp);
        String requestSignStr = SecurityUtil.signRequest(appKey, sigSecret, data, String.valueOf(timestamp));
        map.put("sig",requestSignStr);
        String json = HttpClientUtils.doPostJson(str, JSON.toJSONString(map));
        QueryResponseVo queryResponseVo = JSONObject.parseObject(json, QueryResponseVo.class);
        //解密后的数据
        String response = SecurityUtil.decrypt(queryResponseVo.getData(), dataSecret, dataSecret);
        QueryEnergyUrlVo queryOrderInfoVo = JSONObject.parseObject(response, QueryEnergyUrlVo.class);
        return queryOrderInfoVo;
    }

    /**
     * 订单批量查询
     * @return
     */
    @Override
    public QueryOrderListVo queryOrderList(Integer pageIndex,Integer pageSize,String queryEndTime,String queryStartTime) throws Exception {
        String str = "http://epower-openapi.xiaojukeji.com/energy/v1/";
        Map<String,Object> map = new HashMap<>();
        map.put("pageIndex",pageIndex);
        map.put("pageSize",pageSize);
        map.put("queryEndTime",queryEndTime);
        map.put("queryStartTime",queryStartTime);
        String originRequestDataJsonStr = JSON.toJSONString(map);
        map.put("appKey",appKey);
        String data = SecurityUtil.encrypt(originRequestDataJsonStr, dataSecret, dataSecret);
        map.put("data",data );
        String timestamp = GlobalUtils.format();
        map.put("timeStamp",timestamp);
        String requestSignStr = SecurityUtil.signRequest(appKey, sigSecret, data, String.valueOf(timestamp));
        map.put("sig",requestSignStr);
        String json = HttpClientUtils.doPostJson(str, JSON.toJSONString(map));
        QueryResponseVo queryResponseVo = JSONObject.parseObject(json, QueryResponseVo.class);
        //解密后的数据
        String response = SecurityUtil.decrypt(queryResponseVo.getData(), dataSecret, dataSecret);
        QueryOrderListVo queryOrderInfoVo = JSONObject.parseObject(response, QueryOrderListVo.class);
        return queryOrderInfoVo;
    }
}
