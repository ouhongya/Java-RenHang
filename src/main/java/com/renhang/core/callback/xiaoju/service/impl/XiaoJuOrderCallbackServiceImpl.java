package com.renhang.core.callback.xiaoju.service.impl;

import com.renhang.core.callback.xiaoju.mapper.XiaoJuOrderCallbackMapper;
import com.renhang.core.callback.xiaoju.pojo.QueryResponseVo;
import com.renhang.core.callback.xiaoju.service.XiaoJuOrderCallbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class XiaoJuOrderCallbackServiceImpl implements XiaoJuOrderCallbackService {


    @Autowired
    XiaoJuOrderCallbackMapper juBaoPengOrderCallbackMapper;



    @Override
    public QueryResponseVo notifyOrderInfo(QueryResponseVo queryResponseVo) {
        return null;
    }

    @Override
    public QueryResponseVo notifyCheckUserInfo(QueryResponseVo queryResponseVo) {
        return null;
    }
}
