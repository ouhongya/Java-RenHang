package com.renhang.core.callback.yibangbang.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.renhang.common.Utils.HttpClientUtils;
import com.renhang.common.Utils.IDUtils;
import com.renhang.common.Utils.MD5;
import com.renhang.core.callback.yibangbang.mapper.TaskCallbackMapper;
import com.renhang.core.callback.yibangbang.pojo.*;
import com.renhang.core.callback.yibangbang.service.TaskCallbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TaskCallbackServiceImpl implements TaskCallbackService {
    @Value("${TaskEntry.name}")
    private String taskentryname;
    @Value("${TaskEntry.secret}")
    private String taskentrysecret;

    @Autowired
    TaskCallbackMapper taskCallbackMapper;
    /**
     * 任务墙处理
     * @param
     * @return
     */

    @Override
    public String TaskCallbackService(ReceiveModel receiveModel) {
        try{
            String id = IDUtils.get32UUID();
            receiveModel.setId(id);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = formatter.format(new Date());
            receiveModel.setCreate_time(dateString);
            taskCallbackMapper.insertTaskCallback(receiveModel);
            reqData[] reqData = receiveModel.getReqData();
            for(reqData reqdata :reqData){
                reqdata.setId(IDUtils.get32UUID());
                reqdata.setTask_id(id);
                String dateStr= formatter.format(new Date());
                reqdata.setCreate_time(dateStr);
                taskCallbackMapper.insertTaskreqDataCallback(reqdata);
            }
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }


    }

    @Override
    public Item TaskUserCallbackService(ItemModel itemmodel) {
        try{
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("phone",itemmodel.getPhone());
            map.put("channel",taskentryname);
            map.put("time",new Date().getTime());
            String str=itemmodel.getPhone()+taskentryname+taskentrysecret;
            String res = MD5.MD5Encode(str, "UTF-8", false);
            map.put("signature",res);
            String response = HttpClientUtils.doGet("https://dev.ehelp.yunbangyin.com/api/external",map);
            Item resBean = JSONObject.parseObject(res, Item.class);
            Map<String,String> obj =new HashMap<String, String>();
            obj.put("id",IDUtils.get32UUID());
            obj.put("code",resBean.getCode());
            obj.put("msg",resBean.getMsg());
            obj.put("name",resBean.getItems().getName());
            obj.put("head_img",resBean.getItems().getHead_img());
            obj.put("balance",resBean.getItems().getBalance());
            obj.put("reward",resBean.getItems().getReward());
            obj.put("wait",resBean.getWait());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
             String dateString = formatter.format(new Date());
            obj.put("createdTime",dateString);
            taskCallbackMapper.insertUser(obj);
            return resBean;
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }

    }


}
