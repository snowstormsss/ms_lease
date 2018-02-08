package com.snowstorms.ms_lease_core.controller;

import domain.User;
import dto.Result;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author  xieyucheng
 * @create  2018/2/7 15:30
 * @desc  //
 **/
@RestController
public class UserController {
    @PostMapping(value = "/register")
    public String register(User user){
        return user.getUsername()+" "+user.getPassword();
    }

    @PostMapping(value = "/login")
    public Result login(User user){
        if(user.getUsername().equals("xyc") && user.getPassword().equals("xyc123")){
            return Result.buildSuccessData("登录成功");
        }
        else{
            return Result.error(HttpStatus.BAD_REQUEST.value(),"账号或密码错误!");
        }
    }
}
