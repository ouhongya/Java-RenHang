package com.renhang.core.apicall.kendeji.pojo;

import lombok.Data;

@Data
public class PagedQuery {
    /**
     * int	分页页码，从1开始	true
     */
    private Integer pageIndex;
    /**
     * int	每页大小	true
     */
    private Integer pageSize;
    /**
     * string	最后更新时间开始时间	true
     */
    private String  updateTimeBeginTime;
    /**
     * string	最后更新时间结束时间	true
     */
    private String  updateTimeEndTime;
}
