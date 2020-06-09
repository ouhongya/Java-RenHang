package com.renhang.core.apicall.xiaozhuzhuanqian.service;

import com.renhang.core.apicall.xiaozhuzhuanqian.pojo.ApigaoeDetailRes.ApigaoeDetailRes;
import com.renhang.core.apicall.xiaozhuzhuanqian.pojo.ApigaoeListRes;
import com.renhang.core.apicall.xiaozhuzhuanqian.pojo.ApigaoeVo;
import com.renhang.core.apicall.xiaozhuzhuanqian.pojo.TokenVo;
import com.renhang.core.apicall.xiaozhuzhuanqian.pojo.VerifyVo;

public interface XiaoZhuoZhuanQianService {

    ApigaoeVo getToken(TokenVo tokenVo);

    ApigaoeListRes apigaoeList();

    ApigaoeDetailRes apigaoeDetail(String id);

    ApigaoeVo apigaoeApply(String id);

    ApigaoeVo apigaoeCancel(String id);

    ApigaoeVo apigaoeVerify(VerifyVo verifyVo);

}
