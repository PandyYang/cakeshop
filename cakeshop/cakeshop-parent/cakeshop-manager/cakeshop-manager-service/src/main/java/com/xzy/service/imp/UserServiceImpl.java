package com.xzy.service.imp;

import com.xzy.mapper.UsersMapper;
import com.xzy.pojo.Users;
import com.xzy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Author: Pandy
 * @Date: 2019/2/15 19:54
 * @Version 1.0
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;


    @Override
    public Users login(String username, String password) {
        return usersMapper.findByUsernameAndPwd(username,password);
    }


    @Override
    public void addUsers(String username, String password, String sex, int age, String signd,
                        String photo, String telephone, String email) {
        Users u = usersMapper.findUserByUsername(username);
        if (u == null) {
            usersMapper.addUsers(username, password, sex, age,
                    signd, photo, telephone, email);
        }

    }


    @Override
    public Users findUserByUsername(String username) {
        return usersMapper.findUserByUsername(username);
    }

    @Override
    public Users display(Long id) {
        return usersMapper.display(id);
    }

    @Override
    public String edit(String username, String password, String sex, int age, String signd, String photo,
                       String telephone, String email) {
        return usersMapper.edit(username,password,sex,age,signd,photo,telephone,email);
    }
}
