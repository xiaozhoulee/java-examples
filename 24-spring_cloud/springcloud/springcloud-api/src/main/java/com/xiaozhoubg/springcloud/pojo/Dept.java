package com.xiaozhoubg.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)//开启链式写法
public class Dept implements Serializable { //实体类，与数据库表关系映射，这个大家都知道
    private Long deptno;
    private String dname;

    //这个数据存储在哪个数据库？
    //有可能一个服务对应一个数据库，同一个信息也可能存在不同的数据库
    private String db_source;

}
