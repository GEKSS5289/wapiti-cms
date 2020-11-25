package com.wapiti.domain.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author sue
 * @date 2020/11/24 22:57
 */

@Data
public class AdminDTO {


    @NotBlank(message = "用户头像不能为空")
    private String adminFace;

    /**
     * 管理员名字
     */
    @NotBlank(message = "用户名称不能为空")
    private String adminName;

    /**
     * 管理员账号
     */
    @NotBlank(message = "用户账号不能为空")

    private String adminAccount;

}
