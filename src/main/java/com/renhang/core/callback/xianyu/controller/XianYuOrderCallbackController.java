package com.renhang.core.callback.xianyu.controller;

import com.renhang.core.apicall.xianyu.service.XianYuService;
import com.renhang.core.callback.xianyu.service.XianYuOrderCallbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RequestMapping("/xianyu")
@RestController
public class XianYuOrderCallbackController {

    @Autowired
    XianYuOrderCallbackService XianYuToOrderCallback;

    /**
     * 闲娱的用户订单回调成功
     * @param request
     */
    @GetMapping("/orderCallback")
    public void XianYuOrderCallback(HttpServletRequest request){
        Map properties = request.getParameterMap();
        XianYuToOrderCallback.XianYuToOrderCallback(properties);
    }

    /**
     * 截图任务订单审核失败
     * @param request
     */
    @GetMapping("/orderCallbackFailure")
    public void XianYuOrderCallbackFailure(HttpServletRequest request){
        Map properties = request.getParameterMap();
        XianYuToOrderCallback.XianYuOrderCallbackFailure(properties);
    }

    /**
     * 订阅截图任务变更通知
     * @param ids
     */
    @GetMapping("/notification")
    public void XianYuNotification(String ids){
        XianYuToOrderCallback.XianYuNotification(ids);
    }
}
