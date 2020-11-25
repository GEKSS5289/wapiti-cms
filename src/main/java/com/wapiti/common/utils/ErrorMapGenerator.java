package com.wapiti.common.utils;


import com.wapiti.support.exception.ErrorclampException;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sue
 * @date 2020/11/12 13:11
 */

public class ErrorMapGenerator {

    public static Map errorPush(String errorMsg){
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("errorMsg",errorMsg);
        return errorMap;
    }

    public static Map errorPush(ErrorclampException e){
        Map<String,String> errorMap = new HashMap<>();
        ErrorFilter.startFilter(errorMap,e);
        return errorMap;
    }

    public static Map errorPush(MethodArgumentNotValidException e){
        Map<String,String> errorMap = new HashMap<>();
        ErrorFilter.startFilter(errorMap,e);
        return errorMap;
    }

}
