package com.renhang.core.callback.yibangbang.pojo;


import lombok.Data;

import java.util.Date;

@Data
public class ReceiveModel {
    String id;
    int CodeInfo;
    String MsgInfo;
    reqData[] reqData;
    String signature;
    Date create_time;

}
