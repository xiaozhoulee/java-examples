package com.xiaozhoubg.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.xiaozhoubg.pojo.Department;
import com.xiaozhoubg.pojo.Employee;
import com.xiaozhoubg.pojo.mapper.DepartmentMapper;
import com.xiaozhoubg.pojo.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    DepartmentMapper departmentMapper;

    //查询所有员工，返回列表页面
    @GetMapping("/emps")
    public String list(Model model){
        List<Employee> employees = employeeMapper.selectEmployee();

        model.addAttribute("emps",employees);
        return "emp/list";
    }

    //添加员工

    @GetMapping("/emp")
    public String toAddpage(Model model){

//        查到部门，model需要提供department部门选项
        List<Department> departments = departmentMapper.selectDepartment();
        model.addAttribute("departments",departments);
//        System.out.println(departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){
//        把它输出到控制台，方便我们看，使用感叹号是为了能让我们快速找到信息的位置
//        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//        System.out.println(employee);

//        保存员工信息
       employeeMapper.addEmployee(employee);
        //回到员工列表页面，可以使用redirect或者forward
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id") Integer id,Model model){
//        根据id查员工
        Employee employees = employeeMapper.getEmployeeById(id);
        //将员工信息返回页面
        System.out.println(employees);
        model.addAttribute("emp",employees);
        //查出所有部门，提供修改选择
        List<Department> departments = departmentMapper.selectDepartment();
        model.addAttribute("departments",departments);
        return "emp/update";
    }

    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
//        把它输出到控制台，方便我们看，使用感叹号是为了能让我们快速找到信息的位置
//        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//        System.out.println(employee);

//        保存员工信息
        employeeMapper.updateEmployee(employee);
        //回到员工列表页面，可以使用redirect或者forward
        return "redirect:/emps";
    }

    @GetMapping("/delEmp/{id}")
    public String delEmp(@PathVariable("id") Integer id){
        employeeMapper.deleteEmployee(id);
        return "redirect:/emps";

    }
}
