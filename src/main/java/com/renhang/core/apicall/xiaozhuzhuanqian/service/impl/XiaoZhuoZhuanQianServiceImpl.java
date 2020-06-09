package com.renhang.core.apicall.xiaozhuzhuanqian.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.renhang.common.Utils.HttpClientUtils;
import com.renhang.common.Utils.MD5;
import com.renhang.core.apicall.xiaozhuzhuanqian.pojo.ApigaoeDetailRes.ApigaoeDetailRes;
import com.renhang.core.apicall.xiaozhuzhuanqian.pojo.ApigaoeListRes;
import com.renhang.core.apicall.xiaozhuzhuanqian.pojo.ApigaoeVo;
import com.renhang.core.apicall.xiaozhuzhuanqian.pojo.TokenVo;
import com.renhang.core.apicall.xiaozhuzhuanqian.pojo.VerifyVo;
import com.renhang.core.apicall.xiaozhuzhuanqian.service.XiaoZhuoZhuanQianService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class XiaoZhuoZhuanQianServiceImpl implements XiaoZhuoZhuanQianService {

    @Value("${XYWeb.id}")
    private String id;
    @Value("${XYWeb.appKey}")
    private String appKey;

    /**
     * 获取token
     * @param tokenVo
     * @return
     * MD5(base64 ( " device = 864804031618796 & id = 12 & phone = 2 & uid = 12322 & ") + "c37e5e4685bee3564f" )
     */
    @Override
    public ApigaoeVo getToken(TokenVo tokenVo) {
        String url = "http://xyzqdsp.niaogebiji.com/sspmdl/gettoken";
        Map<String,String> map = new HashMap<>();
        map.put("device",tokenVo.getDevice());
        map.put("device2","");
        map.put("id",id);
        map.put("phone",tokenVo.getPhone().toString());
        map.put("uid",tokenVo.getUid().toString());
        String str = "device=" +tokenVo.getDevice()+"&id="+id+"&phone="+tokenVo.getPhone()+"&uid="+tokenVo.getUid()+"&";
        //进⾏base64编码
        String encodeData = MD5.encodeData(str)+appKey;
        //对拼接key的字符串进行md5加密，最后的值即为sign值
        String sign = MD5.getMD5(encodeData);
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
        String headerVal ="ssp_api_token="+"eyJwdWJsaXNoIjoxNTY1NzU1MTEyLCJleHBpcmUiOjE1NjU3OTgzMTIsImF1dGgiOiJkaXlITUFDIn0%253D.eyJ1c2VyIjp7ImlkIjoiMTE4IiwicGhvbmUiOiIyIiwiZGV2aWNlIjoiNThCQjZEQTgtMkZDNy00RTAyLTg3RkYtN0IzMjdBMUEyRjg1IiwibWVkaWFfaWQiOiIxMTEiLCJ1c2VyX2lkIjoiMTEwIiwicHJvcGVydHkiOiIyMSJ9LCJtZWRpYSI6eyJpZCI6MTExLCJ0YXNrX3R5cGUiOiIxMjMiLCJ3aXRoZHJhd190eXBlIjoiMSIsImV4Y2hhbmdlX3JhdGUiOiIxMDAwIiwiY3VycmVuY3lfdW5pdCI6Ilx1NWUwMSJ9fQ%253D%253D.b44d1eba51abf41b93adda5f547e2bda5bfbaa53cf124e9eb26efa1ead9793ec";
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
        String headerVal ="ssp_api_token="+"eyJwdWJsaXNoIjoxNTY1NzU1MTEyLCJleHBpcmUiOjE1NjU3OTgzMTIsImF1dGgiOiJkaXlITUFDIn0%253D.eyJ1c2VyIjp7ImlkIjoiMTE4IiwicGhvbmUiOiIyIiwiZGV2aWNlIjoiNThCQjZEQTgtMkZDNy00RTAyLTg3RkYtN0IzMjdBMUEyRjg1IiwibWVkaWFfaWQiOiIxMTEiLCJ1c2VyX2lkIjoiMTEwIiwicHJvcGVydHkiOiIyMSJ9LCJtZWRpYSI6eyJpZCI6MTExLCJ0YXNrX3R5cGUiOiIxMjMiLCJ3aXRoZHJhd190eXBlIjoiMSIsImV4Y2hhbmdlX3JhdGUiOiIxMDAwIiwiY3VycmVuY3lfdW5pdCI6Ilx1NWUwMSJ9fQ%253D%253D.b44d1eba51abf41b93adda5f547e2bda5bfbaa53cf124e9eb26efa1ead9793ec";
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
        String headerVal ="ssp_api_token="+"eyJwdWJsaXNoIjoxNTY1NzU1MTEyLCJleHBpcmUiOjE1NjU3OTgzMTIsImF1dGgiOiJkaXlITUFDIn0%253D.eyJ1c2VyIjp7ImlkIjoiMTE4IiwicGhvbmUiOiIyIiwiZGV2aWNlIjoiNThCQjZEQTgtMkZDNy00RTAyLTg3RkYtN0IzMjdBMUEyRjg1IiwibWVkaWFfaWQiOiIxMTEiLCJ1c2VyX2lkIjoiMTEwIiwicHJvcGVydHkiOiIyMSJ9LCJtZWRpYSI6eyJpZCI6MTExLCJ0YXNrX3R5cGUiOiIxMjMiLCJ3aXRoZHJhd190eXBlIjoiMSIsImV4Y2hhbmdlX3JhdGUiOiIxMDAwIiwiY3VycmVuY3lfdW5pdCI6Ilx1NWUwMSJ9fQ%253D%253D.b44d1eba51abf41b93adda5f547e2bda5bfbaa53cf124e9eb26efa1ead9793ec";
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
        String headerVal ="ssp_api_token="+"eyJwdWJsaXNoIjoxNTY1NzU1MTEyLCJleHBpcmUiOjE1NjU3OTgzMTIsImF1dGgiOiJkaXlITUFDIn0%253D.eyJ1c2VyIjp7ImlkIjoiMTE4IiwicGhvbmUiOiIyIiwiZGV2aWNlIjoiNThCQjZEQTgtMkZDNy00RTAyLTg3RkYtN0IzMjdBMUEyRjg1IiwibWVkaWFfaWQiOiIxMTEiLCJ1c2VyX2lkIjoiMTEwIiwicHJvcGVydHkiOiIyMSJ9LCJtZWRpYSI6eyJpZCI6MTExLCJ0YXNrX3R5cGUiOiIxMjMiLCJ3aXRoZHJhd190eXBlIjoiMSIsImV4Y2hhbmdlX3JhdGUiOiIxMDAwIiwiY3VycmVuY3lfdW5pdCI6Ilx1NWUwMSJ9fQ%253D%253D.b44d1eba51abf41b93adda5f547e2bda5bfbaa53cf124e9eb26efa1ead9793ec";
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
