package com.renhang.core.apicall.xiecheng.controller;

import com.renhang.common.Utils.GlobalUtils;
import com.renhang.core.apicall.xiecheng.pojo.OpenServiceAuthRes;
import com.renhang.core.apicall.xiecheng.pojo.OrderDetails;
import com.renhang.core.apicall.xiecheng.service.XieChengService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/xiecheng")
@Log4j2
public class XieChengController {


    @Autowired
    XieChengService xieChengService;

    /**
     * 获取token
     * @return
     */
    @PostMapping("/OpenServiceAuth/authorize")
    public OpenServiceAuthRes OpenServiceAuth(){
        OpenServiceAuthRes openServiceAuthRes = null;
        try {
            openServiceAuthRes=  xieChengService.OpenServiceAuthauthorize();
        }catch (Exception e){
            log.error("拉取token接口出错啦\n");
            log.error(e);
            log.error(GlobalUtils.format(new Date()));
            return openServiceAuthRes;
        }
        return openServiceAuthRes;
    }

    /**
     * 刷新token
     * @return
     */
    @PostMapping("/OpenServiceAuth/refresh")
    public OpenServiceAuthRes OpenServiceAuthRefresh(String token){
        OpenServiceAuthRes openServiceAuthRes = null;
        try {
            openServiceAuthRes=  xieChengService.OpenServiceAuthRefresh(token);
        }catch (Exception e){
            log.error("刷新token接口出错啦\n");
            log.error(e);
            log.error(GlobalUtils.format(new Date()));
            return openServiceAuthRes;
        }
        return openServiceAuthRes;
    }

    /**
     * Proxy 服务
     * @return
     */
    @PostMapping("/OpenServiceAuth/proxy")
    public String OpenServiceProxy(String ICODE,String UUID,String Token, String Mode,String Format){
        String openServiceAuthRes = null;
        try {
            openServiceAuthRes=  xieChengService.OpenServiceProxy( ICODE, UUID, Token,  Mode, Format);
        }catch (Exception e){
            log.error("Proxy 服务接口出错啦\n");
            log.error(e);
            log.error(GlobalUtils.format(new Date()));
            return openServiceAuthRes;
        }
        return openServiceAuthRes;
    }

    /**
     * 订单详情查询接口
     * @return
     */
    @PostMapping("/OpenServiceAuth/Details")
    public OrderDetails OpenServiceOrderDetails(String orderId){
        OrderDetails openServiceAuthRes = null;
        try {
            openServiceAuthRes=  xieChengService.OpenServiceOrderDetails(orderId);
        }catch (Exception e){
            log.error("订单详情查询接口接口出错啦\n");
            log.error(e);
            log.error(GlobalUtils.format(new Date()));
            return openServiceAuthRes;
        }
        return openServiceAuthRes;
    }
}
