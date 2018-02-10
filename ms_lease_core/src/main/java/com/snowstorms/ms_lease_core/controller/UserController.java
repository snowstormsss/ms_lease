package com.snowstorms.ms_lease_core.controller;

import com.snowstorms.ms_lease_core.service.UserService;
import domain.User;
import dto.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import util.MD5Util;

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

    @PostMapping(value = "/register/{username}/{password}")
    Result register(@PathVariable("username")String username, @PathVariable("password")String password){
        logger.info("port:"+"${server.port}");
        return userService.register(username,MD5Util.md5Encode(password));
    }

    @PostMapping(value = "/login/{username}/{password}")
    Result login(@PathVariable("username")String username,@PathVariable("password")String password){
        return userService.login(username, MD5Util.md5Encode(password));
    }

    @PostMapping(value = "/findByName/{username}")
    Result findByName(@PathVariable("username") String username){
        return userService.findByName(username);
    }

}
