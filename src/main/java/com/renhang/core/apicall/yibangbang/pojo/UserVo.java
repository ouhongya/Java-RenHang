package com.renhang.core.apicall.yibangbang.pojo;

import lombok.Data;



@Data
public class UserVo {
    //用户手机号
    private String phone;
    //国家区号(大陆手机号可不填写)
    private Integer area_code;


}
