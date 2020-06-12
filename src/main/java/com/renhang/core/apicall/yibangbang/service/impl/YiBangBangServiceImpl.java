package com.renhang.core.apicall.yibangbang.service.impl;


import com.renhang.common.Utils.HttpClientUtils;
import com.renhang.common.Utils.MD5;
import com.renhang.core.apicall.yibangbang.pojo.TaskEntry;
import com.renhang.core.apicall.yibangbang.pojo.UserVo;
import com.renhang.core.apicall.yibangbang.service.YiBangBangService;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.net.URI;
import java.net.URISyntaxException;
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
    public String TryApiEntry(UserVo uservo) throws URISyntaxException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("phone", uservo.getPhone());
        int areacode=uservo.getArea_code();
        if(areacode != 0){
            map.put("area_code", areacode);
        }
        map.put("channel", taskentryname);
        String str = uservo.getPhone() + taskentryname + taskentrysecret;
        String res = MD5.MD5Encode(str, "UTF-8", false);
        map.put("time", System.currentTimeMillis());
        map.put("signature", res);
        // 创建uri
        String url = "https://c.buuyee.com/api/external";
        URIBuilder builder = new URIBuilder(url);
        for (String key : map.keySet()) {
            builder.addParameter(key, map.get(key).toString());
        }
        return builder.build().toString();
    }

}
