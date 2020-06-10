package com.renhang.core.apicall.xianyu.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.renhang.common.Utils.HttpClientUtils;
import com.renhang.common.Utils.MD5;
import com.renhang.core.apicall.xianyu.pojo.ApigaoeDetailRes.ApigaoeDetailRes;
import com.renhang.core.apicall.xianyu.pojo.ApigaoeListRes;
import com.renhang.core.apicall.xianyu.pojo.ApigaoeVo;
import com.renhang.core.apicall.xianyu.pojo.TokenVo;
import com.renhang.core.apicall.xianyu.pojo.VerifyVo;
import com.renhang.core.apicall.xianyu.service.XianYuService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class XianYuServiceImpl implements XianYuService {

    @Value("${XYWeb.id}")
    private String id;
    @Value("${XYWeb.appKey}")
    private String appKey;

    /**
     * 获取token
     * @param tokenVo
     * @return
     */
    @Override
    public ApigaoeVo getToken(TokenVo tokenVo) {
        String url = "http://xyzqdsp.niaogebiji.com/sspmdl/gettoken";
        Map<String,String> map = new HashMap<>();
        map.put("device",tokenVo.getDevice());
        map.put("id",id);
        map.put("phone",tokenVo.getPhone().toString());
        map.put("uid",tokenVo.getUid().toString());
        String str = "device=" +tokenVo.getDevice()+"&id="+id+"&phone="+tokenVo.getPhone()+"&uid="+tokenVo.getUid()+"&";
        //进⾏base64编码
        String encodeData = MD5.encodeData(str)+appKey;
        //对拼接key的字符串进行md5加密，最后的值即为sign值
        String sign = MD5.MD5Encode(encodeData,"UTF-8",false);
        map.put("sign",sign);
        //发请求拿数据
        String res = HttpClientUtils.doPost(url, map);
        ApigaoeVo apigaoeVo = JSONObject.parseObject(res, ApigaoeVo.class);
        return apigaoeVo;
    }

    /**
     * 获取截图投放列表
     * @return
     */
    @Override
    public ApigaoeListRes apigaoeList() {
        String url = "http://xyzqdsp.niaogebiji.com/sspmdl/apigaoe/list";
        String headerKey ="Cookie";
        String headerVal ="ssp_api_token="+"eyJwdWJsaXNoIjoxNTkxNjg3OTI2LCJleHBpcmUiOjE1OTE3MzExMjYsImF1dGgiOiJkaXlNRDUifQ%3D%3D.eyJ1c2VyIjp7InBob25lIjoxLCJkZXZpY2UiOiI4NjQ4MDQwMzE2MTg3OTYiLCJkZXZpY2UyIjoiIiwibWVkaWFfaWQiOjQ1OCwicmVndGltZSI6MTU5MTY4NzkyNiwidXNlcl9pZCI6OTg3NjU0MzIxLCJwcm9wZXJ0eSI6MCwidmVyc2lvbiI6MSwiaWQiOiI1MDQ1NjUwIn0sIm1lZGlhIjp7ImlkIjo0NTgsInR5cGUiOiIzIiwiam9pbl90eXBlIjoxLCJ0YXNrX3R5cGUiOiIxMiIsIndpdGhkcmF3X3R5cGUiOiIyIiwiZXhjaGFuZ2VfcmF0ZSI6IjEiLCJjdXJyZW5jeV91bml0IjoiXHU1MTQzIn19.d9fa3cb10b81fa1e4fee5242c12525bc";
        String res = HttpClientUtils.doGet(url,headerKey,headerVal);
        ApigaoeListRes apigaoeListRes = JSONObject.parseObject(res, ApigaoeListRes.class);
        return apigaoeListRes;
    }

    /**
     *获取截图详细信息
     * @param id
     * @return
     */
    @Override
    public ApigaoeDetailRes apigaoeDetail(String id) {
        String url = "http://xyzqdsp.niaogebiji.com/sspmdl/apigaoe/detail";
        String headerKey ="Cookie";
        String headerVal ="ssp_api_token="+"eyJwdWJsaXNoIjoxNTkxNjg3OTI2LCJleHBpcmUiOjE1OTE3MzExMjYsImF1dGgiOiJkaXlNRDUifQ%3D%3D.eyJ1c2VyIjp7InBob25lIjoxLCJkZXZpY2UiOiI4NjQ4MDQwMzE2MTg3OTYiLCJkZXZpY2UyIjoiIiwibWVkaWFfaWQiOjQ1OCwicmVndGltZSI6MTU5MTY4NzkyNiwidXNlcl9pZCI6OTg3NjU0MzIxLCJwcm9wZXJ0eSI6MCwidmVyc2lvbiI6MSwiaWQiOiI1MDQ1NjUwIn0sIm1lZGlhIjp7ImlkIjo0NTgsInR5cGUiOiIzIiwiam9pbl90eXBlIjoxLCJ0YXNrX3R5cGUiOiIxMiIsIndpdGhkcmF3X3R5cGUiOiIyIiwiZXhjaGFuZ2VfcmF0ZSI6IjEiLCJjdXJyZW5jeV91bml0IjoiXHU1MTQzIn19.d9fa3cb10b81fa1e4fee5242c12525bc";
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        String res = HttpClientUtils.doGet(url,map,headerKey,headerVal);
        ApigaoeDetailRes apigaoeDetailRes = JSONObject.parseObject(res, ApigaoeDetailRes.class);
        return apigaoeDetailRes;
    }

    /**
     * 请求领取任务
     * @param id
     * @return
     */
    @Override
    public ApigaoeVo apigaoeApply(String id) {
        String url = "http://xyzqdsp.niaogebiji.com/sspmdl/apigaoe/apply";
        String headerKey ="Cookie";
        String headerVal ="ssp_api_token="+"eyJwdWJsaXNoIjoxNTkxNjg3OTI2LCJleHBpcmUiOjE1OTE3MzExMjYsImF1dGgiOiJkaXlNRDUifQ%3D%3D.eyJ1c2VyIjp7InBob25lIjoxLCJkZXZpY2UiOiI4NjQ4MDQwMzE2MTg3OTYiLCJkZXZpY2UyIjoiIiwibWVkaWFfaWQiOjQ1OCwicmVndGltZSI6MTU5MTY4NzkyNiwidXNlcl9pZCI6OTg3NjU0MzIxLCJwcm9wZXJ0eSI6MCwidmVyc2lvbiI6MSwiaWQiOiI1MDQ1NjUwIn0sIm1lZGlhIjp7ImlkIjo0NTgsInR5cGUiOiIzIiwiam9pbl90eXBlIjoxLCJ0YXNrX3R5cGUiOiIxMiIsIndpdGhkcmF3X3R5cGUiOiIyIiwiZXhjaGFuZ2VfcmF0ZSI6IjEiLCJjdXJyZW5jeV91bml0IjoiXHU1MTQzIn19.d9fa3cb10b81fa1e4fee5242c12525bc";
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        String res = HttpClientUtils.doGet(url,map,headerKey,headerVal);
        ApigaoeVo apigaoeVo = JSONObject.parseObject(res, ApigaoeVo.class);
        return apigaoeVo;
    }

    /**
     * 请求释放任务
     * @param id
     * @return
     */
    @Override
    public ApigaoeVo apigaoeCancel(String id) {
        String url = "http://xyzqdsp.niaogebiji.com/sspmdl/apigaoe/cancel";
        String headerKey ="Cookie";
        String headerVal ="ssp_api_token="+"eyJwdWJsaXNoIjoxNTkxNjg3OTI2LCJleHBpcmUiOjE1OTE3MzExMjYsImF1dGgiOiJkaXlNRDUifQ%3D%3D.eyJ1c2VyIjp7InBob25lIjoxLCJkZXZpY2UiOiI4NjQ4MDQwMzE2MTg3OTYiLCJkZXZpY2UyIjoiIiwibWVkaWFfaWQiOjQ1OCwicmVndGltZSI6MTU5MTY4NzkyNiwidXNlcl9pZCI6OTg3NjU0MzIxLCJwcm9wZXJ0eSI6MCwidmVyc2lvbiI6MSwiaWQiOiI1MDQ1NjUwIn0sIm1lZGlhIjp7ImlkIjo0NTgsInR5cGUiOiIzIiwiam9pbl90eXBlIjoxLCJ0YXNrX3R5cGUiOiIxMiIsIndpdGhkcmF3X3R5cGUiOiIyIiwiZXhjaGFuZ2VfcmF0ZSI6IjEiLCJjdXJyZW5jeV91bml0IjoiXHU1MTQzIn19.d9fa3cb10b81fa1e4fee5242c12525bc";
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        String res = HttpClientUtils.doGet(url,map,headerKey,headerVal);
        ApigaoeVo apigaoeVo = JSONObject.parseObject(res, ApigaoeVo.class);
        return apigaoeVo;
    }

    /**
     * 截图提交信息
     * @param verifyVo
     * @return
     */
    @Override
    public ApigaoeVo apigaoeVerify(VerifyVo verifyVo) {
        String url = "http://xyzqdsp.niaogebiji.com/sspmdl/apigaoe/verify";
        Map<String,String> map = new HashMap<>();
        map.put("id",verifyVo.getId());
        map.put("pics",verifyVo.getPics());
        map.put("mobile",verifyVo.getMobile());
        map.put("userName",verifyVo.getUserName());
        map.put("realName",verifyVo.getRealName());
        map.put("others",verifyVo.getOthers());
        String headerKey = "Cookie";
        String headerVal = "ssp_api_token="+"eyJwdWJsaXNoIjoxNTY1NzU1MTEyLCJleHBpcmUiOjE1NjU3OTgzMTIsImF1dGgiOiJkaXlITUFDIn0";
        String res = HttpClientUtils.doPost(url, map, headerKey, headerVal);
        ApigaoeVo apigaoeVo = JSONObject.parseObject(res, ApigaoeVo.class);
        return apigaoeVo;
    }
}
