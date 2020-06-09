package com.renhang.core.apicall.yibangbang.service.impl;



import com.renhang.common.Utils.HttpClientUtils;
import com.renhang.core.apicall.yibangbang.service.YiBangBangService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
public class YiBangBangServiceImpl implements YiBangBangService {
//渠道密钥JWV:QMUe
//渠道别名bkmm00362
    @Override
    public String TryApiEntry(int phone, String channel) {
            String md5=String.valueOf(phone)+channel+"";
            String signature = DigestUtils.md5DigestAsHex(md5.getBytes());
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("phone",phone);
            map.put("channel",channel);
            map.put("time",new Date().getTime());
            map.put("signature",signature);
            String response = HttpClientUtils.doGet("https://dev.ehelp.yunbangyin.com/api/external",map);
            return response;
    }



}
