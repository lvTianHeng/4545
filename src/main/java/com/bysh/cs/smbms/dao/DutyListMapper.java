package com.bysh.cs.smbms.dao;

import com.bysh.cs.smbms.pojo.DutyList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DutyListMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DutyList record);

    DutyList selectByPrimaryKey(Long id);

    List<DutyList> selectAll();

    int updateByPrimaryKey(DutyList record);

    //根据月份和名称查询排班
    DutyList selectByDateAndName(@Param("date") String date, @Param("name") String name);


    /**
     * 删除排班需要删除排班月份记录和当前排班月份下面的所有排班表
     * @param date 日期
     * @return
     */
    int deleteScheduling(String date);
}