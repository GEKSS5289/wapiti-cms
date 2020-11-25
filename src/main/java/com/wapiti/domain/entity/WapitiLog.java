package com.wapiti.domain.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "wapiti_log")
public class WapitiLog {
    /**
     * 日志id
     */
    @Id
    private Integer id;

    /**
     * 日志内容
     */
    @Column(name = "log_content")
    private String logContent;

    /**
     * 日志用户id
     */
    @Column(name = "admin_id")
    private Integer adminId;

    /**
     * 日志创建时间
     */
    @Column(name = "created_tiem")
    private Date createdTiem;

    /**
     * 获取日志id
     *
     * @return id - 日志id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置日志id
     *
     * @param id 日志id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取日志内容
     *
     * @return log_content - 日志内容
     */
    public String getLogContent() {
        return logContent;
    }

    /**
     * 设置日志内容
     *
     * @param logContent 日志内容
     */
    public void setLogContent(String logContent) {
        this.logContent = logContent;
    }

    /**
     * 获取日志用户id
     *
     * @return admin_id - 日志用户id
     */
    public Integer getAdminId() {
        return adminId;
    }

    /**
     * 设置日志用户id
     *
     * @param adminId 日志用户id
     */
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    /**
     * 获取日志创建时间
     *
     * @return created_tiem - 日志创建时间
     */
    public Date getCreatedTiem() {
        return createdTiem;
    }

    /**
     * 设置日志创建时间
     *
     * @param createdTiem 日志创建时间
     */
    public void setCreatedTiem(Date createdTiem) {
        this.createdTiem = createdTiem;
    }
}