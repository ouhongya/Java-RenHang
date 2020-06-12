package com.renhang.core.callback.xiecheng.mapper;

import com.renhang.core.callback.xiecheng.pojo.ItemInfos;
import com.renhang.core.callback.xiecheng.pojo.XieChenOrderCallbackVo;

public interface XieChengOrderCalBackMapper {
    XieChenOrderCallbackVo queryOrderToOrderId(String ordernum);

    void createdXieChengOrder(XieChenOrderCallbackVo xieChenOrderCallbackVo);

    void createdXieChengOrderItem(ItemInfos itemInfos);

    void updateOrder(XieChenOrderCallbackVo xieChenOrderCallbackVo);

    void updateOrderItem(ItemInfos itemInfos);
}
