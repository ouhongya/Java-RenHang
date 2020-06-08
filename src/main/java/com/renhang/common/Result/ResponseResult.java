package com.renhang.common.Result;
import lombok.Data;

@Data
public class ResponseResult {
    private CommonCode status;
    private Object data;

    public ResponseResult(CommonCode status, Object data) {
        this.status = status;
        this.data = data;
    }

    public ResponseResult(CommonCode status) {
        this.status = status;
    }
}
