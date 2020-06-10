package com.renhang.core.apicall.xiaoju.pojo;

import com.renhang.core.apicall.xiaoju.pojo.queryStoreListVo.StoreInfoListVo;
import lombok.Data;

import java.util.List;

@Data
public class QueryStoreListData {
    private Integer pageIndex;
    private Integer pageSize;
    private Integer totalSize;
    private List<StoreInfoListVo> storeInfoList;
}
