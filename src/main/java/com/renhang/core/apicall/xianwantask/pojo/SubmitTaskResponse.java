package com.renhang.core.apicall.xianwantask.pojo;

import lombok.Data;

@Data
public class SubmitTaskResponse {
    //是否成功 0成功、其他失败
    private Integer status;
    //显示消息（可显示给用户）
    private String msg;
    //内部消息（查错用）
    private String info;
    //具体返回内容
    private Object data;

}
