package com.xiaozhoubg.controller;

import com.xiaozhoubg.pojo.User;
import com.xiaozhoubg.pojo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    //选择全部用户
    @GetMapping("/selectUser")
    public String selectUser(){
        List<User> user = userMapper.selectUser();
        System.out.println(user);
        return "查询全部user";
    }

    @GetMapping("/selectUserById")
    public String selectUserById(){
        User user = userMapper.selectUserById(1);
        System.out.println(user);
        return "根据id查询user:"+user;
    }

    @GetMapping("/addUser")
    public String addUser(){
        int addUser = userMapper.addUser(new User(100, "晓舟", "123456"));
        return "添加了一个user"+ addUser;
    }

    @GetMapping("/updateUser")
    public String updateUser(){
        int updateUser = userMapper.updateUser(new User(100, "晓舟2", "654321"));
        System.out.println(updateUser);
        return "修改了user:" + updateUser;
    }

    @GetMapping("/deleteUser")
    public String deleteUser(){
        int deleteUser = userMapper.deleteUser(999);
        System.out.println(deleteUser);
        return "根据id删除user:"+deleteUser;
    }

}
