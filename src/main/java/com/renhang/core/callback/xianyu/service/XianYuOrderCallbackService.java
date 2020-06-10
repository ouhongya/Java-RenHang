package com.renhang.core.callback.xianyu.service;

import java.util.Map;

public interface XianYuOrderCallbackService {

    void XianYuToOrderCallback(Map<String,String[]> params);

    void XianYuOrderCallbackFailure(Map<String,String[]> params);

    void XianYuNotification(String params);
}
