package com.xiaozhoubg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.constraints.Null;
import java.io.File;

@Service
public class EmailService {
    @Autowired
    JavaMailSenderImpl mailSender;

    /**
     *
     * @param html
     * @param subject
     * @param text
     * @param name
     * @param file
     * @param to
     * @param from
     * @throws MessagingException
     * @Author wanghao
     */
    public void sendemail(Boolean html,String subject,String text,String name,String file,String to,String from) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //mimeMessage true支持多文件
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,html);
        //标题
        helper.setSubject(subject);
        //内容开启html
        helper.setText(text,true);
        //发送文件
        helper.addAttachment(name,new File(file));
//        "C:\\Users\\Administrator\\Desktop\\测试1.txt"
        helper.addAttachment(name,new File(file));
        //发送给谁
        helper.setTo(to);
        //从哪里发送
        helper.setFrom(from);
        mailSender.send(mimeMessage);

    }

}
