package com.renhang.core.callback.yibangbang.pojo;


import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ReceiveModel {
    //id
    String id;
    //回调code
    String CodeInfo;
    //返回信息
    String MsgInfo;
    //完成的任务信息
    List<reqData> reqData;
    //签名
    String signature;
    //创建时间
    String create_time;
}
