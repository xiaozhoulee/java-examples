package com.xiaozhoubg;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringDemoDataApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
//        所使用的数据源↓
        System.out.println(dataSource.getClass());

        Connection connection = dataSource.getConnection();

//        查看链接↓
        System.out.println(connection);

//        关闭资源
        connection.close();
    }

}
