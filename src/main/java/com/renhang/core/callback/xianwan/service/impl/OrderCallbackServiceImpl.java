package com.renhang.core.callback.xianwan.service.impl;

import com.renhang.common.Utils.GlobalUtils;
import com.renhang.common.Utils.MD5;
import com.renhang.core.callback.xianwan.mapper.OrderCallbackMapper;
import com.renhang.core.callback.xianwan.pojo.OrderCallbackRes;
import com.renhang.core.callback.xianwan.service.OrderCallbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class OrderCallbackServiceImpl implements OrderCallbackService {

    @Autowired
    OrderCallbackMapper orderCallbackMapper;

    @Value("${XWAndroid.appsecret}")
    private String AndroidAppsecret;

    @Value("${XWIOS.appsecret}")
    private String IOSAppsecret;

    /**
     * 回调订单处理
     * @param params
     * @return
     */
    @Override
    public OrderCallbackRes OrderCallbackService(Map<String,String> params){
        OrderCallbackRes orderCallbackRes = new OrderCallbackRes();
        String str =  params.get("adid")+params.get("appid")+params.get("ordernum")+params.get("dlevel")+params.get("deviceid")
                      +params.get("appsign")+params.get("price")+params.get("money");
        String strAndroid = str+AndroidAppsecret;
        String strIOS = str+IOSAppsecret;
        String signAndroid = MD5.getMD5(strAndroid).toUpperCase();
        String signIOS = MD5.getMD5(strIOS).toUpperCase();
        //校验签名
        if(signAndroid.equals(params.get("keycode")) || signIOS.equals(params.get("keycode"))){
            orderCallbackRes.setSuccess(0);
            orderCallbackRes.setMessage("订单无效");
            return orderCallbackRes;
        }
        params.put("id",GlobalUtils.uuid());
        params.put("createdTime",new Date().toString());
        //查询是否存在这条数据
        Integer num = orderCallbackMapper.queryOrderNum((String) params.get("ordernum"));
        if(num!=0){
            orderCallbackRes.setSuccess(1);
            orderCallbackRes.setMessage("订单已接收");
            return orderCallbackRes;
        }
        //插入数据
        orderCallbackMapper.insertOrderToUserCallback(params);
        orderCallbackRes.setSuccess(1);
        orderCallbackRes.setMessage("接收成功");
        return orderCallbackRes;
    }

}
