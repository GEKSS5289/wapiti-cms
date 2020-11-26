package com.wapiti.support.interceptor;

import com.wapiti.common.constatnt.SMSCode;
import com.wapiti.common.enums.ErrorEnums;
import com.wapiti.common.utils.ExceptionPerformer;
import com.wapiti.common.utils.IPUtil;
import com.wapiti.common.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sue
 * @date 2020/11/26 13:33
 */

@Component
public class IPIntercepter  extends HandlerInterceptorAdapter {

    @Autowired
    private RedisOperator redisOperator;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //重复ip拦截
        String userIp = IPUtil.getRequestIp(request);
        boolean keyIsExist = redisOperator.keyIsExist(SMSCode.SMS_ADMIN_IP +":"+userIp);
        if(keyIsExist){
            ExceptionPerformer.Execute(ErrorEnums.SMSCODE_IP_EXIST);
            return false;
        }
        return true;

    }
}
