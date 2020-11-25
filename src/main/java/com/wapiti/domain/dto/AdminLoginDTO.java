package com.wapiti.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author sue
 * @date 2020/11/26 1:05
 */
@Data
public class AdminLoginDTO {
    @NotBlank(message = "用户账号不能为空")
    private String adminAccount;
    @NotBlank(message = "验证码不能为空")
    private String smsCode;
}
