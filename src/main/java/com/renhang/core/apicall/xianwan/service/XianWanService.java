package com.renhang.core.apicall.xianwan.service;


import com.renhang.core.apicall.xianwan.pojo.TryApiAdClick;
import com.renhang.core.apicall.xianwan.pojo.TryApiAdInfo;
import com.renhang.core.apicall.xianwan.pojo.TryApiAdInfoRes.TryApiAdInfoRes;
import com.renhang.core.apicall.xianwan.pojo.TryApiList;
import com.renhang.core.apicall.xianwan.pojo.TryApiListRes.TryApiListRes;
import com.renhang.core.apicall.xianwan.pojo.tryApiAdClickRes;

public interface XianWanService {
    TryApiListRes TryApiList(TryApiList adListBean);
    TryApiAdInfoRes TryApiAdInfo(TryApiAdInfo TryApiAdInfo);
    tryApiAdClickRes tryApiAdClick(TryApiAdClick tryApiAdClick);
}
