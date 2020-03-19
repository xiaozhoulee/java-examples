package com.xiaozhoubg.mapper;

import com.xiaozhoubg.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//在springboot中声明@Mapper注解，程序会自动扫描识别为mybatis接口类
@Mapper
//@Repository注解让这个接口装配一下，否则回忽略这个接口类
@Repository
public interface UserMapper {

    //    查询全部用户
    List<User> selectUser();
    User selectUserByName(String name);
    //    根据id选择用户
    User selectUserById(int id);

    //    添加一个用户
    int addUser(User user);

    //    修改用户
    int updateUser(User user);

    //    根据id删除用户
    int deleteUser(int id);

}
