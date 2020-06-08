package com.renhang.core.apicall.xianwan.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.renhang.common.Utils.HttpClientUtils;
import com.renhang.common.Utils.MD5;
import com.renhang.core.apicall.xianwan.mapper.XianWanMapper;
import com.renhang.core.apicall.xianwan.pojo.TryApiAdClick;
import com.renhang.core.apicall.xianwan.pojo.TryApiAdInfo;
import com.renhang.core.apicall.xianwan.pojo.TryApiAdInfoRes.TryApiAdInfoRes;
import com.renhang.core.apicall.xianwan.pojo.TryApiList;
import com.renhang.core.apicall.xianwan.pojo.TryApiListRes.TryApiListRes;
import com.renhang.core.apicall.xianwan.pojo.tryApiAdClickRes;
import com.renhang.core.apicall.xianwan.service.XianWanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class XianWanServiceImpl implements XianWanService {

    @Autowired
    XianWanMapper mtUserMapper;


    /**
     * 获取广告列表
     * @param adListBean
     * @return
     */
    @Override
    public TryApiListRes TryApiList(TryApiList adListBean) {
        String url = "https://h5.17xianwan.com/try/API/try_api_list";
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("ptype",adListBean.getPtype());
        map.put("deviceid",adListBean.getDeviceid());
        map.put("appid",adListBean.getAppid());
        map.put("appsign",adListBean.getAppsign());
        map.put("msaoaid",adListBean.getMsaoaid());
        map.put("androidosv",adListBean.getAndroidosv());
        map.put("appsecret","zmfr6t6myz7h9akz");
        String str = adListBean.getAppid()+adListBean.getDeviceid()+adListBean.getMsaoaid()+adListBean.getAndroidosv()+adListBean.getPtype()+adListBean.getAppsign()+"zmfr6t6myz7h9akz";
        map.put("keycode", MD5.MD5Encode(str,"UTF-8",false));
        map.put("xwversion",adListBean.getXwversion());
        map.put("adtype",adListBean.getAdtype());
        map.put("adname",adListBean.getAdname());
        map.put("page",adListBean.getPage());
        map.put("pagesize",adListBean.getPagesize());
        String res = HttpClientUtils.doGet(url, map);
        TryApiListRes resBean = JSONObject.parseObject(res, TryApiListRes.class);
        return resBean;
    }

    /**
     * 查看广告详情
     * @param tryApiAdInfo
     * @return
     */
    @Override
    public TryApiAdInfoRes TryApiAdInfo(TryApiAdInfo tryApiAdInfo) {
        String url = "https://h5.17xianwan.com/try/API/try_api_adInfo";
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("ptype",tryApiAdInfo.getPtype());
        map.put("deviceid",tryApiAdInfo.getDeviceid());
        map.put("msaoaid",tryApiAdInfo.getMsaoaid());
        map.put("androidosv",tryApiAdInfo.getAndroidosv());
        map.put("appid",tryApiAdInfo.getAppid());
        map.put("adid",tryApiAdInfo.getAdid());
        map.put("appsign",tryApiAdInfo.getAppsign());
        map.put("appsecret","zmfr6t6myz7h9akz");
        String str = tryApiAdInfo.getPtype()+tryApiAdInfo.getDeviceid()+tryApiAdInfo.getMsaoaid()
                +tryApiAdInfo.getAndroidosv()+tryApiAdInfo.getAppid()+tryApiAdInfo.getAppsign()+tryApiAdInfo.getAdid()+"zmfr6t6myz7h9akz";
        map.put("keycode", MD5.MD5Encode(str,"UTF-8",false));
        map.put("xwversion",2);
        String res = HttpClientUtils.doGet(url, map);
        TryApiAdInfoRes resBean = JSONObject.parseObject(res, TryApiAdInfoRes.class);
        return resBean;
    }

    /**
     * 点击广告下载
     * @param tryApiAdClick
     * @return
     */
    @Override
    public tryApiAdClickRes tryApiAdClick(TryApiAdClick tryApiAdClick) {
        return null;
    }
}
