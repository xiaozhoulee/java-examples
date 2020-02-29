package com.xiaozhoubg;

import com.xiaozhoubg.service.Userservice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Zook2ApplicationTests {

    @Autowired
    Userservice userservice;
    @Test
    void contextLoads() {
        userservice.buyTicket();
        
    }

}
