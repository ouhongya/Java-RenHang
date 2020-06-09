package com.renhang.core.callback.xianwantask.service;

import com.renhang.core.callback.xianwantask.pojo.XianwanCallbackRes;

import java.util.Map;

public interface XianwanTaskCallbackService {

    XianwanCallbackRes OrderCallbackService(Map<String, String> params);
}
