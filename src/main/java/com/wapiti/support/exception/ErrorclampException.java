package com.wapiti.support.exception;


import com.wapiti.common.enums.ErrorEnums;
import lombok.Data;

/**
 * @author sue
 * @date 2020/11/11 10:44
 */
@Data
public class ErrorclampException extends RuntimeException{
    private ErrorEnums errorEnums;

    public ErrorclampException(ErrorEnums errorEnums) {
        this.errorEnums = errorEnums;
    }

}
