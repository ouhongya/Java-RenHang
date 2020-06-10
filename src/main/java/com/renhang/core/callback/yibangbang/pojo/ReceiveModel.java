package com.renhang.core.callback.yibangbang.pojo;


import lombok.Data;

import java.util.Date;

@Data
public class ReceiveModel {
    String id;
    String CodeInfo;
    String MsgInfo;
    reqData[] reqData;
    String signature;
    String create_time;
}
