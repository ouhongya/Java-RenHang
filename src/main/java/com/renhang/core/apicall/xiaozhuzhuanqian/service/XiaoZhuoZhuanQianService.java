package com.renhang.core.apicall.xiaozhuzhuanqian.service;

import com.renhang.core.apicall.xiaozhuzhuanqian.pojo.ApigaoeDetailRes.ApigaoeDetailRes;
import com.renhang.core.apicall.xiaozhuzhuanqian.pojo.ApigaoeListRes;
import com.renhang.core.apicall.xiaozhuzhuanqian.pojo.TokenRes;
import com.renhang.core.apicall.xiaozhuzhuanqian.pojo.TokenVo;

public interface XiaoZhuoZhuanQianService {

    TokenRes getToken(TokenVo tokenVo);

    ApigaoeListRes apigaoeList();

    ApigaoeDetailRes apigaoeDetail(String id);
}
