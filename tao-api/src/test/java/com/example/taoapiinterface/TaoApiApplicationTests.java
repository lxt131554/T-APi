package com.example.taoapiinterface;
import com.xingtao.taoapiclientsdk.client.Taoapiclient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;

@SpringBootTest
class TaoApiApplicationTests {

    @Resource
    private Taoapiclient taoapiclient;
    @Test
    void contextLoads() {
        String result=taoapiclient.getNameByPost("123");
        String usernamepost=taoapiclient.getNameByPost("666");
        System.out.println(result);
        System.out.println(usernamepost);
    }

}
