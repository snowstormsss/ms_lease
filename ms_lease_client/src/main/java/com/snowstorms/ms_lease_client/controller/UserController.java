package com.snowstorms.ms_lease_client.controller;


import com.auth0.jwt.internal.org.apache.commons.lang3.StringUtils;
import com.snowstorms.ms_lease_client.contant.BaseContant;
import dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


/**
 * @author xie
 * @create 2018/2/7 15:25
 * @desc 用户登录注册控制器
 **/
@Controller
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private HttpHeaders headers;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @ResponseBody
    public String register() {
        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add("username", "xyc");
        requestEntity.add("password", "xyc123");
        String res;
        res = restTemplate.exchange(BaseContant.BasePrefix + "/register", HttpMethod.POST, new HttpEntity<Object>(requestEntity, this.headers), String.class).getBody();
        return res;
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String index() {    //首页跳登录
        return "main";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public Result login(@RequestParam("username") String username, @RequestParam("password") String password) {    //Get方式方便测试
        if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
            MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
            requestEntity.add("username", username);
            requestEntity.add("password", password);
            return restTemplate.exchange(BaseContant.BasePrefix + "/login", HttpMethod.POST, new HttpEntity<Object>(requestEntity, this.headers), Result.class).getBody();
        } else {
            return Result.error("账号或密码不能为空!");
        }
    }
}
