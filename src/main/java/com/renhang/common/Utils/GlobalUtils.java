package com.renhang.common.Utils;

import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class GlobalUtils {

    public static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 时间格式化
     * @param date
     * @return
     */
    public static String format(Date date){
        Date time = date==null ? new Date() : date;
        return sf.format(time);
    }

    /**
     * 拼接签名需要的字符串
     * @param map
     * @return
     */
    public String mapStr(Map<String,String> map){
        String data = "";
        for (String s : map.keySet()) {
            data+=s+"="+map.get(s)+"&";
        }
        return data;
    }






    /**
     * UUID生成
     * @return
     */
    public static String uuid(){
        return UUID.randomUUID().toString().toUpperCase().replace("-","");
    }
}
