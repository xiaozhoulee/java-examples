package com.xiaozhoubg.service;

import com.xiaozhoubg.pojo.User;

//service层重写接口
public interface UserService {
   User getUserByName(String name);
}
