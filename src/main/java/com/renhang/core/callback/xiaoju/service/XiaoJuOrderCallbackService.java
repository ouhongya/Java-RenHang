package com.renhang.core.callback.xiaoju.service;

import com.renhang.core.callback.xiaoju.pojo.QueryResponseVo;

import java.util.Map;

public interface XiaoJuOrderCallbackService {

    QueryResponseVo notifyOrderInfo( QueryResponseVo queryResponseVo);

    QueryResponseVo notifyCheckUserInfo( QueryResponseVo queryResponseVo);

}
