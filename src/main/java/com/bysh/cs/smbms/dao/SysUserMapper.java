package com.bysh.cs.smbms.dao;

import com.bysh.cs.smbms.pojo.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    SysUser selectByPrimaryKey(Long id);

    List<SysUser> selectAll();

    int updateByPrimaryKey(SysUser record);

    SysUser selectByLoginName(String loginName);

    //根据姓名和手机号码模糊查询人员列表
    List<SysUser> selectByNameAndTel(@Param("username") String username, @Param("usertel") String  tel);

    SysUser selectByUsername(String  username);
}