package com.bysh.cs.smbms.dao;

import com.bysh.cs.smbms.pojo.DutyMonth;

import java.util.List;

public interface DutyMonthMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DutyMonth record);

    DutyMonth selectByPrimaryKey(Long id);

    List<DutyMonth> selectAll();

    int updateByPrimaryKey(DutyMonth record);

    int deleteByDutyMonth(String date);
}