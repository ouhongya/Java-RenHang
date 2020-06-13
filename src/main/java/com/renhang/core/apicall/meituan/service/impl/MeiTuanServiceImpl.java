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
        map.put("timestamp",System.currentTimeMillis());
        String ste = utmSource+map.get("timestamp").toString();
        map.put("access_token",AES.encryptHex(ste,utmSecret));
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
        map.put("timestamp",String.valueOf(System.currentTimeMillis()));
        String ste = map.get("utmSource").toString()+map.get("timestamp").toString();
        map.put("access_token",AES.encryptHex(ste,utmSecret));
        map.put("utmMedium", AES.encryptHex(ste,utmSecret));
        map.put("requestId",secondcashback.getRequestId());
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
        map.put("timestamp",String.valueOf(System.currentTimeMillis()));
        String ste = map.get("utmSource").toString()+map.get("timestamp").toString();
        map.put("access_token",AES.encryptHex(ste,utmSecret));
        map.put("utmMedium", AES.encryptHex(ste,utmSecret));
        map.put("requestId",sharecoupon.getRequestId());
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
