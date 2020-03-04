package com.xiaozhoubg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class consumerDept80 {
    public static void main(String[] args) {
        SpringApplication.run(consumerDept80.class,args);

    }
}
