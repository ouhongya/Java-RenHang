package com.renhang.core.callback.xianwantask.controller;

import com.renhang.common.Utils.GlobalUtils;
import com.renhang.core.callback.xianwantask.pojo.XianwanCallbackRes;
import com.renhang.core.callback.xianwantask.service.XianwanTaskCallbackService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

@RequestMapping("/xianwancallback")
@RestController
@Log4j2
public class XianwanTaskCallbackController {

    @Autowired
    public XianwanTaskCallbackService xianwanTaskCallbackService;

    /**
     * 用户订单回调
     * @param params
     * @return
     */
    @GetMapping("/ToTaskAndCallback")
    public XianwanCallbackRes ToTaskAndCallback(@RequestParam Map<String,String> params) {
        XianwanCallbackRes orderCallbackRes = null;
        try {
            orderCallbackRes = xianwanTaskCallbackService.XianwanCallbackService(params);
        }catch (Exception e){
            log.error("闲玩订单回调出现问题\n"+e);
            log.error(GlobalUtils.format(new Date()));
            orderCallbackRes.setSuccess(0);
            orderCallbackRes.setMessage("error msg");
            return orderCallbackRes;
        }
        return orderCallbackRes;
    }

}
