package com.wapiti.domain.dto;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author sue
 * @date 2020/11/24 23:03
 */
@Data
public class TaskDTO {

    @NotNull(message = "执行者id不能为空")
    private Integer executorId;

    @NotNull(message = "发布者id不能为空")
    private Integer publisherId;

    @NotBlank(message = "任务标题不能为空")
    private String taskTitle;

    @NotBlank(message = "任务内容不能为空")
    private String taskContent;

    @NotNull(message = "任务优先级不能为空")
    private Integer taskLevel;
}
