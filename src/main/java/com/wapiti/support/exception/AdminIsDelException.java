package com.wapiti.support.exception;

import com.wapiti.common.enums.ErrorEnums;

/**
 * @author sue
 * @date 2020/11/28 18:52
 */

public class AdminIsDelException extends ErrorclampException{
    public AdminIsDelException(ErrorEnums errorEnums) {
        super(errorEnums);
    }
}
