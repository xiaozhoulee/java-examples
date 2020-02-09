package com.xiaozhoubg.controller;

import com.xiaozhoubg.pojo.Department;
import com.xiaozhoubg.pojo.Employee;
import com.xiaozhoubg.pojo.mapper.DepartmentMapper;
import com.xiaozhoubg.pojo.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    DepartmentMapper departmentMapper;

    @GetMapping("/dep")
    public String register(Model model){
        List<Department> departments = departmentMapper.selectDepartment();
//        System.out.println(departments);
        model.addAttribute("departments",departments);
        return "dep/dep";
    }

    @GetMapping("/adddep")
    public String toadddep(){

        return "dep/adddep";
    }

    @PostMapping("/adddep")
    public String adddep(Department department){

    departmentMapper.addDepartment(department);

        return "redirect:/dep";
    }

    @GetMapping("/depDel/{id}")
    public String depDel(@PathVariable("id") int id){
        departmentMapper.delDepartment(id);
        List<Employee> employees = employeeMapper.selectEmployee();
//        System.out.println(employees.get(id));
//        for ()

            return "redirect:/dep";

        }
}
