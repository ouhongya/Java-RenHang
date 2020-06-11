package com.renhang.core.callback.xiecheng.pojo;

public enum OrderStatus {

    DIY_CONFIRMING("自游行我携状态-确认中"),
    DIY_CONFIRMED("自游行我携状态-已确认"),
    DIY_PAYED("自游行我携状态-已付款"),
    DIY_COMPLETED("自游行我携状态-已成交"),
    DIY_CANCELLED("自游行我携状态-已取消"),
    DIY_UNSUBCRIBE_ALL(" 自游行我携状态-全部退订"),
    DIY_UNSUBCRIBE_PART(" 自游行我携状态-部分退订"),
    DIY_PAYED_PART("自游行我携状态-部分付款"),
    DIY_UNCOMMIT("自游行我携状态-未提交"),
    DIY_UNPAID("自游行我携状态-待支付"),
    DIY_CONFIRMING_NEW("自游行我携状态-确认中")

    ;

    private String chinese;

    OrderStatus(String chinese) {
        this.chinese = chinese;
    }

    public String getChinese() {
        return chinese;
    }

}
