package com.renhang.core.callback.kendeji.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.renhang.common.Utils.GlobalUtils;
import com.renhang.common.Utils.HttpClientUtils;
import com.renhang.common.Utils.SignUtils;
import com.renhang.core.callback.kendeji.mapper.KenDeJiOrderCallbackMapper;
import com.renhang.core.callback.kendeji.pojo.*;
import com.renhang.core.callback.kendeji.service.KenDeJiOrderCallbackService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.*;

@Service
@Log4j2
public class KenDeJiOrderCallbackServiceImpl implements KenDeJiOrderCallbackService {

    @Autowired
    KenDeJiOrderCallbackMapper kenDeJiOrderCallbackMapper;

    @Value("${kfc.secret}")
    private String secret;
    @Value("${kfc.id}")
    private String key;
    @Value("${kfc.url}")
    private String url;

    /**
     * 肯德基订单回调
     * @param orderEventVo
     * @return
     */
    @Override
    public String KenDeJiOrderCallback(OrderEventVo orderEventVo) {
        log.info("回调数据", JSON.toJSONString(orderEventVo));

        if (orderEventVo == null || orderEventVo.getEventType() == null) {
            log.error("肯德基订单消息不合法");
            log.error(GlobalUtils.format(new Date()));
            return "error";
        }
        // 校验签名
        checkSign(orderEventVo);

        //获取订单信息,存入订单
        final KfcOrder orderVo = getByOrderNo(orderEventVo.getOrderNo());
        if (orderVo == null) {
            log.error("获取肯德基订单错误");
            log.error(GlobalUtils.format(new Date()));

            return "error";
        }
        if(orderEventVo.getData().getRefundTime()!=null){
            Integer num = kenDeJiOrderCallbackMapper.queryKftRefundTime(orderEventVo.getOrderNo());
            if(num>0){
                kenDeJiOrderCallbackMapper.updateOrderKenDeJi(orderVo.getData());
                return "success";
            }
        }
        //存入数据库
        orderEventVo.setId(GlobalUtils.uuid());
        orderEventVo.setCreatedTime(new Date());
        kenDeJiOrderCallbackMapper.createdOrderEvent(orderEventVo);
        KfcOrderVo order = orderVo.getData();
        order.setId(GlobalUtils.uuid());
        order.setCreatedTime(new Date());
        KfcPlaceOrderVo kfcPlaceOrder = order.getKfcPlaceOrder();
        kenDeJiOrderCallbackMapper.createdOrderKenDeJi(order);
        List<KfcPlaceOrderItemVo> items = kfcPlaceOrder.getItems();
        for (KfcPlaceOrderItemVo itemVo : items) {
            itemVo.setId(order.getId());
            itemVo.setCreatedTime(new Date());
            if(itemVo.getCanceled()){
                itemVo.setStatus("0");
            }else{
                itemVo.setStatus("1");
            }
            kenDeJiOrderCallbackMapper.createdOrderKenDeJiItem(itemVo);
        }
        switch (orderEventVo.getEventType()) {
            // 部分取消
            case "-3":
                //创建订单
                kenDeJiOrderCallbackMapper.updateOrderKenDeJi(order);
                return "success";
            // 全部取消
            case "-5":
                //创建订单
                kenDeJiOrderCallbackMapper.updateOrderKenDeJi(order);
                return "success";
            // 完成
            case "10":
                //创建订单
                kenDeJiOrderCallbackMapper.createdOrderKenDeJi(order);
                return "success";
            // 非法事件
            default:
                log.error("肯德基订单消息不合法");
                log.error(GlobalUtils.format(new Date()));
                return "error";
        }
    }


    /**
     * 校验签名
     * @param orderEventVo orderEventVo
     */
    private void checkSign(OrderEventVo orderEventVo) {
        Map<String, String> requestMap = new HashMap<>(8);
        requestMap.put("orderNo", orderEventVo.getOrderNo());
        requestMap.put("eventType", orderEventVo.getEventType().toString());
        requestMap.put("platformId", orderEventVo.getPlatformId().toString());
        requestMap.put("platform", orderEventVo.getPlatform());
        final String sign = SignUtils.generateSign(requestMap,secret);
        Assert.isTrue(sign.equalsIgnoreCase(orderEventVo.getSign()), "签名校验失败。");
    }

    /**
     * 根据订单号获取订单
     * @param orderNo 订单号
     * @return 订单
     */
    private KfcOrder getByOrderNo(String orderNo) {
        String requestUrl = url+"/openApi/v1/kfcOrders/getByOrderNo";
        Map<String,String> map = new TreeMap<String,String>();
        map.put("platformId",key);
        map.put("orderNo",orderNo);
        map.put("timestamp",String.valueOf(System.currentTimeMillis()));
        map.put("sign",SignUtils.generateSign(map,secret));
        String params = JSON.toJSONString(map);
        String res = HttpClientUtils.doPostJson(requestUrl, params);
        KfcOrder orderVo = JSONObject.parseObject(res, KfcOrder.class);
        if(orderVo==null){
            log.error("获取肯德基订单号异常");
            log.error(GlobalUtils.format(new Date()));
        }
        return orderVo;
    }
}
