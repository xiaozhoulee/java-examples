package com.xiaozhoubg.pojo.mapper;

import com.xiaozhoubg.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmployeeMapper {

    //    查询全部员工
    List<Employee> selectEmployee();

    //根据id查询员工
    Employee getEmployeeById(int id);

    //    添加
    int addEmployee(Employee employee);

    //    根据id修改
    int updateEmployee(Employee employee);

    //    根据id删除
    int deleteEmployee(int id);
}
