package com.renhang.core.apicall.xianwan.controller;

import com.renhang.common.Utils.GlobalUtils;
import com.renhang.core.apicall.xianwan.pojo.TryApiAdClick.TryApiAdClick;
import com.renhang.core.apicall.xianwan.pojo.TryApiAdInfo;
import com.renhang.core.apicall.xianwan.pojo.TryApiAdInfoRes.TryApiAdInfoRes;
import com.renhang.core.apicall.xianwan.pojo.TryApiList;
import com.renhang.core.apicall.xianwan.pojo.TryApiListRes.TryApiListRes;
import com.renhang.core.apicall.xianwan.pojo.TryApiAdClick.TryApiAdClickRes;
import com.renhang.core.apicall.xianwan.service.XianWanService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/try/API")
@Log4j2
public class XianWanController {


    @Autowired
    XianWanService mtUserService;

    /**
     * 获取广告列表
     * @param adListBean
     * @return
     */
    @GetMapping("/try_api_list")
    public TryApiListRes try_api_list(@RequestBody TryApiList adListBean) {
        TryApiListRes advertising = null;
        try {
             advertising = mtUserService.TryApiList(adListBean);
            return advertising;
        }catch (Exception e){
            log.error(e);
            log.error("获取广告列表\n");
            log.error(GlobalUtils.format(new Date()));
            return advertising;
        }
    }

    /**
     * 查询广告列表
     * @param tryApiAdInfo
     * @return
     */
    @GetMapping("/try_api_adInfo")
    public TryApiAdInfoRes try_api_adInfo(@RequestBody TryApiAdInfo tryApiAdInfo) {
        TryApiAdInfoRes tryApiAdInfoRes = null;
        try {
             tryApiAdInfoRes = mtUserService.TryApiAdInfo(tryApiAdInfo);
            return tryApiAdInfoRes;
        }catch (Exception e){
            log.error(e);
            log.error("查询广告列表\n");
            log.error(GlobalUtils.format(new Date()));
            return tryApiAdInfoRes;
        }
    }

    /**
     * 广告点击下载
     * @param tryApiAdClick
     * @return
     */
    @GetMapping("/try_api_adClick")
    public TryApiAdClickRes try_api_adClick(@RequestBody TryApiAdClick tryApiAdClick){
        TryApiAdClickRes tryApiAdClickRes = null;
        try {
            tryApiAdClickRes = mtUserService.tryApiAdClick(tryApiAdClick);
            return tryApiAdClickRes;
        }catch (Exception e){
            log.error(e);
            log.error("广告点击下载抛异常啦\n");
            log.error(GlobalUtils.format(new Date()));
            return tryApiAdClickRes;
        }
    }
}
