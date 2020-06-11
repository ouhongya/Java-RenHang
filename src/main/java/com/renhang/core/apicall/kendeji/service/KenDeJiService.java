package com.renhang.core.apicall.kendeji.service;

import com.renhang.core.apicall.kendeji.pojo.GetTokenVo;
import com.renhang.core.apicall.kendeji.pojo.KfcFrontendUrl;
import com.renhang.core.apicall.kendeji.pojo.KfcFrontendUrlVo;
import com.renhang.core.apicall.kendeji.pojo.PagedQuery;
import com.renhang.core.callback.kendeji.pojo.KfcOrder;
import com.renhang.core.callback.kendeji.pojo.KfcOrderList;

import java.net.URI;
import java.net.URISyntaxException;

public interface KenDeJiService {

    String platformLogin(String platformUniqueId, String nickname, String redirectUrl) throws URISyntaxException;

    String platformLoginV2(String platformUniqueId, String nickname, String mobile, String redirectUrl) throws URISyntaxException;

    KfcOrder getByOrderNo(String orderNo);

    KfcOrderList listByBatchOrderNos(String orderNo);

    KfcOrderList pagedQuery(PagedQuery pagedQuery);

    GetTokenVo getTokenVoV1(String platformUniqueId, String nickname);

    GetTokenVo getTokenVoV2(String platformUniqueId, String nickname,String mobile) throws URISyntaxException;

    KfcFrontendUrlVo getKfcFrontendUrl();
}
