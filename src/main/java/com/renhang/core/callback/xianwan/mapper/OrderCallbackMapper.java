package com.renhang.core.callback.xianwan.mapper;


import com.renhang.core.callback.xianwan.pojo.OrderCallbackVo;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface OrderCallbackMapper {

    void insertOrderToUserCallback(@Param("params") Map<String,String> params);
    Integer queryOrderNum(String orderNum);
}
