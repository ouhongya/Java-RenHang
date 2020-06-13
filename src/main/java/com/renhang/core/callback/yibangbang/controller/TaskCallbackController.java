package com.renhang.core.callback.yibangbang.controller;

import com.renhang.common.Utils.GlobalUtils;
import com.renhang.common.Utils.HttpClientUtils;
import com.renhang.common.Utils.MD5;
import com.renhang.core.callback.yibangbang.pojo.*;
import com.renhang.core.callback.yibangbang.service.TaskCallbackService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/yibangbang/APICALL")
@RestController
@Log4j2
public class TaskCallbackController {

    @Autowired
    public TaskCallbackService taskCallbackService;

//    /**
//     * 我方无法获取用户信息，在另一方实现
//     * 任务墙处理
//     * @param
//     * @return
//     */
//    @PostMapping("/ToTASKAndCallback")
//    public String taskAndCallback(@RequestBody ReceiveModel receiveModel ) {
//        try {
//             String flag= taskCallbackService.TaskCallbackService(receiveModel);
//             return flag;
//        }catch (Exception e){
//            log.error("任务墙回调出现问题\n"+e);
//            log.error(GlobalUtils.format(new Date()));
//        }
//        return "fail";
//    }

//    /**
//     * 我方无法获取用户信息，在另一方实现
//     * 获取渠道用户信息(余额保存在渠道)
//     * @param
//     * @return
//     */
//    @GetMapping("/ToUserInfoAndCallback")
//    public Item taskToUserAndCallback(ItemModel itemmodel) {
//        Item items=null;
//        try {
////          items = taskCallbackService.TaskUserCallbackService(itemmodel);
//            items=new Item();
//            items.setCode(0);
//            items.setMsg("获取成功");
//            items.setWait(3);
//            Items Item=new Items();
//            Item.setName("测试2");
//            Item.setHead_img("https://pics1.baidu.com/feed/94cad1c8a786c917095eebdb257cbdc93ac757bf.jpeg?token=0c5fff1f7f3536e9ea8a4551e1eddcd5");
//            Item.setBalance(0.00);
//            Item.setReward("0.00");
//            items.setItems(Item);
//            Map<String,Object> map=new HashMap<String,Object>();
//            map.put("phone",itemmodel.getPhone());
//            map.put("timestamp",new Date().getTime());
//            String str=itemmodel.getPhone()+"bkmm00362"+"QMUe";
//            String res = MD5.MD5Encode(str, "UTF-8", false);
//            map.put("signature",res);
//            String response = HttpClientUtils.doGet("https://c.buuyee.com/api/external",map);
//
//            return  items;
//        }catch (Exception e){
//            log.error("任务墙回调出现问题\n"+e);
//            log.error(GlobalUtils.format(new Date()));
//        }
//        return  items;
//    }


}
