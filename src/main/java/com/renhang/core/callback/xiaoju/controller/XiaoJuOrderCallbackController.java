package com.renhang.core.callback.xiaoju.controller;

import com.renhang.core.callback.xiaoju.pojo.QueryResponseVo;
import com.renhang.core.callback.xiaoju.service.XiaoJuOrderCallbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping
@RestController
public class XiaoJuOrderCallbackController {

    @Autowired
    XiaoJuOrderCallbackService juBaoPengOrderCallbackService;

    /**
     * 支付订单通知
     * @param queryResponseVo
     * @return
     */
    @PostMapping("/notifyOrderInfo")
    public QueryResponseVo  notifyOrderInfo(@RequestBody QueryResponseVo queryResponseVo){
        juBaoPengOrderCallbackService.notifyOrderInfo(queryResponseVo);
        return null;
    }

    /**
     * 用户信息校验
     * @param queryResponseVo
     * @return
     */
    @PostMapping("/notifyCheckUserInfo")
    public QueryResponseVo  notifyCheckUserInfo(@RequestBody QueryResponseVo queryResponseVo){
        juBaoPengOrderCallbackService.notifyCheckUserInfo(queryResponseVo);
        return null;
    }

}
