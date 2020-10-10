package com.interceptor;

import com.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:
 * @Author: Yong
 * @CreateDate: 2020/9/26 13:11
 */
public class LoginInterceptor implements HandlerInterceptor {
    //在控制器的请求方法之前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User loginUser =(User) request.getSession().getAttribute("loginUser");
        System.out.println(loginUser);
        String requestURI = request.getRequestURI();
        String remoteAddr = request.getRemoteAddr();
        System.out.println("remoteAddr=" + remoteAddr);
        StringBuffer requestURL = request.getRequestURL();
        System.out.println("url:" + requestURL);
        if("/HRM/login".equals(requestURI)){
            return true;
        }
        if(loginUser == null){
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
            return false;
        }else {
            return true;
        }
    }
}
