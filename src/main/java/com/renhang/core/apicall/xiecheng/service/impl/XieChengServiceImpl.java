package com.renhang.core.apicall.xiecheng.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.renhang.common.Utils.HttpClientUtils;
import com.renhang.core.apicall.xiecheng.pojo.OpenServiceAuthRes;
import com.renhang.core.apicall.xiecheng.pojo.OrderDetails;
import com.renhang.core.apicall.xiecheng.service.XieChengService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.TreeMap;


@Service
public class XieChengServiceImpl implements XieChengService {

    @Value("${xiecheng.AID}")
    private String AID;
    @Value("${xiecheng.SID}")
    private String SID;
    @Value("${xiecheng.KEY}")
    private String KEY;


    /**
     * 获取token
     * @return
     */
    @Override
    public OpenServiceAuthRes OpenServiceAuthauthorize() {
        String url = "https://openserviceauth.ctrip.com/OpenServiceAuth/authorize.ashx?AID="+AID+"&SID="+SID+"&KEY"+KEY;
        Map<String,String> map = new TreeMap<String,String>();
        map.put("AID",AID);
        map.put("SID",SID);
        map.put("KEY",KEY);
        String res = HttpClientUtils.doPost(url,map);
        OpenServiceAuthRes response = JSONObject.parseObject(res, OpenServiceAuthRes.class);
        return response;
    }

    /**
     * 刷新token
     * @return
     */
    @Override
    public OpenServiceAuthRes OpenServiceAuthRefresh(String token){
        String url = "https://openserviceauth.ctrip.com/OpenServiceAuth/refresh.ashx";
        Map<String,String> map = new TreeMap<String,String>();
        map.put("AID",AID);
        map.put("SID",SID);
        map.put("refresh_token",token);
        String res = HttpClientUtils.doPost(url, map);
        OpenServiceAuthRes response = JSONObject.parseObject(res, OpenServiceAuthRes.class);
        return response;
    }

    /**
     *  Proxy 服务
     * @param ICODE
     * @param UUID
     * @param Token
     * @param Mode
     * @param Format
     * @return
     */
    @Override
    public String OpenServiceProxy(String ICODE,String UUID,String Token, String Mode,String Format){
        String url = "Https://sopenservice.ctrip.com/OpenService/ServiceProxy.ashx";
        Map<String,String> map = new TreeMap<String,String>();
        map.put("AID",AID);
        map.put("SID",SID);
        map.put("ICODE",ICODE);
        map.put("UUID",UUID);
        map.put("Token",Token);
        map.put("mode",Mode);
        map.put("format",Format);
        String res = HttpClientUtils.doPost(url, map);
        return res;
    }

    /**
     * 订单详情查询接口
     * @param orderId
     * @return
     */
    @Override
    public OrderDetails OpenServiceOrderDetails(String orderId){
        String url = "Https://sopenservice.ctrip.com/OpenService/ServiceProxy.ashx";
        Map<String,String> map = new TreeMap<String,String>();
        map.put("AllianceID",AID);
        map.put("SID",SID);
        map.put("orderId",orderId);
        String res = HttpClientUtils.doPost(url, map);
        OrderDetails response = JSONObject.parseObject(res, OrderDetails.class);
        return response;
    }
}
