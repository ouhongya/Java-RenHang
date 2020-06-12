package com.renhang.core.callback.kendeji.controller;

import com.alibaba.fastjson.JSONObject;
import com.renhang.common.Utils.GlobalUtils;
import com.renhang.core.callback.kendeji.pojo.OrderEventVo;
import com.renhang.core.callback.kendeji.service.KenDeJiOrderCallbackService;
import com.renhang.core.callback.xiecheng.pojo.XieChenOrderCallbackVo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/kfc")
@Log4j2
public class KenDeJiOrderCallbackController {

    @Autowired
    KenDeJiOrderCallbackService kenDeJiOrderCallbackService;

    /**
     * 肯德基的订单回调
     * @param params
     * @return
     */
    @PostMapping("/order/notify")
    public String KenDeJiOrderCallback(@RequestBody String params) {
        String response = "";
        OrderEventVo orderEventVo = JSONObject.parseObject(params, OrderEventVo.class);
        try {
            response =  kenDeJiOrderCallbackService.KenDeJiOrderCallback(orderEventVo);
        } catch (Exception e) {
            log.error(e);
            log.error("肯德基订单回调失败了");
            log.error(GlobalUtils.format(new Date()));
            return response;
        }
        return response;
    }

}
