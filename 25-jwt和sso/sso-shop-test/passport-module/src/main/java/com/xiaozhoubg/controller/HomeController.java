package com.xiaozhoubg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(String target, HttpSession session){
       if(StringUtils.isEmpty(target)){
           target = "http://www.testshop.com:8080/";
       }
       session.setAttribute("target",target);
        return "index";
    }
}
