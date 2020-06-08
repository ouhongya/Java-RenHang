package com.renhang.common.Result;


import com.fasterxml.jackson.annotation.JsonFormat;




@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CommonCode {
    SUCCESS(1,"操作成功"),
    ERROR(2,"系统繁忙")
    ;
    private Integer code;
    private String message;


    CommonCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
