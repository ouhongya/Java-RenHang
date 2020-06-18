package com.renhang.core.callback.xianwantask.service.impl;

import com.renhang.common.Utils.GlobalUtils;
import com.renhang.common.Utils.MD5;
import com.renhang.core.callback.xianwan.pojo.OrderCallbackRes;
import com.renhang.core.callback.xianwantask.mapper.XianwanCallbackMapper;
import com.renhang.core.callback.xianwantask.pojo.XianwanCallbackRes;
import com.renhang.core.callback.xianwantask.service.XianwanTaskCallbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class XianwanTaskCallbackServiceImpl implements XianwanTaskCallbackService {
    @Value("${XWAndroidTask.appsecret}")
    private String XWAndroidTaskAppsecret;
    @Value("${XWAndroidTask.appId}")
    private String XWAndroidTaskAppid;


    @Value("${XWIOSTask.appsecret}")
    private String XWIOSTaskAppid;
    @Value("${XWIOSTask.appId}")
    private String XWIOSTaskAppsecret;

    @Autowired
    XianwanCallbackMapper xianwanCallbackMapper;
    /**
     * 审核结果推送接口(非必须，渠道提供)
     * @param params
     * @return
     */
    @Override
    public XianwanCallbackRes XianwanCallbackService(Map<String,String> params){
        XianwanCallbackRes orderCallbackRes = new XianwanCallbackRes();
        params.put("id",GlobalUtils.uuid());
        params.put("createdTime",new Date().toString());
        //插入数据
        xianwanCallbackMapper.insertOrderToUserCallback(params);
        orderCallbackRes.setSuccess(1);
        orderCallbackRes.setMessage("成功");
        return orderCallbackRes;
    }

    @Override
    public OrderCallbackRes OrderCallbackService(Map<String, String> params) {

        OrderCallbackRes orderCallbackRes = new OrderCallbackRes();
        String str =  params.get("adid")+params.get("appid")+params.get("ordernum")+params.get("dlevel")+params.get("deviceid")
                +params.get("appsign")+params.get("price")+params.get("money");
        String strAndroid = str+XWAndroidTaskAppsecret;
        String strIOS = str+XWIOSTaskAppsecret;
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
        Integer num = xianwanCallbackMapper.queryOrderNum((String) params.get("ordernum"));
        if(num!=0){
            orderCallbackRes.setSuccess(1);
            orderCallbackRes.setMessage("订单已接收");
            return orderCallbackRes;
        }
        //插入数据
        xianwanCallbackMapper.insertOrderToUsertestCallback(params);
        orderCallbackRes.setSuccess(1);
        orderCallbackRes.setMessage("接收成功");
        return orderCallbackRes;
    }





}
