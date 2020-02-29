package com.xiaozhoubg.controller;

import com.xiaozhoubg.service.AsynService;
import com.xiaozhoubg.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.util.Arrays;

@RestController
public class AsynController {
    @Autowired
    AsynService asynService;

    @Autowired
    EmailService email;

    @GetMapping("/hello")
    public String hello(){

        asynService.hello();

    return "ok";
    }

    @GetMapping("/email")
    public String send() throws MessagingException {
        email.sendemail(
                true,
                "早上好",
                "好好学习把",
                "测试.txt",
                "C:\\Users\\Administrator\\Desktop\\测试1.txt",
                "xxx@qq.com",
                "xxx@qq.com"
        );
        return "发送完毕";
    }


}
