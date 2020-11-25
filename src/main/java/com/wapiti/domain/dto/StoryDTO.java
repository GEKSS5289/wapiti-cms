package com.wapiti.domain.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author sue
 * @date 2020/11/24 23:02
 */

@Data
public class StoryDTO {
    @NotNull(message = "管理员id不能为空")
    private Integer adminId;
    @NotBlank(message = "事迹内容不能为空")
    private String content;
    @NotBlank(message = "事迹标题不能为空")
    private String title;
}
