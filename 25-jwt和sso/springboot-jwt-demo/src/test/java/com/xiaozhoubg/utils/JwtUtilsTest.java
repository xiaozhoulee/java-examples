package com.xiaozhoubg.utils;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
//工具包ok后，第二步进行测试

class JwtUtilsTest {

    @Test
   public void newToken() throws InterruptedException {
        String token = JwtUtils.newToken(10L, 10);
        System.out.println(token);


//        来测试 上面我们设置了token时长10秒
//        接下来咱们睡眠12秒再取，也就是说token过期了咱再取.发现方法抛出了异常
        Thread.sleep(12000);

        Long id = JwtUtils.getId(token);
        System.out.println(id);
    }

    @Test
    public void testRefresh() throws InterruptedException {
        String token = JwtUtils.newToken(100L,10);
        System.out.println("原来的token"+token);
        while (true){
             token = JwtUtils.refresh(token);
            System.out.println("现在的token"+token);
            Thread.sleep(1500);
        }

    }

    @Test
    void testNewToken() {
    }
}