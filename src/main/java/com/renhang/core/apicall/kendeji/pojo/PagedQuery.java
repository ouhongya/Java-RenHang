package com.renhang.core.apicall.kendeji.pojo;

import lombok.Data;

@Data
public class PagedQuery {
    private Integer pageIndex;
    private Integer pageSize;
    private String  updateTimeBeginTime;
    private String  updateTimeEndTime;
}
