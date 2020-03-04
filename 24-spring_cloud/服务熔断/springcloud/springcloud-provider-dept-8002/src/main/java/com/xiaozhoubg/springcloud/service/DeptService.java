package com.xiaozhoubg.springcloud.service;

import com.xiaozhoubg.springcloud.pojo.Dept;

import java.util.List;

public interface DeptService {
    boolean addDept(Dept dept);

    Dept queryById(Long id);

    List<Dept> queryAll();
}
