package com.renhang.core.callback.kendeji.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 肯德基下单信息 model
 *
 * @author xuyanjun
 * @date 2020/4/10
 */
@Data
public class KfcPlaceOrderVo implements Serializable {

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 餐厅名称
     */
    private String storeName;

    /**
     * 餐厅编号
     */
    private String storeCode;

    /**
     * 餐厅地址
     */
    private String storeAddress;

    /**
     * 就餐方式  1:堂食  2:打包
     */
    private Integer eatType;

    /**
     * 商品明细
     */
    private List<KfcPlaceOrderItemVo> items;
}
