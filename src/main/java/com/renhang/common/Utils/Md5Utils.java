package com.renhang.common.Utils;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/**
 * md5 工具类
 *
 * @author xuyanjun
 * @date 2020/4/10
 */
@UtilityClass
public class Md5Utils {

    /**
     * 将字符串进行MD5加密
     *
     * @param content 要加密的内容
     * @return 加密后的内容
     */
    @SneakyThrows
    public static String md5(String content) {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(content.getBytes(Charset.forName("utf-8")));
        byte[] digest = md.digest();
        return DatatypeConverter.printHexBinary(digest);
    }
}
