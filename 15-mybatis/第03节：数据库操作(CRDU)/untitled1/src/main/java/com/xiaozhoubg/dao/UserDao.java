package com.xiaozhoubg.dao;

import com.xiaozhoubg.pojo.User;
import java.util.List;

public interface UserDao {

    List<User> getUserList();

//    根据ID查询用户
    User getUserById(int id);

//    增加用户
    int addUser(User user);

//    根据id修改用户
    int updateUser(User user);

//    根据id删除用户
    int delUser (int id);
}


