package com.renhang.core.apicall.xiaoju.pojo;

import com.renhang.core.apicall.xiaoju.pojo.queryStoreListVo.OrderInfoListVo;
import lombok.Data;

import java.util.List;

@Data
public class QueryOrderListVo {
    private Integer pageIndex;
    private Integer pageSize;
    private Integer totalSize;
    private List<OrderInfoListVo> orderInfoList;

}
