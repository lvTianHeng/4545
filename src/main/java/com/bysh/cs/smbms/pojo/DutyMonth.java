package com.bysh.cs.smbms.pojo;

import java.util.Date;

public class DutyMonth {
    private Long id;

    private Date createtime;

    private Date updatetime;

    private String yearmonth;

    private Integer daynum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getYearmonth() {
        return yearmonth;
    }

    public void setYearmonth(String yearmonth) {
        this.yearmonth = yearmonth == null ? null : yearmonth.trim();
    }

    public Integer getDaynum() {
        return daynum;
    }

    public void setDaynum(Integer daynum) {
        this.daynum = daynum;
    }
}