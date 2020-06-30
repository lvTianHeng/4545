package com.bysh.cs.smbms.intercept;

import com.bysh.cs.smbms.utils.Constant;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 *
 * @author szf
 */
public class LoginIntercept extends HandlerInterceptorAdapter {

    /**
     * 在请求开始之前执行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 判断session是否存在
        Object user = request.getSession().getAttribute(Constant.USER_INFO);
        if (user != null){
            return true;
        } else {
//            跳转到首页
            response.sendRedirect("/");
            return false;
        }
    }
}
