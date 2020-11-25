package com.wapiti.domain.entity;

import com.wapiti.domain.vo.WapitiResVO;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "wapiti_res")
public class WapitiRes {
    /**
     * 资源id
     */
    @Id
    private Integer id;

    /**
     * 资源名称
     */
    @Column(name = "res_name")
    private String resName;

    /**
     * 资源地址
     */
    @Column(name = "res_path")
    private String resPath;

    /**
     * 资源大小
     */
    @Column(name = "res_size")
    private Long resSize;

    /**
     * 发布者id
     */
    @Column(name = "publish_id")
    private Integer publishId;

    /**
     * 资源类型 0视频 1音频 2图片
     */
    @Column(name = "res_type")
    private Boolean resType;

    /**
     * 资源审核状态 0待审核 1未通过 2已通过
     */
    @Column(name = "res_status")
    private Integer resStatus;

    /**
     * 资源是否显示 0不显示 1显示
     */
    @Column(name = "res_del")
    private Boolean resDel;

    /**
     * 资源创建时间
     */
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * 资源修改时间
     */
    @Column(name = "updated_time")
    private Date updatedTime;

    /**
     * 资源删除时间
     */
    @Column(name = "deleted_time")
    private Date deletedTime;


//    public WapitiResVO toWapitiResVO(){
//        return new WapitiResVO(this);
//    }

    /**
     * 获取资源id
     *
     * @return id - 资源id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置资源id
     *
     * @param id 资源id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取资源名称
     *
     * @return res_name - 资源名称
     */
    public String getResName() {
        return resName;
    }

    /**
     * 设置资源名称
     *
     * @param resName 资源名称
     */
    public void setResName(String resName) {
        this.resName = resName;
    }

    /**
     * 获取资源地址
     *
     * @return res_path - 资源地址
     */
    public String getResPath() {
        return resPath;
    }

    /**
     * 设置资源地址
     *
     * @param resPath 资源地址
     */
    public void setResPath(String resPath) {
        this.resPath = resPath;
    }

    /**
     * 获取资源大小
     *
     * @return res_size - 资源大小
     */
    public Long getResSize() {
        return resSize;
    }

    /**
     * 设置资源大小
     *
     * @param resSize 资源大小
     */
    public void setResSize(Long resSize) {
        this.resSize = resSize;
    }

    /**
     * 获取发布者id
     *
     * @return publish_id - 发布者id
     */
    public Integer getPublishId() {
        return publishId;
    }

    /**
     * 设置发布者id
     *
     * @param publishId 发布者id
     */
    public void setPublishId(Integer publishId) {
        this.publishId = publishId;
    }

    /**
     * 获取资源类型 0视频 1音频 2图片
     *
     * @return res_type - 资源类型 0视频 1音频 2图片
     */
    public Boolean getResType() {
        return resType;
    }

    /**
     * 设置资源类型 0视频 1音频 2图片
     *
     * @param resType 资源类型 0视频 1音频 2图片
     */
    public void setResType(Boolean resType) {
        this.resType = resType;
    }

    /**
     * 获取资源审核状态 0待审核 1未通过 2已通过
     *
     * @return res_status - 资源审核状态 0待审核 1未通过 2已通过
     */
    public Integer getResStatus() {
        return resStatus;
    }

    /**
     * 设置资源审核状态 0待审核 1未通过 2已通过
     *
     * @param resStatus 资源审核状态 0待审核 1未通过 2已通过
     */
    public void setResStatus(Integer resStatus) {
        this.resStatus = resStatus;
    }

    /**
     * 获取资源是否显示 0不显示 1显示
     *
     * @return res_del - 资源是否显示 0不显示 1显示
     */
    public Boolean getResDel() {
        return resDel;
    }

    /**
     * 设置资源是否显示 0不显示 1显示
     *
     * @param resDel 资源是否显示 0不显示 1显示
     */
    public void setResDel(Boolean resDel) {
        this.resDel = resDel;
    }

    /**
     * 获取资源创建时间
     *
     * @return created_time - 资源创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置资源创建时间
     *
     * @param createdTime 资源创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取资源修改时间
     *
     * @return updated_time - 资源修改时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置资源修改时间
     *
     * @param updatedTime 资源修改时间
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * 获取资源删除时间
     *
     * @return deleted_time - 资源删除时间
     */
    public Date getDeletedTime() {
        return deletedTime;
    }

    /**
     * 设置资源删除时间
     *
     * @param deletedTime 资源删除时间
     */
    public void setDeletedTime(Date deletedTime) {
        this.deletedTime = deletedTime;
    }
}