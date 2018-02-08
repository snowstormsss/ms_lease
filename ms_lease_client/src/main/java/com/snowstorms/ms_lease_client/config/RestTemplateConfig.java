package com.snowstorms.ms_lease_client.config;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Base64;


/**
 * @author  xie
 * @create  2018/2/7 15:27
 * @desc RestTemplate  配置文件
 **/
@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public HttpHeaders getHeaders(){
        HttpHeaders headers=new HttpHeaders();
        String auth="xyc:xyc666";
        byte[] encodeAuth= Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader="Basic "+new String(encodeAuth);
        headers.set("Authorization",authHeader);
        return headers;
    }
}
