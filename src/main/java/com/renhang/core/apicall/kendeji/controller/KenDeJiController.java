package com.renhang.core.apicall.kendeji.controller;

import com.renhang.common.Utils.GlobalUtils;
import com.renhang.core.apicall.kendeji.pojo.GetTokenVo;
import com.renhang.core.apicall.kendeji.pojo.KfcFrontendUrl;
import com.renhang.core.apicall.kendeji.pojo.KfcFrontendUrlVo;
import com.renhang.core.apicall.kendeji.pojo.PagedQuery;
import com.renhang.core.apicall.kendeji.service.KenDeJiService;
import com.renhang.core.callback.kendeji.pojo.KfcOrder;
import com.renhang.core.callback.kendeji.pojo.KfcOrderList;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping
@Log4j2
public class KenDeJiController {

    @Autowired
    KenDeJiService kenDeJiService;

    /**
     * 注册登录并跳转接口(没有手机号码)
     * @param platformUniqueId 是	string	用户唯一标识
     * @param nickname 是	string	用户昵称
     * @param redirectUrl 否	string	重定向地址（不用填，备用，但需要参与签名）
     * @return
     */
    @GetMapping("/api/v2/platform/login")
    public String platformLogin(String platformUniqueId, String nickname, String redirectUrl){
        String response = null;
        try {
            response = kenDeJiService.platformLogin(platformUniqueId,nickname,redirectUrl);
        }catch (Exception e){
            log.error(e);
            log.error("注册登录并跳转接口(没有手机号码)接口抛异常了\n");
            log.error(GlobalUtils.format(new Date()));
            return response;
        }
        return response;
    }

    /**
     * 注册登录并跳转接口(有手机号码)
     * @param platformUniqueId platformUniqueId	是	string	用户唯一标识
     * @param nickname nickname	是	string	用户昵称
     * @param mobile mobile	是	string	手机号码
     * @param redirectUrl redirectUrl	否	string	重定向地址（不用填，备用,但需要参与签名）
     * @return
     */
    @GetMapping("/api/v3/platform/login")
    public String platformLoginV2(String platformUniqueId,String nickname, String mobile,String redirectUrl){
        String response = null;
        try {
            response = kenDeJiService.platformLoginV2(platformUniqueId,nickname,mobile,redirectUrl);
        }catch (Exception e){
            log.error(e);
            log.error("注册登录并跳转接口(有手机号码)接口抛异常了\n");
            log.error(GlobalUtils.format(new Date()));
            return response;
        }
        return response;
    }

    /**
     * 根据订单号查询订单
     * @param orderNo orderNo	是	string	订单号
     * @return
     */
    @GetMapping("/openApi/v1/kfcOrders/getByOrderNo")
    public KfcOrder getByOrderNo(String orderNo){
        KfcOrder response = null;
        try {
            response = kenDeJiService.getByOrderNo(orderNo);
        }catch (Exception e){
            log.error(e);
            log.error("根据订单号查询订单接口抛异常了\n");
            log.error(GlobalUtils.format(new Date()));
            return response;
        }
        return response;
    }

    /**
     * 根据批量订单号查询订单
     * @param orderNo	是	string	批量订单号, 用英文,号分割
     * @return
     */
    @GetMapping("/openApi/v1/kfcOrders/listByBatchOrderNos")
    public KfcOrderList listByBatchOrderNos(String orderNo){
        KfcOrderList response = null;
        try {
            response = kenDeJiService.listByBatchOrderNos(orderNo);
        }catch (Exception e){
            log.error(e);
            log.error("注册登录并跳转接口抛异常了\n");
            log.error(GlobalUtils.format(new Date()));
            return response;
        }
        return response;
    }

    /**
     * 分页查询肯德基订单
     * @param pagedQuery
     * @return
     */
    @GetMapping("/openApi/v1/kfcOrders/pagedQuery")
    public KfcOrderList pagedQuery(PagedQuery pagedQuery){
        KfcOrderList response = null;
        try {
            response = kenDeJiService.pagedQuery(pagedQuery);
        }catch (Exception e){
            log.error(e);
            log.error("分页查询肯德基订单接口抛异常了\n");
            log.error(GlobalUtils.format(new Date()));
            return response;
        }
        return response;
    }

    /**
     * 注册登录接口(没有手机号)
     * @param platformUniqueId 	是	string	用户唯一标识
     * @param nickname 是	string	用户昵称
     * @return
     */
    @GetMapping("/api/v1/platform/getToken")
    public GetTokenVo pagedQuery(String platformUniqueId,String nickname){
        GetTokenVo response = null;
        try {
            response = kenDeJiService.getTokenVoV1( platformUniqueId, nickname);
        }catch (Exception e){
            log.error(e);
            log.error("注册登录接口(没有手机号)接口抛异常了\n");
            log.error(GlobalUtils.format(new Date()));
            return response;
        }
        return response;
    }

    /**
     * 注册登录接口(有手机号)
     * @param platformUniqueId 是	string	用户唯一标识
     * @param nickname 是	string	用户昵称
     * @param mobile 是	string	手机号码
     * @return
     */
    @GetMapping("/api/v2/platform/getToken")
    public GetTokenVo pagedQuery(String platformUniqueId,String nickname, String mobile){
        GetTokenVo response = null;
        try {
            response = kenDeJiService.getTokenVoV2(platformUniqueId, nickname, mobile);
        }catch (Exception e){
            log.error(e);
            log.error("注册登录接口(有手机号)接口抛异常了\n");
            log.error(GlobalUtils.format(new Date()));
            return response;
        }
        return response;
    }

    /**
     * 获取各个前端页面的URL
     * @return
     */
    @GetMapping("/openApi/v1/url/getKfcFrontendUrl")
    public KfcFrontendUrlVo getKfcFrontendUrl(){
        KfcFrontendUrlVo response = null;
        try {
            response = kenDeJiService.getKfcFrontendUrl();
        }catch (Exception e){
            log.error(e);
            log.error("分页查询肯德基订单接口抛异常了\n");
            log.error(GlobalUtils.format(new Date()));
            return response;
        }
        return response;
    }
}
