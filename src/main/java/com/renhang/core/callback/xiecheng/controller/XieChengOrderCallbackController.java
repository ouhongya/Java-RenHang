package com.renhang.core.callback.xiecheng.controller;

import com.renhang.core.callback.xiecheng.pojo.XieChenOrderCallbackVo;
import com.renhang.core.callback.xiecheng.service.XieChengOrderCallbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/xiecheng")
public class XieChengOrderCallbackController {


    @Autowired
    XieChengOrderCallbackService xieChengOrderCallbackService;

    @PostMapping("/orderCallBack")
    public String xieChenOrderCallbackVo(XieChenOrderCallbackVo xieChenOrderCallbackVo){
        try {
            xieChengOrderCallbackService.xieChenOrderCallbackVo(xieChenOrderCallbackVo);
        }catch (Exception e){

        }
        return null;
    }
}
