package com.xiaozhoubg;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class SpringbootAsynApplicationTests {
    @Autowired
    JavaMailSenderImpl mailSender;
    @Test
    void contextLoads() {
        SimpleMailMessage message =  new SimpleMailMessage();
        message.setSubject("你好！");//设置主题
        message.setText("这里是详细内容");//设置内容
        message.setTo("xxx@qq.com");
        message.setFrom("xxx@qq.com");
        mailSender.send(message);

    }

    @Test
    void contextLoads2() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //mimeMessage true支持多文件
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        //标题
        helper.setSubject("你好！！！！");
        //内容开启html
        helper.setText("<a style='color:green' href='http://www.xiaozhoubg.com'>点我！点我！</a>",true);
        //发送文件
        helper.addAttachment("测试1.txt",new File("C:\\Users\\Administrator\\Desktop\\测试1.txt"));
        helper.addAttachment("测试2.txt",new File("C:\\Users\\Administrator\\Desktop\\测试1.txt"));
        //发送给谁
        helper.setTo("xxx@qq.com");
        //从哪里发送
        helper.setFrom("xxx@qq.com");
        mailSender.send(mimeMessage);
    }



}
