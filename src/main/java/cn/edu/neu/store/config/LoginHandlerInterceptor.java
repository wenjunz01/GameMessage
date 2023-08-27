package cn.edu.neu.store.config;

import cn.edu.neu.store.core.Constants;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录后有session
        Object loginUser =  request.getSession().getAttribute(Constants.LOGIN_USER);
        if (loginUser == null){
            request.setAttribute("msg","请先登录");
            request.getRequestDispatcher("/login.html").forward(request,response);
            return false;
        }else {
            return true;}
    }
}

