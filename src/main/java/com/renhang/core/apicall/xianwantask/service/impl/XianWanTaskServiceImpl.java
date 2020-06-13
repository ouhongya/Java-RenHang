package com.renhang.core.apicall.xianwantask.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.renhang.common.Utils.HttpClientUtils;
import com.renhang.common.Utils.MD5;

import com.renhang.core.apicall.xianwantask.pojo.*;
import com.renhang.core.apicall.xianwantask.service.XianWanTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class XianWanTaskServiceImpl implements XianWanTaskService {


    @Value("${XWAndroidTask.appsecret}")
    private String XWAndroidTaskAppsecret;
    @Value("${XWAndroidTask.appId}")
    private String XWAndroidTaskAppid;


    @Value("${XWIOSTask.appsecret}")
    private String XWIOSTaskAppid;
    @Value("${XWIOSTask.appId}")
    private String XWIOSTaskAppsecret;


//    /**
//     * 获取广告列表
//     *
//     * @param adListBean
//     * @return
//     */
//    @Override
//    public TryApiListRes TryApiList(TryApiList adListBean) {
//        String url = "https://h5.wangzhuantianxia.com/adwall/api/cpa/list";
//        Map<String, Object> map = new HashMap<String, Object>();
//        //手机设备号
//        String deviceid = adListBean.getDeviceid().isEmpty() ? "0" : adListBean.getDeviceid();
//        //IOS 忽略此参数 安卓操作系统版本号 如:安卓10对应的是参数：androidosv=29 （androidQ即安卓10对应androidosv=29）获取不到请传0
//        String androidosv = adListBean.getAndroidosv().isEmpty() ? "0" : adListBean.getAndroidosv();
//        String page = adListBean.getPage().isEmpty() ? "1" : adListBean.getPage();
//        //每页显示多少
//        String pagesize = adListBean.getPagesize().isEmpty() ? "200" : adListBean.getPagesize();
//        //1 iPhone 2 安卓
//        map.put("ptype", adListBean.getPtype());
//        map.put("deviceid", deviceid);
//        map.put("appsign", adListBean.getAppsign());
//        String str = "";
//        if (adListBean.getPtype().equals("2")) {
//            map.put("appid", adListBean.getAppid());
//            map.put("appsecret", adListBean.getAppsecret());
//            //安全联盟
//            map.put("msaoaid", adListBean.getMsaoaid());
//            map.put("androidosv", androidosv);
//            //appid+deviceid+msaoaid+androidosv+ptype+appsign+appsecret
//            str = adListBean.getAppid() + deviceid + adListBean.getMsaoaid() + androidosv + adListBean.getPtype() + adListBean.getAppsign() + adListBean.getAppsecret();
//        } else {
//            map.put("appid", XWIOSAppid);
//            map.put("appsecret", XWIOSAppsecret);
//            str = XWIOSAppid + deviceid + adListBean.getPtype() + adListBean.getAppsign() + XWIOSAppsecret;
//        }
//        map.put("keycode", MD5.MD5Encode(str, "UTF-8", false));
////      map.put("xwversion",2);
//        map.put("page", page);
//        map.put("pagesize", pagesize);
//        map.put("adListType", adListBean.getAdListType());
//        map.put("adType", adListBean.getAdType());
//        map.put("sortType", adListBean.getSortType());
//        map.put("adName", adListBean.getAdName());
//        map.put("tag", adListBean.getTag());
//        map.put("startTime", adListBean.getStartTime());
//        map.put("taskType", adListBean.getTaskType());
//        map.put("age", adListBean.getAge());
//        map.put("userIp", adListBean.getUserIp());
//        String res = HttpClientUtils.doGet(url, map);
//        TryApiListRes resBean = JSONObject.parseObject(res, TryApiListRes.class);
//        return resBean;
//    }

//    /**
//     * 查看广告详情
//     *
//     * @param tryApiAdInfo
//     * @return
//     */
//    @Override
//    public TryApiAdInfoRes TryApiAdInfo(TryApiAdInfo tryApiAdInfo) {
//        String url = " https://h5.wangzhuantianxia.com/adwall/api/cpa/details";
//        Map<String, Object> map = new HashMap<String, Object>();
//        String str = "";
//        //设备号是否为空,空就传0
//        String deviceid = tryApiAdInfo.getDeviceid().isEmpty() ? "0" : tryApiAdInfo.getDeviceid();
//        //IOS 忽略此参数 安全联盟OAID （未接入安全联盟请传空字符串“”）
//        String msaoaid = tryApiAdInfo.getMsaoaid().isEmpty() ? "" : tryApiAdInfo.getMsaoaid();
//        //IOS 忽略此参数 安卓操作系统版本号 如:安卓10对应的是参数：androidosv=29 （androidQ即安卓10对应androidosv=29）获取不到请传0
//        String androidosv = tryApiAdInfo.getAndroidosv().isEmpty() ? "0" : tryApiAdInfo.getAndroidosv();
//        //广告编号
//        map.put("adid", tryApiAdInfo.getAdid());
//        //渠道用户id
//        map.put("appsign", tryApiAdInfo.getAppsign());
//        map.put("ptype", tryApiAdInfo.getPtype());
//        map.put("deviceid", deviceid);
//        //判断当前是1苹果还是2安卓
//        if (tryApiAdInfo.getPtype().equals("2")) {
//            map.put("appid", XWAndroidAppid);
//            map.put("appsecret", XWAndroidAppsecret);
//            //IOS 忽略此参数 安卓操作系统版本号 如:29 、28 （android Q 对应 29）
//            map.put("androidosv", androidosv);
//            //IOS 忽略此参数 安全联盟OAID （未接入安全联盟请传空字符串“”）
//            map.put("msaoaid", msaoaid);
//            //字符串拼接
//            str = tryApiAdInfo.getPtype() + deviceid + msaoaid + tryApiAdInfo.getAndroidosv() + XWAndroidAppid + tryApiAdInfo.getAppsign() + tryApiAdInfo.getAdid() + XWAndroidAppsecret;
//        } else {
//            map.put("appid", XWIOSAppid);
//            map.put("appsecret", XWIOSAppsecret);
//            //字符串拼接
//            str = tryApiAdInfo.getPtype() + deviceid + XWIOSAppid + tryApiAdInfo.getAppsign() + tryApiAdInfo.getAdid() + XWIOSAppsecret;
//        }
//        String encode = MD5.MD5Encode(str, "UTF-8", false);
//        map.put("keycode", encode);
////        map.put("xwversion", 2);
//        String res = HttpClientUtils.doGet(url, map);
//        TryApiAdInfoRes resBean = JSONObject.parseObject(res, TryApiAdInfoRes.class);
//        return resBean;
//    }

    /**
     * 点击领取任务api
     *
     * @param tryApiAdClick
     * @return
     */
    @Override
    public LinkTask tryApiAdClick(TryApiAdClick tryApiAdClick) {
        String url = "https://h5.wangzhuantianxia.com/adwall/api/cpa/start";
        Map<String, String> map = new HashMap<String, String>();
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
            map.put("appid", XWAndroidTaskAppid);
            map.put("appsecret", XWAndroidTaskAppsecret);
            //IOS 忽略此参数 安卓操作系统版本号 如:29 、28 （android Q 对应 29）
            map.put("androidosv", androidosv);
            //IOS 忽略此参数 安全联盟OAID （未接入安全联盟请传空字符串“”）
            map.put("msaoaid", msaoaid);
            //字符串拼接
            str = XWAndroidTaskAppid + deviceid + msaoaid + androidosv + tryApiAdClick.getPtype() + tryApiAdClick.getAppsign() + tryApiAdClick.getAdid() + XWAndroidTaskAppsecret;
        } else {
            map.put("appid", XWIOSTaskAppid);
            map.put("appsecret", XWIOSTaskAppsecret);
            //字符串拼接
            str = XWIOSTaskAppid + deviceid + tryApiAdClick.getPtype() + tryApiAdClick.getAppsign() + tryApiAdClick.getAdid() + XWIOSTaskAppsecret;
        }
        String encode = MD5.MD5Encode(str, "UTF-8", false);
        map.put("keycode", encode);
        String res = HttpClientUtils.doPost(url, map);
        LinkTask resBean = JSONObject.parseObject(res, LinkTask.class);
        return resBean;
    }

    @Override
    public SubmitTaskResponse tryApiSubmitTask(TryApiSubmitTask tryapisubmittask) {
        String url = "https://h5.wangzhuantianxia.com/adwall/api/cpa/submitTask";
        Map<String, String> map = new HashMap<String, String>();
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
            map.put("appid", XWAndroidTaskAppid);
            map.put("appsecret", XWAndroidTaskAppsecret);
            //IOS 忽略此参数 安卓操作系统版本号 如:29 、28 （android Q 对应 29）
            map.put("androidosv", androidosv);
            //IOS 忽略此参数 安全联盟OAID （未接入安全联盟请传空字符串“”）
            map.put("msaoaid", msaoaid);
            //字符串拼接
            str = XWAndroidTaskAppid + deviceid + msaoaid + androidosv + tryapisubmittask.getPtype() + tryapisubmittask.getAppsign() + tryapisubmittask.getAdid() + XWAndroidTaskAppsecret;
        } else {
            map.put("appid", XWIOSTaskAppid);
            map.put("appsecret", XWIOSTaskAppsecret);
            //字符串拼接
            str = XWIOSTaskAppid + deviceid + tryapisubmittask.getPtype() + tryapisubmittask.getAppsign() + tryapisubmittask.getAdid() + XWIOSTaskAppsecret;
        }
        String encode = MD5.MD5Encode(str, "UTF-8", false);
        map.put("keycode", encode);
        String res = HttpClientUtils.doPost(url, map);
        SubmitTaskResponse resBean = JSONObject.parseObject(res, SubmitTaskResponse.class);
        return resBean;
    }

    @Override
    public SubmitTaskResponse tryApiSubmitTaskList(TryApiSubmitTaskList tryapisubmittasklist) {
        String url = "https://h5.wangzhuantianxia.com/adwall/api/cpa/submitTaskList";
        Map<String, String> map = new HashMap<String, String>();
        String str = "";
        //设备号是否为空,空就传0
        String deviceid = tryapisubmittasklist.getDeviceid().isEmpty() ? "0" : tryapisubmittasklist.getDeviceid();
        //IOS 忽略此参数 安全联盟OAID （未接入安全联盟请传空字符串“”）
        String msaoaid = tryapisubmittasklist.getMsaoaid().isEmpty() ? "" : tryapisubmittasklist.getMsaoaid();
        //IOS 忽略此参数 安卓操作系统版本号 如:安卓10对应的是参数：androidosv=29 （androidQ即安卓10对应androidosv=29）获取不到请传0
        String androidosv = tryapisubmittasklist.getAndroidosv().isEmpty() ? "0" : tryapisubmittasklist.getAndroidosv();
        //渠道用户id
        map.put("appsign", tryapisubmittasklist.getAppsign());
        map.put("ptype", tryapisubmittasklist.getPtype());
        map.put("deviceid", deviceid);
        for(TryApiSubmitTaskInfo tryapisubmittaskinfo:tryapisubmittasklist.getList()){
            map.put("adid", tryapisubmittaskinfo.getAdid());
            map.put("groupId", tryapisubmittaskinfo.getGroupId());
            map.put("itemId", tryapisubmittaskinfo.getItemId());
            map.put("answer", tryapisubmittaskinfo.getAnswer());
            //判断当前是1苹果还是2安卓
            if (tryapisubmittasklist.getPtype().equals("2")) {
                map.put("appid", XWAndroidTaskAppid);
                map.put("appsecret", XWAndroidTaskAppsecret);
                //IOS 忽略此参数 安卓操作系统版本号 如:29 、28 （android Q 对应 29）
                map.put("androidosv", androidosv);
                //IOS 忽略此参数 安全联盟OAID （未接入安全联盟请传空字符串“”）
                map.put("msaoaid", msaoaid);
                //字符串拼接
                str = XWAndroidTaskAppid + deviceid + msaoaid + androidosv + tryapisubmittasklist.getPtype() + tryapisubmittasklist.getAppsign() + tryapisubmittaskinfo.getAdid() + XWAndroidTaskAppsecret;
            } else {
                map.put("appid", XWIOSTaskAppid);
                map.put("appsecret", XWIOSTaskAppsecret);
                //字符串拼接
                str = XWIOSTaskAppid + deviceid + tryapisubmittasklist.getPtype() + tryapisubmittasklist.getAppsign() + tryapisubmittaskinfo.getAdid() + XWIOSTaskAppsecret;
            }
            String encode = MD5.MD5Encode(str, "UTF-8", false);
            map.put("keycode", encode);
            String res = HttpClientUtils.doPost(url, map);
        }
        SubmitTaskResponse resBean = new SubmitTaskResponse();
        resBean.setMsg("success");
        return resBean;
    }

    @Override
    public SubmitTaskResponse tryApiSubmitRecommend(TryApiAdClick tryapiadclick) {
        String url = "https://h5.wangzhuantianxia.com/adwall/api/cpa/recommend";
        Map<String, String> map = new HashMap<String, String>();
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
            map.put("appid", XWAndroidTaskAppid);
            map.put("appsecret", XWAndroidTaskAppsecret);
            //IOS 忽略此参数 安卓操作系统版本号 如:29 、28 （android Q 对应 29）
            map.put("androidosv", androidosv);
            //IOS 忽略此参数 安全联盟OAID （未接入安全联盟请传空字符串“”）
            map.put("msaoaid", msaoaid);
            //字符串拼接
            str = XWAndroidTaskAppid + deviceid + msaoaid + androidosv + tryapiadclick.getPtype() + tryapiadclick.getAppsign() + tryapiadclick.getAdid() + XWAndroidTaskAppsecret;
        } else {
            map.put("appid", XWIOSTaskAppid);
            map.put("appsecret", XWIOSTaskAppsecret);
            //字符串拼接
            str = XWIOSTaskAppid + deviceid + tryapiadclick.getPtype() + tryapiadclick.getAppsign() + tryapiadclick.getAdid() + XWIOSTaskAppsecret;
        }
        String encode = MD5.MD5Encode(str, "UTF-8", false);
        map.put("keycode", encode);
        String res = HttpClientUtils.doPost(url, map);
        SubmitTaskResponse resBean = JSONObject.parseObject(res, SubmitTaskResponse.class);
        return resBean;
    }

    @Override
    public SubmitTaskScreenshot tryApiSubmitScreenshot(TryApiScreenshot tryapiscreenshot) {
        String url = "https://h5.wangzhuantianxia.com/adwall/api/cpa/uploadScreenshot";
        Map<String, String> map = new HashMap<String, String>();
        String str = "";
        //设备号是否为空,空就传0
        String deviceid = tryapiscreenshot.getDeviceid().isEmpty() ? "0" : tryapiscreenshot.getDeviceid();
        //IOS 忽略此参数 安全联盟OAID （未接入安全联盟请传空字符串“”）
        String msaoaid = tryapiscreenshot.getMsaoaid().isEmpty() ? "" : tryapiscreenshot.getMsaoaid();
        //IOS 忽略此参数 安卓操作系统版本号 如:安卓10对应的是参数：androidosv=29 （androidQ即安卓10对应androidosv=29）获取不到请传0
        String androidosv = tryapiscreenshot.getAndroidosv().isEmpty() ? "0" : tryapiscreenshot.getAndroidosv();
        //广告编号
        map.put("file", tryapiscreenshot.getFile().toString());
        map.put("adid", tryapiscreenshot.getAdid());
        //渠道用户id
        map.put("appsign", tryapiscreenshot.getAppsign());
        map.put("ptype", tryapiscreenshot.getPtype());
        map.put("deviceid", deviceid);
        //判断当前是1苹果还是2安卓
        if (tryapiscreenshot.getPtype().equals("2")) {
            map.put("appid", XWAndroidTaskAppid);
            map.put("appsecret", XWAndroidTaskAppsecret);
            //IOS 忽略此参数 安卓操作系统版本号 如:29 、28 （android Q 对应 29）
            map.put("androidosv", androidosv);
            //IOS 忽略此参数 安全联盟OAID （未接入安全联盟请传空字符串“”）
            map.put("msaoaid", msaoaid);
            //字符串拼接
            str = XWAndroidTaskAppid + deviceid + msaoaid + androidosv + tryapiscreenshot.getPtype() + tryapiscreenshot.getAppsign() + tryapiscreenshot.getAdid() + XWAndroidTaskAppsecret;
        } else {
            map.put("appid", XWIOSTaskAppid);
            map.put("appsecret", XWIOSTaskAppsecret);
            //字符串拼接
            str = XWIOSTaskAppid + deviceid + tryapiscreenshot.getPtype() + tryapiscreenshot.getAppsign() + tryapiscreenshot.getAdid() + XWIOSTaskAppsecret;
        }
        String encode = MD5.MD5Encode(str, "UTF-8", false);
        map.put("keycode", encode);
        String res = HttpClientUtils.doPost(url, map);
        SubmitTaskScreenshot resBean = JSONObject.parseObject(res, SubmitTaskScreenshot.class);
        return resBean;
    }

    @Override
    public SubmitTaskScreenshot tryApiSubmitScreenshotbase(TryApiScreenshotbase tryapiscreenshotbase) {
        String url = "https://h5.wangzhuantianxia.com/adwall/api/cpa/uploadScreenshot";
        Map<String, String> map = new HashMap<String, String>();
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
            map.put("appid", XWAndroidTaskAppid);
            map.put("appsecret", XWAndroidTaskAppsecret);
            //IOS 忽略此参数 安卓操作系统版本号 如:29 、28 （android Q 对应 29）
            map.put("androidosv", androidosv);
            //IOS 忽略此参数 安全联盟OAID （未接入安全联盟请传空字符串“”）
            map.put("msaoaid", msaoaid);
            //字符串拼接
            str = XWAndroidTaskAppid + deviceid + msaoaid + androidosv + tryapiscreenshotbase.getPtype() + tryapiscreenshotbase.getAppsign() + tryapiscreenshotbase.getAdid() + XWAndroidTaskAppsecret;
        } else {
            map.put("appid", XWIOSTaskAppid);
            map.put("appsecret", XWIOSTaskAppsecret);
            //字符串拼接
            str = XWIOSTaskAppid + deviceid + tryapiscreenshotbase.getPtype() + tryapiscreenshotbase.getAppsign() + tryapiscreenshotbase.getAdid() + XWIOSTaskAppsecret;
        }
        String encode = MD5.MD5Encode(str, "UTF-8", false);
        map.put("keycode", encode);
        String res = HttpClientUtils.doPost(url, map);

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
            map.put("appid", XWAndroidTaskAppid);
            map.put("appsecret", XWAndroidTaskAppsecret);
            //IOS 忽略此参数 安卓操作系统版本号 如:29 、28 （android Q 对应 29）
            map.put("androidosv", androidosv);
            //IOS 忽略此参数 安全联盟OAID （未接入安全联盟请传空字符串“”）
            map.put("msaoaid", msaoaid);
            //字符串拼接
            str = XWAndroidTaskAppid + deviceid + msaoaid + androidosv + tryapisignature.getPtype() + tryapisignature.getAppsign() + tryapisignature.getAdid() + XWAndroidTaskAppsecret;
        } else {
            map.put("appid", XWIOSTaskAppid);
            map.put("appsecret", XWIOSTaskAppsecret);
            //字符串拼接
            str = XWIOSTaskAppid + deviceid + tryapisignature.getPtype() + tryapisignature.getAppsign() + tryapisignature.getAdid() + XWIOSTaskAppsecret;
        }
        String encode = MD5.MD5Encode(str, "UTF-8", false);
        map.put("keycode", encode);
        String res = HttpClientUtils.doGet(url, map);
        SubmitTaskSignature resBean = JSONObject.parseObject(res, SubmitTaskSignature.class);
        return resBean;
    }


}