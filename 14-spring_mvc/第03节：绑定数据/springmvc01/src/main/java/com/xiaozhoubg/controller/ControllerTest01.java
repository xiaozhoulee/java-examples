package com.xiaozhoubg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//控制器类
@Controller
public class ControllerTest01 {
    @RequestMapping(path = "/hello")
    public String test01(){
        System.out.println("hello");
        return "success";
    }
}
