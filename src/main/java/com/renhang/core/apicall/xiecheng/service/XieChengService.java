package com.renhang.core.apicall.xiecheng.service;

import com.renhang.core.apicall.xiecheng.pojo.OpenServiceAuthRes;
import com.renhang.core.apicall.xiecheng.pojo.OrderDetails;

public interface XieChengService {

    OpenServiceAuthRes OpenServiceAuthauthorize();

    OpenServiceAuthRes OpenServiceAuthRefresh(String token);

    String OpenServiceProxy(String ICODE,String UUID,String Token, String Mode,String Format);

    OrderDetails OpenServiceOrderDetails(String orderId);
}
