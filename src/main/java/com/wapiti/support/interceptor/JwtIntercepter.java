package com.wapiti.support.interceptor;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.wapiti.common.constatnt.SMSCode;
import com.wapiti.common.constatnt.TokenParameter;
import com.wapiti.common.enums.ErrorEnums;
import com.wapiti.common.utils.ExceptionPerformer;
import com.wapiti.common.utils.IPUtil;
import com.wapiti.common.utils.JWTUtils;
import com.wapiti.common.utils.RedisOperator;
import com.wapiti.domain.entity.WapitiAdmin;
import com.wapiti.mapper.WapitiAdminMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sue
 * @date 2020/11/12 21:15
 */

@Component
public class JwtIntercepter extends HandlerInterceptorAdapter {



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

       

        JWTUtils.jwtVerifier(request);

        return true;

    }
}
