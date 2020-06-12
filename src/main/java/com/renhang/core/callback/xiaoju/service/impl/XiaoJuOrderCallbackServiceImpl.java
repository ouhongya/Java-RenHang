package com.renhang.core.callback.xiaoju.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.renhang.common.Utils.GlobalUtils;
import com.renhang.common.Utils.SecurityUtil;
import com.renhang.core.callback.xiaoju.mapper.XiaoJuOrderCallbackMapper;
import com.renhang.core.callback.xiaoju.pojo.OrderDetail;
import com.renhang.core.callback.xiaoju.pojo.QueryResponseVo;
import com.renhang.core.callback.xiaoju.pojo.UserAuto;
import com.renhang.core.callback.xiaoju.service.XiaoJuOrderCallbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class XiaoJuOrderCallbackServiceImpl implements XiaoJuOrderCallbackService {

    @Value("${origin.appKey}")
    private String appKey;
    @Value("${origin.appSecret}")
    private String appSecret;
    @Value("${origin.dataSecret}")
    private String dataSecret;
    @Value("${origin.sigSecret}")
    private String sigSecret;

    @Autowired
    XiaoJuOrderCallbackMapper xiaoJuOrderCallbackMapper;

    /**
     * 支付订单通知
     *
     * @param queryResponseVo
     * @return
     */
    @Override
    public QueryResponseVo notifyOrderInfo(QueryResponseVo queryResponseVo) {
        QueryResponseVo responseVo = new QueryResponseVo();
        try {
            String response = SecurityUtil.decrypt(queryResponseVo.getData(), dataSecret, dataSecret);
            OrderDetail notifyOrderInfoVo = JSONObject.parseObject(response, OrderDetail.class);
            //判断金额是否丢失
            if (notifyOrderInfoVo.getTotalMoney() == null || notifyOrderInfoVo.getRealMoney() == null) {
                Map<String, Object> map = new HashMap<>();
                map.put("state", 1);
                map.put("message", "金额字段缺失");
                String originRequestDataJsonStr = JSON.toJSONString(map);
                String data = SecurityUtil.encrypt(originRequestDataJsonStr, dataSecret, dataSecret);
                String timestamp = GlobalUtils.format();
                String requestSignStr = SecurityUtil.signRequest(appKey, sigSecret, data, timestamp);
                responseVo.setAppKey(appKey);
                responseVo.setCode("0");
                responseVo.setData(data);
                responseVo.setMsg("请求成功");
                responseVo.setSig(requestSignStr);
            }
            Map<String, Object> map = new HashMap<>();
            map.put("state", 0);
            map.put("message", "success");
            String originRequestDataJsonStr = JSON.toJSONString(map);
            String data = SecurityUtil.encrypt(originRequestDataJsonStr, dataSecret, dataSecret);
            String timestamp = GlobalUtils.format();
            String requestSignStr = SecurityUtil.signRequest(appKey, sigSecret, data, String.valueOf(timestamp));
            responseVo.setAppKey(appKey);
            responseVo.setCode("0");
            responseVo.setData(data);
            responseVo.setMsg("请求成功");
            responseVo.setSig(requestSignStr);
            Integer count = xiaoJuOrderCallbackMapper.queryOrderXiaoJuToOrderId(notifyOrderInfoVo.getOrderId());
            //判断订单是否已经存在
            if (count >= 0) {
                xiaoJuOrderCallbackMapper.updateXiaoJuOrder(notifyOrderInfoVo);
                return responseVo;
            }
            notifyOrderInfoVo.setId(GlobalUtils.uuid());
            notifyOrderInfoVo.setCreatedTime(new Date());
            xiaoJuOrderCallbackMapper.createdOrderXiaoJu(notifyOrderInfoVo);

        } catch (Exception e) {
            Map<String, Object> map = new HashMap<>();
            map.put("state", 0);
            map.put("message", "系统繁忙请稍后再试");
            String originRequestDataJsonStr = JSON.toJSONString(map);
            String data = null;
            try {
                data = SecurityUtil.encrypt(originRequestDataJsonStr, dataSecret, dataSecret);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            String timestamp = GlobalUtils.format();
            String requestSignStr = null;
            try {
                requestSignStr = SecurityUtil.signRequest(appKey, sigSecret, data, String.valueOf(timestamp));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            responseVo.setAppKey(appKey);
            responseVo.setCode("0");
            responseVo.setData(data);
            responseVo.setMsg("请求成功");
            responseVo.setSig(requestSignStr);
        }
        return responseVo;
    }

    /**
     * 校验用户信息
     * @param queryResponseVo
     * @return
     */
    @Override
    public QueryResponseVo notifyCheckUserInfo(QueryResponseVo queryResponseVo) {
        QueryResponseVo responseVo = new QueryResponseVo();
        try {
            //解密用户信息
            String response = SecurityUtil.decrypt(queryResponseVo.getData(), dataSecret, dataSecret);
            UserAuto userAuto  = JSONObject.parseObject(response, UserAuto.class);
            //加密用户信息并返回
            Map<String, Object> map = new HashMap<>();
            ////0合法 1不合法
            map.put("checkState", 0);
            //非法Id、非登录Id、异常Id
            map.put("checkMsg", "");
            String originRequestDataJsonStr = JSON.toJSONString(map);
            String data = null;
            try {
                data = SecurityUtil.encrypt(originRequestDataJsonStr, dataSecret, dataSecret);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            String timestamp = GlobalUtils.format();
            String requestSignStr = null;
            try {
                requestSignStr = SecurityUtil.signRequest(appKey, sigSecret, data,timestamp);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            responseVo.setAppKey(appKey);
            responseVo.setCode("0");
            responseVo.setData(data);
            responseVo.setMsg("请求成功");
            responseVo.setSig(requestSignStr);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, Object> map = new HashMap<>();
            ////0合法 1不合法
            map.put("checkState", 0);
            //非法Id、非登录Id、异常Id
            map.put("checkMsg", "系统繁忙请稍后再试");
            String originRequestDataJsonStr = JSON.toJSONString(map);
            String data = null;
            try {
                data = SecurityUtil.encrypt(originRequestDataJsonStr, dataSecret, dataSecret);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            String timestamp = GlobalUtils.format();
            String requestSignStr = null;
            try {
                requestSignStr = SecurityUtil.signRequest(appKey, sigSecret, data, String.valueOf(timestamp));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            responseVo.setAppKey(appKey);
            responseVo.setCode("0");
            responseVo.setData(data);
            responseVo.setMsg("请求成功");
            responseVo.setSig(requestSignStr);
        }
        return responseVo;
    }
}
