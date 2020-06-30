package com.bysh.cs.smbms.service.impl;


import com.bysh.cs.smbms.dao.SysUserMapper;
import com.bysh.cs.smbms.pojo.SysUser;
import com.bysh.cs.smbms.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;


@Service
public class SysUserServiceImpl implements ISysUserService {


    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> findAll() {
        return sysUserMapper.selectAll();
    }

    @Override
    public List<SysUser> find(String queryname, String tel) {
        return sysUserMapper.selectByNameAndTel(queryname,tel);
    }

    @Override
    public String delete(Long uid) {
        SysUser user = sysUserMapper.selectByPrimaryKey(uid);
        if (user != null) {
            // 调用dao层删除方法，并返回删除结果
            int result = sysUserMapper.deleteByPrimaryKey(uid);
            return result > 0 ? "true" : "false";
        } else {
            // 用户不存在
            return "notexist";
        }
    }

    @Override
    public String checkUser(String username) {
        // 调用dao层接口方法，根据用户名查询结果
        SysUser user = sysUserMapper.selectByUsername(username);
        // 判断user是否存在
        return user != null ? "exist" : "noexist";
    }

    @Override
    public void save(SysUser user, HttpServletRequest request) {
            // 设置创建的时间
            user.setCreatetime(new Date());
            // 设置修改的时间
            user.setUpdatetime(new Date());
            // 调用保存方法
            user.setUserrole(user.getUserrole() == null ? 0: user.getUserrole());
            sysUserMapper.insert(user);
        }


    @Override
    public void update(Long uid, SysUser user, HttpServletRequest request) {
        SysUser user1 = sysUserMapper.selectByPrimaryKey(uid);
        user1.setUpdatetime(new Date());
        user1.setLoginname(user.getLoginname());
        user1.setUsername(user.getUsername());
        user1.setJob(user.getJob());
        user1.setTel(user.getTel());
        user1.setUpdatetime(new Date());

        //调用sysuserMapper的更新方法
        sysUserMapper.updateByPrimaryKey(user1);
    }

    @Override
    public SysUser findById(Long uid) {
        return sysUserMapper.selectByPrimaryKey(uid);
    }
}
