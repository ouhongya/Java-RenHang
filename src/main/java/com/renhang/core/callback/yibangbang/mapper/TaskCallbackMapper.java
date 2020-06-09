package com.renhang.core.callback.yibangbang.mapper;


import com.renhang.core.callback.yibangbang.pojo.Items;
import com.renhang.core.callback.yibangbang.pojo.ReceiveModel;
import com.renhang.core.callback.yibangbang.pojo.reqData;

public interface TaskCallbackMapper {
    void insertTaskCallback(ReceiveModel receiveModel);
    void insertTaskreqDataCallback(reqData reqdata);
    Items findUserbyphone(String phone);
}
