package com.xiaozhoubg.controller;

import com.xiaozhoubg.mapper.UserMapper;
import com.xiaozhoubg.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class UserController {


//    模拟Redis的方法，该方法在info中调用了
    public static final Map<String,User> redis = new HashMap<>();
    @Autowired
    UserMapper userMapper;

    @RequestMapping("/user/login")
    public String login(String name, String pwd, @SessionAttribute String target, HttpServletResponse response){


        User user = userMapper.selectUserByName(name);
        if (user.getPwd().equals(pwd)){
//            假如A是从vip模块点击登录，这时候B从秒杀模块登录，A先登陆成功，结果却是返回到秒杀模块。所以咱们需要想办法确认用户的唯一身份
//           创建一个UUID加到cookie中
            String token = UUID.randomUUID().toString();
            Cookie cookie = new Cookie("user-token",token);
//            设置cookie生效地址
            cookie.setDomain("testshop.com");
            cookie.setPath("/");
//            通过响应把cookie放到客户端中
            response.addCookie(cookie);
            redis.put(token,user);
            System.out.println(redis);
            return "redirect:"+target;
        }
        return "/liangle";
    }


//    这个方法是返回 模拟redis中Map 的token值
    @GetMapping("/user/info")
    @ResponseBody
    public User getUserInfo(String token){
        return redis.get(token);
    }
}
