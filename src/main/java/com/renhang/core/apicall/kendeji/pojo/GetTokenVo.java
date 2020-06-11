package com.renhang.core.apicall.kendeji.pojo;

import lombok.Data;

@Data
public class GetTokenVo {
    private boolean success;
    private Integer code;
    private GetTokenData data;
    @Data
    class GetTokenData{
        private String accessToken;
        private Integer userId;
    }
}
