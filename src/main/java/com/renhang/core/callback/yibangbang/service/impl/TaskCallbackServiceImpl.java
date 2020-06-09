package com.renhang.core.callback.yibangbang.service.impl;

import com.renhang.common.Utils.HttpClientUtils;
import com.renhang.common.Utils.IDUtils;
import com.renhang.core.callback.yibangbang.mapper.TaskCallbackMapper;
import com.renhang.core.callback.yibangbang.pojo.ItemModel;
import com.renhang.core.callback.yibangbang.pojo.Items;
import com.renhang.core.callback.yibangbang.pojo.ReceiveModel;
import com.renhang.core.callback.yibangbang.pojo.reqData;
import com.renhang.core.callback.yibangbang.service.TaskCallbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TaskCallbackServiceImpl implements TaskCallbackService {

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
            receiveModel.setCreate_time(new Date());
            taskCallbackMapper.insertTaskCallback(receiveModel);
            reqData[] reqData = receiveModel.getReqData();
            for(reqData reqdata :reqData){
                reqdata.setId(IDUtils.get32UUID());
                reqdata.setTask_id(id);
                reqdata.setCreate_time(new Date());
                taskCallbackMapper.insertTaskreqDataCallback(reqdata);
            }
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }


    }

    @Override
    public Items TaskUserCallbackService(ItemModel itemmodel) {
        try{
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("phone",itemmodel.getPhone());
            map.put("channel",itemmodel.getChannel());
            map.put("time",itemmodel.getTimestamp());
            map.put("signature",itemmodel.getSignature());
            String response = HttpClientUtils.doGet("https://dev.ehelp.yunbangyin.com/api/external",map);
            Items userbyphone = taskCallbackMapper.findUserbyphone(itemmodel.getPhone());
            userbyphone.setBalance(response);
            return userbyphone;
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }

    }


}
