package com.xiaozhoubg.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//部门class
//可以使用lombok快速生成方法。但是Employee中有参构造需要自己写，因为Date类型需要自己编写
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Integer id;
    private  String departmentName;
}

