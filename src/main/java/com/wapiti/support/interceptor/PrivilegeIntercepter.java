package com.wapiti.support.interceptor;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.wapiti.common.constatnt.TokenParameter;
import com.wapiti.common.enums.ErrorEnums;
import com.wapiti.common.utils.ExceptionPerformer;
import com.wapiti.common.utils.JWTUtils;
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
public class PrivilegeIntercepter extends HandlerInterceptorAdapter {


    @Autowired
    private WapitiAdminMapper wapitiAdminMapper;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        DecodedJWT jwt = JWTUtils.jwtVerifier(request);

        Integer adminId = jwt.getClaim("adminId").asInt();
        Example example = new Example(WapitiAdmin.class);

        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",adminId);
        WapitiAdmin wapitiAdmin = wapitiAdminMapper.selectOneByExample(example);


        if(wapitiAdmin == null){
            ExceptionPerformer.Execute(ErrorEnums.ADMIN_NOT_EXIST);
        }
        System.out.println(wapitiAdmin.getIsRoot()+":"+jwt.getClaim("isRoot").asBoolean());

        if(wapitiAdmin.getIsRoot()!=jwt.getClaim("isRoot").asBoolean()){
            ExceptionPerformer.Execute(ErrorEnums.ADMIN_INFO_ERROR);
            return false;
        }else if(!wapitiAdmin.getIsRoot()){
            ExceptionPerformer.Execute(ErrorEnums.ADMIN_FORBIDDEN);
            return false;
        }

        return true;

    }
}
