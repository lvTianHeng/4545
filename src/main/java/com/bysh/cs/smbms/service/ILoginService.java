package com.bysh.cs.smbms.service;

import javax.servlet.http.HttpServletRequest;

public interface ILoginService {

    /**
     * 登录方法
     *
     * @param userCode   用户名
     * @param password 密码
     * @param request
     * @return 是否登录成功
     */
    boolean login(String userCode, String password, HttpServletRequest request);

}
