package com.renhang.core.callback.xianwantask.service.impl;

import com.renhang.common.Utils.GlobalUtils;
import com.renhang.common.Utils.MD5;
import com.renhang.core.callback.xianwantask.mapper.XianwanCallbackMapper;
import com.renhang.core.callback.xianwantask.pojo.XianwanCallbackRes;
import com.renhang.core.callback.xianwantask.service.XianwanTaskCallbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class XianwanTaskCallbackServiceImpl implements XianwanTaskCallbackService {

    @Autowired
    XianwanCallbackMapper xianwanCallbackMapper;
    /**
     * 审核结果推送接口(非必须，渠道提供)
     * @param params
     * @return
     */
    @Override
    public XianwanCallbackRes XianwanCallbackService(Map<String,String> params){
        XianwanCallbackRes orderCallbackRes = new XianwanCallbackRes();
        params.put("id",GlobalUtils.uuid());
        params.put("createdTime",new Date().toString());
        //插入数据
        xianwanCallbackMapper.insertOrderToUserCallback(params);
        orderCallbackRes.setSuccess(1);
        orderCallbackRes.setMessage("成功");
        return orderCallbackRes;
    }


}
