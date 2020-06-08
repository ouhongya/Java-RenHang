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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class XianWanServiceImpl implements XianWanService {

    @Autowired
    XianWanMapper mtUserMapper;

    @Value("${XWAndroid.appsecret}")
    private String XWAndroidAppsecret;
    @Value("${XWAndroid.appId}")
    private String XWAndroidAppid;


    @Value("${XWIOS.appsecret}")
    private String XWIOSAppid;
    @Value("${XWIOS.appId}")
    private String XWIOSAppsecret;


    /**
     * 获取广告列表
     *
     * @param adListBean
     * @return
     */
    @Override
    public TryApiListRes TryApiList(TryApiList adListBean) {
        String url = "https://h5.17xianwan.com/try/API/try_api_list";
        Map<String, Object> map = new HashMap<String, Object>();
        //手机设备号
        String deviceid = adListBean.getDeviceid().isEmpty()?"0":adListBean.getDeviceid();
        //IOS 忽略此参数 安卓操作系统版本号 如:安卓10对应的是参数：androidosv=29 （androidQ即安卓10对应androidosv=29）获取不到请传0
        String androidosv = adListBean.getAndroidosv().isEmpty()?"0":adListBean.getAndroidosv();
        //拉取类型
        String adtype = adListBean.getAdtype().isEmpty()?"0": adListBean.getAdtype();
        //名称查询
        String adname =  adListBean.getAdname().isEmpty()?"":adListBean.getAdname();
        //当前页面
        String page = adListBean.getPage().isEmpty()?"1":adListBean.getPage();
        //每页显示多少
        String pagesize = adListBean.getPagesize().isEmpty()?"200":adListBean.getPagesize();
        //1 iPhone 2 安卓
        map.put("ptype", adListBean.getPtype());
        map.put("deviceid", deviceid);
        map.put("appsign", adListBean.getAppsign());
        String str  = "";
        if(adListBean.getPtype().equals("2")){
            map.put("appid", XWAndroidAppid);
            map.put("appsecret", XWAndroidAppsecret);
            //安全联盟
            map.put("msaoaid", adListBean.getMsaoaid());
            map.put("androidosv",androidosv);
            //appid+deviceid+msaoaid+androidosv+ptype+appsign+appsecret
            str =XWAndroidAppid + deviceid + adListBean.getMsaoaid() +androidosv+ adListBean.getPtype() + adListBean.getAppsign() +XWAndroidAppsecret;
        }else{
            map.put("appid", XWIOSAppid);
            map.put("appsecret", XWIOSAppsecret);
            str = XWIOSAppid+ deviceid + adListBean.getPtype() + adListBean.getAppsign() +XWIOSAppsecret;
        }
        map.put("keycode", MD5.MD5Encode(str, "UTF-8", false));
        map.put("xwversion",2);
        map.put("adtype", adtype);
        map.put("adname", adname);
        map.put("page",page);
        map.put("pagesize", pagesize);
        String res = HttpClientUtils.doGet(url, map);
        TryApiListRes resBean = JSONObject.parseObject(res, TryApiListRes.class);
        return resBean;
    }

    /**
     * 查看广告详情
     *
     * @param tryApiAdInfo
     * @return
     */
    @Override
    public TryApiAdInfoRes TryApiAdInfo(TryApiAdInfo tryApiAdInfo) {
        String url = "https://h5.17xianwan.com/try/API/try_api_adInfo";
        Map<String, Object> map = new HashMap<String, Object>();
        String str  = "";
        //设备号是否为空,空就传0
        String deviceid = tryApiAdInfo.getDeviceid().isEmpty()?"0":tryApiAdInfo.getDeviceid();
        String msaoaid  = tryApiAdInfo.getMsaoaid().isEmpty() ?"" :  tryApiAdInfo.getMsaoaid();
        //广告编号
        map.put("adid", tryApiAdInfo.getAdid());
        //渠道用户id
        map.put("appsign", tryApiAdInfo.getAppsign());
        map.put("ptype", tryApiAdInfo.getPtype());
        //判断当前是1苹果还是2安卓
        if (tryApiAdInfo.getPtype().equals("2")) {
            map.put("appid", XWAndroidAppid);
            map.put("appsecret", XWAndroidAppsecret);
            //IOS 忽略此参数 安卓操作系统版本号 如:29 、28 （android Q 对应 29）
            map.put("androidosv", tryApiAdInfo.getAndroidosv());
            //IOS 忽略此参数 安全联盟OAID （未接入安全联盟请传空字符串“”）
            map.put("msaoaid",msaoaid);
            //字符串拼接
            str = tryApiAdInfo.getPtype() + deviceid + msaoaid + tryApiAdInfo.getAndroidosv() + XWAndroidAppid + tryApiAdInfo.getAppsign() + tryApiAdInfo.getAdid() + XWAndroidAppsecret;
        } else {
            map.put("appid", XWIOSAppid);
            map.put("appsecret", XWIOSAppsecret);
            //字符串拼接
            str = tryApiAdInfo.getPtype() + deviceid+ XWIOSAppid + tryApiAdInfo.getAppsign() + tryApiAdInfo.getAdid() + XWIOSAppsecret;
        }
        map.put("keycode", MD5.MD5Encode(str, "UTF-8", false));
        map.put("xwversion", 2);
        String res = HttpClientUtils.doGet(url, map);
        TryApiAdInfoRes resBean = JSONObject.parseObject(res, TryApiAdInfoRes.class);
        return resBean;
    }

    /**
     * 点击广告下载
     *
     * @param tryApiAdClick
     * @return
     */
    @Override
    public tryApiAdClickRes tryApiAdClick(TryApiAdClick tryApiAdClick) {
        return null;
    }
}
