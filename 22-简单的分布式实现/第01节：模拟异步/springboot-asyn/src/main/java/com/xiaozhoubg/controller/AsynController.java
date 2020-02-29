package com.xiaozhoubg.controller;

import com.xiaozhoubg.service.AsynService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsynController {
    @Autowired
    AsynService asynService;


    @GetMapping("/hello")
    public String hello(){

        asynService.hello();

    return "ok";
    }


}
