package com.renhang.common.Utils;

import org.springframework.util.DigestUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class GlobalUtils {

    public static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

    /**
     * 时间格式化
     * @param date
     * @return
     */
    public static String format(Date date){
        Date time = date==null ? new Date() : date;
        return sf.format(time);
    }

    public static String format(){
        return simpleDateFormat.format(new Date());
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
     * map转换成javaBean
     * @param map
     * @return
     */
    public static Object transMap2Bean(Map<String,Object> map,Object obj){
        try{
            //1.获取bean信息
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] properties = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor prop: properties) {
                String key = prop.getName();
                if(map.containsKey(key) && map.get(key) != null){
                    Object value = map.get(key);
                    Method setMethod = prop.getWriteMethod();
                    setMethod.invoke(obj,value);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return obj;
    }



    /**
     * UUID生成
     * @return
     */
    public static String uuid(){
        return UUID.randomUUID().toString().toUpperCase().replace("-","");
    }
}
