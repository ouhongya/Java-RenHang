package com.renhang.core.callback.kendeji.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Data
@ConfigurationProperties(prefix = "kfc")
public class KfcProperty {

    /**
     * 平台id
     */
    private Integer platformId;

    /**
     * 密钥
     */
    private String secret;

    /**
     * 服务器地址
     */
    private String serverUrl;

    /**
     * 连接超时时间(毫秒)
     */
    private Integer timeout = 10000;
}
