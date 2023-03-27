package com.xingtao.taoapiclientsdk.client;

import cn.hutool.core.lang.hash.Hash;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.xingtao.taoapiclientsdk.model.User;
import com.xingtao.taoapiclientsdk.utils.SignUtils;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author 桃
 * 调用第三方客户端
 * @Date 2023/2/19 16:13
 */
public class Taoapiclient {
    private static final String GATEWAY_HOST = "http://localhost:8090";
    private final String accessKey;
    private final String secretKey;

    public Taoapiclient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }
    public String getNameByGet(String name) {
        HashMap<String,Object> paramMap=new HashMap<>();
        paramMap.put("name",name);
        String result = HttpUtil.get(GATEWAY_HOST + "/api/name/", paramMap);
        System.out.println(result);
        return result;
    }

    public String getNameByPost(String name) {
        // 可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        return HttpUtil.post(GATEWAY_HOST+"/api/name/", paramMap);
    }


    private Map<String, String> getHeaders(String body) {
        Map<String, String> header = new HashMap<>();
        header.put("accessKey", accessKey);
        header.put("sign", SignUtils.getsign(body, secretKey));
        // 防止中文乱码
        header.put("body",body);
        header.put("nonce", RandomUtil.randomNumbers(5));
        header.put("timestamp", String.valueOf(System.currentTimeMillis()));
        return header;
    }
    public String getNameByPostWithJson(User user){
//        String json = JSONUtil.toJsonStr(user);
//        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST + "/api/name/")
//                .addHeaders(getHeaders(json))
//                .body(json)
//                .execute();
//        System.out.println(httpResponse.getStatus());
//        String result = httpResponse.body();
//        System.out.println(result);
//        return result;
        String json = JSONUtil.toJsonStr(user);
        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST + "/api/name/user")
                .addHeaders(getHeaders(json))
                .body(json)
                .execute();
//        System.out.println("response = " + httpResponse);
//        System.out.println("status = " + httpResponse.getStatus());
//        if (httpResponse.isOk()) {
//            return httpResponse.body();
//        }
//        return "failed";
        System.out.println(httpResponse.getStatus());
        String result = httpResponse.body();
        System.out.println(result);
        return result;
    }
}
