package com.renhang.core.callback.xianwan.controller;

import com.renhang.common.Utils.GlobalUtils;
import com.renhang.core.callback.xianwan.pojo.OrderCallbackVo;
import com.renhang.core.callback.xianwan.service.OrderCallbackService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RequestMapping("/order")
@RestController
@Log4j2
public class OrderCallbackController {

    @Autowired
    public OrderCallbackService orderCallbackService;

    @GetMapping("/ToUserAndCallback")
    public String orderToUserAndCallback(OrderCallbackVo orderCallbackVo) {
        String flag = null;
        try {
            flag = orderCallbackService.OrderCallbackService(orderCallbackVo);
        }catch (Exception e){
            log.error("闲玩订单回调出现问题\n"+e);
            log.error(GlobalUtils.format(new Date()));
            flag = "{\"success\": 0,\"message\": \"闲玩订单回调出现问题\"}";
        }
        return flag;
    }
}
