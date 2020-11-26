package com.wapiti.support.interceptor;

import com.wapiti.service.LogsMngService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sue
 * @date 2020/11/26 14:45
 */

@Component
public class LogsIntercepter extends HandlerInterceptorAdapter {

    @Autowired
    private LogsMngService logsMngService;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        int length = request.getRequestURI().length();
        char adminId = request.getRequestURI().charAt(length - 1);

        if(request.getMethod().equals("PUT")||request.getMethod().equals("POST")||request.getMethod().equals("DELETE")){
            adminLogsRecord(request, adminId);

        }


    }

    private void adminLogsRecord(HttpServletRequest request, char adminId) {
        if(request.getRequestURI().contains("admin")){
//                logsMngService.addLogs(request.get);
            if(request.getRequestURI().contains("add")){
                logsMngService.addLogs(Integer.parseInt(String.valueOf(adminId)),"添加了新用户");
            }
            if(request.getRequestURI().contains("thaw")){
                logsMngService.addLogs(Integer.parseInt(String.valueOf(adminId)),"解冻了"+adminId+"用户");
            }
            if(request.getRequestURI().contains("freeze")){
                logsMngService.addLogs(Integer.parseInt(String.valueOf(adminId)),"冻结了"+adminId+"用户");
            }
            if(request.getRequestURI().contains("up")){
                logsMngService.addLogs(Integer.parseInt(String.valueOf(adminId)),"将"+adminId+"升级级为了超级管理员");
            }
            if(request.getRequestURI().contains("demote")){
                logsMngService.addLogs(Integer.parseInt(String.valueOf(adminId)),"将"+adminId+"降级为了普通管理员");
            }
            if(request.getMethod().equals("DELETE")){
                logsMngService.addLogs(Integer.parseInt(String.valueOf(adminId)),"删除了"+adminId+"用户");
            }
        }
    }



}
