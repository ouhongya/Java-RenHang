package com.renhang.core.callback.xiaoju.mapper;

import com.renhang.core.callback.xiaoju.pojo.OrderDetail;

public interface XiaoJuOrderCallbackMapper {

    void createdOrderXiaoJu(OrderDetail notifyOrderInfoVo);

    Integer queryOrderXiaoJuToOrderId(Long orderId);

    void updateXiaoJuOrder(OrderDetail notifyOrderInfoVo);
}
