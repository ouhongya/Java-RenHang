package com.renhang.core.apicall.xianyu.service;

import com.renhang.core.apicall.xianyu.pojo.ApigaoeDetailRes.ApigaoeDetailRes;
import com.renhang.core.apicall.xianyu.pojo.ApigaoeListRes;
import com.renhang.core.apicall.xianyu.pojo.ApigaoeVo;
import com.renhang.core.apicall.xianyu.pojo.TokenVo;
import com.renhang.core.apicall.xianyu.pojo.VerifyVo;

public interface XianYuService {

    ApigaoeVo getToken(TokenVo tokenVo);

    ApigaoeListRes apigaoeList();

    ApigaoeDetailRes apigaoeDetail(String id);

    ApigaoeVo apigaoeApply(String id);

    ApigaoeVo apigaoeCancel(String id);

    ApigaoeVo apigaoeVerify(VerifyVo verifyVo);

}
