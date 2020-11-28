package com.wapiti.common.utils;


import com.wapiti.common.enums.ErrorEnums;
import com.wapiti.support.exception.AdminFreezeException;
import com.wapiti.support.exception.AdminPrivilegeException;
import com.wapiti.support.exception.ErrorclampException;

/**
 * @author sue
 * @date 2020/11/11 10:48
 */

public class ExceptionPerformer {
    public static void Execute(ErrorEnums errorEnums){
        throw new ErrorclampException(errorEnums);
    }

    public static void ExecuteAdminFreeze(ErrorEnums errorEnums){
        throw new AdminFreezeException(errorEnums);
    }

    public static void ExecuteAdminIsDel(ErrorEnums errorEnums){
        throw new AdminFreezeException(errorEnums);
    }
    public static void ExecuteAdminPrivilegeException(ErrorEnums errorEnums){
        throw new AdminPrivilegeException(errorEnums);
    }
}
