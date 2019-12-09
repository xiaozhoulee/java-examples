package com.xiaozhoubg.controller;

import com.xiaozhoubg.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/param")
public class paramtest {

@RequestMapping("/test")
    public String test(String username ,String password){
    System.out.println("用户名" + username);
    System.out.println("密码" +password);
        return "success";
}
@RequestMapping("/saveAccount")
public String saveAccount(Account account){
    System.out.println("账户" + account);
    System.out.println("用户名" + account.getUser().getUuname());

    return "success";
}


}
