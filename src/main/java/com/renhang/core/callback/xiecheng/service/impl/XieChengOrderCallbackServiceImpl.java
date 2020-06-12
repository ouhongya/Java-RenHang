package com.renhang.core.callback.xiecheng.service.impl;

import com.renhang.common.Utils.GlobalUtils;
import com.renhang.core.callback.xiecheng.mapper.XieChengOrderCalBackMapper;
import com.renhang.core.callback.xiecheng.pojo.ItemInfos;
import com.renhang.core.callback.xiecheng.pojo.XieChenOrderCallbackVo;
import com.renhang.core.callback.xiecheng.service.XieChengOrderCallbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class XieChengOrderCallbackServiceImpl implements XieChengOrderCallbackService {

    @Autowired
    XieChengOrderCalBackMapper xieChengOrderCalBackMapper;

    /**
     * 携程订单回调接口
     * @param xieChenOrderCallbackVo
     */
    @Override
    public void xieChenOrderCallbackVo(XieChenOrderCallbackVo xieChenOrderCallbackVo) {
        XieChenOrderCallbackVo orderCallbackVo = xieChengOrderCalBackMapper.queryOrderToOrderId(xieChenOrderCallbackVo.getOrderId());
        //说明数据库有这个订单
        List<ItemInfos> itemInfos = xieChenOrderCallbackVo.getItemInfos();
        if(orderCallbackVo!=null){
            //跟新订单
            xieChengOrderCalBackMapper.updateOrder(xieChenOrderCallbackVo);
            for (ItemInfos itemInfo : itemInfos) {
                itemInfo.setOrderId(xieChenOrderCallbackVo.getOrderId());
                xieChengOrderCalBackMapper.updateOrderItem(itemInfo);
            }
            return;
        }
        //插入订单主表数据
        xieChenOrderCallbackVo.setId(GlobalUtils.uuid());
        xieChenOrderCallbackVo.setCreatedTime(new Date());
        xieChengOrderCalBackMapper.createdXieChengOrder(xieChenOrderCallbackVo);
        //插入订单子表数据
        for (ItemInfos itemInfo : itemInfos) {
            itemInfo.setId(GlobalUtils.uuid());
            itemInfo.setOrderId(xieChenOrderCallbackVo.getOrderId());
            itemInfo.setCreatedTime(new Date());
            xieChengOrderCalBackMapper.createdXieChengOrderItem(itemInfo);
        }
    }
}
