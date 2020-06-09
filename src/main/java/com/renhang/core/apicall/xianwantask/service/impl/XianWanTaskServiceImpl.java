package com.renhang.core.apicall.xianwantask.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.renhang.common.Utils.HttpClientUtils;
import com.renhang.common.Utils.MD5;
import com.renhang.core.apicall.xianwantask.mapper.XianWanTaskMapper;

import com.renhang.core.apicall.xianwantask.pojo.TryApiAdClick.TryApiAdClick;
import com.renhang.core.apicall.xianwantask.pojo.TryApiAdClick.TryApiAdClickRes;
import com.renhang.core.apicall.xianwantask.pojo.TryApiAdInfo;
import com.renhang.core.apicall.xianwantask.pojo.TryApiAdInfoRes.*;
import com.renhang.core.apicall.xianwantask.pojo.TryApiList;
import com.renhang.core.apicall.xianwantask.pojo.TryApiListRes.TryApiListRes;
import com.renhang.core.apicall.xianwantask.service.XianWanTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class XianWanTaskServiceImpl implements XianWanTaskService {

    @Autowired
    XianWanTaskMapper mtUserMapper;

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
        String url = "https://h5.wangzhuantianxia.com/adwall/api/cpa/list";
        Map<String, Object> map = new HashMap<String, Object>();
        //手机设备号
        String deviceid = adListBean.getDeviceid().isEmpty() ? "0" : adListBean.getDeviceid();
        //IOS 忽略此参数 安卓操作系统版本号 如:安卓10对应的是参数：androidosv=29 （androidQ即安卓10对应androidosv=29）获取不到请传0
        String androidosv = adListBean.getAndroidosv().isEmpty() ? "0" : adListBean.getAndroidosv();
        String page = adListBean.getPage().isEmpty() ? "1" : adListBean.getPage();
        //每页显示多少
        String pagesize = adListBean.getPagesize().isEmpty() ? "200" : adListBean.getPagesize();
        //1 iPhone 2 安卓
        map.put("ptype", adListBean.getPtype());
        map.put("deviceid", deviceid);
        map.put("appsign", adListBean.getAppsign());
        String str = "";
        if (adListBean.getPtype().equals("2")) {
            map.put("appid", XWAndroidAppid);
            map.put("appsecret", XWAndroidAppsecret);
            //安全联盟
            map.put("msaoaid", adListBean.getMsaoaid());
            map.put("androidosv", androidosv);
            //appid+deviceid+msaoaid+androidosv+ptype+appsign+appsecret
            str = XWAndroidAppid + deviceid + adListBean.getMsaoaid() + androidosv + adListBean.getPtype() + adListBean.getAppsign() + XWAndroidAppsecret;
        } else {
            map.put("appid", XWIOSAppid);
            map.put("appsecret", XWIOSAppsecret);
            str = XWIOSAppid + deviceid + adListBean.getPtype() + adListBean.getAppsign() + XWIOSAppsecret;
        }
        map.put("keycode", MD5.MD5Encode(str, "UTF-8", false));
//      map.put("xwversion",2);
        map.put("page", page);
        map.put("pagesize", pagesize);
        map.put("adListType", adListBean.getAdListType());
        map.put("adType", adListBean.getAdType());
        map.put("sortType", adListBean.getSortType());
        map.put("adName", adListBean.getAdName());
        map.put("tag", adListBean.getTag());
        map.put("startTime", adListBean.getStartTime());
        map.put("taskType", adListBean.getTaskType());
        map.put("age", adListBean.getAge());
        map.put("userIp", adListBean.getUserIp());
        map.put("userIp", adListBean.getUserIp());
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
        String url = " https://h5.wangzhuantianxia.com/adwall/api/cpa/details";
        Map<String, Object> map = new HashMap<String, Object>();
        String str = "";
        //设备号是否为空,空就传0
        String deviceid = tryApiAdInfo.getDeviceid().isEmpty() ? "0" : tryApiAdInfo.getDeviceid();
        //IOS 忽略此参数 安全联盟OAID （未接入安全联盟请传空字符串“”）
        String msaoaid = tryApiAdInfo.getMsaoaid().isEmpty() ? "" : tryApiAdInfo.getMsaoaid();
        //IOS 忽略此参数 安卓操作系统版本号 如:安卓10对应的是参数：androidosv=29 （androidQ即安卓10对应androidosv=29）获取不到请传0
        String androidosv = tryApiAdInfo.getAndroidosv().isEmpty() ? "0" : tryApiAdInfo.getAndroidosv();
        //广告编号
        map.put("adid", tryApiAdInfo.getAdid());
        //渠道用户id
        map.put("appsign", tryApiAdInfo.getAppsign());
        map.put("ptype", tryApiAdInfo.getPtype());
        map.put("deviceid", deviceid);
        //判断当前是1苹果还是2安卓
        if (tryApiAdInfo.getPtype().equals("2")) {
            map.put("appid", XWAndroidAppid);
            map.put("appsecret", XWAndroidAppsecret);
            //IOS 忽略此参数 安卓操作系统版本号 如:29 、28 （android Q 对应 29）
            map.put("androidosv", androidosv);
            //IOS 忽略此参数 安全联盟OAID （未接入安全联盟请传空字符串“”）
            map.put("msaoaid", msaoaid);
            //字符串拼接
            str = tryApiAdInfo.getPtype() + deviceid + msaoaid + tryApiAdInfo.getAndroidosv() + XWAndroidAppid + tryApiAdInfo.getAppsign() + tryApiAdInfo.getAdid() + XWAndroidAppsecret;
        } else {
            map.put("appid", XWIOSAppid);
            map.put("appsecret", XWIOSAppsecret);
            //字符串拼接
            str = tryApiAdInfo.getPtype() + deviceid + XWIOSAppid + tryApiAdInfo.getAppsign() + tryApiAdInfo.getAdid() + XWIOSAppsecret;
        }
        String encode = MD5.MD5Encode(str, "UTF-8", false);
        map.put("keycode", encode);
//        map.put("xwversion", 2);
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
    public LinkTask tryApiAdClick(TryApiAdClick tryApiAdClick) {
        String url = "https://h5.wangzhuantianxia.com/adwall/api/cpa/start";
        Map<String, Object> map = new HashMap<String, Object>();
        String str = "";
        //设备号是否为空,空就传0
        String deviceid = tryApiAdClick.getDeviceid().isEmpty() ? "0" : tryApiAdClick.getDeviceid();
        //IOS 忽略此参数 安全联盟OAID （未接入安全联盟请传空字符串“”）
        String msaoaid = tryApiAdClick.getMsaoaid().isEmpty() ? "" : tryApiAdClick.getMsaoaid();
        //IOS 忽略此参数 安卓操作系统版本号 如:安卓10对应的是参数：androidosv=29 （androidQ即安卓10对应androidosv=29）获取不到请传0
        String androidosv = tryApiAdClick.getAndroidosv().isEmpty() ? "0" : tryApiAdClick.getAndroidosv();
        //广告编号
        map.put("adid", tryApiAdClick.getAdid());
        //渠道用户id
        map.put("appsign", tryApiAdClick.getAppsign());
        map.put("ptype", tryApiAdClick.getPtype());
        map.put("deviceid", deviceid);
        //判断当前是1苹果还是2安卓
        if (tryApiAdClick.getPtype().equals("2")) {
            map.put("appid", XWAndroidAppid);
            map.put("appsecret", XWAndroidAppsecret);
            //IOS 忽略此参数 安卓操作系统版本号 如:29 、28 （android Q 对应 29）
            map.put("androidosv", androidosv);
            //IOS 忽略此参数 安全联盟OAID （未接入安全联盟请传空字符串“”）
            map.put("msaoaid", msaoaid);
            //字符串拼接
            str = tryApiAdClick.getPtype() + deviceid + msaoaid + tryApiAdClick.getAndroidosv() + XWAndroidAppid + tryApiAdClick.getAppsign() + tryApiAdClick.getAdid() + XWAndroidAppsecret;
        } else {
            map.put("appid", XWIOSAppid);
            map.put("appsecret", XWIOSAppsecret);
            //字符串拼接
            str = tryApiAdClick.getPtype() + deviceid + XWIOSAppid + tryApiAdClick.getAppsign() + tryApiAdClick.getAdid() + XWIOSAppsecret;
        }
        String encode = MD5.MD5Encode(str, "UTF-8", false);
        map.put("keycode", encode);
//        map.put("xwversion", 2);
        String res = HttpClientUtils.doGet(url, map);

        LinkTask resBean = JSONObject.parseObject(res, LinkTask.class);
        return resBean;
    }

    @Override
    public SubmitTaskResponse tryApiSubmitTask(TryApiSubmitTask tryapisubmittask) {
        String url = "https://h5.wangzhuantianxia.com/adwall/api/cpa/submitTask";
        Map<String, Object> map = new HashMap<String, Object>();
        String str = "";
        //设备号是否为空,空就传0
        String deviceid = tryapisubmittask.getDeviceid().isEmpty() ? "0" : tryapisubmittask.getDeviceid();
        //IOS 忽略此参数 安全联盟OAID （未接入安全联盟请传空字符串“”）
        String msaoaid = tryapisubmittask.getMsaoaid().isEmpty() ? "" : tryapisubmittask.getMsaoaid();
        //IOS 忽略此参数 安卓操作系统版本号 如:安卓10对应的是参数：androidosv=29 （androidQ即安卓10对应androidosv=29）获取不到请传0
        String androidosv = tryapisubmittask.getAndroidosv().isEmpty() ? "0" : tryapisubmittask.getAndroidosv();
        //广告编号
        map.put("adid", tryapisubmittask.getAdid());
        map.put("groupId", tryapisubmittask.getGroupId());
        map.put("itemId", tryapisubmittask.getItemId());
        map.put("answer", tryapisubmittask.getAnswer());
        //渠道用户id
        map.put("appsign", tryapisubmittask.getAppsign());
        map.put("ptype", tryapisubmittask.getPtype());
        map.put("deviceid", deviceid);
        //判断当前是1苹果还是2安卓
        if (tryapisubmittask.getPtype().equals("2")) {
            map.put("appid", XWAndroidAppid);
            map.put("appsecret", XWAndroidAppsecret);
            //IOS 忽略此参数 安卓操作系统版本号 如:29 、28 （android Q 对应 29）
            map.put("androidosv", androidosv);
            //IOS 忽略此参数 安全联盟OAID （未接入安全联盟请传空字符串“”）
            map.put("msaoaid", msaoaid);
            //字符串拼接
            str = tryapisubmittask.getPtype() + deviceid + msaoaid + tryapisubmittask.getAndroidosv() + XWAndroidAppid + tryapisubmittask.getAppsign() + tryapisubmittask.getAdid() + XWAndroidAppsecret;
        } else {
            map.put("appid", XWIOSAppid);
            map.put("appsecret", XWIOSAppsecret);
            //字符串拼接
            str = tryapisubmittask.getPtype() + deviceid + XWIOSAppid + tryapisubmittask.getAppsign() + tryapisubmittask.getAdid() + XWIOSAppsecret;
        }
        String encode = MD5.MD5Encode(str, "UTF-8", false);
        map.put("keycode", encode);
//        map.put("xwversion", 2);
        String res = HttpClientUtils.doGet(url, map);

        SubmitTaskResponse resBean = JSONObject.parseObject(res, SubmitTaskResponse.class);
        return resBean;
    }

    @Override
    public SubmitTaskResponse tryApiSubmitTaskList(TryApiSubmitTaskList tryapisubmittasklist) {
        String url = "https://h5.wangzhuantianxia.com/adwall/api/cpa/submitTaskList";
        Map<String, Object> map = new HashMap<String, Object>();
        String str = "";
        //设备号是否为空,空就传0
        String deviceid = tryapisubmittasklist.getDeviceid().isEmpty() ? "0" : tryapisubmittasklist.getDeviceid();
        //IOS 忽略此参数 安全联盟OAID （未接入安全联盟请传空字符串“”）
        String msaoaid = tryapisubmittasklist.getMsaoaid().isEmpty() ? "" : tryapisubmittasklist.getMsaoaid();
        //IOS 忽略此参数 安卓操作系统版本号 如:安卓10对应的是参数：androidosv=29 （androidQ即安卓10对应androidosv=29）获取不到请传0
        String androidosv = tryapisubmittasklist.getAndroidosv().isEmpty() ? "0" : tryapisubmittasklist.getAndroidosv();
        //广告编号
        map.put("adid", tryapisubmittasklist.getAdid());
        map.put("list", tryapisubmittasklist.getList());
        //渠道用户id
        map.put("appsign", tryapisubmittasklist.getAppsign());
        map.put("ptype", tryapisubmittasklist.getPtype());
        map.put("deviceid", deviceid);
        //判断当前是1苹果还是2安卓
        if (tryapisubmittasklist.getPtype().equals("2")) {
            map.put("appid", XWAndroidAppid);
            map.put("appsecret", XWAndroidAppsecret);
            //IOS 忽略此参数 安卓操作系统版本号 如:29 、28 （android Q 对应 29）
            map.put("androidosv", androidosv);
            //IOS 忽略此参数 安全联盟OAID （未接入安全联盟请传空字符串“”）
            map.put("msaoaid", msaoaid);
            //字符串拼接
            str = tryapisubmittasklist.getPtype() + deviceid + msaoaid + tryapisubmittasklist.getAndroidosv() + XWAndroidAppid + tryapisubmittasklist.getAppsign() + tryapisubmittasklist.getAdid() + XWAndroidAppsecret;
        } else {
            map.put("appid", XWIOSAppid);
            map.put("appsecret", XWIOSAppsecret);
            //字符串拼接
            str = tryapisubmittasklist.getPtype() + deviceid + XWIOSAppid + tryapisubmittasklist.getAppsign() + tryapisubmittasklist.getAdid() + XWIOSAppsecret;
        }
        String encode = MD5.MD5Encode(str, "UTF-8", false);
        map.put("keycode", encode);
//        map.put("xwversion", 2);
        String res = HttpClientUtils.doGet(url, map);

        SubmitTaskResponse resBean = JSONObject.parseObject(res, SubmitTaskResponse.class);
        return resBean;
    }

    @Override
    public SubmitTaskResponse tryApiSubmitRecommend(TryApiAdClick tryapiadclick) {
        String url = "https://h5.wangzhuantianxia.com/adwall/api/cpa/recommend";
        Map<String, Object> map = new HashMap<String, Object>();
        String str = "";
        //设备号是否为空,空就传0
        String deviceid = tryapiadclick.getDeviceid().isEmpty() ? "0" : tryapiadclick.getDeviceid();
        //IOS 忽略此参数 安全联盟OAID （未接入安全联盟请传空字符串“”）
        String msaoaid = tryapiadclick.getMsaoaid().isEmpty() ? "" : tryapiadclick.getMsaoaid();
        //IOS 忽略此参数 安卓操作系统版本号 如:安卓10对应的是参数：androidosv=29 （androidQ即安卓10对应androidosv=29）获取不到请传0
        String androidosv = tryapiadclick.getAndroidosv().isEmpty() ? "0" : tryapiadclick.getAndroidosv();
        //广告编号
        map.put("adid", tryapiadclick.getAdid());
        //渠道用户id
        map.put("appsign", tryapiadclick.getAppsign());
        map.put("ptype", tryapiadclick.getPtype());
        map.put("deviceid", deviceid);
        //判断当前是1苹果还是2安卓
        if (tryapiadclick.getPtype().equals("2")) {
            map.put("appid", XWAndroidAppid);
            map.put("appsecret", XWAndroidAppsecret);
            //IOS 忽略此参数 安卓操作系统版本号 如:29 、28 （android Q 对应 29）
            map.put("androidosv", androidosv);
            //IOS 忽略此参数 安全联盟OAID （未接入安全联盟请传空字符串“”）
            map.put("msaoaid", msaoaid);
            //字符串拼接
            str = tryapiadclick.getPtype() + deviceid + msaoaid + tryapiadclick.getAndroidosv() + XWAndroidAppid + tryapiadclick.getAppsign() + tryapiadclick.getAdid() + XWAndroidAppsecret;
        } else {
            map.put("appid", XWIOSAppid);
            map.put("appsecret", XWIOSAppsecret);
            //字符串拼接
            str = tryapiadclick.getPtype() + deviceid + XWIOSAppid + tryapiadclick.getAppsign() + tryapiadclick.getAdid() + XWIOSAppsecret;
        }
        String encode = MD5.MD5Encode(str, "UTF-8", false);
        map.put("keycode", encode);
//        map.put("xwversion", 2);
        String res = HttpClientUtils.doGet(url, map);

        SubmitTaskResponse resBean = JSONObject.parseObject(res, SubmitTaskResponse.class);
        return resBean;
    }

    @Override
    public SubmitTaskScreenshot tryApiSubmitScreenshot(TryApiScreenshot tryapiscreenshot) {
        String url = "https://h5.wangzhuantianxia.com/adwall/api/cpa/uploadScreenshot";
        Map<String, Object> map = new HashMap<String, Object>();
        String str = "";
        //设备号是否为空,空就传0
        String deviceid = tryapiscreenshot.getDeviceid().isEmpty() ? "0" : tryapiscreenshot.getDeviceid();
        //IOS 忽略此参数 安全联盟OAID （未接入安全联盟请传空字符串“”）
        String msaoaid = tryapiscreenshot.getMsaoaid().isEmpty() ? "" : tryapiscreenshot.getMsaoaid();
        //IOS 忽略此参数 安卓操作系统版本号 如:安卓10对应的是参数：androidosv=29 （androidQ即安卓10对应androidosv=29）获取不到请传0
        String androidosv = tryapiscreenshot.getAndroidosv().isEmpty() ? "0" : tryapiscreenshot.getAndroidosv();
        //广告编号
        map.put("file", tryapiscreenshot.getFile());
        map.put("adid", tryapiscreenshot.getAdid());
        //渠道用户id
        map.put("appsign", tryapiscreenshot.getAppsign());
        map.put("ptype", tryapiscreenshot.getPtype());
        map.put("deviceid", deviceid);
        //判断当前是1苹果还是2安卓
        if (tryapiscreenshot.getPtype().equals("2")) {
            map.put("appid", XWAndroidAppid);
            map.put("appsecret", XWAndroidAppsecret);
            //IOS 忽略此参数 安卓操作系统版本号 如:29 、28 （android Q 对应 29）
            map.put("androidosv", androidosv);
            //IOS 忽略此参数 安全联盟OAID （未接入安全联盟请传空字符串“”）
            map.put("msaoaid", msaoaid);
            //字符串拼接
            str = tryapiscreenshot.getPtype() + deviceid + msaoaid + tryapiscreenshot.getAndroidosv() + XWAndroidAppid + tryapiscreenshot.getAppsign() + tryapiscreenshot.getAdid() + XWAndroidAppsecret;
        } else {
            map.put("appid", XWIOSAppid);
            map.put("appsecret", XWIOSAppsecret);
            //字符串拼接
            str = tryapiscreenshot.getPtype() + deviceid + XWIOSAppid + tryapiscreenshot.getAppsign() + tryapiscreenshot.getAdid() + XWIOSAppsecret;
        }
        String encode = MD5.MD5Encode(str, "UTF-8", false);
        map.put("keycode", encode);
//        map.put("xwversion", 2);
        String res = HttpClientUtils.doGet(url, map);

        SubmitTaskScreenshot resBean = JSONObject.parseObject(res, SubmitTaskScreenshot.class);
        return resBean;
    }

    @Override
    public SubmitTaskScreenshot tryApiSubmitScreenshotbase(TryApiScreenshotbase tryapiscreenshotbase) {
        String url = "https://h5.wangzhuantianxia.com/adwall/api/cpa/uploadScreenshot";
        Map<String, Object> map = new HashMap<String, Object>();
        String str = "";
        //设备号是否为空,空就传0
        String deviceid = tryapiscreenshotbase.getDeviceid().isEmpty() ? "0" : tryapiscreenshotbase.getDeviceid();
        //IOS 忽略此参数 安全联盟OAID （未接入安全联盟请传空字符串“”）
        String msaoaid = tryapiscreenshotbase.getMsaoaid().isEmpty() ? "" : tryapiscreenshotbase.getMsaoaid();
        //IOS 忽略此参数 安卓操作系统版本号 如:安卓10对应的是参数：androidosv=29 （androidQ即安卓10对应androidosv=29）获取不到请传0
        String androidosv = tryapiscreenshotbase.getAndroidosv().isEmpty() ? "0" : tryapiscreenshotbase.getAndroidosv();
        //广告编号
        map.put("data", tryapiscreenshotbase.getData());
        map.put("adid", tryapiscreenshotbase.getAdid());
        //渠道用户id
        map.put("appsign", tryapiscreenshotbase.getAppsign());
        map.put("ptype", tryapiscreenshotbase.getPtype());
        map.put("deviceid", deviceid);
        //判断当前是1苹果还是2安卓
        if (tryapiscreenshotbase.getPtype().equals("2")) {
            map.put("appid", XWAndroidAppid);
            map.put("appsecret", XWAndroidAppsecret);
            //IOS 忽略此参数 安卓操作系统版本号 如:29 、28 （android Q 对应 29）
            map.put("androidosv", androidosv);
            //IOS 忽略此参数 安全联盟OAID （未接入安全联盟请传空字符串“”）
            map.put("msaoaid", msaoaid);
            //字符串拼接
            str = tryapiscreenshotbase.getPtype() + deviceid + msaoaid + tryapiscreenshotbase.getAndroidosv() + XWAndroidAppid + tryapiscreenshotbase.getAppsign() + tryapiscreenshotbase.getAdid() + XWAndroidAppsecret;
        } else {
            map.put("appid", XWIOSAppid);
            map.put("appsecret", XWIOSAppsecret);
            //字符串拼接
            str = tryapiscreenshotbase.getPtype() + deviceid + XWIOSAppid + tryapiscreenshotbase.getAppsign() + tryapiscreenshotbase.getAdid() + XWIOSAppsecret;
        }
        String encode = MD5.MD5Encode(str, "UTF-8", false);
        map.put("keycode", encode);
//        map.put("xwversion", 2);
        String res = HttpClientUtils.doGet(url, map);

        SubmitTaskScreenshot resBean = JSONObject.parseObject(res, SubmitTaskScreenshot.class);
        return resBean;
    }

    @Override
    public SubmitTaskSignature tryApiSubmitSignature(TryApiSignature tryapisignature) {
        String url = "https://h5.wangzhuantianxia.com/adwall/api/oss/getSignature";
        Map<String, Object> map = new HashMap<String, Object>();
        String str = "";
        //设备号是否为空,空就传0
        String deviceid = tryapisignature.getDeviceid().isEmpty() ? "0" : tryapisignature.getDeviceid();
        //IOS 忽略此参数 安全联盟OAID （未接入安全联盟请传空字符串“”）
        String msaoaid = tryapisignature.getMsaoaid().isEmpty() ? "" : tryapisignature.getMsaoaid();
        //IOS 忽略此参数 安卓操作系统版本号 如:安卓10对应的是参数：androidosv=29 （androidQ即安卓10对应androidosv=29）获取不到请传0
        String androidosv = tryapisignature.getAndroidosv().isEmpty() ? "0" : tryapisignature.getAndroidosv();
        //广告编号
        map.put("adid", tryapisignature.getAdid());
        //渠道用户id
        map.put("appsign", tryapisignature.getAppsign());
        map.put("ptype", tryapisignature.getPtype());
        map.put("deviceid", deviceid);
        //判断当前是1苹果还是2安卓
        if (tryapisignature.getPtype().equals("2")) {
            map.put("appid", XWAndroidAppid);
            map.put("appsecret", XWAndroidAppsecret);
            //IOS 忽略此参数 安卓操作系统版本号 如:29 、28 （android Q 对应 29）
            map.put("androidosv", androidosv);
            //IOS 忽略此参数 安全联盟OAID （未接入安全联盟请传空字符串“”）
            map.put("msaoaid", msaoaid);
            //字符串拼接
            str = tryapisignature.getPtype() + deviceid + msaoaid + tryapisignature.getAndroidosv() + XWAndroidAppid + tryapisignature.getAppsign() + tryapisignature.getAdid() + XWAndroidAppsecret;
        } else {
            map.put("appid", XWIOSAppid);
            map.put("appsecret", XWIOSAppsecret);
            //字符串拼接
            str = tryapisignature.getPtype() + deviceid + XWIOSAppid + tryapisignature.getAppsign() + tryapisignature.getAdid() + XWIOSAppsecret;
        }
        String encode = MD5.MD5Encode(str, "UTF-8", false);
        map.put("keycode", encode);
//        map.put("xwversion", 2);
        String res = HttpClientUtils.doGet(url, map);

        SubmitTaskSignature resBean = JSONObject.parseObject(res, SubmitTaskSignature.class);
        return resBean;
    }


}