package com.renhang.core.apicall.kendeji.controller;

import com.renhang.common.Utils.GlobalUtils;
import com.renhang.core.apicall.kendeji.service.KenDeJiService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/v2")
@Log4j2
public class KenDeJiController {

    @Autowired
    KenDeJiService kenDeJiService;

    @GetMapping("/platform/login")
    public String platformLogin(String platformUniqueId,String nickname,String redirectUrl){
        String response = null;
        try {
            response = kenDeJiService.platformLogin(platformUniqueId,nickname,redirectUrl);
        }catch (Exception e){
            log.error(e);
            log.error("注册登录并跳转接口抛异常了\n");
            log.error(GlobalUtils.format(new Date()));
            return response;
        }
        return response;
    }
}
