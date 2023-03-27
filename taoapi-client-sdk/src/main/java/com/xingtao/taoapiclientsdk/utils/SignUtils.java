package com.xingtao.taoapiclientsdk.utils;


import cn.hutool.crypto.digest.DigestUtil;

/**
 * @Author 桃
 * @Date 2023/2/20 11:15
 */
public class SignUtils {
    public static String getsign(String body, String secretKey){
        String content = body + "." + secretKey;
        return DigestUtil.md5Hex(content);
    }
}
