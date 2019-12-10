package com.xiaozhoubg.controller;

import com.xiaozhoubg.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class controllerTest {
    @RequestMapping("/testString")
    public String test( Model model){
        System.out.println("testString执行了....");
        //模拟从数据库中查询出User对象,
        //注意：这里只是模拟一下数据，跟数据库没有关系
        User user = new User();
        user.setUsername("小舟");
        user.setPassword("123");
        user.setAge(30);
        model.addAttribute("user",user);

        return "Result";
    }

    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){

        user.setAge(30);
        System.out.println(user);
        return user;
    }
}
