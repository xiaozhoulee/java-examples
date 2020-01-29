package com.xiaozhoubg;

import com.xiaozhoubg.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Autowired
    Person person = new Person();

    @Test
    void contextLoads() {
        System.out.println(person);
    }

}
