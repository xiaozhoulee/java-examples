package com.example.websocket.websocketdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DsApplication {
	public static void main(String[] args) {
		SpringApplication.run(DsApplication.class, args);
	}
}
