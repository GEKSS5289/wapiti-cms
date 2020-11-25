package com.wapiti.domain.entity;

import com.wapiti.domain.vo.WapitiAdminVO;
import com.wapiti.domain.vo.WapitiTaskVO;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "wapiti_task")
public class WapitiTask {
    /**
     * 任务id
     */
    @Id
    private Integer id;

    /**
     * 执行者id
     */
    @Column(name = "executor_id")
    private Integer executorId;

    /**
     * 发布者id
     */
    @Column(name = "publisher_id")
    private Integer publisherId;

    /**
     * 任务标题
     */
    @Column(name = "task_title")
    private String taskTitle;

    /**
     * 任务等级 0低等级 1中等级 2高等级
     */
    @Column(name = "task_level")
    private Integer taskLevel;

    /**
     * 任务状态 0未完成 1已完成
     */
    @Column(name = "task_status")
    private Integer taskStatus;

    /**
     * 任务创建时间
     */
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * 任务完成时间
     */
    @Column(name = "finish_time")
    private Date finishTime;

    /**
     * 任务内容
     */
    @Column(name = "task_content")
    private String taskContent;


//    public WapitiTaskVO toWapitiTaskVO(){
//        return new WapitiTaskVO(this);
//    }

    /**
     * 获取任务id
     *
     * @return id - 任务id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置任务id
     *
     * @param id 任务id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取执行者id
     *
     * @return executor_id - 执行者id
     */
    public Integer getExecutorId() {
        return executorId;
    }

    /**
     * 设置执行者id
     *
     * @param executorId 执行者id
     */
    public void setExecutorId(Integer executorId) {
        this.executorId = executorId;
    }

    /**
     * 获取发布者id
     *
     * @return publisher_id - 发布者id
     */
    public Integer getPublisherId() {
        return publisherId;
    }

    /**
     * 设置发布者id
     *
     * @param publisherId 发布者id
     */
    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    /**
     * 获取任务标题
     *
     * @return task_title - 任务标题
     */
    public String getTaskTitle() {
        return taskTitle;
    }

    /**
     * 设置任务标题
     *
     * @param taskTitle 任务标题
     */
    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    /**
     * 获取任务等级 0低等级 1中等级 2高等级
     *
     * @return task_level - 任务等级 0低等级 1中等级 2高等级
     */
    public Integer getTaskLevel() {
        return taskLevel;
    }

    /**
     * 设置任务等级 0低等级 1中等级 2高等级
     *
     * @param taskLevel 任务等级 0低等级 1中等级 2高等级
     */
    public void setTaskLevel(Integer taskLevel) {
        this.taskLevel = taskLevel;
    }

    /**
     * 获取任务状态 0未完成 1已完成
     *
     * @return task_status - 任务状态 0未完成 1已完成
     */
    public Integer getTaskStatus() {
        return taskStatus;
    }

    /**
     * 设置任务状态 0未完成 1已完成
     *
     * @param taskStatus 任务状态 0未完成 1已完成
     */
    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    /**
     * 获取任务创建时间
     *
     * @return created_time - 任务创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置任务创建时间
     *
     * @param createdTime 任务创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取任务完成时间
     *
     * @return finish_time - 任务完成时间
     */
    public Date getFinishTime() {
        return finishTime;
    }

    /**
     * 设置任务完成时间
     *
     * @param finishTime 任务完成时间
     */
    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    /**
     * 获取任务内容
     *
     * @return task_content - 任务内容
     */
    public String getTaskContent() {
        return taskContent;
    }

    /**
     * 设置任务内容
     *
     * @param taskContent 任务内容
     */
    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }
}