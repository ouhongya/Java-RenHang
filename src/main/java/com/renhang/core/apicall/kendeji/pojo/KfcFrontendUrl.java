package com.renhang.core.apicall.kendeji.pojo;

import lombok.Data;

@Data
public class KfcFrontendUrl {
    /**
     * string	首页
     */
    private  String index;
    /**
     * string	订单详情页
     */
    private  String orderInfo;
    /**
     * string	订单列表页
     */
    private  String orderList;
}
