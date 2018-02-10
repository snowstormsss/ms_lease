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
import service.IUserService;
import util.MD5Util;

import javax.annotation.Resource;


/**
 * @author xie
 * @create 2018/2/7 15:25
 * @desc 用户登录注册控制器
 **/
@Controller
public class UserController {
    @Resource
    IUserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private HttpHeaders headers;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Result register(@RequestParam("username") String username, @RequestParam("password") String password){
        if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
            return userService.register(username,password);
        } else {
            return Result.error("账号或密码不能为空!");
        }
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String index() {    //首页跳登录
        return "main";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestParam("username") String username, @RequestParam("password") String password) {    //Get方式方便测试
        if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
            return userService.login(username,password);
        } else {
            return Result.error("账号或密码不能为空!");
        }
    }
}
