package config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @author  xieyucheng
 * @create  2018/2/10 16:03
 * @desc  Feign基本配置
 **/
@Configuration
public class FeignConfig {
    @Bean
    public BasicAuthRequestInterceptor getBasicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor("xyc","xyc666");
    }
}
