package com.renhang.core.callback.kendeji.mapper;

import com.renhang.core.callback.kendeji.pojo.KfcOrderVo;
import com.renhang.core.callback.kendeji.pojo.KfcPlaceOrderItemVo;
import com.renhang.core.callback.kendeji.pojo.OrderEventVo;

public interface KenDeJiOrderCallbackMapper {

    void createdOrderEvent(OrderEventVo orderEventVo);

    void createdOrderKenDeJi(KfcOrderVo orderVo);

    void createdOrderKenDeJiItem(KfcPlaceOrderItemVo KfcPlaceOrderItemVo);

    Integer queryKftRefundTime(String params);
}
