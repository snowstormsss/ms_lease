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
import org.springframework.web.bind.annotation.RequestParam;
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
    public Result register(User user){
        return userService.register(user);
    }

    @PostMapping(value = "/login")
    public Result login(User user){
        return userService.login(user);
    }

    @PostMapping(value = "/findByName")
    public Result findByName(@RequestParam(value = "username")String username){
        return userService.findByName(username);
    }
}
