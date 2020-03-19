package com.xiaozhoubg.interceptor;

import com.xiaozhoubg.utils.JwtUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//咱搞一个拦截器，让每一次请求之前都拿到token，然后刷新token，再响应给请求头

@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器执行！~！！！！");
        String token = request.getHeader("token");
            String refresh = JwtUtils.refresh(token);
            response.addHeader("Access-Control-Expose-Headers","token");
            response.addHeader("token", refresh);
            return true;
        }
    }


