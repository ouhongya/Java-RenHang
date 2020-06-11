package com.renhang.core.apicall.kendeji.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.renhang.common.Utils.HttpClientUtils;
import com.renhang.common.Utils.SignUtils;
import com.renhang.core.apicall.kendeji.pojo.GetTokenVo;
import com.renhang.core.apicall.kendeji.pojo.KfcFrontendUrl;
import com.renhang.core.apicall.kendeji.pojo.KfcFrontendUrlVo;
import com.renhang.core.apicall.kendeji.pojo.PagedQuery;
import com.renhang.core.apicall.kendeji.service.KenDeJiService;
import com.renhang.core.callback.kendeji.pojo.KfcOrder;
import com.renhang.core.callback.kendeji.pojo.KfcOrderList;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.util.Map;
import java.util.TreeMap;

@Service
public class KenDeJiServiceImpl implements KenDeJiService {


    @Value("${kfc.secret}")
    private String secret;
    @Value("${kfc.id}")
    private String key;
    @Value("${kfc.url}")
    private String url;

    /**
     * 注册登录并跳转接口(没有手机号)
     *
     * @param platformUniqueId
     * @param nickname
     * @param redirectUrl
     * @return
     */
    @Override
    public String platformLogin(String platformUniqueId, String nickname, String redirectUrl) throws URISyntaxException {
        String requestUrl = url + "/api/v2/platform/login";
        Map<String, String> map = new TreeMap<>();
        map.put("platformUniqueId", platformUniqueId);
        map.put("nickname", nickname);
        map.put("platformId", key);
        map.put("timestamp", String.valueOf(System.currentTimeMillis()));
        map.put("redirectUrl", "");
        String sign = SignUtils.generateSign(map, secret);
        map.put("sign", sign);
        // 创建uri
        URIBuilder builder = new URIBuilder(requestUrl);
        for (String key : map.keySet()) {
            if (map.get(key) == null) {
                builder.addParameter(key, "");
            } else {
                builder.addParameter(key, map.get(key).toString());
            }
        }
        return builder.build().toString();
    }

    /**
     * 注册登录并跳转接口(有手机号)
     *
     * @param platformUniqueId
     * @param nickname
     * @param redirectUrl
     * @return
     */
    @Override
    public String platformLoginV2(String platformUniqueId, String nickname, String mobile, String redirectUrl) throws URISyntaxException {
        String requestUrl = url + "/api/v3/platform/login";
        Map<String, String> map = new TreeMap<>();
        map.put("platformUniqueId", platformUniqueId);
        map.put("nickname", nickname);
        map.put("mobile", mobile);
        map.put("platformId", key);
        map.put("timestamp", String.valueOf(System.currentTimeMillis()));
        map.put("redirectUrl", redirectUrl);
        String sign = SignUtils.generateSign(map, secret);
        map.put("sign", sign);
        // 创建uri
        URIBuilder builder = new URIBuilder(requestUrl);
        for (String key : map.keySet()) {
            if (map.get(key) == null) {
                builder.addParameter(key, "");
            } else {
                builder.addParameter(key, map.get(key).toString());
            }
        }
        return builder.build().toString();
    }

    /**
     * 查询订单
     * @param orderNo
     * @return
     */
    @Override
    public KfcOrder getByOrderNo(String orderNo) {
        String requestUrl = url + "/openApi/v1/kfcOrders/getByOrderNo";
        Map<String, String> map = new TreeMap<String, String>();
        map.put("platformId", key);
        map.put("orderNo", orderNo);
        map.put("timestamp", String.valueOf(System.currentTimeMillis()));
        map.put("sign", SignUtils.generateSign(map, secret));
        String jsonParams = JSONObject.toJSONString(map);
        String res = HttpClientUtils.doPostJson(requestUrl,jsonParams);
        KfcOrder orderVo = JSONObject.parseObject(res, KfcOrder.class);
        return orderVo;
    }

    /**
     * 批量查询订单
     *
     * @param orderNo
     * @return
     */
    @Override
    public  KfcOrderList listByBatchOrderNos(String orderNo) {
        String requestUrl = url + "/openApi/v1/kfcOrders/listByBatchOrderNos";
        Map<String, String> map = new TreeMap<String, String>();
        map.put("platformId", key);
        map.put("orderNos", orderNo);
        map.put("timestamp", String.valueOf(System.currentTimeMillis()));
        map.put("sign", SignUtils.generateSign(map, secret));
        String params = JSON.toJSONString(map);
        String res = HttpClientUtils.doPostJson(requestUrl, params);
        KfcOrderList orderVo = JSONObject.parseObject(res, KfcOrderList.class);
        return orderVo;
    }

    /**
     * 分页查询订单
     * @param pagedQuery
     * @return
     */
    @Override
    public KfcOrderList pagedQuery(PagedQuery pagedQuery) {
        String requestUrl = url + "/openApi/v1/kfcOrders/pagedQuery";
        Map<String, String> map = new TreeMap<String, String>();
        map.put("pageSize", pagedQuery.getPageSize().toString());
        map.put("pageIndex", pagedQuery.getPageIndex().toString());
        map.put("updateTimeBeginTime", pagedQuery.getUpdateTimeBeginTime());
        map.put("updateTimeEndTime", pagedQuery.getUpdateTimeEndTime());
        map.put("platformId", key);
        map.put("timestamp", String.valueOf(System.currentTimeMillis()));
        map.put("sign", SignUtils.generateSign(map, secret));
        String params = JSON.toJSONString(map);
        String res = HttpClientUtils.doPostJson(requestUrl, params);
        KfcOrderList orderVo = JSONObject.parseObject(res, KfcOrderList.class);
        return orderVo;
    }

    /**
     * 注册登录接口(没有手机号)
     * @param platformUniqueId
     * @param nickname
     * @return
     * @throws URISyntaxException
     */
    @Override
    public GetTokenVo getTokenVoV1(String platformUniqueId, String nickname){
        String requestUrl = url + "/api/v1/platform/getToken";
        Map<String, String> map = new TreeMap<>();
        map.put("platformUniqueId", platformUniqueId);
        map.put("nickname", nickname);
        map.put("platformId", key);
        map.put("timestamp", String.valueOf(System.currentTimeMillis()));
        String sign = SignUtils.generateSign(map, secret);
        map.put("sign", sign);
        // 创建uri
        String res = HttpClientUtils.doGetStr(requestUrl, map);
        GetTokenVo tokenVo = JSONObject.parseObject(res, GetTokenVo.class);
        return  tokenVo;
    }

    /**
     * 注册登录接口(有手机号)
     * @param platformUniqueId
     * @param nickname
     * @return
     * @throws URISyntaxException
     */
    @Override
    public GetTokenVo getTokenVoV2(String platformUniqueId, String nickname,String mobile){
        String requestUrl = url + "/api/v2/platform/getToken";
        Map<String, String> map = new TreeMap<>();
        map.put("platformUniqueId", platformUniqueId);
        map.put("nickname", nickname);
        map.put("mobile",mobile);
        map.put("platformId", key);
        map.put("timestamp", String.valueOf(System.currentTimeMillis()));
        String sign = SignUtils.generateSign(map, secret);
        map.put("sign", sign);
        // 创建uri
        String res = HttpClientUtils.doGetStr(requestUrl, map);
        GetTokenVo tokenVo = JSONObject.parseObject(res, GetTokenVo.class);
        return  tokenVo;
    }

    /**
     * 获取各个前端页面的URL
     * @return
     * @throws URISyntaxException
     */
    @Override
    public KfcFrontendUrlVo getKfcFrontendUrl() {
        String requestUrl = url + "/openApi/v1/url/getKfcFrontendUrl";
        Map<String, String> map = new TreeMap<>();
        map.put("platformId", key);
        map.put("timestamp", String.valueOf(System.currentTimeMillis()));
        String sign = SignUtils.generateSign(map, secret);
        map.put("sign", sign);
        String params = JSON.toJSONString(map);
        String res = HttpClientUtils.doPostJson(requestUrl, params);
        KfcFrontendUrlVo url = JSONObject.parseObject(res, KfcFrontendUrlVo.class);
        return  url;
    }
}
