package com.renhang.core.apicall.kendeji.service.impl;

import com.renhang.core.apicall.kendeji.service.KenDeJiService;
import org.springframework.stereotype.Service;

@Service
public class KenDeJiServiceImpl implements KenDeJiService {

    /**
     * 注册登录并跳转接口
     * @param platformUniqueId
     * @param nickname
     * @param redirectUrl
     * @return
     */
    @Override
    public String platformLogin(String platformUniqueId, String nickname, String redirectUrl) {
        String url = "/api/v2/platform/login";


        return null;
    }
}
