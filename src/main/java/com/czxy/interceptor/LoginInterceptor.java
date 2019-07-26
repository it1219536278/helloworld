package com.czxy.interceptor;

import com.czxy.domain.Log;
import com.czxy.domain.User;
import com.czxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String servletPath = request.getServletPath();
        if (servletPath.startsWith("/js") || servletPath.startsWith("/css") || servletPath.startsWith("/fonts") || servletPath.startsWith("/images") || servletPath.contains("login") || servletPath.contains("index.html")){
            return  true;
        }
        User user = (User) request.getSession().getAttribute("user");
        if (user==null){
            response.sendRedirect("/index.html");
            return false;
        }
        if (servletPath.equals("/user/add") || servletPath.equals("/user/del") || servletPath.equals("/user/update")){
          String name=  servletPath.split("user/")[1];
            Log log = new Log(null, user.getId(), user.getUsername(), name, new Date());
            userService.addLog(log);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
