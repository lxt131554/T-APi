package com.xingtao.taoapiclientsdk;

import com.xingtao.taoapiclientsdk.client.Taoapiclient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author 桃
 * @Date 2023/2/20 14:25
 */
@Configuration
@ConfigurationProperties("taoapi.client")
@Data
@ComponentScan
public class TaoApiClientConfig {
    private   String accessKey;
    private   String secretKey;

    @Bean
    public Taoapiclient taoapiclient(){
        return new Taoapiclient(accessKey,secretKey);
    }
}
