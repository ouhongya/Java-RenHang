package com.renhang.core.apicall.yibangbang.controller;


import com.renhang.common.Utils.GlobalUtils;
import com.renhang.core.apicall.yibangbang.pojo.UserVo;
import com.renhang.core.apicall.yibangbang.service.YiBangBangService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;


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
    public String try_api_list(UserVo uservo)  {
        String response = null;
        try {
             response=mtUserService.TryApiEntry(uservo);
        }catch (Exception e){
            log.error(e);
            log.error(GlobalUtils.format(new Date()));
            return response ;
        }
        return response;
    }


}
