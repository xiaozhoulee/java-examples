package com.xiaozhoubg.service;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class Userservice {
    //我们会去拿注册中心的服务
    @Reference
    TicketService ticketService;
    public void buyTicket(){
        String ticket = ticketService.getTicket();
        System.out.println("在注册中心买到"+ticket);
    }
}
