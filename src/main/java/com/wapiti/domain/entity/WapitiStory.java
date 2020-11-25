package com.wapiti.domain.entity;

import com.wapiti.domain.vo.WapitiStoryVO;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "wapiti_story")
public class WapitiStory {
    /**
     * 事迹ID
     */
    @Id
    private Integer id;

    /**
     * 是否删除 0否 1是
     */
    @Column(name = "is_del")
    private Boolean isDel;

    /**
     * 事迹标题
     */
    private String title;

    /**
     * 发布的管理员
     */
    @Column(name = "admin_id")
    private Integer adminId;

    /**
     * 事迹发布时间
     */
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * 事迹修改时间
     */
    @Column(name = "updated_time")
    private Date updatedTime;

    /**
     * 事迹删除时间
     */
    @Column(name = "deleted_time")
    private Date deletedTime;


    public WapitiStoryVO toWapitiStoryVO(){
        return new WapitiStoryVO(this);
    }
    /**
     * 事迹内容
     */
    private String content;

    /**
     * 获取事迹ID
     *
     * @return id - 事迹ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置事迹ID
     *
     * @param id 事迹ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取是否删除 0否 1是
     *
     * @return is_del - 是否删除 0否 1是
     */
    public Boolean getIsDel() {
        return isDel;
    }

    /**
     * 设置是否删除 0否 1是
     *
     * @param isDel 是否删除 0否 1是
     */
    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    /**
     * 获取事迹标题
     *
     * @return title - 事迹标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置事迹标题
     *
     * @param title 事迹标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取发布的管理员
     *
     * @return admin_id - 发布的管理员
     */
    public Integer getAdminId() {
        return adminId;
    }

    /**
     * 设置发布的管理员
     *
     * @param adminId 发布的管理员
     */
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    /**
     * 获取事迹发布时间
     *
     * @return created_time - 事迹发布时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置事迹发布时间
     *
     * @param createdTime 事迹发布时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取事迹修改时间
     *
     * @return updated_time - 事迹修改时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置事迹修改时间
     *
     * @param updatedTime 事迹修改时间
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * 获取事迹删除时间
     *
     * @return deleted_time - 事迹删除时间
     */
    public Date getDeletedTime() {
        return deletedTime;
    }

    /**
     * 设置事迹删除时间
     *
     * @param deletedTime 事迹删除时间
     */
    public void setDeletedTime(Date deletedTime) {
        this.deletedTime = deletedTime;
    }

    /**
     * 获取事迹内容
     *
     * @return content - 事迹内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置事迹内容
     *
     * @param content 事迹内容
     */
    public void setContent(String content) {
        this.content = content;
    }
}