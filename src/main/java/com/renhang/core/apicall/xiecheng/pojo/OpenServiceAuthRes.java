package com.renhang.core.apicall.xiecheng.pojo;

import lombok.Data;

@Data
public class OpenServiceAuthRes {
    /**
     * 联盟 ID，请求体传入值
     */
    private String AID;
    /**
     * 站点 ID，请求体传入值
     */
    private String SID;
    /**
     * 访问接口用授权
     */
    private String access_token;
    /**
     * 失效时间，单位秒
     */
    private String expires_in;
    /**
     * 刷新接口用授权
     */
    private String refresh_token;
    /**
     * 错误编号
     */
    private String errcode;
    /**
     * 错误信息
     */
    private String errmsg;
}
