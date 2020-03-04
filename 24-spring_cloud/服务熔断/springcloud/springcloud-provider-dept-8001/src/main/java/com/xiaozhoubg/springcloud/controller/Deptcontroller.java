package com.xiaozhoubg.springcloud.controller;

import com.xiaozhoubg.springcloud.pojo.Dept;
import com.xiaozhoubg.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//restful服务
@RestController
public class Deptcontroller {
    @Autowired
    private DeptService deptService;

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept querybyid(@PathVariable("id") Long id){

        return deptService.queryById(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> queryAll(){
        List<Dept> depts = deptService.queryAll();
        return depts;
    }



}
