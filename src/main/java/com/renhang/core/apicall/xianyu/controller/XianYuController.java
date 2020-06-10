package com.renhang.core.apicall.xianyu.controller;

import com.renhang.common.Utils.GlobalUtils;
import com.renhang.core.apicall.xianyu.pojo.ApigaoeDetailRes.ApigaoeDetailRes;
import com.renhang.core.apicall.xianyu.pojo.ApigaoeListRes;
import com.renhang.core.apicall.xianyu.pojo.TokenVo;
import com.renhang.core.apicall.xianyu.pojo.ApigaoeVo;
import com.renhang.core.apicall.xianyu.pojo.VerifyVo;
import com.renhang.core.apicall.xianyu.service.XianYuService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/sspmdl")
@Log4j2
public class XianYuController {

    @Autowired
    private XianYuService xiaoZhuoZhuanQianService;

    /**
     * 获取token
     * @param tokenVo
     * @return
     */
    @GetMapping("/gettoken")
    public ApigaoeVo gettoken(@RequestBody TokenVo tokenVo) {
        ApigaoeVo apigaoeVo = null;
        try {
            apigaoeVo =  xiaoZhuoZhuanQianService.getToken(tokenVo);
        } catch (Exception e) {
            log.error(e);
            log.error("拉取token报错了\n");
            log.error(GlobalUtils.format(new Date()));
            return apigaoeVo;
        }
        return apigaoeVo;
    }

    /**
     * 获取截图投放列表
     * @return
     */
    @GetMapping("/apigaoe/list")
    public ApigaoeListRes apigaoeList() {
        ApigaoeListRes apigaoeListRes = null;
        try {
            apigaoeListRes =  xiaoZhuoZhuanQianService.apigaoeList();
        } catch (Exception e) {
            log.error(e);
            log.error("获取截图投放列表出错了\n");
            log.error(GlobalUtils.format(new Date()));
            return apigaoeListRes;
        }
        return apigaoeListRes;
    }

    /**
     * 获取截图详细信息
     * @param id 列表中返回的试玩id
     * @return
     */
    @GetMapping("/apigaoe/detail")
    public ApigaoeDetailRes apigaoeDetailRes(String id) {
        ApigaoeDetailRes apigaoeDetailRes = null;
        try {
            apigaoeDetailRes =  xiaoZhuoZhuanQianService.apigaoeDetail(id);
        } catch (Exception e) {
            log.error(e);
            log.error("获取截图详细信息出错了\n");
            log.error(GlobalUtils.format(new Date()));
            return apigaoeDetailRes;
        }
        return apigaoeDetailRes;
    }

    /**
     * 请求领取任务
     * @param id 列表中返回的试玩id
     * @return
     */
    @GetMapping("/apigaoe/apply")
    public ApigaoeVo apigaoeApply(String id) {
        ApigaoeVo apigaoeVo = null;
        try {
            apigaoeVo =  xiaoZhuoZhuanQianService.apigaoeApply(id);
        } catch (Exception e) {
            log.error(e);
            log.error("请求领取任务出错了\n");
            log.error(GlobalUtils.format(new Date()));
            return apigaoeVo;
        }
        return apigaoeVo;
    }

    /**
     * 请求释放任务
     * @param id 列表中返回的试玩id
     * @return
     */
    @GetMapping("/apigaoe/cancel")
    public ApigaoeVo apigaoeCancel(String id) {
        ApigaoeVo apigaoeVo = null;
        try {
            apigaoeVo =  xiaoZhuoZhuanQianService.apigaoeCancel(id);
        } catch (Exception e) {
            log.error(e);
            log.error("请求释放任务出错了\n");
            log.error(GlobalUtils.format(new Date()));
            return apigaoeVo;
        }
        return apigaoeVo;
    }

    /**
     * 截图提交信息
     * @return
     */
    @GetMapping("/apigaoe/verify")
    public ApigaoeVo apigaoeVerify(VerifyVo verifyVo) {
        ApigaoeVo apigaoeVo = null;
        try {
            apigaoeVo =  xiaoZhuoZhuanQianService.apigaoeVerify(verifyVo);
        } catch (Exception e) {
            log.error(e);
            log.error("请求释放任务出错了\n");
            log.error(GlobalUtils.format(new Date()));
            return apigaoeVo;
        }
        return apigaoeVo;
    }

}
