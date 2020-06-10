package com.renhang.core.callback.xianyu.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface XianYuOrderCallbackMapper {

    void XianYuToOrderCallbackTo(@Param("params") Map<String,String>params);

    void XianYuOrderCallbackFailure(@Param("params") Map<String,String>params);

    void XianYuNotification(@Param("params") Map<String,String> params);
}
