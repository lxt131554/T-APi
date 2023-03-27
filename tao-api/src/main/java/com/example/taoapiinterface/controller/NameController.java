package com.example.taoapiinterface.controller;

import com.xingtao.taoapiclientsdk.model.User;

import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;


/**
 * @Author 桃
 * @Date 2023/2/19 15:26
 */
@RestController
@RequestMapping("/name")
public class NameController {

    @GetMapping("/")
    public String getNameByGet(String name,HttpServletRequest request) {
//        String sign = request.getHeader("sign");
//        String nonce = request.getHeader("nonce");
//        String timestamp = request.getHeader("timestamp");
        return "发送GET请求 你的名字是：" + name;
    }

    @PostMapping("/")
    public String getNameByPost(@RequestParam(value = "name") String name) {
        return "发送POST请求 你的名字是：" + name;
    }

    @PostMapping("/user")
    public String getNameByPostWithJson(@RequestBody User user, HttpServletRequest request) {
//        String accessKey = request.getHeader("accessKey");
//        // 防止中文乱码
//        String body = URLDecoder.decode(request.getHeader("body"), StandardCharsets.UTF_8.name());
//        String sign = request.getHeader("sign");
//        String nonce = request.getHeader("nonce");
//        String timestamp = request.getHeader("timestamp");
//        boolean hasBlank = StrUtil.hasBlank(accessKey, body, sign, nonce, timestamp);
//        // 判断是否有空
//        if (hasBlank) {
//            return "无权限1";
//        }
//        // TODO 使用accessKey去数据库查询secretKey
//        // 假设查到的secret是abc 进行加密得到sign
//        String secretKey = accessKey;
//        String sign1 = SignUtils.getsign(body, secretKey);
//        if (!StrUtil.equals(sign, sign1)) {
//            return "无权限2";
//        }
//        // TODO 判断随机数nonce
//        // 时间戳是否为数字
//        if (!NumberUtil.isNumber(timestamp)) {
//            return "无权限3";
//        }
//        // 五分钟内的请求有效
//        if (System.currentTimeMillis() - Long.parseLong(timestamp) > 5 * 60 * 1000) {
//            return "无权限4";
//        }
        return "发送POST请求 JSON中你的名字是：" + user.getName();
    }

}
