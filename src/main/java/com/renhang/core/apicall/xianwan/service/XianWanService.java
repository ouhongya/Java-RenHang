package com.renhang.core.apicall.xianwan.service;


import com.renhang.core.apicall.xianwan.pojo.MyActionAdListVo;
import com.renhang.core.apicall.xianwan.pojo.MyActionAdListVoRes;
import com.renhang.core.apicall.xianwan.pojo.TryApiAdClick.TryApiAdClick;
import com.renhang.core.apicall.xianwan.pojo.TryApiAdInfo;
import com.renhang.core.apicall.xianwan.pojo.TryApiAdInfoRes.TryApiAdInfoRes;
import com.renhang.core.apicall.xianwan.pojo.TryApiList;
import com.renhang.core.apicall.xianwan.pojo.TryApiListRes.TryApiListRes;
import com.renhang.core.apicall.xianwan.pojo.TryApiAdClick.TryApiAdClickRes;

public interface XianWanService {
    TryApiListRes TryApiList(TryApiList adListBean);
    TryApiAdInfoRes TryApiAdInfo(TryApiAdInfo TryApiAdInfo);
    TryApiAdClickRes tryApiAdClick(TryApiAdClick tryApiAdClick);

    MyActionAdListVoRes myActionAdList(MyActionAdListVo myActionAdListVo);
}
