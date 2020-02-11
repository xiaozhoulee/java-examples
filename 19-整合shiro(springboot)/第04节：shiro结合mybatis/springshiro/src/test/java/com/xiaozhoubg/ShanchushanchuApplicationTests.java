package com.xiaozhoubg;

import com.xiaozhoubg.pojo.User;
import com.xiaozhoubg.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShanchushanchuApplicationTests {


    @Autowired
    UserServiceImpl userService;
    @Test
    public void contextLoads(){
        User hhh = userService.getUserByName("hhh");
        System.out.println(hhh);
    }

}
