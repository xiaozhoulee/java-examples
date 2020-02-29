package com.xiaozhoubg.controller;

import com.xiaozhoubg.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "测试controller")
@RestController
public class testSwagger {

    @GetMapping("/gettest")
    public String gettest(){
        return "get方法测试success";
    }

    @PostMapping("/posttest")
    public String posttest(@ApiParam("接收用户名") String username){
        return "post方法测试success";
    }

    @DeleteMapping("/deletettest")
    public String deletettest(){
        return "delete方法测试success";
    }


    @ApiOperation("Post测试类")
    @PostMapping(value = "/postt")
    public User postt(User user){

        return user;
    }
}
