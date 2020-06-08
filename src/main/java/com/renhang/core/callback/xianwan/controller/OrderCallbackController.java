package com.renhang.core.callback.xianwan.controller;

import com.renhang.common.Utils.GlobalUtils;
import com.renhang.core.callback.xianwan.pojo.OrderCallbackRes;
import com.renhang.core.callback.xianwan.pojo.OrderCallbackVo;
import com.renhang.core.callback.xianwan.service.OrderCallbackService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@RequestMapping("/order")
@RestController
@Log4j2
public class OrderCallbackController {

    @Autowired
    public OrderCallbackService orderCallbackService;

    /**
     * 用户订单回调
     * @param params
     * @return
     */
    @GetMapping("/ToUserAndCallback")
    public OrderCallbackRes orderToUserAndCallback(@RequestParam Map<String,String> params) {
        OrderCallbackRes orderCallbackRes = null;
        try {
            orderCallbackRes = orderCallbackService.OrderCallbackService(params);
        }catch (Exception e){
            log.error("闲玩订单回调出现问题\n"+e);
            log.error(GlobalUtils.format(new Date()));
            orderCallbackRes.setSuccess(0);
            orderCallbackRes.setMessage("服务器异常,请稍后在试");
            return orderCallbackRes;
        }
        return orderCallbackRes;
    }
}
