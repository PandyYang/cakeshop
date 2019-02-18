package com.xzy.service;

import com.xzy.pojo.Users;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @Author: Pandy
 * @Date: 2019/2/15 19:52
 * @Version 1.0
 */
public interface UserService {
   //登录
   Users login(@Param("username")String username,@Param("password") String password);
    //注册
    public void addUsers(@Param("username")String username,
                        @Param("password")String password,
                        @Param("sex")String sex,
                        @Param("age")int age,
                        @Param("signd")String signd,
                        @Param("photo")String photo,
                        @Param("telephone")String telephone,
                        @Param("email")String email
    );
    //根据用户名查询用户
    Users findUserByUsername(@Param("username") String username);
    //脱敏展示用户
    Users display(@Param("id") Long id);
    //修改用户信息
    String edit(@Param("username")String username,
                @Param("password")String password,
                @Param("sex")String sex,
                @Param("age")int age,
                @Param("signd")String signd,
                @Param("photo")String photo,
                @Param("telephone")String telephone,
                @Param("email")String email
                );
}
