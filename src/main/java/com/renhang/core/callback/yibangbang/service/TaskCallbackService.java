package com.renhang.core.callback.yibangbang.service;


import com.renhang.core.callback.yibangbang.pojo.ItemModel;
import com.renhang.core.callback.yibangbang.pojo.Items;
import com.renhang.core.callback.yibangbang.pojo.ReceiveModel;
import com.renhang.core.callback.yibangbang.pojo.reqData;

public interface TaskCallbackService {

    String TaskCallbackService(ReceiveModel receiveModel);
    Items TaskUserCallbackService(ItemModel itemmodel);
}
