package com.it.webui.util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
 
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.RandomStringUtils;

import sun.misc.BASE64Decoder;
 
@SuppressWarnings("restriction")
public class EncryptUtil {
    private static final String KEY = "asiainfoasiainfo";  
    private static final String ALGORITHMSTR = "AES/ECB/PKCS5Padding";  
    public static String base64Encode(byte[] bytes){  
        return Base64.encodeBase64String(bytes);  
    }  
	public static byte[] base64Decode(String base64Code) throws Exception{  
        return new BASE64Decoder().decodeBuffer(base64Code);  
    }  
    public static byte[] aesEncryptToBytes(String content, String encryptKey) throws Exception {  
        KeyGenerator kgen = KeyGenerator.getInstance("AES");  
        kgen.init(128);  
        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);  
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encryptKey.getBytes(), "AES"));  
        return cipher.doFinal(content.getBytes("utf-8"));  
    }  
    public static String aesEncrypt(String content, String encryptKey) throws Exception {  
        return base64Encode(aesEncryptToBytes(content, encryptKey));  
    }  
    public static String aesDecryptByBytes(byte[] encryptBytes, String decryptKey) throws Exception {  
        KeyGenerator kgen = KeyGenerator.getInstance("AES");  
        kgen.init(128);  
        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);  
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(decryptKey.getBytes(), "AES"));  
        byte[] decryptBytes = cipher.doFinal(encryptBytes);  
        return new String(decryptBytes);  
    }  
    public static String aesDecrypt(String encryptStr, String decryptKey) throws Exception {  
        return aesDecryptByBytes(base64Decode(encryptStr), decryptKey);  
    }  
    
    public static String randomSecret(){
    	return RandomStringUtils.randomAlphanumeric(16);
    }
    /**
     * 测试
     * 
     */
    public static void main(String[] args) throws Exception {
    	//3eEOZwTL4aoUO1fy
    	//userName: aJK41Asn+pLvkmO9rGPYKA==
    	//password: QW8r65Wn6qG7Qcy4IIH8Jg==
    	String decrypt = aesDecrypt("QW8r65Wn6qG7Qcy4IIH8Jg==", KEY);  
        System.out.println("解密后：" + decrypt); 
    	
       /* String content = "123456";  //0gqIDaFNAAmwvv3tKsFOFf9P9m/6MWlmtB8SspgxqpWKYnELb/lXkyXm7P4sMf3e
        System.out.println("加密前：" + content);  //i4JtuVtvzLpRugcQLxQUKQ==
        String key = "1111111111111111";
        System.out.println("加密密钥和解密密钥：" + key);  
        String encrypt = aesEncrypt(content, key);  
        System.out.println(encrypt.length()+":加密后：" + encrypt); 
        String decrypt = aesDecrypt(encrypt, "1111111111111111");  
        System.out.println("解密后：" + decrypt);  
        System.out.println(key); */
    }
}

