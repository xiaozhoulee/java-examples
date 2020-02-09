package com.xiaozhoubg.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.xiaozhoubg.dao.DepartmentDao;
import com.xiaozhoubg.dao.EmployeeDao;
import com.xiaozhoubg.pojo.Department;
import com.xiaozhoubg.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工，返回列表页面
    @GetMapping("emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    //添加员工

    @GetMapping("/emp")
    public String toAddpage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){
//        把它输出到控制台，方便我们看，使用感叹号是为了能让我们快速找到信息的位置
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(employee);

//        保存员工信息
        employeeDao.save(employee);
        //回到员工列表页面，可以使用redirect或者forward
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id") Integer id,Model model){
//        根据id查员工
        Employee employee = employeeDao.get(id);
        //将员工信息返回页面
        model.addAttribute("emp",employee);
        //查出所有部门，提供修改选择
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/update";
    }

    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
//        把它输出到控制台，方便我们看，使用感叹号是为了能让我们快速找到信息的位置
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(employee);

//        保存员工信息
        employeeDao.save(employee);
        //回到员工列表页面，可以使用redirect或者forward
        return "redirect:/emps";
    }

    @GetMapping("/delEmp/{id}")
    public String delEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";

    }
}
