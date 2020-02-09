package com.xiaozhoubg.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class helloshiro {
    @RequestMapping({"/","index"})
    public String hello(Model model){

        model.addAttribute("msg","hello shiro");

        return "index";
    }


    @RequestMapping("user/add")
    public String add(Model model){


        return "user/adduser";
    }



    @RequestMapping("user/update")
    public String update(Model model){


        return "user/updateuser";
    }

    @GetMapping("user/login")
    public String touserlogin(){

        return "user/login";
    }
    @PostMapping("user/login")

//    因为我们需要传值和接收表单的属性，所以 首先这里引入Model 和username，password。
    public String userlogin(Model model, String username,String password){
//        SecurityUtils 是shiro封装完成的方法 用于获取Subject
        Subject subject = SecurityUtils.getSubject();
        System.out.println(subject);
//       UsernamePasswordToken 用于 封装用户登录数据到token
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        System.out.println(subject);

/*
接下来创建一个异常判断
登录成功return到首页，并且在浏览器中创建cookie，
登录失败则return回登录页，并且告诉用户，XXX错误。
*/

        try {
//        执行登录的方法，如果没有异常就ok。
            subject.login(token);
            System.out.println("giaogsdadas");
            return "index";

        } catch (UnknownAccountException e) {//用户名不存在 UnknownAccountException是shiro内置的异常
            model.addAttribute("msg","用户名不存在");
            return "user/login";
        } catch (IncorrectCredentialsException e){//密码错误 IncorrectCredentialsException是shiro内置的异常
            model.addAttribute("msg","密码错误");
            return "user/login";

        } catch (AuthenticationException  e){//密码不存在 AuthenticationException是shiro内置的异常
            model.addAttribute("msg","密码不存在");
            return "user/login";

        }

    }

}
