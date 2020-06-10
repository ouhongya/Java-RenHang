package com.renhang.core.callback.kendeji.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 肯德基下单明细 model
 *
 * @author xuyanjun
 * @date 2020/4/10
 */
@Data
public class KfcPlaceOrderItemVo implements Serializable {

    /**
     * id
     */
    private String id;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 订单id
     */
    private String  order_kendejiId;

    /**
     * 商品id
     */
    private String productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 价格(元)
     */
    private BigDecimal price;

    /**
     * 图片url
     */
    private String imageUrl;

    /**
     * 是否已取消
     */
    private Boolean canceled;
}
