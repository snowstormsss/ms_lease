package com.snowstorms.ms_lease_core.service;

import com.snowstorms.ms_lease_core.dao.UserDao;
import domain.User;
import dto.Result;
import dto.UserDTO;
import org.hibernate.id.GUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import util.JWTUtil;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public Result login(User user){
        int res=userDao.login(user);
        if(res==1){
            Map<String,Object> resMap=new LinkedHashMap<>();
            UserDTO userDTO=new UserDTO();
            userDTO.setUsername(user.getUsername());
            userDTO.setPassword(user.getPassword());
            resMap.put("token", JWTUtil.sign(userDTO,24L * 3600L * 1000L)); //1天有效期
            return Result.ok(resMap); //返回验证token
        }
        else return Result.error(HttpStatus.BAD_REQUEST.value(),"登陆失败,账号或密码错误!");
    }

    public Result register(User user){   //用户注册
        int res=userDao.exist(user);  //先判断是否存在
        if(res==1){
            return Result.error("用户名已经存在!");
        }
        else{
            res=userDao.register(user);
            if(res==1){
                return Result.ok("注册成功!");
            }
            else{
                return Result.error("注册失败!");
            }
        }
    }

    public Result exist(User user){  //判断用户是否存在
        int res=userDao.login(user);
        if(res==1){
            return Result.error("用户已经存在!");
        }
        else{
            return Result.ok();
        }
    }


}
