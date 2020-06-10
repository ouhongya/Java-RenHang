package com.renhang.common.Utils;
import com.alibaba.fastjson.JSON;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class SecurityUtil {
    private static final String appKey = "";
    private static final String appSecret = "";
    private static final String dataSecret = "";
    private static final String sigSecret = "";

    public static void main(String[] args) throws Exception {
        Map<String, Object> originRequestDataMap = new HashMap<String, Object>(4) {
            {
                put("appSecret", appSecret);
            }
        };

        String originRequestDataJsonStr = JSON.toJSONString(originRequestDataMap);
        System.out.println("原始请求 jsonStr:" + originRequestDataJsonStr);
        //{"appSecret":"HlqAnnonTUxDr51AynjlNYzdt+OYXaqceMI70CskDis="}

        // 加密
        String encryptedRequestDataStr = encrypt(originRequestDataJsonStr, dataSecret, dataSecret);
        System.out.println("加密后请求 str:" + encryptedRequestDataStr);
        //wcz5oKvj9t112I/oWaW0fQhiGvF6JiGHNjGWtLnvN+Jv3Q8Bg7zvbyNx+9CNFKWz35eNqGhVL1cdgaMkE0iO7w==

        // 解密
        String decryptedStr = decrypt(encryptedRequestDataStr, dataSecret, dataSecret);
        System.out.println("解密后请求 str:" + decryptedStr);
        //{"appSecret":"HlqAnnonTUxDr51AynjlNYzdt+OYXaqceMI70CskDis="}

        // request 加签
        String timestamp = "20200309160100";
        String requestSignStr = signRequest(appKey, sigSecret, encryptedRequestDataStr, timestamp);
        System.out.println("加签后请求数据:" + requestSignStr);
        //4C1153DD1A1C98B02B5AD135E42BA65A

        Map<String, Object> requestParamDataMap = new HashMap<String, Object>(6) {
            {
                put("appKey", appKey);
                put("data", encryptedRequestDataStr);
                put("timeStamp", timestamp);
                put("sig", requestSignStr);
            }
        };
        System.out.println("request str:" + JSON.toJSONString(requestParamDataMap));
        //{"timeStamp":"20200309160100","sig":"4C1153DD1A1C98B02B5AD135E42BA65A","appKey":"xiongtest","data":"wcz5oKvj9t112I/oWaW0fQhiGvF6JiGHNjGWtLnvN+Jv3Q8Bg7zvbyNx+9CNFKWz35eNqGhVL1cdgaMkE0iO7w=="}

        // response 加签
        Map<String, Object> originResponseDataMap = new HashMap<String, Object>(4) {
            {
                put("accessToken", "1d79ec49f7604ed589821403ca08e21f");
                put("availableTime", 7200);
            }
        };
        String originResponseJsonStr = JSON.toJSONString(originResponseDataMap);
        System.out.println("原始响应:" + originResponseJsonStr);
        //{"accessToken":"1d79ec49f7604ed589821403ca08e21f","availableTime":7200}

        String encryptedResponseStr = encrypt(originResponseJsonStr, dataSecret, dataSecret);
        System.out.println("加密响应:" + encryptedResponseStr);
        //34bgypgmDHZPaA3nsqJD0sO13xP284Nw8rjrXVr87hYRwyDyMnsjwYhps+2IgVtEJfAio97b9Of+5Y6N63N2MwkrKvmPIQU1XxtUTx6dUDA=

        String code = "0";
        String msg = "请求成功";
        String responseSignStr = signResponse(appKey, sigSecret, encryptedResponseStr, code, msg);
        System.out.println("响应签名:" + responseSignStr);
        //A663BFB99FED85FDE7D7180D1DB572FD

        Map<String, Object> responseParamMap = new HashMap<String, Object>(8) {
            {
                put("appKey", appKey);
                put("data", encryptedResponseStr);
                put("code", code);
                put("msg", msg);
                put("sig", responseSignStr);
            }
        };
        System.out.println("response str:" + JSON.toJSONString(responseParamMap));
        //{"msg":"请求成功","sig":"A663BFB99FED85FDE7D7180D1DB572FD","appKey":"xiongtest","code":"0","data":"34bgypgmDHZPaA3nsqJD0sO13xP284Nw8rjrXVr87hYRwyDyMnsjwYhps+2IgVtEJfAio97b9Of+5Y6N63N2MwkrKvmPIQU1XxtUTx6dUDA="}
    }

    public static String encrypt(String originDataStr, String dataSecret, String dataSecretIv) throws Exception {
        byte[] raw = dataSecret.getBytes("UTF-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec iv = new IvParameterSpec(dataSecretIv.getBytes());
        cipher.init(1, skeySpec, iv);

        byte[] encryptedBytes = cipher.doFinal(originDataStr.getBytes());
        String str = (new BASE64Encoder()).encode(encryptedBytes);
        str = str.replaceAll("\\r", "").replaceAll("\\n", "");

        return str;
    }

    public static String decrypt(String encodedDataStr, String dataSecret, String dataSecretIv) throws Exception {
        byte[] raw = dataSecret.getBytes("UTF-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec iv = new IvParameterSpec(dataSecretIv.getBytes());
        cipher.init(2, skeySpec, iv);

        byte[] encryptedBytes = (new BASE64Decoder()).decodeBuffer(encodedDataStr);
        byte[] original = cipher.doFinal(encryptedBytes);
        String originalString = new String(original, "UTF-8");

        return originalString;
    }

    public static String signRequest(String appKey, String sigSecret, String data, String timestamp) throws Exception {
        String strToBeSigned = appKey + data + timestamp;
        return getHmacMd5Str(sigSecret, strToBeSigned);
    }

    public static String signResponse(String appKey, String sigSecret, String data, String code, String msg) throws Exception {
        String strToBeSigned = appKey + data + code + msg;
        return getHmacMd5Str(sigSecret, strToBeSigned);
    }

    public static String getHmacMd5Str(String key, String data) throws Exception {
        byte[] keyByte = key.getBytes("UTF-8");
        byte[] dataByte = data.getBytes("UTF-8");
        byte[] hmacMd5Byte = getHmacMd5Bytes(keyByte, dataByte);
        StringBuffer md5StrBuff = new StringBuffer();

        for (int i = 0; i < hmacMd5Byte.length; ++i) {
            if (Integer.toHexString(255 & hmacMd5Byte[i]).length() == 1) {
                md5StrBuff.append("0").append(Integer.toHexString(255 & hmacMd5Byte[i]));
            } else {
                md5StrBuff.append(Integer.toHexString(255 & hmacMd5Byte[i]));
            }
        }

        return md5StrBuff.toString().toUpperCase();
    }

    public static byte[] getHmacMd5Bytes(byte[] key, byte[] data) throws NoSuchAlgorithmException {
        int length = 64;
        byte[] ipad = new byte[length];
        byte[] opad = new byte[length];

        for (int i = 0; i < 64; ++i) {
            ipad[i] = 54;
            opad[i] = 92;
        }

        byte[] actualKey = key;
        byte[] keyArr = new byte[length];
        if (key.length > length) {
            actualKey = md5(key);
        }

        int i;
        for (i = 0; i < actualKey.length; ++i) {
            keyArr[i] = actualKey[i];
        }

        if (actualKey.length < length) {
            for (i = actualKey.length; i < keyArr.length; ++i) {
                keyArr[i] = 0;
            }
        }

        byte[] kIpadXorResult = new byte[length];

        for (i = 0; i < length; ++i) {
            kIpadXorResult[i] = (byte) (keyArr[i] ^ ipad[i]);
        }

        byte[] firstAppendResult = new byte[kIpadXorResult.length + data.length];

        for (i = 0; i < kIpadXorResult.length; ++i) {
            firstAppendResult[i] = kIpadXorResult[i];
        }

        for (i = 0; i < data.length; ++i) {
            firstAppendResult[i + keyArr.length] = data[i];
        }

        byte[] firstHashResult = md5(firstAppendResult);
        byte[] kOpadXorResult = new byte[length];

        for (i = 0; i < length; ++i) {
            kOpadXorResult[i] = (byte) (keyArr[i] ^ opad[i]);
        }

        byte[] secondAppendResult = new byte[kOpadXorResult.length + firstHashResult.length];

        for (i = 0; i < kOpadXorResult.length; ++i) {
            secondAppendResult[i] = kOpadXorResult[i];
        }

        for (i = 0; i < firstHashResult.length; ++i) {
            secondAppendResult[i + keyArr.length] = firstHashResult[i];
        }

        byte[] hmacMd5Bytes = md5(secondAppendResult);
        return hmacMd5Bytes;
    }

    private static byte[] md5(byte[] str) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(str);
        return md.digest();
    }
}
