package com.renhang.core.callback.xianwan.service;

import com.renhang.core.callback.xianwan.pojo.OrderCallbackRes;
import com.renhang.core.callback.xianwan.pojo.OrderCallbackVo;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public interface OrderCallbackService {

    OrderCallbackRes OrderCallbackService(Map<String,String> params);
}
