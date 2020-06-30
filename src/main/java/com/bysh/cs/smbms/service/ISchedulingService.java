package com.bysh.cs.smbms.service;



import com.bysh.cs.smbms.pojo.DutyList;
import com.bysh.cs.smbms.pojo.SysUser;

import java.util.List;

public interface ISchedulingService {

    //首次访问，月份查询条件为空的时候默认显示当月排班表
    List<DutyList>  fandAll();

    /**
     * /根据用户名和日期查询排班
     * @param date 排班日期
     * @param name  用户名
     * @return
     */
    List<DutyList> findByDateAndName(String date, String name);

    /**
     * 新增排班（排班人数要和当月排班天数相等）
     * @param date 排班的时间
     * @param users 排班的人员
     */
    void addScheduling(String date, List<SysUser> users);


    /**
     * 删除排班
     * 需要删除排班月份记录和当前排班月份下面的所有排班表
     * @param date 当前排班的月份
     */

    String deleteScheduling(String date);


}
