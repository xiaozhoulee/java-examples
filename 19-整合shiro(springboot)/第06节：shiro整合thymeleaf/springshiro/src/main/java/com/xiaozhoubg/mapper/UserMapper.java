package com.xiaozhoubg.mapper;

import com.xiaozhoubg.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface UserMapper {
//   根据name查询表
    User getUserByName(String name);
}
