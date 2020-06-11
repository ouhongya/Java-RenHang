package com.renhang.core.callback.yibangbang.pojo;


import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ReceiveModel {
    String id;
    String CodeInfo;
    String MsgInfo;
    List<reqData> reqData;
    String signature;
    String create_time;
}
