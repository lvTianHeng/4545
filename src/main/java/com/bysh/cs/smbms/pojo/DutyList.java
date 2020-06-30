package com.bysh.cs.smbms.pojo;

import java.util.Date;

public class DutyList {
    private Long id;

    private Date createtime;

    private Date updatetime;

    private Long dutyMonthId;

    private Long sysUserId;

    private String dutydate;

    //关联sysuser表
    private SysUser sysUser;

    //关联dutyMonth表
    private DutyMonth dutyMonth;


    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public DutyMonth getDutyMonth() {
        return dutyMonth;
    }

    public void setDutyMonth(DutyMonth dutyMonth) {
        this.dutyMonth = dutyMonth;
    }

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

    public Long getDutyMonthId() {
        return dutyMonthId;
    }

    public void setDutyMonthId(Long dutyMonthId) {
        this.dutyMonthId = dutyMonthId;
    }

    public Long getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Long sysUserId) {
        this.sysUserId = sysUserId;
    }

    public String getDutydate() {
        return dutydate;
    }

    public void setDutydate(String dutydate) {
        this.dutydate = dutydate == null ? null : dutydate.trim();
    }
}