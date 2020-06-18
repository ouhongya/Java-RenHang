package com.renhang.core.callback.xianwantask.mapper;


import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface XianwanCallbackMapper {

    void insertOrderToUserCallback(@Param("params") Map<String, String> params);
    Integer queryOrderNum(String orderNum);
    void insertOrderToUsertestCallback(@Param("params") Map<String,String> params);

}
