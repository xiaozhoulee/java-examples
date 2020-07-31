package com.example.websocket.websocketdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebsocketdemoApplicationTests {

	@Autowired
	RedisTemplate redisTemplate;

	@Test
	public void contextLoads() {
		redisTemplate.opsForValue().set("mykey","晓舟报告");//操作字符串
		System.out.println(redisTemplate.opsForValue().get("mykey"));
		redisTemplate.opsForList();//操作集合
	}

}
