package com.renhang.core.callback.kendeji.mapper;

import com.renhang.core.callback.kendeji.pojo.KfcOrderVo;
import com.renhang.core.callback.kendeji.pojo.KfcPlaceOrderItemVo;
import com.renhang.core.callback.kendeji.pojo.OrderEventVo;
import org.apache.ibatis.annotations.Param;

public interface KenDeJiOrderCallbackMapper {

    void createdOrderEvent(@Param("orderEventVo") OrderEventVo orderEventVo);

    void updateOrderEvent(OrderEventVo orderEventVo);

    void createdOrderKenDeJi(KfcOrderVo orderVo);

    void updateOrderKenDeJi(KfcOrderVo orderVo);

    void createdOrderKenDeJiItem(KfcPlaceOrderItemVo KfcPlaceOrderItemVo);

    Integer queryKftRefundTime(String params);
}
