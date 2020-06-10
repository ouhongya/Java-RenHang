package com.renhang.core.callback.xianyu.service.impl;

import com.renhang.common.Utils.GlobalUtils;
import com.renhang.common.Utils.MD5;
import com.renhang.core.callback.xianwan.pojo.OrderCallbackRes;
import com.renhang.core.callback.xianyu.mapper.XianYuOrderCallbackMapper;
import com.renhang.core.callback.xianyu.service.XianYuOrderCallbackService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Log4j2
public class XianYuOrderCallbackServiceImpl implements XianYuOrderCallbackService {

    @Autowired
    XianYuOrderCallbackMapper xianYuOrderCallbackMapper;
    
    @Value("${XYWeb.appKey}")
    private String appKey;

    /**
     * 用户订单回调接口
     *
     * @param map
     */
    @Override
    public void XianYuToOrderCallback(Map<String, String[]> map) {
        Map<String, String> params = requestToMap(map);
        //按参数名的字段顺序升序排序
        Set set=params.keySet();
        Object[] arr=set.toArray();
        Arrays.sort(arr);
        String str = "";
        for (Object key : arr) {
            if(!key.equals("sign")){
                str+=key+""+params.get(key);
            }
        }
        //在字符串A前拼接媒体对应的key(在后台中可以查看到分配给对应媒体)，对其进行md5(key + A) = B 
        String signing = appKey + str;
        String sign = MD5.MD5Encode(signing, "UTF-8", false);
        params.put("id", GlobalUtils.uuid());
        params.put("created_time", GlobalUtils.format(new Date()));
        xianYuOrderCallbackMapper.XianYuToOrderCallbackTo(params);
        //签名认证
        if(sign.equals(params.get("sign"))){
            params.put("id", GlobalUtils.uuid());
            params.put("created_time", GlobalUtils.format(new Date()));
            xianYuOrderCallbackMapper.XianYuToOrderCallbackTo(params);
        }else{
            log.info("用户订单回调接口签名失败了\n");
            log.info(GlobalUtils.format(new Date()));
        }
    }

    /**
     * 请求参数转换为我想要的数据结构
     * @param properties
     * @return
     */
    public Map<String,String> requestToMap(Map<String,String[]> properties){
        Map<String,String> returnMap = new HashMap<String,String>();
        Iterator entries = properties.entrySet().iterator();
        Map.Entry entry;
        String name = "";
        String value = "";
        while (entries.hasNext()) {
            entry = (Map.Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if(null == valueObj){
                value = "";
            }else if(valueObj instanceof String[]){
                String[] values = (String[])valueObj;
                for(int i=0;i<values.length;i++){
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length()-1);
            }else{
                value = valueObj.toString();
            }
            returnMap.put(name, value);
        }
        return returnMap;
    }
    /**
     * 用户订单审核失败
     *
     * @param map
     */
    @Override
    public void XianYuOrderCallbackFailure(Map<String, String[]> map) {
        Map<String, String> params = requestToMap(map);
        //按参数名的字段顺序升序排序
        Set set=params.keySet();
        Object[] arr=set.toArray();
        Arrays.sort(arr);
        String str = "";
        for (Object key : arr) {
            if(!key.equals("sign")){
                str+=key+""+params.get(key);
            }
        }
        //在字符串A前拼接媒体对应的key(在后台中可以查看到分配给对应媒体)，对其进行md5(key + A) = B 
        String signing = appKey + str;
        String sign = MD5.MD5Encode(signing, "UTF-8", false);
        //签名认证
        if(sign.equals(params.get("sign"))){
            params.put("id", GlobalUtils.uuid());
            params.put("created_time", GlobalUtils.format(new Date()));
            xianYuOrderCallbackMapper.XianYuOrderCallbackFailure(params);
        }else{
            log.info("用户订单审核失败签名校验失败\n");
            log.info(GlobalUtils.format(new Date()));
        }
    }

    /**
     * 订阅截图任务变更通知
     * @param ids
     */
    @Override
    public void XianYuNotification(String ids) {
        Map<String,String>params = new HashMap<>();
        params.put("id",GlobalUtils.uuid());
        params.put("ids",ids);
        params.put("created_time",GlobalUtils.format(new Date()));
        xianYuOrderCallbackMapper.XianYuNotification(params);
    }

}
