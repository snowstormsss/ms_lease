package com.snowstorms.ms_lease_core.controller;

import domain.User;
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
}
