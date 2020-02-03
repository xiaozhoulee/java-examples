package com.xiaozhoubg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//要求为WebMvcConfigurer类型，所以需要引入这个接口
@Configuration
//@EnableWebMvc
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器地址/mvctest 就会跳转到testMvc页面
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
    }
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
