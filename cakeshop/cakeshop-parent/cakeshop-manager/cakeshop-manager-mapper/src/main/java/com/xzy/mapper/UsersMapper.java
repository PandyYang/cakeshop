package com.xzy.mapper;

import com.xzy.pojo.Users;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface UsersMapper {
 	//添加用户
	public int addUsers(@Param("username")String username,
						@Param("password")String password,
						@Param("sex")String sex,
						@Param("age")int age,
						@Param("signd")String signd,
						@Param("photo")String photo,
						@Param("telephone")String telephone,
						@Param("email")String email

						);
	//根据用户名查找用户
	 Users findUserByUsername(@Param("username") String username);
	//根据用户名与密码查找用户
	Users findByUsernameAndPwd(@Param("username") String username,@Param("password") String password);
	//展示用户详情
	Users display(@Param("id") Long id);
	//用户信息修改
	public String edit(@Param("username")String username,
						@Param("password")String password,
						@Param("sex")String sex,
						@Param("age")int age,
						@Param("signd")String signd,
						@Param("photo")String photo,
						@Param("telephone")String telephone,
						@Param("email")String email
						);
}
