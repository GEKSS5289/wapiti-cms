package com.wapiti.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author sue
 * @date 2020/11/25 10:34
 */

@Data
public class StoryUpdateDTO {
    @NotBlank(message = "事迹内容不能为空")
    private String content;
    @NotBlank(message = "事迹标题不能为空")
    private String title;
}
