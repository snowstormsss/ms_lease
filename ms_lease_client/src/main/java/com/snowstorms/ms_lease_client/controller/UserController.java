package com.snowstorms.ms_lease_client.controller;

import com.alibaba.fastjson.JSONObject;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;



/**
 * @author  xie
 * @create  2018/2/7 15:25
 * @desc    用户登录注册控制器
 **/
@Controller
public class UserController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    @ResponseBody
    public String register(){
        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add("username", "xyc");
        requestEntity.add("password", "xyc123");
        String res;
        res=restTemplate.postForObject("http://127.0.0.1:7961/register",requestEntity,String.class);
        return res;
    }

    @RequestMapping(value = {"","/"},method = RequestMethod.GET)
    public String index(){    //首页跳登录
        return "main";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login_Post(){    //Get方式
        return "index";
    }
}
