package com.renhang.core.apicall.meituan.service.impl;


import com.alibaba.fastjson.JSON;
import com.renhang.common.Utils.AES;
import com.renhang.common.Utils.HttpClientUtils;
import com.renhang.core.apicall.meituan.pojo.SecondCashback;
import com.renhang.core.apicall.meituan.pojo.ShareCoupon;
import com.renhang.core.apicall.meituan.pojo.TryApiList;
import com.renhang.core.apicall.meituan.pojo.TryApiListRes;
import com.renhang.core.apicall.meituan.service.MeiTuanService;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;


@Service
public class MeiTuanServiceImpl implements MeiTuanService {

    @Value("${meituan.utmSource}")
    private String utmSource;
    @Value("${meituan.utmSecret}")
    private String utmSecret;
    @Value("${meituan.activity}")
    private String activity;
    /**
     *核验订单数据
     *
     * @param adListBean
     * @return
     */
    @Override
    public TryApiListRes TryApiList(TryApiList adListBean) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("requestId",adListBean.getRequestId());
        map.put("utmSource",utmSource);
        String version=adListBean.getVersion();
        if(version==null || "".equals(version)){
            version="2.0";
        }

        map.put("version",version);
        Long timestamp = adListBean.getTimestamp();

        if(timestamp==null){
            map.put("timestamp",String.valueOf(System.currentTimeMillis()));
        }else{
            map.put("timestamp",adListBean.getTimestamp().toString());
        }
        String ste = utmSource+map.get("timestamp").toString();
//        String accessToken  = AES.encryptHex(ste, utmSecret);
        byte[] bytes=null;
        try{
            bytes= AES.pwdHandler(ste);
        }catch (Exception e){
            e.printStackTrace();
        }
        map.put("access_token",new String(bytes));
        map.put("startVerifyDate",adListBean.getStartVerifyDate());
        map.put("endVerifyDate",adListBean.getEndVerifyDate());
        map.put("startAddDate",adListBean.getStartAddDate());
        map.put("endAddDate",adListBean.getEndAddDate());
        map.put("startModifyDate",adListBean.getStartModifyDate());
        map.put("endModifyDate",adListBean.getEndModifyDate());
        map.put("uniqueItemIds",adListBean.getUniqueItemIds());
        map.put("viewOrderIds",adListBean.getViewOrderIds());
        map.put("queryType",adListBean.getQueryType());
        map.put("startTime",adListBean.getStartTime());
        map.put("endTime",adListBean.getEndTime());
        Integer page = adListBean.getPage();
        if(page == null){
            page=1;
        }
        map.put("page",page);
        Integer size = adListBean.getSize();
        if(size == null){
            size=10;
        }
        map.put("size",size);
        String response = HttpClientUtils.doGet("https://union.dianping.com/data/promote/verify/item",map);
        TryApiListRes tryApiListRes = JSON.parseObject(response, TryApiListRes.class);
        return  tryApiListRes;
    }

    @Override
    public String TryApiSecondCash(SecondCashback secondcashback) throws URISyntaxException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("utmSource", utmSource);
        String timestamp = secondcashback.getTimestamp();
        if("".equals(timestamp) || timestamp==null ){
            map.put("timestamp",String.valueOf(System.currentTimeMillis()));
        }else{
            map.put("timestamp",timestamp);
        }
        String ste = map.get("utmSource").toString()+map.get("timestamp").toString();
//        String accessToken  = AES.encryptHex(ste, "");
        byte[] bytes=null;
        try{
            bytes= AES.pwdHandler(ste);
        }catch (Exception e){
            e.printStackTrace();
        }
        map.put("access_token",bytes);
//        map.put("access_token",accessToken);
        String UtmMedium= secondcashback.getUtmMedium();
        if(UtmMedium==null){
            map.put("utmMedium", AES.encryptHex(ste,""));
        }else{
            map.put("utmMedium", AES.encryptHex(secondcashback.getUtmMedium(),""));
        }
        if(secondcashback.getRequestId()==null){
            map.put("requestId",ste);
        }else {
            map.put("requestId",secondcashback.getRequestId());
        }

        map.put("activity",activity);
        map.put("version",1.0);
        // 创建uri
        String url = "https://act.meituan.com/clover/page/adunioncps/second_cashback";
        URIBuilder builder = new URIBuilder(url);
        for (String key : map.keySet()) {
            builder.addParameter(key, map.get(key).toString());
        }
        return builder.build().toString();

    }

    @Override
    public String TryApiShareCoupon(ShareCoupon sharecoupon) throws URISyntaxException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("utmSource", utmSource);
        String timestamp = sharecoupon.getTimestamp();
        if("".equals(timestamp) || timestamp==null ){
            map.put("timestamp",String.valueOf(System.currentTimeMillis()));
        }else{
            map.put("timestamp",timestamp);
        }
        String ste = map.get("utmSource").toString()+map.get("timestamp").toString();
//        String accessToken  = AES.encryptHex(ste, "");
        byte[] bytes=null;
        try{
            bytes= AES.pwdHandler(ste);
        }catch (Exception e){
            e.printStackTrace();
        }
        map.put("access_token",bytes);
        String UtmMedium= sharecoupon.getUtmMedium();
        if(UtmMedium==null){
            map.put("utmMedium", AES.encryptHex(ste,""));
        }else{
            map.put("utmMedium", AES.encryptHex(sharecoupon.getUtmMedium(),""));
        }
        if(sharecoupon.getRequestId()==null){
            map.put("requestId",ste);
        }else {
            map.put("requestId",sharecoupon.getRequestId());
        }

        map.put("activity",activity);
        map.put("version",1.0);
        // 创建uri
        String url = "https://act.meituan.com/clover/page/adunioncps/share_coupon";
        URIBuilder builder = new URIBuilder(url);
        for (String key : map.keySet()) {
            builder.addParameter(key, map.get(key).toString());
        }
        return builder.build().toString();
    }


}
