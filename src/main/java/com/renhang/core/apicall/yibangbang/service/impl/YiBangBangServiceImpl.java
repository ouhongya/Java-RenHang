package com.renhang.core.apicall.yibangbang.service.impl;



import com.renhang.common.Utils.HttpClientUtils;
import com.renhang.common.Utils.MD5;
import com.renhang.core.apicall.yibangbang.pojo.TaskEntry;
import com.renhang.core.apicall.yibangbang.service.YiBangBangService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
public class YiBangBangServiceImpl implements YiBangBangService {

    @Value("${TaskEntry.name}")
    private String taskentryname;
    @Value("${TaskEntry.secret}")
    private String taskentrysecret;
    @Override
    public String TryApiEntry(TaskEntry taskentry) {
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("phone",taskentry.getPhone());
            map.put("channel",taskentryname);
            map.put("time",new Date().getTime());
            String str=taskentry.getPhone()+taskentryname+taskentrysecret;
            String res = MD5.MD5Encode(str, "UTF-8", false);
            map.put("signature",res);
            String response = HttpClientUtils.doGet("https://c.buuyee.com/api/external",map);
            return response;
    }
}
