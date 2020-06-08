package com.renhang.core.apicall.xianwan.controller;

import com.renhang.common.Result.CommonCode;
import com.renhang.common.Result.ResponseResult;
import com.renhang.common.Utils.GlobalUtils;
import com.renhang.core.apicall.xianwan.pojo.TryApiAdClick;
import com.renhang.core.apicall.xianwan.pojo.TryApiAdInfo;
import com.renhang.core.apicall.xianwan.pojo.TryApiAdInfoRes.TryApiAdInfoRes;
import com.renhang.core.apicall.xianwan.pojo.TryApiList;
import com.renhang.core.apicall.xianwan.pojo.TryApiListRes.TryApiListRes;
import com.renhang.core.apicall.xianwan.pojo.tryApiAdClickRes;
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
    public ResponseResult try_api_list(@RequestBody TryApiList adListBean) {
        try {
            TryApiListRes advertising = mtUserService.TryApiList(adListBean);
            return new ResponseResult(CommonCode.SUCCESS,advertising);
        }catch (Exception e){
            log.error(e);
            log.error(GlobalUtils.format(new Date()));
            return new ResponseResult(CommonCode.ERROR);
        }
    }

    /**
     * 查询广告列表
     * @param tryApiAdInfo
     * @return
     */
    @GetMapping("/try_api_adInfo")
    public ResponseResult try_api_adInfo(@RequestBody TryApiAdInfo tryApiAdInfo) {
        try {
            TryApiAdInfoRes tryApiAdInfoRes = mtUserService.TryApiAdInfo(tryApiAdInfo);
            return new ResponseResult(CommonCode.SUCCESS,tryApiAdInfoRes);
        }catch (Exception e){
            log.error(e);
            log.error(GlobalUtils.format(new Date()));
            return new ResponseResult(CommonCode.ERROR);
        }
    }

    /**
     * 广告点击下载
     * @param tryApiAdClick
     * @return
     */
    @GetMapping("/try_api_adClick")
    public ResponseResult try_api_adClick(@RequestBody TryApiAdClick tryApiAdClick){
        try {
            tryApiAdClickRes tryApiAdClickRes = mtUserService.tryApiAdClick(tryApiAdClick);
            return new ResponseResult(CommonCode.SUCCESS,tryApiAdClickRes);
        }catch (Exception e){
            log.error(e);
            log.error(GlobalUtils.format(new Date()));
            return new ResponseResult(CommonCode.ERROR);
        }
    }
}
