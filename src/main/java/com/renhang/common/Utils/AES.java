package com.renhang.common.Utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AES {
    private static final String ENCRY_ALGORITHM = "AES";
    /**
     * 加密算法/加密模式/填充类型
     */
    private static final String CIPHER_MODE = "AES/ECB/PKCS5Padding";
    /**
     * 设置 iv 偏移量
     */
    private static final String IV_ = null;
   /**
   * 设置加密字符集
   */
   private static final String CHARACTER = "UTF-8";
    /**
     * 设置加密密码处理长度。
     */
    private static final int PWD_SIZE = 16;
    /**
     * 加密
     */
    public static String encryptHex(String text, String password) {
        try {
            byte[] cipherTextBytes = encrypt(text.getBytes(CHARACTER),
                    pwdHandler(password));
            String cipherText = byte2hex(cipherTextBytes);
            return cipherText;
        } catch (Exception e) {
             e.printStackTrace();
        }
        return null;
    }
    public static byte[] encrypt(byte[] clearTextBytes, byte[] pwdBytes)
            throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(pwdBytes, ENCRY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(CIPHER_MODE);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] cipherTextBytes = cipher.doFinal(clearTextBytes);
        return cipherTextBytes;
    }


    /**
     * 密码处理方法
     */
    public static byte[] pwdHandler(String password) throws Exception{
        byte[] data = null;
        if (password == null) {
            password = "";
        }
        StringBuffer sb = new StringBuffer(PWD_SIZE);
        sb.append(password);
        while (sb.length() < PWD_SIZE){
            sb.append("0");
        }
        if (sb.length() > PWD_SIZE) {
            sb.setLength(PWD_SIZE);
        }
        data = sb.toString().getBytes("UTF-8");
        return data;
    }
    public static String byte2hex(byte[] bytes) {
        StringBuffer sb = new StringBuffer(bytes.length * 2);
        String tmp = "";
        for (int n = 0; n < bytes.length; n++) {
            tmp = (java.lang.Integer.toHexString(bytes[n] & 0XFF));
            if (tmp.length() == 1) {
                sb.append("0");
            }
            sb.append(tmp);
        }
        return sb.toString().toUpperCase();
    }
    public static void main(String[] args) {
        String test = encryptHex("10001555510603", "");
        try {
            byte[] bytes = pwdHandler("10001555510603");
        }catch (Exception e){
            e.printStackTrace();
        }


        System.out.println(test);
    }

}
