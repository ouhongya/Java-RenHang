package com.renhang.core.apicall.xianwantask.controller;

import com.renhang.common.Utils.GlobalUtils;


import com.renhang.core.apicall.xianwantask.pojo.TryApiAdClick.TryApiAdClick;
import com.renhang.core.apicall.xianwantask.pojo.TryApiAdClick.TryApiAdClickRes;
import com.renhang.core.apicall.xianwantask.pojo.TryApiAdInfo;
import com.renhang.core.apicall.xianwantask.pojo.TryApiAdInfoRes.*;
import com.renhang.core.apicall.xianwantask.pojo.TryApiList;
import com.renhang.core.apicall.xianwantask.pojo.TryApiListRes.TryApiListRes;
import com.renhang.core.apicall.xianwantask.service.XianWanTaskService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/try/API/xianwantask")
@Log4j2
public class XianWanTaskController {


    @Autowired
    XianWanTaskService xianWanTaskService;

    /**
     * 获取广告列表
     * @param adListBean
     * @return
     */
    @GetMapping("/try_api_list")
    public TryApiListRes try_api_list(@RequestBody TryApiList adListBean) {
        TryApiListRes advertising = null;
        try {
             advertising = xianWanTaskService.TryApiList(adListBean);
            return advertising;
        }catch (Exception e){
            log.error(e);
            log.error("获取广告列表\n");
            log.error(GlobalUtils.format(new Date()));
            return advertising;
        }
    }

    /**
     * 查询广告详情
     * @param tryApiAdInfo
     * @return
     */
    @GetMapping("/try_api_adInfo")
    public TryApiAdInfoRes try_api_adInfo(@RequestBody TryApiAdInfo tryApiAdInfo) {
        TryApiAdInfoRes tryApiAdInfoRes = null;
        try {
             tryApiAdInfoRes = xianWanTaskService.TryApiAdInfo(tryApiAdInfo);
            return tryApiAdInfoRes;
        }catch (Exception e){
            log.error(e);
            log.error("查询广告列表\n");
            log.error(GlobalUtils.format(new Date()));
            return tryApiAdInfoRes;
        }
    }

    /**
     * 领取任务api
     * @param tryApiAdClick
     * @return
     */
    @PostMapping("/try_api_commit")
    public LinkTask try_api_adClick(@RequestBody TryApiAdClick tryApiAdClick){
        LinkTask tryApiAdClickRes = null;
        try {
            tryApiAdClickRes = xianWanTaskService.tryApiAdClick(tryApiAdClick);
            return tryApiAdClickRes;
        }catch (Exception e){
            log.error(e);
            log.error("广告点击下载抛异常啦\n");
            log.error(GlobalUtils.format(new Date()));
            return tryApiAdClickRes;
        }
    }

    /**
     *  提交任务答案api
     * @param
     * @return
     */
    @PostMapping("/try_api_submitTask")
    public SubmitTaskResponse try_api_submitTask(@RequestBody TryApiSubmitTask tryapisubmittask){
        SubmitTaskResponse tryApiAdClickRes = null;
        try {
            tryApiAdClickRes = xianWanTaskService.tryApiSubmitTask(tryapisubmittask);
            return tryApiAdClickRes;
        }catch (Exception e){
            log.error(e);
            log.error("广告点击下载抛异常啦\n");
            log.error(GlobalUtils.format(new Date()));
            return tryApiAdClickRes;
        }
    }


    /**
     *   提交任务答案列表api
     * @param
     * @return
     */
    @PostMapping("/try_api_submitTaskList")
    public SubmitTaskResponse try_api_submitTaskList(@RequestBody TryApiSubmitTaskList tryapisubmittasklist){
        SubmitTaskResponse tryApiAdClickRes = null;
        try {
            tryApiAdClickRes = xianWanTaskService.tryApiSubmitTaskList(tryapisubmittasklist);
            return tryApiAdClickRes;
        }catch (Exception e){
            log.error(e);
            log.error("广告点击下载抛异常啦\n");
            log.error(GlobalUtils.format(new Date()));
            return tryApiAdClickRes;
        }
    }

    /**
     *  cpa广告推荐api
     * @param
     * @return
     */
    @GetMapping("/try_api_submitRecommend")
    public SubmitTaskResponse try_api_submitRecommend(@RequestBody TryApiAdClick tryapiadclick){
        SubmitTaskResponse tryApiAdClickRes = null;
        try {
            tryApiAdClickRes = xianWanTaskService.tryApiSubmitRecommend(tryapiadclick);
            return tryApiAdClickRes;
        }catch (Exception e){
            log.error(e);
            log.error("广告点击下载抛异常啦\n");
            log.error(GlobalUtils.format(new Date()));
            return tryApiAdClickRes;
        }
    }



    /**
     *  图片上传api-表单文件上传
     * @param
     * @return
     */
    @PostMapping("/try_api_uploadScreenshot")
    public SubmitTaskScreenshot try_api_uploadScreenshot(@RequestBody TryApiScreenshot tryapiscreenshot){
        SubmitTaskScreenshot tryApiAdClickRes = null;
        try {
            tryApiAdClickRes = xianWanTaskService.tryApiSubmitScreenshot(tryapiscreenshot);
            return tryApiAdClickRes;
        }catch (Exception e){
            log.error(e);
            log.error("广告点击下载抛异常啦\n");
            log.error(GlobalUtils.format(new Date()));
            return tryApiAdClickRes;
        }
    }




    /**
     *  图片上传api-base64文件上传
     * @param
     * @return
     */
    @PostMapping("/try_api_uploadScreenshotbase")
    public SubmitTaskScreenshot try_api_uploadScreenshotbase(@RequestBody TryApiScreenshotbase tryapiscreenshotbase){
        SubmitTaskScreenshot tryApiAdClickRes = null;
        try {
            tryApiAdClickRes = xianWanTaskService.tryApiSubmitScreenshotbase(tryapiscreenshotbase);
            return tryApiAdClickRes;
        }catch (Exception e){
            log.error(e);
            log.error("广告点击下载抛异常啦\n");
            log.error(GlobalUtils.format(new Date()));
            return tryApiAdClickRes;
        }
    }

    /**
     * 图片前端直传OSS-推荐
     * @param
     * @return
     */
    @PostMapping("/try_api_uploadSignature")
    public SubmitTaskSignature try_api_uploadSignature(@RequestBody TryApiSignature  tryapisignature){
        SubmitTaskSignature tryApiAdClickRes = null;
        try {
            tryApiAdClickRes = xianWanTaskService.tryApiSubmitSignature(tryapisignature);
            return tryApiAdClickRes;
        }catch (Exception e){
            log.error(e);
            log.error("广告点击下载抛异常啦\n");
            log.error(GlobalUtils.format(new Date()));
            return tryApiAdClickRes;
        }
    }








}
