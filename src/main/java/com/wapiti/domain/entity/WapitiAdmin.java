package com.wapiti.domain.entity;

import com.wapiti.domain.vo.WapitiAdminVO;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "wapiti_admin")
public class WapitiAdmin {
    /**
     * 管理员id
     */
    @Id
    private Integer id;

    /**
     * 管理员头像
     */
    @Column(name = "admin_face")
    private String adminFace;

    /**
     * 管理员名字
     */
    @Column(name = "admin_name")
    private String adminName;

    /**
     * 管理员账号
     */
    @Column(name = "admin_account")
    private String adminAccount;

    /**
     * 管理员是否冻结 0否 1是
     */
    @Column(name = "is_freeze")
    private Boolean isFreeze;

    /**
     * 管理员是否是超级管理员 0否 1是
     */
    @Column(name = "is_root")
    private Boolean isRoot;

    /**
     * 管理员是否删除 0否 1是
     */
    @Column(name = "is_del")
    private Boolean isDel;

    /**
     * 创建管理员时间
     */
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * 修改管理员时间
     */
    @Column(name = "updated_time")
    private Date updatedTime;

    /**
     * 删除管理员时间
     */
    @Column(name = "deleted_time")
    private Date deletedTime;


    public WapitiAdminVO toWapitiAdminVO(){
        return new WapitiAdminVO(this);
    }

    /**
     * 获取管理员id
     *
     * @return id - 管理员id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置管理员id
     *
     * @param id 管理员id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取管理员头像
     *
     * @return admin_face - 管理员头像
     */
    public String getAdminFace() {
        return adminFace;
    }

    /**
     * 设置管理员头像
     *
     * @param adminFace 管理员头像
     */
    public void setAdminFace(String adminFace) {
        this.adminFace = adminFace;
    }

    /**
     * 获取管理员名字
     *
     * @return admin_name - 管理员名字
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     * 设置管理员名字
     *
     * @param adminName 管理员名字
     */
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    /**
     * 获取管理员账号
     *
     * @return admin_account - 管理员账号
     */
    public String getAdminAccount() {
        return adminAccount;
    }

    /**
     * 设置管理员账号
     *
     * @param adminAccount 管理员账号
     */
    public void setAdminAccount(String adminAccount) {
        this.adminAccount = adminAccount;
    }

    /**
     * 获取管理员是否冻结 0否 1是
     *
     * @return is_freeze - 管理员是否冻结 0否 1是
     */
    public Boolean getIsFreeze() {
        return isFreeze;
    }

    /**
     * 设置管理员是否冻结 0否 1是
     *
     * @param isFreeze 管理员是否冻结 0否 1是
     */
    public void setIsFreeze(Boolean isFreeze) {
        this.isFreeze = isFreeze;
    }

    /**
     * 获取管理员是否是超级管理员 0否 1是
     *
     * @return is_root - 管理员是否是超级管理员 0否 1是
     */
    public Boolean getIsRoot() {
        return isRoot;
    }

    /**
     * 设置管理员是否是超级管理员 0否 1是
     *
     * @param isRoot 管理员是否是超级管理员 0否 1是
     */
    public void setIsRoot(Boolean isRoot) {
        this.isRoot = isRoot;
    }

    /**
     * 获取管理员是否删除 0否 1是
     *
     * @return is_del - 管理员是否删除 0否 1是
     */
    public Boolean getIsDel() {
        return isDel;
    }

    /**
     * 设置管理员是否删除 0否 1是
     *
     * @param isDel 管理员是否删除 0否 1是
     */
    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    /**
     * 获取创建管理员时间
     *
     * @return created_time - 创建管理员时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置创建管理员时间
     *
     * @param createdTime 创建管理员时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取修改管理员时间
     *
     * @return updated_time - 修改管理员时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置修改管理员时间
     *
     * @param updatedTime 修改管理员时间
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * 获取删除管理员时间
     *
     * @return deleted_time - 删除管理员时间
     */
    public Date getDeletedTime() {
        return deletedTime;
    }

    /**
     * 设置删除管理员时间
     *
     * @param deletedTime 删除管理员时间
     */
    public void setDeletedTime(Date deletedTime) {
        this.deletedTime = deletedTime;
    }
}