package com.renhang.core.callback.yibangbang.mapper;


import com.renhang.core.callback.yibangbang.pojo.Items;
import com.renhang.core.callback.yibangbang.pojo.ReceiveModel;
import com.renhang.core.callback.yibangbang.pojo.reqData;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface TaskCallbackMapper {
    void insertTaskCallback(ReceiveModel receiveModel);
    void insertTaskreqDataCallback(reqData reqdata);
    void insertUser(@Param("params") Map<String, String> params);
}
