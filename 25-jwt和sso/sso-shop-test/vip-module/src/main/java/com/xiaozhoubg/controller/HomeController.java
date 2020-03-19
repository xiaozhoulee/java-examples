package com.xiaozhoubg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    RestTemplate restTemplate;


    @GetMapping("/")
    //拿到CookieValue
    public String home(@CookieValue(value = "user-token",required = false) Cookie cookie, Model model){
//        获取cookie值
        String token =cookie.getValue();
        //去登录模块取出用户数据
        String url = "http://passport.testshop.com:9000/user/info?token={token}";
       Map user = this.restTemplate.getForObject(url,Map.class,token);
        model.addAttribute("username",user.get("name"));
        return "index";
    }
}
