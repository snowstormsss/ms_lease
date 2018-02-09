package com.snowstorms.ms_lease_core.dao;

import domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author  xieyucheng
 * @create  2018/2/8 17:09
 **/
@Mapper
public interface UserDao {
    int login(User user);   //用户登录

    int register(User user);    //用户注册

    int exist(User user); //验证用户是否存在

    User findByName(@Param("username") String username); //根据用户名取出用户
}
