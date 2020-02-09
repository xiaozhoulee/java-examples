package com.xiaozhoubg.pojo.mapper;

import com.xiaozhoubg.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DepartmentMapper {

//    查询全部部门
    List<Department> selectDepartment();

//    根据根据id查询部门
//    Department selectDepartmentByid(int id);

//    添加部门
        int addDepartment(Department department);
//    删除部门
    int delDepartment(int id);
}
