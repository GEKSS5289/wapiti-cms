package com.wapiti.common.utils;


import com.wapiti.support.exception.ErrorclampException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.Map;

/**
 * @author sue
 * @date 2020/11/1 20:59
 */

public class ErrorFilter {

    public static void startFilter(Map errorMap, MethodArgumentNotValidException e){
        BindingResult bindingResult1 = e.getBindingResult();
        List<FieldError> fieldErrors = bindingResult1.getFieldErrors();
        fieldErrors.forEach(i->{
            errorMap.put(i.getField(), i.getDefaultMessage());
        });
    }

    public static void startFilter(Map errorMap, ErrorclampException e){
        errorMap.put("errorMsg",e.getErrorEnums().getMsg());
        errorMap.put("errorCode",e.getErrorEnums().getCode());
    }



}

