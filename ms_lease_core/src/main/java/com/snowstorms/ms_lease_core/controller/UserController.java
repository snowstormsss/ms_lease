package com.snowstorms.ms_lease_core.controller;

import com.snowstorms.ms_lease_core.service.UserService;
import domain.User;
import dto.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    Logger logger= LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

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
