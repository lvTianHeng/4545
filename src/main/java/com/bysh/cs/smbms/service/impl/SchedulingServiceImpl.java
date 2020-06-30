package com.bysh.cs.smbms.service.impl;


import com.bysh.cs.smbms.dao.DutyListMapper;
import com.bysh.cs.smbms.dao.DutyMonthMapper;
import com.bysh.cs.smbms.pojo.DutyList;
import com.bysh.cs.smbms.pojo.SysUser;
import com.bysh.cs.smbms.service.ISchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SchedulingServiceImpl implements ISchedulingService {

    @Autowired
    private DutyListMapper dutyListMapper;
    @Autowired
    private DutyMonthMapper dutyMonthMapper;

    @Override
    public List<DutyList> fandAll() {
        return dutyListMapper.selectAll();
    }

    @Override
    public List<DutyList> findByDateAndName(String  date, String name) {
        return (List<DutyList>) dutyListMapper.selectByDateAndName(date,name);
    }

    /**
     * 新增排班
     * 先从浏览器获取排班的天数 排班的日期 排班的人数
     * 然后打乱人员顺序 随机排班
     * 需要关联到 sysuser表，dutymonth表，和duty_list表
     * 更新排班表的数据，同时更新排班月份中的数据
     * @param date 排班的时间
     * @param users 排班的人员
     */
    @Override
    public void addScheduling(String date, List<SysUser> users) {

    }

    /**
     *删除排班
     * 先查詢有无排班，再删除
     * @param date 当前排班的月份
     */
    @Override
    public String deleteScheduling(String date) {
        List<DutyList> dutyLists = (List<DutyList>) dutyListMapper.selectByDateAndName(date,null);
        if (dutyLists != null){
            //删除排班表的数据
            int ru1 = dutyListMapper.deleteScheduling(date);
            //删除排班月份的数据
            int ru2 = dutyMonthMapper.deleteByDutyMonth(date);
            return (ru1>0 && ru2>0) ? "true":"false";
        }else {
            return "notfind";
        }

    }
}
