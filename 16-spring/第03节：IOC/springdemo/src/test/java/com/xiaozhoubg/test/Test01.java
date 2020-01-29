package com.xiaozhoubg.test;

// Test01

import com.xiaozhoubg.dao.StudentService;
import com.xiaozhoubg.impl.StudentServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

    /**
     * 以前的写法：手动创建对象
     */
    @Test
    public void oldType(){
        StudentService studentService = new StudentServiceImpl();
        studentService.study();
    }

    /**
     * 使用spring之后的写法：直接通过spring获取对象
     */
    @Test
    public void springType() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //从spring中获取对象
        StudentService studentService = (StudentService) context.getBean("studentService");
        studentService.study();
    }
}
