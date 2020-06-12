package com.renhang.core.callback.xiecheng.controller;

import com.alibaba.fastjson.JSONObject;
import com.renhang.core.callback.xiecheng.pojo.XieChenOrderCallbackVo;
import com.renhang.core.callback.xiecheng.service.XieChengOrderCallbackService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/xiecheng")
@Log4j2
public class XieChengOrderCallbackController {


    @Autowired
    XieChengOrderCallbackService xieChengOrderCallbackService;

    /**
     * 订单回传推送接口
     * @param params
     * @return
     */
    @PostMapping("/orderCallBack")
    public String xieChenOrderCallbackVo(@RequestBody String params ){
        try {
            XieChenOrderCallbackVo xieChenOrderCallbackVo = JSONObject.parseObject(params, XieChenOrderCallbackVo.class);
            xieChengOrderCallbackService.xieChenOrderCallbackVo(xieChenOrderCallbackVo);
        }catch (Exception e){
            return "服务器繁忙请稍后再试";
        }
        return "success";
    }
}
