package com.xiaozhoubg.controller;

import com.xiaozhoubg.pojo.Department;
import com.xiaozhoubg.pojo.Employee;
import com.xiaozhoubg.pojo.mapper.DepartmentMapper;
import com.xiaozhoubg.pojo.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

//用来做测试的controller
//用来做测试的controller
//用来做测试的controller
//用来做测试的controller
@RestController
public class testController {

    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/a")
    public String selectEmployee(){
        Employee employeeById = employeeMapper.getEmployeeById(1);
        System.out.println(employeeById);
        return "ok";
    }
}