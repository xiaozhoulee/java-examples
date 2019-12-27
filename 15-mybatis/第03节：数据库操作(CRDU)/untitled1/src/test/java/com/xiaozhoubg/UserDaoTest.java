package com.xiaozhoubg;

import com.xiaozhoubg.dao.UserDao;
import com.xiaozhoubg.pojo.User;
import com.xiaozhoubg.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void test(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //执行SQL
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void getUserById(){
        //获得SqlSession对象和mapper
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        //要查询的ID
        User user = mapper.getUserById(3);
        System.out.println(user);

        //关闭SqlSession
        sqlSession.close();
    }
        @Test
        public void addUser(){
            SqlSession sqlSession = MyBatisUtils.getSqlSession();
            UserDao mapper = sqlSession.getMapper(UserDao.class);

            mapper.addUser(new User(8, "沈剑心", "fff"));

            //提交请求方法
            sqlSession.commit();
            sqlSession.close();
        }

        @Test
        public void updataUser(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        mapper.updateUser(new User(8,"哈哈","666"));

        sqlSession.commit();
        sqlSession.close();
        }

        @Test
        public void delUser(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        mapper.delUser(8);

        sqlSession.commit();
        sqlSession.close();
        }
}
