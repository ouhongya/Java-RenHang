package com.renhang.core.apicall.xianwantask.pojo.TryApiAdInfoRes;

import lombok.Data;

@Data
public class SubmitTaskSignatureinfo {
    //访问ID
   private String accessId;
    //直传访问地址
    private String host;
    //应用策略码
    private String policy;
    //签名
    private String signature;
    //过期时间时间戳
    private String expire;
    //回调签名
    private String callback;
    //是否使用callback
    private String useCallback;
    //需要上传的文件夹
    private String dir;

}
