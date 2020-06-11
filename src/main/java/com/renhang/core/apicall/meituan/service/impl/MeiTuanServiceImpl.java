package com.renhang.core.apicall.meituan.service.impl;


import com.alibaba.fastjson.JSON;
import com.renhang.common.Utils.AES;
import com.renhang.common.Utils.HttpClientUtils;
import com.renhang.core.apicall.meituan.pojo.TryApiList;
import com.renhang.core.apicall.meituan.pojo.TryApiListRes;
import com.renhang.core.apicall.meituan.service.MeiTuanService;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
public class MeiTuanServiceImpl implements MeiTuanService {
    /**
     *核验订单数据
     *
     * @param adListBean
     * @return
     */
    @Override
    public TryApiListRes TryApiList(TryApiList adListBean) {
        String url = "https://union.dianping.com/data/promote/verify/item";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("requestId",adListBean.getRequestId());
        map.put("utmSource",adListBean.getUtmSource());
        String version=adListBean.getVersion().isEmpty()?"2.0":adListBean.getVersion();
        map.put("version",version);
        Long timestamp = adListBean.getTimestamp();
        if(timestamp==0 ||timestamp==0l ){
            map.put("timestamp",new Date().getTime());
        }else{
            map.put("timestamp",adListBean.getTimestamp());
        }
        String ste = map.get("utmSource").toString()+map.get("timestamp").toString();
        String accessToken  = AES.encryptHex(ste, "");
        map.put("accessToken",accessToken);
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
        if(page == 0){
            page=1;
        }
        map.put("page",page);
        Integer size = adListBean.getSize();
        if(size == 0){
            size=10;
        }
        map.put("size",size);
        String response = HttpClientUtils.doGet("https://union.dianping.com/data/promote/verify/item",map);
        TryApiListRes tryApiListRes = JSON.parseObject(response, TryApiListRes.class);
        return  tryApiListRes;
    }

}
