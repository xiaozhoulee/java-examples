package com.xiaozhoubg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class eureka_7003 {
    public static void main(String[] args) {
        SpringApplication.run(eureka_7003.class,args);
    }
}
