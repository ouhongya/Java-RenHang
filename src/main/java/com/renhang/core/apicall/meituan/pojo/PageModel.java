package com.renhang.core.apicall.meituan.pojo;

import lombok.Data;

import java.util.List;

@Data
public class PageModel {
    //总条数
    private  String recordCount;
    //每⻚数⽬
    private  Integer pageSize ;
    //当前⻚数
    private  Integer page  ;
    //订单数据
    private List<PromoteVerifyItemDataVO> records;

}
