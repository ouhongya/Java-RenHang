package com.renhang.core.callback.xianwan.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class OrderCallbackVo {
    private String id;
    private Integer adid;
    private String adname;
    private String appid;
    private String ordernum;
    private Integer dlevel;
    private String pagename;
    private Integer atype;
    private String deviceid;
    private String simid;
    private String appsign;
    private String merid;
    private String event;
    private String adicon;
    private String price;
    private String money;
    @JsonFormat(pattern = "yyyy-HH-dd HH:mm:ss",timezone = "GMT+8")
    private Date itime;
    private String keycode;
    @JsonFormat(pattern = "yyyy-HH-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdTime;
}
