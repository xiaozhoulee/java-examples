package com.xiaozhoubg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class DeptProvider_8002 {

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_8002.class,args);
    }

}
