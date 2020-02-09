package com.xiaozhoubg.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        if (user == null){//未登录，返回登陆页面
            request.setAttribute("msg","请先登录！");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else {
            //登录，放行
            return true;
        }
    }

}
