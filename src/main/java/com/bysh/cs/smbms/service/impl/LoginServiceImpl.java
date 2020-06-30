package com.bysh.cs.smbms.service.impl;

import com.bysh.cs.smbms.dao.SysUserMapper;
import com.bysh.cs.smbms.pojo.SysUser;
import com.bysh.cs.smbms.service.ILoginService;
import com.bysh.cs.smbms.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private SysUserMapper userMapper;

    @Override
    public boolean login(String userCode, String password, HttpServletRequest request) {
        //根据userCode调用userMapper中的方法，获得用户
        SysUser user = userMapper.selectByLoginName(userCode);
        // 根据 user 信息，判断用户是否登录成功
        boolean b = user != null && user.getPwd().equals(password);
        // 如果登录成功
        if (b) {
            // 把用户的信息存入session中
            request.getSession().setAttribute(Constant.USER_INFO,user);
        }
        return b;
    }
}
