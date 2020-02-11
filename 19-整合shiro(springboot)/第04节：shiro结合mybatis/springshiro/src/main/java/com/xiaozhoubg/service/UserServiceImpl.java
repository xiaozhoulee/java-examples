package com.xiaozhoubg.service;

import com.xiaozhoubg.mapper.UserMapper;
import com.xiaozhoubg.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }
}
