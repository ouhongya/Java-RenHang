package com.renhang.core.callback.xianwan.service.impl;

import com.renhang.core.callback.xianwan.mapper.OrderCallbackMapper;
import com.renhang.core.callback.xianwan.pojo.OrderCallbackVo;
import com.renhang.core.callback.xianwan.service.OrderCallbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderCallbackServiceImpl implements OrderCallbackService {

    @Autowired
    OrderCallbackMapper orderCallbackMapper;

    /**
     * 回调订单处理
     * @param orderCallbackVo
     * @return
     */
    @Override
    public String OrderCallbackService(OrderCallbackVo orderCallbackVo) {
        orderCallbackMapper.insertOrderToUserCallback(orderCallbackVo);
        return null;
    }
}
