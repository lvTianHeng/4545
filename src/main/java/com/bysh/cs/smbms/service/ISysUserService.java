package com.bysh.cs.smbms.service;



import com.bysh.cs.smbms.pojo.SysUser;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ISysUserService {
    /**
     * 查询所有
     *
     * @return
     */
    List<SysUser> findAll();

    /**
     * 根据姓名和电话号码搜索
     *
     * @param queryname     用户名
     * @param tel 角色ID
     * @return
     */
    List<SysUser> find(String queryname, String tel);

    /**
     * 根据ID删除用户，返回结果状态
     *
     * @param uid 用户ID
     * @return
     */
    String delete(Long uid);



    /**
     * 根据用户名判断用户是否存在
     *
     * @param userCode 用户名
     * @return
     */
    String checkUser(String userCode);

    /**
     * 保存用户
     *
     * @param user    需要保存用户的信息
     * @param request
     */
    void save(SysUser user, HttpServletRequest request);

    /**
     * 更新用户
     *
     * @param uid
     * @param user    需要更新到用户
     * @param request
     */
    void update(Long uid, SysUser user, HttpServletRequest request);

    /**
     * 根据id查询
     * @param uid
     * @return
     */
    SysUser findById(Long uid);
}
