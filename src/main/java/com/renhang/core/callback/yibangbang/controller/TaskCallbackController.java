package com.renhang.core.callback.yibangbang.controller;

import com.renhang.common.Utils.GlobalUtils;
import com.renhang.core.callback.yibangbang.pojo.*;
import com.renhang.core.callback.yibangbang.service.TaskCallbackService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RequestMapping("/yibangbang/APICALL")
@RestController
@Log4j2
public class TaskCallbackController {

    @Autowired
    public TaskCallbackService taskCallbackService;

    /**
     * 任务墙处理
     * @param
     * @return
     */
    @GetMapping("/ToTASKAndCallback")
    public String taskAndCallback( @RequestBody ReceiveModel receiveModel ) {
        try {
             String flag= taskCallbackService.TaskCallbackService(receiveModel);
        }catch (Exception e){
            log.error("任务墙回调出现问题\n"+e);
            log.error(GlobalUtils.format(new Date()));
        }
        return "fail";
    }

    /**
     * 获取渠道用户信息(余额保存在渠道)
     * @param
     * @return
     */
    @GetMapping("/ToUserInfoAndCallback")
    public Item taskToUserAndCallback(@RequestBody ItemModel itemmodel) {
        try {
            Items items = taskCallbackService.TaskUserCallbackService(itemmodel);
            Item item=new Item();
            item.setCode(0);
            item.setMsg("获取成功");
            item.setItems(items);
            item.setWait(3);
            return  item;
        }catch (Exception e){
            log.error("任务墙回调出现问题\n"+e);
            log.error(GlobalUtils.format(new Date()));
        }
        Item item=new Item();
        item.setCode(1);
        item.setMsg("获失败");
        return  item;
    }


}
