package com.renhang.core.callback.kendeji.controller;

import com.renhang.common.Utils.GlobalUtils;
import com.renhang.core.callback.kendeji.pojo.OrderEventVo;
import com.renhang.core.callback.kendeji.service.KenDeJiOrderCallbackService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/kendeji")
@Log4j2
public class KenDeJiOrderCallbackController {

    @Autowired
    KenDeJiOrderCallbackService kenDeJiOrderCallbackService;

    @PostMapping("/kfcOrder/notify")
    public String KenDeJiOrderCallback(@RequestBody OrderEventVo orderEventVo) {
        String response = "";
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
