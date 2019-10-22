package com.xiaozhoukj.cs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CookieDemo01")
public class CookieDemo01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建cookie
        Cookie cookie1 = new Cookie("username","monkey1024");
        Cookie cookie2 = new Cookie("password","123456");

        //手动设置绑定路径
        cookie1.setPath(request.getContextPath() + "/aaa");
        cookie2.setPath(request.getContextPath() + "/aaa");

        //设置cookie的失效时间
        cookie1.setMaxAge(60 * 60);//一小时
        cookie2.setMaxAge(60 * 60 * 24);//一天

        //将Cookie添加到相应中
        response.addCookie(cookie1);
        response.addCookie(cookie2);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
