package com.renhang.core.apicall.xianwan.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.renhang.common.Utils.HttpClientUtils;
import com.renhang.common.Utils.MD5;
import com.renhang.core.apicall.xianwan.pojo.TryApiAdClick.TryApiAdClick;
import com.renhang.core.apicall.xianwan.pojo.TryApiAdInfo;
import com.renhang.core.apicall.xianwan.pojo.TryApiAdInfoRes.TryApiAdInfoRes;
import com.renhang.core.apicall.xianwan.pojo.TryApiList;
import com.renhang.core.apicall.xianwan.pojo.TryApiListRes.TryApiListRes;
import com.renhang.core.apicall.xianwan.pojo.TryApiAdClick.TryApiAdClickRes;
import com.renhang.core.apicall.xianwan.service.XianWanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class XianWanServiceImpl implements XianWanService {


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
        //IOS 忽略此参数 安全联盟OAID （未接入安全联盟请传空字符串“”）
        String msaoaid  = tryApiAdInfo.getMsaoaid().isEmpty() ?"" :  tryApiAdInfo.getMsaoaid();
        //IOS 忽略此参数 安卓操作系统版本号 如:安卓10对应的是参数：androidosv=29 （androidQ即安卓10对应androidosv=29）获取不到请传0
        String androidosv = tryApiAdInfo.getAndroidosv().isEmpty()?"0":tryApiAdInfo.getAndroidosv();
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
            map.put("androidosv", androidosv);
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
        String encode = MD5.MD5Encode(str, "UTF-8", false);
        map.put("keycode",encode );
        map.put("xwversion", 2);
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
    public TryApiAdClickRes tryApiAdClick(TryApiAdClick tryApiAdClick) {
        String url = "https://h5.17xianwan.com/try/API/try_api_adClick";
        Map<String, Object> map = new HashMap<String, Object>();
        String str  = "";
        //设备号是否为空,空就传0
        String deviceid = tryApiAdClick.getDeviceid().isEmpty()?"0":tryApiAdClick.getDeviceid();
        String msaoaid  = tryApiAdClick.getMsaoaid().isEmpty() ?"" :  tryApiAdClick.getMsaoaid();
        //IOS 忽略此参数 安卓操作系统版本号 如:安卓10对应的是参数：androidosv=29 （androidQ即安卓10对应androidosv=29）获取不到请传0
        String androidosv = tryApiAdClick.getAndroidosv().isEmpty()?"0":tryApiAdClick.getAndroidosv();
        //广告编号
        map.put("adid",tryApiAdClick.getAdid());
        //用户操作行为 1：下载
        map.put("ctype",1);
        //渠道用户编号(app中 用户ID)
        map.put("appsign",tryApiAdClick.getAppsign());
        //设备号 android取IMEI; iphone取IDFA 获取不到请传 0
        map.put("deviceid",deviceid);
        if(tryApiAdClick.getPtype().equals("2")){
            map.put("ptype",tryApiAdClick.getPtype());
            map.put("androidosv",androidosv);
            map.put("msaoaid",msaoaid);
            map.put("appid",XWAndroidAppid);
            map.put("appsecret",XWAndroidAppsecret);
            str=tryApiAdClick.getPtype()+deviceid+msaoaid+androidosv+XWAndroidAppid+tryApiAdClick.getAppsign()+tryApiAdClick.getAdid()+XWAndroidAppsecret;
        }else {
            map.put("ptype",tryApiAdClick.getPtype());
            map.put("appid",XWIOSAppid);
            map.put("appsecret",XWIOSAppsecret);
            str=tryApiAdClick.getPtype()+deviceid+XWIOSAppid+tryApiAdClick.getAppsign()+tryApiAdClick.getAdid()+XWIOSAppsecret;
        }
        String encode = MD5.MD5Encode(str, "UTF-8", false);
        map.put("keycode",encode);
        String res = HttpClientUtils.doGet(url, map);
        TryApiAdClickRes resBean = JSONObject.parseObject(res, TryApiAdClickRes.class);
        return resBean;
    }
}
