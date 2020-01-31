package com.xiaozhoubg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Map;

import static java.util.Arrays.asList;

@Controller
public class thymeleaf {

    @RequestMapping("testThymeleaf")
    public String testThymeleaf(Model model){
        model.addAttribute("msg","testThymeleaf");
        return "testThymeleaf";
    }

    @RequestMapping("testThymeleaf2")
    public String testThymeleaf2(Model model){
//        存入数据
        model.addAttribute("msg","<h1>testThymeleaf2</h1>");
//        Arrays.asList可以将数组转为集合
        model.addAttribute("users",Arrays.asList("xiaozhou","baogao"));

        return "testThymeleaf2";
    }
}
