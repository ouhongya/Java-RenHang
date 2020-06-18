package com.renhang.core.callback.xianwantask.service;

import com.renhang.core.callback.xianwan.pojo.OrderCallbackRes;
import com.renhang.core.callback.xianwantask.pojo.XianwanCallbackRes;

import java.util.Map;

public interface XianwanTaskCallbackService {

    XianwanCallbackRes XianwanCallbackService(Map<String, String> params);
    OrderCallbackRes OrderCallbackService(Map<String,String> params);
}
