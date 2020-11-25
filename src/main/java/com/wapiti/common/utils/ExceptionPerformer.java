package com.wapiti.common.utils;


import com.wapiti.common.enums.ErrorEnums;
import com.wapiti.support.exception.ErrorclampException;

/**
 * @author sue
 * @date 2020/11/11 10:48
 */

public class ExceptionPerformer {
    public static void Execute(ErrorEnums errorEnums){
        throw new ErrorclampException(errorEnums);
    }


}
