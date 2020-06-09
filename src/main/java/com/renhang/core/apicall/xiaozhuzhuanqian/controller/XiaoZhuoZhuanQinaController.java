package com.renhang.core.apicall.xiaozhuzhuanqian.controller;

import com.renhang.common.Utils.GlobalUtils;
import com.renhang.core.apicall.xiaozhuzhuanqian.pojo.ApigaoeDetailRes.ApigaoeDetailRes;
import com.renhang.core.apicall.xiaozhuzhuanqian.pojo.ApigaoeListRes;
import com.renhang.core.apicall.xiaozhuzhuanqian.pojo.TokenVo;
import com.renhang.core.apicall.xiaozhuzhuanqian.pojo.TokenRes;
import com.renhang.core.apicall.xiaozhuzhuanqian.service.XiaoZhuoZhuanQianService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/sspmdl")
@Log4j2
public class XiaoZhuoZhuanQinaController {

    @Autowired
    private XiaoZhuoZhuanQianService xiaoZhuoZhuanQianService;

    /**
     * 获取token
     * @param tokenVo
     * @return
     */
    @GetMapping("/gettoken")
    public TokenRes gettoken(@RequestBody TokenVo tokenVo) {
        TokenRes tokenRes = null;
        try {
            tokenRes =  xiaoZhuoZhuanQianService.getToken(tokenVo);
        } catch (Exception e) {
            log.error(e);
            log.error("拉取token报错了\n");
            log.error(GlobalUtils.format(new Date()));
            return tokenRes;
        }
        return tokenRes;
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
}
