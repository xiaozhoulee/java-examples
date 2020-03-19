package com.xiaozhoubg.controller;

import com.xiaozhoubg.interceptor.TokenInterceptor;
import com.xiaozhoubg.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class UserController {


    @PostMapping("/login")
    public Map login(String username,String password){
        if ("admin".equals(username)&&"admin".equals(password)){
            Long id =1001L;
            String token = JwtUtils.newToken(id);
            return Collections.singletonMap("token",token);
        }else {
            return Collections.singletonMap("erro","用户名或者密码错误");
        }
    }

    @GetMapping("/info")
    public Map userInfo(@RequestHeader String token){
        if (1001L == JwtUtils.getId(token)){
            return Collections.singletonMap("user","admin");

        }else {
             return Collections.singletonMap("user","凉了");

        }
    }
}
