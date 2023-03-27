package com.example.taoapiinterface;
import com.xingtao.taoapiclientsdk.client.Taoapiclient;
import com.xingtao.taoapiclientsdk.model.User;
import java.io.UnsupportedEncodingException;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
/**
 * @Author 桃
 * @Date 2023/2/19 16:17
 */
public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String accessKey="123456789";
        String secretKey="123456789";
        Taoapiclient taoapiclient=new Taoapiclient(accessKey,secretKey);
        String result1=taoapiclient.getNameByGet("兴陶");
        String result2=taoapiclient.getNameByPost("xingtao");
        User user=new User();
        user.setName("111");
        String result3= taoapiclient.getNameByPost(user.name);
//        HttpServletRequest httpServletRequest=new HttpServletRequestWrapper()
        String result4=taoapiclient.getNameByPostWithJson(user);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }
}
