package com.renhang.core.apicall.xiecheng.pojo;

import lombok.Data;

@Data
public class OpenServiceAuthRes {
    private String AID;
    private String SID;
    private String access_token;
    private String expires_in;
    private String refresh_token;
    private String errcode;
    private String errmsg;
}
