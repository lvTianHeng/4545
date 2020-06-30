package com.bysh.cs.smbms.controller;

import com.bysh.cs.smbms.service.ILoginService;
import com.bysh.cs.smbms.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


@Controller
public class LoginController {

    @Autowired
    private ILoginService loginService;


    /**
     * 跳转到登录页面
     *
     * @return 登录页面名称
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }



    /**
     * 登录
     *
     * @param userCode     用户名
     * @param userPassword 密码
     * @return 成功或者失败页面
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String userCode, String userPassword, Model model, HttpServletRequest request) {
        // 调用登录操作
        boolean isLogin = loginService.login(userCode, userPassword, request);
        // 如果登录成功
        if (isLogin) {
            return "redirect:/welcome";
        } else {
           model.addAttribute("error", "登录失败，请重新登录");
           return "login";
        }
    }

    /**
     * 欢迎页面
     *
     * @return
     */
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome() {
        // 跳转到欢迎页面
        return "frame";
    }

    /**
     * 退出
     *
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        // 删除session中的数据
        request.getSession().removeAttribute(Constant.USER_INFO);
        // session 失效
        request.getSession().invalidate();
        //退出跳转到登录页面
        return "login";
    }

}

