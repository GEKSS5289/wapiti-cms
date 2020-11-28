package com.wapiti.common.enums;

import lombok.Getter;

/**
 * @author sue
 * @date 2020/10/8 19:55
 */
@Getter
public enum ResponseEnums {


    //当操作成功时则返回
    SUCCESS(200,true,"成功"),
    //当操作操作失败时则返回
    FAILED(500,false,"失败");



    private Integer status;
    private Boolean success;
    private String  message;

    ResponseEnums(Integer status, Boolean success, String message) {
        this.status = status;
        this.success = success;
        this.message = message;
    }
}
