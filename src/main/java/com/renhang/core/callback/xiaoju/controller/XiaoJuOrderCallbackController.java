package com.renhang.core.callback.xiaoju.controller;

import com.renhang.common.Utils.GlobalUtils;
import com.renhang.core.callback.xiaoju.pojo.QueryResponseVo;
import com.renhang.core.callback.xiaoju.service.XiaoJuOrderCallbackService;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@RequestMapping
@RestController
@Log4j2
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
        QueryResponseVo  responseVo = null;
        try {
            responseVo = juBaoPengOrderCallbackService.notifyOrderInfo(queryResponseVo);
        }catch (Exception e){
            log.error("支付订单通知接口出错啦\n");
            log.error(e);
            log.error(GlobalUtils.format(new Date()));
            return responseVo;
        }
        return responseVo;
    }

    /**
     * 用户信息校验
     * @param queryResponseVo
     * @return
     */
    @PostMapping("/notifyCheckUserInfo")
    public QueryResponseVo  notifyCheckUserInfo(@RequestBody QueryResponseVo queryResponseVo){
        QueryResponseVo  responseVo = null;
        try {
            responseVo = juBaoPengOrderCallbackService.notifyCheckUserInfo(queryResponseVo);
        }catch (Exception e){
            log.error("用户信息校验接口出错啦\n");
            log.error(e);
            log.error(GlobalUtils.format(new Date()));
            return responseVo;
        }
        return responseVo;
    }

}
