package com.renhang.core.apicall.yibangbang.controller;

import com.renhang.common.Result.CommonCode;
import com.renhang.common.Result.ResponseResult;
import com.renhang.common.Utils.GlobalUtils;
import com.renhang.common.Utils.HttpClientUtils;
import com.renhang.core.apicall.yibangbang.pojo.TaskEntry;
import com.renhang.core.apicall.yibangbang.service.YiBangBangService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/yibangbang/API")
@Log4j2
public class YiBangBangController {


    @Autowired
    YiBangBangService mtUserService;

    /**
     * 任务墙入口
     * @param
     * @return
     */
    @GetMapping("/try_api_entry")
    public String try_api_list(TaskEntry taskentry) {
        try {
            String response = mtUserService.TryApiEntry(taskentry);
            return response;
        }catch (Exception e){
            log.error(e);
            log.error(GlobalUtils.format(new Date()));
            return "fail";
        }
    }



}
