package com.renhang.core.apicall.xianwan.pojo.TryApiAdClick;

import lombok.Data;

@Data
public class TryApiAdClickRes {
    /**
     * int	状态判断 0：正常 其他错误
     */
    private Integer status;
    /**
     * string	应用下载地址
     */
    private String APPUrl;
    /**
     * string	下载类型 0:直接下载 1：在客户端外部默认浏览器打开url（下载地址或h5链接 ） 2：H5游戏（可webview打开，需要渠道webview支持对接文档中的方法）
     */
    private Integer DownType;
    /**
     * int	返回消息
     */
    private String msg;
}
