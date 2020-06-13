package com.renhang.core.apicall.xianyu.service;

import com.renhang.core.apicall.xianyu.pojo.ApigaoeDetailRes.ApigaoeDetailRes;
import com.renhang.core.apicall.xianyu.pojo.ApigaoeListRes;
import com.renhang.core.apicall.xianyu.pojo.ApigaoeVo;
import com.renhang.core.apicall.xianyu.pojo.TokenVo;
import com.renhang.core.apicall.xianyu.pojo.VerifyVo;

public interface XianYuService {

    ApigaoeVo getToken(TokenVo tokenVo);

    ApigaoeListRes apigaoeList(String token);

    ApigaoeDetailRes apigaoeDetail(String id,String token);

    ApigaoeVo apigaoeApply(String id,String token);

    ApigaoeVo apigaoeCancel(String id,String token);

    ApigaoeVo apigaoeVerify(VerifyVo verifyVo);

}
