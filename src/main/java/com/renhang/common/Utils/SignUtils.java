package com.renhang.common.Utils;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.util.Map;
import java.util.TreeMap;

/**
 * 签名工具类
 */
@UtilityClass
public class SignUtils {



    /**
     * 生成签名
     *
     * @param map    要验签的对象map
     * @param secret 密钥
     * @return 签名
     */
    @SneakyThrows
    public static String generateSign(Map<String, String> map, String secret) {
        Map<String, String> reqMap = new TreeMap<>(map);

        StringBuilder paramBuilder = new StringBuilder();
        reqMap.forEach((k, v) ->
                paramBuilder.append(String.format("%s=%s&", k, v == null ? "" : v))
        );
        String paramStr = paramBuilder.substring(0, paramBuilder.length()-1);
        paramStr = paramStr + secret;

        return Md5Utils.md5(paramStr);
    }
}
