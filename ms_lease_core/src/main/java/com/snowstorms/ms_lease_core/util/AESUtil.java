package com.snowstorms.ms_lease_core.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class AESUtil {  
	private static final String strKey="xyc";
    /** 
     * @param rawKey 
     *            密钥 
     * @param clearPwd 
     *            明文字符串 
     * @return 密文字节数组  加密函数
     */  
    public static String encrypt(String clearPwd) {  
        try {  
            SecretKeySpec secretKeySpec = new SecretKeySpec(getRawKey(strKey.getBytes()), "AES");  
            Cipher cipher = Cipher.getInstance("AES");  
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);  
            byte[] encypted = cipher.doFinal(clearPwd.getBytes()); 
            BASE64Encoder base64Encoder=new BASE64Encoder();
            String result=base64Encoder.encode(encypted);
            System.err.println("原来的byte"+result);
            return result;  
        } catch (Exception e) {  
            return null;  
        }  
    }  
  
    /** 
     * @param encrypted 
     *            密文字节数组 
     * @return 解密后的字符串 
     */  
    public static String decrypt(byte[] encrypted) {  
        try {  
            SecretKeySpec secretKeySpec = new SecretKeySpec(getRawKey(strKey.getBytes()), "AES");  
            Cipher cipher = Cipher.getInstance("AES");  
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);  
            byte[] decrypted = cipher.doFinal(encrypted);  
            return new String(decrypted);  
        } catch (Exception e) {  
            return "";  
        }  
    }  
  
    /** 
     * @param seed种子数据 
     * @return 密钥数据 
     */  
    public static byte[] getRawKey(byte[] seed) {  
        byte[] rawKey = null;  
        try {  
            KeyGenerator kgen = KeyGenerator.getInstance("AES");  
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");  
            secureRandom.setSeed(seed);  
            // AES加密数据块分组长度必须为128比特，密钥长度可以是128比特、192比特、256比特中的任意一个  
            kgen.init(128, secureRandom);  
            SecretKey secretKey = kgen.generateKey();  
            rawKey = secretKey.getEncoded();  
        } catch (NoSuchAlgorithmException e) {  
        }  
        return rawKey;  
    }  
}  