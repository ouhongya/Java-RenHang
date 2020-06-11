package com.renhang.core.apicall.xianwantask.pojo;

import lombok.Data;

import java.util.List;

@Data
public class CpaTaskStep {
    private  Integer itemId;
    private  int groupId;
    private  int sort;
    private  int type;
    private  String intro;
    private  String img;
    private  String inviteCode;
    private List choiceQuestionList;
    private boolean stepStatus;
    private  String fillHint;
}
