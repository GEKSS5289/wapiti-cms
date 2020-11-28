package com.wapiti.common.enums;

import lombok.Getter;

/**
 * @author sue
 * @date 2020/11/11 10:45
 */

@Getter
public enum ErrorEnums {

    CATEGORY_EXIST(1001,"该分类已经存在"),
    CATEGORY_NOT_CHANGE(1002,"你并没有改变分类"),
    NOT_FOUND_CATEGORY(1003,"不存在的分类"),



    NOT_FOUND_RESOURCE(2001,"不存在的资源"),
    TOKEN_FAILURE(2002,"token失效"),
    TOKEN_ERROR(2003,"token出错"),
    NOT_TOKEN(2004,"token不存在"),


    FILE_NULL(3001,"文件为空"),
    FILE_UPLOAD_FAIL(3002,"文件上传失败"),

    ADMIN_EXIST(4001,"用户已存在"),
    ADMIN_NOT_EXIST(4002,"用户不存在"),
    ADMIN_EXCEPTION(4003,"账号异常，请联系管理员"),
    ADMIN_FORBIDDEN(4004,"用户权限不足"),
    ADMIN_FREEZE(4005,"用户被冻结"),
    ADMIN_INFO_ERROR(4006,"用户信息出错"),




    SMSCODE_ERROR(5001,"验证码错误"),
    SMSCODE_IP_EXIST(5002,"不要重复获取验证码");

    private Integer code;
    private String msg;

    ErrorEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
