package com.xiaozhoubg.pojo.mapper;

import com.xiaozhoubg.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

//    查询全部用户
    List<User> selectUser();

//    根据id选择用户
    User selectUserById(int id);

//    添加一个用户
    int addUser(User user);

//    修改用户
    int updateUser(User user);

//    根据id删除用户
    int deleteUser(int id);

}
